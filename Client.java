import java.util.ArrayList;

public class Client{
	private String m_name;
	private float m_monthlyBudget;
	private float m_targetSavings;
	private ArrayList<Expense> m_expenses = new ArrayList<Expense>();
	
	public Client()
	{
		m_name = "John Doe";
		m_monthlyBudget = 0.0f;
		m_targetSavings = 0.0f;
	}
	
	public Client(String nm, float budg, float savings)
	{
		m_name = nm;
		m_monthlyBudget = budg;
		m_targetSavings = savings;
	}
	
	
	public Expense findLowestPriority()
	{
		Expense lowest;
		if(m_expenses.size() > 0)
		{
			lowest = m_expenses.get(0);
			for(int i = 0; i < m_expenses.size(); ++i)
			{
				Expense compare = m_expenses.get(i);
				if(compare.getPriority() < lowest.getPriority())
				{
					lowest = compare;
				}
			}
		}
		else
			lowest = null;
		
		return lowest;
	}
	
	
	public void addExpense(String description, float value,int priority)
	{
		m_expenses.add(new Expense(description, value, priority));
	}
	
	
	public String getName()
	{
		return m_name;
	}
	
}