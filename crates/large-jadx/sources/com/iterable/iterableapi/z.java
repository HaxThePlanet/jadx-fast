package com.iterable.iterableapi;

/* loaded from: classes2.dex */
public enum z {

    INBOX_SWIPE,
    DELETE_BUTTON,
    OTHER;

    enum a extends com.iterable.iterableapi.z {
        @Override // com.iterable.iterableapi.z
        public String toString() {
            return "inbox-swipe";
        }
    }

    enum b extends com.iterable.iterableapi.z {
        @Override // com.iterable.iterableapi.z
        public String toString() {
            return "delete-button";
        }
    }

    enum c extends com.iterable.iterableapi.z {
        @Override // com.iterable.iterableapi.z
        public String toString() {
            return "other";
        }
    }
}
