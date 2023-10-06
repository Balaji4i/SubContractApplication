package AppModule.client;

import AppModule.common.SellContract_AM;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 22 13:56:43 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SellContract_AMClient extends ApplicationModuleImpl implements SellContract_AM {
    /**
     * This is the default constructor (do not remove).
     */
    public SellContract_AMClient() {
    }

    public void filterContractLineByConNum(String conNum) {
        Object _ret =
            this.riInvokeExportedMethod(this,"filterContractLineByConNum",new String [] {"java.lang.String"},new Object[] {conNum});
        return;
    }

    public void clearHeaderLines() {
        Object _ret =
            this.riInvokeExportedMethod(this,"clearHeaderLines",null,null);
        return;
    }
}
