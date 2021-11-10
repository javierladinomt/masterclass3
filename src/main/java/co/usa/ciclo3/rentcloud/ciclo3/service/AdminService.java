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
    private AdminRepository repository;

    /**
     * @return Retorna todos los administradores
     */
    public List<Admin> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param AdminId
     * @return
     */
    public Optional<Admin> getAdmin(int AdminId) {
        return repository.getOne(AdminId);
    }

    /**
     * POST
     *
     * @param admin
     * @return
     */
    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return repository.save(admin);
        } else {
            Optional<Admin> existAdmin = repository.getOne(admin.getIdAdmin());
            if (existAdmin.isEmpty()) {
                return repository.save(admin);
            } else {
                return admin;
            }
        }
    }

    /**
     * UPDATE
     *
     * @param admin
     * @return
     */
    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> existAdmin = repository.getOne(admin.getIdAdmin());
            if (existAdmin.isPresent()) {
                if (admin.getName() != null) {
                    existAdmin.get().setName((admin.getName()));
                }
                if (admin.getEmail() != null) {
                    existAdmin.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    existAdmin.get().setPassword(admin.getPassword());
                }
                return repository.save(existAdmin.get());
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    /**
     * DELETE
     * @param adminId
     * @return
     */
    public boolean delete(int adminId){
        Boolean response = getAdmin(adminId).map(admin -> {
            repository.delete(admin);
            return true;
        }).orElse(false);
        return response;
    }
}
