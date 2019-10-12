package HW4;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		//Creates a 2 Dimensional array with two rows, each row can contain 3 Pokemon.
		Pokemon[][] arrOfPokemons = new Pokemon[2][3];
		Scanner stdIn = new Scanner(System.in);

		//TODO	- Completely fill 2 Dimensional array with Pokemon.
		//		- The first row is considered the first player.
		//		- The second row is the second player.
		//		- No duplicate pokemon are allowed throughout the entire 2D array.
		//		- It is ok if your program crashes if you use Integer.parseInt().
		
		System.out.println();

		System.out.println("Pokemons before playing");
		print(arrOfPokemons);
		System.out.println();
		
		play(arrOfPokemons);
		
		System.out.println();
		System.out.println();
		System.out.println("Pokemons After playing");
		print(arrOfPokemons);

		stdIn.close();
	}

	/**
	 * Print out all pokemon in the 2D array.
	 * The first row is the player one, the second row is player two.
	 * See example output in homework description for format.
	 * 
	 * @param arrOfPokemons
	 */
	private static void print(Pokemon[][] arrOfPokemons){

		//TODO

	}

	/**
	 * Very basic implemenation of a pokemon game.
	 * Player one and two randomly selects a Pokemon from their deck.
	 * Each player then randomly selects an attack.
	 * This repeated 6 times.
	 * Nothing to do here.
	 * 
	 * @param arrOfPokemons
	 */
	private static void play(Pokemon[][] arrOfPokemons) {

		int plays = 1;
		int randomPokemonOne, randomPokemonTwo;
		int randomAttackOne, randomAttackTwo;
		Pokemon p1,p2;
		while(plays < 7) {

			System.out.printf("Round %d starting.\n", plays);

			randomPokemonOne = (int)(Math.random()*3);
			randomPokemonTwo = (int)(Math.random()*3);
			randomAttackOne = (int)(Math.random()*2);
			randomAttackTwo = (int)(Math.random()*2);
			p1 = arrOfPokemons[0][randomPokemonOne];
			p2 = arrOfPokemons[1][randomPokemonTwo];

			System.out.printf("%s of Player One is attacking %s of Player Two with %s.\n", 
					p1.getName(), p2.getName(), randomAttackOne == 0 ? "Physical Attack" : "Special Attack");
			
			if(randomAttackOne == 0) {
				p1.physicalAttack(p2);
			} else {
				p1.specialAttack(p2);
			}
			
			System.out.printf("%s of Player Two retaliates with %s.\n", 
					p2.getName(), randomAttackTwo == 0 ? "Physical Attack" : "Special Attack");	

			if(randomAttackTwo == 0) {
				p2.physicalAttack(p1);
			} else {
				p2.specialAttack(p1);
			}
			
			System.out.printf("Round %d is over.\n", plays);
			plays++;
		}

	}

	/**
	 * Create a Pokemon based on the name, health, and power passed in.
	 * The type of pokemon created is based on the name.
	 * If the name is not valid or is null return null.
	 * 
	 * @param name
	 * @param health
	 * @param power
	 * @return
	 */
	static Pokemon makePokemon(String name, int health, int power) {

		//TODO

	}

	/**
	 * Used to verify if a Pokemon exists in the 2D array of Pokemon.
	 * Return true if the pokemon is present, false otherwise.
	 * Watchout for null Pokemon.
	 * 
	 * @param pok
	 * @param arrOfPokemons
	 * @return
	 */
	static boolean contains(Pokemon pok, Pokemon[][] arrOfPokemons) {

		//TODO
		
	}
}
