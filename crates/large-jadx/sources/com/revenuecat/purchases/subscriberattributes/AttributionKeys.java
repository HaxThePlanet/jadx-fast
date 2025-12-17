package com.revenuecat.purchases.subscriberattributes;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008À\u0002\u0018\u00002\u00020\u0001:\u0004\u000b\u000c\r\u000eB\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004¨\u0006\u000f", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/AttributionKeys;", "", "", "IP", "Ljava/lang/String;", "IDFA", "NETWORK_ID", "IDFV", "GPS_AD_ID", "<init>", "()V", "Adjust", "AppsFlyer", "Branch", "MParticle", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public final class AttributionKeys {

    public static final String GPS_AD_ID = "rc_gps_adid";
    public static final String IDFA = "rc_idfa";
    public static final String IDFV = "rc_idfv";
    public static final com.revenuecat.purchases.subscriberattributes.AttributionKeys INSTANCE = null;
    public static final String IP = "rc_ip_address";
    public static final String NETWORK_ID = "rc_attribution_network_id";

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004¨\u0006\u000b", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/AttributionKeys$Adjust;", "", "", "NETWORK", "Ljava/lang/String;", "CREATIVE", "ID", "AD_GROUP", "CAMPAIGN", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class Adjust {

        public static final String AD_GROUP = "adgroup";
        public static final String CAMPAIGN = "campaign";
        public static final String CREATIVE = "creative";
        public static final String ID = "adid";
        public static final com.revenuecat.purchases.subscriberattributes.AttributionKeys.Adjust INSTANCE = null;
        public static final String NETWORK = "network";
        static {
            AttributionKeys.Adjust adjust = new AttributionKeys.Adjust();
            AttributionKeys.Adjust.INSTANCE = adjust;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004R\u0016\u0010\u000c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0004¨\u0006\u0011", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/AttributionKeys$AppsFlyer;", "", "", "ADSET", "Ljava/lang/String;", "AD_ID", "DATA_KEY", "CAMPAIGN", "ID", "CHANNEL", "AD_GROUP", "STATUS_KEY", "AD", "AD_KEYWORDS", "MEDIA_SOURCE", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class AppsFlyer {

        public static final String AD = "af_ad";
        public static final String ADSET = "adset";
        public static final String AD_GROUP = "adgroup";
        public static final String AD_ID = "ad_id";
        public static final String AD_KEYWORDS = "af_keywords";
        public static final String CAMPAIGN = "campaign";
        public static final String CHANNEL = "af_channel";
        public static final String DATA_KEY = "data";
        public static final String ID = "rc_appsflyer_id";
        public static final com.revenuecat.purchases.subscriberattributes.AttributionKeys.AppsFlyer INSTANCE = null;
        public static final String MEDIA_SOURCE = "media_source";
        public static final String STATUS_KEY = "status";
        static {
            AttributionKeys.AppsFlyer appsFlyer = new AttributionKeys.AppsFlyer();
            AttributionKeys.AppsFlyer.INSTANCE = appsFlyer;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004¨\u0006\u0008", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/AttributionKeys$Branch;", "", "", "CAMPAIGN", "Ljava/lang/String;", "CHANNEL", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class Branch {

        public static final String CAMPAIGN = "campaign";
        public static final String CHANNEL = "channel";
        public static final com.revenuecat.purchases.subscriberattributes.AttributionKeys.Branch INSTANCE;
        static {
            AttributionKeys.Branch branch = new AttributionKeys.Branch();
            AttributionKeys.Branch.INSTANCE = branch;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/AttributionKeys$MParticle;", "", "", "ID", "Ljava/lang/String;", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
    public static final class MParticle {

        public static final String ID = "mpid";
        public static final com.revenuecat.purchases.subscriberattributes.AttributionKeys.MParticle INSTANCE;
        static {
            AttributionKeys.MParticle mParticle = new AttributionKeys.MParticle();
            AttributionKeys.MParticle.INSTANCE = mParticle;
        }
    }
    static {
        AttributionKeys attributionKeys = new AttributionKeys();
        AttributionKeys.INSTANCE = attributionKeys;
    }
}
