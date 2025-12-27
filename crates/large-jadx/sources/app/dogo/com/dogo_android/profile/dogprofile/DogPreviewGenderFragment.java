package app.dogo.com.dogo_android.q.p;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ec;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: DogPreviewGenderFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogEditGenderBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: z, reason: from kotlin metadata */
public final class DogPreviewGenderFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private ec binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<b0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final b0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogPreviewGenderViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { z.this.onResume().a() });
        }

        b() {
            super(0);
        }
    }
    public z() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.profile.dogprofile.z.a(this, null, new app.dogo.com.dogo_android.profile.dogprofile.z.b(this)));
    }

    public static final /* synthetic */ a0 B1(z zVar) {
        return zVar.onResume();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final a0 onResume() {
        return (DogPreviewGenderScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final b0 D1() {
        return (DogPreviewGenderViewModel)this.b.getValue();
    }

    private static final void H1(z zVar, View view) {
        n.f(zVar, "this$0");
        zVar.D1().o();
    }

    private static final void I1(z zVar, View view) {
        n.f(zVar, "this$0");
        final androidx.fragment.app.e activity = zVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void J1(z zVar, Boolean boolean) {
        String str;
        int i = 0;
        String str2;
        app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
        int i2 = 5;
        Object obj = null;
        n.f(zVar, "this$0");
        str = "it";
        n.e(boolean, str);
        if (boolean.booleanValue()) {
            if (!zVar.D1().isUserSignedIn()) {
                androidx.fragment.app.e activity2 = zVar.getActivity();
                if (activity2 != null) {
                    i = 0;
                    zendeskConfigurationInfo = null;
                    i2 = 5;
                    obj = null;
                    str2 = "dog_edit";
                    app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity2, i, str2, zendeskConfigurationInfo, i2, obj);
                }
            }
            androidx.fragment.app.e activity = zVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws android.content.res.Resources.NotFoundException {
        n.f(inflater, "inflater");
        boolean z = false;
        ec ecVar = ec.T(inflater, container, z);
        n.e(ecVar, "inflate(inflater, container, false)");
        this.binding = ecVar;
        int i3 = 0;
        final String str = "binding";
        if (ecVar == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i3;
        } else {
            ecVar.W(D1());
            if (this.binding == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i3;
            } else {
                Object[] arr = new Object[1];
                final Resources resources2 = getResources();
                n.e(resources2, "resources");
                arr[z] = app.dogo.com.dogo_android.util.extensionfunction.j1.W0(onResume().a().getName(), resources2);
                this.binding.V(getResources().getString(2131886453, arr));
                if (this.binding == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i3;
                    } else {
                        View view = this.binding.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity = null;
        super.onResume();
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws j {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.profile.dogprofile.l(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.R.setNavigationOnClickListener(new app.dogo.com.dogo_android.profile.dogprofile.j(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                n.e(viewLifecycleOwner, "viewLifecycleOwner");
                D1().saveDogGender().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.profile.dogprofile.k(this));
                return;
            }
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(z view, View savedInstanceState) {
        DogPreviewGenderFragment.I1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(z zVar, Boolean boolean) {
        DogPreviewGenderFragment.J1(zVar, boolean);
    }

    public static /* synthetic */ void G1(z zVar, View view) {
        DogPreviewGenderFragment.H1(zVar, view);
    }
}
