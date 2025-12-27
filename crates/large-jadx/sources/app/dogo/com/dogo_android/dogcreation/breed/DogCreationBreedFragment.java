package app.dogo.com.dogo_android.dogcreation.j;

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
import app.dogo.com.dogo_android.h.gb;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
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
import m.a.b.a.d.a.b;

/* compiled from: DogCreationBreedFragment.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0011H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00142\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationBreedBinding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedViewModel;", "viewModel$delegate", "callSearchDialog", "", "goToNextScreen", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class DogCreationBreedFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private gb binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ j a;
        public final void onChanged(T t) {
            n.e(t, "it");
            if (t.booleanValue()) {
                this.a.G1();
            }
        }

        public a() {
            this.a = jVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            str = "$this$addCallback";
            n.f(dVar, str);
            z = j.this.F1().l().getValue() instanceof LoadResult_Loading;
            if (!(DogCreationBreedFragment.B1(j.this).l().getValue() instanceof oadResult_Loading)) {
                androidx.fragment.app.e requireActivity = j.this.requireActivity();
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
    public static final class d extends p implements kotlin.d0.c.a<n> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogCreationBreedViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public j() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.dogcreation.breed.j.c(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dogcreation.breed.j.d(this, aVar, aVar));
    }

    public static final /* synthetic */ n B1(j jVar) {
        return jVar.F1();
    }

    public static final /* synthetic */ void C1(j jVar) {
        jVar.G1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final void callSearchDialog() {
        String name;
        String str;
        Object value = E1().k().getValue();
        if (value == null || value.getId() != null) {
            name = "";
        } else {
            name = value.getName();
        }
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new DogCreationBreedSearchAppScreen(name));
        }
    }

    private final g E1() {
        return (DogCreationSharedViewModel)this.b.getValue();
    }

    private final n F1() {
        return (DogCreationBreedViewModel)this.c.getValue();
    }

    private final void G1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogCreationBirthdayScreen());
        }
    }

    private static final void L1(j jVar, View view) {
        String jVar2;
        n.f(jVar, "this$0");
        Object value = jVar.E1().k().getValue();
        if (value != null) {
            DogProfile dogProfile = jVar.E1().l();
            jVar2 = "";
            if (dogProfile != null) {
                jVar2 = dogProfile.getId();
                if (jVar2 != null) {
                }
            }
            jVar.F1().saveDogBreed(jVar2, value);
        } else {
            jVar.G1();
        }
    }

    private static final void M1(j jVar, View view) {
        n.f(jVar, "this$0");
        jVar.callSearchDialog();
    }

    private static final void N1(j jVar, View view) {
        n.f(jVar, "this$0");
        final androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void O1(j jVar, View view) {
        n.f(jVar, "this$0");
        jVar.G1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        gb gbVar = gb.T(inflater, container, false);
        n.e(gbVar, "inflate(inflater, container, false)");
        this.binding = gbVar;
        int i = 0;
        String str4 = "binding";
        if (gbVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            gbVar.W(F1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(E1());
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
        int i = 0;
        super.onResume();
        if (E1().l() == null) {
            z = getActivity() instanceof DogCreationActivity;
            DogCreationActivity r0 = this.getActivity() instanceof DogCreationActivity ? (DogCreationActivity)this.getActivity() : 0;
            if (i != 0) {
                i.y();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws d {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new app.dogo.com.dogo_android.dogcreation.breed.j.b(this), 2, null);
        int i4 = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i4;
        } else {
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.c(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i4;
            } else {
                binding22.O.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.e(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i4;
                } else {
                    binding23.R.setNavigationOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.f(this));
                    if (this.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i4;
                    } else {
                        binding24.S.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.d(this));
                        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                        n.e(viewLifecycleOwner2, "viewLifecycleOwner");
                        F1().k().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.dogcreation.breed.j.a(this));
                        return;
                    }
                }
            }
        }
    }


    /* renamed from: H1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(j view, View savedInstanceState) {
        DogCreationBreedFragment.L1(view, savedInstanceState);
    }

    public static /* synthetic */ void I1(j jVar, View view) {
        DogCreationBreedFragment.O1(jVar, view);
    }

    public static /* synthetic */ void J1(j jVar, View view) {
        DogCreationBreedFragment.M1(jVar, view);
    }

    public static /* synthetic */ void K1(j jVar, View view) {
        DogCreationBreedFragment.N1(jVar, view);
    }
}
