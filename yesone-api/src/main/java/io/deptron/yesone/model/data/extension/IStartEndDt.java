package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IStartEndDt {
    @DataProperty
    default String getStartDt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("startDt");
    }

    @DataProperty
    default String getEndDt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("endDt");
    }
}
