package io.deptron.yesone.model;

import java.util.Arrays;
import java.util.Iterator;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import io.deptron.yesone.model.data.A102Model;
import io.deptron.yesone.model.data.B101Model;
import io.deptron.yesone.model.data.B201Model;
import io.deptron.yesone.model.data.C102Model;
import io.deptron.yesone.model.data.C202Model;
import io.deptron.yesone.model.data.C301Model;
import io.deptron.yesone.model.data.C401Model;
import io.deptron.yesone.model.data.D101Model;
import io.deptron.yesone.model.data.E103Model;
import io.deptron.yesone.model.data.F103Model;
import io.deptron.yesone.model.data.G109Model;
import io.deptron.yesone.model.data.G109SumModel;
import io.deptron.yesone.model.data.G110Model;
import io.deptron.yesone.model.data.G110SumModel;
import io.deptron.yesone.model.data.G209Model;
import io.deptron.yesone.model.data.G209SumModel;
import io.deptron.yesone.model.data.G210Model;
import io.deptron.yesone.model.data.G210SumModel;
import io.deptron.yesone.model.data.G309Model;
import io.deptron.yesone.model.data.G309SumModel;
import io.deptron.yesone.model.data.G310Model;
import io.deptron.yesone.model.data.G310SumModel;
import io.deptron.yesone.model.data.G409Model;
import io.deptron.yesone.model.data.G409SumModel;
import io.deptron.yesone.model.data.G410Model;
import io.deptron.yesone.model.data.G410SumModel;
import io.deptron.yesone.model.data.J101Model;
import io.deptron.yesone.model.data.J203Model;
import io.deptron.yesone.model.data.J301Model;
import io.deptron.yesone.model.data.J501Model;
import io.deptron.yesone.model.data.K101Model;
import io.deptron.yesone.model.data.L102Model;
import io.deptron.yesone.model.data.N101Model;
import io.deptron.yesone.model.data.O101Model;
import io.deptron.yesone.model.data.P102Model;
import io.deptron.yesone.model.data.Q101Model;
import io.deptron.yesone.model.data.Q201Model;
import io.deptron.yesone.model.data.Q301Model;
import io.deptron.yesone.model.data.R101Model;

@XmlAccessorType(XmlAccessType.FIELD)
public class ManModel {

    private FormModel formModel;

    public FormModel getFormModel() {
        return this.formModel;
    }

    @XmlAttribute(name = "resid")
    private String resid;

    public String getResid() {
        return this.resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }

    @XmlAttribute(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlJavaTypeAdapter(NodeAdapter.class)
    @XmlElement(name = "data")
    private NodeModel[] xmlDatas;

    private DataModel[] datas;

    public DataModel[] getDatas() {
        return this.datas;
    }

    public void setDatas(DataModel[] datas) {
        this.datas = datas;
    }

    @XmlJavaTypeAdapter(NodeAdapter.class)
    @XmlElement(name = "sum_data")
    private NodeModel xmlSumData;

    private DataModel sumData;

    public DataModel getSumData() {
        return this.sumData;
    }

    public void setSumData(DataModel sumData) {
        this.sumData = sumData;
    }

    public Iterator<DataModel> iterator() {
        return Arrays.stream(this.datas).iterator();
    }

    void beforeUnmarshal(Unmarshaller unmarshaller, Object parent) {
        this.formModel = (FormModel) parent;
    }

    void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        this.datas = Arrays.stream(this.xmlDatas)
                .map(node -> mapToData(node))
                .filter(data -> null != data)
                .toArray(DataModel[]::new);
        this.sumData = mapToSumData(this.xmlSumData);
    }

