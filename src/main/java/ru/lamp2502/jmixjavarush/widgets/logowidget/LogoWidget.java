package ru.lamp2502.jmixjavarush.widgets.logowidget;

import io.jmix.dashboardsui.annotation.DashboardWidget;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("LogoWidget")
@UiDescriptor("logo-widget.xml")
@DashboardWidget(name = "Logo")
public class LogoWidget extends ScreenFragment {
}