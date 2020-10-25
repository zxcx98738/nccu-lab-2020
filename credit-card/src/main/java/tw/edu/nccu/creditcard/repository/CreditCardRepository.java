package tw.edu.nccu.creditcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.edu.nccu.creditcard.entity.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {

}
