package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.Catalogue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Accede al dato de la entidad y le incorpora el CRUD

@Repository
public interface CatalogueRepository extends CrudRepository<Catalogue, Long> {
}
