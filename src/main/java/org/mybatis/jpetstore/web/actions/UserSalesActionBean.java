package org.mybatis.jpetstore.web.actions;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;


import net.sourceforge.stripes.action.*;
import org.mybatis.jpetstore.domain.UserAdopt;
import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Image;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.service.CatalogService;
import org.mybatis.jpetstore.service.UserSalesService;
import org.mybatis.jpetstore.service.AccountService;
import net.sourceforge.stripes.integration.spring.SpringBean;


import javax.servlet.http.HttpSession;

/**
 * The Class UserSalesActionBean.
 *
 * @author Eduardo Macarron
 */
@SessionScope
public class UserSalesActionBean extends AbstractActionBean {

    private static final long serialVersionUID = 5849523372175050635L;

    private static final String SALES_LIST = "/WEB-INF/jsp/user_sales/UserSalesList.jsp";
    private static final String SELECT_SALES = "/WEB-INF/jsp/user_sales/SelectSalesForm.jsp";
    private static final String INSERT_SALES = "/WEB-INF/jsp/user_sales/InsertSalesForm.jsp";
    private static final String EDIT_SALES = "/WEB-INF/jsp/user_sales/EditSales.jsp";
    private static final String INFO_SALES = "/WEB-INF/jsp/user_sales/InfoSales.jsp";
    private static final String INSERT_ADOPT = "/WEB-INF/jsp/user_sales/InsertAdoptForm.jsp";
    private static final String UPDATE_ADOPT = "/WEB-INF/jsp/user_sales/UpdateAdoptForm.jsp";
    private static final String VIEW_ADOPT_LIST_ADT = "/WEB-INF/jsp/user_sales/ViewAdoptListForAdopter.jsp";
    private static final String VIEW_ADOPT_ADT = "/WEB-INF/jsp/user_sales/ViewAdoptForAdopter.jsp";
    private static final String VIEW_ADOPT_LIST_SL = "/WEB-INF/jsp/user_sales/ViewAdoptListForSales.jsp";
    private static final String VIEW_ADOPT_SL = "/WEB-INF/jsp/user_sales/ViewAdoptForSales.jsp";
    private static final String VIEW_SALES_LIST_SL = "/WEB-INF/jsp/user_sales/ViewSalesListForSales.jsp";

    @SpringBean
    private transient UserSalesService userSalesService;
    @SpringBean
    private transient AccountService accountService;
    @SpringBean
    private transient CatalogService catalogService;

    private List<UserAdopt> userAdoptsList;
    private List<Image> userImageList;
    private List<Item> userItemList;
    private List<Product> userProductList;
    private int[] adoptCntList;

    private int asid;
    private int aid;
    private String itemId;
    private int check;
    private FileBean img1;
    private FileBean img2;
    private FileBean img3;
    private String msg;
    private String f_category = "%";
    private String f_charge = "%";
    private int f_order = 0;
    private String f_search;

    private Account account = new Account();
    private UserAdopt userAdopt;
    private Image image = new Image();
    private Item userItem;
    private Product userProduct;


    public List<UserAdopt> getUserAdoptsList() { return userAdoptsList; }

    public void setUserAdoptsList(List<UserAdopt> userAdoptsList) { this.userAdoptsList = userAdoptsList; }

    public List<Image> getUserImageList() { return userImageList; }

    public void setUserImageList(List<Image> userImageList) { this.userImageList = userImageList; }

    public Account getAccount() { return account; }

    public void setAccount(Account account) { this.account = account; }

    public UserAdopt getUserAdopt() { return userAdopt; }

    public void setUserAdopt(UserAdopt userAdopt) { this.userAdopt = userAdopt; }

    public Image getImage() { return image; }

    public void setImage(Image image) { this.image = image; }

    public int getAsid() { return asid; }

    public void setAsid(int asid) { this.asid = asid; }

    public int getAid() { return aid; }

    public void setAid(int aid) { this.aid = aid; }

    public String getItemId() { return itemId; }

    public void setItemId(String itemId) { this.itemId = itemId; }

    public int getCheck() { return check; }

    public void setCheck(int check) { this.check = check; }

