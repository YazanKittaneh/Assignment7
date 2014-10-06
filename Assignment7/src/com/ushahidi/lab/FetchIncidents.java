package com.ushahidi.lab;

import edu.grinnell.glimmer.ushahidi.UshahidiFilteringClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiIncidentList;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;

public class FetchIncidents
{
  public void getIncidents(String startDate, String endDate)
  {
    UshahidiFilteringClient filterClient;
    UshahidiIncidentList list = new UshahidiIncidentList();
//    UshahidiFilteringClient filterClient
    list.getIncidents();
  }
}
