class RunIOFlow:
    def run(self,params):
        driver =  Browser.Driver
        print("Browser title {}".format(driver.title))
        flows = driver.find_elements_by_css_selector(".t-flow .t-flow-c [data-hook=\"flows\"]>tr")
        print("list size : {}".format(len(flows)))
        print("Wait completed")
        flowName = params["flowName"]
        print("Browser title {}")
        for flow in flows:
          print(flow.text)
          if flow.text == flowName:
            settings = flow.find_elements_by_css_selector("td>a")
            print("settings length : {}".format(len(settings)))
            for setting in settings:
               print(setting.get_attribute("data-hook"))
               if setting.get_attribute("data-hook") == "run-now":
                 setting.click()
                 break

print("Run ompleted")
