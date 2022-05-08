package com.example.proj102;
//CLASE PARA GUARDAR RESULTADOS  ARRAY
import android.app.Application;

public class Preguntasaplicadas extends Application {
    private String nopregunta;
    private String pregunta;
    private String respuesta;
    private String correctoyn;

    public String getNopregunta() {
        return nopregunta;
    }

    public void setNopregunta(String nopregunta) {
        this.nopregunta = nopregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getCorrectoyn() {
        return correctoyn;
    }

    public void setCorrectoyn(String correctoyn) {
        this.correctoyn = correctoyn;
    }

    @Override
    public String toString() {
        return "Preguntasaplicadas{" +
                "nopregunta='" + nopregunta + '\'' +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", correctoyn='" + correctoyn + '\'' +
                '}';
    }
}
