package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public class Constants {

    public static final ChildKey DOT_INFO = null;
    public static final ChildKey DOT_INFO_AUTHENTICATED = null;
    public static final ChildKey DOT_INFO_CONNECTED = null;
    public static final ChildKey DOT_INFO_SERVERTIME_OFFSET = null;
    public static final String WIRE_PROTOCOL_VERSION = "5";
    static {
        Constants.DOT_INFO = ChildKey.fromString(".info");
        Constants.DOT_INFO_SERVERTIME_OFFSET = ChildKey.fromString("serverTimeOffset");
        Constants.DOT_INFO_AUTHENTICATED = ChildKey.fromString("authenticated");
        Constants.DOT_INFO_CONNECTED = ChildKey.fromString("connected");
    }
}
