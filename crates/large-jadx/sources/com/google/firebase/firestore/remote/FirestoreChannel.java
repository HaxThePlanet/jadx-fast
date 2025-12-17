package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Util;
import io.grpc.a0;
import io.grpc.d1;
import io.grpc.d1.b;
import io.grpc.h;
import io.grpc.h.a;
import io.grpc.t0;
import io.grpc.t0.f;
import io.grpc.u0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FirestoreChannel {

    private static final t0.f<String> RESOURCE_PREFIX_HEADER;
    private static final t0.f<String> X_GOOG_API_CLIENT_HEADER;
    private static volatile String clientLanguage;
    private final CredentialsProvider<String> appCheckProvider;
    private final AsyncQueue asyncQueue;
    private final CredentialsProvider<User> authProvider;
    private final com.google.firebase.firestore.remote.GrpcCallProvider callProvider;
    private final com.google.firebase.firestore.remote.GrpcMetadataProvider metadataProvider;
    private final String resourcePrefixValue;
    static {
        io.grpc.t0.d dVar = t0.c;
        FirestoreChannel.X_GOOG_API_CLIENT_HEADER = t0.f.e("x-goog-api-client", dVar);
        FirestoreChannel.RESOURCE_PREFIX_HEADER = t0.f.e("google-cloud-resource-prefix", dVar);
        FirestoreChannel.clientLanguage = "gl-java/";
    }

    FirestoreChannel(AsyncQueue asyncQueue, Context context2, CredentialsProvider<User> credentialsProvider3, CredentialsProvider<String> credentialsProvider4, DatabaseInfo databaseInfo5, com.google.firebase.firestore.remote.GrpcMetadataProvider grpcMetadataProvider6) {
        super();
        this.asyncQueue = asyncQueue;
        this.metadataProvider = grpcMetadataProvider6;
        this.authProvider = credentialsProvider3;
        this.appCheckProvider = credentialsProvider4;
        FirestoreCallCredentials obj6 = new FirestoreCallCredentials(credentialsProvider3, credentialsProvider4);
        GrpcCallProvider obj3 = new GrpcCallProvider(asyncQueue, context2, databaseInfo5, obj6);
        this.callProvider = obj3;
        DatabaseId obj1 = databaseInfo5.getDatabaseId();
        Object[] obj2 = new Object[2];
        this.resourcePrefixValue = String.format("projects/%s/databases/%s", obj1.getProjectId(), obj1.getDatabaseId());
    }

    private void a(h[] hArr, com.google.firebase.firestore.remote.IncomingStreamObserver incomingStreamObserver2, j j3) {
        final int i = 0;
        hArr[i] = (h)j3.getResult();
        FirestoreChannel.1 anon = new FirestoreChannel.1(this, incomingStreamObserver2, hArr);
        hArr[i].start(anon, requestHeaders());
        incomingStreamObserver2.onOpen();
        hArr[i].request(1);
    }

    static AsyncQueue access$000(com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel) {
        return firestoreChannel.asyncQueue;
    }

    static FirebaseFirestoreException access$100(com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel, d1 d12) {
        return firestoreChannel.exceptionFromStatus(d12);
    }

    private void c(k k, Object object2, j j3) {
        final Object obj4 = j3.getResult();
        FirestoreChannel.4 anon = new FirestoreChannel.4(this, k);
        (h)obj4.start(anon, requestHeaders());
        obj4.request(2);
        obj4.sendMessage(object2);
        obj4.halfClose();
    }

    private void e(k k, Object object2, j j3) {
        final Object obj5 = j3.getResult();
        ArrayList arrayList = new ArrayList();
        FirestoreChannel.3 anon = new FirestoreChannel.3(this, arrayList, (h)obj5, k);
        obj5.start(anon, requestHeaders());
        obj5.request(1);
        obj5.sendMessage(object2);
        obj5.halfClose();
    }

    private FirebaseFirestoreException exceptionFromStatus(d1 d1) {
        if (Datastore.isMissingSslCiphers(d1)) {
            FirebaseFirestoreException firebaseFirestoreException = new FirebaseFirestoreException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", FirebaseFirestoreException.Code.fromValue(d1.n().value()), d1.m());
            return firebaseFirestoreException;
        }
        return Util.exceptionFromStatus(d1);
    }

    private String getGoogApiClientValue() {
        Object[] arr = new Object[2];
        return String.format("%s fire/%s grpc/", FirestoreChannel.clientLanguage, "24.0.0");
    }

    private t0 requestHeaders() {
        t0 t0Var = new t0();
        t0Var.o(FirestoreChannel.X_GOOG_API_CLIENT_HEADER, getGoogApiClientValue());
        t0Var.o(FirestoreChannel.RESOURCE_PREFIX_HEADER, this.resourcePrefixValue);
        com.google.firebase.firestore.remote.GrpcMetadataProvider metadataProvider = this.metadataProvider;
        if (metadataProvider != null) {
            metadataProvider.updateMetadata(t0Var);
        }
        return t0Var;
    }

    public static void setClientLanguage(String string) {
        FirestoreChannel.clientLanguage = string;
    }

    public void b(h[] hArr, com.google.firebase.firestore.remote.IncomingStreamObserver incomingStreamObserver2, j j3) {
        a(hArr, incomingStreamObserver2, j3);
    }

    public void d(k k, Object object2, j j3) {
        c(k, object2, j3);
    }

    public void f(k k, Object object2, j j3) {
        e(k, object2, j3);
    }

    public void invalidateToken() {
        this.authProvider.invalidateToken();
        this.appCheckProvider.invalidateToken();
    }

    <ReqT, RespT> h<ReqT, RespT> runBidiStreamingRpc(u0<ReqT, RespT> u0, com.google.firebase.firestore.remote.IncomingStreamObserver<RespT> incomingStreamObserver2) {
        h[] arr = new h[1];
        final j obj4 = this.callProvider.createClientCall(u0);
        n nVar = new n(this, arr, incomingStreamObserver2);
        obj4.addOnCompleteListener(this.asyncQueue.getExecutor(), nVar);
        FirestoreChannel.2 obj5 = new FirestoreChannel.2(this, arr, obj4);
        return obj5;
    }

    <ReqT, RespT> j<RespT> runRpc(u0<ReqT, RespT> u0, ReqT reqt2) {
        k kVar = new k();
        l lVar = new l(this, kVar, reqt2);
        this.callProvider.createClientCall(u0).addOnCompleteListener(this.asyncQueue.getExecutor(), lVar);
        return kVar.a();
    }

    <ReqT, RespT> j<List<RespT>> runStreamingResponseRpc(u0<ReqT, RespT> u0, ReqT reqt2) {
        k kVar = new k();
        m mVar = new m(this, kVar, reqt2);
        this.callProvider.createClientCall(u0).addOnCompleteListener(this.asyncQueue.getExecutor(), mVar);
        return kVar.a();
    }

    public void shutdown() {
        this.callProvider.shutdown();
    }
}
