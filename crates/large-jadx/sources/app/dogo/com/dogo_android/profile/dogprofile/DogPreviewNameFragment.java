package app.dogo.com.dogo_android.q.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.gc;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: DogPreviewNameFragment.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogEditNameBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getNameErrorMessage", "", "name", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c0, reason: from kotlin metadata */
public final class DogPreviewNameFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private gc binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<e0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogPreviewNameViewModel.class), this.$parameters);
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
            return org.koin.core.parameter.b.b(new Object[] { c0.this.onResume().a() });
        }

        b() {
            super(0);
        }
    }
    public c0() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.profile.dogprofile.c0.a(this, null, new app.dogo.com.dogo_android.profile.dogprofile.c0.b(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ d0 getNameErrorMessage(c0 name) {
        return name.onResume();
    }

    private final String C1(String str) {
        int i = 1;
        String string;
        str = str.length() == 0 ? 1 : 0;
        if (i != 0) {
            str2 = "{\n            getString(R.string.user_profile_name_alert)\n        }";
            n.e(getString(2131887645), str2);
        } else {
            str2 = "{\n            getString(R.string.dog_name_too_long)\n        }";
            n.e(getString(2131886467), str2);
        }
        return string;
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final d0 onResume() {
        return (DogPreviewNameScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final e0 E1() {
        return (DogPreviewNameViewModel)this.b.getValue();
    }

    private static final void I1(c0 c0Var, View view) throws android.content.res.Resources.NotFoundException {
        n.f(c0Var, "this$0");
        if (c0Var.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            String object = binding2.O.getText().toString();
            if (c0Var.E1().o(object)) {
                c0Var.E1().p(object);
            } else {
                int i = 1;
                Toast.makeText(c0Var.getContext(), c0Var.C1(object), i).show();
            }
            return;
        }
    }

    private static final void J1(c0 c0Var, View view) {
        n.f(c0Var, "this$0");
        final androidx.fragment.app.e activity = c0Var.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void K1(c0 c0Var, Boolean boolean) {
        String str;
        int i = 0;
        String str2;
        app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
        int i2 = 5;
        Object obj = null;
        n.f(c0Var, "this$0");
        str = "it";
        n.e(boolean, str);
        if (boolean.booleanValue()) {
            if (!c0Var.E1().isUserSignedIn()) {
                androidx.fragment.app.e activity2 = c0Var.getActivity();
                if (activity2 != null) {
                    i = 0;
                    zendeskConfigurationInfo = null;
                    i2 = 5;
                    obj = null;
                    str2 = "dog_edit";
                    app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity2, i, str2, zendeskConfigurationInfo, i2, obj);
                }
            }
            androidx.fragment.app.e activity = c0Var.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        gc gcVar = gc.T(inflater, container, false);
        n.e(gcVar, "inflate(inflater, container, false)");
        this.binding = gcVar;
        int i = 0;
        String str4 = "binding";
        if (gcVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            gcVar.V(E1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.M(getViewLifecycleOwner());
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    View view = this.binding.w();
                    n.e(view, "binding.root");
                    return view;
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
    public void onViewCreated(View view, Bundle bundle) throws o {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.profile.dogprofile.n(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.Q.setNavigationOnClickListener(new app.dogo.com.dogo_android.profile.dogprofile.o(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                n.e(viewLifecycleOwner, "viewLifecycleOwner");
                E1().l().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.profile.dogprofile.m(this));
                return;
            }
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(c0 view, Boolean savedInstanceState) {
        DogPreviewNameFragment.K1(view, savedInstanceState);
    }

    public static /* synthetic */ void G1(c0 c0Var, View view) {
        DogPreviewNameFragment.I1(c0Var, view);
    }

    public static /* synthetic */ void H1(c0 c0Var, View view) {
        DogPreviewNameFragment.J1(c0Var, view);
    }
}
