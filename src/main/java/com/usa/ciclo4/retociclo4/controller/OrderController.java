package com.usa.ciclo4.retociclo4.controller;

import com.usa.ciclo4.retociclo4.model.Order;
import com.usa.ciclo4.retociclo4.model.Product;
import com.usa.ciclo4.retociclo4.model.User;
import com.usa.ciclo4.retociclo4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Order order){
        orderService.save(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return  orderService.delete(id);
    }

    @GetMapping("/zona/{zona}")
    public List<Order> emailExist(@PathVariable("zona") String zona){
        return orderService.getOrderByZone(zona);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> salesManExist(@PathVariable("id") int id){
        return orderService.getOrderBySalesManId(id);
    }

    @GetMapping("/state/{status}/{id}")
    public List<Order> salesManIdAndStatusExist(@PathVariable("id") int id, @PathVariable("status") String status){
        return orderService.getOrderBySalesManIdAndStatus(id, status);
    }

    /*@GetMapping("/date/{registerDay}/{id}")
    public List<Order> RegisterDayAndSalesManIdExist(@PathVariable("id") int id, @PathVariable("registerDay") Date registerDay){
        return orderService.getOrderByRegisterDayAndSalesManId(registerDay, id);
    }*/

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getByRegisterDayAndSalesManId(@PathVariable("registerDay")String  registerDay,@PathVariable("id") Integer id){
        return orderService.getByRegisterDayAndSalesManId(registerDay, id);
    }

}
