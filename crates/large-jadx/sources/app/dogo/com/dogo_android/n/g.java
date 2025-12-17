package app.dogo.com.dogo_android.n;

import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0008\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0008\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/library/LibraryCallback$Callback;", "", "onArticleListSelected", "", "onArticleSelected", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "onComingSoonItemSelect", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onProgramListSelected", "onProgramSelected", "onRecommendedProgramSelected", "onSubscriptionSelected", "onTrickListSelected", "categoryId", "", "categoryName", "onTrickSelected", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface g {
    public abstract void E0();

    public abstract void Q();

    public abstract void X(String string, String string2);

    public abstract void a(Article article);

    public abstract void b(ProgramDescriptionItem programDescriptionItem);

    public abstract void c();

    public abstract void g(ProgramDescriptionItem programDescriptionItem);

    public abstract void j(TrickItem trickItem);
}
