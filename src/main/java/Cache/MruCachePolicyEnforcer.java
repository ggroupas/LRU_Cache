package Cache;

import DoublyLinkedList.DoublyLinkedList;

/**
 * <b>MRU: Most Recently Used</b><br>
 *
 * Keeps most recent item to HEAD
 * Removes items from HEAD
 */
public class MruCachePolicyEnforcer extends CachePolicyEnforcerBase {

    @Override
    public void onItemAccessed(DoublyLinkedList.Node item) {
        _list.moveToHead(item);
    }

    @Override
    public void onCapacityReached() {
        _list.removeHead();
    }

    public DoublyLinkedList.Node getItemToRemove(){
        return _list.getHead();
    }

    @Override
    public void add(DoublyLinkedList.Node item) {
        _list.addNode(item);
    }

    @Override
    public void addExisting(DoublyLinkedList.Node item) {
        _list.moveToHead(item);
    }
}
