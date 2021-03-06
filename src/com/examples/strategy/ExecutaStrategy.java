package com.examples.strategy;

import com.examples.composite.game.Inimigo;
import com.examples.strategy.interfaces.IAtaque;

/**
 * classe inicial do exemplo.
 *
 * Strategy é um padrão que consiste na implementação de algoritmos
 * diferentes para resolver um mesmo problema, de modo que a forma de
 * resolução possa ser definida pelo sistema, conforme mais apropriado ao
 * contexto que se apresenta.
 *
 * Nosso exemplo é complementar ao exemplo do padrão Composite, que se define
 * inimigos para um jogo. Neste exemplo um mesmo inimigo pode ter padrões
 * diferentes de ataque. Para definir o padrão de ataque de um inimigo se usa o
 * padrão Strategy.
 *
 * Definimos dois tipos de ataque, um descrito na classe "AtaqueFogo" outro na
 * classe "AtaqueVoador". Esses ataques são atribuidos aos inimigos criados na
 * classe ExecutaStrategy e uma simulação de ataque é realizado por cada um
 *
 * @author Ricardo D. Agulhari Março/2017
 */
public class ExecutaStrategy {

	public static void main(String[] args) {

		// realizarAtaque é um método que invoca o ataque do algoritmo escolhido para
		// o objeto

		// Definimos quatro inimigos para o exemplo, usando a classe Inimigo definido no
		// exemplo de Composite
		Inimigo tartaruga1 = new Inimigo("Tartaruga básica 1", 2, 1);
		Inimigo tartaruga2 = new Inimigo("Tartaruga básica 2", 2, 1);
		Inimigo tartaruga3 = new Inimigo("Tartaruga básica 3", 2, 1);
		Inimigo flor1 = new Inimigo("Flor de fogo", 4, 2);

		/*
		 * Criamos um objeto para cada tipo de ataque. O objeto será atribuído ao
		 * inimigo para que o mesmo possa realizar a ação.
		 */
		IAtaque ataque = new AtaqueVoador();

		/*
		 * abaixo iniciamos a execução d exemplo. Primeiramente atribuimos um ataque
		 * ao inimigo pelo método "defineInimigo" e depois executamos o método
		 * estático "realizarAtaque" para que o algoritmo de ataque seja executado para
		 * o inimigo selecionado
		 */
		System.out.println("-------------");
		ataque.defineInimigo(tartaruga1.tituloInimigo);
		System.out.println(ataque.atacar());
		System.out.println("-------------");
		ataque.defineInimigo(tartaruga2.tituloInimigo);
		System.out.println(ataque.atacar());
		System.out.println("-------------");
		ataque.defineInimigo(tartaruga3.tituloInimigo);
		System.out.println(ataque.atacar());

		ataque = new AtaqueFogo();

		System.out.println("-------------");
		ataque.defineInimigo(flor1.tituloInimigo);
		System.out.println(ataque.atacar());

	}

}
