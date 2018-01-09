package actions.IO;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyExportConnectionStatus{
    public void run(def params){
        
        WebElement element
        
        def time = 0;
        while(time<120)
        {
            time += 2
            sleep(2000)
            
            element = Elements.find(params,Browser.Driver)
            
            if(element.getText() == params."verify Text")
            {
                break;
            }else
            {
                print element.getText()
            }
            
        }
        
    }
}