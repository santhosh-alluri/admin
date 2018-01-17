package actions.IO;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class FindConnectorfromMarketPlace{
    public void run(def params){
        
       /* def foundElements = Elements.findAll(params,Browser.Driver)
         
        //select specified connector from IO Marketplace
        for(element in foundElements)
        {
           // println(element.getAttribute('src'))
            if(element.getAttribute('src').contains(params."Connector Name"))
            {
                element.click()     
                break
            }
        }
        
         sleep(2000) */
        
        //click on install button 
      //   params.ID = ".appsList.smartconnectorsList>li .appBox .appTop .a-action>a"
                println(" params.ID" +  params.ID)
                def Smartconnectors = Elements.findAll(params,Browser.Driver)
                for(element in Smartconnectors)
                {
                    println(element.getText() )
                    if(element.getText() == "Install")
                    {
                        element.click();
                        break
                    }
                }
    }
}