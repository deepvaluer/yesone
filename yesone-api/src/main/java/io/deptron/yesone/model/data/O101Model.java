package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.NodeModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.ISum;

public class O101Model extends DataModel implements ISum, IAmt {
    @DataProperty
    public BigInteger getHiYrs() {
        return this.bigIntegerValueOf("hiYrs");
    }

    @DataProperty
    public BigInteger getLtrmYrs() {
        return this.bigIntegerValueOf("ltrmYrs");
    }

    @DataProperty
    public BigInteger getHiNtf() {
        return this.bigIntegerValueOf("hiNtf");
    }

    @DataProperty
    public BigInteger getLtrmNtf() {
        return this.bigIntegerValueOf("ltrmNtf");
    }

    @DataProperty
    public BigInteger getHiPmt() {
        return this.bigIntegerValueOf("hiPmt");
    }

    @DataProperty
    public BigInteger getLtrmPmt() {
        return this.bigIntegerValueOf("ltrmPmt");
    }

    @Override
    public void addAmt(NodeModel node) {
        this.addAmt(O101AmtModel.class, node);
    }

}
