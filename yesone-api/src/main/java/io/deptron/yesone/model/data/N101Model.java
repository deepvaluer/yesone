package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.IComCd;
import io.deptron.yesone.model.data.extension.IFundNm;
import io.deptron.yesone.model.data.extension.IRegDt;
import io.deptron.yesone.model.data.extension.ISecuNo;
import io.deptron.yesone.model.data.extension.ISum;

public class N101Model extends DataModel implements IBusnid, ISecuNo, IFundNm, IRegDt, IComCd, ISum, IAmt {
    @DataProperty
    public BigInteger getDdctBsAssAmt() {
        return this.bigIntegerValueOf("ddctBsAssAmt");
    }

    @DataProperty(start = 2022)
    public BigInteger getCtrTermMmCnt() {
        return this.bigIntegerValueOf("ctrTermMmCnt");
    }

}
