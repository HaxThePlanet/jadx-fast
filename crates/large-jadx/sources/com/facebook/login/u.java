package com.facebook.login;

import kotlin.Metadata;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007", d2 = {"Lcom/facebook/login/NonceUtil;", "", "()V", "isValidNonce", "", "nonce", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class u {
    static {
    }

    public static final boolean a(String string) {
        int i;
        int i2;
        int length;
        i = 0;
        final int i3 = 1;
        if (string != null) {
            if (string.length() == 0) {
                i2 = i3;
            } else {
                i2 = i;
            }
        } else {
        }
        if (i2 != 0) {
            return i;
        }
        if (l.d0(string, ' ', 0, false, 6, 0) >= 0) {
            i = i3;
        }
        return i ^ 1;
    }
}
