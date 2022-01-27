package ru.lamp2502.jmixjavarush.screen.main;

import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.ui.ScreenTools;
import io.jmix.ui.component.AppWorkArea;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Window;
import io.jmix.ui.component.mainwindow.Drawer;
import io.jmix.ui.download.DownloadFormat;
import io.jmix.ui.download.Downloader;
import io.jmix.ui.icon.JmixIcon;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiControllerUtils;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lamp2502.jmixjavarush.entity.User;

@UiController("MainScreen")
@UiDescriptor("main-screen.xml")
@Route(path = "main", root = true)
public class MainScreen extends Screen implements Window.HasWorkArea {
    @Autowired
    private DataManager dataManager;

    @Autowired
    private ScreenTools screenTools;

    @Autowired
    private AppWorkArea workArea;
/*    @Autowired
    private Drawer drawer;*/
 /*   @Autowired
    private Button collapseDrawerButton;*/

    User loadByGenericId(Id<User> userId) {
        return dataManager.load(userId).one();
    }


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
