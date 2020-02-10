import java.util.Scanner;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P01 Calendar Printer
// Files: CalendarPrinter.java
// Course: CS 300
//
// Author: Zhengjia Mao
// Email: zmao27@wisc.edu
// Lecturer's Name: Gary DAHL
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Bailong Huang
// Partner Email: bhuang67@wisc.edu
// Partner Lecturer's Name: Gary DAHL
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _YES__ Write-up states that pair programming is allowed for this assignment.
// _YES__ We have both read and understand the course Pair Programming Policy.
// _YES__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class CalendarPrinter {
  /*
   * We are using final value to initialize Days of Week and Months of Year in order to keep those    
   * values always be the same.
   */
  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  
  /*
   * We are using this method to get what the number of century in the year.
   * And this method will be used in the other methods below.
   */
  public static int getCentury(String year) {
    int century = Integer.parseInt(year) / 100;
    return century;

  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  
  /*
   * The method is finding the remaining number after the year divided by 100.
   * And the method will be used in the other methods below.   
   */
  public static int getYearWithinCentury(String year) {

    return (Integer.parseInt(year) % 100);

  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  
  /*
   * The method is going to use a specific formula to compute whether
   * the year is leap year or not. In order to classify normal year 
   * and leap year. 
   */
  public static boolean getIsLeapYear(String yearString) {
    int yr = Integer.parseInt(yearString);

    if (yr % 4 != 0) {
      return false;
    } else if (yr % 100 != 0) {
      return true;
    } else if (yr % 400 != 0) {
      return false;
    } else {
      return true;
    }
  }

  // Note implementation tips in Appendix I below.
  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */
  
  /*
   * This method is trying to find out what the index of month that a user inputs
   * in array of MONTHS_OF_YEAR is. We have to change every letter to be upper case
   * and only get first three letters after a users input a month, and then the
   * compiler can use these letters to find the index of a month that matching 
   * the parameter.
   */
  
  public static int getMonthIndex(String month) {
    for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
      if (month.toUpperCase().substring(0, 3).equals(MONTHS_OF_YEAR[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  
  /*
   * The method is going to find out how many days in the month and the year that uses 
   * try to know. Since every month has different the numbers of day in a year even 
   * the leap year which has a different numbers of day in February.  
   */
  public static int getNumberOfDaysInMonth(String month, String year) {
    int daysOfNormalYear[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if (getIsLeapYear(year) == true) {
      if (getMonthIndex(month) == 1) {
        return daysOfNormalYear[getMonthIndex(month)] + 1;
      } else {
        return daysOfNormalYear[getMonthIndex(month)];
      }
    } else {
      return daysOfNormalYear[getMonthIndex(month)];
    }

  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  
  /*
   * The method is using a formula to find a number which stands for 
   * first day of week in month. 
   * 
   * (Saturday = 0, Sunday = 1, ... , Thursday = 5, Friday = 6)
   */
  
  public static int getFirstDayOfWeekInMonth(String month, String year) {
    int K = getYearWithinCentury(year);
    int m = getMonthIndex(month);
    if (month.toUpperCase().substring(0, 3).equals("JAN")) {
      m += 13;
      K -= 1; //Jan and Feb are counted in the last year;
    } else if (month.toUpperCase().substring(0, 3).equals("FEB")) {
      m += 13;
      K -= 1;
    } else {
      m += 1;
    }
    int J = getCentury(year);
    int h = (1 + ((13 * (m + 1)) / 5) + K + (K / 4) + (J / 4) + 5 * J) % 7;
    int d = ((h + 5) % 7); //convert to our index
    return d;

  }

  // Note implementation tips in Appendix I below.
  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
   * 22 23 24 25 26 27 28 29 30 . . . . . .
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  
  /*
   *This method combine all the methods we made above in order to generate 
   *a final calendar in a specific month in a specific year. Generally, we
   *are mostly using for loop and if statement to store all required elements
   *into a 2D array.This 2D array can be 4 x 7, 5 x 7, or 6 x 7 that depend on
   *the order of days in the month.
   * 
   */
  public static String[][] generateCalendar(String month, String year) {

    int numOfDot = getFirstDayOfWeekInMonth(month, year);
    int numOfDays = getNumberOfDaysInMonth(month, year);
    int currentDay = 1;
    int numOfRows = (int) Math.ceil(numOfDays / 7.0) + 1;
    if (numOfDot != 0) {
      if (numOfDays == 28) {
        numOfRows += 1;
        //in Febs with 28 days, if the first day is not Monday,
        //the calendar needs an extra row;
      }
    }

    String[][] finalCalendar = new String[numOfRows][7];

    for (int a = 0; a < 7; a++) {
      finalCalendar[0][a] = DAYS_OF_WEEK[a] + " ";
    }

    for (int b = 0; b < numOfDot; b++) {
      //fill in dots first;
      finalCalendar[1][b] = " . " + " ";
    }

    for (int i = 1; i < numOfRows; i++) {
      if (i == 1) {
        //the dates start from the second row;
        for (int j = numOfDot; j < 7; j++) {
          if (currentDay < 10) {
            //the spacing formatting;
            finalCalendar[i][j] = " " + String.valueOf(currentDay) + "  ";
            currentDay++;
          } else {
            finalCalendar[i][j] = " " + String.valueOf(currentDay) + " ";
            currentDay++;
          }
        }
      } else {
        for (int j = 0; j < 7; j++) {
          if (currentDay < 10) {
            finalCalendar[i][j] = " " + String.valueOf(currentDay) + "  ";
            currentDay++;
          } else {
            finalCalendar[i][j] = " " + String.valueOf(currentDay) + " ";
            currentDay++;
          }
        }
      }
    }

    for (int c = (numOfDays - 28 + numOfDot); c < 7; c++) {
      //fill in dots in the end;
      if (c == 0) {
        break;
      } else {
        finalCalendar[numOfRows - 1][c] = " . " + " ";
      }
    }
    
    return finalCalendar;
  }

  /*
   * This is the main method. We are using to method to make the work
   * done perfectly. Using the scanner to catch when the specific month
   * in the specific year a user intend to know is. And the program will 
   * print out the calendar that the user expects. 
   */
  public static void main(String args[]) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("================================");
    System.out.print("Enter the month to print: ");
    String monthAnswer = userInput.nextLine();
    System.out.print("Enter the year to print: ");
    String yearAnswer = userInput.nextLine();
    String test[][] = CalendarPrinter.generateCalendar(monthAnswer, yearAnswer);
    for (int i = 0; i < test.length; i++) {
      for (int j = 0; j < test[0].length; j++) {
        System.out.print(test[i][j]);
      }
      System.out.println();
    }
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");

  }


}