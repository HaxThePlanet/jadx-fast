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
import app.dogo.com.dogo_android.h.oc;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.q.r.c;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;
import kotlin.w;

/* compiled from: DogPreviewFragment.kt */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\u0008\u0010\u001e\u001a\u00020\u0016H\u0002J\"\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010'\u001a\u00020\u0016H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u0001012\u0008\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u00106\u001a\u00020\u0016H\u0016J\u0010\u00107\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00109\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u0010:\u001a\u00020\u0016H\u0016J\u001a\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020-2\u0008\u00102\u001a\u0004\u0018\u000103H\u0016J\u0008\u0010=\u001a\u00020\u0016H\u0002J\u0018\u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogPreviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "viewModel$delegate", "callDogDeleteAlert", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "callSubscriptionDialog", "handleDestinationScreens", "destination", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "profileData", "loadNextAppScreenAfterResultIfRequested", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAddDogClick", "onAddNewDogClick", "onAvatarClick", "onBirthdayClick", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "onBreedClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteDogClick", "onDogOwnerClick", "onDogSelectClick", "onGenderClick", "onNameClick", "onParticipateInWelcomeChallengeClick", "onResume", "onViewCreated", "view", "removeDestinationFromKey", "showDogOwners", "showSubscriptionDialog", "", "showDogOwnersDeeplinkFlow", "showDogOwnersNormalFlow", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public final class DogPreviewFragment extends Fragment implements v {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final w.a INSTANCE = new w$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private oc binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFragment$Companion;", "", "()V", "DOG_PARENTS_LOGIN_REQUEST", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class e<T> implements androidx.lifecycle.y<T> {

        final /* synthetic */ w a;
        public final void onChanged(T t) {
            z = t instanceof LoadResult_Success;
            if (t instanceof oadResult_Success) {
                this.a.H1().v((DogProfile)t.component1().getId());
            }
        }

        public e() {
            this.a = wVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class f<T> implements androidx.lifecycle.y<T> {

        final /* synthetic */ w a;
        public final void onChanged(T t) {
            if (!this.a.H1().isUserSignedIn()) {
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

        public f() {
            this.a = wVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class g<T> implements androidx.lifecycle.y<T> {

        final /* synthetic */ w a;
        public final void onChanged(T t) {
            Object obj;
            str = "it";
            n.e(t, str);
            if (t.booleanValue()) {
                this.a.H1().x();
                String str2 = null;
                t = this.a.getActivity() instanceof Navigator ? (Navigator)this.a.getActivity() : str2;
                if (this.a != null) {
                    int i = 1;
                    Navigator.y0(obj, str2, 11100, i, str2);
                }
            }
        }

        public g() {
            this.a = wVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class h<T> implements androidx.lifecycle.y<T> {

        final /* synthetic */ w a;
        public final void onChanged(T t) {
            androidx.fragment.app.e activity = this.a.getActivity();
            if (activity != null) {
                android.content.Context requireContext = this.a.requireContext();
                str = "requireContext()";
                n.e(requireContext, str);
                app.dogo.com.dogo_android.util.extensionfunction.g1.i0(activity, BindingAdapters.a.i(t, requireContext));
            }
        }

        public h() {
            this.a = wVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ ProfilePreview $profilePreview;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            w.this.getSharedViewModel().e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }

        b(ProfilePreview profilePreview) {
            this.$profilePreview = profilePreview;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ ProfilePreview $profilePreview;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            w.this.getSharedViewModel().e0(this.$profilePreview.isUserDogsCreator(), this.$profilePreview.getDogProfile().getId(), this.$profilePreview.isLastDog());
        }

        c(ProfilePreview profilePreview) {
            this.$profilePreview = profilePreview;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.l<app.dogo.com.dogo_android.util.e0.y<? extends ProfilePreview>, Boolean> {

        public static final w.d a = new w$d();
        @Override // kotlin.d0.d.p
        public final boolean a(app.dogo.com.dogo_android.util.e0.y<ProfilePreview> yVar) {
            return yVar instanceof LoadResult_Success;
        }


        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class i extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public i(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class j extends p implements kotlin.d0.c.a<h0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogPreviewViewModel.class), this.$parameters);
        }

        public j(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends p implements kotlin.d0.c.a<m.a.c.i.a> {

        public static final w.k a = new w$k();
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { Boolean.FALSE });
        }


        k() {
            super(0);
        }
    }

    public w() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.profile.dogprofile.w.j(this, aVar, app.dogo.com.dogo_android.profile.dogprofile.w.k.a));
        this.c = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.profile.dogprofile.w.i(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.view.dailytraining.l callDogDeleteAlert(w profilePreview) {
        return profilePreview.getSharedViewModel();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ h0 callSubscriptionDialog(w profilePreview) {
        return profilePreview.H1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final void onAddDogClick(ProfilePreview profilePreview) {
        if (profilePreview.isUserDogsCreator()) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.showPermissionExplanationDialog(activity, new app.dogo.com.dogo_android.profile.dogprofile.w.b(this, profilePreview));
            }
        } else {
            activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.y0(activity, new app.dogo.com.dogo_android.profile.dogprofile.w.c(this, profilePreview));
            }
        }
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final void onAddNewDogClick(ProfilePreview profilePreview) throws android.content.res.Resources.NotFoundException {
        int i3 = 2131887317;
        new b(requireContext()).H(getResources().getString(i3)).x(getResources().getString(2131886205)).E(getResources().getString(i3), new app.dogo.com.dogo_android.profile.dogprofile.h(this, profilePreview)).y(2131886677, null).o();
    }

    private static final void F1(w wVar, ProfilePreview profilePreview, DialogInterface dialogInterface, int i) {
        n.f(wVar, "this$0");
        n.f(profilePreview, "$profilePreview");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(wVar.getActivity(), wVar.getSharedViewModel().G("dog_profile", wVar.loadNextAppScreenAfterResultIfRequested().getTag(), true, profilePreview));
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final f0 loadNextAppScreenAfterResultIfRequested() {
        return (DogPreviewScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final h0 H1() {
        return (DogPreviewViewModel)this.b.getValue();
    }

    /* renamed from: I1, reason: from kotlin metadata */
    private final void handleDestinationScreens(app.dogo.com.dogo_android.y.j destination, ProfilePreview profileData) {
        if (destination instanceof DogParentsScreen) {
            onBreedClick(profileData);
        }
    }

    private final void L1() {
        app.dogo.com.dogo_android.y.j jVar = loadNextAppScreenAfterResultIfRequested().c();
        if (jVar != null) {
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            app.dogo.com.dogo_android.util.extensionfunction.j1.u0(H1().t(), viewLifecycleOwner, app.dogo.com.dogo_android.profile.dogprofile.w.d.a, new app.dogo.com.dogo_android.profile.dogprofile.g(this, jVar));
            O1();
        }
    }

    /* renamed from: M1, reason: from kotlin metadata */
    private static final void onCreateView(w inflater, app.dogo.com.dogo_android.y.j container, app.dogo.com.dogo_android.util.e0.y savedInstanceState) {
        n.f(inflater, "this$0");
        if (savedInstanceState instanceof LoadResult_Success) {
            inflater.handleDestinationScreens(container, (ProfilePreview)savedInstanceState.component1());
        }
    }

    /* renamed from: N1, reason: from kotlin metadata */
    private final void onBirthdayClick(ProfilePreview dogProfile) {
        int i3 = 0;
        H1().z();
        if (dogProfile.getUserPremium() != null) {
            dogProfile = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
            if (i3 != 0) {
                int i = 11101;
                i3.w0(H1().r(), i);
            }
        } else {
            boolean z = false;
            ProfilePreview profilePreview = null;
            int i2 = 12;
            Object obj = null;
            str = "dog_profile";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), str, loadNextAppScreenAfterResultIfRequested().getTag(), z, profilePreview, i2, obj));
        }
    }

    private final void O1() {
        final Bundle arguments = getArguments();
        if (arguments != null) {
            ProfilePreview profilePreview = null;
            app.dogo.com.dogo_android.y.j jVar = null;
            int i = 3;
            Object obj = null;
            str = "SCREEN_KEY";
            arguments.putParcelable(str, DogPreviewScreen.b(loadNextAppScreenAfterResultIfRequested(), false, profilePreview, jVar, i, obj));
        }
    }

    /* renamed from: P1, reason: from kotlin metadata */
    private final void onViewCreated(ProfilePreview view, boolean savedInstanceState) {
        DogProfile dogProfile;
        boolean userDogsCreator;
        app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation = null;
        int i = 4;
        Object obj = null;
        Intent intent = null;
        if (view.isUserDogsCreator() && !view.getUserPremium() && savedInstanceState) {
            onAddNewDogClick(view);
        }
    }

    /* renamed from: Q1, reason: from kotlin metadata */
    private final void onBreedClick(ProfilePreview dogProfile) {
        onViewCreated(dogProfile, true);
    }

    /* renamed from: R1, reason: from kotlin metadata */
    private final void onDeleteDogClick(ProfilePreview profilePreview) {
        onViewCreated(profilePreview, false);
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: D0, reason: from kotlin metadata */
    public void onDogOwnerClick(DogProfile profilePreview) {
        n.f(profilePreview, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewNameScreen(profilePreview));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: I0, reason: from kotlin metadata */
    public void onGenderClick(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewBreedScreen(dogProfile));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: J, reason: from kotlin metadata */
    public void onNameClick(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewBirthdayScreen(dogProfile));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: Z0, reason: from kotlin metadata */
    public void onParticipateInWelcomeChallengeClick(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogPreviewGenderScreen(dogProfile));
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: a1, reason: from kotlin metadata */
    public void showDogOwnersDeeplinkFlow(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        H1().isUserNameSet();
        onAddDogClick(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: c0, reason: from kotlin metadata */
    public void showDogOwnersNormalFlow(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        onBirthdayClick(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void n(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        onDeleteDogClick(profilePreview);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        ProfilePreview profilePreview = null;
        super.onActivityResult(i, i2, intent);
        final int i4 = -1;
        int i3 = 203;
        if (i == 203) {
            if (i2 == i4) {
                android.net.Uri uri = d.b(intent).g();
                str2 = "getActivityResult(data).uri";
                n.e(uri, str2);
                H1().w(uri);
            } else {
                if (i2 == 204) {
                    str2 = "Something went wrong with cropping";
                    a.e(d.b(intent).c(), str2, new Object[0]);
                }
            }
        } else {
            i3 = 134679;
            if (i == 134679 && i2 == i4 && intent == null) {
                int i5 = 0;
                if (profilePreview != null) {
                    onDeleteDogClick(profilePreview);
                } else {
                    str = "Dog parent open flow failed. Missing profile data from login screen";
                    a.d(new Exception(str));
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        oc ocVar = oc.T(layoutInflater, viewGroup, false);
        n.e(ocVar, "inflate(inflater, container, false)");
        this.binding = ocVar;
        int i = 0;
        String str4 = "binding";
        if (ocVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ocVar.W(H1());
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
            activity.p0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner2, str2);
        getSharedViewModel().E().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.profile.dogprofile.w.e(this));
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str2);
        H1().s().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.profile.dogprofile.w.f(this));
        androidx.lifecycle.q viewLifecycleOwner4 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner4, str2);
        getSharedViewModel().F().observe(viewLifecycleOwner4, new app.dogo.com.dogo_android.profile.dogprofile.w.g(this));
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        n.e(viewLifecycleOwner, str2);
        H1().u().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.profile.dogprofile.w.h(this));
        if (loadNextAppScreenAfterResultIfRequested().d()) {
            if (loadNextAppScreenAfterResultIfRequested().getProfilePreview() != null) {
                loadNextAppScreenAfterResultIfRequested().e(false);
                ProfilePreview profilePreview2 = loadNextAppScreenAfterResultIfRequested().getProfilePreview();
                n.d(profilePreview2);
                onDeleteDogClick(profilePreview2);
            }
        }
        L1();
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

    /* renamed from: J1, reason: from kotlin metadata */
    public static /* synthetic */ void onActivityResult(w requestCode, app.dogo.com.dogo_android.y.j resultCode, app.dogo.com.dogo_android.util.e0.y data) {
        DogPreviewFragment.onCreateView(requestCode, resultCode, data);
    }

    public static /* synthetic */ void K1(w wVar, ProfilePreview profilePreview, DialogInterface dialogInterface, int i) {
        DogPreviewFragment.F1(wVar, profilePreview, dialogInterface, i);
    }
}
