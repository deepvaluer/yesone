package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IBusnid;

@DataProperty(start = 2022)
public class R101Model extends DataModel implements IBusnid {

    @DataProperty
    public String getPwdCd() {
        return this.stringValueOf("pwdCd");
    }
}
