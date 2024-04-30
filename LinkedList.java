package linkedlist;

public class LinkedList <T>{
	
	private class Node<T>{
		private T data;
		private Node<T> next;
	}
	private int size;
	private Node<T> head;
	
	public LinkedList() {
		size = 0;
		head = null;
	}
	
	public void add(int index, T data) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		Node<T> newNode = new Node<>();
		newNode.data = data;
		if(index == 0) {
			newNode.next = head;
			head = newNode;
			size ++;
			return;
		}
		Node<T> temp = head;
		for(int i=0; i<index-1; i++)
			temp = temp.next;
		newNode.next = temp.next;
		temp.next =  newNode;
		size++;
	}
	
	public void addFirst(T data) {
		add(0,data);
	}
	public void add(T data) {
		addFirst(data);
	}
	public void addLast(T data) {
		add(size,data);
	}
	
	public void remove(int index) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(index == 0) {
			head = head.next;
			size--;
			return;
		}
		Node<T> temp = head;
		for(int i=0; i<index-1; i++)
			temp = temp.next;
		Node<T> temp2 = temp.next;
		temp.next = temp2.next;
		size --;
		
	}
	public void removeFirst() {
		remove(0);
	}
	public void removeLast() {
		remove(size-1);
	}
	public void remove() {
		removeLast();
	}
	
	public T get(int index) {
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node<T> temp = head;
		for(int i=0; i<index; i++)
			temp = temp.next;
		return temp.data;
	}
	public T getFirst() {
		return get(0);
	}
	public T getLast() {
		return get(size-1);
	}
	
	public void set(int index, T data) {
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node<T> temp = head;
		for(int i=0; i<index; i++)
			temp = temp.next;
		temp.data = data;
	}
	
	public void clear() {
		size = 0;
		head = null;
	}
	
	public boolean contains(T data) {
		Node<T> temp = head;
		for(int i=0; i<size; i++) {
			if(temp.data.equals(data))
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public String toString() {
		String str = "[";
		if(head == null)
			return str + "]";
		Node<T> temp = head;
		while(temp.next != null) {
			str = str + temp.data + ", ";
			temp = temp.next;
		}
		str = str + temp.data + "]";
		return str;
	}
	
	public void reverse() {
		Node<T> current = head;
		Node<T> prev = null;
		Node<T> next = head;
		for(int i = 0; i < size; i++) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
}
