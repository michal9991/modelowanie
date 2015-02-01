package uz.issi.modelowanie.projekt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Klasa obslugujaca dodatki do napojow. Dodaje, usuwa, wyswietla wybrane,
 * wszystkie dodatki. Dodatkowo klasa jest odpowiedzialna za dostarczenie
 * dodatku do kubka.
 * 
 * @author Micha³ Kowalec 331 IZZ
 */

public class Dodatek implements Zdarzenie {

	Scanner wejscie = new Scanner(System.in);
	ArrayList<String> listaDodatkow = new ArrayList<String>();
	private String nazwa;

	/**
	 * Wczytuje nazwe dodatku.
	 */

	private String wczytajNazwe() {
		System.out.print("Podaj nazwe dodatku:");
		return wejscie.nextLine();
	}

	/**
	 * Wczytuje nazwe dodatku oraz dodaje elementy do arraylisty listaDodatkow.
	 */
	public void dodaj() {
		nazwa = wczytajNazwe();
		sprawdzNazwe(nazwa);
		listaDodatkow.add(nazwa);
	}

	/**
	 * Dodaje elementy do arraylisty listaDodatkow.
	 * 
	 * @param nazwa
	 *            nazwa dodawanego dodatku.
	 */
	public void dodaj(String nazwa) {
		listaDodatkow.add(nazwa);
	}

	/**
	 * Usuwa elementy z arraylisty listaDodatkow.
	 * 
	 * @param pozycja
	 *            pozycja usuwanego elementu
	 */
	public void usun(int pozycja) {
		if (pozycja > listaDodatkow.size() || pozycja < 0) {
			throw new IndexOutOfBoundsException("nieprawidlowa wartosc!");
		}
		listaDodatkow.remove(pozycja);
	}

	/**
	 * Zwraca nazwe dodatku na danej pozycji w arrayliscie.
	 * 
	 * @param pozycja
	 *            pozycja usuwanego elementu
	 */
	public String pokazNazwe(int pozycja) {
		return listaDodatkow.get(pozycja).toString();
	}

	/**
	 * Wypisuje cala liste dodanych elementow z arraylisty listaDodatkow przy
	 * u¿yciu iteratora
	 */
	public void pokazWszystkie() {
		Iterator<String> iterator = listaDodatkow.iterator();
		int licznik = 1;

		System.out.println();
		System.out.println("Lista dodatkow:");

		while (iterator.hasNext()) {
			System.out.println(licznik + ". " + iterator.next());
			licznik++;
		}
	}

	/**
	 * Dodaje do listy standardowe dodatki.
	 */
	public void dodajStandardoweDodatki() {
		listaDodatkow.add("Posypka");
		listaDodatkow.add("Smietanka");
		listaDodatkow.add("Wisienka");
		listaDodatkow.add("Syrop orzechowy");
	}

	/**
	 * Dodaje do kubka wybrany dodatek.
	 * 
	 * @param nazwa
	 *            nazwa dodatku
	 */
	public void dodajDoKubka(String nazwa) {
		System.out.println("Dodaje " + nazwa + " do kubka");
	}
	
	private void sprawdzNazwe(String nazwa) throws IllegalArgumentException {
		if (nazwa.isEmpty())
			throw new IllegalArgumentException("nazwa nie moze byc pusta");
	}

}
