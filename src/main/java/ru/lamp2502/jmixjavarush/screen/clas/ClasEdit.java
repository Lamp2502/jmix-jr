package ru.lamp2502.jmixjavarush.screen.clas;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.Clas;

@UiController("Clas.edit")
@UiDescriptor("clas-edit.xml")
@EditedEntityContainer("clasDc")
public class ClasEdit extends StandardEditor<Clas> {
}