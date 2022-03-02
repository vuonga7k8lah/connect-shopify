package com.wiloke.corecommon.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ErrorsDTOUtils {

    private Map<String, String> errors;

    public ErrorsDTOUtils(BindingResult bindingResult){

        setErrors(parseError( bindingResult.getAllErrors() ));
    }

    /**
     * Parse error to object
     * @param objectErrors
     * @return
     */
    public Map<String, String> parseError(List<ObjectError> objectErrors){

        Map<String, String> errorList = new HashMap<String, String>();

        for (ObjectError error: objectErrors) {
            String fieldName = ((FieldError) error).getField();
            errorList.put(fieldName, error.getDefaultMessage());
        }

        return errorList;
    }
}
