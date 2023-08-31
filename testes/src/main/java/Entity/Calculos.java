package Entity;

import lombok.Data;

@Data
public class Calculos {

    private Double media;

    private Double desvioPadrao;

    private Double mediana;

    private int quantidade;

    public Calculos(){

    }
    public Calculos(Double media, Double desvioPadrao, Double mediana, int quantidade) {
        this.media = media;
        this.desvioPadrao = desvioPadrao;
        this.mediana = mediana;
        this.quantidade = quantidade;
    }
}
