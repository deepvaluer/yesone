package io.deptron.yesone.model;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import org.w3c.dom.Node;

public class NodeAdapter extends XmlAdapter<NodeAdapter.AdapterEntity, NodeModel> {

    static class AdapterEntity {

        @XmlAnyAttribute
        public Map<QName, Object> attr;

        @XmlAnyElement
        public List<Node> nodes;
    }

    @Override
    public NodeModel unmarshal(AdapterEntity v) throws Exception {
        return NodeModel.parse(v);
    }

    @Override
    public AdapterEntity marshal(NodeModel v) throws Exception {
        return null;
    }

}
