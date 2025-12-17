package com.google.firebase.database.core;

import com.google.firebase.emulators.EmulatedServiceSettings;
import java.net.URI;

/* loaded from: classes2.dex */
public final class RepoInfo {

    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    public String host;
    public String internalHost;
    public String namespace;
    public boolean secure;
    public void applyEmulatorSettings(EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings == null) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(emulatedServiceSettings.getHost());
        stringBuilder.append(":");
        stringBuilder.append(emulatedServiceSettings.getPort());
        String obj3 = stringBuilder.toString();
        this.host = obj3;
        this.internalHost = obj3;
        this.secure = false;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.database.core.RepoInfo> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (RepoInfo.class != object.getClass()) {
            } else {
                if (this.secure != object.secure) {
                    return i;
                }
                if (!this.host.equals(object.host)) {
                    return i;
                }
            }
            return this.namespace.equals(object.namespace);
        }
        return i;
    }

    public URI getConnectionURL(String string) {
        String str;
        String string2;
        StringBuilder stringBuilder;
        str = this.secure ? "wss" : "ws";
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("://");
        stringBuilder.append(this.internalHost);
        stringBuilder.append("/.ws?ns=");
        stringBuilder.append(this.namespace);
        stringBuilder.append("&");
        stringBuilder.append("v");
        stringBuilder.append("=");
        stringBuilder.append("5");
        if (string != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder.toString());
            stringBuilder.append("&ls=");
            stringBuilder.append(string);
            string2 = stringBuilder.toString();
        }
        return URI.create(string2);
    }

    public int hashCode() {
        return i4 += i6;
    }

    public boolean isCacheableHost() {
        return this.internalHost.startsWith("s-");
    }

    public boolean isCustomHost() {
        boolean contains;
        int i;
        String str;
        if (!this.host.contains(".firebaseio.com") && !this.host.contains(".firebaseio-demo.com")) {
            i = !this.host.contains(".firebaseio-demo.com") ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isDemoHost() {
        return this.host.contains(".firebaseio-demo.com");
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toDebugString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(host=");
        stringBuilder.append(this.host);
        stringBuilder.append(", secure=");
        stringBuilder.append(this.secure);
        stringBuilder.append(", ns=");
        stringBuilder.append(this.namespace);
        stringBuilder.append(" internal=");
        stringBuilder.append(this.internalHost);
        stringBuilder.append(")");
        return stringBuilder.toString();
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
