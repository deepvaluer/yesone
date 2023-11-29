package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IMm;

public class P102AmtModel extends DataModel implements IMm {

    @DataProperty
    public BigInteger getWrkpNtf() {
        return this.bigIntegerValueOf("wrkpNtf");
    }

    @DataProperty
    public BigInteger getRgnPmt() {
        return this.bigIntegerValueOf("rgnPmt");
    }

    @DataProperty
    public BigInteger getSum() {
        P102Model data = (P102Model) this.getManModel().getDatas()[0];
        return data.getSum();
    }

}
