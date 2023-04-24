package traadeks22T;

public class SnakkesagligPerson extends Thread
//public class SnakkesagligPerson implements Runnable
	{
	  private String navn;
	  private int ventetid;

	  public SnakkesagligPerson(String n, int t)
	  {
	    navn = n;
	    ventetid = t;
	  }

	  public void run()
	  {
	    for (int i=0; i<5; i++)
	    {
	      System.out.println(navn+": bla bla bla "+i);
	      try {
			  Thread.sleep(ventetid);
		  } catch (Exception e) {
			  System.out.println(e.getMessage());
		  } // vent lidt
	    }
	  }
	

}
