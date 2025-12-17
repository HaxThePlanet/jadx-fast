package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
final class k3 {

    private static final h b;
    private final com.google.android.play.core.assetpacks.f0 a;
    static {
        h hVar = new h("VerifySliceTaskHandler");
        k3.b = hVar;
    }

    k3(com.google.android.play.core.assetpacks.f0 f0) {
        super();
        this.a = f0;
    }

    private final void b(com.google.android.play.core.assetpacks.j3 j3, File file2) {
        int i = 0;
        int i2 = 1;
        File file = this.a.B(j3.b, j3.c, j3.d, obj6);
        if (file.exists() == null) {
        } else {
            if (j2.a(i3.a(file2, file)).equals(j3.f) == null) {
            } else {
                try {
                    Object[] arr3 = new Object[2];
                    arr3[i] = j3.e;
                    arr3[i2] = j3.b;
                    k3.b.d("Verification of slice %s of pack %s successful.", arr3);
                    Object[] arr2 = new Object[i2];
                    arr2[i] = j3.e;
                    g1 obj10 = new g1(String.format("Verification failed for slice %s.", arr2), j3.a);
                    throw obj10;
                    int arr = new Object[arr];
                    String str4 = j3.e;
                    arr[format] = str4;
                    int format = "Could not digest file during verification for slice %s.";
                    format = String.format(format, arr);
                    j3 = j3.a;
                    g1 g1Var = new g1(format, file2, j3);
                    throw g1Var;
                    j3 = j3.a;
                    arr = "SHA256 algorithm not supported.";
                    format = new g1(arr, file2, j3);
                    throw format;
                    Object[] arr4 = new Object[i2];
                    arr4[i] = j3.e;
                    obj10 = new g1(String.format("Cannot find metadata files for slice %s.", arr4), j3.a);
                    throw obj10;
                    arr = new Object[arr];
                    str4 = j3.e;
                    arr[format] = str4;
                    format = "Could not reconstruct slice archive during verification for slice %s.";
                    format = String.format(format, arr);
                    j3 = j3.a;
                    g1Var = new g1(format, file2, j3);
                    throw g1Var;
                } catch (java.security.NoSuchAlgorithmException noSuchAlgorithm) {
                } catch (java.io.IOException ioException1) {
                }
            }
        }
    }

    public final void a(com.google.android.play.core.assetpacks.j3 j3) {
        File file = this.a.C(j3.b, j3.c, j3.d, obj4);
        int i2 = 0;
        int i3 = 1;
        if (file.exists() == null) {
        } else {
            b(j3, file);
            File file2 = this.a.D(j3.b, j3.c, j3.d, obj8);
            if (file2.exists() == null) {
                file2.mkdirs();
            }
            if (file.renameTo(file2) == null) {
            } else {
            }
            Object[] arr = new Object[i3];
            arr[i2] = j3.e;
            g1 g1Var = new g1(String.format("Failed to move slice %s after verification.", arr), j3.a);
            throw g1Var;
        }
        Object[] arr2 = new Object[i3];
        arr2[i2] = j3.e;
        g1 g1Var2 = new g1(String.format("Cannot find unverified files for slice %s.", arr2), j3.a);
        throw g1Var2;
    }
}
