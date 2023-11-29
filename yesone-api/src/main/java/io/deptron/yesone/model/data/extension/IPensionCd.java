package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IPensionCd {
    @DataProperty
    default String getPensionCd() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("pensionCd");
    }

}
