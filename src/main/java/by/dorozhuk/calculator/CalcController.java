package by.dorozhuk.calculator;

import by.dorozhuk.calculator.entity.Calculator;
import by.dorozhuk.calculator.entity.Operation;
import by.dorozhuk.calculator.entity.OperationEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class CalcController {

    private static ArrayList<String> history = new ArrayList<>();
    private static String wrapperName = "guest";

    @GetMapping()
    public String index(Model model) {
        inputModel(model);
        return "index";
    }

    @GetMapping(path = "/calc/{num1}/{num2}/{type}")
    public String calc(@PathVariable(name = "num1") Integer num1,
                       @PathVariable(name = "num2") Integer num2,
                       @PathVariable(name = "type") OperationEnum type,
                       Model model) {
        dirtyWork(num1, num2, type);
        inputModel(model);
        return "index";
    }

    @GetMapping(path = "/calc")
    public String formCalc(@RequestParam(name = "num1") Integer num1,
                           @RequestParam(name = "num2") Integer num2,
                           @RequestParam(name = "type") OperationEnum type,
                           Model model) {
        dirtyWork(num1, num2, type);
        inputModel(model);
        return "index";
    }

    @GetMapping(path = "/user")
    public String user(@RequestParam(name = "name", required = false) String name,
                       Model model) {

        if (name == null || name.equals("")) {
            wrapperName = "guest";
        } else {
            wrapperName = name;
        }

        inputModel(model);
        return "index";
    }

    private String calculate(Operation operation) {
        String result = "";
        switch (operation.getType()) {
            case SUM:
                result = Calculator.sum(operation);
                break;
            case SUB:
                result = Calculator.sub(operation);
                break;
            case MULT:
                result = Calculator.mult(operation);
                break;
            case DIV:
                result = Calculator.div(operation);
                break;
        }
        return result;
    }

    private Model inputModel(Model model) {
        model.addAttribute("name", wrapperName);
        model.addAttribute("history", history);
        return model;
    }

    private void dirtyWork(Integer num1, Integer num2, OperationEnum type) {
        Operation operation = new Operation(num1, num2, type);
        String result;
        if (num1 != null && num2 != null && type != null) {
            result = calculate(operation);
            history.add(result);
        }
    }

}
