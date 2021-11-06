package co.usa.ciclo3.rentcloud.ciclo3.service;

import co.usa.ciclo3.rentcloud.ciclo3.model.Admin;
import co.usa.ciclo3.rentcloud.ciclo3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author JALP
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    /**
     * GET/{id}
     * @param id
     * @return
     */
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    /**
     * POST
     * @param a
     * @return
     */
    public Admin save(Admin a){
        if(a.getIdAdmin()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> aAux=adminRepository.getAdmin(a.getIdAdmin());
            if(aAux.isEmpty()){
                return adminRepository.save(a);
            }else{
                return a;
            }
        }
    }


}
