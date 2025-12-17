package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public interface FirebaseRemoteConfigValue {
    public abstract boolean asBoolean();

    public abstract byte[] asByteArray();

    public abstract double asDouble();

    public abstract long asLong();

    public abstract String asString();

    public abstract int getSource();
}
