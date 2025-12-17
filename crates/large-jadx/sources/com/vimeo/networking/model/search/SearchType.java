package com.vimeo.networking.model.search;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public enum SearchType {

    VIDEO("clip"),
    VOD("ondemand"),
    USER("people"),
    CHANNEL("channel"),
    GROUP("group");

    private final String string;
    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }
}
