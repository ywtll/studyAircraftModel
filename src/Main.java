import info.AircraftModel;
import info.MapModel;

public class Main {
    public static void main(String[] args) {
        AircraftModel aircraftModel = new AircraftModel(0, 0);
        aircraftModel.setStep(10);

        /*
        wsad
         */
        aircraftModel.setUp(38);
        aircraftModel.setDown(40);
        aircraftModel.setLeft(37);
        aircraftModel.setLight(39);


        new MapModel(800,400,aircraftModel );
    }
}
