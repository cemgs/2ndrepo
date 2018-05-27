package edu.sabanciuniv.cs310.sumall;

/**
 * Created by Cemges on 5/6/2018.
 */

public class cartitem implements Comparable<cartitem> {

    public int price;
    public int count;
    public String name;

    public cartitem(int p, int c, String n)
    {
        count = c;
        price = p*c;
        name = n;


    }

    public cartitem()
    {

    }
    @Override
    public int compareTo(cartitem other) {
        return this.name.compareTo(other.name);
    }


}
