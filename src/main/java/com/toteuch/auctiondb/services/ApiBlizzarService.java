package com.toteuch.auctiondb.services;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.toteuch.auctiondb.enums.Namespace;
import com.toteuch.auctiondb.enums.Region;
import com.toteuch.auctiondb.json.AccessToken;
import com.toteuch.auctiondb.json.AuctionResult;
import com.toteuch.auctiondb.json.TokenPrice;
import com.toteuch.auctiondb.utils.ParameterStringBuilderUtils;

@Service
public class ApiBlizzarService implements IApiBlizzardService{

	@Value("${auctiondb.blizzard.api.username}")
	private String clientId;
	@Value("${auctiondb.blizzard.api.secret}")
	private String clientSecret;
	
	private final static String DATA_WOW = "data/wow/";
	private final static int EU_ELUNE_ID = 1315;
	
	Logger logger = LoggerFactory.getLogger(ApiBlizzarService.class);
	
	private AccessToken getAccessToken() {
		ResponseEntity<String> responseAccess = null;
		RestTemplate restTemplateAccess = new RestTemplate();

		String credentials = this.clientId + ":" + this.clientSecret;
		String encodedCredentials = new String(Base64.getEncoder().encode(credentials.getBytes()));

		HttpHeaders headersAccess = new HttpHeaders();
		headersAccess.add("Authorization", "Basic " + encodedCredentials);
		
		HttpEntity<String> requestAccess = new HttpEntity<String>(headersAccess);
		
		String access_token_url = "https://eu.battle.net/oauth/token";
		access_token_url += "?grant_type=" + "client_credentials";
		logger.debug("Request Access Token...");
		responseAccess = restTemplateAccess.exchange(access_token_url, HttpMethod.POST, requestAccess, String.class);
		
		Gson gson = new Gson();
		AccessToken accessToken = gson.fromJson(responseAccess.getBody(), AccessToken.class);
		logger.debug("Access Token : " + accessToken.getAccess_token());
		return accessToken;
	}
	
	private ResponseEntity<String> callRestWebService(HttpMethod httpMethod, String url, Map<String,String> params) {
		// Request Access Token
		AccessToken accessToken = getAccessToken();
		
		RestTemplate restTemplate = new RestTemplate();
		
		// set authent
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken.getAccess_token());
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		url+= ParameterStringBuilderUtils.getParamsString(params);
		logger.debug("Calling " + url+ "...");
		
		return restTemplate.exchange(url, httpMethod, request, String.class);
		
	}

	@Override
	public TokenPrice getTokenPrice(Region region) {
		String url = region.getHost()+DATA_WOW+"token/";
		
		Map<String, String> params = new HashMap<>();
		params.put("namespace", Namespace.DYNAMIC.getNamespace()+region.getIdentifier());
		
		ResponseEntity<String> response = callRestWebService(HttpMethod.GET, url, params);
		
		Gson gson = new Gson();
		TokenPrice tokenPrice = gson.fromJson(response.getBody(), TokenPrice.class);
		return tokenPrice;
	}

	@Override
	public AuctionResult getAuctionHouseElune() {
		String url = Region.EU.getHost()+DATA_WOW+"connected-realm/"+EU_ELUNE_ID+"/auctions";
		Map<String, String> params = new HashMap<String, String>();
		params.put("namespace", Namespace.DYNAMIC.getNamespace()+Region.EU.getIdentifier());
		ResponseEntity<String> response = callRestWebService(HttpMethod.GET, url, params);
		Gson gson = new Gson();
		AuctionResult auctionResult = gson.fromJson(response.getBody(), AuctionResult.class);
		return auctionResult;
	}
	
}
