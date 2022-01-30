package ru.lamp2502.jmixjavarush.screen.documents;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.document.DocumentImpl;

@UiController("DefectsIdentificationAct.edit")
@UiDescriptor("documents-edit.xml")
@EditedEntityContainer("defectsIdentificationActDc")
public class DocumentsEdit extends StandardEditor<DocumentImpl> {
}