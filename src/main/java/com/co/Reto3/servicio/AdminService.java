package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Admin;
import com.co.Reto3.repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmins(){
        return adminRepository.getAdmins();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin saveAdmin(Admin admin){
        if(admin.getIdAdmin()== null){
            return adminRepository.saveAdmin(admin);
        }else {
            Optional<Admin> e= adminRepository.getAdmin(admin.getIdAdmin());
            if (e.isEmpty()){
                return adminRepository.saveAdmin(admin);
            }else {
                return admin;
            }
        }
    }
}
