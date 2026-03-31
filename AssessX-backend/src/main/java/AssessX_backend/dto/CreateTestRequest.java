package AssessX_backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTestRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String questions;

    @NotBlank
    private String answers;

    @NotNull
    @Min(1)
    private Integer points;

    @NotNull
    @Min(1)
    private Integer timeLimitSec;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getQuestions() { return questions; }
    public void setQuestions(String questions) { this.questions = questions; }

    public String getAnswers() { return answers; }
    public void setAnswers(String answers) { this.answers = answers; }

    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }

    public Integer getTimeLimitSec() { return timeLimitSec; }
    public void setTimeLimitSec(Integer timeLimitSec) { this.timeLimitSec = timeLimitSec; }
}
