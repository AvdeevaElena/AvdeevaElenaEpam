package SE03;

public class Node {

     Node left;
     Node right;


     static int height(Node node) {

         if (node == null) {

             return 0;

         }


         int left = height(node.left);

         int right = height(node.right);

         return Math.max(left, right);

     }
}
