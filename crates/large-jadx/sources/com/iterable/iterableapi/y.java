package com.iterable.iterableapi;

/* compiled from: IterableInAppCloseAction.java */
/* loaded from: classes2.dex */
public enum y {

    BACK,
    LINK,
    OTHER;

    enum a extends y {
        @Override // com.iterable.iterableapi.y
        public String toString() {
            return "back";
        }
    }

    enum b extends y {
        @Override // com.iterable.iterableapi.y
        public String toString() {
            return "link";
        }
    }

    enum c extends y {
        @Override // com.iterable.iterableapi.y
        public String toString() {
            return "other";
        }
    }
}
