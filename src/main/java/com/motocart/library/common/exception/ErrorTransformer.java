package com.motocart.library.common.exception;

import com.motocart.library.common.dto.response.ErrorDTO;
import com.motocart.library.common.dto.response.ErrorsDTO;
import com.motocart.library.common.util.TextUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorTransformer {

    @Value("${moto-cart.error.stacktrace:true}")
    private boolean showStackTrace;


    public ErrorsDTO getErrorsDTO(GlobalException globalException) {
        return getErrorsDTO(globalException, null);
    }

    public ErrorsDTO getErrorsDTO(GlobalException globalException, String value) {
        if (globalException.getErrorsDTO() != null) {
            return globalException.getErrorsDTO();
        }

        ErrorsDTO errorsDTO = new ErrorsDTO();
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        for (Error err : globalException.getErrorList()) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCode(err.getCode());
            errorDTO.setValue(ExceptionUtils.getRootCauseMessage(globalException));
            errorDTO.setDetails(showStackTrace ? TextUtil.truncateStackTrace(err.getStacktrace()) : null);
            errorDTO.setMessage(err.getMessage());
            errorDTO.setValue(value);
            errorDTO.setTimestamp(Instant.now());
            errorDTOList.add(errorDTO);
        }
        errorsDTO.setErrorDTO(errorDTOList);
        return errorsDTO;
    }

    public ErrorsDTO transformValidationErrors(String errors) {
        ErrorsDTO errorsDTO = new ErrorsDTO();
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode("VALIDATION_ERROR");
        errorDTO.setMessage(errors);
        errorDTO.setTimestamp(Instant.now());
        errorDTOList.add(errorDTO);
        errorsDTO.setErrorDTO(errorDTOList);
        return errorsDTO;
    }

    public ErrorsDTO singleError(String code, String message, Throwable throwable) {
        ErrorsDTO errorsDTO = new ErrorsDTO();
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(code);
        errorDTO.setMessage(message);
        errorDTO.setValue(throwable != null ? ExceptionUtils.getRootCauseMessage(throwable) : null);
        errorDTO.setDetails(showStackTrace && throwable != null ? TextUtil.truncateStackTrace(ExceptionUtils.getStackTrace(throwable)) : null);
        errorDTO.setTimestamp(Instant.now());
        errorsDTO.setErrorDTO(List.of(errorDTO));
        return errorsDTO;
    }
}
