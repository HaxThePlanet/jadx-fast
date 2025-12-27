package com.android.billingclient.api;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
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
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
class d extends c {

    private volatile int a;
    private final String b;
    private final Handler c;
    private volatile f0 d;
    private Context e;
    private volatile d f;
    private volatile s g;
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
    private d(Context context, boolean z, k kVar, String str, String str2) {
        super();
        final int i = 0;
        this.a = i;
        this.c = new Handler(Looper.getMainLooper());
        this.j = i;
        this.b = str;
        l(context, kVar, z);
    }

    static /* synthetic */ Handler A(d dVar) {
        return dVar.p();
    }

    static /* synthetic */ t B(d dVar, String str) throws java.io.UnsupportedEncodingException {
        String concatenated;
        String concatenated2;
        String str3;
        int length;
        ArrayList stringArrayList;
        int i;
        String string;
        Bundle item;
        com.android.billingclient.api.PurchaseHistoryRecord purchaseHistoryRecord;
        String concatenated3;
        String str4;
        int length2;
        com.android.billingclient.api.t tVar;
        String str5 = String.valueOf(str);
        String str8 = "Querying purchase history, item type: ";
        if (str5.length() != 0) {
            concatenated = str8.concat(str5);
        } else {
            concatenated = new String(str8);
        }
        String str7 = "BillingClient";
        a.j(str7, concatenated);
        ArrayList arrayList = new ArrayList();
        List list = null;
        int i3 = list;
        while (!dVar.k) {
            try {
                Bundle bundle = dVar.f.P(6, dVar.e.getPackageName(), str, string, item);
            } catch (org.json.JSONException jSON) {
                jSON = String.valueOf(jSON);
                str = String.valueOf(jSON);
                str = str.length();
                str += 48;
                StringBuilder stringBuilder = new StringBuilder(str);
                str = "Got an exception trying to decode the purchase: ";
                stringBuilder.append(str);
                stringBuilder.append(jSON);
                jSON = stringBuilder.toString();
                a.k(str6, jSON);
                str = w.k;
                jSON = new t(str, r3);
            }
            com.android.billingclient.api.g gVar2 = y.a(bundle, str7, "getPurchaseHistory()");
            ArrayList stringArrayList3 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            i = 0;
            while (i < stringArrayList3.size()) {
                String str16 = String.valueOf((String)bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST").get(i));
                str4 = "Purchase record found for sku : ";
                a.j(str7, concatenated3);
                try {
                    purchaseHistoryRecord = new PurchaseHistoryRecord((String)stringArrayList3.get(i), (String)bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST").get(i));
                } catch (org.json.JSONException jSON) {
                    jSON = String.valueOf(jSON);
                    str = String.valueOf(jSON);
                    str = str.length();
                    str += 48;
                    stringBuilder = new StringBuilder(str);
                    str = "Got an exception trying to decode the purchase: ";
                    stringBuilder.append(str);
                    stringBuilder.append(jSON);
                    jSON = stringBuilder.toString();
                    a.k(str6, jSON);
                    str = w.k;
                    jSON = new t(str, r3);
                }
                arrayList.add(purchaseHistoryRecord);
                i = i + 1;
            }
            string = bundle.getString("INAPP_CONTINUATION_TOKEN");
            String str9 = String.valueOf(string);
            str3 = "Continuation token: ";
            str16 = String.valueOf((String)dVar.f.get(i));
            str4 = "Purchase record found for sku : ";
            a.j(str7, concatenated3);
            try {
                purchaseHistoryRecord = new PurchaseHistoryRecord((String)stringArrayList3.get(i), (String)stringArrayList.get(i));
            } catch (org.json.JSONException jSON) {
                jSON = String.valueOf(jSON);
                str = String.valueOf(jSON);
                str = str.length();
                str += 48;
                stringBuilder = new StringBuilder(str);
                str = "Got an exception trying to decode the purchase: ";
                stringBuilder.append(str);
                stringBuilder.append(jSON);
                jSON = stringBuilder.toString();
                a.k(str6, jSON);
                str = w.k;
                jSON = new t(str, r3);
            }
            arrayList.add(purchaseHistoryRecord);
            i = i + 1;
            a.j(str7, concatenated2);
            if (TextUtils.isEmpty(string)) {
                tVar = new t(w.l, arrayList);
            }
        }
        a.k(str7, "getPurchaseHistory is not supported on current device");
        tVar = new t(w.i, list);
        return tVar;
    }

    static /* synthetic */ g C(d dVar) {
        return dVar.r();
    }

    static /* synthetic */ Purchase.a D(d dVar, String str) throws java.io.UnsupportedEncodingException {
        String concatenated;
        Bundle bundle;
        String concatenated2;
        ArrayList stringArrayList;
        int i2;
        String string;
        Bundle item;
        com.android.billingclient.api.Purchase purchase;
        String concatenated3;
        String str4;
        int length2;
        com.android.billingclient.api.Purchase.a aVar;
        String str5 = String.valueOf(str);
        String str8 = "Querying owned items, item type: ";
        if (str5.length() != 0) {
            concatenated = str8.concat(str5);
        } else {
            concatenated = new String(str8);
        }
        String str7 = "BillingClient";
        a.j(str7, concatenated);
        ArrayList arrayList = new ArrayList();
        List list = null;
        int i4 = list;
        while (dVar.m) {
            bundle = dVar.f.U1(9, dVar.e.getPackageName(), str, string, item);
            com.android.billingclient.api.g gVar2 = y.a(bundle, str7, "getPurchase()");
            ArrayList stringArrayList3 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            i2 = 0;
            while (i2 < stringArrayList3.size()) {
                String str16 = String.valueOf((String)bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST").get(i2));
                str4 = "Sku is owned: ";
                a.j(str7, concatenated3);
                try {
                    purchase = new Purchase((String)stringArrayList3.get(i2), (String)bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST").get(i2));
                } catch (org.json.JSONException jSON) {
                    jSON = String.valueOf(jSON);
                    str = String.valueOf(jSON);
                    str = str.length();
                    str += 48;
                    StringBuilder stringBuilder = new StringBuilder(str);
                    str = "Got an exception trying to decode the purchase: ";
                    stringBuilder.append(str);
                    stringBuilder.append(jSON);
                    jSON = stringBuilder.toString();
                    a.k(str6, jSON);
                    str = w.k;
                    jSON = new Purchase.a(str, r3);
                }
                arrayList.add(purchase);
                i2 = i2 + 1;
            }
            string = bundle.getString("INAPP_CONTINUATION_TOKEN");
            String str9 = String.valueOf(string);
            str3 = "Continuation token: ";
            str16 = String.valueOf((String)dVar.f.get(i2));
            str4 = "Sku is owned: ";
            int i = 3;
            bundle = jSON.f.o0(i, jSON.e.getPackageName(), str, string);
            a.j(str7, concatenated3);
            try {
                purchase = new Purchase((String)stringArrayList3.get(i2), (String)stringArrayList.get(i2));
            } catch (org.json.JSONException jSON) {
                jSON = String.valueOf(jSON);
                str = String.valueOf(jSON);
                str = str.length();
                str += 48;
                stringBuilder = new StringBuilder(str);
                str = "Got an exception trying to decode the purchase: ";
                stringBuilder.append(str);
                stringBuilder.append(jSON);
                jSON = stringBuilder.toString();
                a.k(str6, jSON);
                str = w.k;
                jSON = new Purchase.a(str, r3);
            }
            arrayList.add(purchase);
            i2 = i2 + 1;
            a.j(str7, concatenated2);
            if (TextUtils.isEmpty(string)) {
                aVar = new Purchase.a(w.l, arrayList);
            }
        }
        aVar = new Purchase.a(gVar2, list);
        return aVar;
    }

    static /* synthetic */ Future K(d dVar, Callable callable, long j, Runnable runnable, Handler handler) {
        return dVar.t(callable, 30000L, runnable, handler);
    }

    private void l(Context context, k kVar, boolean z) {
        final Context applicationContext = context.getApplicationContext();
        this.e = applicationContext;
        this.d = new f0(applicationContext, kVar);
        this.s = z;
    }

    private final Handler p() {
        Handler handler;
        if (Looper.myLooper() == null) {
        } else {
            handler = new Handler(Looper.myLooper());
        }
        return handler;
    }

    private final g q(g gVar) {
        if (Thread.interrupted()) {
            return gVar;
        }
        this.c.post(new n0(this, gVar));
        return gVar;
    }

    private final g r() {
        com.android.billingclient.api.g gVar;
        int i2 = 3;
        if (this.a != 0) {
            i2 = 3;
            if (this.a == 3) {
                gVar = w.m;
            } else {
                gVar = w.k;
            }
        }
        return gVar;
    }

    private final g s(String str) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        com.android.billingclient.api.g gVar;
        final com.android.billingclient.api.l0 l0Var = new l0(this, str);
        try {
            str = (Integer)this.t(l0Var, 5000L, null, p()).get(5000L, TimeUnit.MILLISECONDS).intValue() == 0 ? w.l : w.h;
        } catch (Exception unused) {
            str = "BillingClient";
            a.k(str, "Exception while checking if billing is supported; try to reconnect");
            str = w.m;
            return str;
        }
        return ((Integer)this.t(l0Var, 5000L, null, p()).get(5000L, TimeUnit.MILLISECONDS).intValue() == 0 ? w.l : w.h);
    }

    private final <T> Future<T> t(Callable<T> callable, long j, Runnable runnable, Handler handler) {
        if (this.t == null) {
            this.t = Executors.newFixedThreadPool(a.a, new p(this));
        }
        try {
            final Future submit = this.t.submit(callable);
        } catch (Exception e) {
            e = String.valueOf(e);
            j = String.valueOf(e);
            j = j.length();
            j += 28;
            r5 = new StringBuilder(j);
            j = "Async task throws exception ";
            r5.append(j);
            r5.append(e);
            e = r5.toString();
            j = "BillingClient";
            a.k(j, e);
            e = null;
            return e;
        }
        handler.postDelayed(new r0(submit, runnable), (long)(double)j * 0.95d);
        return submit;
    }

    @Override // com.android.billingclient.api.c
    public final /* synthetic */ Integer G(String str) {
        final Bundle bundle = new Bundle();
        bundle.putBoolean("vr", true);
        return Integer.valueOf(this.f.N1(7, this.e.getPackageName(), str, bundle));
    }

    @Override // com.android.billingclient.api.c
    public final /* synthetic */ Object H(a aVar, b bVar) {
        String str2 = "BillingClient";
        try {
            Bundle bundle2 = this.f.g2(9, this.e.getPackageName(), aVar.a(), a.b(aVar, this.b));
        } catch (Exception e) {
            e = String.valueOf(e);
            String str3 = String.valueOf(e);
            str3 = str3.length();
            str3 += 32;
            StringBuilder stringBuilder = new StringBuilder(str3);
            str3 = "Error acknowledge purchase; ex: ";
            e = str3 + str3 + e;
            a.k(str, e);
            e = w.m;
            bVar.onAcknowledgePurchaseResponse(e);
            return obj;
        }
        com.android.billingclient.api.g.a aVar2 = g.c();
        aVar2.c(a.a(bundle2, str2));
        aVar2.b(a.h(bundle2, str2));
        bVar.onAcknowledgePurchaseResponse(aVar2.a());
        return null;
    }

    @Override // com.android.billingclient.api.c
    public final /* synthetic */ Object I(h hVar, i iVar) throws java.io.UnsupportedEncodingException {
        String concatenated;
        int _int;
        int length;
        String str4;
        final String str6 = "BillingClient";
        final String str8 = hVar.a();
        try {
            String str10 = "Consuming purchase with token: ";
            concatenated = String.valueOf(str8);
            if (concatenated.length() != 0) {
                concatenated = str10.concat(concatenated);
            } else {
            }
            a.j(str6, concatenated);
            if (this.m) {
                Bundle bundle2 = this.f.H(9, this.e.getPackageName(), str8, a.c(hVar, this.m, this.b));
                _int = bundle2.getInt("RESPONSE_CODE");
                str4 = a.h(bundle2, str6);
            } else {
                _int = this.f.C(3, this.e.getPackageName(), str8);
                str4 = "";
            }
            com.android.billingclient.api.g.a aVar = g.c();
            aVar.c(_int);
            aVar.b(str4);
            com.android.billingclient.api.g gVar = aVar.a();
            str = "Successfully consumed purchase.";
            a.j(str6, str);
            iVar.onConsumeResponse(gVar, str8);
            StringBuilder stringBuilder = new StringBuilder(63);
            str2 = "Error consuming purchase with token. Response code: ";
            str = 63 + str2 + _int;
            a.k(str6, str);
            iVar.onConsumeResponse(gVar, str8);
        } catch (Exception e) {
            e = String.valueOf(e);
            String str9 = String.valueOf(e);
            str9 = str9.length();
            str9 += 30;
            StringBuilder stringBuilder2 = new StringBuilder(str9);
            str9 = "Error consuming purchase; ex: ";
            e = str9 + str9 + e;
            a.k(str5, e);
            e = w.m;
            iVar.onConsumeResponse(e, str7);
        }
        return null;
    }

    @Override // com.android.billingclient.api.c
    public final /* synthetic */ Object J(String str, List list, String str2, m mVar) {
        ArrayList arrayList;
        int size;
        int i = 0;
        Bundle bundle;
        int i2 = 3;
        int i3 = 0;
        String str6;
        String str7;
        boolean key;
        String packageName;
        Object obj3;
        String str8;
        int i4 = 0;
        String str9;
        int i5;
        String packageName2;
        Bundle bundle2;
        Bundle bundle3;
        final Object str11 = this;
        String str13 = "BillingClient";
        size = list.size();
        size = 0;
        i = 6;
        i = 4;
        str7 = "Item is unavailable for purchase.";
        String str4 = null;
        while (size < size) {
            size = size + 20;
            int r11 = size;
            ArrayList arrayList3 = new ArrayList(list.subList(size, size));
            ArrayList arrayList2 = new ArrayList();
            i4 = 0;
            while (i4 < arrayList3.size()) {
                arrayList2.add((c0)arrayList3.get(i4).a());
                i4 = i4 + 1;
            }
            arrayList2.add((c0)arrayList3.get(i4).a());
            i4 = i4 + 1;
            bundle2 = new Bundle();
            bundle2.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle2.putString("playBillingLibraryVersion", str11.b);
            try {
            } catch (org.json.JSONException unused) {
                String str10 = "Got a JSON exception trying to decode SkuDetails.";
                a.k(str12, str10);
            }
            str6 = "DETAILS_LIST";
            ArrayList stringArrayList = bundle.getStringArrayList(str6);
            if (stringArrayList == null) {
                str2 = "querySkuDetailsAsync got null response list";
                a.k(str13, str2);
            }
        }
        str7 = "";
        i = 0;
        com.android.billingclient.api.g.a aVar = g.c();
        aVar.c(i);
        aVar.b(str7);
        mVar.onSkuDetailsResponse(aVar.a(), arrayList);
        return str4;
    }

    @Override // com.android.billingclient.api.c
    public final /* synthetic */ void L(g gVar) {
        this.d.b().onPurchasesUpdated(gVar, null);
    }

    @Override // com.android.billingclient.api.c
    public final void a(a aVar, b bVar) {
        if (!e()) {
            bVar.onAcknowledgePurchaseResponse(w.m);
            return;
        }
        if (TextUtils.isEmpty(aVar.a())) {
            a.k("BillingClient", "Please provide a valid purchase token.");
            bVar.onAcknowledgePurchaseResponse(w.j);
            return;
        }
        if (!this.m) {
            bVar.onAcknowledgePurchaseResponse(w.b);
            return;
        }
        if (this.t(new i0(this, aVar, bVar), 30000L, new h0(bVar), p()) == null) {
            bVar.onAcknowledgePurchaseResponse(r());
        }
    }

    @Override // com.android.billingclient.api.c
    public final void b(h hVar, i iVar) {
        if (!e()) {
            iVar.onConsumeResponse(w.m, hVar.a());
            return;
        }
        if (this.t(new j0(this, hVar, iVar), 30000L, new o0(iVar, hVar), p()) == null) {
            iVar.onConsumeResponse(r(), hVar.a());
        }
    }

    @Override // com.android.billingclient.api.c
    public final void c() {
        try {
            this.d.c();
            if (this.g != null) {
                this.g.c();
            }
            if (this.f != null) {
                a.j("BillingClient", "Unbinding from service.");
                this.e.unbindService(this.g);
                this.g = sVar4;
            }
            this.f = sVar4;
            if (this.t != null) {
                this.t.shutdownNow();
                this.t = sVar4;
            }
        } catch (Throwable th) {
        }
        this.a = 3;
    }

    @Override // com.android.billingclient.api.c
    public final g d(String str) throws java.io.UnsupportedEncodingException {
        int i = 3;
        long l;
        com.android.billingclient.api.g gVar;
        com.android.billingclient.api.g gVar2;
        com.android.billingclient.api.g gVar3;
        com.android.billingclient.api.g gVar4;
        com.android.billingclient.api.g gVar5;
        com.android.billingclient.api.g gVar6;
        String concatenated;
        com.android.billingclient.api.g gVar7;
        if (!e()) {
            return w.m;
        }
        switch (str.hashCode()) {
            case -422092961:
                i = 1;
                i = -1;
                break;
            case 96321:
                i = 6;
                i = -1;
                break;
            case 97314:
                i = 5;
                i = -1;
                break;
            case 98307:
                i = 8;
                i = -1;
                break;
            case 99300:
                i = 7;
                i = -1;
                break;
            case 100293:
                i = 9;
                i = -1;
                break;
            case 207616302:
                i = 4;
                i = -1;
                break;
            case 292218239:
                i = 2;
                i = -1;
                break;
            case 1219490065:
                i = 3;
                i = -1;
                break;
            case 1987365622:
                i = 0;
                i = -1;
                break;
            default:
                i = -1;
        }
        switch (i) {
            case 0:
                gVar4 = w.l;
                gVar4 = w.h;
                return gVar4;
            case 1:
                gVar2 = w.l;
                gVar2 = w.h;
                return gVar2;
            case 2:
                return this.s("inapp");
            case 3:
                return this.s("subs");
            case 4:
                gVar = w.l;
                gVar = w.h;
                return gVar;
            case 5:
                gVar6 = w.l;
                gVar6 = w.h;
                return gVar6;
            case 6:
                gVar3 = w.l;
                gVar3 = w.h;
                return gVar3;
            case 7:
                gVar7 = w.l;
                gVar7 = w.h;
                return gVar7;
            case 8:
                gVar5 = w.l;
                gVar5 = w.h;
                return gVar5;
            default:
                String str16 = String.valueOf(str);
                String str2 = "Unsupported feature: ";
                concatenated = str2.concat(str16);
                concatenated = new String(str2);
                a.k("BillingClient", concatenated);
                return w.q;
        }
    }

    @Override // com.android.billingclient.api.c
    public final g f(Activity activity, f fVar) throws JSONException, java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        Future future;
        int i = 15;
        String concatenated;
        TimeUnit timeUnit;
        ArrayList arrayList;
        int i3 = 0;
        int i4 = 1;
        boolean empty3;
        String str2;
        String optString;
        int length = 0;
        int size3;
        int i2;
        int i7 = 0;
        int i8;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Object item;
        int i13;
        final Object activity5 = this;
        activity2 = activity;
        str2 = "BUY_INTENT";
        String str4 = "; try to reconnect";
        if (!e()) {
            com.android.billingclient.api.g gVar7 = w.m;
            activity5.q(gVar7);
            return gVar7;
        }
        ArrayList list = fVar.l();
        i2 = 0;
        Object item2 = list.get(i2);
        String str27 = item2.q();
        final String str41 = "BillingClient";
        concatenated = "";
        while (i2 < list.size()) {
            String str44 = String.valueOf(concatenated);
            String str5 = String.valueOf(list.get(i2));
            i8 = String.valueOf(str44).length() + String.valueOf(str5).length();
            StringBuilder stringBuilder3 = new StringBuilder(i8);
            concatenated = i8 + str44 + str5;
            i6 = list.size() - 1;
        }
        int i17 = (String.valueOf(concatenated).length() + 41) + String.valueOf(str27).length();
        StringBuilder stringBuilder4 = new StringBuilder(i17);
        String str16 = "Constructing buy intent for ";
        String str17 = ", item type: ";
        str18 = i17 + str16 + concatenated + str17 + str27;
        a.j(str41, str18);
        if (activity5.k) {
            Bundle bundle = a.e(fVar, activity5.m, activity5.s, activity5.b);
            arrayList = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            size3 = list.size();
            i7 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            while (i7 < size3) {
                item = list.get(i7);
                try {
                    optString = new JSONObject(item.h()).optString("offer_id_token");
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                    String str11 = "package not found";
                    obj4.putString(str, str11);
                }
                String str38 = item.s();
                i13 = item.r();
                String str32 = item.u();
                arrayList3.add(optString);
                length = 1;
                i9 = i9 | !TextUtils.isEmpty(optString);
                arrayList6.add(str38);
                i10 = i10 | !TextUtils.isEmpty(str38);
                arrayList2.add(Integer.valueOf(i13));
                int r9 = i13 != 0 ? 1 : 0;
                i11 = i11 | (i13 != 0 ? 1 : 0);
                i12 = i12 | (i13 != 0 ? 1 : 0);
                arrayList4.add(str32);
                i7 = i7 + 1;
                activity2 = activity;
            }
            if (!arrayList.isEmpty()) {
                bundle.putStringArrayList("skuDetailsTokens", arrayList);
            }
            if (i9 != 0 && !activity5.p) {
                com.android.billingclient.api.g gVar4 = w.h;
                activity5.q(gVar4);
                return gVar4;
            }
            if (i10 != 0) {
                bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList6);
            }
            if (i11 != 0) {
                bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList2);
            }
            if (i12 != 0) {
                bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList4);
            }
            if (!TextUtils.isEmpty(item2.t())) {
                bundle.putString("skuPackageName", item2.t());
                i3 = 1;
            } else {
                i3 = 0;
            }
            java.lang.CharSequence charSequence = null;
            if (!TextUtils.isEmpty(charSequence)) {
                bundle.putString("accountName", charSequence);
            }
            i4 = 1;
            if (list.size() > 1) {
                ArrayList arrayList5 = new ArrayList(list.size() - 1);
                i5 = list.size() - 1;
                ArrayList arrayList7 = new ArrayList(i5);
                while (i4 < list.size()) {
                    arrayList5.add((SkuDetails)list.get(i4).n());
                    arrayList7.add((SkuDetails)list.get(i4).q());
                    i4 = i4 + 1;
                }
                bundle.putStringArrayList("additionalSkus", arrayList5);
                bundle.putStringArrayList("additionalSkuTypes", arrayList7);
            }
            str3 = "PROXY_PACKAGE";
            if (!TextUtils.isEmpty(activity.getIntent().getStringExtra(str3))) {
                String stringExtra2 = activity.getIntent().getStringExtra(str3);
                bundle.putString("proxyPackage", stringExtra2);
                try {
                    i4 = 0;
                    bundle.putString("proxyPackageVersion", activity5.e.getPackageManager().getPackageInfo(stringExtra2, i4).versionName);
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                    str11 = "package not found";
                    obj4.putString(str, str11);
                }
            }
            if (!activity5.q || activity5.m == 0) {
                if (activity5.m) {
                    i = 9;
                } else {
                    String str = fVar.a() ? 7 : 6;
                }
            } else {
                str = 15;
            }
            s0 activity2 = new s0(this, (fVar.a() ? 7 : 6), item2, str27, fVar, bundle);
            Handler handler = null;
            future = this.t(activity2, 5000L, handler, activity5.c);
        } else {
            handler = null;
            future = this.t(new k0(activity5, item2, str27), 5000L, handler, activity5.c);
        }
        try {
            Object obj = future.get(5000L, TimeUnit.MILLISECONDS);
            int i15 = a.a(obj, str41);
            if (i15 != 0) {
                StringBuilder stringBuilder = new StringBuilder(52);
                String str26 = "Unable to buy item, Error response code: ";
                str8 = 52 + str26 + i15;
                a.k(str41, str8);
                com.android.billingclient.api.g.a aVar = g.c();
                aVar.c(i15);
                aVar.b(a.h(obj, str41));
                com.android.billingclient.api.g gVar3 = aVar.a();
                activity5.q(gVar3);
                return gVar3;
            }
            Context activity3 = activity;
            Intent intent = new Intent(activity3, ProxyBillingActivity.class);
            intent.putExtra(str2, (PendingIntent)obj.getParcelable(str2));
            activity3.startActivity(intent);
        } catch (Exception unused) {
            str = String.valueOf(obj5);
            str = str.length();
            str = (fVar.a() ? 7 : 6) + 69;
            str11 = new StringBuilder(str);
            str = "Exception while launching billing flow: ; for sku: ";
            str11.append(str);
            String str43 = obj5;
            str11.append(str43);
            str11.append(str);
            str = str11.toString();
            a.k(str40, str);
            str = w.m;
            obj3.q(str);
            return str;
        } catch (java.util.concurrent.TimeoutException | java.util.concurrent.CancellationException unused) {
            str43 = obj5;
            str11 = String.valueOf(str43);
            str11 = str11.length();
            str11 += 68;
            StringBuilder stringBuilder2 = new StringBuilder(str11);
            str11 = "Time out while launching billing flow: ; for sku: ";
            str = str11 + str11 + str43 + str;
            a.k(str40, str);
            str = w.n;
            obj3.q(str);
            return str;
        }
        return w.l;
    }

    @Override // com.android.billingclient.api.c
    public final void h(String str, j jVar) {
        final List list = null;
        if (!e()) {
            jVar.onPurchaseHistoryResponse(w.m, list);
            return;
        }
        if (this.t(new o(this, str, jVar), 30000L, new p0(jVar), p()) == null) {
            jVar.onPurchaseHistoryResponse(r(), list);
        }
    }

    @Override // com.android.billingclient.api.c
    public final Purchase.a i(String str) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        final List list = null;
        if (!e()) {
            return new Purchase.a(w.m, list);
        }
        if (TextUtils.isEmpty(str)) {
            a.k("BillingClient", "Please provide a valid SKU type.");
            return new Purchase.a(w.f, list);
        }
        final com.android.billingclient.api.u0 u0Var = new u0(this, str);
        try {
        } catch (Exception unused) {
            com.android.billingclient.api.g gVar = w.k;
            str = new Purchase.a(gVar, r1);
            return str;
        } catch (java.util.concurrent.TimeoutException | java.util.concurrent.CancellationException unused) {
            gVar = w.n;
            str = new Purchase.a(gVar, r1);
            return str;
        }
        return (Purchase.a)this.t(u0Var, 5000L, null, this.c).get(5000L, TimeUnit.MILLISECONDS);
    }

    @Override // com.android.billingclient.api.c
    public final void j(l lVar, m mVar) {
        final List list = null;
        if (!e()) {
            mVar.onSkuDetailsResponse(w.m, list);
            return;
        }
        final String str2 = lVar.a();
        List list2 = lVar.b();
        str = "BillingClient";
        if (TextUtils.isEmpty(str2)) {
            a.k(str, "Please fix the input params. SKU type can't be empty.");
            mVar.onSkuDetailsResponse(w.f, list);
            return;
        }
        if (list2 != null) {
            final ArrayList arrayList = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                Object b0Var = new b0(list);
                b0Var.a((String)it.next());
                arrayList.add(b0Var.b());
            }
            m0 lVar2 = new m0(this, str2, arrayList, null, mVar);
            if (this.t(lVar2, 30000L, new q0(mVar), p()) == null) {
                mVar.onSkuDetailsResponse(r(), list);
            }
            return;
        }
        a.k(str, "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
        mVar.onSkuDetailsResponse(w.e, list);
    }

    @Override // com.android.billingclient.api.c
    public final void k(e eVar) {
        final String str10 = "BillingClient";
        if (e()) {
            a.j(str10, "Service connection is valid. No need to re-initialize.");
            eVar.onBillingSetupFinished(w.l);
            return;
        }
        final int i3 = 1;
        if (this.a == i3) {
            a.k(str10, "Client is already in the process of connecting to billing service.");
            eVar.onBillingSetupFinished(w.d);
            return;
        }
        if (this.a == 3) {
            a.k(str10, "Client was already closed and can't be reused. Please create another instance.");
            eVar.onBillingSetupFinished(w.m);
            return;
        }
        this.a = i3;
        this.d.d();
        a.j(str10, "Starting in-app billing setup.");
        this.g = new s(this, eVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        str = "com.android.vending";
        intent.setPackage(str);
        final int i6 = 0;
        List intentServices = this.e.getPackageManager().queryIntentServices(intent, i6);
        if (intentServices != null && !intentServices.isEmpty()) {
            if (serviceInfo2 != null) {
                if (!"com.android.vending".equals(serviceInfo2.packageName) || serviceInfo2.name == null) {
                    a.k(str10, "The device doesn't have valid Play Store.");
                } else {
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(new ComponentName(packageName2, name2));
                    intent2.putExtra("playBillingLibraryVersion", this.b);
                    if (this.e.bindService(intent2, this.g, i3)) {
                        a.j(str10, "Service was bonded successfully.");
                        return;
                    }
                    a.k(str10, "Connection to Billing service is blocked.");
                }
            }
        }
        this.a = i6;
        a.j(str10, "Billing service unavailable on device.");
        eVar.onBillingSetupFinished(w.c);
    }

    @Override // com.android.billingclient.api.c
    public final /* synthetic */ Bundle y(int i, SkuDetails skuDetails, String str, f fVar, Bundle bundle) {
        return this.f.o1(i, this.e.getPackageName(), skuDetails.n(), str, null, bundle);
    }

    @Override // com.android.billingclient.api.c
    public final /* synthetic */ Bundle z(SkuDetails skuDetails, String str) {
        return this.f.u0(3, this.e.getPackageName(), skuDetails.n(), str, null);
    }

    d(String str, boolean z, Context context, k kVar) throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        Object obj;
        try {
            obj = Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
        }
        this(context, z, kVar, obj, null);
    }

    static /* synthetic */ d E(d dVar) {
        return dVar.f;
    }

    static /* synthetic */ d F(d dVar, d dVar2) {
        dVar.f = dVar2;
        return dVar2;
    }

    static /* synthetic */ boolean M(d dVar, boolean z) {
        dVar.h = z;
        return z;
    }

    static /* synthetic */ boolean N(d dVar, boolean z) {
        dVar.r = z;
        return z;
    }

    static /* synthetic */ boolean O(d dVar, boolean z) {
        dVar.q = z;
        return z;
    }

    static /* synthetic */ boolean P(d dVar, boolean z) {
        dVar.p = z;
        return z;
    }

    static /* synthetic */ boolean Q(d dVar, boolean z) {
        dVar.o = z;
        return z;
    }

    static /* synthetic */ boolean R(d dVar, boolean z) {
        dVar.n = z;
        return z;
    }

    static /* synthetic */ boolean S(d dVar, boolean z) {
        dVar.m = z;
        return z;
    }

    static /* synthetic */ boolean m(d dVar, boolean z) {
        dVar.l = z;
        return z;
    }

    static /* synthetic */ boolean n(d dVar, boolean z) {
        dVar.k = z;
        return z;
    }

    static /* synthetic */ boolean o(d dVar, boolean z) {
        dVar.i = z;
        return z;
    }

    static /* synthetic */ int u(d dVar) {
        return dVar.j;
    }

    static /* synthetic */ int v(d dVar, int i) {
        dVar.j = i;
        return i;
    }

    static /* synthetic */ int w(d dVar, int i) {
        dVar.a = i;
        return i;
    }

    static /* synthetic */ Context x(d dVar) {
        return dVar.e;
    }

    @Override // com.android.billingclient.api.c
    public final boolean e() {
        if (this.a == 2 && this.f != null && this.g != null) {
            return true;
        }
        return false;
    }
}
