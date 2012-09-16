import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/15/12
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class biblioteca {
    public static final int RESERVED=1;
    public static final int AVAILABLE=0;

    public class Book{
        String sBookName;
        int iStatus;

        Book()
        {
            sBookName="";
            iStatus=AVAILABLE;
        }
        Book(String sBookName,int iStatus)
        {
            this.sBookName=sBookName;
            this.iStatus=iStatus;
        }

        int getiStatus()
        {
            return iStatus;
        }
        String getsBookName()
        {
            return sBookName;
        }
        void setiStatus(int iStatus)
        {
            this.iStatus=iStatus;
        }
    }
    Book listOfBooks[];
    biblioteca()
    {
        listOfBooks=new Book[10];
        listOfBooks[0]=new Book("Harry Potter 1",AVAILABLE);
        listOfBooks[1]=new Book("Harry Potter 2",AVAILABLE);
        listOfBooks[2]=new Book("Harry Potter 3",AVAILABLE);
        listOfBooks[3]=new Book("Harry Potter 4",AVAILABLE);
        listOfBooks[4]=new Book("Harry Potter 5",AVAILABLE);
        listOfBooks[5]=new Book("Harry Potter 6",AVAILABLE);
        listOfBooks[6]=new Book("Harry Potter 7",AVAILABLE);
        listOfBooks[7]=new Book("Little Women 1",AVAILABLE);
        listOfBooks[8]=new Book("Little Women 2",AVAILABLE);
        listOfBooks[9]=new Book("Little Women 3",AVAILABLE);
    }
    biblioteca(String sBookName,int iStatus)
    {
        listOfBooks = new Book[1];
        listOfBooks[0]=new Book(sBookName,iStatus);
    }


    void displayWelcomeMessage(String message)
    {
        System.out.print(message);
    }

    int displayAllBooks()
    {
           System.out.println("Book Name------Status( 0 means Available/1 stands for reserved");

           for(int iCounter=0;iCounter<=listOfBooks.length-1;iCounter++)
           {
               System.out.println(listOfBooks[iCounter].getsBookName()+"\t\t"+listOfBooks[iCounter].getiStatus());
           }
        return 0;
    }
    Book findBookAvailability(String bookName)
    {
        for(int iCounter=0;iCounter<=0;iCounter++)
        {
            if(listOfBooks[iCounter].getsBookName().equals(bookName))
            {
                return listOfBooks[iCounter];
            }
        }
        return null;
    }

    void reserveBook() throws IOException
    {
        BufferedReader dataRead=new BufferedReader(new InputStreamReader(System.in));
        String sReserveBookName;
        Book requestedBook;

        System.out.print("Enter the name of the book you want to reserve:\t");
        sReserveBookName=dataRead.readLine();
        requestedBook=findBookAvailability(sReserveBookName);

        /*a null object would signify that the book is not present in the library */
        if(requestedBook!=null)
        {
            if(requestedBook.getiStatus()==AVAILABLE)
            {
                System.out.println("“Thank You! Enjoy the book.\n");
                requestedBook.setiStatus(RESERVED);
            }
            else
            {
                System.out.println("Sorry the book is already reserved");
            }
        }
        else
        {
            System.out.println("“Sorry we don't have that book yet");
        }
    }

    void viewDetails(String message)
    {
          System.out.print(message);

    }
    int displayOptions()  throws IOException
    {
        BufferedReader dataInput=new BufferedReader(new InputStreamReader(System.in)) ;
        int iChoice;
        String sChoice;

        System.out.println("--------Please choose what you want to do from the list given below:------");
        System.out.println("1->See all the books in the library");
        System.out.println("2->Reserve a book") ;
        System.out.println("3->Check your details");
        System.out.println("4->Exit");

        do{
            System.out.print("Please enter a valid choice:");
            sChoice= dataInput.readLine();
            iChoice=Integer.parseInt(sChoice);
        }while(iChoice!=1 && iChoice!=2 && iChoice!=3 && iChoice!=4);

        return iChoice;
    }

    public static void main( String args[]) throws IOException
    {
        int iMemberChoice;

        biblioteca Biblioteca=new biblioteca();
        Biblioteca.displayWelcomeMessage("Hi Member. Welcome to Bangalore Biblioteca");
        iMemberChoice=Biblioteca.displayOptions();

        while(iMemberChoice!=4)
        {
            switch(iMemberChoice)
            {
                case 1: Biblioteca.displayAllBooks();
                    break;
                case 2: Biblioteca.reserveBook();
                    break;
                case 3: Biblioteca.viewDetails("Please talk to Librarian. Thank you.");
                    break;
            }
            iMemberChoice=Biblioteca.displayOptions();
        }

    }

}
