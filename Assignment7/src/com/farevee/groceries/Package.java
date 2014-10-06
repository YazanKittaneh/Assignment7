package com.farevee.groceries;

public class Package
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  
    String PackageName;
    Weight packageWeight;
    int packagePrice;
    
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
    
    /**
     * Constructor for a Package object
     * 
     * @param name, a string
     * @param weight, a Weight object
     * @param price, an int price
     */
    public Package(String name, Weight weight, int price)
    {
      PackageName=name;
      packageWeight=weight;
      packagePrice=price;
    }
    
    
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+ 
    
    /**
     * returns package weight
     */
  @Override
  public Weight getWeight()
  {
    return packageWeight;
  } // Weight getWeight()
  
  
  
  /**
   * returns package price
   */
  @Override
  public int getPrice()
  {
    return packagePrice;
  } //int getPrice()

  
  
  /**
   * returns string in form "5 oz. package of mac and cheeze”
   */
  @Override
  public String toString(int i)
    throws Exception
  {
    String BulkItemString = ""; //“5 oz. package of mac and cheeze”

    if (i >= 0)
      {
        BulkItemString += packageWeight.toString() + "package of " + PackageName;
        return BulkItemString;
      }
    else
      throw new Exception("Invalid row " + i);
  } //String toString(int i)

}