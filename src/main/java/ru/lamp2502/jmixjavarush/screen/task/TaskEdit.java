package ru.lamp2502.jmixjavarush.screen.task;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.Task;

@UiController("Task_.edit")
@UiDescriptor("task-edit.xml")
@EditedEntityContainer("taskDc")
public class TaskEdit extends StandardEditor<Task> {
}