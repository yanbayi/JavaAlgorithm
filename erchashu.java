package ti;

    class Node{
        private int data;
        private Node leftNode;
        private Node rightNode;
        public Node(int data,Node leftNode,Node rightNode){
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
        public int getData(){
            return data;
        }
        public void setData(int data){
            this.data = data;
        }
        public Node getLeftNode(){
            return leftNode;
        }
        public void setLeftNode(Node leftNode){
            this.leftNode = leftNode;
        }
        public Node getRightNode(){
            return rightNode;
        }
        public void setRightNode(Node rightNode){
            this.rightNode = rightNode;
        }
    }

    class BinaryTree {
        public Node init() {
            Node J = new Node(8, null, null);
            Node H = new Node(3, null, null);
            Node G = new Node(4, null, null);
            Node F = new Node(7, null, J);
            Node E = new Node(5, H, null);
            Node D = new Node(9, null, G);
            Node C = new Node(1, F, null);
            Node B = new Node(2, E, D);
            Node A = new Node(6, B, C);

            return A;
        }

        public void printNode(Node node) {
            System.out.print(node.getData());
        }

        public void FirstTrave(Node root) {
            printNode(root);
            if (root.getLeftNode() != null) {//不为空，递归左孩子
                FirstTrave(root.getLeftNode());
            }
            if (root.getRightNode() != null) {//不为空，递归左孩子
                FirstTrave(root.getRightNode());
            }
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            Node root = tree.init();
            System.out.println("先序遍历");
            tree.FirstTrave(root);
        }
    }
