package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.r;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class c {

    private static final Lock c;
    private static com.google.android.gms.auth.api.signin.internal.c d;
    private final Lock a;
    private final SharedPreferences b;
    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        c.c = reentrantLock;
    }

    c(Context context) {
        super();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static com.google.android.gms.auth.api.signin.internal.c b(Context context) {
        com.google.android.gms.auth.api.signin.internal.c cVar;
        Object obj2;
        r.j(context);
        final Lock lock2 = c.c;
        lock2.lock();
        if (c.d == null) {
            cVar = new c(context.getApplicationContext());
            c.d = cVar;
        }
        lock2.unlock();
        return c.d;
    }

    private static final String i(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(string);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void a() {
        this.a.lock();
        this.b.edit().clear().apply();
        this.a.unlock();
    }

    public GoogleSignInAccount c() {
        String str;
        boolean empty;
        int i;
        str = h("defaultGoogleSignInAccount");
        i = 0;
        if (TextUtils.isEmpty(str)) {
        } else {
            str = h(c.i("googleSignInAccount", str));
            if (str != null) {
                i = GoogleSignInAccount.o2(str);
            }
        }
        return i;
    }

    public GoogleSignInOptions d() {
        String str;
        boolean empty;
        int i;
        str = h("defaultGoogleSignInAccount");
        i = 0;
        if (TextUtils.isEmpty(str)) {
        } else {
            str = h(c.i("googleSignInOptions", str));
            if (str != null) {
                i = GoogleSignInOptions.q2(str);
            }
        }
        return i;
    }

    public String e() {
        return h("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions2) {
        r.j(googleSignInAccount);
        r.j(googleSignInOptions2);
        g("defaultGoogleSignInAccount", googleSignInAccount.q2());
        r.j(googleSignInAccount);
        r.j(googleSignInOptions2);
        String str2 = googleSignInAccount.q2();
        g(c.i("googleSignInAccount", str2), googleSignInAccount.r2());
        g(c.i("googleSignInOptions", str2), googleSignInOptions2.r2());
    }

    protected final void g(String string, String string2) {
        this.a.lock();
        this.b.edit().putString(string, string2).apply();
        this.a.unlock();
    }

    protected final String h(String string) {
        this.a.lock();
        this.a.unlock();
        return this.b.getString(string, 0);
    }
}
