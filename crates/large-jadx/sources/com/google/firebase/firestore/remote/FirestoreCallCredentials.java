package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Logger;
import io.grpc.c;
import io.grpc.c.a;
import io.grpc.c.b;
import io.grpc.d1;
import io.grpc.t0;
import io.grpc.t0.f;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class FirestoreCallCredentials extends c {

    private static final t0.f<String> AUTHORIZATION_HEADER = null;
    private static final String LOG_TAG = "FirestoreCallCredentials";
    private static final t0.f<String> X_FIREBASE_APPCHECK;
    private final CredentialsProvider<String> appCheckProvider;
    private final CredentialsProvider<User> authProvider;
    static {
        io.grpc.t0.d dVar = t0.c;
        FirestoreCallCredentials.AUTHORIZATION_HEADER = t0.f.e("Authorization", dVar);
        FirestoreCallCredentials.X_FIREBASE_APPCHECK = t0.f.e("x-firebase-appcheck", dVar);
    }

    FirestoreCallCredentials(CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2) {
        super();
        this.authProvider = credentialsProvider;
        this.appCheckProvider = credentialsProvider2;
    }

    static void a(j j, c.a c$a2, j j3, j j4) {
        Object aUTHORIZATION_HEADER;
        Object stringBuilder;
        String str;
        Object obj6;
        String obj8;
        t0 obj9 = new t0();
        final int i = 1;
        final int i2 = 0;
        final String str2 = "FirestoreCallCredentials";
        if (j.isSuccessful()) {
            obj6 = j.getResult();
            Logger.debug(str2, "Successfully fetched auth token.", new Object[i2]);
            if ((String)obj6 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Bearer ");
                stringBuilder.append((String)obj6);
                obj9.o(FirestoreCallCredentials.AUTHORIZATION_HEADER, stringBuilder.toString());
            }
            if (j3.isSuccessful()) {
                obj6 = j3.getResult();
                if (obj6 != null && !(String)obj6.isEmpty()) {
                    if (!obj6.isEmpty()) {
                        Logger.debug(str2, "Successfully fetched AppCheck token.", new Object[i2]);
                        obj9.o(FirestoreCallCredentials.X_FIREBASE_APPCHECK, obj6);
                    }
                }
                a2.a(obj9);
            } else {
                obj6 = j3.getException();
                if (obj6 instanceof FirebaseApiNotAvailableException != null) {
                    Logger.debug(str2, "Firebase AppCheck API not available.", new Object[i2]);
                }
            }
            obj8 = new Object[i];
            obj8[i2] = obj6;
            Logger.warn(str2, "Failed to get AppCheck token: %s.", obj8);
            a2.b(d1.k.q(obj6));
        } else {
            obj6 = j.getException();
            if (obj6 instanceof FirebaseApiNotAvailableException != null) {
                Logger.debug(str2, "Firebase Auth API not available, not using authentication.", new Object[i2]);
            } else {
                if (obj6 instanceof FirebaseNoSignedInUserException != null) {
                    Logger.debug(str2, "No user signed in, not using authentication.", new Object[i2]);
                }
            }
        }
        obj8 = new Object[i];
        obj8[i2] = obj6;
        Logger.warn(str2, "Failed to get auth token: %s.", obj8);
        a2.b(d1.k.q(obj6));
    }

    @Override // io.grpc.c
    public void applyRequestMetadata(c.b c$b, Executor executor2, c.a c$a3) {
        j obj4 = this.authProvider.getToken();
        j token = this.appCheckProvider.getToken();
        j[] arr = new j[2];
        k kVar = new k(obj4, a3, token);
        m.g(obj4, token).addOnCompleteListener(executor2, kVar);
    }

    @Override // io.grpc.c
    public void thisUsesUnstableApi() {
    }
}
