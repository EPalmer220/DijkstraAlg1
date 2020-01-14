package com.company;

import java.util.ArrayList;

public class QueueArray<E> {
    //fields
    private ArrayList<E> arr;

    public QueueArray(){
        this.arr = new ArrayList<E>();
    }

    /**
     * Pushes an item onto the bottom/back of this queue.
     * @param item the Element to be pushed
     * @return item that was pushed
     */
    public E enqueue(E item){
        arr.add(arr.size()-1, item);
        return item;
    }

    /**
     * Removes the object at the top of this queue and returns that object as the value of this function.
     * @return item that was removed
     */
    public E dequeue(){
        if(arr.size() != 0){
            E valRemoved = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            return valRemoved;
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
        if(arr.size() != 0)
            return arr.get(0);
        else{
            System.out.println("\n* add items to the queue *");
            return null;
        }
    }

    /**
     * Outputs the queue order
     */
    public void display(){
        for(int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
    }

    /**
     * @return number of items in queue
     */
    public int size(){
        return arr.size();
    }

    /**
     * Checks if queue is currently empty
     * @return true if queue is empty, false if not
     */
    public boolean isEmpty(){
        if(arr.size() == 0)
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
