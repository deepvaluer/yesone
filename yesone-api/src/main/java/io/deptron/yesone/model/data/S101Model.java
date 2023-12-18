package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.NodeModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.ISum;

@DataProperty(start = 2023)
public class S101Model extends DataModel implements ISum, IAmt {

    @Override
    public void addAmt(NodeModel node) {
        this.addAmt(S101AmtModel.class, node);
    }

}
