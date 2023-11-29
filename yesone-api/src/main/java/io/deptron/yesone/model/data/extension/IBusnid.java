package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IBusnid {
    @DataProperty
    default String getBusnid() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("busnid");
    }

    @DataProperty
    default String getTradeNm() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("tradeNm");
    }
}
