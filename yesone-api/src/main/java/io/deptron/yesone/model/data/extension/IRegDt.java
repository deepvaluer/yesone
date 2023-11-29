package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IRegDt {
    @DataProperty
    default String getRegDt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("regDt");
    }
}
