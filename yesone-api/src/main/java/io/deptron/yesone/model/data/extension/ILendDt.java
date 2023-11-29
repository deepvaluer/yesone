package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface ILendDt {
    @DataProperty
    default String getLendDt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("lendDt");
    }
}
