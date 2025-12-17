package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;
import kotlin.y.q0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000cj\u0008\u0012\u0004\u0012\u00020\u0004`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lcom/facebook/internal/FacebookSignatureValidator;", "", "()V", "FBF_HASH", "", "FBI_HASH", "FBL_HASH", "FBR2_HASH", "FBR_HASH", "IGR_HASH", "MSR_HASH", "validAppSignatureHashes", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "validateSignature", "", "context", "Landroid/content/Context;", "packageName", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class j {

    private static final HashSet<String> a;
    static {
        j.a = q0.c(/* result */);
    }

    public static final boolean a(Context context, String string2) {
        int str2;
        boolean z;
        int i;
        int flags;
        int i2;
        int str;
        android.content.pm.PackageInfo obj7;
        int obj8;
        str2 = "packageInfo.signatures";
        n.f(context, "context");
        n.f(string2, "packageName");
        String bRAND = Build.BRAND;
        n.e(bRAND, "brand");
        i2 = 0;
        int i3 = 1;
        if (l.M(bRAND, "generic", i2, 2, 0) && flags & 2 != 0) {
            if (flags & 2 != 0) {
                return i3;
            }
        }
        obj7 = context.getPackageManager().getPackageInfo(string2, 64);
        obj8 = obj7.signatures;
        if (obj8 != null) {
            n.e(obj8, str2);
            obj8 = obj8.length == 0 ? i3 : i2;
            if (obj8 != null) {
            } else {
                obj7 = obj7.signatures;
                n.e(obj7, str2);
                str2 = i2;
                while (str2 < obj7.length) {
                    byte[] byteArray = obj7[str2].toByteArray();
                    n.e(byteArray, "it.toByteArray()");
                    str2++;
                }
                i2 = i3;
            }
        }
        return i2;
    }
}
