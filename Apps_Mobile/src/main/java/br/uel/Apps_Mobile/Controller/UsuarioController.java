package br.uel.Apps_Mobile.Controller;

import br.uel.Apps_Mobile.Model.Usuario;
import br.uel.Apps_Mobile.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String autenticar(@RequestParam String email, @RequestParam String senha, HttpSession session, Model model) {
        Usuario usuario = usuarioService.autenticar(email, senha);

        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/apps";
        } else {
            model.addAttribute("error", "E-mail ou senha inválidos!");
            return "index";
        }

    @PostMapping("/cadastro")
    public String autenticar(@RequestParam String nome, @RequestParam String email, @RequestParam String senha, HttpSession session, Model model) {
        Usuario usuario = usuarioService.autenticar(email, senha);

        if (usuario != null) {
            session.setAttribute("usuarioexiste", "Usuário Já Existe!");
            return "redirect:/";
        } else {
            Usuario novo = Usuario
            model.addAttribute("error", "E-mail ou senha inválidos!");
            return "redirect:/";
        }
    }



    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
