package Aircraft;

public class Coordinates{
    private int _longitude;
    private int _latitude;
    private int _height;

    Coordinates(int longitude, int latitude, int height){
        _longitude = longitude;
        _latitude = latitude;
        _height = height;
    }

    public int getLongitude(){
        return _longitude;
    }

    public int getLatitude(){
        return _latitude;
    }

    public int getHeight(){
        return _height;
    }
}
