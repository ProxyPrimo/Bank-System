package banksystem.web;

import banksystem.data.UserRegisterBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        modelAndView.addObject("userRegisterBindingModel", new UserRegisterBindingModel());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView postRegister(ModelAndView modelAndView
            , @Valid UserRegisterBindingModel userRegisterBindingModel
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        System.out.println();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
