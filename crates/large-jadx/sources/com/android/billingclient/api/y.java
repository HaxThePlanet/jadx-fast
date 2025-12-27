package com.android.billingclient.api;

import android.os.Bundle;
import f.c.a.d.b.i.a;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
final class y {
    static g a(Bundle bundle, String str, String str2) {
        com.android.billingclient.api.g gVar3 = w.k;
        final int i = 0;
        final int i2 = 1;
        str = "BillingClient";
        if (bundle == null) {
            Object[] arr = new Object[i2];
            a.k(str, String.format("%s got null owned items list", new Object[] { str2 }));
            return w.k;
        }
        int i3 = a.a(bundle, str);
        com.android.billingclient.api.g.a aVar = g.c();
        aVar.c(i3);
        aVar.b(a.h(bundle, str));
        if (i3 != 0) {
            Object[] arr2 = new Object[2];
            a.k(str, String.format("%s failed. Response code: %s", new Object[] { str2, Integer.valueOf(i3) }));
            return aVar.a();
        }
        String str4 = "INAPP_PURCHASE_ITEM_LIST";
        if (bundle.containsKey(str4)) {
            String str6 = "INAPP_PURCHASE_DATA_LIST";
            if (bundle.containsKey(str6)) {
                String str7 = "INAPP_DATA_SIGNATURE_LIST";
                if (bundle.containsKey(str7)) {
                    if (bundle.getStringArrayList(str4) == null) {
                        Object[] arr4 = new Object[i2];
                        a.k(str, String.format("Bundle returned from %s contains null SKUs list.", new Object[] { str2 }));
                        return w.k;
                    }
                    if (bundle.getStringArrayList(str6) == null) {
                        Object[] arr5 = new Object[i2];
                        a.k(str, String.format("Bundle returned from %s contains null purchases list.", new Object[] { str2 }));
                        return w.k;
                    }
                    if (bundle.getStringArrayList(str7) == null) {
                        Object[] arr6 = new Object[i2];
                        a.k(str, String.format("Bundle returned from %s contains null signatures list.", new Object[] { str2 }));
                        return w.k;
                    }
                }
                return w.l;
            }
        }
        Object[] arr3 = new Object[i2];
        a.k(str, String.format("Bundle returned from %s doesn't contain required fields.", new Object[] { str2 }));
        return w.k;
    }
}
