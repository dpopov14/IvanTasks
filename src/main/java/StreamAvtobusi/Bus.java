package StreamAvtobusi;

public class Bus {

    int boarding;
    int gettingOff;
    int continuing;


    public Bus(int boarding, int gettingOff, int continuing) {
        this.boarding = boarding;
        this.gettingOff = gettingOff;
        this.continuing = continuing;
    }

    public int getBoarding() {
        return boarding;
    }

    public void setBoarding(int boarding) {
        this.boarding = boarding;
    }

    public int getGettingOff() {
        return gettingOff;
    }

    public void setGettingOff(int gettingOff) {
        this.gettingOff = gettingOff;
    }

    public int getContinuing() {
        return continuing;
    }

    public void setContinuing(int continuing) {
        this.continuing = continuing;
    }

    public void incrementBoarding() {
        this.boarding += 1;
    }

    public void incrementGettingOff() {
        this.gettingOff += 1;
    }

    public void incrementContinuing() {
        this.continuing += 1;
    }

    public void decrementContinuing() {
        this.continuing -= 1;
    }


    @Override
    public String toString() {
        return
                " boarding = " + boarding +
                        " | gettingOff =  " + gettingOff +
                        " | continuing =  " + continuing+ " |\n";
    }
}
