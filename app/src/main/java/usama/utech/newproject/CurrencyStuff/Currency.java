package usama.utech.newproject.CurrencyStuff;

/**
 * Created by tomm on 4/4/16 AD.
 */
public class Currency {
    private String name;
    private double rate;

    public Currency(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
