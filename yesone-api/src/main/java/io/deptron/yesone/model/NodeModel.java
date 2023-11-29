package io.deptron.yesone.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.namespace.QName;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.deptron.yesone.model.annotation.DataProperty;
import io.deptron.yesone.util.StringHelper;

@XmlAccessorType(XmlAccessType.FIELD)
public class NodeModel {

    private String key;

    private String value;

    private Map<String, String> attrs;

    private List<NodeModel> nodes;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, String> getAttrs() {
        return this.attrs;
    }

    public void setAttrs(Map<String, String> attrs) {
        this.attrs = attrs;
    }

    public List<NodeModel> getNodes() {
        return this.nodes;
    }

    public void setNodes(List<NodeModel> nodes) {
        this.nodes = nodes;
    }

    public static NodeModel parse(NodeAdapter.AdapterEntity entity) {

        NodeModel newNodeModel = new NodeModel();

        Map<String, String> attrs = new HashMap<String, String>();
        if (null != entity.attr) {
            Iterator<QName> attrIter = entity.attr.keySet().iterator();
            while (attrIter.hasNext()) {
                QName attrKey = attrIter.next();
                String attrValue = StringHelper.stringValueOf(entity.attr.get(attrKey));
                String key = StringHelper.toCamelCase(attrKey.getLocalPart());
                attrs.put(key, attrValue);
            }
        }

        newNodeModel.setAttrs(attrs);
        if (null == entity.nodes)
            return newNodeModel;

        List<NodeModel> childNodeModels = new ArrayList<NodeModel>();
        Iterator<Node> iterNode = entity.nodes.iterator();
        while (iterNode.hasNext()) {

            Node node = iterNode.next();

            NamedNodeMap attrMap = node.getAttributes();

            String key = StringHelper.toCamelCase(node.getNodeName());
            String value = "";

            Node firstNode = node.getFirstChild();
            if (null != firstNode) {
                value = StringHelper.stringValueOf(firstNode.getNodeValue());
            }

            NodeList childNodes = node.getChildNodes();
            NodeModel childNodeModel;
            if (childNodes.getLength() > 1) {
                childNodeModel = NodeModel.parse(attrMap, childNodes);
            } else {
                childNodeModel = NodeModel.parse(attrMap);
            }
            childNodeModel.setKey(key);
            childNodeModel.setValue(value);
            childNodeModels.add(childNodeModel);
        }

        newNodeModel.setNodes(childNodeModels);

        return newNodeModel;
    }

    public static NodeModel parse(NamedNodeMap attrMap) {

        NodeModel newNodeModel = new NodeModel();

        Map<String, String> attrs = new HashMap<String, String>();
        int attrLength = attrMap.getLength();
        if (attrLength > 0) {
            for (int i = 0; i < attrLength; i++) {
                Node attr = attrMap.item(i);
                String key = StringHelper.toCamelCase(attr.getNodeName());
                String value = StringHelper.stringValueOf(attr.getNodeValue());
                attrs.put(key, value);
            }
        }

        newNodeModel.setAttrs(attrs);

        return newNodeModel;
    }

    public static NodeModel parse(NamedNodeMap attrMap, NodeList childNodes) {

        NodeModel newNodeModel = NodeModel.parse(attrMap);

        List<NodeModel> childNodeModels = new ArrayList<NodeModel>();
        int childLength = childNodes.getLength();
        if (childLength > 0) {
            for (int i = 0; i < childLength; i++) {

                Node node = childNodes.item(i);

                NamedNodeMap attrMap2 = node.getAttributes();

                String key = StringHelper.toCamelCase(node.getNodeName());
                String value = "";

                Node firstNode = node.getFirstChild();
                if (null != firstNode) {
                    value = StringHelper.stringValueOf(firstNode.getNodeValue());

                }
                NodeList childNodes2 = node.getChildNodes();
                NodeModel childNodeModel;
                if (childNodes2.getLength() > 1) {
                    childNodeModel = NodeModel.parse(attrMap2, childNodes2);
                } else {
                    childNodeModel = NodeModel.parse(attrMap2);
                }
                childNodeModel.setKey(key);
                childNodeModel.setValue(value);
                childNodeModels.add(childNodeModel);
            }
        }

        newNodeModel.setNodes(childNodeModels);
        return newNodeModel;
    }

    public <S extends DataModel> S toDataModel(Class<S> clazz, ManModel manModel) {
        int year = manModel.getFormModel().getYear();
        return toDataModel(clazz, manModel, year);
    }

    public <S extends DataModel> S toDataModel(Class<S> clazz, ManModel manModel, int year) {
        S castModel = null;
        try {
            DataProperty dataProperty = clazz.getDeclaredAnnotation(DataProperty.class);
            if (null != dataProperty && year > 0) {
                if (year < dataProperty.start() || dataProperty.end() < year) {
                    return null;
                }
            }

            castModel = (S) clazz.newInstance();
            castModel.setManModel(manModel);
            if (!StringHelper.isEmptyTrimmed(key) && !StringHelper.isEmptyTrimmed(value))
                addAttr(castModel, key, value);

            addAttrs(castModel, this.attrs);
            addNodes(castModel, this.nodes);

        } catch (Exception ex) {

        }
        return castModel;
    }

    private <S extends DataModel> void addNodes(S dataModel, List<NodeModel> nodes) {
        if (null == nodes)
            return;

        for (NodeModel node : nodes) {
            String nodeKey = node.getKey();
            String nodeValue = node.getValue();
            if ("amt".equals(nodeKey)) {
                addAmt(dataModel, node);
            } else {
                if (!StringHelper.isEmptyTrimmed(nodeValue))
                    addAttr(dataModel, nodeKey, nodeValue);
                addAttrs(dataModel, node.getAttrs());
            }
        }

    }

    private <S extends DataModel> void addAttrs(S dataModel, Map<String, String> attrs) {
        if (null == attrs)
            return;
        Iterator<String> attrKeys = attrs.keySet().iterator();
        while (attrKeys.hasNext()) {
            String attrKey = attrKeys.next();
            addAttr(dataModel, attrKey, attrs.get(attrKey));
        }
    }

    private <S extends DataModel> void addAttr(S dataModel, String key, String value) {
        try {
            String attrKey = key;
            String attrValue = value;
            String suffix = attrKey.substring(0, 1).toUpperCase() + attrKey.substring(1);
            Method getMethod = dataModel.getClass().getMethod("get" + suffix);
            DataProperty dataPorperty = getMethod.getDeclaredAnnotation(DataProperty.class);
            if (null != dataPorperty) {
                // Method addMethod = dataModel.getClass().getMethod("addAttr", String.class,
                // String.class);
                dataModel.addAttr(attrKey, attrValue);
            }
        } catch (Exception ex) {

        }

    }

    private <S extends DataModel> void addAmt(S dataModel, NodeModel amt) {
        try {
            Method getMethod = dataModel.getClass().getMethod("getAmt");
            DataProperty dataPorperty = getMethod.getDeclaredAnnotation(DataProperty.class);
            if (null != dataPorperty) {
                Method addMethod = dataModel.getClass().getMethod("addAmt", NodeModel.class);
                addMethod.invoke(dataModel, amt);
            }
        } catch (Exception ex) {

        }

    }
}