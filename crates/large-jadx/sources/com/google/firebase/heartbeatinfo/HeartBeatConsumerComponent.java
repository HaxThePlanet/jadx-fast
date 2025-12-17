package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

/* loaded from: classes2.dex */
public class HeartBeatConsumerComponent {
    public static Component<?> create() {
        HeartBeatConsumerComponent.1 anon = new HeartBeatConsumerComponent.1();
        return Component.intoSet(anon, HeartBeatConsumer.class);
    }
}
