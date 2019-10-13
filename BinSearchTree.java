/************************************************************** 
            Purpose/Description: <This program does a binary search tree
	    with 3 customized methods. one of the methods adds only the 
	    positive numbers from the tree. another method prints the 
	    elements in ascending order. yet another method finds the
	    maximum number and erase the number's node.> 
            Author’s Panther ID: <5660995>           
            Certification:  
            I hereby certify that this work is my own and none of it is
            the work of any other person.  
        **************************************************************/
package central;

public class BinSearchTree {
    int max = 0;
     int sum = 0;
    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    }
    Node root;  
    BinSearchTree() {  
        root = null;  
    } 
    public  void printTree()  { 
       inOrder(root); //invokes helper function
    } 
  
    // A utility function to do ascending order
    public void inOrder(Node root) { 
        if (root != null) { 
            inOrder(root.left);  
            System.out.println(root.key); 
             inOrder(root.right); 
        } 
    } 
    public int positiveKeySum(){
        
        return sumRec(root);
    }
    int sumRec(Node root){
        if(root == null){
            return 0;
        }
        if(root.key < 0){ //negative number, then do nothing
            sum = sum + 0;
        }
        else{
           sum = sum + root.key;
        }
        sumRec(root.left);
        sumRec(root.right);
        return sum;
        
    }
    public void deleteMax(){  
        delMaxRec(root);
    }
    public void delMaxRec(Node root){
        if(root.right == null){
            max = root.key;
            deleteKey(max);
            return;
        }
        delMaxRec(root.right);//recursion to find the biggest number
    }  
    
    void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) { 
  
        /* If the tree is empty, return a new node */
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 
    // This method mainly calls deleteRec() 
    void deleteKey(int key) 
    { 
        root = deleteRec(root, key); 
    } 
  
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.key = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 
    int minValue(Node root) 
    { 
        int minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 
    
}
