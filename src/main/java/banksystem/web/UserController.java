package banksystem.web;

import banksystem.data.bindings.UserRegisterBindingModel;
import banksystem.data.services.UserServiceModel;
import banksystem.services.UserService;
import org.modelmapper.ModelMapper;
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

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

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

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.userRegistrationBindingModel"
                            , bindingResult);
            modelAndView.setViewName("register");
            return modelAndView;

        } else if (userService.findByFirstNameAndMiddleNameAndLastName(userRegisterBindingModel.getFirstName(), userRegisterBindingModel.getMiddleName(), userRegisterBindingModel.getLastName()) != null) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("userFound", true);
            modelAndView.setViewName("register");
            return modelAndView;
        } else if (userService.findByEmail(userRegisterBindingModel.getEmail()) != null) {
            modelAndView.setViewName("register");
            return modelAndView;
        }
        userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
