package com.examples.composite.empresa;

import com.examples.composite.interfaces.IFuncionario;

/**
 * Esta classe descreve os comportamentos e propriedades referentes a um funcionÃ¡rio. Definimos as
 * propriedades que descrevem o funcionÃ¡rio (nome, area, salario) e o mÃ©todo da interface (detalharFuncionario)
 * com o print dos dados do funcionÃ¡rio.
* */

public class Funcionario implements IFuncionario {
    private String nome;
    private String area;
    private int salario;

    public Funcionario(String nome, String area, int salario)
    {
        this.nome = nome;
        this.area = area;
        this.salario = salario;
    }

    @Override
    public String detalharFuncionario() {
        return ("Dados do empregado: [ Nome: " + this.nome +
                ", Ã�rea: " + this.area + ", SalÃ¡rio: " + this.salario + "]");
    }


}
