package app.dogo.com.dogo_android.dogcreation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.c;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.q;
import app.dogo.com.dogo_android.util.q.b;
import app.dogo.com.dogo_android.util.t.a;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.k0.l;
import kotlin.m;

/* compiled from: DogCreationActivity.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u000c\u0018\u0000 B2\u00020\u0001:\u0001BB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\"\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0008\u0010+\u001a\u0004\u0018\u00010\u0006H\u0002J\u0008\u0010,\u001a\u00020%H\u0016J\"\u0010-\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0008\u0010+\u001a\u0004\u0018\u00010\u0006H\u0014J\u0008\u0010.\u001a\u00020%H\u0016J\u0012\u0010/\u001a\u00020%2\u0008\u00100\u001a\u0004\u0018\u000101H\u0014J-\u00102\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00192\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u000105042\u0006\u00106\u001a\u000207H\u0016¢\u0006\u0002\u00108J\u0008\u00109\u001a\u00020%H\u0014J\u0008\u0010:\u001a\u00020%H\u0014J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u000201H\u0014J\u0006\u0010=\u001a\u00020%J\u0006\u0010>\u001a\u00020%J\u0006\u0010?\u001a\u00020%J\u0008\u0010@\u001a\u00020%H\u0002J\u0006\u0010A\u001a\u00020%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b\"\u0004\u0008\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u000b\"\u0004\u0008\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008#\u0010\u0014\u001a\u0004\u0008!\u0010\"¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityDogCreationBinding;", "dataToPass", "Landroid/content/Intent;", "imageCropper", "Lapp/dogo/com/dogo_android/util/ImageCropper;", "isBackStackEmptyOr1Item", "", "()Z", "isFragmentsResumed", "setFragmentsResumed", "(Z)V", "loginViewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getLoginViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "loginViewModel$delegate", "Lkotlin/Lazy;", "newDataToPass", "getNewDataToPass", "setNewDataToPass", "requestCodeToPass", "", "resultCodeToPass", "screenKey", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationScreenKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationScreenKey;", "sessionViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSessionViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sessionViewModel$delegate", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callTopFragmentOnActivityResults", "requestCode", "resultCode", "data", "finish", "onActivityResult", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeFragments", "onSaveInstanceState", "outState", "setCancelAndFinish", "setSuccessResultsAndFinish", "setWelcomeParticipatingAndFinish", "startImageCropper", "startOvalImageCropperWithNoSizeRestrictions", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DogCreationActivity extends androidx.appcompat.app.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final DogCreationActivity.a INSTANCE = new DogCreationActivity$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private final q binding = new q();
    /* renamed from: a, reason: from kotlin metadata */
    private c dataToPass;
    /* renamed from: b, reason: from kotlin metadata */
    private final h imageCropper;
    private final h c;
    /* renamed from: v, reason: from kotlin metadata */
    private boolean isFragmentsResumed;
    private boolean w;
    private int x;
    /* renamed from: y, reason: from kotlin metadata */
    private int requestCodeToPass;
    /* renamed from: z, reason: from kotlin metadata */
    private Intent resultCodeToPass;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationActivity$Companion;", "", "()V", "CREATED_DOG_ID", "", "STATE_SAVE_DOG_ID", "WELCOME_CHALLENGE_AVATAR_URI", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/dogcreation/DogCreationActivity$onCreate$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends androidx.activity.d {

        final /* synthetic */ DogCreationActivity c;
        c() {
            this.c = dogCreationActivity;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(this.c);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            String stringExtra;
            Object[] arr = new Object[2];
            if (DogCreationActivity.this.getIntent().getStringExtra("view_source") == null) {
                stringExtra = "";
            }
            return org.koin.core.parameter.b.b(new Object[] { stringExtra, 0 });
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { DogCreationActivity.this.l().describeContents(), Boolean.valueOf(DogCreationActivity.this.l().d()) });
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogCreationSharedViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends p implements kotlin.d0.c.a<b0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final b0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(LoginViewModel.class), this.$parameters);
        }

        public f(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public DogCreationActivity() {
        super();
        final m sYNCHRONIZED2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final m.a.c.j.a aVar = null;
        this.imageCropper = j.a(sYNCHRONIZED2, new DogCreationActivity.e(this, aVar, new DogCreationActivity.d(this)));
        this.c = j.a(sYNCHRONIZED2, new DogCreationActivity.f(this, aVar, new DogCreationActivity.b(this)));
        q imageCropper = new ImageCropper();
    }

    /* renamed from: B, reason: from kotlin metadata */
    private final void finish() {
        try {
            this.binding.v(this);
        } catch (Exception e) {
            a.d(e);
            Throwable e2 = 2131886123;
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(this, e2);
        }
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ f attachBaseContext(DogCreationActivity newBase) {
        return newBase.l();
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final void callTopFragmentOnActivityResults(int requestCode, int resultCode, Intent data) {
        Object prev = null;
        int i;
        List list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        ListIterator it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            i = !(Fragment)prev instanceof t;
            if (!it.previous() instanceof t) {
                break;
            }
        }
        int i2 = 0;
        if (prev != null) {
            prev.onActivityResult(requestCode, resultCode, data);
        }
    }

    private final b0 k() {
        return (LoginViewModel)this.c.getValue();
    }

    private final f l() {
        return (DogCreationScreenKey)app.dogo.com.dogo_android.util.extensionfunction.g1.l(this);
    }

    private final g m() {
        return (DogCreationSharedViewModel)this.imageCropper.getValue();
    }

    private final boolean n() {
        boolean z = true;
        if (getSupportFragmentManager().p0() > 1) {
            int i3 = 0;
        }
        return z;
    }

    private static final void t(DogCreationActivity dogCreationActivity, app.dogo.com.dogo_android.login_v2.t tVar) {
        n.f(dogCreationActivity, "this$0");
        n.e(tVar, "it");
        app.dogo.com.dogo_android.util.extensionfunction.g1.h0(dogCreationActivity, tVar);
    }

    private static final void u(DogCreationActivity dogCreationActivity, Boolean boolean) {
        n.f(dogCreationActivity, "this$0");
        n.e(boolean, "it");
        if (boolean.booleanValue()) {
            dogCreationActivity.onBackPressed();
        }
    }

    private static final void v(DogCreationActivity dogCreationActivity, Boolean boolean) {
        String str;
        Object boolean22;
        app.dogo.com.dogo_android.y.j jVar;
        n.f(dogCreationActivity, "this$0");
        if (dogCreationActivity.m().q()) {
            jVar = dogCreationActivity.m().m();
            str = "";
            String r2 = jVar == null ? "" : str;
            boolean z = false;
            int i = 4;
            Object obj = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.f(dogCreationActivity, (jVar == null ? "" : str), new DogCreationWelcomeScreen(), false, 4, null);
        } else {
            dogCreationActivity.z();
        }
    }

    private static final void w(DogCreationActivity dogCreationActivity, Boolean boolean) {
        n.f(dogCreationActivity, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.g0(dogCreationActivity, 2131886836);
    }

    /* renamed from: x, reason: from kotlin metadata */
    private static final void onRequestPermissionsResult(DogCreationActivity requestCode, InAppMessage permissions, FirebaseInAppMessagingDisplayCallbacks grantResults) {
        n.f(requestCode, "this$0");
        n.f(permissions, "inAppMessage");
        n.f(grantResults, "firebaseInAppMessagingDisplayCallbacks");
        app.dogo.com.dogo_android.util.extensionfunction.g1.r(requestCode, permissions, grantResults);
    }

    @Override // androidx.appcompat.app.d
    public final void A() {
        String str = null;
        String str2;
        final Intent intent = new Intent();
        DogProfile dogProfile2 = m().l();
        str2 = "";
        if (dogProfile2 != null) {
            str2 = dogProfile2.getId();
            if (str2 != null) {
            }
        }
        intent.putExtra("welcomeParticipationUri", m().i(str2));
        DogProfile dogProfile = m().l();
        if (dogProfile == null) {
            int i = 0;
        } else {
            str = dogProfile.getId();
        }
        intent.putExtra("newDogId", str);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.appcompat.app.d
    public final void C() {
        if (!this.binding.k()) {
            int i = 0;
            this.binding.p(i, i);
            this.binding.startAnAppropriateImageSourceSelection(ImageCropper_CropperShape.OVAL);
            str = "Image cropper started";
            a.f(str, new Object[i]);
            finish();
        }
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a iNSTANCE2 = MyContextWrapper.INSTANCE;
        final Context resources2 = iNSTANCE2.updateResources(context, LocaleService.getLanguageFromLocaleString(App.INSTANCE.l().W()));
        super.attachBaseContext(resources2);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        iNSTANCE2.updateResourcesUpTo25Api(resources, resources2);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public void finish() {
        if (l().b()) {
            Intent intent2 = new Intent(this, MainScreenActivity.class);
            intent2.putExtras(getIntent());
            startActivity(intent2);
        }
        super.finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        k().I(i, i2, intent);
        try {
            this.binding.onActivityResultsForImageSelection(i, i2, intent, this);
        } catch (Exception e) {
            a.d(e);
        }
        this.binding.onActivityResultsForImageCropper(i, i2, intent);
        if (this.w) {
            callTopFragmentOnActivityResults(i, i2, intent);
        } else {
            this.x = i;
            this.requestCodeToPass = i2;
            i = intent == null ? 0 : new Intent(intent);
            this.resultCodeToPass = (intent == null ? 0 : new Intent(intent));
            boolean z = true;
            this.isFragmentsResumed = (intent == null ? 0 : new Intent(intent));
        }
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        if (!n()) {
            super.onBackPressed();
        } else {
            if (m().n()) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(this, 2131886470);
            } else {
                y();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle savedInstanceState) throws app.dogo.com.dogo_android.dogcreation.h.f {
        app.dogo.com.dogo_android.dogcreation.DogCreationActivity.c dogCreationActivity_onCreate_1;
        int i = 0;
        super.onCreate(savedInstanceState);
        androidx.databinding.ViewDataBinding viewDataBinding = f.g(this, 2131558429);
        n.e(viewDataBinding, "setContentView(this, R.layout.activity_dog_creation)");
        this.dataToPass = viewDataBinding;
        if (viewDataBinding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            viewDataBinding.T(m());
            getOnBackPressedDispatcher().b(this, new DogCreationActivity_onCreate_1(this));
            if (savedInstanceState == null) {
                String str2 = l().c();
                if (str2 == null || l.z(str2)) {
                    i = 1;
                }
                if (i != 0) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new DogCreationNameScreen());
                } else {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new DogCreationAvatarScreen());
                }
            } else {
                Bundle bundle = savedInstanceState.getBundle("user_cache_bundle");
                if (bundle != null) {
                    m().h(bundle);
                }
                str = "dog_creation_dog_id";
                String string = savedInstanceState.getString(str);
                if (string != null) {
                    m().s(string);
                }
            }
            k().r().observe(this, new b(this));
            k().getShouldGoBack().observe(this, new d(this));
            k().n().observe(this, new e(this));
            k().m().observe(this, new c(this));
            return;
        }
    }

    @Override // androidx.appcompat.app.d
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        n.f(strArr, "permissions");
        n.f(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            this.binding.onRequestPermissionsResult(i, strArr, iArr, this);
        } catch (Exception e) {
            a.d(e);
            e = 2131886123;
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(this, e);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(new a(this));
    }

    @Override // androidx.appcompat.app.d
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (this.isFragmentsResumed) {
            callTopFragmentOnActivityResults(this.x, this.requestCodeToPass, this.resultCodeToPass);
            boolean isFragmentsResumed2 = false;
            this.isFragmentsResumed = isFragmentsResumed2;
        }
        this.w = true;
    }

    @Override // androidx.appcompat.app.d
    protected void onSaveInstanceState(Bundle outState) {
        String str = null;
        n.f(outState, "outState");
        outState.putBundle("user_cache_bundle", m().j());
        DogProfile dogProfile = m().l();
        if (dogProfile == null) {
            int i = 0;
        } else {
            str = dogProfile.getId();
        }
        outState.putString("dog_creation_dog_id", str);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.appcompat.app.d
    public final void y() {
        String str = null;
        final Intent intent = new Intent();
        DogProfile dogProfile = m().l();
        if (dogProfile == null) {
            int i2 = 0;
        } else {
            str = dogProfile.getId();
        }
        intent.putExtra("newDogId", str);
        setResult(0, intent);
        finish();
    }

    @Override // androidx.appcompat.app.d
    public final void z() {
        String str = null;
        final Intent intent = new Intent();
        DogProfile dogProfile = m().l();
        if (dogProfile == null) {
            int i2 = 0;
        } else {
            str = dogProfile.getId();
        }
        intent.putExtra("newDogId", str);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: o, reason: from kotlin metadata */
    public static /* synthetic */ void onActivityResult(DogCreationActivity requestCode, InAppMessage resultCode, FirebaseInAppMessagingDisplayCallbacks data) {
        DogCreationActivity.onRequestPermissionsResult(requestCode, resultCode, data);
    }

    public static /* synthetic */ void p(DogCreationActivity dogCreationActivity, app.dogo.com.dogo_android.login_v2.t tVar) {
        DogCreationActivity.t(dogCreationActivity, tVar);
    }

    public static /* synthetic */ void q(DogCreationActivity dogCreationActivity, Boolean boolean) {
        DogCreationActivity.w(dogCreationActivity, boolean);
    }

    public static /* synthetic */ void r(DogCreationActivity dogCreationActivity, Boolean boolean) {
        DogCreationActivity.u(dogCreationActivity, boolean);
    }

    public static /* synthetic */ void s(DogCreationActivity dogCreationActivity, Boolean boolean) {
        DogCreationActivity.v(dogCreationActivity, boolean);
    }
}
