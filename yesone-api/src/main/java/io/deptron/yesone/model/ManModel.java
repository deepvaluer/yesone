package io.deptron.yesone.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import io.deptron.yesone.model.data.C501Model;
import io.deptron.yesone.model.data.D101Model;
import io.deptron.yesone.model.data.E103Model;
import io.deptron.yesone.model.data.F103Model;
import io.deptron.yesone.model.data.G109Model;
import io.deptron.yesone.model.data.G109SumModel;
import io.deptron.yesone.model.data.G110Model;
import io.deptron.yesone.model.data.G110SumModel;
import io.deptron.yesone.model.data.G111Model;
import io.deptron.yesone.model.data.G111SumModel;
import io.deptron.yesone.model.data.G209Model;
import io.deptron.yesone.model.data.G209SumModel;
import io.deptron.yesone.model.data.G210Model;
import io.deptron.yesone.model.data.G210SumModel;
import io.deptron.yesone.model.data.G211Model;
import io.deptron.yesone.model.data.G211SumModel;
import io.deptron.yesone.model.data.G309Model;
import io.deptron.yesone.model.data.G309SumModel;
import io.deptron.yesone.model.data.G310Model;
import io.deptron.yesone.model.data.G310SumModel;
import io.deptron.yesone.model.data.G311Model;
import io.deptron.yesone.model.data.G311SumModel;
import io.deptron.yesone.model.data.G409Model;
import io.deptron.yesone.model.data.G409SumModel;
import io.deptron.yesone.model.data.G410Model;
import io.deptron.yesone.model.data.G410SumModel;
import io.deptron.yesone.model.data.G411Model;
import io.deptron.yesone.model.data.G411SumModel;
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
import io.deptron.yesone.model.data.S101Model;

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
                .map(node -> nodeToData(node))
                .filter(data -> null != data)
                .toArray(DataModel[]::new);
        this.sumData = nodeToSumData(this.xmlSumData);
    }

    private DataModel nodeToData(NodeModel node, Map<String, Class<? extends DataModel>> classMap) {

        String formCd = this.getFormModel().getFormCd();
        int year = this.getFormModel().getYear();

        String key = formCd.substring(0, 4);

        Class<? extends DataModel> dataModelClass = classMap.get(key);
        if (dataModelClass != null) {
            return node.toDataModel(dataModelClass, this, year);
        } else {
            return null;
        }
    }

    private DataModel nodeToData(NodeModel node) {
        if (null == node)
            return null;

        Map<String, Class<? extends DataModel>> classMap = new HashMap<>();
        classMap.put("A102", A102Model.class);
        classMap.put("B101", B101Model.class);
        classMap.put("B201", B201Model.class);
        classMap.put("C102", C102Model.class);
        classMap.put("C202", C202Model.class);
        classMap.put("C301", C301Model.class);
        classMap.put("C401", C401Model.class);
        classMap.put("C501", C501Model.class);
        classMap.put("D101", D101Model.class);
        classMap.put("E103", E103Model.class);
        classMap.put("F103", F103Model.class);
        classMap.put("G109", G109Model.class);
        classMap.put("G209", G209Model.class);
        classMap.put("G309", G309Model.class);
        classMap.put("G409", G409Model.class);
        classMap.put("G110", G110Model.class);
        classMap.put("G210", G210Model.class);
        classMap.put("G310", G310Model.class);
        classMap.put("G410", G410Model.class);
        classMap.put("G111", G111Model.class);
        classMap.put("G211", G211Model.class);
        classMap.put("G311", G311Model.class);
        classMap.put("G411", G411Model.class);
        classMap.put("J101", J101Model.class);
        classMap.put("J203", J203Model.class);
        classMap.put("J301", J301Model.class);
        classMap.put("J501", J501Model.class);
        classMap.put("K101", K101Model.class);
        classMap.put("L102", L102Model.class);
        classMap.put("N101", N101Model.class);
        classMap.put("N102", N101Model.class);
        classMap.put("O101", O101Model.class);
        classMap.put("P102", P102Model.class);
        classMap.put("Q101", Q101Model.class);
        classMap.put("Q201", Q201Model.class);
        classMap.put("Q301", Q301Model.class);
        classMap.put("R101", R101Model.class);
        classMap.put("S101", S101Model.class);

        return nodeToData(node, classMap);
    }

    private DataModel nodeToSumData(NodeModel node) {
        if (null == node)
            return null;

        Map<String, Class<? extends DataModel>> classMap = new HashMap<>();

        classMap.put("G109", G109SumModel.class);
        classMap.put("G209", G209SumModel.class);
        classMap.put("G309", G309SumModel.class);
        classMap.put("G409", G409SumModel.class);
        classMap.put("G110", G110SumModel.class);
        classMap.put("G210", G210SumModel.class);
        classMap.put("G310", G310SumModel.class);
        classMap.put("G410", G410SumModel.class);
        classMap.put("G111", G111SumModel.class);
        classMap.put("G211", G211SumModel.class);
        classMap.put("G311", G311SumModel.class);
        classMap.put("G411", G411SumModel.class);

        return nodeToData(node, classMap);

    }

}
