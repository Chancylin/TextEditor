/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		
		//test empty list, remove should throw an exception
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		// test short list, first contents, then out of bounds
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		assertEquals("Check first", "A", shortList.remove(0));
		assertEquals("Remove: check size is correct ", 1, shortList.size());
		assertEquals("Check second", "B", shortList.remove(0));
		assertEquals("Remove: check size is correct ", 0, shortList.size());

		try {
			shortList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// skip the test longer list, redundant
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		//test empty list, get should throw an exception
		try {
			emptyList.add(null);
			fail("Check add null");
		}
		catch (NullPointerException e) {
		
		}
		emptyList.add(0, 1);
		assertEquals("Check first", (Integer) 1, emptyList.get(0));
		assertEquals("Remove: check size is correct ", 1, emptyList.size());
		
		// short list
		shortList.add("C"); //ABC
		assertEquals("Check new last", "C", shortList.get(2));
		assertEquals("Check new second last", "B", shortList.get(1));
		assertEquals("Remove: check size is correct ", 3, shortList.size());
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Remove: check size is correct ", 0, emptyList.size());
		assertEquals("Remove: check size is correct ", 2, shortList.size());
			
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		
		//test empty list, get should throw an exception
		try {
			emptyList.add(-1, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		// add null
		try {
			emptyList.add(0, null);
			fail("Check add null");
		}
		catch (NullPointerException e) {
		
		}
		
		emptyList.add(0, 1);
		assertEquals("Check first", (Integer) 1, emptyList.get(0));
		assertEquals("Remove: check size is correct ", 1, emptyList.size());
		
		// test short list, first contents, then out of bounds
		try {
			shortList.add(3, "C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		// case 1: add to the first
		shortList.add(0, "a");
		assertEquals("Check new first", "a", shortList.get(0));
		assertEquals("Check new second", "A", shortList.get(1));
		assertEquals("Remove: check size is correct ", 3, shortList.size());
		// case 2: add to the end
		shortList.add(3, "C"); //aABC
		assertEquals("Check new last", "C", shortList.get(3));
		assertEquals("Check new second last", "B", shortList.get(2));
		assertEquals("Remove: check size is correct ", 4, shortList.size());
		// case 3: add to the middle
		shortList.add(2, "b"); //aAbBC
		assertEquals("Check new middle", "b", shortList.get(2));
		assertEquals("Check the middle pre", "A", shortList.get(1));
		assertEquals("Check the middle next", "B", shortList.get(3));
		assertEquals("Remove: check size is correct ", 5, shortList.size());

		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		//test empty list, get should throw an exception
		try {
			int tmp = emptyList.set(-1, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		//
		// test short list, first contents, then out of bounds
		try {
			String tmp = shortList.set(-1, "a");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			String tmp = shortList.set(3, "C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		assertEquals("Check replaced element, first", "A", shortList.set(0, "a"));
		assertEquals("Check new first", "a", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		assertEquals("Remove: check size is correct ", 2, shortList.size());
		
		assertEquals("Check replaced element, last", "B", shortList.set(1, "b"));
		assertEquals("Check new last", "b", shortList.get(1));
		assertEquals("Check first", "a", shortList.get(0));
		assertEquals("Remove: check size is correct ", 2, shortList.size());
		
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element replaced", (Integer)i, longerList.set(i, i+1));
			assertEquals("Check "+i+ " element new", (Integer) (i+1), longerList.get(i));
			
		}
		
		assertEquals("Remove: check size is correct ", LONG_LIST_LENGTH, longerList.size());
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	@Test
	public void testToString() {
		assertEquals("Check empty list", "", emptyList.toString());
		assertEquals("Check short list", "A B ", shortList.toString());
		assertEquals("Check list", "65 21 42 ", list1.toString());
		// System.out.println("empty list:" + emptyList);
		// System.out.println("short list:" + shortList);
		// System.out.println("list 1:" + list1);
		
		
		
	}
	
}
