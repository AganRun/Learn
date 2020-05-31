package Charpter12_collection;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T t) {
        storage.addFirst(t);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.pop();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public int size() {
        return storage.size();
    }

    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("first");
        stack.push("second");
        log.info("first element: " + stack.peek());
        log.info("pop element: " + stack.pop());
        log.info("is empty: " + stack.empty());
        log.info("size: " + stack.size());
        log.info("stack:" + stack.toString());
    }
}
