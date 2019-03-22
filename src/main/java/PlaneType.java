public enum PlaneType {

    AIRBUS_A220(130, 7800),
    AIRBUS_A320(120, 7200),
    AIRBUS_A330(110, 6600),
    AIRBUS_A340(100, 6000),
    AIRBUS_A350(90, 5400),
    AIRBUS_A380(80, 4800),
    ATR_42(40, 1800),
    BOEING_717(105, 6300),
    BOEING_727(75, 4500),
    BOEING_737(215, 12900),
    BOEING_747(175, 10500),
    BOEING_757(150, 9000),
    BOEING_767(55, 3300),
    BOEING_777(60, 3600),
    COMAC_C919(300, 18000),
    CONCORDE(20, 1200),
    FRIGATE_ECOJET(5, 300);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight){
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getWeight(){
        return this.weight;
    }
}
