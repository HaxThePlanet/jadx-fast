package com.google.firebase.database.connection;

/* loaded from: classes2.dex */
public interface ListenHashProvider {
    public abstract com.google.firebase.database.connection.CompoundHash getCompoundHash();

    public abstract String getSimpleHash();

    public abstract boolean shouldIncludeCompoundHash();
}
