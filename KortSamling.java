package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene.
 * Når programmet er ferdig settes denne til 13, men under utvikling / testing
 * kan det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {

		samling = new Kort[MAKS_KORT];
		antall = 0;

	}

	public Kort[] getSamling() {

		return samling;

	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {

		return antall;
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {

		boolean erTom = true;
		for (Kort kort : samling) {
			if (kort != null) {
				erTom = false;
			}
		}
		return erTom;
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {

		samling[antall] = kort;
		antall++;

	}

	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {

		
		for (Kortfarge f : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				samling [antall] = new Kort(f, i);
				antall++;
			}
		}

	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {

		for (int i = antall - 1; i >= 0; i--) {
			samling[i] = null;
			antall--;
		}
	}

	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga
	 *         er tom, returneres null.
	 */
	public Kort seSiste() {

		boolean tom = true;
		for (int i = 0; i <= antall; i++) {
			if (samling[i] != null) {
				tom = false;
				break;
			}
		}
		if (tom) {
			return null;
		} else {
			return samling[antall - 1];
		}

	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres null.
	 */
	public Kort taSiste() {


		if(antall < 1) return null;
		
		Kort k = samling [antall - 1];
		samling [antall - 1] = null;
		antall--;				
		return k;
	}

	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		int x;

		for (x  = 0; x < antall; x++) {
			if (samling[x].equals(kort)) {
				return true;
			}
		}
		
		return false;

	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga, skjer
	 * ingenting med samilingen
	 * 
	 * @param kort kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *             ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */

	public boolean fjern(Kort kort) {

		for (int i = 0; i < antall; i++) {
			if (samling[i].equals(kort)) {
				samling[i] = samling[antall - 1];
				antall--;
				return true;
			}
		}
		
		return false;
			}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {

Kort[] tabellKort = new Kort[antall];
		
		for (int s = 0; s < antall; s++) {
			tabellKort[s] = samling[s];
		}
		
		return tabellKort;

	}

}
