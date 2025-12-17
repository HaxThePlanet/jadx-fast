package com.google.firebase.firestore.remote;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.protobuf.z.a;
import f.c.e.c.c;
import f.c.e.c.c.b;
import f.c.e.c.e;
import f.c.e.c.e.b;
import f.c.e.c.f;
import f.c.e.c.o;
import io.grpc.d1;
import io.grpc.d1.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class Datastore {

    static final String SSL_DEPENDENCY_ERROR_MESSAGE = "The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.";
    static final Set<String> WHITE_LISTED_HEADERS;
    private final com.google.firebase.firestore.remote.FirestoreChannel channel;
    private final DatabaseInfo databaseInfo;
    private final com.google.firebase.firestore.remote.RemoteSerializer serializer;
    private final AsyncQueue workerQueue;
    static {
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        Datastore.WHITE_LISTED_HEADERS = hashSet;
    }

    public Datastore(DatabaseInfo databaseInfo, AsyncQueue asyncQueue2, CredentialsProvider<User> credentialsProvider3, CredentialsProvider<String> credentialsProvider4, Context context5, com.google.firebase.firestore.remote.GrpcMetadataProvider grpcMetadataProvider6) {
        super();
        this.databaseInfo = databaseInfo;
        this.workerQueue = asyncQueue2;
        RemoteSerializer remoteSerializer = new RemoteSerializer(databaseInfo.getDatabaseId());
        this.serializer = remoteSerializer;
        this.channel = initializeChannel(databaseInfo, asyncQueue2, credentialsProvider3, credentialsProvider4, context5, grpcMetadataProvider6);
    }

    private List a(j j) {
        boolean channel;
        FirebaseFirestoreException.Code uNAUTHENTICATED;
        int i;
        MutationResult decodeMutationResult;
        com.google.firebase.firestore.remote.RemoteSerializer serializer;
        if (!j.isSuccessful()) {
            if (exception instanceof FirebaseFirestoreException == null) {
            } else {
                if ((FirebaseFirestoreException)j.getException().getCode() != FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                } else {
                    this.channel.invalidateToken();
                }
            }
            throw j.getException();
        }
        Object obj7 = j.getResult();
        int i2 = obj7.f();
        ArrayList arrayList = new ArrayList(i2);
        i = 0;
        while (i < i2) {
            arrayList.add(this.serializer.decodeMutationResult(obj7.e(i), this.serializer.decodeVersion((f)obj7.c())));
            i++;
        }
        return arrayList;
    }

    private List c(List list, j j2) {
        boolean successful;
        FirebaseFirestoreException.Code decodeMaybeDocument;
        boolean next;
        DocumentKey key;
        if (!j2.isSuccessful() && exception instanceof FirebaseFirestoreException != null && (FirebaseFirestoreException)j2.getException().getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
            if (exception instanceof FirebaseFirestoreException != null) {
                if ((FirebaseFirestoreException)j2.getException().getCode() == FirebaseFirestoreException.Code.UNAUTHENTICATED) {
                    this.channel.invalidateToken();
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator obj5 = (List)j2.getResult().iterator();
        for (d next4 : obj5) {
            decodeMaybeDocument = this.serializer.decodeMaybeDocument(next4);
            hashMap.put(decodeMaybeDocument.getKey(), decodeMaybeDocument);
        }
        obj5 = new ArrayList();
        final Iterator obj4 = list.iterator();
        for (DocumentKey next3 : obj4) {
            obj5.add((MutableDocument)hashMap.get(next3));
        }
        return obj5;
    }

    public static boolean isMissingSslCiphers(d1 d1) {
        boolean equals;
        boolean str;
        d1.b uNAVAILABLE;
        int i;
        Throwable obj5;
        obj5 = d1.m();
        final int i2 = 0;
        if (obj5 instanceof SSLHandshakeException != null && obj5.getMessage().contains("no ciphers available")) {
            obj5 = obj5.getMessage().contains("no ciphers available") ? i : i2;
        } else {
        }
        if (Build.VERSION.SDK_INT < 21 && d1.n().equals(d1.b.UNAVAILABLE) && obj5 != null) {
            if (equals.equals(d1.b.UNAVAILABLE)) {
                if (obj5 != null) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isPermanentError(FirebaseFirestoreException.Code firebaseFirestoreException$Code) {
        switch (i) {
            case 1:
                IllegalArgumentException obj3 = new IllegalArgumentException("Treated status OK as error");
                throw obj3;
            case 2:
                return 0;
            case 3:
                return 1;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown gRPC status code: ");
                stringBuilder.append(code);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
        }
    }

    public static boolean isPermanentError(d1 d1) {
        return Datastore.isPermanentError(FirebaseFirestoreException.Code.fromValue(d1.n().value()));
    }

    public static boolean isPermanentWriteError(d1 d1) {
        boolean permanentError;
        d1 obj1;
        if (Datastore.isPermanentError(d1) && !d1.n().equals(d1.b.ABORTED)) {
            obj1 = !d1.n().equals(d1.b.ABORTED) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public List b(j j) {
        return a(j);
    }

    public j<List<MutationResult>> commit(List<Mutation> list) {
        String encodeMutation;
        com.google.firebase.firestore.remote.RemoteSerializer serializer;
        e.b bVar = e.f();
        bVar.c(this.serializer.databaseName());
        Iterator obj4 = list.iterator();
        for (Mutation next2 : obj4) {
            bVar.b(this.serializer.encodeMutation(next2));
        }
        i iVar = new i(this);
        return this.channel.runRpc(o.b(), (e)bVar.build()).continueWith(this.workerQueue.getExecutor(), iVar);
    }

    com.google.firebase.firestore.remote.WatchStream createWatchStream(com.google.firebase.firestore.remote.WatchStream.Callback watchStream$Callback) {
        WatchStream watchStream = new WatchStream(this.channel, this.workerQueue, this.serializer, callback);
        return watchStream;
    }

    com.google.firebase.firestore.remote.WriteStream createWriteStream(com.google.firebase.firestore.remote.WriteStream.Callback writeStream$Callback) {
        WriteStream writeStream = new WriteStream(this.channel, this.workerQueue, this.serializer, callback);
        return writeStream;
    }

    public List d(List list, j j2) {
        return c(list, j2);
    }

    DatabaseInfo getDatabaseInfo() {
        return this.databaseInfo;
    }

    AsyncQueue getWorkerQueue() {
        return this.workerQueue;
    }

    com.google.firebase.firestore.remote.FirestoreChannel initializeChannel(DatabaseInfo databaseInfo, AsyncQueue asyncQueue2, CredentialsProvider<User> credentialsProvider3, CredentialsProvider<String> credentialsProvider4, Context context5, com.google.firebase.firestore.remote.GrpcMetadataProvider grpcMetadataProvider6) {
        super(asyncQueue2, context5, credentialsProvider3, credentialsProvider4, databaseInfo, grpcMetadataProvider6);
        return firestoreChannel2;
    }

    public j<List<MutableDocument>> lookup(List<DocumentKey> list) {
        String encodeKey;
        com.google.firebase.firestore.remote.RemoteSerializer serializer;
        c.b bVar = c.h();
        bVar.c(this.serializer.databaseName());
        Iterator iterator = list.iterator();
        for (DocumentKey next2 : iterator) {
            bVar.b(this.serializer.encodeKey(next2));
        }
        j jVar = new j(this, list);
        return this.channel.runStreamingResponseRpc(o.a(), (c)bVar.build()).continueWith(this.workerQueue.getExecutor(), jVar);
    }

    void shutdown() {
        this.channel.shutdown();
    }
}
