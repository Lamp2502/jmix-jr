package ru.lamp2502.jmixjavarush.screen.documents;

import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.lamp2502.jmixjavarush.entity.User;
import ru.lamp2502.jmixjavarush.entity.document.DocumentImpl;

@UiController("DocumentImpl.edit")
@UiDescriptor("documents-edit.xml")
@EditedEntityContainer("documentDc")
@Route(value = "documents/edit", parentPrefix = "documents")


public class DocumentsEdit extends StandardEditor<DocumentImpl> {

    @Autowired
    private EntityPicker<User> managerField;
    @Autowired
    private Notifications notifications;

    @Subscribe("managerField.points")
    public void onCustomerEntityPickerPoints(Action.ActionPerformedEvent event) {
        User customer = managerField.getValue();
        if (customer != null) {
            notifications.create()
                    .withCaption(customer.getFirstName() +
                            " has " + customer.getWorkphone() +
                            " reward points")
                    .show();
        } else {
            notifications.create()
                    .withCaption("Choose a customer")
                    .show();
        }
    }
}