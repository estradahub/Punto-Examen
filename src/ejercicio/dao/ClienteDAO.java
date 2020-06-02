package ejercicio.dao;

import ejercicio.dao.exception.ClienteYaExisteException;
import ejercicio.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDAO {

    void registrarCliente(Cliente cliente)throws ClienteYaExisteException;

    Optional<Cliente> consultarClienteporId(String id);

    List<Cliente> listarClientes();
}
