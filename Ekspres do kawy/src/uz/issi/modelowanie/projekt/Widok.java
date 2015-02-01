package uz.issi.modelowanie.projekt;

/**
 * Klasa generuj�ca menu oraz jego podmenu
 * 
 * @author Micha� Kowalec 331 IZZ
 */
public class Widok {

	/** Generuje menu glowne */
	public void pokazMenuGlowne() {
		System.out.println("Witamy w ekspresie do kawy");
		odstepy(1);
		System.out.println("Menu:");
		odstepy(1);
		System.out.println("1. Wybor napoju");
		System.out.println("2. Panel administratora");
		odstepy(1);
		System.out.print("Wybierz opcje:");
	}

	/** Generuje menu panelu administratora */
	public void pokazMenuAdministratora() {

		odstepy(2);
		System.out.println("Panel administratora:");
		odstepy(1);
		System.out.println("1. Dodaj nap�j");
		System.out.println("2. Pokaz napoje");
		System.out.println("3. Usun nap�j");
		System.out.println("4. Dodaj dodatek");
		System.out.println("5. Pokaz dodatki");
		System.out.println("6. Usun dodatek");
		System.out.println("0. Powr�t");
		odstepy(1);
		System.out.print("Wybierz opcje:");
	}

	/** Generuje menu wyboru napoju */
	public void pokazMenuWyboruNapoju() {

		System.out.println("0. Powr�t");
		odstepy(1);
		System.out.print("Wybierz opcje:");

	}

	/** Generuje menu wyboru dodatku */
	public void pokazMenuWyboruDodatku() {

		System.out.println("0. Bez dodatku");
		odstepy(1);
		System.out.print("Wybierz opcje:");
	}

	/**
	 * Tworzy odst�py w postaci println.
	 * 
	 * @param ilosc
	 *            ilosc odst�p�w
	 */
	public void odstepy(int ilosc) {
		for (int licznik = 0; licznik < ilosc; licznik++) {
			System.out.println();
		}
	}
}
