package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.HttpDataSource.a;
import com.google.android.exoplayer2.upstream.m;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class e0 implements com.google.android.exoplayer2.drm.f0 {

    private final HttpDataSource.a a;
    private final String b;
    private final boolean c;
    private final Map<String, String> d;
    public e0(String string, boolean z2, HttpDataSource.a httpDataSource$a3) {
        int i;
        boolean empty;
        super();
        if (z2) {
            if (!TextUtils.isEmpty(string)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        g.a(i);
        this.a = a3;
        this.b = string;
        this.c = z2;
        HashMap obj2 = new HashMap();
        this.d = obj2;
    }

    private static byte[] c(HttpDataSource.a httpDataSource$a, String string2, byte[] b3Arr3, Map<String, String> map4) {
        int obj8;
        n obj9;
        z zVar = new z(a.a());
        obj8 = new n.b();
        obj8.j(string2);
        obj8.e(map4);
        obj8.d(2);
        obj8.c(b3Arr3);
        obj8.b(1);
        obj8 = 0;
        obj9 = nVar;
        m obj10 = new m(zVar, obj9);
        p0.m(obj10);
        return p0.G0(obj10);
    }

    private static String d(HttpDataSource.InvalidResponseCodeException httpDataSource$InvalidResponseCodeException, int i2) {
        int responseCode;
        int i;
        Object obj3;
        int obj4;
        responseCode = invalidResponseCodeException.responseCode;
        final int i4 = 0;
        if (responseCode != 307) {
            if (responseCode == 308 && i2 < 5) {
                obj4 = i2 < 5 ? 1 : i4;
            } else {
            }
        } else {
        }
        int i3 = 0;
        if (obj4 == null) {
            return i3;
        }
        obj3 = invalidResponseCodeException.headerFields;
        obj3 = obj3.get("Location");
        if (obj3 != null && obj3 != null && !(List)obj3.isEmpty()) {
            obj3 = obj3.get("Location");
            if ((List)obj3 != null) {
                if (!(List)obj3.isEmpty()) {
                    return (String)obj3.get(i4);
                }
            }
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.drm.f0
    public byte[] a(UUID uUID, com.google.android.exoplayer2.drm.b0.a b0$a2) {
        String str;
        boolean empty;
        Object str3;
        String str2;
        boolean obj8;
        if (!this.c) {
            if (TextUtils.isEmpty(a2.b())) {
                str = this.b;
            }
        } else {
        }
        if (TextUtils.isEmpty(str)) {
        } else {
            HashMap hashMap = new HashMap();
            str3 = w0.e;
            str2 = str3.equals(uUID) ? "text/xml" : equals2 ? "application/json" : "application/octet-stream";
            hashMap.put("Content-Type", str2);
            if (str3.equals(uUID)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            obj8 = this.d;
            hashMap.putAll(this.d);
            return e0.c(this.a, str, a2.a(), hashMap);
            synchronized (obj8) {
                obj8 = this.d;
                hashMap.putAll(this.d);
                return e0.c(this.a, str, a2.a(), hashMap);
            }
        }
        n.b obj9 = new n.b();
        obj9.i(Uri.EMPTY);
        IllegalStateException illegalStateException = new IllegalStateException("No license URL");
        super(obj9.a(), Uri.EMPTY, x.k(), 0, obj5, illegalStateException);
        throw obj8;
    }

    @Override // com.google.android.exoplayer2.drm.f0
    public byte[] b(UUID uUID, com.google.android.exoplayer2.drm.b0.d b0$d2) {
        String obj3 = d2.b();
        String obj4 = p0.A(d2.a());
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(obj3);
        stringBuilder.append("&signedRequest=");
        stringBuilder.append(obj4);
        return e0.c(this.a, stringBuilder.toString(), 0, Collections.emptyMap());
    }

    @Override // com.google.android.exoplayer2.drm.f0
    public void e(String string, String string2) {
        g.e(string);
        g.e(string2);
        final Map map = this.d;
        this.d.put(string, string2);
        return;
        synchronized (map) {
            g.e(string);
            g.e(string2);
            map = this.d;
            this.d.put(string, string2);
        }
    }
}
