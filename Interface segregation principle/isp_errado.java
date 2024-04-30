interface Relogio {
    void setAlarme(Instant instant);
    float lerTermometro();
    void sincronizarRadio();
}
class relogioAntigo implements Relogio {
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public float lerTermometro() {
        throw new Exception();
    }
    @Override
    public void sincronizarRadio(); {
    }
}
class relogioModerno implements Relogio {sincronizarRadio
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public float lerTermometro() {
        return 5; 
    }
    @Override
    public void sincronizarRadio(); {
        throw new Exception();
    }
}
