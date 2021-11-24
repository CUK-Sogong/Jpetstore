package org.mybatis.jpetstore.mapper;
import org.mybatis.jpetstore.domain.UserAdopt;
import java.util.List;
import org.mybatis.jpetstore.domain.UserSale;

public interface UserSalesMapper {

    List<UserSale> getSalesList();

    void insertAdopt(UserAdopt userAdopt);

    void updateAdopt(UserAdopt userAdopt);

    void deleteAdopt(int asid);

    List<UserAdopt> getAdoptList();

    List<UserAdopt> getAdoptListByUsername(String username);

    UserAdopt getAdopt(int asid);

    UserSale getSalesListByUsername(String username);
}
