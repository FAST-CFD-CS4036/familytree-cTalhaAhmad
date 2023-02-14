package bll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dal.PersonDAOStub;

class PersonBOTests {
	
	static PersonDAOStub stub;
	static PersonBO bo;

//	@BeforeEach
//	void init() {
//		stub = new PersonDAOStub();
//		bo = new PersonBO(stub);
//	}
	
	@BeforeAll
	static void coldStart() {
		stub = new PersonDAOStub();
		bo = new PersonBO(stub);
	}
	
	@Test
	@DisplayName ("When Father and Mother are Same")
	void testIsSibling() {		
		Assertions.assertTrue(bo.isSibling(3, 4));
	}
	
	@Test
	@DisplayName ("When Father and Mother are not Same")
	void testIsSibling2() {
		Assertions.assertFalse(bo.isSibling(1, 8));
	}
	
	@Test
	@DisplayName ("When Father and Mother are not Same")
	void testIsSibling3() {
		Assertions.assertFalse(bo.isSibling(3, 7));
	}
	
	@Test
	@DisplayName ("When Father and Mother are not Same")
	void testIsSibling4() {
		Assertions.assertFalse(bo.isSibling(4, 5));
	}
	
	@Test
	@DisplayName ("Half Sibling on Father Side")
	void testIsHalfSibling() {		
		Assertions.assertFalse(bo.isHalfSibling(5, 6));
	}
	
	@Test
	@DisplayName ("Half Sibling on Mother Side")
	void testIsHalfSibling2() {
		Assertions.assertTrue(bo.isHalfSibling(7, 8));
	}
	
	@Test
	@DisplayName ("Not Half Sibling on Father Side")
	void testIsHalfSibling3() {
		Assertions.assertFalse(bo.isHalfSibling(1, 2));
	}
	
	@Test
	@DisplayName ("Not Half Sibling on Mother Side")
	void testIsHalfSibling4() {
		Assertions.assertFalse(bo.isHalfSibling(3, 4));
	}
}


// class activity 14 feb 23 > is half sibling + is sibling k 4,4 functions