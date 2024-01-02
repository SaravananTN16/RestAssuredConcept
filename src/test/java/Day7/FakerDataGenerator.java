package Day7;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	
	@Test
	void textGeneratorDummyData() {
		
		//add dependency like faker
		Faker faker = new Faker();
		
		
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		String username = faker.name().username();
		String password = faker.internet().password();
		
		String phoneNumber = faker.phoneNumber().phoneNumber();
		String safeEmailAddress = faker.internet().safeEmailAddress(); // generate email address
		
		System.out.println("This is my Full Name " + fullName);
		System.out.println("This is my firstName " + firstName);
		System.out.println("This is my lastName " + lastName);
		System.out.println("This is my userName " + username);
		System.out.println("This is my password " + password);
		System.out.println("This is my phoneNumber " + phoneNumber);
		System.out.println("This is my emailAddress " + safeEmailAddress);
		
	}

}
