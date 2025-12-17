package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.e;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import d.p.a.a;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SignInHubActivity extends e {

    private static boolean x = false;
    private boolean a = false;
    private com.google.android.gms.auth.api.signin.internal.SignInConfiguration b;
    private boolean c;
    private int v;
    private Intent w;
    static {
    }

    public SignInHubActivity() {
        super();
        final int i = 0;
    }

    static int i(com.google.android.gms.auth.api.signin.internal.SignInHubActivity signInHubActivity) {
        return signInHubActivity.v;
    }

    static Intent j(com.google.android.gms.auth.api.signin.internal.SignInHubActivity signInHubActivity) {
        return signInHubActivity.w;
    }

    private final void k() {
        final int i = 0;
        x xVar = new x(this, i);
        final int i2 = 0;
        getSupportLoaderManager().c(i2, i, xVar);
        SignInHubActivity.x = i2;
    }

    private final void l(int i) {
        Status status = new Status(i);
        Intent obj3 = new Intent();
        obj3.putExtra("googleSignInStatus", status);
        int i2 = 0;
        setResult(i2, obj3);
        finish();
        SignInHubActivity.x = i2;
    }

    private final void m(String string) {
        String obj3;
        Intent intent = new Intent(string);
        if (string.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.b);
        startActivityForResult(intent, 40962);
    }

    @Override // androidx.fragment.app.e
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return 1;
    }

    @Override // androidx.fragment.app.e
    protected final void onActivityResult(int i, int i2, Intent intent3) {
        int extra;
        android.os.Parcelable parcelableExtra;
        com.google.android.gms.auth.api.signin.GoogleSignInAccount googleSignInAccount;
        int obj4;
        int obj5;
        if (this.a) {
        }
        setResult(0);
        if (i != 40962) {
        }
        obj4 = 8;
        String str = "signInAccount";
        parcelableExtra = intent3.getParcelableExtra(str);
        if (intent3 != null && parcelableExtra != null && (SignInAccount)parcelableExtra.j2() != null) {
            str = "signInAccount";
            parcelableExtra = intent3.getParcelableExtra(str);
            if ((SignInAccount)parcelableExtra != null) {
                if ((SignInAccount)parcelableExtra.j2() != null) {
                    obj4 = parcelableExtra.j2();
                    Objects.requireNonNull(obj4);
                    o.a(this).c(this.b.j2(), obj4);
                    intent3.removeExtra(str);
                    intent3.putExtra("googleSignInAccount", obj4);
                    this.c = true;
                    this.v = i2;
                    this.w = intent3;
                    k();
                }
            }
            obj5 = "errorCode";
            if (intent3.hasExtra(obj5) && intent3.getIntExtra(obj5, obj4) == 13) {
                if (intent3.getIntExtra(obj5, obj4) == 13) {
                    obj4 = 12501;
                }
                l(obj4);
            }
        }
        l(obj4);
    }

    @Override // androidx.fragment.app.e
    protected final void onCreate(Bundle bundle) {
        boolean boolean;
        boolean equals;
        String obj5;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        Objects.requireNonNull(action);
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            l(12500);
        }
        final String str8 = "AuthSignInClient";
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            if (!action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
                obj5 = String.valueOf(intent.getAction());
                String str = "Unknown action: ";
                if (obj5.length() != 0) {
                    obj5 = str.concat(obj5);
                } else {
                    obj5 = new String(str);
                }
                Log.e(str8, obj5);
                finish();
            }
        }
        String str7 = "config";
        Bundle bundleExtra = intent.getBundleExtra(str7);
        Objects.requireNonNull(bundleExtra);
        android.os.Parcelable parcelable = bundleExtra.getParcelable(str7);
        int i = 0;
        if ((SignInConfiguration)parcelable == null) {
            Log.e(str8, "Activity started with invalid configuration.");
            setResult(i);
            finish();
        }
        this.b = (SignInConfiguration)parcelable;
        if (bundle == null && SignInHubActivity.x) {
            if (SignInHubActivity.x) {
                setResult(i);
                l(12502);
            }
            SignInHubActivity.x = true;
            m(action);
        }
        boolean = bundle.getBoolean("signingInGoogleApiClients");
        this.c = boolean;
        if (boolean) {
            this.v = bundle.getInt("signInResultCode");
            obj5 = bundle.getParcelable("signInResultData");
            Objects.requireNonNull((Intent)obj5);
            this.w = obj5;
            k();
        }
    }

    @Override // androidx.fragment.app.e
    public final void onDestroy() {
        super.onDestroy();
        SignInHubActivity.x = false;
    }

    @Override // androidx.fragment.app.e
    protected final void onSaveInstanceState(Bundle bundle) {
        boolean z;
        String str;
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.c);
        if (this.c) {
            bundle.putInt("signInResultCode", this.v);
            bundle.putParcelable("signInResultData", this.w);
        }
    }
}
