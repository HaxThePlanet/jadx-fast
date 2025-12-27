package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: EmbedTitle.java */
/* loaded from: classes2.dex */
public class EmbedTitle implements Serializable {

    private static final long serialVersionUID = -2543724237726304625L;
    @SerializedName("name")
    private String mName;
    @SerializedName("owner")
    private String mOwner;
    @SerializedName("portrait")
    private String mPortrait;
    public String getName() {
        return this.mName;
    }

    public String getOwner() {
        return this.mOwner;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setOwner(String str) {
        this.mOwner = str;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }
}
