package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: EmbedLogos.java */
/* loaded from: classes2.dex */
public class EmbedLogos implements Serializable {

    private static final long serialVersionUID = -6946192139468749658L;
    @SerializedName("custom")
    private EmbedCustomLogos mCustom;
    @SerializedName("vimeo")
    private boolean mVimeoLogoVisible;
    public EmbedCustomLogos getCustom() {
        return this.mCustom;
    }

    public boolean isVimeoLogoVisible() {
        return this.mVimeoLogoVisible;
    }

    public void setCustom(EmbedCustomLogos embedCustomLogos) {
        this.mCustom = embedCustomLogos;
    }

    public void setVimeoLogo(boolean z) {
        this.mVimeoLogoVisible = z;
    }
}
