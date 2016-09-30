package tiy.invictus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventContactApplicationTests {
	@Autowired
	EventRepository events;

	@Autowired
	UserRepository users;

	@Autowired
	ContactRequestRepository contacts;

	@Autowired
	CheckedInRepository checkedInRepos;

	Database myDB = new Database(users, events);

	@Test
	public void login() throws Exception {
		User myUser = new User("sharifa", "chin",  "test@tiy.com", "hello");
		User tester = new User();
		tester = myDB.login(myUser);

		System.out.println("tester: " + tester.firstName);
		System.out.println("myUser: " + myUser.firstName);
	}

	@Test
	public void register() throws Exception {
		User user = new User("brice", "blanch", "brice@tiy.com", "hello");
		User tester = new User();
		if (user == null) {
			throw new Exception("Unable to add game without an active user in the session");
		}

		users.save(user);
//		tester = myController.register("brice", "blanch","brice@tiy.com", "hello");

//		System.out.println(tester);
	}

}
