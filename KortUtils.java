package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling samling av kort som skal sorteres.
	 */

	public static void sorter(KortSamling samling) {

		int antall = samling.getAntalKort();
		Kort[] midlertidigSam = samling.getSamling();

		for (int i = 0; i < antall; i++) {
			for (int x = 1; x < antall - i; x++) {
				if (midlertidigSam[x - 1].getVerdi() > midlertidigSam[x].getVerdi()) {
					Kort mdl = midlertidigSam[x - 1];
					midlertidigSam[x - 1] = midlertidigSam[x];
					midlertidigSam[x] = mdl;
				}
			}
		}
	}

	/**
	 * Stokkar en kortsamling.
	 * 
	 * @param samling samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {
Random random = new Random();
		
        for (int i = samling.getSamling().length - 1; i > 0; i--) {
          int j = random.nextInt(i);

          Kort temp = samling.getSamling()[i];
          samling.getSamling()[i]= samling.getSamling()[j];
          samling.getSamling()[j]= temp;
		}

	}
}
