package exam.hello;

import java.util.List;

import org.springframework.web.client.RestTemplate;

public class TestMain {

	
	//please before running D.java ensure server is running.
	
	public static void main(String[] args) {
		
		String url ="http://localhost:8080";
		RestTemplate t =new RestTemplate();
		
		  Guide x = t.getForObject(url+"/pw?x=1",Guide.class);
		  System.out.println(x. getAddressProof());
		  
		  
		  
		  Guide z =new  Guide("1","2","3","4","5","6","7","8");
		  Guide q =  t.postForObject(url+"/upd", z, Guide.class);
	      System.out.println("***************"+q);
		  
		  
		  
		  
		  
		  
		 
		
		  
		  /*
		
		  List l = t.getForObject(url+"/ms",List.class); 
		  
		  System.out.println(l.size());
		 
		
		  Mobile z =new Mobile(67,77);
		  Mobile q =  t.postForObject("http://localhost:8080/upd", z, Mobile.class);
		  System.out.println(q);
		  
		  
		  
		  */
		 
		
		
		
		
		
		
		
		
		

	}

}
