using System;

namespace Stack_List_Implementation
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkedLIstStack stack = new LinkedLIstStack();
            stack.push(10);
            stack.push(15);
            stack.push(77);
            stack.push(0);
            stack.push(69);
            stack.push(13);

            Console.Write("Stack before deleting: ");
            stack.display();
            
            // print Top element of Stack  
            Console.Write("\nTop element is {0}\n", stack.peek());

            stack.pop();

            Console.Write("Stack after deleting: ");
            stack.display();

            // print Top element of Stack  
            Console.Write("\nTop element is {0}\n", stack.peek());
        }
    }
}
