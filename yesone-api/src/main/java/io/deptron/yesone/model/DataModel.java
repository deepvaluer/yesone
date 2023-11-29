package io.deptron.yesone.model;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.util.StringHelper;

public class DataModel {

    private ManModel manModel;

    public void setManModel(ManModel manModel) {
        this.manModel = manModel;
    }

    public ManModel getManModel() {
        return this.manModel;
    }

    public FormModel getFormModel() {
        return this.manModel.getFormModel();
    }

    protected Map<String, Object> attrs = new HashMap<String, Object>();

    protected List<DataModel> amts = new ArrayList<DataModel>();

    public void addAttr(String key, String value) {
        this.attrs.put(key, value);
    }

    public void addAmt(NodeModel value) {
    }

    public void addAmt(DataModel value) {
        this.amts.add(value);
    }

    public <S extends DataModel> void addAmt(Class<S> clazz, NodeModel nodeModel) {
        S amt = nodeModel.toDataModel(clazz, this.manModel);
        this.amts.add(amt);
    }

    public String stringValueOf(String key) {
        return this.stringValueOf(key, "");
    }

    public String stringValueOf(String key, String def) {
        return StringHelper.stringValueOf(this.attrs.get(key), def);
    }

    public int intValueOf(String key) {
        return Integer.parseInt(this.stringValueOf(key, "0"));
    }

    public BigInteger bigIntegerValueOf(String key) {
        return new BigInteger(this.stringValueOf(key, "0"));
    }

    @DataProperty
    public String getFormCd() {
        return this.getFormModel().getFormCd();
    }

    @DataProperty
    public String getName() {
        return this.getManModel().getName();
    }

    @DataProperty
    public String getResid() {
        return this.getManModel().getResid();
    }

    @DataProperty
    public String getDatCd() {
        return this.stringValueOf("datCd");
    }

    public List<DataModel> getAmts() {
        return this.amts;
    }

    public Map<String, Object> getParameterMap() {
        int year = this.getFormModel().getYear();
        return getParameterMap(year);
    }

    public Map<String, Object> getParameterMap(int year) {
        Map<String, Object> map = new HashMap<String, Object>();
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            DataProperty dataProperty = method.getDeclaredAnnotation(DataProperty.class);
            if (null != dataProperty) {
                if (year > 0) {
                    if (year < dataProperty.start() || dataProperty.end() < year) {
                        continue;
                    }
                }

                String key = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                Object value = null;
                try {
                    value = method.invoke(this);
                } catch (Exception ex) {
                }
                map.put(key, value);
            }
        }
        return map;
    }

}
