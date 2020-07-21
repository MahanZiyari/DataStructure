using System;

namespace tree_functions
{
    public class Node
    {
        public int data;
        public Node leftChild, rightChild;

        public Node(int data)
        {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Tree tree = new Tree();
            tree.root = new Node(4);
            tree.root.leftChild = new Node(13);
            tree.root.leftChild.leftChild = new Node(8);
            tree.root.leftChild.rightChild = new Node(20);
            tree.root.rightChild = new Node(7);
            tree.root.rightChild.leftChild = new Node(1);

            Console.WriteLine("\ninorder traversal: ");
            tree.inOrder(tree.root);

            Console.WriteLine("\npreorder traversal: ");
            tree.preOrder(tree.root);

            Console.WriteLine("\npostorder traversal: ");
            tree.postOrder(tree.root);

            Console.WriteLine("\nlevelorder traversal: ");
            tree.levelOrder(tree.root);

            Console.WriteLine("\nsum: " + tree.sumLeftLeafs(tree.root));

            Console.WriteLine("\nlevelorder traversal of reverted tree: ");
            tree.revert(tree.root);
            tree.levelOrder(tree.root);

            Console.WriteLine("\n\ntree statisc: ");
            Console.Write("leaf nodes =  " + tree.getLeafCount(tree.root));
            Console.Write("\nNon-leaf nodes =  " + tree.getNonLeafCount(tree.root));
            Console.Write("\nall nodes =  " + tree.getNodeCount(tree.root));

            Console.WriteLine("\n\ncalling clear method.....");
            tree.clear(tree.root);
        }
    }
}
