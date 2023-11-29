package io.deptron.yesone.model.data.extension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IAmt {
    @DataProperty
    default List<Map<String, Object>> getAmt() {
        DataModel dataModel = (DataModel) this;
        List<Map<String, Object>> res = new ArrayList<>();

        List<DataModel> amts = dataModel.getAmts();
        if (null == amts)
            return res;
        for (DataModel amt : amts) {
            Map<String, Object> repMap = amt.getParameterMap();
            if (null != repMap) {
                res.add(repMap);
            }
        }
        return res;
    }

}
