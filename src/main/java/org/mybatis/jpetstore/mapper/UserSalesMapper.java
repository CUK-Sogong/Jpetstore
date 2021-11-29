package org.mybatis.jpetstore.mapper;
import org.mybatis.jpetstore.domain.Image;
import org.mybatis.jpetstore.domain.UserAdopt;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import java.util.List;

public interface UserSalesMapper {

    void insertAdopt(UserAdopt userAdopt);

    void updateAdopt(UserAdopt userAdopt);

    void deleteAdopt(int aid);

    List<UserAdopt> getAdoptList();

    List<UserAdopt> getAdoptListByUsername(String username);

    UserAdopt getAdopt(int aid);

    UserAdopt getAdoptRecent();

    void acceptAdopt(int aid); // astatus 1로 바꿔주기, sstatus 0으로 바꿔주기

    void refusalAdopt(int aid); // astatus 0으로 바꿔주기


    void insertImage(Image image);

    List<UserAdopt> getAdoptListBySid(String sid);

    int getAdoptCnt(String sid);

    List<Image> getImageList(String itemId);
    String getImageDirByItemId(String itemId);
}
