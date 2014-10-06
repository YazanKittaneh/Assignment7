package com.farevee.groceries;

public class BulkFood
{

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  String bulkName;
  Units bulkUnit;
  int bulkPrice;
  int bulkSupply;
  
  
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  public BulkFood(String name, Units unit, int pricePerUnit, int supply)
  {
    bulkName=name;
    bulkUnit=unit;
    bulkPrice=pricePerUnit;
    bulkSupply=supply;
  }
  
  // +---------+----------------------------------------------------
  // | Methods |
  // +---------+
  
  /**
   * @return
   *    name of BulkFood
   */
  public String getName()
  {
    return bulkName;
  } //String getName()
  
  
  /**
   * @return
   *    unit
   */
  public Units getUnit()
  {
    return bulkUnit;
  } //Units getUnit()
  
  
  /**
   * @return
   *    price per unit
   */
  public int getPricePerUnit()
  {
    return bulkPrice;
  } //int getPricePerUnit()
  
  
  /**
   * @return
   *    number of supply
   */
  public int getSupply()
  {
    return bulkSupply;
  } //int getSupply()
  
 
}
