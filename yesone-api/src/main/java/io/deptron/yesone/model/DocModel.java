package io.deptron.yesone.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DocModel {

    @XmlElement(name = "doc_type")
    private String docType;

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @XmlElement(name = "seq")
    private String seq;

    public String getSeq() {
        return this.seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    @XmlElement(name = "att_year")
    private String attYear;

    public String getAttYear() {
        return this.attYear;
    }

    public void setAttYear(String attYear) {
        this.attYear = attYear;
    }

    @XmlElement(name = "att_inqrMm")
    private String attInqrMm;

    public String getAttInqrMm() {
        return this.attInqrMm;
    }

    public void setAttInqrMm(String attInqrMm) {
        this.attInqrMm = attInqrMm;
    }

    @XmlElement(name = "resid")
    private String resid;

    public String getResid() {
        return this.resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }

    @XmlElement(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
