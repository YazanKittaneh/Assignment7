package com.farevee.groceries;

public class BulkItem
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  BulkFood bulkFood;
  Units bulkUnit;
  int bulkAmount;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * constructs a BulkItem object
   * 
   * @param food, a BulkFood
   * @param unit, Units
   * @param amount, an int
   */
  public BulkItem(BulkFood food, Units unit, int amount)
  {
    bulkFood = food;
    bulkUnit = unit;
    bulkAmount = amount;
  } //BulkItem(BulkFood food, Units unit, int amount)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+ 

  /**
   * 
   * Returns an object weight
   */
  @Override
  public Weight getWeight()
  {
    Weight bulkWeight = new Weight(bulkUnit, bulkAmount);
    return bulkWeight;
  } // Weight getWeight()

  /**
   * multiples price per unit by amount of units
   * @return
   *    int, price of bulkItem
   */
  @Override
  public int getPrice()
  {
    return (bulkFood.getPricePerUnit() * bulkAmount);
  } //int getPrice()

  /**
   * 
   * returns string in form of “5 pounds of bananas”
   */
  @Override
  public String toString(int i)
    // gives the number of units, the units, and the type of bulk food. For example, “5 pounds of bananas”. 
    throws Exception
  {
    String BulkItemString = ""; // “5 pounds of bananas”. 

    if (i >= 0)
      {
        BulkItemString += bulkAmount + bulkUnit.plural + "of" + bulkFood.bulkName;
        return BulkItemString;
      }
    else
      throw new Exception("Invalid row " + i);
  } //String toString(int i)
  
  
  public boolean equals(BulkFood compareFood)
  {
    if(compareFood.bulkName == bulkFood.bulkName && 
       compareFood.bulkPrice == bulkFood.bulkPrice &&
       compareFood.bulkSupply == bulkFood.bulkSupply &&
       compareFood.bulkUnit == bulkFood.bulkUnit)
      {
        return true;
      }
    else
      return false; 
  } //boolean equals(BulkFood compareFood)

}
