package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class ExistenceFilter {

    private final int count;
    public ExistenceFilter(int i) {
        super();
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExistenceFilter{count=");
        stringBuilder.append(this.count);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
