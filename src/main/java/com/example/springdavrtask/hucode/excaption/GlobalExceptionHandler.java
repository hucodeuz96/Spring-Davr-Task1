package com.example.springdavrtask.hucode.excaption;

import com.example.springdavrtask.hucode.response.AppErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<AppErrorDTO> handleNotFound(NotFoundException e, WebRequest webRequest) {
        return new ResponseEntity<>(new AppErrorDTO(HttpStatus.NOT_FOUND, e.getMessage(), webRequest), HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value = {BadRequestException.class})
//    public ResponseEntity<DataDTO<AppErrorDTO>> handleBadRequest(BadRequestException e, WebRequest webRequest) {
//        return new ResponseEntity<>(new DataDTO<>(
//                new AppErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage(), webRequest)));
//    }

//    @ExceptionHandler(value = {BadCredentialsException.class})
//    public ResponseEntity<DataDTO<AppErrorDTO>> handleBadCredentials(BadCredentialsException e, WebRequest webRequest) {
//        return new ResponseEntity<>(new DataDTO<>(
//                new AppErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage(), webRequest)));
//    }
//
//    @ExceptionHandler(value = {RuntimeException.class})
//    public ResponseEntity<DataDTO<AppErrorDTO>> handleRuntime(RuntimeException e, WebRequest webRequest) {
//        return new ResponseEntity<>
//                (new DataDTO<>(
//                        new AppErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage(), webRequest)));
//    }

//    @ExceptionHandler(value = {CustomSQLException.class})
//    public ResponseEntity<DataDTO<AppErrorDTO>> handleCustomSQL(CustomSQLException e, WebRequest webRequest) {
//        return new ResponseEntity<>(new DataDTO<>(
//                new AppErrorDTO(HttpStatus.CONFLICT, e.getMessage(), webRequest)));
//    }
//
//    @ExceptionHandler(value = {ConstraintViolationException.class})
//    public ResponseEntity<DataDTO<AppErrorDTO>> handleConstraintViolation(ConstraintViolationException e, WebRequest webRequest) {
//        return new ResponseEntity<>(new DataDTO<>(
//                new AppErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage(), webRequest)));
//    }

//    @Override
//    protected org.springframework.http.ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                                           HttpHeaders headers, HttpStatus status, WebRequest request) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return new org.springframework.http.ResponseEntity<>(new DataDTO<>(errors), HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(TypeMismatchException.class)
//    public ResponseEntity<DataDTO<AppErrorDTO>> handleTypeMismatchException(TypeMismatchException e, WebRequest webRequest) {
//        return new ResponseEntity<>(new DataDTO<>(
//                new AppErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage(), webRequest)));
//    }
//
//    @ExceptionHandler(WebExchangeBindException.class)
//    public ResponseEntity<DataDTO<AppErrorDTO>> handleWebExchangeBindException(WebExchangeBindException e, WebRequest webRequest) {
//        return new ResponseEntity<>(new DataDTO<>(
//                new AppErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage(), webRequest)));
//
//    }

}
