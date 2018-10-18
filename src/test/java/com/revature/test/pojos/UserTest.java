package com.revature.test.pojos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pojos.User;

public class UserTest {

	private static User userTest;

	@Before
	public void setUp() throws Exception {
		userTest = new User(1001, "testing", "safepassword", "cook", "Spongebob", "Squarepants", "555 IQ Lane", false);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	/* TESTS FOR GETTERS */

	@Test
	public void testGetUsername() {
		assertEquals("Should equal the User username", "testing", userTest.getUsername());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("Should equal the User password", "safepassword", userTest.getPassword());

	}
	
	@Test
	public void testGetUserID() {
		assertEquals("Should equal the User userID", 1001, userTest.getUserId());
	}
	
	@Test
	public void testGetRole() {
		assertEquals("Should equal the User role", "cook", userTest.getRole());
	}
	
	@Test
	public void testGetfName() {
		assertEquals("Should equal the User first name", "Spongebob" , userTest.getfName());
	}
	
	@Test
	public void testGetlName() {
		assertEquals("Should equal the User last name", "Squarepants", userTest.getlName());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals("Should equal the User address", "555 IQ Lane", userTest.getAddress());
	}
	
	@Test
	public void testGetIsDeleted() {
		assertEquals("Should display true / false depending on the deletion status of the user", false, userTest.isDeleted());
	}
	
	/* TESTS FOR SETTERS */
	
	@Test
	public void testSetUsername() {
		userTest.setUsername("not testing");
		assertTrue("Should update the username for User", "not testing".equals(userTest.getUsername()));
	}
	
	@Test
	public void testSetPassword() {
		userTest.setPassword("unsafepassword");
		assertTrue("Should update the password for User", "unsafepassword".equals(userTest.getPassword()));
	}
	
	@Test
	public void testSetUserId() {
		userTest.setUserId(1002);
		assertTrue("Should update the userID", userTest.getUserId() == 1002);
	}
	
	@Test
	public void testSetRole() {
		userTest.setRole("critic");
		assertTrue("Should update the role for User", "critic".equals(userTest.getRole()));
	}
	
	@Test
	public void testSetfName() {
		userTest.setfName("Squidward");
		assertTrue("Should update the first name for User", "Squidward".equals(userTest.getfName()));
	}
	
	@Test
	public void testSetlName() {
		userTest.setlName("Tentacles");
		assertTrue("Should update the last name for User", "Tentacles".equals(userTest.getlName()));
	}
	
	@Test
	public void testSetAddress() {
		userTest.setAddress("100 HQ Drive");
		assertTrue("Should update the address for User", "100 HQ Drive".equals(userTest.getAddress()));
	}
	
	@Test
	public void testSetDeleted() {
		userTest.setDeleted(true);
		assertTrue("Should update the deleted status for User", userTest.isDeleted());
	}
	

}
