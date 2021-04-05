package com.sixthou;

public class Q0021_Merge_Two_Sorted_List {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        Solution solution = new Solution();
        solution.mergeTwoLists(l1,l2);


    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode ans;
            ListNode tmp;

            //시작 노드 결정
            if(l1.val >= l2.val){
                ans = l2;
                tmp = l1;
            }else{
                ans = l1;
                tmp = l2;
            }

            //탐색 시작
            while (tmp.next != null){
                if(ans.next.val > tmp.next.val){
                    ans.next = tmp.next;
                    tmp.next = ans.next;
                }
            }

            return null;
        }
    }
}
