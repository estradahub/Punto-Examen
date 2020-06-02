package ejercicio.dao.impl;

import ejercicio.dao.ClienteDAO;
import ejercicio.dao.exception.ClienteYaExisteException;
import ejercicio.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAOList implements ClienteDAO {
    private static List<Cliente> bd = new ArrayList<>();
    @Override
    public void registrarCliente(Cliente cliente) throws ClienteYaExisteException {
        Optional<Cliente> proveedorOptional = consultarClienteporId(cliente.getId());
        if(proveedorOptional.isPresent())
        {
            throw new ClienteYaExisteException(cliente.getId());
        }
        bd.add(cliente);
    }
    @Override
    public Optional<Cliente> consultarClienteporId(String id) {
        Optional<Cliente> clienteVacio = Optional.empty();
        return bd.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Cliente> listarClientes() {
        return null;
    }

    public void agregarSaldo(int agregar, String clientId){
        consultarClienteporId(clientId);



    }
}
