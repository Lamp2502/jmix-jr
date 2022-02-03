package ru.lamp2502.jmixjavarush.screen.contract;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.document.Contract;

@UiController("Contract.browse")
@UiDescriptor("contract-browse.xml")
@LookupComponent("contractsTable")
public class ContractBrowse extends StandardLookup<Contract> {
}