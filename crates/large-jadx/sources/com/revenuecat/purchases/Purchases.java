package com.revenuecat.purchases;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Pair;
import androidx.lifecycle.a0;
import androidx.lifecycle.j;
import androidx.lifecycle.q;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.c;
import com.android.billingclient.api.c.b;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener;
import com.revenuecat.purchases.common.BillingAbstract.StateListener;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.HTTPClient;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.attribution.AttributionData;
import com.revenuecat.purchases.common.attribution.AttributionNetwork;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.ETagManager.Companion;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import com.revenuecat.purchases.google.SkuDetailsConverterKt;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetProductDetailsCallback;
import com.revenuecat.purchases.interfaces.GetSkusResponseListener;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.MakePurchaseListener;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallbackKt;
import com.revenuecat.purchases.interfaces.ProductChangeListener;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallbackKt;
import com.revenuecat.purchases.interfaces.PurchaseErrorListener;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsListener;
import com.revenuecat.purchases.interfaces.ReceivePurchaserInfoListener;
import com.revenuecat.purchases.interfaces.UpdatedPurchaserInfoListener;
import com.revenuecat.purchases.models.ProductDetails;
import com.revenuecat.purchases.models.PurchaseDetails;
import com.revenuecat.purchases.models.RevenueCatPurchaseState;
import com.revenuecat.purchases.subscriberattributes.AttributionDataMigrator;
import com.revenuecat.purchases.subscriberattributes.AttributionFetcher;
import com.revenuecat.purchases.subscriberattributes.BackendHelpersKt;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.AttributionIds.Adjust;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.AttributionIds.AppsFlyer;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.AttributionIds.Facebook;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.AttributionIds.Mparticle;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.AttributionIds.OneSignal;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.CampaignParameters.Ad;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.CampaignParameters.AdGroup;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.CampaignParameters.Campaign;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.CampaignParameters.Creative;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.CampaignParameters.Keyword;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.CampaignParameters.MediaSource;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.DisplayName;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.Email;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.FCMTokens;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.PhoneNumber;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.util.AdvertisingIdClient;
import com.revenuecat.purchases.util.AdvertisingIdClient.AdInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.o;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010$\n\u0002\u0008#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u0087\u00022\u00020\u0001:\u0004\u0088\u0002\u0087\u0002Bf\u0008\u0001\u0012\u0008\u0010ü\u0001\u001a\u00030û\u0001\u0012\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u0008\u0010Î\u0001\u001a\u00030Í\u0001\u0012\u0008\u0010ÿ\u0001\u001a\u00030þ\u0001\u0012\u0008\u0010ù\u0001\u001a\u00030ø\u0001\u0012\u0008\u0010Û\u0001\u001a\u00030Ú\u0001\u0012\u0008\u0010Ñ\u0001\u001a\u00030Ð\u0001\u0012\u0008\u0010\u0082\u0002\u001a\u00030\u0081\u0002\u0012\u0008\u0010Þ\u0001\u001a\u00030Ý\u0001¢\u0006\u0006\u0008\u0085\u0002\u0010\u0086\u0002J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001f\u0010\u000b\u001a\u00020\u0002*\u0004\u0018\u00010\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ+\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J=\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00172\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a`\u001bH\u0002¢\u0006\u0004\u0008\u001d\u0010\u001eJ-\u0010%\u001a\u00020\u00062\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\u0008%\u0010&J#\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008'\u0010\u0008J+\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008(\u0010)J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\u0008,\u0010-J}\u00108\u001a\u00020\u00062\u000c\u00100\u001a\u0008\u0012\u0004\u0012\u00020/0.2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0008\u0002\u00105\u001a\u001c\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0006\u0018\u000103j\u0004\u0018\u0001`42\"\u0008\u0002\u00107\u001a\u001c\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0006\u0018\u000103j\u0004\u0018\u0001`6H\u0002¢\u0006\u0004\u00088\u00109Ja\u0010<\u001a\u00020\u00062\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001f2.\u0010;\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a`\u001b\u0012\u0004\u0012\u00020\u00060:2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060:H\u0002¢\u0006\u0004\u0008<\u0010=J\u0019\u0010?\u001a\u00020\u00062\u0008\u0010\u0005\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\u0008?\u0010@J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\u0008A\u0010-J\u001d\u0010D\u001a\u00020\u00062\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00060BH\u0002¢\u0006\u0004\u0008D\u0010EJ\u0019\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010F\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008H\u0010IJ\u0011\u0010K\u001a\u0004\u0018\u00010JH\u0002¢\u0006\u0004\u0008K\u0010LJ\u000f\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\u0008N\u0010OJG\u0010Q\u001a:\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000603j\u0002`4\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000603j\u0002`60PH\u0002¢\u0006\u0004\u0008Q\u0010RJQ\u0010T\u001a:\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000603j\u0002`4\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000603j\u0002`60P2\u0008\u0010S\u001a\u0004\u0018\u00010JH\u0002¢\u0006\u0004\u0008T\u0010UJ\u001b\u0010D\u001a\u00020\u0006*\u00020V2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\u0008D\u0010WJ1\u0010\\\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020\u001a2\u0008\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020GH\u0002¢\u0006\u0004\u0008\\\u0010]J9\u0010b\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0006\u0010^\u001a\u00020\u001a2\u0008\u0010_\u001a\u0004\u0018\u00010\u00022\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020JH\u0002¢\u0006\u0004\u0008b\u0010cJA\u0010d\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u001a2\u0006\u0010a\u001a\u00020`2\u0006\u0010Y\u001a\u00020X2\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010[\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020VH\u0002¢\u0006\u0004\u0008d\u0010eJ\u000f\u0010f\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008f\u0010gJ\u000f\u0010h\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008h\u0010gJ\u000f\u0010i\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008i\u0010gJ\r\u0010j\u001a\u00020\u0006¢\u0006\u0004\u0008j\u0010gJ\u0015\u0010k\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000f¢\u0006\u0004\u0008k\u0010lJ#\u0010n\u001a\u00020\u00062\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00020.2\u0006\u0010\u0005\u001a\u00020m¢\u0006\u0004\u0008n\u0010oJ%\u0010n\u001a\u00020\u00062\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00020.2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\u0008p\u0010qJ#\u0010r\u001a\u00020\u00062\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00020.2\u0006\u0010\u0005\u001a\u00020m¢\u0006\u0004\u0008r\u0010oJ%\u0010r\u001a\u00020\u00062\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00020.2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\u0008s\u0010qJ/\u0010w\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0006\u0010u\u001a\u00020t2\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020vH\u0007¢\u0006\u0004\u0008w\u0010xJ-\u0010w\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0006\u0010u\u001a\u00020t2\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020y¢\u0006\u0004\u0008w\u0010zJ/\u0010w\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020JH\u0000¢\u0006\u0004\u0008{\u0010|J%\u0010w\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0006\u0010u\u001a\u00020t2\u0006\u0010\u0005\u001a\u00020v¢\u0006\u0004\u0008w\u0010}J'\u0010w\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020GH\u0000¢\u0006\u0004\u0008{\u0010~J3\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020vH\u0007¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001J1\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020y¢\u0006\u0006\u0008\u0081\u0001\u0010\u0083\u0001J3\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010a\u001a\u00020`2\u0006\u0010$\u001a\u00020JH\u0000¢\u0006\u0006\u0008\u0084\u0001\u0010\u0085\u0001J)\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010\u0005\u001a\u00020v¢\u0006\u0006\u0008\u0081\u0001\u0010\u0086\u0001J+\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020X2\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010\u0005\u001a\u00020GH\u0000¢\u0006\u0006\u0008\u0084\u0001\u0010\u0087\u0001J\u0018\u0010\u0088\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0006\u0008\u0088\u0001\u0010\u0089\u0001J&\u0010\u008b\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020\u00022\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0005\u0008\u008b\u0001\u0010\u0008J&\u0010\u008c\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020\u00022\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0005\u0008\u008c\u0001\u0010\u0008J(\u0010\u008e\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020\u00022\u000b\u0008\u0002\u0010$\u001a\u0005\u0018\u00010\u008d\u0001H\u0007¢\u0006\u0006\u0008\u008e\u0001\u0010\u008f\u0001J\u001e\u0010\u0090\u0001\u001a\u00020\u00062\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0006\u0008\u0090\u0001\u0010\u0089\u0001J\u001e\u0010\u0091\u0001\u001a\u00020\u00062\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0006\u0008\u0091\u0001\u0010\u0089\u0001J\u000f\u0010\u0092\u0001\u001a\u00020\u0006¢\u0006\u0005\u0008\u0092\u0001\u0010gJ\u0018\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0006\u0008\u0093\u0001\u0010\u0089\u0001J\u000f\u0010\u0094\u0001\u001a\u00020\u0006¢\u0006\u0005\u0008\u0094\u0001\u0010gJ\u000f\u0010\u0095\u0001\u001a\u00020\u0006¢\u0006\u0005\u0008\u0095\u0001\u0010gJ(\u0010\u0098\u0001\u001a\u00020\u00062\u0016\u0010\u0097\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0096\u0001¢\u0006\u0006\u0008\u0098\u0001\u0010\u0099\u0001J\u001b\u0010\u009b\u0001\u001a\u00020\u00062\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008\u009b\u0001\u0010\u009c\u0001J\u001b\u0010\u009e\u0001\u001a\u00020\u00062\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008\u009e\u0001\u0010\u009c\u0001J\u001b\u0010 \u0001\u001a\u00020\u00062\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008 \u0001\u0010\u009c\u0001J\u001b\u0010¢\u0001\u001a\u00020\u00062\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008¢\u0001\u0010\u009c\u0001J\u000f\u0010£\u0001\u001a\u00020\u0006¢\u0006\u0005\u0008£\u0001\u0010gJ\u001b\u0010¥\u0001\u001a\u00020\u00062\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008¥\u0001\u0010\u009c\u0001J\u001b\u0010§\u0001\u001a\u00020\u00062\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008§\u0001\u0010\u009c\u0001J\u001b\u0010©\u0001\u001a\u00020\u00062\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008©\u0001\u0010\u009c\u0001J\u001b\u0010«\u0001\u001a\u00020\u00062\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008«\u0001\u0010\u009c\u0001J\u001b\u0010­\u0001\u001a\u00020\u00062\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008­\u0001\u0010\u009c\u0001J\u001b\u0010¯\u0001\u001a\u00020\u00062\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008¯\u0001\u0010\u009c\u0001J\u001b\u0010±\u0001\u001a\u00020\u00062\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008±\u0001\u0010\u009c\u0001J\u001b\u0010³\u0001\u001a\u00020\u00062\t\u0010²\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008³\u0001\u0010\u009c\u0001J\u001b\u0010µ\u0001\u001a\u00020\u00062\t\u0010´\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008µ\u0001\u0010\u009c\u0001J\u001b\u0010·\u0001\u001a\u00020\u00062\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008·\u0001\u0010\u009c\u0001J\u001b\u0010¹\u0001\u001a\u00020\u00062\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\u0008¹\u0001\u0010\u009c\u0001J0\u0010À\u0001\u001a\u00020\u00062\u0008\u0010»\u0001\u001a\u00030º\u00012\u0008\u0010½\u0001\u001a\u00030¼\u00012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0006\u0008¾\u0001\u0010¿\u0001J\u0085\u0001\u0010Ä\u0001\u001a\u00020\u00062\u0007\u0010Á\u0001\u001a\u00020/2\u0008\u0010^\u001a\u0004\u0018\u00010\u001a2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0008\u0002\u00105\u001a\u001c\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0006\u0018\u000103j\u0004\u0018\u0001`42\"\u0008\u0002\u00107\u001a\u001c\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0006\u0018\u000103j\u0004\u0018\u0001`6H\u0000¢\u0006\u0006\u0008Â\u0001\u0010Ã\u0001J\u0011\u0010Æ\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0005\u0008Å\u0001\u0010gR0\u00101\u001a\u00020\r2\u0007\u0010Ç\u0001\u001a\u00020\r8F@FX\u0087\u000e¢\u0006\u0017\u0012\u0005\u0008Ì\u0001\u0010g\u001a\u0006\u0008È\u0001\u0010É\u0001\"\u0006\u0008Ê\u0001\u0010Ë\u0001R\u001a\u0010Î\u0001\u001a\u00030Í\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008Î\u0001\u0010Ï\u0001R\u001a\u0010Ñ\u0001\u001a\u00030Ð\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008Ñ\u0001\u0010Ò\u0001R*\u0010Õ\u0001\u001a\u00020\r2\u0007\u0010Ç\u0001\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\u0008Ó\u0001\u0010É\u0001\"\u0006\u0008Ô\u0001\u0010Ë\u0001R-\u0010Ù\u0001\u001a\u0004\u0018\u00010>2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010>8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\u0008Ö\u0001\u0010×\u0001\"\u0005\u0008Ø\u0001\u0010@R\u001a\u0010Û\u0001\u001a\u00030Ú\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008Û\u0001\u0010Ü\u0001R*\u0010Þ\u0001\u001a\u00030Ý\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\u0008Þ\u0001\u0010ß\u0001\u001a\u0006\u0008à\u0001\u0010á\u0001\"\u0006\u0008â\u0001\u0010ã\u0001R\u0016\u0010ä\u0001\u001a\u00020\r8F@\u0006¢\u0006\u0008\u001a\u0006\u0008ä\u0001\u0010É\u0001R\u0015\u0010\u0003\u001a\u00020\u00028F@\u0006¢\u0006\u0008\u001a\u0006\u0008å\u0001\u0010æ\u0001R;\u0010è\u0001\u001a\u00030ç\u00012\u0008\u0010Ç\u0001\u001a\u00030ç\u00018@@@X\u0080\u000e¢\u0006\u001f\n\u0006\u0008è\u0001\u0010é\u0001\u0012\u0005\u0008î\u0001\u0010g\u001a\u0006\u0008ê\u0001\u0010ë\u0001\"\u0006\u0008ì\u0001\u0010í\u0001R#\u0010ô\u0001\u001a\u00030ï\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\u0008ð\u0001\u0010ñ\u0001\u001a\u0006\u0008ò\u0001\u0010ó\u0001R\u001c\u0010ö\u0001\u001a\u0005\u0018\u00010õ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008ö\u0001\u0010÷\u0001R\u001a\u0010ù\u0001\u001a\u00030ø\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008ù\u0001\u0010ú\u0001R\u001a\u0010ü\u0001\u001a\u00030û\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008ü\u0001\u0010ý\u0001R\u001a\u0010ÿ\u0001\u001a\u00030þ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008ÿ\u0001\u0010\u0080\u0002R\u001a\u0010\u0082\u0002\u001a\u00030\u0081\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u0082\u0002\u0010\u0083\u0002¨\u0006\u0089\u0002", d2 = {"Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "", "appUserID", "Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;", "listener", "Lkotlin/w;", "retrievePurchaseInfo", "(Ljava/lang/String;Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;)V", "Lcom/revenuecat/purchases/util/AdvertisingIdClient$AdInfo;", "networkUserId", "generateAttributionDataCacheValue", "(Lcom/revenuecat/purchases/util/AdvertisingIdClient$AdInfo;Ljava/lang/String;)Ljava/lang/String;", "", "appInBackground", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsListener;", "completion", "fetchAndCacheOfferings", "(Ljava/lang/String;ZLcom/revenuecat/purchases/interfaces/ReceiveOfferingsListener;)V", "Lcom/revenuecat/purchases/PurchasesError;", "error", "handleErrorFetchingOfferings", "(Lcom/revenuecat/purchases/PurchasesError;Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsListener;)V", "Lcom/revenuecat/purchases/Offerings;", "offerings", "Ljava/util/HashMap;", "Lcom/revenuecat/purchases/models/ProductDetails;", "Lkotlin/collections/HashMap;", "detailsByID", "logMissingProducts", "(Lcom/revenuecat/purchases/Offerings;Ljava/util/HashMap;)Lkotlin/w;", "", "skus", "Lcom/revenuecat/purchases/ProductType;", "productType", "Lcom/revenuecat/purchases/interfaces/GetProductDetailsCallback;", "callback", "getSkus", "(Ljava/util/Set;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/interfaces/GetProductDetailsCallback;)V", "updateAllCaches", "fetchAndCachePurchaserInfo", "(Ljava/lang/String;ZLcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;)V", "Lcom/revenuecat/purchases/PurchaserInfo;", "info", "cachePurchaserInfo", "(Lcom/revenuecat/purchases/PurchaserInfo;)V", "", "Lcom/revenuecat/purchases/models/PurchaseDetails;", "purchases", "allowSharingPlayStoreAccount", "consumeAllTransactions", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "onSuccess", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "onError", "postPurchases", "(Ljava/util/List;ZZLjava/lang/String;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "Lkotlin/Function1;", "onCompleted", "getSkuDetails", "(Ljava/util/Set;Lkotlin/d0/c/l;Lkotlin/d0/c/l;)V", "Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;", "afterSetListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;)V", "sendUpdatedPurchaserInfoToDelegateIfChanged", "Lkotlin/Function0;", "action", "dispatch", "(Lkotlin/d0/c/a;)V", "sku", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "getPurchaseCallback", "(Ljava/lang/String;)Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "getAndClearProductChangeCallback", "()Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "getPurchasesUpdatedListener", "()Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "Landroid/util/Pair;", "getPurchaseCompletedCallbacks", "()Landroid/util/Pair;", "productChangeListener", "getProductChangeCompletedCallbacks", "(Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;)Landroid/util/Pair;", "Lcom/revenuecat/purchases/interfaces/PurchaseErrorListener;", "(Lcom/revenuecat/purchases/interfaces/PurchaseErrorListener;Lcom/revenuecat/purchases/PurchasesError;)V", "Landroid/app/Activity;", "activity", "product", "presentedOfferingIdentifier", "startPurchase", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "productDetails", "offeringIdentifier", "Lcom/revenuecat/purchases/UpgradeInfo;", "upgradeInfo", "startProductChange", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/UpgradeInfo;Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;)V", "replaceOldPurchaseWithNewProduct", "(Lcom/revenuecat/purchases/models/ProductDetails;Lcom/revenuecat/purchases/UpgradeInfo;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/interfaces/PurchaseErrorListener;)V", "synchronizeSubscriberAttributesIfNeeded", "()V", "onAppBackgrounded", "onAppForegrounded", "syncPurchases", "getOfferings", "(Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsListener;)V", "Lcom/revenuecat/purchases/interfaces/GetSkusResponseListener;", "getSubscriptionSkus", "(Ljava/util/List;Lcom/revenuecat/purchases/interfaces/GetSkusResponseListener;)V", "getSubscriptionSkus$purchases_release", "(Ljava/util/List;Lcom/revenuecat/purchases/interfaces/GetProductDetailsCallback;)V", "getNonSubscriptionSkus", "getNonSubscriptionSkus$purchases_release", "Lcom/android/billingclient/api/SkuDetails;", "skuDetails", "Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;", "purchaseProduct", "(Landroid/app/Activity;Lcom/android/billingclient/api/SkuDetails;Lcom/revenuecat/purchases/UpgradeInfo;Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;)V", "Lcom/revenuecat/purchases/interfaces/ProductChangeListener;", "(Landroid/app/Activity;Lcom/android/billingclient/api/SkuDetails;Lcom/revenuecat/purchases/UpgradeInfo;Lcom/revenuecat/purchases/interfaces/ProductChangeListener;)V", "purchaseProduct$purchases_release", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/ProductDetails;Lcom/revenuecat/purchases/UpgradeInfo;Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;)V", "(Landroid/app/Activity;Lcom/android/billingclient/api/SkuDetails;Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;)V", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/ProductDetails;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "Lcom/revenuecat/purchases/Package;", "packageToPurchase", "purchasePackage", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/UpgradeInfo;Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;)V", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/UpgradeInfo;Lcom/revenuecat/purchases/interfaces/ProductChangeListener;)V", "purchasePackage$purchases_release", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/UpgradeInfo;Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;)V", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/interfaces/MakePurchaseListener;)V", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "restorePurchases", "(Lcom/revenuecat/purchases/interfaces/ReceivePurchaserInfoListener;)V", "newAppUserID", "createAlias", "identify", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logIn", "(Ljava/lang/String;Lcom/revenuecat/purchases/interfaces/LogInCallback;)V", "logOut", "reset", "close", "getPurchaserInfo", "removeUpdatedPurchaserInfoListener", "invalidatePurchaserInfoCache", "", "attributes", "setAttributes", "(Ljava/util/Map;)V", "email", "setEmail", "(Ljava/lang/String;)V", "phoneNumber", "setPhoneNumber", "displayName", "setDisplayName", "fcmToken", "setPushToken", "collectDeviceIdentifiers", "adjustID", "setAdjustID", "appsflyerID", "setAppsflyerID", "fbAnonymousID", "setFBAnonymousID", "mparticleID", "setMparticleID", "onesignalID", "setOnesignalID", "mediaSource", "setMediaSource", "campaign", "setCampaign", "adGroup", "setAdGroup", "ad", "setAd", "keyword", "setKeyword", "creative", "setCreative", "Lorg/json/JSONObject;", "jsonObject", "Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "network", "postAttributionData$purchases_release", "(Lorg/json/JSONObject;Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;Ljava/lang/String;)V", "postAttributionData", "purchase", "postToBackend$purchases_release", "(Lcom/revenuecat/purchases/models/PurchaseDetails;Lcom/revenuecat/purchases/models/ProductDetails;ZZLjava/lang/String;Lkotlin/d0/c/p;Lkotlin/d0/c/p;)V", "postToBackend", "updatePendingPurchaseQueue$purchases_release", "updatePendingPurchaseQueue", "value", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "getAllowSharingPlayStoreAccount$annotations", "Lcom/revenuecat/purchases/common/Backend;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "Lcom/revenuecat/purchases/identity/IdentityManager;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "getFinishTransactions", "setFinishTransactions", "finishTransactions", "getUpdatedPurchaserInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedPurchaserInfoListener;", "setUpdatedPurchaserInfoListener", "updatedPurchaserInfoListener", "Lcom/revenuecat/purchases/common/Dispatcher;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "Lcom/revenuecat/purchases/common/AppConfig;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "getAppConfig$purchases_release", "()Lcom/revenuecat/purchases/common/AppConfig;", "setAppConfig$purchases_release", "(Lcom/revenuecat/purchases/common/AppConfig;)V", "isAnonymous", "getAppUserID", "()Ljava/lang/String;", "Lcom/revenuecat/purchases/PurchasesState;", "state", "Lcom/revenuecat/purchases/PurchasesState;", "getState$purchases_release", "()Lcom/revenuecat/purchases/PurchasesState;", "setState$purchases_release", "(Lcom/revenuecat/purchases/PurchasesState;)V", "getState$purchases_release$annotations", "Lcom/revenuecat/purchases/AppLifecycleHandler;", "lifecycleHandler$delegate", "Lkotlin/h;", "getLifecycleHandler", "()Lcom/revenuecat/purchases/AppLifecycleHandler;", "lifecycleHandler", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "Landroid/app/Application;", "application", "Landroid/app/Application;", "Lcom/revenuecat/purchases/common/BillingAbstract;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "subscriberAttributesManager", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "backingFieldAppUserID", "<init>", "(Landroid/app/Application;Ljava/lang/String;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;Lcom/revenuecat/purchases/common/AppConfig;)V", "Companion", "AttributionNetwork", "purchases_release"}, k = 1, mv = {1, 4, 0})
public final class Purchases implements com.revenuecat.purchases.LifecycleDelegate {

