package uz.issi.modelowanie.projekt;

public class Grzalka {
	Pompa pompa = new Pompa();
	private boolean czyGotowa = false;

	/**
	 * Metoda uruchomiaj¹ca grza³kê. Sprawdza równie¿ czy grza³ka jest
	 * rozgrzana.
	 */
	public void uruchom() {
		System.out.println("Uruchamiam grzalke");
		czyGotowa = true;
		if (czyGotowa == true)
			gotowa();
	}

	/**
	 * Metoda ustawiaj¹ca temperature grza³ki.
	 * 
	 * @param temperatura
	 *            wartoœæ temperatury.
	 */
	public void ustawTemperature(int temperatura) {
		System.out.println("Ustawiam temperature grzalki[" + temperatura
				+ " C]");

	}

	/**
	 * Metoda wywolywana wtedy, gdy grzalka jest nagrzana.
	 */
	private void gotowa() {
		System.out.println("Grzalka nagrzana");
		pompa.uruchom();
	}

}
