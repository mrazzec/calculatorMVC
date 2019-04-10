package by.dorozhuk.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class CalcController {

    private static ArrayList<String> history = new ArrayList<>();
    private static String name = "ghost";

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("name", this.name);
        model.addAttribute("history", history);
        return "index";
    }

    @GetMapping(path = "/calc")
    public String calc(@RequestParam(name = "num1") Integer num1,
                       @RequestParam(name = "num2") Integer num2,
                       @RequestParam(name = "type") String type,
                       Model model){
        Integer result = 0;
        if (num1 != null && num2 != null){
            result = calculate(num1, num2, type);
            history.add(num1 + " " + type + " " + num2 + " = " + result);
        }
        model.addAttribute("name", this.name);
        model.addAttribute("history", history);
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping(path = "/user")
    public String user(@RequestParam(name = "name", required = false) String name,
                       Model model) {
        this.name = name;
        model.addAttribute("name", this.name);
        model.addAttribute("history", history);
        return "index";
    }

    private Integer calculate(Integer num1, Integer num2, String type) {
        Integer result = 0;
        switch (type){
            case "+" :
                result = num1 + num2;
                break;
            case "-" :
                result = num1 - num2;
                break;
            case "/" :
                result = num1 / num2;
                break;
            case "*" :
                result = num1 * num2;
                break;
            case "%" :
                result = num1 % num2;
                break;
        }
        return result;
    }

}
