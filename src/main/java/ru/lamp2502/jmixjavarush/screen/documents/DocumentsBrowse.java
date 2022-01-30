package ru.lamp2502.jmixjavarush.screen.documents;

import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.document.DocumentImpl;

@UiController("Documents.browse")
@UiDescriptor("documents-browse.xml")
@LookupComponent("documentsTable")
@Route("documents")
public class DocumentsBrowse extends StandardLookup<DocumentImpl> {
}