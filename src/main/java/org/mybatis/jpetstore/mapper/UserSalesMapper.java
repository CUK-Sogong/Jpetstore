package org.mybatis.jpetstore.mapper;
import org.mybatis.jpetstore.domain.UserAdopt;
import java.util.List;
import org.mybatis.jpetstore.domain.UserSale;

public interface UserSalesMapper {

    List<UserSale> getSalesList();

    void insertSale(UserSale userSale);

    void insertAdopt(UserAdopt userAdopt);

    void updateAdopt(UserAdopt userAdopt);

    void deleteAdopt(int asid);

    List<UserAdopt> getAdoptList();

    List<UserAdopt> getAdoptListByUsername(String username);

    UserAdopt getAdopt(int asid);

    List<UserSale> getSalesListByUsername(String username);

    UserSale getSales(int sid);

    void updateSales(UserSale userSale);

    void acceptAdopt(); // astatus 1로 바꿔주기, sstatus 0으로 바꿔주기

    void refusalAdopt(); // astatus 0으로 바꿔주기
}
