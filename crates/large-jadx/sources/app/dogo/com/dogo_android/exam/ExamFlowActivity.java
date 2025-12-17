package app.dogo.com.dogo_android.exam;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.appcompat.app.d;
import androidx.databinding.f;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.exam.k.j;
import app.dogo.com.dogo_android.h.e;
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
import f.c.a.f.a.d.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlin.y.p;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0005\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0018\u001a\u00020\u000c2\u0012\u0010\u0019\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00060\u001a\"\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0008\u0010 \u001a\u00020\u001dH\u0016J\u0008\u0010!\u001a\u00020\u001dH\u0016J\u0008\u0010\"\u001a\u00020\u001dH\u0016J\u0012\u0010#\u001a\u00020\u001d2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0014J+\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010+J\u0008\u0010,\u001a\u00020\u001dH\u0014J\u0008\u0010-\u001a\u00020\u001dH\u0002R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lapp/dogo/com/dogo_android/exam/ExamFlowCallback;", "()V", "allRequiredPermissions", "", "", "getAllRequiredPermissions", "()Ljava/util/List;", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityExamFlowBinding;", "isBackStackEmptyOr1Item", "", "()Z", "screenKey", "Lapp/dogo/com/dogo_android/exam/ExamFlowScreenKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/exam/ExamFlowScreenKey;", "sessionViewModel", "Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "getSessionViewModel", "()Lapp/dogo/com/dogo_android/exam/ExamFlowViewModel;", "sessionViewModel$delegate", "Lkotlin/Lazy;", "arePermissionsGranted", "permissions", "", "([Ljava/lang/String;)Z", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "cancelFlow", "completeFlow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "requestPermissions", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExamFlowActivity extends d implements app.dogo.com.dogo_android.exam.d {

    public static final app.dogo.com.dogo_android.exam.ExamFlowActivity.a Companion;
    private e a;
    private final h b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamFlowActivity$Companion;", "", "()V", "PERMISSION_REQUEST_CODE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/exam/ExamFlowActivity$onCreate$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final app.dogo.com.dogo_android.exam.ExamFlowActivity c;
        b(app.dogo.com.dogo_android.exam.ExamFlowActivity examFlowActivity) {
            this.c = examFlowActivity;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            g1.O(this.c);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.exam.ExamFlowActivity this$0;
        c(app.dogo.com.dogo_android.exam.ExamFlowActivity examFlowActivity) {
            this.this$0 = examFlowActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.this$0.d();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.exam.ExamFlowActivity this$0;
        d(app.dogo.com.dogo_android.exam.ExamFlowActivity examFlowActivity) {
            this.this$0 = examFlowActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.this$0.d();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<w> {

        final List<String> $deniedPermissions;
        final app.dogo.com.dogo_android.exam.ExamFlowActivity this$0;
        e(app.dogo.com.dogo_android.exam.ExamFlowActivity examFlowActivity, List<String> list2) {
            this.this$0 = examFlowActivity;
            this.$deniedPermissions = list2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            final int i = 1;
            App.Companion.l().J0(i);
            Object[] array = this.$deniedPermissions.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            this.this$0.requestPermissions((String[])array, i);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends p implements a<app.dogo.com.dogo_android.exam.f> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public f(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.exam.f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        ExamFlowActivity.a aVar = new ExamFlowActivity.a(0);
        ExamFlowActivity.Companion = aVar;
    }

    public ExamFlowActivity() {
        super();
        final int i = 0;
        ExamFlowActivity.f fVar = new ExamFlowActivity.f(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, fVar);
    }

    private final boolean i(String... stringArr) {
        int i;
        int checkSelfPermission;
        final int i2 = 0;
        i = i2;
        synchronized (this) {
            try {
                while (i < stringArr.length) {
                    i++;
                }
                i++;
                if (checkSelfPermission(stringArr[i]) != 0) {
                } else {
                }
                return i2;
                return 1;
                throw stringArr;
            }
        }
    }

    private final List<String> j() {
        boolean systemFeature;
        List list = p.m(/* result */);
        if (getPackageManager().hasSystemFeature("android.hardware.microphone")) {
            list.add("android.permission.RECORD_AUDIO");
        }
        return list;
    }

    private final app.dogo.com.dogo_android.exam.e k() {
        return (e)g1.l(this);
    }

    private final app.dogo.com.dogo_android.exam.f l() {
        return (f)this.b.getValue();
    }

    private final boolean m() {
        int i;
        if (getSupportFragmentManager().p0() <= 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public static void n(app.dogo.com.dogo_android.exam.ExamFlowActivity examFlowActivity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        ExamFlowActivity.o(examFlowActivity, inAppMessage2, firebaseInAppMessagingDisplayCallbacks3);
    }

    private static final void o(app.dogo.com.dogo_android.exam.ExamFlowActivity examFlowActivity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        n.f(examFlowActivity, "this$0");
        n.f(inAppMessage2, "inAppMessage");
        n.f(firebaseInAppMessagingDisplayCallbacks3, "firebaseInAppMessagingDisplayCallbacks");
        g1.r(examFlowActivity, inAppMessage2, firebaseInAppMessagingDisplayCallbacks3);
    }

    private final void p() {
        List array;
        int strArr;
        array = g1.k(this, j());
        final int i2 = 1;
        synchronized (this) {
            try {
                if (App.Companion.l().t()) {
                }
                array = array.toArray(new String[0]);
                if (array == null) {
                } else {
                }
                requestPermissions((String[])array, i2);
                NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw nullPointerException;
                strArr = new ExamFlowActivity.e(this, array);
                f1.p0(this, array, strArr);
                throw th;
            }
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
    protected void onCreate(Bundle bundle) {
        boolean systemFeature;
        int length;
        Bundle obj3;
        super.onCreate(bundle);
        androidx.databinding.ViewDataBinding view = f.g(this, 2131558430);
        n.e(view, "setContentView(this, R.layout.activity_exam_flow)");
        this.a = (e)view;
        if (view == null) {
        } else {
            view.T(l());
            ExamFlowActivity.b bVar = new ExamFlowActivity.b(this);
            getOnBackPressedDispatcher().b(this, bVar);
            if (!getPackageManager().hasSystemFeature("android.hardware.camera")) {
                g1.g0(this, 2131886517);
                d();
            } else {
                Object[] array = j().toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                if (i((String[])Arrays.copyOf((String[])array, array.length))) {
                    if (bundle == null) {
                        obj3 = new j(k().a());
                        g1.n(this, obj3);
                    }
                } else {
                    p();
                }
            }
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.appcompat.app.d
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
        Object obj2;
        Object obj3;
        Object obj4;
        n.f(string2Arr2, "permissions");
        n.f(i3Arr3, "grantResults");
        super.onRequestPermissionsResult(i, string2Arr2, i3Arr3);
        synchronized (this) {
            try {
                obj2 = j().toArray(new String[0]);
                if (obj2 == null) {
                } else {
                }
                if (i((String[])Arrays.copyOf((String[])obj2, obj2.length))) {
                } else {
                }
                obj2 = new j(k().a());
                g1.n(this, obj2);
                obj3 = new ExamFlowActivity.c(this);
                obj4 = new ExamFlowActivity.d(this);
                f1.e0(this, g1.k(this, j()), obj3, obj4);
                obj2 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw obj2;
                throw i;
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        a aVar = new a(this);
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(aVar);
    }
}
