import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	
	
	public static void main(String[] args) {
		
		Queue<Book> myQueue = new LinkedList<Book>();
		
		myQueue.add(new Book("Book1", "Author1"));
		myQueue.add(new Book("Book2", "Author2"));
		myQueue.add(new Book("Book3", "Author3"));
		myQueue.add(new Book("Book4", "Author4"));

		
		System.out.println(myQueue.size());
		
//		Iterator<Book> iterator = myQueue.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(myQueue.remove());
//		}
		
//		while(myQueue.size() > 0) {
//			System.out.println(myQueue.remove());
//		}

	}
}

class Book {
	private String bookName;
	private String author;
	
	
	public Book(String bookName, String author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + "]";
	}
	
	
}
