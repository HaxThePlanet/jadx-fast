package app.dogo.com.dogo_android.dogcreation.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.dogcreation.DogCreationActivity;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.h.eb;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.h0.g1;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: DogCreationBirthdayFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u0011H\u0016J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00132\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/birthday/DogCreationBirthdayFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationBirthdayBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/birthday/DogCreationBirthdayViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/birthday/DogCreationBirthdayViewModel;", "viewModel$delegate", "goToNextScreen", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class DogCreationBirthdayFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private eb binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ d a;
        public final void onChanged(T t) {
            n.e(t, "it");
            if (t.booleanValue()) {
                this.a.G1();
            }
        }

        public a() {
            this.a = dVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            str = "$this$addCallback";
            n.f(dVar, str);
            z = d.this.F1().o().getValue() instanceof LoadResult_Loading;
            if (!(DogCreationBirthdayFragment.C1(d.this).o().getValue() instanceof oadResult_Loading)) {
                androidx.fragment.app.e requireActivity = d.this.requireActivity();
                str = "requireActivity()";
                n.e(requireActivity, str);
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(requireActivity);
            }
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(DogCreationSharedViewModel.class), this.$parameters);
        }

        public c(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogCreationBirthdayViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            int i = 0;
            Object[] arr = new Object[1];
            DogProfile dogProfile = d.this.goToNextScreen().l();
            if (dogProfile == null) {
                i = 0;
            } else {
                Long birthday = dogProfile.getBirthday();
            }
            return org.koin.core.parameter.b.b(new Object[] { i });
        }

        e() {
            super(0);
        }
    }
    public d() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.d.c(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.d.d(this, aVar, new kotlinx.coroutines.d.e(this)));
    }

    public static final /* synthetic */ g B1(d dVar) {
        return dVar.goToNextScreen();
    }

    public static final /* synthetic */ f C1(d dVar) {
        return dVar.F1();
    }

    public static final /* synthetic */ void D1(d dVar) {
        dVar.G1();
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final g goToNextScreen() {
        return (DogCreationSharedViewModel)this.b.getValue();
    }

    private final f F1() {
        return (DogCreationBirthdayViewModel)this.c.getValue();
    }

    private final void G1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogCreationGenderScreen());
        }
    }

    private static final void K1(d dVar, View view) {
        String dVar2;
        n.f(dVar, "this$0");
        final long currentlySelectedTimeInMillis = dVar.F1().getCurrentlySelectedTimeInMillis();
        if (dVar.F1().r(currentlySelectedTimeInMillis)) {
            dVar2 = "";
            if (dVar.F1().q()) {
                DogProfile dogProfile = dVar.goToNextScreen().l();
                if (dogProfile != null) {
                    dVar2 = dogProfile.getId();
                    if (dVar2 != null) {
                    }
                }
                dVar.F1().saveBirthday(dVar2, Long.valueOf(currentlySelectedTimeInMillis));
            } else {
                DogProfile dogProfile2 = dVar.goToNextScreen().l();
                if (dogProfile2 != null) {
                    dVar2 = dogProfile2.getId();
                    if (dVar2 != null) {
                    }
                }
                dVar.F1().saveBirthday(dVar2, null);
            }
        } else {
            androidx.fragment.app.e activity = dVar.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886451);
            }
        }
    }

    private static final void L1(d dVar, View view) {
        n.f(dVar, "this$0");
        final androidx.fragment.app.e activity = dVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void M1(d dVar, View view) {
        n.f(dVar, "this$0");
        dVar.G1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i;
        n.f(inflater, "inflater");
        boolean z = false;
        eb ebVar = eb.T(inflater, container, z);
        n.e(ebVar, "inflate(inflater, container, false)");
        this.binding = ebVar;
        String str2 = "binding";
        i = 0;
        if (ebVar == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ebVar.V(F1());
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
                binding2.Q.setText(getString(2131886454, arr));
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
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new kotlinx.coroutines.d.b(this), 2, null);
        int i4 = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i4;
        } else {
            binding2.P.setOnClickListener(new kotlinx.coroutines.a(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i4;
            } else {
                binding22.R.setNavigationOnClickListener(new kotlinx.coroutines.b(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i4;
                } else {
                    binding23.S.setOnClickListener(new kotlinx.coroutines.c(this));
                    androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                    n.e(viewLifecycleOwner2, "viewLifecycleOwner");
                    F1().m().observe(viewLifecycleOwner2, new kotlinx.coroutines.d.a(this));
                    return;
                }
            }
        }
    }


    /* renamed from: H1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(d view, View savedInstanceState) {
        DogCreationBirthdayFragment.K1(view, savedInstanceState);
    }

    public static /* synthetic */ void I1(d dVar, View view) {
        DogCreationBirthdayFragment.L1(dVar, view);
    }

    public static /* synthetic */ void J1(d dVar, View view) {
        DogCreationBirthdayFragment.M1(dVar, view);
    }
}
