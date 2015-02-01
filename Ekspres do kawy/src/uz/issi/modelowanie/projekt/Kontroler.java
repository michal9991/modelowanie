package uz.issi.modelowanie.projekt;

import java.util.Scanner;

/**
 * Klasa steruj¹ca ekspresem. Obs³uguje menu, przygotowywuje wybrany napój,
 * dodatkowo wsypuje cukier i dodaje mleko.
 * 
 * @author Micha³ Kowalec 331 IZZ
 */

public class Kontroler {

	Scanner wejscie = new Scanner(System.in);
	String wybranyNapoj;
	String wybranyDodatek;
	int poziomCukru;
	int poziomMleka;
	int porcjeCukru;
	int porcjeMleka;

	Widok widok = new Widok();
	Napoj napoj = new Napoj();
	Dodatek dodatek = new Dodatek();
	Pompa pompa = new Pompa();
	Grzalka grzalka = new Grzalka();

	/**
	 * Metoda s³u¿¹ca do wczytywania liczby z klawiatury.
	 * 
	 * @return liczbê wczytan¹ z klawiatury.
	 */

	public int wczytajOpcje() {
		int opcja;
		opcja = wejscie.nextInt();
		return opcja;
	}

	/**
	 * Dodaje do ekspresu standardowe produkty.
	 */
	public void dodajStandardoweProdukty() {
		napoj.dodajStandardoweNapoje();
		dodatek.dodajStandardoweDodatki();
	}

	/**
	 * Obs³uguje menu g³ówne.
	 * 
	 * @param opcja
	 *            Wybierana opcja.
	 */
	public void wybierzOpcjeMenuGlownego(int opcja) {
		switch (opcja) {
		case 1:
			wybierzNapoj();
			break;

		case 2:
			pokazMenuAdministratora();
			break;

		default:
			System.out.println("Z³y wybór, wybierz ponownie");
			pokazMenuGlowne();

		}

	}

	/**
	 * Obs³uguje i wyswietla menu panelu administratora.
	 */
	public void pokazMenuAdministratora() {
		widok.pokazMenuAdministratora();
		wybierzOpcjeMenuAdministratora(wczytajOpcje());
	}

	/**
	 * Obs³uguje i wyswietla menu wyboru napoju.
	 */
	public void wybierzNapoj() {
		widok.odstepy(4);
		napoj.pokazWszystkie();
		widok.pokazMenuWyboruNapoju();
		wybierzOpcjeMenuWyboru(wczytajOpcje());
	}

	/**
	 * Obs³uguje menu wyboru napoju.
	 * 
	 * @param opcja
	 *            Wybierana opcja.
	 */
	public void wybierzOpcjeMenuWyboru(int opcja) {
		if (opcja == 0) {
			pokazMenuGlowne();
		}

		if (opcja > napoj.listaNapojow.size() || opcja < 0)
			throw new IllegalArgumentException("Nie ma takiego napoju!");
		widok.odstepy(3);
		zrobNapoj(opcja);

	}

	/**
	 * Obsluguje menu wyboru dodatku.
	 * 
	 * @param opcja
	 *            wybierana opcja
	 */
	private void wybierzOpcjeMenuWyboruDodatku(int opcja) {

		if (opcja > dodatek.listaDodatkow.size() || opcja < 0)
			throw new IllegalArgumentException("Nie ma takiego dodatku!");

		wybranyDodatek = dodatek.listaDodatkow.get(opcja - 1);

	}

	/**
	 * Obs³uguje menu panelu administratora.
	 * 
	 * @param opcja
	 *            Wybierana opcja.
	 */
	public void wybierzOpcjeMenuAdministratora(int opcja) {

		switch (opcja) {

		case 0:
			pokazMenuGlowne();
			break;

		case 1:
			napoj.dodaj();
			pokazMenuAdministratora();
			break;

		case 2:
			pokazWszystkieNapoje();
			pokazMenuAdministratora();

		case 3:
			usunNapoj();
			break;
		case 4:
			dodatek.dodaj();
			pokazMenuAdministratora();
			break;

		case 5:
			pokazWszystkieDodatki();
			break;
		case 6:
			usunDodatek();
			break;
		default:
			System.out.println("Z³y wybór, wybierz ponownie");
			pokazMenuAdministratora();
		}
	}

	/**
	 * Obsluguje usuwanie dodatku.
	 */
	public void usunDodatek() {
		if (dodatek.listaDodatkow.isEmpty()) {
			System.out.println("Nie ma co usuwac!");
			pokazMenuAdministratora();
		} else {
			System.out.print("Podaj numer usuwanego dodatku:");
			dodatek.usun(wczytajOpcje() - 1);
			pokazMenuAdministratora();
		}
	}

	/**
	 * Wyswietla wszystkie dodatki wprowadzone do arraylisty.
	 */
	public void pokazWszystkieDodatki() {
		if (dodatek.listaDodatkow.isEmpty()) {
			System.out.println("Nie ma ¿adnych dodatków!");
			pokazMenuAdministratora();
		} else {
			dodatek.pokazWszystkie();
			widok.odstepy(1);
			System.out
					.println("Wcisnij enter zeby wrocic do menu administratora...");
			wejscie.nextLine();
			pokazMenuAdministratora();
		}
	}