    public static final com.revenuecat.purchases.Purchases.Companion Companion;
    private static com.revenuecat.purchases.Purchases backingFieldSharedInstance;
    private static final String frameworkVersion;
    private static PlatformInfo platformInfo;
    private static List<AttributionData> postponedAttributionData;
    private static URL proxyURL;
    private AppConfig appConfig;
    private final Application application;
    private final Backend backend;
    private final BillingAbstract billing;
    private final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final Handler handler;
    private final IdentityManager identityManager;
    private final h lifecycleHandler$delegate;
    private volatile com.revenuecat.purchases.PurchasesState state;
    private final SubscriberAttributesManager subscriberAttributesManager;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0008\n\u0002\u0008\r\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u000f", d2 = {"Lcom/revenuecat/purchases/Purchases$AttributionNetwork;", "", "", "serverValue", "I", "getServerValue", "()I", "<init>", "(Ljava/lang/String;II)V", "ADJUST", "APPSFLYER", "BRANCH", "TENJIN", "FACEBOOK", "MPARTICLE", "purchases_release"}, k = 1, mv = {1, 4, 0})
    public static enum AttributionNetwork {

        ADJUST(true),
        APPSFLYER(false),
        BRANCH(true),
        TENJIN(false),
        FACEBOOK(true),
        MPARTICLE(6);

