package com.appsflyer.internal;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.c;
import com.android.billingclient.api.g;
import com.android.billingclient.api.k;
import com.android.billingclient.api.l;
import com.android.billingclient.api.l.a;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class at implements k {

    private com.appsflyer.internal.ax AFInAppEventParameterName;
    at(com.appsflyer.internal.ax ax) {
        this.AFInAppEventParameterName = ax;
        super();
    }

    public final void onPurchasesUpdated(g g, List<Purchase> list2) {
        String sku;
        com.appsflyer.internal.ax aFInAppEventParameterName = this.AFInAppEventParameterName;
        if (g.b() == 0) {
            if (list2 == null) {
                try {
                    if (aFInAppEventParameterName.values == null) {
                    }
                    AFLogger.init("Got Ars billing callback but billing client is missing!");
                    ArrayList obj4 = new ArrayList();
                    Iterator iterator = list2.iterator();
                    for (Purchase next2 : iterator) {
                        obj4.add(next2.getSku());
                    }
                    obj4.add((Purchase)iterator.next().getSku());
                    l.a aVar = l.c();
                    aVar.c("subs");
                    aVar.b(obj4);
                    ax.1 anon = new ax.1(aFInAppEventParameterName, list2);
                    aFInAppEventParameterName.values.j(aVar.a(), anon);
                    StringBuilder obj5 = new StringBuilder("Failed to setup Ars Play billing service: ");
                    obj5.append(g.b());
                    obj5.append(" ");
                    obj5.append(g.a());
                    AFLogger.init(obj5.toString());
                    list2 = g instanceof NoSuchMethodError;
                    if (list2 == null) {
                    } else {
                    }
                    list2 = g instanceof NoClassDefFoundError;
                    if (list2 != null) {
                    }
                    list2 = "It seems your app uses different Play Billing library version than the SDK. Please use v.3.0.3";
                    AFLogger.init(list2);
                    list2 = "Failed to query new purchase details";
                    AFLogger.AFInAppEventType(list2, g);
                }
            } else {
            }
        }
    }
}
