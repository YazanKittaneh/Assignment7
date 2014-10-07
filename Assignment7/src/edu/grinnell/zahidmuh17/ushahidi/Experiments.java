package edu.grinnell.zahidmuh17.ushahidi;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import edu.grinnell.glimmer.ushahidi.UshahidiCategory;
import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiLocation;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;

public class Experiments
{

  /**
  * @param args
  */
  public static void main(String[] args) throws Exception
  {

    
    PrintWriter pen = new PrintWriter(System.out, true);
    
    
//    UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
//    UshahidiExtensions.printIncident(pen, UshahidiUtils.randomIncident());
//    Ushahidi.printIncident(pen, UshahidiUtils.randomIncident());
    
    
//    UshahidiClient client = Ushahidi.testingClient();
//    Ushahidi.incidentsWithinDistance(client, 37.2, -121.9,
//                                     100);
    UshahidiClient webclient =
        new UshahidiWebClient("http://ushahidi1.grinnell.edu/sandbox/");
//    Ushahidi.printIncidentsWithinDate(webclient, LocalDateTime.of(2000, 2, 3, 1, 23), LocalDateTime.of(2014, 9, 3, 1, 23));
    
//    Ushahidi.incidentsWithinDistance(webclient, 31.740751,  -66.284087, 4000);

    
    Ushahidi.generalFilter((UshahidiIncident inc) ->
    { return inc.getTitle().equals("Ruckus in Kershaw"); }
        , webclient);
    
    

  }

}
