package Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.context.FacesContext;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletContext;

import javax.sql.DataSource;

import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;


//import oracle.apps.xdo.template.FOProcessor;
//import oracle.apps.xdo.template.RTFProcessor;


public class RTFUtils {
    public RTFUtils() {
        super();
    }
    
    
    public static  ServletContext getContext() {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
    }
    
    public static FacesContext getFacesContext() {
            return FacesContext.getCurrentInstance();
        }
    
    
//    public HttpServletResponse getResponse() {
//           return (HttpServletResponse)getFacesContext().getExternalContext().getResponse();
//       }
    
    public static byte[] runReport(String templateFile, oracle.jbo.domain.Number ID, String packageName) {
        //  String  templateFile = ;
        byte[] dataBytes = null;

        try {
            ServletContext context = getContext();
            InputStream fs = context.getResourceAsStream(templateFile);
            //Process RTF template to convert to XSL-FO format
            //System.err.println("====1====");
            RTFProcessor rtfp = new RTFProcessor(fs);
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfp.setOutput(xslOutStream);
            rtfp.process();
            //System.err.println("====2====");
            //Use XSL Template and Data from the VO to generate report and return the OutputStream of report
            ByteArrayInputStream xslInStream =
                new ByteArrayInputStream(xslOutStream.toByteArray());
            //            ViewObject vo =
            //                ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
            //
            //            Number cert =
            //                (Number)vo.getCurrentRow().getAttribute("CertHeaderId");
            FOProcessor processor = new FOProcessor();
            ByteArrayInputStream dataStream =
                //new ByteArrayInputStream((byte[])ADFUtils.findOperation("getXMLData").execute());
                new ByteArrayInputStream((getXMLData(ID, packageName).getBytes()));
           
            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);
            byte outFileTypeByte = FOProcessor.FORMAT_PDF;
            processor.setOutputFormat(outFileTypeByte);
            processor.generate();

            dataBytes = pdfOutStream.toByteArray();

        } catch (IOException e) {
            //System.out.println("IOException when generating pdf===IO" +e.toString());
        } catch (Exception e) {
            // e.printStackTrace();
            //System.out.println("IOException when generating pdf===EXE" +
//                               e.toString());

        }
        return dataBytes;
    }
    
    
    public static String getXMLData(oracle.jbo.domain.Number ID, String packageName) throws Exception {
        String retStr = "";
        Context ctx;
        Connection con = null;
        ctx = new InitialContext();
//        String dataSource = "subcont1";
//        String dataSource = "contractUAT";
        String dataSource = "subcont";

        DataSource ds = (DataSource)ctx.lookup(dataSource);
        con = ds.getConnection();
//        String selectSQL ="SELECT XXSC_REPORT_PKG.Payment_certificate('" + ID +"') xml FROM dual";
          String selectSQL ="SELECT XXSC_REPORT_PKG."+packageName+"('" + ID +"') xml FROM dual";
//        String selectSQL =packageQuery;
        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        //System.err.println("=====OUT XML==" + selectSQL);
        ResultSet rs1 = preparedStatement.executeQuery(selectSQL);
        while (rs1.next()) {
            retStr = rs1.getString("xml");
        }
        //System.err.println("=====OUT XML==" + retStr);
        return retStr;
    }
    
}
