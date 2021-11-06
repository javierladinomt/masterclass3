package co.usa.ciclo3.rentcloud.ciclo3.service;

import co.usa.ciclo3.rentcloud.ciclo3.model.Cloud;
import co.usa.ciclo3.rentcloud.ciclo3.repository.CloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudService {

    @Autowired
    private CloudRepository cloudRepository;

    public List<Cloud> getAll(){
        return cloudRepository.getAll();
    }

    public Optional<Cloud> getCloud(int id){
        return cloudRepository.getCloud(id);
    }

    public Cloud save(Cloud c){
        if (c.getId()==null){
            return cloudRepository.save(c);
        }else{
            Optional<Cloud> cAux=cloudRepository.getCloud(c.getId());
            if(cAux.isEmpty()){
                return cloudRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
