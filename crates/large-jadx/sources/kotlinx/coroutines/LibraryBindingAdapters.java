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
import androidx.core.content.e.f;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.al;
import app.dogo.com.dogo_android.h.e3;
import app.dogo.com.dogo_android.h.gl;
import app.dogo.com.dogo_android.h.il;
import app.dogo.com.dogo_android.h.kl;
import app.dogo.com.dogo_android.h.wk;
import app.dogo.com.dogo_android.h.yk;
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
import kotlin.h0.g;

/* compiled from: LibraryBindingAdapters.kt */
@Metadata(d1 = "\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J%\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000e*\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u000e*\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cH\u0007J\u0016\u0010\u001d\u001a\u00020\u000e*\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J \u0010!\u001a\u00020\u000e*\u00020\"2\u0008\u0010\u001b\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0007J&\u0010!\u001a\u00020\u000e*\u00020\"2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001c2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0014\u0010'\u001a\u00020\u000e*\u00020(2\u0006\u0010)\u001a\u00020&H\u0007J\u0016\u0010*\u001a\u00020\u000e*\u00020+2\u0008\u0010)\u001a\u0004\u0018\u00010&H\u0007J\u001b\u0010,\u001a\u00020\u000e*\u00020\u00152\u0008\u0010-\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018J%\u0010,\u001a\u00020\u000e*\u00020+2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u000e*\u00020+2\u0008\u00100\u001a\u0004\u0018\u000101H\u0007JV\u00102\u001a\u00020\u000e*\u00020\u00042\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0008\u0010$\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0007J\u0016\u0010B\u001a\u00020\u000e*\u00020C2\u0008\u0010)\u001a\u0004\u0018\u00010DH\u0007J \u0010E\u001a\u00020\u000e*\u00020F2\u0008\u0010\u001b\u001a\u0004\u0018\u00010#2\u0008\u0010$\u001a\u0004\u0018\u00010GH\u0007J.\u0010E\u001a\u00020\u000e*\u00020F2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020H\u0018\u0001032\u0008\u0010$\u001a\u0004\u0018\u00010G2\u0006\u0010I\u001a\u00020+H\u0007J\u0016\u0010J\u001a\u00020\u000e*\u00020+2\u0008\u0010)\u001a\u0004\u0018\u000101H\u0007J%\u0010K\u001a\u00020\u000e*\u00020+2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010.J \u0010L\u001a\u00020\u000e*\u00020\u00152\u0008\u0010M\u001a\u0004\u0018\u00010N2\u0008\u0010O\u001a\u0004\u0018\u00010 H\u0007J\u001b\u0010P\u001a\u00020\u000e*\u00020\u00042\u0008\u0010Q\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010RJ#\u0010S\u001a\u00020\u000e*\u00020\u00042\u0006\u0010T\u001a\u00020+2\u0008\u0010U\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010VJ\u001c\u0010W\u001a\u00020\u000e*\u00020\u00042\u0006\u0010X\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u0004H\u0007¨\u0006Z", d2 = {"Lapp/dogo/com/dogo_android/library/LibraryBindingAdapters;", "", "()V", "inflateNewLibraryTagChip", "Landroid/view/View;", "libraryTag", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "index", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "animateBigTimerArc", "", "Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;", "elapsedTimeSeconds", "", "goalSeconds", "(Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;Ljava/lang/Long;Ljava/lang/Long;)V", "customDisabledButton", "Landroid/widget/Button;", "isEnabled", "", "(Landroid/widget/Button;Ljava/lang/Boolean;)V", "set", "Lapp/dogo/com/dogo_android/view/compat/ChipGroupWithState;", "result", "", "setArticleImage", "Landroid/widget/ImageView;", "imageUrl", "", "setArticleListTab", "Landroidx/recyclerview/widget/RecyclerView;", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "callback", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "setArticleTags", "Lcom/google/android/material/chip/ChipGroup;", "item", "setArticleTitleText", "Landroid/widget/TextView;", "setBigTimerDescriptionButton", "isVariation", "(Landroid/widget/TextView;Ljava/lang/Long;Ljava/lang/Long;)V", "setBigTimerGoalDescription", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "setLibraryAdapter", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/Library;", "Lapp/dogo/com/dogo_android/library/LibraryCallback$Callback;", "trickBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryTrickListBinding;", "gameBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryGameListBinding;", "skillsBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibrarySkillListBinding;", "articleBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryArticleListBinding;", "programBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutLibraryProgramListBinding;", "subscribeBanner", "Lapp/dogo/com/dogo_android/databinding/LayoutLibrarySubscribeBinding;", "setLibraryHeaderForTricks", "Lcom/google/android/material/appbar/MaterialToolbar;", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "setLibraryProgramAdapter", "Landroidx/viewpager2/widget/ViewPager2;", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedProgramData;", "title", "setLibraryTrickNameText", "setOvertimeLabel", "setupCtaText", "flowtype", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel$TrainingFlowType;", "trainingTimeDuration", "setupTrickDetailsCard", "isClickerHidden", "(Landroid/view/View;Ljava/lang/Boolean;)V", "setupTrickDetailsPauseTime", "textView", "pauseTimeSec", "(Landroid/view/View;Landroid/widget/TextView;Ljava/lang/Long;)V", "setupTrickDetailsToolbar", "compactView", "normalView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class LibraryBindingAdapters {

    public static final f a = new f();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[TrickDetailsViewModel_TrainingFlowType.values().length];
            iArr[TrickDetailsViewModel_TrainingFlowType.PAUSED.ordinal()] = 1;
            iArr[TrickDetailsViewModel_TrainingFlowType.TIMED.ordinal()] = 2;
            iArr[TrickDetailsViewModel_TrainingFlowType.RATED.ordinal()] = 3;
            kotlinx.coroutines.f.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$1", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements o.a {

        final /* synthetic */ g a;
        b(g gVar) {
            this.a = gVar;
            super();
        }

        /* renamed from: j, reason: from kotlin metadata */
        public void onTrickSelected(TrickItem trick) {
            n.f(trick, "trick");
            this.a.j(trick);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$2", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements o.a {

        final /* synthetic */ g a;
        c(g gVar) {
            this.a = gVar;
            super();
        }

        /* renamed from: j, reason: from kotlin metadata */
        public void onTrickSelected(TrickItem trick) {
            n.f(trick, "trick");
            this.a.j(trick);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$3", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "onTrickSelected", "", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d implements o.a {

        final /* synthetic */ g a;
        d(g gVar) {
            this.a = gVar;
            super();
        }

        /* renamed from: j, reason: from kotlin metadata */
        public void onTrickSelected(TrickItem trick) {
            n.f(trick, "trick");
            this.a.j(trick);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$4", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e implements n.b {

        final /* synthetic */ g a;
        e(g gVar) {
            this.a = gVar;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public void onArticleSelected(Article article) {
            n.f(article, "article");
            this.a.a(article);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/library/LibraryBindingAdapters$setLibraryAdapter$5", "Lapp/dogo/com/dogo_android/library/program/ProgramListCardAdapter$Callback;", "onComingSoonItemSelect", "", "program", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onProgramSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f implements b.a {

        final /* synthetic */ g a;
        f(g gVar) {
            this.a = gVar;
            super();
        }

        /* renamed from: b, reason: from kotlin metadata */
        public void onComingSoonItemSelect(ProgramDescriptionItem program) {
            n.f(program, "program");
            this.a.b(program);
        }

        /* renamed from: g, reason: from kotlin metadata */
        public void onProgramSelected(ProgramDescriptionItem program) {
            n.f(program, "program");
            this.a.g(program);
        }
    }
    private f() {
        super();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final void setLibraryProgramAdapter(ArcProgressBar result, Long callback, Long title) {
        str = "<this>";
        n.f(result, str);
        if (callback != null && title != null) {
            long value = title.longValue();
            float f = 1f;
            i = (int)(float)result.getMax() * (g.d((float)callback.longValue() / (float)value, f));
            result.a(i, 1000L);
        }
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final void animateBigTimerArc(Button elapsedTimeSeconds, Boolean goalSeconds) {
        str = "<this>";
        n.f(elapsedTimeSeconds, str);
        if (goalSeconds != null) {
            android.content.res.Resources.Theme theme = null;
            if (goalSeconds.booleanValue()) {
                elapsedTimeSeconds.setBackgroundColor(f.d(elapsedTimeSeconds.getResources(), 2131100336, theme));
                int i = 2131099706;
                elapsedTimeSeconds.setTextColor(f.d(elapsedTimeSeconds.getResources(), i, theme));
            } else {
                elapsedTimeSeconds.setBackgroundColor(f.d(elapsedTimeSeconds.getResources(), 2131099683, theme));
                i = 2131099768;
                elapsedTimeSeconds.setTextColor(f.d(elapsedTimeSeconds.getResources(), i, theme));
            }
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final View inflateNewLibraryTagChip(LibraryTag libraryTag, int index, Context context, ViewGroup parent) {
        e3 e3Var = e3.T(LayoutInflater.from(context), parent, false);
        n.e(e3Var, "inflate(LayoutInflater.from(context), parent, false)");
        e3Var.V(libraryTag);
        e3Var.w().setTag(libraryTag.getId());
        e3Var.w().setId(index);
        View view2 = e3Var.w();
        n.e(view2, "chip.root");
        return view2;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final void setArticleListTab(ChipGroupWithState result, List<LibraryTag> callback) {
        int i = 0;
        app.dogo.com.dogo_android.n.f fVar;
        Context context;
        String str2;
        str = "<this>";
        n.f(result, str);
        if (callback != null && result.getChildCount() > 0) {
            result.saveLastSelectedTag();
            ArrayList arrayList = new ArrayList(p.r(callback, 10));
            i = 0;
            Iterator it = callback.iterator();
            while (it.hasNext()) {
                i = i + 1;
                if (i < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
            result.hasGroupTagsChanged(arrayList);
            result.r();
            result.q(result.getLastSelectedId());
        }
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final void setArticleListTab(ImageView result, String callback) {
        int i = 1;
        n.f(result, "<this>");
        i = 1;
        i = 0;
        int r2 = i;
        if (i != 0) {
            m.a(result.getContext()).D(callback).y1(d.h()).p1(MyAppGlideModule.d(result.getContext())).C0(result);
        } else {
        }
        if (i == 0) {
            i = 8;
        }
        result.setVisibility(i);
    }

    public static final void g(RecyclerView recyclerView, LibrarySection librarySection, n.b bVar) {
        str = "<this>";
        n.f(recyclerView, str);
        if (librarySection != null && bVar != null && librarySection.getArticles() != null) {
            app.dogo.com.dogo_android.n.k.n articleListAdapter = new ArticleListAdapter(bVar);
            articleListAdapter.j(librarySection.getArticles());
            recyclerView.setAdapter(articleListAdapter);
            if (recyclerView.getItemDecorationCount() == 0) {
                Context context = recyclerView.getContext();
                str = "context";
                n.e(context, str);
                recyclerView.h(new LibrarySectionDecoration(context));
            }
        }
    }

    public static final void h(RecyclerView recyclerView, List<Article> list, n.b bVar) {
        int i = 0;
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && bVar != null && recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new ArticleListAdapter(bVar));
            bVar = recyclerView.getAdapter() instanceof ArticleListAdapter ? (ArticleListAdapter)recyclerView.getAdapter() : 0;
            if (i != 0) {
                i.j(list);
            }
            if (recyclerView.getItemDecorationCount() == 0) {
                Context context = recyclerView.getContext();
                str = "context";
                n.e(context, str);
                recyclerView.h(new LibrarySectionDecoration(context));
            }
        }
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final void setBigTimerDescriptionButton(ChipGroup elapsedTimeSeconds, Article goalSeconds) throws android.content.res.Resources.NotFoundException {
        int color;
        String str;
        List displayTags;
        n.f(elapsedTimeSeconds, "<this>");
        n.f(goalSeconds, "item");
        elapsedTimeSeconds.removeAllViews();
        displayTags = goalSeconds.getDisplayTags();
        int i = 2;
        if (displayTags.size() > i) {
            str = "+";
            boolean z = false;
            int i2 = 1;
            kotlin.d0.d.g gVar = null;
            str3 = "";
            LibraryTag libraryTag = new LibraryTag(z, n.o(str, Integer.valueOf(displayTags.size() - i)), str3, i2, gVar);
            displayTags = p.t0(p.F0(displayTags, i), p.b(libraryTag));
        }
        Iterator it = displayTags.iterator();
        while (it.hasNext()) {
            app.dogo.com.dogo_android.h.w wVar = w.T(LayoutInflater.from(elapsedTimeSeconds.getContext()), elapsedTimeSeconds, false);
            n.e(wVar, "inflate(inflater, this, false)");
            wVar.V((LibraryTag)it.next());
            elapsedTimeSeconds.addView(wVar.w());
            i = 2131100379;
            elapsedTimeSeconds.setBackgroundColor(elapsedTimeSeconds.getResources().getColor(i, null));
        }
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final void setLibraryProgramAdapter(TextView result, Article callback) throws android.content.res.Resources.NotFoundException {
        str = "<this>";
        n.f(result, str);
        if (callback != null) {
            android.content.res.Resources.Theme theme = null;
            if (callback.isRead()) {
                Drawable drawable = a.f(result.getContext(), 2131231065);
                int dimensionPixelSize = result.getResources().getDimensionPixelSize(2131165620);
                int i = 0;
                if (drawable != null) {
                    drawable.setBounds(i, i, dimensionPixelSize, dimensionPixelSize);
                }
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "check";
                str2 = "  ";
                String title2 = callback.getTitle();
                callback = str3 + str2 + title2;
                SpannableString spannableString = new SpannableString(callback);
                n.d(drawable);
                int i2 = 17;
                spannableString.setSpan(new ImageSpan(drawable, 1), i, 5, i2);
                result.setText(spannableString);
                result.setTextColor(result.getResources().getColor(2131099823, theme));
            } else {
                result.setText(callback.getTitle());
                result.setTextColor(result.getResources().getColor(2131099767, theme));
            }
        }
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final void setOvertimeLabel(Button elapsedTimeSeconds, Boolean goalSeconds) throws android.content.res.Resources.NotFoundException {
        int i = 2131886774;
        Object obj;
        str = "<this>";
        n.f(elapsedTimeSeconds, str);
        if (goalSeconds != null && goalSeconds.booleanValue()) {
            i = 2131887651;
            String string2 = elapsedTimeSeconds.getResources().getString(i);
            elapsedTimeSeconds.setText(obj);
        }
    }

    public static final void l(TextView textView, Long long, Long long2) {
        n.f(textView, "<this>");
        if (long != null && long2 != null) {
            boolean z = false;
            int i = 2;
            Object obj = null;
            textView.setText(Utilities_Companion.b(Utilities.Companion, g.f(long.longValue(), long2.longValue()), z, i, obj));
        }
    }

    /* renamed from: m, reason: from kotlin metadata */
    public static final void setupCtaText(TextView flowtype, TrickItem trainingTimeDuration) {
        str = "<this>";
        n.f(flowtype, str);
        if (trainingTimeDuration != null && trainingTimeDuration.isVariation()) {
            ProgramBindingAdapters.q0(flowtype, trainingTimeDuration.getDescription());
        }
    }

    public static final void n(View view, y<Library> yVar, g gVar, kl klVar, yk ykVar, gl glVar, wk wkVar, al alVar, il ilVar) {
        int i = 0;
        n.f(view, "<this>");
        n.f(klVar, "trickBinding");
        n.f(ykVar, "gameBinding");
        n.f(glVar, "skillsBinding");
        n.f(wkVar, "articleBinding");
        n.f(alVar, "programBinding");
        n.f(ilVar, "subscribeBanner");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && gVar != null) {
            Object component1 = yVar.component1();
            klVar.U(component1.getTrickSection());
            klVar.V(gVar);
            klVar.T(new LibraryBindingAdapters_setLibraryAdapter_1(gVar));
            ykVar.U(component1.getGamesSection());
            ykVar.V(gVar);
            ykVar.T(new LibraryBindingAdapters_setLibraryAdapter_2(gVar));
            glVar.U(component1.getSkillsSection());
            glVar.V(gVar);
            glVar.T(new LibraryBindingAdapters_setLibraryAdapter_3(gVar));
            wkVar.U(component1.getArticleSection());
            wkVar.V(gVar);
            wkVar.T(new LibraryBindingAdapters_setLibraryAdapter_4(gVar));
            alVar.U(component1.getProgramSection());
            alVar.V(gVar);
            alVar.T(new LibraryBindingAdapters_setLibraryAdapter_5(gVar));
            view = n.b(component1.isDogPremiumContentLocked(), Boolean.TRUE) ? 0 : 8;
            ilVar.w().setVisibility((n.b(component1.isDogPremiumContentLocked(), Boolean.TRUE) ? 0 : 8));
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    public static final void setupTrickDetailsPauseTime(MaterialToolbar textView, TrickItem.TrickCategory pauseTimeSec) throws android.content.res.Resources.NotFoundException {
        String str;
        int i2 = -808875034;
        int i3 = 0;
        Object obj;
        n.f(textView, "<this>");
        if (pauseTimeSec == null) {
            i3 = 0;
        } else {
            String id = pauseTimeSec.getId();
        }
        int i = 2131887623;
        if (i3 != 0) {
            int i4 = i3.hashCode();
            i2 = -808875034;
            if (i4 != -808875034) {
                i2 = -773789916;
                if (i4 != -773789916) {
                    i2 = -314563939;
                    if (i4 != -314563939) {
                        String string = textView.getResources().getString(i);
                    } else {
                        str = "id_games";
                        if (i3.equals(str)) {
                            i = 2131886667;
                            String string4 = textView.getResources().getString(i);
                        }
                    }
                } else {
                    str = "id_tricks";
                    if (i3.equals(str)) {
                        String string3 = textView.getResources().getString(i);
                    }
                }
            } else {
                str = "id_skills";
                if (i3.equals(str)) {
                    i = 2131886727;
                    String string2 = textView.getResources().getString(i);
                }
            }
        }
        textView.setTitle(obj);
    }

    public static final void p(ViewPager2 viewPager2, LibrarySection librarySection, b.a aVar) throws android.content.res.Resources.NotFoundException {
        String str2;
        int i = 0;
        String str3 = null;
        String str4;
        str = "<this>";
        n.f(viewPager2, str);
        if (librarySection != null && aVar != null) {
            int i2 = 0;
            if (librarySection.getProgramDescriptions() != null) {
                if (viewPager2.getItemDecorationCount() == 0) {
                    Context context = viewPager2.getContext();
                    str4 = "context";
                    n.e(context, str4);
                    viewPager2.a(new LibraryTrickDecoration(context));
                }
                if (viewPager2.getAdapter() == null) {
                    b programListCardAdapter = new ProgramListCardAdapter(aVar);
                    programListCardAdapter.j(librarySection.getProgramDescriptions());
                    viewPager2.setAdapter(programListCardAdapter);
                    int i3 = 3;
                    viewPager2.setOffscreenPageLimit(i3);
                }
                z = viewPager2.getAdapter() instanceof ProgramListCardAdapter;
                i = 0;
                aVar = viewPager2.getAdapter() instanceof ProgramListCardAdapter ? (ProgramListCardAdapter)viewPager2.getAdapter() : i;
                if (i != 0) {
                    Object obj = p.a0(i.getItemCount(), i2);
                    if (obj == null) {
                    } else {
                        str2 = obj.getId();
                    }
                    Object obj2 = p.a0(librarySection.getProgramDescriptions(), i2);
                    if (obj2 != null) {
                        str3 = obj2.getId();
                    }
                    i.j(librarySection.getProgramDescriptions());
                    if (!(n.b(str2, str3)) != 0) {
                        viewPager2.k(i2, false);
                    }
                }
                viewPager2.setPageTransformer(new kotlinx.coroutines.a(viewPager2.getResources().getDimensionPixelOffset(2131165629), viewPager2.getResources().getDimensionPixelOffset(2131165620)));
            } else {
                a.c("Invalid Library Section Item", new Object[i2]);
            }
        }
    }

    private static final void q(int i, int i2, View view, float f) {
        n.f(view, "page");
        ViewParent parent2 = view.getParent().getParent();
        Objects.requireNonNull(parent2, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        f *= f;
        if (parent2.getOrientation() != 0) {
            view.setTranslationY(f2);
        } else {
            int i3 = 1;
            if (u.B(parent2) == 1) {
                orientation = -f2;
                view.setTranslationX(orientation);
            } else {
                view.setTranslationX(f2);
            }
        }
    }

    /* renamed from: r, reason: from kotlin metadata */
    public static final void setupTrickDetailsToolbar(TextView compactView, TrickItem normalView) {
        boolean locked;
        int i = 0;
        Object obj;
        int i2 = 17;
        String str2;
        ImageSpan imageSpan;
        str = "<this>";
        n.f(compactView, str);
        if (normalView != null && normalView.getLocked()) {
            Drawable drawable = a.f(compactView.getContext(), 2131231191);
            i = 0;
            if (drawable != null) {
                drawable.setBounds(i, i, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "lock";
            str2 = "  ";
            String name2 = normalView.getName();
            normalView = str3 + str2 + name2;
            n.d(drawable);
            i2 = 17;
            new SpannableString(normalView).setSpan(new ImageSpan(drawable, 1), i, 4, i2);
            compactView.setText(obj);
        }
    }

    public static final void s(TextView textView, Long long, Long long2) {
        int i = 1;
        long value;
        long l;
        boolean z = false;
        int i2 = 2;
        Object obj = null;
        String str2 = null;
        str = "<this>";
        n.f(textView, str);
        if (long != null && long2 != null) {
            long value2 = long.longValue();
            value = long2.longValue();
            i = 0;
            int r0 = value2 > value ? 1 : 0;
            if (i != 0) {
                l = long.longValue() - long2.longValue();
                z = false;
                i2 = 2;
                obj = null;
                str2 = Utilities_Companion.b(Utilities.Companion, l, z, i2, obj);
            } else {
                int i3 = 0;
            }
            if (i == 0) {
                i = 8;
            }
            textView.setVisibility(i);
            str4 = "+";
            textView.setText(n.o(str4, str2));
        }
    }

    public static final void t(Button button, n.a aVar, String str) throws android.content.res.Resources.NotFoundException, NoWhenBranchMatchedException {
        int i = 1;
        int i2 = 2;
        int i3 = 0;
        Object obj;
        int i4 = 2131887251;
        str = "<this>";
        n.f(button, str);
        if (aVar != null) {
            int i5 = kotlinx.coroutines.f.a.a[aVar.ordinal()];
            i = 1;
            if (i5 != i) {
                i2 = 2;
                if (i5 != 2 && i5 == 3) {
                    i4 = 2131886685;
                    String string2 = button.getResources().getString(i4);
                }
                i2 = 2131887361;
                Object[] arr = new Object[i];
                i3 = 0;
                arr[i3] = str;
                String string3 = button.getResources().getString(i2, arr);
            } else {
                i4 = 2131887251;
                String string = button.getResources().getString(i4);
            }
            button.setText(obj);
        }
    }

    public static final void u(View view, Boolean boolean) {
        str = "<this>";
        n.f(view, str);
        if (boolean != null && boolean.booleanValue()) {
            view.setBackgroundColor(-1);
        }
    }

    public static final void v(View view, TextView textView, Long long) throws android.content.res.Resources.NotFoundException {
        n.f(view, "<this>");
        n.f(textView, "textView");
        if (long != null) {
            String string = view.getResources().getString(2131887028);
            n.e(string, "resources.getString(R.string.paused_title)");
            Object obj = null;
            String str6 = Utilities_Companion.b(Utilities.Companion, long.longValue(), false, 2, obj);
            StringBuilder stringBuilder = new StringBuilder();
            str3 = string + 32 + str6;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
            i = str3.length() - str6.length();
            int i2 = 33;
            spannableStringBuilder.setSpan(new TypefaceSpan("sans-serif-medium"), i, str3.length(), i2);
            int i3 = 2131100352;
            android.content.res.Resources.Theme theme = null;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(view.getResources().getColor(i3, theme)), i, str3.length(), i2);
            textView.setText(spannableStringBuilder);
            int i4 = 0;
            view.setVisibility(i4);
        } else {
            i4 = 8;
            view.setVisibility(i4);
        }
    }


    public static /* synthetic */ void d(int i, int i2, View view, float f) {
        LibraryBindingAdapters.q(i, i2, view, f);
    }
}
