package Composite;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xuziwen
 * @date 2021/3/7 11:54 下午
 */
public class BranchNode extends Node{
    private String name;

    private List<Node> nodeList=new LinkedList<Node>();

    public BranchNode(String name) {
        this.name = name;
    }

    public List<Node> addNode(Node node){
        nodeList.add(node);
        return nodeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public void printName() {
        System.out.println(getName());
    }
}
