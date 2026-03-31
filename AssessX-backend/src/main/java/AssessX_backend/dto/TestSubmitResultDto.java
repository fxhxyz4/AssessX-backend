package AssessX_backend.dto;

public class TestSubmitResultDto {

    private int earnedPoints;
    private int maxPoints;
    private int correctAnswers;
    private int totalQuestions;

    public TestSubmitResultDto(int earnedPoints, int maxPoints, int correctAnswers, int totalQuestions) {
        this.earnedPoints = earnedPoints;
        this.maxPoints = maxPoints;
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }

    public int getEarnedPoints() { return earnedPoints; }
    public int getMaxPoints() { return maxPoints; }
    public int getCorrectAnswers() { return correctAnswers; }
    public int getTotalQuestions() { return totalQuestions; }
}
