package amazonreviewers.project.model;

public class CommentDto {
    private String id;
    private String productId;
    private String userId;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private String time;
    private String summary;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Long getHelpfulnessNumerator() {
        return helpfulnessNumerator;
    }

    public void setHelpfulnessNumerator(Long helpfulnessNumerator) {
        this.helpfulnessNumerator = helpfulnessNumerator;
    }

    public Long getHelpfulnessDenominator() {
        return helpfulnessDenominator;
    }

    public void setHelpfulnessDenominator(Long helpfulnessDenominator) {
        this.helpfulnessDenominator = helpfulnessDenominator;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommentDto that = (CommentDto) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!productId.equals(that.productId)) {
            return false;
        }
        if (!userId.equals(that.userId)) {
            return false;
        }
        if (!profileName.equals(that.profileName)) {
            return false;
        }
        if (!helpfulnessNumerator.equals(that.helpfulnessNumerator)) {
            return false;
        }
        if (!helpfulnessDenominator.equals(that.helpfulnessDenominator)) {
            return false;
        }
        if (!score.equals(that.score)) {
            return false;
        }
        if (!time.equals(that.time)) {
            return false;
        }
        if (!summary.equals(that.summary)) {
            return false;
        }
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + profileName.hashCode();
        result = 31 * result + helpfulnessNumerator.hashCode();
        result = 31 * result + helpfulnessDenominator.hashCode();
        result = 31 * result + score.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + summary.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CommentDto{"
                + "id=" + id
                + ", productId='" + productId + '\''
                + ", userId='" + userId + '\''
                + ", profileName='" + profileName
                + '\'' + ", helpfulnessNumerator='" + helpfulnessNumerator + '\''
                + ", helpfulnessDenominator='" + helpfulnessDenominator + '\''
                + ", score='" + score + '\''
                + ", time='" + time + '\''
                + ", summary='" + summary + '\''
                + ", text='" + text + '\''
                + '}';
    }
}
