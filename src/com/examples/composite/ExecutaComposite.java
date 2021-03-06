package com.examples.composite;

import com.examples.composite.empresa.Funcionario;
import com.examples.composite.empresa.Gerente;
import com.examples.composite.game.Caixa;
import com.examples.composite.game.Fase;
import com.examples.composite.game.Inimigo;
import com.examples.composite.interfaces.IFuncionario;
import com.examples.composite.interfaces.IObjeto;

/**
 * Classe inicial do exemplo.
 *
 * Apresentamos dois exemplos de composite.
 *
 * O primeiro exemplo consiste na montagem de uma hierarquia de objetos que implementam a interface "IFuncionario" para
 * representar a hierarquia de uma empresa. A classe funcionário descreve três dados básicos:
 * nome, cargo e salário. A Classe Gerente, além das 3 propriedades citadas, acrescenta um array com a lista de
 * subordinados imediatos.
 * Uma vez montada a hierarquia o sistema executa uma busca para exibir essa hierarquia no
 * console exibindo a hierarquia existente.
 *
 * O segundo exemplo é a construção de uma hierarquia de inimigos do game Mario Bros (exemplo apresentado
 * em aula). Este exemplo tem continuidade no pattern Strategy. Neste caso o exemplo consiste
 * na instanciação e definição dos inimigos, criando uma hierarquia com base na especialização dos inimigos
 * (por exemplo, no primeiro nível uma tartaruga, o segundo uma tartaruga com asas, etc.).
 * Todos os objetos "Inimigo" possui um método render(), que seria responsável pela renderização do objeto
 * no jogo.
 *
 * @author Ricardo D. Agulhari
 * Janeiro/2017
 */
public class ExecutaComposite {

    public static void go() {
        System.out.println("----------Iniciando teste do case 'Funcionarios'-----------");
        testeHierarquiaEmpresa();
        System.out.println("----------Fim do teste do case 'Funcionarios'-----------");
        System.out.println("\n\n----------Iniciando teste do case 'Hierarquia de inimigos Mario Bros'-----------");
        testeMarioBrosInimigos();
        System.out.println("----------Fim do teste do case 'Hierarquia de inimigos Mario Bros'-----------");

    }

    private static void testeHierarquiaEmpresa() {
        /*
        * A primeira parte do exemplo consiste em criar todos os objetos Funcionários e Gerentes
        * e o encadeamento entre os objetos, utilizando o método "incluirSubordinado".
        *
        * A inclusão é sempre do superior para os funcionários. Assim, o presidente possui
        * dois diretores abaixo dele, assim como cada diretor possui sua hierarquia.
        * */

        Gerente presidente = new Gerente("Francisco", "Presidência da empresa", 10000);
        Gerente diretorVendas = new Gerente("Roberta", "Diretora de Vendas", 8000);
        Gerente diretorMkt = new Gerente("Osmair", "Diretor de Marketing", 8000);
        
        Funcionario vendedor1 = new Funcionario("Janete", "Vendedora", 2700);
        Funcionario vendedor2 = new Funcionario("Claudio", "Vendedor", 3000);
        Funcionario vendedor3 = new Funcionario("Matheus", "Vendedor", 2800);
        
        Funcionario asssistentemkt1 = new Funcionario("Ana Cláudia", "Assistente de Marketing", 2500);
        Funcionario designer1 = new Funcionario("Jhonny", "Designer", 1600);
        Funcionario designer2 = new Funcionario("Antônio", "Designer", 1800);

        diretorVendas.incluirSubordinado(vendedor1);
        diretorVendas.incluirSubordinado(vendedor2);
        diretorVendas.incluirSubordinado(vendedor3);

        diretorMkt.incluirSubordinado(asssistentemkt1);
        diretorMkt.incluirSubordinado(designer1);
        diretorMkt.incluirSubordinado(designer2);

        presidente.incluirSubordinado(diretorVendas);
        presidente.incluirSubordinado(diretorMkt);

        /*
        * Após a definição dos objetos e a estruturação destes em uma hierarquia, executamos um método
        * comum a todos, detalharFuncionario(), para mostrar as informações de cada instância. Este exemplo já
        * considera que são 2 níveis de hierarquia. Para um exemplo que trabalhe com qualquer hierarquia, é necessário
        * refatorar a forma de percorrer essa lista.
        * */

        System.out.println(presidente.detalharFuncionario());
        for (IFuncionario diretor: presidente.getSubordinados()) {

            System.out.println("\t" + diretor.detalharFuncionario());

            if (diretor instanceof Gerente) {
                for (IFuncionario func : ((Gerente)diretor).getSubordinados())
                    System.out.println("\t\t" + func.detalharFuncionario());
            }
        }

    }

    private static void testeMarioBrosInimigos() {

        /*Como no exemplo de hierarquia da empresa, a primeira parte do exemplo é a instanciação
        * dos objetos do tipo inimigo e a montagem da hierarquia dos objetos.
        * */

        Fase f12 = new Fase("Mundo 1-2");

        f12.add(new Caixa(3, "item"));
        f12.add(new Caixa(3, "tijolo"));
        f12.add(new Caixa(1, "tijolo"));
        f12.add(new Caixa(3, "pedra"));
        f12.add(new Caixa(2, "item"));

        f12.add(new Inimigo("Goomba", 1, 3));
        f12.add(new Inimigo("Tartaruga verde", 1, 2));
        f12.add(new Inimigo("Tartaruga verde", 2, 4));
        f12.add(new Inimigo("Tartaruga vermelha", 1, 4));

        /*
        * A segunda parte do exemplo consiste em percorrer a lista de objetos e das respectivas
        * hierarquias, executando em todos os objetos o método "render()", para demonstrar a forma
        * como se dá o encadeamento destes objetos.
        * */

        System.out.println(f12.titulo);
        for (IObjeto i : f12.getObjetos()) {

            System.out.println("\t" + i.render());

        }
    }
}
