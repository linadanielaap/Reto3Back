package com.co.Reto3.controlador;

import com.co.Reto3.modelo.Admin;
import com.co.Reto3.servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }

    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
}
