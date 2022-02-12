package ru.lamp2502.jmixjavarush.widgets.lookupwidget;

import io.jmix.dashboards.model.DashboardModel;
import io.jmix.dashboards.model.Widget;
import io.jmix.dashboardsui.annotation.DashboardWidget;
import io.jmix.dashboardsui.annotation.WidgetParam;
import io.jmix.dashboardsui.component.Dashboard;
import io.jmix.dashboardsui.event.DashboardEvent;
import io.jmix.dashboardsui.widget.RefreshableWidget;
import io.jmix.ui.WindowParam;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@DashboardWidget(name = "CAPTION", editFragmentId = "dshbrd_LookupWidget.edit")
@UiController("dshbrd_LookupWidget")
@UiDescriptor("lookup-widget.xml")
public class LookupWidget extends ScreenFragment implements RefreshableWidget {
    public static final String CAPTION = "Lookup";

    @WindowParam
    protected Widget widget;

    @WindowParam
    protected DashboardModel dashboardModel;

    @WindowParam
    protected Dashboard dashboard;

    @WidgetParam
    @WindowParam
    protected String lookupWindowId;

    public String getLookupWindowId() {
        return lookupWindowId;
    }

    public void setLookupWindowId(String lookupWindowId) {
        this.lookupWindowId = lookupWindowId;
    }

    @Override
    public void refresh(DashboardEvent dashboardEvent) {
        //some actions
    }
}