package io.deptron.yesone.model.data.extension;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IEdu {
    @DataProperty
    default String getEduTp() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("eduTp");
    }

    @DataProperty
    default String getEduCl() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("eduCl");
    }

}
