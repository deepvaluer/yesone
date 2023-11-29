package io.deptron.yesone.model.data.extension;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface ISum {
    @DataProperty
    default BigInteger getSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("sum");
    }

}
