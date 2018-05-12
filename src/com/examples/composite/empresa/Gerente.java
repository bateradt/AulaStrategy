package com.examples.composite.empresa;

import java.util.ArrayList;
import java.util.List;

import com.examples.composite.interfaces.IFuncionario;

/**
 * Esta classe descreve os comportamentos e propriedades referentes a um funcionÃ¡rio. Definimos as
 * propriedades que descrevem o funcionÃ¡rio (nome, area, salario), alÃ©m de um objeto que contÃ©m uma lista
 * dos subordinados e o mÃ©todo da interface (detalharFuncionario) com o print dos dados do funcionÃ¡rio.
 * */


public class Gerente implements IFuncionario {
    private String nome;
    private String area;
    private int salario;
    private List<IFuncionario> subordinados;

    public Gerente(String nome, String area, int salario)
    {
        this.nome = nome;
        this.area = area;
        this.salario = salario;
        this.subordinados = new ArrayList<>();
    }

    //MÃ©todo que adiciona um objeto subordinado a um objeto atual
    public void incluirSubordinado(IFuncionario func)
    {
        subordinados.add(func);
    }

    /*MÃ©todo para remoÃ§Ã£o de subordinados. Para a simplificaÃ§Ã£o do exemplo
    * a Ãºnica validaÃ§Ã£o Ã© se o funcionÃ¡rio existe.*/
    public void removerSubordinado(Funcionario func)
    {
        if (subordinados.contains(func))
            subordinados.remove(func);
    }

    //MÃ©todo para retornar a lista de subordinados
    public List<IFuncionario> getSubordinados()
    {
        return subordinados;
    }

    /*ImplementaÃ§Ã£o particular de um mÃ©todo "toString()" que obtem os dados do funcionÃ¡rio
    * e estrutura a impressÃ£o.
    * */

    @Override
    public String detalharFuncionario() {
        return ("Dados do empregado: [ Nome: " + this.nome +
                ", Ã�rea: " + this.area + ", SalÃ¡rio: " + this.salario + ", Subordinados Imediatos: " +
                Integer.toString(this.subordinados.size()) + "]");
    }
}
