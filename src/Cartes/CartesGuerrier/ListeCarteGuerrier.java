package Cartes.CartesGuerrier;

import Cartes.Techniques;

public abstract class ListeCarteGuerrier {
    private static Techniques[] listeTechnique = {
            new BriseCoude(),
            new ChangementDePosition(),
            new Feinte(),
            new OuvreGarde(),
            new TransBerserk(),
            new FracasArme(),
            new AttaqueDouble(),
            new FrappeBrutale(),
            new ContreAttaque(),
            new CoupAssomant(),
            new ViveAttaque(),
            new SurLaDefensive()
    };

    public static Techniques[] getListeTechnique() {
        return listeTechnique;
    }
}
