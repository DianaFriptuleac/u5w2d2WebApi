package dianafriptuleac.u5w2d2WebApi.controllers;

import dianafriptuleac.u5w2d2WebApi.entities.Autore;
import dianafriptuleac.u5w2d2WebApi.payloads.NewAutorePayload;
import dianafriptuleac.u5w2d2WebApi.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    //1.Get http://localhost:3002/autori

    @GetMapping
    public List<Autore> getAutore() {
        return this.autoreService.findAllAutori();
    }

    //2. Post http://localhost:3002/autori = payload

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAutore(@RequestBody NewAutorePayload body) {
        return this.autoreService.saveAutore(body);
    }
}
