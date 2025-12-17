package com.facebook.e0;

import com.facebook.a;
import com.facebook.internal.b0;
import com.facebook.o;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u000fH\u0002R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\n¨\u0006\u0015", d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair;", "Ljava/io/Serializable;", "accessToken", "Lcom/facebook/AccessToken;", "(Lcom/facebook/AccessToken;)V", "accessTokenString", "", "applicationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessTokenString", "()Ljava/lang/String;", "getApplicationId", "equals", "", "o", "", "hashCode", "", "writeReplace", "Companion", "SerializationProxyV1", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String accessTokenString;
    private final String applicationId;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008B\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lcom/facebook/appevents/AccessTokenAppIdPair$SerializationProxyV1;", "Ljava/io/Serializable;", "accessTokenString", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Serializable {

        private static final long serialVersionUID = -2488473066578201069L;
        private final String accessTokenString;
        private final String appId;
        static {
        }

        public a(String string, String string2) {
            n.f(string2, "appId");
            super();
            this.accessTokenString = string;
            this.appId = string2;
        }

        private final Object readResolve() {
            a aVar = new a(this.accessTokenString, this.appId);
            return aVar;
        }
    }
    static {
    }

    public a(a a) {
        n.f(a, "accessToken");
        super(a.m(), o.g());
    }

    public a(String string, String string2) {
        String obj2;
        n.f(string2, "applicationId");
        super();
        this.applicationId = string2;
        obj2 = b0.W(string) ? 0 : obj2;
        this.accessTokenString = obj2;
    }

    private final Object writeReplace() {
        a.a aVar = new a.a(this.accessTokenString, this.applicationId);
        return aVar;
    }

    @Override // java.io.Serializable
    public final String a() {
        return this.accessTokenString;
    }

    @Override // java.io.Serializable
    public final String b() {
        return this.applicationId;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        boolean applicationId;
        int i;
        Object obj4;
        if (!object instanceof a) {
            return 0;
        }
        if (b0.c(object.accessTokenString, this.accessTokenString) && b0.c(object.applicationId, this.applicationId)) {
            if (b0.c(object.applicationId, this.applicationId)) {
                i = 1;
            }
        }
        return i;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        String accessTokenString = this.accessTokenString;
        if (accessTokenString != null) {
            i = accessTokenString.hashCode();
        } else {
            i = 0;
        }
        return i ^= i3;
    }
}
