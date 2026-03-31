package AssessX_backend.dto;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

public class SubmitTestRequest {

    @NotNull
    private Map<String, String> answers;

    public Map<String, String> getAnswers() { return answers; }
    public void setAnswers(Map<String, String> answers) { this.answers = answers; }
}
