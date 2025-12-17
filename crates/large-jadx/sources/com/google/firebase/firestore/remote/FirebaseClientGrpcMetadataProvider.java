package com.google.firebase.firestore.remote;

import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import io.grpc.t0;
import io.grpc.t0.f;

/* loaded from: classes2.dex */
public class FirebaseClientGrpcMetadataProvider implements com.google.firebase.firestore.remote.GrpcMetadataProvider {

    private static final t0.f<String> GMP_APP_ID_HEADER = null;
    private static final t0.f<String> HEART_BEAT_HEADER = null;
    private static final String HEART_BEAT_TAG = "fire-fst";
    private static final t0.f<String> USER_AGENT_HEADER;
    private final FirebaseOptions firebaseOptions;
    private final Provider<HeartBeatInfo> heartBeatInfoProvider;
    private final Provider<UserAgentPublisher> userAgentPublisherProvider;
    static {
        io.grpc.t0.d dVar = t0.c;
        FirebaseClientGrpcMetadataProvider.HEART_BEAT_HEADER = t0.f.e("x-firebase-client-log-type", dVar);
        FirebaseClientGrpcMetadataProvider.USER_AGENT_HEADER = t0.f.e("x-firebase-client", dVar);
        FirebaseClientGrpcMetadataProvider.GMP_APP_ID_HEADER = t0.f.e("x-firebase-gmpid", dVar);
    }

    public FirebaseClientGrpcMetadataProvider(Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseOptions firebaseOptions3) {
        super();
        this.userAgentPublisherProvider = provider;
        this.heartBeatInfoProvider = provider2;
        this.firebaseOptions = firebaseOptions3;
    }

    private void maybeAddGmpAppId(t0 t0) {
        int gMP_APP_ID_HEADER;
        FirebaseOptions firebaseOptions = this.firebaseOptions;
        if (firebaseOptions == null) {
        }
        String applicationId = firebaseOptions.getApplicationId();
        if (applicationId.length() != 0) {
            t0.o(FirebaseClientGrpcMetadataProvider.GMP_APP_ID_HEADER, applicationId);
        }
    }

    @Override // com.google.firebase.firestore.remote.GrpcMetadataProvider
    public void updateMetadata(t0 t0) {
        int string;
        Object uSER_AGENT_HEADER;
        Object hEART_BEAT_HEADER;
        String userAgent;
        if (this.heartBeatInfoProvider.get() != null) {
            if (this.userAgentPublisherProvider.get() == null) {
            } else {
                string = (HeartBeatInfo)this.heartBeatInfoProvider.get().getHeartBeatCode("fire-fst").getCode();
                if (string != null) {
                    t0.o(FirebaseClientGrpcMetadataProvider.HEART_BEAT_HEADER, Integer.toString(string));
                }
                t0.o(FirebaseClientGrpcMetadataProvider.USER_AGENT_HEADER, (UserAgentPublisher)this.userAgentPublisherProvider.get().getUserAgent());
                maybeAddGmpAppId(t0);
            }
        }
    }
}
