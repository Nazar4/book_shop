package ua.lviv.lgs.book_shop.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class CustomErrorController implements ErrorController {
    @PostMapping("/error")
    public String handleError404(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == 403) {
                return "error-403";
            }
            else if(statusCode == 500) {
                return "error-500";
            }else if(statusCode == 404) {
                return "error-404";
            }
        }
        return "error";
    }

    @GetMapping("/error")
    public String handleError403(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == 403) {
                return "error-403";
            }else if(statusCode == 404){
                return  "error-404";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

