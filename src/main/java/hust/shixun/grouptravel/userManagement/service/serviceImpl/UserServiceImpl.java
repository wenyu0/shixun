package hust.shixun.grouptravel.userManagement.service.serviceImpl;

import com.sun.org.apache.xpath.internal.operations.Or;
import hust.shixun.grouptravel.entities.City;
import hust.shixun.grouptravel.entities.Notes;
import hust.shixun.grouptravel.entities.Order;
import hust.shixun.grouptravel.entities.Product;
import hust.shixun.grouptravel.userManagement.mapper.UserMapper;
import hust.shixun.grouptravel.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    @Override
    public int getProvinceId(int cityId) {
        return userMapper.getProvinceId(cityId);
    }

    @Override
    public List<Integer> getCityList(String provinceName) {
        return userMapper.getCityList(provinceName);
    }

    @Override
    public boolean addOrder(Order order) {
        return userMapper.addOrder(order);
    }

    @Override
    public Product queryProductById(int productId) {
        return userMapper.queryProductById(productId);
    }

    @Override
    public List<Product> queryProductByName(String productName) {
        return userMapper.queryProductByName(productName);
    }

    @Override
    public List<Product> queryProductByCity(int cityId) {
        return userMapper.queryProductByCity(cityId);
    }

    @Override
    public List<Order> queryOrdersWithUnpay(int userId) {
        return userMapper.queryOrdersWithUnpay(userId);
    }

    @Override
    public Boolean updateUnpayOrder(int orderId) {
        return userMapper.updateUnpayOrder(orderId);
    }

    @Override
    public List<Notes> queryNotesByUserId(int orderId) {
        return userMapper.queryNotesByUserId(orderId);
    }

    @Override
    public Boolean addNotes(Notes notes) {
        return userMapper.addNotes(notes);
    }

    @Override
    public double queryOrderPrice(int orderId) {
        return userMapper.queryOrderPrice(orderId);
    }

    @Override
    public Boolean updateOrderPrice(int orderId, double orderPrice) {
        Order order =userMapper.selectOrderByOrderId(orderId);
        Double price=order.getOrderPrice();
        int pNum=order.getPNum();
        Double currentDiscount=order.getCurrentDiscount();
//       砍价金额超出原有金额
        if(orderPrice>=price){
            return false;
        }
        // 修改后的价格
        price-=orderPrice;
        pNum+=1;
        currentDiscount+=orderPrice;
        return userMapper.updateOrderPrice(orderId,price,pNum,currentDiscount);
    }

    @Override
    public List<Order> queryOrder(int orderId) {
        return userMapper.queryOrder(orderId);
    }

    @Override
    public Boolean addRates(double rate, int orderId) {
        return userMapper.addRates(rate, orderId);
    }

    @Override
    public Boolean likeNotes(int userId, int notesId) {
        return userMapper.likeNotes(userId,notesId);
    }

    @Override
    public Boolean commentNotes(int userId, int notesId, String commentContent) {
        return userMapper.commentNotes(userId,notesId,commentContent);
    }

    @Override
    public List<Notes> queryLikeNotes(int userId) {
        return userMapper.queryLikeNotes(userId);
    }

    @Override
    public String getimgByCity(int cityId) {
        return userMapper.getimgByCity(cityId);
    }

    @Override
    public List<City> getAllCitys() {
        return userMapper.getAllCitys();
    }
}
