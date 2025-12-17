package com.vimeo.networking.model.playback;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class PlayProgress implements Serializable {

    private static final long serialVersionUID = -3745271302058282379L;
    public int mSeconds;
    @Override // java.io.Serializable
    public int getSeconds() {
        return this.mSeconds;
    }
}
