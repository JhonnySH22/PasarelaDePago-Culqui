package proyectocard.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proyectocard.models.CardModel;

@Repository
public interface CardRepository extends CrudRepository<CardModel, Long> {

    public abstract ArrayList<CardModel> findByToken(String token);
}
