package co.com.sofka.crud.repositories;

import co.com.sofka.crud.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Accede a los datos de la entidad y les incorpora los métodos CRUD.
 *
 * @author Jose David Echavarria Ruiz.
 */

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
