package com.example.proj102;
//CLASE PARA GUARDAR LA LISTA DE PREGUNTAS
//LEIDAS DESDE EL CSV
public class Preguntalineadedato {
    private String nopregunta;
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String imagen;
    private String respuesta;

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

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Preguntalineadedato{" +
                "nopregunta='" + nopregunta + '\'' +
                ", pregunta='" + pregunta + '\'' +
                ", opcion1='" + opcion1 + '\'' +
                ", opcion2='" + opcion2 + '\'' +
                ", opcion3='" + opcion3 + '\'' +
                ", opcion4='" + opcion4 + '\'' +
                ", imagen='" + imagen + '\'' +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }
}
