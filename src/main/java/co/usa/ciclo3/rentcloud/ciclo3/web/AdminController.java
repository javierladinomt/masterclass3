package co.usa.ciclo3.rentcloud.ciclo3.web;

import co.usa.ciclo3.rentcloud.ciclo3.model.Admin;
import co.usa.ciclo3.rentcloud.ciclo3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdminController {

        @Autowired
        private AdminService service;

        @GetMapping("/all")
        public List<Admin> getAll(){
            return service.getAll();
        }
        @GetMapping("/{id}")
        public Optional<Admin> getOne(@PathVariable ("id") int adminId){
            return service.getAdmin(adminId);
        }

        @PostMapping("/save")
        @ResponseStatus(HttpStatus.CREATED)
        public Admin save(@RequestBody Admin admin){
            return service.save(admin);
        }

        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public Admin update(@RequestBody Admin admin){
            return service.update(admin);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean delete(@PathVariable("id") int adminId){
            return service.delete(adminId);
        }
}
