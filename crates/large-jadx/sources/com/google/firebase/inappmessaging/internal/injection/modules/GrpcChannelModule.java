package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import io.grpc.e;
import io.grpc.s0;

/* loaded from: classes2.dex */
@Module
public class GrpcChannelModule {
    @Provides
    public e providesGrpcChannel(String string) {
        return s0.b(string).a();
    }

    @Provides
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }
}
