package br.edu.ufcg.computacao.si1.controller.restController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luiz on 21/03/17.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String irParaHome() {
        return "index";
    }
}
