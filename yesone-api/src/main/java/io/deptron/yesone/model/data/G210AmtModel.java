package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IMm;

@DataProperty(start = 2022)
public class G210AmtModel extends DataModel implements IMm {
    @DataProperty
    public BigInteger getAmt() {
        return this.bigIntegerValueOf("amt");
    }
}
