package proyectocard.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyectocard.models.CardModel;
import proyectocard.services.CardService;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    // Obtener tarjetas
    @GetMapping()
    public ArrayList<CardModel> getCards() {
        return cardService.getCards();
    }

    // Obtener tarjeta por id
    @GetMapping("/{id}")
    public Optional<CardModel> getCard(@PathVariable("id") Long id) {
        return cardService.getCard(id);
    }

    @GetMapping("/query")
    public ArrayList<CardModel> getToken(@RequestParam("token") String token) {
        return cardService.getToken(token);
    }

    // Crear o actulizar tarjeta
    @PostMapping()
    public String createCard(@RequestBody CardModel card) {
        CardModel Card = new CardModel();
        card.setToken(Card.generarTotken());
        cardService.createCard(card);
        return card.getToken();
    }

    // Eliminar tarjeta
    @DeleteMapping("/{id}")
    public String removeCard(@PathVariable("id") Long id) {
        boolean ok = cardService.removeCard(id);

        if (ok) {
            return "Tarjeta " + id + " eliminada";
        } else {
            return "La tarjeta " + id + " no fue eliminiada o no existe";
        }
    }

}
