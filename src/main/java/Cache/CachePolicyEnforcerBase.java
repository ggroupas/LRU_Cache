package Cache;

import DoublyLinkedList.DoublyLinkedList;
import lombok.Getter;

/**
 * A policy enforcer is a set of actions that are used by a Cache to ensure a specific replacement/ eviction policy is enforced.
 *
 * @see Cache
 * @see CacheReplacementPolicy
 * */
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

