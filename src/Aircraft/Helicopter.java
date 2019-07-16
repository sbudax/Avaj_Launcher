package Aircraft;

import Weather.WeatherTower;
import Simulator.Simulator;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower _weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = _weatherTower.getWeather(_coordinates);
        switch (weather){
            case "RAIN":
                _coordinates = new Coordinates(_coordinates.getLongitude() + 5, _coordinates.getLatitude(), _coordinates.getHeight());
                Simulator.writer.println("Helicopter#" + _name + "(" + _id + "):" + "Its raining.");
                break;
            case "FOG":
                _coordinates = new Coordinates(_coordinates.getLongitude() + 1, _coordinates.getLatitude(), _coordinates.getHeight());
                Simulator.writer.println("Helicopter#" + _name + "(" + _id + ")" + "Visibilty low due to fog.");
                break;
            case "SUN":
                _coordinates = new Coordinates(_coordinates.getLongitude() + 10, _coordinates.getLatitude(), _coordinates.getHeight() + 2);
                Simulator.writer.println("Helicopter#" + _name + "(" + _id + ")" + "Enjoy clear sunny skies.");
                break;
            case "SNOW":
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight());
                Simulator.writer.println("Helicopter#" + _name + "(" + _id + ")" + "Freezing temperatures due to snow.");
                break;
        }
        if (_coordinates.getHeight() == 0){
            _weatherTower.unregister(this);
            Simulator.writer.println("Helicopter#" + _name + "(" + _id + "):" + "landing.");
            Simulator.writer.println("Helicopter#" + _name + "(" + _id + "):" + "Unregistered from weather tower.");
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        _weatherTower = weatherTower;
        weatherTower.register(this);
        Simulator.writer.println("Tower says: Helicopter#" + _name + "(" + _id + ")" + " registered to weather tower.");
    }

}
