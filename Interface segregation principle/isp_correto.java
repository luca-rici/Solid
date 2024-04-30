interface Termometro {
    float lerTermometro();
}
interface Radio {
    void sincronizarRadio();
}   
interface Alarme {
    void setAlarme(Instant instant);
}
class relogioAntigo implements Alarme, Radio {
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public void sincronizarRadio() {
    }
}
class relogioMOderno implements Alarme, Termometro {
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public float lerTermometro() {
        return 5;
    }
}
