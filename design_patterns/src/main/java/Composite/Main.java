package Composite;

/**
 * @author xuziwen
 * @date 2021/3/7 11:52 下午
 * 组合模式：树状结构专用
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");

        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");

        LeafNode c11 = new LeafNode("c11");
        LeafNode c12 = new LeafNode("c12");

        BranchNode section21 = new BranchNode("section21");
        LeafNode s211 = new LeafNode("s211");
        LeafNode s212 = new LeafNode("s212");

        root.addNode(chapter1);
        root.addNode(chapter2);

        chapter1.addNode(c11);
        chapter1.addNode(c12);

        chapter2.addNode(section21);
        section21.addNode(s211);
        section21.addNode(s212);

        printTree(root,0);

    }

    /**
     * 遍历树
     * @param node
     * @param depth
     * 还可以用 队列(Breadth-First Search) 栈(Depth-First Search)实现
     */
    public static void printTree(Node node,int depth){
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        node.printName();
        if(node instanceof BranchNode){
            ((BranchNode) node).getNodeList().forEach(e-> printTree(e,depth+1));
        }

    };
}
