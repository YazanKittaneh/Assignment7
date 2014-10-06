package com.farevee.groceries;

public class Weight
{
  
  Units unit;
  int amount;
  
  public Weight(Units un, int value)
  {
    unit = un;
    amount = value;
  }
  
  public String toString()
  {
    String weightString ="";
    weightString += amount + unit.abbrev;
    return weightString;
  }

}
