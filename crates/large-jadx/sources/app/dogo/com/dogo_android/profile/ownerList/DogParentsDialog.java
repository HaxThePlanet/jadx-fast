package app.dogo.com.dogo_android.q.s;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.h.y8;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: DogParentsDialog.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogDogParentsBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDelete", "", "dogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "onResume", "sendInvite", "shortDynamicLink", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class DogParentsDialog extends d implements b.b {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private y8 b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ c a;
        public final void onChanged(T t) {
            n.e(t, "shortDynamicLink");
            this.a.onDelete(t);
        }

        public a() {
            this.a = cVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements y<T> {

        final /* synthetic */ c a;
        public final void onChanged(T t) {
            a.d(t);
            androidx.fragment.app.e activity = this.a.getActivity();
            if (activity != null) {
                android.content.Context requireContext = this.a.requireContext();
                str = "requireContext()";
                n.e(requireContext, str);
                app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity, BindingAdapters.a.i(new Exception(t), requireContext));
            }
        }

        public b() {
            this.a = cVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogParentsViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { c.this.C1().component1() });
        }

        d() {
            super(0);
        }
    }
    public c() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.profile.ownerList.c.c(this, null, new app.dogo.com.dogo_android.profile.ownerList.c.d(this)));
    }

    public static final /* synthetic */ void B1(c cVar, String str) {
        cVar.onDelete(str);
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final f getTheme() {
        return (DogParentsViewModel)this.binding.getValue();
    }

    private static final void F1(c cVar, View view) {
        n.f(cVar, "this$0");
        cVar.dismiss();
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final void onDelete(String dogParent) throws android.content.res.Resources.NotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] arr = new Object[1];
        String string2 = getResources().getString(2131886792, new Object[] { C1().component1().getName() });
        str3 = string2 + 32 + dogParent;
        Intent chooser = new Intent("android.intent.action.SEND");
        chooser.setType("text/plain");
        string = "android.intent.extra.TEXT";
        chooser.putExtra(string, str3);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.startActivity(Intent.createChooser(chooser, getResources().getString(2131887124)));
        }
    }

    @Override // androidx.fragment.app.d
    public final d C1() {
        return (DogParentsScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            android.view.Window window = dialog.getWindow();
            if (window != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.callZendeskDialog(window);
            }
        }
        boolean z = false;
        y8 y8Var = y8.T(inflater, container, z);
        n.e(y8Var, "inflate(inflater, container, false)");
        this.b = y8Var;
        int i = 0;
        final String str = "binding";
        if (y8Var == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            y8Var.W(getTheme());
            if (this.b == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.V(this);
                if (this.b == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.b.M(getViewLifecycleOwner());
                    if (this.b == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        y8Var4.R.setEnabled(z);
                        if (this.b == null) {
                            n.w(str);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            y8Var5.P.setOnClickListener(new app.dogo.com.dogo_android.profile.ownerList.a(this));
                            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                            String str2 = "viewLifecycleOwner";
                            n.e(viewLifecycleOwner2, str2);
                            getTheme().m().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.profile.ownerList.c.a(this));
                            androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
                            n.e(viewLifecycleOwner3, str2);
                            getTheme().k().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.profile.ownerList.c.b(this));
                            if (this.b == null) {
                                n.w(str);
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) i;
                            } else {
                                View view = this.b.w();
                                n.e(view, "binding.root");
                                return view;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onResume() {
        super.onResume();
        getTheme().n();
    }

    @Override // androidx.fragment.app.d
    /* renamed from: t, reason: from kotlin metadata */
    public void sendInvite(DogParentUIState.DogParent shortDynamicLink) {
        n.f(shortDynamicLink, "dogParent");
        getTheme().deleteOwner(shortDynamicLink.getId());
    }


    public static /* synthetic */ void E1(c cVar, View view) {
        DogParentsDialog.F1(cVar, view);
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return R.style.DogParentsDialog;
    }
}
