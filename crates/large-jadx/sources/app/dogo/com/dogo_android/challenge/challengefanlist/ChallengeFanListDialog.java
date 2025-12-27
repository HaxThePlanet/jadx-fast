package app.dogo.com.dogo_android.d.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.d.a.n.d;
import app.dogo.com.dogo_android.d.a.n.f;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.k8;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.util.n0.k;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import h.a.b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeFanListDialog.kt */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00170\u0016H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0008\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020!2\u0008\u0010#\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyFullScreenFragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeFanListBinding;", "linearLayout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialogViewModel;", "checkPermissions", "", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getTopBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutTopBarBinding;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "", "setupObservers", "viewModel", "setupRecycleView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class ChallengeFanListDialog extends x {

    /* renamed from: A, reason: from kotlin metadata */
    private m adapter;
    /* renamed from: B, reason: from kotlin metadata */
    private k binding;
    /* renamed from: y, reason: from kotlin metadata */
    private LinearLayoutManager linearLayout;
    private k8 z;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialog$setupRecycleView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends k {

        final /* synthetic */ l d;
        a() {
            this.d = lVar;
            super(2);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        /* renamed from: a, reason: from kotlin metadata */
        public void onLoadMore() {
            app.dogo.com.dogo_android.d.a.m observers = this.d.adapter;
            n.d(observers);
            observers.R();
        }
    }
    /* renamed from: c2, reason: from kotlin metadata */
    public static final /* synthetic */ m setupObservers(l viewModel) {
        return viewModel.adapter;
    }

    /* renamed from: d2, reason: from kotlin metadata */
    private final boolean checkPermissions() {
        n.d(this.adapter);
        return this.adapter.J();
    }

    private static final void i2(l lVar, com.google.android.gms.tasks.j jVar) {
        n.f(lVar, "this$0");
        n.f(jVar, "task");
        if (jVar.isSuccessful()) {
            n.d(lVar.adapter);
            lVar.adapter.R();
        } else {
            a0 a0Var = lVar.G1();
            n.d(a0Var);
            a0Var.onBackPressed();
        }
    }

    /* renamed from: j2, reason: from kotlin metadata */
    private final void setupRecycleView(m recyclerView) {
        n.d(recyclerView);
        recyclerView.F().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.challengefanlist.c(this));
        recyclerView.H().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.challengefanlist.a(this));
    }

    private static final void k2(l lVar, List list) {
        str = "this$0";
        n.f(lVar, str);
        if (list != null && list.isEmpty()) {
            n.d(lVar.adapter);
            lVar.adapter.R();
            return;
        }
    }

    private static final void l2(l lVar, Boolean boolean) {
        n.f(lVar, "this$0");
        if (boolean != null && boolean.booleanValue()) {
            n.d(lVar.binding);
            lVar.binding.i2();
        }
    }

    private final void m2(RecyclerView recyclerView) {
        n.d(this.adapter);
        this.binding = new ChallengeFanListAdapter(this.adapter.C(), F1(), D1());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.linearLayout = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.binding);
        n.d(this.adapter);
        recyclerView.q1(this.adapter.G());
        recyclerView.l(new ChallengeFanListDialog_setupRecycleView_1(this));
        n.d(this.binding);
        this.binding.a0(new app.dogo.com.dogo_android.challenge.challengefanlist.b(this));
    }

    private static final boolean n2(l lVar, View view, int i) {
        int i7 = 2131362633;
        String str;
        n.f(lVar, "this$0");
        n.f(view, "view");
        n.d(lVar.binding);
        h.a.b.h.f fVar = lVar.binding.O0(i);
        if (fVar == null) {
            return true;
        }
        n.d(lVar.adapter);
        final int i10 = 0;
        if (!lVar.adapter.J()) {
            return false;
        }
        z = fVar instanceof ChallengeFanListEntryItem;
        final int i11 = 2131362981;
        if (fVar instanceof ChallengeFanListEntryItem) {
            ChallengeEntryVoter challengeEntryVoter = (ChallengeFanListEntryItem)fVar.g();
            int i6 = 2131363557;
            if (view.getId() == 2131363557 && lVar.G1() != null) {
                n.d(lVar.adapter);
                if (lVar.adapter.D() != null) {
                    a0 a0Var3 = lVar.G1();
                    n.d(a0Var3);
                    n.d(lVar.adapter);
                    ChallengeModel challengeModel2 = lVar.adapter.D();
                    n.d(challengeModel2);
                    a0Var3.o0(challengeEntryVoter.getVoterEntryId(), challengeModel2.getId());
                }
            }
            i7 = 2131362633;
            if (view.getId() == 2131362633 && lVar.checkPermissions()) {
                n.d(lVar.adapter);
                lVar.adapter.y(challengeEntryVoter);
                n.d(lVar.binding);
                lVar.binding.notifyItemChanged(i, 100);
            }
            if (view.getId() == i11 && lVar.G1() != null && challengeEntryVoter.getDogProfile() != null) {
                a0 a0Var5 = lVar.G1();
                n.d(a0Var5);
                a0Var5.f0(challengeEntryVoter.getDogProfile(), challengeEntryVoter.getBadges());
            }
            int i8 = 2131362728;
            if (view.getId() == 2131362728 && lVar.checkPermissions()) {
                n.d(lVar.adapter);
                lVar.adapter.z(challengeEntryVoter);
                n.d(lVar.binding);
                lVar.binding.notifyItemChanged(i, Integer.valueOf(i10));
            }
        }
        z2 = fVar instanceof ChallengeFanListSimpleItem;
        if (fVar instanceof ChallengeFanListSimpleItem) {
            ChallengeEntryVoter challengeEntryVoter2 = fVar.g();
            if (view.getId() == i11 && lVar.G1() != null && challengeEntryVoter2.getDogProfile() != null) {
                a0 a0Var = lVar.G1();
                n.d(a0Var);
                a0Var.f0(challengeEntryVoter2.getDogProfile(), challengeEntryVoter2.getBadges());
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return FullScreenTag.CHALLENGE_FAN_LIST_DIALOG_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return S.codeRedemption;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() {
        String string = getString(2131886282);
        n.e(string, "getString(R.string.challenge_fans)");
        return string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        n.d(this.z);
        n.e(k8Var.P, "binding!!.topBar");
        return k8Var.P;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        r rVar = J1();
        Objects.requireNonNull(rVar, "null cannot be cast to non-null type app.dogo.com.dogo_android.challenge.challengefanlist.ChallengeFanListDialogViewModel");
        this.adapter = rVar;
        k8 k8Var = k8.T(layoutInflater, viewGroup, false);
        this.z = k8Var;
        n.d(k8Var);
        k8Var.W(this.adapter);
        n.d(this.z);
        this.z.V(G1());
        n.d(this.adapter);
        if (!this.adapter.V(getArguments())) {
            a0 a0Var = G1();
            n.d(a0Var);
            a0Var.onBackPressed();
        }
        n.d(this.adapter);
        if (this.adapter.I().isEmpty()) {
            n.d(this.adapter);
            this.adapter.Z().addOnCompleteListener(new app.dogo.com.dogo_android.challenge.challengefanlist.d(this));
        }
        n.d(this.z);
        n.e(k8Var3.O, "binding!!.recycleView");
        m2(k8Var3.O);
        setupRecycleView(this.adapter);
        n.d(this.z);
        View view = this.z.w();
        n.e(view, "binding!!.root");
        return view;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onStop() {
        super.onStop();
        n.d(this.adapter);
        n.d(this.linearLayout);
        this.adapter.W(this.linearLayout.v2());
    }

    public static /* synthetic */ void e2(l lVar, Boolean boolean) {
        ChallengeFanListDialog.l2(lVar, boolean);
    }

    /* renamed from: f2, reason: from kotlin metadata */
    public static /* synthetic */ boolean onCreateView(l inflater, View container, int savedInstanceState) {
        return ChallengeFanListDialog.n2(inflater, container, savedInstanceState);
    }

    public static /* synthetic */ void g2(l lVar, List list) {
        ChallengeFanListDialog.k2(lVar, list);
    }

    public static /* synthetic */ void h2(l lVar, com.google.android.gms.tasks.j jVar) {
        ChallengeFanListDialog.i2(lVar, jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public Class<? extends r> K1() {
        return ChallengeFanListDialogViewModel.class;
    }
}
