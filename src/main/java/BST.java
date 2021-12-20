import java.util.LinkedList;
import java.util.Queue;

class Node {
    protected String data;
    protected Node left, right;
   

    public Node() 
    {
        left = null;
        right = null;
    }

    public Node(String data)
    {
        this(data,null,null);
    }

    public Node(String data, Node lt, Node rt) 
    {
        this.data = data; 
        left = lt; 
        right = rt;
    }
}

class BST {
    protected Node root = null;
   
    public BST(){

	}
    
    public boolean isEmpty() 
    {
        return root == null;
    }
    
    public void insert(String data) 
    {
    	Node p = root, prev = null;
		    while (p != null) {
		        prev = p;
		        if (p.data.compareTo(data) < 0)
		            p = p.right;
		        else p = p.left;
		    }
		    if (root == null)
		        root = new Node(data);
		    else if (prev.data.compareTo(data) < 0)
		        prev.right = new Node(data);
		    else prev.left  = new Node(data);
    }   

    public boolean breadthFirst(String cmp)
    {
    	Node p = root;
        Queue<Node> queue = new LinkedList<>();
        if (p != null) 
        {
            queue.add(p);
            while (!queue.isEmpty()) 
            {
                p = queue.remove();
                if(p.data.equals(cmp))
                {
                	return true ;
                }
                if (p.left != null)
                    queue.add(p.left);
                if (p.right != null)
                    queue.add(p.right);
            }
        }
        return false ;
    }
    
    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }


}
