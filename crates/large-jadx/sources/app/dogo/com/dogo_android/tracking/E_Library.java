package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Library;", "", "()V", "ArticleFinishReadingTapped", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$ArticleId;", "LibraryAllArticlesTapped", "Lapp/dogo/com/dogo_android/tracking/Event0;", "LibraryAllProgramsTapped", "LibraryAllTricksTapped", "Lapp/dogo/com/dogo_android/tracking/EP$CategoryId;", "LibraryArticleTapped", "LibraryArticlesShortcutTapped", "LibraryGamesShortcutTapped", "LibraryProgramTapped", "Lapp/dogo/com/dogo_android/tracking/EP$ProgramId;", "LibrarySkillsShortcutTapped", "LibrarySubscriptionPromotionTapped", "LibraryTrickTapped", "Lapp/dogo/com/dogo_android/tracking/EP$TrickId;", "LibraryTricksShortcutTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d0, reason: from kotlin metadata */
public final class E_Library {

    public static final u2<b1> a;
    public static final t2 b;
    public static final t2 c;
    public static final u2<n2> d;
    public static final u2<w0> e;
    public static final t2 f;
    public static final t2 g;
    public static final t2 h;
    public static final t2 i;
    public static final t2 j;
    public static final u2<e2> k;
    public static final u2<w0> l;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_Library.a = companion2.a("library_show_all_tapped").b(new EP_CategoryId());
        E_Library.b = companion2.a("library_show_all_articles_tapped");
        E_Library.c = companion2.a("library_show_all_programs_tapped");
        E_Library.d = companion2.a("library_trick_tapped").b(new EP_TrickId());
        E_Library.e = companion2.a("library_article_tapped").b(new EP_ArticleId());
        E_Library.f = companion2.a("library_trick_shortcut_tapped");
        E_Library.g = companion2.a("library_games_shortcut_tapped");
        E_Library.h = companion2.a("library_skills_shortcut_tapped");
        E_Library.i = companion2.a("library_articles_shortcut_tapped");
        E_Library.j = companion2.a("library_subscription_promotion_tapped");
        E_Library.k = companion2.a("library_program_tapped").b(new EP_ProgramId());
        E_Library.l = companion2.a("finish_reading_tapped").b(new EP_ArticleId());
    }
}
