package io.deptron.yesone.model.data.extension;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.annotation.DataProperty;

public interface ICreditSumProvider {
    @DataProperty
    default BigInteger getTotPreYearSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTotPreYearSum();
    }

    @DataProperty
    default BigInteger getTotCurrYearSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTotCurrYearSum();
    }

    @DataProperty
    default BigInteger getGnrlSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getGnrlSum();
    }

    @DataProperty
    default BigInteger getTdmrSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTdmrSum();
    }

    @DataProperty
    default BigInteger getTrpSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTrpSum();
    }

    @DataProperty
    default BigInteger getIsldSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getIsldSum();
    }

    @DataProperty
    default BigInteger getTotSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTotSum();
    }

    //
    // 전통시장 사용금액 합계
    //
    @DataProperty(start = 2022)
    default BigInteger getTdmrTotPreYearSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTdmrTotPreYearSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getTdmrTotCurrYearSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTdmrTotCurrYearSum();
    }

    //
    // 상반기 합계
    //
    @DataProperty(start = 2022)
    default BigInteger getTfhyGnrlSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTfhyGnrlSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyTdmrSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTfhyTdmrSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyTrpSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTfhyTrpSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyIsldSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTfhyIsldSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getTfhyTotSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getTfhyTotSum();
    }

    //
    // 하반기 합계
    //
    @DataProperty(start = 2022)
    default BigInteger getShfyGnrlSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getShfyGnrlSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getShfyTdmrSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getShfyTdmrSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getShfyTrpSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getShfyTrpSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getShfyIsldSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getShfyIsldSum();
    }

    @DataProperty(start = 2022)
    default BigInteger getShfyTotSum() {
        DataModel dataModel = (DataModel) this;
        ICreditSum sum = (ICreditSum) dataModel.getManModel().getSumData();
        return sum.getShfyTotSum();
    }
}
