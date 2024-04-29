package Isrirer.Test.CustomList;

import javax.swing.event.EventListenerList;

public class List {
    protected Object[] elements;
    private EventListenerList listenerList = new EventListenerList();

    public List() {
        elements = new Object[0];
    }

    public void addElement(Object element) {
        Object[] newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = element;
        elements = newElements;

        fireListChanged();
    }

    public Object getElement(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    private void fireListChanged() {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == ListChangeListener.class) {
                ((ListChangeListener) listeners[i + 1]).listChanged(new ListChangeEvent(this));
            }
        }
    }

    public void addListChangeListener(ListChangeListener listener) {
        listenerList.add(ListChangeListener.class, listener);
    }

    public void removeListChangeListener(ListChangeListener listener) {
        listenerList.remove(ListChangeListener.class, listener);
    }
}

