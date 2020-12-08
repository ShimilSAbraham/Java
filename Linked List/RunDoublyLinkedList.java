import java.io.*;

class Node
{
  int data;
  Node next;
  Node prev;
}

class DoublyLinkedList
{
  Node head;
  Node tail;
  //function to insert elements to the list
  public void insert(int n)
  {
    Node newnode = new Node();
    newnode.data = n;
    //if the list is empty
    if(head==null)
    {
        head=newnode;
        tail=head;
    }
    //using the tail we can avoid a while loop to find the end of the list
    else
    {
        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
    }
  }
  //function to delete a particular element
  public int delete(int n, int count)
  {
    Node temp = head;
    //after this while temp will point either to the searched item or will be the last node or both
    while(n!=temp.data && temp.next!=null)
        temp=temp.next;
    if(temp.data==n)
    {
      //if the starting element is to be deleted
      if(temp==head)
      {
        //if its the only element left
        if(count==1)
        {
            head=null;
            tail=null;
        }
        else
        {
            head=temp.next;
            head.prev=null;
        }
      }
      else
      {
        if(temp.next==null)
        {
          (temp.prev).next=null;
          tail=temp.prev;
        }
        else
        {
            (temp.next).prev=temp.prev;
            (temp.prev).next=temp.next; 
        }
      }            
      return count-1;
    }
    else
    {
      System.out.println("No such element found");
      return count;
    }
 }
      public void display()
      {
          Node temp = head;
          do {            
              System.out.println(temp.data);
              temp=temp.next;
          } while (temp!=null);
  }
}

public class RunDoublyLinkedList {
    public static void main(String[] args)throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                DoublyLinkedList list = new DoublyLinkedList();
                int op,input,count=0;
                do 
                {  
                    System.out.println("Enter the operation to be performed:");
                    System.out.println("1 to insert, 2 to delete, 3 to display and 4 to exit");
                    op=Integer.parseInt(br.readLine());
                    if(op==1)
                    {
                        count+=1;
                        System.out.println("Enter the number to be inserted:");
                        input=Integer.parseInt(br.readLine());
                        list.insert(input);
                    }
                    else if(op==2)
                    {
                        if(count==0)
                            System.out.println("List is empty. Cannot delete any elements");
                        else
                        {
                            System.out.println("Enter the number to be deleted:");
                            input=Integer.parseInt(br.readLine());
                            count=list.delete(input,count);
                        }
                    }
                    else if(op==3)
                    {
                        if(count==0)
                            System.out.println("List is empty.");
                        else
                        {
                            System.out.println("The list contains:");
                            list.display();
                        }
                    }
                        
                    else
                        System.out.println("Exiting from the program");
                } while (op!=4);
    }
}
