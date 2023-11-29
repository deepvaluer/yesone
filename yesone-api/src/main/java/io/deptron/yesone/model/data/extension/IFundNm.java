package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IFundNm {
    @DataProperty
    default String getFundNm() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("fundNm");
    }
}
