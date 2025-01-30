package SingleLinkedList.StudentRecordManagement;

public class Student {
    public static class Node
    {
        //public int rollNumber;
        String RollNumber;
        String Name;
        int age;
        char Grade;
        Node next;

        public Node(String roll,String name,int age,char grade)
        {
            this.RollNumber = roll;
            this.Name = name;
            this.age= age;
            this.Grade = grade;
            this.next = null;
        }
    }
     public static Node head;
     public static Node tail;
     public static int size;
     public void addstudent(String roll_no,String name,int age,char grade)
     {
         Node newNode = new Node(roll_no,name,age,grade);
          size++;
         if(head == null)
         {
           head = tail = newNode;
         }
         else
         {
            newNode.next = head;
            head = newNode;
         }
     }

     public void deletestudent(String rollNumber)
     {
        if(head == null)
        {
            System.out.println("List is already empty");
            return;
        }
        else
        {
            if(head.RollNumber.equals(rollNumber))
            {
               head = head.next;
               return;
            }
        }
     }
     public void search(String rollNumber)
     {
         for(int i=0;i<size;i++)
         {
             if(head.RollNumber.equals(rollNumber))
                 System.out.println("Record found");
             else
                 System.out.println("NO record found");
         }
     }
     public void display()
     {
         if(head == null)
             System.out.println("List is empty");
         else
         {
             Node temp = head;
             while(temp != null)
             {
                 System.out.println("Roll number of a student :"+ temp.RollNumber);
                 System.out.println("Name of a student :"+ temp.Name);
                 System.out.println("Age of a student :"+ temp.age);
                 System.out.println("Grade of a student :"+ temp.Grade);
                 System.out.println("----------*************---------------------");
                 temp = temp.next;
             }

         }
     }
     public void upgrade(String rollNumber,char newgrade)
     {
         Node current = head;
         while(current!= null)
         {
            if(current.RollNumber.equals(rollNumber))
            {
               current.Grade = newgrade;
                System.out.println("Grade updated for roll number :"+ current.RollNumber);
               return;
            }
             current = current.next;
         }
     }



     public static void main(String[] mmg)
     {
         Student student = new Student();

         student.addstudent("0111CS211113","Pratham mishra",22,'A');
         student.addstudent("0111CS211176","Shreya Gupta",23,'b');
         student.addstudent("0111CS211084","Naveen jha ",24,'b');
         student.addstudent("0111CS211072","Kushagra gupta",22,'b');
         System.out.println("\n =================================\n ");
         student.display();
         System.out.println("---------------***************------------------");
         System.out.println("Total number of students : "+ size);
     }



}
