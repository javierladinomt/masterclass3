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

    public Cloud update(Cloud cloud){
        if (cloud.getId() != null){
            Optional<Cloud> existCloud = repository.getOne(cloud.getId());
            if (existCloud.isPresent()){
                if (cloud.getName() != null){
                    existCloud.get().setName(cloud.getName());
                }
                if (cloud.getBrand() != null){
                    existCloud.get().setBrand(cloud.getBrand());
                }
                if (cloud.getMessages() != null){
                    existCloud.get().setMessages(cloud.getMessages());
                }
                if (cloud.getCategory() != null){
                    existCloud.get().setCategory(cloud.getCategory());
                }
                if (cloud.getDescription() != null){
                    existCloud.get().setDescription(cloud.getDescription());
                }
                if (cloud.getReservations() != null){
                    existCloud.get().setReservations(cloud.getReservations());
                }
                if (cloud.getYear() != null){
                    existCloud.get().setYear(cloud.getYear());
                }
                return repository.save(existCloud.get());
            }else{
                return cloud;
            }
        }else{
            return cloud;
        }
    }

    public boolean delete(int cloudId) {
        Boolean response = getCloud(cloudId).map(cloud -> {
            repository.delete(cloud);
            return true;
        }).orElse(false);
        return response;
    }
}
