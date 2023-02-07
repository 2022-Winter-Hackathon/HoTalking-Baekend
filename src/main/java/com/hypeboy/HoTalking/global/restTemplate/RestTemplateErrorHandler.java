package com.hypeboy.HoTalking.global.restTemplate;

import com.hypeboy.HoTalking.global.error.exception.InternalServerException;
import com.hypeboy.HoTalking.global.error.exception.TamperedCodeException;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        final HttpStatus httpStatus = response.getStatusCode();
        return !httpStatus.is2xxSuccessful();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        final String error = getErrorAsString(response);
        if(error.equals("{\"status\":403,\"message\":\"변조된 code입니다\"}")) {
            throw new TamperedCodeException();
        }
        throw new InternalServerException();
    }

    private String getErrorAsString(@NonNull final ClientHttpResponse response)
            throws IOException {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody()))) {
            return bufferedReader.readLine();
        }
    }

}