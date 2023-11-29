package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.ISum;

public class C202Model extends DataModel implements IBusnid, ISum, IAmt {
    @DataProperty
    public String getCourseCd() {
        return this.stringValueOf("courseCd");
    }

    @DataProperty
    public String getSubjectNm() {
        return this.stringValueOf("subjectNm");
    }

}
