using System;

namespace Queue_Implemented_With_LinkedList
{
    class Program
    {
        static void Main(string[] args)
        {
            // create the queue and add some element
            Queue queue = new Queue();
            queue.addElement(5);
            queue.addElement(44);
            queue.addElement(12);
            queue.addElement(9);
            queue.addElement(36);
            queue.addElement(79);

            Console.Write("queue : ");
            print(queue.front);
            Console.WriteLine("\nQueue front before deleting: " + queue.front.data);
            Console.WriteLine("Queue rear before deleting: " + queue.rear.data);


            queue.deleteElement();


            Console.Write("\nqueue after deleting: ");
            print(queue.front);
            Console.WriteLine("\nQueue front after deleting: " + queue.front.data);
            Console.WriteLine("Queue rear after deleting: " + queue.rear.data);
        }


        // a utility function to print the queue with recursion
        public static void print(QueueNode node)
        {
            if (node == null)
                return;

            Console.Write(node.data + "   ");
            print(node.next);
        }
    }


    // a linked list node that store an integer as data
    class QueueNode
    {
        public int data;
        public QueueNode next;

        // constructor
        public QueueNode(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    /*
     *   this class represent the queue
     * front stores the front node
     * and rear stores the rear node
     */
    class Queue
    {
        public QueueNode front, rear;
        public Queue()
        {
            this.front = null;
            this.rear = null;
        }

        // function to add a element to the queue
        public void addElement(int element)
        {
            QueueNode tmp = new QueueNode(element);


            // If queue is empty, then new 
            // node is front and rear both 
            if (this.rear == null)
            {
                this.front = this.rear = tmp;
                return;
            }

            // Add the new node at end of queue and change rear 
            this.rear.next = tmp;
            this.rear = tmp;
        }

        // method to delete an element from the queue
        public void deleteElement()
        {
            // returning NULL if queue is empty
            if (this.front == null)
                return;

            // Store previous front move front one node ahead 
            QueueNode tmp = this.front;
            this.front = this.front.next;

            // If front becomes NULL, then change rear also as NULL 
            if (this.front == null)
                this.rear = null;
        }
    }
}
