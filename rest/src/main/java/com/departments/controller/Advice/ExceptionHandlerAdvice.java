package com.departments.controller.Advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alex on 10.2.17.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger log  = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

//    @ExceptionHandler(Exception.class)
//    public ModelAndView exception(Exception e) {
//        log.debug("Handling exception: " + e.getLocalizedMessage());
//        ModelAndView mav = new ModelAndView("exception");
//        mav.addObject("name", e.getClass().getSimpleName());
//        mav.addObject("message", e.getMessage());
//        return mav;
//    }
//    !!! for exception.jsp
//    <html>
//<head>
//    <title>Spring MVC @ControllerAdvice example</title>
//</head>
//<body>
//
//	<h1>Ops! Something went wrong</h1>
//
//	<b>${name}</b>:  ${message}
//
//</body>
//</html>

//    or
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleDataAccessException(DataAccessException ex) {
        log.debug("Handling DataAccessException: " + ex);
        return "Not data found " + ex.getLocalizedMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public  String handleIllegalArgumentException(IllegalArgumentException ex) {
        return "No illegal argument exception: " + ex.getLocalizedMessage();
    }
}
