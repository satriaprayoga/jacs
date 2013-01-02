package org.satriaprayoga.jacs.datamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * DataModelNode.java
 * @author GILANG SATRIA PRAYOGA
 *
 */
public class DataModelNode {
	
	private String name;
	private String value;
	
	private DataModelNode parent=null;
	private Map<String, DataModelNode> children=null;
	
	public DataModelNode(DataModelNode parent) {
		this.parent=parent;
	}
	
	public DataModelNode(DataModelNode parent,String name,String value) {
		this.parent=parent;
		this.name=name;
		this.value=value;
		children=new HashMap<String, DataModelNode>();
	}
	
	public DataModelNode getParent() {
		return parent;
	}
	
	public Collection<DataModelNode> getChildren(){
		if(children==null){
			return new ArrayList<DataModelNode>();
		}else{
			return children.values();
		}
	}
	
	public String getFQName(){
		StringBuilder builder=new StringBuilder();
		buildFQName(builder);
		return builder.toString();
	}
	
	private void buildFQName(StringBuilder builder){
		if(parent!=null){
			parent.buildFQName(builder);
			builder.append(".");
		}
		builder.append(name);
	}
	
	public boolean isLeaf(){
		return children==null;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
}
