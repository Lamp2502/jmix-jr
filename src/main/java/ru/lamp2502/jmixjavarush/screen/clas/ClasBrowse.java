package ru.lamp2502.jmixjavarush.screen.clas;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.Clas;

@UiController("Clas.browse")
@UiDescriptor("clas-browse.xml")
@LookupComponent("clasesTable")
public class ClasBrowse extends StandardLookup<Clas> {
}