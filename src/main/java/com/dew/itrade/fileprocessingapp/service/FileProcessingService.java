package com.dew.itrade.fileprocessingapp.service;

import com.dew.itrade.fileprocessingapp.dto.FileInfoDto;
import com.dew.itrade.fileprocessingapp.dto.ResponseDto;

public interface FileProcessingService {
    ResponseDto saveFileInfo(FileInfoDto fileInfoDto);
}
