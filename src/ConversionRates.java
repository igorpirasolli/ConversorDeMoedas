public class ConversionRates {
    private double USD;
    private double BRL;
    private double COP;
    private double ARS;

    public double getUSD() {
        return USD;
    }

    public double getBRL() {
        return BRL;
    }

    public double getCOP() {
        return COP;
    }

    public double getARS() {
        return ARS;
    }

    public double dolarParaPesoArgentino(double valor) {
        return valor * this.ARS;
    }
    public double dolarParaRealBrasileiro(double valor) {
        return valor * this.BRL;
    }

    public double dolarParaPesoColombiano(double valor) {
        return valor * this.COP;
    }

    public double pesoArgentinoParaDolar(double valor) {
        return valor / this.ARS;
    }

    public double pesoColombianoParaDolar(double valor) {
        return valor / this.COP;
    }

    public double realBrasileiroParaDolar(double valor) {
        return valor / this.BRL;
    }
}
