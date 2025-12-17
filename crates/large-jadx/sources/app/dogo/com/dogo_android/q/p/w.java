package app.dogo.com.dogo_android.q.p;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.c.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.h.oc;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.q.r.c;
import app.dogo.com.dogo_android.q.s.d;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.j;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import com.theartofdev.edmodo.cropper.d;
import f.c.a.e.s.b;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
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
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\u0008\u0010\u001e\u001a\u00020\u0016H\u0002J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010'\u001a\u00020\u0016H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u0001012\u0008\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u00106\u001a\u00020\u0016H\u0016J\u0010\u00107\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00109\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010:\u001a\u00020\u0016H\u0016J\u001a\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020-2\u0008\u00102\u001a\u0004\u0018\u000103H\u0016J\u0008\u0010=\u001a\u00020\u0016H\u0002J\u0018\u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogPreviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "viewModel$delegate", "callDogDeleteAlert", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "callSubscriptionDialog", "handleDestinationScreens", "destination", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "profileData", "loadNextAppScreenAfterResultIfRequested", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAddDogClick", "onAddNewDogClick", "onAvatarClick", "onBirthdayClick", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "onBreedClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteDogClick", "onDogOwnerClick", "onDogSelectClick", "onGenderClick", "onNameClick", "onParticipateInWelcomeChallengeClick", "onResume", "onViewCreated", "view", "removeDestinationFromKey", "showDogOwners", "showSubscriptionDialog", "", "showDogOwnersDeeplinkFlow", "showDogOwnersNormalFlow", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class w extends Fragment implements app.dogo.com.dogo_android.q.p.v {

    public static final app.dogo.com.dogo_android.q.p.w.a Companion;
    private oc a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFragment$Companion;", "", "()V", "DOG_PARENTS_LOGIN_REQUEST", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class e implements y<T> {

        final app.dogo.com.dogo_android.q.p.w a;
        public e(app.dogo.com.dogo_android.q.p.w w) {
            this.a = w;
            super();
        }

        public final void onChanged(T t) {
            boolean z;
            Object obj2;
            if (t instanceof y.c) {
                w.C1(this.a).v((DogProfile)(y.c)(y)t.a().getId());
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class f implements y<T> {

        final app.dogo.com.dogo_android.q.p.w a;
        public f(app.dogo.com.dogo_android.q.p.w w) {
            this.a = w;
            super();
        }

        public final void onChanged(T t) {
            androidx.fragment.app.e activity;
            int i3;
            String str;
            int i4;
            int i2;
            int i;
            boolean obj7;
            if (!w.C1(this.a).isUserSignedIn()) {
                activity = this.a.getActivity();
                if (activity == null) {
                } else {
                    g1.H(activity, 0, "dog_edit", 0, 5, 0);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class g implements y<T> {

        final app.dogo.com.dogo_android.q.p.w a;
        public g(app.dogo.com.dogo_android.q.p.w w) {
            this.a = w;
            super();
        }

        public final void onChanged(T t) {
            String str;
            int i2;
            int i;
            boolean obj4;
            n.e((Boolean)t, "it");
            if (t.booleanValue()) {
                w.C1(this.a).x();
                i2 = 0;
                if (obj4 instanceof a0) {
                } else {
                    obj4 = i2;
                }
                if (obj4 == null) {
                } else {
                    a0.y0(obj4, i2, 11100, 1, i2);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class h implements y<T> {

        final app.dogo.com.dogo_android.q.p.w a;
        public h(app.dogo.com.dogo_android.q.p.w w) {
            this.a = w;
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
    static final class b extends p implements a<w> {

        final ProfilePreview $profilePreview;
        final app.dogo.com.dogo_android.q.p.w this$0;
        b(app.dogo.com.dogo_android.q.p.w w, ProfilePreview profilePreview2) {
            this.this$0 = w;
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
            w.B1(this.this$0).e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final ProfilePreview $profilePreview;
        final app.dogo.com.dogo_android.q.p.w this$0;
        c(app.dogo.com.dogo_android.q.p.w w, ProfilePreview profilePreview2) {
            this.this$0 = w;
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
            w.B1(this.this$0).e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<y<? extends ProfilePreview>, Boolean> {

        public static final app.dogo.com.dogo_android.q.p.w.d a;
        static {
            w.d dVar = new w.d();
            w.d.a = dVar;
        }

        d() {
            super(1);
        }

        public final boolean a(y<ProfilePreview> y) {
            return y instanceof y.c;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a((y)object));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class i extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public i(Fragment fragment, a a2, a a3) {
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
    public static final class j extends p implements a<app.dogo.com.dogo_android.q.p.h0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public j(j0 j0, a a2, a a3) {
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
    static final class k extends p implements a<a> {

        public static final app.dogo.com.dogo_android.q.p.w.k a;
        static {
            w.k kVar = new w.k();
            w.k.a = kVar;
        }

        k() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(Boolean.FALSE);
        }
    }
    static {
        w.a aVar = new w.a(0);
        w.Companion = aVar;
    }

    public w() {
        super();
        final int i = 0;
        w.j jVar = new w.j(this, i, w.k.a);
        this.b = j.a(m.SYNCHRONIZED, jVar);
        w.i iVar = new w.i(this, i, i);
        this.c = j.a(m.NONE, iVar);
    }

    public static final l B1(app.dogo.com.dogo_android.q.p.w w) {
        return w.getSharedViewModel();
    }

    public static final app.dogo.com.dogo_android.q.p.h0 C1(app.dogo.com.dogo_android.q.p.w w) {
        return w.H1();
    }

    private final void D1(ProfilePreview profilePreview) {
        androidx.fragment.app.e activity;
        p bVar;
        if (profilePreview.isUserDogsCreator() != null) {
            activity = getActivity();
            if (activity == null) {
            } else {
                bVar = new w.b(this, profilePreview);
                f1.Q(activity, bVar);
            }
        } else {
            activity = getActivity();
            if (activity == null) {
            } else {
                bVar = new w.c(this, profilePreview);
                f1.y0(activity, bVar);
            }
        }
    }

    private final void E1(ProfilePreview profilePreview) {
        b bVar = new b(requireContext());
        int i3 = 2131887317;
        h hVar = new h(this, profilePreview);
        bVar.H(getResources().getString(i3)).x(getResources().getString(2131886205)).E(getResources().getString(i3), hVar).y(2131886677, 0).o();
    }

    private static final void F1(app.dogo.com.dogo_android.q.p.w w, ProfilePreview profilePreview2, DialogInterface dialogInterface3, int i4) {
        n.f(w, "this$0");
        n.f(profilePreview2, "$profilePreview");
        g1.n(w.getActivity(), w.getSharedViewModel().G("dog_profile", w.G1().getTag(), true, profilePreview2));
    }

    private final app.dogo.com.dogo_android.q.p.f0 G1() {
        return (f0)k1.a(this);
    }

    private final app.dogo.com.dogo_android.q.p.h0 H1() {
        return (h0)this.b.getValue();
    }

    private final void I1(j j, ProfilePreview profilePreview2) {
        if (j instanceof d) {
            Q1(profilePreview2);
        }
    }

    public static void J1(app.dogo.com.dogo_android.q.p.w w, j j2, y y3) {
        w.M1(w, j2, y3);
    }

    public static void K1(app.dogo.com.dogo_android.q.p.w w, ProfilePreview profilePreview2, DialogInterface dialogInterface3, int i4) {
        w.F1(w, profilePreview2, dialogInterface3, i4);
    }

    private final void L1() {
        androidx.lifecycle.x xVar;
        androidx.lifecycle.q viewLifecycleOwner;
        app.dogo.com.dogo_android.q.p.w.d dVar;
        app.dogo.com.dogo_android.q.p.g gVar;
        j jVar = G1().c();
        if (jVar != null) {
            viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            gVar = new g(this, jVar);
            j1.u0(H1().t(), viewLifecycleOwner, w.d.a, gVar);
            O1();
        }
    }

    private static final void M1(app.dogo.com.dogo_android.q.p.w w, j j2, y y3) {
        Object obj3;
        n.f(w, "this$0");
        if (y3 instanceof y.c) {
            w.I1(j2, (ProfilePreview)(y.c)y3.a());
        }
    }

    private final void N1(ProfilePreview profilePreview) {
        androidx.fragment.app.e activity;
        int i4;
        l sharedViewModel;
        String str;
        String tag;
        int i;
        int i5;
        int i2;
        int i3;
        int obj10;
        H1().z();
        if (profilePreview.getUserPremium() != null) {
            if (obj10 instanceof a0) {
            } else {
                obj10 = 0;
            }
            if (obj10 == null) {
            } else {
                obj10.w0(H1().r(), 11101);
            }
        } else {
            g1.n(getActivity(), l.H(getSharedViewModel(), "dog_profile", G1().getTag(), false, 0, 12, 0));
        }
    }

    private final void O1() {
        app.dogo.com.dogo_android.q.p.f0 f0Var;
        String str;
        int i3;
        int i;
        int i2;
        int i4;
        final Bundle arguments = getArguments();
        if (arguments == null) {
        } else {
            arguments.putParcelable("SCREEN_KEY", f0.b(G1(), false, 0, 0, 3, 0));
        }
    }

    private final void P1(ProfilePreview profilePreview, boolean z2) {
        boolean sharedViewModel;
        Object dogProfile;
        boolean userDogsCreator;
        int i2;
        int i;
        int i3;
        int obj7;
        androidx.fragment.app.e obj8;
        if (profilePreview.isUserDogsCreator() != null) {
            if (profilePreview.getUserPremium() == null) {
                if (z2 != null) {
                    E1(profilePreview);
                } else {
                    g1.n(getActivity(), getSharedViewModel().G("dog_profile", G1().getTag(), true, profilePreview));
                }
            } else {
                if (!H1().isUserSignedIn()) {
                    obj8 = getActivity();
                    if (obj8 == null) {
                    } else {
                        androidx.fragment.app.e activity = getActivity();
                        if (activity == null) {
                            obj7 = 0;
                        } else {
                            obj7 = i1.f(activity, "dog_profile", profilePreview, 0, 4, 0);
                        }
                        obj8.startActivityForResult(obj7, 134679);
                    }
                } else {
                    if (!H1().isUserNameSet()) {
                        obj8 = getActivity();
                        if (obj8 == null) {
                        } else {
                            sharedViewModel = new c(profilePreview);
                            g1.n(obj8, sharedViewModel);
                        }
                    } else {
                        obj7 = getActivity();
                        if (obj7 == null) {
                        } else {
                            obj8 = new d(profilePreview.getDogProfile());
                            g1.X(obj7, obj8);
                        }
                    }
                }
            }
        }
    }

    private final void Q1(ProfilePreview profilePreview) {
        P1(profilePreview, true);
    }

    private final void R1(ProfilePreview profilePreview) {
        P1(profilePreview, false);
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
        H1().A();
        D1(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void c0(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        N1(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void n(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        R1(profilePreview);
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
                H1().w(obj4);
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
                        R1(obj3);
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
        oc obj2 = oc.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(H1());
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
            activity.p0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        boolean obj3;
        androidx.lifecycle.q obj4;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        w.e eVar = new w.e(this);
        getSharedViewModel().E().observe(obj4, eVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        w.f fVar = new w.f(this);
        H1().s().observe(obj4, fVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        w.g gVar = new w.g(this);
        getSharedViewModel().F().observe(obj4, gVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        w.h hVar = new w.h(this);
        H1().u().observe(obj4, hVar);
        if (G1().d() && G1().getProfilePreview() != null) {
            if (G1().getProfilePreview() != null) {
                G1().e(false);
                obj3 = G1().getProfilePreview();
                n.d(obj3);
                R1(obj3);
            }
        }
        L1();
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
        String str2;
        String str;
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