	/**
	 * Wyswietla wszystkie napoje wprowadzone do arraylisty.
	 */
	public void pokazWszystkieNapoje() {
		if (napoj.listaNapojow.isEmpty()) {
			System.out.println("Nie ma ¿adnych napojów!");
		} else
			napoj.pokazWszystkie();
		widok.odstepy(1);
		System.out
				.println("Wcisnij enter zeby wrocic do menu administratora...");
		wejscie.nextLine();
	}

	/**
	 * Obs³uguje i wyswietla menu glowne.
	 */
	public void pokazMenuGlowne() {
		widok.odstepy(1);
		widok.pokazMenuGlowne();
		wybierzOpcjeMenuGlownego(wczytajOpcje());
	}

	/**
	 * Obsluguje usuwanie napoju
	 */
	private void usunNapoj() {
		if (napoj.listaNapojow.isEmpty()) {
			System.out.println("Nie ma co usuwac!");
			pokazMenuAdministratora();
		} else {
			System.out.print("Podaj numer usuwanego napoju:");
			napoj.usun(wczytajOpcje() - 1);
			pokazMenuAdministratora();
		}
	}

	/**
	 * Tworzy wybrany napoj.
	 * 
	 * @param opcja
	 *            wybierany napoj
	 */
	private void zrobNapoj(int opcja) {

		wybranyNapoj = napoj.listaNapojow.get(opcja - 1).getNazwa();
		dodatek.pokazWszystkie();
		widok.pokazMenuWyboruDodatku();
		wybierzOpcjeMenuWyboruDodatku(wczytajOpcje());

		widok.odstepy(1);
		System.out.print("Podaj ilosc porcji cukru:");
		porcjeCukru = porcjeCukru(wczytajOpcje());
		if (porcjeCukru > 0) {
			System.out.print("Podaj ilosc cukru w porcji [0-5]:");
			poziomCukru = poziomCukru(wczytajOpcje());
		}
		System.out.print("Podaj ilosc porcji mleka:");
		porcjeMleka = porcjeMleka(wczytajOpcje());
		if (porcjeMleka > 0) {
			System.out.print("Podaj ilosc mleka w porcji [0-5]:");
			poziomMleka = poziomMleka(wczytajOpcje());
		}
		widok.odstepy(1);
		System.out.println("Robie " + wybranyNapoj + "...");
		grzalka.ustawTemperature(napoj.listaNapojow.get(opcja - 1)
				.getTemperatura());
		pompa.ustawCisnienieWody(napoj.listaNapojow.get(opcja - 1)
				.getCisnienie());
		grzalka.uruchom();
		napoj.wsyp(wybranyNapoj);
		wsypCukier();
		pompa.tloczWode();
		wylejZawartoscGlowicy();
		wlejMleko();
		dodatek.dodajDoKubka(wybranyDodatek);
		wysunKubek();

	}

	/**
	 * Sprawdza poprawnoœæ wyboru poziomu cukru
	 * 
	 * @param poziom
	 *            poziom cukru.
	 * 
	 * @return poziom poziom cukru.
	 */
	public int poziomCukru(int poziom) {
		if (poziom > 5 || poziom < 0)
			throw new IllegalArgumentException("Niepoprawna wartosc cukru!");
		else
			return poziom;
	}

	/**
	 * Sprawdza poprawnoœæ wyboru porcji cukru.
	 * 
	 * @param ilosc
	 *            ilosc porcji.
	 * 
	 * @return ilosc ilosc porcji.
	 */
	public int porcjeCukru(int ilosc) {
		if (ilosc < 0)
			throw new IllegalArgumentException("Niepoprawna wartosc cukru!");
		else
			return ilosc;
	}
	/**
	 * Metoda odpowiedzialna za wsypywanie cukru.
	 */
	private void wsypCukier() {
		poziomCukru = poziomCukru * porcjeCukru;
		if (poziomCukru > 0)
			System.out.println("Wsypuje " + poziomCukru + " miarki cukru");
	}

	/**
	 * Sprawdza poprawnoœæ wyboru poziomu mleka
	 * 
	 * @param poziom
	 *            poziom mleka.
	 */
	public int poziomMleka(int poziom) {
		if (poziom > 5 || poziom < 0) {
			throw new IllegalArgumentException("Niepoprawna wartosc mleka!");
		} else {
			return poziom;
		}
	}

	/**
	 * Sprawdza poprawnoœæ wyboru porcji mleka.
	 * 
	 * @param ilosc
	 *            ilosc porcji.
	 * 
	 * @return ilosc ilosc porcji.
	 */
	public int porcjeMleka(int ilosc) {
		if (ilosc < 0)
			throw new IllegalArgumentException("Niepoprawna wartosc mleka!");
		else
			return ilosc;
	}

	/**
	 * Metoda odpowiedzialna za wlewanie mleka.
	 */
	private void wlejMleko() {
		poziomMleka = poziomMleka * porcjeMleka;
		if (poziomMleka > 0)
			System.out.println("Wlewam " + poziomMleka * 10
					+ " ml mleka do kubka");
	}

	/**
	 * Metoda odpowiedzialna za wlewanie zawartosci glowicy do kubka.
	 */
	private void wylejZawartoscGlowicy() {
		System.out.println("Wlewam do kubka zawartosc glowicy");
	}

	/**
	 * Metoda odpowiedzialna za wysuwanie kubka oraz o komunikowanie o zakonczeniu procesu.
	 */
	private void wysunKubek() {
		System.out.println("Gotowe!");
	}
}
