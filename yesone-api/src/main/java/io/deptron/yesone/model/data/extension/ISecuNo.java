package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface ISecuNo {
    @DataProperty
    default String getSecuNo() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("secuNo");
    }

}
