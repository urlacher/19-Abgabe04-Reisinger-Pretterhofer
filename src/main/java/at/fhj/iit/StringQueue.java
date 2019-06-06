package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE


/**
 * Queue Implementation of <code>Queue</code> Interface.
 * supports String Values and can be initialized with a maximum number
 * of items.
 *
 * @author Florian Reisinger und Thomas Pretterhofer
 * @version 1.0
 *
 * @see Queue
 */
public class StringQueue implements Queue {

	//private static final Logger logger = LogManager.getLogger(StringStack.class);
	/**
	 * stores the string values of this queue
	 */
	private List<String> elements = new ArrayList<String>();

	/**
	 * defines the maximum size of the queue
	 */
	private int maxSize = 5;

	/**
	 * Constructor that initialize the queue and delimit the
	 * maximum size.
	 *
	 * @param maxSize the maxium size of the queue
	 */
	public StringQueue(int maxSize){
		this.maxSize = maxSize;
	}


	/**
	 * The function "offer" adds a String, which is
	 * given as an parameter. If the queue size
	 * is smaller then the maximum size, then the
	 * String will be added and the function returns
	 * "true". Otherwise the String won't be added
	 * and the function returns "false".
	 *
	 * @param obj	the String-parameter which will
	 *              be added to the queue of this
	 *              instance.
	 *
	 * @return The return value is a boolean,
	 * if the functions succeded or not.
	 */
	@Override
	public boolean offer(String obj) {
		if(elements.size()!= maxSize)
			elements.add(obj);
		else
			return false;
		
		return true;
	}


	/**
	 * The function "poll" picks the String from
	 * the head of the queue, saves it to a
	 * String variable, deletes the String in the
	 * queue and returns the deleted String.
	 *
	 * @return The function returns a String
	 * from the Head of the queue.
	 */
	@Override
	public String poll() {
		String element = this.peek();
		
		if(elements.size() > 0){
			elements.remove(0);
		}
		
		return element;
	}


	/**
	 * The function calls the function "poll()"
	 * which removes the String from the head
	 * from the queue. Additionally this
	 * function checks if the element is null,
	 * which means the queue is empty.
	 *
	 * @return The function returns a String
	 * from the Head of the queue.
	 */
	@Override
	public String remove() {
		String element = this.poll();
		//element = "";
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

	/**
	 * The function "peek" picks the String from
	 * the head of the queue, checks before if the
	 * queue has an element or not.
	 *
	 * @return The function returns a String
	 * from the Head of the queue or null,
	 * if the queue is empty.
	 */
	@Override
	public String peek() {
		String element;
		if(elements.size() > 0)
			element = elements.get(0);
		else
			element = null;
		
		return element;
	}

	/**
	 * The function "element" calls the
	 * function "peek" which returns an
	 * element or null.
	 *
	 * @return The function returns a String
	 * from the head of the queue or an
	 * exception if the queue is empty
	 */
	@Override
	public String element() {
		String element = peek();
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}


	//Just to test
	public static void main(String[] args) {
		StringQueue stringQueue = new StringQueue(9);
		stringQueue.elements.add("A");
		stringQueue.elements.add("B");
		stringQueue.elements.add("C");
		stringQueue.remove();
		System.out.printf("%s", stringQueue.peek());
	}
}