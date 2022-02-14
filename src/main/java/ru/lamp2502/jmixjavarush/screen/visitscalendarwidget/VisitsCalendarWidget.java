package ru.lamp2502.jmixjavarush.screen.visitscalendarwidget;

import io.jmix.dashboardsui.annotation.DashboardWidget;
import io.jmix.ui.component.Calendar;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.GregorianCalendar;

@UiController("VisitsCalendarWidget")
@UiDescriptor("visits-calendar-widget.xml")
@DashboardWidget(name = "DadhCalendar")
public class VisitsCalendarWidget extends ScreenFragment {
    @Autowired
    private Calendar calendar;
   /* @Autowired
    private CollectionContainer<Task> taskDc;
    @Autowired
    private CollectionLoader<Task> taskDl;*/

/*    @Subscribe
    private void onAfterInit(AfterInitEvent afterInitEvent) {
        taskDl.load();

        for (Task task : taskDc.getItems()) {
            SimpleCalendarEvent calendarEvent = new SimpleCalendarEvent();
            calendarEvent.setCaption(task.getDocument().getInstanceName());
            calendarEvent.setStart(task.getCreatedDate());
            calendarEvent.setEnd(task.getPerformBefore());
            calendarEvent.setAllDay(true);
            calendar.getEventProvider().addEvent(calendarEvent);
        }
    }*/

    @Subscribe("monthPicker")
    private void onMonthPickerValueChange(HasValue.ValueChangeEvent<Date> event) {
/*        LocalDate c = LocalDate.from(event.getValue());
        calendar.setStartDate(event.getValue());
        calendar.setEndDate(event.getValue());*/
        java.util.Calendar c = new GregorianCalendar();
        c.setTime(event.getValue());
        c.add(java.util.Calendar.DAY_OF_MONTH, c.getActualMaximum(java.util.Calendar.DAY_OF_MONTH));
        calendar.setStartDate(event.getValue());
        calendar.setEndDate( c.getTime());

    }
}