package io.deptron.yesone.model.data.extension;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface ICashSum {
    @DataProperty(start = 2023)
    default BigInteger getHletSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("hletSum");
    }

    @DataProperty(start = 2023)
    default BigInteger getTfhyHletSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tfhyHletSum");
    }

    @DataProperty(start = 2023)
    default BigInteger getShfyHletSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("shfyHletSum");
    }

}
