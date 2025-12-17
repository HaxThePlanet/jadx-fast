package zendesk.support;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* loaded from: classes3.dex */
interface HelpCenterService {
    @DELETE("/api/v2/help_center/votes/{vote_id}.json")
    public abstract Call<Void> deleteVote(Long long);

    @POST("/api/v2/help_center/articles/{article_id}/down.json")
    public abstract Call<zendesk.support.ArticleVoteResponse> downvoteArticle(Long long, String string2);

    @GET("/api/v2/help_center/{locale}/articles/{article_id}.json?respect_sanitization_settings=true")
    public abstract Call<zendesk.support.ArticleResponse> getArticle(String string, Long long2, String string3);

    @GET("/api/v2/help_center/{locale}/sections/{id}/articles.json?respect_sanitization_settings=true")
    public abstract Call<zendesk.support.ArticlesListResponse> getArticles(String string, Long long2, String string3, String string4, int i5);

    @GET("/api/v2/help_center/{locale}/articles/{article_id}/attachments/{attachment_type}.json")
    public abstract Call<zendesk.support.AttachmentResponse> getAttachments(String string, Long long2, String string3);

    @GET("/api/v2/help_center/{locale}/categories.json?per_page=1000")
    public abstract Call<zendesk.support.CategoriesResponse> getCategories(String string);

    @GET("/api/v2/help_center/{locale}/categories/{category_id}.json")
    public abstract Call<zendesk.support.CategoryResponse> getCategoryById(String string, Long long2);

    @GET("/hc/api/mobile/{locale}/article_tree.json")
    public abstract Call<zendesk.support.HelpResponse> getHelp(String string, String string2, String string3, String string4, int i5, String string6, int i7, String string8, String string9);

    @GET("/api/v2/help_center/{locale}/sections/{section_id}.json")
    public abstract Call<zendesk.support.SectionResponse> getSectionById(String string, Long long2);

    @GET("/api/v2/help_center/{locale}/categories/{id}/sections.json")
    public abstract Call<zendesk.support.SectionsResponse> getSections(String string, Long long2, int i3);

    @GET("/api/mobile/help_center/search/deflect.json?respect_sanitization_settings=true")
    public abstract Call<Object> getSuggestedArticles(String string, String string2, String string3, Long long4, Long long5);

    @GET("/api/v2/help_center/{locale}/articles.json?respect_sanitization_settings=true")
    public abstract Call<zendesk.support.ArticlesListResponse> listArticles(String string, String string2, String string3, String string4, String string5, Integer integer6, Integer integer7);

    @GET("/api/v2/help_center/articles/search.json?respect_sanitization_settings=true&origin=mobile_sdk")
    public abstract Call<zendesk.support.ArticlesSearchResponse> searchArticles(String string, String string2, String string3, String string4, String string5, String string6, Integer integer7, Integer integer8);

    @POST("/api/v2/help_center/{locale}/articles/{article_id}/stats/view.json")
    public abstract Call<Void> submitRecordArticleView(Long long, String string2, zendesk.support.RecordArticleViewRequest recordArticleViewRequest3);

    @POST("/api/v2/help_center/articles/{article_id}/up.json")
    public abstract Call<zendesk.support.ArticleVoteResponse> upvoteArticle(Long long, String string2);
}
