package com.facebook.e0.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0008\u0010+\u001a\u00020,H\u0007J0\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001e\u00101\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u0004\u0018\u00010\"2\n\u00104\u001a\u0006\u0012\u0002\u0008\u00030\u001f2\u0006\u00105\u001a\u00020\u0004H\u0002J0\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0008\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0008\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0008\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0008\u00107\u001a\u0004\u0018\u00010\u0001H\u0007JF\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0008\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0007JF\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/2\u0008\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0004JA\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0008\u0010F\u001a\u0004\u0018\u00010\u00012\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020A2\u0006\u0010'\u001a\u00020(2\u0008\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J,\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040L2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\u0008\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001c\u0010M\u001a\u00020,2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u001f0\u001ej\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u001ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"` X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseEventManager;", "", "()V", "AS_INTERFACE", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "", "DETAILS_LIST", "GET_PURCHASES", "GET_PURCHASE_HISTORY", "GET_SKU_DETAILS", "INAPP", "INAPP_CONTINUATION_TOKEN", "INAPP_PURCHASE_DATA_LIST", "IN_APP_BILLING_SERVICE", "IN_APP_BILLING_SERVICE_STUB", "IS_BILLING_SUPPORTED", "ITEM_ID_LIST", "LAST_CLEARED_TIME", "MAX_QUERY_PURCHASE_NUM", "PACKAGE_NAME", "kotlin.jvm.PlatformType", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_INAPP_STORE", "PURCHASE_STOP_QUERY_TIME_SEC", "RESPONSE_CODE", "SKU_DETAILS_STORE", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "classMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/lang/reflect/Method;", "purchaseInappSharedPrefs", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", "asInterface", "context", "Landroid/content/Context;", "service", "Landroid/os/IBinder;", "clearSkuDetailsCache", "", "filterPurchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchases", "getClass", "className", "getMethod", "classObj", "methodName", "getPurchaseHistory", "inAppBillingObj", "type", "getPurchaseHistoryInapp", "getPurchases", "getPurchasesInapp", "getPurchasesSubs", "getSkuDetails", "", "skuList", "isSubscription", "", "getSkuDetailsFromGoogle", "hasFreeTrialPeirod", "skuDetail", "invokeMethod", "obj", "args", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "isBillingSupported", "readSkuDetailsFromCache", "", "writeSkuDetailsToCache", "skuDetailsMap", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    private static final HashMap<String, Method> a;
    private static final HashMap<String, Class<?>> b;
    private static final String c;
    private static final SharedPreferences d;
    private static final SharedPreferences e;
    public static final com.facebook.e0.t.d f;
    static {
        d dVar = new d();
        d.f = dVar;
        HashMap hashMap = new HashMap();
        d.a = hashMap;
        HashMap hashMap2 = new HashMap();
        d.b = hashMap2;
        d.c = o.f().getPackageName();
        final int i = 0;
        d.d = o.f().getSharedPreferences("com.facebook.internal.SKU_DETAILS", i);
        d.e = o.f().getSharedPreferences("com.facebook.internal.PURCHASE", i);
    }

    public static final Object a(Context context, IBinder iBinder2) {
        if (a.d(d.class)) {
            return null;
        }
        n.f(context, "context");
        final Object[] arr = new Object[1];
        return d.f.n(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", 0, arr);
    }

    public static final void b() {
        Object long;
        Object clear;
        int cmp;
        long long2;
        long = "LAST_CLEARED_TIME";
        if (a.d(d.class)) {
        }
        currentTimeMillis /= i2;
        clear = d.d;
        int i3 = 0;
        long2 = clear.getLong(long, i3);
        if (Long.compare(long2, i3) == 0) {
            clear.edit().putLong(long, i).apply();
        } else {
            if (Long.compare(i4, long2) > 0) {
                clear.edit().clear().putLong(long, i).apply();
            }
        }
    }

    private final ArrayList<String> c(ArrayList<String> arrayList) {
        Object next;
        String string;
        String string2;
        boolean cmp;
        String str;
        long l;
        if (a.d(this)) {
            return 0;
        }
        ArrayList arrayList2 = new ArrayList();
        SharedPreferences.Editor edit = d.e.edit();
        final int i3 = 1000;
        final Iterator obj15 = arrayList.iterator();
        while (obj15.hasNext()) {
            next = obj15.next();
            JSONObject jSONObject = new JSONObject((String)next);
            string2 = jSONObject.getString("productId");
            string = jSONObject.getString("purchaseToken");
            if (Long.compare(i5, l) > 0) {
            } else {
            }
            if (n.b(d.e.getString(string2, ""), string)) {
            } else {
            }
            edit.putString(string2, string);
            arrayList2.add(next);
        }
        edit.apply();
        return arrayList2;
    }

    private final Class<?> d(Context context, String string2) {
        if (a.d(this)) {
            return 0;
        }
        HashMap map = d.b;
        Object obj = map.get(string2);
        if ((Class)obj != null) {
            return (Class)obj;
        }
        Class class = context.getClassLoader().loadClass(string2);
        n.e(class, "classObj");
        map.put(string2, class);
        return class;
    }

    private final Method e(Class<?> class, String string2) {
        Class<String> equals;
        Class[] copyOf;
        Class[] arr;
        boolean equals2;
        Class tYPE;
        Class tYPE2;
        Method obj13;
        equals = String.class;
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        HashMap map = d.a;
        Object obj = map.get(string2);
        if ((Method)obj != null) {
            return (Method)obj;
        }
        tYPE = 4;
        final int i4 = 2;
        final String str6 = "Integer.TYPE";
        final int i5 = 3;
        final int i6 = 0;
        final int i7 = 1;
        switch (string2) {
            case "getPurchases":
                arr = new Class[tYPE];
                tYPE = Integer.TYPE;
                n.e(tYPE, str6);
                arr[i6] = tYPE;
                arr[i7] = equals;
                arr[i4] = equals;
                arr[i5] = equals;
                arr = i2;
                break;
            case "isBillingSupported":
                arr = new Class[i5];
                tYPE = Integer.TYPE;
                n.e(tYPE, str6);
                arr[i6] = tYPE;
                arr[i7] = equals;
                arr[i4] = equals;
                arr = i2;
                break;
            case "asInterface":
                new Class[i7][i6] = IBinder.class;
                arr = i2;
                break;
            case "getPurchaseHistory":
                arr = new Class[5];
                tYPE2 = Integer.TYPE;
                n.e(tYPE2, str6);
                arr[i6] = tYPE2;
                arr[i7] = equals;
                arr[i4] = equals;
                arr[i5] = equals;
                arr[tYPE] = Bundle.class;
                arr = i2;
                break;
            case "getSkuDetails":
                arr = new Class[tYPE];
                tYPE = Integer.TYPE;
                n.e(tYPE, str6);
                arr[i6] = tYPE;
                arr[i7] = equals;
                arr[i4] = equals;
                arr[i5] = Bundle.class;
                arr = i2;
                break;
            default:
                arr = i2;
        }
        if (arr == null) {
            copyOf = new Class[i7];
            copyOf[i6] = i2;
            obj13 = class.getDeclaredMethod(string2, copyOf);
        } else {
            obj13 = class.getDeclaredMethod(string2, (Class[])Arrays.copyOf(arr, arr.length));
        }
        Method method = obj13;
        map.put(string2, method);
        return method;
    }

    private final ArrayList<String> f(Context context, Object object2, String string3) {
        boolean z;
        int string;
        int i2;
        int i4;
        int i3;
        Object bundle;
        Object obj;
        Context cmp;
        String str;
        String stringArrayList;
        Object next;
        Object[] arr;
        int i;
        int i5;
        final int i6 = 0;
        if (a.d(this)) {
            return i6;
        }
        ArrayList arrayList = new ArrayList();
        if (o(context, object2, string3)) {
            z = 0;
            string = i6;
            i4 = i2;
            arr = new Object[5];
            arr[z] = 6;
            i = 1;
            arr[i] = d.c;
            arr[2] = string3;
            arr[3] = string;
            bundle = new Bundle();
            arr[4] = bundle;
            Object obj3 = this.n(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", object2, arr);
            while (obj3 != null) {
                stringArrayList = obj3.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                if ((Bundle)obj3.getInt("RESPONSE_CODE") == 0 && stringArrayList != null) {
                } else {
                }
                string = i6;
                if (i2 < 30) {
                }
                if (string != null) {
                }
                if (i4 == 0) {
                }
                arr = new Object[5];
                arr[z] = 6;
                i = 1;
                arr[i] = d.c;
                arr[2] = string3;
                arr[3] = string;
                bundle = new Bundle();
                arr[4] = bundle;
                obj3 = this.n(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", object2, arr);
                stringArrayList = obj3.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                if (stringArrayList != null) {
                } else {
                }
                n.e(stringArrayList, "purchaseDetails.getStrin…SE_DATA_LIST) ?: continue");
                stringArrayList = stringArrayList.iterator();
                while (stringArrayList.hasNext()) {
                    next = stringArrayList.next();
                    JSONObject jSONObject = new JSONObject((String)next);
                    if (Long.compare(i5, l) > 0) {
                        break loop_8;
                    } else {
                    }
                    arrayList.add(next);
                    i2++;
                    cmp = 1000;
                }
                string = obj3.getString("INAPP_CONTINUATION_TOKEN");
                next = stringArrayList.next();
                jSONObject = new JSONObject((String)next);
                if (Long.compare(i5, l) > 0) {
                } else {
                }
                arrayList.add(next);
                i2++;
                cmp = 1000;
                i4 = i;
            }
        }
        return arrayList;
    }

    public static final ArrayList<String> g(Context context, Object object2) {
        Object cls;
        String str;
        if (a.d(d.class)) {
            return 0;
        }
        n.f(context, "context");
        ArrayList arrayList = new ArrayList();
        if (object2 == null) {
            return arrayList;
        }
        final com.facebook.e0.t.d dVar = d.f;
        cls = dVar.d(context, "com.android.vending.billing.IInAppBillingService");
        if (cls != null && dVar.e(cls, "getPurchaseHistory") != null) {
            if (dVar.e(cls, "getPurchaseHistory") != null) {
                return dVar.c(dVar.f(context, object2, "inapp"));
            }
        }
        return arrayList;
    }

    private final ArrayList<String> h(Context context, Object object2, String string3) {
        boolean z;
        Object string;
        int i;
        ArrayList stringArrayList;
        String int;
        Object size;
        Context context2;
        String str2;
        String str;
        Object obj;
        Object[] arr;
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        ArrayList arrayList = new ArrayList();
        if (object2 == null) {
            return arrayList;
        }
        if (o(context, object2, string3)) {
            z = 0;
            string = i2;
            i = z;
            arr = new Object[4];
            int = 3;
            arr[z] = Integer.valueOf(int);
            arr[1] = d.c;
            arr[2] = string3;
            arr[int] = string;
            string = this.n(context, "com.android.vending.billing.IInAppBillingService", "getPurchases", object2, arr);
            while (string != null) {
                if ((Bundle)string.getInt("RESPONSE_CODE") == 0) {
                } else {
                }
                string = i2;
                if (i < 30) {
                }
                if (string != null) {
                }
                arr = new Object[4];
                int = 3;
                arr[z] = Integer.valueOf(int);
                arr[1] = d.c;
                arr[2] = string3;
                arr[int] = string;
                string = this.n(context, "com.android.vending.billing.IInAppBillingService", "getPurchases", object2, arr);
                stringArrayList = string.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                if (stringArrayList != null) {
                }
                i += size;
                arrayList.addAll(stringArrayList);
                string = string.getString("INAPP_CONTINUATION_TOKEN");
            }
        }
        return arrayList;
    }

    public static final ArrayList<String> i(Context context, Object object2) {
        if (a.d(d.class)) {
            return 0;
        }
        n.f(context, "context");
        com.facebook.e0.t.d dVar = d.f;
        return dVar.c(dVar.h(context, object2, "inapp"));
    }

    public static final ArrayList<String> j(Context context, Object object2) {
        if (a.d(d.class)) {
            return 0;
        }
        n.f(context, "context");
        com.facebook.e0.t.d dVar = d.f;
        return dVar.c(dVar.h(context, object2, "subs"));
    }

    public static final Map<String, String> k(Context context, ArrayList<String> arrayList2, Object object3, boolean z4) {
        Object next;
        boolean key;
        if (a.d(d.class)) {
            return 0;
        }
        n.f(context, "context");
        n.f(arrayList2, "skuList");
        Map map = d.f.p(arrayList2);
        ArrayList arrayList = new ArrayList();
        Iterator obj7 = arrayList2.iterator();
        while (obj7.hasNext()) {
            next = obj7.next();
            if (!map.containsKey((String)next)) {
            }
            arrayList.add(next);
        }
        map.putAll(d.f.l(context, arrayList, object3, z4));
        return map;
    }

    private final Map<String, String> l(Context context, ArrayList<String> arrayList2, Object object3, boolean z4) {
        Bundle bundle;
        int str2;
        Object obj;
        Context context2;
        String str3;
        String str;
        Object obj2;
        Object[] arr;
        int i;
        Object obj12;
        String obj14;
        String obj15;
        if (a.d(this)) {
            return 0;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (object3 != null) {
            if (arrayList2.isEmpty()) {
            } else {
                bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
                arr = new Object[4];
                str2 = 3;
                obj15 = z4 != null ? "subs" : "inapp";
                try {
                    arr[str2] = bundle;
                    obj12 = this.n(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", object3, arr);
                    obj12 = obj12.getStringArrayList("DETAILS_LIST");
                    if (obj12 != null && (Bundle)obj12.getInt("RESPONSE_CODE") == 0 && obj12 != null && arrayList2.size() == obj12.size()) {
                    }
                    if ((Bundle)obj12.getInt("RESPONSE_CODE") == 0) {
                    }
                    obj12 = obj12.getStringArrayList("DETAILS_LIST");
                    if (obj12 != null) {
                    }
                    if (arrayList2.size() == obj12.size()) {
                    }
                    while (i < arrayList2.size()) {
                        obj15 = arrayList2.get(i);
                        n.e(obj15, "skuList[i]");
                        bundle = obj12.get(i);
                        n.e(bundle, "skuDetailsList[i]");
                        linkedHashMap.put(obj15, bundle);
                        i++;
                    }
                    obj15 = arrayList2.get(i);
                    n.e(obj15, "skuList[i]");
                    bundle = obj12.get(i);
                    n.e(bundle, "skuDetailsList[i]");
                    linkedHashMap.put(obj15, bundle);
                    i++;
                    q(linkedHashMap);
                    return linkedHashMap;
                    a.b(context, this);
                    return obj1;
                }
            }
        }
    }

    private final Object n(Context context, String string2, String string3, Object object4, Object[] object5Arr5) {
        Object obj4;
        Object obj6;
        final int i = 0;
        if (a.d(this)) {
            return i;
        }
        Class obj3 = d(context, string2);
        obj4 = e(obj3, string3);
        if (obj3 != null && obj4 != null && object4 != null) {
            obj4 = e(obj3, string3);
            if (obj4 != null) {
                if (object4 != null) {
                    obj6 = obj3.cast(object4);
                }
                return obj4.invoke(obj6, Arrays.copyOf(object5Arr5, object5Arr5.length));
            }
        }
        return i;
    }

    private final boolean o(Context context, Object object2, String string3) {
        int i;
        Object obj10;
        i = 0;
        if (a.d(this)) {
            return i;
        }
        if (object2 == null) {
            return i;
        }
        int i2 = 3;
        final Object[] arr = new Object[i2];
        arr[i] = Integer.valueOf(i2);
        final int i4 = 1;
        arr[i4] = d.c;
        arr[2] = string3;
        obj10 = this.n(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", object2, arr);
        if (obj10 != null && (Integer)obj10.intValue() == 0) {
            if ((Integer)obj10.intValue() == 0) {
                i = i4;
            }
        }
        return i;
    }

    private final Map<String, String> p(ArrayList<String> arrayList) {
        int next;
        Object obj;
        String string;
        String[] strArr;
        long l;
        int i3;
        int i;
        int i2;
        final int i4 = 0;
        if (a.d(this)) {
            return i4;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Iterator obj13 = arrayList.iterator();
        while (obj13.hasNext()) {
            next = obj13.next();
            string = d.d.getString((String)next, i4);
            obj = l.E0(string, /* result */, false, 2, 2, 0);
            if (string != null && Long.compare(i7, l) < 0) {
            }
            obj = l.E0(string, /* result */, false, 2, 2, 0);
            if (Long.compare(i7, l) < 0) {
            }
            n.e(next, "sku");
            linkedHashMap.put(next, obj.get(1));
        }
        return linkedHashMap;
    }

    private final void q(Map<String, String> map) {
        String string;
        Object key;
        StringBuilder stringBuilder;
        int i;
        if (a.d(this)) {
        }
        SharedPreferences.Editor edit = d.d.edit();
        Iterator obj8 = map.entrySet().iterator();
        for (Map.Entry next2 : obj8) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(currentTimeMillis /= i3);
            stringBuilder.append(';');
            stringBuilder.append((String)next2.getValue());
            edit.putString((String)next2.getKey(), stringBuilder.toString());
        }
        edit.apply();
    }

    public final boolean m(String string) {
        int i;
        int obj3;
        i = 0;
        if (a.d(this)) {
            return i;
        }
        n.f(string, "skuDetail");
        JSONObject jSONObject = new JSONObject(string);
        obj3 = jSONObject.optString("freeTrialPeriod");
        int i2 = 1;
        if (obj3 != null) {
            obj3 = obj3.length() > 0 ? i2 : i;
            if (obj3 != null) {
                i = i2;
            }
        }
        try {
            return i;
            a.b(string, this);
            return obj1;
        } catch (org.json.JSONException jSON) {
        } catch (Throwable th1) {
        }
    }
}
