package ru.lamp2502.jmixjavarush.screen.user;

import io.jmix.ui.Notifications;
import io.jmix.ui.component.GroupTable;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lamp2502.jmixjavarush.entity.User;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;

import java.util.Set;

@UiController("User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {
    @Autowired
    private Notifications notifications;


    @Install(to = "usersTable.create", subject = "afterCommitHandler")
    private void customersGroupTableCreateAfterCommitHandler(User customer) {
        notifications.create()
                .withCaption("Created  " + customer)
                .show();
    }
}