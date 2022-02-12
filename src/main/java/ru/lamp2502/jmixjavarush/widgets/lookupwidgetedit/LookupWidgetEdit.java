package ru.lamp2502.jmixjavarush.widgets.lookupwidgetedit;

import io.jmix.core.Metadata;
import io.jmix.dashboards.model.Widget;
import io.jmix.dashboardsui.annotation.WidgetParam;
import io.jmix.dashboardsui.screen.widget.WidgetEdit;
import io.jmix.ui.WindowConfig;
import io.jmix.ui.WindowParam;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import io.jmix.ui.sys.ScreenXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Map;

@UiController("dshbrd_LookupWidget.edit")
@UiDescriptor("lookup-widget-edit.xml")
public class LookupWidgetEdit extends ScreenFragment {
    @Autowired
    protected ComboBox<String> lookupIdComboBox;
    @Autowired
    protected WindowConfig windowConfig;
    @Autowired
    protected Metadata metadata;
    @Autowired
    protected ScreenXmlLoader screenXmlLoader;

    protected InstanceContainer<Widget> widgetDc;

    @WidgetParam
    @WindowParam
    protected String lookupWindowId;

    @Subscribe
    public void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        Map<String, Object> params = Collections.emptyMap();
        if (options instanceof MapScreenOptions) {
            params = ((MapScreenOptions) options).getParams();
        }
    //    lookupIdComboBox.setOptionsList(getAllLookupIds());
     //   lookupIdComboBox.addValueChangeListener(e -> lookupIdSelected(e.getValue()));

        initWidgetDс(params);
     //   selectLookupId();
    }

    protected void initWidgetDс(Map<String, Object> params) {
        widgetDc = (InstanceContainer<Widget>) params.get(WidgetEdit.ITEM_DC);
    }
}