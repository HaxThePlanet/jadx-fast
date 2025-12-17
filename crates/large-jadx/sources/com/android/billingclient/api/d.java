package com.android.billingclient.api;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import f.c.a.d.b.i.a;
import f.c.a.d.b.i.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class d extends com.android.billingclient.api.c {

    private volatile int a;
    private final String b;
    private final Handler c;
    private volatile com.android.billingclient.api.f0 d;
    private Context e;
    private volatile d f;
    private volatile com.android.billingclient.api.s g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private ExecutorService t;
    private d(Context context, boolean z2, com.android.billingclient.api.k k3, String string4, String string5) {
        super();
        final int obj7 = 0;
        this.a = obj7;
        Handler handler = new Handler(Looper.getMainLooper());
        this.c = handler;
        this.j = obj7;
        this.b = string4;
        l(context, k3, z2);
    }

    d(String string, boolean z2, Context context3, com.android.billingclient.api.k k4) {
        Object obj7;
        try {
            obj7 = Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(0);
            string = "4.0.0";
            super(context3, z2, k4, obj7, 0);
        }
    }

    static Handler A(com.android.billingclient.api.d d) {
        return d.p();
    }

    static com.android.billingclient.api.t B(com.android.billingclient.api.d d, String string2) {
        String concat3;
        ArrayList arrayList;
        String empty;
        String concat2;
        Object str2;
        com.android.billingclient.api.g length;
        Object stringArrayList;
        Object obj;
        int string;
        Bundle bundle;
        com.android.billingclient.api.PurchaseHistoryRecord purchaseHistoryRecord;
        String concat;
        String str;
        int length2;
        com.android.billingclient.api.t obj14;
        Object obj15;
        String valueOf = String.valueOf(string2);
        String str4 = "Querying purchase history, item type: ";
        if (valueOf.length() != 0) {
            concat3 = str4.concat(valueOf);
        } else {
            concat3 = new String(str4);
        }
        String str3 = "BillingClient";
        a.j(str3, concat3);
        arrayList = new ArrayList();
        int i = 0;
        string = i;
        while (!d.k) {
            empty = d.f.P(6, d.e.getPackageName(), string2, string, a.f(d.m, d.s, d.b));
            str2 = y.a(empty, str3, "getPurchaseHistory()");
            if (str2 != w.l) {
                break;
            } else {
            }
            ArrayList stringArrayList3 = empty.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            obj = 0;
            while (obj < stringArrayList3.size()) {
                String valueOf3 = String.valueOf((String)empty.getStringArrayList("INAPP_PURCHASE_ITEM_LIST").get(obj));
                str = "Purchase record found for sku : ";
                if (valueOf3.length() != 0) {
                } else {
                }
                concat = new String(str);
                a.j(str3, concat);
                purchaseHistoryRecord = new PurchaseHistoryRecord((String)stringArrayList3.get(obj), (String)empty.getStringArrayList("INAPP_DATA_SIGNATURE_LIST").get(obj));
                if (TextUtils.isEmpty(purchaseHistoryRecord.c())) {
                }
                arrayList.add(purchaseHistoryRecord);
                obj++;
                a.k(str3, "BUG: empty/null token!");
                concat = str.concat(valueOf3);
            }
            string = empty.getString("INAPP_CONTINUATION_TOKEN");
            String valueOf2 = String.valueOf(string);
            str2 = "Continuation token: ";
            if (valueOf2.length() != 0) {
            } else {
            }
            concat2 = new String(str2);
            a.j(str3, concat2);
            concat2 = str2.concat(valueOf2);
            valueOf3 = String.valueOf((String)stringArrayList2.get(obj));
            str = "Purchase record found for sku : ";
            if (valueOf3.length() != 0) {
            } else {
            }
            concat = new String(str);
            a.j(str3, concat);
            purchaseHistoryRecord = new PurchaseHistoryRecord((String)stringArrayList3.get(obj), (String)stringArrayList.get(obj));
            if (TextUtils.isEmpty(purchaseHistoryRecord.c())) {
            }
            arrayList.add(purchaseHistoryRecord);
            obj++;
            a.k(str3, "BUG: empty/null token!");
            concat = str.concat(valueOf3);
        }
        a.k(str3, "getPurchaseHistory is not supported on current device");
        obj14 = new t(w.i, i);
        return obj14;
    }

    static com.android.billingclient.api.g C(com.android.billingclient.api.d d) {
        return d.r();
    }

    static com.android.billingclient.api.Purchase.a D(com.android.billingclient.api.d d, String string2) {
        String concat;
        ArrayList arrayList;
        String empty;
        String string;
        String str2;
        int i;
        int length;
        String packageName;
        ArrayList stringArrayList;
        int i2;
        int string3;
        Bundle bundle;
        com.android.billingclient.api.Purchase purchase;
        String concat2;
        String str;
        int length2;
        com.android.billingclient.api.Purchase.a obj14;
        Object obj15;
        String valueOf = String.valueOf(string2);
        String str4 = "Querying owned items, item type: ";
        if (valueOf.length() != 0) {
            concat = str4.concat(valueOf);
        } else {
            concat = new String(str4);
        }
        String str3 = "BillingClient";
        a.j(str3, concat);
        arrayList = new ArrayList();
        int i3 = 0;
        string3 = i3;
        while (d.m) {
            empty = d.f.U1(9, d.e.getPackageName(), string2, string3, a.f(d.m, d.s, d.b));
            str2 = y.a(empty, str3, "getPurchase()");
            if (str2 != w.l) {
                break;
            } else {
            }
            ArrayList stringArrayList3 = empty.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            i2 = 0;
            while (i2 < stringArrayList3.size()) {
                String valueOf3 = String.valueOf((String)empty.getStringArrayList("INAPP_PURCHASE_ITEM_LIST").get(i2));
                str = "Sku is owned: ";
                if (valueOf3.length() != 0) {
                } else {
                }
                concat2 = new String(str);
                a.j(str3, concat2);
                purchase = new Purchase((String)stringArrayList3.get(i2), (String)empty.getStringArrayList("INAPP_DATA_SIGNATURE_LIST").get(i2));
                if (TextUtils.isEmpty(purchase.e())) {
                }
                arrayList.add(purchase);
                i2++;
                a.k(str3, "BUG: empty/null token!");
                concat2 = str.concat(valueOf3);
            }
            string3 = empty.getString("INAPP_CONTINUATION_TOKEN");
            String valueOf2 = String.valueOf(string3);
            str2 = "Continuation token: ";
            if (valueOf2.length() != 0) {
            } else {
            }
            string = new String(str2);
            a.j(str3, string);
            empty = d.f.o0(3, d.e.getPackageName(), string2, string3);
            string = str2.concat(valueOf2);
            valueOf3 = String.valueOf((String)stringArrayList2.get(i2));
            str = "Sku is owned: ";
            if (valueOf3.length() != 0) {
            } else {
            }
            concat2 = new String(str);
            a.j(str3, concat2);
            purchase = new Purchase((String)stringArrayList3.get(i2), (String)stringArrayList.get(i2));
            if (TextUtils.isEmpty(purchase.e())) {
            }
            arrayList.add(purchase);
            i2++;
            a.k(str3, "BUG: empty/null token!");
            concat2 = str.concat(valueOf3);
        }
        obj14 = new Purchase.a(str2, i3);
        return obj14;
    }

    static d E(com.android.billingclient.api.d d) {
        return d.f;
    }

    static d F(com.android.billingclient.api.d d, d d2) {
        d.f = d2;
        return d2;
    }

    static Future K(com.android.billingclient.api.d d, Callable callable2, long l3, Runnable runnable4, Handler handler5) {
        return d.t(callable2, 30000, obj3, handler5);
    }

    static boolean M(com.android.billingclient.api.d d, boolean z2) {
        d.h = z2;
        return z2;
    }

    static boolean N(com.android.billingclient.api.d d, boolean z2) {
        d.r = z2;
        return z2;
    }

    static boolean O(com.android.billingclient.api.d d, boolean z2) {
        d.q = z2;
        return z2;
    }

    static boolean P(com.android.billingclient.api.d d, boolean z2) {
        d.p = z2;
        return z2;
    }

    static boolean Q(com.android.billingclient.api.d d, boolean z2) {
        d.o = z2;
        return z2;
    }

    static boolean R(com.android.billingclient.api.d d, boolean z2) {
        d.n = z2;
        return z2;
    }

    static boolean S(com.android.billingclient.api.d d, boolean z2) {
        d.m = z2;
        return z2;
    }

    private void l(Context context, com.android.billingclient.api.k k2, boolean z3) {
        final Context obj2 = context.getApplicationContext();
        this.e = obj2;
        f0 f0Var = new f0(obj2, k2);
        this.d = f0Var;
        this.s = z3;
    }

    static boolean m(com.android.billingclient.api.d d, boolean z2) {
        d.l = z2;
        return z2;
    }

    static boolean n(com.android.billingclient.api.d d, boolean z2) {
        d.k = z2;
        return z2;
    }

    static boolean o(com.android.billingclient.api.d d, boolean z2) {
        d.i = z2;
        return z2;
    }

    private final Handler p() {
        Handler handler;
        Looper myLooper;
        if (Looper.myLooper() == null) {
            handler = this.c;
        } else {
            handler = new Handler(Looper.myLooper());
        }
        return handler;
    }

    private final com.android.billingclient.api.g q(com.android.billingclient.api.g g) {
        if (Thread.interrupted()) {
            return g;
        }
        n0 n0Var = new n0(this, g);
        this.c.post(n0Var);
        return g;
    }

    private final com.android.billingclient.api.g r() {
        com.android.billingclient.api.g gVar;
        int i;
        int i2;
        if (this.a != 0) {
            if (this.a == 3) {
                gVar = w.m;
            } else {
                gVar = w.k;
            }
        } else {
        }
        return gVar;
    }

    private final com.android.billingclient.api.g s(String string) {
        com.android.billingclient.api.g obj7;
        l0 l0Var = new l0(this, string);
        obj7 = (Integer)this.t(l0Var, 5000, obj3, 0).get(5000, l0Var).intValue() == 0 ? w.l : w.h;
        return obj7;
    }

    private final <T> Future<T> t(Callable<T> callable, long l2, Runnable runnable3, Handler handler4) {
        ExecutorService fixedThreadPool;
        com.android.billingclient.api.p pVar;
        if (this.t == null) {
            pVar = new p(this);
            this.t = Executors.newFixedThreadPool(a.a, pVar);
        }
        final Future obj3 = this.t.submit(callable);
        r0 r0Var = new r0(obj3, handler4);
        obj7.postDelayed(r0Var, (long)obj4);
        return obj3;
    }

    static int u(com.android.billingclient.api.d d) {
        return d.j;
    }

    static int v(com.android.billingclient.api.d d, int i2) {
        d.j = i2;
        return i2;
    }

    static int w(com.android.billingclient.api.d d, int i2) {
        d.a = i2;
        return i2;
    }

    static Context x(com.android.billingclient.api.d d) {
        return d.e;
    }

    @Override // com.android.billingclient.api.c
    public final Integer G(String string) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("vr", true);
        return Integer.valueOf(this.f.N1(7, this.e.getPackageName(), string, bundle));
    }

    @Override // com.android.billingclient.api.c
    public final Object H(com.android.billingclient.api.a a, com.android.billingclient.api.b b2) {
        String str = "BillingClient";
        Bundle obj8 = this.f.g2(9, this.e.getPackageName(), a.a(), a.b(a, this.b));
        com.android.billingclient.api.g.a aVar = g.c();
        aVar.c(a.a(obj8, str));
        aVar.b(a.h(obj8, str));
        b2.onAcknowledgePurchaseResponse(aVar.a());
        return null;
    }

    @Override // com.android.billingclient.api.c
    public final Object I(com.android.billingclient.api.h h, com.android.billingclient.api.i i2) {
        String concat;
        int int;
        String string;
        String valueOf;
        String packageName2;
        Object stringBuilder;
        int packageName;
        boolean z;
        String str;
        String obj8;
        final String str2 = "BillingClient";
        final String str3 = h.a();
        String str5 = "Consuming purchase with token: ";
        valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            concat = str5.concat(valueOf);
        } else {
            valueOf = new String(str5);
            concat = valueOf;
        }
        a.j(str2, concat);
        if (this.m) {
            obj8 = this.f.H(9, this.e.getPackageName(), str3, a.c(h, this.m, this.b));
            int = obj8.getInt("RESPONSE_CODE");
            obj8 = a.h(obj8, str2);
        } else {
            int = this.f.C(3, this.e.getPackageName(), str3);
            obj8 = "";
        }
        try {
            stringBuilder = g.c();
            stringBuilder.c(int);
            stringBuilder.b(obj8);
            obj8 = stringBuilder.a();
            if (int == 0) {
            } else {
            }
            a.j(str2, "Successfully consumed purchase.");
            i2.onConsumeResponse(obj8, str3);
            stringBuilder = new StringBuilder(63);
            stringBuilder.append("Error consuming purchase with token. Response code: ");
            stringBuilder.append(int);
            a.k(str2, stringBuilder.toString());
            i2.onConsumeResponse(obj8, str3);
            h = String.valueOf(h);
            String str4 = String.valueOf(h);
            str4 = str4.length();
            str4 += 30;
            StringBuilder stringBuilder2 = new StringBuilder(str4);
            str4 = "Error consuming purchase; ex: ";
            stringBuilder2.append(str4);
            stringBuilder2.append(h);
            h = stringBuilder2.toString();
            a.k(obj0, h);
            h = w.m;
            i2.onConsumeResponse(h, obj1);
            return null;
        }
    }

    @Override // com.android.billingclient.api.c
    public final Object J(String string, List list2, String string3, com.android.billingclient.api.m m4) {
        ArrayList arrayList;
        String str;
        String size2;
        Object stringArrayList;
        int i;
        int str2;
        int i3;
        int i2;
        int size;
        int string2;
        String skuDetails;
        int i5;
        int i8;
        boolean bundle2;
        int i6;
        ArrayList stringBuilder;
        Object obj4;
        String str3;
        int i7;
        d dVar;
        int i4;
        String packageName;
        String str4;
        Bundle bundle3;
        Bundle bundle;
        final Object obj = this;
        String str5 = "BillingClient";
        arrayList = new ArrayList();
        size2 = list2.size();
        str2 = 0;
        skuDetails = "Item is unavailable for purchase.";
        i5 = 0;
        while (str2 < size2) {
            i8 = str2 + 20;
            if (i8 > size2) {
            } else {
            }
            i6 = i8;
            stringBuilder = new ArrayList(list2.subList(str2, i6));
            ArrayList arrayList2 = new ArrayList();
            i7 = 0;
            while (i7 < stringBuilder.size()) {
                arrayList2.add((c0)stringBuilder.get(i7).a());
                i7++;
            }
            bundle2 = new Bundle();
            bundle2.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle2.putString("playBillingLibraryVersion", obj.b);
            if (obj.n) {
            } else {
            }
            stringArrayList = obj.f.q1(3, obj.e.getPackageName(), string, bundle2);
            str2 = "DETAILS_LIST";
            stringArrayList = stringArrayList.getStringArrayList(str2);
            if (stringArrayList == null) {
                break;
            } else {
            }
            i3 = 0;
            while (i3 < stringArrayList.size()) {
                skuDetails = new SkuDetails((String)stringArrayList.get(i3));
                String valueOf = String.valueOf(skuDetails);
                stringBuilder = new StringBuilder(length += 17);
                stringBuilder.append("Got sku details: ");
                stringBuilder.append(valueOf);
                a.j(str5, stringBuilder.toString());
                arrayList.add(skuDetails);
                i3++;
            }
            str2 = i8;
            skuDetails = "Item is unavailable for purchase.";
            i5 = 0;
            skuDetails = new SkuDetails((String)stringArrayList.get(i3));
            valueOf = String.valueOf(skuDetails);
            stringBuilder = new StringBuilder(length += 17);
            stringBuilder.append("Got sku details: ");
            stringBuilder.append(valueOf);
            a.j(str5, stringBuilder.toString());
            arrayList.add(skuDetails);
            i3++;
            stringArrayList = obj.f.w(10, obj.e.getPackageName(), string, bundle2, a.d(obj.j, obj.s, obj.b, i5, stringBuilder));
            str3 = string;
            arrayList2.add((c0)stringBuilder.get(i7).a());
            i7++;
            i6 = size2;
        }
        skuDetails = "";
        i = 0;
        com.android.billingclient.api.g.a aVar = g.c();
        aVar.c(i);
        aVar.b(skuDetails);
        m4.onSkuDetailsResponse(aVar.a(), arrayList);
        return i5;
    }

    @Override // com.android.billingclient.api.c
    public final void L(com.android.billingclient.api.g g) {
        this.d.b().onPurchasesUpdated(g, 0);
    }

    @Override // com.android.billingclient.api.c
    public final void a(com.android.billingclient.api.a a, com.android.billingclient.api.b b2) {
        Object obj7;
        if (!e()) {
            b2.onAcknowledgePurchaseResponse(w.m);
        }
        if (TextUtils.isEmpty(a.a())) {
            a.k("BillingClient", "Please provide a valid purchase token.");
            b2.onAcknowledgePurchaseResponse(w.j);
        }
        if (!this.m) {
            b2.onAcknowledgePurchaseResponse(w.b);
        }
        i0 i0Var = new i0(this, a, b2);
        h0 h0Var = new h0(b2);
        if (this.t(i0Var, 30000, obj3, h0Var) == null) {
            b2.onAcknowledgePurchaseResponse(r());
        }
    }

    @Override // com.android.billingclient.api.c
    public final void b(com.android.billingclient.api.h h, com.android.billingclient.api.i i2) {
        Object future;
        Object obj8;
        if (!e()) {
            i2.onConsumeResponse(w.m, h.a());
        }
        j0 j0Var = new j0(this, h, i2);
        o0 o0Var = new o0(i2, h);
        if (this.t(j0Var, 30000, obj4, o0Var) == null) {
            i2.onConsumeResponse(r(), h.a());
        }
    }

    @Override // com.android.billingclient.api.c
    public final void c() {
        com.android.billingclient.api.s sVar2;
        Object sVar;
        Object stringBuilder;
        this.d.c();
        if (this.g != null) {
            this.g.c();
        }
        final int i2 = 0;
        if (this.g != null && this.f != null) {
            try {
                if (this.f != null) {
                }
                a.j("BillingClient", "Unbinding from service.");
                this.e.unbindService(this.g);
                this.g = i2;
                this.f = i2;
                ExecutorService service = this.t;
                if (service != null) {
                }
                service.shutdownNow();
                this.t = i2;
                this.a = 3;
                Throwable string = String.valueOf(string);
                String str3 = String.valueOf(string);
                str3 = str3.length();
                str3 += 48;
                stringBuilder = new StringBuilder(str3);
                str3 = "There was an exception while ending connection: ";
                stringBuilder.append(str3);
                stringBuilder.append(string);
                string = stringBuilder.toString();
                a.k(th, string);
                this.a = obj1;
                this.a = obj1;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.android.billingclient.api.c
    public final com.android.billingclient.api.g d(String string) {
        int i;
        boolean equals;
        long l;
        com.android.billingclient.api.g obj3;
        if (!e()) {
            return w.m;
        }
        switch (string) {
            case "subscriptionsUpdate":
                i = 1;
                i = -1;
                break;
            case "aaa":
                i = 6;
                i = -1;
                break;
            case "bbb":
                i = 5;
                i = -1;
                break;
            case "ccc":
                i = 8;
                i = -1;
                break;
            case "ddd":
                i = 7;
                i = -1;
                break;
            case "eee":
                i = 9;
                i = -1;
                break;
            case "priceChangeConfirmation":
                i = 4;
                i = -1;
                break;
            case "inAppItemsOnVr":
                i = 2;
                i = -1;
                break;
            case "subscriptionsOnVr":
                i = 3;
                i = -1;
                break;
            case "subscriptions":
                i = 0;
                i = -1;
                break;
            default:
                i = -1;
        }
        switch (i) {
            case 0:
                obj3 = w.l;
                obj3 = w.h;
                return obj3;
            case 1:
                obj3 = w.l;
                obj3 = w.h;
                return obj3;
            case 2:
                return s("inapp");
            case 3:
                return s("subs");
            case 4:
                obj3 = w.l;
                obj3 = w.h;
                return obj3;
            case 5:
                obj3 = w.l;
                obj3 = w.h;
                return obj3;
            case 6:
                obj3 = w.l;
                obj3 = w.h;
                return obj3;
            case 7:
                obj3 = w.l;
                obj3 = w.h;
                return obj3;
            case 8:
                obj3 = w.l;
                obj3 = w.h;
                return obj3;
            default:
                obj3 = String.valueOf(string);
                String str = "Unsupported feature: ";
                obj3 = str.concat(obj3);
                obj3 = new String(str);
                a.k("BillingClient", obj3);
                return w.q;
        }
    }

    @Override // com.android.billingclient.api.c
    public final boolean e() {
        int i;
        if (this.a == 2 && this.f != null && this.g != null) {
            if (this.f != null) {
                if (this.g != null) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.android.billingclient.api.c
    public final com.android.billingclient.api.g f(Activity activity, com.android.billingclient.api.f f2) {
        Future future;
        int i10;
        Object k0Var;
        Object str8;
        boolean versionName;
        int i13;
        String string;
        int i12;
        Object arrayList;
        int i16;
        int i;
        boolean equals;
        boolean z;
        int size;
        Handler handler;
        Object arrayList4;
        int arrayList3;
        Object packageManager;
        int i6;
        boolean empty;
        int i2;
        com.android.billingclient.api.s0 s0Var;
        boolean arrayList5;
        String size3;
        int i7;
        String optString;
        int i9;
        String size2;
        int i8;
        int length2;
        String str7;
        int str5;
        String valueOf;
        Object stringBuilder;
        int arrayList2;
        int length;
        String str4;
        String str6;
        String str;
        int i14;
        int i4;
        int i11;
        int i5;
        Object obj;
        int i3;
        String str2;
        String str3;
        int i15;
        final Object obj7 = this;
        s0Var = activity;
        size2 = "; try to reconnect";
        if (!e()) {
            com.android.billingclient.api.g gVar7 = w.m;
            obj7.q(gVar7);
            return gVar7;
        }
        str8 = f2.l();
        i13 = 0;
        Object obj6 = str8.get(i13);
        String str23 = (SkuDetails)obj6.q();
        final String str33 = "BillingClient";
        if (str23.equals("subs") && obj7.h) {
            if (obj7.h) {
            }
            a.k(str33, "Current client doesn't support subscriptions.");
            com.android.billingclient.api.g gVar6 = w.o;
            obj7.q(gVar6);
            return gVar6;
        }
        if (f2.o() && obj7.k) {
            if (obj7.k) {
            }
            a.k(str33, "Current client doesn't support extra params for buy intent.");
            com.android.billingclient.api.g gVar5 = w.g;
            obj7.q(gVar5);
            return gVar5;
        }
        if (str8.size() > 1 && obj7.r) {
            if (obj7.r) {
            }
            a.k(str33, "Current client doesn't support multi-item purchases.");
            com.android.billingclient.api.g gVar = w.p;
            obj7.q(gVar);
            return gVar;
        }
        String str25 = "";
        i8 = i13;
        str7 = str25;
        while (i8 < str8.size()) {
            String valueOf6 = String.valueOf(str7);
            valueOf = String.valueOf(str8.get(i8));
            StringBuilder stringBuilder4 = new StringBuilder(length4 += length);
            stringBuilder4.append(valueOf6);
            stringBuilder4.append(valueOf);
            if (i8 < size6--) {
            }
            str7 = string;
            i8++;
            i13 = 0;
            string = String.valueOf(stringBuilder4.toString()).concat(", ");
        }
        stringBuilder = new StringBuilder(i19 += length2);
        stringBuilder.append("Constructing buy intent for ");
        stringBuilder.append(str7);
        stringBuilder.append(", item type: ");
        stringBuilder.append(str23);
        a.j(str33, stringBuilder.toString());
        if (obj7.k) {
            length2 = a.e(f2, obj7.m, obj7.s, obj7.b);
            arrayList = new ArrayList();
            stringBuilder = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            str4 = str25;
            arrayList4 = new ArrayList();
            arrayList2 = new ArrayList();
            str6 = size2;
            size2 = str8.size();
            str = str7;
            str7 = 0;
            i14 = 0;
            i4 = 0;
            i11 = 0;
            i5 = 0;
            while (str7 < size2) {
                obj = str8.get(str7);
                if (!(SkuDetails)obj.v().isEmpty()) {
                } else {
                }
                i3 = size2;
                JSONObject jSONObject = new JSONObject(obj.h());
                optString = jSONObject.optString("offer_id_token");
                String str32 = obj.s();
                i15 = obj.r();
                String str27 = obj.u();
                stringBuilder.add(optString);
                i14 |= i25;
                arrayList6.add(str32);
                i4 |= i26;
                arrayList4.add(Integer.valueOf(i15));
                if (i15 != 0) {
                } else {
                }
                i9 = 0;
                i11 |= i9;
                i5 |= i27;
                arrayList2.add(str27);
                str7++;
                s0Var = activity;
                size2 = i3;
                size3 = str3;
                i9 = length;
                i3 = size2;
                arrayList.add(obj.v());
                String str28 = obj17;
            }
            str2 = size3;
            if (!arrayList.isEmpty()) {
                length2.putStringArrayList("skuDetailsTokens", arrayList);
            }
            if (i14 != 0 && !obj7.p) {
                if (!obj7.p) {
                    com.android.billingclient.api.g gVar4 = w.h;
                    obj7.q(gVar4);
                    return gVar4;
                }
                length2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", stringBuilder);
            }
            if (i4 != 0) {
                length2.putStringArrayList("SKU_OFFER_ID_LIST", arrayList6);
            }
            if (i11 != 0) {
                length2.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList4);
            }
            if (i5 != 0) {
                length2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList2);
            }
            if (!TextUtils.isEmpty(obj6.t())) {
                length2.putString("skuPackageName", obj6.t());
                i16 = 1;
            } else {
                i16 = 0;
            }
            int i23 = 0;
            if (!TextUtils.isEmpty(i23)) {
                length2.putString("accountName", i23);
            }
            if (str8.size() > 1) {
                arrayList3 = new ArrayList(size4--);
                arrayList5 = new ArrayList(size5--);
                while (i2 < str8.size()) {
                    arrayList3.add((SkuDetails)str8.get(i2).n());
                    arrayList5.add((SkuDetails)str8.get(i2).q());
                    i2++;
                }
                length2.putStringArrayList("additionalSkus", arrayList3);
                length2.putStringArrayList("additionalSkuTypes", arrayList5);
            }
            packageManager = "PROXY_PACKAGE";
            if (!TextUtils.isEmpty(activity.getIntent().getStringExtra(packageManager))) {
                String stringExtra2 = activity.getIntent().getStringExtra(packageManager);
                length2.putString("proxyPackage", stringExtra2);
                length2.putString("proxyPackageVersion", packageInfo.versionName);
            }
            if (obj7.q && i16 != 0) {
                i10 = i16 != 0 ? 15 : z3 ? 9 : z4 ? 7 : 6;
            } else {
            }
            super(this, i10, obj6, str23, f2, length2);
            future = this.t(s0Var, 5000, obj6, 0);
        } else {
            str2 = size3;
            str6 = size2;
            str = str7;
            k0Var = new k0(obj7, obj6, str23);
            future = this.t(k0Var, 5000, obj6, 0);
        }
        Object obj2 = future.get(5000, i12);
        int i18 = a.a((Bundle)obj2, str33);
        if (i18 != 0) {
            StringBuilder stringBuilder2 = new StringBuilder(52);
            stringBuilder2.append("Unable to buy item, Error response code: ");
            stringBuilder2.append(i18);
            a.k(str33, stringBuilder2.toString());
            com.android.billingclient.api.g.a aVar = g.c();
            aVar.c(i18);
            aVar.b(a.h(obj2, str33));
            com.android.billingclient.api.g gVar3 = aVar.a();
            obj7.q(gVar3);
            return gVar3;
        }
        Context context = activity;
        Intent intent = new Intent(context, ProxyBillingActivity.class);
        String str19 = str2;
        intent.putExtra(str19, (PendingIntent)obj2.getParcelable(str19));
        context.startActivity(intent);
        return w.l;
    }

    @Override // com.android.billingclient.api.c
    public final void h(String string, com.android.billingclient.api.j j2) {
        Object obj9;
        final int i = 0;
        if (!e()) {
            j2.onPurchaseHistoryResponse(w.m, i);
        }
        o oVar = new o(this, string, j2);
        p0 p0Var = new p0(j2);
        if (this.t(oVar, 30000, obj5, p0Var) == null) {
            j2.onPurchaseHistoryResponse(r(), i);
        }
    }

    @Override // com.android.billingclient.api.c
    public final com.android.billingclient.api.Purchase.a i(String string) {
        final int i = 0;
        if (!e()) {
            Purchase.a obj9 = new Purchase.a(w.m, i);
            return obj9;
        }
        if (TextUtils.isEmpty(string)) {
            a.k("BillingClient", "Please provide a valid SKU type.");
            obj9 = new Purchase.a(w.f, i);
            return obj9;
        }
        u0 u0Var = new u0(this, string);
        return (Purchase.a)this.t(u0Var, 5000, obj5, 0).get(5000, u0Var);
    }

    @Override // com.android.billingclient.api.c
    public final void j(com.android.billingclient.api.l l, com.android.billingclient.api.m m2) {
        boolean empty;
        String b0Var;
        Object obj13;
        final int i = 0;
        if (!e()) {
            m2.onSkuDetailsResponse(w.m, i);
        }
        final String str = l.a();
        obj13 = l.b();
        b0Var = "BillingClient";
        if (TextUtils.isEmpty(str)) {
            a.k(b0Var, "Please fix the input params. SKU type can't be empty.");
            m2.onSkuDetailsResponse(w.f, i);
        }
        if (obj13 != null) {
            ArrayList arrayList = new ArrayList();
            obj13 = obj13.iterator();
            for (String next2 : obj13) {
                b0Var = new b0(i);
                b0Var.a(next2);
                arrayList.add(b0Var.b());
            }
            super(this, str, arrayList, 0, m2);
            q0 q0Var = new q0(m2);
            if (this.t(obj13, 30000, obj9, q0Var) == null) {
                m2.onSkuDetailsResponse(r(), i);
            }
        }
        a.k(b0Var, "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
        m2.onSkuDetailsResponse(w.e, i);
    }

    @Override // com.android.billingclient.api.c
    public final void k(com.android.billingclient.api.e e) {
        Object intent;
        String equals;
        Object intentServices;
        boolean packageName;
        final String str7 = "BillingClient";
        if (e()) {
            a.j(str7, "Service connection is valid. No need to re-initialize.");
            e.onBillingSetupFinished(w.l);
        }
        final int i3 = 1;
        if (this.a == i3) {
            a.k(str7, "Client is already in the process of connecting to billing service.");
            e.onBillingSetupFinished(w.d);
        }
        if (this.a == 3) {
            a.k(str7, "Client was already closed and can't be reused. Please create another instance.");
            e.onBillingSetupFinished(w.m);
        }
        this.a = i3;
        this.d.d();
        a.j(str7, "Starting in-app billing setup.");
        s sVar = new s(this, e, 0);
        this.g = sVar;
        intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        equals = "com.android.vending";
        intent.setPackage(equals);
        final int i6 = 0;
        intentServices = this.e.getPackageManager().queryIntentServices(intent, i6);
        intentServices = obj.serviceInfo;
        if (intentServices != null && !intentServices.isEmpty() && intentServices != null) {
            if (!intentServices.isEmpty()) {
                intentServices = obj.serviceInfo;
                if (intentServices != null) {
                    packageName = intentServices.packageName;
                    intentServices = intentServices.name;
                    if (equals.equals(packageName) && intentServices != null) {
                        if (intentServices != null) {
                            ComponentName componentName = new ComponentName(packageName, intentServices);
                            intentServices = new Intent(intent);
                            intentServices.setComponent(componentName);
                            intentServices.putExtra("playBillingLibraryVersion", this.b);
                            if (this.e.bindService(intentServices, this.g, i3)) {
                                a.j(str7, "Service was bonded successfully.");
                            }
                            a.k(str7, "Connection to Billing service is blocked.");
                        } else {
                            a.k(str7, "The device doesn't have valid Play Store.");
                        }
                    } else {
                    }
                }
            }
        }
        this.a = i6;
        a.j(str7, "Billing service unavailable on device.");
        e.onBillingSetupFinished(w.c);
    }

    @Override // com.android.billingclient.api.c
    public final Bundle y(int i, com.android.billingclient.api.SkuDetails skuDetails2, String string3, com.android.billingclient.api.f f4, Bundle bundle5) {
        return this.f.o1(i, this.e.getPackageName(), skuDetails2.n(), string3, 0, bundle5);
    }

    @Override // com.android.billingclient.api.c
    public final Bundle z(com.android.billingclient.api.SkuDetails skuDetails, String string2) {
        return this.f.u0(3, this.e.getPackageName(), skuDetails.n(), string2, 0);
    }
}
