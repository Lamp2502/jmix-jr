package ru.lamp2502.jmixjavarush.screen.contract;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.document.Contract;

@UiController("Contract.edit")
@UiDescriptor("contract-edit.xml")
@EditedEntityContainer("contractDc")
public class ContractEdit extends StandardEditor<Contract> {
}