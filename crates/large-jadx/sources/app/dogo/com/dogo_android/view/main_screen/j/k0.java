package app.dogo.com.dogo_android.view.main_screen.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.a0.g.f.g0.c;
import app.dogo.com.dogo_android.a0.g.f.h0;
import app.dogo.com.dogo_android.d.b.z.k;
import app.dogo.com.dogo_android.h.ci;
import app.dogo.com.dogo_android.h.ga;
import app.dogo.com.dogo_android.k.b;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeTitleItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem;
import app.dogo.com.dogo_android.q.q.g;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.k0.d;
import app.dogo.com.dogo_android.util.l0.a;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.k;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import com.bumptech.glide.c;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.a;
import com.github.ksoichiro.android.observablescrollview.b;
import com.google.android.gms.tasks.j;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import com.theartofdev.edmodo.cropper.d;
import f.d.a.a;
import h.a.b.b;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010&\u001a\u00020'2\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0008\u0010*\u001a\u00020'H\u0002J\u0012\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0008\u0010/\u001a\u000200H\u0016J\u000e\u00101\u001a\u0008\u0012\u0004\u0012\u00020302H\u0014J\u0008\u00104\u001a\u000205H\u0016J\u0008\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010:09H\u0016J\"\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0008\u0010>\u001a\u0004\u0018\u00010?H\u0016J$\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020B2\u0008\u0010C\u001a\u0004\u0018\u00010D2\u0008\u0010E\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020)H\u0016J\u0008\u0010I\u001a\u00020'H\u0016J\u0010\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u000207H\u0016J\u0008\u0010L\u001a\u00020'H\u0016J\u0008\u0010M\u001a\u00020'H\u0016J\u0008\u0010N\u001a\u00020'H\u0002J\u0008\u0010O\u001a\u00020'H\u0002J\u0008\u0010P\u001a\u00020'H\u0003J\u0010\u0010Q\u001a\u00020'2\u0006\u0010R\u001a\u00020SH\u0002J\u0008\u0010T\u001a\u00020'H\u0002J\u0018\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\rH\u0002J\u0006\u0010Y\u001a\u00020'J\u0018\u0010Z\u001a\u00020'2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\"\u0010#\u001a\u0004\u0008 \u0010!R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectCallback;", "()V", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentChallengeHomeBinding;", "commentBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "navBarSize", "", "newEntryBubblePositionChangeCallback", "Lapp/dogo/com/dogo_android/util/listeners/SimpleClickCallBack;", "getNewEntryBubblePositionChangeCallback", "()Lapp/dogo/com/dogo_android/util/listeners/SimpleClickCallBack;", "setNewEntryBubblePositionChangeCallback", "(Lapp/dogo/com/dogo_android/util/listeners/SimpleClickCallBack;)V", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "getOnRefreshListener", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "setOnRefreshListener", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;)V", "scrollListener", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "scrollObserver", "Lcom/github/ksoichiro/android/observablescrollview/ObservableScrollViewCallbacks;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "vm", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeHomeViewModel;", "callEntryCreation", "", "arguments", "Landroid/os/Bundle;", "clearGlideCache", "createTitleView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/FragmentTags;", "getMessagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDataReceived", "action", "mail", "onDestroy", "onEntryImageDogSelect", "dogId", "onPause", "onResume", "openNotificationWindow", "setupListeners", "setupObservers", "setupRecycleView", "recyclerView", "Lcom/github/ksoichiro/android/observablescrollview/ObservableRecyclerView;", "shareToFriends", "showDeleteCommentDialog", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "position", "showPremiumScreen", "showReportDialog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k0 extends w implements g {

    public static final app.dogo.com.dogo_android.view.main_screen.j.k0.a Companion;
    private e A;
    private a B;
    private k C;
    private LinearLayoutManager D;
    private a E;
    private d F;
    private int G;
    private SwipeRefreshLayout.j H;
    private final h x;
    private ga y;
    private g0 z;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$Companion;", "", "()V", "GENERAL_BACK_TOP_CLICKED", "", "GENERAL_SORT_24_HOURS_CLICKED", "GENERAL_SORT_7_DAYS_CLICKED", "GENERAL_SORT_COUNTRY_CLICKED", "GENERAL_SORT_LATEST_CLICKED", "GENERAL_SORT_POPULAR_CLICKED", "GENERAL_SORT_YOUR_CLICKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH\u0016¨\u0006\r", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$setupListeners$2", "Lcom/github/ksoichiro/android/observablescrollview/ObservableScrollViewCallbacks;", "onDownMotionEvent", "", "onScrollChanged", "scrollY", "", "firstScroll", "", "dragging", "onUpOrCancelMotionEvent", "scrollState", "Lcom/github/ksoichiro/android/observablescrollview/ScrollState;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements a {

        final app.dogo.com.dogo_android.view.main_screen.j.k0 a;
        c(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            this.a = k0;
            super();
        }

        public static void d(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            k0.c.g(k0);
        }

        public static void e(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            k0.c.f(k0);
        }

        private static final void f(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            n.f(k0, "this$0");
            ga obj1 = k0.c2(k0);
            n.d(obj1);
            obj1.Q.setVisibility(0);
        }

        private static final void g(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            n.f(k0, "this$0");
            ga obj1 = k0.c2(k0);
            n.d(obj1);
            obj1.Q.setVisibility(8);
        }

        @Override // com.github.ksoichiro.android.observablescrollview.a
        public void a(b b) {
            int i;
            int i2;
            b dOWN;
            Object d0Var;
            app.dogo.com.dogo_android.view.main_screen.j.k0 k0Var;
            app.dogo.com.dogo_android.view.main_screen.j.e0 e0Var;
            Object obj7;
            n.f(b, "scrollState");
            ga gaVar = k0.c2(this.a);
            n.d(gaVar);
            final int i4 = 1;
            i = gaVar.Q.getVisibility() == 0 ? i4 : i2;
            a0 a0Var = this.a.G1();
            n.d(a0Var);
            if (a0Var.C() == 0) {
                i2 = i4;
            }
            g0 g0Var = k0.e2(this.a);
            n.d(g0Var);
            g0Var.G();
            a aVar = this.a.m2();
            n.d(aVar);
            aVar.a();
            g0 g0Var2 = k0.e2(this.a);
            n.d(g0Var2);
            g0Var2.V2();
            g0 g0Var3 = k0.e2(this.a);
            n.d(g0Var3);
            g0 g0Var4 = k0.e2(this.a);
            n.d(g0Var4);
            if (b == b.DOWN && i == 0 && g0Var3.V0() && g0Var4.Z0()) {
                if (i == 0) {
                    g0Var3 = k0.e2(this.a);
                    n.d(g0Var3);
                    if (g0Var3.V0()) {
                        g0Var4 = k0.e2(this.a);
                        n.d(g0Var4);
                        if (g0Var4.Z0()) {
                            g0 g0Var5 = k0.e2(this.a);
                            n.d(g0Var5);
                            g0Var5.f2();
                            ga gaVar2 = k0.c2(this.a);
                            n.d(gaVar2);
                            int i8 = 1065353216;
                            e0Var = new e0(this.a);
                            gaVar2.Q.animate().setDuration(0).scaleX(i8).scaleY(i8).withStartAction(e0Var).start();
                            dOWN = k0.e2(this.a);
                            n.d(dOWN);
                            dOWN.W2();
                        }
                    }
                }
                if (i2 == 0) {
                    dOWN = this.a.G1();
                    n.d(dOWN);
                    dOWN.p0();
                }
            }
            if (b == b.UP && i != 0) {
                if (i != 0) {
                    obj7 = k0.c2(this.a);
                    n.d(obj7);
                    int i3 = 0;
                    d0Var = new d0(this.a);
                    obj7.Q.animate().setDuration(200).scaleX(i3).scaleY(i3).withEndAction(d0Var).start();
                }
                obj7 = k0.b2(this.a);
                n.d(obj7);
                if (obj7.W0() == i4 && i2 != 0) {
                    if (i2 != 0) {
                        obj7 = this.a.G1();
                        n.d(obj7);
                        obj7.F();
                    }
                }
            }
        }

        @Override // com.github.ksoichiro.android.observablescrollview.a
        public void b() {
        }

        @Override // com.github.ksoichiro.android.observablescrollview.a
        public void c(int i, boolean z2, boolean z3) {
            a obj1 = this.a.m2();
            n.d(obj1);
            obj1.a();
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$setupRecycleView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends RecyclerView.u {

        final app.dogo.com.dogo_android.view.main_screen.j.k0 a;
        e(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            this.a = k0;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i;
            int obj3;
            int obj5;
            n.f(recyclerView, "recyclerView");
            obj3 = 7;
            int obj4 = 1;
            LinearLayoutManager linearLayoutManager = k0.d2(this.a);
            n.d(linearLayoutManager);
            if (i3 > 15 && linearLayoutManager.w2() >= obj3) {
                linearLayoutManager = k0.d2(this.a);
                n.d(linearLayoutManager);
                if (linearLayoutManager.w2() >= obj3) {
                    i = k0.e2(this.a);
                    n.d(i);
                    i.p2(obj4);
                }
            }
            final int i5 = 0;
            obj5 = k0.d2(this.a);
            n.d(obj5);
            obj3 = k0.c2(this.a);
            n.d(obj3);
            if (i3 < -15 && obj5.w2() < obj3 && !obj3.Q.hasFocus()) {
                obj5 = k0.d2(this.a);
                n.d(obj5);
                if (obj5.w2() < obj3) {
                    obj3 = k0.c2(this.a);
                    n.d(obj3);
                    if (!obj3.Q.hasFocus()) {
                        obj3 = k0.e2(this.a);
                        n.d(obj3);
                        obj3.p2(i5);
                    }
                }
            }
            obj3 = k0.d2(this.a);
            n.d(obj3);
            if (obj3.v2() >= 2) {
                obj3 = k0.e2(this.a);
                n.d(obj3);
                obj3.y0().hideNotifications(i5);
            } else {
                obj3 = k0.e2(this.a);
                n.d(obj3);
                obj3.y0().hideNotifications(obj4);
            }
            obj3 = k0.d2(this.a);
            n.d(obj3);
            obj3 = obj3.w2();
            obj5 = k0.b2(this.a);
            n.d(obj5);
            if (obj3 >= 6 && obj3 == obj5 -= obj4) {
                obj5 = k0.b2(this.a);
                n.d(obj5);
                if (obj3 == obj5 -= obj4) {
                    obj3 = k0.e2(this.a);
                    n.d(obj3);
                    obj3.p2(obj4);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$setupListeners$3", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends k {

        final app.dogo.com.dogo_android.view.main_screen.j.k0 d;
        d(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            this.d = k0;
            super(5);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        public void a() {
            g0 g0Var = k0.e2(this.d);
            n.d(g0Var);
            g0Var.X1();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<w> {

        final f $item;
        final int $position;
        final app.dogo.com.dogo_android.view.main_screen.j.k0 this$0;
        f(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, f f2, int i3) {
            this.this$0 = k0;
            this.$item = f2;
            this.$position = i3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            k0.g2(this.this$0, (k)this.$item.g(), this.$position);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements a<w> {

        final f $item;
        final int $position;
        final app.dogo.com.dogo_android.view.main_screen.j.k0 this$0;
        g(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, f f2, int i3) {
            this.this$0 = k0;
            this.$item = f2;
            this.$position = i3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            k0.f2(this.this$0, (k)this.$item.g(), this.$position);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements l<String, w> {

        final f $item;
        final int $position;
        final app.dogo.com.dogo_android.view.main_screen.j.k0 this$0;
        h(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, f f2, int i3) {
            this.this$0 = k0;
            this.$item = f2;
            this.$position = i3;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            String $position;
            boolean obj2;
            n.f(string, "it");
            obj2 = k0.e2(this.this$0);
            n.d(obj2);
            obj2 = k0.e2(this.this$0);
            n.d(obj2);
            if (!obj2.R0() && !obj2.Y0((k)this.$item.g())) {
                obj2 = k0.e2(this.this$0);
                n.d(obj2);
                if (!obj2.Y0((k)this.$item.g())) {
                    obj2 = k0.b2(this.this$0);
                    if (obj2 == null) {
                    } else {
                        obj2.removeItem(this.$position);
                    }
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<w> {

        final ChallengeComment $model;
        final int $position;
        final app.dogo.com.dogo_android.view.main_screen.j.k0 this$0;
        i(ChallengeComment challengeComment, app.dogo.com.dogo_android.view.main_screen.j.k0 k02, int i3) {
            this.$model = challengeComment;
            this.this$0 = k02;
            this.$position = i3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            Object this$0;
            int $position;
            String tag;
            if (this.$model.getDocumentId() == null) {
                this.this$0.Z1(2131886123);
            } else {
                g0 g0Var = k0.e2(this.this$0);
                n.d(g0Var);
                g0Var.a2(this.$model, this.this$0.l2().getTag());
                g0 g0Var2 = k0.e2(this.this$0);
                n.d(g0Var2);
                if (g0Var2.H2(this.$model)) {
                    this$0 = k0.b2(this.this$0);
                    n.d(this$0);
                    this$0.removeItem(this.$position);
                } else {
                    this$0 = k0.b2(this.this$0);
                    n.d(this$0);
                    this$0.q2(this.$position);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends p implements l<String, w> {

        final ChallengeComment $model;
        final int $position;
        final app.dogo.com.dogo_android.view.main_screen.j.k0 this$0;
        j(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, ChallengeComment challengeComment2, int i3) {
            this.this$0 = k0;
            this.$model = challengeComment2;
            this.$position = i3;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            String $position;
            boolean obj2;
            n.f(string, "it");
            obj2 = k0.e2(this.this$0);
            n.d(obj2);
            obj2 = k0.e2(this.this$0);
            n.d(obj2);
            if (!obj2.R0() && !obj2.Y0(this.$model)) {
                obj2 = k0.e2(this.this$0);
                n.d(obj2);
                if (!obj2.Y0(this.$model)) {
                    obj2 = k0.b2(this.this$0);
                    if (obj2 == null) {
                    } else {
                        obj2.removeItem(this.$position);
                    }
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class k extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public k(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$onCreateView$1", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getUserDogIcon", "Landroid/net/Uri;", "isUserPremiumBadgeVisible", "", "onAvatarClick", "", "onSendActionListener", "currentText", "", "replyTarget", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "permissionCheck", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final app.dogo.com.dogo_android.view.main_screen.j.k0 a;
        b(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
            this.a = k0;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public Uri getUserDogIcon() {
            int i;
            g0 g0Var = k0.e2(this.a);
            if (g0Var == null) {
                i = 0;
            } else {
                i = g0Var.D0();
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean isUserPremiumBadgeVisible() {
            g0 g0Var = k0.e2(this.a);
            n.d(g0Var);
            return g0Var.b1();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onAvatarClick() {
            a0 a0Var;
            String str2;
            String str;
            g0 g0Var = k0.e2(this.a);
            n.d(g0Var);
            if (g0Var.f0() > 0) {
                a0Var = this.a.G1();
                n.d(a0Var);
                a0Var.l0("challenge_profile_dog_select_request", "challenge_home");
            } else {
                a0Var = this.a.G1();
                n.d(a0Var);
                g0 g0Var2 = k0.e2(this.a);
                n.d(g0Var2);
                a0Var.w0(g0Var2.b0().getId(), 11100);
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onSendActionListener(String string, ChallengeComment challengeComment2) {
            n.f(string, "currentText");
            g0 g0Var = k0.e2(this.a);
            n.d(g0Var);
            if (g0Var.a3(string, challengeComment2, this.a.G1())) {
                clearCommentField();
            }
            this.a.M1();
            LinearLayoutManager obj3 = k0.d2(this.a);
            n.d(obj3);
            obj3.S1(7);
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean permissionCheck() {
            return 1;
        }
    }
    static {
        k0.a aVar = new k0.a(0);
        k0.Companion = aVar;
    }

    public k0() {
        super();
        final int i = 0;
        k0.k kVar = new k0.k(this, i, i);
        this.x = j.a(m.NONE, kVar);
        a0 a0Var = new a0(this);
        this.H = a0Var;
    }

    public static void A2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        k0.c3(k0, boolean2);
    }

    public static void B2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        k0.U2(k0, list2);
    }

    public static void C2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Integer integer2) {
        k0.V2(k0, integer2);
    }

    public static void D2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, j j2) {
        k0.i2(k0, j2);
    }

    public static void E2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        k0.M2(k0);
    }

    public static void F2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        k0.e3(k0, boolean2);
    }

    public static void G2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        k0.Z2(k0, boolean2);
    }

    public static void H2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        k0.W2(k0, boolean2);
    }

    public static void I2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        k0.d3(k0, list2);
    }

    private static final boolean J2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, View view2, int i3, KeyEvent keyEvent4) {
        n.f(k0, "this$0");
        if (i3 == 4) {
            ga obj1 = k0.y;
            n.d(obj1);
            obj1.S.requestFocus();
            d obj0 = k0.F;
            Objects.requireNonNull(obj0, "null cannot be cast to non-null type app.dogo.com.dogo_android.util.interfaces.CommentBarManager");
            obj0.clearCommentField();
            return 1;
        }
        return 0;
    }

    private static final Object K2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, j j2) {
        String str;
        Object obj1;
        boolean obj2;
        n.f(k0, "this$0");
        if (!k0.isStateSaved()) {
            obj2 = k0.z;
            n.d(obj2);
            obj2.B2();
            obj2 = k0.G1();
            n.d(obj2);
            k0.G = obj2.D();
            k0.O2();
            obj2 = k0.y;
            n.d(obj2);
            obj2 = obj2.S;
            n.e(obj2, "binding!!.recycleView");
            k0.f3(obj2);
            k0.Q2();
            obj1 = k0.z;
            n.d(obj1);
            obj1.i2();
        }
        return null;
    }

    private static final void L2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, View view2) {
        n.f(k0, "this$0");
        g0 obj1 = k0.z;
        n.d(obj1);
        obj1.A(k0.G1());
    }

    private static final void M2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        g0 g0Var;
        n.f(k0, "this$0");
        g0 g0Var2 = k0.z;
        n.d(g0Var2);
        if (g0Var2.c3()) {
            k kVar = k0.C;
            n.d(kVar);
            kVar.b();
            e eVar = k0.A;
            n.d(eVar);
            eVar.j2();
            g0 g0Var3 = k0.z;
            n.d(g0Var3);
            g0Var3.l2();
            g0 g0Var4 = k0.z;
            n.d(g0Var4);
            g0Var4.A2();
            g0Var = k0.z;
            n.d(g0Var);
            g0Var.d2();
        } else {
            g0Var = k0.z;
            n.d(g0Var);
            g0Var.i2();
        }
        k0.c.c(u.z);
        a aVar = k0.m2();
        n.d(aVar);
        aVar.a();
        k0.M1();
    }

    private final void N2() {
        Bundle bundle;
        i cHALLENGE_NOTIFICATION_CENTER_FRAGMENT;
        int i;
        int i2;
        final a0 a0Var = G1();
        if (a0Var != null) {
            bundle = new Bundle();
            bundle.putBoolean("hasBackArrow", true);
            a0Var.I0(i.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT, bundle, 2130772003, 0);
        }
    }

    private final void O2() {
        o oVar = new o(this);
        this.E = oVar;
        k0.c cVar = new k0.c(this);
        this.B = cVar;
        k0.d dVar = new k0.d(this);
        this.C = dVar;
    }

    private static final void P2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        n.f(k0, "this$0");
        ga gaVar = k0.y;
        n.d(gaVar);
        final g0 g0Var = k0.z;
        n.d(g0Var);
        e obj2 = k0.A;
        n.d(obj2);
        gaVar.R.setY(g0Var.M(obj2.F0));
    }

    private final void Q2() {
        g0 g0Var = this.z;
        n.d(g0Var);
        c0 c0Var = new c0(this);
        g0Var.V().observe(getViewLifecycleOwner(), c0Var);
        g0 g0Var2 = this.z;
        n.d(g0Var2);
        u uVar = new u(this);
        g0Var2.o0().observe(getViewLifecycleOwner(), uVar);
        g0 g0Var3 = this.z;
        n.d(g0Var3);
        w wVar = new w(this);
        g0Var3.p0().observe(getViewLifecycleOwner(), wVar);
        g0 g0Var4 = this.z;
        n.d(g0Var4);
        g0 g0Var13 = new g0(this);
        g0Var4.t0().observe(getViewLifecycleOwner(), g0Var13);
        g0 g0Var5 = this.z;
        n.d(g0Var5);
        b0 b0Var = new b0(this);
        g0Var5.l0().observe(getViewLifecycleOwner(), b0Var);
        g0 g0Var6 = this.z;
        n.d(g0Var6);
        t tVar = new t(this);
        g0Var6.i0().observe(getViewLifecycleOwner(), tVar);
        g0 g0Var7 = this.z;
        n.d(g0Var7);
        p pVar = new p(this);
        g0Var7.k0().observe(getViewLifecycleOwner(), pVar);
        g0 g0Var8 = this.z;
        n.d(g0Var8);
        l lVar = new l(this);
        g0Var8.K0().observe(getViewLifecycleOwner(), lVar);
        g0 g0Var9 = this.z;
        n.d(g0Var9);
        x xVar10 = new x(this);
        g0Var9.s0().observe(getViewLifecycleOwner(), xVar10);
        g0 g0Var10 = this.z;
        n.d(g0Var10);
        y yVar = new y(this);
        g0Var10.q0().observe(getViewLifecycleOwner(), yVar);
        g0 g0Var11 = this.z;
        n.d(g0Var11);
        f0 f0Var = new f0(this);
        g0Var11.g0().observe(getViewLifecycleOwner(), f0Var);
        q qVar = new q(this);
        getSharedViewModel().E().observe(getViewLifecycleOwner(), qVar);
        g0 g0Var12 = this.z;
        n.d(g0Var12);
        androidx.lifecycle.q viewLifecycleOwner13 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner13, "viewLifecycleOwner");
        v vVar2 = new v(this);
        g0Var12.w0().observe(viewLifecycleOwner13, vVar2);
    }

    private static final void R2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        Object str;
        Object obj1;
        boolean obj2;
        n.f(k0, "this$0");
        if (list2 != null) {
            str = k0.A;
            n.d(str);
            str.g2(list2);
        }
        obj2 = k0.y;
        n.d(obj2);
        if (obj2.U.h()) {
            obj1 = k0.y;
            n.d(obj1);
            obj1.U.setRefreshing(false);
        }
    }

    private static final void S2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        Object obj1;
        b obj2;
        n.f(k0, "this$0");
        if (boolean2 != null) {
            if (boolean2.booleanValue()) {
                obj1 = k0.B;
                n.d(obj1);
                obj1.a(b.UP);
            } else {
                obj1 = k0.B;
                n.d(obj1);
                obj1.a(b.DOWN);
            }
        }
    }

    private static final void T2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        String str;
        g0.c user;
        String documentId;
        int i;
        Object obj3;
        List obj4;
        n.f(k0, "this$0");
        if (list2 != null) {
            e eVar = k0.A;
            n.d(eVar);
            i = 0;
            if (list2.isEmpty()) {
                documentId = 0;
            } else {
                documentId = (EntryUserPhotoItem)list2.get(i).getModel().getDocumentId();
            }
            eVar.y2(documentId);
            g0 g0Var = k0.z;
            n.d(g0Var);
            e eVar2 = k0.A;
            n.d(eVar2);
            eVar2.z2(list2);
            obj4 = k0.D;
            n.d(obj4);
            if (g0Var.z0() == g0.c.User && obj4.w2() >= 7) {
                eVar2 = k0.A;
                n.d(eVar2);
                eVar2.z2(list2);
                obj4 = k0.D;
                n.d(obj4);
                if (obj4.w2() >= 7) {
                    obj4 = k0.z;
                    n.d(obj4);
                    obj4.p2(true);
                }
                obj4 = k0.y;
                n.d(obj4);
                if (obj4.U.h()) {
                    obj3 = k0.y;
                    n.d(obj3);
                    obj3.U.setRefreshing(i);
                }
            }
        }
    }

    private static final void U2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        Object str;
        Object obj1;
        boolean obj2;
        n.f(k0, "this$0");
        if (list2 != null) {
            str = k0.A;
            n.d(str);
            str.i2(list2);
        }
        obj2 = k0.y;
        n.d(obj2);
        if (obj2.U.h()) {
            obj1 = k0.y;
            n.d(obj1);
            obj1.U.setRefreshing(false);
        }
    }

    private static final void V2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Integer integer2) {
        Object str;
        int intValue;
        Object obj2;
        int obj3;
        n.f(k0, "this$0");
        ga gaVar = k0.y;
        n.d(gaVar);
        gaVar.S.q1(integer2.intValue());
        if (integer2 != 0 && integer2.intValue() == 0) {
            gaVar = k0.y;
            n.d(gaVar);
            gaVar.S.q1(integer2.intValue());
            if (integer2.intValue() == 0) {
                obj2 = k0.G1();
                n.d(obj2);
                obj2.p0();
            }
        }
    }

    private static final void W2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        Object obj1;
        n.f(k0, "this$0");
        if (boolean2 != null) {
            obj1 = k0.A;
            n.d(obj1);
            obj1.p2();
        }
    }

    private static final void X2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, y y2) {
        Object obj1;
        int obj2;
        n.f(k0, "this$0");
        n.e(y2, "it");
        if (obj2 instanceof DogProfile != null) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = k0.F;
            if (obj2 == null) {
            } else {
                obj2.updateDogAvatar();
            }
            obj1 = k0.A;
            if (obj1 == null) {
            } else {
                obj1.notifyDataSetChanged();
            }
        }
    }

    private static final void Y2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        Object obj1;
        n.f(k0, "this$0");
        g0 g0Var = k0.z;
        n.d(g0Var);
        if (!g0Var.R0()) {
            obj1 = k0.A;
            if (obj1 == null) {
            } else {
                obj1.w2(list2);
            }
        }
    }

    private static final void Z2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        String str;
        int context;
        int nVar;
        Object obj2;
        ga obj3;
        n.f(k0, "this$0");
        obj3 = k0.y;
        n.d(obj3);
        obj3.O.setVisibility(8);
        obj3 = k0.z;
        n.d(obj3);
        if (boolean2 != null && !obj3.W0()) {
            obj3 = k0.y;
            n.d(obj3);
            obj3.O.setVisibility(8);
            obj3 = k0.z;
            n.d(obj3);
            if (!obj3.W0()) {
                obj3 = k0.z;
                n.d(obj3);
                nVar = new n(k0);
                obj3.K2(k0.getContext(), nVar);
            }
            obj3 = k0.y;
            nVar = obj3 == null ? str : obj3.U;
            n.d(obj3);
            if (nVar != 0 && obj3.U.h()) {
                n.d(obj3);
                if (obj3.U.h()) {
                    obj2 = k0.y;
                    if (obj2 == null) {
                    } else {
                        str = obj2.U;
                    }
                    if (str == null) {
                    } else {
                        str.setRefreshing(false);
                    }
                }
            }
        }
    }

    private static final void a3(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        n.f(k0, "this$0");
        k0.n2().onRefresh();
    }

    public static final e b2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        return k0.A;
    }

    private static final void b3(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        n.f(k0, "this$0");
        k0.j2();
        k obj2 = k0.C;
        n.d(obj2);
        obj2.b();
        obj2 = k0.A;
        n.d(obj2);
        obj2.j2();
        obj2 = k0.y;
        n.d(obj2);
        obj2.S.q1(2);
        obj2 = k0.z;
        n.d(obj2);
        obj2.A2();
        obj2 = k0.z;
        n.d(obj2);
        g0 g0Var = k0.z;
        n.d(g0Var);
        obj2.Z2(g0Var.W());
        k0.M1();
    }

    public static final ga c2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        return k0.y;
    }

    private static final void c3(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        Object obj1;
        n.f(k0, "this$0");
        if (boolean2 != null) {
            obj1 = k0.A;
            n.d(obj1);
            obj1.u2();
        }
    }

    public static final LinearLayoutManager d2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        return k0.D;
    }

    private static final void d3(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        String str;
        Object obj1;
        n.f(k0, "this$0");
        if (list2 != null && empty ^= 1 != 0) {
            if (empty ^= 1 != 0) {
                obj1 = k0.A;
                n.d(obj1);
                obj1.Z(6, list2);
            }
        }
    }

    public static final g0 e2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        return k0.z;
    }

    private static final void e3(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        Object obj1;
        e obj2;
        n.f(k0, "this$0");
        if (boolean2 != null) {
            obj2 = k0.z;
            n.d(obj2);
            obj2.W2();
            obj2 = k0.A;
            n.d(obj2);
            obj1 = k0.z;
            n.d(obj1);
            obj2.r2(obj1.W());
        }
    }

    public static final void f2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, ChallengeComment challengeComment2, int i3) {
        k0.i3(challengeComment2, i3);
    }

    private final void f3(ObservableRecyclerView observableRecyclerView) {
        ArrayList arrayList = new ArrayList();
        g0 g0Var = this.z;
        n.d(g0Var);
        ChallengeTitleItem challengeTitleItem = g0Var.X();
        n.e(challengeTitleItem, "vm!!.challengeTitleCell");
        arrayList.add(challengeTitleItem);
        g0 g0Var2 = this.z;
        n.d(g0Var2);
        app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem entryTitleItem = g0Var2.C0();
        n.e(entryTitleItem, "vm!!.titleCell");
        arrayList.add(entryTitleItem);
        g0 g0Var3 = this.z;
        n.d(g0Var3);
        EntrySortingTabItem entrySortingTabItem = g0Var3.y0();
        n.e(entrySortingTabItem, "vm!!.sortingCell");
        arrayList.add(entrySortingTabItem);
        g0 g0Var4 = this.z;
        n.d(g0Var4);
        app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem entryFilterItem = g0Var4.m0();
        n.e(entryFilterItem, "vm!!.filterCell");
        arrayList.add(entryFilterItem);
        g0 g0Var5 = this.z;
        n.d(g0Var5);
        app.dogo.com.dogo_android.model.entry_list_item_models.InviteFriendsBannerItem inviteFriendsBannerItem = g0Var5.n0();
        n.e(inviteFriendsBannerItem, "vm!!.inviteFriendsCell");
        arrayList.add(inviteFriendsBannerItem);
        g0 g0Var6 = this.z;
        n.d(g0Var6);
        app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem becomePremiumBannerItem = g0Var6.S();
        n.e(becomePremiumBannerItem, "vm!!.becomePremiumCell");
        arrayList.add(becomePremiumBannerItem);
        g0 g0Var7 = this.z;
        n.d(g0Var7);
        app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem sponsorBannerItem = g0Var7.A0();
        n.e(sponsorBannerItem, "vm!!.sponsorCell");
        arrayList.add(sponsorBannerItem);
        final a0 a0Var = G1();
        n.d(a0Var);
        super(arrayList, this.z, a0Var, F1(), l2());
        this.A = eVar5;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.D = linearLayoutManager;
        observableRecyclerView.setLayoutManager(linearLayoutManager);
        observableRecyclerView.setAdapter(this.A);
        e eVar3 = this.A;
        n.d(eVar3);
        int i = 1;
        eVar3.M1(i);
        eVar3.N1(i);
        ga gaVar = this.y;
        n.d(gaVar);
        SwipeRefreshLayout swipeRefreshLayout = gaVar.U;
        n.e(swipeRefreshLayout, "binding!!.swipeRefreshLayout");
        swipeRefreshLayout.setOnRefreshListener(this.H);
        k kVar = this.C;
        n.d(kVar);
        observableRecyclerView.l(kVar);
        k0.e eVar4 = new k0.e(this);
        observableRecyclerView.l(eVar4);
        observableRecyclerView.setScrollViewCallbacks(this.B);
        a obj8 = this.B;
        n.d(obj8);
        obj8.a(b.DOWN);
        obj8 = this.A;
        n.d(obj8);
        k kVar2 = new k(this);
        obj8.a0(kVar2);
    }

    public static final void g2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, ChallengeComment challengeComment2, int i3) {
        k0.k3(challengeComment2, i3);
    }

    private static final boolean g3(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, View view2, int i3) {
        int badges;
        boolean z2;
        boolean z;
        int bundle;
        f nOTIFICATION_CLICK_AREA2;
        boolean nOTIFICATION_CLICK_AREA;
        boolean z3;
        int activity;
        androidx.databinding.a gaVar;
        int editText;
        int documentId;
        int i;
        DogProfileModel dogProfileModel;
        int cHALLENGE_DETAILS_DIALOG;
        int fVar;
        int i6;
        int dogName;
        int requireActivity;
        app.dogo.com.dogo_android.view.main_screen.j.k0.h hVar;
        int i8;
        Long valueOf;
        long l;
        int i5;
        String dogId;
        Double num;
        int i7;
        double d;
        int i2;
        int i4;
        Object obj = k0;
        badges = i3;
        n.f(obj, "this$0");
        n.f(view2, "view");
        e eVar = obj.A;
        n.d(eVar);
        nOTIFICATION_CLICK_AREA2 = eVar.O0(badges);
        if (nOTIFICATION_CLICK_AREA2 instanceof k && view2.getId() == 2131362294) {
            if (view2.getId() == 2131362294) {
                g0 g0Var = obj.z;
                n.d(g0Var);
                fVar = nOTIFICATION_CLICK_AREA2;
                g0 g0Var2 = obj.z;
                n.d(g0Var2);
                if (g0Var.Y0((k)fVar.g()) && !g0Var2.X0(fVar.g())) {
                    g0Var2 = obj.z;
                    n.d(g0Var2);
                    if (!g0Var2.X0(fVar.g())) {
                        activity = k0.getActivity();
                        if (activity == null) {
                        } else {
                            fVar = new k0.f(obj, nOTIFICATION_CLICK_AREA2, badges);
                            dogName = new k0.g(obj, nOTIFICATION_CLICK_AREA2, badges);
                            f1.J(activity, fVar, dogName);
                        }
                    } else {
                        obj.i3(fVar.g(), badges);
                    }
                } else {
                }
            }
            if (view2.getId() == 2131363058) {
                gaVar = obj.y;
                if (gaVar == null) {
                } else {
                    gaVar = gaVar.P;
                    if (gaVar == null) {
                    } else {
                        gaVar = gaVar.T();
                        if (gaVar == null) {
                        } else {
                            gaVar.addReplyTag((k)nOTIFICATION_CLICK_AREA2.g());
                        }
                    }
                }
                ga gaVar2 = obj.y;
                n.d(gaVar2);
                obj.Y1(ciVar.Q);
            }
            dogName = 1;
            if (view2.getId() == 2131363061) {
                f fVar4 = nOTIFICATION_CLICK_AREA2;
                cHALLENGE_DETAILS_DIALOG = (k)fVar4.g().getEntryId();
                documentId = fVar4.g().getDocumentId();
                if (cHALLENGE_DETAILS_DIALOG != null) {
                    if (l.z(cHALLENGE_DETAILS_DIALOG)) {
                        requireActivity = dogName;
                    } else {
                        requireActivity = 0;
                    }
                } else {
                }
                if (requireActivity == null) {
                    if (documentId != null) {
                        if (l.z(documentId)) {
                            requireActivity = dogName;
                        } else {
                            requireActivity = 0;
                        }
                    } else {
                    }
                    if (requireActivity == null) {
                        App.Companion.r().c(u.B);
                        requireActivity = k0.requireActivity();
                        n.e(requireActivity, "requireActivity()");
                        hVar = new k0.h(obj, nOTIFICATION_CLICK_AREA2, badges);
                        g1.T(requireActivity, cHALLENGE_DETAILS_DIALOG, documentId, hVar);
                    }
                }
            }
            if (view2.getId() == 2131362217 && (k)nOTIFICATION_CLICK_AREA2.g().isSpam()) {
                if ((k)nOTIFICATION_CLICK_AREA2.g().isSpam()) {
                    bundle = new Bundle();
                    g0 g0Var3 = obj.z;
                    n.d(g0Var3);
                    bundle.putParcelable("challenge", g0Var3.W());
                    bundle.putBoolean("show_rules", dogName);
                    bundle.putBoolean("hide_participate_button", dogName);
                    bundle.putInt("style", 2131951968);
                    i = k0.G1();
                    n.d(i);
                    i.k(c.CHALLENGE_DETAILS_DIALOG, bundle);
                }
            }
            if (view2.getId() == 2131362981) {
                f fVar2 = nOTIFICATION_CLICK_AREA2;
                ChallengeComment challengeComment3 = (k)fVar2.g();
                super(challengeComment3.getDogName(), challengeComment3.getDogAvatarUrl(), 0, 0, Long.valueOf(0), 0, 0, challengeComment3.getDogId(), Double.valueOf(0), 1, 0, 1024, 0);
                nOTIFICATION_CLICK_AREA = k0.G1();
                n.d(nOTIFICATION_CLICK_AREA);
                nOTIFICATION_CLICK_AREA.f0(dogProfileModel2, fVar2.g().getBadges());
            }
        }
        if (nOTIFICATION_CLICK_AREA2 instanceof InviteFriendsBannerItem) {
            k0.h3();
        }
        if (nOTIFICATION_CLICK_AREA2 instanceof BecomePremiumBannerItem) {
            k0.j3();
        }
        if (nOTIFICATION_CLICK_AREA2 instanceof EntrySortingTabItem && view2.getId() == ChallengeTitleItem.NOTIFICATION_CLICK_AREA) {
            if (view2.getId() == ChallengeTitleItem.NOTIFICATION_CLICK_AREA) {
                k0.N2();
            }
        }
        if (nOTIFICATION_CLICK_AREA2 instanceof ChallengeTitleItem && view2.getId() == ChallengeTitleItem.NOTIFICATION_CLICK_AREA) {
            if (view2.getId() == ChallengeTitleItem.NOTIFICATION_CLICK_AREA) {
                k0.N2();
            }
        }
        return 0;
    }

    private final l getSharedViewModel() {
        return (l)this.x.getValue();
    }

    private final void h2(Bundle bundle) {
        B1();
        g0 g0Var = this.z;
        n.d(g0Var);
        z zVar = new z(this);
        g0Var.O(bundle).addOnCompleteListener(zVar);
    }

    private final void h3() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        String string = getResources().getString(2131886783);
        n.e(string, "resources.getString(R.string.invite_friends_text)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(' ');
        stringBuilder.append(App.Companion.n().A());
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        intent.setType("text/plain");
        a0 a0Var = G1();
        n.d(a0Var);
        a0Var.startActivity(Intent.createChooser(intent, "..."));
        this.c.c(a0.d);
    }

    private static final void i2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, j j2) {
        Object str;
        int i;
        String str2;
        Object obj3;
        Object obj4;
        n.f(k0, "this$0");
        n.f(j2, "entryCreationDataFetchTask");
        str = k0.G1();
        i = 0;
        if (str != null) {
            k0.C1();
            if (j2.isSuccessful()) {
                obj3 = j2.getResult();
                str.n0((h0)obj3.a(), obj3.d(), obj3.b(), obj3.c());
            } else {
                a.e(j2.getException(), "Entry creation failed", new Object[i]);
            }
        } else {
            a.c("Navigator is not attached", new Object[i]);
        }
    }

    private final void i3(ChallengeComment challengeComment, int i2) {
        app.dogo.com.dogo_android.view.main_screen.j.k0.i iVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            iVar = new k0.i(challengeComment, this, i2);
            f1.O(activity, iVar);
        }
    }

    private final void j2() {
        c.c(requireContext()).b();
    }

    private final View k2(Context context) {
        FrameLayout frameLayout = new FrameLayout(requireContext());
        View obj4 = LayoutInflater.from(context).inflate(2131558484, frameLayout, false);
        n.e(obj4, "from(context).inflate(R.layout.cell_entry_challenge_pager_item, frameLayout, false)");
        return obj4;
    }

    private final void k3(ChallengeComment challengeComment, int i2) {
        int requireActivity;
        int jVar;
        int i;
        boolean z;
        final String entryId = challengeComment.getEntryId();
        final String documentId = challengeComment.getDocumentId();
        jVar = 1;
        if (entryId != null) {
            if (l.z(entryId)) {
                i = jVar;
            } else {
                i = requireActivity;
            }
        } else {
        }
        if (i == 0) {
            if (documentId != null) {
                if (l.z(documentId)) {
                    requireActivity = jVar;
                }
            } else {
            }
            if (requireActivity == null) {
                App.Companion.r().c(u.B);
                requireActivity = requireActivity();
                n.e(requireActivity, "requireActivity()");
                jVar = new k0.j(this, challengeComment, i2);
                g1.T(requireActivity, entryId, documentId, jVar);
            }
        }
    }

    public static boolean o2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, View view2, int i3) {
        return k0.g3(k0, view2, i3);
    }

    public static void p2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        k0.T2(k0, list2);
    }

    public static Object q2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, j j2) {
        return k0.K2(k0, j2);
    }

    public static void r2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        k0.a3(k0);
    }

    public static void s2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        k0.P2(k0);
    }

    public static void t2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        k0.S2(k0, boolean2);
    }

    public static void u2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, y y2) {
        k0.X2(k0, y2);
    }

    public static void v2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, View view2) {
        k0.L2(k0, view2);
    }

    public static boolean w2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, View view2, int i3, KeyEvent keyEvent4) {
        return k0.J2(k0, view2, i3, keyEvent4);
    }

    public static void x2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        k0.R2(k0, list2);
    }

    public static void y2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, Boolean boolean2) {
        k0.b3(k0, boolean2);
    }

    public static void z2(app.dogo.com.dogo_android.view.main_screen.j.k0 k0, List list2) {
        k0.Y2(k0, list2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public q D1() {
        return l2();
    }

    protected Set<h> E1() {
        HashSet hashSet = new HashSet();
        hashSet.add(h.MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE);
        hashSet.add(h.MESSAGE_ACTION_CHALLENGE_FILTERS);
        hashSet.add(h.MESSAGE_ACTION_BACK_TO_TOP);
        hashSet.add(h.MESSAGE_ACTION_SWITCH_TO_YOUR_TAB);
        hashSet.add(h.MESSAGE_ACTION_START_ENTRY_CREATION_FLOW);
        hashSet.add(h.MESSAGE_ACTION_COMMENT_COUNT_CHANGE);
        return hashSet;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public k3 H1() {
        return j3.I;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public String I1() {
        String string = getString(2131886332);
        n.e(string, "getString(R.string.challenges_tittle)");
        return string;
    }

    public Class<? extends r> K1() {
        return g0.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void U(String string) {
        androidx.fragment.app.e finishing;
        int i2;
        int i3;
        int i;
        boolean z;
        String str;
        app.dogo.com.dogo_android.model.LiteDogProfile liteDogProfile;
        g0 g0Var;
        int i4;
        Uri obj8;
        n.f(string, "dogId");
        finishing = getActivity();
        i3 = 1;
        final int i5 = 0;
        if (finishing == null) {
            i2 = i5;
        } else {
        }
        i2 = this.z;
        if (i2 != 0 && i2 != null) {
            i2 = this.z;
            if (i2 != null) {
                i = 0;
                if (i2 == null) {
                    i2 = i;
                } else {
                    i2 = i2.W();
                }
                if (i2 == null) {
                    str = i;
                } else {
                    str = i2.getId();
                }
                g0 g0Var2 = this.z;
                if (g0Var2 == null) {
                    liteDogProfile = i;
                } else {
                    liteDogProfile = g0Var2.r0(string);
                }
                g0Var = this.z;
                if (g0Var == null) {
                    i4 = i5;
                } else {
                }
                if (i2 != null && n.b(o.WELCOME_CHALLENGE.getId(), str) && liteDogProfile != null && i4 != 0) {
                    if (n.b(o.WELCOME_CHALLENGE.getId(), str)) {
                        if (liteDogProfile != null) {
                            if (i4 != 0) {
                            } else {
                                i3 = i5;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                if (i3 != 0) {
                    i3 = this.z;
                    if (i3 == null) {
                    } else {
                        if (i3 == null) {
                            obj8 = i;
                        } else {
                            obj8 = i3.e0(string);
                        }
                        i3.U2(obj8);
                    }
                    obj8 = G1();
                    if (obj8 == null) {
                    } else {
                        obj8.n0(i2, liteDogProfile, i, i);
                    }
                } else {
                    i2 = this.z;
                    if (i2 == null) {
                    } else {
                        i2.n2(string);
                    }
                    obj8 = G1();
                    if (obj8 == null) {
                    } else {
                        i2 = 800;
                        obj8.B0(i5, i2, i2);
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void W1(h h, Bundle bundle2) {
        Object mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE;
        Object mESSAGE_ACTION_SWITCH_TO_YOUR_TAB;
        Object mESSAGE_ACTION_BACK_TO_TOP;
        Object mESSAGE_ACTION_CHALLENGE_FILTERS;
        Object mESSAGE_ACTION_START_ENTRY_CREATION_FLOW;
        Object mESSAGE_ACTION_COMMENT_COUNT_CHANGE;
        Object obj;
        String yOUR_TAB;
        String string;
        int i;
        app.dogo.com.dogo_android.view.main_screen.j.r rVar;
        Object obj8;
        Object obj9;
        n.f(h, "action");
        n.f(bundle2, "mail");
        final String str3 = "data";
        final String str4 = "id";
        if (h == h.MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE) {
            if (bundle2.get(str4) != null && bundle2.get(str3) == null) {
                if (bundle2.get(str3) == null) {
                    mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE = this.z;
                    n.d(mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE);
                    mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE.Y1(bundle2.getString(str4));
                } else {
                    g0 g0Var = this.z;
                    n.d(g0Var);
                    if (g0Var.F0() != null) {
                        mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE = G1();
                        n.d(mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE);
                        yOUR_TAB = getString(2131887330);
                        n.e(yOUR_TAB, "getString(R.string.social_share_challenges_my_photo)");
                        rVar = new r(this);
                        mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE.r0(yOUR_TAB, getString(2131886703), 10000, rVar);
                    }
                }
            } else {
            }
        }
        if (h == h.MESSAGE_ACTION_SWITCH_TO_YOUR_TAB) {
            a aVar = this.B;
            n.d(aVar);
            aVar.a(b.UP);
            mESSAGE_ACTION_SWITCH_TO_YOUR_TAB = this.z;
            n.d(mESSAGE_ACTION_SWITCH_TO_YOUR_TAB);
            mESSAGE_ACTION_SWITCH_TO_YOUR_TAB.s2(b.YOUR_TAB);
        }
        if (h == h.MESSAGE_ACTION_BACK_TO_TOP) {
            ga gaVar = this.y;
            n.d(gaVar);
            gaVar.S.q1(0);
            mESSAGE_ACTION_BACK_TO_TOP = G1();
            n.d(mESSAGE_ACTION_BACK_TO_TOP);
            mESSAGE_ACTION_BACK_TO_TOP.p0();
        }
        if (h == h.MESSAGE_ACTION_CHALLENGE_FILTERS) {
            yOUR_TAB = this.z;
            n.d(yOUR_TAB);
            yOUR_TAB.q2((Map)bundle2.getSerializable(str3));
        }
        if (h == h.MESSAGE_ACTION_START_ENTRY_CREATION_FLOW) {
            mESSAGE_ACTION_START_ENTRY_CREATION_FLOW = this.z;
            n.d(mESSAGE_ACTION_START_ENTRY_CREATION_FLOW);
            mESSAGE_ACTION_START_ENTRY_CREATION_FLOW.Q2(G1());
        }
        if (h == h.MESSAGE_ACTION_COMMENT_COUNT_CHANGE) {
            obj8 = this.A;
            n.d(obj8);
            obj8.t2(bundle2.getString(str4), bundle2.getInt(str3));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public final void j3() {
        g0 g0Var = this.z;
        n.d(g0Var);
        androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.y.j jVar = g0Var.B0("challenge_home", g1.i(requireActivity));
        n.e(jVar, "screen");
        g1.n(requireActivity(), jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public i l2() {
        return i.CHALLENGE_HOME_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public final a m2() {
        return this.E;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public final SwipeRefreshLayout.j n2() {
        return this.H;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onActivityResult(int i, int i2, Intent intent3) {
        int i3;
        app.dogo.com.dogo_android.model.LiteDogProfile liteDogProfile;
        String str2;
        String str;
        int obj6;
        int obj7;
        Intent obj8;
        super.onActivityResult(i, i2, intent3);
        final int i4 = -1;
        if (i == 203 && i2 == i4) {
            if (i2 == i4) {
                i3 = this.z;
                n.d(i3);
                if (i3.U2(d.b(intent3).g())) {
                    obj8 = G1();
                    n.d(obj8);
                    g0 g0Var = this.z;
                    n.d(g0Var);
                    g0 g0Var2 = this.z;
                    n.d(g0Var2);
                    g0 g0Var3 = this.z;
                    n.d(g0Var3);
                    g0 g0Var4 = this.z;
                    n.d(g0Var4);
                    obj8.n0(g0Var.W(), g0Var2.x0(), g0Var3.G0(), g0Var4.H0());
                } else {
                    Z1(2131886123);
                }
            }
        }
        if (i == 11103 && i2 == i4) {
            if (i2 == i4) {
                obj6 = this.z;
                n.d(obj6);
                obj6.R2(G1(), true);
            }
            obj6 = this.F;
            n.d(obj6);
            obj6.updateDogAvatar();
            obj6 = this.A;
            n.d(obj6);
            obj6.notifyDataSetChanged();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        boolean obj2;
        int obj3;
        n.f(layoutInflater, "inflater");
        r obj4 = J1();
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type app.dogo.com.dogo_android.viewmodel.main_screen.challenge.ChallengeHomeViewModel");
        this.z = (g0)obj4;
        obj2 = ga.T(layoutInflater, viewGroup2, false);
        this.y = obj2;
        n.d(obj2);
        obj2.W(this.z);
        obj2 = this.y;
        n.d(obj2);
        obj2.V(G1());
        obj2 = this.z;
        n.d(obj2);
        obj2.o2(getArguments());
        obj2 = this.z;
        n.d(obj2);
        if (obj2.G2(getArguments())) {
            h2(getArguments());
        }
        obj2 = new k0.b(this);
        this.F = obj2;
        obj3 = this.y;
        obj3 = obj3 == null ? 0 : obj3.P;
        if (obj3 == null) {
        } else {
            obj3.U(obj2);
        }
        obj2 = this.y;
        if (obj2 == null) {
        } else {
            obj2 = obj2.P;
            if (obj2 == null) {
            } else {
                obj2 = obj2.Q;
                if (obj2 == null) {
                } else {
                    obj3 = new s(this);
                    obj2.setOnKeyListener(obj3);
                }
            }
        }
        obj2 = this.z;
        n.d(obj2);
        obj2.F2(k2(getContext()), G1());
        obj2 = this.z;
        n.d(obj2);
        obj3 = new m(this);
        obj2.z2().continueWith(obj3);
        obj2 = this.y;
        n.d(obj2);
        obj2 = obj2.w();
        n.e(obj2, "binding!!.root");
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onDestroy() {
        super.onDestroy();
        final g0 g0Var = this.z;
        n.d(g0Var);
        g0Var.j2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onPause() {
        super.onPause();
        g0 g0Var = this.z;
        n.d(g0Var);
        g0Var.L();
        g0 g0Var2 = this.z;
        n.d(g0Var2);
        g0Var2.j2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onResume() {
        super.onResume();
        g0 g0Var = this.z;
        n.d(g0Var);
        g0 g0Var3 = this.z;
        n.d(g0Var3);
        g0Var.y(g0Var3.a0());
        g0 g0Var2 = this.z;
        n.d(g0Var2);
        g0Var2.x();
    }
}
