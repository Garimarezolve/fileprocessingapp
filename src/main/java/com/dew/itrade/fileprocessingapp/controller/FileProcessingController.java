package com.dew.itrade.fileprocessingapp.controller;

import com.dew.itrade.fileprocessingapp.dto.FileInfoDto;
import com.dew.itrade.fileprocessingapp.dto.ResponseDto;
import com.dew.itrade.fileprocessingapp.service.FileProcessingService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file")
@Slf4j
@RequiredArgsConstructor
public class FileProcessingController {

    private final FileProcessingService fileProcessingService;

    @PostMapping("/save")
    public ResponseDto saveFileInfo(@RequestBody @Valid FileInfoDto fileInfoDto , HttpServletResponse response){
        log.info("saving the file info  for request {}", fileInfoDto);
        return fileProcessingService.saveFileInfo(fileInfoDto);
    }
}
