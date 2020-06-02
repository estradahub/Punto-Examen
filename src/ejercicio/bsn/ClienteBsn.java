package ejercicio.bsn;

import ejercicio.dao.ClienteDAO;
import ejercicio.dao.exception.ClienteYaExisteException;
import ejercicio.dao.impl.ClienteDAOList;
import ejercicio.model.Cliente;

public class ClienteBsn {

    private ClienteDAO clienteDAO;

    public ClienteBsn(){
        this.clienteDAO = new ClienteDAOList();
    }
    public void registrarCliente(Cliente cliente)throws ClienteYaExisteException{
        //todo validar reglas de negocio
        try{
            this.clienteDAO.registrarCliente(cliente);

        }catch (ClienteYaExisteException cye){
            System.out.println(cye);
            throw new ClienteYaExisteException((String.format("Ya existe una cuenta para la identificación %s ", cliente.getId())));
        }
    }
    public void añadirSaldo(int agregar){


    }

}
