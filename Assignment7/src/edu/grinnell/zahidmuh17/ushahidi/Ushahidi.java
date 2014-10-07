package edu.grinnell.zahidmuh17.ushahidi;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiIncidentList;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;

public class Ushahidi
{

  // A client containing random incidents
  public static UshahidiTestingClient testingClient()
  {
    UshahidiTestingClient newClient = new UshahidiTestingClient();
    for (int i = 0; i < 12; i++)
      {
        newClient.addIncident(UshahidiUtils.randomIncident());

      }
    return newClient;
  }

  //print an Incident in custom format
  public static void printIncident(PrintWriter pen, UshahidiIncident incident)
  {
    pen.println("Incident #: " + incident.getTitle());
    pen.println(incident.getDescription());
    pen.println("location: " + incident.getLocation());
    pen.println("status: " + incident.getMode() + ", " + incident.getActive()
                + ", " + incident.getVerified());
    pen.println("Date: " + incident.getDate());
    pen.println();
  }

  //A method that prints incidents given a specific date range

  public static void printIncidentsWithinDate(UshahidiClient client,
                                       LocalDateTime startDate,
                                       LocalDateTime endDate)
    throws Exception
  {

    UshahidiIncident currentIncident = client.nextIncident();
    PrintWriter pen = new PrintWriter(System.out, true);

    while (client.hasMoreIncidents())
      {

        if (startDate.isBefore(currentIncident.getDate())
            && endDate.isAfter(currentIncident.getDate()))
          {

            printIncident(pen, currentIncident);
            currentIncident = client.nextIncident();

          }
        else
          {
//            printIncident(pen, currentIncident);
            currentIncident = client.nextIncident();
          }

      }

  }

  // A method that returns an ArrayList of UshahidiIncidents that lay in
  // a specific date range
  public ArrayList<UshahidiIncident>
    makeArrayofIncidentsWithinDate(UshahidiClient client,
                                   LocalDateTime startDate,
                                   LocalDateTime endDate)
  {

    UshahidiIncident[] incidentslist = client.getIncidents();
    ArrayList<UshahidiIncident> arrayList = new ArrayList<UshahidiIncident>();
    int len = incidentslist.length;

    for (int index = 0; index < len; index++)
      {

        UshahidiIncident currentIncident = incidentslist[index];

        if (startDate.isBefore(currentIncident.getDate())
            && endDate.isAfter(currentIncident.getDate()))
          {

            arrayList.add(incidentslist[index]);

          }//if

      }//for

    return arrayList;
  }//makeArrayofIncidentsWithinDate

  // A method that returns an ArrayList of Ushahidi Incidents that
  // are within distance of the provided coordinates.
  
  public static ArrayList<UshahidiIncident>
    incidentsWithinDistance(UshahidiClient client, double latitude,
                            double longitude, double distance)
  {

    UshahidiIncident[] incidentslist = client.getIncidents();
    ArrayList<UshahidiIncident> arrayList = new ArrayList<UshahidiIncident>();
    int len = incidentslist.length;

    for (int index = 0; index < len; index++)
      {

        double currentLat = incidentslist[index].getLocation().getLatitude();
        double currentLong = incidentslist[index].getLocation().getLongitude();

        if (sphericalDistance(currentLong, currentLat, longitude, latitude) <= distance)
          {
            
//            Print statements for testing:
            
//            System.out.println(sphericalDistance(currentLong, currentLat, longitude, latitude));
//            printIncident(new PrintWriter(System.out, true),incidentslist[index] );
            arrayList.add(incidentslist[index]);

          }//if

      }//for
    return arrayList;
  }//incidentsWithinDistance

  //The following is a helper method that gives the distance 
  //between two earth coordinates in miles
  //source: http://andrew.hedges.name/experiments/haversine/

  public static double sphericalDistance(double longitude1, double latitude1,
                                         double longitude2, double latitude2)
  {

    double dLongitude = longitude2 - longitude1;
    double dLatitude = latitude2 - latitude1;

    double a =
        Math.pow(Math.sin(dLatitude / 2), 2) + Math.cos(latitude1)
            * Math.cos(latitude2) * Math.pow(Math.sin(dLongitude / 2), 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double d = 3961.0 * c;

    return d;

  }//sphericalDistance

  //A method for filtering a List (grabbed by a client) of Ushahidi incidents
  //by a general Predicate
  public static ArrayList<UshahidiIncident>
    generalFilter(Predicate<UshahidiIncident> pred, UshahidiClient client)
  {

    UshahidiIncident[] incidentslist = client.getIncidents();
    ArrayList<UshahidiIncident> listResult = new ArrayList<UshahidiIncident>();
    int len = incidentslist.length;

    for (int index = 0; index < len; index++)
      {
        UshahidiIncident currentIncident = incidentslist[index];
        if (pred.test(currentIncident))
          {

//          Print statement for testing:            
//            printIncident(new PrintWriter(System.out, true),incidentslist[index] );
            listResult.add(incidentslist[index]);

          }// if

      }//for
    return listResult;

  }//generalFilter(Predicate<UshahidiIncident> pred, UshahidiClient client)

}//class