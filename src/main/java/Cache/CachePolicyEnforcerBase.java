package Cache;

import DoublyLinkedList.DoublyLinkedList;
import lombok.Getter;

public abstract class CachePolicyEnforcerBase implements ICachePolicyEnforcer {
    DoublyLinkedList _list = new DoublyLinkedList<>();

    public DoublyLinkedList.Node getHead() {
        return this._list.getHead();
    }

    public DoublyLinkedList.Node getTail() {
        return this._list.getTail();
    }

}

