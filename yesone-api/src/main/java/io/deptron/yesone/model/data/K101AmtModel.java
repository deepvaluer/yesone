package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IMm;

public class K101AmtModel extends DataModel implements IMm {
    @DataProperty
    public BigInteger getAmt() {
        return this.bigIntegerValueOf("amt");
    }

    @DataProperty
    public String getDate() {
        return this.stringValueOf("date");
    }
}
