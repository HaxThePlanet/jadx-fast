package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.annotations.Encodable.Ignore;
import f.c.a.d.b.h.e;
import f.c.a.d.b.h.s;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class MessagingClientEventExtension {

    private static final com.google.firebase.messaging.reporting.MessagingClientEventExtension DEFAULT_INSTANCE;
    private final com.google.firebase.messaging.reporting.MessagingClientEvent messaging_client_event_;

    public static final class Builder {

        private com.google.firebase.messaging.reporting.MessagingClientEvent messaging_client_event_ = null;
        Builder() {
            super();
            final int i = 0;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEventExtension build() {
            MessagingClientEventExtension messagingClientEventExtension = new MessagingClientEventExtension(this.messaging_client_event_);
            return messagingClientEventExtension;
        }

        public com.google.firebase.messaging.reporting.MessagingClientEventExtension.Builder setMessagingClientEvent(com.google.firebase.messaging.reporting.MessagingClientEvent messagingClientEvent) {
            this.messaging_client_event_ = messagingClientEvent;
            return this;
        }
    }
    static {
        MessagingClientEventExtension.Builder builder = new MessagingClientEventExtension.Builder();
        MessagingClientEventExtension.DEFAULT_INSTANCE = builder.build();
    }

    MessagingClientEventExtension(com.google.firebase.messaging.reporting.MessagingClientEvent messagingClientEvent) {
        super();
        this.messaging_client_event_ = messagingClientEvent;
    }

    public static com.google.firebase.messaging.reporting.MessagingClientEventExtension getDefaultInstance() {
        return MessagingClientEventExtension.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.messaging.reporting.MessagingClientEventExtension.Builder newBuilder() {
        MessagingClientEventExtension.Builder builder = new MessagingClientEventExtension.Builder();
        return builder;
    }

    @Encodable$Ignore
    public com.google.firebase.messaging.reporting.MessagingClientEvent getMessagingClientEvent() {
        com.google.firebase.messaging.reporting.MessagingClientEvent messaging_client_event_;
        if (this.messaging_client_event_ == null) {
            messaging_client_event_ = MessagingClientEvent.getDefaultInstance();
        }
        return messaging_client_event_;
    }

    @Encodable$Field(name = "messagingClientEvent")
    public com.google.firebase.messaging.reporting.MessagingClientEvent getMessagingClientEventInternal() {
        return this.messaging_client_event_;
    }

    public byte[] toByteArray() {
        return e.c(this);
    }

    public void writeTo(OutputStream outputStream) {
        e.b(this, outputStream);
    }
}
