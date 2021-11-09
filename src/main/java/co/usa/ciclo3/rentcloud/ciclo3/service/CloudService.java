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
    private CloudRepository repository;

    public List<Cloud> getAll(){
        return repository.getAll();
    }

    public Optional<Cloud> getCloud(int CloudId){
        return repository.getOne(CloudId);
    }

    public Cloud save(Cloud cloud){
        if (cloud.getId()==null){
            return repository.save(cloud);
        }else{
            Optional<Cloud> existCloud=repository.getOne(cloud.getId());
            if(existCloud.isEmpty()){
                return repository.save(cloud);
            }else{
                return cloud;
            }
        }
    }
}
