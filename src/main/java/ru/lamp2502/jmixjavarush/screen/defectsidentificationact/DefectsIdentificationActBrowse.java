package ru.lamp2502.jmixjavarush.screen.defectsidentificationact;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.DefectsIdentificationAct;

@UiController("DefectsIdentificationAct.browse")
@UiDescriptor("defects-identification-act-browse.xml")
@LookupComponent("defectsIdentificationActsTable")
public class DefectsIdentificationActBrowse extends StandardLookup<DefectsIdentificationAct> {
}