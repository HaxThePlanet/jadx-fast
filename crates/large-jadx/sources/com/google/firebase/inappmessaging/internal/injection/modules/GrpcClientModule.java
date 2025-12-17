package com.google.firebase.inappmessaging.internal.injection.modules;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.common.io.BaseEncoding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import f.c.f.a.a.a.e.g;
import f.c.f.a.a.a.e.g.b;
import io.grpc.e;
import io.grpc.k;
import io.grpc.m1.e;
import io.grpc.t0;
import io.grpc.t0.f;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
@Module
public class GrpcClientModule {

    private final FirebaseApp firebaseApp;
    public GrpcClientModule(FirebaseApp firebaseApp) {
        super();
        this.firebaseApp = firebaseApp;
    }

    public static String getSignature(PackageManager packageManager, String string2) {
        int i;
        android.content.pm.PackageInfo obj2;
        String obj3;
        obj2 = packageManager.getPackageInfo(string2, 64);
        obj2 = obj2.signatures;
        obj3 = 0;
        if (obj2 != null && obj2 != null && obj2.length != 0 && obj2[obj3] == null) {
            obj2 = obj2.signatures;
            if (obj2 != null) {
                if (obj2.length != 0) {
                    try {
                        obj3 = 0;
                        if (obj2[obj3] == null) {
                        }
                        return GrpcClientModule.signatureDigest(obj2[obj3]);
                        return null;
                    }
                }
            }
        }
    }

    private static String signatureDigest(Signature signature) {
        return BaseEncoding.a().n().f(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
    }

    @Provides
    public t0 providesApiKeyHeaders() {
        io.grpc.t0.d dVar = t0.c;
        t0 t0Var = new t0();
        String packageName = this.firebaseApp.getApplicationContext().getPackageName();
        t0Var.o(t0.f.e("X-Goog-Api-Key", dVar), this.firebaseApp.getOptions().getApiKey());
        t0Var.o(t0.f.e("X-Android-Package", dVar), packageName);
        String signature = GrpcClientModule.getSignature(this.firebaseApp.getApplicationContext().getPackageManager(), packageName);
        if (signature != null) {
            t0Var.o(t0.f.e("X-Android-Cert", dVar), signature);
        }
        return t0Var;
    }

    @Provides
    public g.b providesInAppMessagingSdkServingStub(e e, t0 t02) {
        io.grpc.i[] arr = new i[1];
        return g.b(k.b(e, e.a(t02)));
    }
}
