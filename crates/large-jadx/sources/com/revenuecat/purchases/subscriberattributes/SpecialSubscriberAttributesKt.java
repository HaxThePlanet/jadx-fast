package com.revenuecat.purchases.subscriberattributes;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0018\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0005\"\u0016\u0010\u0008\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0005\"\u0016\u0010\t\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0005\"\u0016\u0010\n\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0005\"\u0016\u0010\u000b\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0005\"\u0016\u0010\u000c\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0005\"\u0016\u0010\r\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\r\u0010\u0005\"\u0016\u0010\u000e\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0005\"\u0016\u0010\u0010\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0005\"\u0016\u0010\u0012\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0005\"\u0016\u0010\u0013\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0005\"\u0016\u0010\u0014\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u0005\"\u0016\u0010\u0015\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0005\"\u0016\u0010\u0016\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0005\"\u0016\u0010\u0017\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0005\"\u0016\u0010\u0018\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0005¨\u0006\u0019", d2 = {"", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "getSubscriberAttributeKey", "(Ljava/lang/String;)Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "SPECIAL_KEY_APPSFLYER_ID", "Ljava/lang/String;", "SPECIAL_KEY_FCM_TOKENS", "SPECIAL_KEY_MEDIA_SOURCE", "SPECIAL_KEY_IDFV", "SPECIAL_KEY_ADJUST_ID", "SPECIAL_KEY_IP", "SPECIAL_KEY_DISPLAY_NAME", "SPECIAL_KEY_PHONE_NUMBER", "SPECIAL_KEY_KEYWORD", "SPECIAL_KEY_MPARTICLE_ID", "SPECIAL_KEY_ONESIGNAL_ID", "SPECIAL_KEY_FB_ANON_ID", "SPECIAL_KEY_ANDROID_ID", "SPECIAL_KEY_CAMPAIGN", "SPECIAL_KEY_EMAIL", "SPECIAL_KEY_AD", "SPECIAL_KEY_IDFA", "SPECIAL_KEY_CREATIVE", "SPECIAL_KEY_AD_GROUP", "SPECIAL_KEY_GPS_AD_ID", "subscriber-attributes_release"}, k = 2, mv = {1, 4, 0})
public final class SpecialSubscriberAttributesKt {

    public static final String SPECIAL_KEY_AD = "$ad";
    public static final String SPECIAL_KEY_ADJUST_ID = "$adjustId";
    public static final String SPECIAL_KEY_AD_GROUP = "$adGroup";
    public static final String SPECIAL_KEY_ANDROID_ID = "$androidId";
    public static final String SPECIAL_KEY_APPSFLYER_ID = "$appsflyerId";
    public static final String SPECIAL_KEY_CAMPAIGN = "$campaign";
    public static final String SPECIAL_KEY_CREATIVE = "$creative";
    public static final String SPECIAL_KEY_DISPLAY_NAME = "$displayName";
    public static final String SPECIAL_KEY_EMAIL = "$email";
    public static final String SPECIAL_KEY_FB_ANON_ID = "$fbAnonId";
    public static final String SPECIAL_KEY_FCM_TOKENS = "$fcmTokens";
    public static final String SPECIAL_KEY_GPS_AD_ID = "$gpsAdId";
    public static final String SPECIAL_KEY_IDFA = "$idfa";
    public static final String SPECIAL_KEY_IDFV = "$idfv";
    public static final String SPECIAL_KEY_IP = "$ip";
    public static final String SPECIAL_KEY_KEYWORD = "$keyword";
    public static final String SPECIAL_KEY_MEDIA_SOURCE = "$mediaSource";
    public static final String SPECIAL_KEY_MPARTICLE_ID = "$mparticleId";
    public static final String SPECIAL_KEY_ONESIGNAL_ID = "$onesignalId";
    public static final String SPECIAL_KEY_PHONE_NUMBER = "$phoneNumber";
    public static final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey getSubscriberAttributeKey(String string) {
        com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.Custom custom;
        com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey obj1;
        n.f(string, "$this$getSubscriberAttributeKey");
        switch (string) {
            case "$fcmTokens":
                obj1 = SubscriberAttributeKey.FCMTokens.INSTANCE;
                custom = new SubscriberAttributeKey.Custom(string);
                obj1 = custom;
                break;
            case "$phoneNumber":
                obj1 = SubscriberAttributeKey.PhoneNumber.INSTANCE;
                custom = new SubscriberAttributeKey.Custom(string);
                obj1 = custom;
                break;
            case "$email":
                obj1 = SubscriberAttributeKey.Email.INSTANCE;
                custom = new SubscriberAttributeKey.Custom(string);
                obj1 = custom;
                break;
            case "$displayName":
                obj1 = SubscriberAttributeKey.DisplayName.INSTANCE;
                custom = new SubscriberAttributeKey.Custom(string);
                obj1 = custom;
                break;
            default:
                custom = new SubscriberAttributeKey.Custom(string);
                obj1 = custom;
        }
        return obj1;
    }
}
