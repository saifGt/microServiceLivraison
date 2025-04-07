package com.esprit.tn.livraisonmicro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/livraison")
public class LivraisonRestApi {
    @Autowired
    private LivraisonService ls ;
    @Autowired
    private EmailSendServices es;
    private String title="Hello, i'm the candidate Micro-Service";
    @RequestMapping(value = "/{id}")public ResponseEntity<Livraison> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<Livraison>(ls.findById(id),HttpStatus.OK);
    }

    @RequestMapping("/hello") public String sayHello(){
        System.out.println(title); return title;
    }

    @RequestMapping("/livraisons")
    public ResponseEntity<List<Livraison>> getAllLivraison(){
        return new ResponseEntity<List<Livraison>>(ls.getAllLivraisons(), HttpStatus.OK);
    }

    @PostMapping(value = "/addliv",consumes = MediaType.APPLICATION_JSON_VALUE)@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Livraison> addLiv(@RequestBody Livraison l){
        return new ResponseEntity<Livraison>(ls.addLivraison(l),HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)@ResponseStatus(HttpStatus.OK)
    public Livraison UpdateLivraison(@PathVariable(value = "id")int id,@RequestBody Livraison l  ){
        return new ResponseEntity<Livraison>(ls.updateLivraison(id,l),HttpStatus.OK).getBody();
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> DeleteLiv(@PathVariable(value = "id") int id) {
        boolean deleted = ls.deleteLivraison(id);

        if (deleted) {
            return ResponseEntity.ok("Suppression réussie");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Échec de la suppression : élément non trouvé");
        }
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestParam String to,@RequestParam String subject,@RequestParam String message){
        es.sendEmail(to,subject,message);
        return ResponseEntity.ok("Mail envoiyer avec succes ! ");
    }








}
