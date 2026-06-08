public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

       ListNode dummy = new ListNode(0);
       ListNode current = dummy;
       int carry = 0;
       while(l1!=null || l2!=null || carry!=0)
       {
           int x = 0;
           int y = 0;
           if(l1!=null)
           {
               x= l1.val;
           }
           if(l2!=null)
           {
               y= l2.val;
           }

           int sum = x+y+carry;
           carry=sum/10;
           int digit = sum%10;
           current.next = new ListNode(digit);
           current=current.next;

           if(l1!=null)
           {
               l1=l1.next;
           }
           if(l2!=null)
           {
               l2=l2.next;
           }
       }
       return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        AddTwoNumbers solution = new AddTwoNumbers();

        // 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(result);
    }
}