package org.mybatis.jpetstore.web.actions;

import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import org.mybatis.jpetstore.domain.UserSale;
import org.mybatis.jpetstore.domain.UserAdopt;
import org.mybatis.jpetstore.domain.Account;
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
    private static final String EDIT_SALES = "/WEB-INF/jsp/user_sales/EditSalesForm.jsp";
    private static final String INFO_SALES = "/WEB-INF/jsp/user_sales/InfoSales.jsp";
    private static final String INSERT_ADOPT = "/WEB-INF/jsp/user_sales/InsertAdoptForm.jsp";
    private static final String UPDATE_ADOPT = "/WEB-INF/jsp/user_sales/UpdateAdoptForm.jsp";
    private static final String VIEW_ADOPT_LIST_ADT = "/WEB-INF/jsp/user_sales/ViewAdoptListForAdopter.jsp";
    private static final String VIEW_ADOPT_ADT = "/WEB-INF/jsp/user_sales/ViewAdoptForAdopter.jsp";
    private static final String VIEW_ADOPT_LIST_SL = "/WEB-INF/jsp/user_sales/ViewAdoptListForSales.jsp";
    private static final String VIEW_ADOPT_SL = "/WEB-INF/jsp/user_sales/ViewAdoptForSales.jsp";


    @SpringBean
    private transient UserSalesService userSalesService;

    private List<UserSale> userSaleList;
    private List<UserAdopt> userAdoptsList;
    private UserSale userSale;
    private UserAdopt userAdopt;
    private int asid;
    private int aid;

    private Account account = new Account();

    public List<UserSale> getUserSaleList() { return userSaleList; }

    public void setUserSaleList(List<UserSale> userSaleList) { this.userSaleList = userSaleList; }

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

    /**
     * View Sales List
     *
     * @return the resolution
     */
    @DefaultHandler
    public Resolution viewSalesList() {
        return new ForwardResolution(SALES_LIST);
    }

    /**
     * Select Sales Form
     *
     * @return the resolution
     */
    public Resolution selectSalesForm(){
        return new ForwardResolution(SELECT_SALES);
    }

    /**
     * Insert Sales Form
     *
     * @return the resolution
     */
    public Resolution insertSalesForm(){
        return new ForwardResolution(INSERT_SALES);
    }

    /**
     * Edit Sales Form
     *
     * @return the resolution
     */
    public Resolution editSalesForm(){
        return new ForwardResolution(EDIT_SALES);
    }

    /**
     * View Sales Info
     *
     * @return the resolution
     */
    public Resolution infoSales(){
        return new ForwardResolution(INFO_SALES);
    }

    /**
     * Insert Adopt Form
     *
     * @return the resolution
     */
    public Resolution insertAdoptForm(){ return new ForwardResolution(INSERT_ADOPT); }

    /**
     * Insert Adopt
     *
     * @return the resolution
     */
    public Resolution insertAdopt(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        Account account = accountBean.getAccount();

        userAdopt.setAuserid(account.getUsername());
        userAdopt.setAsid(userSale.getsId());
        userSalesService.insertAdopt(userAdopt);
        return new ForwardResolution(VIEW_ADOPT_ADT);
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

    public Resolution deleteAdopt(){
        userSalesService.deleteAdopt(userAdopt.getAsid());
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
        Account account = accountBean.getAccount();
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
        return new ForwardResolution(VIEW_ADOPT_ADT);
    }

    /**
     * View Adopt List For Sales
     *
     * @return the resolution
     */
    public Resolution viewAdoptListSl(){
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        Account account = accountBean.getAccount();
        userSale = userSalesService.getSalesListByUsername(account.getUsername());
        return new ForwardResolution(VIEW_ADOPT_LIST_SL);
    }

    /**
     * View Adopt For Sales
     *
     * @return the resolution
     */
    public Resolution viewAdoptSl(){
        userAdopt = userSalesService.getAdopt(asid);
        return new ForwardResolution(VIEW_ADOPT_SL);
    }
}
