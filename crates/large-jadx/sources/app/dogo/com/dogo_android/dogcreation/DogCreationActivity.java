package app.dogo.com.dogo_android.dogcreation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.appcompat.app.d;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.h.f;
import app.dogo.com.dogo_android.dogcreation.m.d;
import app.dogo.com.dogo_android.dogcreation.o.d;
import app.dogo.com.dogo_android.h.c;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.t;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.q;
import app.dogo.com.dogo_android.util.q.b;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.y.j;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;
import f.c.a.f.a.d.a;
import f.d.a.a;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u000c\u0018\u0000 B2\u00020\u0001:\u0001BB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\"\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0008\u0010+\u001a\u0004\u0018\u00010\u0006H\u0002J\u0008\u0010,\u001a\u00020%H\u0016J\"\u0010-\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0008\u0010+\u001a\u0004\u0018\u00010\u0006H\u0014J\u0008\u0010.\u001a\u00020%H\u0016J\u0012\u0010/\u001a\u00020%2\u0008\u00100\u001a\u0004\u0018\u000101H\u0014J-\u00102\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00192\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u000105042\u0006\u00106\u001a\u000207H\u0016¢\u0006\u0002\u00108J\u0008\u00109\u001a\u00020%H\u0014J\u0008\u0010:\u001a\u00020%H\u0014J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u000201H\u0014J\u0006\u0010=\u001a\u00020%J\u0006\u0010>\u001a\u00020%J\u0006\u0010?\u001a\u00020%J\u0008\u0010@\u001a\u00020%H\u0002J\u0006\u0010A\u001a\u00020%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b\"\u0004\u0008\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u000b\"\u0004\u0008\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008#\u0010\u0014\u001a\u0004\u0008!\u0010\"¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityDogCreationBinding;", "dataToPass", "Landroid/content/Intent;", "imageCropper", "Lapp/dogo/com/dogo_android/util/ImageCropper;", "isBackStackEmptyOr1Item", "", "()Z", "isFragmentsResumed", "setFragmentsResumed", "(Z)V", "loginViewModel", "Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "getLoginViewModel", "()Lapp/dogo/com/dogo_android/login_v2/LoginViewModel;", "loginViewModel$delegate", "Lkotlin/Lazy;", "newDataToPass", "getNewDataToPass", "setNewDataToPass", "requestCodeToPass", "", "resultCodeToPass", "screenKey", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationScreenKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationScreenKey;", "sessionViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSessionViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sessionViewModel$delegate", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callTopFragmentOnActivityResults", "requestCode", "resultCode", "data", "finish", "onActivityResult", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeFragments", "onSaveInstanceState", "outState", "setCancelAndFinish", "setSuccessResultsAndFinish", "setWelcomeParticipatingAndFinish", "startImageCropper", "startOvalImageCropperWithNoSizeRestrictions", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogCreationActivity extends d {

    public static final app.dogo.com.dogo_android.dogcreation.DogCreationActivity.a Companion;
    private final q A;
    private c a;
    private final h b;
    private final h c;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private Intent z;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationActivity$Companion;", "", "()V", "CREATED_DOG_ID", "", "STATE_SAVE_DOG_ID", "WELCOME_CHALLENGE_AVATAR_URI", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/dogcreation/DogCreationActivity$onCreate$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends d {

        final app.dogo.com.dogo_android.dogcreation.DogCreationActivity c;
        c(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity) {
            this.c = dogCreationActivity;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            g1.O(this.c);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.dogcreation.DogCreationActivity this$0;
        b(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity) {
            this.this$0 = dogCreationActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            String stringExtra;
            Object[] arr = new Object[2];
            if (this.this$0.getIntent().getStringExtra("view_source") == null) {
                stringExtra = "";
            }
            return b.b(stringExtra, 0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.dogcreation.DogCreationActivity this$0;
        d(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity) {
            this.this$0 = dogCreationActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(DogCreationActivity.i(this.this$0).a(), Boolean.valueOf(DogCreationActivity.i(this.this$0).d()));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements a<app.dogo.com.dogo_android.dogcreation.g> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.dogcreation.g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends p implements a<b0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public f(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final b0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(b0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        DogCreationActivity.a aVar = new DogCreationActivity.a(0);
        DogCreationActivity.Companion = aVar;
    }

    public DogCreationActivity() {
        super();
        DogCreationActivity.d dVar = new DogCreationActivity.d(this);
        final m sYNCHRONIZED = m.SYNCHRONIZED;
        final int i = 0;
        DogCreationActivity.e eVar = new DogCreationActivity.e(this, i, dVar);
        this.b = j.a(sYNCHRONIZED, eVar);
        DogCreationActivity.b bVar = new DogCreationActivity.b(this);
        DogCreationActivity.f fVar = new DogCreationActivity.f(this, i, bVar);
        this.c = j.a(sYNCHRONIZED, fVar);
        q qVar = new q();
        this.A = qVar;
    }

    private final void B() {
        q qVar;
        try {
            this.A.v(this);
            a.d(th);
            Throwable th = 2131886123;
            g1.g0(this, th);
        }
    }

    public static final app.dogo.com.dogo_android.dogcreation.f i(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity) {
        return dogCreationActivity.l();
    }

    private final void j(int i, int i2, Intent intent3) {
        int previous;
        int i3;
        List list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
        }
        previous = 0;
        if ((Fragment)previous == 0) {
        } else {
            (Fragment)previous.onActivityResult(i, i2, intent3);
        }
    }

    private final b0 k() {
        return (b0)this.c.getValue();
    }

    private final app.dogo.com.dogo_android.dogcreation.f l() {
        return (f)g1.l(this);
    }

    private final app.dogo.com.dogo_android.dogcreation.g m() {
        return (g)this.b.getValue();
    }

    private final boolean n() {
        int i;
        if (getSupportFragmentManager().p0() <= 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public static void o(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        DogCreationActivity.x(dogCreationActivity, inAppMessage2, firebaseInAppMessagingDisplayCallbacks3);
    }

    public static void p(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, t t2) {
        DogCreationActivity.t(dogCreationActivity, t2);
    }

    public static void q(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, Boolean boolean2) {
        DogCreationActivity.w(dogCreationActivity, boolean2);
    }

    public static void r(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, Boolean boolean2) {
        DogCreationActivity.u(dogCreationActivity, boolean2);
    }

    public static void s(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, Boolean boolean2) {
        DogCreationActivity.v(dogCreationActivity, boolean2);
    }

    private static final void t(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, t t2) {
        n.f(dogCreationActivity, "this$0");
        n.e(t2, "it");
        g1.h0(dogCreationActivity, t2);
    }

    private static final void u(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, Boolean boolean2) {
        n.f(dogCreationActivity, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue()) {
            dogCreationActivity.onBackPressed();
        }
    }

    private static final void v(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, Boolean boolean2) {
        String str;
        Object obj;
        Object jVar;
        d dVar;
        int i3;
        int i2;
        int i;
        j obj8;
        n.f(dogCreationActivity, "this$0");
        if (dogCreationActivity.m().q()) {
            obj8 = dogCreationActivity.m().m();
            if (obj8 == null) {
                jVar = str;
            } else {
            }
            dVar = new d();
            g1.f(dogCreationActivity, jVar, dVar, false, 4, 0);
        } else {
            dogCreationActivity.z();
        }
    }

    private static final void w(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, Boolean boolean2) {
        n.f(dogCreationActivity, "this$0");
        g1.g0(dogCreationActivity, 2131886836);
    }

    private static final void x(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        n.f(dogCreationActivity, "this$0");
        n.f(inAppMessage2, "inAppMessage");
        n.f(firebaseInAppMessagingDisplayCallbacks3, "firebaseInAppMessagingDisplayCallbacks");
        g1.r(dogCreationActivity, inAppMessage2, firebaseInAppMessagingDisplayCallbacks3);
    }

    @Override // androidx.appcompat.app.d
    public final void A() {
        String i;
        Object dogProfile;
        String str;
        Intent intent = new Intent();
        dogProfile = m().l();
        str = "";
        if (dogProfile == null) {
        } else {
            dogProfile = dogProfile.getId();
            if (dogProfile == null) {
            } else {
                str = dogProfile;
            }
        }
        intent.putExtra("welcomeParticipationUri", m().i(str));
        DogProfile dogProfile2 = m().l();
        if (dogProfile2 == null) {
            i = 0;
        } else {
            i = dogProfile2.getId();
        }
        intent.putExtra("newDogId", i);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.appcompat.app.d
    public final void C() {
        boolean arr;
        String str;
        q.b oVAL;
        if (!this.A.k()) {
            int i = 0;
            this.A.p(i, i);
            this.A.o(q.b.OVAL);
            a.f("Image cropper started", new Object[i]);
            B();
        }
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a companion = t.Companion;
        final Context obj4 = companion.b(context, n2.b(App.Companion.l().W()));
        super.attachBaseContext(obj4);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        companion.c(resources, obj4);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public void finish() {
        boolean intent2;
        Intent intent;
        if (l().b()) {
            intent2 = new Intent(this, MainScreenActivity.class);
            intent2.putExtras(getIntent());
            startActivity(intent2);
        }
        super.finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent3) {
        q qVar;
        int obj2;
        super.onActivityResult(i, i2, intent3);
        k().I(i, i2, intent3);
        this.A.m(i, i2, intent3, this);
        this.A.l(i, i2, intent3);
        if (this.w) {
            j(i, i2, intent3);
        } else {
            this.x = i;
            this.y = i2;
            if (intent3 == null) {
                obj2 = 0;
            } else {
                obj2 = new Intent(intent3);
            }
            this.z = obj2;
            this.v = true;
        }
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        boolean z;
        if (n()) {
            if (m().n()) {
                g1.g0(this, 2131886470);
            } else {
                y();
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        Object onBackPressedDispatcher;
        Object cVar;
        Object obj3;
        super.onCreate(bundle);
        androidx.databinding.ViewDataBinding view = f.g(this, 2131558429);
        n.e(view, "setContentView(this, R.layout.activity_dog_creation)");
        this.a = (c)view;
        if (view == null) {
        } else {
            view.T(m());
            cVar = new DogCreationActivity.c(this);
            getOnBackPressedDispatcher().b(this, cVar);
            if (bundle == null) {
                obj3 = l().c();
                if (obj3 != null) {
                    if (l.z(obj3)) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
                if (obj3 != null) {
                    obj3 = new d();
                    g1.n(this, obj3);
                } else {
                    obj3 = new f();
                    g1.n(this, obj3);
                }
            } else {
                Bundle bundle2 = bundle.getBundle("user_cache_bundle");
                if (bundle2 != null) {
                    m().h(bundle2);
                }
                obj3 = bundle.getString("dog_creation_dog_id");
                if (obj3 != null) {
                    m().s(obj3);
                }
            }
            b bVar = new b(this);
            k().r().observe(this, bVar);
            d dVar = new d(this);
            k().getShouldGoBack().observe(this, dVar);
            e eVar = new e(this);
            k().n().observe(this, eVar);
            c cVar2 = new c(this);
            k().m().observe(this, cVar2);
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.appcompat.app.d
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
        int obj2;
        n.f(string2Arr2, "permissions");
        n.f(i3Arr3, "grantResults");
        super.onRequestPermissionsResult(i, string2Arr2, i3Arr3);
        this.A.n(i, string2Arr2, i3Arr3, this);
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        a aVar = new a(this);
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(aVar);
    }

    @Override // androidx.appcompat.app.d
    protected void onResumeFragments() {
        boolean z;
        int i;
        Intent intent;
        super.onResumeFragments();
        if (this.v) {
            j(this.x, this.y, this.z);
            this.v = false;
        }
        this.w = true;
    }

    @Override // androidx.appcompat.app.d
    protected void onSaveInstanceState(Bundle bundle) {
        int i;
        n.f(bundle, "outState");
        bundle.putBundle("user_cache_bundle", m().j());
        DogProfile dogProfile = m().l();
        if (dogProfile == null) {
            i = 0;
        } else {
            i = dogProfile.getId();
        }
        bundle.putString("dog_creation_dog_id", i);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.d
    public final void y() {
        int i;
        Intent intent = new Intent();
        DogProfile dogProfile = m().l();
        if (dogProfile == null) {
            i = 0;
        } else {
            i = dogProfile.getId();
        }
        intent.putExtra("newDogId", i);
        setResult(0, intent);
        finish();
    }

    @Override // androidx.appcompat.app.d
    public final void z() {
        int i;
        Intent intent = new Intent();
        DogProfile dogProfile = m().l();
        if (dogProfile == null) {
            i = 0;
        } else {
            i = dogProfile.getId();
        }
        intent.putExtra("newDogId", i);
        setResult(-1, intent);
        finish();
    }
}
