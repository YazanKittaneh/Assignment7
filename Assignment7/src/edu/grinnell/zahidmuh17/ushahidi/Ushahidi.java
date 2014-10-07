package edu.grinnell.zahidmuh17.ushahidi;

import java.util.ArrayList;
import java.util.Date;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiTestingClient;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;

public class Ushahidi {



//A client for testing
public static UshahidiTestingClient testingClient()
  {
    UshahidiTestingClient newClient = new UshahidiTestingClient();
    for (int i = 0; i < 12; i++)
      {
        newClient.addIncident(UshahidiUtils.randomIncident());

      }
    return newClient;
  }

 
//Need java 8 for this to work
 
// public void printIncidentsWithinDate(UshahidiClient client, Date startDate, Date endDate) throws Exception{
// 
// UshahidiIncident currentIncident = client.nextIncident();
// PrintWriter pen = new PrintWriter(System.out, true);
// 
// while(client.hasMoreIncidents()){
// 
// 
// if (currentIncident.getDate())
// 
// 
// 
// 
// 
// }
// 
// 
// }

//Extra 2: part a
public ArrayList<UshahidiIncident> makeArrayofIncidentsWithinDate(
UshahidiClient client, Date startDate, Date endDate) {

UshahidiIncident[] incidentslist = client.getIncidents();
ArrayList<UshahidiIncident> arrayList = new ArrayList<UshahidiIncident>();
int len = incidentslist.length;

for (int index = 0; index < len; index++) {


//Over here, we need to check for the date - I can't use LocalDateTime since I have Java 7
// if(startDate.after(incidentslist[index].getDate())){

//If within date, add the incident to the arrayList
arrayList.add(incidentslist[index]);

// }

}

return arrayList;
}

//Extra 2: Part b
public static ArrayList<UshahidiIncident> incidentsWithinDistance(
UshahidiClient client,
double latitude, double longitude, double distance) {

UshahidiIncident[] incidentslist = client.getIncidents();
ArrayList<UshahidiIncident> arrayList = new ArrayList<UshahidiIncident>();
int len = incidentslist.length;

for (int index = 0; index < len; index++) {

double currentLat = incidentslist[index].getLocation()
.getLatitude();
double currentLong = incidentslist[index].getLocation()
.getLongitude();

if (sphericalDistance(currentLong, currentLat, longitude, latitude) < distance) {

arrayList.add(incidentslist[index]);

}

}
return arrayList;
}

//source: http://andrew.hedges.name/experiments/haversine/

public static double sphericalDistance(double longitude1, double latitude1,
double longitude2, double latitude2) {

double dLongitude = longitude2 - longitude1;
double dLatitude = latitude2 - latitude1;

double a = Math.pow(Math.sin(dLatitude / 2), 2) + Math.cos(latitude1)
* Math.cos(latitude2) * Math.pow(Math.sin(dLongitude / 2), 2);
double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
double d = 3961.0 * c;

return d;

}
}