package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IUsePlaceCd {
    @DataProperty
    default String getUsePlaceCd() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("usePlaceCd");
    }
}
