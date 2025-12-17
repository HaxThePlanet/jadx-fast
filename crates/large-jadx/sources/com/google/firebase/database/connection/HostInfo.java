package com.google.firebase.database.connection;

import java.net.URI;

/* loaded from: classes2.dex */
public class HostInfo {

    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    private final String host;
    private final String namespace;
    private final boolean secure;
    public HostInfo(String string, String string2, boolean z3) {
        super();
        this.host = string;
        this.namespace = string2;
        this.secure = z3;
    }

    public static URI getConnectionUrl(String string, boolean z2, String string3, String string4) {
        String obj1;
        String obj2;
        obj2 = z2 ? "wss" : "ws";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj2);
        stringBuilder.append("://");
        stringBuilder.append(string);
        stringBuilder.append("/.ws?ns=");
        stringBuilder.append(string3);
        stringBuilder.append("&");
        stringBuilder.append("v");
        stringBuilder.append("=");
        stringBuilder.append("5");
        if (string4 != null) {
            obj2 = new StringBuilder();
            obj2.append(stringBuilder.toString());
            obj2.append("&ls=");
            obj2.append(string4);
            obj1 = obj2.toString();
        }
        return URI.create(obj1);
    }

    public String getHost() {
        return this.host;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http");
        str = this.secure ? "s" : "";
        stringBuilder.append(str);
        stringBuilder.append("://");
        stringBuilder.append(this.host);
        return stringBuilder.toString();
    }
}
