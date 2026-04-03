/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedLinkedList = null;
        ListNode prev = null;

        if(list1 == null && list2 == null) 
        {
            return null;
        }

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                if(mergedLinkedList == null) {
                    mergedLinkedList = list1;
                    prev = mergedLinkedList;
                } else {
                    prev.next = list1;
                    prev = prev.next;
                }
                list1 = list1.next;
            } else {
                if(mergedLinkedList == null) {
                    mergedLinkedList = list2;
                    prev = mergedLinkedList;
                } else {
                    prev.next = list2;
                    prev = prev.next;
                }
                list2 = list2.next;
            }
        }

        if(list1 != null) {
            prev.next = list1;
        }

        if(list2 != null) {
            prev.next = list2;
        }
        
        return mergedLinkedList;
    }
}