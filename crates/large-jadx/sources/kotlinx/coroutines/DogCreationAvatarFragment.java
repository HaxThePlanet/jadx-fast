package app.dogo.com.dogo_android.dogcreation.h;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.h.sb;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.h0.g1;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: DogCreationAvatarFragment.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0008\u0010 \u001a\u00020\u0011H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationPictureBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarViewModel;", "viewModel$delegate", "goToNextScreen", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class DogCreationAvatarFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private sb binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<androidx.activity.d, w> {
        @Override // kotlin.d0.d.p
        public final void a(androidx.activity.d dVar) {
            str = "$this$addCallback";
            n.f(dVar, str);
            z = e.this.E1().s().getValue() instanceof LoadResult_Loading;
            if (!(DogCreationAvatarFragment.C1(e.this).s().getValue() instanceof oadResult_Loading)) {
                androidx.fragment.app.e requireActivity = e.this.requireActivity();
                str = "requireActivity()";
                n.e(requireActivity, str);
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(requireActivity);
            }
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(DogCreationSharedViewModel.class), this.$parameters);
        }

        public b(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogCreationAvatarViewModel.class), this.$parameters);
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
            String str;
            Object[] arr = new Object[1];
            DogProfile dogProfile = e.this.goToNextScreen().l();
            str = "";
            if (dogProfile != null) {
                str = dogProfile.getId();
                if (str != null) {
                }
            }
            return org.koin.core.parameter.b.b(new Object[] { str });
        }

        d() {
            super(0);
        }
    }
    public e() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.e.b(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.e.c(this, aVar, new kotlinx.coroutines.e.d(this)));
    }

    public static final /* synthetic */ g B1(e eVar) {
        return eVar.goToNextScreen();
    }

    public static final /* synthetic */ g C1(e eVar) {
        return eVar.E1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final g goToNextScreen() {
        return (DogCreationSharedViewModel)this.b.getValue();
    }

    private final g E1() {
        return (DogCreationAvatarViewModel)this.c.getValue();
    }

    private final void F1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogCreationBreedScreen());
        }
    }

    private static final void K1(e eVar, View view) {
        int i = 0;
        n.f(eVar, "this$0");
        z = eVar.E1().s().getValue() instanceof LoadResult_Loading;
        if (!(eVar.E1().s().getValue() instanceof oadResult_Loading)) {
            z = eVar.getActivity() instanceof DogCreationActivity;
            eVar = eVar.getActivity() instanceof DogCreationActivity ? (DogCreationActivity)eVar.getActivity() : 0;
            if (i != 0) {
                i.C();
            }
        }
    }

    private static final void L1(e eVar, View view) {
        n.f(eVar, "this$0");
        final androidx.fragment.app.e activity = eVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void M1(e eVar, View view) {
        n.f(eVar, "this$0");
        eVar.F1();
    }

    private static final void N1(e eVar, View view) {
        n.f(eVar, "this$0");
        eVar.F1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 203) {
            com.theartofdev.edmodo.cropper.d.c cVar = d.b(data);
            if (resultCode != -1) {
                int i2 = 204;
                if (resultCode == 204) {
                    a.d(cVar.c());
                }
            } else {
                android.net.Uri uri = cVar.g();
                n.e(uri, "resultUri");
                E1().t(uri);
                android.net.Uri uri2 = E1().p();
                if (uri2 != null) {
                    E1().u(uri2);
                } else {
                    androidx.fragment.app.e activity = getActivity();
                    if (activity != null) {
                        int i = 2131886123;
                        app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, i);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i;
        n.f(inflater, "inflater");
        boolean z = false;
        sb sbVar = sb.T(inflater, container, z);
        n.e(sbVar, "inflate(inflater, container, false)");
        this.binding = sbVar;
        String str2 = "binding";
        i = 0;
        if (sbVar == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            sbVar.V(E1());
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                Object[] arr = new Object[1];
                DogProfile dogProfile = goToNextScreen().l();
                if (dogProfile == null) {
                } else {
                    String name = dogProfile.getName();
                }
                arr[z] = i;
                binding2.Q.setText(getString(2131886456, arr));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str2);
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
        int i = 0;
        super.onResume();
        if (goToNextScreen().l() == null) {
            z = getActivity() instanceof DogCreationActivity;
            DogCreationActivity r0 = this.getActivity() instanceof DogCreationActivity ? (DogCreationActivity)this.getActivity() : 0;
            if (i != 0) {
                i.y();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws c {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new kotlinx.coroutines.e.a(this), 2, null);
        int i4 = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i4;
        } else {
            binding2.O.setOnClickListener(new kotlinx.coroutines.b(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i4;
            } else {
                binding22.R.setNavigationOnClickListener(new kotlinx.coroutines.a(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i4;
                } else {
                    binding23.S.setOnClickListener(new kotlinx.coroutines.d(this));
                    if (this.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i4;
                    } else {
                        binding24.P.setOnClickListener(new kotlinx.coroutines.c(this));
                        return;
                    }
                }
            }
        }
    }


    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(e view, View savedInstanceState) {
        DogCreationAvatarFragment.L1(view, savedInstanceState);
    }

    public static /* synthetic */ void H1(e eVar, View view) {
        DogCreationAvatarFragment.K1(eVar, view);
    }

    public static /* synthetic */ void I1(e eVar, View view) {
        DogCreationAvatarFragment.N1(eVar, view);
    }

    public static /* synthetic */ void J1(e eVar, View view) {
        DogCreationAvatarFragment.M1(eVar, view);
    }
}
