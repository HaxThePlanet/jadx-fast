package com.iterable.iterableapi;

/* compiled from: IterableInAppLocation.java */
/* loaded from: classes2.dex */
public enum e0 {

    INBOX,
    IN_APP;

    enum a extends e0 {
        @Override // com.iterable.iterableapi.e0
        public String toString() {
            return "in-app";
        }
    }

    enum b extends e0 {
        @Override // com.iterable.iterableapi.e0
        public String toString() {
            return "inbox";
        }
    }
}