    private DataModel mapToData(NodeModel node) {
        if (null == node)
            return null;
        String formCd = this.getFormModel().getFormCd();
        int year = this.getFormModel().getYear();
        DataModel res;
        if (formCd.startsWith("A102"))
            res = node.toDataModel(A102Model.class, this, year);
        else if (formCd.startsWith("B101"))
            res = node.toDataModel(B101Model.class, this, year);
        else if (formCd.startsWith("B201"))
            res = node.toDataModel(B201Model.class, this, year);
        else if (formCd.startsWith("C102"))
            res = node.toDataModel(C102Model.class, this, year);
        else if (formCd.startsWith("C202"))
            res = node.toDataModel(C202Model.class, this, year);
        else if (formCd.startsWith("C301"))
            res = node.toDataModel(C301Model.class, this, year);
        else if (formCd.startsWith("C401"))
            res = node.toDataModel(C401Model.class, this, year);
        else if (formCd.startsWith("D101"))
            res = node.toDataModel(D101Model.class, this, year);
        else if (formCd.startsWith("E103"))
            res = node.toDataModel(E103Model.class, this, year);
        else if (formCd.startsWith("F103"))
            res = node.toDataModel(F103Model.class, this, year);
        else if (formCd.startsWith("G109"))
            res = node.toDataModel(G109Model.class, this, year);
        else if (formCd.startsWith("G209"))
            res = node.toDataModel(G209Model.class, this, year);
        else if (formCd.startsWith("G309"))
            res = node.toDataModel(G309Model.class, this, year);
        else if (formCd.startsWith("G409"))
            res = node.toDataModel(G409Model.class, this, year);
        else if (formCd.startsWith("G110"))
            res = node.toDataModel(G110Model.class, this, year);
        else if (formCd.startsWith("G210"))
            res = node.toDataModel(G210Model.class, this, year);
        else if (formCd.startsWith("G310"))
            res = node.toDataModel(G310Model.class, this, year);
        else if (formCd.startsWith("G410"))
            res = node.toDataModel(G410Model.class, this, year);
        else if (formCd.startsWith("J101"))
            res = node.toDataModel(J101Model.class, this, year);
        else if (formCd.startsWith("J203"))
            res = node.toDataModel(J203Model.class, this, year);
        else if (formCd.startsWith("J301"))
            res = node.toDataModel(J301Model.class, this, year);
        else if (formCd.startsWith("J501"))
            res = node.toDataModel(J501Model.class, this, year);
        else if (formCd.startsWith("K101"))
            res = node.toDataModel(K101Model.class, this, year);
        else if (formCd.startsWith("L102"))
            res = node.toDataModel(L102Model.class, this, year);
        else if (formCd.startsWith("N101"))
            res = node.toDataModel(N101Model.class, this, year);
        else if (formCd.startsWith("N102"))
            res = node.toDataModel(N101Model.class, this, year);
        else if (formCd.startsWith("O101"))
            res = node.toDataModel(O101Model.class, this, year);
        else if (formCd.startsWith("P102"))
            res = node.toDataModel(P102Model.class, this, year);
        else if (formCd.startsWith("Q101"))
            res = node.toDataModel(Q101Model.class, this, year);
        else if (formCd.startsWith("Q201"))
            res = node.toDataModel(Q201Model.class, this, year);
        else if (formCd.startsWith("Q301"))
            res = node.toDataModel(Q301Model.class, this, year);
        else if (formCd.startsWith("R101"))
            res = node.toDataModel(R101Model.class, this, year);
        else
            return null;

        return res;
    }

    private DataModel mapToSumData(NodeModel node) {
        if (null == node)
            return null;

        String formCd = this.getFormModel().getFormCd();
        int year = this.getFormModel().getYear();
        DataModel res;
        if (formCd.startsWith("G109"))
            res = node.toDataModel(G109SumModel.class, this, year);
        else if (formCd.startsWith("G209"))
            res = node.toDataModel(G209SumModel.class, this, year);
        else if (formCd.startsWith("G309"))
            res = node.toDataModel(G309SumModel.class, this, year);
        else if (formCd.startsWith("G409"))
            res = node.toDataModel(G409SumModel.class, this, year);
        else if (formCd.startsWith("G110"))
            res = node.toDataModel(G110SumModel.class, this, year);
        else if (formCd.startsWith("G210"))
            res = node.toDataModel(G210SumModel.class, this, year);
        else if (formCd.startsWith("G310"))
            res = node.toDataModel(G310SumModel.class, this, year);
        else if (formCd.startsWith("G410"))
            res = node.toDataModel(G410SumModel.class, this, year);
        else
            return null;

        return res;
    }

}
