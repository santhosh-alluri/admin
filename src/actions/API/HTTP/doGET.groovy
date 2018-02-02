package actions.API.HTTP;

import groovy.json.JsonSlurper

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class doGET{
    public def run(def params){

        String request = params.URL; // v1/connections
        println(URL);
        URL obj = new URL(request);

        /*
         * Creating connection using post method
         */
        // obj.openConnection();
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");

        /*
         * Adding requesting Heading like authorization and type of data
         * exchanging
         */

        con.setRequestProperty("Content-Type", params."Content-Type");
        if(params.Token != null)
        {
        con.setRequestProperty("Authorization", params.Token);        
        }

        int responseCode = con.getResponseCode();
        con.getInputStream();
        System.out.println("\nSending 'GET' request to URL : " + request);
        System.out.println("Response Code : " + responseCode);

        BufferedReader input = new BufferedReader(new InputStreamReader(
                con.getInputStream()))
        String inputLine;
        def response = new StringBuilder();
        System.out.println("Response message" + con.getResponseMessage());
        while ((inputLine = input.readLine()) != null) {
            response.append(inputLine);
        }
        input.close();
        con.disconnect();
        println(response);
        return response;
    }
}