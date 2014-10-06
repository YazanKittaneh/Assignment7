package com.farevee.groceries;

public class ManyPackages
    implements Item
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  
  Package manyType;
  int manyCount;
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * Creates a package ManyPackages
   */
  public ManyPackages(Package type, int count)
  {
    manyType=type;
    manyCount=count;
  }
  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+ 
  
  /**
   * gives weight of the package
   */
  @Override
  public Weight getWeight()
  {
    manyType.packageWeight.amount = (manyType.packageWeight.amount * manyCount);
    return manyType.getWeight();
  }
  
  

  /**
   * returns total price
   */
  @Override
  public int getPrice()
  {
    manyType.packagePrice = (manyType.packagePrice * manyCount);
    return manyType.packagePrice;
  } // int getPrice()

  
  
  /**
   * returns string in form of 4 x 5 oz. package of mac and cheeze”
   */
  @Override
  public String toString(int i)
    throws Exception
  {
    String manyPackageString = "";

    if (i >= 0)
      {
        manyPackageString += manyCount + " x " + manyType.getWeight().toString() + "package of " + manyType.PackageName;
        return manyPackageString;
      }
    else
      throw new Exception("Invalid row " + i);
  } // String toString(int i)

}