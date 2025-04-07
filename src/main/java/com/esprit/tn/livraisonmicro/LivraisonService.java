package com.esprit.tn.livraisonmicro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonService implements IserviceLiv{
    @Autowired
    private JpaLivraison jpaLivraison;


    @Override
    public Livraison addLivraison(Livraison l) {
        return jpaLivraison.save(l);
    }

    @Override
    public List<Livraison> getAllLivraisons() {
        return jpaLivraison.findAll();
    }

    @Override
    public Livraison updateLivraison(int id, Livraison l) {
        Livraison livexisting = jpaLivraison.findById(id).get();
        livexisting.setDateLivraison(l.getDateLivraison());
        livexisting.setEmail(l.getEmail());
        livexisting.setNom(l.getNom());
        livexisting.setFraisLivraison(l.getFraisLivraison());
        livexisting.setStatut(l.getStatut());
        livexisting.setTelephone(l.getTelephone());
        livexisting.setLatitude(l.getLatitude());
        livexisting.setLongitude(l.getLongitude());
        return jpaLivraison.save(livexisting);
    }

    @Override
    public boolean deleteLivraison(int id) {
        if (jpaLivraison.findById(id).isPresent()){
            jpaLivraison.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Livraison findById(int id) {
        Livraison liv = jpaLivraison.findById(id).orElse(null);
        return liv;
    }
}
