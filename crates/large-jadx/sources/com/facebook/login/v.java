package com.facebook.login;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g0.c;
import kotlin.h0.c;
import kotlin.h0.f;
import kotlin.h0.g;
import kotlin.k0.h;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0008", d2 = {"Lcom/facebook/login/PKCEUtil;", "", "()V", "generateCodeVerifier", "", "isValidCodeVerifier", "", "codeVerifier", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class v {
    static {
    }

    public static final String a() {
        int i;
        int valueOf;
        f fVar = new f(43, 128);
        int i2 = g.j(fVar, c.b);
        c cVar = new c(97, 122);
        c cVar2 = new c(65, 90);
        c cVar3 = new c(48, 57);
        ArrayList arrayList = new ArrayList(i2);
        i = 0;
        while (i < i2) {
            arrayList.add(Character.valueOf((Character)p.v0(p.u0(p.u0(p.u0(p.u0(p.t0(p.r0(cVar, cVar2), cVar3), '-'), '.'), '_'), '~'), c.b).charValue()));
            i++;
        }
        return p.h0(arrayList, "", 0, 0, 0, 0, 0, 62, 0);
    }

    public static final boolean b(String string) {
        int length2;
        int length;
        int i;
        int i2 = 0;
        if (string != null) {
            if (string.length() == 0) {
                length2 = 1;
            } else {
                length2 = i2;
            }
        } else {
        }
        if (length2 == 0 && string.length() >= 43 && string.length() > 128) {
            if (string.length() >= 43) {
                if (string.length() > 128) {
                }
                h hVar = new h("^[-._~A-Za-z0-9]+$");
                return hVar.d(string);
            }
        }
        return i2;
    }
}
