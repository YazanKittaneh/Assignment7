package edu.grinnell.zahidmuh17.ushahidi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Predicate;

import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;
import sun.security.util.PendingException;

public class UshahidiUI
{

  //Fields for globals
  static int startYear;
  static int startMonth;
  static int startDay;
  static int endYear;
  static int endMonth;
  static int endDay;
  
  //The generic predicate
  static Predicate<UshahidiIncident> pred;
  static UshahidiWebClient webClient;

  //Boolean to indicate whether the user has quit or not
  static boolean quit = false;

  public static void main(String[] args)
    throws Exception
  {

    //Input reader
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("Welcome to this magnificent Ushahidi UI. ");

    //Loop to check whether the user has quit everytime 
    //baseUI finishes (there's always a prompt at the end)
    while (!quit)
      {

        baseUI(pen, reader);
      }//while

  }//main

  /*
   * A method that does most of the work for the UI. Takes a PrintWriter and
   * a BufferedReader as input. 
   */

  public static void baseUI(PrintWriter pen, BufferedReader reader)
    throws Exception

  {

    //Initial prompt requesting a URL for the client
    pen.println("Please begin by entering the URL of your webClient:");

    //Parse the url
    String url = reader.readLine();

    //This try/catch block has custom exception handling, if the URL is malformed
    //a message is sent saying try again, and the method (baseUI) is called again
    try
      {
        webClient = new UshahidiWebClient(url);
      }//try
    catch (MalformedURLException e)
      {
        pen.println("\nInvalid URL. Please try again,\n");
        return;
      }//catch

    //Instructions defining the capabilites of the UI
    pen.println("You have entered: " + url + "\n");

    pen.println("You have the following ways to filter your incidents: ");
    pen.println("1) Date");
    pen.println("2) Tags in Description");
    pen.println("3) Contains title\n");

    pen.println("Please type in either 1, 2 or 3 to proceed. Type QUITQUIT to quit.");

    String option = reader.readLine();

    //This switch statement does most of the logic work
    switch (option)
      {
        case "1":

          try
          {
          pen.println("Start year:");
          startYear = Integer.parseInt(reader.readLine());
          pen.println("Start month:");
          startMonth = Integer.parseInt(reader.readLine());
          pen.println("Start day:");
          startDay = Integer.parseInt(reader.readLine());
          pen.println("End year:");
          endYear = Integer.parseInt(reader.readLine());
          pen.println("End month:");
          endMonth = Integer.parseInt(reader.readLine());
          pen.println("End day:");
          endDay = Integer.parseInt(reader.readLine());
          }
          catch (Exception e)  //catches invalid date inputs
          {
            pen.println("\nInvalid date. Please try again,\n");
            break;
          }
          
          final LocalDateTime startDate =
              LocalDateTime.of(startYear, startMonth, startDay, 00, 00);
          final LocalDateTime endDate =
              LocalDateTime.of(endYear, endMonth, endDay, 00, 00);

          //The predicate is now assigned to checking for the date range
          try
            {
              pred = new Predicate<UshahidiIncident>()
                {

                  @Override
                  public boolean test(UshahidiIncident t)
                  {
                    return (t.getDate().isBefore(endDate) && t.getDate()
                                                              .isAfter(startDate));
                  }//test
                };//Predicate
            }
          catch (Exception e)
            {
              pen.println("\nInvalid input. Please try again,\n");
            }
          break;
        case "2":

          //This case allows a user to enter a string, and that string is then searched
          //Ushahidi Incidents' description fields.
          pen.println("Please enter the tag you wish to be searched in the description fields:");
          String tag = reader.readLine();
          try
            {
              pred = new Predicate<UshahidiIncident>()
                {

                  @Override
                  public boolean test(UshahidiIncident t)
                  {
                    String description = t.getDescription();

                    return description.toLowerCase()
                                      .contains(tag.toLowerCase());
                  }
                  //test
                };//Predicate
            }
          catch (Exception e)
            {
              pen.println("\nInvalid input. Please try again,\n");
            }
          break;
        case "3":

          //Similar to 2, but searches for the title
          pen.println("Please enter the title you wish to be searched in the title field");
          String title = reader.readLine();
          try
            {
              pred = new Predicate<UshahidiIncident>()
                {

                  @Override
                  public boolean test(UshahidiIncident t)
                  {
                    String description = t.getTitle();

                    return description.toLowerCase()
                                      .contains(title.toLowerCase());
                  }//test
                };//Predicate
            }
          catch (Exception e)
            {
              pen.println("\nInvalid input. Please try again,\n");
            }
          break;
        //The instance variable is changed if user asks to quit
        case "QUITQUIT":
          quit = true;
          break;
        //Default case is when user enters input not recognized by the code
        default:
          pen.println("Please enter a valid option");
      }//switch

    //Before executing the following code, it should be checked whether the
    //user asked to quit or not
    if (!quit)
      {
        ArrayList<UshahidiIncident> arrayList =
            Ushahidi.generalFilter(pred, webClient);

        if (arrayList.size() == 0)
          pen.println("\nNo results found\n");
        else
          {
            //print indivual incidents in the list
            for (UshahidiIncident incident : arrayList)
              {
                Ushahidi.printIncident(pen, incident);
              }//for
          }//else

        //Ask the user whether they want to continue or not
        pen.println("Type YES to search again. Type QUITQUIT to quit");
        if (!reader.readLine().equals("YES"))
          {
            pen.println("Goodbye!");
            quit = true;
          }//if
      }//if(!quit)
  }//baseUI
}//class
