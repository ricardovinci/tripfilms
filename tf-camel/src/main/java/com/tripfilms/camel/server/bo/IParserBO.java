package com.tripfilms.camel.server.bo;

import java.util.List;

import com.tripfilms.camel.server.be.Video;

public interface IParserBO {
	public List<Video> parse();
}
