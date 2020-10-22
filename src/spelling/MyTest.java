package spelling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

	private String dictFile = "data/words.small.txt"; 

	AutoCompleteDictionaryTrie emptyDict; 
	AutoCompleteDictionaryTrie smallDict;
	AutoCompleteDictionaryTrie largeDict;
	
	@Before
	public void setUp() throws Exception 
	{
		emptyDict = new AutoCompleteDictionaryTrie();
		smallDict = new AutoCompleteDictionaryTrie();
		largeDict = new AutoCompleteDictionaryTrie();

		smallDict.addWord("Hello");
		// System.out.println("add hello correctly");
		smallDict.addWord("HElLo");
		// System.out.println("add HElLo correctly");
		smallDict.addWord("help");
		// System.out.println("add help correctly");
		smallDict.addWord("he");
		smallDict.addWord("hem");
		smallDict.addWord("hot");
		smallDict.addWord("hey");
		smallDict.addWord("a");
		smallDict.addWord("subsequent");
		
		//DictionaryLoader.loadDictionary(largeDict, dictFile);
	}

	@Test
	public void testAddWord()
	{	
		// assertEquals("Asserting hellow is not in small dict", false, smallDict.isWord("hellow"));
		System.out.println("start adding hellow");
		smallDict.addWord("hellow");
		System.out.println("add hellow correctly");
		assertEquals("Asserting hellow is in small dict", true, smallDict.isWord("hellow"));

	}

}
