package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IComCd {
    @DataProperty
    default String getComCd() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("comCd");
    }

}
