package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.domain.Rider;
import com.svalero.deliveryAPI.domain.User;
import com.svalero.deliveryAPI.domain.dto.OrderDto;
import com.svalero.deliveryAPI.exception.OrderNotFoundException;
import com.svalero.deliveryAPI.exception.RestaurantNotFoundException;
import com.svalero.deliveryAPI.exception.RiderNotFoundException;
import com.svalero.deliveryAPI.exception.UserNotFoundException;
import com.svalero.deliveryAPI.repository.OrderRepository;
import com.svalero.deliveryAPI.repository.RestaurantRepository;
import com.svalero.deliveryAPI.repository.RiderRepository;
import com.svalero.deliveryAPI.repository.UserRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private RiderRepository riderRepository;


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrder(long id)throws OrderNotFoundException {
        return orderRepository.findById(id) //si no esta el objeto mandame esta excepcion
                .orElseThrow(()-> new OrderNotFoundException());
    }

    @Override
    public List<Order> findByDistance(int distance) {
        return orderRepository.findByDistance(distance);
    }

    @Override
    public Order deleteOrder(long id)throws OrderNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException());

        orderRepository.deleteById(id);
        return order;
    }

    @Override
    public Order addOrder( Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addOrder(OrderDto orderDto) throws UserNotFoundException, RestaurantNotFoundException, RiderNotFoundException {
        User user = userRespository.findById(orderDto.getUser())
                .orElseThrow(()-> new UserNotFoundException());
        Restaurant restaurant = restaurantRepository.findById(orderDto.getRestaurant())
                .orElseThrow(()-> new ResolutionException());
        Rider rider = riderRepository.findById(orderDto.getRider())
                .orElseThrow(()-> new RiderNotFoundException());

//        Order order = new Order();
//        ModelMapper mapper = new ModelMapper();//mapea los objetos, es decir, comounia los objetos con los mismos atributos
//
//        mapper.map(orderDto, order);
        ModelMapper mapper = new ModelMapper();
        Order order = mapper.map(orderDto, Order.class);

        order.setRestaurant(restaurant);
        order.setRider(rider);
        order.setUser(user);
        return orderRepository.save(order);

    }

    @Override
    public Order modifyOrder(long id, Order newOrder)throws OrderNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException());
        order.setDistance(newOrder.getDistance());
        order.setPrice(newOrder.getPrice());
        order.setReady(newOrder.isReady());
        order.setTime(newOrder.getTime());
        order.setWeight(newOrder.getWeight());
        return orderRepository.save(order);
    }
}
