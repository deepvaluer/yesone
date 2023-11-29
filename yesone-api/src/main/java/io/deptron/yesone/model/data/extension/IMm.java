package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IMm {
    @DataProperty
    default String getMm() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("mm");
    }

}
