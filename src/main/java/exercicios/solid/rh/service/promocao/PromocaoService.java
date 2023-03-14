package exercicios.solid.rh.service.promocao;

import exercicios.solid.rh.ValidacaoException;
import exercicios.solid.rh.model.Cargo;
import exercicios.solid.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE == cargoAtual){
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }

        if(metaBatida){
            Cargo novoCargo = cargoAtual.getProximoCargo();
        }else {
            throw new ValidacaoException("Funcionário não bateu a meta!");
        }
    }
}
