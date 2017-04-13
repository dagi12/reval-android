package pl.edu.amu.wmi.reval.topic;

import android.app.Application;

import java.util.List;

import pl.edu.amu.wmi.reval.common.services.AbstactRetrofitService;
import pl.edu.amu.wmi.reval.common.services.MyCallback;
import retrofit2.Call;
import retrofit2.Response;

public class TopicServiceImpl extends AbstactRetrofitService {

    private final TopicService topicService;

    public TopicServiceImpl(TopicService topicService, Application application) {
        super(application);
        this.topicService = topicService;
    }

    public void getTopics(final TopicAdapter adapter, final int subjectId) {
        topicService.getTopicsBySubject(subjectId).enqueue(new MyCallback<List<Topic>>(application) {
            @Override
            protected void onHandledResponse(Call<List<Topic>> call, Response<List<Topic>> response) {
                adapter.populateTopics(response.body());
            }
        });
    }

    public interface TopicAdapter {
        void populateTopics(List<Topic> topics);
    }
}
