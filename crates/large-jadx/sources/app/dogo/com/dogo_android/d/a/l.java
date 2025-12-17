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
import app.dogo.com.dogo_android.k.j;
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
import com.google.android.gms.tasks.j;
import h.a.b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00170\u0016H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0008\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020!2\u0008\u0010#\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyFullScreenFragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeFanListBinding;", "linearLayout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialogViewModel;", "checkPermissions", "", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getTopBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutTopBarBinding;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "", "setupObservers", "viewModel", "setupRecycleView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends x {

    private app.dogo.com.dogo_android.d.a.m A;
    private app.dogo.com.dogo_android.d.a.k B;
    private LinearLayoutManager y;
    private k8 z;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListDialog$setupRecycleView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends k {

        final app.dogo.com.dogo_android.d.a.l d;
        a(app.dogo.com.dogo_android.d.a.l l) {
            this.d = l;
            super(2);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        public void a() {
            app.dogo.com.dogo_android.d.a.m mVar = l.c2(this.d);
            n.d(mVar);
            mVar.R();
        }
    }
    public static final app.dogo.com.dogo_android.d.a.m c2(app.dogo.com.dogo_android.d.a.l l) {
        return l.A;
    }

    private final boolean d2() {
        app.dogo.com.dogo_android.d.a.m mVar = this.A;
        n.d(mVar);
        return mVar.J();
    }

    public static void e2(app.dogo.com.dogo_android.d.a.l l, Boolean boolean2) {
        l.l2(l, boolean2);
    }

    public static boolean f2(app.dogo.com.dogo_android.d.a.l l, View view2, int i3) {
        return l.n2(l, view2, i3);
    }

    public static void g2(app.dogo.com.dogo_android.d.a.l l, List list2) {
        l.k2(l, list2);
    }

    public static void h2(app.dogo.com.dogo_android.d.a.l l, j j2) {
        l.i2(l, j2);
    }

    private static final void i2(app.dogo.com.dogo_android.d.a.l l, j j2) {
        Object obj1;
        n.f(l, "this$0");
        n.f(j2, "task");
        if (j2.isSuccessful()) {
            obj1 = l.A;
            n.d(obj1);
            obj1.R();
        } else {
            obj1 = l.G1();
            n.d(obj1);
            obj1.onBackPressed();
        }
    }

    private final void j2(app.dogo.com.dogo_android.d.a.m m) {
        c cVar = new c(this);
        n.d(m);
        m.F().observe(getViewLifecycleOwner(), cVar);
        a aVar = new a(this);
        m.H().observe(getViewLifecycleOwner(), aVar);
    }

    private static final void k2(app.dogo.com.dogo_android.d.a.l l, List list2) {
        String empty;
        Object obj1;
        n.f(l, "this$0");
        if (list2 != null && list2.isEmpty()) {
            if (list2.isEmpty()) {
                obj1 = l.A;
                n.d(obj1);
                obj1.R();
            }
            obj1 = l.B;
            n.d(obj1);
            obj1.h2(list2);
        }
    }

    private static final void l2(app.dogo.com.dogo_android.d.a.l l, Boolean boolean2) {
        Object obj1;
        boolean obj2;
        n.f(l, "this$0");
        if (boolean2 && boolean2.booleanValue()) {
            if (boolean2.booleanValue()) {
                obj1 = l.B;
                n.d(obj1);
                obj1.i2();
            }
        }
    }

    private final void m2(RecyclerView recyclerView) {
        app.dogo.com.dogo_android.d.a.m mVar2 = this.A;
        n.d(mVar2);
        k kVar = new k(mVar2.C(), F1(), D1());
        this.B = kVar;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.y = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.B);
        app.dogo.com.dogo_android.d.a.m mVar = this.A;
        n.d(mVar);
        recyclerView.q1(mVar.G());
        l.a aVar = new l.a(this);
        recyclerView.l(aVar);
        b obj5 = new b(this);
        app.dogo.com.dogo_android.d.a.k kVar3 = this.B;
        n.d(kVar3);
        kVar3.a0(obj5);
    }

    private static final boolean n2(app.dogo.com.dogo_android.d.a.l l, View view2, int i3) {
        boolean challengeEntryVoter;
        int a0Var;
        int i2;
        int dogProfile2;
        int valueOf;
        int voterEntryId;
        int dogProfile;
        int i;
        String badges;
        Object obj7;
        Object obj8;
        boolean obj9;
        n.f(l, "this$0");
        n.f(view2, "view");
        app.dogo.com.dogo_android.d.a.k kVar = l.B;
        n.d(kVar);
        h.a.b.h.f fVar = kVar.O0(i3);
        if (fVar == null) {
            return 1;
        }
        app.dogo.com.dogo_android.d.a.m mVar = l.A;
        n.d(mVar);
        final int i4 = 0;
        if (!mVar.J()) {
            return i4;
        }
        final int i5 = 2131362981;
        challengeEntryVoter = (d)fVar.g();
        app.dogo.com.dogo_android.d.a.m mVar2 = l.A;
        n.d(mVar2);
        if (fVar instanceof d && view2.getId() == 2131363557 && l.G1() != null && mVar2.D() != null) {
            challengeEntryVoter = (d)fVar.g();
            if (view2.getId() == 2131363557) {
                if (l.G1() != null) {
                    mVar2 = l.A;
                    n.d(mVar2);
                    if (mVar2.D() != null) {
                        a0Var = l.G1();
                        n.d(a0Var);
                        app.dogo.com.dogo_android.d.a.m mVar5 = l.A;
                        n.d(mVar5);
                        ChallengeModel challengeModel = mVar5.D();
                        n.d(challengeModel);
                        a0Var.o0(challengeEntryVoter.getVoterEntryId(), challengeModel.getId());
                    }
                }
            }
            if (view2.getId() == 2131362633 && l.d2()) {
                if (l.d2()) {
                    app.dogo.com.dogo_android.d.a.m mVar4 = l.A;
                    n.d(mVar4);
                    mVar4.y(challengeEntryVoter);
                    i2 = l.B;
                    n.d(i2);
                    i2.notifyItemChanged(i3, 100);
                }
            }
            if (view2.getId() == i5 && l.G1() != null && challengeEntryVoter.getDogProfile() != null) {
                if (l.G1() != null) {
                    if (challengeEntryVoter.getDogProfile() != null) {
                        dogProfile2 = l.G1();
                        n.d(dogProfile2);
                        dogProfile2.f0(challengeEntryVoter.getDogProfile(), challengeEntryVoter.getBadges());
                    }
                }
            }
            if (view2.getId() == 2131362728 && l.d2()) {
                if (l.d2()) {
                    app.dogo.com.dogo_android.d.a.m mVar3 = l.A;
                    n.d(mVar3);
                    mVar3.z(challengeEntryVoter);
                    challengeEntryVoter = l.B;
                    n.d(challengeEntryVoter);
                    challengeEntryVoter.notifyItemChanged(i3, Integer.valueOf(i4));
                }
            }
        }
        obj9 = (f)fVar.g();
        if (fVar instanceof f && view2.getId() == i5 && l.G1() != null && obj9.getDogProfile() != null) {
            obj9 = (f)fVar.g();
            if (view2.getId() == i5) {
                if (l.G1() != null) {
                    if (obj9.getDogProfile() != null) {
                        obj7 = l.G1();
                        n.d(obj7);
                        obj7.f0(obj9.getDogProfile(), obj9.getBadges());
                    }
                }
            }
        }
        return i4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return j.CHALLENGE_FAN_LIST_DIALOG_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return j3.K;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() {
        String string = getString(2131886282);
        n.e(string, "getString(R.string.challenge_fans)");
        return string;
    }

    public Class<? extends r> K1() {
        return m.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        k8 k8Var = this.z;
        n.d(k8Var);
        cn cnVar = k8Var.P;
        n.e(cnVar, "binding!!.topBar");
        return cnVar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        boolean obj2;
        Object obj3;
        n.f(layoutInflater, "inflater");
        r obj4 = J1();
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type app.dogo.com.dogo_android.challenge.challengefanlist.ChallengeFanListDialogViewModel");
        this.A = (m)obj4;
        obj2 = k8.T(layoutInflater, viewGroup2, false);
        this.z = obj2;
        n.d(obj2);
        obj2.W(this.A);
        obj2 = this.z;
        n.d(obj2);
        obj2.V(G1());
        obj2 = this.A;
        n.d(obj2);
        if (!obj2.V(getArguments())) {
            obj2 = G1();
            n.d(obj2);
            obj2.onBackPressed();
        }
        obj2 = this.A;
        n.d(obj2);
        if (obj2.I().isEmpty()) {
            obj2 = this.A;
            n.d(obj2);
            obj3 = new d(this);
            obj2.Z().addOnCompleteListener(obj3);
        }
        obj2 = this.z;
        n.d(obj2);
        obj2 = obj2.O;
        n.e(obj2, "binding!!.recycleView");
        m2(obj2);
        j2(this.A);
        obj2 = this.z;
        n.d(obj2);
        obj2 = obj2.w();
        n.e(obj2, "binding!!.root");
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onStop() {
        super.onStop();
        final app.dogo.com.dogo_android.d.a.m mVar = this.A;
        n.d(mVar);
        LinearLayoutManager linearLayoutManager = this.y;
        n.d(linearLayoutManager);
        mVar.W(linearLayoutManager.v2());
    }
}
