import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	CreditCard Card1 = new CreditCard(20,"001");
	CreditCard Card2 = new CreditCard(300,"002");
	
	
	Customer C1 = new Customer("Jimmy","001",null, null, Card1);
	Customer C2 = new Customer("Peter","002",null, null, Card2);
	
	Product p1 = new Product("123", 100, 20);
	Product p2 = new Product("125", 100, 300);
	Product p3 = new Product("125", 100, 1000);

@Before
public void init(){
	SuperMarketSystem.products.add(p1);
	SuperMarketSystem.products.add(p2);
	SuperMarketSystem.products.add(p3);
}

@Test
public void testAddLoyaltyPoints() {
	
	C1.getCard().addLoyaltyPoints(1000);
	assertEquals(C1.getCard().getBalance(),1020,0);
}

@Test
public void testPickUP(){
	C1.pickUp(p1);
	C1.pickUp(p2);	
	C1.pickUp(p3);	
	assertEquals(C1.calAmount(),1320,0);
	
}


@Test
public void testCheckCreditPoint() {
	
	assertEquals(C1.checkCreditPoint(),20,0);
}

@Test
public void testPayment() {
	C1.pickUp(p1);
	C1.pickUp(p2);
	C1.pickUp(p3);
	assertEquals(0, C1.getPreviousTransacitons().size());
	C1.payment();  //total price should be 1320, but there was 20 LoyaltyPoints in the account, it get 5 dollar discount.so the bill is 1315 dollar.
	assertEquals(1, C1.getPreviousTransacitons().size());
	}
}
