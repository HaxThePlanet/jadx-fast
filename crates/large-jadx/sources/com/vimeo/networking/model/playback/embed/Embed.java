package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class Embed implements Serializable {

    private static final long serialVersionUID = -4708548576616330795L;
    @SerializedName("buttons")
    private com.vimeo.networking.model.playback.embed.EmbedButtons mButtons;
    @SerializedName("color")
    private String mColor;
    @SerializedName("html")
    private com.vimeo.networking.model.playback.embed.EmbedHtml mHtml;
    @SerializedName("playbar")
    private boolean mPlayBar;
    @SerializedName("title")
    private com.vimeo.networking.model.playback.embed.EmbedTitle mTitle;
    @SerializedName("uri")
    private String mUri;
    @SerializedName("volume")
    private boolean mVolume;
    @Override // java.io.Serializable
    public com.vimeo.networking.model.playback.embed.EmbedButtons getButtons() {
        return this.mButtons;
    }

    @Override // java.io.Serializable
    public String getColor() {
        return this.mColor;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.playback.embed.EmbedHtml getHtml() {
        return this.mHtml;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.playback.embed.EmbedTitle getTitle() {
        return this.mTitle;
    }

    @Override // java.io.Serializable
    public String getUri() {
        return this.mUri;
    }

    @Override // java.io.Serializable
    public boolean isPlayBar() {
        return this.mPlayBar;
    }

    @Override // java.io.Serializable
    public boolean isVolume() {
        return this.mVolume;
    }

    @Override // java.io.Serializable
    public void setButtons(com.vimeo.networking.model.playback.embed.EmbedButtons embedButtons) {
        this.mButtons = embedButtons;
    }

    @Override // java.io.Serializable
    public void setColor(String string) {
        this.mColor = string;
    }

    @Override // java.io.Serializable
    public void setPlayBar(boolean z) {
        this.mPlayBar = z;
    }

    @Override // java.io.Serializable
    public void setTitle(com.vimeo.networking.model.playback.embed.EmbedTitle embedTitle) {
        this.mTitle = embedTitle;
    }

    @Override // java.io.Serializable
    public void setVolume(boolean z) {
        this.mVolume = z;
    }
}
