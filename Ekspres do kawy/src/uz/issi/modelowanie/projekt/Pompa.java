package uz.issi.modelowanie.projekt;

/**
 * Klasa steruj¹ca pomp¹. Uruchamia j¹ oraz ustawia dane ciœnienie wody.
 * 
 * @author Micha³ Kowalec 331 IZZ
 */
public class Pompa {
	boolean czyGotowa = false;

	/**
	 * Metoda uruchomiaj¹ca pompe.
	 */
	public void uruchom() {
		System.out.println("Uruchamiam pompe wody");
	}

	/**
	 * Metoda ustawiaj¹ca ciœnienie wody w pompie.
	 * 
	 * @param cisnienieWody
	 *            cisnienie wody.
	 */
	public void ustawCisnienieWody(int cisnienieWody) {
		System.out
				.println("Ustawiam cisnienie wody[" + cisnienieWody + " bar]");
	}

	/**
	 * Metoda uruchomiaj¹ca t³oczenie wody do g³owicy
	 */
	public void tloczWode() {
		czyGotowa = true;
		if (czyGotowa == true)
			System.out.println("Tlocze wode do glowicy");
		else
			throw new IllegalAccessError("Pompa jest wylaczona!");
	}
}
