package histoire;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ScenarioCasDegrade {
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Etal etal = new Etal();
		System.out.println(etal.acheterProduit(12,asterix));
		System.out.println("Fin du test");
		}

}
