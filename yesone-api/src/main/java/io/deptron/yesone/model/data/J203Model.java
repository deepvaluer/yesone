package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAccNo;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.IStartEndDt;
import io.deptron.yesone.model.data.extension.ISum;
import io.deptron.yesone.model.data.extension.ISumDdct;

public class J203Model extends DataModel implements IBusnid, IAccNo, IStartEndDt, ISum, ISumDdct, IAmt {
    @DataProperty
    public String getLendKd() {
        return this.stringValueOf("lendKd");
    }

    @DataProperty
    public String getHouseTakeDt() {
        return this.stringValueOf("houseTakeDt");
    }

    @DataProperty
    public String getMortSetupDt() {
        return this.stringValueOf("mortSetupDt");
    }

    @DataProperty
    public int getRepayYears() {
        return this.intValueOf("repayYears");
    }

    @DataProperty
    public String getLendGoodsNm() {
        return this.stringValueOf("lendGoodsNm");
    }

    @DataProperty
    public BigInteger getDebt() {
        return this.bigIntegerValueOf("debt");
    }

    @DataProperty
    public BigInteger getFixedRateDebt() {
        return this.bigIntegerValueOf("fixedRateDebt");
    }

    @DataProperty
    public BigInteger getNotDeferDebt() {
        return this.bigIntegerValueOf("notDeferDebt");
    }

    @DataProperty
    public BigInteger getThisYearRedeAmt() {
        return this.bigIntegerValueOf("thisYearRedeAmt");
    }

}
