package app.dogo.com.dogo_android.f;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.n;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import app.dogo.com.dogo_android.f.k.e;
import app.dogo.com.dogo_android.f.l.i;
import app.dogo.com.dogo_android.f.l.i.b;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.g.f0;
import app.dogo.com.dogo_android.m.c;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.n.m.u.j;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;
import app.dogo.com.dogo_android.repository.domain.TrickCover;
import app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.util.ViewPagerCustomDuration;
import app.dogo.com.dogo_android.util.c0;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.n0.r;
import app.dogo.com.dogo_android.util.n0.s;
import app.dogo.com.dogo_android.y.d0.n.a;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.w;

/* compiled from: TrainingBindingAdapters.kt */
@Metadata(d1 = "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u000c\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0014\u0010\u0010\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001e\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0016\u0010\u0017\u001a\u00020\u0004*\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J \u0010\u001b\u001a\u00020\u0004*\u00020\u00122\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J&\u0010\u001b\u001a\u00020\u0004*\u00020\u00122\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J8\u0010 \u001a\u00020\u0004*\u00020\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010\u0015\u001a\u0004\u0018\u00010'H\u0007J,\u0010(\u001a\u00020\u0004*\u00020\u00122\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u001c\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\"H\u0007J$\u0010)\u001a\u00020\u0004*\u00020\u00122\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020+H\u0007J(\u0010)\u001a\u00020\u0004*\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0008\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000202H\u0007JL\u00103\u001a\u00020\u0004*\u00020\u000f2\u0014\u0010\u001c\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002040\u001e\u0018\u00010\"2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010#\u001a\u00020$2\u0006\u00105\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J \u00106\u001a\u00020\u0004*\u00020\u00122\u0008\u0010\u001c\u001a\u0004\u0018\u00010.2\u0008\u0010\u0015\u001a\u0004\u0018\u000107H\u0007J\u001c\u00108\u001a\u00020\u0004*\u00020\u00122\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\"H\u0007J\u0014\u00109\u001a\u00020\u0004*\u00020\n2\u0006\u0010:\u001a\u00020\u0006H\u0007J\u0014\u0010;\u001a\u00020\u0004*\u00020\u00182\u0006\u0010\u000e\u001a\u00020<H\u0007¨\u0006=", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters;", "", "()V", "setArrowsVisibility", "", "position", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "backArrow", "Landroid/widget/ImageView;", "frontArrow", "goBack", "Landroid/view/View;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "goNext", "setDashboardTrickAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "recentlyViewedTricks", "Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "callback", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "setExamCardStatusText", "Landroid/widget/TextView;", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "setLibraryTrickAdapter", "result", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "setLibraryTrickVideoDetailsTab", "results", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;", "setSimpleTrickListAdapter", "setTrickAdapter", "list", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "Lapp/dogo/com/dogo_android/util/ViewPagerCustomDuration;", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "onSessionFinished", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "progressBar", "Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar;", "setVimeoVideoAdapter", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "textView", "setWorkoutCoverAdapter", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardCallback;", "setWorkoutOverviewAdapter", "setupRatingBarView", "rating", "skipTrick", "Landroidx/viewpager/widget/ViewPager;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class TrainingBindingAdapters {

    public static final i a = new i();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramExam_Status.values().length];
            iArr[ProgramExam_Status.PENDING.ordinal()] = 1;
            iArr[ProgramExam_Status.APPROVED.ordinal()] = 2;
            iArr[ProgramExam_Status.REJECTED.ordinal()] = 3;
            app.dogo.com.dogo_android.dailyworkout.i.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u000c", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setLibraryTrickVideoDetailsTab$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ViewPager2.i {

        final /* synthetic */ app.dogo.com.dogo_android.n.m.u.o a;
        final /* synthetic */ k b;
        b(app.dogo.com.dogo_android.n.m.u.o oVar, k kVar) {
            this.a = oVar;
            this.b = kVar;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                this.a.y();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int i = 0;
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            if (position == 0) {
                position = positionOffset == 0 ? 1 : 0;
                if (i != 0 && positionOffsetPixels == 0) {
                    this.a.y();
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (position != 0) {
                this.b.M();
            }
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setLibraryTrickVideoDetailsTab$2", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends ViewPager2.i {

        final /* synthetic */ k a;
        c(k kVar) {
            this.a = kVar;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (position != 0) {
                this.a.M();
            }
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u000c", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setVimeoVideoAdapter$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g extends ViewPager2.i {

        final /* synthetic */ app.dogo.com.dogo_android.m.d a;
        final /* synthetic */ TextView b;
        final /* synthetic */ List<GoodTrickExample> c;
        final /* synthetic */ ImageView d;
        final /* synthetic */ ImageView e;
        g(app.dogo.com.dogo_android.m.d dVar, TextView textView, List<GoodTrickExample> list, ImageView imageView, ImageView imageView2) {
            this.a = dVar;
            this.b = textView;
            this.c = list;
            this.d = imageView;
            this.e = imageView2;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                this.a.r();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int i = 0;
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            if (position == 0) {
                position = positionOffset == 0 ? 1 : 0;
                if (i != 0 && positionOffsetPixels == 0) {
                    this.a.r();
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            this.b.setText((GoodTrickExample)this.c.get(position).getDogName());
            TrainingBindingAdapters.a.setArrowsVisibility(position, this.a, this.d, this.e);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setTrickAdapter$2", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends ViewPager.n {

        final /* synthetic */ SegmentedProgressBar a;
        final /* synthetic */ i b;
        final /* synthetic */ ViewPagerCustomDuration c;
        final /* synthetic */ Runnable d;
        e(SegmentedProgressBar segmentedProgressBar, i iVar, ViewPagerCustomDuration viewPagerCustomDuration, Runnable runnable) {
            this.a = segmentedProgressBar;
            this.b = iVar;
            this.c = viewPagerCustomDuration;
            this.d = runnable;
            super();
        }

        @Override // androidx.viewpager.widget.ViewPager$n
        public void onPageSelected(int position) {
            int i;
            super.onPageSelected(position);
            this.a.setActiveSegmentPosition(position);
            i = 0;
            i = 1;
            int r0 = this.b.t() == position ? i : 0;
            if (this.b.t() < position) {
            }
            if (this.b != 0) {
                this.c.postDelayed(this.d, 500L);
            } else {
                if (i != 0) {
                    i2 = position - i;
                    this.c.N(i2, true);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ k $callback;
        final /* synthetic */ ViewPager2 $this_setLibraryTrickVideoDetailsTab;
        final /* synthetic */ TrickItem $trickItem;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            if (this.$this_setLibraryTrickVideoDetailsTab.getCurrentItem() != p.i(this.$trickItem.getVideoSteps())) {
                this.$callback.t0();
            }
        }

        d(ViewPager2 viewPager2, TrickItem trickItem, k kVar) {
            this.$this_setLibraryTrickVideoDetailsTab = viewPager2;
            this.$trickItem = trickItem;
            this.$callback = kVar;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "position", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements l<Integer, w> {

        final /* synthetic */ ViewPagerCustomDuration $this_setTrickAdapter;
        @Override // kotlin.d0.d.p
        public final void a(int i) {
            this.$this_setTrickAdapter.N(i, true);
        }

        f(ViewPagerCustomDuration viewPagerCustomDuration) {
            this.$this_setTrickAdapter = viewPagerCustomDuration;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ e0 $callback;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.$callback.p1();
        }

        h(e0 e0Var) {
            this.$callback = e0Var;
            super(0);
        }
    }
    private i() {
        super();
    }

    /* renamed from: A, reason: from kotlin metadata */
    private static final void goBack(i.b viewPager) {
        viewPager.m1();
    }

    public static final void B(ViewPager2 viewPager2, y<? extends List<GoodTrickExample>> yVar, c0 c0Var, TabLayout tabLayout, TextView textView, ImageView imageView, ImageView imageView2) {
        n.f(viewPager2, "<this>");
        n.f(tabLayout, "tabLayout");
        n.f(textView, "textView");
        n.f(imageView, "backArrow");
        n.f(imageView2, "frontArrow");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && c0Var != null) {
            yVar23 = yVar.component1();
            app.dogo.com.dogo_android.m.d vimeoVideoAdapter = new VimeoVideoAdapter(c0Var);
            vimeoVideoAdapter.q(yVar23);
            viewPager2.setAdapter(vimeoVideoAdapter);
            TrainingBindingAdapters_setVimeoVideoAdapter_1 yVar22 = new TrainingBindingAdapters_setVimeoVideoAdapter_1(vimeoVideoAdapter, textView, yVar23, imageView, imageView2);
            viewPager2.h(yVar22);
            new d(tabLayout, viewPager2, app.dogo.com.dogo_android.dailyworkout.g.a).a();
            Context context = viewPager2.getContext();
            str = "context";
            n.e(context, str);
            viewPager2.setPageTransformer(new CarouselEffectTransformer(viewPager2, context));
            viewPager2.setOffscreenPageLimit(1);
            viewPager2.a(new MarginItemDecoration());
        }
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static final void setTrickAdapter(RecyclerView workoutSession, WorkoutSession onSessionFinished, e0 progressBar) throws android.content.res.Resources.NotFoundException {
        int i = 2;
        ArrayList arrayList;
        int i2 = 0;
        int i5 = 3;
        TrickItem trickItem;
        int i6;
        TrickCover.CoverType tRICK2;
        TrickItem trickItem2;
        int i7;
        kotlin.d0.d.g gVar;
        TrickCover.CoverType tRICK22;
        int i8;
        kotlin.d0.d.g gVar2;
        TrickCover trickCover;
        TrickItem trickItem3 = null;
        int i9;
        TrickCover.CoverType uNDISPLAYED_TRICK2;
        int i10 = 1;
        kotlin.d0.d.g gVar3 = null;
        final Object workoutSession2 = workoutSession;
        final e0 progressBar2 = progressBar;
        str = "<this>";
        n.f(workoutSession2, str);
        if (onSessionFinished != null && progressBar2 != null && workoutSession.getLayoutManager() == null) {
            i2 = 0;
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(workoutSession.getContext(), i2);
            i = 2;
            flexboxLayoutManager.g3(i);
            workoutSession2.setLayoutManager(flexboxLayoutManager);
            if (workoutSession.getItemDecorationCount() == 0) {
                i2 = 2131165623;
                i = (int)workoutSession.getResources().getDimension(i2);
                workoutSession2.h(new LessonCardTrickCoverSpaceItemDecoration(i));
            }
            List list = p.O(onSessionFinished.getTrainingTricksList());
            int i11 = 10;
            i5 = 3;
            if (i5 >= list.size()) {
                List list2 = p.F0(list, i5);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    i6 = 0;
                    i7 = 2;
                    gVar = null;
                    i5 = new TrickCover((TrickItem)it.next(), i6, TrickCover_CoverType.TRICK, i7, gVar);
                    new ArrayList(p.r(list2, i11)).add(trickCover3);
                }
            } else {
                List list3 = p.F0(list, i5);
                ArrayList arrayList2 = new ArrayList(p.r(list3, i11));
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    i7 = 0;
                    i8 = 2;
                    gVar2 = null;
                    TrickCover trickCover2 = new TrickCover((TrickItem)it2.next(), i7, TrickCover_CoverType.TRICK, i8, gVar2);
                    arrayList2.add(trickCover2);
                }
                trickItem3 = null;
                i9 = list.size() - 3;
                i10 = 1;
                gVar3 = null;
                trickCover = new TrickCover(trickItem3, i9, TrickCover_CoverType.UNDISPLAYED_TRICK, i10, gVar3);
                List list4 = p.u0(arrayList2, trickCover);
            }
            workoutSession2.setAdapter(new WorkoutCardTrickCoverGridAdapter(arrayList, new app.dogo.com.dogo_android.dailyworkout.i.h(progressBar2)));
        }
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static final void setLibraryTrickAdapter(RecyclerView result, y<WorkoutSession> callback) throws android.content.res.Resources.NotFoundException {
        int itemDecorationCount = 0;
        n.f(result, "<this>");
        z = callback instanceof LoadResult_Success;
        itemDecorationCount = 0;
        callback = callback instanceof oadResult_Success ? (oadResult_Success)callback : 0;
        if (itemDecorationCount != 0) {
            Object component1 = itemDecorationCount.component1();
            if (component1 != null) {
                if (result.getAdapter() == null) {
                    result.setAdapter(new DailyWorkoutOverviewAdapter());
                }
                RecyclerView.h adapter2 = result.getAdapter();
                z2 = adapter2 instanceof DailyWorkoutOverviewAdapter;
                if (adapter2 instanceof DailyWorkoutOverviewAdapter) {
                }
                if (itemDecorationCount != 0) {
                    itemDecorationCount.i(p.O(component1.getTrainingTricksList()));
                }
                if (result.getItemDecorationCount() == 0) {
                    result.h(new GridSpacesItemDecoration(result.getResources().getDimensionPixelSize(2131165638)));
                }
            }
        }
    }

    /* renamed from: F, reason: from kotlin metadata */
    public static final void setLibraryTrickAdapter(ImageView result, int callback) {
        int i2 = 2131231271;
        n.f(result, "<this>");
        int i = 1;
        if (callback == 1) {
            i2 = 2131231271;
        } else {
            i = 2;
            if (callback == 2) {
                i2 = 2131231272;
            } else {
                i = 3;
                if (callback == 3) {
                    i2 = 2131231273;
                } else {
                    i = 4;
                    if (callback != 4) {
                        i = 5;
                        callback = callback != 5 ? R.drawable.progress_0 : R.drawable.progress_5;
                    } else {
                        callback = 2131231274;
                    }
                }
            }
        }
        result.setImageResource((callback != 5 ? R.drawable.progress_0 : R.drawable.progress_5));
    }

    public static final /* synthetic */ void a(i iVar, int i, RecyclerView.h hVar, ImageView imageView, ImageView imageView2) {
        iVar.setArrowsVisibility(i, hVar, imageView, imageView2);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final void setSimpleTrickListAdapter(View callback, ViewPager2 result) {
        n.f(callback, "<this>");
        n.f(result, "viewPager");
        callback.setOnClickListener(new app.dogo.com.dogo_android.dailyworkout.b(result));
    }

    /* renamed from: c, reason: from kotlin metadata */
    private static final void setTrickAdapter(ViewPager2 list, View callback) {
        n.f(list, "$viewPager");
        final int i = 1;
        list.k(list.getCurrentItem() - i, true);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static final void setWorkoutCoverAdapter(View result, ViewPager2 callback) {
        n.f(result, "<this>");
        n.f(callback, "viewPager");
        result.setOnClickListener(new app.dogo.com.dogo_android.dailyworkout.a(callback));
    }

    private static final void e(ViewPager2 viewPager2, View view) {
        n.f(viewPager2, "$viewPager");
        final int i = 1;
        viewPager2.k(viewPager2.getCurrentItem() + i, true);
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void setArrowsVisibility(int position, RecyclerView.h<?> adapter, ImageView backArrow, ImageView frontArrow) {
        final int i2 = 1;
        final int i3 = 4;
        if (adapter.getItemCount() == i2) {
            backArrow.setVisibility(i3);
            frontArrow.setVisibility(i3);
        } else {
            int itemCount = 0;
            if (position == 0) {
                backArrow.setVisibility(i3);
                frontArrow.setVisibility(itemCount);
            } else {
                i = adapter.getItemCount() - i2;
                if (position == adapter.getItemCount() - i2) {
                    backArrow.setVisibility(itemCount);
                    frontArrow.setVisibility(i3);
                } else {
                    backArrow.setVisibility(itemCount);
                    frontArrow.setVisibility(itemCount);
                }
            }
        }
    }

    public static final void o(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks, o.a aVar) {
        int i = 0;
        String str;
        n.f(recyclerView, "<this>");
        n.f(recentlyViewedTricks, "recentlyViewedTricks");
        if (recentlyViewedTricks.getTrickList() != null && aVar != null && recyclerView.getItemDecorationCount() == 0) {
            Context context = recyclerView.getContext();
            str = "context";
            n.e(context, str);
            recyclerView.h(new LibraryTrickDecoration(context));
            i = 0;
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(new TrickListAdapter(aVar));
                RecyclerView.h aVar32 = recyclerView.getAdapter();
                if (aVar32 instanceof TrickListAdapter) {
                }
                if (i != 0) {
                    i.j(recentlyViewedTricks.getTrickList());
                }
                try {
                    recyclerView.postDelayed(new app.dogo.com.dogo_android.dailyworkout.f(recyclerView, recentlyViewedTricks), 0L);
                } catch (Exception e) {
                    a.d(e);
                }
            } else {
                RecyclerView.h recyclerView2 = e.getAdapter();
                z = recyclerView2 instanceof TrickListAdapter;
                if (recyclerView2 instanceof TrickListAdapter) {
                }
                if (i != 0) {
                    i.j(recentlyViewedTricks.getTrickList());
                }
            }
        }
    }

    private static final void p(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks) {
        int value;
        n.f(recyclerView, "$this_setDashboardTrickAdapter");
        n.f(recentlyViewedTricks, "$recentlyViewedTricks");
        Integer scrollPosition = recentlyViewedTricks.getScrollPosition();
        value = 0;
        if (scrollPosition == null) {
        } else {
            value = scrollPosition.intValue();
        }
        recyclerView.scrollBy(value, value);
    }

    public static final void q(TextView textView, ProgramExam programExam) {
        int ordinal = 0;
        int i2;
        Object obj;
        int color;
        n.f(textView, "<this>");
        ordinal = 0;
        if (programExam == null) {
        } else {
            ProgramExam.Status status2 = programExam.getStatus();
        }
        i2 = -1;
        if (ordinal == 0) {
        } else {
            i2 = app.dogo.com.dogo_android.dailyworkout.i.a.a[ordinal.ordinal()];
        }
        int i4 = 3;
        final int i5 = 2;
        final int i6 = 1;
        if (i2 == i6) {
            int i3 = 2131886574;
            String string = textView.getContext().getString(i3);
        } else {
            if (i2 == i5) {
                i3 = 2131886551;
                String string2 = textView.getContext().getString(i3);
            } else {
                if (i2 != i4) {
                    String str2 = "";
                } else {
                    i3 = 2131887181;
                    String string3 = textView.getContext().getString(i3);
                }
            }
        }
        textView.setText(obj);
        if (programExam != null) {
            ProgramExam.Status status = programExam.getStatus();
        }
        if (ordinal != 0) {
            i2 = app.dogo.com.dogo_android.dailyworkout.i.a.a[ordinal.ordinal()];
        }
        if (i2 == i6) {
            int i = 2131099839;
            color = textView.getContext().getColor(i);
        } else {
            if (i2 == i5) {
                i = 2131100352;
                color = textView.getContext().getColor(i);
            } else {
                if (i2 != i4) {
                    i = 2131100379;
                    color = textView.getContext().getColor(i);
                } else {
                    i = 2131100376;
                    color = textView.getContext().getColor(i);
                }
            }
        }
        textView.setTextColor(color);
    }

    public static final void r(RecyclerView recyclerView, LibrarySection librarySection, o.a aVar) {
        RecyclerView.h adapter;
        Context context;
        String str2;
        int i = 0;
        str = "<this>";
        n.f(recyclerView, str);
        if (librarySection != null && aVar != null && librarySection.getTricks() != null && recyclerView.getItemDecorationCount() == 0) {
            context = recyclerView.getContext();
            str2 = "context";
            n.e(context, str2);
            recyclerView.h(new LibraryTrickDecoration(context));
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(new TrickListAdapter(aVar));
            }
            z = recyclerView.getAdapter() instanceof TrickListAdapter;
            recyclerView = recyclerView.getAdapter() instanceof TrickListAdapter ? (TrickListAdapter)recyclerView.getAdapter() : 0;
            if (i != 0) {
                i.j(librarySection.getTricks());
            }
        }
    }

    public static final void s(RecyclerView recyclerView, List<TrickItem> list, o.a aVar) {
        int i = 0;
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && aVar != null && recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new TrickListAdapter(aVar));
            i = 0;
            aVar = recyclerView.getAdapter() instanceof TrickListAdapter ? (TrickListAdapter)recyclerView.getAdapter() : 0;
            if (i != 0) {
                i.j(list);
            }
            androidx.recyclerview.widget.RecyclerView.p list22 = recyclerView.getLayoutManager();
            z = list22 instanceof GridLayoutManager;
            if (list22 instanceof GridLayoutManager) {
            }
            if (i != 0) {
                int i2 = 2;
                i.z3(i2);
            }
            if (recyclerView.getItemDecorationCount() == 0) {
                int i3 = 0;
                recyclerView.measure(i3, i3);
                recyclerView.h(new LibrarySpacesItemDecoration());
            }
        }
    }

    public static final void t(ViewPager2 viewPager2, y<TrickItem> yVar, TabLayout tabLayout, c0 c0Var, k kVar) {
        TrickItem trickItem = null;
        int i;
        Object yVar22;
        n.f(viewPager2, "<this>");
        n.f(tabLayout, "tabLayout");
        z = yVar instanceof LoadResult_Success;
        yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
        }
        if (trickItem != null && kVar != null && viewPager2.getAdapter() == null && c0Var != null && trickItem.getVimeoData() != null) {
            app.dogo.com.dogo_android.n.m.u.o videoTrickDetailsAdapter = new VideoTrickDetailsAdapter(trickItem.getVideoSteps(), trickItem.getVimeoData().getVideoUrl(), c0Var, new app.dogo.com.dogo_android.dailyworkout.i.d(viewPager2, trickItem, kVar));
            viewPager2.setAdapter(videoTrickDetailsAdapter);
            viewPager2.h(new TrainingBindingAdapters_setLibraryTrickVideoDetailsTab_1(videoTrickDetailsAdapter, kVar));
            new d(tabLayout, viewPager2, app.dogo.com.dogo_android.dailyworkout.e.a).a();
            viewPager2.setCurrentItem(0);
            viewPager2.setOffscreenPageLimit(1);
        }
    }

    public static final void w(RecyclerView recyclerView, o.a aVar, y<? extends List<TrickItem>> yVar) {
        int i = 0;
        RecyclerView.h adapter2;
        n.f(recyclerView, "<this>");
        z = yVar instanceof LoadResult_Success;
        i = 0;
        yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : i;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                if (aVar != null && recyclerView.getAdapter() == null) {
                    recyclerView.setAdapter(new TrickListAdapter(aVar));
                    z = recyclerView.getAdapter() instanceof TrickListAdapter;
                    aVar = recyclerView.getAdapter() instanceof TrickListAdapter ? (TrickListAdapter)recyclerView.getAdapter() : i;
                    if (adapter2 != null) {
                        adapter2.j(component1);
                    }
                    androidx.recyclerview.widget.RecyclerView.p aVar22 = recyclerView.getLayoutManager();
                    if (aVar22 instanceof GridLayoutManager) {
                    }
                    if (i != 0) {
                        int i2 = 2;
                        i.z3(i2);
                    }
                    if (recyclerView.getItemDecorationCount() == 0) {
                        int i3 = 0;
                        recyclerView.measure(i3, i3);
                        recyclerView.h(new LibrarySpacesItemDecoration());
                    }
                }
            }
        }
    }

    public static final void x(RecyclerView recyclerView, List<TrickItem> list, n.a aVar) {
        int i;
        int size;
        int i2 = 0;
        n.f(recyclerView, "<this>");
        str = "callback";
        n.f(aVar, str);
        if (list != null) {
            app.dogo.com.dogo_android.y.d0.n programTrainingPlanTrickAdapter = new ProgramTrainingPlanTrickAdapter(aVar);
            programTrainingPlanTrickAdapter.j(list);
            aVar = recyclerView.getLayoutManager() instanceof GridLayoutManager ? (GridLayoutManager)recyclerView.getLayoutManager() : 0;
            if (i2 != 0) {
                i = 1;
                if (list.size() != 1) {
                    i = 2;
                }
                i2.z3(i);
            }
            recyclerView.setAdapter(programTrainingPlanTrickAdapter);
        }
    }

    /* renamed from: y, reason: from kotlin metadata */
    public static final void setLibraryTrickVideoDetailsTab(ViewPagerCustomDuration results, WorkoutSession tabLayout, i.b videoPlayerFactory, SegmentedProgressBar callback) throws android.content.res.Resources.NotFoundException {
        n.f(results, "<this>");
        str = "progressBar";
        n.f(callback, str);
        if (tabLayout != null && videoPlayerFactory != null) {
            i dailyWorkoutAdapter = new DailyWorkoutAdapter(new app.dogo.com.dogo_android.dailyworkout.i.f(results), videoPlayerFactory, tabLayout.getTrainingTricksList());
            results.setAdapter(dailyWorkoutAdapter);
            results.setOffscreenPageLimit(2);
            results.Q(false, app.dogo.com.dogo_android.dailyworkout.h.a);
            int i = 2131165618;
            results.setPageMargin(a.b(results.getResources().getDimension(i)));
            callback.setSegmentCount(tabLayout.getTrainingTricksList().size());
            results.c(new TrainingBindingAdapters_setTrickAdapter_2(callback, dailyWorkoutAdapter, results, new app.dogo.com.dogo_android.dailyworkout.c(videoPlayerFactory)));
            double d = 3d;
            results.setScrollDurationFactor(d);
        }
    }

    private static final void z(View view, float f) {
        n.f(view, "page");
        view.setAlpha((float)1 - Math.abs(f));
    }


    /* renamed from: C, reason: from kotlin metadata */
    private static final void setDashboardTrickAdapter(TabLayout.g recentlyViewedTricks, int callback) {
        n.f(recentlyViewedTricks, "$noName_0");
    }

    public static /* synthetic */ void f(ViewPager2 viewPager2, View view) {
        TrainingBindingAdapters.e(viewPager2, view);
    }

    public static /* synthetic */ void g(ViewPager2 viewPager2, View view) {
        TrainingBindingAdapters.setTrickAdapter(viewPager2, view);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static /* synthetic */ void goNext(i.b viewPager) {
        TrainingBindingAdapters.goBack(viewPager);
    }

    public static /* synthetic */ void i(TabLayout.g gVar, int i) {
        TrainingBindingAdapters.v(gVar, i);
    }

    public static /* synthetic */ void j(TabLayout.g gVar, int i) {
        TrainingBindingAdapters.u(gVar, i);
    }

    public static /* synthetic */ void k(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks) {
        TrainingBindingAdapters.p(recyclerView, recentlyViewedTricks);
    }

    public static /* synthetic */ void l(TabLayout.g gVar, int i) {
        TrainingBindingAdapters.setDashboardTrickAdapter(gVar, i);
    }

    public static /* synthetic */ void m(View view, float f) {
        TrainingBindingAdapters.z(view, f);
    }

    private static final void u(TabLayout.g gVar, int i) {
        n.f(gVar, "$noName_0");
    }

    private static final void v(TabLayout.g gVar, int i) {
        n.f(gVar, "$noName_0");
    }
}
