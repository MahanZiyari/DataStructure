using System;
using System.Collections.Generic;
using System.Text;
using tree_functions;

namespace tree_functions
{
    class Tree
    {
        public Node root;

        public virtual void preOrder(Node node)
        {
            // Return Condition 
            if (node == null)
            {
                return;
            }

            Stack<Node> nodeStack = new Stack<Node>();
            nodeStack.Push(root);


            while (nodeStack.Count > 0)
            {


                Node mynode = nodeStack.Pop();
                Console.Write(mynode.data + " ");


                if (mynode.rightChild != null)
                {
                    nodeStack.Push(mynode.rightChild);
                }
                if (mynode.leftChild != null)
                {
                    nodeStack.Push(mynode.leftChild);
                }
            }
        }

        public virtual void inOrder(Node node)
        {
            if (node == null)
                return;

            Stack<Node> stack = new Stack<Node>();
            Node current = node;


            while (current != null || stack.Count > 0)
            {


                while (current != null)
                {
                    stack.Push(current);
                    current = current.leftChild;
                }


                current = stack.Pop();

                Console.Write(current.data + " ");


                current = current.rightChild;
            }
        }

        public virtual void postOrder(Node node)
        {
            // Create two stacks 
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();


            if (node == null)
                return;

            // Push root to first stack 
            s1.Push(node);

            // Run while first stack is not empty 
            while (s1.Count > 0)
            {
                // Pop an item from s1 and Push it to s2 
                Node temp = s1.Pop();
                s2.Push(temp);

                // Push left and right children of removed item to s1 
                if (temp.leftChild != null)
                    s1.Push(temp.leftChild);
                if (temp.rightChild != null)
                    s1.Push(temp.rightChild);
            }

            // Print all elements of second stack 
            while (s2.Count > 0)
            {
                Node temp = s2.Pop();
                Console.Write(temp.data + " ");
            }
        }

        public virtual void levelOrder(Node node)
        {
            LinkedList<Node> q1 = new LinkedList<Node>();
            LinkedList<Node> q2 = new LinkedList<Node>();

            if (node == null)
            {
                return;
            }

            // Pushing first level node  
            // into first queue  
            q1.AddLast(node);

            // Executing loop till both the  
            // queues become empty  
            while (q1.Count > 0 || q2.Count > 0)
            {

                while (q1.Count > 0)
                {

                    // Pushing left child of current node  
                    // in first queue into second queue  
                    if (q1.First.Value.leftChild != null)
                    {
                        q2.AddLast(q1.First.Value.leftChild);
                    }

                    // pushing right child of current node  
                    // in first queue into second queue  
                    if (q1.First.Value.rightChild != null)
                    {
                        q2.AddLast(q1.First.Value.rightChild);
                    }

                    Console.Write(q1.First.Value.data + " ");
                    q1.RemoveFirst();
                }
                //Console.WriteLine();

                while (q2.Count > 0)
                {

                    // pushing left child of current node  
                    // in second queue into first queue  
                    if (q2.First.Value.leftChild != null)
                    {
                        q1.AddLast(q2.First.Value.leftChild);
                    }

                    // pushing right child of current  
                    // node in second queue into first queue  
                    if (q2.First.Value.rightChild != null)
                    {
                        q1.AddLast(q2.First.Value.rightChild);
                    }

                    Console.Write(q2.First.Value.data + " ");
                    q2.RemoveFirst();
                }
                //Console.WriteLine();
            }
        }

        public virtual void revert(Node node)
        {
            if (node == null)
                return;

            Queue<Node> q = new Queue<Node>();
            q.Enqueue(root);

            // Do BFS. While doing BFS, keep swapping 
            // left and right children 
            while (q.Count > 0)
            {
                // pop top node from queue 
                Node current = q.Peek();
                q.Dequeue();

                // swap left child with right child 
                Node temp = current.leftChild;
                current.leftChild = current.rightChild;
                current.rightChild = temp;

                // push left and right children 
                if (current.leftChild != null)
                    q.Enqueue(current.leftChild);
                if (current.rightChild != null)
                    q.Enqueue(current.rightChild);
            }
        }

        public virtual int getLeafCount(Node node)
        {
            if (node == null)
                return 0;
            if (node.leftChild == null && node.rightChild == null)
                return 1;
            else
                return getLeafCount(node.leftChild) + getLeafCount(node.rightChild);
        }

        public virtual int getNonLeafCount(Node node)
        {  
            if (node == null || (node.leftChild == null && node.rightChild == null))
                return 0;

            return 1 + getNonLeafCount(node.leftChild) +
                        getNonLeafCount(node.rightChild);
        }

        public virtual int getNodeCount(Node node)
        {
            return getNonLeafCount(node) + getLeafCount(node);
        }

        public virtual void clear(Node node)
        {
            if (node == null)
                return;

            // removing items in postorder
            clear(node.leftChild);
            clear(node.rightChild);
            Console.WriteLine("node " + node.data + " removed");
        }

        public virtual int sumLeftLeafs(Node node)
        {
            int s = 0;
            if(node != null)
            {
                if (isLeaf(node.leftChild))
                    s += node.leftChild.data;
                else
                    s += sumLeftLeafs(node.leftChild);
                s += sumLeftLeafs(node.rightChild);
            }
            return s;
        }

        public virtual Boolean isLeaf(Node node)
        {
            if (node == null)
                return false;
            if (node.leftChild == null && node.rightChild == null)
                return true;
            return false;
        }
    }
}
