package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class EmbedTitle implements Serializable {

    private static final long serialVersionUID = -2543724237726304625L;
    @SerializedName("name")
    private String mName;
    @SerializedName("owner")
    private String mOwner;
    @SerializedName("portrait")
    private String mPortrait;
    @Override // java.io.Serializable
    public String getName() {
        return this.mName;
    }

    @Override // java.io.Serializable
    public String getOwner() {
        return this.mOwner;
    }

    @Override // java.io.Serializable
    public String getPortrait() {
        return this.mPortrait;
    }

    @Override // java.io.Serializable
    public void setName(String string) {
        this.mName = string;
    }

    @Override // java.io.Serializable
    public void setOwner(String string) {
        this.mOwner = string;
    }

    @Override // java.io.Serializable
    public void setPortrait(String string) {
        this.mPortrait = string;
    }
}
