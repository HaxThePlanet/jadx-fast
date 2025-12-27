package app.dogo.com.dogo_android.q.q;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.a9;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.j;
import kotlin.m;

/* compiled from: DogSelectDialog.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0016J\u0008\u0010,\u001a\u00020\u0018H\u0016J\u001a\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010/\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogDogSelectBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectViewModel;", "viewModel$delegate", "getTheme", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddDogClick", "userPremium", "", "onAddNewDogClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "dogId", "", "onResume", "onViewCreated", "view", "saveSelectionAndDismiss", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class DogSelectDialog extends com.google.android.material.bottomsheet.b implements f.a {

    /* renamed from: b, reason: from kotlin metadata */
    private a9 binding;
    private final kotlin.h c;
    private final kotlin.h v;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public a(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<j> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogSelectViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { h.this.getTheme().getSource() });
        }

        c() {
            super(0);
        }
    }
    public h() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.c = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.profile.dogselect.h.a(this, aVar2, aVar2));
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.profile.dogselect.h.b(this, aVar2, new app.dogo.com.dogo_android.profile.dogselect.h.c(this)));
    }

    /* renamed from: F1, reason: from kotlin metadata */
    public static final /* synthetic */ i onAddDogClick(h userPremium) {
        return userPremium.getTheme();
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final i getTheme() {
        return (DogSelectScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final j H1() {
        return (DogSelectViewModel)this.v.getValue();
    }

    /* renamed from: L1, reason: from kotlin metadata */
    private final void onItemClick(boolean dogId) {
        String str = null;
        int i2;
        H1().p();
        str = null;
        if (dogId) {
            dogId = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : str;
            if (i2 != 0) {
                i2.switchFullscreenFragment(H1().k(), 11101, getTheme().b(), str);
            }
        } else {
            e dogId2 = getActivity();
            if (dogId2 instanceof Navigator) {
            }
            obj = str;
            if (obj != null) {
                String str3 = null;
                app.dogo.com.dogo_android.repository.domain.SubscriptionOffer subscriptionOffer = null;
                int i = 6;
                Object obj2 = null;
                str2 = "dog_profile";
                Navigator.F0(obj, str2, str3, subscriptionOffer, i, obj2);
            }
        }
    }

    private static final void M1(h hVar, String str) {
        n.f(hVar, "this$0");
        n.e(str, "dogId");
        hVar.P1(str);
    }

    private static final void N1(h hVar, View view) {
        n.f(hVar, "this$0");
        hVar.dismiss();
    }

    /* renamed from: O1, reason: from kotlin metadata */
    private static final void saveSelectionAndDismiss(DialogInterface dogId) {
        Objects.requireNonNull(dogId, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        View viewById = dogId.findViewById(2131362302);
        n.d(viewById);
        ViewParent parent = viewById.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.y(viewById);
        n.e(bottomSheetBehavior, "from<FrameLayout?>(bottomSheet)");
        bottomSheetBehavior.V(viewById.getHeight());
        parent.getParent().requestLayout();
    }

    private final void P1(String str) {
        Fragment fragment;
        int i = 0;
        str2 = "challenge_image_dog_select_request";
        if (n.b(getTheme().createFragment(), str2)) {
            e activity = getActivity();
            i = 0;
            int r0 = activity == null ? 0 : i;
            z2 = (activity == null ? 0 : i) instanceof DogSelectCallback;
            if ((activity == null ? 0 : i) instanceof DogSelectCallback) {
                fragment = r0;
            }
            if (i != 0) {
                i.onEntryImageDogSelect(str);
            }
        }
        getSharedViewModel().s(str, getTheme().getSource());
        dismiss();
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // com.google.android.material.bottomsheet.b
    public void J0(String str) {
        n.f(str, "dogId");
        H1().q();
        H1().n(str);
    }

    @Override // com.google.android.material.bottomsheet.b
    public void U0(boolean z) {
        onItemClick(z);
    }

    @Override // com.google.android.material.bottomsheet.b
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String stringExtra = null;
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            int i = 0;
        } else {
            stringExtra = data.getStringExtra("newDogId");
        }
        if (requestCode == 11101 && stringExtra != null && !this.isDetached()) {
            P1(stringExtra);
        }
    }

    @Override // com.google.android.material.bottomsheet.b
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        a9 a9Var = a9.T(inflater, container, false);
        n.e(a9Var, "inflate(inflater, container, false)");
        this.binding = a9Var;
        int i = 0;
        String str3 = "binding";
        if (a9Var == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            a9Var.W(H1());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(this);
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.binding.w();
                    }
                }
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.b
    public void onResume() {
        super.onResume();
        H1().m();
    }

    @Override // com.google.android.material.bottomsheet.b
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        H1().getData().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.profile.dogselect.b(this));
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.profile.dogselect.c(this));
            Dialog dialog = getDialog();
            n.d(dialog);
            dialog.setOnShowListener(app.dogo.com.dogo_android.profile.dogselect.d.a);
            return;
        }
    }


    /* renamed from: I1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(h view, String savedInstanceState) {
        DogSelectDialog.M1(view, savedInstanceState);
    }

    public static /* synthetic */ void J1(h hVar, View view) {
        DogSelectDialog.N1(hVar, view);
    }

    /* renamed from: K1, reason: from kotlin metadata */
    public static /* synthetic */ void onAddNewDogClick(DialogInterface userPremium) {
        DogSelectDialog.saveSelectionAndDismiss(userPremium);
    }

    @Override // com.google.android.material.bottomsheet.b
    public int getTheme() {
        return R.style.DogSelectBottomSheetDialogTheme;
    }
}
