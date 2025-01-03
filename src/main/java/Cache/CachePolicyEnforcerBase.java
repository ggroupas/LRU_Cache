package Cache;

import DoublyLinkedList.DoublyLinkedList;
import lombok.Getter;

public abstract class CachePolicyEnforcerBase {
    DoublyLinkedList _list = new DoublyLinkedList<>();

    abstract void onItemAccessed(DoublyLinkedList.Node item);
    abstract void onCapacityReached();
    abstract DoublyLinkedList.Node getItemToRemove();
    abstract void add(DoublyLinkedList.Node item);
    abstract void addExisting(DoublyLinkedList.Node item);

    public DoublyLinkedList.Node getHead() {
        return this._list.getHead();
    }

    public DoublyLinkedList.Node getTail() {
        return this._list.getTail();
    }

}

