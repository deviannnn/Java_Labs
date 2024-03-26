package vn.edu.tdtu.lab8_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.lab8_2.model.Employee;
import vn.edu.tdtu.lab8_2.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("listEmployee", employeeService.list());
        return "index";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee item) {
        employeeService.save(item);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("editEmployee", employeeService.find(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, @ModelAttribute("employee") Employee item) {
        item.setId(id);
        employeeService.save(item);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
