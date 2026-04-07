package AssessX_backend.exception;

import org.springframework.http.HttpStatus;

public class DeadlineExpiredException extends AppException {

    public DeadlineExpiredException() {
        super(HttpStatus.BAD_REQUEST, "Assignment deadline has expired");
    }
}
