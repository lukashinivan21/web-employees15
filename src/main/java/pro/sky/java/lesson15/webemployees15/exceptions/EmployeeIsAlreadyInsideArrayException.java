package pro.sky.java.lesson15.webemployees15.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIsAlreadyInsideArrayException extends RuntimeException {

}
