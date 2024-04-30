interface Relogio {
    void setAlarme(Instant instant);
    float lerTermometro();
    void tuneInToRandomRadio();
}
class relogioAntigo implements Relogio {
    @Override
    public void setAlarme(Instant instant) {
        // set the alarm
    }
    @Override
    public float lerTermometro() {
        throw new UnsupportedOperationException("ancient Relogio does not have thermometer");
    }
    @Override
    public void tuneInToRandomRadio() {
        // tune in to one of the stations
    }
}
class relogioModerno implements Relogio {
    @Override
    public void setAlarme(Instant instant) {
        // set the alarm
    }
    @Override
    public float lerTermometro() {
        return 5; // return some value
    }
    @Override
    public void tuneInToRandomRadio() {
        throw new UnsupportedOperationException("modern Relogio cannot play radio");
    }
}
