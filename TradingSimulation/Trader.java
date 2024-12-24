import java.util.*;

class Order {
    String stockSymbol;
    String orderType;
    double price;
    int quantity;
    int timestamp;
    String userID;
    boolean allOrNone;

    public Order(String stockSymbol, String orderType, double price, int quantity, int timestamp, String userID, boolean allOrNone) {
        this.stockSymbol = stockSymbol;
        this.orderType = orderType;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.userID = userID;
        this.allOrNone = allOrNone;
    }
    
    public boolean equals(Order o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return timestamp == order.timestamp &&
               orderType.equals(order.orderType) &&
               stockSymbol.equals(order.stockSymbol) &&
               price == order.price &&
               quantity == order.quantity &&
               userID.equals(order.userID);
    }
    
    public double getPrice() {
    	return this.price;
    }
    
    
}

public class Trader {
    Queue<Order> orderQueue = new LinkedList<>();
    Queue<Order> NonExecutedOrderQueue = new LinkedList<>();
    List<String> executedOrders = new ArrayList<>();
    
    
    
    public static void main(String[]args) {
    	
    	
    	
    	
    	Trader trader = new Trader();
  	
    	System.out.println("Homework Main: ");
    	
    	Order order1 = new Order("AAPL", "buy", 150.0, 100, 1, "user1", false);
    	Order order2 = new Order("GOOGL", "sell", 250.0, 50, 2, "user2", true);
    	Order order3 = new Order("MSFT", "buy", 180.0, 200, 3, "user3", false);
    	Order order4 = new Order("AAPL", "sell", 150.0, 50, 4, "user4", false);
    	Order cancelOrder = new Order("MSFT", "Cancel", 0.0, 0, 3, "user3", false);
 
    	
    	trader.pushOrder(order1);
    	trader.pushOrder(order2);
    	trader.pushOrder(order3);
     	trader.pushOrder(order4);


    	
    	trader.execute();
 
    	
    	trader.printExecutedOrders();
	
    	trader.pushOrder(cancelOrder); //MSFT got cancelled
 
    	
    	trader.execute();
 
    	
    	trader.printExecutedOrders(); //nothing

    	trader.printOrderQueue();
    	
    	System.out.println();
    	System.out.println("My Test Cases:");
    	
    	Trader trader2 = new Trader();
    	
    	System.out.println();
    	System.out.println("Sell price > buy price:");
    	Order order5 = new Order("AAPL", "buy", 150.0, 100, 1, "user1", false);
    	Order order6 = new Order("AAPL", "sell", 250.0, 50, 2, "user2", false);
    	Order order7 = new Order("MSFT", "buy", 180.0, 200, 3, "user3", false);
    	Order order8 = new Order("LLD", "sell", 150.0, 50, 4, "user4", false);
    	
    	trader2.pushOrder(order5);
    	trader2.pushOrder(order6);
    	trader2.pushOrder(order7);
     	trader2.pushOrder(order8);
     	trader2.execute();
     	trader2.printExecutedOrders();
     	trader2.printOrderQueue();
     	
     	System.out.println();
     	System.out.println("Benefit on Buyer Test:");
     	
     	Trader trader3 = new Trader();
     	
     	Order order9 = new Order("AAPL", "buy", 150.0, 100, 1, "user1", false);
    	Order order10 = new Order("AAPL", "sell", 100.0, 10, 2, "user2", false);
    	Order order11 = new Order("AAPL", "sell", 50.0, 20, 3, "user3", false);
    	Order order12 = new Order("AAPL", "sell", 20.0, 50, 4, "user4", false);
    	
    	trader3.pushOrder(order9);
    	trader3.pushOrder(order10);
    	trader3.pushOrder(order11);
     	trader3.pushOrder(order12);
     	trader3.execute();
     	trader3.printExecutedOrders();
     	trader3.printOrderQueue();
     	
     	System.out.println();
     	System.out.println("All Or None Test:");
     	
     	Trader trader4 = new Trader();
     	
     	Order order13 = new Order("AAPL", "buy", 150.0, 10, 1, "user1", true);
    	Order order14 = new Order("AAPL", "sell", 100.0, 100, 2, "user2", true);  // no transfer
    	
    	Order order15 = new Order("GOOGL", "buy", 150.0, 100, 1, "user3", false);    
    	Order order16 = new Order("GOOGL", "sell", 100.0, 10, 2, "user4", true);
    	
    	Order order17 = new Order("UBER", "buy", 150.0, 100, 1, "user5", true);
    	Order order18 = new Order("UBER", "sell", 100.0, 100, 2, "user6", true);
    	
    	Order order29 = new Order("ASELS", "buy", 150.0, 100, 1, "user7", true);
    	Order order30 = new Order("ASELS", "sell", 100.0, 95, 2, "user8", false); // no transfer
    	
    	
    	
    	trader4.pushOrder(order13);
    	trader4.pushOrder(order14);
    	trader4.pushOrder(order15);
    	trader4.pushOrder(order16);
    	trader4.pushOrder(order17);
    	trader4.pushOrder(order18);
    	trader4.pushOrder(order29);
    	trader4.pushOrder(order30);
    	
     	trader4.execute();
     	trader4.printExecutedOrders();
     	trader4.printOrderQueue();
     	
     	System.out.println();
     	System.out.println("Invalid Orders:");
     	
     	Trader trader5 = new Trader();
     	
     	Order order19 = new Order("AAPL", "buy", 0.0, 0, 1, "user1", true);
    	Order order20 = new Order("AAPL", "sell", 0.0, 0, 2, "user2", true); 
    	
    	trader5.pushOrder(order19);
    	trader5.pushOrder(order20);
    	
    	trader5.execute();                  
    	trader5.printExecutedOrders();
     	trader5.printOrderQueue();
     	
     	System.out.println();
     	System.out.println("Multiple Sellers:");
     	
     	
     	
     	Trader trader6 = new Trader();
     	
     	
     	
     	Order order21 = new Order("KOC", "buy", 150.0, 300, 14, "user1", false);
        Order order22 = new Order("KOC", "sell", 150.0, 100, 15, "user2", false);
        Order order23 = new Order("KOC", "sell", 150.0, 100, 16, "user3", false);
        Order order24 = new Order("KOC", "sell", 150.0, 100, 17, "user4", false);
        trader6.pushOrder(order21);
        trader6.pushOrder(order22);
        trader6.pushOrder(order23);
        trader6.pushOrder(order24);
        trader6.execute();
        trader6.printExecutedOrders();
        trader6.printOrderQueue();
        
        
        System.out.println();
     	System.out.println("Canceling while there are pairs");
        
        
        
        Trader trader7 = new Trader();
     	
     	
     	
     	Order order25 = new Order("KOC", "buy", 150.0, 300, 14, "user1", false);
        Order order26 = new Order("KOC", "Cancel", 0.0, 0, 14, "user1", false);
        Order order27 = new Order("KOC", "sell", 150.0, 100, 16, "user3", false);
        Order order28 = new Order("KOC", "sell", 150.0, 100, 17, "user4", false);
        trader7.pushOrder(order25);
        trader7.pushOrder(order26);
        trader7.pushOrder(order27);
        trader7.pushOrder(order28);
        trader7.execute();
        trader7.printExecutedOrders();
        trader7.printOrderQueue();
        
        
        
        
        System.out.println();
     	System.out.println("Buyer Has Benefit But Seller Wants To Sell All Test:");
        
        
        
        Trader trader8 = new Trader();
     	
     	
     	
     	Order order31 = new Order("KT", "buy", 150.0, 300, 14, "user1", false);
        Order order32 = new Order("KT", "sell", 28.0, 150, 15, "user2", true);
        Order order33 = new Order("KT", "sell", 35.0, 250, 16, "user3", true);
        Order order34 = new Order("KT", "sell", 150.0, 100, 17, "user4", false);
        trader8.pushOrder(order31);
        trader8.pushOrder(order32);
        trader8.pushOrder(order33);
        trader8.pushOrder(order34);
        trader8.execute();
        trader8.printExecutedOrders();
        trader8.printOrderQueue();
        
        
        
        
        System.out.println();
     	System.out.println("Additional Cancel Test:");
        
        
        
        Trader trader10 = new Trader();
     	
     	
     	
     	Order order39 = new Order("KT", "sell", 10.0, 300, 14, "user1", false);
        Order order40 = new Order("KT", "buy", 28.0, 150, 15, "user2", false);
        Order order41 = new Order("KT", "buy", 35.0, 250, 16, "user3", false);
        Order order42 = new Order("KT", "Cancel", 0.0, 0, 14, "user1", false);
        trader10.pushOrder(order39);
        trader10.pushOrder(order40);
        trader10.pushOrder(order41);
        trader10.pushOrder(order42);
        trader10.execute();
        trader10.printExecutedOrders();
        trader10.printOrderQueue();
        
        
        
        
        System.out.println();
     	System.out.println("Buyer Order Test:");
        
        
        
        Trader trader11 = new Trader();
     	
     	
     	
     	Order order43 = new Order("TOGG", "sell", 2000.0, 300, 14, "user1", false);
        Order order44 = new Order("TOGG", "buy", 2800.0, 100, 15, "user2", false);
        Order order45 = new Order("TOGG", "buy", 3500.0, 100, 16, "user3", false);
        Order order46 = new Order("TOGG", "buy", 5000.0, 100, 17, "user4", false);
        Order order47 = new Order("TOGG", "sell", 5000.0, 100, 18, "user5", false);
        trader11.pushOrder(order43);
        trader11.pushOrder(order44);
        trader11.pushOrder(order45);
        trader11.pushOrder(order46);
        trader11.pushOrder(order47);
        trader11.execute();
        trader11.printExecutedOrders();
        trader11.printOrderQueue();
        
        
        
        
        
        
        
        System.out.println();
     	System.out.println("Cancel Before Order:");
        
        
        
        Trader trader12 = new Trader();
     	
     	
     	
     	Order order48 = new Order("META", "sell", 10.0, 300, 14, "user1", true);
        Order order49 = new Order("META", "buy", 28.0, 300, 15, "user2", true);
        Order order52 = new Order("KT","Cancel", 0 ,0 ,17,"user4",false);       // ignored.
        Order order50 = new Order("KT", "buy", 35.0, 250, 16, "user3", false);
        Order order51 = new Order("KT", "sell", 33.0, 250, 17, "user4", false);
        trader12.pushOrder(order48);
        trader12.pushOrder(order49);
        trader12.pushOrder(order52);
        trader12.pushOrder(order50);
        trader12.pushOrder(order51);
        trader12.execute();
        trader12.printExecutedOrders();
        trader12.printOrderQueue();
     	
    	System.out.println();
     	System.out.println("Something Nice & Random:");
        
        
        
        Trader trader9 = new Trader();
     	
     	
     	
     	Order order35 = new Order("KT", "sell", 10.0, 300, 14, "user1", false);
        Order order36 = new Order("KT", "buy", 28.0, 150, 15, "user2", false);
        Order order37 = new Order("KT", "buy", 35.0, 250, 16, "user3", false);
        Order order38 = new Order("KT", "sell", 33.0, 100, 17, "user4", false);
        trader9.pushOrder(order35);
        trader9.pushOrder(order36);
        trader9.pushOrder(order37);
        trader9.pushOrder(order38);
        trader9.execute();
        trader9.printExecutedOrders();
        trader9.printOrderQueue();
     	
    	
    }
    

