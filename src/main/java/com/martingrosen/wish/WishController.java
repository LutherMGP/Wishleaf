package com.martingrosen.wish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WishController {
    @Autowired private WishService service;

    @GetMapping("/wishes")
    public String showWishList(Model model) {
        List<Wish> listWishes = service.listAll();
        model.addAttribute("listWishes", listWishes);

        return "wishes";
    }

    @GetMapping("/wishes/new")
    public String showNewForm(Model model) {
        model.addAttribute("wish", new Wish());
        model.addAttribute("pageTitle", "Add New Wish");
        return "wish_form";
    }

    @PostMapping("/wishes/save")
    public String saveWish(Wish wish, RedirectAttributes ra) {
        service.save(wish);
        ra.addFlashAttribute("message", "The wish has been saved successfully.");
        return "redirect:/wishes";
    }

    @GetMapping("/wishes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Wish wish = service.get(id);
            model.addAttribute("wish", wish);
            model.addAttribute("pageTitle", "Edit Wish (ID: " + id + ")");

            return "wish_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/wishes";
        }
    }

    @GetMapping("/wishes/delete/{id}")
    public String deleteWish(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The wish ID " + id + " has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
            return "redirect:/wishes";
    }

}
