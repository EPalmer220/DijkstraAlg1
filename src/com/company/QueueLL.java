package com.company;

public class QueueLL<E> {
    //fields
    private Node head;

    public QueueLL(){
        this.head = null;
    }

    /**
     * Pushes an item onto the bottom/back of this queue.
     * @param item the Element to be pushed
     * @return item that was pushed
     */
    public E enqueue(E item){
        if(head != null){
            Node tempNode = head;
            Node newNode = new Node(item);

            // iterates through until last node, allowing for a term to be added
            while(tempNode.getPointer() != null){
                tempNode = tempNode.getPointer();
            }
            tempNode.setPointer(newNode);
            return item;
        }
        else{
            head = new Node(item);
            return item;
        }
    }

    /**
     * Removes the object at the top of this queue and returns that object as the value of this function.
     * @return item that was removed
     */
    public E dequeue(){
        if(head != null){

            // if head is NOT the only node in the queue
            if(head.getPointer() != null){
                E valRemoved = (E) this.head.getData();
                Node secondNode = head.getPointer(); // used to shift down elements in queue
                head.setData(secondNode.getData());
                head.setPointer(secondNode.getPointer());
                return valRemoved;
            }

            // if head is the only node in the queue
            else{
                E valRemoved = (E) this.head.getData();
                this.head = null;
                return valRemoved;
            }

        }
        else{
            System.out.println("\n* add items to the queue *");
            return null;
        }
    }

    /**
     * Looks at the object at the top of this queue without removing it from the queue.
     * @return object at top of queue
     */
    public E peek(){
        if(head == null){
            System.out.println("\n* add items to the queue *");
            return null;
        }
        else
            return (E) head.getData();
    }

    /**
     * Outputs the queue order
     */
    public void display(){
        Node tempNode = head;
        String strList = "";

        if(tempNode != null){

            // iterates through queue and records data of each node
            while(tempNode.getPointer() != null){
                strList += tempNode.getData() + "\n";
                tempNode = tempNode.getPointer();
            }
            strList += tempNode.getData();
            System.out.println(strList);
        }

        else{
            System.out.println("* The queue is empty! Add terms to display them. *");
        }
    }

    /**
     * @return number of items in queue
     */
    public int size(){
        if(head != null){
            int numItems = 1;
            Node tempNode = head;

            // iterates through queue, incrementing number of elements
            while(tempNode.getPointer() != null){
                tempNode = tempNode.getPointer();
                numItems++;
            }
            return numItems;
        }

        else
            return 0;
    }

    /**
     * Checks if queue is currently empty
     * @return true if queue is empty, false if not
     */
    public boolean isEmpty(){
        if(this.head == null)
            return true;
        return false;
    }
}


/*
E enqueue(E item) - Pushes an item onto the bottom/back of this queue.
E dequeue() - Removes the object at the top of this queue and returns that object as the value of this function.
E peek()- Looks at the object at the top of this queue without removing it from the queue.
void display() - Outputs the queue order
int size() - Returns number of items in the queue
boolean isEmpty - Checks if queue is currently empty
 */