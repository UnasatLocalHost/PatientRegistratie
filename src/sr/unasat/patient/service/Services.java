package sr.unasat.patient.service;



public class Services {


   public static class Node
   {
       int patientID;
       String patientName;
       public Node left,right;

       public Node (int patientID, String patientName)
       {
           this.patientID = patientID;
           this.patientName = patientName;
       }
   }

   public static class Main
   {
       public static void printDLL(Node head)
       {
           Node curr = head;
           while (curr != null)
           {
               System.out.println(curr.patientID + " : "+ curr.patientName);
               curr = curr.right;
           }
       }


       //function to in-place convert given Binary Tree  to a Doubly Linked List.
       public static Node convert(Node root,Node head)
       {
           //base case: tree is empty

           if (root == null) {return head;}

           //recursively convert left subtree first
           head = convert(root.left,head);

           //store right child
           Node right=root.right;

           //insert current node in de beginning of the DLL
           root.right = head;
           if (head != null) {head.left = root;}

           head = root;

           //recursively convert right subtree
           return convert(right,head);






       }
       //function to reserve a DLL
       public static Node reverse (Node head)
       {
           Node prev = null;
           Node current  = head;

           while (current != null)
           {
               //swap current left with current right
               Node temp = current.left;
               current.left = current.right;
               current.right = temp;
           }
           return prev;

       }

       //main function to in-place convert given Binary tree to a DLL

       public static void convert(Node root) {
           //head of the DLL
           Node head  = null;

           //convert binary tree  to DLL
           head = convert(root,head);

           //reserve the linked list
           head = reverse(head);


           //print the list
           printDLL(head);
       }

     public static boolean ifNodeExist(Node node, int key)
       {
           if (node == null) {return false;}
           if (node.patientID == key) {return true;}

           // then recur on left subtree
           boolean result1 = ifNodeExist(node.left,key);
           if (result1) return true;// node was found, no need to look any further.

           //node is not found in left, so recur on right subtree.
           boolean result2 = ifNodeExist(node.right,key);
           return result2;
       }

       public static Node deleteNode (Node root, int key)
       {
           //pointer to store parent node of the current node
           Node parent = null;

           // start with the root node
           Node curr = root;

           //search for key & set its parent pointer
           while (curr != null && curr.patientID != key)
           {
               // update parent node as current node

               parent = curr;
               //if the key is less than the current node , go left subtree.
               // else go to the right subtree.
               if (key < curr.patientID)
               {
                   curr = curr.left;
               }
               else
               {
                   curr = curr.right;
               }
           }
           //return if key is not found in the tree
           if (curr == null) {return root;}

           //case 1: node to be deleted has no children.
           if (curr.left == null && curr.right == null)
           {
               //if node to be deleted is not  a root node , then set is.
               // parent left/right child to null

               if (curr != root){
                   if (parent.left == curr) {
                       parent.left = null;
                   }
                   else {
                       parent.right = null;
                   }
               }
               else
               {root = null;}
           }
           //case 2: node to be deleted has 2 children
           else if(curr.left != null && curr.right != null)
           {
               //find its in-order successor node
               Node successor = minimumKey(curr.right);

               //store successor value

               int val = successor.patientID;

               //recursively delete the successor.

               deleteNode(root,successor.patientID);

               //copy the value of the successor to current node
               curr.patientID = val;

           }
           //case 3: node to be deleted has only one child
           else
           {
               //find child node
               Node child = (curr.left != null)? curr.left : curr.right;

               //if node to deleted is not a root node , then set its parent
               // to its child

               if (curr != root)
               {
                   if (curr == parent.left)
                   {
                       parent.left = child;

                   }else {
                       parent.right = child;
                   }
               }
               // if node to be deleted is root node, then set the root to child
               else {
                   root = child;
               }
           }
           return root;
       }
   }

    public static Node minimumKey(Node curr) {
       while (curr.left != null)
       {
           curr = curr.left;
       }
       return curr;
    }


}