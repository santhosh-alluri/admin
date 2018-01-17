package actions.IO;

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import actions.selenium.Browser

class VerifyPingResponse{
    public void run(def params){
        
        
         def driver = Browser.Driver
        
        //click TEST button on connection setting page
        driver.findElement(By.xpath("//button[text()='Test']")).click()        
        sleep(5000)
        
        def time = 0
        while(time<50)
        {
          time += 2
          sleep(2000)
           
            //get the pop-up text
            def popup = driver.findElement(By.xpath("//p[@data-hook='alertMessage']"))
            
             if(popup != null && popup.isDisplayed())
            {
               println "got the connection response : " + popup.getText()
                
               if(popup.getText() == "Connection is working fine!")
                {
                 driver.findElement(By.xpath("//button[@data-hook='closeDialog']")).click()
                }else
                {
                    println "something went wrong went connection setup"
                    assert false : popup.getText()
                }
               break;
            }else
            {
                println "Still waiting for ping response"
            }
        }  
        
    }
}