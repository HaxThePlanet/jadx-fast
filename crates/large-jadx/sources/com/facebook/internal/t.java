package com.facebook.internal;

import kotlin.Metadata;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\u0002\u001a\u0004\u0008\u0006\u0010\t¨\u0006\u000e", d2 = {"Lcom/facebook/internal/InternalSettings;", "", "()V", "UNITY_PREFIX", "", "customUserAgent", "isUnityApp", "", "isUnityApp$annotations", "()Z", "getCustomUserAgent", "setCustomUserAgent", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class t {

    private static volatile String a;
    static {
    }

    public static final String a() {
        return t.a;
    }

    public static final boolean b() {
        String str;
        int i3;
        int i;
        int i2;
        String str2;
        str = t.a;
        final int i4 = 0;
        if (str != null && l.M(str, "Unity.", i4, 2, 0) == 1) {
            if (l.M(str, "Unity.", i4, 2, 0) == 1) {
            } else {
                i3 = i4;
            }
        } else {
        }
        return i3;
    }
}