        private final int serverValue;
        @Override // java.lang.Enum
        public final int getServerValue() {
            return this.serverValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0008\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008_\u00105J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u0008*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ?\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000bH\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J5\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00022\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001dH\u0007¢\u0006\u0004\u0008 \u0010!J%\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00022\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001dH\u0007¢\u0006\u0004\u0008\"\u0010#J-\u0010%\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001dH\u0007¢\u0006\u0004\u0008%\u0010&J+\u0010,\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\u0008,\u0010-J9\u0010,\u001a\u00020\u001f2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010.2\u0006\u0010*\u001a\u00020)2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\u0008,\u0010/R\"\u00100\u001a\u00020\u00068\u0006@\u0007X\u0087D¢\u0006\u0012\n\u0004\u00080\u00101\u0012\u0004\u00084\u00105\u001a\u0004\u00082\u00103R(\u00108\u001a\u0008\u0012\u0004\u0012\u000207068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u00088\u00109\u001a\u0004\u0008:\u0010;\"\u0004\u0008<\u0010=R(\u0010?\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\u0008?\u0010@\u0012\u0004\u0008E\u00105\u001a\u0004\u0008A\u0010B\"\u0004\u0008C\u0010DR$\u0010F\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008F\u0010G\u001a\u0004\u0008H\u0010I\"\u0004\u0008J\u0010KR*\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\u0008M\u0010N\u0012\u0004\u0008S\u00105\u001a\u0004\u0008O\u0010P\"\u0004\u0008Q\u0010RR*\u0010Z\u001a\u00020\u00082\u0006\u0010T\u001a\u00020\u00088F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\u0008Y\u00105\u001a\u0004\u0008U\u0010V\"\u0004\u0008W\u0010XR*\u0010^\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u00138F@AX\u0087\u000e¢\u0006\u0012\u0012\u0004\u0008]\u00105\u001a\u0004\u0008[\u0010I\"\u0004\u0008\\\u0010K¨\u0006`", d2 = {"Lcom/revenuecat/purchases/Purchases$Companion;", "", "Landroid/content/Context;", "Landroid/app/Application;", "getApplication", "(Landroid/content/Context;)Landroid/app/Application;", "", "permission", "", "hasPermission", "(Landroid/content/Context;Ljava/lang/String;)Z", "Ljava/util/concurrent/ExecutorService;", "createDefaultExecutor", "()Ljava/util/concurrent/ExecutorService;", "context", "apiKey", "appUserID", "observerMode", "service", "Lcom/revenuecat/purchases/Purchases;", "configure", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/util/concurrent/ExecutorService;)Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "configuration", "configure$purchases_release", "(Lcom/revenuecat/purchases/PurchasesConfiguration;)Lcom/revenuecat/purchases/Purchases;", "", "Lcom/revenuecat/purchases/BillingFeature;", "features", "Lcom/revenuecat/purchases/interfaces/Callback;", "callback", "Lkotlin/w;", "canMakePayments", "(Landroid/content/Context;Ljava/util/List;Lcom/revenuecat/purchases/interfaces/Callback;)V", "isBillingSupported", "(Landroid/content/Context;Lcom/revenuecat/purchases/interfaces/Callback;)V", "feature", "isFeatureSupported", "(Ljava/lang/String;Landroid/content/Context;Lcom/revenuecat/purchases/interfaces/Callback;)V", "Lorg/json/JSONObject;", "data", "Lcom/revenuecat/purchases/Purchases$AttributionNetwork;", "network", "networkUserId", "addAttributionData", "(Lorg/json/JSONObject;Lcom/revenuecat/purchases/Purchases$AttributionNetwork;Ljava/lang/String;)V", "", "(Ljava/util/Map;Lcom/revenuecat/purchases/Purchases$AttributionNetwork;Ljava/lang/String;)V", "frameworkVersion", "Ljava/lang/String;", "getFrameworkVersion", "()Ljava/lang/String;", "getFrameworkVersion$annotations", "()V", "", "Lcom/revenuecat/purchases/common/attribution/AttributionData;", "postponedAttributionData", "Ljava/util/List;", "getPostponedAttributionData$purchases_release", "()Ljava/util/List;", "setPostponedAttributionData$purchases_release", "(Ljava/util/List;)V", "Lcom/revenuecat/purchases/common/PlatformInfo;", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "getPlatformInfo$annotations", "backingFieldSharedInstance", "Lcom/revenuecat/purchases/Purchases;", "getBackingFieldSharedInstance$purchases_release", "()Lcom/revenuecat/purchases/Purchases;", "setBackingFieldSharedInstance$purchases_release", "(Lcom/revenuecat/purchases/Purchases;)V", "Ljava/net/URL;", "proxyURL", "Ljava/net/URL;", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "getProxyURL$annotations", "value", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "getDebugLogsEnabled$annotations", "debugLogsEnabled", "getSharedInstance", "setSharedInstance$purchases_release", "getSharedInstance$annotations", "sharedInstance", "<init>", "purchases_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static void addAttributionData$default(com.revenuecat.purchases.Purchases.Companion purchases$Companion, Map map2, com.revenuecat.purchases.Purchases.AttributionNetwork purchases$AttributionNetwork3, String string4, int i5, Object object6) {
            int obj3;
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            companion.addAttributionData(map2, attributionNetwork3, obj3);
        }

        public static void addAttributionData$default(com.revenuecat.purchases.Purchases.Companion purchases$Companion, JSONObject jSONObject2, com.revenuecat.purchases.Purchases.AttributionNetwork purchases$AttributionNetwork3, String string4, int i5, Object object6) {
            int obj3;
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            companion.addAttributionData(jSONObject2, attributionNetwork3, obj3);
        }

        public static void canMakePayments$default(com.revenuecat.purchases.Purchases.Companion purchases$Companion, Context context2, List list3, Callback callback4, int i5, Object object6) {
            List obj2;
            if (i5 &= 2 != 0) {
                obj2 = p.g();
            }
            companion.canMakePayments(context2, obj2, callback4);
        }

        public static com.revenuecat.purchases.Purchases configure$default(com.revenuecat.purchases.Purchases.Companion purchases$Companion, Context context2, String string3, String string4, boolean z5, ExecutorService executorService6, int i7, Object object8) {
            int obj9;
            int obj10;
            ExecutorService obj11;
            if (i7 & 4 != 0) {
                obj9 = 0;
            }
            if (i7 & 8 != 0) {
                obj10 = 0;
            }
            if (i7 & 16 != 0) {
                obj11 = companion.createDefaultExecutor();
            }
            return companion.configure(context2, string3, obj9, obj10, obj11);
        }

        private final ExecutorService createDefaultExecutor() {
            final java.util.concurrent.ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            n.e(singleThreadScheduledExecutor, "Executors.newSingleThreadScheduledExecutor()");
            return singleThreadScheduledExecutor;
        }

        private final Application getApplication(Context context) {
            final Context obj2 = context.getApplicationContext();
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.app.Application");
            return (Application)obj2;
        }

        public static void getDebugLogsEnabled$annotations() {
        }

        public static void getFrameworkVersion$annotations() {
        }

        public static void getPlatformInfo$annotations() {
        }

        public static void getProxyURL$annotations() {
        }

        public static void getSharedInstance$annotations() {
        }

        private final boolean hasPermission(Context context, String string2) {
            int obj1;
            obj1 = context.checkCallingOrSelfPermission(string2) == 0 ? 1 : 0;
            return obj1;
        }

        public final void addAttributionData(Map<String, ? extends Object> map, com.revenuecat.purchases.Purchases.AttributionNetwork purchases$AttributionNetwork2, String string3) {
            Object string;
            Object nULL;
            String str;
            n.f(map, "data");
            n.f(attributionNetwork2, "network");
            JSONObject jSONObject = new JSONObject();
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                string = iterator.next();
                nULL = map.get((String)string);
                if (nULL != null && jSONObject.put(string, nULL) != null) {
                } else {
                }
                jSONObject.put(string, JSONObject.NULL);
                if (jSONObject.put(string, nULL) != null) {
                } else {
                }
            }
            addAttributionData(jSONObject, attributionNetwork2, string3);
        }

        public final void addAttributionData(JSONObject jSONObject, com.revenuecat.purchases.Purchases.AttributionNetwork purchases$AttributionNetwork2, String string3) {
            Object backingFieldSharedInstance$purchases_release;
            Object obj3;
            n.f(jSONObject, "data");
            n.f(attributionNetwork2, "network");
            backingFieldSharedInstance$purchases_release = getBackingFieldSharedInstance$purchases_release();
            if (backingFieldSharedInstance$purchases_release != null) {
                backingFieldSharedInstance$purchases_release.postAttributionData$purchases_release(jSONObject, PurchasesKt.convert(attributionNetwork2), string3);
            } else {
                backingFieldSharedInstance$purchases_release = new Purchases.Companion.addAttributionData.1(jSONObject, attributionNetwork2, string3);
                backingFieldSharedInstance$purchases_release.invoke();
            }
        }

        public final void canMakePayments(Context context, Callback<Boolean> callback2) {
            Purchases.Companion.canMakePayments$default(this, context, 0, callback2, 2, 0);
        }

        public final void canMakePayments(Context context, List<? extends com.revenuecat.purchases.BillingFeature> list2, Callback<Boolean> callback3) {
            n.f(context, "context");
            n.f(list2, "features");
            n.f(callback3, "callback");
            c.b bVar = c.g(context);
            bVar.b();
            bVar.c(Purchases.Companion.canMakePayments.1.INSTANCE);
            c cVar = bVar.a();
            Handler handler = new Handler(context.getMainLooper());
            super(handler, cVar, context, callback3, list2);
            cVar.k(anon);
        }

        public final com.revenuecat.purchases.Purchases configure(Context context, String string2) {
            return Purchases.Companion.configure$default(this, context, string2, 0, false, 0, 28, 0);
        }

        public final com.revenuecat.purchases.Purchases configure(Context context, String string2, String string3) {
            return Purchases.Companion.configure$default(this, context, string2, string3, false, 0, 24, 0);
        }

        public final com.revenuecat.purchases.Purchases configure(Context context, String string2, String string3, boolean z4) {
            return Purchases.Companion.configure$default(this, context, string2, string3, z4, 0, 16, 0);
        }

        public final com.revenuecat.purchases.Purchases configure(Context context, String string2, String string3, boolean z4, ExecutorService executorService5) {
            n.f(context, "context");
            n.f(string2, "apiKey");
            n.f(executorService5, "service");
            PurchasesConfiguration.Builder builder = new PurchasesConfiguration.Builder(context, string2);
            return configure$purchases_release(builder.appUserID(string3).observerMode(z4).service(executorService5).build());
        }

