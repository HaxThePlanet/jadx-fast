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
import app.dogo.com.dogo_android.h.ci;
import app.dogo.com.dogo_android.h.ga;
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
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.m;

/* compiled from: ChallengeHomeFragmentLegacy.kt */
@Metadata(d1 = "\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010&\u001a\u00020'2\u0008\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0008\u0010*\u001a\u00020'H\u0002J\u0012\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0008\u0010/\u001a\u000200H\u0016J\u000e\u00101\u001a\u0008\u0012\u0004\u0012\u00020302H\u0014J\u0008\u00104\u001a\u000205H\u0016J\u0008\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010:09H\u0016J\"\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0008\u0010>\u001a\u0004\u0018\u00010?H\u0016J$\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020B2\u0008\u0010C\u001a\u0004\u0018\u00010D2\u0008\u0010E\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020)H\u0016J\u0008\u0010I\u001a\u00020'H\u0016J\u0010\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u000207H\u0016J\u0008\u0010L\u001a\u00020'H\u0016J\u0008\u0010M\u001a\u00020'H\u0016J\u0008\u0010N\u001a\u00020'H\u0002J\u0008\u0010O\u001a\u00020'H\u0002J\u0008\u0010P\u001a\u00020'H\u0003J\u0010\u0010Q\u001a\u00020'2\u0006\u0010R\u001a\u00020SH\u0002J\u0008\u0010T\u001a\u00020'H\u0002J\u0018\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\rH\u0002J\u0006\u0010Y\u001a\u00020'J\u0018\u0010Z\u001a\u00020'2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\"\u0010#\u001a\u0004\u0008 \u0010!R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectCallback;", "()V", "adapter", "Lapp/dogo/com/dogo_android/util/recycle_views/ChallengeEntryListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentChallengeHomeBinding;", "commentBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "navBarSize", "", "newEntryBubblePositionChangeCallback", "Lapp/dogo/com/dogo_android/util/listeners/SimpleClickCallBack;", "getNewEntryBubblePositionChangeCallback", "()Lapp/dogo/com/dogo_android/util/listeners/SimpleClickCallBack;", "setNewEntryBubblePositionChangeCallback", "(Lapp/dogo/com/dogo_android/util/listeners/SimpleClickCallBack;)V", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "getOnRefreshListener", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "setOnRefreshListener", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;)V", "scrollListener", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "scrollObserver", "Lcom/github/ksoichiro/android/observablescrollview/ObservableScrollViewCallbacks;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "vm", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeHomeViewModel;", "callEntryCreation", "", "arguments", "Landroid/os/Bundle;", "clearGlideCache", "createTitleView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/FragmentTags;", "getMessagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDataReceived", "action", "mail", "onDestroy", "onEntryImageDogSelect", "dogId", "onPause", "onResume", "openNotificationWindow", "setupListeners", "setupObservers", "setupRecycleView", "recyclerView", "Lcom/github/ksoichiro/android/observablescrollview/ObservableRecyclerView;", "shareToFriends", "showDeleteCommentDialog", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "position", "showPremiumScreen", "showReportDialog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k0, reason: from kotlin metadata */
public final class ChallengeHomeFragmentLegacy extends app.dogo.com.dogo_android.util.e0.w implements app.dogo.com.dogo_android.q.q.g {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final k0.a INSTANCE = new k0$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private e adapter;
    /* renamed from: B, reason: from kotlin metadata */
    private com.github.ksoichiro.android.observablescrollview.a binding;
    /* renamed from: C, reason: from kotlin metadata */
    private app.dogo.com.dogo_android.util.n0.k commentBarManager;
    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayoutManager layoutManager;
    /* renamed from: E, reason: from kotlin metadata */
    private app.dogo.com.dogo_android.util.l0.a navBarSize;
    private app.dogo.com.dogo_android.util.k0.d F;
    private int G;
    /* renamed from: H, reason: from kotlin metadata */
    private SwipeRefreshLayout.j scrollListener = new a0();
    /* renamed from: x, reason: from kotlin metadata */
    private final kotlin.h scrollObserver;
    private ga y;
    private g0 z;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$Companion;", "", "()V", "GENERAL_BACK_TOP_CLICKED", "", "GENERAL_SORT_24_HOURS_CLICKED", "GENERAL_SORT_7_DAYS_CLICKED", "GENERAL_SORT_COUNTRY_CLICKED", "GENERAL_SORT_LATEST_CLICKED", "GENERAL_SORT_POPULAR_CLICKED", "GENERAL_SORT_YOUR_CLICKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000cH\u0016¨\u0006\r", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$setupListeners$2", "Lcom/github/ksoichiro/android/observablescrollview/ObservableScrollViewCallbacks;", "onDownMotionEvent", "", "onScrollChanged", "scrollY", "", "firstScroll", "", "dragging", "onUpOrCancelMotionEvent", "scrollState", "Lcom/github/ksoichiro/android/observablescrollview/ScrollState;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements com.github.ksoichiro.android.observablescrollview.a {

        final /* synthetic */ k0 a;
        c() {
            this.a = k0Var;
            super();
        }

        private static final void f(k0 k0Var) {
            n.f(k0Var, "this$0");
            ga gaVar = k0Var.y;
            n.d(gaVar);
            gaVar.Q.setVisibility(0);
        }

        private static final void g(k0 k0Var) {
            n.f(k0Var, "this$0");
            ga gaVar = k0Var.y;
            n.d(gaVar);
            gaVar.Q.setVisibility(8);
        }

        public void a(com.github.ksoichiro.android.observablescrollview.b bVar) {
            int i;
            com.github.ksoichiro.android.observablescrollview.b dOWN2;
            com.github.ksoichiro.android.observablescrollview.b uP2;
            app.dogo.com.dogo_android.view.main_screen.j.k0 k0Var;
            app.dogo.com.dogo_android.view.main_screen.j.e0 e0Var;
            n.f(bVar, "scrollState");
            ga gaVar = this.a.y;
            n.d(gaVar);
            i = 0;
            i = 1;
            int r0 = gaVar.Q.getVisibility() == 0 ? i : 0;
            app.dogo.com.dogo_android.util.e0.a0 a0Var = this.a.G1();
            n.d(a0Var);
            if (a0Var.C() == 0) {
            }
            g0 g0Var = this.a.z;
            n.d(g0Var);
            g0Var.G();
            app.dogo.com.dogo_android.util.l0.a aVar = this.a.m2();
            n.d(aVar);
            aVar.a();
            g0 g0Var2 = this.a.z;
            n.d(g0Var2);
            g0Var2.V2();
            if (bVar == b.DOWN && this.a == 0) {
                g0 g0Var3 = this.a.z;
                n.d(g0Var3);
                if (g0Var3.V0() && g0Var4.Z0()) {
                    g0 g0Var5 = this.a.z;
                    n.d(g0Var5);
                    g0Var5.f2();
                    ga gaVar2 = this.a.y;
                    n.d(gaVar2);
                    float f2 = 1f;
                    gaVar2.Q.animate().setDuration(0L).scaleX(f2).scaleY(f2).withStartAction(new app.dogo.com.dogo_android.view.main_screen.challenge.e0(this.a)).start();
                    g0 g0Var6 = this.a.z;
                    n.d(g0Var6);
                    g0Var6.W2();
                }
                if (i == 0) {
                    app.dogo.com.dogo_android.util.e0.a0 a0Var2 = this.a.G1();
                    n.d(a0Var2);
                    a0Var2.p0();
                }
            }
            if (bVar == b.UP && this.a != 0) {
                ga gaVar3 = this.a.y;
                n.d(gaVar3);
                float f = 0.0f;
                gaVar3.Q.animate().setDuration(200L).scaleX(f).scaleY(f).withEndAction(new app.dogo.com.dogo_android.view.main_screen.challenge.d0(this.a)).start();
                e eVar = this.a.adapter;
                n.d(eVar);
                if (eVar.W0() == i && i != 0) {
                    app.dogo.com.dogo_android.util.e0.a0 a0Var3 = this.a.G1();
                    n.d(a0Var3);
                    a0Var3.F();
                }
            }
        }

        /* renamed from: c, reason: from kotlin metadata */
        public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
            app.dogo.com.dogo_android.util.l0.a aVar = this.a.m2();
            n.d(aVar);
            aVar.a();
        }

        /* renamed from: d, reason: from kotlin metadata */
        public static /* synthetic */ void onUpOrCancelMotionEvent(k0 scrollState) {
            ChallengeHomeFragmentLegacy_setupListeners_2.g(scrollState);
        }

        public static /* synthetic */ void e(k0 k0Var) {
            ChallengeHomeFragmentLegacy_setupListeners_2.f(k0Var);
        }

        /* renamed from: b, reason: from kotlin metadata */
        public void onDownMotionEvent() {
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$setupRecycleView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends RecyclerView.u {

        final /* synthetic */ k0 a;
        e() {
            this.a = k0Var;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            n.f(recyclerView, "recyclerView");
            int i2 = 7;
            boolean z2 = true;
            int i = 15;
            if (dy > 15) {
                LinearLayoutManager linearLayoutManager = this.a.layoutManager;
                n.d(linearLayoutManager);
                if (linearLayoutManager.w2() >= i2) {
                    g0 g0Var = this.a.z;
                    n.d(g0Var);
                    g0Var.p2(z2);
                }
            }
            final boolean z = false;
            if (dy < -15) {
                LinearLayoutManager linearLayoutManager4 = this.a.layoutManager;
                n.d(linearLayoutManager4);
                if (linearLayoutManager4.w2() < i2) {
                    ga gaVar = this.a.y;
                    n.d(gaVar);
                    if (!gaVar.P.Q.hasFocus()) {
                        g0 g0Var5 = this.a.z;
                        n.d(g0Var5);
                        g0Var5.p2(z);
                    }
                }
            }
            LinearLayoutManager linearLayoutManager2 = this.a.layoutManager;
            n.d(linearLayoutManager2);
            if (linearLayoutManager2.v2() >= 2) {
                g0 g0Var4 = this.a.z;
                n.d(g0Var4);
                g0Var4.y0().hideNotifications(z);
            } else {
                g0 g0Var3 = this.a.z;
                n.d(g0Var3);
                g0Var3.y0().hideNotifications(z2);
            }
            LinearLayoutManager linearLayoutManager3 = this.a.layoutManager;
            n.d(linearLayoutManager3);
            int i3 = linearLayoutManager3.w2();
            int i5 = 6;
            if (i3 >= 6) {
                e eVar = this.a.adapter;
                n.d(eVar);
                i5 = eVar.getItemCount() - z2;
                if (i3 == eVar.getItemCount() - z2) {
                    g0 g0Var2 = this.a.z;
                    n.d(g0Var2);
                    g0Var2.p2(z2);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$setupListeners$3", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends app.dogo.com.dogo_android.util.n0.k {

        final /* synthetic */ k0 d;
        d() {
            this.d = k0Var;
            super(5);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        /* renamed from: a, reason: from kotlin metadata */
        public void onLoadMore() {
            g0 g0Var = this.d.z;
            n.d(g0Var);
            g0Var.X1();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ f $item;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            k0.this.k3((ChallengeCommentItem)this.$item.g(), this.$position);
        }

        f(f fVar, int i) {
            this.$item = fVar;
            this.$position = i;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ f $item;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            k0.this.i3((ChallengeCommentItem)this.$item.g(), this.$position);
        }

        g(f fVar, int i) {
            this.$item = fVar;
            this.$position = i;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements kotlin.d0.c.l<String, kotlin.w> {

        final /* synthetic */ f $item;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            str2 = "it";
            n.f(str, str2);
            g0 g0Var = k0.this.z;
            n.d(g0Var);
            if (!g0Var.R0()) {
                g0 g0Var2 = k0.this.z;
                n.d(g0Var2);
                if (!g0Var2.Y0((ChallengeCommentItem)this.$item.g())) {
                    e eVar = k0.this.adapter;
                    if (eVar != null) {
                        eVar.removeItem(this.$position);
                    }
                }
            }
        }

        h(f fVar, int i) {
            this.$item = fVar;
            this.$position = i;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ ChallengeComment $model;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            if (this.$model.getDocumentId() == null) {
                int $position2 = 2131886123;
                k0.this.Z1($position2);
            } else {
                g0 g0Var = k0.this.z;
                n.d(g0Var);
                g0Var.a2(this.$model, k0.this.l2().getTag());
                g0 g0Var2 = k0.this.z;
                n.d(g0Var2);
                if (g0Var2.H2(this.$model)) {
                    e eVar = k0.this.adapter;
                    n.d(eVar);
                    eVar.removeItem(this.$position);
                } else {
                    e eVar2 = k0.this.adapter;
                    n.d(eVar2);
                    eVar2.q2(this.$position);
                }
            }
        }

        i(ChallengeComment challengeComment, k0 k0Var, int i) {
            this.$model = challengeComment;
            this.$position = i;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends p implements kotlin.d0.c.l<String, kotlin.w> {

        final /* synthetic */ ChallengeComment $model;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            str2 = "it";
            n.f(str, str2);
            g0 g0Var = k0.this.z;
            n.d(g0Var);
            if (!g0Var.R0()) {
                g0 g0Var2 = k0.this.z;
                n.d(g0Var2);
                if (!g0Var2.Y0(this.$model)) {
                    e eVar = k0.this.adapter;
                    if (eVar != null) {
                        eVar.removeItem(this.$position);
                    }
                }
            }
        }

        j(ChallengeComment challengeComment, int i) {
            this.$model = challengeComment;
            this.$position = i;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class k extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public k(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeHomeFragmentLegacy$onCreateView$1", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getUserDogIcon", "Landroid/net/Uri;", "isUserPremiumBadgeVisible", "", "onAvatarClick", "", "onSendActionListener", "currentText", "", "replyTarget", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "permissionCheck", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.util.k0.d {

        final /* synthetic */ k0 a;
        b() {
            this.a = k0Var;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public Uri getUserDogIcon() {
            int i = 0;
            g0 g0Var = this.a.z;
            if (g0Var == null) {
                i = 0;
            } else {
                Uri uri = g0Var.D0();
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean isUserPremiumBadgeVisible() {
            g0 g0Var = this.a.z;
            n.d(g0Var);
            return g0Var.b1();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onAvatarClick() {
            g0 g0Var = this.a.z;
            n.d(g0Var);
            if (g0Var.f0() > 0) {
                app.dogo.com.dogo_android.util.e0.a0 a0Var = this.a.G1();
                n.d(a0Var);
                str = "challenge_profile_dog_select_request";
                str2 = "challenge_home";
                a0Var.l0(str, str2);
            } else {
                a0Var = this.a.G1();
                n.d(a0Var);
                g0 g0Var2 = this.a.z;
                n.d(g0Var2);
                a0Var.w0(g0Var2.b0().getId(), 11100);
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onSendActionListener(String currentText, ChallengeComment replyTarget) {
            n.f(currentText, "currentText");
            g0 g0Var = this.a.z;
            n.d(g0Var);
            if (g0Var.a3(currentText, replyTarget, this.a.G1())) {
                clearCommentField();
            }
            this.a.M1();
            LinearLayoutManager linearLayoutManager = this.a.layoutManager;
            n.d(linearLayoutManager);
            linearLayoutManager.S1(7);
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean permissionCheck() {
            return true;
        }
    }

    public k0() {
        super();
        final m.a.c.j.a aVar = null;
        this.scrollObserver = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.view.main_screen.challenge.k0.k(this, aVar, aVar));
        app.dogo.com.dogo_android.view.main_screen.j.a0 a0Var = new app.dogo.com.dogo_android.view.main_screen.challenge.a0(this);
    }

    private static final boolean J2(k0 k0Var, View view, int i, KeyEvent keyEvent) {
        n.f(k0Var, "this$0");
        if (i == 4) {
            n.d(k0Var.y);
            gaVar.P.S.requestFocus();
            Objects.requireNonNull(k0Var.F, "null cannot be cast to non-null type app.dogo.com.dogo_android.util.interfaces.CommentBarManager");
            k0Var.F.clearCommentField();
            return true;
        }
        return false;
    }

    private static final Object K2(k0 k0Var, com.google.android.gms.tasks.j jVar) {
        n.f(k0Var, "this$0");
        if (!k0Var.isStateSaved()) {
            n.d(k0Var.z);
            k0Var.z.B2();
            app.dogo.com.dogo_android.util.e0.a0 a0Var = k0Var.G1();
            n.d(a0Var);
            k0Var.G = a0Var.D();
            k0Var.O2();
            n.d(k0Var.y);
            str = "binding!!.recycleView";
            n.e(gaVar.S, str);
            k0Var.f3(gaVar.S);
            k0Var.Q2();
            n.d(k0Var.z);
            k0Var.z.i2();
        }
        return null;
    }

    private static final void L2(k0 k0Var, View view) {
        n.f(k0Var, "this$0");
        n.d(k0Var.z);
        k0Var.z.A(k0Var.G1());
    }

    /* renamed from: M2, reason: from kotlin metadata */
    private static final void createTitleView(k0 context) {
        n.f(context, "this$0");
        n.d(context.z);
        if (context.z.c3()) {
            n.d(context.commentBarManager);
            context.commentBarManager.b();
            n.d(context.adapter);
            context.adapter.j2();
            n.d(context.z);
            context.z.l2();
            n.d(context.z);
            context.z.A2();
            n.d(context.z);
            context.z.d2();
        } else {
            n.d(context.z);
            context.z.i2();
        }
        context.c.logEvent(E_Challenges.z);
        app.dogo.com.dogo_android.util.l0.a aVar = context.m2();
        n.d(aVar);
        aVar.a();
        context.M1();
    }

    /* renamed from: N2, reason: from kotlin metadata */
    private final void clearGlideCache() {
        final app.dogo.com.dogo_android.util.e0.a0 a0Var = G1();
        if (a0Var != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("hasBackArrow", true);
            int i = 2130772003;
            int i2 = 0;
            a0Var.I0(FragmentTags.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT, bundle, i, i2);
        }
    }

    private final void O2() {
        this.navBarSize = new app.dogo.com.dogo_android.view.main_screen.challenge.o(this);
        this.binding = new ChallengeHomeFragmentLegacy_setupListeners_2(this);
        this.commentBarManager = new ChallengeHomeFragmentLegacy_setupListeners_3(this);
    }

    /* renamed from: P2, reason: from kotlin metadata */
    private static final void onEntryImageDogSelect(k0 dogId) {
        n.f(dogId, "this$0");
        n.d(dogId.y);
        n.d(dogId.z);
        n.d(dogId.adapter);
        gaVar.R.setY(dogId.z.M(adapter2.F0));
    }

    private final void Q2() {
        n.d(this.z);
        this.z.V().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.c0(this));
        n.d(this.z);
        this.z.o0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.u(this));
        n.d(this.z);
        this.z.p0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.w(this));
        n.d(this.z);
        this.z.t0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.g0(this));
        n.d(this.z);
        this.z.l0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.b0(this));
        n.d(this.z);
        this.z.i0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.t(this));
        n.d(this.z);
        this.z.k0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.p(this));
        n.d(this.z);
        this.z.K0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.l(this));
        n.d(this.z);
        this.z.s0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.x(this));
        n.d(this.z);
        this.z.q0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.y(this));
        n.d(this.z);
        this.z.g0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.f0(this));
        getSharedViewModel().E().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.view.main_screen.challenge.q(this));
        n.d(this.z);
        androidx.lifecycle.q viewLifecycleOwner13 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner13, "viewLifecycleOwner");
        this.z.w0().observe(viewLifecycleOwner13, new app.dogo.com.dogo_android.view.main_screen.challenge.v(this));
    }

    private static final void R2(k0 k0Var, List list) {
        str = "this$0";
        n.f(k0Var, str);
        if (list != null) {
            n.d(k0Var.adapter);
            k0Var.adapter.g2(list);
        }
        n.d(k0Var.y);
        if (gaVar2.U.h()) {
            n.d(k0Var.y);
            boolean z = false;
            gaVar.U.setRefreshing(z);
        }
    }

    private static final void S2(k0 k0Var, Boolean boolean) {
        n.f(k0Var, "this$0");
        if (boolean != null && boolean.booleanValue()) {
            n.d(k0Var.binding);
            k0Var.binding.a(b.UP);
        }
    }

    private static final void T2(k0 k0Var, List list) {
        int i = 7;
        String documentId = null;
        str = "this$0";
        n.f(k0Var, str);
        if (list != null) {
            n.d(k0Var.adapter);
            int i2 = 0;
            if (list.isEmpty()) {
                int i4 = 0;
            } else {
                documentId = (EntryUserPhotoItem)list.get(i2).getModel().getDocumentId();
            }
            k0Var.adapter.y2(documentId);
            n.d(k0Var.z);
            if (k0Var.z.z0() == app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.c.User) {
                n.d(k0Var.adapter);
                k0Var.adapter.z2(list);
                n.d(k0Var.layoutManager);
                i = 7;
                if (k0Var.layoutManager.w2() >= 7) {
                    n.d(k0Var.z);
                    k0Var.z.p2(true);
                }
                n.d(k0Var.y);
                if (gaVar2.U.h()) {
                    n.d(k0Var.y);
                    gaVar.U.setRefreshing(false);
                }
            }
        }
    }

    private static final void U2(k0 k0Var, List list) {
        str = "this$0";
        n.f(k0Var, str);
        if (list != null) {
            n.d(k0Var.adapter);
            k0Var.adapter.i2(list);
        }
        n.d(k0Var.y);
        if (gaVar2.U.h()) {
            n.d(k0Var.y);
            boolean z = false;
            gaVar.U.setRefreshing(z);
        }
    }

    private static final void V2(k0 k0Var, Integer integer) {
        str = "this$0";
        n.f(k0Var, str);
        if (integer != null) {
            n.d(k0Var.y);
            gaVar.S.q1(integer.intValue());
            if (integer.intValue() == 0) {
                app.dogo.com.dogo_android.util.e0.a0 a0Var = k0Var.G1();
                n.d(a0Var);
                a0Var.p0();
            }
        }
    }

    private static final void W2(k0 k0Var, Boolean boolean) {
        n.f(k0Var, "this$0");
        if (boolean != null) {
            n.d(k0Var.adapter);
            k0Var.adapter.p2();
        }
    }

    private static final void X2(k0 k0Var, y yVar) {
        int i = 0;
        n.f(k0Var, "this$0");
        n.e(yVar, "it");
        yVar = app.dogo.com.dogo_android.util.base_classes.z.b(yVar) instanceof DogProfile ? (DogProfile)app.dogo.com.dogo_android.util.base_classes.z.b(yVar) : 0;
        if (i != 0) {
            if (k0Var.F != null) {
                k0Var.F.updateDogAvatar();
            }
            if (k0Var.adapter != null) {
                k0Var.adapter.notifyDataSetChanged();
            }
        }
    }

    private static final void Y2(k0 k0Var, List list) {
        n.f(k0Var, "this$0");
        n.d(k0Var.z);
    }

    private static final void Z2(k0 k0Var, Boolean boolean) {
        int i2 = 0;
        str = "this$0";
        n.f(k0Var, str);
        if (boolean != null) {
            n.d(k0Var.y);
            int i = 8;
            gaVar3.O.setVisibility(i);
            n.d(k0Var.z);
            if (!k0Var.z.W0()) {
                n.d(k0Var.z);
                k0Var.z.K2(k0Var.getContext(), new app.dogo.com.dogo_android.view.main_screen.challenge.n(k0Var));
            }
            int r1 = k0Var.y == null ? 0 : gaVar2.U;
            if (i2 != 0) {
                n.d(k0Var.y);
                if (gaVar2.U.h() && k0Var.y == null) {
                    if (i2 != 0) {
                        i2.setRefreshing(false);
                    }
                }
            }
        }
    }

    /* renamed from: a3, reason: from kotlin metadata */
    private static final void setupRecycleView(k0 recyclerView) {
        n.f(recyclerView, "this$0");
        recyclerView.n2().onRefresh();
    }

    public static final /* synthetic */ e b2(k0 k0Var) {
        return k0Var.adapter;
    }

    private static final void b3(k0 k0Var, Boolean boolean) {
        n.f(k0Var, "this$0");
        k0Var.j2();
        n.d(k0Var.commentBarManager);
        k0Var.commentBarManager.b();
        n.d(k0Var.adapter);
        k0Var.adapter.j2();
        n.d(k0Var.y);
        gaVar.S.q1(2);
        n.d(k0Var.z);
        k0Var.z.A2();
        n.d(k0Var.z);
        n.d(k0Var.z);
        k0Var.z.Z2(k0Var.z.W());
        k0Var.M1();
    }

    public static final /* synthetic */ ga c2(k0 k0Var) {
        return k0Var.y;
    }

    private static final void c3(k0 k0Var, Boolean boolean) {
        n.f(k0Var, "this$0");
        if (boolean != null) {
            n.d(k0Var.adapter);
            k0Var.adapter.u2();
        }
    }

    public static final /* synthetic */ LinearLayoutManager d2(k0 k0Var) {
        return k0Var.layoutManager;
    }

    private static final void d3(k0 k0Var, List list) {
        str = "this$0";
        n.f(k0Var, str);
        if (list != null) {
            if (!list.isEmpty()) {
                n.d(k0Var.adapter);
                k0Var.adapter.Z(6, list);
            }
        }
    }

    public static final /* synthetic */ g0 e2(k0 k0Var) {
        return k0Var.z;
    }

    private static final void e3(k0 k0Var, Boolean boolean) {
        n.f(k0Var, "this$0");
        if (boolean != null) {
            n.d(k0Var.z);
            k0Var.z.W2();
            n.d(k0Var.adapter);
            n.d(k0Var.z);
            k0Var.adapter.r2(k0Var.z.W());
        }
    }

    /* renamed from: f2, reason: from kotlin metadata */
    public static final /* synthetic */ void onActivityResult(k0 requestCode, ChallengeComment resultCode, int data) {
        requestCode.i3(resultCode, data);
    }

    private final void f3(ObservableRecyclerView observableRecyclerView) {
        ArrayList arrayList = new ArrayList();
        n.d(this.z);
        ChallengeTitleItem challengeTitleItem = this.z.X();
        n.e(challengeTitleItem, "vm!!.challengeTitleCell");
        arrayList.add(challengeTitleItem);
        n.d(this.z);
        app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem entryTitleItem = this.z.C0();
        n.e(entryTitleItem, "vm!!.titleCell");
        arrayList.add(entryTitleItem);
        n.d(this.z);
        EntrySortingTabItem entrySortingTabItem = this.z.y0();
        n.e(entrySortingTabItem, "vm!!.sortingCell");
        arrayList.add(entrySortingTabItem);
        n.d(this.z);
        app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterItem entryFilterItem = this.z.m0();
        n.e(entryFilterItem, "vm!!.filterCell");
        arrayList.add(entryFilterItem);
        n.d(this.z);
        app.dogo.com.dogo_android.model.entry_list_item_models.InviteFriendsBannerItem inviteFriendsBannerItem = this.z.n0();
        n.e(inviteFriendsBannerItem, "vm!!.inviteFriendsCell");
        arrayList.add(inviteFriendsBannerItem);
        n.d(this.z);
        app.dogo.com.dogo_android.model.entry_list_item_models.BecomePremiumBannerItem becomePremiumBannerItem = this.z.S();
        n.e(becomePremiumBannerItem, "vm!!.becomePremiumCell");
        arrayList.add(becomePremiumBannerItem);
        n.d(this.z);
        app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerItem sponsorBannerItem = this.z.A0();
        n.e(sponsorBannerItem, "vm!!.sponsorCell");
        arrayList.add(sponsorBannerItem);
        final app.dogo.com.dogo_android.util.e0.a0 a0Var = G1();
        n.d(a0Var);
        app.dogo.com.dogo_android.util.recycle_views.e eVar = new app.dogo.com.dogo_android.util.recycle_views.e(arrayList, this.z, a0Var, F1(), l2());
        this.adapter = eVar;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.layoutManager = linearLayoutManager;
        observableRecyclerView.setLayoutManager(linearLayoutManager);
        observableRecyclerView.setAdapter(this.adapter);
        n.d(this.adapter);
        boolean z = true;
        this.adapter.M1(z);
        this.adapter.N1(z);
        n.d(this.y);
        n.e(gaVar.U, "binding!!.swipeRefreshLayout");
        gaVar.U.setOnRefreshListener(this.scrollListener);
        n.d(this.commentBarManager);
        observableRecyclerView.l(this.commentBarManager);
        observableRecyclerView.l(new ChallengeHomeFragmentLegacy_setupRecycleView_1(this));
        observableRecyclerView.setScrollViewCallbacks(this.binding);
        n.d(this.binding);
        this.binding.a(b.DOWN);
        n.d(this.adapter);
        this.adapter.a0(new app.dogo.com.dogo_android.view.main_screen.challenge.k(this));
    }

    /* renamed from: g2, reason: from kotlin metadata */
    public static final /* synthetic */ void onCreateView(k0 inflater, ChallengeComment container, int savedInstanceState) {
        inflater.k3(container, savedInstanceState);
    }

    private static final boolean g3(k0 k0Var, View view, int i) {
        boolean z3;
        int i9 = 2131363058;
        int i7 = 2131363061;
        ChallengeComment challengeComment;
        int i10;
        app.dogo.com.dogo_android.view.main_screen.j.k0.h hVar;
        Object k0Var2 = k0Var;
        i32 = i;
        n.f(k0Var2, "this$0");
        n.f(view, "view");
        n.d(k0Var2.adapter);
        f fVar = k0Var2.adapter.O0(i32);
        z3 = fVar instanceof ChallengeCommentItem;
        if (fVar instanceof ChallengeCommentItem) {
            int i8 = 2131362294;
            if (view.getId() == 2131362294) {
                n.d(k0Var2.z);
                if (k0Var2.z.Y0(fVar.g())) {
                    n.d(k0Var2.z);
                    if (k0Var2.z.X0(fVar.g())) {
                        k0Var2.i3(fVar.g(), i32);
                    } else {
                        androidx.fragment.app.e activity = k0Var.getActivity();
                        if (activity != null) {
                            app.dogo.com.dogo_android.util.extensionfunction.f1.J(activity, new app.dogo.com.dogo_android.view.main_screen.challenge.k0.f(k0Var2, fVar, i32), new app.dogo.com.dogo_android.view.main_screen.challenge.k0.g(k0Var2, fVar, i32));
                        }
                    }
                }
            }
            i9 = 2131363058;
            if (view.getId() == 2131363058 && k0Var2.y == null) {
                n.d(k0Var2.y);
                k0Var2.Y1(gaVar2.P.Q);
            }
            i7 = 2131363061;
            boolean z5 = true;
            if (view.getId() == 2131363061) {
                String entryId = fVar.g().getEntryId();
                String documentId = fVar.g().getDocumentId();
                if (entryId == null || l.z(entryId)) {
                    i10 = z5;
                }
                if (i10 == 0 && documentId != null) {
                    if (l.z(documentId)) {
                        i10 = z5;
                    } else {
                        i10 = 0;
                    }
                    if (i10 == 0) {
                        App.INSTANCE.r().logEvent(E_Challenges.B);
                        androidx.fragment.app.e requireActivity = k0Var.requireActivity();
                        n.e(requireActivity, "requireActivity()");
                        app.dogo.com.dogo_android.util.extensionfunction.g1.T(requireActivity, entryId, documentId, new app.dogo.com.dogo_android.view.main_screen.challenge.k0.h(k0Var2, fVar, i32));
                    }
                }
            }
            int i6 = 2131362217;
            if (view.getId() == 2131362217) {
                if ((ChallengeCommentItem)fVar.g().isSpam()) {
                    Bundle bundle = new Bundle();
                    n.d(k0Var2.z);
                    bundle.putParcelable("challenge", k0Var2.z.W());
                    bundle.putBoolean("show_rules", z5);
                    bundle.putBoolean("hide_participate_button", z5);
                    bundle.putInt("style", 2131951968);
                    app.dogo.com.dogo_android.util.e0.a0 a0Var2 = k0Var.G1();
                    n.d(a0Var2);
                    a0Var2.k(DialogTags.CHALLENGE_DETAILS_DIALOG, bundle);
                }
            }
            if (view.getId() == 2131362981) {
                ChallengeComment challengeComment5 = fVar.g();
                String str = null;
                String str2 = null;
                int i11 = 0;
                boolean z7 = true;
                Long l = null;
                int i12 = 1024;
                kotlin.d0.d.g gVar2 = null;
                DogProfileModel dogProfileModel = new DogProfileModel(challengeComment5.getDogName(), challengeComment5.getDogAvatarUrl(), null, str, Long.valueOf(0L), str2, i11, challengeComment5.getDogId(), num, z7, l, i12, gVar2);
                app.dogo.com.dogo_android.util.e0.a0 a0Var = k0Var.G1();
                n.d(a0Var);
                a0Var.f0(dogProfileModel, fVar.g().getBadges());
            }
        }
        if (fVar instanceof InviteFriendsBannerItem) {
            k0Var.h3();
        }
        if (fVar instanceof BecomePremiumBannerItem) {
            k0Var.j3();
        }
        z = fVar instanceof EntrySortingTabItem;
        if (fVar instanceof EntrySortingTabItem && view.getId() == ChallengeTitleItem.NOTIFICATION_CLICK_AREA) {
            k0Var.clearGlideCache();
        }
        z2 = fVar instanceof ChallengeTitleItem;
        if (fVar instanceof ChallengeTitleItem) {
            if (view.getId() == ChallengeTitleItem.NOTIFICATION_CLICK_AREA) {
                k0Var.clearGlideCache();
            }
        }
        return false;
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.scrollObserver.getValue();
    }

    private final void h2(Bundle bundle) {
        B1();
        n.d(this.z);
        this.z.O(bundle).addOnCompleteListener(new app.dogo.com.dogo_android.view.main_screen.challenge.z(this));
    }

    private final void h3() throws android.content.res.Resources.NotFoundException {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        String string = getResources().getString(2131886783);
        n.e(string, "resources.getString(R.string.invite_friends_text)");
        String str5 = App.INSTANCE.n().A();
        final StringBuilder stringBuilder = new StringBuilder();
        str2 = string + 32 + str5;
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        app.dogo.com.dogo_android.util.e0.a0 a0Var = G1();
        n.d(a0Var);
        a0Var.startActivity(Intent.createChooser(intent, "..."));
        this.c.logEvent(E_General.d);
    }

    private static final void i2(k0 k0Var, com.google.android.gms.tasks.j jVar) {
        n.f(k0Var, "this$0");
        n.f(jVar, "entryCreationDataFetchTask");
        app.dogo.com.dogo_android.util.e0.a0 a0Var = k0Var.G1();
        int i = 0;
        if (a0Var == null) {
            a.c("Navigator is not attached", new Object[i]);
        } else {
            k0Var.C1();
            if (jVar.isSuccessful()) {
                Object result = jVar.getResult();
                a0Var.n0(result.a(), result.d(), result.b(), result.c());
            } else {
                str = "Entry creation failed";
                a.e(jVar.getException(), str, new Object[i]);
            }
        }
    }

    private final void i3(ChallengeComment challengeComment, int i) {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.f1.showInputDialog(activity, new app.dogo.com.dogo_android.view.main_screen.challenge.k0.i(challengeComment, this, i));
        }
    }

    private final void j2() {
        c.c(requireContext()).b();
    }

    private final View k2(Context context) {
        View inflate = LayoutInflater.from(context).inflate(2131558484, new FrameLayout(requireContext()), false);
        n.e(inflate, "from(context).inflate(R.layout.cell_entry_challenge_pager_item, frameLayout, false)");
        return inflate;
    }

    private final void k3(ChallengeComment challengeComment, int i) {
        boolean z;
        final String entryId = challengeComment.getEntryId();
        final String documentId = challengeComment.getDocumentId();
        i = 0;
        i = 1;
        if (entryId == null || l.z(entryId)) {
        }
        if (i == 0 && documentId != null) {
            if (l.z(documentId)) {
            }
            if (i == 0) {
                App.INSTANCE.r().logEvent(E_Challenges.B);
                androidx.fragment.app.e requireActivity = requireActivity();
                n.e(requireActivity, "requireActivity()");
                app.dogo.com.dogo_android.util.extensionfunction.g1.T(requireActivity, entryId, documentId, new app.dogo.com.dogo_android.view.main_screen.challenge.k0.j(this, challengeComment, i));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    protected Set<app.dogo.com.dogo_android.k.h> E1() {
        final HashSet hashSet = new HashSet();
        hashSet.add(FragmentMessageAction.MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE);
        hashSet.add(FragmentMessageAction.MESSAGE_ACTION_CHALLENGE_FILTERS);
        hashSet.add(FragmentMessageAction.MESSAGE_ACTION_BACK_TO_TOP);
        hashSet.add(FragmentMessageAction.MESSAGE_ACTION_SWITCH_TO_YOUR_TAB);
        hashSet.add(FragmentMessageAction.MESSAGE_ACTION_START_ENTRY_CREATION_FLOW);
        hashSet.add(FragmentMessageAction.MESSAGE_ACTION_COMMENT_COUNT_CHANGE);
        return hashSet;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public k3 H1() {
        return S.challengeShare;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public String I1() {
        String string = getString(2131886332);
        n.e(string, "getString(R.string.challenges_tittle)");
        return string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void U(String str) {
        int i;
        ChallengeModel challengeModel;
        String str3;
        app.dogo.com.dogo_android.model.LiteDogProfile liteDogProfile;
        Uri uri;
        n.f(str, "dogId");
        androidx.fragment.app.e activity = getActivity();
        i = 1;
        final boolean z2 = false;
        boolean r0 = z2;
        if (this.z != 0 && this.z != null && this.z == null) {
            int i2 = str2;
            if (this.z == null) {
                int i4 = str2;
            } else {
                str3 = challengeModel.getId();
            }
            if (this.z == null) {
                int i3 = str2;
            } else {
                liteDogProfile = this.z.r0(str);
            }
            boolean r6 = z2;
            if (this.z == null || !n.b(SpecialChallenges.WELCOME_CHALLENGE.getId(), str3) || this.z == null || this.z == 0) {
                i = z2;
            }
            if (i != 0) {
                if (this.z != null) {
                    if (this.z == null) {
                        int i5 = str2;
                    } else {
                        uri = this.z.e0(str);
                    }
                    this.z.U2(uri);
                }
                app.dogo.com.dogo_android.util.e0.a0 a0Var = G1();
                if (a0Var != null) {
                    a0Var.n0(challengeModel, liteDogProfile, str2, str2);
                }
            } else {
                if (this.z != null) {
                    this.z.n2(str);
                }
                a0Var = G1();
                if (a0Var != null) {
                    i = 800;
                    a0Var.B0(z2, i, i);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void W1(app.dogo.com.dogo_android.k.h hVar, Bundle bundle) {
        String string;
        n.f(hVar, "action");
        n.f(bundle, "mail");
        final String str4 = "data";
        final String str5 = "id";
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE) {
            if (bundle.get(str5) == null || bundle.get(str4) != null) {
                n.d(this.z);
                if (this.z.F0() != null) {
                    app.dogo.com.dogo_android.util.e0.a0 a0Var2 = G1();
                    n.d(a0Var2);
                    string = getString(2131887330);
                    n.e(string, "getString(R.string.social_share_challenges_my_photo)");
                    int i = 10000;
                    a0Var2.r0(string, getString(2131886703), i, new app.dogo.com.dogo_android.view.main_screen.challenge.r(this));
                }
            } else {
                n.d(this.z);
                this.z.Y1(bundle.getString(str5));
            }
        }
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_SWITCH_TO_YOUR_TAB) {
            n.d(this.binding);
            this.binding.a(b.UP);
            n.d(this.z);
            this.z.s2(ChallengeSortingTab.YOUR_TAB);
        }
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_BACK_TO_TOP) {
            n.d(this.y);
            gaVar.S.q1(0);
            app.dogo.com.dogo_android.util.e0.a0 a0Var = G1();
            n.d(a0Var);
            a0Var.p0();
        }
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_CHALLENGE_FILTERS) {
            n.d(this.z);
            this.z.q2((Map)bundle.getSerializable(str4));
        }
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_START_ENTRY_CREATION_FLOW) {
            n.d(this.z);
            this.z.Q2(G1());
        }
        if (hVar == FragmentMessageAction.MESSAGE_ACTION_COMMENT_COUNT_CHANGE) {
            n.d(this.adapter);
            this.adapter.t2(bundle.getString(str5), bundle.getInt(str4));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public final void j3() {
        n.d(this.z);
        androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.y.j jVar = this.z.B0("challenge_home", app.dogo.com.dogo_android.util.extensionfunction.g1.shouldLoadImage(requireActivity));
        n.e(jVar, "screen");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(requireActivity(), jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public i l2() {
        return FragmentTags.CHALLENGE_HOME_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public final app.dogo.com.dogo_android.util.l0.a m2() {
        return this.navBarSize;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public final SwipeRefreshLayout.j n2() {
        return this.scrollListener;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onActivityResult(int i, int i2, Intent intent) {
        app.dogo.com.dogo_android.util.e0.a0 a0Var;
        int i4 = 11103;
        super.onActivityResult(i, i2, intent);
        final int i5 = -1;
        int i3 = 203;
        if (i == 203 && i2 == i5) {
            n.d(this.z);
            if (this.z.U2(d.b(intent).g())) {
                app.dogo.com.dogo_android.util.e0.a0 a0Var2 = G1();
                n.d(a0Var2);
                n.d(this.z);
                n.d(this.z);
                n.d(this.z);
                n.d(this.z);
                a0Var2.n0(this.z.W(), this.z.x0(), this.z.G0(), this.z.H0());
            } else {
                Z1(2131886123);
            }
        }
        i4 = 11103;
        if (i == 11103 && i2 == i5) {
            n.d(this.z);
            this.z.R2(G1(), true);
            n.d(this.F);
            this.F.updateDogAvatar();
            n.d(this.adapter);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        n.f(layoutInflater, "inflater");
        r rVar = J1();
        Objects.requireNonNull(rVar, "null cannot be cast to non-null type app.dogo.com.dogo_android.viewmodel.main_screen.challenge.ChallengeHomeViewModel");
        this.z = rVar;
        ga gaVar2 = ga.T(layoutInflater, viewGroup, false);
        this.y = gaVar2;
        n.d(gaVar2);
        gaVar2.W(this.z);
        n.d(this.y);
        this.y.V(G1());
        n.d(this.z);
        this.z.o2(getArguments());
        n.d(this.z);
        if (this.z.G2(getArguments())) {
            h2(getArguments());
        }
        app.dogo.com.dogo_android.view.main_screen.j.k0.b challengeHomeFragmentLegacy_onCreateView_1 = new ChallengeHomeFragmentLegacy_onCreateView_1(this);
        this.F = challengeHomeFragmentLegacy_onCreateView_1;
        viewGroup = this.y == null ? 0 : gaVar5.P;
        if (this.y != 0) {
            i.U(challengeHomeFragmentLegacy_onCreateView_1);
        }
        if (this.y != null) {
            if (gaVar.P != null) {
                if (ciVar.Q != null) {
                    ciVar.Q.setOnKeyListener(new app.dogo.com.dogo_android.view.main_screen.challenge.s(this));
                }
            }
        }
        n.d(this.z);
        this.z.F2(k2(getContext()), G1());
        n.d(this.z);
        this.z.z2().continueWith(new app.dogo.com.dogo_android.view.main_screen.challenge.m(this));
        n.d(this.y);
        View view = this.y.w();
        n.e(view, "binding!!.root");
        return view;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onDestroy() {
        super.onDestroy();
        n.d(this.z);
        this.z.j2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onPause() {
        super.onPause();
        n.d(this.z);
        this.z.L();
        n.d(this.z);
        this.z.j2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onResume() {
        super.onResume();
        n.d(this.z);
        n.d(this.z);
        this.z.y(this.z.a0());
        n.d(this.z);
        this.z.x();
    }

    /* renamed from: A2, reason: from kotlin metadata */
    public static /* synthetic */ void onDataReceived(k0 action, Boolean mail) {
        ChallengeHomeFragmentLegacy.c3(action, mail);
    }

    /* renamed from: B2, reason: from kotlin metadata */
    public static /* synthetic */ void showDeleteCommentDialog(k0 model, List position) {
        ChallengeHomeFragmentLegacy.U2(model, position);
    }

    /* renamed from: C2, reason: from kotlin metadata */
    public static /* synthetic */ void showReportDialog(k0 model, Integer position) {
        ChallengeHomeFragmentLegacy.V2(model, position);
    }

    public static /* synthetic */ void D2(k0 k0Var, com.google.android.gms.tasks.j jVar) {
        ChallengeHomeFragmentLegacy.i2(k0Var, jVar);
    }

    /* renamed from: E2, reason: from kotlin metadata */
    public static /* synthetic */ void callEntryCreation(k0 arguments) {
        ChallengeHomeFragmentLegacy.createTitleView(arguments);
    }

    public static /* synthetic */ void F2(k0 k0Var, Boolean boolean) {
        ChallengeHomeFragmentLegacy.e3(k0Var, boolean);
    }

    public static /* synthetic */ void G2(k0 k0Var, Boolean boolean) {
        ChallengeHomeFragmentLegacy.Z2(k0Var, boolean);
    }

    public static /* synthetic */ void H2(k0 k0Var, Boolean boolean) {
        ChallengeHomeFragmentLegacy.W2(k0Var, boolean);
    }

    public static /* synthetic */ void I2(k0 k0Var, List list) {
        ChallengeHomeFragmentLegacy.d3(k0Var, list);
    }

    public static /* synthetic */ boolean o2(k0 k0Var, View view, int i) {
        return ChallengeHomeFragmentLegacy.g3(k0Var, view, i);
    }

    public static /* synthetic */ void p2(k0 k0Var, List list) {
        ChallengeHomeFragmentLegacy.T2(k0Var, list);
    }

    public static /* synthetic */ Object q2(k0 k0Var, com.google.android.gms.tasks.j jVar) {
        return ChallengeHomeFragmentLegacy.K2(k0Var, jVar);
    }

    public static /* synthetic */ void r2(k0 k0Var) {
        ChallengeHomeFragmentLegacy.setupRecycleView(k0Var);
    }

    public static /* synthetic */ void s2(k0 k0Var) {
        ChallengeHomeFragmentLegacy.onEntryImageDogSelect(k0Var);
    }

    public static /* synthetic */ void t2(k0 k0Var, Boolean boolean) {
        ChallengeHomeFragmentLegacy.S2(k0Var, boolean);
    }

    public static /* synthetic */ void u2(k0 k0Var, y yVar) {
        ChallengeHomeFragmentLegacy.X2(k0Var, yVar);
    }

    public static /* synthetic */ void v2(k0 k0Var, View view) {
        ChallengeHomeFragmentLegacy.L2(k0Var, view);
    }

    public static /* synthetic */ boolean w2(k0 k0Var, View view, int i, KeyEvent keyEvent) {
        return ChallengeHomeFragmentLegacy.J2(k0Var, view, i, keyEvent);
    }

    public static /* synthetic */ void x2(k0 k0Var, List list) {
        ChallengeHomeFragmentLegacy.R2(k0Var, list);
    }

    public static /* synthetic */ void y2(k0 k0Var, Boolean boolean) {
        ChallengeHomeFragmentLegacy.b3(k0Var, boolean);
    }

    public static /* synthetic */ void z2(k0 k0Var, List list) {
        ChallengeHomeFragmentLegacy.Y2(k0Var, list);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public Class<? extends r> K1() {
        return app.dogo.com.dogo_android.viewmodel.main_screen.challenge.g0.class;
    }
}
