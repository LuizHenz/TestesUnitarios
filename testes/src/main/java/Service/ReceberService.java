package Service;

import DTO.ReceberDTO;
import Entity.Calculos;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

public class ReceberService {
    private Calculos calculos;

    public Calculos verify(final ReceberDTO receberDTO){

        Assert.isTrue(receberDTO.getNumeroList().size() < 20, "Lista menor que 20 itens");

        media(receberDTO.getNumeroList());
        alert(receberDTO.getNumeroList());
        tamanho(receberDTO.getNumeroList());
        mediana(receberDTO.getNumeroList());

        return new ReceberDTO(media(receberDTO.getNumeroList()),alert(receberDTO.getNumeroList()),mediana(receberDTO.getNumeroList()),tamanho(receberDTO.getNumeroList()));

    }

    public Double media(List<Double> lista){

        Double media,soma = 0.0;

        for(Double i : lista){
            soma += i;
        }

        return media = soma / lista.size();

    }

    public Double alert(List<Double> lista){
        Double result = 0.0;
        Double i = media(lista);

        for(Double j: lista){

            Double quadrado = Math.pow(j-i, 2);
            result += quadrado;
        }

        result /= lista.size();

        return  Math.sqrt(result);

    }

    public int tamanho(List<Double> lista){
        return lista.size();
    }

    public Double mediana(List<Double> lista){

        Collections.sort(lista);

        int meio = lista.size() / 2;

        if(lista.size() % 2 == 1){
            return lista.get(meio);
        }else{
            return  lista.get(meio - 1) + lista.get(meio) / 2;
        }
    }

    public Double valorMin(List<Double> lista){
        Collections.sort(lista);

        return lista.get(0);
    }

    public Double valorMax(List<Double> lista){
        Collections.sort(lista);

        return lista.get(lista.size()-1);
    }


    public Double sum(List<Double> lista){
        Double result = 0.0;
        for(int i = 0; i < lista.size(); i++){
            result += lista.get(i);
        }
        return result;
    }
}
