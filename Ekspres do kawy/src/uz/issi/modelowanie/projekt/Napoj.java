package uz.issi.modelowanie.projekt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Klasa obslugujaca napoje. Dodaje, usuwa, wyswietla wybrane, wszystkie napoje.
 * Dodatkowo klasa jest odpowiedzialna za dostarczenie napoju do kubka oraz
 * sprawdzenie poprawnoœci wprowadzonej temperatury oraz ciœnienia
 * 
 * @author Micha³ Kowalec 331 IZZ
 */
public class Napoj implements Zdarzenie {

	public ArrayList<Napoj> listaNapojow = new ArrayList<Napoj>();
	Scanner wejscie = new Scanner(System.in);

	private String nazwa;
	private int temperatura;
	private int cisnienie;
	private final int MaxCisnienie = 40;
	private final int MaxTemperatura = 100;


	public Napoj(String nazwa, int temperatura, int cisnienie) {
		this.nazwa = nazwa;
		this.temperatura = temperatura;
		this.cisnienie = cisnienie;
	}

	public Napoj() {
	}

	/**
	 * Wczytuje nazwe napoju.
	 * 
	 * @return nazwa nazwa wczytanego napoju
	 */
	private String wczytajNazwe() {
		return wejscie.nextLine();
	}

	/**
	 * Dodaje napój przy u¿yciu metod: setNazwa,setTemperatura,setCiœnienie.
	 */
	public void dodaj() {
		setNazwa();
		setTemperatura();
		setCisnienie();
		listaNapojow.add(new Napoj(nazwa, temperatura, cisnienie));
	}

	/**
	 * Dodaje napój przy u¿yciu parametrow.
	 * 
	 * @param nazwa
	 *            nazwa napoju
	 * @param temperatura
	 *            temperatura napoju
	 * @param cisnienie
	 *            cisnienie napoju
	 */
	public void dodaj(String nazwa, int temperatura, int cisnienie) {
		listaNapojow.add(new Napoj(nazwa, temperatura, cisnienie));
	}

	/**
	 * Usuwa wybrany napój.
	 * 
	 * @param pozycja
	 *            pozycja usuwanego napoju.
	 */
	public void usun(int pozycja) {
		if (pozycja > listaNapojow.size() || pozycja < 0)
			throw new IndexOutOfBoundsException("nieprawidlowa wartosc!");
		listaNapojow.remove(pozycja);
	}

	/**
	 * Wyœwietla ca³¹ listê dodanych napojów przy u¿yciu iteratora.
	 */
	public void pokazWszystkie() {
		int licznik = 1;
		Iterator<Napoj> iterator = listaNapojow.iterator();

		System.out.println();
		System.out.println("Lista napojow:");

		while (iterator.hasNext()) {
			System.out.println(licznik + ". " + iterator.next().getNazwa());
			licznik++;
		}
	}

	/**
	 * Pobiera nazwe napoju.
	 * 
	 * @return nazwa nazwa napoju
	 */
	public String getNazwa() {
		return nazwa;
	}

	/**
	 * Wczytuje nazwe napoju
	 */
	public void setNazwa() {
		System.out.print("Podaj nazwe napoju:");
		nazwa = wczytajNazwe();
		sprawdzNazwe(nazwa);
	}

	/**
	 * Sprawdza poprawnoœæ wprowadzonej nazwy.

	 * @throws IllegalArgumentException
	 */
	private void sprawdzNazwe(String nazwa) throws IllegalArgumentException {
		if (nazwa.isEmpty())
			throw new IllegalArgumentException("nazwa nie moze byc pusta");
	}

	/**
	 * Pobiera temperature napoju.
	 * 
	 * @return temperatura temperatura napoju
	 */
	public int getTemperatura() {
		return temperatura;
	}

	/**
	 * Wczytuje temperature napoju i sprawdza jej poprawnosc
	 */
	public void setTemperatura() {
		System.out.print("Podaj wartosc temperatury [max 100]:");
		temperatura = wejscie.nextInt();
		sprawdzTemperature(temperatura);
	}

	/**
	 * Sprawdza poprawnoœæ wprowadzonej wartoœci temperatury.
	 * 
	 * @param temperatura
	 *            temperatura napoju.
	 */
	private void sprawdzTemperature(int temperatura) {
		if (temperatura < 0 || temperatura > MaxTemperatura)
			throw new IllegalArgumentException(
					"niepoprawna wartosc temperatury!");

	}

	/**
	 * Pobiera cisnienie napoju.
	 * 
	 * @return cisnienie cisnienie napoju
	 */
	public int getCisnienie() {
		return cisnienie;
	}

	/**
	 * Wczytuje cisnienie napoju i sprawdza jego poprawnosc.
	 */
	public void setCisnienie() {
		System.out.print("Podaj wartosc cisnienia [max:40]:");
		cisnienie = wejscie.nextInt();
		wejscie.nextLine();
		sprawdzCisnienie(cisnienie);
	}

	/**
	 * Sprawdza poprawnoœæ wprowadzonej wartoœci ciœnienia.
	 * 
	 * @param cisnienie
	 *            cisnienie napoju.
	 */
	private void sprawdzCisnienie(int cisnienie) {
		if (cisnienie < 0 || cisnienie > MaxCisnienie) {
			throw new IllegalArgumentException("niepoprawna wartosc cisnienia!");
		}

	}

	/**
	 * Wsypuje napój do g³owicy.
	 * 
	 * @param nazwa
	 *            nazwa wsypywanego napoju.
	 */
	public void wsyp(String nazwa) {
		System.out.println("Wsypuje " + nazwa + " do glowicy");
	}

	/**
	 * Dodaje standardowe napoje.
	 */
	public void dodajStandardoweNapoje() {
		listaNapojow.add(new Napoj("Kawa czarna", 80, 2));
		listaNapojow.add(new Napoj("Latte", 70, 1));
		listaNapojow.add(new Napoj("Cappucino", 85, 1));
	}

}
