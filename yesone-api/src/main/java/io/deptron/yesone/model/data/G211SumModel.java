package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.ICashSum;
import io.deptron.yesone.model.data.extension.ICreditSum;

@DataProperty(start = 2023)
public class G211SumModel extends DataModel implements ICreditSum, ICashSum {

}
