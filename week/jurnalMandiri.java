public class jurnalMandiri {
    Node root;

    public static void main(String[] args) {
        jurnalMandiri tree = new jurnalMandiri();
        /*
         * lakukan proses penambahan data dengan memanggil method insert, ambil studi
         * kasus sebanyak n nilai
         * 
         */

        tree.insert(4, "hkim");
        tree.insert(5, "bambang");
        tree.insert(3, "bambank");
        tree.insert(6, "yanto");
        tree.insert(9, "abdul");
        System.out.println(tree.search(6));
        System.out.println("data max "+tree.findMax());
        System.out.println("data min "+tree.findMin());
        tree.dataShow();
    }

    public jurnalMandiri() {
        root = null;
    }

    public void insert(int nim, String nama) {
        root = insertRecord(root, nim, nama);
    }

    private Node insertRecord(Node root, int nim, String nama) {
        Mahasiswa mhs = new Mahasiswa(nim, nama);
        if (root == null) {
            root = new Node(mhs);
            return root;
        }
        if (nim < root.mahasiswa.nim)
            root.left = insertRecord(root.left, nim, nama);
        else if (nim > root.mahasiswa.nim)
            root.right = insertRecord(root.right, nim, nama);
        return root;
    }

    public void dataShow() {
        System.out.print("inorder  : ");
        inorderRec(root);
        System.out.print("Preorder : ");
        preorderTraversal(root);
        System.out.print("Postorder : ");
        postorderTraversal(root);
    }

    /*
     * Inorder traversal
     * a. Traverse the left subtree
     * b. Visit the root.
     * c. Traverse the right subtree
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.mahasiswa.getNim() + " ");
            inorderRec(root.right);
        }
    }

    /*
     * Preorder traversal
     * a. Visit the root.
     * b. Traverse the left subtree
     * c. Traverse the right subtree
     */
    void preorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.mahasiswa.getNim() + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /*
     * Postorder traversal
     * a. Traverse the left subtree
     * b. Traverse the right subtree
     * c. Visit the root.
     */
    void postorderTraversal(Node node) {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.mahasiswa.getNim() + " ");
    }

    public boolean search(int nim) {
        return searchRec(root, nim);
    }

    private boolean searchRec(Node root, int nim) {
        if (root == null)
            return false;
        if (nim == root.mahasiswa.nim)
            return true;
        if (nim < root.mahasiswa.nim)
            return searchRec(root.left, nim);
        else
            return searchRec(root.right, nim);
    }

    public int findMin(){
        return findMinRec(root);
    }

    private int findMinRec(Node root){
        if (root==null) {
            throw new IllegalStateException("Empty Tree");
        } if (root.left==null) {
            return root.mahasiswa.getNim();
        }return findMinRec(root.left);
    }

    public int findMax() {
        return findMaxRec(root);
    }

    private int findMaxRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Empty Tree");

        /*
         * jika child kanan memiliki nilai null, berarti data ditemukan pada node
         * tersebut
         */
        if (root.right == null)
            return root.mahasiswa.getNim();
        /*
         * rekursif jika data child kanan masih memiliki nilai
         */
        return findMaxRec(root.right);
    }

}

// Node Class
// class Node {
//     int data;
//     Node left, right;

//     public Node(int item) {
//         data = item;
//         left = right = null;
//     }}

// Node Class

    class Node {
        Mahasiswa mahasiswa;
        Node left, right;

        public Node(Mahasiswa mahasiswa) {
            this.mahasiswa = mahasiswa;
            left = right = null;
        }
    }

    class Mahasiswa {
        int nim;
        String nama;

        public Mahasiswa(int nim, String nama) {
            this.nim = nim;
            this.nama = nama;
        }

        public int getNim() {
            return nim;
        }

        public String getNama() {
            return nama;
        }

        public String toString() {
            return (nim + " " + nama);
        }
}
