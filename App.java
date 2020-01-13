package StudentLibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) {
		Student[] students = null;
		Book[] books = null;

		ExecutorService service = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENT);
		
		try {
			books = new Book[Constants.NUMBER_OF_BOOKS];
			students = new Student[Constants.NUMBER_OF_STUDENT];
			
			for (int i = 0; i < Constants.NUMBER_OF_BOOKS; i++) {
				books[i] = new Book(i);
			}
			
			for (int i = 0; i < Constants.NUMBER_OF_STUDENT; i++) {
				students[i] = new Student(i, books);
				service.execute(students[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			service.shutdown();
		}
		finally {
			service.shutdown();
		}
	}
}
