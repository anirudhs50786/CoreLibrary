package com.motocart.library.common.exception;

import com.motocart.library.common.dto.response.ErrorDTO;
import com.motocart.library.common.dto.response.ErrorsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorTransformer {

    @Value("moto-cart.error.stacktrace: true")
    private boolean showStackTrace;


    public ErrorsDTO getErrorsDTO(GlobalException globalException) {
        return getErrorsDTO(globalException, null);
    }

    public ErrorsDTO getErrorsDTO(GlobalException globalException, String value) {
        ErrorsDTO errorsDTO = new ErrorsDTO();
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        for (Error err : globalException.getErrorList()) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setCode(err.getCode());
            errorDTO.setDetails(showStackTrace ? err.getStacktrace() : null);
            errorDTO.setMessage(err.getMessage());
            errorDTO.setValue(value);
            errorDTOList.add(errorDTO);
        }
        errorsDTO.setErrorDTO(errorDTOList);
        return errorsDTO;
    }

}
