package zendesk.answerbot;

import retrofit2.Call;
import retrofit2.http.POST;

/* loaded from: classes3.dex */
interface AnswerBotService {
    @POST("/api/v2/answer_bot/interaction")
    public abstract Call<zendesk.answerbot.DeflectionResponse> interaction(zendesk.answerbot.DeflectionRequest deflectionRequest);

    @POST("/api/v2/answer_bot/rejection")
    public abstract Call<Void> rejection(zendesk.answerbot.PostReject postReject);

    @POST("/api/v2/answer_bot/resolution")
    public abstract Call<Void> resolution(zendesk.answerbot.PostResolve postResolve);
}
