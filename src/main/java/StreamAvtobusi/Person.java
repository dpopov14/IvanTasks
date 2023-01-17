package StreamAvtobusi;

public class Person {
    private String name;
    private String firstStop;
    private String lastStop;

    public Person(String name, String firstStop, String lastStop) {
        this.name = name;
        this.firstStop = firstStop;
        this.lastStop = lastStop;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFirstStop() {
        return firstStop;
    }

    public String getLastStop() {
        return lastStop;
    }
}
