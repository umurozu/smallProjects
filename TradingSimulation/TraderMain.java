
public class TraderMain {
	
	public static void main(String[] args) {
    	Trader trader = new Trader();
 
    	/*    	
    	 * clearOrders() order queuesini ve executed order queuesini temizlemek icin
    	 * 
    	 */
    	
    	
    	System.out.println("Main Scenario in the assignment: ");
    	// Sample orders
    	Order order1 = new Order("AAPL", "buy", 150.0, 100, 1, "user1", false);
    	Order order2 = new Order("GOOGL", "sell", 250.0, 50, 2, "user2", true);
    	Order order3 = new Order("MSFT", "buy", 180.0, 200, 3, "user3", false);
    	Order order4 = new Order("AAPL", "sell", 150.0, 50, 4, "user4", false);
    	Order cancelOrder = new Order("MSFT", "Cancel", 0.0, 0, 3, "user3", false);
 
    	// Push orders to the trader
    	trader.pushOrder(order1);
    	trader.pushOrder(order2);
    	trader.pushOrder(order3);
     	trader.pushOrder(order4);


    	// Execute trades
    	trader.execute();
 
    	// Print executed orders
    	trader.printExecutedOrders();
	//Format: sellerUsername,buyerUsername, price, quantity
    	// Push cancel order to the trader
    	trader.pushOrder(cancelOrder); //MSFT got cancelled
 
    	// Execute trades after cancel order
    	trader.execute();
 
    	// Print updated executed orders
    	trader.printExecutedOrders(); //nothing

	trader.printOrderQueue();
	//"GOOGL", "sell", 250.0, 50, 2, "user2", true
//"AAPL", "buy", 150.0, 50, 1, "user1", false
	
	
	System.out.println();	
	// Scenario 1: Simple match of buy and sell orders
    System.out.println("Scenario 1:");
    Order orderA = new Order("AAPL", "buy", 150.0, 100, 1, "user1", false);
    Order orderB = new Order("AAPL", "sell", 150.0, 100, 2, "user2", false);
    trader.pushOrder(orderA);
    trader.pushOrder(orderB);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();
   
    System.out.println();
    // Scenario 2: All or None testing
    System.out.println("Scenario 2:");
    Order orderC = new Order("AAPL", "buy", 100.0, 50, 3, "user3", true);
    Order orderD = new Order("AAPL", "sell", 200.0, 30, 4, "user4", false);
    trader.pushOrder(orderC);
    trader.pushOrder(orderD);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();
    
    System.out.println();
    // Scenario 3: Multiple orders with partial matching
    System.out.println("Scenario 3:");
    Order order5 = new Order("AAPL", "buy", 150.0, 200, 5, "user5", false);
    Order order6 = new Order("AAPL", "sell", 130.0, 100, 6, "user6", false);
    Order order7 = new Order("AAPL", "sell", 150.0, 50, 7, "user7", false);
    trader.pushOrder(order5);
    trader.pushOrder(order6);
    trader.pushOrder(order7);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();
    
    System.out.println();
    // Scenario 4: Cancel order
    System.out.println("Scenario 4:");
    Order order8 = new Order("AAPL", "buy", 100.0, 50, 8, "user8", false);
    Order order9 = new Order("AAPL", "sell", 100.0, 50, 9, "user9", false);
    Order cancelOrder2 = new Order("AAPL", "Cancel", 0.0, 0, 8, "user8", false);
    trader.pushOrder(order8);
    trader.pushOrder(cancelOrder2);
    trader.pushOrder(order9);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();
    
    System.out.println();
    //Scenario 5: Match at a lower price
    System.out.println("Scenario 5:");
    Order order10 = new Order("AAPL", "buy", 120.0, 100, 10, "user10", false);
    Order order11 = new Order("AAPL", "sell", 100.0, 100, 11, "user11", false);
    trader.pushOrder(order10);
    trader.pushOrder(order11);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();
    
    System.out.println();
    //Scenario 6: Partially fill a buy order
    System.out.println("Scenario 6:");
    Order order12 = new Order("AAPL", "buy", 150.0, 200, 12, "user12", false);
    Order order13 = new Order("AAPL", "sell", 150.0, 100, 13, "user13", false);
    trader.pushOrder(order12);
    trader.pushOrder(order13);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();
   
    System.out.println();
    //Scenario 7: Multiple matches with different sellers
    System.out.println("Scenario 7:");
    Order order14 = new Order("AAPL", "buy", 150.0, 300, 14, "user14", false);
    Order order15 = new Order("AAPL", "sell", 150.0, 100, 15, "user15", false);
    Order order16 = new Order("AAPL", "sell", 150.0, 100, 16, "user16", false);
    Order order17 = new Order("AAPL", "sell", 150.0, 100, 17, "user17", false);
    trader.pushOrder(order14);
    trader.pushOrder(order15);
    trader.pushOrder(order16);
    trader.pushOrder(order17);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();
   
    System.out.println();
    //Scenario 8: Multiple orders at different prices
    System.out.println("Scenario 8:");
    Order order20 = new Order("AAPL", "buy", 150.0, 100, 20, "user20", false);
    Order order21 = new Order("AAPL", "sell", 145.0, 100, 21, "user21", false);
    Order order22 = new Order("AAPL", "sell", 140.0, 100, 22, "user22", false);
    trader.pushOrder(order20);
    trader.pushOrder(order21);
    trader.pushOrder(order22);
    trader.execute();
    trader.printExecutedOrders();
    trader.printOrderQueue();

    System.out.println();
	//Scenario 9: Invalid order
    System.out.println("Scenario 9:");
    Order order23 = new Order("AAPL", "buy", 0, 0, 23, "user23", false);
    trader.pushOrder(order23);
    
    System.out.println();
    System.out.println();
	}

}
