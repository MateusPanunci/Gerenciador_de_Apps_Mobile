package br.uel.Apps_Mobile.Controller;

import br.uel.Apps_Mobile.Model.AppMobile;
import br.uel.Apps_Mobile.Service.AppsMobileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/apps")
public class AppsMobileController {
    private final AppsMobileService service;

    @Autowired
    public AppsMobileController(AppsMobileService service){
        this.service = service;
    }


    @GetMapping
    public String listar(Model model){
        model.addAttribute("appsMobile", service.listar());
        return "listar_CSS"; //"listar"
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("nome") String nome, Model model, RedirectAttributes ra){
        try {
            model.addAttribute("appBuscado", service.buscar(nome));
            return "busca";
        }
        catch(RuntimeException e){
            ra.addFlashAttribute("buscainvalida", e.getLocalizedMessage());
            return "redirect:/apps";
        }
    }


    @GetMapping("/novo")
    public String abrirCadastro(Model model){
        model.addAttribute("app", new AppMobile());
        return "form_CSS"; //"form"
    }

    @GetMapping("/editar/{id}")
    public String abrirEdicao(@PathVariable Long id, Model model, RedirectAttributes ra) {
        try {
            model.addAttribute("app", service.buscar(id));
            return "form_CSS"; //"form"
        } catch (RuntimeException e){
            ra.addFlashAttribute("error", e.getMessage());
            return "redirect:/apps";
            /* Maneira que encontrei para burlar o problema de não mostrar o erro pelo
            Binding Results
            */
        }
    }

    @PostMapping
    public String cadastrar(@Valid @ModelAttribute AppMobile app,
                            BindingResult erros,
                            RedirectAttributes ra,
                            Model model)
    {
        if (erros.hasErrors()) {
            model.addAttribute("app", app); //Não estava dando certo sem criar uma nova model
            String error = "";

            //O th:error não estava funcionando também, achei essa maneira alternativa de informar o erro genericamente
            for (FieldError erro : erros.getFieldErrors()) {
                error = "O campo \"" + erro.getField() + "\" foi preenchido incorretamente!";
                break;
            }
            ra.addFlashAttribute("error", error);
            return "redirect:/apps/novo";
        }
        try {
            service.adicionar(app);
            ra.addFlashAttribute("msg", "App Mobile cadastrado!");
            return "redirect:/apps";
        } catch (DataIntegrityViolationException e) {
            ra.addFlashAttribute("error", "Já há um App cadastrado com o nome " + app.nome + "!");
        return "redirect:/apps/novo";
    }
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id,
                          RedirectAttributes ra) {
        service.remover(id);
        ra.addFlashAttribute("msg", "App excluído!");
        return "redirect:/apps";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute AppMobile app,
                            BindingResult erros,
                            RedirectAttributes ra,
                            Model model) {

        if (erros.hasErrors()) {
            model.addAttribute("app", app);
            String error = "";
            for (FieldError erro : erros.getFieldErrors()) {
                error = "O campo \"" + erro.getField() + "\" foi preenchido incorretamente!";
                break;
            }
            ra.addFlashAttribute("error", error);
            return String.format("redirect:/apps/editar/%d",id);
        }
        try {
            service.atualizar(id, app);
            ra.addFlashAttribute("msg", "App Mobile atualizado!");
        }
        catch (RuntimeException e) {
            ra.addFlashAttribute("error", e.getMessage());
            //Ver para que serve
        }
        return "redirect:/apps";
    }
}
