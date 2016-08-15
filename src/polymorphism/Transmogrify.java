package polymorphism;

import javax.swing.plaf.nimbus.State;

public class Transmogrify {

	public static void main(String[] args) {
	
		Stage stage=new Stage();
		stage.performPlay();//HappyActor
		stage.change();
		stage.performPlay();//SadActory
		
	}
}
class Actor{
	public void act(){}
}
class HappyActor extends Actor{
	public void act(){ System.out.println("HappyActor");  }
}
class SadActory extends Actor{
	public void act(){ System.out.println("SadActory");  }
}
class Stage{
	private Actor actor=new HappyActor();
	public void change()
	{
		actor=new SadActory();
	}
	public void performPlay(){actor.act();}
}

