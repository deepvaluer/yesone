package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.NodeModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.ICashSumProvider;
import io.deptron.yesone.model.data.extension.ICreditSumProvider;
import io.deptron.yesone.model.data.extension.ISum;
import io.deptron.yesone.model.data.extension.IUsePlaceCd;

@DataProperty(start = 2023)
public class G211Model extends DataModel implements IUsePlaceCd, ISum, IAmt, ICreditSumProvider, ICashSumProvider {

    @Override
    public void addAmt(NodeModel node) {
        this.addAmt(G211AmtModel.class, node);
    }

}