    public void pushOrder(Order order) {
    	
    	
    	if(order.orderType.equals("Cancel")) {
    		
    		for (Order current: orderQueue) {
    			
    			if (current.timestamp == order.timestamp && current.userID.equals(order.userID) 
    					&& current.stockSymbol.equals(order.stockSymbol)) {
                    orderQueue.remove(current);
                    break;
    			
    			}
    		}
    	
    	}
    	
    	else if(order.price > 0 && order.quantity > 0)
        orderQueue.add(order);
    }

    public void execute() {
    	
    	
    	executedOrders.clear();
    	
    	for(Order currentOrder: orderQueue) {
            

            if (currentOrder.orderType.equals("sell")) {
               int quantity = executeSellOrder(currentOrder);
               
               if(quantity > 0) {
            	   
            	   Order temp = new Order(currentOrder.stockSymbol, currentOrder.orderType, currentOrder.price, 
            			   quantity, currentOrder.timestamp, currentOrder.userID, currentOrder.allOrNone);
            	   
            	   NonExecutedOrderQueue.add(temp);
               }
           
                
            } 
            
             if (currentOrder.orderType.equals("buy")) {
            	int quantity = executeBuyOrder(currentOrder);
                
                if(quantity > 0) {
             	   
             	   Order temp = new Order(currentOrder.stockSymbol, currentOrder.orderType, currentOrder.price, 
             			   quantity, currentOrder.timestamp, currentOrder.userID, currentOrder.allOrNone);
             	   
             	   NonExecutedOrderQueue.add(temp);
                }
                
                
            }
            
          
        }
    	
    	orderQueue.clear();
    	
    	for(Order order: NonExecutedOrderQueue) {
    		orderQueue.add(order);
    	}
    	
    	NonExecutedOrderQueue.clear();

    }

