package com.simpleTalk.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.simpleTalk.common.ServerResponse;


public interface IFileService {
	ServerResponse<Map<String, String>> uploadFile(String owner,MultipartFile multipartFile);
}
