package com.facebook.e0.t;

import android.content.Context;
import com.facebook.internal.g0.i.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u0007\u0008\u0007\u0018\u0000 )2\u00020\u0001:\u0005()*+,B«\u0001\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0010\u000c\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001fJ\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001fH\u0002J(\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0&2\u0006\u0010#\u001a\u00020\u001fH\u0002J\u0008\u0010'\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000c\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "context", "Landroid/content/Context;", "billingClient", "billingClientClazz", "Ljava/lang/Class;", "purchaseResultClazz", "purchaseClazz", "skuDetailsClazz", "purchaseHistoryRecordClazz", "skuDetailsResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "queryPurchasesMethod", "Ljava/lang/reflect/Method;", "getPurchaseListMethod", "getOriginalJsonMethod", "getOriginalJsonSkuMethod", "getOriginalJsonPurchaseHistoryMethod", "querySkuDetailsAsyncMethod", "queryPurchaseHistoryAsyncMethod", "inAppPurchaseSkuDetailsWrapper", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;)V", "historyPurchaseSet", "", "", "queryPurchase", "", "skuType", "querySkuRunnable", "Ljava/lang/Runnable;", "queryPurchaseHistory", "queryPurchaseHistoryRunnable", "queryPurchaseHistoryAsync", "runnable", "querySkuDetailsAsync", "skuIDs", "", "startConnection", "BillingClientStateListenerWrapper", "Companion", "PurchaseHistoryResponseListenerWrapper", "PurchasesUpdatedListenerWrapper", "SkuDetailsResponseListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private static final AtomicBoolean s;
    private static com.facebook.e0.t.c t;
    private static final AtomicBoolean u;
    private static final Map<String, JSONObject> v;
    private static final Map<String, JSONObject> w;
    public static final com.facebook.e0.t.c.b x;
    private final Set<String> a;
    private final Context b;
    private final Object c;
    private final Class<?> d;
    private final Class<?> e;
    private final Class<?> f;
    private final Class<?> g;
    private final Class<?> h;
    private final Class<?> i;
    private final Class<?> j;
    private final Method k;
    private final Method l;
    private final Method m;
    private final Method n;
    private final Method o;
    private final Method p;
    private final Method q;
    private final com.facebook.e0.t.g r;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$BillingClientStateListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object object, Method method2, Object[] object3Arr3) {
            int i;
            AtomicBoolean obj3;
            int obj4;
            String obj5;
            final int i2 = 0;
            if (a.d(this)) {
                return i2;
            }
            n.f(object, "proxy");
            n.f(method2, "m");
            if (n.b(method2.getName(), "onBillingSetupFinished")) {
                c.x.f().set(true);
            } else {
                obj3 = method2.getName();
                n.e(obj3, "m.name");
                i = 0;
                if (l.w(obj3, "onBillingServiceDisconnected", i, 2, i2)) {
                    c.x.f().set(i);
                }
            }
            return i2;
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010,\u001a\u0004\u0018\u00010\u00012\u0008\u0010-\u001a\u0004\u0018\u00010.2\n\u0010/\u001a\u0006\u0012\u0002\u0008\u000300H\u0002J\u0010\u00101\u001a\u0002022\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020.H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u001d\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0&¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010)¨\u00064", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$Companion;", "", "()V", "CLASSNAME_BILLING_CLIENT", "", "CLASSNAME_BILLING_CLIENT_BUILDER", "CLASSNAME_BILLING_CLIENT_STATE_LISTENER", "CLASSNAME_PURCHASE", "CLASSNAME_PURCHASES_RESULT", "CLASSNAME_PURCHASE_HISTORY_RECORD", "CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER", "CLASSNAME_PURCHASE_UPDATED_LISTENER", "CLASSNAME_SKU_DETAILS", "CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER", "IN_APP", "METHOD_BUILD", "METHOD_ENABLE_PENDING_PURCHASES", "METHOD_GET_ORIGINAL_JSON", "METHOD_GET_PURCHASE_LIST", "METHOD_NEW_BUILDER", "METHOD_ON_BILLING_SERVICE_DISCONNECTED", "METHOD_ON_BILLING_SETUP_FINISHED", "METHOD_ON_PURCHASE_HISTORY_RESPONSE", "METHOD_ON_SKU_DETAILS_RESPONSE", "METHOD_QUERY_PURCHASES", "METHOD_QUERY_PURCHASE_HISTORY_ASYNC", "METHOD_QUERY_SKU_DETAILS_ASYNC", "METHOD_SET_LISTENER", "METHOD_START_CONNECTION", "PACKAGE_NAME", "PRODUCT_ID", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "isServiceConnected", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "purchaseDetailsMap", "", "Lorg/json/JSONObject;", "getPurchaseDetailsMap", "()Ljava/util/Map;", "skuDetailsMap", "getSkuDetailsMap", "createBillingClient", "context", "Landroid/content/Context;", "billingClientClazz", "Ljava/lang/Class;", "createInstance", "", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        private final Object a(Context context, Class<?> class2) {
            Class arr2;
            int i;
            int i3;
            Method arr;
            Method method3;
            int i2;
            Method method;
            Method method2;
            String str;
            Object obj11;
            Class obj12;
            Class cls = h.a("com.android.billingclient.api.BillingClient$Builder");
            arr2 = h.a("com.android.billingclient.api.PurchasesUpdatedListener");
            i = 0;
            if (cls != null) {
                if (arr2 == null) {
                } else {
                    i3 = 1;
                    Class[] arr3 = new Class[i3];
                    i2 = 0;
                    arr3[i2] = Context.class;
                    arr = h.b(class2, "newBuilder", arr3);
                    method3 = h.b(cls, "enablePendingPurchases", new Class[i2]);
                    Class[] arr5 = new Class[i3];
                    arr5[i2] = arr2;
                    method = h.b(cls, "setListener", arr5);
                    method2 = h.b(cls, "build", new Class[i2]);
                    if (arr != null && method3 != null && method != null) {
                        if (method3 != null) {
                            if (method != null) {
                                if (method2 == null) {
                                } else {
                                    str = new Object[i3];
                                    str[i2] = context;
                                    obj11 = h.c(class2, arr, i, str);
                                    arr = new Class[i3];
                                    arr[i2] = arr2;
                                    c.d dVar = new c.d();
                                    obj12 = Proxy.newProxyInstance(arr2.getClassLoader(), arr, dVar);
                                    n.e(obj12, "Proxy.newProxyInstance(\n…UpdatedListenerWrapper())");
                                    arr2 = new Object[i3];
                                    arr2[i2] = obj12;
                                    obj11 = h.c(cls, method, obj11, arr2);
                                    if (obj11 != null && obj11 == null) {
                                        arr = new Class[i3];
                                        arr[i2] = arr2;
                                        dVar = new c.d();
                                        obj12 = Proxy.newProxyInstance(arr2.getClassLoader(), arr, dVar);
                                        n.e(obj12, "Proxy.newProxyInstance(\n…UpdatedListenerWrapper())");
                                        arr2 = new Object[i3];
                                        arr2[i2] = obj12;
                                        obj11 = h.c(cls, method, obj11, arr2);
                                        if (obj11 == null) {
                                            return i;
                                        }
                                        obj11 = h.c(cls, method3, obj11, new Object[i2]);
                                        if (obj11 == null) {
                                        } else {
                                            i = h.c(cls, method2, obj11, new Object[i2]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return i;
        }

        private final void b(Context context) {
            Object method;
            Class[] arr;
            Context context2;
            Object cls;
            int i;
            com.facebook.e0.t.c cVar;
            Class<String> obj = String.class;
            final com.facebook.e0.t.g gVar = g.i.b();
            final Class cls2 = h.a("com.android.billingclient.api.BillingClient");
            final Class cls4 = h.a("com.android.billingclient.api.Purchase");
            final Class cls3 = h.a("com.android.billingclient.api.Purchase$PurchasesResult");
            final Class cls5 = h.a("com.android.billingclient.api.SkuDetails");
            final Class cls6 = h.a("com.android.billingclient.api.PurchaseHistoryRecord");
            final Class cls7 = h.a("com.android.billingclient.api.SkuDetailsResponseListener");
            final Class cls8 = h.a("com.android.billingclient.api.PurchaseHistoryResponseListener");
            if (gVar != null && cls2 != null && cls3 != null && cls4 != null && cls5 != null && cls7 != null && cls6 != null) {
                cls2 = h.a("com.android.billingclient.api.BillingClient");
                cls4 = h.a("com.android.billingclient.api.Purchase");
                cls3 = h.a("com.android.billingclient.api.Purchase$PurchasesResult");
                cls5 = h.a("com.android.billingclient.api.SkuDetails");
                cls6 = h.a("com.android.billingclient.api.PurchaseHistoryRecord");
                cls7 = h.a("com.android.billingclient.api.SkuDetailsResponseListener");
                cls8 = h.a("com.android.billingclient.api.PurchaseHistoryResponseListener");
                if (cls2 != null) {
                    if (cls3 != null) {
                        if (cls4 != null) {
                            if (cls5 != null) {
                                if (cls7 != null) {
                                    if (cls6 != null) {
                                        if (cls8 == null) {
                                        } else {
                                            int i3 = 1;
                                            Class[] arr2 = new Class[i3];
                                            int i5 = 0;
                                            arr2[i5] = obj;
                                            final Method method2 = h.b(cls2, "queryPurchases", arr2);
                                            final Method method3 = h.b(cls3, "getPurchasesList", new Class[i5]);
                                            String str12 = "getOriginalJson";
                                            final Method method4 = h.b(cls4, str12, new Class[i5]);
                                            final Method method5 = h.b(cls5, str12, new Class[i5]);
                                            final Method method6 = h.b(cls6, str12, new Class[i5]);
                                            int i4 = 2;
                                            Class[] arr7 = new Class[i4];
                                            arr7[i5] = gVar.e();
                                            arr7[i3] = cls7;
                                            method = h.b(cls2, "querySkuDetailsAsync", arr7);
                                            arr = new Class[i4];
                                            arr[i5] = obj;
                                            arr[1] = cls8;
                                            final Method method7 = h.b(cls2, "queryPurchaseHistoryAsync", arr);
                                            if (method2 != null && method3 != null && method4 != null && method5 != null && method6 != null && method != null) {
                                                if (method3 != null) {
                                                    if (method4 != null) {
                                                        if (method5 != null) {
                                                            if (method6 != null) {
                                                                if (method != null) {
                                                                    if (method7 == null) {
                                                                    } else {
                                                                        Object obj6 = this.a(context, cls2);
                                                                        if (obj6 != null) {
                                                                            super(context, obj6, cls2, cls3, cls4, cls5, cls6, cls7, cls8, method2, method3, method4, method5, method6, method, method7, gVar, 0);
                                                                            c.m(cVar);
                                                                            method = c.f();
                                                                            Objects.requireNonNull(method, "null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
                                                                            c.n(method);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        Object obj4 = this;
                                    }
                                }
                            }
                        }
                    }
                }
                Object obj3 = this;
            }
            Object obj2 = this;
        }

        public final com.facebook.e0.t.c c(Context context) {
            n.f(context, "context");
            synchronized (this) {
                try {
                    return c.f();
                    b(context);
                    c.e().set(true);
                    return c.f();
                    throw context;
                }
            }
        }

        public final Map<String, JSONObject> d() {
            return c.g();
        }

        public final Map<String, JSONObject> e() {
            return c.j();
        }

        public final AtomicBoolean f() {
            return c.k();
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008\u0081\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u000cH\u0002J0\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\u0015", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchaseHistoryResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "getPurchaseHistoryRecord", "", "purchaseHistoryRecordList", "", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public final class c implements InvocationHandler {

        private Runnable a;
        final com.facebook.e0.t.c b;
        public c(com.facebook.e0.t.c c, Runnable runnable2) {
            n.f(runnable2, "runnable");
            this.b = c;
            super();
            this.a = runnable2;
        }

        private final void a(List<?> list) {
            boolean string;
            boolean jSONObject;
            Object str;
            Object[] arr;
            final String str2 = "productId";
            if (a.d(this)) {
            }
            Iterator obj6 = list.iterator();
            while (obj6.hasNext()) {
                if (string instanceof String == null) {
                }
                jSONObject = new JSONObject((String)string);
                jSONObject.put("packageName", c.a(this.b).getPackageName());
                if (string != null && jSONObject.has(str2)) {
                }
                jSONObject = new JSONObject(string);
                jSONObject.put("packageName", c.a(this.b).getPackageName());
                if (jSONObject.has(str2)) {
                }
                string = jSONObject.getString(str2);
                c.d(this.b).add(string);
                n.e(string, "skuID");
                c.x.d().put(string, jSONObject);
                string = 0;
            }
            try {
                this.a.run();
                a.b(list, this);
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object object, Method method2, Object[] object3Arr3) {
            int obj3;
            String obj4;
            final int i = 0;
            if (a.d(this)) {
                return i;
            }
            n.f(object, "proxy");
            n.f(method2, "method");
            if (n.b(method2.getName(), "onPurchaseHistoryResponse")) {
                obj3 = object3Arr3 != null ? object3Arr3[obj3] : i;
                if (obj3 != null && obj3 instanceof List != null) {
                    if (obj3 instanceof List != null) {
                        try {
                            a((List)obj3);
                            return i;
                            a.b(object, this);
                            return obj1;
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchasesUpdatedListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class d implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object object, Method method2, Object[] object3Arr3) {
            final int i = 0;
            if (a.d(this)) {
                return i;
            }
            n.f(object, "proxy");
            n.f(method2, "m");
            return i;
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0008\u0081\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\u0015", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$SkuDetailsResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "parseSkuDetails", "", "skuDetailsObjectList", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public final class e implements InvocationHandler {

        private Runnable a;
        final com.facebook.e0.t.c b;
        public e(com.facebook.e0.t.c c, Runnable runnable2) {
            n.f(runnable2, "runnable");
            this.b = c;
            super();
            this.a = runnable2;
        }

        public final void a(List<?> list) {
            String string;
            boolean jSONObject;
            Object obj;
            Object[] arr;
            final String str = "productId";
            if (a.d(this)) {
            }
            n.f(list, "skuDetailsObjectList");
            Iterator obj6 = list.iterator();
            while (obj6.hasNext()) {
                if (string instanceof String == null) {
                }
                jSONObject = new JSONObject((String)string);
                if (string != null && jSONObject.has(str) != null) {
                }
                jSONObject = new JSONObject(string);
                if (jSONObject.has(str) != null) {
                }
                string = jSONObject.getString(str);
                n.e(string, "skuID");
                c.x.e().put(string, jSONObject);
                string = 0;
            }
            try {
                this.a.run();
                a.b(list, this);
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object object, Method method2, Object[] object3Arr3) {
            int obj3;
            String obj4;
            final int i = 0;
            if (a.d(this)) {
                return i;
            }
            n.f(object, "proxy");
            n.f(method2, "m");
            if (n.b(method2.getName(), "onSkuDetailsResponse")) {
                obj3 = object3Arr3 != null ? object3Arr3[obj3] : i;
                if (obj3 != null && obj3 instanceof List != null) {
                    if (obj3 instanceof List != null) {
                        try {
                            a((List)obj3);
                            return i;
                            a.b(object, this);
                            return obj1;
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class f implements Runnable {

        final com.facebook.e0.t.c a;
        final Runnable b;
        f(com.facebook.e0.t.c c, Runnable runnable2) {
            this.a = c;
            this.b = runnable2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            ArrayList arrayList = new ArrayList(c.d(this.a));
            c.l(this.a, "inapp", arrayList, this.b);
        }
    }
    static {
        c.b bVar = new c.b(0);
        c.x = bVar;
        int i2 = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i2);
        c.s = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(i2);
        c.u = atomicBoolean2;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        c.v = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        c.w = concurrentHashMap2;
    }

    private c(Context context, Object object2, Class<?> class3, Class<?> class4, Class<?> class5, Class<?> class6, Class<?> class7, Class<?> class8, Class<?> class9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, com.facebook.e0.t.g g17) {
        final Object obj = this;
        super();
        obj.b = context;
        obj.c = object2;
        obj.d = class3;
        obj.e = class4;
        obj.f = class5;
        obj.g = class6;
        obj.h = class7;
        obj.i = class8;
        obj.j = class9;
        obj.k = method10;
        obj.l = method11;
        obj.m = method12;
        obj.n = method13;
        obj.o = method14;
        obj.p = method15;
        obj.q = method16;
        obj.r = g17;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        obj.a = copyOnWriteArraySet;
    }

    public c(Context context, Object object2, Class class3, Class class4, Class class5, Class class6, Class class7, Class class8, Class class9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, com.facebook.e0.t.g g17, g g18) {
        super(context, object2, class3, class4, class5, class6, class7, class8, class9, method10, method11, method12, method13, method14, method15, method16, g17);
    }

    public static final Context a(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
            return null;
        }
        return c.b;
    }

    public static final Method b(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
            return null;
        }
        return c.o;
    }

    public static final Method c(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
            return null;
        }
        return c.n;
    }

    public static final Set d(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
            return null;
        }
        return c.a;
    }

    public static final AtomicBoolean e() {
        if (a.d(c.class)) {
            return null;
        }
        return c.s;
    }

    public static final com.facebook.e0.t.c f() {
        if (a.d(c.class)) {
            return null;
        }
        return c.t;
    }

    public static final Map g() {
        if (a.d(c.class)) {
            return null;
        }
        return c.v;
    }

    public static final Class h(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
            return null;
        }
        return c.h;
    }

    public static final Class i(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
            return null;
        }
        return c.g;
    }

    public static final Map j() {
        if (a.d(c.class)) {
            return null;
        }
        return c.w;
    }

    public static final AtomicBoolean k() {
        if (a.d(c.class)) {
            return null;
        }
        return c.u;
    }

    public static final void l(com.facebook.e0.t.c c, String string2, List list3, Runnable runnable4) {
        if (a.d(c.class)) {
        }
        c.r(string2, list3, runnable4);
    }

    public static final void m(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
        }
        c.t = c;
    }

    public static final void n(com.facebook.e0.t.c c) {
        if (a.d(c.class)) {
        }
        c.s();
    }

    private final void q(String string, Runnable runnable2) {
        if (a.d(this)) {
        }
        final int i = 1;
        Class[] arr = new Class[i];
        final int i2 = 0;
        arr[i2] = this.j;
        c.c cVar = new c.c(this, runnable2);
        final Object obj8 = Proxy.newProxyInstance(this.j.getClassLoader(), arr, cVar);
        n.e(obj8, "Proxy.newProxyInstance(\n…istenerWrapper(runnable))");
        Object[] arr2 = new Object[2];
        arr2[i2] = string;
        arr2[i] = obj8;
        h.c(this.d, this.q, this.c, arr2);
    }

    private final void r(String string, List<String> list2, Runnable runnable3) {
        if (a.d(this)) {
        }
        final int i = 1;
        Class[] arr = new Class[i];
        final int i3 = 0;
        arr[i3] = this.i;
        c.e eVar = new c.e(this, runnable3);
        final Object obj8 = Proxy.newProxyInstance(this.i.getClassLoader(), arr, eVar);
        n.e(obj8, "Proxy.newProxyInstance(\n…istenerWrapper(runnable))");
        Object[] arr2 = new Object[2];
        arr2[i3] = this.r.d(string, list2);
        arr2[i] = obj8;
        h.c(this.d, this.p, this.c, arr2);
    }

    private final void s() {
        Object proxyInstance;
        Method method;
        Object str;
        int arr2;
        Class[] arr;
        int i;
        if (a.d(this)) {
        }
        proxyInstance = h.a("com.android.billingclient.api.BillingClientStateListener");
        arr2 = 1;
        arr = new Class[arr2];
        i = 0;
        arr[i] = proxyInstance;
        method = h.b(this.d, "startConnection", arr);
        if (proxyInstance != null && method != null) {
            arr2 = 1;
            arr = new Class[arr2];
            i = 0;
            arr[i] = proxyInstance;
            method = h.b(this.d, "startConnection", arr);
            if (method != null) {
                Class[] arr3 = new Class[arr2];
                arr3[i] = proxyInstance;
                c.a aVar = new c.a();
                proxyInstance = Proxy.newProxyInstance(proxyInstance.getClassLoader(), arr3, aVar);
                n.e(proxyInstance, "Proxy.newProxyInstance(\n…ntStateListenerWrapper())");
                arr2 = new Object[arr2];
                arr2[i] = proxyInstance;
                h.c(this.d, method, this.c, arr2);
            }
        }
    }

    public final void o(String string, Runnable runnable2) {
        Object iterator;
        boolean arrayList;
        Object[] string2;
        String jSONObject;
        Object obj;
        Object[] arr;
        final String str = "productId";
        if (a.d(this)) {
        }
        n.f(string, "skuType");
        n.f(runnable2, "querySkuRunnable");
        Object[] arr2 = new Object[1];
        final int i3 = 0;
        arr2[i3] = "inapp";
        int i = 0;
        if (iterator instanceof List == null) {
            iterator = i;
        }
        if ((List)iterator != null) {
            arrayList = new ArrayList();
            iterator = (List)iterator.iterator();
            while (iterator.hasNext()) {
                if (string2 instanceof String == null) {
                }
                jSONObject = new JSONObject((String)string2);
                if (string2 != null && jSONObject.has(str) != null) {
                }
                jSONObject = new JSONObject(string2);
                if (jSONObject.has(str) != null) {
                }
                string2 = jSONObject.getString(str);
                arrayList.add(string2);
                n.e(string2, "skuID");
                c.v.put(string2, jSONObject);
                string2 = i;
            }
            r(string, arrayList, runnable2);
        }
    }

    public final void p(String string, Runnable runnable2) {
        if (a.d(this)) {
        }
        n.f(string, "skuType");
        n.f(runnable2, "queryPurchaseHistoryRunnable");
        c.f fVar = new c.f(this, runnable2);
        q(string, fVar);
    }
}
