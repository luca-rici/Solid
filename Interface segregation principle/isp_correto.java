interface Termometro {
    float readTermometro();
}
interface Radio {
    void tuneInToRandomRadio();
}   
interface Alarme {
    void setAlarme(Instant instant);
}
class relogioAntigo implements Alarme, Radio {
    @Override
    public void setAlarme(Instant instant) {
        // set the Alarme
    }
    @Override
    public void tuneInToRandomRadio() {
        // tune in to one of the stations
    }
}
class relogioMOderno implements Alarme, Termometro {
    @Override
    public void setAlarme(Instant instant) {
        // set the Alarme
    }
    @Override
    public float lerTermometro() {
        return 5; // return some value
    }
}
