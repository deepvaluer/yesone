package io.deptron.yesone.model;

import java.util.Arrays;
import java.util.Iterator;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class FormModel {

    @XmlAttribute(name = "form_cd")
    private String formCd;

    public String getFormCd() {
        return this.formCd;
    }

    public void setFormCd(String formCd) {
        this.formCd = formCd;
    }

    @XmlElement(name = "man")
    private ManModel[] mans;

    public ManModel[] getMans() {
        return this.mans;
    }

    public void setMans(ManModel[] mans) {
        this.mans = mans;
    }

    public Iterator<ManModel> iterator() {
        return Arrays.stream(this.mans).iterator();
    }

    private YesoneModel yesOneModel;

    public YesoneModel getYesoneModel() {
        return this.yesOneModel;
    }

    public void setYesoneModel(YesoneModel yesOneModel) {
        this.yesOneModel = yesOneModel;
    }

    public int getYear() {
        return Integer.parseInt(this.yesOneModel.getDoc().getAttYear());
    }

    void beforeUnmarshal(Unmarshaller unmarshaller, Object parent) {
        this.yesOneModel = (YesoneModel) parent;
    }
}
