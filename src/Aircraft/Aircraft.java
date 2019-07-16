package Aircraft;

public class Aircraft{

    protected long _id;
    protected String _name;
    protected Coordinates _coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        _id = nextId();
        _coordinates = coordinates;
        _name = name;
    }

    private long nextId(){
        return ++idCounter;
    }
}
