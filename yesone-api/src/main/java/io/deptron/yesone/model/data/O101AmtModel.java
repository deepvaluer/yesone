package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IMm;

public class O101AmtModel extends DataModel implements IMm {

    @DataProperty
    public BigInteger getHiNtf() {
        return this.bigIntegerValueOf("hiNtf");
    }

    @DataProperty
    public BigInteger getLtrmNtf() {
        return this.bigIntegerValueOf("ltrmNtf");
    }

    @DataProperty
    public BigInteger getHiPmt() {
        return this.bigIntegerValueOf("hiPmt");
    }

    @DataProperty
    public BigInteger getLtrmPmt() {
        return this.bigIntegerValueOf("ltrmPmt");
    }

    @DataProperty
    public BigInteger getSum() {
        O101Model data = (O101Model) this.getManModel().getDatas()[0];
        return data.getSum();
    }

}
