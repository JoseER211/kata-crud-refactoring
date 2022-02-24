package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.CatalogueDTO;
import co.com.sofka.crud.dtos.CatalogueTodoDTO;
import co.com.sofka.crud.dtos.DTO;
import co.com.sofka.crud.models.Catalogue;
import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.services.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class CatalogueController {

    @Autowired
    private CatalogueService service;

    @GetMapping(value = "api/catalogs")
    public Iterable<CatalogueDTO> list(){
        return service.list();
    }

    @PostMapping(value = "api/catalogue")
    public Catalogue save(@RequestBody CatalogueDTO catalogueDTO){
        return service.save(catalogueDTO);
    }

    @PutMapping(value = "api/catalogue")
    public Catalogue update(@RequestBody CatalogueDTO catalogueDTO){
        if(catalogueDTO.getId() != null){
            return service.save(catalogueDTO);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/catalogue")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/catalogue")
    public CatalogueDTO get(@PathVariable("id") Long id){
        return service.getDTO(id);
    }

    @GetMapping("api/showAll")
    public DTO listInterfaz(){return service.showAll();}

    @PostMapping(value = "api/{id}/addTodo")
    public Todo addTodo(@RequestBody CatalogueTodoDTO catalogueTodoDTO){
        return service.addTodo(catalogueTodoDTO);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
