package Aircraft;

import Weather.WeatherTower;
import Simulator.Simulator;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower _weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = _weatherTower.getWeather(_coordinates);

        switch (weather) {
            case "RAIN":
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 5);
                Simulator.writer.println("Baloon#" + _name + "(" + _id + "):" + "Its raining.");
                break;
            case "FOG":
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 3);
                Simulator.writer.println("Baloon#" + _name + "(" + _id + "):" + "Visibility low due to fog.");
                break;
            case "SUN":
                _coordinates = new Coordinates(_coordinates.getLongitude() + 2, _coordinates.getLatitude(), _coordinates.getHeight() + 4);
                Simulator.writer.println("Baloon#" + _name + "(" + _id + "):" + "Enjoy clear sunny skies.");
                break;
            case "SNOW":
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 15);
                Simulator.writer.println("Baloon#" + _name + "(" + _id + "):" + "Freezing temperatures due to snow.");
                break;
        }
            if (_coordinates.getHeight() == 0){
                _weatherTower.unregister(this);
                Simulator.writer.println("Jetplane#" + _name + "(" + _id + "):" + "landing.");
                Simulator.writer.println("Jetplaner#" + _name + "(" + _id + "):" + "Unregistered from weather tower.");
            }
    }

    public void registerTower(WeatherTower weatherTower){
        _weatherTower = weatherTower;
        _weatherTower.register(this);
        Simulator.writer.println("Tower says: Jetplane#" + _name + "(" + _id + ")" + " registered to weather tower.");
    }
}
