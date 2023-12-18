package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.ICreditSumProvider;
import io.deptron.yesone.model.data.extension.ISum;
import io.deptron.yesone.model.data.extension.IUsePlaceCd;

@DataProperty(start = 2023)
public class G411Model extends DataModel implements IBusnid, IUsePlaceCd, ISum, IAmt, ICreditSumProvider {

}
