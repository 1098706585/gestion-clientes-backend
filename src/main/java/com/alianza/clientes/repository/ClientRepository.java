package com.alianza.clientes.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.alianza.clientes.dto.ClientesAlianza;
import com.alianza.clientes.dto.ResponseSp;

@Repository
public class ClientRepository {
    private List<ClientesAlianza> list = new ArrayList<ClientesAlianza>();

    public void createProducts() {
        list = List.of(
                new ClientesAlianza(1, "carias","Camilo Arias",3157553554L,"luna@gmail.com","01/12/2020","02/11/2022"),
                new ClientesAlianza(2, "aarenas","Andres Arenas",3157581554L,"luna@gmail.com","01/12/2020","02/11/2022"),
                new ClientesAlianza(3, "fpinto","Felipe Pinto",3157585145L,"luna@gmail.com","01/12/2020","02/11/2022")
        );
    }
    
    public int contadorId=1;

    public List<ClientesAlianza> getAllProducts() {
        return list;
    }

    
    public List<ClientesAlianza> findById(int id){
    	List<ClientesAlianza> lstClientesAlianza = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
            	lstClientesAlianza.add(list.get(i));
                return lstClientesAlianza;
            }
        }
        return null;
    }

    public List<ClientesAlianza> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public ResponseEntity<?> save(int id,String name,Long phone,String email,String startDate,String endDate) {
        
    	ClientesAlianza clientesAlianza = new ClientesAlianza();
        if(name==null || email==null || phone==null || startDate==null || endDate==null) {
        	return ResponseEntity.ok(new ResponseSp("-1", "Todos los campos son obligatorios para la creacion del cliente"));
        }
        clientesAlianza.setId(contadorId);
        clientesAlianza.setName(name);        
        String[] newStr = name.split("\\s+");
		String primeraLetra = name.substring(0, 1);
		clientesAlianza.setSharedKey(primeraLetra.toLowerCase()+newStr[1].toLowerCase().toString());
		clientesAlianza.setPhone(phone);
        clientesAlianza.setEmail(email);
        clientesAlianza.setStartDate(startDate);
        clientesAlianza.setEndDate(endDate);
        list.add(clientesAlianza);        
        contadorId++;
        return ResponseEntity.ok(clientesAlianza);
        
    	
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public ClientesAlianza update(ClientesAlianza clientesAlianza) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (clientesAlianza.getId())) {
                id = clientesAlianza.getId();
                idx = i;
                break;
            }
        }

        ClientesAlianza product1 = new ClientesAlianza();
        product1.setId(id);
        product1.setName(clientesAlianza.getName());
        product1.setPhone(clientesAlianza.getPhone());
        product1.setEmail(clientesAlianza.getEmail());
        product1.setStartDate(clientesAlianza.getStartDate());
        product1.setEndDate(clientesAlianza.getEndDate());
        list.set(idx, clientesAlianza);
        return product1;
    }
}