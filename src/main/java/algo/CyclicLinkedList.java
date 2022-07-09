package algo;

import java.util.HashSet;
import java.util.Set;

public class CyclicLinkedList {
    public static void main(String[] args) {
        int[] listA = new int[]{2,4,3,5,6};
        LinkNode c= createListWithCycle(listA);
        printList(c,listA.length);
        LinkNode nodeWithCycle = findNodeWithCycle(c);
        System.out.println("Value of Node with cycle is (using a HashSet) \t"+ nodeWithCycle.value);

        LinkNode hareTor = findCycleWithHareAndTortoise(c);
        if(hareTor != null) System.out.println("Value of the cycle node from HareTortoise algo is\t"+hareTor.value);
        else System.out.println("No cycle detected");

    }
    static class LinkNode {
        public int value;
        public LinkNode next ;

        LinkNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static  LinkNode  findNodeWithCycle(LinkNode head){
        LinkNode current = head ;
        Set<LinkNode> nodeSet = new HashSet<>();
        if(head == null || head.next == null) return  head;
        else{
            while(current.next !=null){
                if(nodeSet.contains(current)) return  current;
                else nodeSet.add(current);

                current = current.next;
            }
        }
        return  current;
    }
    // Using Floyd's : Hare and Tortoise algorithm
    public static  LinkNode findCycleWithHareAndTortoise(LinkNode head){
        // 1. Tortoise advances One position
        // 2. Hare advances Two positions
        // 3. The node where both meet is MeetingNode (can be hare or tortoise )
        // 4. At this point the hare and tortoise will be pointing at the same Node. So initialize p2 = hare OR tortoise
        // 5. Initialize p1 = head
        // 6. advance p1 and p2 till they meet at the same node .
        // 7. The meeting node of P1 and P2 is the cycle Node to be returned.

        LinkNode hare = head , tortoise = head ;
        while(true){
            if(tortoise==null || tortoise.next == null) return null;
            else {
                tortoise = tortoise.next ;
                hare = hare.next.next; // Hare advances Two positions
            }
            if (hare == tortoise ) break;
        }

        // at this point the hare and tortoise will be pointing at the same Node. So initialize p2 = hare OR tortoise

        LinkNode p1 = head , p2 = hare;

        // advance p1 and p2 till they meet at the same node .
        // the meeting node of P1 and P2 is the cycle Node to be returned.
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1 ;
    }

    public static  LinkNode createListWithCycle(int[] valueArray){
        int[] listArray = valueArray;
        LinkNode head=null, cycleNode = null , currentNode = head ;

        for(int i = listArray.length-1 ; i>=0 ; i--){
            if(head == null ){
                head = currentNode  = new LinkNode(listArray[i]);
            }else {
                currentNode.next = new LinkNode(listArray[i]);
                if(i==3) cycleNode = currentNode.next; // initializing cycle node
                currentNode = currentNode.next;
            }
        }
        currentNode.next = cycleNode;// creating cycle node

        return  head;
    }

    public static void printList(LinkNode head, int count) {
        while (count >=0) {
            System.out.print(head.value + "-->");
            if(head.next!=null)
                head = head.next;
            count--;
        }
        System.out.println("\n");
    }
}