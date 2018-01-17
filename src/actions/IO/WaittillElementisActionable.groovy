package actions.IO;

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import actions.selenium.Browser
import org.openqa.selenium.support.ui.Select
import actions.selenium.utils.Elements
import java.lang.Exception;


class WaittillElementisActionable{
    public void run(def params){
        
        def driver = Browser.Driver
       
        def time = 0
        while(time<120){
            time += 2
            sleep(2000)
            
            def element = Elements.find(params,Browser.Driver)

            try{
             println "Action Type : " + params.actionType
             println params.actionType == "click"
                
               if(params."actionType"=="click")
                {
                        element.click()
                        println "clicked on this element"
                }else if(params."actionType"=="valueDropDown")
                {
                        new Select(element).selectByValue(params."Value")
                        println "Selected this value from drop down"
                }else if(params."actionType"=="TextDropDown")
                {
                         new Select(element).selectByVisibleText(params."Value") 
                         println "Selected this text from drop down"
                }else if(params."actionType"=="sendKeys")
                {
                          element.clear()
                          element.sendKeys(params."Value")
                         println "send keys to this element "
                }else
                {
                     println("This element unknown" + params.actionType); 
                }
                break
            }catch(Exception ex)
            {
                println("Element is not yet available")
            }
            
            
        }
        
    }
}