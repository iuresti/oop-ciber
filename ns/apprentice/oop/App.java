package ns.apprentice.oop;

import java.util.HashMap;

import ns.apprentice.oop.ciber.repository.impl.ComputerRepositoryImpl;
import ns.apprentice.oop.ciber.repository.impl.RentItemRepositoryImpl;
import ns.apprentice.oop.ciber.repository.impl.UserRepositoryImpl;
import ns.apprentice.oop.ciber.service.impl.ComputerServiceImpl;
import ns.apprentice.oop.ciber.service.impl.ConfigurationServiceImpl;
import ns.apprentice.oop.ciber.service.impl.RentServiceImpl;
import ns.apprentice.oop.ciber.service.impl.UserServiceImpl;
import ns.apprentice.oop.ciber.view.CiberUI;
import ns.apprentice.oop.ciber.view.impl.CiberUIMainMenu;
import ns.apprentice.oop.ciber.view.impl.ComputerView;
import ns.apprentice.oop.ciber.view.impl.ReleaseView;
import ns.apprentice.oop.ciber.view.impl.RentView;
import ns.apprentice.oop.ciber.view.impl.UserView;

//Use javac -d target -classpath . ns/apprentice/oop/App.java to compile
public class App {

    public static final String BEAN_MAIN_VIEW = "MAIN_VIEW";
    public static final String BEAN_COMPUTER_VIEW = "COMPUTER_VIEW";
    public static final String BEAN_USER_VIEW = "USER_VIEW";
    public static final String BEAN_RENT_VIEW = "RENT_VIEW";
    public static final String BEAN_RELEASE_VIEW = "BEAN_RELEASE_VIEW";

    public static final String BEAN_COMPUTER_REPOSITORY = "COMPUTER_REPOSITORY";
    public static final String BEAN_USER_REPOSITORY = "USER_REPOSITORY";
    public static final String BEAN_RENT_ITEM_REPOSITORY = "RENT_ITEM_REPOSITORY";

    public static final String BEAN_CONFIGURATION_SERVICE = "CONFIGURATION_SERVICE";
    public static final String BEAN_RENT_SERVICE = "RENT_SERVICE";
    public static final String BEAN_COMPUTER_SERVICE = "COMPUTER_SERVICE";
    public static final String BEAN_USER_SERVICE = "USER_SERVICE";

    private static HashMap<String, Object> beans;

    static {
        beans = new HashMap<>();

        beans.put(BEAN_USER_REPOSITORY, new UserRepositoryImpl());
        beans.put(BEAN_COMPUTER_REPOSITORY, new ComputerRepositoryImpl());
        beans.put(BEAN_RENT_ITEM_REPOSITORY, new RentItemRepositoryImpl());

        beans.put(BEAN_CONFIGURATION_SERVICE, new ConfigurationServiceImpl());
        beans.put(BEAN_COMPUTER_SERVICE, new ComputerServiceImpl());
        beans.put(BEAN_USER_SERVICE, new UserServiceImpl());
        beans.put(BEAN_RENT_SERVICE, new RentServiceImpl());

        beans.put(BEAN_COMPUTER_VIEW, new ComputerView());
        beans.put(BEAN_USER_VIEW, new UserView());
        beans.put(BEAN_RENT_VIEW, new RentView());
        beans.put(BEAN_RELEASE_VIEW, new ReleaseView());
        beans.put(BEAN_MAIN_VIEW, new CiberUIMainMenu());
    }

    public static void main(String[] args) throws Exception {

        CiberUI ciberUI = (CiberUI) App.getBean(BEAN_MAIN_VIEW);

        do {
            try {
                ciberUI = ciberUI.execute();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ciberUI = (CiberUI) App.getBean(BEAN_MAIN_VIEW);
            }
        } while (ciberUI != null);

    }


    public static Object getBean(String beanId) {
        return beans.get(beanId);
    }
}
