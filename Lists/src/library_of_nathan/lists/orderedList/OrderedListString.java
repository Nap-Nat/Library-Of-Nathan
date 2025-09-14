/**
 * 
 */
package library_of_nathan.lists.orderedList;

/**
 * Creates an array of modular size that keep elements in the order they were put in.
 * Elements can be added to any section of the list and push elements down to compensate.
 * TODO Elements can be removed from any section of the list and elements move up to compensate.
 * TODO Elements can be found in the list and either return boolean or index 
 * @author Nathan Potter
 */
public class OrderedListString {

	// Fields -----------------------------------------------------
	// ------------------------------------------------------------
	
	/** The array of Strings in the list */
	private  String[] list;
	/** The size of the list */
	private int size;
	
	
	// Constructors -----------------------------------------------
	// ------------------------------------------------------------
	
	/**
	 * Makes a new blank list
	 */
	public OrderedListString() {
		list = new String[0];
		size = 0;
	}
	
	/**
	 * Makes a list with one element (input)
	 * @param input : The inputed String element
	 */
	public OrderedListString(String input) {
		list = new String[1];
		list[0] = input;
		size = 1;
	}
	
	/**
	 * Makes a list based on a given String array
	 * @param input : The inputed String array
	 */
	public OrderedListString(String[] input) {
		list = input;
		size = input.length;
	}

	// Getters and Setters -----------------------------------------
	// ------------------------------------------------------------
	
	/**
     * Returns the ID value of the list
     * @return the ID value of the list
     */
	public String[] getListID() {
		return list;
	}

	
	/**
	 * Returns the size of the list
	 * @return the size of the list
	 */
	public int length() {
		return size;
	}
	
	
	// Methods ------------------------------------------------
	// ------------------------------------------------------------
	
	/**
	 * Adds a string to the end of the list
	 * @param adding : The value to be added to the list
	 * @throws IllegalArgumentException : If the input is null
	 */
	public void add(String adding) throws IllegalArgumentException {
		
		//Invalid Checks ---------------------
		if(adding == null) {
			throw new IllegalArgumentException("Null input.");
		}
		
		
		//Variables ---------------------------
		String [] newList = new String[size + 1];
		
		
		// Functions -------------------------
		for(int i = 0; i < size; i++) {
			newList[i] = list[i];
		}
		
		newList[size] = adding;
		
		//Results -----------------------
		list = newList;
		size++;
		
	}
	
	
	/**
	 * Adds an string to the list at the index inputed while keeping everything else in order
	 * @param adding : The value to be added to the list
	 * @param index : The index where the value should be added
	 * @throws IllegalArgumentException : If the input is null or the index is outOfBounds
	 */
	public void add(String adding, int index) throws IllegalArgumentException {
		
		
		//Invalid Checks --------------------
		if(adding == null) {
			throw new IllegalArgumentException("Null input.");
		}
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("Index is not within range.");
		}
		
		
		//Variables --------------------------
		String [] newList = new String[size + 1];
		int j = 0;
		
		
		//Function ---------------------------
		//Continuously counts down the new list 
		//while the old list waits when the new element's index comes up
		for(int i = 0;  i < size + 1; i++) {
			
			if(i != index) {
				newList[i] = list[j];
				j++;
			}
			else {
				newList[i] = adding;
			}
			
		}

		//Effect -----------------------------
		list = newList;
		size++;
		
		
	}
	
}
