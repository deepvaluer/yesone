package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAccNo;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.IGoodsNm;
import io.deptron.yesone.model.data.extension.ISum;

public class B201Model extends DataModel implements IBusnid, IAccNo, IGoodsNm, ISum, IAmt {
    @DataProperty
    public String getInsuResid() {
        return this.stringValueOf("insuResid");
    }

    @DataProperty
    public String getInsuNm() {
        return this.stringValueOf("insuNm");
    }

}
