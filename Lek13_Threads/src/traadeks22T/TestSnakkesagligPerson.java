package traadeks22T;

public class TestSnakkesagligPerson {

	public static void main(String[] args) {
		SnakkesagligPerson ulla = new SnakkesagligPerson("Ulla", 20);
		SnakkesagligPerson pia = new SnakkesagligPerson("Pia", 10);
		SnakkesagligPerson ib = new SnakkesagligPerson("Ib", 30);

		//man bruger implements Runnable skal man først lave en tråd på Runnable objektet
		//Thread tradUlla = new Thread(ulla);
		//Thread tradPia = new Thread(pia);
		//Thread tradIb = new Thread(ib);
		
		//tradUlla.start();
		//tradPia.start();
		//tradIb.start();

		//bruges når man extends Thread
		ulla.start();
		pia.start();
		ib.start();

	}

}
