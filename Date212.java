public class Date212
{
    private int year;
    private int month;
    private int day;
    
    //constructor 
    public Date212(String date)
    {
        //date="20251009"
        this.year = Integer.parseInt(date.substring(0,4));
        this.month = Integer.parseInt(date.substring(4,6));
        this.day = Integer.parseInt(date.substring(6));
    }
    
    //getters
    public int getYear()
    {
        return this.year;
    }

    public int getMonth()
    {
        return this.month;
    }

    public int getDay()
    {
        return this.day;
    }

    //setters
    
    public void setYear(int y)
    {
        this.year = y;
    }

    public void setMonth(int m)
    {
        this.month = m;
    }

    public void setDay(int d)
    {
        this.day = d;
    }

    //Equality check
    public boolean isEqual(Date212 other)
    {
        return ((this.year == other.getYear()) && (this.day == other.getDay()) && (this.month == other.getMonth()));
    }

    // If d1<d2 I want to return -1 else return 1 Encoding the idea that d1 comes before d2 Here This isour d1 and other is our d2 
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

            //check month
            if (this.month < other.getMonth())
            {
                return -1;
            }
            if (this.month > other.getMonth())
            {
                return 1;
            }

            //check day
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
    
    //convert int month to month name
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

    //Convert to readable string format
    public String toString()
    {
        return (this.intToMonth(this.month) + " " + this.day + ", "+ this.year);
    }

    public String getOriginal() {
    // Rebuild the original 8-digit string (YYYYMMDD)
    String y = String.format("%04d", year);
    String m = String.format("%02d", month);
    String d = String.format("%02d", day);
    return y + m + d;
}

    //Selection sort for Date212 objects
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