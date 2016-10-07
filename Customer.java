//Genesis Dionisio
//CSC 130 Section 2
// Programming Assignment 2
//worked with Eric Cai with main method and cashiers
//queue class taken from LaFore Chapter 4
import java.util.Random;
class Customer {
    private int nElems;
    private int Start;
    private int lineTime;
    private int End;
    private int CustomerNum;
    private int endTime;
    private int TotalTime;

    
    public Customer() {
       this.nElems = nElems;
       this.lineTime = 0;
    }
    public void setStart(int time) {
       Start = time;
    }
    
    public int getStart() {
       return Start;
    }
  
   void setendTime(int t)
   {
      endTime =  t;
   } 
   int getendTime()
   {
      return endTime;
   }
    
    public void setCustomerNum(int num) {
       CustomerNum = num;
    }
    
    public int getCustomerNum() {
       return CustomerNum;
    }
    
    
    public void setItem() {
       Random random = new Random();
       nElems = random.nextInt(9) + 1;
    }
    
    public int getItems() {
       return nElems;
    }
    
    public void decrement() {
       nElems--;
    }
}

class Queue
{
private int maxSize;
private Customer[] shopArray;
private int front;
private int rear;
private int nElems;

public Queue(int s) {
maxSize = s;
shopArray = new Customer[maxSize];
front = 0;
rear = -1;
nElems = 0;
}
public void insert(Customer j) {
	if(rear == maxSize-1) // deal with wraparound
	rear = -1;
	shopArray[++rear] = j; // increment rear and insert
	nElems++; // one more item
   }
   public Object remove() {
   	Object temp = shopArray[front++]; // get value and incr front
   	if(front == maxSize) // deal with wraparound
   	front = 0;
   	nElems--; // one less item
   	return temp;
   }
   
   public Customer peekFront() {
      return shopArray[front];
   }
   
   public boolean isEmpty() {
      return (nElems==0);
   }
   
   public boolean isFull() {
      return (nElems==maxSize);
   }
   
   public int size() {
      return nElems;
   }
   
   public int setSize(int s) {
   	return maxSize = s;
   }
   
   } // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp {

public static void main(String[] args) {
	Random random = new Random();
	Customer[] Shoppers = new Customer[1000];
	Queue[] Cashiers = new Queue[10];
	
	for (int count = 0; count <= 9; count++) {
		Cashiers[count] = new Queue(100);
	}
	

	int tick = 0;
	int ShoppersCount = 0;
	int CashierCount = 0;
	int CustomerOut = 0;
	boolean ShoppersMade = false;
	
	while (CustomerOut < 1000) {
		int CustomerTick = random.nextInt(9)+1;
		if(CustomerTick <= 3 && ShoppersCount <1000) {
			Shoppers[ShoppersCount] = new Customer();
			Shoppers[ShoppersCount].setCustomerNum(ShoppersCount);
			Shoppers[ShoppersCount].setItem();
			Shoppers[ShoppersCount].setStart(tick);
			ShoppersMade = true;
		}
		if (ShoppersMade == true) {
			if (ShoppersCount >= 11) {
				for (int count = 0; count < Cashiers.length; count++) {
					if (Cashiers[CashierCount].size() < Cashiers[count].size())
					{
					}
				else {
					CashierCount = count;
				}
			}
		}
		Cashiers[CashierCount].insert(Shoppers[ShoppersCount]);
		Shoppers[ShoppersCount].setCustomerNum(ShoppersCount);
		System.out.println("Shopper " + ShoppersCount + " is with Cashier " + (CashierCount+ 1) + ", with a tick of " + tick + " and with this number of items " + Cashiers[CashierCount].peekFront().getItems());
        ShoppersMade = false;
        ShoppersCount++;
        CashierCount++;
        
        if (CashierCount == 10) {
            CashierCount = 0;
         }
	}
        for (int count = 0; count < Cashiers.length; count ++) {
            if (Cashiers[count].size() > 0) {
               if (Cashiers[count].peekFront().getItems() == 0) {
                  System.out.println("Shopper "+ Cashiers[count].peekFront().getCustomerNum() + " has left from Cashier " + count + " at tick " + tick);
                  Cashiers[count].remove();
                  CustomerOut++;
               }
               if (Cashiers[count].size() > 0) {
                  Cashiers[count].peekFront().decrement();
               }
            }
        }	
        tick++;
		}
	}
}// end class QueueApp
		 
	 


// while someone is in queue
//* 	count the time for someone being in the line
//* 	when a customer is in the line give them a tick for when they enqueue
//* 	second tick for when the customer dequeue
//* 	calculate the time it took to get through queue
//* end while loop
//return average time in queue
//* do same thing express line
 	
 	
 	