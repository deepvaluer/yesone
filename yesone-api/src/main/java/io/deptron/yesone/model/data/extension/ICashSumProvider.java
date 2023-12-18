package io.deptron.yesone.model.data.extension;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface ICashSumProvider {

    @DataProperty(start = 2023)
    default BigInteger getHletSum() {
        DataModel dataModel = (DataModel) this;
        ICashSum sum = (ICashSum) dataModel.getManModel().getSumData();
        return sum.getHletSum();
    }

    @DataProperty(start = 2023)
    default BigInteger getTfhyHletSum() {
        DataModel dataModel = (DataModel) this;
        ICashSum sum = (ICashSum) dataModel.getManModel().getSumData();
        return sum.getTfhyHletSum();
    }

    @DataProperty(start = 2023)
    default BigInteger getShfyHletSum() {
        DataModel dataModel = (DataModel) this;
        ICashSum sum = (ICashSum) dataModel.getManModel().getSumData();
        return sum.getShfyHletSum();
    }
}
