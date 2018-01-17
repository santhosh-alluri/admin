package actions.IO;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class WaitforInstallationCompletion{
    
     def driver = Browser.Driver;
    
    public void run(def params){
        
        def time = 0;
        while(time<120)
        {
            time += 2
            sleep(2000)
           
            if(driver.getCurrentUrl().contains("settings"))
            {
                println "we are on flow setting page"
                println "completed connector installation"
                break;
            }
           
        }    
    }
}