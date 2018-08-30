

public class Splash  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SplashGUI splashGUI = new SplashGUI();
		final StartMain view = new StartMain();
		
		
		Thread timer = new Thread(){
            public void run(){
                try{
                	splashGUI.setVisible(true);
                    sleep(3000);                                //delay
                    splashGUI.dispose();
                    view.setVisible(true);
                }
              catch (InterruptedException e){
                       e.printStackTrace();
                }
            }
        };
            timer.start();
            	
    }

	}


