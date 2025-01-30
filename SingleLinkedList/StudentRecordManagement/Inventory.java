package SingleLinkedList.StudentRecordManagement;

public class Inventory {

    public static class Node
    {
        String name;
        String id;
        int  quantity;
        double price;
        Node next;
        public Node(String ItemName,String ItemId,int ItemQuantity,double ItemPrice)
        {
            this.name = ItemName;
            this.id = ItemId;
            this.price = ItemPrice;
            this.quantity = ItemQuantity;
        }
    }
    public static Node head;
    public static int size;
    public static Node tail;

    public void additem(String ItemName,String ItemId,int ItemQuantity,double ItemPrice)
    {
        Node newNode = new  Node(ItemName, ItemId, ItemQuantity, ItemPrice);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void RemoveItem(String idItem)
    {
        Node temp = head;
         if(size ==0)
         {
             System.out.println("List is already empty");
         }
         else if(size ==1 && temp.id.equals(idItem)) {

           temp = head.next;
           size =0;
         }
         else
         {
            while(temp!=null)
            {
               if(temp.id.equals(idItem))
               {
                 temp = temp.next;
                 size--;
               }
               else
                   System.out.println("Record not found ");
            }
         }
    }

    public void updateItem(String id1,int newquantity)
    {
        Node temp = head;
        while(temp!=null)
        {
            if (temp.id.equals(id1))
            {
                temp.quantity = newquantity;
                return;
            }
            else
            {
                System.out.println("Record not found");
            }
            temp = temp.next;
        }
    }

    public void SearchItem(String id1)
    {
        Node temp = head;
        while(temp!=null)
        {
            if (temp.id.equals(id1))
            {
                System.out.println("Item is founded");
                return;
            }
            else
            {
                System.out.println("Record not found");
            }
            temp = temp.next;
        }
    }


    public void calculatePrice(double price,int quantity)
    {

        double total_value = price * quantity;
        System.out.println("Total price is :"+ total_value);
    }

     public static void main(String[] mmg)
     {
         Inventory product = new Inventory();
         product.additem("apple","1",40,60);
         product.additem("orange","2",25,100);
         product.calculatePrice(60,10);

     }

}
