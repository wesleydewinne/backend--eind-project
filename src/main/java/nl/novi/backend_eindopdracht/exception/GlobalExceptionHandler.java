package nl.novi.backend_eindopdracht.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  // 1. Resource niet gevonden (bijv. Student, Trainer)
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
    logger.warn("Resource not found: {}", ex.getMessage());
    return buildErrorResponse(ex, HttpStatus.NOT_FOUND, request);
  }

  // 2. Resource bestaat al (bijv. e-mailadres al in gebruik)
  @ExceptionHandler(DuplicateResourceException.class)
  public ResponseEntity<ApiError> handleDuplicateResource(DuplicateResourceException ex, HttpServletRequest request) {
    logger.warn("Duplicate resource: {}", ex.getMessage());
    return buildErrorResponse(ex, HttpStatus.CONFLICT, request);
  }

  // 3. Business logica, zoals cursus zit vol
  @ExceptionHandler(CourseFullException.class)
  public ResponseEntity<ApiError> handleCourseFull(CourseFullException ex, HttpServletRequest request) {
    logger.warn("Business rule violation: {}", ex.getMessage());
    return buildErrorResponse(ex, HttpStatus.CONFLICT, request);
  }

  // 4. Validatiefouten via @Valid
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
    logger.warn("Validation error: {}", ex.getMessage());

    Map<String, String> validationErrors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error ->
            validationErrors.put(error.getField(), error.getDefaultMessage()));

    ApiError error = new ApiError(
            HttpStatus.BAD_REQUEST.value(),
            "Validatiefout",
            validationErrors.toString(),
            request.getRequestURI()
    );
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  // 5. Verkeerde/onjuiste parameters in services
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiError> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
    logger.warn("Illegal argument: {}", ex.getMessage());
    return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, request);
  }

  // 6. Beveiligingsfout door Spring Security (bijv. rol mist)
//  @ExceptionHandler(AccessDeniedException.class)
//  public ResponseEntity<ApiError> handleAccessDenied(AccessDeniedException ex, HttpServletRequest request) {
//    logger.warn("Access denied: {}", ex.getMessage());
//    return buildErrorResponse(ex, HttpStatus.FORBIDDEN, request);
//  }

  // 7. Eigen beveiligingscontrole (bijv. handmatige permissie-check)
//  @ExceptionHandler(SecurityException.class)
//  public ResponseEntity<ApiError> handleSecurityException(SecurityException ex, HttpServletRequest request) {
//    logger.warn("Security violation: {}", ex.getMessage());
//    return buildErrorResponse(ex, HttpStatus.FORBIDDEN, request);
//  }

  // 8. Onverwachte fouten
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> handleGenericException(Exception ex, HttpServletRequest request) {
    logger.error("Unexpected error occurred", ex);
    ApiError error = new ApiError(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Interne fout",
            "Er is een onverwachte fout opgetreden. Probeer het later opnieuw.",
            request.getRequestURI()
    );
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // 🔧 Helper methode om herhaling te voorkomen
  private ResponseEntity<ApiError> buildErrorResponse(Exception ex, HttpStatus status, HttpServletRequest request) {
    ApiError error = new ApiError(
            status.value(),
            status.getReasonPhrase(),
            ex.getMessage(),
            request.getRequestURI()
    );
    return new ResponseEntity<>(error, status);
  }
}
