package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.NodeModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.ICreditSumProvider;
import io.deptron.yesone.model.data.extension.ISum;
import io.deptron.yesone.model.data.extension.IUsePlaceCd;

@DataProperty(end = 2021)
public class G209Model extends DataModel implements IUsePlaceCd, ISum, IAmt, ICreditSumProvider {

    @Override
    public void addAmt(NodeModel node) {
        this.addAmt(G209AmtModel.class, node);
    }

}
