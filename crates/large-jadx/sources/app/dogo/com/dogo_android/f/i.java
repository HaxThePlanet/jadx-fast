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
import app.dogo.com.dogo_android.m.a;
import app.dogo.com.dogo_android.m.c;
import app.dogo.com.dogo_android.m.d;
import app.dogo.com.dogo_android.n.m.o;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.n.m.u.j;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.n.m.u.o;
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
import app.dogo.com.dogo_android.util.n0.n;
import app.dogo.com.dogo_android.util.n0.o;
import app.dogo.com.dogo_android.util.n0.r;
import app.dogo.com.dogo_android.util.n0.s;
import app.dogo.com.dogo_android.y.d0.n;
import app.dogo.com.dogo_android.y.d0.n.a;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import com.google.android.material.tabs.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.e0.a;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u000c\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0014\u0010\u0010\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001e\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0016\u0010\u0017\u001a\u00020\u0004*\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J \u0010\u001b\u001a\u00020\u0004*\u00020\u00122\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J&\u0010\u001b\u001a\u00020\u0004*\u00020\u00122\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J8\u0010 \u001a\u00020\u0004*\u00020\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010\u0015\u001a\u0004\u0018\u00010'H\u0007J,\u0010(\u001a\u00020\u0004*\u00020\u00122\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u001c\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\"H\u0007J$\u0010)\u001a\u00020\u0004*\u00020\u00122\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020+H\u0007J(\u0010)\u001a\u00020\u0004*\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0008\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000202H\u0007JL\u00103\u001a\u00020\u0004*\u00020\u000f2\u0014\u0010\u001c\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002040\u001e\u0018\u00010\"2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010#\u001a\u00020$2\u0006\u00105\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J \u00106\u001a\u00020\u0004*\u00020\u00122\u0008\u0010\u001c\u001a\u0004\u0018\u00010.2\u0008\u0010\u0015\u001a\u0004\u0018\u000107H\u0007J\u001c\u00108\u001a\u00020\u0004*\u00020\u00122\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\"H\u0007J\u0014\u00109\u001a\u00020\u0004*\u00020\n2\u0006\u0010:\u001a\u00020\u0006H\u0007J\u0014\u0010;\u001a\u00020\u0004*\u00020\u00182\u0006\u0010\u000e\u001a\u00020<H\u0007¨\u0006=", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters;", "", "()V", "setArrowsVisibility", "", "position", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "backArrow", "Landroid/widget/ImageView;", "frontArrow", "goBack", "Landroid/view/View;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "goNext", "setDashboardTrickAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "recentlyViewedTricks", "Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "callback", "Lapp/dogo/com/dogo_android/library/tricks/TrickListAdapter$Callback;", "setExamCardStatusText", "Landroid/widget/TextView;", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "setLibraryTrickAdapter", "result", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "setLibraryTrickVideoDetailsTab", "results", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;", "setSimpleTrickListAdapter", "setTrickAdapter", "list", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "Lapp/dogo/com/dogo_android/util/ViewPagerCustomDuration;", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "onSessionFinished", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "progressBar", "Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar;", "setVimeoVideoAdapter", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "textView", "setWorkoutCoverAdapter", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardCallback;", "setWorkoutOverviewAdapter", "setupRatingBarView", "rating", "skipTrick", "Landroidx/viewpager/widget/ViewPager;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i {

    public static final app.dogo.com.dogo_android.f.i a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramExam.Status.PENDING.ordinal()] = 1;
            iArr[ProgramExam.Status.APPROVED.ordinal()] = 2;
            iArr[ProgramExam.Status.REJECTED.ordinal()] = 3;
            i.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u000c", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setLibraryTrickVideoDetailsTab$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ViewPager2.i {

        final o a;
        final k b;
        b(o o, k k2) {
            this.a = o;
            this.b = k2;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int i) {
            int obj1;
            super.onPageScrollStateChanged(i);
            if (i == 0) {
                this.a.y();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrolled(int i, float f2, int i3) {
            int obj1;
            super.onPageScrolled(i, f2, i3);
            if (i == 0) {
                obj1 = Float.compare(f2, obj1) == 0 ? 1 : 0;
                if (obj1 != null && i3 == 0) {
                    if (i3 == 0) {
                        this.a.y();
                    }
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            int obj1;
            super.onPageSelected(i);
            if (i != 0) {
                this.b.M();
            }
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setLibraryTrickVideoDetailsTab$2", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends ViewPager2.i {

        final k a;
        c(k k) {
            this.a = k;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            int obj1;
            super.onPageSelected(i);
            if (i != 0) {
                this.a.M();
            }
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u000c", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setVimeoVideoAdapter$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g extends ViewPager2.i {

        final d a;
        final TextView b;
        final List<GoodTrickExample> c;
        final ImageView d;
        final ImageView e;
        g(d d, TextView textView2, List<GoodTrickExample> list3, ImageView imageView4, ImageView imageView5) {
            this.a = d;
            this.b = textView2;
            this.c = list3;
            this.d = imageView4;
            this.e = imageView5;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int i) {
            int obj1;
            super.onPageScrollStateChanged(i);
            if (i == 0) {
                this.a.r();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrolled(int i, float f2, int i3) {
            int obj1;
            super.onPageScrolled(i, f2, i3);
            if (i == 0) {
                obj1 = Float.compare(f2, obj1) == 0 ? 1 : 0;
                if (obj1 != null && i3 == 0) {
                    if (i3 == 0) {
                        this.a.r();
                    }
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            this.b.setText((GoodTrickExample)this.c.get(i).getDogName());
            i.a(i.a, i, this.a, this.d, this.e);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/dailyworkout/TrainingBindingAdapters$setTrickAdapter$2", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends ViewPager.n {

        final SegmentedProgressBar a;
        final i b;
        final ViewPagerCustomDuration c;
        final Runnable d;
        e(SegmentedProgressBar segmentedProgressBar, i i2, ViewPagerCustomDuration viewPagerCustomDuration3, Runnable runnable4) {
            this.a = segmentedProgressBar;
            this.b = i2;
            this.c = viewPagerCustomDuration3;
            this.d = runnable4;
            super();
        }

        @Override // androidx.viewpager.widget.ViewPager$n
        public void onPageSelected(int i) {
            int i2;
            int i3;
            int obj5;
            super.onPageSelected(i);
            this.a.setActiveSegmentPosition(i);
            final int i5 = 1;
            i2 = this.b.t() == i ? i5 : i3;
            if (this.b.t() < i) {
                i3 = i5;
            }
            if (i2 != 0) {
                this.c.postDelayed(this.d, 500);
            } else {
                if (i3 != 0) {
                    this.c.N(i -= i5, i5);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final k $callback;
        final ViewPager2 $this_setLibraryTrickVideoDetailsTab;
        final TrickItem $trickItem;
        d(ViewPager2 viewPager2, TrickItem trickItem2, k k3) {
            this.$this_setLibraryTrickVideoDetailsTab = viewPager2;
            this.$trickItem = trickItem2;
            this.$callback = k3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            int currentItem;
            if (this.$this_setLibraryTrickVideoDetailsTab.getCurrentItem() != p.i(this.$trickItem.getVideoSteps())) {
                this.$callback.t0();
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "position", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<Integer, w> {

        final ViewPagerCustomDuration $this_setTrickAdapter;
        f(ViewPagerCustomDuration viewPagerCustomDuration) {
            this.$this_setTrickAdapter = viewPagerCustomDuration;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(int i) {
            this.$this_setTrickAdapter.N(i, true);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((Number)object.intValue());
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements a<w> {

        final e0 $callback;
        h(e0 e0) {
            this.$callback = e0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.$callback.p1();
        }
    }
    static {
        i iVar = new i();
        i.a = iVar;
    }

    private static final void A(i.b i$b) {
        b.m1();
    }

    public static final void B(ViewPager2 viewPager2, y<? extends List<GoodTrickExample>> y2, c0 c03, TabLayout tabLayout4, TextView textView5, ImageView imageView6, ImageView imageView7) {
        boolean z;
        d dVar;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj7;
        Object obj8;
        Object obj9;
        n.f(viewPager2, "<this>");
        n.f(tabLayout4, "tabLayout");
        n.f(textView5, "textView");
        n.f(imageView6, "backArrow");
        n.f(imageView7, "frontArrow");
        if (y2 instanceof y.c && c03 != null) {
            if (c03 != null) {
                obj2 = obj7;
                dVar = new d(c03);
                dVar.q((List)obj2);
                viewPager2.setAdapter(dVar);
                super(dVar, textView5, obj2, imageView6, imageView7);
                viewPager2.h(obj7);
                obj7 = new d(tabLayout4, viewPager2, g.a);
                obj7.a();
                obj8 = viewPager2.getContext();
                n.e(obj8, "context");
                obj7 = new a(viewPager2, obj8);
                viewPager2.setPageTransformer(obj7);
                viewPager2.setOffscreenPageLimit(1);
                obj7 = new c();
                viewPager2.a(obj7);
            }
        }
    }

    private static final void C(TabLayout.g tabLayout$g, int i2) {
        n.f(g, "$noName_0");
    }

    public static final void D(RecyclerView recyclerView, WorkoutSession workoutSession2, e0 e03) {
        Object flexboxLayoutManager;
        int itemDecorationCount;
        Iterator iterator;
        Object f0Var;
        int arrayList;
        int hVar;
        boolean next;
        int trickCover;
        int trickCover3;
        int i4;
        Object arrayList2;
        int i9;
        Object tRICK;
        int i2;
        int tRICK2;
        int i3;
        int i6;
        TrickCover trickCover2;
        int i5;
        int i;
        TrickCover.CoverType uNDISPLAYED_TRICK;
        int i8;
        int i7;
        final Object obj = recyclerView;
        final e0 e0Var = e03;
        n.f(obj, "<this>");
        if (workoutSession2 != null && e0Var != null && recyclerView.getLayoutManager() == null) {
            if (e0Var != null) {
                if (recyclerView.getLayoutManager() == null) {
                    flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext(), 0);
                    flexboxLayoutManager.g3(2);
                    obj.setLayoutManager(flexboxLayoutManager);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    itemDecorationCount = new o((int)dimension);
                    obj.h(itemDecorationCount);
                }
                List list = p.O(workoutSession2.getTrainingTricksList());
                int i10 = 10;
                i4 = 3;
                if (i4 >= list.size()) {
                    List list2 = p.F0(list, i4);
                    arrayList = new ArrayList(p.r(list2, i10));
                    iterator = list2.iterator();
                    for (Object next2 : iterator) {
                        super((TrickItem)next2, 0, TrickCover.CoverType.TRICK, 2, 0);
                        arrayList.add(trickCover);
                    }
                } else {
                    List list3 = p.F0(list, i4);
                    arrayList2 = new ArrayList(p.r(list3, i10));
                    Iterator iterator2 = list3.iterator();
                    for (Object next3 : iterator2) {
                        super((TrickItem)next3, 0, TrickCover.CoverType.TRICK, 2, 0);
                        arrayList2.add(trickCover3);
                    }
                    super(0, iterator + -3, TrickCover.CoverType.UNDISPLAYED_TRICK, 1, 0);
                    arrayList = p.u0(arrayList2, trickCover4);
                }
                hVar = new i.h(e0Var);
                f0Var = new f0(arrayList, hVar);
                obj.setAdapter(f0Var);
            }
        }
    }

    public static final void E(RecyclerView recyclerView, y<WorkoutSession> y2) {
        RecyclerView.h eVar;
        boolean nVar;
        int i;
        boolean z;
        Object obj4;
        n.f(recyclerView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj4 = i;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.a();
            if ((WorkoutSession)obj4 == null) {
            } else {
                if (recyclerView.getAdapter() == null) {
                    eVar = new e();
                    recyclerView.setAdapter(eVar);
                }
                nVar = recyclerView.getAdapter();
                if (nVar instanceof e) {
                    i = nVar;
                }
                if (i == 0) {
                } else {
                    i.i(p.O((WorkoutSession)obj4.getTrainingTricksList()));
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    nVar = new n(recyclerView.getResources().getDimensionPixelSize(2131165638));
                    recyclerView.h(nVar);
                }
            }
        }
    }

    public static final void F(ImageView imageView, int i2) {
        int i;
        int obj2;
        n.f(imageView, "<this>");
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        obj2 = i2 != 5 ? R.drawable.progress_0 : R.drawable.progress_5;
                    } else {
                        obj2 = 2131231274;
                    }
                } else {
                    obj2 = 2131231273;
                }
            } else {
                obj2 = 2131231272;
            }
        } else {
            obj2 = 2131231271;
        }
        imageView.setImageResource(obj2);
    }

    public static final void a(app.dogo.com.dogo_android.f.i i, int i2, RecyclerView.h recyclerView$h3, ImageView imageView4, ImageView imageView5) {
        i.n(i2, h3, imageView4, imageView5);
    }

    public static final void b(View view, ViewPager2 viewPager22) {
        n.f(view, "<this>");
        n.f(viewPager22, "viewPager");
        b bVar = new b(viewPager22);
        view.setOnClickListener(bVar);
    }

    private static final void c(ViewPager2 viewPager2, View view2) {
        n.f(viewPager2, "$viewPager");
        final int i = 1;
        viewPager2.k(obj2 -= i, i);
    }

    public static final void d(View view, ViewPager2 viewPager22) {
        n.f(view, "<this>");
        n.f(viewPager22, "viewPager");
        a aVar = new a(viewPager22);
        view.setOnClickListener(aVar);
    }

    private static final void e(ViewPager2 viewPager2, View view2) {
        n.f(viewPager2, "$viewPager");
        final int i = 1;
        viewPager2.k(obj2 += i, i);
    }

    public static void f(ViewPager2 viewPager2, View view2) {
        i.e(viewPager2, view2);
    }

    public static void g(ViewPager2 viewPager2, View view2) {
        i.c(viewPager2, view2);
    }

    public static void h(i.b i$b) {
        i.A(b);
    }

    public static void i(TabLayout.g tabLayout$g, int i2) {
        i.v(g, i2);
    }

    public static void j(TabLayout.g tabLayout$g, int i2) {
        i.u(g, i2);
    }

    public static void k(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks2) {
        i.p(recyclerView, recentlyViewedTricks2);
    }

    public static void l(TabLayout.g tabLayout$g, int i2) {
        i.C(g, i2);
    }

    public static void m(View view, float f2) {
        i.z(view, f2);
    }

    private final void n(int i, RecyclerView.h<?> recyclerView$h2, ImageView imageView3, ImageView imageView4) {
        int itemCount;
        int obj5;
        final int i2 = 1;
        final int i3 = 4;
        if (h2.getItemCount() == i2) {
            imageView3.setVisibility(i3);
            imageView4.setVisibility(i3);
        } else {
            itemCount = 0;
            if (i == 0) {
                imageView3.setVisibility(i3);
                imageView4.setVisibility(itemCount);
            } else {
                if (i == obj5 -= i2) {
                    imageView3.setVisibility(itemCount);
                    imageView4.setVisibility(i3);
                } else {
                    imageView3.setVisibility(itemCount);
                    imageView4.setVisibility(itemCount);
                }
            }
        }
    }

    public static final void o(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks2, o.a o$a3) {
        List trickList;
        int itemDecorationCount;
        int context;
        String str;
        Object obj3;
        o.a obj5;
        n.f(recyclerView, "<this>");
        n.f(recentlyViewedTricks2, "recentlyViewedTricks");
        if (recentlyViewedTricks2.getTrickList() != null && a3 != null && recyclerView.getItemDecorationCount() == 0) {
            if (a3 != null) {
                if (recyclerView.getItemDecorationCount() == 0) {
                    context = recyclerView.getContext();
                    n.e(context, "context");
                    itemDecorationCount = new s(context);
                    recyclerView.h(itemDecorationCount);
                }
                context = 0;
                if (recyclerView.getAdapter() == null) {
                    o oVar = new o(a3);
                    recyclerView.setAdapter(oVar);
                    obj5 = recyclerView.getAdapter();
                    if (obj5 instanceof o) {
                        context = obj5;
                    }
                    if (context == null) {
                    } else {
                        context.j(recentlyViewedTricks2.getTrickList());
                    }
                    obj5 = new f(recyclerView, recentlyViewedTricks2);
                    recyclerView.postDelayed(obj5, 0);
                } else {
                    obj3 = recyclerView.getAdapter();
                    if (obj3 instanceof o) {
                        context = obj3;
                    }
                    if (context == null) {
                    } else {
                        context.j(recentlyViewedTricks2.getTrickList());
                    }
                }
            }
        }
    }

    private static final void p(RecyclerView recyclerView, RecentlyViewedTricks recentlyViewedTricks2) {
        int obj2;
        n.f(recyclerView, "$this_setDashboardTrickAdapter");
        n.f(recentlyViewedTricks2, "$recentlyViewedTricks");
        obj2 = recentlyViewedTricks2.getScrollPosition();
        int i = 0;
        if (obj2 == null) {
            obj2 = i;
        } else {
            obj2 = obj2.intValue();
        }
        recyclerView.scrollBy(obj2, i);
    }

    public static final void q(TextView textView, ProgramExam programExam2) {
        int ordinal;
        int i4;
        int status;
        int i;
        String string;
        int i2;
        int[] iArr;
        int i3;
        int[] obj8;
        n.f(textView, "<this>");
        if (programExam2 == null) {
            status = ordinal;
        } else {
            status = programExam2.getStatus();
        }
        if (status == 0) {
            i = i2;
        } else {
            i = i.a.a[status.ordinal()];
        }
        int i5 = 3;
        final int i6 = 2;
        final int i7 = 1;
        if (i != i7) {
            if (i != i6) {
                if (i != i5) {
                    string = "";
                } else {
                    string = textView.getContext().getString(2131887181);
                }
            } else {
                string = textView.getContext().getString(2131886551);
            }
        } else {
            string = textView.getContext().getString(2131886574);
        }
        textView.setText(string);
        if (programExam2 == null) {
        } else {
            ordinal = programExam2.getStatus();
        }
        if (ordinal == 0) {
        } else {
            i2 = i.a.a[ordinal.ordinal()];
        }
        if (i2 != i7) {
            if (i2 != i6) {
                if (i2 != i5) {
                    obj8 = textView.getContext().getColor(2131100379);
                } else {
                    obj8 = textView.getContext().getColor(2131100376);
                }
            } else {
                obj8 = textView.getContext().getColor(2131100352);
            }
        } else {
            obj8 = textView.getContext().getColor(2131099839);
        }
        textView.setTextColor(obj8);
    }

    public static final void r(RecyclerView recyclerView, LibrarySection librarySection2, o.a o$a3) {
        Object oVar;
        int itemDecorationCount;
        Context context;
        String str;
        Object obj3;
        Object obj4;
        o.a obj5;
        n.f(recyclerView, "<this>");
        if (librarySection2 != null && a3 != null) {
            if (a3 != null) {
                if (librarySection2.getTricks() != null) {
                    if (recyclerView.getItemDecorationCount() == 0) {
                        context = recyclerView.getContext();
                        n.e(context, "context");
                        itemDecorationCount = new s(context);
                        recyclerView.h(itemDecorationCount);
                    }
                    if (recyclerView.getAdapter() == null) {
                        oVar = new o(a3);
                        recyclerView.setAdapter(oVar);
                    }
                    if (obj3 instanceof o) {
                    } else {
                        obj3 = 0;
                    }
                    if (obj3 == null) {
                    } else {
                        obj3.j(librarySection2.getTricks());
                    }
                } else {
                    a.c("Invalid Library Section Item", new Object[0]);
                }
            }
        }
    }

    public static final void s(RecyclerView recyclerView, List<TrickItem> list2, o.a o$a3) {
        String str;
        RecyclerView.h oVar;
        int i;
        List obj3;
        o.a obj4;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getAdapter() == null) {
            if (a3 != null) {
                if (recyclerView.getAdapter() == null) {
                    oVar = new o(a3);
                    recyclerView.setAdapter(oVar);
                }
                if (obj4 instanceof o) {
                } else {
                    obj4 = i;
                }
                if (obj4 == null) {
                } else {
                    obj4.j(list2);
                }
                obj3 = recyclerView.getLayoutManager();
                if (obj3 instanceof GridLayoutManager != null) {
                    i = obj3;
                }
                if (i == 0) {
                } else {
                    i.z3(2);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = 0;
                    recyclerView.measure(obj3, obj3);
                    obj3 = new r();
                    recyclerView.h(obj3);
                }
            }
        }
    }

    public static final void t(ViewPager2 viewPager2, y<TrickItem> y2, TabLayout tabLayout3, c0 c04, k k5) {
        boolean videoSteps;
        Object i;
        o oVar;
        app.dogo.com.dogo_android.f.i.d dVar;
        int obj5;
        Object obj7;
        n.f(viewPager2, "<this>");
        n.f(tabLayout3, "tabLayout");
        if (y2 instanceof y.c) {
        } else {
            obj5 = i;
        }
        if (obj5 == null) {
        } else {
            i = obj5;
        }
        if (i != null && k5 != null && viewPager2.getAdapter() == null && c04 != null) {
            if (k5 != null) {
                if (viewPager2.getAdapter() == null) {
                    if (c04 != null) {
                        if (i.getVimeoData() != null) {
                            dVar = new i.d(viewPager2, i, k5);
                            oVar = new o(i.getVideoSteps(), i.getVimeoData().getVideoUrl(), c04, dVar);
                            viewPager2.setAdapter(oVar);
                            obj5 = new i.b(oVar, k5);
                            viewPager2.h(obj5);
                            obj5 = new d(tabLayout3, viewPager2, e.a);
                            obj5.a();
                            viewPager2.setCurrentItem(0);
                            viewPager2.setOffscreenPageLimit(1);
                        } else {
                            obj5 = new j(k5, i.getTrickSteps());
                            viewPager2.setAdapter(obj5);
                            obj5 = new i.c(k5);
                            viewPager2.h(obj5);
                            obj5 = new d(tabLayout3, viewPager2, d.a);
                            obj5.a();
                        }
                    }
                }
            }
        }
    }

    private static final void u(TabLayout.g tabLayout$g, int i2) {
        n.f(g, "$noName_0");
    }

    private static final void v(TabLayout.g tabLayout$g, int i2) {
        n.f(g, "$noName_0");
    }

    public static final void w(RecyclerView recyclerView, o.a o$a2, y<? extends List<TrickItem>> y3) {
        boolean z;
        RecyclerView.h oVar;
        int i;
        o.a obj3;
        Object obj4;
        n.f(recyclerView, "<this>");
        i = 0;
        if (y3 instanceof y.c) {
        } else {
            obj4 = i;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.a();
            if ((List)obj4 == null) {
            } else {
                if (a2 != null && recyclerView.getAdapter() == null) {
                    if (recyclerView.getAdapter() == null) {
                        oVar = new o(a2);
                        recyclerView.setAdapter(oVar);
                    }
                    if (obj3 instanceof o) {
                    } else {
                        obj3 = i;
                    }
                    if (obj3 == null) {
                    } else {
                        obj3.j((List)obj4);
                    }
                    obj3 = recyclerView.getLayoutManager();
                    if (obj3 instanceof GridLayoutManager != null) {
                        i = obj3;
                    }
                    if (i == 0) {
                    } else {
                        i.z3(2);
                    }
                    if (recyclerView.getItemDecorationCount() == 0) {
                        obj3 = 0;
                        recyclerView.measure(obj3, obj3);
                        obj3 = new r();
                        recyclerView.h(obj3);
                    }
                }
            }
        }
    }

    public static final void x(RecyclerView recyclerView, List<TrickItem> list2, n.a n$a3) {
        Object nVar;
        int i;
        List obj3;
        Object obj4;
        n.f(recyclerView, "<this>");
        n.f(a3, "callback");
        if (list2 != null) {
            nVar = new n(a3);
            nVar.j(list2);
            if (obj4 instanceof GridLayoutManager != null) {
            } else {
                obj4 = 0;
            }
            if (obj4 == null) {
            } else {
                if (list2.size() == 1) {
                } else {
                    i = 2;
                }
                obj4.z3(i);
            }
            recyclerView.setAdapter(nVar);
        }
    }

    public static final void y(ViewPagerCustomDuration viewPagerCustomDuration, WorkoutSession workoutSession2, i.b i$b3, SegmentedProgressBar segmentedProgressBar4) {
        Object iVar;
        app.dogo.com.dogo_android.f.c cVar;
        int i;
        long obj4;
        n.f(viewPagerCustomDuration, "<this>");
        n.f(segmentedProgressBar4, "progressBar");
        if (workoutSession2 != 0 && b3 != null) {
            if (b3 != null) {
                i.f fVar = new i.f(viewPagerCustomDuration);
                iVar = new i(fVar, b3, workoutSession2.getTrainingTricksList());
                viewPagerCustomDuration.setAdapter(iVar);
                viewPagerCustomDuration.setOffscreenPageLimit(2);
                viewPagerCustomDuration.Q(false, h.a);
                viewPagerCustomDuration.setPageMargin(a.b(viewPagerCustomDuration.getResources().getDimension(2131165618)));
                cVar = new c(b3);
                segmentedProgressBar4.setSegmentCount(workoutSession2.getTrainingTricksList().size());
                obj4 = new i.e(segmentedProgressBar4, iVar, viewPagerCustomDuration, cVar);
                viewPagerCustomDuration.c(obj4);
                viewPagerCustomDuration.setScrollDurationFactor(4613937818241073152L);
            }
        }
    }

    private static final void z(View view, float f2) {
        n.f(view, "page");
        view.setAlpha(f -= obj2);
    }
}
