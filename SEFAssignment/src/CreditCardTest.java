
import static org.junit.Assert.*;
import org.junit.Test;

public class CreditCardTest {

	CreditCard Card1 =new CreditCard(100,"001");
	
	
	@Test
	public void getBalance() {
		
		assertEquals(Card1.getBalance(),100,0);
		
	}
	
	@Test
	public void addLoyaltyPoints() {
		
		Card1.addLoyaltyPoints(100);
		assertEquals(Card1.getBalance(),200,0);
		
	}
    
	@Test
	public void deductLoyaltyPoints() {
		
		Card1.deductLoyaltyPoints(10);
		assertEquals(Card1.getBalance(),90,0);
		
	}
	
}
