package io.deptron.yesone.model.data;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.data.extension.IAccNo;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.IBusnid;
import io.deptron.yesone.model.data.extension.IComCd;
import io.deptron.yesone.model.data.extension.IStartEndDt;
import io.deptron.yesone.model.data.extension.ISum;

public class D101Model extends DataModel implements IBusnid, IAccNo, IStartEndDt, IComCd, ISum, IAmt {

}
