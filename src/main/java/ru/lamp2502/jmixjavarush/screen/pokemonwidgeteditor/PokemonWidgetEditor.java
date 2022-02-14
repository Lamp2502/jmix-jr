package ru.lamp2502.jmixjavarush.screen.pokemonwidgeteditor;

import io.jmix.dashboardsui.annotation.WidgetParam;
import io.jmix.ui.WindowParam;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lamp2502.jmixjavarush.entity.User;

@UiController("sample_PokemonWidgetEditor")
@UiDescriptor("pokemon-widget-editor.xml")
public class PokemonWidgetEditor extends ScreenFragment {

    @Autowired
    private EntityPicker<User> pokemonPicker;

    @WindowParam
    @WidgetParam
    protected User pet;

    @Subscribe("pokemonPicker")
    public void onPokemonPickerValueChange(HasValue.ValueChangeEvent<String> event) {
        pet=pokemonPicker.getValue();
    }

}