package linkedlist;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        recursive(l1, l2, result, 0);
        return result;
    }

    private static ListNode recursive(ListNode l1, ListNode l2, ListNode result, Integer carry) {

        if (l1 == null && l2 == null) {
            return result;
        }

        // if both have same no of elemnts
        if (l1 != null && l2 != null) {
            Integer sum = l1.val + l2.val;
            int remainder = sum % 10 + carry;
            carry = sum / 10;
            if (result.next == null) {
                result.val = remainder;
                result.next = new ListNode();
            } else {
                result = result.next;
                result.val = remainder;
                result.next = new ListNode();
            }
            recursive(l1.next, l2.next, result, carry);
        }

       //  if l1 have more element than l2
        if (l1 != null && l2 == null) {
            Integer sum = l1.val;
            int remainder = sum % 10 + carry;
            carry = sum / 10;
            result.next= new ListNode(remainder,null);
            recursive(l1.next, null, result,carry);
        }

        // if l2 have more number of elements
        if (l2 != null & l1== null) {
            Integer sum = l2.val;
            int remainder = sum % 10 + carry;
            carry = sum / 10;
            result.next= new ListNode(remainder,null);
            recursive(null, l2.next, result,carry);
        }

        //when both reach end of list
        if (l2 == null && l1 == null) {
            Integer sum = l1.val + l2.val;
            int remainder = sum % 10 + carry;
            carry = sum / 10;
            result.next = new ListNode(remainder);
            recursive(l1.next, l2.next, result, carry);
        }

        return result;
    }
}