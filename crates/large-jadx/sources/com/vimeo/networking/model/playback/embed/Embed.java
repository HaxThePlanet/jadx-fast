package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: Embed.java */
/* loaded from: classes2.dex */
public class Embed implements Serializable {

    private static final long serialVersionUID = -4708548576616330795L;
    @SerializedName("buttons")
    private EmbedButtons mButtons;
    @SerializedName("color")
    private String mColor;
    @SerializedName("html")
    private EmbedHtml mHtml;
    @SerializedName("playbar")
    private boolean mPlayBar;
    @SerializedName("title")
    private EmbedTitle mTitle;
    @SerializedName("uri")
    private String mUri;
    @SerializedName("volume")
    private boolean mVolume;
    public EmbedButtons getButtons() {
        return this.mButtons;
    }

    public String getColor() {
        return this.mColor;
    }

    public EmbedHtml getHtml() {
        return this.mHtml;
    }

    public EmbedTitle getTitle() {
        return this.mTitle;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isPlayBar() {
        return this.mPlayBar;
    }

    public boolean isVolume() {
        return this.mVolume;
    }

    public void setButtons(EmbedButtons embedButtons) {
        this.mButtons = embedButtons;
    }

    public void setColor(String str) {
        this.mColor = str;
    }

    public void setPlayBar(boolean z) {
        this.mPlayBar = z;
    }

    public void setTitle(EmbedTitle embedTitle) {
        this.mTitle = embedTitle;
    }

    public void setVolume(boolean z) {
        this.mVolume = z;
    }
}
