package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.NodeModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAccNo;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IStartEndDt;
import io.deptron.yesone.model.data.extension.ISum;
import io.deptron.yesone.model.data.extension.ISumDdct;

public class K101Model extends DataModel implements IAccNo, IStartEndDt, ISum, ISumDdct, IAmt {
    @DataProperty
    public String getRuleYn() {
        return this.stringValueOf("ruleYn");
    }

    @DataProperty
    public String getPayMethod() {
        return this.stringValueOf("payMethod");
    }

    @Override
    public void addAmt(NodeModel node) {
        this.addAmt(K101AmtModel.class, node);
    }

}
