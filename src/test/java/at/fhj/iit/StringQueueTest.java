package at.fhj.iit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class StringQueueTest {
    public StringQueue q;
    private int maxSize = 5;

    @Before
    public void setup() throws Exception {
        q = new StringQueue(maxSize);
    }


    /**
     * Tries to add more items to the queue as the maximum size of the queue is.
     * Checks the return value if each method call.
     * The last method call must return false,
     * all other must return true.
     */
    @Test
    public void testOfferMaxSize() {

        for (int i = 0; i < maxSize; i++) {
            assertTrue(q.offer(Integer.toString(i)));
        }
        assertFalse(q.offer("Overflow"));
    }

    //---------- Tests with poll() ----------

    /**
     * Tries to poll an element from an empty queue.
     * This element must be null.
     */
    @Test
    public void testPollIsNull() {
        assertTrue(q.poll() == null);
    }


    /**
     * A teststring is added to the queue.
     * The result of poll must be the teststring.
     * The result of the poll of an empty queue must be null.
     */
    @Test
    public void testOneStringWithPoll1() {
        final String testString = "TestString!?12315_-*!§";
        q.offer(testString);
        assertTrue(q.poll() == testString);
        assertTrue(q.poll() == null);
    }

    /**
     * A teststring is added to the queue.
     * The result of poll must be the teststring.
     * The result of the poll of an empty queue must be null.
     */
    @Test
    public void testOneStringWithPoll2() {
        final String testString = "Houston, we have a problem!";
        q.offer(testString);
        assertTrue(q.poll() == testString);
        assertTrue(q.poll() == null);
    }


    /**
     * Puts a sequence of numbers in the queue, then polls all the elements.
     * Sequence must be the same.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithNumbers1() {
        for (int i = 0; i < maxSize; i++) {
            assertTrue(q.offer(Integer.toString(i)));
        }

        for (int i = 0; i < maxSize; i++) {
            assertTrue(q.poll().equals(Integer.toString(i)));
        }

        assertTrue(q.poll() == null);
    }

    /**
     * Puts a sequence of numbers in the queue, then polls all the elements.
     * Sequence must be the same.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithNumbers2() {
        for (int i = maxSize; i > 0 ; i--) {
            assertTrue(q.offer(Integer.toString(i)));
        }

        for (int i = maxSize; i > 0 ; i--) {
            assertTrue(q.poll().equals(Integer.toString(i)));
        }

        assertTrue(q.poll() == null);
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * poll() must return the combination of strings and numbers in the same sequence.
     * One more element is polled than putted. This element must be null.
     */
    @Test
    public void testSequencePollWithStrings() {
        final String[] testStrings = {"May the source be with you!", "So much to code, so little time :-)", " ", "!§$%&/()=?[]{}", "Kill Bill Vol. 2", "63458tr!z7h49_", "pulp", "FICTION"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize; i++) {

            assertTrue(q.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        arrayIndex = 0;
        for (int i = 0; i < maxSize; i++) {

            assertTrue(q.poll().equals(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }
        assertTrue(q.poll() == null);
    }

    //---------- Tests with remove() ----------

    /**
     * Tries to remove an element from an empty queue. Must throw
     * NoSuchElementException.
     *
     * @throws Exception
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyQueue() {
        q.remove();
    }

    /**
     * A teststring is added to the queue.
     * The result of remove must be the teststring.
     * The result of the remove of an empty queue must be an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOneStringWithRemove() {
        final String testString = "bla bla bla & bla 1234";
        q.offer(testString);
        assertTrue(q.remove().equals(testString));
        q.remove();
    }

    /**
     * A teststring is added to the queue.
     * The result of remove must be the teststring.
     * The result of the remove of an empty queue must be an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOneStringWithRemove2() {
        final String testString = "Oh behave, baby!";
        assertTrue(q.remove().equals(testString));
        q.remove();
    }

    /**
     * Puts a sequence of numbers in the queue, then removes all the elements.
     * Sequence must be the same.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithNumbers1() {
        for (int i = 0; i < maxSize; i++) {
            assertTrue(q.offer(Integer.toString(i)));
        }

        for (int i = 0; i < maxSize; i++) {
            assertTrue(q.remove().equals(Integer.toString(i)));
        }

        q.remove();
    }

    /**
     * Puts a sequence of numbers in the queue, then removes all the elements.
     * Sequence must be the same.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithNumbers2() {
        for (int i = maxSize; i > 0 ; i--) {
            assertTrue(q.offer(Integer.toString(i)));
        }

        for (int i = maxSize; i > 0 ; i--) {
            assertTrue(q.remove().equals(Integer.toString(i)));
        }

        q.remove();
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * remove() must return the combination of strings and numbers in the same sequence.
     * One more element is removed than putted. This element must throw an exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testSequenceRemoveWithStrings() {
        final String[] testStrings = {"I'll be back!", "Talk to the hand!", "I need your clothes, your boots and your motorcycle!", "Hast la vista, Baby!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize; i++) {

            assertTrue(q.offer(i + testStrings[arrayIndex]));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        arrayIndex = 0;
        for (int i = 0; i < maxSize; i++) {

            assertTrue(q.remove().equals(i + testStrings[arrayIndex]));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }
        q.remove();
    }

    //---------- Tests with peek() ----------

    /**
     * Tries to peek into an empty queue.
     * This element must be null.
     */
    @Test
    public void testPeekIsNull() {
        assertTrue(q.peek() == null);
    }

    /**
     * A teststring is added to the queue.
     * The result of peek() must be the teststring.
     */
    @Test
    public void testOneStringWithPeek1() {
        final String testString = "Who is Zed? Zed`s dead, baby!";
        q.offer(testString);
        assertTrue(q.peek() == testString);
    }

    /**
     * A teststring is added to the queue.
     * The result of peek() must be the teststring.
     */
    @Test
    public void testOneStringWithPeek2() {
        final String testString = "E.T. nach Hause telefonieren!";
        q.offer(testString);
        assertTrue(q.peek() == testString);
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * peek() must show the very first element.
     */
    @Test
    public void testSeveralStringsWithPeek() {
        final String[] testStrings = {"Ein Big Mac ist ein Big Mac, aber die nennen ihn Le Big Macke!", "Ich bin Mr. Wolf. Ich löse Probleme.", "Hamburger! Der Grundstein eines jeden nahrhaften Frühstücks!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize; i++) {

            assertTrue(q.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        assertTrue(q.peek().equals(testStrings[0]+"0"));
    }

    //---------- Tests with element() ----------

    /**
     * Uses element() on an empty queue, must throw exception.
     * @throws Exception
     */
    @Test(expected = NoSuchElementException.class)
    public void testElementIsNull() {
        q.element();
    }

    /**
     * A teststring is added to the queue.
     * The result of element() must be the teststring.
     */
    @Test
    public void testOneStringWithElement1() {
        final String testString = "Who is Zed? Zed`s dead, baby!";
        q.offer(testString);
        assertTrue(q.element().equals(testString));
    }

    /**
     * A teststring is added to the queue.
     * The result of element() must be the teststring.
     */
    @Test
    public void testOneStringWithElement2() {
        final String testString = "Möge die Macht mit dir sein!";
        q.offer(testString);
        assertTrue(q.element().equals(testString));
    }

    /**
     * Adds a combination of strings and numbers to the queue.
     * element() must show the very first element.
     */
    @Test
    public void testSeveralStringsWithElement() {
        final String[] testStrings = {"Ein Big Mac ist ein Big Mac, aber die nennen ihn Le Big Macke!", "Ich bin Mr. Wolf. Ich löse Probleme.", "Hamburger! Der Grundstein eines jeden nahrhaften Frühstücks!"};
        int arrayIndex = 0;

        for (int i = 0; i < maxSize; i++) {

            assertTrue(q.offer(testStrings[arrayIndex] + i));

            if (arrayIndex + 1 >= testStrings.length) {
                arrayIndex = 0;
            } else
                arrayIndex++;
        }

        assertTrue(q.element().equals(testStrings[0]+"0"));
    }
}
