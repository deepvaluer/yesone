package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.NodeModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.ICreditSumProvider;
import io.deptron.yesone.model.data.extension.ISum;
import io.deptron.yesone.model.data.extension.IUsePlaceCd;

@DataProperty(start = 2022)
public class G210Model extends DataModel implements IUsePlaceCd, ISum, IAmt, ICreditSumProvider {

    @Override
    public void addAmt(NodeModel node) {
        this.addAmt(G210AmtModel.class, node);
    }

}
