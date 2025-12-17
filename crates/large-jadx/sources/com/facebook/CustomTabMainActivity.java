package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.b0;
import com.facebook.internal.e;
import com.facebook.internal.r;
import com.facebook.internal.w;
import com.facebook.login.s;
import com.facebook.login.s.a;
import d.q.a.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\rH\u0014J\u0008\u0010\u000e\u001a\u00020\u0008H\u0014J\u001a\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lcom/facebook/CustomTabMainActivity;", "Landroid/app/Activity;", "()V", "redirectReceiver", "Landroid/content/BroadcastReceiver;", "shouldCloseCustomTab", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "sendResult", "resultCode", "", "resultIntent", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CustomTabMainActivity extends Activity {

    public static final String A;
    public static final com.facebook.CustomTabMainActivity.a B;
    public static final String c;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;
    private boolean a = true;
    private BroadcastReceiver b;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lcom/facebook/CustomTabMainActivity$Companion;", "", "()V", "EXTRA_ACTION", "", "EXTRA_CHROME_PACKAGE", "EXTRA_PARAMS", "EXTRA_TARGET_APP", "EXTRA_URL", "NO_ACTIVITY_EXCEPTION", "REFRESH_ACTION", "parseResponseUri", "Landroid/os/Bundle;", "urlString", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final Bundle a(com.facebook.CustomTabMainActivity.a customTabMainActivity$a, String string2) {
            return a.b(string2);
        }

        private final Bundle b(String string) {
            Uri obj2 = Uri.parse(string);
            n.e(obj2, "uri");
            Bundle bundle = b0.i0(obj2.getQuery());
            bundle.putAll(b0.i0(obj2.getFragment()));
            return bundle;
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"com/facebook/CustomTabMainActivity$onCreate$redirectReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class b extends BroadcastReceiver {

        final com.facebook.CustomTabMainActivity a;
        b(com.facebook.CustomTabMainActivity customTabMainActivity) {
            this.a = customTabMainActivity;
            super();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            n.f(context, "context");
            n.f(intent2, "intent");
            Intent obj3 = new Intent(this.a, CustomTabMainActivity.class);
            obj3.setAction(CustomTabMainActivity.z);
            String str3 = CustomTabMainActivity.x;
            obj3.putExtra(str3, intent2.getStringExtra(str3));
            obj3.addFlags(603979776);
            this.a.startActivity(obj3);
        }
    }
    static {
        CustomTabMainActivity.a aVar = new CustomTabMainActivity.a(0);
        CustomTabMainActivity.B = aVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_action");
        CustomTabMainActivity.c = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder2.append(".extra_params");
        CustomTabMainActivity.v = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder3.append(".extra_chromePackage");
        CustomTabMainActivity.w = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder4.append(".extra_url");
        CustomTabMainActivity.x = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder5.append(".extra_targetApp");
        CustomTabMainActivity.y = stringBuilder5.toString();
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder6.append(".action_refresh");
        CustomTabMainActivity.z = stringBuilder6.toString();
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder7.append(".no_activity_exception");
        CustomTabMainActivity.A = stringBuilder7.toString();
    }

    public CustomTabMainActivity() {
        super();
        final int i = 1;
    }

    private final void a(int i, Intent intent2) {
        Object str;
        a aVar;
        Bundle bundle;
        Object intent;
        Intent obj6;
        BroadcastReceiver broadcastReceiver = this.b;
        if (broadcastReceiver != null) {
            a.b(this).e(broadcastReceiver);
        }
        str = "intent";
        int i2 = 0;
        if (intent2 != null) {
            String stringExtra = intent2.getStringExtra(CustomTabMainActivity.x);
            if (stringExtra != null) {
                bundle = CustomTabMainActivity.a.a(CustomTabMainActivity.B, stringExtra);
            } else {
                bundle = new Bundle();
            }
            intent = getIntent();
            n.e(intent, str);
            str = w.o(intent, bundle, i2);
            if (str != null) {
                obj6 = str;
            }
            setResult(i, obj6);
        } else {
            obj6 = getIntent();
            n.e(obj6, str);
            setResult(i, w.o(obj6, i2, i2));
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        int intentFilter;
        String stringExtra;
        e rVar;
        int i;
        String str;
        Object obj8;
        super.onCreate(bundle);
        String str2 = CustomTabActivity.b;
        Intent intent = getIntent();
        n.e(intent, "intent");
        intentFilter = 0;
        if (n.b(str2, intent.getAction())) {
            setResult(intentFilter);
            finish();
        }
        obj8 = getIntent().getStringExtra(CustomTabMainActivity.c);
        if (bundle == null && obj8 != null) {
            obj8 = getIntent().getStringExtra(CustomTabMainActivity.c);
            if (obj8 != null) {
                Bundle bundleExtra = getIntent().getBundleExtra(CustomTabMainActivity.v);
                i = 1;
                if (l.a[s.Companion.a(getIntent().getStringExtra(CustomTabMainActivity.y)).ordinal()] != i) {
                    rVar = new e(obj8, bundleExtra);
                } else {
                    rVar = new r(obj8, bundleExtra);
                }
                this.a = intentFilter;
                if (!rVar.b(this, getIntent().getStringExtra(CustomTabMainActivity.w))) {
                    setResult(intentFilter, getIntent().putExtra(CustomTabMainActivity.A, i));
                    finish();
                }
                obj8 = new CustomTabMainActivity.b(this);
                this.b = obj8;
                intentFilter = new IntentFilter(str2);
                a.b(this).c(obj8, intentFilter);
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intent intent2;
        Object action;
        n.f(intent, "intent");
        super.onNewIntent(intent);
        int i = -1;
        if (n.b(CustomTabMainActivity.z, intent.getAction())) {
            intent2 = new Intent(CustomTabActivity.c);
            a.b(this).d(intent2);
            a(i, intent);
        } else {
            if (n.b(CustomTabActivity.b, intent.getAction())) {
                a(i, intent);
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        boolean z;
        int i;
        super.onResume();
        if (this.a) {
            a(0, 0);
        }
        this.a = true;
    }
}
