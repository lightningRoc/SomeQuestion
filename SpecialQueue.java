import java.util.LinkedList;
import java.util.Queue;

/**
	 * create a queue for Dog and Cat
	 * add:can add Cat and Dog to queue
	 * pollAll:poll a element of queue
	 * pollDog:poll a Dog of queue
	 * pollCat:poll a Cat of queue
	 * isEmpty:if the queue has elements
	 * isDogEmpty:if the queue has Dogs
	 * isCatEmpty:if the queue has Cats
	 * @author PC
	 *
	 */

public class SpecialQueue {
	private Queue<FurtherQueue> dogQ;
	private Queue<FurtherQueue> catQ;
	private long globalCount;
	
	public SpecialQueue()
	{
		dogQ=new LinkedList<FurtherQueue>();
		catQ=new LinkedList<FurtherQueue>();
		globalCount=0;
	}
	
	class FurtherQueue
	{
		private Pet pet;
		private long count;
		
		public FurtherQueue(Pet pet,long count)
		{
			this.pet=pet;
			this.count=count;
		}
		
		public Pet getPet()
		{
			return this.pet;
		}
		
		public long getCount()
		{
			return this.count;
		}
		
		public String getPetType()
		{
			return this.pet.getPetType();
		}
	}
	
	public void add(Pet pet)
	{
		if(pet.getPetType().equals("dog"))
		{
			dogQ.add(new FurtherQueue(pet,globalCount++));
		}
		else if(pet.getPetType().equals("cat"))
		{
			catQ.add(new FurtherQueue(pet,globalCount++));
		}
		else
		{
			throw new RuntimeException("the pet isn't dog or cat");
		}
	}
	
	public Pet pollAll()
	{
		if(!dogQ.isEmpty()&&!catQ.isEmpty())
		{
			if(dogQ.peek().getCount()<catQ.peek().getCount())
			{
				return dogQ.poll().getPet();
			}
			else
			{
				return catQ.poll().getPet();
			}
		}
		else if(!dogQ.isEmpty())
		{
			return dogQ.poll().getPet();
		}
		else if(!catQ.isEmpty())
		{
			return catQ.poll().getPet();
		}
		else
		{
			throw new RuntimeException("queue is empty");
		}
	}
	
	public Dog pollDog()
	{
		if(!isDogEmpty())
		{
			return (Dog)dogQ.poll().getPet();
		}
		else
		{
			throw new RuntimeException("Dog queue is empty");
		}
	}
	
	public Cat pollCat()
	{
		if(!isCatEmpty())
		{
			return (Cat)catQ.poll().getPet();
		}
		else
		{
			throw new RuntimeException("Cat queue is empty");
		}
	}
	
	public boolean isEmpty()
	{
		return dogQ.isEmpty()&&catQ.isEmpty();
	}
	
	public boolean isDogEmpty()
	{
		return dogQ.isEmpty();
	}
	
	public boolean isCatEmpty()
	{
		return catQ.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test Data
		SpecialQueue test=new SpecialQueue();
		test.add(new Dog());
		test.add(new Cat());
		test.add(new Cat());
		
		System.out.println(test.pollCat().getPetType());
		
		while(!test.isEmpty())System.out.println(test.pollAll().getPetType());
	}

}

class Pet
{
	private String type;
	
	public Pet(String type)
	{
		this.type=type;
	}
	
	public String getPetType()
	{
		return this.type;
	}
}

class Dog extends Pet
{
	public Dog()
	{
		super("dog");
	}
}

class Cat extends Pet
{
	public Cat()
	{
		super("cat");
	}
}