package mnxk.kotlintex.models;

public class Beers {
    int beerThumb;
    String beerName;
    Double beerPrice;

public Beers(int beerThumb, String beerName, Double beerPrice) {
        this.beerThumb = beerThumb;
        this.beerName = beerName;
        this.beerPrice = beerPrice;
    }

    public int getBeerThumb() {
        return beerThumb;
    }

    public void setBeerThumb(int beerThumb) {
        this.beerThumb = beerThumb;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public Double getBeerPrice() {
        return beerPrice;
    }

    public void setBeerPrice(Double beerPrice) {
        this.beerPrice = beerPrice;
    }
}
