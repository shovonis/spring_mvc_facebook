package net.therap.SpringMVCFacebook.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rifatul.islam
 * @since 6/25/14.
 */

@ControllerAdvice
public class GlobalErrorHandler {

    public static final String ERROR_PAGE = "error";
private static final Logger log = LoggerFactory.getLogger(GlobalErrorHandler.class);

    //This method will eat all exception.Not recommended for practical use.
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(Exception.class)
    public ModelAndView defaultError(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName(ERROR_PAGE);
        return modelAndView;
    }
}
