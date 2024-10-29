package dianafriptuleac.u5w2d2WebApi.services;

import dianafriptuleac.u5w2d2WebApi.entities.Autore;
import dianafriptuleac.u5w2d2WebApi.payloads.NewAutorePayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<Autore> autoriList = new ArrayList<>();

    //Cerco la lista di autori
    public List<Autore> findAllAutori() {
        return this.autoriList;
    }

    public Autore saveAutore(NewAutorePayload body) {
        Random rdm = new Random();
        Autore newAutore = new Autore(body.getNome(), body.getCognome(), body.getEmail(), body.getDataDiNascita());
        newAutore.setId(rdm.nextInt(1, 500000));
        newAutore.setAvatar("newAvatar");
        return newAutore;
    }

}