    public String getF_category() { return f_category; }

    public void setF_category(String f_category) { this.f_category = f_category; }

    public String getF_charge() { return f_charge; }

    public void setF_charge(String f_charge) { this.f_charge = f_charge; }

    public int isF_order() { return f_order; }

    public void setF_order(int f_order) { this.f_order = f_order; }

    public FileBean getImg1() { return img1; }

    public void setImg1(FileBean img1) { this.img1 = img1; }

    public FileBean getImg2() { return img2; }

    public void setImg2(FileBean img2) { this.img2 = img2; }

    public FileBean getImg3() { return img3; }

    public void setImg3(FileBean img3) { this.img3 = img3; }

    public String getF_search() { return f_search; }

    public void setF_search(String f_search) { this.f_search = f_search; }

    public int[] getAdoptCntList() { return adoptCntList; }

    public void setAdoptCntList(int[] adoptCntList) { this.adoptCntList = adoptCntList; }

    public String getMsg() { return msg; }

    public void setMsg(String msg) { this.msg = msg; }

    public Item getUserItem() { return userItem; }

    public void setUserItem(Item userItem) { this.userItem = userItem; }

    public Product getUserProduct() { return userProduct; }

    public void setUserProduct(Product userProduct) { this.userProduct = userProduct; }

    public List<Item> getUserItemList() { return userItemList; }

    public void setUserItemList(List<Item> userItemList) { this.userItemList = userItemList; }

    public List<Product> getUserProductList() { return userProductList; }

    public void setUserProductList(List<Product> userProductList) { this.userProductList = userProductList; }

    /**
     * View Sales List
     *
     * @return the resolution
     */
    @DefaultHandler
    public Resolution viewSalesListAll() {
        clear();
        msg = "전체 분양 목록";
        userItemList = catalogService.getUserItemList();
        return new ForwardResolution(SALES_LIST);
    }

    public Resolution viewSalesList() {
        if(f_search==null) f_search = "";
        if(f_category.equals("%")) msg = "전체 분양 목록";
        else if(f_category.equals("DOGS")) msg = "강아지 분양 목록";
        else if(f_category.equals("CATS")) msg = "고양이 분양 목록";
        else if(f_category.equals("BIRDS")) msg = "새 분양 목록";
        else if(f_category.equals("FISH")) msg = "물고기 분양 목록";
        else if(f_category.equals("REPTILES")) msg = "파충류 분양 목록";
        userItemList = catalogService.getUserItemListByFilter(f_category, f_charge,f_order,"%" + f_search.toLowerCase()+"%");

        return new ForwardResolution(SALES_LIST);
    }



    /**
     * Select Sales Form
     *
     * @return the resolution
     */
    public Resolution selectSalesForm(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        if (accountBean == null || !accountBean.isAuthenticated()) {
            setMessage("You must sign on before attempting to insert your pet to sale.  Please sign on and try checking out again.");
            return new ForwardResolution(AccountActionBean.class); }
        return new ForwardResolution(SELECT_SALES);
    }

    /**
     * Insert Sales Form
     *
     * @return the resolution
     */
    public Resolution insertSalesForm(){
        clear();
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();
        return new ForwardResolution(INSERT_SALES);
    }

