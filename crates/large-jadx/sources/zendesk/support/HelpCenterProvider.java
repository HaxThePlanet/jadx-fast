package zendesk.support;

import com.zendesk.service.f;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public interface HelpCenterProvider {
    public abstract void deleteVote(Long long, f<Void> f2);

    public abstract void downvoteArticle(Long long, f<zendesk.support.ArticleVote> f2);

    public abstract void getArticle(Long long, f<zendesk.support.Article> f2);

    public abstract void getArticles(Long long, f<List<zendesk.support.Article>> f2);

    public abstract void getArticles(Long long, String string2, f<List<zendesk.support.Article>> f3);

    public abstract void getAttachments(Long long, zendesk.support.AttachmentType attachmentType2, f<List<zendesk.support.HelpCenterAttachment>> f3);

    public abstract void getCategories(f<List<zendesk.support.Category>> f);

    public abstract void getCategory(Long long, f<zendesk.support.Category> f2);

    public abstract void getHelp(zendesk.support.HelpRequest helpRequest, f<List<zendesk.support.HelpItem>> f2);

    public abstract void getSection(Long long, f<zendesk.support.Section> f2);

    public abstract void getSections(Long long, f<List<zendesk.support.Section>> f2);

    public abstract void getSuggestedArticles(zendesk.support.SuggestedArticleSearch suggestedArticleSearch, f<Object> f2);

    public abstract void listArticles(zendesk.support.ListArticleQuery listArticleQuery, f<List<zendesk.support.SearchArticle>> f2);

    public abstract void listArticlesFlat(zendesk.support.ListArticleQuery listArticleQuery, f<List<zendesk.support.FlatArticle>> f2);

    public abstract void searchArticles(zendesk.support.HelpCenterSearch helpCenterSearch, f<List<zendesk.support.SearchArticle>> f2);

    public abstract void submitRecordArticleView(zendesk.support.Article article, Locale locale2, f<Void> f3);

    public abstract void upvoteArticle(Long long, f<zendesk.support.ArticleVote> f2);
}
