package com.example.petclinic.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error", produces = "application/json")
    public ErrorMessage handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        ErrorMessage errorMessage = null;
        if (status != null) {

            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {

                errorMessage = new ErrorMessage(ErrorType.BAD_KARMA, HttpStatus.NOT_FOUND, "Sorry - that endpoint doesn't exist!");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {

                errorMessage = new ErrorMessage(ErrorType.BAD_KARMA, HttpStatus.INTERNAL_SERVER_ERROR, "Sorry - the server ain't workin!");
            } else {

                errorMessage = new ErrorMessage(ErrorType.SOMETHING_BROKE, HttpStatus.I_AM_A_TEAPOT, "I'm late! I'm late! To a very important date!");
            }
        }

        return errorMessage;
    }

    @Override
    public String getErrorPath() {

        return "/error";
    }
}
