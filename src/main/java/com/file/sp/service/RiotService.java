package com.file.sp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class RiotService {
	public Map<String,Object> getLevelInfo(String name){

		try {
			name = URLEncoder.encode(name,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String urlStr="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name;
	
		String X_Riot_Token = "RGAPI-6e565cd0-a828-494d-afc3-551c730cb215";

        URL url;
		try {
			url = new URL(urlStr);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("X-Riot-Token", X_Riot_Token);
	        int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println(response.toString());
            ObjectMapper om = new ObjectMapper();
            br.close();
            return om.readValue(response.toString(), Map.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
