package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAccNo;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.IGoodsNm;
import io.deptron.yesone.model.data.extension.ISum;

public class A102Model extends DataModel implements IBusnid, IAccNo, IGoodsNm, ISum, IAmt {

    @DataProperty
    public String getInsu1Resid() {
        return this.stringValueOf("insu1Resid");
    }

    @DataProperty
    public String getInsu1Nm() {
        return this.stringValueOf("insu1Nm");
    }

    @DataProperty
    public String getInsu2Resid1() {
        return this.stringValueOf("insu2Resid1");
    }

    @DataProperty
    public String getInsu2Nm1() {
        return this.stringValueOf("insu2Nm1");
    }

    @DataProperty
    public String getInsu2Resid2() {
        return this.stringValueOf("insu2Resid2");
    }

    @DataProperty
    public String getInsu2Nm2() {
        return this.stringValueOf("insu2Nm2");
    }

    @DataProperty
    public String getInsu2Resid3() {
        return this.stringValueOf("insu2Resid3");
    }

    @DataProperty
    public String getInsu2Nm3() {
        return this.stringValueOf("insu2Nm3");
    }

}
