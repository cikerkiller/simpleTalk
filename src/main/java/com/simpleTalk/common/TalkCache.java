package com.simpleTalk.common;

import java.util.Map;

import com.google.common.collect.Maps;

public interface TalkCache {
	Map<String, Object> userSession=Maps.newHashMap();
}
