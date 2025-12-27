package app.dogo.com.dogo_android.d.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.o8;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.k0.g;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.h;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: ChallengeProfileDialog.kt */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010 0\u001fH\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010)\u001a\u00020*H\u0016J\u0008\u0010+\u001a\u00020*H\u0016J\u0008\u0010,\u001a\u00020*H\u0016J\u001a\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u001bH\u0002J\u0008\u00101\u001a\u00020*H\u0002J\u0008\u00102\u001a\u00020*H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u000e\u001a\u0004\u0008\u0013\u0010\u0014¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyFullScreenFragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeProfileBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "toolBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialogViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialogViewModel;", "vm$delegate", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getTopBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutTopBarBinding;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "onStop", "onViewCreated", "view", "reportUser", "toastMessage", "setupObservers", "setupRecyclerView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class ChallengeProfileDialog extends x {

    /* renamed from: A, reason: from kotlin metadata */
    private o8 adapter;
    /* renamed from: B, reason: from kotlin metadata */
    private q binding;
    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayoutManager linearLayoutManager;
    private g D = new o$e();
    /* renamed from: y, reason: from kotlin metadata */
    private final h toolBarManager;
    private final h z;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            o.this.getFragmentTag().Q();
        }

        a() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = o.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public c(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<p> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final p invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeProfileDialogViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016J\u0008\u0010\u0007\u001a\u00020\u0006H\u0016J\u0008\u0010\u0008\u001a\u00020\u0006H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\nH\u0016J\u0008\u0010\u000c\u001a\u00020\nH\u0016¨\u0006\r", d2 = {"app/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialog$toolBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getActionName", "", "getTitle", "isBackVisible", "", "isBlockVisible", "isFlagVisible", "onAction", "", "onBack", "onBlockAction", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends g {

        final /* synthetic */ o a;
        e() {
            this.a = oVar;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            return this.a.I1();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onAction() {
            if (this.a.getFragmentTag().D()) {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.t0(activity, new app.dogo.com.dogo_android.challenge.profile.o.e.a(this.a));
                }
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            a0 a0Var = this.a.G1();
            n.d(a0Var);
            a0Var.onBackPressed();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBlockAction() {
            if (this.a.getFragmentTag().D()) {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.r0(activity, new app.dogo.com.dogo_android.challenge.profile.o.e.b(this.a));
                }
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getActionName() {
            return " ";
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return true;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBlockVisible() {
            return true;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isFlagVisible() {
            return true;
        }
    }
    public o() {
        super();
        final m.a.c.j.a aVar = null;
        this.toolBarManager = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.challenge.profile.o.c(this, aVar, aVar));
        this.z = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.challenge.profile.o.d(this, aVar, aVar));
        app.dogo.com.dogo_android.d.d.o.e challengeProfileDialog_toolBarManager_1 = new ChallengeProfileDialog_toolBarManager_1(this);
    }

    /* renamed from: c2, reason: from kotlin metadata */
    public static final /* synthetic */ p reportUser(o toastMessage) {
        return toastMessage.getFragmentTag();
    }

    /* renamed from: d2, reason: from kotlin metadata */
    public static final /* synthetic */ void onViewCreated(o view, String savedInstanceState) {
        view.l2(savedInstanceState);
    }

    /* renamed from: e2, reason: from kotlin metadata */
    private final p getFragmentTag() {
        return (ChallengeProfileDialogViewModel)this.z.getValue();
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.toolBarManager.getValue();
    }

    private static final void j2(o oVar, y yVar) {
        n.f(oVar, "this$0");
        if (yVar instanceof LoadResult_Success) {
            oVar.getFragmentTag().V((LiteDogProfile)yVar.component1());
            oVar.setupRecyclerView();
            oVar.m2();
            oVar.x.notifyPropertyChanged(160);
            if (oVar.getFragmentTag().F()) {
                oVar.getFragmentTag().s().addOnSuccessListener(new app.dogo.com.dogo_android.challenge.profile.b(oVar));
            } else {
                if (oVar.binding != null) {
                    oVar.binding.g2(oVar.getFragmentTag().x());
                }
            }
        } else {
            z = yVar instanceof LoadResult_Error;
            if (yVar instanceof oadResult_Error) {
                android.content.Context requireContext = oVar.requireContext();
                str = "requireContext()";
                n.e(requireContext, str);
                app.dogo.com.dogo_android.util.extensionfunction.f1.m0(oVar, BindingAdapters.a.i(new Exception(yVar.component1()), requireContext), new app.dogo.com.dogo_android.challenge.profile.o.a(oVar), new app.dogo.com.dogo_android.challenge.profile.o.b(oVar));
            }
        }
    }

    private static final void k2(o oVar, List list) {
        n.f(oVar, "this$0");
        n.d(oVar.binding);
        n.d(list);
        oVar.binding.Z(0, list);
    }

    private final void l2(String str) {
        getFragmentTag().R();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity, str);
        }
    }

    private final void m2() {
        getFragmentTag().B().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.profile.d(this));
        getSharedViewModel().E().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.profile.a(this));
    }

    private static final void n2(o oVar, Map map) {
        n.f(oVar, "this$0");
        n.f(map, "userEntryIdsForChallenges");
        n.d(oVar.binding);
        oVar.binding.B2(new HashMap(map));
    }

    private static final void o2(o oVar, y yVar) {
        int i = 0;
        n.f(oVar, "this$0");
        n.e(yVar, "it");
        yVar = app.dogo.com.dogo_android.util.base_classes.z.b(yVar) instanceof DogProfile ? (DogProfile)app.dogo.com.dogo_android.util.base_classes.z.b(yVar) : 0;
        if (i != 0) {
            if (oVar.binding != null) {
                oVar.binding.notifyDataSetChanged();
            }
        }
    }

    private final void setupRecyclerView() {
        if (this.adapter == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            n.e(adapter2.O, "binding.list");
            if (adapter2.O.getAdapter() == null) {
                a0 a0Var = G1();
                n.d(a0Var);
                n.e(a0Var, "navigator!!");
                this.binding = new ChallengeProfileListAdapter(p.g(), F1(), a0Var, D1());
                this.linearLayoutManager = new LinearLayoutManager(getContext());
                adapter2.O.setAdapter(this.binding);
                adapter2.O.setLayoutManager(this.linearLayoutManager);
            }
            return;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return FullScreenTag.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return S.dailyGoalCompletedScreen;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() {
        return getFragmentTag().A();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        o8 o8Var = o8.T(inflater, container, false);
        n.e(o8Var, "inflate(inflater, container, false)");
        this.adapter = o8Var;
        Bundle arguments = getArguments();
        if (arguments != null) {
            getFragmentTag().S(arguments);
        }
        getFragmentTag().u();
        int i = 0;
        String str4 = "binding";
        if (this.adapter == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            adapter2.P.U(this.D);
            if (this.adapter == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                View view = this.adapter.w();
                n.e(view, "binding.root");
                return view;
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onPause() {
        super.onPause();
        getFragmentTag().k();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onResume() {
        super.onResume();
        getFragmentTag().i();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onStop() {
        int i = 0;
        super.onStop();
        if (this.linearLayoutManager == null) {
            i = 0;
        } else {
            i = this.linearLayoutManager.y2();
        }
        getFragmentTag().T(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        getFragmentTag().y().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.profile.c(this));
    }


    public static /* synthetic */ void f2(o oVar, y yVar) {
        ChallengeProfileDialog.o2(oVar, yVar);
    }

    public static /* synthetic */ void g2(o oVar, List list) {
        ChallengeProfileDialog.k2(oVar, list);
    }

    public static /* synthetic */ void h2(o oVar, y yVar) {
        ChallengeProfileDialog.j2(oVar, yVar);
    }

    public static /* synthetic */ void i2(o oVar, Map map) {
        ChallengeProfileDialog.n2(oVar, map);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public Class<? extends r> K1() {
        return BaseViewModel.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        return null;
    }
}
