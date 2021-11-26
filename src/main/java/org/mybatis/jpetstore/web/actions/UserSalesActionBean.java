package org.mybatis.jpetstore.web.actions;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import net.sourceforge.stripes.action.*;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.domain.UserSale;
import org.mybatis.jpetstore.domain.UserAdopt;
import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.service.UserSalesService;
import org.mybatis.jpetstore.service.AccountService;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

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

    private List<UserSale> userSalesList;
    private List<UserAdopt> userAdoptsList;
    private UserSale userSale;
    private UserAdopt userAdopt;
    private int asid;
    private int aid;
    private int sid;
    private int check;
    private FileBean img;

    private String f_category = "%";
    private String f_charge = "%";
    private int f_order = 0;

    private Account account = new Account();

    public List<UserSale> getUserSalesList() { return userSalesList; }

    public void setUserSalesList(List<UserSale> userSalesList) { this.userSalesList = userSalesList; }

    public List<UserAdopt> getUserAdoptsList() { return userAdoptsList; }

    public void setUserAdoptsList(List<UserAdopt> userAdoptsList) { this.userAdoptsList = userAdoptsList; }

    public Account getAccount() { return account; }

    public void setAccount(Account account) { this.account = account; }

    public UserSale getUserSale() { return userSale; }

    public void setUserSale(UserSale userSale) { this.userSale = userSale; }

    public UserAdopt getUserAdopt() { return userAdopt; }

    public void setUserAdopt(UserAdopt userAdopt) { this.userAdopt = userAdopt; }

    public int getAsid() { return asid; }

    public void setAsid(int asid) { this.asid = asid; }

    public int getAid() { return aid; }

    public void setAid(int aid) { this.aid = aid; }

    public int getSid() { return sid; }

    public void setSid(int sid) { this.sid = sid; }

    public int getCheck() { return check; }

    public void setCheck(int check) { this.check = check; }

    public String getF_category() { return f_category; }

    public void setF_category(String f_category) { this.f_category = f_category; }

    public String getF_charge() { return f_charge; }

    public void setF_charge(String f_charge) { this.f_charge = f_charge; }

    public int isF_order() { return f_order; }

    public void setF_order(int f_order) { this.f_order = f_order; }

    public FileBean getImg() { return img; }

    public void setImg(FileBean img) { this.img = img; }

    /**
     * View Sales List
     *
     * @return the resolution
     */
    @DefaultHandler
    public Resolution viewSalesList() {
        userSalesList = userSalesService.getSalesList(f_category,f_charge,f_order);
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
    public Resolution insertSales(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();

        userSale.setsuserid(account.getUsername());
        if (check == 0) {
            userSale.setScharge(0);
            userSale.setSprice(BigDecimal.ZERO);
        } else
            userSale.setScharge(1);
        if(userSale.getSdesc() == null || userSale.getSprice() == null || userSale.getSnote() == null
                || userSale.getSdesc().length() < 1  || userSale.getSnote().length() < 1){
            setMessage("필수항목을 입력해 주세요!");
            return new ForwardResolution(INSERT_SALES);
        }
        else {
            userSalesService.insertSale(userSale);
            userSale = userSalesService.getSalesRecent();
            return new ForwardResolution(INFO_SALES);
        }

    }

    /**
     * Edit Sales Form
     *
     * @return the resolution
     */
    public Resolution updateSalesForm(){ return new ForwardResolution(EDIT_SALES); }

    /**
     * Edit Sales
     *
     * @return the resolution
     */
    public Resolution updateSales(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();


        if(userSale.getSdesc() == null || userSale.getSprice() == null || userSale.getSnote() == null
                || userSale.getSdesc().length() < 1  || userSale.getSnote().length() < 1){
            setMessage("필수항목을 입력해 주세요!");
            return new ForwardResolution(EDIT_SALES);
        }
        else {
            userSalesService.updateSales(userSale);
            userSalesList = userSalesService.getSalesList("%", "%", 0);
            return new ForwardResolution(INFO_SALES);
        }
    }

    /**
     * Edit Sales
     *
     * @return the resolution
     */
    public Resolution deleteSales(){
        userSalesService.deleteSales(sid);
        userSalesList = userSalesService.getSalesList("%", "%",0);
        return new ForwardResolution(SALES_LIST);
    }

    /**
     * View Sales Info
     *
     * @return the resolution
     */
    public Resolution viewSales(){
        userSale = userSalesService.getSales(sid);
        account = accountService.getAccount(userSale.getsuserid());
        return new ForwardResolution(INFO_SALES);
    }

    /**
     * Insert Adopt Form
     *
     * @return the resolution
     */
    public Resolution insertAdoptForm(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();
        userSale = userSalesService.getSales(sid);
        return new ForwardResolution(INSERT_ADOPT);
    }

    /**
     * Insert Adopt
     *
     * @return the resolution
     */
    public Resolution insertAdopt(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();


        if(userAdopt.getApets() == null || userAdopt.getAnote() == null
                || userAdopt.getApets().length() < 1  || userAdopt.getAnote().length() < 1){
            setMessage("필수항목을 입력해 주세요!");
            return new ForwardResolution(INSERT_ADOPT);
        }
        else {
            userAdopt.setAuserid(account.getUsername());
            userAdopt.setAsid(userSale.getsid());
            userSalesService.insertAdopt(userAdopt);
            userAdopt = userSalesService.getAdoptRecent();
            return new ForwardResolution(VIEW_ADOPT_ADT);
        }
    }

    /**
     * Update Adopt Form
     *
     * @return the resolution
     */
    public Resolution updateAdoptForm(){
        return new ForwardResolution(UPDATE_ADOPT);
    }

    /**
     * Update Adopt
     *
     * @return the resolution
     */
    public Resolution updateAdopt(){
        userSalesService.updateAdopt(userAdopt);
        return new ForwardResolution(VIEW_ADOPT_ADT);
    }

    /**
     * Delete Adopt
     *
     * @return the resolution
     */
    public Resolution deleteAdopt(){
        userSalesService.deleteAdopt(userAdopt.getAid());
        userAdoptsList = userSalesService.getAdoptList();
        return new ForwardResolution(VIEW_ADOPT_LIST_ADT);
    }

    /**
     * View Adopt List For Adopter
     *
     * @return the resolution
     */
    public Resolution viewAdoptListAdt(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();
        userAdoptsList = userSalesService.getAdoptListByUsername(account.getUsername());
        return new ForwardResolution(VIEW_ADOPT_LIST_ADT);
    }

    /**
     * View Adopt For Adopter
     *
     * @return the resolution
     */
    public Resolution viewAdoptAdt(){
        userAdopt = userSalesService.getAdopt(aid);
        userSale = userSalesService.getSales(userAdopt.getAsid());
        return new ForwardResolution(VIEW_ADOPT_ADT);
    }

    /**
     * View Sales List For Sales
     *
     * @return the resolution
     */
    public Resolution viewSalesListSl(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        account = accountBean.getAccount();
        userSalesList = userSalesService.getSalesListByUsername(account.getUsername());
        return new ForwardResolution(VIEW_SALES_LIST_SL);
    }

    /**
     * View Adopt List For Sales
     *
     * @return the resolution
     */
    public Resolution viewAdoptListSl(){
        userSale = userSalesService.getSales(sid);
        userAdoptsList = userSalesService.getAdoptListBySid(sid);
        return new ForwardResolution(VIEW_ADOPT_LIST_SL);
    }

    /**
     * View Adopt For Sales
     *
     * @return the resolution
     */
    public Resolution viewAdoptSl(){
        userAdopt = userSalesService.getAdopt(aid);
        userSale = userSalesService.getSales(userAdopt.getAsid());
        return new ForwardResolution(VIEW_ADOPT_SL);
    }

    /**
     * Accept Adopt
     *
     * @return the resolution
     */
    public Resolution acceptAdopt(){
        userSalesService.acceptAdopt(aid);
        userSale = userSalesService.getSales(userSalesService.getAdopt(aid).getAsid());
        userSale.setSstatus(0);
        userSalesService.updateSales(userSale);
        userSalesList = userSalesService.getSalesListByUsername(account.getUsername());
        return new ForwardResolution(VIEW_ADOPT_LIST_SL);
    }

    /**
     * Refusal Adopt
     *
     * @return the resolution
     */
    public Resolution refusalAdopt(){
        userSalesService.refusalAdopt(aid);
        userSalesList = userSalesService.getSalesListByUsername(account.getUsername());
        return new ForwardResolution(VIEW_ADOPT_LIST_SL);
    }

    /**
     * Clear.
     */
    public void clear() {
        userSale = new UserSale();
    }
}
