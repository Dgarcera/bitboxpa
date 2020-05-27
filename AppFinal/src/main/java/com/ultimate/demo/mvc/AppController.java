package com.ultimate.demo.mvc;

import com.ultimate.demo.model.Item;
import com.ultimate.demo.services.ItemService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private ItemService service; 
        //private ItemDAO dao;
	
	@RequestMapping({"/","/login"})
	public String viewHomePage(Model model) {
            return "index";
	}
        
        @GetMapping({"/dblist"})
	public String viewDB(Model model) {
            List<Item> listItems = service.listAll();
            //List<Item> listItems = dao.listAll();
            model.addAttribute("listItems", listItems);
            return "showdb";
	}
	
	@RequestMapping("/new")
	public String showNewItemPage(Model model) {
            Item item = new Item();
            model.addAttribute("item", item);
            return "new_item";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveItem(@ModelAttribute("item") Item item) {
            service.save(item);
            //dao.save(item);
            return "redirect:/dblist";
	}
        
        @RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item item) {
            service.add(item);
            //dao.save(item);
            return "redirect:/dblist";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditItemPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("edit_item");
            Item item = service.get(id);
            //Item item = dao.get(id);
            mav.addObject("item", item);
            return mav;
	}
        
        @RequestMapping("/info/{id}")
        public ModelAndView showItemInfo(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("item_info");
            Item item = service.get(id);
            mav.addObject("item", item);
            return mav;
        }
        
        
	/*
	@RequestMapping("/delete/{id}")
	public String deleteItem(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}*/
        
}