    /**
     * Insert Sales
     *
     * @return the resolution
     */
    public Resolution insertSales() throws IOException {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();
        userItem.setUserId(account.getUsername());
        if (check == 0) {
            userItem.setCharge(0);
            userItem.setListPrice(BigDecimal.ZERO);
            userItem.setUnitCost(BigDecimal.ZERO);
        } else
            userItem.setCharge(1);
        if(userProduct.getName() == null || userItem.getListPrice() == null || userItem.getAttribute4() == null
                || userProduct.getName().length() < 1  || userItem.getAttribute4().length() < 1 || img1 == null){
            setMessage("필수항목을 입력해 주세요!");
            return new ForwardResolution(INSERT_SALES);
        }
        else {
            String id = "SAL-" + Integer.toString(catalogService.getNextId("salenum"));
            userItem.setItemId(id);
            userItem.setProductId(id);
            userItem.setUnitCost(userItem.getListPrice());
            userProduct.setProductId(id);
            catalogService.insertUserProduct(userProduct);
            catalogService.insertUserItem(userItem);
            //본인 user_images 경로 적기
            String path = "C:/Users/ktykt/git/Jpetstore/src/main/webapp/user_images/";

            if(img1!=null) {
                String time = LocalTime.now().toString().replace(":", "").replace(".", "");
                image.setDir("../user_images/"+time+img1.getFileName());
                image.setSid(id);
                catalogService.setProductDescription(id, "../user_images/"+time+img1.getFileName());
                img1.save(new File(path + time + img1.getFileName()));
                userSalesService.insertImage(image);
            }
            if(img2!=null) {
                String time = LocalTime.now().toString().replace(":", "").replace(".", "");
                image.setDir("../user_images/"+time+img2.getFileName());
                image.setSid(userItem.getItemId());
                img2.save(new File(path + time + img2.getFileName()));
                userSalesService.insertImage(image);
            }
            if(img3!=null) {
                String time = LocalTime.now().toString().replace(":", "").replace(".", "");
                image.setDir("../user_images/"+time+img3.getFileName());
                image.setSid(userItem.getItemId());
                img3.save(new File(path + time + img3.getFileName()));
                userSalesService.insertImage(image);
            }


            return viewSalesList();
        }

    }

    /**
     * Edit Sales Form
     *
     * @return the resolution
     */
    public Resolution updateSalesForm(){
        userItem = catalogService.getUserItem(itemId);
        userProduct = catalogService.getUserProduct(itemId);
        return new ForwardResolution(EDIT_SALES);
    }

