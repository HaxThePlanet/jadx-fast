package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.util.Log;
import f.c.a.f.a.d.b;
import f.c.a.f.a.d.f;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class y {

    private final f a;
    private final Context b;
    private final com.google.android.play.core.internal.x c;
    private PackageInfo d;
    public y(Context context, f f2, com.google.android.play.core.internal.u u3) {
        b bVar = new b(f2);
        x obj4 = new x(bVar);
        super();
        this.a = f2;
        this.b = context;
        this.c = obj4;
    }

    private final PackageInfo d() {
        PackageInfo packageInfo;
        String packageName;
        int i;
        if (this.d == null) {
            this.d = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64);
        }
        return this.d;
    }

    private static X509Certificate e(Signature signature) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            return (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(byteArrayInputStream);
            Log.e("SplitCompat", "Cannot decode certificate.", signature);
            signature = null;
            return signature;
        }
    }

    public final boolean a(File[] fileArr) {
        long longVersionCode;
        int length;
        int cmp;
        Object obj;
        PackageInfo packageInfo = d();
        if (Build.VERSION.SDK_INT >= 28) {
            longVersionCode = packageInfo.getLongVersionCode();
        } else {
            longVersionCode = (long)versionCode;
        }
        length = fileArr.length;
        length--;
        while (length >= 0) {
            this.c.b((AssetManager)w0.c(AssetManager.class), fileArr[length]);
            length--;
        }
        return 1;
    }

    public final boolean b(List<Intent> list) {
        boolean exists;
        f fVar;
        Iterator obj3 = list.iterator();
        for (Intent next2 : obj3) {
        }
        return 1;
    }

    public final boolean c(File[] fileArr) {
        String str;
        PackageInfo signatures;
        int stringBuilder2;
        int stringBuilder;
        int length;
        int absolutePath;
        X509Certificate x509Certificate;
        boolean length2;
        int length3;
        int i;
        boolean equals;
        String obj13;
        signatures = d();
        stringBuilder2 = 0;
        final int i2 = 0;
        if (signatures != null) {
            if (signatures.signatures == null) {
            } else {
                stringBuilder2 = new ArrayList();
                signatures = signatures.signatures;
                absolutePath = i2;
                while (absolutePath < signatures.length) {
                    x509Certificate = y.e(signatures[absolutePath]);
                    if (x509Certificate != null) {
                    }
                    absolutePath++;
                    stringBuilder2.add(x509Certificate);
                }
            }
        }
        String str4 = "SplitCompat";
        if (stringBuilder2 != 0) {
            if (stringBuilder2.isEmpty()) {
            } else {
                length = fileArr.length;
                length--;
                while (length >= 0) {
                    absolutePath = fileArr[length].getAbsolutePath();
                    x509Certificate = w1.a(absolutePath);
                    absolutePath = stringBuilder2.iterator();
                    for (X509Certificate length2 : absolutePath) {
                        i = i2;
                        while (i < x509Certificate.length) {
                            i++;
                        }
                        i++;
                    }
                    length--;
                    i = i2;
                    while (i < x509Certificate.length) {
                        i++;
                    }
                    i++;
                }
            }
            return 1;
        }
        Log.e(str4, "No app certificates found.");
        return i2;
    }
}
