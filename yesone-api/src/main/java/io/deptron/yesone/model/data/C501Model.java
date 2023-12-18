package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.ISum;

@DataProperty(start = 2023)
public class C501Model extends DataModel implements IBusnid, ISum, IAmt {

    @DataProperty
    public String getEduTp() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("eduTp");
    }

    @DataProperty
    public String getEduEnd() {
        DataModel dataModel = (DataModel) this;
        return dataModel.stringValueOf("eduEnd");
    }

}
