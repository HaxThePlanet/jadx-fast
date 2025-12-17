package com.google.android.gms.measurement.internal;

import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import androidx.core.content.a;
import com.google.android.gms.common.util.e;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class o extends com.google.android.gms.measurement.internal.w5 {

    private long c;
    private String d;
    private AccountManager e;
    private Boolean f;
    private long g;
    o(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean j() {
        Calendar instance = Calendar.getInstance();
        int i8 = 16;
        this.c = TimeUnit.MINUTES.convert((long)i5, i8);
        Locale default = Locale.getDefault();
        Locale eNGLISH = Locale.ENGLISH;
        String lowerCase2 = default.getLanguage().toLowerCase(eNGLISH);
        String lowerCase = default.getCountry().toLowerCase(eNGLISH);
        StringBuilder stringBuilder = new StringBuilder(i6 += length2);
        stringBuilder.append(lowerCase2);
        stringBuilder.append("-");
        stringBuilder.append(lowerCase);
        this.d = stringBuilder.toString();
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final long o() {
        h();
        return this.g;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final long p() {
        k();
        return this.c;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final String q() {
        k();
        return this.d;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void r() {
        h();
        this.f = 0;
        this.g = 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean s() {
        Object result2;
        AccountManager accountManager2;
        Object result;
        AccountManager accountManager;
        int i;
        String str = "com.google";
        h();
        long currentTimeMillis = this.a.c().currentTimeMillis();
        i = 0;
        if (Long.compare(i2, i4) > 0) {
            this.f = i;
        }
        Boolean bool = this.f;
        int i5 = 0;
        if (bool == null && a.a(this.a.f(), "android.permission.GET_ACCOUNTS") != 0) {
            i5 = 0;
            if (a.a(this.a.f(), "android.permission.GET_ACCOUNTS") != 0) {
                this.a.b().y().a("Permission error checking for dasher/unicorn accounts");
                this.g = currentTimeMillis;
                this.f = Boolean.FALSE;
                return i5;
            }
            if (this.e == null) {
                this.e = AccountManager.get(this.a.f());
            }
            result = this.e.getAccountsByTypeAndFeatures(str, /* result */, i, i).getResult();
            int i6 = 1;
            if ((Account[])result != null && result.length > 0) {
                if (result.length > 0) {
                    this.f = Boolean.TRUE;
                    this.g = currentTimeMillis;
                    return i6;
                }
            }
            result2 = this.e.getAccountsByTypeAndFeatures(str, /* result */, i, i).getResult();
            if ((Account[])result2 != null && result2.length > 0) {
                if (result2.length > 0) {
                    this.f = Boolean.TRUE;
                    this.g = currentTimeMillis;
                    return i6;
                }
            }
            this.g = currentTimeMillis;
            this.f = Boolean.FALSE;
            return i5;
        }
        return bool.booleanValue();
    }
}
