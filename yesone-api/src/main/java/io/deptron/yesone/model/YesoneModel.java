package io.deptron.yesone.model;

import java.util.Arrays;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "yesone")
public class YesoneModel {

    @XmlElement(name = "doc")
    private DocModel doc;

    public DocModel getDoc() {
        return this.doc;
    }

    public void setDoc(DocModel doc) {
        this.doc = doc;
    }

    @XmlElement(name = "form")
    private FormModel[] forms;

    public FormModel[] getForms() {
        return this.forms;
    }

    public void setForms(FormModel[] forms) {
        this.forms = forms;
    }

    public Iterator<FormModel> iterator() {
        return Arrays.stream(this.forms).iterator();
    }
}
