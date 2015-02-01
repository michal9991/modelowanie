package uz.issi.modelowanie.projekt;

public class Grzalka {
	Pompa pompa = new Pompa();
	private boolean czyGotowa = false;

	/**
	 * Metoda uruchomiaj�ca grza�k�. Sprawdza r�wnie� czy grza�ka jest
	 * rozgrzana.
	 */
	public void uruchom() {
		System.out.println("Uruchamiam grzalke");
		czyGotowa = true;
		if (czyGotowa == true)
			gotowa();
	}

	/**
	 * Metoda ustawiaj�ca temperature grza�ki.
	 * 
	 * @param temperatura
	 *            warto�� temperatury.
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
