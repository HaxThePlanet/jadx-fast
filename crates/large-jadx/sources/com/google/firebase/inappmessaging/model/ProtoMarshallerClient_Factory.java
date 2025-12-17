package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ProtoMarshallerClient_Factory implements Factory<com.google.firebase.inappmessaging.model.ProtoMarshallerClient> {

    private static final class InstanceHolder {

        private static final com.google.firebase.inappmessaging.model.ProtoMarshallerClient_Factory INSTANCE;
        static {
            ProtoMarshallerClient_Factory protoMarshallerClient_Factory = new ProtoMarshallerClient_Factory();
            ProtoMarshallerClient_Factory.InstanceHolder.INSTANCE = protoMarshallerClient_Factory;
        }

        static com.google.firebase.inappmessaging.model.ProtoMarshallerClient_Factory access$000() {
            return ProtoMarshallerClient_Factory.InstanceHolder.INSTANCE;
        }
    }
    public static com.google.firebase.inappmessaging.model.ProtoMarshallerClient_Factory create() {
        return ProtoMarshallerClient_Factory.InstanceHolder.access$000();
    }

    public static com.google.firebase.inappmessaging.model.ProtoMarshallerClient newInstance() {
        ProtoMarshallerClient protoMarshallerClient = new ProtoMarshallerClient();
        return protoMarshallerClient;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.model.ProtoMarshallerClient get() {
        return ProtoMarshallerClient_Factory.newInstance();
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
