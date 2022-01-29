package ru.lamp2502.jmixjavarush.screen.defectsidentificationact;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.DefectsIdentificationAct;

@UiController("DefectsIdentificationAct.edit")
@UiDescriptor("defects-identification-act-edit.xml")
@EditedEntityContainer("defectsIdentificationActDc")
public class DefectsIdentificationActEdit extends StandardEditor<DefectsIdentificationAct> {
}