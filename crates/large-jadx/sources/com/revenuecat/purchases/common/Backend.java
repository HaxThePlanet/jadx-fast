package com.revenuecat.purchases.common;

import android.net.Uri;
import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.c.q;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010[\u001a\u00020\t\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010^\u001a\u00020]¢\u0006\u0004\u0008`\u0010aJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0013\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJq\u0010\u0018\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0010\"\u0004\u0008\u0001\u0010\u0011\"\u0004\u0008\u0002\u0010\u0012* \u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00150\u00140\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00028\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00152\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\u0008\u001a\u0010\u001bJc\u0010&\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f2 \u0010%\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060\"¢\u0006\u0004\u0008&\u0010'JE\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00042\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0004\u0008,\u0010-J¥\u0001\u00108\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042 \u00101\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001d2\u0006\u00103\u001a\u0002022\u0008\u00104\u001a\u0004\u0018\u00010\t2\u001c\u0010+\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000605j\u0002`62$\u0010!\u001a \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\u00060\"j\u0002`7¢\u0006\u0004\u00088\u00109JE\u0010:\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00042\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0004\u0008:\u0010-J?\u0010?\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u000c\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00060<2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0004\u0008?\u0010@JK\u0010A\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006052\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f¢\u0006\u0004\u0008A\u0010BJ\r\u0010C\u001a\u00020\u0006¢\u0006\u0004\u0008C\u0010\u001bR\u009e\u0001\u0010F\u001a<\u0012\u0004\u0012\u00020\t\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f0\u0015j\u0002`D0\u00140\u00132@\u0010E\u001a<\u0012\u0004\u0012\u00020\t\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f0\u0015j\u0002`D0\u00140\u00138F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008F\u0010G\u001a\u0004\u0008H\u0010I\"\u0004\u0008J\u0010KR(\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001d8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008L\u0010G\u001a\u0004\u0008M\u0010IR²\u0001\u0010Q\u001aF\u0012\u000e\u0012\u000c\u0012\u0004\u0012\u00020\t0Nj\u0002`O\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f0\u0015j\u0002`P0\u00140\u00132J\u0010E\u001aF\u0012\u000e\u0012\u000c\u0012\u0004\u0012\u00020\t0Nj\u0002`O\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00060\u001f0\u0015j\u0002`P0\u00140\u00138F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008Q\u0010G\u001a\u0004\u0008R\u0010I\"\u0004\u0008S\u0010KRê\u0001\u0010U\u001ab\u0012\u000e\u0012\u000c\u0012\u0004\u0012\u00020\t0Nj\u0002`O\u0012N\u0012L\u0012H\u0012F\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000605j\u0002`6\u0012\"\u0012 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\u00060\"j\u0002`70\u0015j\u0002`T0\u00140\u00132f\u0010E\u001ab\u0012\u000e\u0012\u000c\u0012\u0004\u0012\u00020\t0Nj\u0002`O\u0012N\u0012L\u0012H\u0012F\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000605j\u0002`6\u0012\"\u0012 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\u00060\"j\u0002`70\u0015j\u0002`T0\u00140\u00138F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008U\u0010G\u001a\u0004\u0008V\u0010I\"\u0004\u0008W\u0010KR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008Y\u0010ZR\u0016\u0010[\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008^\u0010_¨\u0006b", d2 = {"Lcom/revenuecat/purchases/common/Backend;", "", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "call", "", "randomDelay", "Lkotlin/w;", "enqueue", "(Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Z)V", "", "string", "encode", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "isSuccessful", "(Lcom/revenuecat/purchases/common/networking/HTTPResult;)Z", "K", "S", "E", "", "", "Lkotlin/o;", "cacheKey", "functions", "addCallback", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Ljava/lang/Object;Lkotlin/o;Z)V", "close", "()V", "path", "", "body", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "Lkotlin/Function3;", "", "Lorg/json/JSONObject;", "onCompleted", "performRequest", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/d0/c/l;Lkotlin/d0/c/q;)V", "appUserID", "appInBackground", "Lcom/revenuecat/purchases/PurchaserInfo;", "onSuccess", "getPurchaserInfo", "(Ljava/lang/String;ZLkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "purchaseToken", "isRestore", "observerMode", "subscriberAttributes", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "receiptInfo", "storeAppUserID", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "postReceiptData", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lcom/revenuecat/purchases/common/ReceiptInfo;Ljava/lang/String;Lkotlin/d0/c/p;Lkotlin/d0/c/q;)V", "getOfferings", "newAppUserID", "Lkotlin/Function0;", "onSuccessHandler", "onErrorHandler", "createAlias", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/d0/c/a;Lkotlin/d0/c/l;)V", "logIn", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/d0/c/p;Lkotlin/d0/c/l;)V", "clearCaches", "Lcom/revenuecat/purchases/common/OfferingsCallback;", "<set-?>", "offeringsCallbacks", "Ljava/util/Map;", "getOfferingsCallbacks", "()Ljava/util/Map;", "setOfferingsCallbacks", "(Ljava/util/Map;)V", "authenticationHeaders", "getAuthenticationHeaders$common_release", "", "Lcom/revenuecat/purchases/common/CallbackCacheKey;", "Lcom/revenuecat/purchases/common/PurchaserInfoCallback;", "callbacks", "getCallbacks", "setCallbacks", "Lcom/revenuecat/purchases/common/PostReceiptCallback;", "postReceiptCallbacks", "getPostReceiptCallbacks", "setPostReceiptCallbacks", "Lcom/revenuecat/purchases/common/Dispatcher;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "apiKey", "Ljava/lang/String;", "Lcom/revenuecat/purchases/common/HTTPClient;", "httpClient", "Lcom/revenuecat/purchases/common/HTTPClient;", "<init>", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/HTTPClient;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class Backend {

    private final String apiKey;
    private final Map<String, String> authenticationHeaders;
    private volatile Map<List<String>, List<o<l<PurchaserInfo, w>, l<PurchasesError, w>>>> callbacks;
    private final com.revenuecat.purchases.common.Dispatcher dispatcher;
    private final com.revenuecat.purchases.common.HTTPClient httpClient;
    private volatile Map<String, List<o<l<JSONObject, w>, l<PurchasesError, w>>>> offeringsCallbacks;
    private volatile Map<List<String>, List<o<p<PurchaserInfo, JSONObject, w>, q<PurchasesError, Boolean, JSONObject, w>>>> postReceiptCallbacks;
    public Backend(String string, com.revenuecat.purchases.common.Dispatcher dispatcher2, com.revenuecat.purchases.common.HTTPClient hTTPClient3) {
        n.f(string, "apiKey");
        n.f(dispatcher2, "dispatcher");
        n.f(hTTPClient3, "httpClient");
        super();
        this.apiKey = string;
        this.dispatcher = dispatcher2;
        this.httpClient = hTTPClient3;
        StringBuilder obj3 = new StringBuilder();
        obj3.append("Bearer ");
        obj3.append(string);
        this.authenticationHeaders = j0.e(u.a("Authorization", obj3.toString()));
        LinkedHashMap obj2 = new LinkedHashMap();
        this.callbacks = obj2;
        obj2 = new LinkedHashMap();
        this.postReceiptCallbacks = obj2;
        obj2 = new LinkedHashMap();
        this.offeringsCallbacks = obj2;
    }

    public static final String access$encode(com.revenuecat.purchases.common.Backend backend, String string2) {
        return backend.encode(string2);
    }

    public static final com.revenuecat.purchases.common.HTTPClient access$getHttpClient$p(com.revenuecat.purchases.common.Backend backend) {
        return backend.httpClient;
    }

    public static final boolean access$isSuccessful(com.revenuecat.purchases.common.Backend backend, HTTPResult hTTPResult2) {
        return backend.isSuccessful(hTTPResult2);
    }

    private final <K, S, E> void addCallback(Map<K, List<o<S, E>>> map, com.revenuecat.purchases.common.Dispatcher.AsyncCall dispatcher$AsyncCall2, K k3, o<? extends S, ? extends E> o4, boolean z5) {
        o[] key;
        int i;
        Object obj3;
        Object obj6;
        if (!map.containsKey(k3)) {
            key = new o[1];
            map.put(k3, p.m(o4));
            enqueue(asyncCall2, z5);
        } else {
            obj3 = map.get(k3);
            n.d(obj3);
            (List)obj3.add(o4);
        }
    }

    static void addCallback$default(com.revenuecat.purchases.common.Backend backend, Map map2, com.revenuecat.purchases.common.Dispatcher.AsyncCall dispatcher$AsyncCall3, Object object4, o o5, boolean z6, int i7, Object object8) {
        int obj11;
        if (i7 &= 8 != 0) {
            obj11 = 0;
        }
        backend.addCallback(map2, asyncCall3, object4, o5, obj11);
    }

    private final String encode(String string) {
        final String obj2 = Uri.encode(string);
        n.e(obj2, "Uri.encode(string)");
        return obj2;
    }

    private final void enqueue(com.revenuecat.purchases.common.Dispatcher.AsyncCall dispatcher$AsyncCall, boolean z2) {
        boolean dispatcher;
        if (!this.dispatcher.isClosed()) {
            this.dispatcher.enqueue(asyncCall, z2);
        }
    }

    static void enqueue$default(com.revenuecat.purchases.common.Backend backend, com.revenuecat.purchases.common.Dispatcher.AsyncCall dispatcher$AsyncCall2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        backend.enqueue(asyncCall2, obj2);
    }

    private final boolean isSuccessful(HTTPResult hTTPResult) {
        int obj2;
        obj2 = hTTPResult.getResponseCode() < 300 ? 1 : 0;
        return obj2;
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    public final void close() {
        this.dispatcher.close();
    }

    public final void createAlias(String string, String string2, a<w> a3, l<? super PurchasesError, w> l4) {
        n.f(string, "appUserID");
        n.f(string2, "newAppUserID");
        n.f(a3, "onSuccessHandler");
        n.f(l4, "onErrorHandler");
        super(this, string, string2, l4, a3);
        Backend.enqueue$default(this, anon, false, 2, 0);
    }

    public final Map<String, String> getAuthenticationHeaders$common_release() {
        return this.authenticationHeaders;
    }

    public final Map<List<String>, List<o<l<PurchaserInfo, w>, l<PurchasesError, w>>>> getCallbacks() {
        return this.callbacks;
        synchronized (this) {
            return this.callbacks;
        }
    }

    public final void getOfferings(String string, boolean z2, l<? super JSONObject, w> l3, l<? super PurchasesError, w> l4) {
        n.f(string, "appUserID");
        n.f(l3, "onSuccess");
        n.f(l4, "onError");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/subscribers/");
        stringBuilder.append(encode(string));
        stringBuilder.append("/offerings");
        final String string2 = stringBuilder.toString();
        Backend.getOfferings.call.1 anon = new Backend.getOfferings.call.1(this, string2);
        this.addCallback(this.offeringsCallbacks, anon, string2, u.a(l3, l4), z2);
        w obj8 = w.a;
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            n.f(l3, "onSuccess");
            n.f(l4, "onError");
            stringBuilder = new StringBuilder();
            stringBuilder.append("/subscribers/");
            stringBuilder.append(encode(string));
            stringBuilder.append("/offerings");
            string2 = stringBuilder.toString();
            anon = new Backend.getOfferings.call.1(this, string2);
            this.addCallback(this.offeringsCallbacks, anon, string2, u.a(l3, l4), z2);
            obj8 = w.a;
        }
    }

    public final Map<String, List<o<l<JSONObject, w>, l<PurchasesError, w>>>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
        synchronized (this) {
            return this.offeringsCallbacks;
        }
    }

    public final Map<List<String>, List<o<p<PurchaserInfo, JSONObject, w>, q<PurchasesError, Boolean, JSONObject, w>>>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
        synchronized (this) {
            return this.postReceiptCallbacks;
        }
    }

    public final void getPurchaserInfo(String string, boolean z2, l<? super PurchaserInfo, w> l3, l<? super PurchasesError, w> l4) {
        n.f(string, "appUserID");
        n.f(l3, "onSuccess");
        n.f(l4, "onError");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/subscribers/");
        stringBuilder.append(encode(string));
        String obj7 = stringBuilder.toString();
        final List list = p.b(obj7);
        Backend.getPurchaserInfo.call.1 anon = new Backend.getPurchaserInfo.call.1(this, obj7, list);
        this.addCallback(this.callbacks, anon, list, u.a(l3, l4), z2);
        obj7 = w.a;
        return;
        synchronized (this) {
            n.f(string, "appUserID");
            n.f(l3, "onSuccess");
            n.f(l4, "onError");
            stringBuilder = new StringBuilder();
            stringBuilder.append("/subscribers/");
            stringBuilder.append(encode(string));
            obj7 = stringBuilder.toString();
            list = p.b(obj7);
            anon = new Backend.getPurchaserInfo.call.1(this, obj7, list);
            this.addCallback(this.callbacks, anon, list, u.a(l3, l4), z2);
            obj7 = w.a;
        }
    }

    public final void logIn(String string, String string2, p<? super PurchaserInfo, ? super Boolean, w> p3, l<? super PurchasesError, w> l4) {
        n.f(string, "appUserID");
        n.f(string2, "newAppUserID");
        n.f(p3, "onSuccessHandler");
        n.f(l4, "onErrorHandler");
        super(this, string2, string, l4, p3);
        Backend.enqueue$default(this, anon, false, 2, 0);
    }

    public final void performRequest(String string, Map<String, ? extends Object> map2, l<? super PurchasesError, w> l3, q<? super PurchasesError, ? super Integer, ? super JSONObject, w> q4) {
        n.f(string, "path");
        n.f(l3, "onError");
        n.f(q4, "onCompleted");
        super(this, string, map2, l3, q4);
        Backend.enqueue$default(this, anon, false, 2, 0);
    }

    public final void postReceiptData(String string, String string2, boolean z3, boolean z4, Map<String, ? extends Map<String, ? extends Object>> map5, com.revenuecat.purchases.common.ReceiptInfo receiptInfo6, String string7, p<? super PurchaserInfo, ? super JSONObject, w> p8, q<? super PurchasesError, ? super Boolean, ? super JSONObject, w> q9) {
        int i;
        String value;
        o[] arr;
        final com.revenuecat.purchases.common.Backend backend = this;
        Object obj = string;
        Object obj2 = string2;
        value = string7;
        n.f(obj, "purchaseToken");
        n.f(obj2, "appUserID");
        Object obj3 = map5;
        n.f(obj3, "subscriberAttributes");
        n.f(receiptInfo6, "receiptInfo");
        n.f(p8, "onSuccess");
        n.f(q9, "onError");
        String[] strArr = new String[7];
        final int i14 = 0;
        strArr[i14] = obj;
        final int i15 = 1;
        strArr[i15] = obj2;
        final int i17 = 2;
        strArr[i17] = String.valueOf(z3);
        final int i18 = 3;
        strArr[i18] = String.valueOf(z4);
        final int i19 = 4;
        strArr[i19] = map5.toString();
        final int i20 = 5;
        strArr[i20] = receiptInfo6.toString();
        strArr[6] = value;
        List list = p.l(strArr);
        arr = new o[13];
        arr[i14] = u.a("fetch_token", obj);
        arr[i15] = u.a("product_ids", receiptInfo6.getProductIDs());
        arr[i17] = u.a("app_user_id", obj2);
        arr[i18] = u.a("is_restore", Boolean.valueOf(z3));
        arr[i19] = u.a("presented_offering_identifier", receiptInfo6.getOfferingIdentifier());
        arr[i20] = u.a("observer_mode", Boolean.valueOf(z4));
        arr[6] = u.a("price", receiptInfo6.getPrice());
        arr[7] = u.a("currency", receiptInfo6.getCurrency());
        i = !map5.isEmpty() ? obj3 : 0;
        arr[8] = u.a("attributes", i);
        arr[9] = u.a("normal_duration", receiptInfo6.getDuration());
        arr[10] = u.a("intro_duration", receiptInfo6.getIntroDuration());
        arr[11] = u.a("trial_duration", receiptInfo6.getTrialDuration());
        arr[12] = u.a("store_user_id", value);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = j0.k(arr).entrySet().iterator();
        while (iterator.hasNext()) {
            value = iterator.next();
            if ((Map.Entry)value.getValue() != null) {
            } else {
            }
            arr = i14;
            if (arr != null) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
            arr = i15;
        }
        Backend.postReceiptData.call.1 anon = new Backend.postReceiptData.call.1(backend, linkedHashMap, list);
        Backend.addCallback$default(this, backend.postReceiptCallbacks, anon, list, u.a(p8, q9), false, 8, 0);
        w wVar = w.a;
        return;
        synchronized (this) {
            anon = new Backend.postReceiptData.call.1(backend, linkedHashMap, list);
            Backend.addCallback$default(this, backend.postReceiptCallbacks, anon, list, u.a(p8, q9), false, 8, 0);
            wVar = w.a;
        }
    }

    public final void setCallbacks(Map<List<String>, List<o<l<PurchaserInfo, w>, l<PurchasesError, w>>>> map) {
        n.f(map, "<set-?>");
        this.callbacks = map;
        return;
        synchronized (this) {
            n.f(map, "<set-?>");
            this.callbacks = map;
        }
    }

    public final void setOfferingsCallbacks(Map<String, List<o<l<JSONObject, w>, l<PurchasesError, w>>>> map) {
        n.f(map, "<set-?>");
        this.offeringsCallbacks = map;
        return;
        synchronized (this) {
            n.f(map, "<set-?>");
            this.offeringsCallbacks = map;
        }
    }

    public final void setPostReceiptCallbacks(Map<List<String>, List<o<p<PurchaserInfo, JSONObject, w>, q<PurchasesError, Boolean, JSONObject, w>>>> map) {
        n.f(map, "<set-?>");
        this.postReceiptCallbacks = map;
        return;
        synchronized (this) {
            n.f(map, "<set-?>");
            this.postReceiptCallbacks = map;
        }
    }
}
