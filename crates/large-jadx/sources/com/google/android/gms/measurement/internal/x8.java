package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.e;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class x8 extends com.google.android.gms.measurement.internal.r9 {

    private String d;
    private boolean e;
    private long f;
    public final com.google.android.gms.measurement.internal.b4 g;
    public final com.google.android.gms.measurement.internal.b4 h;
    public final com.google.android.gms.measurement.internal.b4 i;
    public final com.google.android.gms.measurement.internal.b4 j;
    public final com.google.android.gms.measurement.internal.b4 k;
    x8(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
        com.google.android.gms.measurement.internal.g4 g4Var = this.a.F();
        g4Var.getClass();
        final int i = 0;
        b4 obj5 = new b4(g4Var, "last_delete_stale", i, obj3);
        this.g = obj5;
        com.google.android.gms.measurement.internal.g4 g4Var2 = this.a.F();
        g4Var2.getClass();
        obj5 = new b4(g4Var2, "backoff", i, obj3);
        this.h = obj5;
        com.google.android.gms.measurement.internal.g4 g4Var3 = this.a.F();
        g4Var3.getClass();
        obj5 = new b4(g4Var3, "last_upload", i, obj3);
        this.i = obj5;
        com.google.android.gms.measurement.internal.g4 g4Var4 = this.a.F();
        g4Var4.getClass();
        obj5 = new b4(g4Var4, "last_upload_attempt", i, obj3);
        this.j = obj5;
        com.google.android.gms.measurement.internal.g4 g4Var5 = this.a.F();
        g4Var5.getClass();
        obj5 = new b4(g4Var5, "midnight_offset", i, obj3);
        this.k = obj5;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean l() {
        return 0;
    }

    @Deprecated
    final Pair<String, Boolean> m(String string) {
        String str;
        String str2;
        int cmp;
        boolean obj7;
        h();
        long l = this.a.c().a();
        String str5 = this.d;
        if (str5 != null && Long.compare(l, l3) >= 0) {
            if (Long.compare(l, l3) >= 0) {
            }
            obj7 = new Pair(str5, Boolean.valueOf(this.e));
            return obj7;
        }
        this.f = l += l2;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        obj7 = AdvertisingIdClient.getAdvertisingIdInfo(this.a.f());
        this.d = "";
        str = obj7.getId();
        if (str != null) {
            this.d = str;
        }
        this.e = obj7.isLimitAdTrackingEnabled();
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        obj7 = new Pair(this.d, Boolean.valueOf(this.e));
        return obj7;
    }

    final Pair<String, Boolean> n(String string, com.google.android.gms.measurement.internal.h h2) {
        if (h2.j()) {
            return m(string);
        }
        Pair obj2 = new Pair("", Boolean.FALSE);
        return obj2;
    }

    @Deprecated
    final String o(String string) {
        h();
        final MessageDigest messageDigest = ia.s();
        if (messageDigest == null) {
            return null;
        }
        final int i = 1;
        final Object[] arr = new Object[i];
        BigInteger bigInteger = new BigInteger(i, messageDigest.digest((String)obj6.first.getBytes()));
        arr[0] = bigInteger;
        return String.format(Locale.US, "%032X", arr);
    }
}
