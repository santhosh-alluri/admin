package actions.IO;


import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import actions.selenium.Browser

class CheckHomePageAvailability{
    public void run(def params){
        
        def driver = Browser.Driver
        
         def time = 0
        while(time<60)
        {
          time += 2
          sleep(2000)
            
          if(driver.getCurrentUrl() == "https://staging.integrator.io/")
          {
                println "we are on IO Home Page"
              break;
          }else
          {
              println "still waiting for IO Home Page"
          }
        }   
    }
}