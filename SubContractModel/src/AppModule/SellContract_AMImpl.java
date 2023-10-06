package AppModule;

import AppModule.common.SellContract_AM;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 22 11:46:08 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SellContract_AMImpl extends ApplicationModuleImpl implements SellContract_AM {
    /**
     * This is the default constructor (do not remove).
     */
    public SellContract_AMImpl() {
    }

    /**
     * Container's getter for XxstgSellContractHeaders_VO1.
     * @return XxstgSellContractHeaders_VO1
     */
    public ViewObjectImpl getXxstgSellContractHeaders_VO1() {
        return (ViewObjectImpl)findViewObject("XxstgSellContractHeaders_VO1");
    }

    /**
     * Container's getter for XxstgSellContractLines_VO1.
     * @return XxstgSellContractLines_VO1
     */
    public ViewObjectImpl getXxstgSellContractLines_VO1() {
        return (ViewObjectImpl)findViewObject("XxstgSellContractLines_VO1");
    }
    
    public void filterContractLineByConNum(String conNum) {
       
            ViewObjectImpl lineVO=this.getXxstgSellContractLines_VO1();
            lineVO.setNamedWhereClauseParam("p_con_num",conNum);
            lineVO.executeQuery();
        
    }

    /**
     * Container's getter for SellContractLine_ROVO1.
     * @return SellContractLine_ROVO1
     */
    public ViewObjectImpl getSellContractLine_ROVO1() {
        return (ViewObjectImpl)findViewObject("SellContractLine_ROVO1");
    }

    /**
     * Container's getter for ContractLineType_ROVO1.
     * @return ContractLineType_ROVO1
     */
    public ViewObjectImpl getContractLineType_ROVO1() {
        return (ViewObjectImpl)findViewObject("ContractLineType_ROVO1");
    }

    /**
     * Container's getter for FunctionROVO1.
     * @return FunctionROVO1
     */
    public ViewObjectImpl getFunctionROVO1() {
        return (ViewObjectImpl)findViewObject("FunctionROVO1");
    }
    
    public void clearHeaderLines() {
      ViewObjectImpl headerVO=this.getXxstgSellContractHeaders_VO1();
        headerVO.setNamedWhereClauseParam("p_con_num", -1);
        headerVO.executeQuery();
        ViewObjectImpl lineVO=this.getXxstgSellContractLines_VOs1();
          lineVO.setNamedWhereClauseParam("p_con_num", -1);
          lineVO.executeQuery();
    }

    /**
     * Container's getter for LineNumberROVO1.
     * @return LineNumberROVO1
     */
    public ViewObjectImpl getLineNumberROVO1() {
        return (ViewObjectImpl)findViewObject("LineNumberROVO1");
    }

    /**
     * Container's getter for ProjectNumberROVO1.
     * @return ProjectNumberROVO1
     */
    public ViewObjectImpl getProjectNumberROVO1() {
        return (ViewObjectImpl)findViewObject("ProjectNumberROVO1");
    }

    /**
     * Container's getter for DeleteSellContractLines_VO1.
     * @return DeleteSellContractLines_VO1
     */
    public ViewObjectImpl getDeleteSellContractLines_VO1() {
        return (ViewObjectImpl)findViewObject("DeleteSellContractLines_VO1");
    }

    /**
     * Container's getter for XxstgSellContractLines_VOs1.
     * @return XxstgSellContractLines_VOs1
     */
    public ViewObjectImpl getXxstgSellContractLines_VOs1() {
        return (ViewObjectImpl)findViewObject("XxstgSellContractLines_VOs1");
    }
}