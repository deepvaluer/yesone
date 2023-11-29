package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IAccNo {
    @DataProperty
    default String getAccNo() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("accNo");
    }

}
