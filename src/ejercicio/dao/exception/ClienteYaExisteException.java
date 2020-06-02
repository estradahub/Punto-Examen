package ejercicio.dao.exception;

public class ClienteYaExisteException extends Exception{
    public ClienteYaExisteException(String id){
        super(String.format("Ya existe una cuenta para este cliente: %s", id));
    }
}
