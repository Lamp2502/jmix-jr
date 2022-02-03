package ru.lamp2502.jmixjavarush.screen.main;

import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.ScreenTools;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.*;
import io.jmix.ui.model.*;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lamp2502.jmixjavarush.entity.User;
import ru.lamp2502.jmixjavarush.screen.contract.ContractBrowse;
import ru.lamp2502.jmixjavarush.screen.document.DocumentBrowse;
import ru.lamp2502.jmixjavarush.screen.task.TaskBrowse;

@UiController("MainScreen")
@UiDescriptor("main-screen.xml")
@Route(path = "main", root = true)
public class MainScreen extends Screen implements Window.HasWorkArea {
    @Autowired
    private DataManager dataManager;

    @Autowired
    private DataContext dataContext;


    @Autowired
    private ScreenTools screenTools;

    @Autowired
    private AppWorkArea workArea;

    @Autowired
    private CurrentUserSubstitution currentUserSubstitution;

    @Autowired
    private InstanceLoader<User> userDl;

    @Autowired
    private DataComponents dataComponents;

    @Autowired
    private UiComponents uiComponents;

    @Autowired
    private InstanceContainer<User> userDc;

    @Autowired
    private Label<String> fioInMainFon;
    @Autowired
    private Label<String> fioInHeader;
    @Autowired
    private Label<String> workPositionHeader;
    @Autowired
    private Label<String> workPlaceHeader;

    private LoadContext<User> loadContext;

    @Autowired
    private ScreenBuilders screenBuilders;


    @Autowired
    private Notifications notifications;

/*    @Autowired
    private Button documents;*/

    @Subscribe("documents")
    public void onScreenButtonClickForDocuments(Button.ClickEvent event) {
        screenBuilders.screen(this)
                .withScreenClass(DocumentBrowse.class)
                .withOpenMode(OpenMode.THIS_TAB)
                .build()
                .show();
    }

    @Subscribe("contracts")
    public void onScreenButtonClickForContracts(Button.ClickEvent event) {
        screenBuilders.screen(this)
                .withScreenClass(ContractBrowse.class)
                .withOpenMode(OpenMode.THIS_TAB)
                .build()
                .show();
    }

    @Subscribe("tasks")
    public void onScreenButtonClickForTasks(Button.ClickEvent event) {
        screenBuilders.screen(this)
                .withScreenClass(TaskBrowse.class)
                .withOpenMode(OpenMode.THIS_TAB)
                .build()
                .show();
    }


    @Install(to = "userDl", target = Target.DATA_LOADER)
    protected User customersDlLoadDelegate(LoadContext<User> loadContext) {
        loadContext.setQueryString("select c from User c where c.username like :username").
                setParameter("username", currentUserSubstitution.getEffectiveUser().getUsername());

        User user = dataManager.load(loadContext);
        String str = user.getLastName() != null ? user.getLastName() + " " : "";
        str += user.getFirstName() != null ? user.getFirstName() + " " : "";
        str += user.getPatronymic() != null ? user.getPatronymic() + " " : "";
        fioInMainFon.setValue(str);
        fioInHeader.setValue(str);
        workPositionHeader.setValue(user.getPosition());
        workPlaceHeader.setValue(user.getWorkplace());
        return dataManager.load(loadContext);
    }

 /*   @Subscribe
    protected void onInit(InitEvent event) {

        loadContext.setQueryString("select c from User c where c.username like :username").
                setParameter("username", currentUserSubstitution.getEffectiveUser().getUsername());
        User user = dataManager.load(loadContext);
        String str = user.getLastName() != null ? user.getLastName() + " " : "";
        str += user.getFirstName() != null ? user.getFirstName() + " " : "";
        str += user.getPatronymic() != null ? user.getPatronymic() + " " : "";
        fio.setValue(str);
    }*/

/*    @Install(to = "userDl", target = Target.DATA_LOADER)
    protected User customersDlLoadDelegate(LoadContext<User> loadContext) {
        dataManager.load(loadContext);

        System.out.println("loadContext  --------------------");
        System.out.println("query"+"-   "+ loadContext.getQuery());
        System.out.println("toString"+"-   "+ loadContext.toString());
        System.out.println("accessConstraints"+"-   "+ loadContext.getAccessConstraints());
        System.out.println("metaClass"+"-   "+ loadContext.getEntityMetaClass());
        System.out.println("fetchPlan"+"-   "+ loadContext.getFetchPlan());
        System.out.println("hints"+"-   "+ loadContext.getHints());
        System.out.println("id"+"-   "+ loadContext.getId());
        System.out.println("ids"+"-   "+ loadContext.getIds());
        System.out.println("prevQueries"+"-   "+ loadContext.getPreviousQueries());
        System.out.println("queryKey"+"-   "+ loadContext.getQueryKey());
        System.out.println("================");
        System.out.println("dataManager  --------------------");
        System.out.println("toString"+"-   "+ dataManager.toString());
        System.out.println("================");
        System.out.println("InstanceContainer  --------------------");
        System.out.println("toString"+"-   "+ userDc.toString());
*//*        System.out.println("toString"+"-   "+ userDc.getItem());
        System.out.println("toString"+"-   "+ userDc.getItem().getId());
        System.out.println("toString"+"-   "+ userDc.getItem().getFirstName());*//*
        System.out.println("================");
        System.out.println("currentUser  --------------------");
        System.out.println("userName"+"-   "+ currentUserSubstitution.getEffectiveUser().getUsername());
        System.out.println("toString"+"-   "+ currentUserSubstitution.getEffectiveUser().toString());
        System.out.println(currentUserSubstitution.getSubstitutedUser());
        System.out.println(currentUserSubstitution.getAuthenticatedUser());

        System.out.println("================");


        return dataManager.load(loadContext);
    }*/


    @Override
    public AppWorkArea getWorkArea() {
        return workArea;
    }

/*    @Subscribe("collapseDrawerButton")
    private void onCollapseDrawerButtonClick(Button.ClickEvent event) {
        drawer.toggle();
        if (drawer.isCollapsed()) {
            collapseDrawerButton.setIconFromSet(JmixIcon.CHEVRON_RIGHT);
        } else {
            collapseDrawerButton.setIconFromSet(JmixIcon.CHEVRON_LEFT);
        }
    }*/

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        screenTools.openDefaultScreen(
                UiControllerUtils.getScreenContext(this).getScreens());

        screenTools.handleRedirect();
    }


}
