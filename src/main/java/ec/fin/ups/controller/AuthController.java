package ec.fin.ups.controller;

import ec.fin.ups.Utils.JWTUtil;
import ec.fin.ups.interfaceServices.IPersonaService;
import ec.fin.ups.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final IPersonaService personaService;
    private final JWTUtil jwtUtil;

    @Autowired
    public AuthController(IPersonaService personaService, JWTUtil jwtUtil){
        this.personaService = personaService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Persona persona){
        Persona usuarioLogin = personaService.getUserByEmailPassword(persona.getCorreo(), persona.getPassword());

        if (usuarioLogin != null){
            return jwtUtil.create(String.valueOf(usuarioLogin.getId()), usuarioLogin.getCorreo());
        }
        return "FAIL";
    }

}
