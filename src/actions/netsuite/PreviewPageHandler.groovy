package actions.netsuite;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

class PreviewPageHandler{
    
    def driver = Browser.Driver;
    public void run(def params){

    //waiting till preview bundle page is ready
    isPreviewBundlePageReady()
        
     //getting bundle label to verify bundle version
     def ver = driver.findElement(By.id("div__prelabel")).getText().replaceAll("\\s","")
     println("bundle label" + ver)
        
     //checking bundle is already installed or not
     if(ver.contains("NewVersion") && ver.contains("CurrentVersion"))
     {
            def currentVersion = ver.substring(ver.indexOf(":",ver.indexOf(":")+2)+1, ver.indexOf("NewVersion:"))            
            def newVersion     = ver.substring(ver.lastIndexOf(":")+1, ver.length())
            println("currentVersion : " + currentVersion)
            println("newVersion : " + newVersion)

       
       //verify bundle versions         
         if(newVersion == currentVersion)
         {
             println "Netsuite has updated bundle"
         }else
         {
             println "Netsuite has older bundle"
         }

     }else
     {
         // to-do 
     }
        
    }
    
    public void isPreviewBundlePageReady()
    {
       def time = 0
        
        while(time<60)
        {
            sleep(2000)
            time += 2
            if(driver.getCurrentUrl().contains("previewbundleupdate.nl"))
            {
                break
            }else
            {
                println "preview page is not ready yet"
            }
        }
    }
}