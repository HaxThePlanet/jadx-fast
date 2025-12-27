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
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;
import kotlin.w;

/* compiled from: DogPreviewFullscreenFragment.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J$\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0008\u0010*\u001a\u0004\u0018\u00010+2\u0008\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u00100\u001a\u00020\u0016H\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0008\u00104\u001a\u00020\u0016H\u0016J\u001a\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020'2\u0008\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00107\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogPreviewFullscreenBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "viewModel$delegate", "callDogDeleteAlert", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAddDogClick", "onAddNewDogClick", "onAvatarClick", "onBirthdayClick", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "onBreedClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteDogClick", "onDogOwnerClick", "onDogSelectClick", "onGenderClick", "onNameClick", "onParticipateInWelcomeChallengeClick", "onResume", "onViewCreated", "view", "showDogOwners", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x, reason: from kotlin metadata */
public final class DogPreviewFullscreenFragment extends Fragment implements v {

    /* renamed from: a, reason: from kotlin metadata */
    private qc binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class c<T> implements y<T> {

        final /* synthetic */ x a;
        public final void onChanged(T t) {
            z = t instanceof LoadResult_Success;
            if (t instanceof oadResult_Success) {
                this.a.F1().v((DogProfile)t.component1().getId());
            }
        }

        public c() {
            this.a = xVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class d<T> implements y<T> {

        final /* synthetic */ x a;
        public final void onChanged(T t) {
            if (!this.a.F1().isUserSignedIn()) {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    int i = 0;
                    app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
                    int i2 = 5;
                    Object obj = null;
                    str = "dog_edit";
                    app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity, i, str, zendeskConfigurationInfo, i2, obj);
                }
            }
        }

        public d() {
            this.a = xVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class e<T> implements y<T> {

        final /* synthetic */ x a;
        public final void onChanged(T t) {
            Object obj;
            str = "it";
            n.e(t, str);
            if (t.booleanValue()) {
                this.a.F1().x();
                String str2 = null;
                t = this.a.getActivity() instanceof Navigator ? (Navigator)this.a.getActivity() : str2;
                if (this.a != null) {
                    int i = 1;
                    Navigator.y0(obj, str2, 11100, i, str2);
                }
            }
        }

        public e() {
            this.a = xVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class f<T> implements y<T> {

        final /* synthetic */ x a;
        public final void onChanged(T t) {
            androidx.fragment.app.e activity = this.a.getActivity();
            if (activity != null) {
                android.content.Context requireContext = this.a.requireContext();
                str = "requireContext()";
                n.e(requireContext, str);
                app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity, BindingAdapters.a.i(t, requireContext));
            }
        }

        public f() {
            this.a = xVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ ProfilePreview $profilePreview;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            x.this.getSharedViewModel().e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }

        a(ProfilePreview profilePreview) {
            this.$profilePreview = profilePreview;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ ProfilePreview $profilePreview;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            x.this.getSharedViewModel().e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }

        b(ProfilePreview profilePreview) {
            this.$profilePreview = profilePreview;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public g(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends p implements kotlin.d0.c.a<h0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogPreviewViewModel.class), this.$parameters);
        }

        public h(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements kotlin.d0.c.a<m.a.c.i.a> {

        public static final x.i a = new x$i();
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { Boolean.TRUE });
        }


        i() {
            super(0);
        }
    }
    public x() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.profile.dogprofile.x.h(this, aVar, app.dogo.com.dogo_android.profile.dogprofile.x.i.a));
        this.c = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.profile.dogprofile.x.g(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ l callDogDeleteAlert(x profilePreview) {
        return profilePreview.getSharedViewModel();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ h0 onAddDogClick(x profilePreview) {
        return profilePreview.F1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final void onAddNewDogClick(ProfilePreview profilePreview) {
        if (profilePreview.isUserDogsCreator()) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.showPermissionExplanationDialog(activity, new app.dogo.com.dogo_android.profile.dogprofile.x.a(this, profilePreview));
            }
        } else {
            activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.y0(activity, new app.dogo.com.dogo_android.profile.dogprofile.x.b(this, profilePreview));
            }
        }
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final y onAvatarClick() {
        return (DogPreviewFullscreenScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final h0 F1() {
        return (DogPreviewViewModel)this.b.getValue();
    }

    /* renamed from: H1, reason: from kotlin metadata */
    private final void onBirthdayClick(ProfilePreview dogProfile) {
        int i3 = 0;
        F1().z();
        if (dogProfile.getUserPremium() != null) {
            dogProfile = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
            if (i3 != 0) {
                int i = 11101;
                i3.w0(F1().r(), i);
            }
        } else {
            boolean z = false;
            ProfilePreview profilePreview = null;
            int i2 = 12;
            Object obj = null;
            str = "dog_profile";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), str, onAvatarClick().getTag(), z, profilePreview, i2, obj));
        }
    }

    private static final void I1(x xVar, View view) {
        n.f(xVar, "this$0");
        final androidx.fragment.app.e activity = xVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* renamed from: J1, reason: from kotlin metadata */
    private final void onBreedClick(ProfilePreview dogProfile) {
        boolean userDogsCreator;
        ProfilePreview dogProfile3;
        app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation = null;
        int i = 4;
        Object obj = null;
        Intent intent = null;
        if (dogProfile.isUserDogsCreator() && dogProfile.getUserPremium() == null) {
            userDogsCreator = true;
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), getSharedViewModel().G("dog_profile", onAvatarClick().getTag(), userDogsCreator, dogProfile));
        }
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: D0, reason: from kotlin metadata */
    public void onDeleteDogClick(DogProfile profilePreview) {
        n.f(profilePreview, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewNameScreen(profilePreview));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: I0, reason: from kotlin metadata */
    public void onDogOwnerClick(DogProfile profilePreview) {
        n.f(profilePreview, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewBreedScreen(profilePreview));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: J, reason: from kotlin metadata */
    public void onGenderClick(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewBirthdayScreen(dogProfile));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: Z0, reason: from kotlin metadata */
    public void onNameClick(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewGenderScreen(dogProfile));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: a1, reason: from kotlin metadata */
    public void onParticipateInWelcomeChallengeClick(ProfilePreview dogProfile) {
        n.f(dogProfile, "profilePreview");
        F1().isUserNameSet();
        onAddNewDogClick(dogProfile);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: c0, reason: from kotlin metadata */
    public void showDogOwners(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        onBirthdayClick(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void n(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        onBreedClick(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ProfilePreview profilePreview = null;
        super.onActivityResult(requestCode, resultCode, data);
        final int i2 = -1;
        int i = 203;
        if (requestCode == 203) {
            if (resultCode == i2) {
                android.net.Uri uri = d.b(data).g();
                str2 = "getActivityResult(data).uri";
                n.e(uri, str2);
                F1().w(uri);
            } else {
                if (resultCode == 204) {
                    str2 = "Something went wrong with cropping";
                    a.e(d.b(data).c(), str2, new Object[0]);
                }
            }
        } else {
            i = 134679;
            if (requestCode == 134679 && resultCode == i2 && data == null) {
                int i3 = 0;
                if (profilePreview != null) {
                    onBreedClick(profilePreview);
                } else {
                    str = "Dog parent open flow failed. Missing profile data from login screen";
                    a.d(new Exception(str));
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        qc qcVar = qc.T(inflater, container, false);
        n.e(qcVar, "inflate(inflater, container, false)");
        this.binding = qcVar;
        int i = 0;
        String str4 = "binding";
        if (qcVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            qcVar.W(F1());
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
                    this.binding.V(this);
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
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.Q.setOnClickListener(new app.dogo.com.dogo_android.profile.dogprofile.i(this));
            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(viewLifecycleOwner2, str2);
            getSharedViewModel().E().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.profile.dogprofile.x.c(this));
            androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner3, str2);
            F1().s().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.profile.dogprofile.x.d(this));
            androidx.lifecycle.q viewLifecycleOwner4 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner4, str2);
            getSharedViewModel().F().observe(viewLifecycleOwner4, new app.dogo.com.dogo_android.profile.dogprofile.x.e(this));
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, str2);
            F1().u().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.profile.dogprofile.x.f(this));
            if (onAvatarClick().component1()) {
                if (onAvatarClick().getProfilePreview() != null) {
                    onAvatarClick().equals(false);
                    ProfilePreview profilePreview2 = onAvatarClick().getProfilePreview();
                    n.d(profilePreview2);
                    onBreedClick(profilePreview2);
                }
            }
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(DogProfile dogProfile) {
        int i;
        android.net.Uri uri = null;
        n.f(dogProfile, "dogProfile");
        final String id = dogProfile.getId();
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (i != 0) {
            android.content.Context context = getContext();
            if (context != null) {
                uri = app.dogo.com.dogo_android.util.extensionfunction.i1.d(context, id, "avatar.jpg");
            }
            i.i0(SpecialChallenges.WELCOME_CHALLENGE.getId(), id, uri);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void u() {
        androidx.fragment.app.e activity = null;
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            str = "dog_select";
            str2 = "dog_profile";
            activity.l0(str, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void z() {
        androidx.fragment.app.e activity = null;
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.C0();
        }
    }


    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(x view, View savedInstanceState) {
        DogPreviewFullscreenFragment.I1(view, savedInstanceState);
    }
}
