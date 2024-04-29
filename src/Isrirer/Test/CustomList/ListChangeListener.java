package Isrirer.Test.CustomList;

import java.util.EventListener;

public interface ListChangeListener extends EventListener {
    void listChanged(ListChangeEvent event);
}