
package doctors;

import static doctors.config.connectDB;
import java.util.Scanner;


public class main {

    public void addDoctor(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Doctor First Name: ");
        String fname = sc.next();
        System.out.print("Doxtor Last Name: ");
        String lname = sc.next();
        System.out.print("Doctor specialization: ");
        String spec = sc.next();
        System.out.print("Contact number: ");
        String cnum = sc.next();
        System.out.print("Years of experience: ");
        String year = sc.next();
        String sql = "INSERT INTO tbl_doctor (d_fname, d_lname, d_spec, d_cnum, d_year) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, spec, cnum, year);

    }
    
    
    private void viewDoctor() {
        String Query = "SELECT * FROM tbl_doctor";
        String[] Headers = {"ID", "first Name", "Last name", "Specialization", "Contact num", "Years of experience"};
        String[] Columns = {"d_id", "d_fname", "d_lname", "d_spec", "d_cnum", "d_year"};
        config conf = new config();
        conf.viewRecords(Query, Headers, Columns);
    }
    
  private void updateDoctor(){
  
      Scanner sc = new Scanner(System.in);
  
      System.out.print("Enter Doctor ID to update: ");
      int id = sc.nextInt();
  
        System.out.print("Doctor First Name: ");
        String ufname = sc.next();
        System.out.print("Doxtor Last Name: ");
        String ulname = sc.next();
        System.out.print("Doctor specialization: ");
        String uspec = sc.next();
        System.out.print("Contact number: ");
        String ucnum = sc.next();
        System.out.print("Years of experience: ");
        String uyear = sc.next();
      String sqlUpdate = "UPDATE tbl_doctor SET d_fname = ?, d_lname = ?, d_spec = ?, d_cnum = ?, d_year = ? WHERE d_id = ?";
      config conf = new config();
      conf.updateRecord(sqlUpdate, ufname, ulname, uspec, ucnum, uyear, id);
      
  }  
    
    
 private void deleteDoctor(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Enter Doctor ID to delete: ");
        int id = sc.nextInt();
 
        String sqlDelete = "DELETE FROM tbl_doctor WHERE d_id = ?";
        conf.deleteRecord(sqlDelete, id);
 }

    
    
    public static void main(String[] args) {
        
        connectDB();
        Scanner sc = new Scanner(System.in);
        String op = null;
        main doc = new main();
     
        do{
        System.out.println(" Doctor data");
        System.out.println("-------------------------------------");
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        System.out.println("-------------------------------------");

        System.out.print("Enter Action: ");
        int option = sc.nextInt();

        while(option > 5){
            System.out.print("Invalid Action. Try Again: ");
            option = sc.nextInt();
         
        } switch(option){

            case 1:
               doc.addDoctor();
            break;
         
            case 2:
                 doc.viewDoctor();
            break;
         
            case 3:
                  doc.viewDoctor();
                  doc.updateDoctor();
            break;
           
            case 4:
                  doc.viewDoctor();
                   doc.deleteDoctor();
            break;
           
            case 5:
                System.exit(0);
                break;
           
    }     System.out.print("Do you want to continue?(yes/no): ");
            op=sc.next();
        }while(op.equals("yes")|| op.equals("no"));
         System.out.println("THANK YOU");
    }

 
}
    
    

