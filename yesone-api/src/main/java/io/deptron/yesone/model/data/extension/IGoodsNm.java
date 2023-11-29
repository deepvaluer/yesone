package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IGoodsNm {
    @DataProperty
    default String getGoodsNm() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("goodsNm");
    }
}
