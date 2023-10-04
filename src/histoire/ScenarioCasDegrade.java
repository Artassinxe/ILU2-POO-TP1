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
		try {
			System.out.println(etal.acheterProduit(1,asterix));
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("Fin du test");
		}

}
