import java.util.Comparator;

/**
 * @author prabhjot kaur
 * CS 212 - Project 4
 * File: Date212Comparator.java
 * Date: 15 December 2025
 * Date212Comparator
 *
 * A comparator for Date212 objects. This class allows
 * Date212 objects to be compared using the Comparator interface.
 * It simply delegates comparison to the Date212 compareTo method.
 */
class Date212Comparator implements Comparator <Date212>
{
	
	/**
     * Compares two Date212 objects by delegating to their compareTo method.
     *
     * @param d1 the first Date212 object
     * @param d2 the second Date212 object
     * @return a negative number if d1 < d2, 
     *         zero if they are equal,
     *         a positive number if d1 > d2
     */
	public int compare(Date212 d1, Date212 d2)
	{
		return d1.compareTo(d2);
	}
}