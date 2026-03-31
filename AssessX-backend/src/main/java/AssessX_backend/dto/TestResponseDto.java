package AssessX_backend.dto;

import AssessX_backend.model.Test;
import java.time.LocalDateTime;

public class TestResponseDto {

    private Long id;
    private String title;
    private String questions;
    private String answers; // null for STUDENT role
    private Integer points;
    private Integer timeLimitSec;
    private Long createdById;
    private LocalDateTime createdAt;

    public static TestResponseDto from(Test test, boolean includeAnswers) {
        TestResponseDto dto = new TestResponseDto();
        dto.id = test.getId();
        dto.title = test.getTitle();
        dto.questions = test.getQuestions();
        dto.answers = includeAnswers ? test.getAnswers() : null;
        dto.points = test.getPoints();
        dto.timeLimitSec = test.getTimeLimitSec();
        dto.createdById = test.getCreatedBy() != null ? test.getCreatedBy().getId() : null;
        dto.createdAt = test.getCreatedAt();
        return dto;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getQuestions() { return questions; }
    public String getAnswers() { return answers; }
    public Integer getPoints() { return points; }
    public Integer getTimeLimitSec() { return timeLimitSec; }
    public Long getCreatedById() { return createdById; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
