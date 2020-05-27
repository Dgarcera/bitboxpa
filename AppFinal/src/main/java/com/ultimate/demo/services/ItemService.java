package com.ultimate.demo.services;

import com.ultimate.demo.model.Item;
import com.ultimate.demo.repositories.ItemRepository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Service
//@Transactional
public class ItemService {
 
    @Autowired
    private ItemRepository repo;
     
    public List<Item> listAll() {
        return repo.findAll();
    }
    
    //@RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Item item) {   
        repo.save(item);
    }
    
    public void add(Item item) {
        SimpleDateFormat formatter = new SimpleDateFormat("Y-MM-dd HH:mm:ss");  
        Date date = new Date();
        item.setCreated(formatter.format(date));
        repo.save(item);
    }
     
    public Item get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}