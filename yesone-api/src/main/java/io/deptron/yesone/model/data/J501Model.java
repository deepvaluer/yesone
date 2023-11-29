package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IStartEndDt;
import io.deptron.yesone.model.data.extension.ISum;

public class J501Model extends DataModel implements IStartEndDt, ISum, IAmt {
    @DataProperty
    public String getLsorNo() {
        return this.stringValueOf("lsorNo");
    }

    @DataProperty
    public String getLsorNm() {
        return this.stringValueOf("lsorNm");
    }

    @DataProperty
    public String getAdr() {
        return this.stringValueOf("adr");
    }

    @DataProperty
    public String getArea() {
        return this.stringValueOf("area");
    }

    @DataProperty
    public String getTypeCd() {
        return this.stringValueOf("typeCd");
    }

}
