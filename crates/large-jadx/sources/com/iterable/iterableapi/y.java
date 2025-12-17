package com.iterable.iterableapi;

/* loaded from: classes2.dex */
public enum y {

    BACK,
    LINK,
    OTHER;

    enum a extends com.iterable.iterableapi.y {
        @Override // com.iterable.iterableapi.y
        public String toString() {
            return "back";
        }
    }

    enum b extends com.iterable.iterableapi.y {
        @Override // com.iterable.iterableapi.y
        public String toString() {
            return "link";
        }
    }

    enum c extends com.iterable.iterableapi.y {
        @Override // com.iterable.iterableapi.y
        public String toString() {
            return "other";
        }
    }
}
