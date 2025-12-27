package com.iterable.iterableapi;

/* compiled from: IterableInAppDeleteActionType.java */
/* loaded from: classes2.dex */
public enum z {

    DELETE_BUTTON,
    INBOX_SWIPE,
    OTHER;

    enum a extends z {
        @Override // com.iterable.iterableapi.z
        public String toString() {
            return "inbox-swipe";
        }
    }

    enum b extends z {
        @Override // com.iterable.iterableapi.z
        public String toString() {
            return "delete-button";
        }
    }

    enum c extends z {
        @Override // com.iterable.iterableapi.z
        public String toString() {
            return "other";
        }
    }
}
