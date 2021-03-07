package Composite;

/**
 * @author xuziwen
 * @date 2021/3/7 11:54 下午
 */
public class LeafNode extends Node{

    private String name;

    public LeafNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(getName());
    }
}
