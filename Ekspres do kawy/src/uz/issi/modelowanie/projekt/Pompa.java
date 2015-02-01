package uz.issi.modelowanie.projekt;

/**
 * Klasa steruj�ca pomp�. Uruchamia j� oraz ustawia dane ci�nienie wody.
 * 
 * @author Micha� Kowalec 331 IZZ
 */
public class Pompa {
	boolean czyGotowa = false;

	/**
	 * Metoda uruchomiaj�ca pompe.
	 */
	public void uruchom() {
		System.out.println("Uruchamiam pompe wody");
	}

	/**
	 * Metoda ustawiaj�ca ci�nienie wody w pompie.
	 * 
	 * @param cisnienieWody
	 *            cisnienie wody.
	 */
	public void ustawCisnienieWody(int cisnienieWody) {
		System.out
				.println("Ustawiam cisnienie wody[" + cisnienieWody + " bar]");
	}

	/**
	 * Metoda uruchomiaj�ca t�oczenie wody do g�owicy
	 */
	public void tloczWode() {
		czyGotowa = true;
		if (czyGotowa == true)
			System.out.println("Tlocze wode do glowicy");
		else
			throw new IllegalAccessError("Pompa jest wylaczona!");
	}
}
