package io.deptron.yesone.model.data.extension;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface IPensionAttr {
    @DataProperty
    default BigInteger getAnnTotAmt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("annTotAmt");
    }

    @DataProperty
    default BigInteger getTaxYearAmt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("taxYearAmt");
    }

    @DataProperty
    default BigInteger getDdctBsAssAmt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("ddctBsAssAmt");
    }

    @DataProperty
    default BigInteger getIsaAnnTotAmt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("isaAnnTotAmt");
    }

    @DataProperty
    default BigInteger getIsaTaxYearAmt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("isaTaxYearAmt");
    }

    @DataProperty
    default BigInteger getIsaDdctBsAssAmt() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("isaDdctBsAssAmt");
    }
}
