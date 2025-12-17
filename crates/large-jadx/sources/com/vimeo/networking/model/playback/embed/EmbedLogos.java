package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class EmbedLogos implements Serializable {

    private static final long serialVersionUID = -6946192139468749658L;
    @SerializedName("custom")
    private com.vimeo.networking.model.playback.embed.EmbedCustomLogos mCustom;
    @SerializedName("vimeo")
    private boolean mVimeoLogoVisible;
    @Override // java.io.Serializable
    public com.vimeo.networking.model.playback.embed.EmbedCustomLogos getCustom() {
        return this.mCustom;
    }

    @Override // java.io.Serializable
    public boolean isVimeoLogoVisible() {
        return this.mVimeoLogoVisible;
    }

    @Override // java.io.Serializable
    public void setCustom(com.vimeo.networking.model.playback.embed.EmbedCustomLogos embedCustomLogos) {
        this.mCustom = embedCustomLogos;
    }

    @Override // java.io.Serializable
    public void setVimeoLogo(boolean z) {
        this.mVimeoLogoVisible = z;
    }
}