        public final com.revenuecat.purchases.Purchases configure$purchases_release(com.revenuecat.purchases.PurchasesConfiguration purchasesConfiguration) {
            ExecutorService defaultExecutor;
            n.f(purchasesConfiguration, "configuration");
            com.revenuecat.purchases.Purchases.Companion companion = Purchases.Companion;
            if (!companion.hasPermission(purchasesConfiguration.getContext(), "android.permission.INTERNET")) {
            } else {
                if (z ^= 1 == 0) {
                } else {
                    if (!applicationContext instanceof Application) {
                    } else {
                        final Application application = companion.getApplication(purchasesConfiguration.getContext());
                        super(purchasesConfiguration.getContext(), purchasesConfiguration.getObserverMode(), companion.getPlatformInfo(), companion.getProxyURL(), purchasesConfiguration.getStore());
                        android.content.SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
                        ETagManager eTagManager = new ETagManager(ETagManager.Companion.initializeSharedPreferences(purchasesConfiguration.getContext()));
                        if (purchasesConfiguration.getService() != null) {
                        } else {
                            defaultExecutor = companion.createDefaultExecutor();
                        }
                        Dispatcher dispatcher = new Dispatcher(defaultExecutor);
                        HTTPClient hTTPClient = new HTTPClient(appConfig2, eTagManager);
                        Backend backend = new Backend(purchasesConfiguration.getApiKey(), dispatcher, hTTPClient);
                        SubscriberAttributesPoster subscriberAttributesPoster = new SubscriberAttributesPoster(backend);
                        n.e(defaultSharedPreferences, "prefs");
                        super(defaultSharedPreferences, purchasesConfiguration.getApiKey(), 0, 0, 12, 0);
                        SubscriberAttributesCache subscriberAttributesCache = new SubscriberAttributesCache(deviceCache);
                        AttributionFetcher attributionFetcher = new AttributionFetcher(dispatcher);
                        AttributionDataMigrator attributionDataMigrator = new AttributionDataMigrator();
                        IdentityManager identityManager2 = new IdentityManager(deviceCache, subscriberAttributesCache, backend);
                        SubscriberAttributesManager subscriberAttributesManager2 = new SubscriberAttributesManager(subscriberAttributesCache, subscriberAttributesPoster, attributionFetcher, attributionDataMigrator);
                        super(application, purchasesConfiguration.getAppUserID(), backend, BillingFactory.INSTANCE.createBilling(purchasesConfiguration.getStore(), application, backend, deviceCache), deviceCache, dispatcher, identityManager2, subscriberAttributesManager2, appConfig2);
                        companion.setSharedInstance$purchases_release(purchases2);
                        return purchases2;
                    }
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Needs an application context.".toString());
                    throw illegalArgumentException2;
                }
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("API key must be set. Get this from the RevenueCat web app".toString());
                throw illegalArgumentException3;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Purchases requires INTERNET permission.".toString());
            throw illegalArgumentException;
        }

        public final com.revenuecat.purchases.Purchases getBackingFieldSharedInstance$purchases_release() {
            return Purchases.access$getBackingFieldSharedInstance$cp();
        }

        public final boolean getDebugLogsEnabled() {
            return Config.INSTANCE.getDebugLogsEnabled();
        }

        public final String getFrameworkVersion() {
            return Purchases.access$getFrameworkVersion$cp();
        }

        public final PlatformInfo getPlatformInfo() {
            return Purchases.access$getPlatformInfo$cp();
        }

        public final List<AttributionData> getPostponedAttributionData$purchases_release() {
            return Purchases.access$getPostponedAttributionData$cp();
        }

        public final URL getProxyURL() {
            return Purchases.access$getProxyURL$cp();
        }

        public final com.revenuecat.purchases.Purchases getSharedInstance() {
            com.revenuecat.purchases.Purchases backingFieldSharedInstance$purchases_release = Purchases.Companion.getBackingFieldSharedInstance$purchases_release();
            if (backingFieldSharedInstance$purchases_release == null) {
            } else {
                return backingFieldSharedInstance$purchases_release;
            }
            UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException("There is no singleton instance. Make sure you configure Purchases before trying to get the default instance. More info here: https://errors.rev.cat/configuring-sdk");
            throw uninitializedPropertyAccessException;
        }

        public final void isBillingSupported(Context context, Callback<Boolean> callback2) {
            n.f(context, "context");
            n.f(callback2, "callback");
            c.b bVar = c.g(context);
            bVar.b();
            bVar.c(Purchases.Companion.isBillingSupported.1.INSTANCE);
            c cVar = bVar.a();
            Handler handler = new Handler(context.getMainLooper());
            Purchases.Companion.isBillingSupported$$inlined.let.lambda.1 anon = new Purchases.Companion.isBillingSupported$$inlined.let.lambda.1(handler, cVar, context, callback2);
            cVar.k(anon);
        }

        public final void isFeatureSupported(String string, Context context2, Callback<Boolean> callback3) {
            n.f(string, "feature");
            n.f(context2, "context");
            n.f(callback3, "callback");
            c.b bVar = c.g(context2);
            bVar.b();
            bVar.c(Purchases.Companion.isFeatureSupported.1.INSTANCE);
            c cVar = bVar.a();
            Handler handler = new Handler(context2.getMainLooper());
            super(handler, cVar, context2, string, callback3);
            cVar.k(anon);
        }

        public final void setBackingFieldSharedInstance$purchases_release(com.revenuecat.purchases.Purchases purchases) {
            Purchases.access$setBackingFieldSharedInstance$cp(purchases);
        }

        public final void setDebugLogsEnabled(boolean z) {
            Config.INSTANCE.setDebugLogsEnabled(z);
        }

        public final void setPlatformInfo(PlatformInfo platformInfo) {
            n.f(platformInfo, "<set-?>");
            Purchases.access$setPlatformInfo$cp(platformInfo);
        }

        public final void setPostponedAttributionData$purchases_release(List<AttributionData> list) {
            n.f(list, "<set-?>");
            Purchases.access$setPostponedAttributionData$cp(list);
        }

        public final void setProxyURL(URL uRL) {
            Purchases.access$setProxyURL$cp(uRL);
        }

        public final void setSharedInstance$purchases_release(com.revenuecat.purchases.Purchases purchases) {
            com.revenuecat.purchases.Purchases backingFieldSharedInstance$purchases_release;
            JSONObject data;
            AttributionNetwork network;
            n.f(purchases, "value");
            com.revenuecat.purchases.Purchases.Companion companion = Purchases.Companion;
            backingFieldSharedInstance$purchases_release = companion.getBackingFieldSharedInstance$purchases_release();
            if (backingFieldSharedInstance$purchases_release != null) {
                backingFieldSharedInstance$purchases_release.close();
            }
            companion.setBackingFieldSharedInstance$purchases_release(purchases);
            Iterator iterator = companion.getPostponedAttributionData$purchases_release().iterator();
            for (AttributionData next2 : iterator) {
                purchases.postAttributionData$purchases_release(next2.getData(), next2.getNetwork(), next2.getNetworkUserId());
                iterator.remove();
            }
        }
    }
    static {
        final int i = 0;
        Purchases.Companion companion = new Purchases.Companion(i);
        Purchases.Companion = companion;
        PlatformInfo platformInfo = new PlatformInfo("native", i);
        Purchases.platformInfo = platformInfo;
        ArrayList arrayList = new ArrayList();
        Purchases.postponedAttributionData = arrayList;
        Purchases.frameworkVersion = "4.3.1";
    }

    public Purchases(Application application, String string2, Backend backend3, BillingAbstract billingAbstract4, DeviceCache deviceCache5, Dispatcher dispatcher6, IdentityManager identityManager7, SubscriberAttributesManager subscriberAttributesManager8, AppConfig appConfig9) {
        final Object obj = this;
        Object obj2 = application;
        Object obj3 = string2;
        Object obj4 = backend3;
        final Object obj5 = billingAbstract4;
        Object obj6 = deviceCache5;
        Object obj7 = dispatcher6;
        final Object obj8 = identityManager7;
        Object obj9 = subscriberAttributesManager8;
        final Object obj10 = appConfig9;
        n.f(obj2, "application");
        n.f(obj4, "backend");
        n.f(obj5, "billing");
        n.f(obj6, "deviceCache");
        n.f(obj7, "dispatcher");
        n.f(obj8, "identityManager");
        n.f(obj9, "subscriberAttributesManager");
        n.f(obj10, "appConfig");
        super();
        obj.application = obj2;
        obj.backend = obj4;
        obj.billing = obj5;
        obj.deviceCache = obj6;
        obj.dispatcher = obj7;
        obj.identityManager = obj8;
        obj.subscriberAttributesManager = obj9;
        obj.appConfig = obj10;
        super(0, 0, 0, 0, 0, 0, 0, 127, 0);
        obj.state = purchasesState;
        Purchases.lifecycleHandler.2 anon = new Purchases.lifecycleHandler.2(obj);
        obj.lifecycleHandler$delegate = j.b(anon);
        LogIntent dEBUG = LogIntent.DEBUG;
        LogWrapperKt.log(dEBUG, "Debug logging enabled");
        int i = 1;
        Object[] arr = new Object[i];
        int i2 = 0;
        arr[i2] = Purchases.frameworkVersion;
        String format2 = String.format("SDK Version - %s", Arrays.copyOf(arr, i));
        String str4 = "java.lang.String.format(this, *args)";
        n.e(format2, str4);
        LogWrapperKt.log(dEBUG, format2);
        Object[] arr2 = new Object[i];
        arr2[i2] = obj3;
        String format = String.format("Initial App User ID - %s", Arrays.copyOf(arr2, i));
        n.e(format, str4);
        LogWrapperKt.log(LogIntent.USER, format);
        obj8.configure(obj3);
        Purchases.1 anon2 = new Purchases.1(obj);
        obj.dispatch(anon2);
        Purchases.2 anon3 = new Purchases.2(obj);
        obj5.setStateListener(anon3);
        obj5.setPurchasesUpdatedListener(getPurchasesUpdatedListener());
        Handler handler = new Handler(Looper.getMainLooper());
        obj.handler = handler;
    }

    public static final void access$cachePurchaserInfo(com.revenuecat.purchases.Purchases purchases, com.revenuecat.purchases.PurchaserInfo purchaserInfo2) {
        purchases.cachePurchaserInfo(purchaserInfo2);
    }

    public static final void access$dispatch(com.revenuecat.purchases.Purchases purchases, PurchaseErrorListener purchaseErrorListener2, com.revenuecat.purchases.PurchasesError purchasesError3) {
        purchases.dispatch(purchaseErrorListener2, purchasesError3);
    }

    public static final void access$dispatch(com.revenuecat.purchases.Purchases purchases, a a2) {
        purchases.dispatch(a2);
    }

    public static final String access$generateAttributionDataCacheValue(com.revenuecat.purchases.Purchases purchases, AdvertisingIdClient.AdInfo advertisingIdClient$AdInfo2, String string3) {
        return purchases.generateAttributionDataCacheValue(adInfo2, string3);
    }

    public static final ProductChangeCallback access$getAndClearProductChangeCallback(com.revenuecat.purchases.Purchases purchases) {
        return purchases.getAndClearProductChangeCallback();
    }

    public static final Backend access$getBackend$p(com.revenuecat.purchases.Purchases purchases) {
        return purchases.backend;
    }

    public static final com.revenuecat.purchases.Purchases access$getBackingFieldSharedInstance$cp() {
        return Purchases.backingFieldSharedInstance;
    }

    public static final BillingAbstract access$getBilling$p(com.revenuecat.purchases.Purchases purchases) {
        return purchases.billing;
    }

    public static final DeviceCache access$getDeviceCache$p(com.revenuecat.purchases.Purchases purchases) {
        return purchases.deviceCache;
    }

    public static final String access$getFrameworkVersion$cp() {
        return Purchases.frameworkVersion;
    }

    public static final IdentityManager access$getIdentityManager$p(com.revenuecat.purchases.Purchases purchases) {
        return purchases.identityManager;
    }

    public static final com.revenuecat.purchases.AppLifecycleHandler access$getLifecycleHandler$p(com.revenuecat.purchases.Purchases purchases) {
        return purchases.getLifecycleHandler();
    }

    public static final PlatformInfo access$getPlatformInfo$cp() {
        return Purchases.platformInfo;
    }

    public static final List access$getPostponedAttributionData$cp() {
        return Purchases.postponedAttributionData;
    }

    public static final Pair access$getProductChangeCompletedCallbacks(com.revenuecat.purchases.Purchases purchases, ProductChangeCallback productChangeCallback2) {
        return purchases.getProductChangeCompletedCallbacks(productChangeCallback2);
    }

    public static final URL access$getProxyURL$cp() {
        return Purchases.proxyURL;
    }

    public static final PurchaseCallback access$getPurchaseCallback(com.revenuecat.purchases.Purchases purchases, String string2) {
        return purchases.getPurchaseCallback(string2);
    }

    public static final Pair access$getPurchaseCompletedCallbacks(com.revenuecat.purchases.Purchases purchases) {
        return purchases.getPurchaseCompletedCallbacks();
    }

    public static final void access$getSkuDetails(com.revenuecat.purchases.Purchases purchases, Set set2, l l3, l l4) {
        purchases.getSkuDetails(set2, l3, l4);
    }

    public static final SubscriberAttributesManager access$getSubscriberAttributesManager$p(com.revenuecat.purchases.Purchases purchases) {
        return purchases.subscriberAttributesManager;
    }

    public static final void access$handleErrorFetchingOfferings(com.revenuecat.purchases.Purchases purchases, com.revenuecat.purchases.PurchasesError purchasesError2, ReceiveOfferingsListener receiveOfferingsListener3) {
        purchases.handleErrorFetchingOfferings(purchasesError2, receiveOfferingsListener3);
    }

    public static final w access$logMissingProducts(com.revenuecat.purchases.Purchases purchases, com.revenuecat.purchases.Offerings offerings2, HashMap hashMap3) {
        return purchases.logMissingProducts(offerings2, hashMap3);
    }

    public static final void access$postPurchases(com.revenuecat.purchases.Purchases purchases, List list2, boolean z3, boolean z4, String string5, p p6, p p7) {
        purchases.postPurchases(list2, z3, z4, string5, p6, p7);
    }

    public static final void access$sendUpdatedPurchaserInfoToDelegateIfChanged(com.revenuecat.purchases.Purchases purchases, com.revenuecat.purchases.PurchaserInfo purchaserInfo2) {
        purchases.sendUpdatedPurchaserInfoToDelegateIfChanged(purchaserInfo2);
    }

    public static final void access$setBackingFieldSharedInstance$cp(com.revenuecat.purchases.Purchases purchases) {
        Purchases.backingFieldSharedInstance = purchases;
    }

    public static final void access$setPlatformInfo$cp(PlatformInfo platformInfo) {
        Purchases.platformInfo = platformInfo;
    }

    public static final void access$setPostponedAttributionData$cp(List list) {
        Purchases.postponedAttributionData = list;
    }

    public static final void access$setProxyURL$cp(URL uRL) {
        Purchases.proxyURL = uRL;
    }

    public static final void access$updateAllCaches(com.revenuecat.purchases.Purchases purchases, String string2, ReceivePurchaserInfoListener receivePurchaserInfoListener3) {
        purchases.updateAllCaches(string2, receivePurchaserInfoListener3);
    }

