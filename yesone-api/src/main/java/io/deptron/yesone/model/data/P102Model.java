package io.deptron.yesone.model.data;

import java.math.BigInteger;

import io.deptron.yesone.model.DataModel;
import io.deptron.yesone.model.NodeModel;
import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.model.data.extension.IAmt;
import io.deptron.yesone.model.data.extension.ISum;

public class P102Model extends DataModel implements ISum, IAmt {
    @DataProperty
    public BigInteger getSpNtf() {
        return this.bigIntegerValueOf("spNtf");
    }

    @DataProperty
    public BigInteger getSpym() {
        return this.bigIntegerValueOf("spym");
    }

    @DataProperty
    public BigInteger getJlc() {
        return this.bigIntegerValueOf("jlc");
    }

    @DataProperty
    public BigInteger getNtf() {
        return this.bigIntegerValueOf("ntf");
    }

    @DataProperty
    public BigInteger getPmt() {
        return this.bigIntegerValueOf("pmt");
    }

    @Override
    public void addAmt(NodeModel node) {
        this.addAmt(P102AmtModel.class, node);
    }

}
