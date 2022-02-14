package ru.lamp2502.jmixjavarush.widgets.artwidget;

import io.jmix.core.DataManager;
import io.jmix.dashboards.model.Widget;
import io.jmix.dashboardsui.annotation.DashboardWidget;
import io.jmix.dashboardsui.annotation.WidgetParam;
import io.jmix.ui.WindowParam;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lamp2502.jmixjavarush.entity.User;

@UiController("sample_ArtWidget")
@UiDescriptor("art-widget.xml")
@DashboardWidget(name = "Pokemon Art", editFragmentId = "sample_PokemonWidgetEditor")
public class ArtWidget extends ScreenFragment {

    public static final String INIT_POKEMON = "246736KX";

    @Autowired
    private InstanceContainer<User> petDc;

    @Autowired
    private DataManager dataManager;

    @WindowParam
    @WidgetParam
    protected User pet;

    @WindowParam
    protected Widget widget;

    @Subscribe
    public void onInit(InitEvent event) {
        if (pet == null || pet.getImage() == null) {
            pet = dataManager.loadValue("select s from User s where " +
                            "s.username = :name", User.class)
                    .parameter("name", INIT_POKEMON)
                    .one();
        }
        petDc.setItem(pet);
        widget.setCaption(pet.getUsername());
    }
}