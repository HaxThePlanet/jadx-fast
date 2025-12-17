package com.facebook.login;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\n¨\u0006\u000b", d2 = {"Lcom/facebook/login/DefaultAudience;", "", "nativeProtocolAudience", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getNativeProtocolAudience", "()Ljava/lang/String;", "NONE", "ONLY_ME", "FRIENDS", "EVERYONE", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public enum c {

    NONE(false),
    ONLY_ME(false),
    FRIENDS(false),
    EVERYONE(false);

    private final String nativeProtocolAudience;
    @Override // java.lang.Enum
    public final String getNativeProtocolAudience() {
        return this.nativeProtocolAudience;
    }
}
