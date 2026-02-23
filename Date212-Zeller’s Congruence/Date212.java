/**
 * @author prabhjot kaur
 * 	Date212 
 * CS 212 - Project 4
 * File: Date212.java
 * Date: 15 December 2025
 * 
 * This class represents a date in the format YYYYMMDD.
 * It provides methods to compare dates, convert to string format,
 * and sort an array of Date212 objects using selection sort.
 * */
class Date212
{
	private int year;
	private int month;
	private int day;
	private String fileFormat;

	/**
     * Constructs a Date212 object from a string in YYYYMMDD format.
     *
     * @param date the date string in YYYYMMDD format
     */
	
	public Date212(String date)
{
    if (date == null || date.length() != 8)
        throw new IllegalDate212Exception("Invalid date format");

    try {
        this.fileFormat = date;
        this.year = Integer.parseInt(date.substring(0,4));
        this.month = Integer.parseInt(date.substring(4,6));
        this.day = Integer.parseInt(date.substring(6));
    }
    catch (NumberFormatException e) {
        throw new IllegalDate212Exception("Non-numeric date");
    }

    if (this.month < 1 || this.month > 12)
        throw new IllegalDate212Exception("Invalid month");

    if (this.day < 1 || this.day > 31)
        throw new IllegalDate212Exception("Invalid day");
}

	//getters

	/**
     * @return the original date string
     */
	
	public String getFileFormat()
	{
		return this.fileFormat;
	}

	/**
     * @return the year
     */

	public int getYear()
	{
		return this.year;
	}

	/**
     * @return the month
     */
	
	public int getMonth()
	{
		return this.month;
	}
	/**
	 * @return the day
	 */
	
	public int getDay()
	{
		return this.day;
	}
	
	//setters

	/**
     * Sets the year value.
     *
     * @param y the year
     */
	
	public void setYear(int y)
	{
		this.year = y;
	}

	/**
     * Sets the day value.
     *
     * @param d the day
     */
	
	public void setDay(int d)
	{
		this.day = d;
	}

	/**
	 * Sets the month value.
	 *
	 * @param m the month
	 */
	
	public void setMonth(int m)
	{
		this.month = m;
	}
	/**
     * Checks if two Date212 objects represent the same date.
     *
     * @param other another Date212 object
     * @return true if the dates are equal, false otherwise
     */
	
	public boolean isEqual(Date212 other)
	{
		return ((this.year == other.getYear()) && (this.day == other.getDay()) && (this.month == other.getMonth()));
	}

	/**
     * Compares this date to another date.
     *
     * @param other the Date212 object to compare to
     * @return -1 if this date is earlier, 1 if later, 0 if equal
     */
	
	
	/**
	If d1 < d2 I want to return -1 else return 1
	Encoding the idea that d1 comes before d2
	Here This is our d1 and other is our d2.*/
	public int compareTo(Date212 other)
	{
		if (!(this.isEqual(other)))
		{
			//check year
			if (this.year < other.getYear())
			{
				return -1;
			}
			if (this.year > other.getYear())
			{
				return 1;
			}
			if (this.month < other.getMonth())
			{
				return -1;
			}
			if (this.month > other.getMonth())
			{
				return 1;
			}
			if (this.day < other.getDay())
			{
				return -1;
			}
			if (this.day > other.getDay())
			{
				return 1;
			}
		}
		
		return 0;
	}

	/**
     * Converts a numeric day value to its corresponding weekday name.
     *
     * @param d numeric day from Zeller's Congruence
     * @return the name of the weekday
     */
	
	private String intToDay(int d)
	{
		switch(d)
		{
			case 0:
				return "Saturday";
			case 1:
				return "Sunday";
			case 2:
				return "Monday";
			case 3:
				return "Tuesday";
			case 4:
				return "Wednesday";
			case 5: 
				return "Thursday";
			case 6:
				return "Friday";
			default:
				return "Invalid";
		}
	}

	
    /**
     * Converts a numeric month value to its month name.
     *
     * @param m the month number
     * @return the month name
     */
	
	private String intToMonth(int m)
	{
		switch(m)
		{
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
			default:
				return "Invalid";
		}
		
		
	}

	/**
     * Uses Zeller's Congruence to calculate the day of the week.
     *
     * @param day the day
     * @param month the month
     * @param year the year
     * @return an integer representing the day of the week
     */
	
	private static int zellerAlg(int day, int month, int year)
	{
		//four variables in the zeller algorithm
		int q = day;
		int m = month;
		int J = 0;
		int K = 0;
		
		if (month == 1)
		{
			m = 13;
			K = ((year - 1)%100);
			J = (year - 1)/100;
		}
		if (month == 2)
		{
			m = 14;
			K = ((year - 1)%100);
			J = (year - 1)/100;
		}
		if (month > 2)
		{
			m = month;
			K = ((year)%100);
			J = (year)/100;
		}
		
		int t2 = (13*(m + 1))/5;
		int t4 = (K/4);
		int t5 = (J/4);

		
		return Math.floorMod((q + t2 + K + t4 + t5 - (2*J)),7);
	}

	/**
     * Returns the date in readable format including the day of the week.
     *
     * @return formatted date string
     */
	
	public String toString()
	{
		int d = zellerAlg(this.day, this.month, this.year);
		
		
		return (this.intToDay(d) + ", " + this.intToMonth(this.month) + " " + this.day + ", " + this.year);
	}

	 /**
     * Sorts an array of Date212 objects using selection sort.
     *
     * @param A the array to sort
     * @param size the number of elements
     */
	
	public static void selectionSort(Date212[] A, int size)
	{
		Date212 min;
		int indexOfSmall  = -1;
		for (int i = 0; i < A.length; i++)
		{
			min = A[i]; //smallest ith value in A
			for (int j = 1; j < A.length; j++)
			{
				if (A[j].compareTo(min) < 0)
				{
					min = A[j];
					indexOfSmall = j;
				}
			}
			//swap elements min with A[i].
			Date212 temp = A[i];
			A[i] = min;
			A[indexOfSmall] = temp;
			
		}
	}
	
}

// main()
// 		Date212 d = new Date212("20251009")
		