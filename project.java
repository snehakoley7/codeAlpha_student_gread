import java .util.*;
class student{
    int id; 
    String name;
    int math, physics, computer; 
    int total;
    double per;
    student(int id, String name , int math,int physics, int computer){

        this.id=id;
        this.name=name;
        this.math=math;
        this.physics=physics;
        this.computer=computer;
        total=math+physics+computer;
        per= total/3.0;
    }
}
class  project{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<student>list = new ArrayList<>();
    public static boolean isIdUnique(int id){
        for (student s : list){
            if(s.id ==id){
              return false;
            }
        }
        return true;
    }
    //add student
    public static void addstudent(){

        int id;
        while(true){
            try{

              System.out.print("Enter the ID:");
              id=sc.nextInt();
            if(isIdUnique(id)){
                break;
            } 
            else{
                System.out.println("ID already exists! Try Again...");
            }  
         }catch(InputMismatchException e){
            System.out.print("invalid input !! plese enter number only");
            sc.nextLine();
         } 
        }
        sc.nextLine();
        System.out.print("Enter name:");
        String name =sc.nextLine();
        System.out.print("Math:");
        int m =sc.nextInt();
        System.out.print("Physics:");
        int p =sc.nextInt();
        System.out.print("Computer:");
        int c = sc.nextInt();

        list.add(new student(id,name,m,p,c));
        System.out.print("\nstudent Added");

    }
    //display student

    public static void displaystudent(){
        if(list.isEmpty()){
            System.out.println("No Record");
            return;
        }
        for (student s : list){
            int total =s.math + s.physics +s. computer;
            double per= total/3.0;
            System.out.println("\nID:" + s.id);
            System.out.println("Name:" + s.name);
            System.out.println(" Math:"+s.math);
            System.out.println("Physics:" +s.physics);
            System.out.println("Computer:" +s.computer);
            System.out.println("Total:"+total);
            System.out.println("Percentage: " +per);
        }
    } 
    //search student
    public static void searchstudent(){
       if(list.isEmpty()){
            System.out.println("No Record");
            return;
        }
        System.out.println("Enter the ID you want to search");
        int id =sc.nextInt();
        for(student s : list){
           if(s.id==id){
             System.out.println("Student found");
             System.out.println("____________________________");
             System.out.println("ID:"+id);
             System.out.println("Name:"+s.name);
             System.out.println("Math:"+s.math);
             System.out.println("Physics:"+s.physics);
             System.out.println("Computer:"+s.computer);
             System.out.println("Total:"+ s.total);
             System.out.println("Percentage:"+s.per);
             return;
            }
            else{
                System.out.println("student not fount");
            }
        }
    }
    public static void avarege(){
 if(list.isEmpty()){
            System.out.println("No Record");
            return;
        }
        double sum =0;
        for(student s :list){
            int total = s.math+ s.physics+s.computer;
            sum +=total/3.0;
        }
        double avg = sum/list.size();
         
        System.out.println("Avarege Percentage of Class : "+avg);

    }
    public static void highest(){

         if(list.isEmpty()){
            System.out.println("No Record");
            return;
        }
        student top=list.get(0);
        double maxper= (top.math+top.physics+top.computer)/3.0;
        for( student s : list){
            double per=(s.math+s.physics+s.computer)/3.0;
             if(maxper<per){
                maxper=per;
                top=s;
             }
        }
        System.out.println("______THE  TOP  STUDENT ________");
        System.out.println("ID:"+top.id);
        System.out.println("Name:"+top.name);
        System.out.println("Math:"+top.math);
        System.out.println("Physics:"+top.physics);
        System.out.println("Computer:"+top.computer);
        System.out.println("Total:"+ top.total);
        System.out.println("Percentage:"+maxper);
    }
    public static void lowest(){
       if(list.isEmpty()){
            System.out.println("No Record");
            return;
        }
        student top=list.get(0);
        double minper=(top.math+top.physics+top.computer)/3.0;
        for( student s : list){
            double per=(s.math+s.physics+s.computer)/3.0;
             if(minper>per){
                minper=per;
                top=s;
             }
        }
        System.out.println("__________________________");
        System.out.println("ID:"+top.id);
        System.out.println("Name:"+top.name);
        System.out.println("Math:"+top.math);
        System.out.println("Physics:"+top.physics);
        System.out.println("Computer:"+top.computer);
        System.out.println("Total:"+ top.total);
        System.out.println("Percentage:"+minper);
    }
    
    public static void delete(){
     if(list.isEmpty()){
            System.out.println("No Record");
            return;
        }
        System.out.println("Enter the ID you want to delete");
        int id=sc.nextInt();
        Iterator<student> it = list.iterator();
         while (it.hasNext()){
            student s = it.next();
            if(s.id ==id){
                it.remove();
                System.out.println("student Deleted");
                return;
            }
         }
         System.out.println("Student Not Found");

    }
    public static void main(String args[]){
        int ch;
        do{
            System.out.println("\n===========MENU==========\n");
            System.out.println("1 For add student\n 2 For Display all Student\n 3 for search Student\n 4 For Calculate Avarage\n 5 for display the highest marks\n 6 for Display the lowest marks\n 7 for Delete Student\n 8 for exit");
            System.out.println("_________________________________________");
            System.out.println("Enter your choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1: addstudent();
                        break;
                case 2: displaystudent();
                        break;
                case 3: searchstudent();
                        break;
                case 4:  avarege();
                        break;
                case 5: highest();
                        break;
                case 6: lowest();
                        break;
                case 7 : delete();
                         break;
                case 8:System.exit(0);     
                default: System.out.println("Try Again........");   
            }        
            
        }while(ch!=8);
    } 
}

