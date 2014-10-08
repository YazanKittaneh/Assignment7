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

  /**
   * A client containing random incidents
   * 
   * @return  newClient filled with random incident
   */
  public static UshahidiTestingClient testingClient()
  {
    UshahidiTestingClient newClient = new UshahidiTestingClient();
    for (int i = 0; i < 12; i++)
      {
        newClient.addIncident(UshahidiUtils.randomIncident());

      } //creates 12 random incidents
    return newClient;
  } //UshahidiTestingClient testingClient()

  /**
   * Print an Incident in custom format
   * 
   * @param pen, a PrintWriter
   * @param incident, the incident being specified
   */
  public static void printIncident(PrintWriter pen, UshahidiIncident incident)
  {
    pen.println("Incident #: " + incident.getTitle());
    pen.println(incident.getDescription());
    pen.println("location: " + incident.getLocation());
    pen.println("status: " + incident.getMode() + ", " + incident.getActive()
                + ", " + incident.getVerified());
    pen.println("Date: " + incident.getDate());
    pen.println();
  } //printIncident(PrintWriter pen, UshahidiIncident incident)

  /**
   * prints incidents, given a specific date range
   * 
   * @param client, the client with incidents
   * @param startDate, the start date of the range
   * @param endDate, the end date of the range
   * @throws Exception
   */
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

          } //if current incident is between startDate and endDate
        else
          {
            currentIncident = client.nextIncident();
          } // else get new incident

      } //while there are more incidents

  } // printIncidentsWithinDate(client, startDate, endDate)

  /**
   * Returns an ArrayList of UshahidiIncidents that lay in
   * a specific date range
   * 
   * @param client, the client with incidents
   * @param startDate, the start date of the range
   * @param endDate, the end date of the range
   * @return 
   */
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

          }//if incident is between startDate and endDate

      }//for each element in array

    return arrayList;
  }//makeArrayofIncidentsWithinDate

  /**
   * A method that returns an ArrayList of Ushahidi Incidents that
   * are within distance of the provided coordinates.
   * 
   * 
   * @param client, the client with incidents
   * @param latitude, a double
   * @param longitude, a double
   * @param distance, a double
   * @return
   */
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

            arrayList.add(incidentslist[index]);

          }//if the distance of incident is within selected distance

      }//for every value of the array
    return arrayList;
  }//incidentsWithinDistance

  /**
   * The following is a helper method that gives the distance 
   * between two earth coordinates in miles
   * 
   * source: http://andrew.hedges.name/experiments/haversine/
   * 
   * @param longitude1, double
   * @param latitude1, double
   * @param longitude2, double
   * @param latitude2, double
   * @return d, spherical distance 
   */
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

  /**
   * A method for filtering a List (grabbed by a client) of Ushahidi incidents
   * by a general Predicate
   * 
   * @param pred, a predicate
   * @param client, the client with incidents
   * @return listResult, array list of incidents
   */
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

            listResult.add(incidentslist[index]);

          }// if current incident passes predicate

      }//for every value in the arrayList
    return listResult;

  }//generalFilter(Predicate<UshahidiIncident> pred, UshahidiClient client)

}//class