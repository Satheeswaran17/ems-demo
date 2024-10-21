import org.hibernate.Session;
import org.hibernate.service.ServiceRegistryBuilder;   
import org.hibernate.service.ServiceRegistry;       
import org.hibernate.SessionFactory;   
import org.hibernate.cfg.Configuration;     
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
    
public class StoreData {    
public static void main(String[] args) {    
  Configuration con = new Configuration().configure();
	//ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    //Create typesafe ServiceRegistry object    
  //StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();        
  //Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();    
  SessionFactory factory = con.buildSessionFactory();  
  Session session = factory.openSession();  
  Transaction t = session.beginTransaction();   
  Employee e1=new Employee();    
  e1.setId(102);    
  e1.setFirstName("Gaurav");    
  e1.setLastName("Chawla");            
  session.save(e1);  
  t.commit();  
  System.out.println("successfully saved");    
  factory.close();  
  session.close();           
 }    
} 