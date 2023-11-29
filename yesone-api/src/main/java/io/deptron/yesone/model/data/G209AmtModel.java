package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IMm;

@DataProperty(end = 2021)
public class G209AmtModel extends DataModel implements IMm {
    @DataProperty
    public BigInteger getAmt() {
        return this.bigIntegerValueOf("amt");
    }
}
