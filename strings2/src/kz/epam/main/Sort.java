package kz.epam.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
/**
 * <h1>Class for sorting the splitted text into sentences by word count (ASC)</h1>
 * 
 * @version 1.0
 * @author MRSPEC
 *
 */
public class Sort {
	private String text;
	private List<List> listSentences;
    	private List<List> listWords;
    	private List<String> listCharacters;

	private Map<Integer, List> list = new HashMap<Integer, List>();
    	private List sortedKeys;
	private ListIterator iterator;
	
	public Sort() {

	}
	
	public Sort(String fileName) throws IOException {
		this.text = FileReader.readFile(fileName, Charset.defaultCharset());
	}
	
	/**
	 * Set the text from the file
	 * @param fileName
	 * @throws IOException
	 */
	public void setText(String fileName) throws IOException {
		this.text = FileReader.readFile(fileName, Charset.defaultCharset());
	}
	public void setText(String fileName, Charset charset) throws IOException {
		this.text = FileReader.readFile(fileName, charset);
	}

    /**
     * <p>Remove spaces if they are more than one</p>
     */
    public void trim() {
        text = text.replaceAll("(\\s)(\\s+)", " ");
    }


    /**
     * <p>Splitting the word into characters</p>
     * @param word
     * @return the aggregate of characters in the word
     */
    private List splitCharacters(String word) {
        int aggregateCharacters = 0;

        listCharacters = new ArrayList<String>();

        char[] characters = word.toCharArray();

        for (char ch : characters) {
            listCharacters.add(String.valueOf(ch));
        }

        return listCharacters;
    }

    /**
     * <p>Counting the words and adding to the list</p>
     * @param splittedWords
     * @return the aggregate of words
     */
	private int splitWords(String[] splittedWords) {
	        int count = 0;
	        listWords = new ArrayList<List>();
	
	        for(String word : splittedWords) {
	            listWords.add(splitCharacters(word));
	            count++;
	        }
	
	        return count;
	}
	
	/**
	 * <p>Split the text into the sentences, and key is the word count</p>
	 */
	public void splitText() {
		String[] sentences = text.split("(?<=[.?!;])\\s+(?=\\p{Lu})");
		
		for(String sentence : sentences) {
			String[] splittedWords = sentence.split("[\\s]+");
			
			/** Counting the words and adding to the list **/
            		int wordCount = this.splitWords(splittedWords);

            		listSentences = new ArrayList<List>();
            		listSentences.add(listWords);

            		list.put(wordCount, listSentences);
		}	
	}
	
	/**
	 * <p>Sorting list key by ASC</p>
	 */
	public void sort() {
		if (!list.isEmpty()) {
			sortedKeys=new ArrayList(list.keySet());
			Collections.sort(sortedKeys);
			iterator = sortedKeys.listIterator();
		} else {
			System.out.println("Nothing to sort here");
		}
	}
	
	/**
	 * <p>Unpacking the sorted list into lines sentences</p>
	 */
	public void getSortedList() {
		while(iterator.hasNext()) {
			List<List> sentences = list.get(iterator.next());
	            	for (List sentence : sentences) {
	                	List<List> words = sentence;
	
	        		 for (List word : words) {
	                    		List<List> characters = word;
	                    		for (int i = 0; i < characters.size(); i++) {
	                        		System.out.print(characters.get(i));
	                    		}
	                    		
	                    		System.out.print(" ");
	                	}
	
	                	System.out.println();
	
	            	}	
		}
	}
}