    /**
     * Edit Sales
     *
     * @return the resolution
     */
    public Resolution updateSales(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();


        if(userProduct.getName() == null || userItem.getListPrice() == null || userItem.getAttribute4() == null
                || userProduct.getName().length() < 1  || userItem.getAttribute4().length() < 1){
            setMessage("필수항목을 입력해 주세요!");
            return new ForwardResolution(INSERT_SALES);
        }
        else {
            catalogService.updateUserItem(userItem);
            catalogService.updateUserProduct(userItem);
            return viewSalesList();
        }
    }
//
//    /**
//     * Edit Sales
//     *
//     * @return the resolution
//     */
//    public Resolution deleteSales(){
//        userSalesService.deleteSales(sid);
//        clear();
//        userSalesList = userSalesService.getSalesListAll();;
//        return new ForwardResolution(SALES_LIST);
//    }
//
//    /**
//     * View Sales Info
//     *
//     * @return the resolution
//     */
//    public Resolution viewSales(){
//        userSale = userSalesService.getSales(sid);
//        account = accountService.getAccount(userSale.getsuserid());
//        userImageList = userSalesService.getImageList(sid);
//        return new ForwardResolution(INFO_SALES);
//    }
//
//    /**
//     * Insert Adopt Form
//     *
//     * @return the resolution
//     */
//    public Resolution insertAdoptForm(){
//        clear();
//        HttpSession session = context.getRequest().getSession();
//        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
//        account = accountBean.getAccount();
//        userSale = userSalesService.getSales(sid);
//        return new ForwardResolution(INSERT_ADOPT);
//    }
//
//    /**
//     * Insert Adopt
//     *
//     * @return the resolution
//     */
//    public Resolution insertAdopt(){
//
//        HttpSession session = context.getRequest().getSession();
//        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
//        account = accountBean.getAccount();
//
//
//        if(userAdopt.getApets() == null || userAdopt.getAnote() == null
//                || userAdopt.getApets().length() < 1  || userAdopt.getAnote().length() < 1){
//            setMessage("필수항목을 입력해 주세요!");
//            return new ForwardResolution(INSERT_ADOPT);
//        }
//        else {
//            userAdopt.setAuserid(account.getUsername());
//            userAdopt.setAsid(userSale.getsid());
//            userSalesService.insertAdopt(userAdopt);
//            userAdopt = userSalesService.getAdoptRecent();
//            return new ForwardResolution(VIEW_ADOPT_ADT);
//        }
//    }
//
//    /**
//     * Update Adopt Form
//     *
//     * @return the resolution
//     */
//    public Resolution updateAdoptForm(){
//        return new ForwardResolution(UPDATE_ADOPT);
//    }
//
//    /**
//     * Update Adopt
//     *
//     * @return the resolution
//     */
//    public Resolution updateAdopt(){
//        userSalesService.updateAdopt(userAdopt);
//        return new ForwardResolution(VIEW_ADOPT_ADT);
//    }
//
//    /**
//     * Delete Adopt
//     *
//     * @return the resolution
//     */
//    public Resolution deleteAdopt(){
//        userSalesService.deleteAdopt(userAdopt.getAid());
//        userAdoptsList = userSalesService.getAdoptList();
//        return new ForwardResolution(VIEW_ADOPT_LIST_ADT);
//    }
//
//    /**
//     * View Adopt List For Adopter
//     *
//     * @return the resolution
//     */
//    public Resolution viewAdoptListAdt(){
//        HttpSession session = context.getRequest().getSession();
//        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
//        account = accountBean.getAccount();
//        userAdoptsList = userSalesService.getAdoptListByUsername(account.getUsername());
//        return new ForwardResolution(VIEW_ADOPT_LIST_ADT);
//    }
//
//    /**
//     * View Adopt For Adopter
//     *
//     * @return the resolution
//     */
//    public Resolution viewAdoptAdt(){
//        userAdopt = userSalesService.getAdopt(aid);
//        userSale = userSalesService.getSales(userAdopt.getAsid());
//        return new ForwardResolution(VIEW_ADOPT_ADT);
//    }
//
//    /**
//     * View Sales List For Sales
//     *
//     * @return the resolution
//     */
//    public Resolution viewSalesListSl(){
//        HttpSession session = context.getRequest().getSession();
//        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
//        account = accountBean.getAccount();
//        userSalesList = userSalesService.getSalesListByUsername(account.getUsername());
//        adoptCntList = new int[userSalesList.size()];
//        for(int i=0;i<userSalesList.size();i++)
//        {
//            UserSale temp = userSalesList.get(i);
//            adoptCntList[i]=userSalesService.getAdoptCnt(temp.getsid());
//        }
//        return new ForwardResolution(VIEW_SALES_LIST_SL);
//    }
//
//    /**
//     * View Adopt List For Sales
//     *
//     * @return the resolution
//     */
//    public Resolution viewAdoptListSl(){
//        userSale = userSalesService.getSales(sid);
//        userAdoptsList = userSalesService.getAdoptListBySid(sid);
//        return new ForwardResolution(VIEW_ADOPT_LIST_SL);
//    }
//
//    /**
//     * View Adopt For Sales
//     *
//     * @return the resolution
//     */
//    public Resolution viewAdoptSl(){
//        userAdopt = userSalesService.getAdopt(aid);
//        userSale = userSalesService.getSales(userAdopt.getAsid());
//        return new ForwardResolution(VIEW_ADOPT_SL);
//    }
//
//    /**
//     * Accept Adopt
//     *
//     * @return the resolution
//     */
//    public Resolution acceptAdopt(){
//        userSalesService.acceptAdopt(aid);
//        userSale = userSalesService.getSales(userSalesService.getAdopt(aid).getAsid());
//        userSale.setSstatus(0);
//        userSalesService.updateSales(userSale);
//        userSalesList = userSalesService.getSalesListByUsername(account.getUsername());
//        return new ForwardResolution(VIEW_ADOPT_LIST_SL);
//    }
//
//    /**
//     * Refusal Adopt
//     *
//     * @return the resolution
//     */
//    public Resolution refusalAdopt(){
//        userSalesService.refusalAdopt(aid);
//        userSalesList = userSalesService.getSalesListByUsername(account.getUsername());
//        return new ForwardResolution(VIEW_ADOPT_LIST_SL);
//    }
//
    /**
     * Clear.
     */
    public void clear() {
        userAdopt = new UserAdopt();
        f_category = "%";
        f_charge = "%";
        f_order = 0;
        f_search = "";
    }
}
