package ru.lamp2502.jmixjavarush.screen.document;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.document.Document;

@UiController("Document.browse")
@UiDescriptor("document-browse.xml")
@LookupComponent("documentsTable")
public class DocumentBrowse extends StandardLookup<Document> {
}