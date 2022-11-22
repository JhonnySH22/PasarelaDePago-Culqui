package proyectocard.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectocard.models.CardModel;
import proyectocard.repositories.CardRepository;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    // Trae todas las filas de mysql
    public ArrayList<CardModel> getCards() {
        return (ArrayList<CardModel>) cardRepository.findAll();
    }

    // Trae solo una fila del mysql mediante un id
    public Optional<CardModel> getCard(Long id) {
        return (Optional<CardModel>) cardRepository.findById(id);
    }

    // Trae solo una fila del mysql mediante un token
    public ArrayList<CardModel> getToken(String token) {
        return cardRepository.findByToken(token);
    }

    // Crea o actuliza una nueva fila del mysql
    public CardModel createCard(CardModel card) {
        return cardRepository.save(card);
    }

    // Elimina una fila del mysql mediate id
    public boolean removeCard(long id) {
        try {
            cardRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
