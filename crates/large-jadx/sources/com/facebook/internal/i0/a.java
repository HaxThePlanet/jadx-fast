package com.facebook.internal.i0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0007R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002¨\u0006\t", d2 = {"Lcom/facebook/internal/security/CertificateUtil;", "", "()V", "DELIMITER", "", "getDELIMITER$facebook_core_release$annotations", "getCertificateHash", "ctx", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {
    static {
    }

    public static final String a(Context context) {
        int i;
        int i2;
        String str;
        int obj6;
        n.f(context, "ctx");
        obj6 = obj6.signatures;
        StringBuilder stringBuilder = new StringBuilder();
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        i = 0;
        i2 = i;
        while (i2 < obj6.length) {
            instance.update(obj6[i2].toByteArray());
            stringBuilder.append(Base64.encodeToString(instance.digest(), i));
            stringBuilder.append(":");
            i2++;
        }
        int i4 = 1;
        if (stringBuilder.length() > 0) {
            i = i4;
        }
        try {
            if (i != 0) {
            }
            stringBuilder.setLength(obj6 -= i4);
            obj6 = stringBuilder.toString();
            n.e(obj6, "sb.toString()");
            return obj6;
            context = "";
            return context;
        }
    }
}
