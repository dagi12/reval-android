package pl.edu.amu.wmi.reval.answer.report;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class AnswerReport extends AbstractRevalItem implements Serializable {

    private Answer answer;

    @SerializedName("similarAnswer")
    private Integer similarAnswer;

    @SerializedName("similarityPercentage")
    private Integer similarity;

    public AnswerReport() {
        // retrofit need
    }

    public Integer getSimilarity() {
        return similarity;
    }

    public Answer getAnswer() {
        return answer;
    }
}
