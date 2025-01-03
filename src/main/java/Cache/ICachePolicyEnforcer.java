package Cache;

import DoublyLinkedList.DoublyLinkedList;

public interface ICachePolicyEnforcer<K, V> {

    void onItemAccessed(DoublyLinkedList.Node<K, V> item);
    void onCapacityReached();
    DoublyLinkedList.Node getItemToRemove();
    void add(DoublyLinkedList.Node<K, V> item);
    void addExisting(DoublyLinkedList.Node<K, V> item);
}
