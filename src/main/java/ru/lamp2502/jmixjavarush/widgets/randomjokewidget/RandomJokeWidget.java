package ru.lamp2502.jmixjavarush.widgets.randomjokewidget;

import io.jmix.dashboardsui.annotation.DashboardWidget;
import io.jmix.dashboardsui.annotation.WidgetParam;
import io.jmix.dashboardsui.event.DashboardEvent;
import io.jmix.dashboardsui.widget.RefreshableWidget;
import io.jmix.ui.WindowParam;
import io.jmix.ui.component.TextArea;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.slf4j.Logger;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;


@UiController("sample_RandomJokeWidget")
@UiDescriptor("random-joke-widget.xml")
@DashboardWidget(name = "Random Joke")
public class RandomJokeWidget extends ScreenFragment implements RefreshableWidget {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RandomJokeWidget.class);
    @Inject
    private TextArea<String> randomJoke;

    @WindowParam(name = "font-size")
    @WidgetParam
    private String fontSize;

    private int errorCount = 0;

    @Subscribe
    private void onAfterInit(AfterInitEvent event) {
        if(fontSize!=null) {
            randomJoke.addStyleName(fontSize);
        }
        randomJoke.setValue(getNewJoke());
    }

    @Override
    public void refresh(DashboardEvent dashboardEvent) {
        randomJoke.setValue(getNewJoke());
    }

    private String getNewJoke() {
        String host = "icanhazdadjoke.com";
        String url = "https://" + host;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "text/plain");
        headers.set("User-Agent", "CubaDashboardDemoApp");
        headers.set("Cache-Control", "no-cache");
        headers.set("Host", host);
        HttpEntity<String> request = new HttpEntity<>("", headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                log.info("Can`t fetch a joke, response: " + response.toString());
            }
        } catch (Exception e) {
            log.error("Can`t fetch a joke", e);
        }
        errorCount++;
        return String.format("Can`t fetch a joke. Errors count: %d", errorCount);
    }
}