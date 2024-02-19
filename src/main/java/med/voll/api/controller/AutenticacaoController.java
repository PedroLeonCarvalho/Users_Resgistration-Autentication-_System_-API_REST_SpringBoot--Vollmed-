package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.AutenticacaoService;
import med.voll.api.domain.user.DadosAutenticacao;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.DadosTokenJWT;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
   private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao dados) {
try{
var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
            var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
} catch ( Exception e)
{
             e.printStackTrace();
             return ResponseEntity.badRequest().body(e.getMessage());
    }}
}
