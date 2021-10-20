package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som implementerer bordet som spilles på.
 * 
 * Klassen har objektvariablene bunkeTil og bunkeFra som skal brukes til å
 * representere kortene som er i de to bunker på border.
 */
public class Bord {

	private KortSamling bunkeFra;
	private KortSamling bunkeTil;
	
	

	/**
	 * Metoden oppretter to bunker, til- og fra-bunken Alle kortene legges til
	 * fra-bunken.
	 */
	public Bord() {

		bunkeFra = new KortSamling();
		bunkeTil = new KortSamling();

		bunkeFra.leggTilAlle();
		KortUtils.stokk(bunkeFra);
	}

	/**
	 * Gir peker/referanse til til-bunken.
	 * 
	 * @return referanse/peker til til-bunken.
	 */
	public KortSamling getBunkeTil() {

		return bunkeTil;

	}

	/**
	 * Gir peker/referanse til fra-bunken.
	 * 
	 * @return referanse/peker til fra-bunken.
	 */
	public KortSamling getBunkeFra() {

		return bunkeFra;

	}

	/**
	 * Sjekker om til-bunken er tom.
	 * 
	 * @return true om til-bunken er tom, false ellers.
	 */
	public boolean bunketilTom() {

		KortSamling til = getBunkeTil();

		return til.erTom();

	}

	/**
	 * Sjekker om fra-bunken er tom.
	 * 
	 * @return true om fra-bunken er tom, false ellers.
	 */
	public boolean bunkefraTom() {

		KortSamling fra = getBunkeFra();

		return fra.erTom();

	}

	/**
	 * Gir antall kort i fra-bunken.
	 * 
	 * @return antall kort i fra-bunken.
	 */
	public int antallBunkeFra() {

		return bunkeFra.getAntalKort();

	}

	/**
	 * Gir antall kort i til-bunken.
	 * 
	 * @return antall kort i til-bunken.
	 */
	public int antallBunkeTil() {

		return bunkeTil.getAntalKort();

	}

	/**
	 * Tar øverste kortet fra fra-bunken og legger dettte til til-bunken (med
	 * billedsiden opp, men det trenger ikke gruppen tenke på).
	 */
	public void vendOversteFraBunke() {

		Kort overste = bunkeFra.taSiste();

		bunkeTil.leggTil(overste);

	}

	/**
	 * Tar øverste kortet fra fra-bunken.
	 * 
	 * @return peker/referanse til det kort som blev tatt fra fra-bunken
	 */

	public Kort taOversteFraBunke() {

		return bunkeFra.taSiste();

	}

	/**
	 * Metode som leser øverste kortet i til-bunken. Kortet vil fremdeles være
	 * øverst i til-bunken etter at metoden er utført.
	 * 
	 * @return peker/referanse til øverste kortet i til-bunken.
	 */
	public Kort seOversteBunkeTil() {

		return bunkeTil.seSiste();

	}

	
	public void snuTilBunken() {
		if (bunkefraTom()) {

		Kort k = bunkeTil.taSiste(); 
		int x = bunkeTil.getAntalKort();
		for (int i = 0; i < x; i++) {
			bunkeFra.leggTil(bunkeTil.taSiste());
		}
		KortUtils.stokk(bunkeFra);
		bunkeTil.leggTil(k);
		
	}}

	/**
	 * Metode som legger et kort i til-bunken.
	 * 
	 * @param k kort som skal legges ned.
	 * 
	 */
	public void leggNedBunkeTil(Kort k) {

		bunkeTil.leggTil(k);

	}
}
