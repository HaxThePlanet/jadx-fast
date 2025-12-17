package app.dogo.com.dogo_android.q.p;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.h.qc;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.q.r.c;
import app.dogo.com.dogo_android.q.s.d;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.j;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import com.theartofdev.edmodo.cropper.d;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J$\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0008\u0010*\u001a\u0004\u0018\u00010+2\u0008\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u00100\u001a\u00020\u0016H\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0008\u00104\u001a\u00020\u0016H\u0016J\u001a\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020'2\u0008\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00107\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogPreviewFullscreenBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "viewModel$delegate", "callDogDeleteAlert", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAddDogClick", "onAddNewDogClick", "onAvatarClick", "onBirthdayClick", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "onBreedClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteDogClick", "onDogOwnerClick", "onDogSelectClick", "onGenderClick", "onNameClick", "onParticipateInWelcomeChallengeClick", "onResume", "onViewCreated", "view", "showDogOwners", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x extends Fragment implements app.dogo.com.dogo_android.q.p.v {

    private qc a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class c implements y<T> {

        final app.dogo.com.dogo_android.q.p.x a;
        public c(app.dogo.com.dogo_android.q.p.x x) {
            this.a = x;
            super();
        }

        public final void onChanged(T t) {
            boolean z;
            Object obj2;
            if (t instanceof y.c) {
                x.C1(this.a).v((DogProfile)(y.c)(y)t.a().getId());
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class d implements y<T> {

        final app.dogo.com.dogo_android.q.p.x a;
        public d(app.dogo.com.dogo_android.q.p.x x) {
            this.a = x;
            super();
        }

        public final void onChanged(T t) {
            androidx.fragment.app.e activity;
            int i;
            String str;
            int i4;
            int i2;
            int i3;
            boolean obj7;
            if (!x.C1(this.a).isUserSignedIn()) {
                activity = this.a.getActivity();
                if (activity == null) {
                } else {
                    g1.H(activity, 0, "dog_edit", 0, 5, 0);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class e implements y<T> {

        final app.dogo.com.dogo_android.q.p.x a;
        public e(app.dogo.com.dogo_android.q.p.x x) {
            this.a = x;
            super();
        }

        public final void onChanged(T t) {
            String str;
            int i;
            int i2;
            boolean obj4;
            n.e((Boolean)t, "it");
            if (t.booleanValue()) {
                x.C1(this.a).x();
                i = 0;
                if (obj4 instanceof a0) {
                } else {
                    obj4 = i;
                }
                if (obj4 == null) {
                } else {
                    a0.y0(obj4, i, 11100, 1, i);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class f implements y<T> {

        final app.dogo.com.dogo_android.q.p.x a;
        public f(app.dogo.com.dogo_android.q.p.x x) {
            this.a = x;
            super();
        }

        public final void onChanged(T t) {
            n nVar;
            android.content.Context requireContext;
            String str;
            Object obj5;
            androidx.fragment.app.e activity = this.a.getActivity();
            if (activity == null) {
            } else {
                requireContext = this.a.requireContext();
                n.e(requireContext, "requireContext()");
                g1.i0(activity, n.a.i((Exception)t, requireContext));
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final ProfilePreview $profilePreview;
        final app.dogo.com.dogo_android.q.p.x this$0;
        a(app.dogo.com.dogo_android.q.p.x x, ProfilePreview profilePreview2) {
            this.this$0 = x;
            this.$profilePreview = profilePreview2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            x.B1(this.this$0).e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final ProfilePreview $profilePreview;
        final app.dogo.com.dogo_android.q.p.x this$0;
        b(app.dogo.com.dogo_android.q.p.x x, ProfilePreview profilePreview2) {
            this.this$0 = x;
            this.$profilePreview = profilePreview2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            x.B1(this.this$0).e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public g(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends p implements a<app.dogo.com.dogo_android.q.p.h0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public h(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.q.p.h0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(h0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<a> {

        public static final app.dogo.com.dogo_android.q.p.x.i a;
        static {
            x.i iVar = new x.i();
            x.i.a = iVar;
        }

        i() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(Boolean.TRUE);
        }
    }
    static {
    }

    public x() {
        super();
        final int i = 0;
        x.h hVar3 = new x.h(this, i, x.i.a);
        this.b = j.a(m.SYNCHRONIZED, hVar3);
        x.g gVar = new x.g(this, i, i);
        this.c = j.a(m.NONE, gVar);
    }

    public static final l B1(app.dogo.com.dogo_android.q.p.x x) {
        return x.getSharedViewModel();
    }

    public static final app.dogo.com.dogo_android.q.p.h0 C1(app.dogo.com.dogo_android.q.p.x x) {
        return x.F1();
    }

    private final void D1(ProfilePreview profilePreview) {
        androidx.fragment.app.e activity;
        p aVar;
        if (profilePreview.isUserDogsCreator() != null) {
            activity = getActivity();
            if (activity == null) {
            } else {
                aVar = new x.a(this, profilePreview);
                f1.Q(activity, aVar);
            }
        } else {
            activity = getActivity();
            if (activity == null) {
            } else {
                aVar = new x.b(this, profilePreview);
                f1.y0(activity, aVar);
            }
        }
    }

    private final app.dogo.com.dogo_android.q.p.y E1() {
        return (y)k1.a(this);
    }

    private final app.dogo.com.dogo_android.q.p.h0 F1() {
        return (h0)this.b.getValue();
    }

    public static void G1(app.dogo.com.dogo_android.q.p.x x, View view2) {
        x.I1(x, view2);
    }

    private final void H1(ProfilePreview profilePreview) {
        androidx.fragment.app.e activity;
        int i5;
        l sharedViewModel;
        String str;
        String tag;
        int i;
        int i4;
        int i3;
        int i2;
        int obj10;
        F1().z();
        if (profilePreview.getUserPremium() != null) {
            if (obj10 instanceof a0) {
            } else {
                obj10 = 0;
            }
            if (obj10 == null) {
            } else {
                obj10.w0(F1().r(), 11101);
            }
        } else {
            g1.n(getActivity(), l.H(getSharedViewModel(), "dog_profile", E1().getTag(), false, 0, 12, 0));
        }
    }

    private static final void I1(app.dogo.com.dogo_android.q.p.x x, View view2) {
        n.f(x, "this$0");
        final androidx.fragment.app.e obj0 = x.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private final void J1(ProfilePreview profilePreview) {
        boolean userPremium;
        DogProfile sharedViewModel;
        boolean userDogsCreator;
        Object str;
        int i3;
        int i2;
        int i;
        ProfilePreview obj8;
        if (profilePreview.isUserDogsCreator() != null) {
            if (profilePreview.getUserPremium() == null) {
                g1.n(getActivity(), getSharedViewModel().G("dog_profile", E1().getTag(), true, profilePreview));
            } else {
                if (!F1().isUserSignedIn()) {
                    userPremium = getActivity();
                    if (userPremium == null) {
                    } else {
                        androidx.fragment.app.e activity = getActivity();
                        if (activity == null) {
                            obj8 = 0;
                        } else {
                            obj8 = i1.f(activity, "dog_profile", profilePreview, 0, 4, 0);
                        }
                        userPremium.startActivityForResult(obj8, 134679);
                    }
                } else {
                    if (!F1().isUserNameSet()) {
                        userPremium = getActivity();
                        if (userPremium == null) {
                        } else {
                            sharedViewModel = new c(profilePreview);
                            g1.n(userPremium, sharedViewModel);
                        }
                    } else {
                        obj8 = getActivity();
                        if (obj8 == null) {
                        } else {
                            userPremium = new d(profilePreview.getDogProfile());
                            g1.X(obj8, userPremium);
                        }
                    }
                }
            }
        }
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(DogProfile dogProfile) {
        app.dogo.com.dogo_android.q.p.d0 d0Var;
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            d0Var = new d0(dogProfile);
            g1.n(activity, d0Var);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I0(DogProfile dogProfile) {
        app.dogo.com.dogo_android.q.p.t tVar;
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            tVar = new t(dogProfile);
            g1.n(activity, tVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void J(DogProfile dogProfile) {
        app.dogo.com.dogo_android.q.p.q qVar;
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            qVar = new q(dogProfile);
            g1.n(activity, qVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z0(DogProfile dogProfile) {
        app.dogo.com.dogo_android.q.p.a0 a0Var;
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            a0Var = new a0(dogProfile);
            g1.n(activity, a0Var);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void a1(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        F1().A();
        D1(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void c0(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        H1(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void n(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        J1(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        int i3;
        int obj3;
        int obj4;
        Object obj5;
        super.onActivityResult(i, i2, intent3);
        final int i4 = -1;
        if (i == 203) {
            if (i2 != i4) {
                if (i2 != 204) {
                } else {
                    a.e(d.b(intent3).c(), "Something went wrong with cropping", new Object[0]);
                }
            } else {
                obj4 = d.b(intent3).g();
                n.e(obj4, "getActivityResult(data).uri");
                F1().w(obj4);
            }
        } else {
            if (i == 134679 && i2 == i4) {
                if (i2 == i4) {
                    if (intent3 == null) {
                        obj3 = 0;
                    } else {
                        obj3 = intent3.getParcelableExtra("profile_preview");
                    }
                    if (obj3 != null) {
                        J1(obj3);
                    } else {
                        obj3 = new Exception("Dog parent open flow failed. Missing profile data from login screen");
                        a.d(obj3);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        qc obj2 = qc.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(F1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2 = obj2.w();
                        n.e(obj2, "binding.root");
                        return obj2;
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity;
        super.onResume();
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        boolean obj3;
        androidx.lifecycle.q obj4;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        obj3 = this.a;
        if (obj3 == null) {
        } else {
            obj4 = new i(this);
            obj3.Q.setOnClickListener(obj4);
            obj4 = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(obj4, str2);
            x.c cVar = new x.c(this);
            getSharedViewModel().E().observe(obj4, cVar);
            obj4 = getViewLifecycleOwner();
            n.e(obj4, str2);
            x.d dVar = new x.d(this);
            F1().s().observe(obj4, dVar);
            obj4 = getViewLifecycleOwner();
            n.e(obj4, str2);
            x.e eVar = new x.e(this);
            getSharedViewModel().F().observe(obj4, eVar);
            obj4 = getViewLifecycleOwner();
            n.e(obj4, str2);
            x.f fVar = new x.f(this);
            F1().u().observe(obj4, fVar);
            if (E1().a() && E1().getProfilePreview() != null) {
                if (E1().getProfilePreview() != null) {
                    E1().b(false);
                    obj3 = E1().getProfilePreview();
                    n.d(obj3);
                    J1(obj3);
                }
            }
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(DogProfile dogProfile) {
        int activity;
        String str;
        android.net.Uri i;
        android.content.Context context;
        n.f(dogProfile, "dogProfile");
        final String obj5 = dogProfile.getId();
        if (activity instanceof a0) {
        } else {
            activity = i;
        }
        if (activity == null) {
        } else {
            context = getContext();
            if (context == null) {
            } else {
                i = i1.d(context, obj5, "avatar.jpg");
            }
            activity.i0(o.WELCOME_CHALLENGE.getId(), obj5, i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void u() {
        androidx.fragment.app.e activity;
        String str;
        String str2;
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.l0("dog_select", "dog_profile");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void z() {
        androidx.fragment.app.e activity;
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.C0();
        }
    }
}
