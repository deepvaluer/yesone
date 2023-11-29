package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAccNo;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.IComCd;
import io.deptron.yesone.model.data.extension.IGoodsNm;
import io.deptron.yesone.model.data.extension.IRegDt;
import io.deptron.yesone.model.data.extension.ISum;

public class J301Model extends DataModel implements IBusnid, IAccNo, IGoodsNm, IRegDt, IComCd, ISum, IAmt {
    @DataProperty
    public String getSavingGubn() {
        return this.stringValueOf("savingGubn");
    }

}