    public static final void addAttributionData(Map<String, ? extends Object> map, com.revenuecat.purchases.Purchases.AttributionNetwork purchases$AttributionNetwork2, String string3) {
        Purchases.Companion.addAttributionData(map, attributionNetwork2, string3);
    }

    public static final void addAttributionData(JSONObject jSONObject, com.revenuecat.purchases.Purchases.AttributionNetwork purchases$AttributionNetwork2, String string3) {
        Purchases.Companion.addAttributionData(jSONObject, attributionNetwork2, string3);
    }

    private final void afterSetListener(UpdatedPurchaserInfoListener updatedPurchaserInfoListener) {
        String currentAppUserID;
        com.revenuecat.purchases.PurchaserInfo obj2;
        LogWrapperKt.log(LogIntent.DEBUG, "Listener set");
        obj2 = this.deviceCache.getCachedPurchaserInfo(this.identityManager.getCurrentAppUserID());
        if (updatedPurchaserInfoListener != null && obj2 != null) {
            LogWrapperKt.log(LogIntent.DEBUG, "Listener set");
            obj2 = this.deviceCache.getCachedPurchaserInfo(this.identityManager.getCurrentAppUserID());
            if (obj2 != null) {
                sendUpdatedPurchaserInfoToDelegateIfChanged(obj2);
            }
        }
    }

    private final void cachePurchaserInfo(com.revenuecat.purchases.PurchaserInfo purchaserInfo) {
        this.deviceCache.cachePurchaserInfo(this.identityManager.getCurrentAppUserID(), purchaserInfo);
        return;
        synchronized (this) {
            this.deviceCache.cachePurchaserInfo(this.identityManager.getCurrentAppUserID(), purchaserInfo);
        }
    }

    public static final void canMakePayments(Context context, Callback<Boolean> callback2) {
        Purchases.Companion.canMakePayments$default(Purchases.Companion, context, 0, callback2, 2, 0);
    }

    public static final void canMakePayments(Context context, List<? extends com.revenuecat.purchases.BillingFeature> list2, Callback<Boolean> callback3) {
        Purchases.Companion.canMakePayments(context, list2, callback3);
    }

    public static final com.revenuecat.purchases.Purchases configure(Context context, String string2) {
        return Purchases.Companion.configure$default(Purchases.Companion, context, string2, 0, false, 0, 28, 0);
    }

    public static final com.revenuecat.purchases.Purchases configure(Context context, String string2, String string3) {
        return Purchases.Companion.configure$default(Purchases.Companion, context, string2, string3, false, 0, 24, 0);
    }

    public static final com.revenuecat.purchases.Purchases configure(Context context, String string2, String string3, boolean z4) {
        return Purchases.Companion.configure$default(Purchases.Companion, context, string2, string3, z4, 0, 16, 0);
    }

    public static final com.revenuecat.purchases.Purchases configure(Context context, String string2, String string3, boolean z4, ExecutorService executorService5) {
        return Purchases.Companion.configure(context, string2, string3, z4, executorService5);
    }

    public static final com.revenuecat.purchases.Purchases configure$purchases_release(com.revenuecat.purchases.PurchasesConfiguration purchasesConfiguration) {
        return Purchases.Companion.configure$purchases_release(purchasesConfiguration);
    }

    public static void createAlias$default(com.revenuecat.purchases.Purchases purchases, String string2, ReceivePurchaserInfoListener receivePurchaserInfoListener3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        purchases.createAlias(string2, obj2);
    }

    private final void dispatch(PurchaseErrorListener purchaseErrorListener, com.revenuecat.purchases.PurchasesError purchasesError2) {
        Purchases.dispatch.1 anon = new Purchases.dispatch.1(purchaseErrorListener, purchasesError2);
        dispatch(anon);
    }

    private final void dispatch(a<w> a) {
        Handler handler;
        Object mainLooper;
        Object obj4;
        Looper mainLooper2 = Looper.getMainLooper();
        n.e(mainLooper2, "Looper.getMainLooper()");
        if (z ^= 1 != 0) {
            if (this.handler != null) {
                if (a != null) {
                    mainLooper = new PurchasesKt.sam.java_lang_Runnable.0(a);
                    obj4 = mainLooper;
                }
            } else {
                handler = new Handler(Looper.getMainLooper());
                if (a != null) {
                    mainLooper = new PurchasesKt.sam.java_lang_Runnable.0(a);
                }
            }
            handler.post((Runnable)obj4);
        } else {
            a.invoke();
        }
    }

    private final void fetchAndCacheOfferings(String string, boolean z2, ReceiveOfferingsListener receiveOfferingsListener3) {
        this.deviceCache.setOfferingsCacheTimestampToNow();
        Purchases.fetchAndCacheOfferings.1 anon = new Purchases.fetchAndCacheOfferings.1(this, receiveOfferingsListener3);
        Purchases.fetchAndCacheOfferings.2 anon2 = new Purchases.fetchAndCacheOfferings.2(this, receiveOfferingsListener3);
        this.backend.getOfferings(string, z2, anon, anon2);
    }

    static void fetchAndCacheOfferings$default(com.revenuecat.purchases.Purchases purchases, String string2, boolean z3, ReceiveOfferingsListener receiveOfferingsListener4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        purchases.fetchAndCacheOfferings(string2, z3, obj3);
    }

    private final void fetchAndCachePurchaserInfo(String string, boolean z2, ReceivePurchaserInfoListener receivePurchaserInfoListener3) {
        this.deviceCache.setPurchaserInfoCacheTimestampToNow(string);
        Purchases.fetchAndCachePurchaserInfo.1 anon = new Purchases.fetchAndCachePurchaserInfo.1(this, receivePurchaserInfoListener3);
        Purchases.fetchAndCachePurchaserInfo.2 anon2 = new Purchases.fetchAndCachePurchaserInfo.2(this, string, receivePurchaserInfoListener3);
        this.backend.getPurchaserInfo(string, z2, anon, anon2);
    }

    static void fetchAndCachePurchaserInfo$default(com.revenuecat.purchases.Purchases purchases, String string2, boolean z3, ReceivePurchaserInfoListener receivePurchaserInfoListener4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        purchases.fetchAndCachePurchaserInfo(string2, z3, obj3);
    }

    private final String generateAttributionDataCacheValue(AdvertisingIdClient.AdInfo advertisingIdClient$AdInfo, String string2) {
        int i2;
        int i;
        int obj13;
        String[] strArr = new String[2];
        final int i4 = 1;
        if (adInfo != 0) {
            if (limitAdTrackingEnabled ^= i4 != 0) {
            } else {
                obj13 = i2;
            }
            if (obj13 != null) {
                i2 = obj13.getId();
            }
        }
        strArr[i4] = string2;
        return p.h0(p.l(strArr), "_", 0, 0, 0, 0, 0, 62, 0);
    }

    public static void getAllowSharingPlayStoreAccount$annotations() {
    }

