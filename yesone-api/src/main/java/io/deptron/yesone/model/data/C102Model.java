package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.ISum;

public class C102Model extends DataModel implements IBusnid, ISum, IAmt {

    @DataProperty
    public String getEduTp() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("eduTp");
    }

    @DataProperty
    public String getEduCl() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("eduCl");
    }
}
