package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.IComCd;
import io.deptron.yesone.model.data.extension.IFundNm;
import io.deptron.yesone.model.data.extension.IRegDt;
import io.deptron.yesone.model.data.extension.ISecuNo;
import io.deptron.yesone.model.data.extension.ISum;

public class Q101Model extends DataModel implements IBusnid, ISecuNo, IFundNm, IRegDt, IComCd, ISum {
    @DataProperty
    public String getVntAsctClCd() {
        return this.stringValueOf("vntAsctClCd");
    }

}
