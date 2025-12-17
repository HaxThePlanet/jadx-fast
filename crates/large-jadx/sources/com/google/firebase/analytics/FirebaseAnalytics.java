package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.g3;
import com.google.android.gms.measurement.internal.j7;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class FirebaseAnalytics {

    private static volatile com.google.firebase.analytics.FirebaseAnalytics zza;
    private final g3 zzb;
    private ExecutorService zzc;

    public static enum ConsentStatus {

        GRANTED,
        DENIED;
    }

    public static enum ConsentType {

        AD_STORAGE,
        ANALYTICS_STORAGE;
    }

    public static class Event {

        public static final String ADD_PAYMENT_INFO = "add_payment_info";
        public static final String ADD_SHIPPING_INFO = "add_shipping_info";
        public static final String ADD_TO_CART = "add_to_cart";
        public static final String ADD_TO_WISHLIST = "add_to_wishlist";
        public static final String AD_IMPRESSION = "ad_impression";
        public static final String APP_OPEN = "app_open";
        public static final String BEGIN_CHECKOUT = "begin_checkout";
        public static final String CAMPAIGN_DETAILS = "campaign_details";
        @Deprecated
        public static final String CHECKOUT_PROGRESS = "checkout_progress";
        public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
        @Deprecated
        public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
        public static final String GENERATE_LEAD = "generate_lead";
        public static final String JOIN_GROUP = "join_group";
        public static final String LEVEL_END = "level_end";
        public static final String LEVEL_START = "level_start";
        public static final String LEVEL_UP = "level_up";
        public static final String LOGIN = "login";
        public static final String POST_SCORE = "post_score";
        @Deprecated
        public static final String PRESENT_OFFER = "present_offer";
        public static final String PURCHASE = "purchase";
        @Deprecated
        public static final String PURCHASE_REFUND = "purchase_refund";
        public static final String REFUND = "refund";
        public static final String REMOVE_FROM_CART = "remove_from_cart";
        public static final String SCREEN_VIEW = "screen_view";
        public static final String SEARCH = "search";
        public static final String SELECT_CONTENT = "select_content";
        public static final String SELECT_ITEM = "select_item";
        public static final String SELECT_PROMOTION = "select_promotion";
        @Deprecated
        public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
        public static final String SHARE = "share";
        public static final String SIGN_UP = "sign_up";
        public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
        public static final String TUTORIAL_BEGIN = "tutorial_begin";
        public static final String TUTORIAL_COMPLETE = "tutorial_complete";
        public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
        public static final String VIEW_CART = "view_cart";
        public static final String VIEW_ITEM = "view_item";
        public static final String VIEW_ITEM_LIST = "view_item_list";
        public static final String VIEW_PROMOTION = "view_promotion";
        public static final String VIEW_SEARCH_RESULTS = "view_search_results";
    }

    public static class Param {

        public static final String ACHIEVEMENT_ID = "achievement_id";
        public static final String ACLID = "aclid";
        public static final String AD_FORMAT = "ad_format";
        public static final String AD_PLATFORM = "ad_platform";
        public static final String AD_SOURCE = "ad_source";
        public static final String AD_UNIT_NAME = "ad_unit_name";
        public static final String AFFILIATION = "affiliation";
        public static final String CAMPAIGN = "campaign";
        public static final String CHARACTER = "character";
        @Deprecated
        public static final String CHECKOUT_OPTION = "checkout_option";
        @Deprecated
        public static final String CHECKOUT_STEP = "checkout_step";
        public static final String CONTENT = "content";
        public static final String CONTENT_TYPE = "content_type";
        public static final String COUPON = "coupon";
        public static final String CP1 = "cp1";
        public static final String CREATIVE_NAME = "creative_name";
        public static final String CREATIVE_SLOT = "creative_slot";
        public static final String CURRENCY = "currency";
        public static final String DESTINATION = "destination";
        public static final String DISCOUNT = "discount";
        public static final String END_DATE = "end_date";
        public static final String EXTEND_SESSION = "extend_session";
        public static final String FLIGHT_NUMBER = "flight_number";
        public static final String GROUP_ID = "group_id";
        public static final String INDEX = "index";
        public static final String ITEMS = "items";
        public static final String ITEM_BRAND = "item_brand";
        public static final String ITEM_CATEGORY = "item_category";
        public static final String ITEM_CATEGORY2 = "item_category2";
        public static final String ITEM_CATEGORY3 = "item_category3";
        public static final String ITEM_CATEGORY4 = "item_category4";
        public static final String ITEM_CATEGORY5 = "item_category5";
        public static final String ITEM_ID = "item_id";
        @Deprecated
        public static final String ITEM_LIST = "item_list";
        public static final String ITEM_LIST_ID = "item_list_id";
        public static final String ITEM_LIST_NAME = "item_list_name";
        @Deprecated
        public static final String ITEM_LOCATION_ID = "item_location_id";
        public static final String ITEM_NAME = "item_name";
        public static final String ITEM_VARIANT = "item_variant";
        public static final String LEVEL = "level";
        public static final String LEVEL_NAME = "level_name";
        public static final String LOCATION = "location";
        public static final String LOCATION_ID = "location_id";
        public static final String MEDIUM = "medium";
        public static final String METHOD = "method";
        public static final String NUMBER_OF_NIGHTS = "number_of_nights";
        public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
        public static final String NUMBER_OF_ROOMS = "number_of_rooms";
        public static final String ORIGIN = "origin";
        public static final String PAYMENT_TYPE = "payment_type";
        public static final String PRICE = "price";
        public static final String PROMOTION_ID = "promotion_id";
        public static final String PROMOTION_NAME = "promotion_name";
        public static final String QUANTITY = "quantity";
        public static final String SCORE = "score";
        public static final String SCREEN_CLASS = "screen_class";
        public static final String SCREEN_NAME = "screen_name";
        public static final String SEARCH_TERM = "search_term";
        public static final String SHIPPING = "shipping";
        public static final String SHIPPING_TIER = "shipping_tier";
        @Deprecated
        public static final String SIGN_UP_METHOD = "sign_up_method";
        public static final String SOURCE = "source";
        public static final String START_DATE = "start_date";
        public static final String SUCCESS = "success";
        public static final String TAX = "tax";
        public static final String TERM = "term";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String TRAVEL_CLASS = "travel_class";
        public static final String VALUE = "value";
        public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";
    }

    public static class UserProperty {

        public static final String ALLOW_AD_PERSONALIZATION_SIGNALS = "allow_personalized_ads";
        public static final String SIGN_UP_METHOD = "sign_up_method";
    }
    public FirebaseAnalytics(g3 g3) {
        super();
        r.j(g3);
        this.zzb = g3;
    }

    public static com.google.firebase.analytics.FirebaseAnalytics getInstance(Context context) {
        com.google.firebase.analytics.FirebaseAnalytics zza;
        com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
        Object obj2;
        zza = FirebaseAnalytics.class;
        if (FirebaseAnalytics.zza == null && FirebaseAnalytics.zza == null) {
            zza = FirebaseAnalytics.class;
            synchronized (zza) {
                int i = 0;
                firebaseAnalytics = new FirebaseAnalytics(g3.A(context, i, i, i, i));
                FirebaseAnalytics.zza = firebaseAnalytics;
            }
        }
        return FirebaseAnalytics.zza;
    }

    public static j7 getScionFrontendApiImplementation(Context context, Bundle bundle2) {
        final int i = 0;
        final g3 obj1 = g3.A(context, i, i, i, bundle2);
        if (obj1 == null) {
            return i;
        }
        zzc obj2 = new zzc(obj1);
        return obj2;
    }

    static g3 zza(com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics) {
        return firebaseAnalytics.zzb;
    }

    public j<String> getAppInstanceId() {
        Object zzc;
        com.google.firebase.analytics.zza i;
        Object str;
        int i4;
        int i3;
        int i2;
        TimeUnit sECONDS;
        ArrayBlockingQueue arrayBlockingQueue;
        Class<com.google.firebase.analytics.FirebaseAnalytics> obj = FirebaseAnalytics.class;
        synchronized (obj) {
            arrayBlockingQueue = new ArrayBlockingQueue(100);
            super(this, 0, 1, 30, obj7, TimeUnit.SECONDS, arrayBlockingQueue);
            this.zzc = zzc;
            zzb zzb = new zzb(this);
            return m.c(this.zzc, zzb);
        }
    }

    public String getFirebaseInstanceId() {
        try {
            return (String)m.b(FirebaseInstallations.getInstance().getId(), 30000, obj2);
            IllegalStateException illegalStateException = new IllegalStateException(cause);
            throw illegalStateException;
            illegalStateException = "Firebase Installations getId Task has timed out.";
            IllegalThreadStateException cause = new IllegalThreadStateException(illegalStateException);
            throw cause;
            cause = cause.getCause();
            illegalStateException = new IllegalStateException(cause);
            throw illegalStateException;
        }
    }

    public void logEvent(String string, Bundle bundle2) {
        this.zzb.Q(string, bundle2);
    }

    public void resetAnalyticsData() {
        this.zzb.c();
    }

    public void setAnalyticsCollectionEnabled(boolean z) {
        this.zzb.j(Boolean.valueOf(z));
    }

    public void setConsent(Map<com.google.firebase.analytics.FirebaseAnalytics.ConsentType, com.google.firebase.analytics.FirebaseAnalytics.ConsentStatus> map) {
        Object ordinal;
        Object aNALYTICS_STORAGE;
        String str;
        Object obj7;
        Bundle bundle = new Bundle();
        ordinal = map.get(FirebaseAnalytics.ConsentType.AD_STORAGE);
        final String str2 = "denied";
        final String str3 = "granted";
        final int i = 1;
        if ((FirebaseAnalytics.ConsentStatus)ordinal != null) {
            ordinal = (FirebaseAnalytics.ConsentStatus)ordinal.ordinal();
            str = "ad_storage";
            if (ordinal != 0) {
                if (ordinal != i) {
                } else {
                    bundle.putString(str, str2);
                }
            } else {
                bundle.putString(str, str3);
            }
        }
        obj7 = map.get(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE);
        if ((FirebaseAnalytics.ConsentStatus)obj7 != null) {
            obj7 = (FirebaseAnalytics.ConsentStatus)obj7.ordinal();
            aNALYTICS_STORAGE = "analytics_storage";
            if (obj7 != null) {
                if (obj7 != i) {
                } else {
                    bundle.putString(aNALYTICS_STORAGE, str2);
                }
            } else {
                bundle.putString(aNALYTICS_STORAGE, str3);
            }
        }
        this.zzb.e(bundle);
    }

    @Deprecated
    public void setCurrentScreen(Activity activity, String string2, String string3) {
        this.zzb.f(activity, string2, string3);
    }

    public void setDefaultEventParameters(Bundle bundle) {
        this.zzb.h(bundle);
    }

    public void setSessionTimeoutDuration(long l) {
        this.zzb.k(l);
    }

    public void setUserId(String string) {
        this.zzb.l(string);
    }

    public void setUserProperty(String string, String string2) {
        this.zzb.m(0, string, string2, false);
    }
}
