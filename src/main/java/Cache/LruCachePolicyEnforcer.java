package Cache;

import DoublyLinkedList.DoublyLinkedList;

public class LruCachePolicyEnforcer extends CachePolicyEnforcerBase {

    @Override
    public void onItemAccessed(DoublyLinkedList.Node item) {
        _list.moveToHead(item);
    }

    @Override
    public void onCapacityReached() {
        _list.removeTail();
    }

    public DoublyLinkedList.Node getItemToRemove(){
        return _list.getTail();
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
