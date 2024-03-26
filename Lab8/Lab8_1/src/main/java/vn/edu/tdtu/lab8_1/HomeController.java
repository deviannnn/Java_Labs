package vn.edu.tdtu.lab8_1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

@Controller
public class HomeController implements ErrorController {
    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @PostMapping("/contact")
    public String showInfoContact(@RequestParam("name") String name, @RequestParam("phone") String phone,
                                  @RequestParam("message") String message, Model model) {
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        model.addAttribute("message",message);
        return "infomation";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Integer statusCode = (Integer) request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
        if (statusCode == null) {
            statusCode = -1;
        }

        String errorMessage;
        switch (statusCode) {
            case 400:
                errorMessage = "Bad Request";
                break;
            case 401:
                errorMessage = "Unauthorized";
                break;
            case 404:
                errorMessage = "Resource not found";
                break;
            case 500:
                errorMessage = "Internal Server Error";
                break;
            default:
                errorMessage = "Error";
                break;
        }
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}
