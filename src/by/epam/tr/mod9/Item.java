package by.epam.tr.mod9;

public class Item<T> {
	private T value;
	private Item<T> next;
	
	public Item (T value,Item<T> next){
		this.value = value;
		this.next = next;
	}
	
	public T getValue(){
		return this.value;
	}
	
	public void setValue(T _value){
		value = _value;
	}
	
	public Item<T> getNext(){
		return this.next;
	}
	
	public void setNext(Item<T> _next){
		next = _next;
	}
	
	public String toString(Item<T> item){
		return item.getValue().toString();
	}

	

}
