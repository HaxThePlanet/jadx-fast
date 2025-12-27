package com.vimeo.networking.model.search;

import com.google.gson.annotations.SerializedName;

/* compiled from: SearchType.java */
/* loaded from: classes2.dex */
public enum SearchType {

    CHANNEL,
    GROUP,
    USER,
    VIDEO,
    VOD;

    private final String string;
    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }
}
