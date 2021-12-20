package com.usa.ciclo4.retociclo4.service;

import com.usa.ciclo4.retociclo4.model.Order;
import com.usa.ciclo4.retociclo4.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.save(order);
        }
    }

    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> dbOrder = orderRepository.getOrder(order.getId());
            if (!dbOrder.isEmpty()){
                if (order.getId() != null){
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null){
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null){
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null){
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null){
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null){
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        }
        return order;
    }

    public boolean delete(int orderId){
        return getOrder(orderId).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);

    }

    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }

    public List<Order> getOrderBySalesManId(int id){
        return orderRepository.getOrderBySalesManId(id);
    }

    public List<Order> getOrderBySalesManIdAndStatus(int id, String status){
        return orderRepository.getOrderBySalesManIdAndStatus(id, status);
    }

    /*public List<Order> getOrderByRegisterDayAndSalesManId(Date registerDay, Integer id){
        return orderRepository.getOrderByRegisterDayAndSalesManId(registerDay, id);
    }*/

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay, id);
    }
}
