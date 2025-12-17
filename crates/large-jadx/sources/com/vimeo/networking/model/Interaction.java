package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class Interaction implements Serializable {

    private static final String STREAM_AVAILABLE = "available";
    private static final String STREAM_PURCHASED = "purchased";
    private static final String STREAM_RESTRICTED = "restricted";
    private static final String STREAM_UNAVAILABLE = "unavailable";
    private static final long serialVersionUID = 2033767841952340400L;
    public boolean added;
    public Date addedTime;
    public Date expiration;
    public com.vimeo.networking.model.Interaction.Stream stream;
    public String uri;

    public static enum Stream {

        PURCHASED("purchased"),
        RESTRICTED("restricted"),
        AVAILABLE("available"),
        UNAVAILABLE("unavailable");

        private final String mName;
        @Override // java.lang.Enum
        public String toString() {
            return this.mName;
        }
    }
}
