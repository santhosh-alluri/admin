package actions.IO;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class FindIntegrationinDashboard{
    public void run(def params){
        
        println("This is Find Integration in Dashboard")
        println(params)
         def integrations = Elements.findAll(params,Browser.Driver)
                for(element in integrations)
                {
                    println(element.getText() )
                    if(element.getText() == params."Integration Name")
                    {
                        element.click();
                        break
                    }
                }
        
    }
}