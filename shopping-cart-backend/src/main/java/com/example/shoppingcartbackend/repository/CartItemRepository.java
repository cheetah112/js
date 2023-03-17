package com.example.shoppingcartbackend.repository;

import com.example.shoppingcartbackend.db.CartDB;
import com.example.shoppingcartbackend.db.CourseDB;
import com.example.shoppingcartbackend.dto.CartItemDto;
import com.example.shoppingcartbackend.exception.BadRequestException;
import com.example.shoppingcartbackend.model.CartItem;
import com.example.shoppingcartbackend.model.Course;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CartItemRepository {

    ModelMapper mapper = new ModelMapper();
//    TypeMap<CartItem,CartItemDto> propertyMapper = this.mapper.createTypeMap(CartItem.class,CartItemDto.class);
//    propertyMapper.addMappings(
//            mapper -> mapper.map())
    public List<CartItemDto> getAllItem() {
        List<CartItemDto> listCartItem = new ArrayList<>();

        for (CartItem item: CartDB.cart
             ) {
            CartItemDto cartItemDto = mapper.map(item, CartItemDto.class);
            listCartItem.add(cartItemDto);
        }
        return listCartItem;
    }

    public void deleteItem(Integer id) {
        CartDB.cart.removeIf(item -> Objects.equals(item.getId(),id));
    }

    public void increItem(Integer id) {
        for (int i = 0; i < CartDB.cart.size(); i++) {
            if(CartDB.cart.get(i).getId() == id){
                Integer count = CartDB.cart.get(i).getCount();
                CartDB.cart.get(i).setCount(count + 1);
                return;
            }
        }
        throw new BadRequestException("Id không tồn tại");

    }

    public void decreItem(Integer id) {
        for (int i = 0; i < CartDB.cart.size(); i++) {
            if(CartDB.cart.get(i).getId() == id){
                Integer count = CartDB.cart.get(i).getCount();
                if(count > 0){
                CartDB.cart.get(i).setCount(count - 1);
                }else{
                    throw new BadRequestException("Không giảm được nữa");
                }
                return;
            }
        }
        throw new BadRequestException("Id không tồn tại");
    }
    public CartItem findItemById(Integer id){
        Optional<Course> courseOptional = CourseDB.courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if(courseOptional.isPresent()){
            return new CartItem((CartDB.cart.get(CartDB.cart.size()-1).getId())+1,courseOptional.get().getId(),1);
        }
        throw new BadRequestException("Không tìm thấy id khóa học");
    }

}
