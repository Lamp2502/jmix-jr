package ru.lamp2502.jmixjavarush.screen.document;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.document.Document;

@UiController("Document.edit")
@UiDescriptor("document-edit.xml")
@EditedEntityContainer("documentDc")
public class DocumentEdit extends StandardEditor<Document> {
}