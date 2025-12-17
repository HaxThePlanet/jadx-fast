package app.dogo.com.dogo_android.n;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.a;
import androidx.core.content.e.f;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.al;
import app.dogo.com.dogo_android.h.e3;
import app.dogo.com.dogo_android.h.gl;
import app.dogo.com.dogo_android.h.il;
import app.dogo.com.dogo_android.h.kl;
import app.dogo.com.dogo_android.h.w;
import app.dogo.com.dogo_android.h.wk;
import app.dogo.com.dogo_android.h.yk;
import app.dogo.com.dogo_android.n.k.n;
import app.dogo.com.dogo_android.n.k.n.b;
import app.dogo.com.dogo_android.n.l.b;
import app.dogo.com.dogo_android.n.l.b.a;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.n.m.u.n.a;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.Library;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.a;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.customview.ArcProgressBar;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.n0.q;
import app.dogo.com.dogo_android.util.n0.s;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.p;
import app.dogo.com.dogo_android.view.compat.ChipGroupWithState;
import app.dogo.com.dogo_android.y.l;
import com.bumptech.glide.j;
import com.bumptech.glide.load.n.e.d;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.ChipGroup;
import d.h.l.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J%\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000e*\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u000e*\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cH\u0007J\u0016\u0010\u001d\u001a\u00020\u000e*\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J \u0010!\u001a\u00020\u000e*\u00020\"2\u0008\u0010\u001b\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0007J&\u0010!\u001a\u00020\u000e*\u00020\"2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001c2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0014\u0010'\u001a\u00020\u000e*\u00020(2\u0006\u0010)\u001a\u00020&H\u0007J\u0016\u0010*\u001a\u00020\u000e*\u00020+2\u0008\u0010)\u001a\u0004\u0018\u00010&H\u0007J\u001b\u0010,\u001a\u00020\u000e*\u00020\u00152\u0008\u0010-\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018J%\u0010,\u001a\u00020\u000e*\u00020+2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u000e*\u00020+2\u0008\u00100\u001a\u0004\u0018\u000101H\u0007JV\u00102\u001a\u00020\u000e*\u00020\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0008\u0010$\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0007J\u0016\u0010B\u001a\u00020\u000e*\u00020C2\u0008\u0010)\u001a\u0004\u0018\u00010DH\u0007J \u0010E\u001a\u00020\u000e*\u00020F2\u0008\u0010\u001b\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010GH\u0007J.\u0010E\u001a\u00020\u000e*\u00020F2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020H\u0018\u0001032\u0008\u0010$\u001a\u0004\u0018\u00010G2\u0006\u0010I\u001a\u00020+H\u0007J\u0016\u0010J\u001a\u00020\u000e*\u00020+2\u0008\u0010)\u001a\u0004\u0018\u000101H\u0007J%\u0010K\u001a\u00020\u000e*\u00020+2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010.J \u0010L\u001a\u00020\u000e*\u00020\u00152\u0008\u0010M\u001a\u0004\u0018\u00010N2\u0008\u0010O\u001a\u0004\u0018\u00010 H\u0007J\u001b\u0010P\u001a\u00020\u000e*\u00020\u00042\u0008\u0010Q\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010RJ#\u0010S\u001a\u00020\u000e*\u00020\u00042\u0006\u0010T\u001a\u00020+2\u0008\u0010U\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010VJ\u001c\u0010W\u001a\u00020\u000e*\u00020\u00042\u0006\u0010X\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u0004H\u0007¨\u0006Z", d2 = {"Lapp/dogo/com/dogo_android/library/LibraryBindingAdapters;", "", "()V", "inflateNewLibraryTagChip", "Landroid/view/View;", "libraryTag", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "index", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "animateBigTimerArc", "", "Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;", "elapsedTimeSeconds", "", "goalSeconds", "(Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;Ljava/lang/Long;Ljava/lang/Long;)V", "customDisabledButton", "Landroid/widget/Button;", "isEnabled", "", "(Landroid/widget/Button;Ljava/lang/Boolean;)V", "set", "Lapp/dogo/com/dogo_android/view/compat/ChipGroupWithState;", "result", "", "setArticleImage", "Landroid/widget/ImageView;", "imageUrl", "", "setArticleListTab", "Landroidx/recyclerview/widget/RecyclerView;", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "callback", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "setArticleTags", "Lcom/google/android/material/chip/ChipGroup;", "item", "setArticleTitleText", "Landroid/widget/TextView;", "setBigTimerDescriptionButton", "isVariation", "(Landroid/widget/TextView;Ljava/lang/Long;Ljava/lang/Long;)V", "setBigTimerGoalDescription", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "setLibraryAdapter", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Library;", "Lapp/dogo/com/dogo_android/library/LibraryCallback$Callback;", "trickBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryTrickListBinding;", "gameBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryGameListBinding;", "skillsBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibrarySkillListBinding;", "articleBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryArticleListBinding;", "programBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryProgramListBinding;", "subscribeBanner", "Lapp/dogo/com/dogo_android/databinding/LayoutLibrarySubscribeBinding;", "setLibraryHeaderForTricks", "Lcom/google/android/material/appbar/MaterialToolbar;", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "setLibraryProgramAdapter", "Landroidx/viewpager2/widget/ViewPager2;", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedProgramData;", "title", "setLibraryTrickNameText", "setOvertimeLabel", "setupCtaText", "flowtype", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel$TrainingFlowType;", "trainingTimeDuration", "setupTrickDetailsCard", "isClickerHidden", "(Landroid/view/View;Ljava/lang/Boolean;)V", "setupTrickDetailsPauseTime", "textView", "pauseTimeSec", "(Landroid/view/View;Landroid/widget/TextView;Ljava/lang/Long;)V", "setupTrickDetailsToolbar", "compactView", "normalView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f {

    public static final app.dogo.com.dogo_android.n.f a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[n.a.PAUSED.ordinal()] = 1;
            iArr[n.a.TIMED.ordinal()] = 2;
            iArr[n.a.RATED.ordinal()] = 3;
            f.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$1", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements o.a {

        final app.dogo.com.dogo_android.n.g a;
        b(app.dogo.com.dogo_android.n.g g) {
            this.a = g;
            super();
        }

        @Override // app.dogo.com.dogo_android.n.m.o$a
        public void j(TrickItem trickItem) {
            n.f(trickItem, "trick");
            this.a.j(trickItem);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$2", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements o.a {

        final app.dogo.com.dogo_android.n.g a;
        c(app.dogo.com.dogo_android.n.g g) {
            this.a = g;
            super();
        }

        @Override // app.dogo.com.dogo_android.n.m.o$a
        public void j(TrickItem trickItem) {
            n.f(trickItem, "trick");
            this.a.j(trickItem);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$3", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d implements o.a {

        final app.dogo.com.dogo_android.n.g a;
        d(app.dogo.com.dogo_android.n.g g) {
            this.a = g;
            super();
        }

        @Override // app.dogo.com.dogo_android.n.m.o$a
        public void j(TrickItem trickItem) {
            n.f(trickItem, "trick");
            this.a.j(trickItem);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$4", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e implements n.b {

        final app.dogo.com.dogo_android.n.g a;
        e(app.dogo.com.dogo_android.n.g g) {
            this.a = g;
            super();
        }

        @Override // app.dogo.com.dogo_android.n.k.n$b
        public void a(Article article) {
            n.f(article, "article");
            this.a.a(article);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$5", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "onComingSoonItemSelect", "", "program", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onProgramSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f implements b.a {

        final app.dogo.com.dogo_android.n.g a;
        f(app.dogo.com.dogo_android.n.g g) {
            this.a = g;
            super();
        }

        @Override // app.dogo.com.dogo_android.n.l.b$a
        public void b(ProgramDescriptionItem programDescriptionItem) {
            n.f(programDescriptionItem, "program");
            this.a.b(programDescriptionItem);
        }

        @Override // app.dogo.com.dogo_android.n.l.b$a
        public void g(ProgramDescriptionItem programDescriptionItem) {
            n.f(programDescriptionItem, "program");
            this.a.g(programDescriptionItem);
        }
    }
    static {
        f fVar = new f();
        f.a = fVar;
    }

    public static final void a(ArcProgressBar arcProgressBar, Long long2, Long long3) {
        String str;
        long longValue;
        int obj4;
        int obj5;
        n.f(arcProgressBar, "<this>");
        if (long2 != 0 && long3 != 0) {
            if (long3 != 0) {
                longValue = long3.longValue();
                arcProgressBar.a((int)i, 1000);
            }
        }
    }

    public static final void b(Button button, Boolean boolean2) {
        String str;
        int i;
        int obj3;
        n.f(button, "<this>");
        if (boolean2 != 0) {
            str = 0;
            if (boolean2.booleanValue()) {
                button.setBackgroundColor(f.d(button.getResources(), 2131100336, str));
                button.setTextColor(f.d(button.getResources(), 2131099706, str));
            } else {
                button.setBackgroundColor(f.d(button.getResources(), 2131099683, str));
                button.setTextColor(f.d(button.getResources(), 2131099768, str));
            }
        }
    }

    private final View c(LibraryTag libraryTag, int i2, Context context3, ViewGroup viewGroup4) {
        e3 obj4 = e3.T(LayoutInflater.from(context3), viewGroup4, false);
        n.e(obj4, "inflate(LayoutInflater.from(context), parent, false)");
        obj4.V(libraryTag);
        obj4.w().setTag(libraryTag.getId());
        obj4.w().setId(i2);
        View obj2 = obj4.w();
        n.e(obj2, "chip.root");
        return obj2;
    }

    public static void d(int i, int i2, View view3, float f4) {
        f.q(i, i2, view3, f4);
    }

    public static final void e(ChipGroupWithState chipGroupWithState, List<LibraryTag> list2) {
        Object arrayList;
        int i;
        boolean next;
        int i2;
        app.dogo.com.dogo_android.n.f fVar;
        Context context;
        String str;
        Iterable obj8;
        n.f(chipGroupWithState, "<this>");
        if (list2 != null && chipGroupWithState.getChildCount() > 0) {
            if (chipGroupWithState.getChildCount() > 0) {
                chipGroupWithState.y();
            }
            arrayList = new ArrayList(p.r(list2, 10));
            i = 0;
            obj8 = list2.iterator();
            for (Object next : obj8) {
                context = chipGroupWithState.getContext();
                n.e(context, "context");
                arrayList.add(f.a.c((LibraryTag)next, i, context, chipGroupWithState));
                i = i2;
            }
            chipGroupWithState.z(arrayList);
            chipGroupWithState.r();
            chipGroupWithState.q(chipGroupWithState.getLastSelectedId());
        }
    }

    public static final void f(ImageView imageView, String string2) {
        int i4;
        int i3;
        int i2;
        int i;
        Object obj4;
        n.f(imageView, "<this>");
        i4 = 1;
        i3 = 0;
        if (string2 == null) {
            i2 = i3;
        } else {
        }
        if (i2 != 0) {
            m.a(imageView.getContext()).D(string2).y1(d.h()).p1(MyAppGlideModule.d(imageView.getContext())).C0(imageView);
        } else {
            i4 = i3;
        }
        if (i4 != 0) {
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public static final void g(RecyclerView recyclerView, LibrarySection librarySection2, n.b n$b3) {
        Object nVar;
        Object obj1;
        String obj2;
        Object obj3;
        n.f(recyclerView, "<this>");
        if (librarySection2 != null && b3 != null) {
            if (b3 != null) {
                if (librarySection2.getArticles() != null) {
                    nVar = new n(b3);
                    nVar.j(librarySection2.getArticles());
                    obj2 = w.a;
                    recyclerView.setAdapter(nVar);
                    if (recyclerView.getItemDecorationCount() == 0) {
                        obj3 = recyclerView.getContext();
                        n.e(obj3, "context");
                        obj2 = new q(obj3);
                        recyclerView.h(obj2);
                    }
                } else {
                    a.c("Invalid Library Section Article Item", new Object[0]);
                }
            }
        }
    }

    public static final void h(RecyclerView recyclerView, List<Article> list2, n.b n$b3) {
        androidx.recyclerview.widget.RecyclerView.h nVar;
        String str;
        List obj2;
        int obj3;
        n.f(recyclerView, "<this>");
        if (list2 != null && b3 != null && recyclerView.getAdapter() == null) {
            if (b3 != null) {
                if (recyclerView.getAdapter() == null) {
                    nVar = new n(b3);
                    recyclerView.setAdapter(nVar);
                }
                if (obj3 instanceof n) {
                } else {
                    obj3 = 0;
                }
                if (obj3 == null) {
                } else {
                    obj3.j(list2);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = recyclerView.getContext();
                    n.e(obj3, "context");
                    obj2 = new q(obj3);
                    recyclerView.h(obj2);
                }
            }
        }
    }

    public static final void i(ChipGroup chipGroup, Article article2) {
        int color;
        int i2;
        String str2;
        LibraryTag libraryTag;
        int i3;
        String str3;
        String str;
        int i;
        int i4;
        List obj11;
        n.f(chipGroup, "<this>");
        n.f(article2, "item");
        chipGroup.removeAllViews();
        obj11 = article2.getDisplayTags();
        i2 = 2;
        if (obj11.size() > i2) {
            super(0, n.o("+", Integer.valueOf(size -= i2)), "", 1, 0);
            obj11 = p.t0(p.F0(obj11, i2), p.b(libraryTag2));
        }
        obj11 = obj11.iterator();
        for (LibraryTag next2 : obj11) {
            w wVar = w.T(LayoutInflater.from(chipGroup.getContext()), chipGroup, false);
            n.e(wVar, "inflate(inflater, this, false)");
            wVar.V(next2);
            chipGroup.addView(wVar.w());
            chipGroup.setBackgroundColor(chipGroup.getResources().getColor(2131100379, null));
        }
    }

    public static final void j(TextView textView, Article article2) {
        String str2;
        int i;
        SpannableString spannableString;
        int i3;
        int i2;
        String str;
        int obj7;
        n.f(textView, "<this>");
        if (article2 != 0) {
            i = 0;
            if (article2.isRead()) {
                Drawable drawable = a.f(textView.getContext(), 2131231065);
                int dimensionPixelSize = textView.getResources().getDimensionPixelSize(2131165620);
                i3 = 0;
                if (drawable == null) {
                } else {
                    drawable.setBounds(i3, i3, dimensionPixelSize, dimensionPixelSize);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("check");
                stringBuilder.append("  ");
                stringBuilder.append(article2.getTitle());
                spannableString = new SpannableString(stringBuilder.toString());
                n.d(drawable);
                obj7 = new ImageSpan(drawable, 1);
                spannableString.setSpan(obj7, i3, 5, 17);
                textView.setText(spannableString);
                textView.setTextColor(textView.getResources().getColor(2131099823, i));
            } else {
                textView.setText(article2.getTitle());
                textView.setTextColor(textView.getResources().getColor(2131099767, i));
            }
        }
    }

    public static final void k(Button button, Boolean boolean2) {
        int str;
        String obj2;
        n.f(button, "<this>");
        if (boolean2 != null) {
            if (boolean2.booleanValue()) {
                obj2 = button.getResources().getString(2131887651);
            } else {
                obj2 = button.getResources().getString(2131886774);
            }
            button.setText(obj2);
        }
    }

    public static final void l(TextView textView, Long long2, Long long3) {
        v2.a companion;
        long l;
        int i2;
        int i3;
        int i;
        String obj8;
        n.f(textView, "<this>");
        if (long2 != null && long3 != null) {
            if (long3 != null) {
                textView.setText(v2.a.b(v2.Companion, g.f(long2.longValue(), obj3), obj3, 0, 2));
            }
        }
    }

    public static final void m(TextView textView, TrickItem trickItem2) {
        String variation;
        String obj2;
        n.f(textView, "<this>");
        if (trickItem2 != null) {
            if (trickItem2.isVariation()) {
                l.q0(textView, trickItem2.getDescription());
            } else {
                textView.setText(trickItem2.getDescription());
            }
        }
    }

    public static final void n(View view, y<Library> y2, app.dogo.com.dogo_android.n.g g3, kl kl4, yk yk5, gl gl6, wk wk7, al al8, il il9) {
        int obj1;
        Object obj2;
        Object obj3;
        n.f(view, "<this>");
        n.f(kl4, "trickBinding");
        n.f(yk5, "gameBinding");
        n.f(gl6, "skillsBinding");
        n.f(wk7, "articleBinding");
        n.f(al8, "programBinding");
        n.f(il9, "subscribeBanner");
        if (y2 instanceof y.c && g3 != null) {
            if (g3 != null) {
                obj1 = (y.c)y2.a();
                kl4.U((Library)obj1.getTrickSection());
                kl4.V(g3);
                obj2 = new f.b(g3);
                kl4.T(obj2);
                yk5.U(obj1.getGamesSection());
                yk5.V(g3);
                obj2 = new f.c(g3);
                yk5.T(obj2);
                gl6.U(obj1.getSkillsSection());
                gl6.V(g3);
                obj2 = new f.d(g3);
                gl6.T(obj2);
                wk7.U(obj1.getArticleSection());
                wk7.V(g3);
                obj2 = new f.e(g3);
                wk7.T(obj2);
                al8.U(obj1.getProgramSection());
                al8.V(g3);
                obj2 = new f.f(g3);
                al8.T(obj2);
                obj1 = n.b(obj1.isDogPremiumContentLocked(), Boolean.TRUE) ? 0 : 8;
                il9.w().setVisibility(obj1);
            }
        }
    }

    public static final void o(MaterialToolbar materialToolbar, TrickItem.TrickCategory trickItem$TrickCategory2) {
        int i;
        String str;
        int i2;
        int obj4;
        n.f(materialToolbar, "<this>");
        if (trickCategory2 == null) {
            obj4 = 0;
        } else {
            obj4 = trickCategory2.getId();
        }
        i = 2131887623;
        if (obj4 != null) {
            str = obj4.hashCode();
            if (str != -808875034) {
                if (str != -773789916) {
                    if (str != -314563939) {
                        obj4 = materialToolbar.getResources().getString(i);
                    } else {
                        if (!obj4.equals("id_games")) {
                        } else {
                            obj4 = materialToolbar.getResources().getString(2131886667);
                        }
                    }
                } else {
                    if (!obj4.equals("id_tricks")) {
                    } else {
                        obj4 = materialToolbar.getResources().getString(i);
                    }
                }
            } else {
                if (!obj4.equals("id_skills")) {
                } else {
                    obj4 = materialToolbar.getResources().getString(2131886727);
                }
            }
        } else {
        }
        materialToolbar.setTitle(obj4);
    }

    public static final void p(ViewPager2 viewPager2, LibrarySection librarySection2, b.a b$a3) {
        Object programDescriptions;
        int itemDecorationCount;
        androidx.recyclerview.widget.RecyclerView.h bVar;
        boolean z;
        String str2;
        int i;
        int context;
        Object str;
        Object obj4;
        int obj5;
        b.a obj6;
        n.f(viewPager2, "<this>");
        if (librarySection2 != null && a3 != null) {
            if (a3 != null) {
                i = 0;
                if (librarySection2.getProgramDescriptions() != null) {
                    if (viewPager2.getItemDecorationCount() == 0) {
                        context = viewPager2.getContext();
                        n.e(context, "context");
                        itemDecorationCount = new s(context);
                        viewPager2.a(itemDecorationCount);
                    }
                    if (viewPager2.getAdapter() == null) {
                        bVar = new b(a3);
                        bVar.j(librarySection2.getProgramDescriptions());
                        obj6 = w.a;
                        viewPager2.setAdapter(bVar);
                        viewPager2.setOffscreenPageLimit(3);
                    }
                    context = 0;
                    if (obj6 instanceof b) {
                    } else {
                        obj6 = context;
                    }
                    if (obj6 == null) {
                    } else {
                        Object obj = p.a0(obj6.g(), i);
                        if ((ProgramDescriptionItem)obj == null) {
                            str2 = context;
                        } else {
                            str2 = (ProgramDescriptionItem)obj.getId();
                        }
                        str = p.a0(librarySection2.getProgramDescriptions(), i);
                        if ((ProgramDescriptionItem)str == null) {
                        } else {
                            context = (ProgramDescriptionItem)str.getId();
                        }
                        obj6.j(librarySection2.getProgramDescriptions());
                        if (z2 ^= 1 != 0) {
                            viewPager2.k(i, i);
                        }
                    }
                    programDescriptions = new a(viewPager2.getResources().getDimensionPixelOffset(2131165629), viewPager2.getResources().getDimensionPixelOffset(2131165620));
                    viewPager2.setPageTransformer(programDescriptions);
                } else {
                    a.c("Invalid Library Section Item", new Object[i]);
                }
            }
        }
    }

    private static final void q(int i, int i2, View view3, float f4) {
        int obj2;
        int obj3;
        n.f(view3, "page");
        ViewParent parent2 = view3.getParent().getParent();
        Objects.requireNonNull(parent2, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        f4 *= obj2;
        if ((ViewPager2)parent2.getOrientation() == 0) {
            if (u.B(parent2) == 1) {
                view3.setTranslationX(-obj5);
            } else {
                view3.setTranslationX(obj5);
            }
        } else {
            view3.setTranslationY(obj5);
        }
    }

    public static final void r(TextView textView, TrickItem trickItem2) {
        boolean locked;
        int i;
        Object spannableString;
        int intrinsicHeight;
        String str;
        ImageSpan obj6;
        n.f(textView, "<this>");
        if (trickItem2 != null) {
            if (trickItem2.getLocked()) {
                Drawable drawable = a.f(textView.getContext(), 2131231191);
                i = 0;
                if (drawable == null) {
                } else {
                    drawable.setBounds(i, i, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("lock");
                stringBuilder.append("  ");
                stringBuilder.append(trickItem2.getName());
                spannableString = new SpannableString(stringBuilder.toString());
                n.d(drawable);
                obj6 = new ImageSpan(drawable, 1);
                spannableString.setSpan(obj6, i, 4, 17);
            } else {
                spannableString = trickItem2.getName();
            }
            textView.setText(spannableString);
        }
    }

    public static final void s(TextView textView, Long long2, Long long3) {
        int str;
        int i;
        long longValue;
        int i3;
        int i2;
        int i4;
        int i5;
        int obj9;
        String obj10;
        n.f(textView, "<this>");
        if (long2 != null && long3 != null) {
            if (long3 != null) {
                str = Long.compare(longValue2, longValue) > 0 ? 1 : i;
                if (str != null) {
                    obj9 = v2.a.b(v2.Companion, longValue3 -= obj9, obj4, 0, 2);
                } else {
                    obj9 = 0;
                }
                if (str != null) {
                } else {
                    i = 8;
                }
                textView.setVisibility(i);
                textView.setText(n.o("+", obj9));
            }
        }
    }

    public static final void t(Button button, n.a n$a2, String string3) {
        String str;
        int i;
        int i2;
        String obj4;
        Object obj5;
        n.f(button, "<this>");
        if (a2 != null) {
            obj4 = f.a.a[a2.ordinal()];
            str = 1;
            if (obj4 != str) {
                if (obj4 != 2) {
                    if (obj4 != 3) {
                    } else {
                        obj4 = button.getResources().getString(2131886685);
                    }
                    NoWhenBranchMatchedException obj3 = new NoWhenBranchMatchedException();
                    throw obj3;
                }
                str = new Object[str];
                str[0] = string3;
                obj4 = button.getResources().getString(2131887361, str);
            } else {
                obj4 = button.getResources().getString(2131887251);
            }
            button.setText(obj4);
        }
    }

    public static final void u(View view, Boolean boolean2) {
        String str;
        int i;
        Drawable obj3;
        n.f(view, "<this>");
        if (boolean2 != null) {
            if (boolean2.booleanValue()) {
                view.setBackgroundColor(-1);
            } else {
                view.setBackground(f.f(view.getResources(), 2131231279, 0));
            }
        }
    }

    public static final void v(View view, TextView textView2, Long long3) {
        int length;
        SpannableStringBuilder spannableStringBuilder;
        int i4;
        int color;
        int i2;
        int i;
        int i3;
        int i5;
        int obj9;
        ForegroundColorSpan obj10;
        n.f(view, "<this>");
        n.f(textView2, "textView");
        if (long3 != null) {
            String string = view.getResources().getString(2131887028);
            n.e(string, "resources.getString(R.string.paused_title)");
            obj10 = v2.a.b(v2.Companion, long3.longValue(), obj4, 0, 2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(' ');
            stringBuilder.append(obj10);
            String string2 = stringBuilder.toString();
            spannableStringBuilder = new SpannableStringBuilder(string2);
            length2 -= obj10;
            obj10 = new TypefaceSpan("sans-serif-medium");
            i2 = 33;
            spannableStringBuilder.setSpan(obj10, i4, string2.length(), i2);
            obj10 = new ForegroundColorSpan(view.getResources().getColor(2131100352, 0));
            spannableStringBuilder.setSpan(obj10, i4, string2.length(), i2);
            textView2.setText(spannableStringBuilder);
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
