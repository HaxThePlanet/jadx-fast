package com.google.firebase.inappmessaging;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;

/* loaded from: classes2.dex */
public enum EventType implements c0.c {

    UNKNOWN_EVENT_TYPE(false),
    IMPRESSION_EVENT_TYPE(true),
    CLICK_EVENT_TYPE(2);

    private final int value;

    private static final class EventTypeVerifier implements c0.e {

        static final c0.e INSTANCE;
        static {
            EventType.EventTypeVerifier eventTypeVerifier = new EventType.EventTypeVerifier();
            EventType.EventTypeVerifier.INSTANCE = eventTypeVerifier;
        }

        @Override // com.google.protobuf.c0$e
        public boolean isInRange(int i) {
            int obj1;
            obj1 = EventType.forNumber(i) != null ? 1 : 0;
            return obj1;
        }
    }
    public static com.google.firebase.inappmessaging.EventType forNumber(int i) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return EventType.CLICK_EVENT_TYPE;
            }
            return EventType.IMPRESSION_EVENT_TYPE;
        }
        return EventType.UNKNOWN_EVENT_TYPE;
    }

    public static c0.d<com.google.firebase.inappmessaging.EventType> internalGetValueMap() {
        return EventType.internalValueMap;
    }

    public static c0.e internalGetVerifier() {
        return EventType.EventTypeVerifier.INSTANCE;
    }

    @Deprecated
    public static com.google.firebase.inappmessaging.EventType valueOf(int i) {
        return EventType.forNumber(i);
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
