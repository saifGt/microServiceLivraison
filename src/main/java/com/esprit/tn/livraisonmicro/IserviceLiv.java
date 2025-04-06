package com.esprit.tn.livraisonmicro;

import java.util.List;

public interface IserviceLiv {
    public Livraison addLivraison(Livraison l);
    List<Livraison> getAllLivraisons();

    Livraison updateLivraison(int id,Livraison l);

    boolean deleteLivraison(int id);
    Livraison findById(int id);

}
