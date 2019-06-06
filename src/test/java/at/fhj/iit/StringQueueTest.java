package at.fhj.iit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class StringQueueTest {
	public StringQueue q;

	@Before
	public void setup() throws Exception {
		q = new StringQueue(5);
	}

	@Test
	/**
	 * tries to poll an element from an empty queue.
	 * 
	 * @throws Exception
	 */
	public void testPollIsNull() throws Exception {
		assertTrue(q.poll() == null);
	}

	/**
	 * tries to remove an element from an empty queue. Must throw
	 * NoSuchElementException
	 * 
	 * @throws Exception
	 */
	@Test(expected = NoSuchElementException.class)
	public void testPopFromEmptyStack() throws Exception {
		q.remove();
	}

}
