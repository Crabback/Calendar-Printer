import java.util.Scanner;
////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: P01 Calendar Printer
//Files: CalendarTester.java
//Course: CS 300
//
//Author: Zhengjia Mao
//Email: zmao27@wisc.edu
//Lecturer's Name: Gary DAHL
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name: Bailong Huang
//Partner Email: bhuang67@wisc.edu
//Partner Lecturer's Name: Gary DAHL
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//_YES__ Write-up states that pair programming is allowed for this assignment.
//_YES__ We have both read and understand the course Pair Programming Policy.
//_YES__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully
//acknowledge and credit those sources of help here. Instructors and TAs do
//not need to be credited here, but tutors, friends, relatives, room mates,
//strangers, and others do. If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons: NONE
//Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class CalendarTester {

  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2019") != 19)
      return false;
    if (CalendarPrinter.getYearWithinCentury("44444") != 44)
      return false;
    return true;
  }

  public static boolean testGetIsLeapYear() {
    if (CalendarPrinter.getIsLeapYear("2") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("1000") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("40000") != true)
      return false;
    return true;
  }

  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("feB") != 1)
      return false;
    if (CalendarPrinter.getMonthIndex("Sept") != 8)
      return false;
    if (CalendarPrinter.getMonthIndex("November") != 10)
      return false;
    return true;
  }

  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("feB", "7") != 28)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("FEb", "2000") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("November", "44899") != 30)
      return false;
    return true;
  }

  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("feBgtvtgbtgb", "2017") != 2)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("FEb", "1975") != 5)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("November", "2020") != 6)
      return false;
    return true;
  }


  public static void main(String[] args) {
    System.out.println(testGetCentury());
    System.out.println(testGetYearWithinCentury());
    System.out.println(testGetIsLeapYear());
    System.out.println(testGetMonthIndex());
    System.out.println(testGetNumberOfDaysInMonth());
    System.out.println(testGetFirstDayOfWeekInMonth());

    String test[][] = CalendarPrinter.generateCalendar("feb", "2020");
    for (int i = 0; i < test.length; i++) {
      for (int j = 0; j < test[0].length; j++) {
        System.out.print(test[i][j]);

      }
      System.out.println();
    }
  }

}
