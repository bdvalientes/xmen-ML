package co.com.xmen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.xmen.models.Adn;

@Repository
public interface AdnRepository extends CrudRepository<Adn, Integer> {

	Integer countByismutant(@Param("isMutant") boolean isMutant);

}
