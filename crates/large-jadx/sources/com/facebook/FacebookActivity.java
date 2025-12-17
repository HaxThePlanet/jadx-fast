package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.facebook.common.b;
import com.facebook.common.c;
import com.facebook.h0.b;
import com.facebook.internal.b0;
import com.facebook.internal.g;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.h0.a.b;
import com.facebook.internal.h0.a.b.c;
import com.facebook.internal.w;
import com.facebook.login.n;
import com.facebook.share.a.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J7\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0017¢\u0006\u0002\u0010\u0012J\u0008\u0010\u0013\u001a\u00020\u0004H\u0014J\u0008\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\t2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001c", d2 = {"Lcom/facebook/FacebookActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "<set-?>", "Landroidx/fragment/app/Fragment;", "currentFragment", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "dump", "", "prefix", "", "fd", "Ljava/io/FileDescriptor;", "writer", "Ljava/io/PrintWriter;", "args", "", "(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "getFragment", "handlePassThroughError", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class FacebookActivity extends e {

    private static final String b;
    private Fragment a;
    static {
        String name = FacebookActivity.class.getName();
        n.e(name, "FacebookActivity::class.java.name");
        FacebookActivity.b = name;
    }

    private final void j() {
        Intent intent = getIntent();
        n.e(intent, "requestIntent");
        Intent intent3 = getIntent();
        n.e(intent3, "intent");
        setResult(0, w.o(intent3, 0, w.s(w.w(intent))));
        finish();
    }

    @Override // androidx.fragment.app.e
    public void dump(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        if (a.d(this)) {
        }
        n.f(string, "prefix");
        n.f(printWriter3, "writer");
        if (b.f.n(string, printWriter3, string4Arr4)) {
        }
        super.dump(string, fileDescriptor2, printWriter3, string4Arr4);
    }

    @Override // androidx.fragment.app.e
    public final Fragment getCurrentFragment() {
        return this.a;
    }

    @Override // androidx.fragment.app.e
    protected Fragment i() {
        Object parcelableExtra;
        n supportFragmentManager;
        Fragment nVar;
        int str;
        String str2;
        parcelableExtra = getIntent();
        supportFragmentManager = getSupportFragmentManager();
        n.e(supportFragmentManager, "supportFragmentManager");
        String str4 = "SingleFragment";
        if (supportFragmentManager.k0(str4) == null) {
            n.e(parcelableExtra, "intent");
            str = 1;
            if (n.b("FacebookDialogFragment", parcelableExtra.getAction())) {
                nVar = new g();
                nVar.setRetainInstance(str);
                nVar.show(supportFragmentManager, str4);
            } else {
                if (n.b("DeviceShareDialogFragment", parcelableExtra.getAction())) {
                    Log.w(FacebookActivity.b, "Please stop use Device Share Dialog, this feature has been disabled and all related classes in Facebook Android SDK will be removed from v13.0.0 release.");
                    nVar = new a();
                    nVar.setRetainInstance(str);
                    parcelableExtra = parcelableExtra.getParcelableExtra("content");
                    Objects.requireNonNull(parcelableExtra, "null cannot be cast to non-null type com.facebook.share.model.ShareContent<*, *>");
                    nVar.K1((a)parcelableExtra);
                    nVar.show(supportFragmentManager, str4);
                } else {
                    if (n.b("ReferralFragment", parcelableExtra.getAction())) {
                        nVar = new b();
                        nVar.setRetainInstance(str);
                        parcelableExtra = supportFragmentManager.n();
                        parcelableExtra.b(b.c, nVar, str4);
                        parcelableExtra.g();
                    } else {
                        nVar = new n();
                        nVar.setRetainInstance(str);
                        parcelableExtra = supportFragmentManager.n();
                        parcelableExtra.b(b.c, nVar, str4);
                        parcelableExtra.g();
                    }
                }
            }
        }
        return nVar;
    }

    @Override // androidx.fragment.app.e
    public void onConfigurationChanged(Configuration configuration) {
        n.f(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.a;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.e
    public void onCreate(Bundle bundle) {
        boolean applicationContext;
        String str;
        super.onCreate(bundle);
        Intent obj3 = getIntent();
        if (!o.y()) {
            b0.d0(FacebookActivity.b, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            applicationContext = getApplicationContext();
            n.e(applicationContext, "applicationContext");
            o.E(applicationContext);
        }
        setContentView(c.a);
        n.e(obj3, "intent");
        if (n.b("PassThrough", obj3.getAction())) {
            j();
        }
        this.a = i();
    }
}