    private final ProductChangeCallback getAndClearProductChangeCallback() {
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, 0, 0, 0, false, false, 119, 0));
        return getState$purchases_release().getProductChangeCallback();
    }

    public static final boolean getDebugLogsEnabled() {
        return Purchases.Companion.getDebugLogsEnabled();
    }

    public static final String getFrameworkVersion() {
        return Purchases.frameworkVersion;
    }

    private final com.revenuecat.purchases.AppLifecycleHandler getLifecycleHandler() {
        return (AppLifecycleHandler)this.lifecycleHandler$delegate.getValue();
    }

    public static final PlatformInfo getPlatformInfo() {
        return Purchases.platformInfo;
    }

    private final Pair<p<PurchaseDetails, com.revenuecat.purchases.PurchaserInfo, w>, p<PurchaseDetails, com.revenuecat.purchases.PurchasesError, w>> getProductChangeCompletedCallbacks(ProductChangeCallback productChangeCallback) {
        Purchases.getProductChangeCompletedCallbacks.onSuccess.1 anon = new Purchases.getProductChangeCompletedCallbacks.onSuccess.1(this, productChangeCallback);
        Purchases.getProductChangeCompletedCallbacks.onError.1 anon2 = new Purchases.getProductChangeCompletedCallbacks.onError.1(this, productChangeCallback);
        Pair obj3 = new Pair(anon, anon2);
        return obj3;
    }

    public static final URL getProxyURL() {
        return Purchases.proxyURL;
    }

    private final PurchaseCallback getPurchaseCallback(String string) {
        Object value;
        boolean key;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = getState$purchases_release().getPurchaseCallbacks().entrySet().iterator();
        while (iterator.hasNext()) {
            value = iterator.next();
            if (!n.b((String)(Map.Entry)value.getKey(), string)) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
        }
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, linkedHashMap, 0, 0, false, false, 123, 0));
        return (PurchaseCallback)getState$purchases_release().getPurchaseCallbacks().get(string);
    }

    private final Pair<p<PurchaseDetails, com.revenuecat.purchases.PurchaserInfo, w>, p<PurchaseDetails, com.revenuecat.purchases.PurchasesError, w>> getPurchaseCompletedCallbacks() {
        Purchases.getPurchaseCompletedCallbacks.onSuccess.1 anon = new Purchases.getPurchaseCompletedCallbacks.onSuccess.1(this);
        Purchases.getPurchaseCompletedCallbacks.onError.1 anon2 = new Purchases.getPurchaseCompletedCallbacks.onError.1(this);
        Pair pair = new Pair(anon, anon2);
        return pair;
    }

    private final BillingAbstract.PurchasesUpdatedListener getPurchasesUpdatedListener() {
        Purchases.getPurchasesUpdatedListener.1 anon = new Purchases.getPurchasesUpdatedListener.1(this);
        return anon;
    }

    public static final com.revenuecat.purchases.Purchases getSharedInstance() {
        return Purchases.Companion.getSharedInstance();
    }

    private final void getSkuDetails(Set<String> set, l<? super HashMap<String, ProductDetails>, w> l2, l<? super com.revenuecat.purchases.PurchasesError, w> l3) {
        Purchases.getSkuDetails.1 anon = new Purchases.getSkuDetails.1(this, set, l2, l3);
        Purchases.getSkuDetails.2 obj5 = new Purchases.getSkuDetails.2(l3);
        this.billing.querySkuDetailsAsync(ProductType.SUBS, set, anon, obj5);
    }

    private final void getSkus(Set<String> set, com.revenuecat.purchases.ProductType productType2, GetProductDetailsCallback getProductDetailsCallback3) {
        Purchases.getSkus.1 anon = new Purchases.getSkus.1(this, getProductDetailsCallback3);
        Purchases.getSkus.2 anon2 = new Purchases.getSkus.2(this, getProductDetailsCallback3);
        this.billing.querySkuDetailsAsync(productType2, set, anon, anon2);
    }

    public static void getState$purchases_release$annotations() {
    }

    private final void handleErrorFetchingOfferings(com.revenuecat.purchases.PurchasesError purchasesError, ReceiveOfferingsListener receiveOfferingsListener2) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = purchasesError;
        String format = String.format("Error fetching offerings - %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.GOOGLE_ERROR, format);
        this.deviceCache.clearOfferingsCacheTimestamp();
        Purchases.handleErrorFetchingOfferings.1 anon = new Purchases.handleErrorFetchingOfferings.1(receiveOfferingsListener2, purchasesError);
        dispatch(anon);
    }

    public static void identify$default(com.revenuecat.purchases.Purchases purchases, String string2, ReceivePurchaserInfoListener receivePurchaserInfoListener3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        purchases.identify(string2, obj2);
    }

    public static final void isBillingSupported(Context context, Callback<Boolean> callback2) {
        Purchases.Companion.isBillingSupported(context, callback2);
    }

    public static final void isFeatureSupported(String string, Context context2, Callback<Boolean> callback3) {
        Purchases.Companion.isFeatureSupported(string, context2, callback3);
    }

    public static void logIn$default(com.revenuecat.purchases.Purchases purchases, String string2, LogInCallback logInCallback3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        purchases.logIn(string2, obj2);
    }

    private final w logMissingProducts(com.revenuecat.purchases.Offerings offerings, HashMap<String, ProductDetails> hashMap2) {
        Object arrayList;
        List availablePackages;
        int i;
        boolean next;
        int i4;
        boolean key;
        ArrayList list;
        String str;
        int i2;
        int i5;
        int i7;
        int i3;
        int i9;
        int i6;
        int i8;
        int obj12;
        int obj13;
        ArrayList arrayList2 = new ArrayList();
        obj12 = offerings.getAll().values().iterator();
        for (Offering next5 : obj12) {
            p.y(arrayList2, next5.getAvailablePackages());
        }
        obj12 = new ArrayList(p.r(arrayList2, 10));
        Iterator iterator = arrayList2.iterator();
        for (Package next4 : iterator) {
            obj12.add(next4.getProduct().n());
        }
        arrayList = new ArrayList();
        obj12 = obj12.iterator();
        while (obj12.hasNext()) {
            next = obj12.next();
            if (!hashMap2.containsKey((String)next)) {
            }
            arrayList.add(next);
        }
        obj13 = 1;
        list = obj12 ^= obj13 != 0 ? arrayList : i4;
        if (list != null) {
            Object[] arr = new Object[obj13];
            arr[0] = p.h0(list, ", ", 0, 0, 0, 0, 0, 62, 0);
            obj13 = String.format("Could not find SkuDetails for %s \nThere is a problem with your configuration in Play Store Developer Console. More info here: https://errors.rev.cat/configuring-products", Arrays.copyOf(arr, obj13));
            n.e(obj13, "java.lang.String.format(this, *args)");
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, obj13);
            i4 = w.a;
        }
        return i4;
    }

    public static void logOut$default(com.revenuecat.purchases.Purchases purchases, ReceivePurchaserInfoListener receivePurchaserInfoListener2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        purchases.logOut(obj1);
    }

    private final void postPurchases(List<PurchaseDetails> list, boolean z2, boolean z3, String string4, p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchaserInfo, w> p5, p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchasesError, w> p6) {
        Object purchaseState;
        Object pURCHASED;
        com.revenuecat.purchases.Purchases purchases;
        boolean z4;
        boolean z;
        String str;
        p pVar;
        p pVar2;
        Object obj;
        Object obj2;
        BillingAbstract billing;
        com.revenuecat.purchases.ProductType type;
        Set set;
        com.revenuecat.purchases.Purchases.postPurchases$$inlined.forEach.lambda.1 anon;
        final p pVar4 = p6;
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            obj = next2;
            if ((PurchaseDetails)obj.getPurchaseState() == RevenueCatPurchaseState.PURCHASED) {
            } else {
            }
            obj2 = this;
            if (pVar4 != null) {
            }
            z4 = 0;
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PaymentPendingError, z4, 2, z4);
            LogUtilsKt.errorLog(purchasesError);
            pURCHASED = w.a;
            purchaseState = pVar4.invoke(obj, purchasesError);
            pURCHASED = obj;
            purchases = this;
            z4 = z2;
            z = z3;
            str = string4;
            pVar = p5;
            super(pURCHASED, purchases, z4, z, str, pVar, p6);
            super(pURCHASED, purchases, z4, z, str, pVar, p6);
            obj2.billing.querySkuDetailsAsync(obj.getType(), p.P0(obj.getSkus()), anon, anon3);
        }
        Object obj3 = this;
    }

    static void postPurchases$default(com.revenuecat.purchases.Purchases purchases, List list2, boolean z3, boolean z4, String string5, p p6, p p7, int i8, Object object9) {
        int i;
        int i2;
        final int i5 = 0;
        i = i8 & 16 != 0 ? i5 : p6;
        i2 = i8 & 32 != 0 ? i5 : p7;
        purchases.postPurchases(list2, z3, z4, string5, i, i2);
    }

    public static void postToBackend$purchases_release$default(com.revenuecat.purchases.Purchases purchases, PurchaseDetails purchaseDetails2, ProductDetails productDetails3, boolean z4, boolean z5, String string6, p p7, p p8, int i9, Object object10) {
        int i;
        int i2;
        final int i5 = 0;
        i = i9 & 32 != 0 ? i5 : p7;
        i2 = i9 & 64 != 0 ? i5 : p8;
        purchases.postToBackend$purchases_release(purchaseDetails2, productDetails3, z4, z5, string6, i, i2);
    }

    private final void replaceOldPurchaseWithNewProduct(ProductDetails productDetails, com.revenuecat.purchases.UpgradeInfo upgradeInfo2, Activity activity3, String string4, String string5, PurchaseErrorListener purchaseErrorListener6) {
        super(this, upgradeInfo2, activity3, string4, productDetails, string5);
        Purchases.replaceOldPurchaseWithNewProduct.2 anon3 = new Purchases.replaceOldPurchaseWithNewProduct.2(this, purchaseErrorListener6);
        obj.billing.findPurchaseInPurchaseHistory(string4, productDetails.getType(), upgradeInfo2.getOldSku(), anon4, anon3);
    }

    public static void reset$default(com.revenuecat.purchases.Purchases purchases, ReceivePurchaserInfoListener receivePurchaserInfoListener2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        purchases.reset(obj1);
    }

    private final void retrievePurchaseInfo(String string, ReceivePurchaserInfoListener receivePurchaserInfoListener2) {
        boolean cachedPurchaserInfo;
        Object dEBUG;
        Object anon;
        String str;
        boolean appInBackground;
        int i2;
        int i;
        int i3;
        Object obj10;
        ReceivePurchaserInfoListener obj11;
        cachedPurchaserInfo = this.deviceCache.getCachedPurchaserInfo(string);
        final String str2 = "PurchaserInfo updated from network.";
        if (cachedPurchaserInfo != null) {
            dEBUG = LogIntent.DEBUG;
            LogWrapperKt.log(dEBUG, "Vending PurchaserInfo from cache.");
            anon = new Purchases.retrievePurchaseInfo.1(receivePurchaserInfoListener2, cachedPurchaserInfo);
            dispatch(anon);
            appInBackground = getState$purchases_release().getAppInBackground();
            if (this.deviceCache.isPurchaserInfoCacheStale(string, appInBackground)) {
                obj11 = appInBackground ? "PurchaserInfo cache is stale, updating from network in background." : "PurchaserInfo cache is stale, updating from network in foreground.";
                LogWrapperKt.log(dEBUG, obj11);
                Purchases.fetchAndCachePurchaserInfo$default(this, string, appInBackground, 0, 4, 0);
                LogWrapperKt.log(LogIntent.RC_SUCCESS, str2);
            }
        } else {
            LogWrapperKt.log(LogIntent.DEBUG, "No cached PurchaserInfo, fetching from network.");
            fetchAndCachePurchaserInfo(string, getState$purchases_release().getAppInBackground(), receivePurchaserInfoListener2);
            LogWrapperKt.log(LogIntent.RC_SUCCESS, str2);
        }
    }

    static void retrievePurchaseInfo$default(com.revenuecat.purchases.Purchases purchases, String string2, ReceivePurchaserInfoListener receivePurchaserInfoListener3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        purchases.retrievePurchaseInfo(string2, obj2);
    }

    private final void sendUpdatedPurchaserInfoToDelegateIfChanged(com.revenuecat.purchases.PurchaserInfo purchaserInfo) {
        Object anon;
        LogIntent dEBUG;
        int str;
        com.revenuecat.purchases.PurchasesState state$purchases_release;
        int i2;
        int i4;
        int i5;
        int i6;
        Object obj;
        int i3;
        int i7;
        int i8;
        int i;
        o oVar = u.a(getState$purchases_release().getUpdatedPurchaserInfoListener(), getState$purchases_release().getLastSentPurchaserInfo());
        Object obj2 = oVar.a();
        anon = oVar.b();
        synchronized (this) {
            oVar = u.a(getState$purchases_release().getUpdatedPurchaserInfoListener(), getState$purchases_release().getLastSentPurchaserInfo());
            obj2 = oVar.a();
            anon = oVar.b();
        }
        try {
            if (z ^= 1 != 0) {
            }
            if (anon != null) {
            } else {
            }
            LogWrapperKt.log(LogIntent.DEBUG, "PurchaserInfo updated, sending to listener.");
            LogWrapperKt.log(LogIntent.DEBUG, "Sending latest PurchaserInfo to listener.");
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, 0, 0, purchaserInfo, false, false, 111, 0));
            w wVar = w.a;
            anon = new Purchases.sendUpdatedPurchaserInfoToDelegateIfChanged$$inlined.let.lambda.1((UpdatedPurchaserInfoListener)(UpdatedPurchaserInfoListener)obj2, this, purchaserInfo);
            dispatch(anon);
            throw purchaserInfo;
            throw purchaserInfo;
        } catch (Throwable th) {
        }
    }

    public static final void setDebugLogsEnabled(boolean z) {
        Purchases.Companion.setDebugLogsEnabled(z);
    }

    public static final void setPlatformInfo(PlatformInfo platformInfo) {
        Purchases.platformInfo = platformInfo;
    }

    public static final void setProxyURL(URL uRL) {
        Purchases.proxyURL = uRL;
    }

    public static final void setSharedInstance$purchases_release(com.revenuecat.purchases.Purchases purchases) {
        Purchases.Companion.setSharedInstance$purchases_release(purchases);
    }

    private final void startProductChange(Activity activity, ProductDetails productDetails2, String string3, com.revenuecat.purchases.UpgradeInfo upgradeInfo4, ProductChangeCallback productChangeCallback5) {
        Object purchasesError;
        boolean finishTransactions;
        Object productChangeCallback;
        PurchaseErrorListener th;
        String format;
        int i6;
        Object str2;
        Object[] arr;
        int i8;
        int i5;
        Object obj;
        int string;
        String str;
        int state$purchases_release;
        int i;
        int i3;
        int i7;
        ProductChangeCallback productChangeCallback2;
        int i10;
        int i11;
        int i9;
        int i2;
        int i4;
        final Object obj2 = this;
        purchasesError = string3;
        int i12 = 1;
        arr = new Object[i12];
        StringBuilder stringBuilder = new StringBuilder();
        int i13 = 32;
        stringBuilder.append(i13);
        stringBuilder.append(productDetails2);
        stringBuilder.append(i13);
        i5 = 0;
        if (purchasesError != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" - offering: ");
            stringBuilder2.append(purchasesError);
            string = stringBuilder2.toString();
        } else {
            string = i5;
        }
        stringBuilder.append(string);
        stringBuilder.append(" UpgradeInfo: ");
        stringBuilder.append(upgradeInfo4);
        arr[0] = stringBuilder.toString();
        format = String.format("Product change started: %s", Arrays.copyOf(arr, i12));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.PURCHASE, format);
        synchronized (this) {
            LogWrapperKt.log(LogIntent.WARNING, "finishTransactions is set to false and a purchase has been started. Are you sure you want to do this? More info here: https://errors.rev.cat/finishTransactions");
            if (getState$purchases_release().getProductChangeCallback() == null) {
                obj2.setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, 0, productChangeCallback5, 0, false, false, 119, 0));
                i8 = productChangeCallback;
            } else {
                i8 = i5;
            }
            w wVar = w.a;
            if (i8 != 0) {
            } else {
                purchasesError = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, i5, 2, i5);
                LogUtilsKt.errorLog(purchasesError);
                obj2.dispatch(productChangeCallback5, purchasesError);
            }
        }
        this.replaceOldPurchaseWithNewProduct(productDetails2, upgradeInfo4, activity, i8, string3, productChangeCallback5);
    }

    private final void startPurchase(Activity activity, ProductDetails productDetails2, String string3, PurchaseCallback purchaseCallback4) {
        Object purchasesError;
        Object billing;
        boolean finishTransactions;
        boolean currentAppUserID;
        Object operationAlreadyInProgressError;
        String format;
        int i3;
        Object str2;
        Object[] arr;
        String string;
        int string2;
        int state$purchases_release;
        String str;
        int i;
        Map map;
        int i7;
        int i6;
        int i4;
        int i2;
        int i5;
        int i8;
        final Object obj = this;
        purchasesError = string3;
        billing = purchaseCallback4;
        int i9 = 1;
        arr = new Object[i9];
        StringBuilder stringBuilder = new StringBuilder();
        int i10 = 32;
        stringBuilder.append(i10);
        stringBuilder.append(productDetails2);
        stringBuilder.append(i10);
        int i11 = 0;
        if (purchasesError != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" - offering: ");
            stringBuilder2.append(purchasesError);
            string2 = stringBuilder2.toString();
        } else {
            string2 = i11;
        }
        stringBuilder.append(string2);
        arr[0] = stringBuilder.toString();
        format = String.format("Purchase started - product: %s", Arrays.copyOf(arr, i9));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.PURCHASE, format);
        synchronized (this) {
            LogWrapperKt.log(LogIntent.WARNING, "finishTransactions is set to false and a purchase has been started. Are you sure you want to do this? More info here: https://errors.rev.cat/finishTransactions");
            if (!getState$purchases_release().getPurchaseCallbacks().containsKey(productDetails2.getSku())) {
                obj.setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, j0.o(getState$purchases_release().getPurchaseCallbacks(), j0.e(u.a(productDetails2.getSku(), billing))), 0, 0, false, false, 123, 0));
                i3 = currentAppUserID;
            } else {
                i3 = i11;
            }
            w wVar = w.a;
            if (i3 != 0) {
            } else {
                purchasesError = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, i11, 2, i11);
                LogUtilsKt.errorLog(purchasesError);
                obj.dispatch(billing, purchasesError);
            }
        }
        obj.billing.makePurchaseAsync(activity, i3, productDetails2, 0, string3);
    }

    private final void synchronizeSubscriberAttributesIfNeeded() {
        this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getAppUserID());
    }

    private final void updateAllCaches(String string, ReceivePurchaserInfoListener receivePurchaserInfoListener2) {
        final boolean appInBackground = getState$purchases_release().getAppInBackground();
        fetchAndCachePurchaserInfo(string, appInBackground, receivePurchaserInfoListener2);
        Purchases.fetchAndCacheOfferings$default(this, string, appInBackground, 0, 4, 0);
    }

    static void updateAllCaches$default(com.revenuecat.purchases.Purchases purchases, String string2, ReceivePurchaserInfoListener receivePurchaserInfoListener3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        purchases.updateAllCaches(string2, obj2);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void close() {
        final Map emptyMap = Collections.emptyMap();
        n.e(emptyMap, "emptyMap()");
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, emptyMap, 0, 0, false, false, 123, 0));
        w wVar = w.a;
        this.backend.close();
        int i2 = 0;
        this.billing.setPurchasesUpdatedListener(i2);
        setUpdatedPurchaserInfoListener(i2);
        Purchases.close.2 anon = new Purchases.close.2(this);
        dispatch(anon);
        return;
        synchronized (this) {
            emptyMap = Collections.emptyMap();
            n.e(emptyMap, "emptyMap()");
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, emptyMap, 0, 0, false, false, 123, 0));
            wVar = w.a;
            this.backend.close();
            i2 = 0;
            this.billing.setPurchasesUpdatedListener(i2);
            setUpdatedPurchaserInfoListener(i2);
            anon = new Purchases.close.2(this);
            dispatch(anon);
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void collectDeviceIdentifiers() {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "collectDeviceIdentifiers";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.collectDeviceIdentifiers(getAppUserID(), this.application);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void createAlias(String string) {
        final int i = 0;
        Purchases.createAlias$default(this, string, i, 2, i);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void createAlias(String string, ReceivePurchaserInfoListener receivePurchaserInfoListener2) {
        String currentAppUserID;
        boolean anon;
        com.revenuecat.purchases.Purchases.createAlias$$inlined.let.lambda.2 anon2;
        Object obj4;
        n.f(string, "newAppUserID");
        if (!n.b(this.identityManager.getCurrentAppUserID(), string)) {
        } else {
            currentAppUserID = 0;
        }
        if (currentAppUserID != null) {
            anon = new Purchases.createAlias$$inlined.let.lambda.1(this, string, receivePurchaserInfoListener2);
            anon2 = new Purchases.createAlias$$inlined.let.lambda.2(this, string, receivePurchaserInfoListener2);
            this.identityManager.createAlias(string, anon, anon2);
        } else {
            retrievePurchaseInfo(this.identityManager.getCurrentAppUserID(), receivePurchaserInfoListener2);
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final boolean getAllowSharingPlayStoreAccount() {
        boolean currentUserIsAnonymous;
        Boolean allowSharingPlayStoreAccount = getState$purchases_release().getAllowSharingPlayStoreAccount();
        synchronized (this) {
            try {
                currentUserIsAnonymous = allowSharingPlayStoreAccount.booleanValue();
                currentUserIsAnonymous = this.identityManager.currentUserIsAnonymous();
                return currentUserIsAnonymous;
                throw th;
            }
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final AppConfig getAppConfig$purchases_release() {
        return this.appConfig;
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final String getAppUserID() {
        return this.identityManager.getCurrentAppUserID();
        synchronized (this) {
            return this.identityManager.getCurrentAppUserID();
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
        synchronized (this) {
            return this.appConfig.getFinishTransactions();
        }
    }

    public final void getNonSubscriptionSkus(List<String> list, GetSkusResponseListener getSkusResponseListener2) {
        n.f(list, "skus");
        n.f(getSkusResponseListener2, "listener");
        Purchases.getNonSubscriptionSkus.1 anon = new Purchases.getNonSubscriptionSkus.1(getSkusResponseListener2);
        getSkus(p.P0(list), ProductTypeConversionsKt.toProductType("inapp"), anon);
    }

    public final void getNonSubscriptionSkus$purchases_release(List<String> list, GetProductDetailsCallback getProductDetailsCallback2) {
        n.f(list, "skus");
        n.f(getProductDetailsCallback2, "callback");
        getSkus(p.P0(list), ProductType.INAPP, getProductDetailsCallback2);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void getOfferings(ReceiveOfferingsListener receiveOfferingsListener) {
        Object appInBackground;
        Object dEBUG;
        Object anon;
        boolean appInBackground2;
        int i;
        int i3;
        int i2;
        boolean obj9;
        n.f(receiveOfferingsListener, "listener");
        o oVar = u.a(this.identityManager.getCurrentAppUserID(), this.deviceCache.getCachedOfferings());
        final Object obj2 = obj;
        appInBackground = oVar.b();
        synchronized (this) {
            n.f(receiveOfferingsListener, "listener");
            oVar = u.a(this.identityManager.getCurrentAppUserID(), this.deviceCache.getCachedOfferings());
            obj2 = obj;
            appInBackground = oVar.b();
        }
        LogWrapperKt.log(LogIntent.DEBUG, "No cached Offerings, fetching from network");
        fetchAndCacheOfferings((String)(String)obj2, getState$purchases_release().getAppInBackground(), receiveOfferingsListener);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void getPurchaserInfo(ReceivePurchaserInfoListener receivePurchaserInfoListener) {
        n.f(receivePurchaserInfoListener, "listener");
        retrievePurchaseInfo(this.identityManager.getCurrentAppUserID(), receivePurchaserInfoListener);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final com.revenuecat.purchases.PurchasesState getState$purchases_release() {
        return this.state;
        synchronized (this) {
            return this.state;
        }
    }

    public final void getSubscriptionSkus(List<String> list, GetSkusResponseListener getSkusResponseListener2) {
        n.f(list, "skus");
        n.f(getSkusResponseListener2, "listener");
        Purchases.getSubscriptionSkus.1 anon = new Purchases.getSubscriptionSkus.1(getSkusResponseListener2);
        getSkus(p.P0(list), ProductTypeConversionsKt.toProductType("subs"), anon);
    }

    public final void getSubscriptionSkus$purchases_release(List<String> list, GetProductDetailsCallback getProductDetailsCallback2) {
        n.f(list, "skus");
        n.f(getProductDetailsCallback2, "callback");
        getSkus(p.P0(list), ProductType.SUBS, getProductDetailsCallback2);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final UpdatedPurchaserInfoListener getUpdatedPurchaserInfoListener() {
        return getState$purchases_release().getUpdatedPurchaserInfoListener();
        synchronized (this) {
            return getState$purchases_release().getUpdatedPurchaserInfoListener();
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void identify(String string) {
        final int i = 0;
        Purchases.identify$default(this, string, i, 2, i);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void identify(String string, ReceivePurchaserInfoListener receivePurchaserInfoListener2) {
        String currentAppUserID;
        boolean anon;
        com.revenuecat.purchases.Purchases.identify$$inlined.let.lambda.2 anon2;
        Object obj4;
        n.f(string, "newAppUserID");
        if (!n.b(this.identityManager.getCurrentAppUserID(), string)) {
        } else {
            currentAppUserID = 0;
        }
        if (currentAppUserID != null) {
            anon = new Purchases.identify$$inlined.let.lambda.1(this, string, receivePurchaserInfoListener2);
            anon2 = new Purchases.identify$$inlined.let.lambda.2(this, string, receivePurchaserInfoListener2);
            this.identityManager.identify(string, anon, anon2);
        } else {
            retrievePurchaseInfo(this.identityManager.getCurrentAppUserID(), receivePurchaserInfoListener2);
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void invalidatePurchaserInfoCache() {
        LogWrapperKt.log(LogIntent.DEBUG, "Invalidating PurchaserInfo cache.");
        this.deviceCache.clearPurchaserInfoCache(getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final boolean isAnonymous() {
        return this.identityManager.currentUserIsAnonymous();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void logIn(String string) {
        final int i = 0;
        Purchases.logIn$default(this, string, i, 2, i);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void logIn(String string, LogInCallback logInCallback2) {
        String currentAppUserID;
        Object identityManager;
        p anon2;
        com.revenuecat.purchases.Purchases.logIn$$inlined.let.lambda.2 anon;
        Object obj4;
        Object obj5;
        n.f(string, "newAppUserID");
        if (!n.b(this.identityManager.getCurrentAppUserID(), string)) {
        } else {
            currentAppUserID = 0;
        }
        if (currentAppUserID != null) {
            anon2 = new Purchases.logIn$$inlined.let.lambda.1(this, string, logInCallback2);
            anon = new Purchases.logIn$$inlined.let.lambda.2(this, string, logInCallback2);
            this.identityManager.logIn(string, anon2, anon);
        } else {
            identityManager = new Purchases.logIn.3(this, logInCallback2);
            anon2 = new Purchases.logIn.4(this, logInCallback2);
            retrievePurchaseInfo(this.identityManager.getCurrentAppUserID(), ListenerConversionsKt.receivePurchaserInfoListener(identityManager, anon2));
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void logOut() {
        final int i = 0;
        Purchases.logOut$default(this, i, 1, i);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void logOut(ReceivePurchaserInfoListener receivePurchaserInfoListener) {
        Object currentAppUserID;
        com.revenuecat.purchases.PurchasesState state$purchases_release;
        int i2;
        int i8;
        Map emptyMap;
        int i4;
        int i7;
        int i5;
        int i3;
        int i6;
        int i;
        currentAppUserID = this.identityManager.logOut();
        if (currentAppUserID != null) {
            if (receivePurchaserInfoListener != null) {
                receivePurchaserInfoListener.onError(currentAppUserID);
            }
        } else {
            this.backend.clearCaches();
            emptyMap = Collections.emptyMap();
            n.e(emptyMap, "emptyMap()");
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, emptyMap, 0, 0, false, false, 123, 0));
            w wVar = w.a;
            updateAllCaches(this.identityManager.getCurrentAppUserID(), receivePurchaserInfoListener);
            synchronized (this) {
                this.backend.clearCaches();
                emptyMap = Collections.emptyMap();
                n.e(emptyMap, "emptyMap()");
                setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, emptyMap, 0, 0, false, false, 123, 0));
                wVar = w.a;
                updateAllCaches(this.identityManager.getCurrentAppUserID(), receivePurchaserInfoListener);
            }
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppBackgrounded() {
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, 0, 0, 0, true, false, 95, 0));
        w wVar = w.a;
        LogWrapperKt.log(LogIntent.DEBUG, "App backgrounded");
        synchronizeSubscriberAttributesIfNeeded();
        return;
        synchronized (this) {
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, 0, 0, 0, true, false, 95, 0));
            wVar = w.a;
            LogWrapperKt.log(LogIntent.DEBUG, "App backgrounded");
            synchronizeSubscriberAttributesIfNeeded();
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppForegrounded() {
        boolean firstTimeInForeground;
        boolean offeringsCacheStale;
        Object dEBUG;
        int currentAppUserID;
        Object appUserID;
        int currentAppUserID2;
        int i4;
        int i2;
        int i3;
        int i;
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, 0, 0, 0, false, false, 31, 0));
        w wVar = w.a;
        dEBUG = LogIntent.DEBUG;
        LogWrapperKt.log(dEBUG, "App foregrounded");
        currentAppUserID = 0;
        synchronized (this) {
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, 0, 0, 0, false, false, 31, 0));
            wVar = w.a;
            dEBUG = LogIntent.DEBUG;
            LogWrapperKt.log(dEBUG, "App foregrounded");
            currentAppUserID = 0;
        }
        try {
            if (this.deviceCache.isPurchaserInfoCacheStale(getAppUserID(), currentAppUserID)) {
            }
            LogWrapperKt.log(dEBUG, "PurchaserInfo cache is stale, updating from network in foreground.");
            Purchases.fetchAndCachePurchaserInfo$default(this, this.identityManager.getCurrentAppUserID(), false, 0, 4, 0);
            if (this.deviceCache.isOfferingsCacheStale(currentAppUserID)) {
            }
            LogWrapperKt.log(dEBUG, "Offerings cache is stale, updating from network in foreground");
            Purchases.fetchAndCacheOfferings$default(this, this.identityManager.getCurrentAppUserID(), false, 0, 4, 0);
            LogWrapperKt.log(LogIntent.RC_SUCCESS, "Offerings updated from network.");
            updatePendingPurchaseQueue$purchases_release();
            synchronizeSubscriberAttributesIfNeeded();
            throw th;
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void postAttributionData$purchases_release(JSONObject jSONObject, AttributionNetwork attributionNetwork2, String string3) {
        n.f(jSONObject, "jsonObject");
        n.f(attributionNetwork2, "network");
        Purchases.postAttributionData.1 anon = new Purchases.postAttributionData.1(this, attributionNetwork2, string3, jSONObject);
        AdvertisingIdClient.INSTANCE.getAdvertisingIdInfo(this.application, anon);
    }

    public final void postToBackend$purchases_release(PurchaseDetails purchaseDetails, ProductDetails productDetails2, boolean z3, boolean z4, String string5, p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchaserInfo, w> p6, p<? super PurchaseDetails, ? super com.revenuecat.purchases.PurchasesError, w> p7) {
        final Object obj = this;
        Object obj3 = string5;
        n.f(purchaseDetails, "purchase");
        n.f(obj3, "appUserID");
        Map unsyncedSubscriberAttributes = obj.subscriberAttributesManager.getUnsyncedSubscriberAttributes(obj3);
        ReceiptInfo receiptInfo = new ReceiptInfo(purchaseDetails.getSkus(), purchaseDetails.getPresentedOfferingIdentifier(), productDetails2);
        com.revenuecat.purchases.Purchases purchases = this;
        String str3 = string5;
        final Map map = unsyncedSubscriberAttributes;
        final int i = z4;
        final PurchaseDetails purchaseDetails2 = purchaseDetails;
        super(purchases, str3, map, i, purchaseDetails2, p6);
        super(purchases, str3, map, i, purchaseDetails2, p7);
        obj.backend.postReceiptData(purchaseDetails.getPurchaseToken(), string5, z3, z4 ^ 1, BackendHelpersKt.toBackendMap(unsyncedSubscriberAttributes), receiptInfo, purchaseDetails.getStoreUserID(), anon4, anon6);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchasePackage(Activity activity, com.revenuecat.purchases.Package package2, com.revenuecat.purchases.UpgradeInfo upgradeInfo3, MakePurchaseListener makePurchaseListener4) {
        n.f(activity, "activity");
        n.f(package2, "packageToPurchase");
        n.f(upgradeInfo3, "upgradeInfo");
        n.f(makePurchaseListener4, "listener");
        this.startProductChange(activity, SkuDetailsConverterKt.toProductDetails(package2.getProduct()), package2.getOffering(), upgradeInfo3, ProductChangeCallbackKt.toProductChangeCallback(makePurchaseListener4));
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchasePackage(Activity activity, com.revenuecat.purchases.Package package2, com.revenuecat.purchases.UpgradeInfo upgradeInfo3, ProductChangeListener productChangeListener4) {
        n.f(activity, "activity");
        n.f(package2, "packageToPurchase");
        n.f(upgradeInfo3, "upgradeInfo");
        n.f(productChangeListener4, "listener");
        purchasePackage$purchases_release(activity, package2, upgradeInfo3, ProductChangeCallbackKt.toProductChangeCallback(productChangeListener4));
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchasePackage(Activity activity, com.revenuecat.purchases.Package package2, MakePurchaseListener makePurchaseListener3) {
        n.f(activity, "activity");
        n.f(package2, "packageToPurchase");
        n.f(makePurchaseListener3, "listener");
        purchasePackage$purchases_release(activity, package2, PurchaseCallbackKt.toPurchaseCallback(makePurchaseListener3));
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchasePackage$purchases_release(Activity activity, com.revenuecat.purchases.Package package2, com.revenuecat.purchases.UpgradeInfo upgradeInfo3, ProductChangeCallback productChangeCallback4) {
        n.f(activity, "activity");
        n.f(package2, "packageToPurchase");
        n.f(upgradeInfo3, "upgradeInfo");
        n.f(productChangeCallback4, "callback");
        this.startProductChange(activity, SkuDetailsConverterKt.toProductDetails(package2.getProduct()), package2.getOffering(), upgradeInfo3, productChangeCallback4);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchasePackage$purchases_release(Activity activity, com.revenuecat.purchases.Package package2, PurchaseCallback purchaseCallback3) {
        n.f(activity, "activity");
        n.f(package2, "packageToPurchase");
        n.f(purchaseCallback3, "listener");
        startPurchase(activity, SkuDetailsConverterKt.toProductDetails(package2.getProduct()), package2.getOffering(), purchaseCallback3);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchaseProduct(Activity activity, SkuDetails skuDetails2, com.revenuecat.purchases.UpgradeInfo upgradeInfo3, MakePurchaseListener makePurchaseListener4) {
        n.f(activity, "activity");
        n.f(skuDetails2, "skuDetails");
        n.f(upgradeInfo3, "upgradeInfo");
        n.f(makePurchaseListener4, "listener");
        purchaseProduct$purchases_release(activity, SkuDetailsConverterKt.toProductDetails(skuDetails2), upgradeInfo3, ProductChangeCallbackKt.toProductChangeCallback(makePurchaseListener4));
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchaseProduct(Activity activity, SkuDetails skuDetails2, com.revenuecat.purchases.UpgradeInfo upgradeInfo3, ProductChangeListener productChangeListener4) {
        n.f(activity, "activity");
        n.f(skuDetails2, "skuDetails");
        n.f(upgradeInfo3, "upgradeInfo");
        n.f(productChangeListener4, "listener");
        purchaseProduct$purchases_release(activity, SkuDetailsConverterKt.toProductDetails(skuDetails2), upgradeInfo3, ProductChangeCallbackKt.toProductChangeCallback(productChangeListener4));
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchaseProduct(Activity activity, SkuDetails skuDetails2, MakePurchaseListener makePurchaseListener3) {
        n.f(activity, "activity");
        n.f(skuDetails2, "skuDetails");
        n.f(makePurchaseListener3, "listener");
        purchaseProduct$purchases_release(activity, SkuDetailsConverterKt.toProductDetails(skuDetails2), PurchaseCallbackKt.toPurchaseCallback(makePurchaseListener3));
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchaseProduct$purchases_release(Activity activity, ProductDetails productDetails2, com.revenuecat.purchases.UpgradeInfo upgradeInfo3, ProductChangeCallback productChangeCallback4) {
        n.f(activity, "activity");
        n.f(productDetails2, "productDetails");
        n.f(upgradeInfo3, "upgradeInfo");
        n.f(productChangeCallback4, "listener");
        this.startProductChange(activity, productDetails2, 0, upgradeInfo3, productChangeCallback4);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void purchaseProduct$purchases_release(Activity activity, ProductDetails productDetails2, PurchaseCallback purchaseCallback3) {
        n.f(activity, "activity");
        n.f(productDetails2, "productDetails");
        n.f(purchaseCallback3, "callback");
        startPurchase(activity, productDetails2, 0, purchaseCallback3);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void removeUpdatedPurchaserInfoListener() {
        setUpdatedPurchaserInfoListener(0);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void reset() {
        final int i = 0;
        Purchases.reset$default(this, i, 1, i);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void reset(ReceivePurchaserInfoListener receivePurchaserInfoListener) {
        this.deviceCache.clearLatestAttributionData(this.identityManager.getCurrentAppUserID());
        this.identityManager.reset();
        this.backend.clearCaches();
        final Map emptyMap = Collections.emptyMap();
        n.e(emptyMap, "emptyMap()");
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, emptyMap, 0, 0, false, false, 123, 0));
        w wVar = w.a;
        updateAllCaches(this.identityManager.getCurrentAppUserID(), receivePurchaserInfoListener);
        return;
        synchronized (this) {
            this.deviceCache.clearLatestAttributionData(this.identityManager.getCurrentAppUserID());
            this.identityManager.reset();
            this.backend.clearCaches();
            emptyMap = Collections.emptyMap();
            n.e(emptyMap, "emptyMap()");
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, 0, emptyMap, 0, 0, false, false, 123, 0));
            wVar = w.a;
            updateAllCaches(this.identityManager.getCurrentAppUserID(), receivePurchaserInfoListener);
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void restorePurchases(ReceivePurchaserInfoListener receivePurchaserInfoListener) {
        boolean allowSharingPlayStoreAccount;
        String str;
        n.f(receivePurchaserInfoListener, "listener");
        LogWrapperKt.log(LogIntent.DEBUG, "Restoring purchases");
        if (!getAllowSharingPlayStoreAccount()) {
            LogWrapperKt.log(LogIntent.WARNING, "allowSharingPlayStoreAccount is set to false and restorePurchases has been called. This will 'alias' any app user id's sharing the same receipt. Are you sure you want to do this? More info here: https://errors.rev.cat/allowsSharingPlayStoreAccount");
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Purchases.restorePurchases$$inlined.let.lambda.1 anon2 = new Purchases.restorePurchases$$inlined.let.lambda.1(getFinishTransactions(), this, currentAppUserID, receivePurchaserInfoListener);
        Purchases.restorePurchases$$inlined.let.lambda.2 anon = new Purchases.restorePurchases$$inlined.let.lambda.2(this, currentAppUserID, receivePurchaserInfoListener);
        this.billing.queryAllPurchases(currentAppUserID, anon2, anon);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setAd(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setAd";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setAdGroup(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setAdGroup";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setAdjustID(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setAdjustID";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Adjust.INSTANCE, string, getAppUserID(), this.application);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setAllowSharingPlayStoreAccount(boolean z) {
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), Boolean.valueOf(z), 0, 0, 0, 0, false, false, 126, 0));
        return;
        synchronized (this) {
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), Boolean.valueOf(z), 0, 0, 0, 0, false, false, 126, 0));
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setAppConfig$purchases_release(AppConfig appConfig) {
        n.f(appConfig, "<set-?>");
        this.appConfig = appConfig;
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setAppsflyerID(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setAppsflyerID";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.AppsFlyer.INSTANCE, string, getAppUserID(), this.application);
    }

    public final void setAttributes(Map<String, String> map) {
        n.f(map, "attributes");
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setAttributes";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttributes(map, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setCampaign(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setCampaign";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setCreative(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setCreative";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setDisplayName(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setDisplayName";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.DisplayName.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setEmail(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setEmail";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.Email.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setFBAnonymousID(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setFBAnonymousID";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Facebook.INSTANCE, string, getAppUserID(), this.application);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setFinishTransactions(boolean z) {
        this.appConfig.setFinishTransactions(z);
        return;
        synchronized (this) {
            this.appConfig.setFinishTransactions(z);
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setKeyword(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "seKeyword";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setMediaSource(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setMediaSource";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setMparticleID(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setMparticleID";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Mparticle.INSTANCE, string, getAppUserID(), this.application);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setOnesignalID(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setOnesignalID";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.OneSignal.INSTANCE, string, getAppUserID(), this.application);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setPhoneNumber(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setPhoneNumber";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.PhoneNumber.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setPushToken(String string) {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = "setPushToken";
        String format = String.format("%s called", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.FCMTokens.INSTANCE, string, getAppUserID());
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setState$purchases_release(com.revenuecat.purchases.PurchasesState purchasesState) {
        n.f(purchasesState, "value");
        this.state = purchasesState;
        return;
        synchronized (this) {
            n.f(purchasesState, "value");
            this.state = purchasesState;
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void setUpdatedPurchaserInfoListener(UpdatedPurchaserInfoListener updatedPurchaserInfoListener) {
        setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, updatedPurchaserInfoListener, 0, 0, 0, false, false, 125, 0));
        w wVar = w.a;
        afterSetListener(updatedPurchaserInfoListener);
        return;
        synchronized (this) {
            setState$purchases_release(PurchasesState.copy$default(getState$purchases_release(), 0, updatedPurchaserInfoListener, 0, 0, 0, false, false, 125, 0));
            wVar = w.a;
            afterSetListener(updatedPurchaserInfoListener);
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void syncPurchases() {
        LogWrapperKt.log(LogIntent.DEBUG, "Syncing purchases");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        Purchases.syncPurchases.1 anon = new Purchases.syncPurchases.1(this, currentAppUserID);
        this.billing.queryAllPurchases(currentAppUserID, anon, Purchases.syncPurchases.2.INSTANCE);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public final void updatePendingPurchaseQueue$purchases_release() {
        Object dispatcher;
        Object anon;
        int i3;
        int i2;
        int i;
        if (this.billing.isConnected()) {
            LogWrapperKt.log(LogIntent.DEBUG, "Updating pending purchase queue");
            anon = new Purchases.updatePendingPurchaseQueue.1(this);
            Dispatcher.enqueue$default(this.dispatcher, anon, false, 2, 0);
        } else {
            LogWrapperKt.log(LogIntent.DEBUG, "Skipping updating pending purchase queue since BillingClient is not connected yet.");
        }
    }
}
