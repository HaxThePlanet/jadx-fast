package com.android.billingclient.api;

import android.os.Bundle;
import f.c.a.d.b.i.a;

/* loaded from: classes.dex */
final class y {
    static com.android.billingclient.api.g a(Bundle bundle, String string2, String string3) {
        boolean key;
        com.android.billingclient.api.g.a key2;
        boolean key3;
        com.android.billingclient.api.g obj8 = w.k;
        final int i = 0;
        final int i2 = 1;
        final String str = "BillingClient";
        if (bundle == null) {
            Object[] obj7 = new Object[i2];
            obj7[i] = string3;
            a.k(str, String.format("%s got null owned items list", obj7));
            return obj8;
        }
        int i3 = a.a(bundle, str);
        key2 = g.c();
        key2.c(i3);
        key2.b(a.h(bundle, str));
        if (i3 != 0) {
            obj7 = new Object[2];
            obj7[i] = string3;
            obj7[i2] = Integer.valueOf(i3);
            a.k(str, String.format("%s failed. Response code: %s", obj7));
            return key2.a();
        }
        String str2 = "INAPP_PURCHASE_ITEM_LIST";
        key = "INAPP_PURCHASE_DATA_LIST";
        if (bundle.containsKey(str2) && bundle.containsKey(key)) {
            key = "INAPP_PURCHASE_DATA_LIST";
            if (bundle.containsKey(key)) {
                key2 = "INAPP_DATA_SIGNATURE_LIST";
                if (!bundle.containsKey(key2)) {
                } else {
                    if (bundle.getStringArrayList(str2) == null) {
                        obj7 = new Object[i2];
                        obj7[i] = string3;
                        a.k(str, String.format("Bundle returned from %s contains null SKUs list.", obj7));
                        return obj8;
                    }
                    if (bundle.getStringArrayList(key) == null) {
                        obj7 = new Object[i2];
                        obj7[i] = string3;
                        a.k(str, String.format("Bundle returned from %s contains null purchases list.", obj7));
                        return obj8;
                    }
                    if (bundle.getStringArrayList(key2) == null) {
                        obj7 = new Object[i2];
                        obj7[i] = string3;
                        a.k(str, String.format("Bundle returned from %s contains null signatures list.", obj7));
                        return obj8;
                    }
                }
                return w.l;
            }
        }
        obj7 = new Object[i2];
        obj7[i] = string3;
        a.k(str, String.format("Bundle returned from %s doesn't contain required fields.", obj7));
        return obj8;
    }
}
