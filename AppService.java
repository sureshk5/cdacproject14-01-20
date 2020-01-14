package exam.hello;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	
	private DataBaseProject obj1;
	
	
	@Autowired
	public void setObj1(DataBaseProject obj1) {
		System.out.println("Service : repository DAO  wired to service ");
		this.obj1 = obj1;
	}

	public AppService()
	{
		
	}

	public String decodeIntoSHA256(String stringValue) {
		String hexstring=toHexString(getSHA256(stringValue));
		System.out.println(hexstring);
		return hexstring;
	}

	private String toHexString(byte[] sha256) {
		BigInteger number = new BigInteger(1, sha256); 
		StringBuilder hexString = new StringBuilder(number.toString(16)); 
		while(hexString.length()<32)
		{
			hexString.insert(0,'0');
		}
		return hexString.toString();
	}

	private byte[] getSHA256(String stringValue) {
		MessageDigest md=null;
		try {
			 md= MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		 return md.digest(stringValue.getBytes(StandardCharsets.UTF_8)); 
	}

	public Guide insertIntoDB(Guide guide) {
		String encodeUserId=decodeIntoSHA256(guide.getUserId());
		String encodePassword=decodeIntoSHA256(guide.getPassword());
		guide.setUserId(encodeUserId);
		guide.setPassword(encodePassword);
		obj1.insertDB(guide.getFirstName(),guide.getLastName(),guide.getGender(),guide.getgmail(),guide.getAddressProof(),guide.getcontact_number(),guide.getUserId(),guide.getPassword());
		return guide;
	}

	public Boolean findValue(String userid,String password) {
		String encodeuserid=decodeIntoSHA256(userid);
		String encodepassword=decodeIntoSHA256(password);
		Guide guide1=null;
		try {
			 guide1=obj1.findByUser(encodeuserid);
//			 System.out.println(encodepassword);
//			 System.out.println(guide1.getPassword());
//			 System.out.println(encodeuserid);
//			 System.out.println(guide1.getUserId());
		if(encodeuserid.equals(guide1.getUserId()))
			{
			if(encodepassword.equals(guide1.getPassword()))
				{
				System.out.println("matched");
				return true;
				}
			}	
		}
		catch(NullPointerException e)
		{
		System.out.println("not found");	
		}
		return false;
	}

	/*
	 * public Guide getId(int mn) { // note obj1 here is a repository object
	 * 
	 * Optional<Guide> x = obj1.findById(mn); Guide y =null; if(x.isPresent()) { y =
	 * x.get(); //get the mobile object
	 * 
	 * } else { y =new Guide(mn); } return y;
	 * 
	 * }
	 * 
	 * 
	 * public List<Guide> getAll() { return obj1.findAll(); }
	 * 
	 * public Guide delAcc(int accno) { obj1.deleteById(accno); Guide a =
	 * getId(accno); return a; }
	 * 
	 * public Guide update(Guide n) { // System.out.println("update failure"); //
	 * TODO Auto-generated method stub
	 * 
	 * if(obj1.existsById(n.getCustid())) { obj1.save(n); }//change of failing is
	 * almost zero.
	 * 
	 * else { n = new Guide(0); //obj1.save(n); } return n; }
	 */
}
