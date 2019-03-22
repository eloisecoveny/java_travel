public class Plane {

    private PlaneType type;
    private int capacity;
    private int weight;

    public Plane(PlaneType type){
        this.type = type;
        this.capacity = this.type.getCapacity();
        this.weight = this.type.getWeight();
    }

    public PlaneType getType(){
        return this.type;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getWeight(){
        return this.weight;
    }
}
