package mg.working.atelier_reparation.services;

import mg.working.atelier_reparation.model.Client;
import mg.working.atelier_reparation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public void insertClient(Client client) {
        this.clientRepository.save(client);
    }

    public List<Client> getAllClient() {
        List<Client> valiny = this.clientRepository.findAll();
        return valiny;
    }
    public Client getClientById(String id){
        return this.clientRepository.getReferenceById(id);
    }

    public Client getLastClient() {
        return this.clientRepository.findFirstByOrderByIdDesc();
    }


}
