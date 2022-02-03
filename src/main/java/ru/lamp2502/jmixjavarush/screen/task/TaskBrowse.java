package ru.lamp2502.jmixjavarush.screen.task;

import io.jmix.ui.screen.*;
import ru.lamp2502.jmixjavarush.entity.Task;

@UiController("Task_.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTableSheet")
public class TaskBrowse extends StandardLookup<Task> {
}