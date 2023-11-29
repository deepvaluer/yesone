package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.ISum;

public class L102Model extends DataModel implements IBusnid, ISum, IAmt {
    @DataProperty
    public String getDonationCd() {
        return this.stringValueOf("donationCd");
    }

    @DataProperty
    public BigInteger getSbdyAplnSum() {
        return this.bigIntegerValueOf("sbdyAplnSum");
    }

    @DataProperty
    public BigInteger getConbSum() {
        return this.bigIntegerValueOf("conbSum");
    }

}
