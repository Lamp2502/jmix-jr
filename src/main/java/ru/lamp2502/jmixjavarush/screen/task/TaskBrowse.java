package ru.lamp2502.jmixjavarush.screen.task;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.Task;

@UiController("Task_.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
public class TaskBrowse extends StandardLookup<Task> {
}