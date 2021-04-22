package se.lexicon.formbinding_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.formbinding_practice.entity.Customer;
import se.lexicon.formbinding_practice.repository.CustomerRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/")
public class CustomerController {

    CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String getAll(Model model) {

        return "homePage";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
        System.out.println("customer = " + customer);
        if (bindingResult.hasErrors()) {
            return "homePage";
        }
        return "redirect:/admin/";
    }
}