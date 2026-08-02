package com.motocart.library.common.exception;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignExceptionDecoder implements ErrorDecoder {

    private final ExceptionTransformer exceptionTransformer;
    private final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    public FeignExceptionDecoder(ExceptionTransformer exceptionTransformer) {
        this.exceptionTransformer = exceptionTransformer;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception decoded = defaultDecoder.decode(methodKey, response);
        if (decoded instanceof FeignException feignException) {
            return exceptionTransformer.transform(feignException);
        }
        return decoded;
    }
}

