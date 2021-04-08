package App;

/**
 *
 * @author Margaret
 */

import controller.Controller;

public class App {

    public static void run() {        
        System.out.println("App\n" + "========\n\n");
        
        Controller controller = new Controller();  
        
        controller.run();
                
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    
}
