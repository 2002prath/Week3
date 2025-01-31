package Stack;
    import java.util.Stack;

public class QueueCreation {



        Stack<Integer> inputStack;
        Stack<Integer> outputStack;

        // Constructor
        public QueueCreation() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        // Enqueue operation
        public void enqueue(int x) {
            inputStack.push(x);
        }

        // Dequeue operation
        public int dequeue() {
            if (outputStack.isEmpty()) {
                if (inputStack.isEmpty()) {
                    throw new RuntimeException("Queue is empty");
                }
                // Transfer elements from inputStack to outputStack
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.pop();
        }

        // Peek operation (returns front without removing)
        public int peek() {
            if (outputStack.isEmpty()) {
                if (inputStack.isEmpty()) {
                    throw new RuntimeException("Queue is empty");
                }
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }

        // Main method for testing
        public static void main(String[] args) {
            QueueCreation queue = new QueueCreation();

            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            System.out.println("Dequeued: " + queue.dequeue()); // 1
            System.out.println("Front element: " + queue.peek()); // 2

            queue.enqueue(4);
            System.out.println("Dequeued: " + queue.dequeue()); // 2
            System.out.println("Dequeued: " + queue.dequeue()); // 3
            System.out.println("Dequeued: " + queue.dequeue()); // 4

            System.out.println("Is queue empty? " + queue.isEmpty()); // true
        }
    }


