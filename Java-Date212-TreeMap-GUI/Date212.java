/**
 * 
 * @author prabhjot kaur
 * Date212 represents a date in YYYYMMDD format.
 * It validates the input string, stores the date as integers,
 * and provides comparison, formatting, and utility methods.
 */
public class Date212 implements Comparable<Date212> {
    private int year;
    private int month;
    private int day;

    /**
     * Constructs a Date212 object from an 8-digit string (YYYYMMDD).
     * Performs full validation of format, month, and day.
     *
     * @param date the 8-digit date string
     * @throws IllegalDate212Exception if format or value is invalid
     */
    //constructor WITH VALIDATION
    public Date212(String date) {

        // Check format: must be exactly 8 digits
        if (date == null || date.length() != 8 || !date.matches("\\d{8}")) {
            throw new IllegalDate212Exception("Invalid date format: " + date);
        }

        // Parse the parts
        this.year = Integer.parseInt(date.substring(0, 4));    
        this.month = Integer.parseInt(date.substring(4, 6));
        this.day = Integer.parseInt(date.substring(6));

        // Validate month
        if (month < 1 || month > 12) {
            throw new IllegalDate212Exception("Invalid month: " + month);
        }

        // Days in each month (no leap year checking required)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Validate day
        if (day < 1 || day > daysInMonth[month - 1]) {
            throw new IllegalDate212Exception("Invalid day: " + day + " for month " + month);
        }
    }

    //getters
    /** @return the year value */
    public int getYear() { return this.year; }
    /** @return the month value */
    public int getMonth() { return this.month; }
    /** @return the day value */
    public int getDay() { return this.day; }

    /**
     * Compares this date to another Date212 for natural ordering.
     * Comparison order: year → month → day.
     *
     * @param other the Date212 to compare to
     * @return negative, zero, or positive integer
     */
    //setters
    /**Sets the year */
    public void setYear(int y) { this.year = y; }
    public void setMonth(int m) { this.month = m; }
    public void setDay(int d) { this.day = d; }

    //Equality check
    public boolean isEqual(Date212 other) {
        return ((this.year == other.getYear()) && 
                (this.day == other.getDay()) && 
                (this.month == other.getMonth()));
    }

    // Compare two dates
    public int compareTo(Date212 other) {
        if (!(this.isEqual(other))) {
            if (this.year < other.getYear()) return -1;
            if (this.year > other.getYear()) return 1;

            if (this.month < other.getMonth()) return -1;
            if (this.month > other.getMonth()) return 1;

            if (this.day < other.getDay()) return -1;
            if (this.day > other.getDay()) return 1;
        }
        return 0;
    }

    /**
     * Converts an integer month to its name.
     *
     * @param m month number
     * @return month name
     */
    //convert int month to month name
    private String intToMonth(int m) {
        switch (m) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid";
        }
    }

    //Convert to readable string format
    public String toString() {
        return (this.intToMonth(this.month) + " " + this.day + ", " + this.year);
    }

    /**
     * @return the original YYYYMMDD string
     */
    public String getOriginal() {
        String y = String.format("%04d", year);
        String m = String.format("%02d", month);
        String d = String.format("%02d", day);
        return y + m + d;
    }

    /**
     * Selection sort for an array of Date212 objects.
     * Sorts the array in ascending order.
     *
     * @param array the array to sort
     * @param size number of elements (not always needed, but included per rubric)
     */
    //Selection sort for Date212 objects
    public static void selectionSort(Date212[] A, int size) {
        Date212 min;
        int indexOfSmall = -1;
        for (int i = 0; i < A.length; i++) {
            min = A[i];
            for (int j = 1; j < A.length; j++) {
                if (A[j].compareTo(min) < 0) {
                    min = A[j];
                    indexOfSmall = j;
                }
            }
            Date212 temp = A[i];
            A[i] = min;
            A[indexOfSmall] = temp;
        }
    }
}
