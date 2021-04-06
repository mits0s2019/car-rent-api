package com.example.carShop.validators;

import com.example.carShop.exceptions.CarApiException;
import com.intersalonica.validation.dto.ValidationDTO;
import com.intersalonica.validation.dto.ValidationInputDTO;
import com.intersalonica.validation.service.CustomValidator;
import lombok.SneakyThrows;

import java.util.List;


public class ConfirmationPasswordValidator implements CustomValidator {

    @SneakyThrows
    @Override
    public ValidationDTO validate(List<ValidationInputDTO> vidtos) {

        ValidationInputDTO viPassword =
                vidtos.stream()
                        .filter(el -> el.getFieldName().equals("$.password"))
                        .findFirst().orElseThrow(() -> new CarApiException("Error while validation confirmation password"));

        ValidationInputDTO viConfirmationPassword =
                vidtos.stream()
                        .filter(el -> el.getFieldName().equals("$.confirmationPassword"))
                        .findFirst().orElseThrow(() -> new CarApiException("Error while validation confirmation password"));

        if (viPassword.getData().equals(viConfirmationPassword.getData())) {
            return null;
        }
        return new ValidationDTO(viPassword.getFieldName(), viPassword.getCustomErrorCode());
    }
}
