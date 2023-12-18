package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IMm;

@DataProperty(start = 2023)
public class S101AmtModel extends DataModel implements IMm {

    @DataProperty
    public BigInteger getAmt() {
        return this.bigIntegerValueOf("amt");
    }

    @DataProperty
    public BigInteger getSum() {
        P102Model data = (P102Model) this.getManModel().getDatas()[0];
        return data.getSum();
    }

}
