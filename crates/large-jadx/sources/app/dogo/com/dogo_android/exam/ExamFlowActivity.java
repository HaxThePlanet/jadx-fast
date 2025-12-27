package app.dogo.com.dogo_android.exam;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.f;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.h;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;

/* compiled from: ExamFlowActivity.kt */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0005\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0018\u001a\u00020\u000c2\u0012\u0010\u0019\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u001a\"\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0008\u0010 \u001a\u00020\u001dH\u0016J\u0008\u0010!\u001a\u00020\u001dH\u0016J\u0008\u0010\"\u001a\u00020\u001dH\u0016J\u0012\u0010#\u001a\u00020\u001d2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0014J+\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010+J\u0008\u0010,\u001a\u00020\u001dH\u0014J\u0008\u0010-\u001a\u00020\u001dH\u0002R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lapp/dogo/com/dogo_android/exam/ExamFlowCallback;", "()V", "allRequiredPermissions", "", "", "getAllRequiredPermissions", "()Ljava/util/List;", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityExamFlowBinding;", "isBackStackEmptyOr1Item", "", "()Z", "screenKey", "Lapp/dogo/com/dogo_android/exam/ExamFlowScreenKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/exam/ExamFlowScreenKey;", "sessionViewModel", "Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "getSessionViewModel", "()Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "sessionViewModel$delegate", "Lkotlin/Lazy;", "arePermissionsGranted", "permissions", "", "([Ljava/lang/String;)Z", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "cancelFlow", "completeFlow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "requestPermissions", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ExamFlowActivity extends androidx.appcompat.app.d implements d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ExamFlowActivity.a INSTANCE = new ExamFlowActivity$a(0);
    private app.dogo.com.dogo_android.h.e a;
    /* renamed from: b, reason: from kotlin metadata */
    private final h binding;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowActivity$Companion;", "", "()V", "PERMISSION_REQUEST_CODE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/exam/ExamFlowActivity$onCreate$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends androidx.activity.d {

        final /* synthetic */ ExamFlowActivity c;
        b() {
            this.c = examFlowActivity;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(this.c);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            ExamFlowActivity.this.d();
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            ExamFlowActivity.this.d();
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ List<String> $deniedPermissions;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            final boolean z = true;
            App.INSTANCE.l().saveDogAsReported(z);
            Object[] array = this.$deniedPermissions.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ExamFlowActivity.this.requestPermissions(array, z);
        }

        e(List<String> list) {
            this.$deniedPermissions = list;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends kotlin.d0.d.p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ExamFlowViewModel.class), this.$parameters);
        }

        public f(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public ExamFlowActivity() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new ExamFlowActivity.f(this, aVar, aVar));
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final synchronized boolean arePermissionsGranted(String... permissions) {
        int i;
        i = 0;
        i = i + 1;
        return true;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final List<String> cancelFlow() {
        List list = p.m(new String[] { "android.permission.CAMERA" });
        if (getPackageManager().hasSystemFeature("android.hardware.microphone")) {
            list.add("android.permission.RECORD_AUDIO");
        }
        return list;
    }

    private final e k() {
        return (ExamFlowScreenKey)app.dogo.com.dogo_android.util.extensionfunction.g1.l(this);
    }

    private final f l() {
        return (ExamFlowViewModel)this.binding.getValue();
    }

    private final boolean m() {
        boolean z = true;
        if (getSupportFragmentManager().p0() > 1) {
            int i3 = 0;
        }
        return z;
    }

    private static final void o(ExamFlowActivity examFlowActivity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        n.f(examFlowActivity, "this$0");
        n.f(inAppMessage, "inAppMessage");
        n.f(firebaseInAppMessagingDisplayCallbacks, "firebaseInAppMessagingDisplayCallbacks");
        app.dogo.com.dogo_android.util.extensionfunction.g1.r(examFlowActivity, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }

    private final synchronized void p() {
        List list = app.dogo.com.dogo_android.util.extensionfunction.g1.k(this, cancelFlow());
        final int i3 = 1;
        i = list.isEmpty() ^ i3;
        Object[] array = list.toArray(new String[0]);
        requestPermissions(array, i3);
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context newBase) {
        n.f(newBase, "newBase");
        t.a iNSTANCE2 = MyContextWrapper.INSTANCE;
        final Context resources2 = iNSTANCE2.updateResources(newBase, LocaleService.getLanguageFromLocaleString(App.INSTANCE.l().W()));
        super.attachBaseContext(resources2);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        iNSTANCE2.updateResourcesUpTo25Api(resources, resources2);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public void c() {
        setResult(-1);
        finish();
    }

    @Override // androidx.appcompat.app.d
    public void d() {
        setResult(0);
        finish();
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        if (m()) {
            d();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle savedInstanceState) throws app.dogo.com.dogo_android.exam.k.j {
        super.onCreate(savedInstanceState);
        androidx.databinding.ViewDataBinding viewDataBinding = f.g(this, 2131558430);
        n.e(viewDataBinding, "setContentView(this, R.layout.activity_exam_flow)");
        this.a = viewDataBinding;
        if (viewDataBinding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            viewDataBinding.T(l());
            getOnBackPressedDispatcher().b(this, new ExamFlowActivity_onCreate_1(this));
            if (!getPackageManager().hasSystemFeature("android.hardware.camera")) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.g0(this, 2131886517);
                d();
            } else {
                Object[] array = cancelFlow().toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                length = array.length;
                if (!arePermissionsGranted((String[])Arrays.copyOf(array, length))) {
                    p();
                } else {
                    if (savedInstanceState == null) {
                        app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new ExamRecordScreen(k().describeContents()));
                    }
                }
            }
            return;
        }
    }

    @Override // androidx.appcompat.app.d
    public synchronized void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        n.f(strArr, "permissions");
        n.f(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1) {
            return;
        }
        Object[] array = cancelFlow().toArray(new String[0]);
        if (arePermissionsGranted((String[])Arrays.copyOf(array, array.length))) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new ExamRecordScreen(k().describeContents()));
        } else {
            app.dogo.com.dogo_android.util.extensionfunction.f1.e0(this, app.dogo.com.dogo_android.util.extensionfunction.g1.k(this, cancelFlow()), new ExamFlowActivity.c(this), new ExamFlowActivity.d(this));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(new a(this));
    }

    /* renamed from: n, reason: from kotlin metadata */
    public static /* synthetic */ void onRequestPermissionsResult(ExamFlowActivity requestCode, InAppMessage permissions, FirebaseInAppMessagingDisplayCallbacks grantResults) {
        ExamFlowActivity.o(requestCode, permissions, grantResults);
    }
}