    private int executeSellOrder(Order sellOrder) {
    	
        for (Order buyOrder : orderQueue) {
            if (buyOrder.stockSymbol.equals(sellOrder.stockSymbol) && buyOrder.orderType.equals("buy")) {
            	if((buyOrder.allOrNone == true && buyOrder.quantity > sellOrder.quantity) ||
            			(sellOrder.allOrNone == true && sellOrder.quantity > buyOrder.quantity)) {
            		
            		continue;
            	}
            		
                if (buyOrder.price >= sellOrder.price) {
              
                	executeBuyOrder(buyOrder);

                    if (sellOrder.quantity == 0) {
                    	
                        break;
                    } 
                }
            }
        }
        return sellOrder.quantity;
    }
    
    
    
   
    
    

    private int executeBuyOrder(Order buyOrder) {
    	Queue<Order> sameStockName = new LinkedList<>();
    	
    	
    	
    		
    	for(Order sellOrder: orderQueue) {
    		if (sellOrder.stockSymbol.equals(buyOrder.stockSymbol) && sellOrder.orderType.equals("sell")) {
    		
    			sameStockName.add(sellOrder);
    		}
 
    	}
    	
    	sameStockName = sortQueueByPrice(sameStockName);
    
        for (Order sellOrder : sameStockName) {
            if (sellOrder.stockSymbol.equals(buyOrder.stockSymbol) && sellOrder.orderType.equals("sell")) {
            	if((buyOrder.allOrNone == true && buyOrder.quantity > sellOrder.quantity) ||
            			(sellOrder.allOrNone == true && sellOrder.quantity > buyOrder.quantity)) {
            		
            		continue;
            		}
            		
                if (sellOrder.price <= buyOrder.price) {
                    int executedQuantity = Math.min(sellOrder.quantity, buyOrder.quantity);
                    if(executedQuantity != 0)
                   
                    executedOrders.add(sellOrder.userID + "," + buyOrder.userID + "," + sellOrder.price + "," + executedQuantity);
                    sellOrder.quantity -= executedQuantity;
                    buyOrder.quantity -= executedQuantity;

                    if (buyOrder.quantity == 0) {
                        break;
                    } 
                }
            }
        }
        return buyOrder.quantity;
    }

    

    public void printExecutedOrders() {
        for (String executedOrder : executedOrders) {
            System.out.println(executedOrder);
        }
    }
    
    public static Queue<Order> sortQueueByPrice(Queue<Order> unsortedQueue) {
    	List<Order> orderList = new ArrayList<>(unsortedQueue);
    	
    	
        
        Collections.sort(orderList, new Comparator<Order>() {

            public int compare(Order o1, Order o2) {
        	
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
       
        return new LinkedList<>(orderList);
    }
    
    
    

    public void printOrderQueue() {
    
        for (Order order : orderQueue) {
            System.out.println(order.stockSymbol + ", " + order.orderType + ", " + order.price + ", " +
                               order.quantity + ", " + order.timestamp + ", " + order.userID + ", " +
                               order.allOrNone);
            
        }
        
    }
}
