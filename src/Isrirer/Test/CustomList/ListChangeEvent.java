package Isrirer.Test.CustomList;

import java.util.EventObject;

public class ListChangeEvent extends EventObject {
    public ListChangeEvent(Object source) {
        super(source);
    }
}