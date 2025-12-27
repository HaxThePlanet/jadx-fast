package app.dogo.com.dogo_android.q.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.j.i.b;
import app.dogo.com.dogo_android.h.cc;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
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
import m.a.b.a.d.a.b;

/* compiled from: DogPreviewBreedFragment.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0008\u0010\u001e\u001a\u00020\u0011H\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogEditBreedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAddNewSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "onBreedItemSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s, reason: from kotlin metadata */
public final class DogPreviewBreedFragment extends Fragment implements i.b {

    /* renamed from: a, reason: from kotlin metadata */
    private cc binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<u> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final u invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogPreviewBreedViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public s() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.profile.dogprofile.s.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final t onResume() {
        return (DogPreviewBreedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final u C1() {
        return (DogPreviewBreedViewModel)this.b.getValue();
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final void onAddNewSelected(DogBreed item) {
        String str;
        if (item.getId() == null) {
            str = "id_custom_breed";
        }
        C1().q(str);
        C1().o(item, onResume().createFragment().getId());
    }

    private static final void H1(s sVar, View view) {
        n.f(sVar, "this$0");
        final androidx.fragment.app.e activity = sVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void I1(s sVar, View view) {
        n.f(sVar, "this$0");
        if (sVar.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.Q.setText("");
            return;
        }
    }

    private static final void J1(s sVar, Boolean boolean) {
        String str;
        int i = 0;
        String str2;
        app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
        int i2 = 5;
        Object obj = null;
        n.f(sVar, "this$0");
        str = "it";
        n.e(boolean, str);
        if (boolean.booleanValue()) {
            if (!sVar.C1().isUserSignedIn()) {
                androidx.fragment.app.e activity2 = sVar.getActivity();
                if (activity2 != null) {
                    i = 0;
                    zendeskConfigurationInfo = null;
                    i2 = 5;
                    obj = null;
                    str2 = "dog_edit";
                    app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity2, i, str2, zendeskConfigurationInfo, i2, obj);
                }
            }
            androidx.fragment.app.e activity = sVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: A0, reason: from kotlin metadata */
    public void onBreedItemSelected(DogBreed item) {
        n.f(item, "item");
        onAddNewSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        cc ccVar = cc.T(inflater, container, false);
        n.e(ccVar, "inflate(inflater, container, false)");
        this.binding = ccVar;
        int i = 0;
        String str4 = "binding";
        if (ccVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ccVar.W(C1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(this);
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
    public void onViewCreated(View view, Bundle bundle) throws e {
        int i = 0;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        view = onResume().b().length() > 0 ? 1 : 0;
        int i2 = 0;
        String str3 = "binding";
        if (i != 0) {
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                binding23.Q.setText(onResume().b());
            }
        }
        if (this.binding == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            binding2.R.setNavigationOnClickListener(new app.dogo.com.dogo_android.profile.dogprofile.d(this));
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                binding22.O.setOnClickListener(new app.dogo.com.dogo_android.profile.dogprofile.e(this));
                androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                n.e(viewLifecycleOwner, "viewLifecycleOwner");
                C1().k().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.profile.dogprofile.f(this));
                return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: y1, reason: from kotlin metadata */
    public void onItemSelected(DogBreed item) {
        n.f(item, "item");
        onAddNewSelected(item);
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(s view, View savedInstanceState) {
        DogPreviewBreedFragment.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void E1(s sVar, View view) {
        DogPreviewBreedFragment.I1(sVar, view);
    }

    public static /* synthetic */ void F1(s sVar, Boolean boolean) {
        DogPreviewBreedFragment.J1(sVar, boolean);
    }
}
