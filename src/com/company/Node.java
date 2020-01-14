package com.company;

public class Node <E> {
    //fields
    private E data;
    private Node pointer;

    /**
     * Default constructor
     */
    public Node(){
        this.data = null;
        this.pointer = null;
    }

    /**
     * constructor w/ specified E data
     * @param data the E to be passed to this.data
     */
    public Node(E data){
        this.data = data;
        this.pointer = null;
    }

    // pointer setter and getter

    /**
     * Sets this.pointer to specified Node
     * @param pointer the Node that this.pointer is set to
     */
    public void setPointer(Node pointer){
        this.pointer = pointer;
    }

    /**
     * @return Node's pointer
     */
    public Node getPointer(){
        return this.pointer;
    }

    // data setter and getter

    /**
     * @return Node's data
     */
    public E getData(){
        return this.data;
    }

    /**
     * Sets this.data to specified E
     * @param newData the E that this.data is set to
     */
    public void setData(E newData){
        this.data = newData;
    }

}
