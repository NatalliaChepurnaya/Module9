package by.epam.tr.mod9;

import by.epam.tr.mod9.Item;


public class CustomLinkedList<T> {
	private Item<T> head = null;
	private Item<T> tail = null;
	private int numberOfElements = 0;
	
	public static void main(String[] args){
		Number[] array = {2.5,1,100,0100,10L};
		CustomLinkedList<Number> test = new CustomLinkedList<Number>(array);
		
		System.out.println("Number of elements:");
		System.out.println(test.getNumberOfElements());
		System.out.println("Elements:");
		test.printList();
		
		System.out.println("Head:");
		System.out.println(test.getHead().getValue());
		System.out.println("Tail");
		System.out.println(test.getTail().getValue());
		
		System.out.println("New head:");
		test.setHead(89);
		test.printList();		
		System.out.println("New tail:");
		test.setTail(33);
		test.printList();
		
		System.out.println("Search:");
		Item<Number> srch = test.search(7);
		if (srch != null){
			System.out.println(srch.getValue());
		}
		else {
			System.out.println("Index is out of scope");
		}
		
		
		System.out.println("New element:");
		test.addElement(101,8);
		test.printList();
		
		System.out.println("Delete element:");
		test.deleteElement(100);
		test.printList();
		
		
		
	}
	
	public CustomLinkedList(T[] array){
		setHead(array[0]);
		tail = head;
		for(int i = 1;i < array.length;i++){
			setTail(array[i]);
		}
	}
	
	public Item<T> getHead(){
		return head;
	}
	
	public void setHead(T newHead){
		Item<T> oldHead = head;
		head = new Item<T>(newHead,oldHead);
		numberOfElements++;
	}
	
	public Item<T> getTail(){
		return tail;
	}
	
	public void setTail(T newTail){
		Item<T> oldTail = tail;
		Item<T> item = new Item<T>(newTail,null);
		oldTail.setNext(item);
		tail = item;
		numberOfElements++;
	}
	
	public int getNumberOfElements(){
		return this.numberOfElements;
	}
	
	public void printList(){
		Item<T> item = head;
		do {
			System.out.println(item.getValue());
			item = item.getNext();
		} while (item != tail);
		System.out.println(tail.getValue());
	}
	
	public void addElement(T elem,int index){
		Item<T> item;
		if (index == 1){
			setHead(elem);
		}
		else if (index == this.getNumberOfElements() + 1){
			setTail(elem);
		}
		else {
			Item<T> srch = this.search(index - 1);
			if (srch != null) {
				item = new Item<T>(elem,srch.getNext());
				srch.setNext(item);
			}
			else {
				System.out.println("New index element is out of scope");
			}
			
		}
		
	}
	
	public Item<T> search(int index){
		if (index >= 1 && index <= this.getNumberOfElements()){
			Item<T> item = head;
			for(int i = 1;i < index; i++){
				item = item.getNext();
			}
			return item;
		}
		else {
			return null;
		}
	}
	
	public void deleteElement(int index){
		Item<T> item;
		if (index == 1){
			head = head.getNext();
		}
		else {
			item = this.search(index - 1);
			if (index == this.getNumberOfElements()){
				tail = item;
				tail.setNext(null);
			}
			else {
				if (item != null) {
					item.setNext(item.getNext().getNext());
				}
				else {
					System.out.println("Required element is out of scope");
				}
			}	
		}
	}
	
	 
	
}
