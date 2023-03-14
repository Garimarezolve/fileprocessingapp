package com.dew.itrade.fileprocessingapp.service;

import com.dew.itrade.fileprocessingapp.constant.ApplicationConstant;
import com.dew.itrade.fileprocessingapp.dto.FileInfoDto;
import com.dew.itrade.fileprocessingapp.dto.ResponseDto;
import com.dew.itrade.fileprocessingapp.dto.SuccessResponseDto;
import com.dew.itrade.fileprocessingapp.entity.FileInfo;
import com.dew.itrade.fileprocessingapp.exception.ServiceException;
import com.dew.itrade.fileprocessingapp.repository.FileProcessingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileProcessingServiceImpl implements FileProcessingService{

    private  final FileProcessingRepository repository;
    @Override
    public ResponseDto saveFileInfo(FileInfoDto fileInfoDto) {
        FileInfo existingFile= repository.findByChecksum(fileInfoDto.getChecksum());
        if(existingFile!=null){
             throw  new ServiceException(ApplicationConstant.ERROR_STATUS_CODE, HttpStatus.OK,ApplicationConstant.FILE_ALREADY_EXIST);
        }
        FileInfo fileInfo= repository.save(FileInfo.builder()
                .checksum(fileInfoDto.getChecksum())
                .filename(fileInfoDto.getFilename())
                .process(fileInfoDto.getProcess())
                .status(fileInfoDto.getStatus()).build());

        return new SuccessResponseDto(FileInfoDto.builder().checksum(fileInfo.getChecksum()).filename(fileInfo.getFilename()).process(fileInfo.getProcess()).Status(fileInfo.getStatus()).build()
                , ApplicationConstant.CREATED_MSG,ApplicationConstant.HTTP_RESPONSE_CREATED_CODE);
    }
}
