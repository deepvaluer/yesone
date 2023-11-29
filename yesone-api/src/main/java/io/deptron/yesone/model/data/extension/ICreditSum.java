package io.deptron.yesone.model.data.extension;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface ICreditSum {
    @DataProperty
    default BigInteger getTotPreYearSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("totPreYearSum");
    }

    @DataProperty
    default BigInteger getTotCurrYearSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("totCurrYearSum");
    }

    @DataProperty
    default BigInteger getGnrlSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("gnrlSum");

    }

    @DataProperty
    default BigInteger getTdmrSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tdmrSum");
    }

    @DataProperty
    default BigInteger getTrpSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("trpSum");

    }

    @DataProperty
    default BigInteger getIsldSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("isldSum");

    }

    @DataProperty
    default BigInteger getTotSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("totSum");
    }

    //
    // 전통시장 사용금액 합계
    //
    @DataProperty(start = 2022)
    default BigInteger getTdmrTotPreYearSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tdmrTotPreYearSum");
    }

    @DataProperty(start = 2022)
    default BigInteger getTdmrTotCurrYearSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tdmrTotCurrYearSum");
    }

    //
    // 상반기 합계
    //
    @DataProperty(start = 2022)
    default BigInteger getTfhyGnrlSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("thfGynrlSum");

    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyTdmrSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tfhyTdmrSum");
    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyTrpSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tfhyTrpSum");

    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyIsldSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tfhyIsldSum");

    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyTotSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("tfhyTotSum");
    }

    //
    // 하반기 합계
    //
    @DataProperty(start = 2022)
    default BigInteger getShfyGnrlSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("thfGynrlSum");

    }

    @DataProperty(start = 2022)
    default BigInteger getShfyTdmrSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("shfyTdmrSum");
    }

    @DataProperty(start = 2022)
    default BigInteger getShfyTrpSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("shfyTrpSum");

    }

    @DataProperty(start = 2022)
    default BigInteger getShfyIsldSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("shfyIsldSum");

    }

    @DataProperty(start = 2022)
    default BigInteger getShfyTotSum() {
        DataModel dataModel = (DataModel) this;
        return dataModel.bigIntegerValueOf("shfyTotSum");
    }

}
