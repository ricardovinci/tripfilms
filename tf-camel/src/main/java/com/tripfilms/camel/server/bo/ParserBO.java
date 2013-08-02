package com.tripfilms.camel.server.bo;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;
import com.tripfilms.camel.server.facebook.be.FBCommentData;
import com.tripfilms.camel.server.facebook.be.FBCommentsResponse;

public class ParserBO implements IParserBO {
	
	static final Logger logger = LoggerFactory.getLogger(ParserBO.class);
	
	private static String MFB_BASE_URL = "https://graph.facebook.com/comments/?ids=";

	private static String MVIDEO_1 = "http://developers.facebook.com/docs/reference/plugins/comments";
	
	private static String MVIDEO_2 = "http://www.tripfilms.com/Travel_Video-v89433-Alaska-Whales_snorkels_and_microbrews_in_Alaska-Video.html";

	private List<String> mVideos;

	private List<Video> oVideosList;


	public List<Video> parse() {
		initVideosList();
		
		Map<String,FBCommentsResponse> oFBResult = null;	
		oVideosList = new ArrayList<Video>();
		Type oMapType = new TypeToken<Map<String, FBCommentsResponse>>() {}.getType();
		Gson oGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssz").create();
		
		for (String oUrl : mVideos) {					
			oFBResult = getJsonFromURL(oUrl, oGson, oMapType);	
			oVideosList.add(parseToVideo(oFBResult, oUrl));
		}
		
		return oVideosList;
	}
	
	
	
	private Video parseToVideo(Map<String,FBCommentsResponse> pResult, String pUrl){
		
		Video oVideo = new Video();
		oVideo.setId(pUrl);
		oVideo.setComments(parseToComment(pResult.get(pUrl).getComments().getCommentsData()));
			
		return oVideo;
	}
	
	private List<Comment> parseToComment(List<FBCommentData> pCommentData){
		List<Comment> oComments = new ArrayList<Comment>();
		Comment oComment;
		
		for (FBCommentData oFbCommentData : pCommentData) {
			oComment = new Comment();
			oComment.setDate(oFbCommentData.getCreatedTime());
			oComment.setMessage(oFbCommentData.getComment());
			oComment.setId(oFbCommentData.getId());
			oComments.add(oComment);
		}
		return oComments;
	}
	
	private Map<String,FBCommentsResponse> getJsonFromURL(String pUrl, Gson pGson, Type pMapType  ){
		try {
			return pGson.fromJson(new InputStreamReader(new URL(MFB_BASE_URL+pUrl).openStream()), pMapType);
		} catch (Exception e) {
			logger.error("Error while retrieving json from "+pUrl);
			e.printStackTrace();
			return null;
		}
		
	}
	
	private void initVideosList(){
		mVideos = new ArrayList<String>();
		mVideos.add(MVIDEO_1);
		mVideos.add(MVIDEO_2);
	}
	

}
