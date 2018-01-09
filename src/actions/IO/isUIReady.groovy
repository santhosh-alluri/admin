package actions.IO;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class isUIReady{
    public void run(def params){
        
        WebElement element
        
        def time = 0;
        while(time<120)
        {
            time += 2
            sleep(2000)
            
            try {
                println(params.ID)
         		element = Elements.find(params,Browser.Driver)
                println(element)
        		element.click()
       			element.click()
                println("UI is available now")
                break;
                } catch(Exception ex) {
                println("UI is not yet ready")
                }     
        }    
        
    }
}