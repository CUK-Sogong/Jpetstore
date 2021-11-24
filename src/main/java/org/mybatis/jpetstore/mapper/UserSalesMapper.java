package org.mybatis.jpetstore.mapper;
import org.mybatis.jpetstore.domain.UserSale;
import org.mybatis.jpetstore.domain.UserAdopt;
import java.util.List;

public interface UserSalesMapper {
    List<UserSale> getSalesList();
}
