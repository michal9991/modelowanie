package uz.issi.modelowanie.projekt;

/**
 * Klasa g��wna programu.
 * 
 * @author Micha� Kowalec 331 IZZ
 */
public class Main {

	public static void main(String[] args) {
		Widok widok = new Widok();
		Kontroler kontroler = new Kontroler();

		kontroler.dodajStandardoweProdukty();
		widok.pokazMenuGlowne();
		kontroler.wybierzOpcjeMenuGlownego(kontroler.wczytajOpcje());

	}

}
