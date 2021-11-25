package org.mybatis.jpetstore.mapper;
import org.mybatis.jpetstore.domain.UserAdopt;
import java.util.List;
import org.mybatis.jpetstore.domain.UserSale;

public interface UserSalesMapper {

    List<UserSale> getSalesList(String f_category,String f_charge,int f_order, String f_search);

    List<UserSale> getSalesListAll();

    List<UserSale> getSalesListtest();

    void insertSale(UserSale userSale);

    void insertAdopt(UserAdopt userAdopt);

    void updateAdopt(UserAdopt userAdopt);

    void deleteAdopt(int aid);

    List<UserAdopt> getAdoptList();

    List<UserAdopt> getAdoptListByUsername(String username);

    UserAdopt getAdopt(int aid);

    List<UserSale> getSalesListByUsername(String username);

    UserSale getSales(int sid);

    UserSale getSalesRecent();

    UserAdopt getAdoptRecent();

    void updateSales(UserSale userSale);

    void acceptAdopt(int aid); // astatus 1로 바꿔주기, sstatus 0으로 바꿔주기

    void refusalAdopt(int aid); // astatus 0으로 바꿔주기

    void deleteSales(int sid);

    List<UserAdopt> getAdoptListBySid(int sid);
}
