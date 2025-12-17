package com.revenuecat.purchases.subscriberattributes;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0008\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\u0011\u0008\u0002\u0012\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001a\u0010\u0004\u001a\u00020\u00032\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u0019\u0010\u000c\u001a\u00020\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u000e\u0010\u000b\u0082\u0001\n\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"¨\u0006#", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "backendKey", "Ljava/lang/String;", "getBackendKey", "<init>", "(Ljava/lang/String;)V", "AttributionIds", "CampaignParameters", "Custom", "DeviceIdentifiers", "DisplayName", "Email", "FCMTokens", "PhoneNumber", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$Email;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$DisplayName;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$PhoneNumber;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$FCMTokens;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$Custom;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$GPSAdID;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$AndroidID;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers$IP;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public abstract class SubscriberAttributeKey {

    private final String backendKey;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\u00086\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0007", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$DeviceIdentifiers;", "", "<init>", "()V", "AndroidID", "GPSAdID", "IP", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static abstract class DeviceIdentifiers {
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\u0008\t\nB\u0011\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005\u0082\u0001\u0005\u000b\u000c\r\u000e\u000f¨\u0006\u0010", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "", "backendKey", "<init>", "(Ljava/lang/String;)V", "Adjust", "AppsFlyer", "Facebook", "Mparticle", "OneSignal", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds$Adjust;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds$AppsFlyer;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds$Facebook;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds$Mparticle;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds$OneSignal;", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static abstract class AttributionIds extends com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey {
        private AttributionIds(String string) {
            super(string, 0);
        }

        public AttributionIds(String string, g g2) {
            super(string);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0006\u0006\u0007\u0008\t\n\u000bB\u0011\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005\u0082\u0001\u0006\u000c\r\u000e\u000f\u0010\u0011¨\u0006\u0012", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "", "backendKey", "<init>", "(Ljava/lang/String;)V", "Ad", "AdGroup", "Campaign", "Creative", "Keyword", "MediaSource", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters$MediaSource;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Campaign;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters$AdGroup;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Ad;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Keyword;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$CampaignParameters$Creative;", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static abstract class CampaignParameters extends com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey {
        private CampaignParameters(String string) {
            super(string, 0);
        }

        public CampaignParameters(String string, g g2) {
            super(string);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$Custom;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "", "value", "<init>", "(Ljava/lang/String;)V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class Custom extends com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey {
        public Custom(String string) {
            n.f(string, "value");
            super(string, 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$DisplayName;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class DisplayName extends com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey {

        public static final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.DisplayName INSTANCE;
        static {
            SubscriberAttributeKey.DisplayName displayName = new SubscriberAttributeKey.DisplayName();
            SubscriberAttributeKey.DisplayName.INSTANCE = displayName;
        }

        private DisplayName() {
            super("$displayName", 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$Email;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class Email extends com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey {

        public static final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.Email INSTANCE;
        static {
            SubscriberAttributeKey.Email email = new SubscriberAttributeKey.Email();
            SubscriberAttributeKey.Email.INSTANCE = email;
        }

        private Email() {
            super("$email", 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$FCMTokens;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class FCMTokens extends com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey {

        public static final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.FCMTokens INSTANCE;
        static {
            SubscriberAttributeKey.FCMTokens fCMTokens = new SubscriberAttributeKey.FCMTokens();
            SubscriberAttributeKey.FCMTokens.INSTANCE = fCMTokens;
        }

        private FCMTokens() {
            super("$fcmTokens", 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$PhoneNumber;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class PhoneNumber extends com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey {

        public static final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.PhoneNumber INSTANCE;
        static {
            SubscriberAttributeKey.PhoneNumber phoneNumber = new SubscriberAttributeKey.PhoneNumber();
            SubscriberAttributeKey.PhoneNumber.INSTANCE = phoneNumber;
        }

        private PhoneNumber() {
            super("$phoneNumber", 0);
        }
    }
    private SubscriberAttributeKey(String string) {
        super();
        this.backendKey = string;
    }

    public SubscriberAttributeKey(String string, g g2) {
        super(string);
    }

    public boolean equals(Object object) {
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        if (object != null) {
            class = object.getClass();
        } else {
            class = 0;
        }
        int i3 = 0;
        if (z ^= i != 0) {
            return i3;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey");
        if (obj4 ^= i != 0) {
            return i3;
        }
        return i;
    }

    public final String getBackendKey() {
        return this.backendKey;
    }

    public int hashCode() {
        return this.backendKey.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SubscriberAttributeKey('");
        stringBuilder.append(this.backendKey);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}
