class HTTPActions:
    def validate(self, params):
        #Validate
        if 'url' in params:
            pass
        else:
            print 'url is not available in params'
            raise Exception('url is not available in params')
        pass
    def processHeaders(self, params):
        headerDict = {}
        #process headers here
        #Format is 'keyname: keyvalue::...'
        if 'headers' in params:
            headerStr = params['headers']
            allHeaders = headerStr.split('::')
            for hStr in allHeaders:
                h = hStr.split(': ')
                print len(h)
                if len(h) > 1:
                #TODO add checks when there is no h[1]
                    headerDict[h[0]] = h[1]
        return headerDict
    def run(self, params):
        import json
        import requests
        self.validate(params)
        for i in params:
            print i + " : " + str(params[i])
        headers = self.processHeaders(params)
        m = params['method']
        if m.lower() == 'get':
            #call get method
            response = requests.get(params['url'], headers=headers)
        elif m.lower() == 'post':
            #check for data as well
            print (params['json'])
            response = requests.get(params['url'], headers=headers, data=params['json'])
        
        if response.status_code == 200:
            print response.json()
        return response.json()
        pass
