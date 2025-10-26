package br.uel.Apps_Mobile.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login(HttpSession session) {
        Object usuario = session.getAttribute("usuarioLogado");

        if (usuario != null) {
            return "redirect:/apps";
        } else {
            return "index";
        }
    }
}
