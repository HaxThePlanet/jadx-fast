package app.dogo.com.dogo_android.service;

import android.content.Context;
import android.content.res.Resources;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.k.n.a;
import app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum;
import app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum.Companion;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum.Companion;
import app.dogo.com.dogo_android.s.a.h2;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.k1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.gms.tasks.m;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import com.revenuecat.purchases.PackageType;
import com.squareup.moshi.f;
import com.squareup.moshi.r;
import com.squareup.moshi.r.a;
import com.squareup.moshi.t;
import i.b.a0;
import i.b.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u001f\n\u0002\u0010%\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010$\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016J\u0016\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u0001J\u001c\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00102\u000c\u0010o\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016J\u0006\u0010p\u001a\u00020lJ\u001d\u0010q\u001a\u0004\u0018\u00010\"2\u0006\u0010r\u001a\u00020\u00102\u0006\u0010s\u001a\u00020\u0010¢\u0006\u0002\u0010tJ\u0010\u0010u\u001a\u00020\u000c2\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0016\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u000cJ\u0010\u0010|\u001a\u00020x2\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0010\u0010}\u001a\u00020\"2\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0016\u0010~\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00162\u0006\u0010\u007f\u001a\u00020\u0010H\u0002J\u0015\u0010\u0080\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010v\u001a\u00020\u0010J\u0011\u0010\u0081\u0001\u001a\u00020\u00102\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0007\u0010\u0082\u0001\u001a\u00020\u000cJ\u0010\u0010\u0083\u0001\u001a\u00020\u000c2\u0007\u0010\u0084\u0001\u001a\u00020\u0010J\u0007\u0010\u0085\u0001\u001a\u00020\u000cJ\u0010\u0010\u0086\u0001\u001a\u00020\u000c2\u0007\u0010\u0084\u0001\u001a\u00020\u0010J\u0017\u0010\u0087\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010\u007f\u001a\u00020\u0010H\u0002J\u001d\u0010\u0088\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100e2\u0006\u0010\u007f\u001a\u00020\u0010H\u0002J*\u0010\u0089\u0001\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100e0e2\u0007\u0010\u008a\u0001\u001a\u00020\u0010H\u0002J\u000e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u000c0\u008c\u0001J\t\u0010\u008d\u0001\u001a\u00020lH\u0002R\u0011\u0010\u000b\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00168F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0018R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00168F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0018R\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0018R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008&\u0010\u0018R\u0017\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00168F¢\u0006\u0006\u001a\u0004\u0008(\u0010\u0018R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u00168F¢\u0006\u0006\u001a\u0004\u0008+\u0010\u0018R\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u0011\u00100\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u00081\u0010\u0012R\u0011\u00102\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00083\u0010\u000eR\u0011\u00104\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00084\u0010\u000eR\u0011\u00105\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00085\u0010\u000eR\u0011\u00106\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00086\u0010\u000eR\u0011\u00107\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00087\u0010\u000eR\u0011\u00108\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00088\u0010\u000eR\u0011\u00109\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00089\u0010\u000eR\u0011\u0010:\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008:\u0010\u000eR\u0011\u0010;\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008;\u0010\u000eR\u0011\u0010<\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008<\u0010\u000eR\u0011\u0010=\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008=\u0010\u000eR\u0011\u0010>\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008>\u0010\u000eR\u0011\u0010?\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008?\u0010\u000eR\u0011\u0010@\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008@\u0010\u000eR\u0011\u0010A\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008A\u0010\u000eR\u0011\u0010B\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008B\u0010\u000eR\u0011\u0010C\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008C\u0010\u000eR\u0011\u0010D\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008E\u0010\u0012R\u0011\u0010F\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008G\u0010$R\u0011\u0010H\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008I\u0010$R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008K\u0010$R\u001a\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008O\u0010\u0012R\u0011\u0010P\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008Q\u0010\u000eR\u0011\u0010R\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008S\u0010\u000eR\u0011\u0010T\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008U\u0010\u000eR\u0011\u0010V\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\u0008X\u0010YR\u0011\u0010Z\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008[\u0010\u0012R\u0011\u0010\\\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008]\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010^\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008_\u0010$R\u0017\u0010`\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008a\u0010\u0018R\u0017\u0010b\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008c\u0010\u0018R\u001d\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100e8F¢\u0006\u0006\u001a\u0004\u0008f\u0010gR\u0011\u0010h\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008i\u0010\u000e¨\u0006\u008f\u0001", d2 = {"Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "firebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "experimentInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "challengeFilterFeaturedState", "", "getChallengeFilterFeaturedState", "()Z", "dogoOfferId", "", "getDogoOfferId", "()Ljava/lang/String;", "dynamicLinkPrefix", "getDynamicLinkPrefix", "forceImageTrickList", "", "getForceImageTrickList", "()Ljava/util/List;", "getBitingProgramOverviewOrder", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "getGetBitingProgramOverviewOrder", "getDashboardCardsOrder", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "getGetDashboardCardsOrder", "getLockedTricks", "getGetLockedTricks", "getNpsTicketForZendeskMinSymbols", "", "getGetNpsTicketForZendeskMinSymbols", "()J", "getOnboardingQuestions", "getGetOnboardingQuestions", "getPottyProgramOverviewOrder", "getGetPottyProgramOverviewOrder", "getSpecialOffers", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "getGetSpecialOffers", "getTimeGoalDurationSeconds", "", "getGetTimeGoalDurationSeconds", "()I", "instagramFollowJson", "getInstagramFollowJson", "inviteFriendsBannerState", "getInviteFriendsBannerState", "isCertificateEnabled", "isContactUsBadgeEnabled", "isCustomersExperienceEnabled", "isHelpCardEnabled", "isHelpCardLockedForFreeUsers", "isIterableNotificationsEnabled", "isLessonFlowChangeEnabled", "isLoginBeforeZendeskTicketEnabled", "isMobileInboxEnabled", "isNewRecommendedProgramCardEnabledV2", "isPottyTrackerNewUiEnabled", "isPremiumContentLocked", "isProgramExamsEnabled", "isSubscriptionAllPlansTopEnabled", "isTimeMetricEnabled", "isTrainingRemindersEnabled", "locationCode", "getLocationCode", "minSupportedVersionCode", "getMinSupportedVersionCode", "photoLikeThresholdForShare", "getPhotoLikeThresholdForShare", "recentTricksMaximum", "getRecentTricksMaximum", "sessionDebugValues", "", "shareToFriendsLink", "getShareToFriendsLink", "shouldShowBecomePremiumBanner", "getShouldShowBecomePremiumBanner", "shouldShowInAppReview", "getShouldShowInAppReview", "sponsoredChallengeFirstFlag", "getSponsoredChallengeFirstFlag", "subscriptionPricePerPeriodType", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "getSubscriptionPricePerPeriodType", "()Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "tiktokFollowJson", "getTiktokFollowJson", "todaysSessionDailyTrickTimeSeconds", "getTodaysSessionDailyTrickTimeSeconds", "trickThresholdForShare", "getTrickThresholdForShare", "tricksWithoutClicker", "getTricksWithoutClicker", "whitelistedPrograms", "getWhitelistedPrograms", "whitelistedProgramsOverride", "", "getWhitelistedProgramsOverride", "()Ljava/util/Map;", "workoutStreaksEnabled", "getWorkoutStreaksEnabled", "activeDebugOverrides", "addDebugFeatureOverwrite", "", "featureKey", "value", "list", "clearDebugOverrides", "getArticleForLanguage", "iso2Language", "trickId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getBooleanValue", "key", "getCustomerLifetimeValueMultiplierFor", "", "type", "Lcom/revenuecat/purchases/PackageType;", "freeTrial", "getDoubleValue", "getLongValue", "getSpecialProgramOverviewOrder", "remoteKey", "getStringListValue", "getStringValue", "isDebugOverridesInUse", "isHelpCenterEnabled", "locale", "isProgramOverviewEnabled", "isSocialTabDisabledForLocale", "parseJsonArray", "parseJsonMap", "parseLanguageMap", "trickString", "safeRefresh", "Lio/reactivex/Single;", "syncSessionDebugCache", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r2 {

    public static final app.dogo.com.dogo_android.service.r2.a Companion = null;
    private static final long f = 3600L;
    private final o3 a;
    private final FirebaseRemoteConfig b;
    private final h2 c;
    private final app.dogo.com.dogo_android.service.p2 d;
    private final Map<String, Object> e;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008%\n\u0002\u0010\t\n\u0002\u0008\u0017\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020*¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/service/RemoteConfigService$Companion;", "", "()V", "APP_CERTIFICATE_ENABLED", "", "APP_CONTENT_LOCK_KEY", "APP_CUSTOMERS_EXPERIENCE_ENABLED", "APP_IS_FIRST_INSTALL_VERSION_6", "APP_TRAINING_PROGRAM_EXAM_KEY", "APP_TRAINING_REMINDERS_ENABLED", "APP_VERSION_CODE_KEY", "ASK_LOGIN_BEFORE_ZENDESK_TICKET_ENABLES", "BITING_OVERVIEW_CARDS_ORDER", "CHALLENGE_FEATURED_FILTER_ENABLED", "CHALLENGE_STATE_KEY", "CLTV_ANNUAL_MULTIPLIER", "CLTV_ANNUAL_MULTIPLIER_FREE_TRIAL", "CLTV_MONTHLY_MULTIPLIER", "CLTV_MONTHLY_MULTIPLIER_FREE_TRIAL", "CLTV_QUARTERLY_MULTIPLIER", "CLTV_QUARTERLY_MULTIPLIER_FREE_TRIAL", "CONTACT_US_BADGE_ENABLED", "DASHBOARD_CARDS_ORDER", "DOGO_OFFER_ID", "DYNAMIC_LINK_PREFIX", "FORCE_IMAGE_TRICK", "HELP_CARD_ENABLED", "INSTAGRAM_FOLLOW_US", "INVITE_FRIENDS_BANNER_ENABLED", "ITERABLE_NOTIFICATIONS_ENABLED", "LESSON_FLOW_CHANGE_ENABLED", "LOCKED_TRICKS", "LOCK_ON_HELP_CARD_FOR_FREE_USERS", "MOBILE_INBOX_ENABLED", "NPS_TICKET_FOR_ZENDESK_MIN_SYMBOLS", "ONBOARDING_QUESTIONS", "PHOTO_LIKE_THRESHOLD_FOR_SHARE", "POTTY_OVERVIEW_CARDS_ORDER", "POTTY_TRACKER_NEW_UI", "RECENT_TRICKS_MAXIMUM", "RECOMMENDED_PROGRAM_NEW_UI_V2", "REMOTE_CONFIG_EXPIRATION_TIME", "", "getREMOTE_CONFIG_EXPIRATION_TIME", "()J", "SESSION_DAILY_TRICK_TIME_IN_SECONDS", "SHOW_CHALLENGE_BECOME_PREMIUM_BANNER", "SHOW_IN_APP_REVIEW", "SOCIAL_TAB_COUNTRIES", "SPECIAL_OFFER", "SPONSORED_CHALLENGES_FIRST", "SUBSCRIPTION_ALL_PLANS_TOP_ENABLED", "SUBSCRIPTION_PRICE_PER", "TIKTOK_FOLLOW_US", "TIME_GOAL_DURATION_SECONDS", "TIME_METRIC_ENABLED", "TIPS_AND_TRICKS", "TRICKS_WITHOUT_CLICKER", "TRICK_THRESHOLD_FOR_SHARE", "USER_LOCATION_CODE", "USE_DOGO_API", "WHITELISTED_PROGRAMS", "WHITELISTED_PROGRAMS_OVERRIDE", "WORKOUT_STREAKS_ENABLED", "ZENDESK_HELP_CENTER_LANGUAGES", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[PackageType.ANNUAL.ordinal()] = 1;
            iArr[PackageType.THREE_MONTH.ordinal()] = 2;
            iArr[PackageType.MONTHLY.ordinal()] = 3;
            r2.b.a = iArr;
        }
    }
    static {
        r2.a aVar = new r2.a(0);
        r2.Companion = aVar;
    }

    public r2(o3 o3, FirebaseRemoteConfig firebaseRemoteConfig2, h2 h23, app.dogo.com.dogo_android.service.p2 p24) {
        n.f(o3, "tracker");
        n.f(firebaseRemoteConfig2, "firebaseRemoteConfig");
        n.f(h23, "experimentInteractor");
        n.f(p24, "preferenceService");
        super();
        this.a = o3;
        this.b = firebaseRemoteConfig2;
        this.c = h23;
        this.d = p24;
        LinkedHashMap obj3 = new LinkedHashMap();
        this.e = obj3;
        obj3 = new HashMap();
        Boolean obj5 = Boolean.TRUE;
        obj3.put("challenge_state", obj5);
        obj3.put("location_code", "null");
        Boolean obj6 = Boolean.FALSE;
        obj3.put("is_challenge_filter_featured_enabled", obj6);
        obj3.put("android_trick_threshold_for_share", 8);
        obj3.put("android_photo_like_threshold_for_share", 20);
        obj3.put("sponsored_challenges_first", obj6);
        obj3.put("android_config_session_daily_trick_time_in_seconds", 120);
        obj3.put("android_config_invite_friends_banner_enabled", obj5);
        obj3.put("android_show_challenge_become_premium_banner", obj5);
        obj3.put("android_feature_in_app_review", obj6);
        obj3.put("android_config_dynamic_link_prefix", "https://dogoapp.page.link");
        obj3.put("android_program_exams_enabled", obj5);
        obj3.put("android_config_min_supported_app_version", 555);
        obj3.put("android_detect_v6_first_install", obj5);
        obj3.put("android_config_certificate_enabled", obj6);
        obj3.put("android_config_customers_experience_enabled", obj6);
        obj3.put("android_config_use_appengine_api", obj5);
        obj3.put("android_config_current_offering_id", "");
        String str43 = "[\"en\"]";
        obj3.put("android_config_help_center_enabled_v2", str43);
        obj3.put("android_config_workout_streaks", obj6);
        obj3.put("android_config_help_card_enabled", obj5);
        obj3.put("android_lock_help_card", obj5);
        obj3.put("android_config_create_nps_login", obj5);
        obj3.put("android_config_mobile_inbox", obj6);
        obj3.put("android_config_cltv_monthly", Double.valueOf(4609479254609976361L));
        obj3.put("android_config_cltv_monthly_free_trial", Double.valueOf(4599616371426034975L));
        obj3.put("android_config_cltv_quarterly", Double.valueOf(4606281698874543309L));
        obj3.put("android_config_cltv_quarterly_free_trial", Double.valueOf(4594212051873190380L));
        obj3.put("android_config_cltv_annual", Double.valueOf(4603759683083215831L));
        obj3.put("android_config_cltv_annual_free_trial", Double.valueOf(4587366580439587226L));
        obj3.put("android_config_create_nps_ticket_min_symbols", 50);
        obj3.put("android_config_recent_tricks", 15);
        obj3.put("android_config_dashboard_card_order", "[\"recentTricks\", \"program\", \"exam\", \"help\", \"workout\", \"subscription\"]");
        obj3.put("android_config_onboarding_questions", "[\"id_age\",\"id_pull_leash\",\"id_recall\",\"id_sit_and_stay\",\"id_improve_reaction_speed\",\"id_fun_tricks\",\"id_open_door\"]");
        obj3.put("android_config_tricks_without_clicker", "[\"id_hand_feeding_01\",\"id_tug_01\", \"id_handling_01\",\"id_handling_02\", \"id_handling_03\",\"id_meet_greet_01\", \"id_biting_program_01\",\"id_collar_01\", \"id_guarding_program_01\",\"id_guarding_program_02\", \"id_jumping_prevent_01\",\"id_gotcha_program_01\"]");
        obj3.put("android_config_program_whitelist", "[\"id_puppy_program\", \"id_pleasant_walks\", \"id_useful_program\", \"id_impulse_control\", \"id_adorable_program\", \"id_agile_program\", \"id_basic_obedience\"]");
        obj3.put("android_config_local_training_reminders_enabled", obj6);
        obj3.put("android_config_rt_1_lesson_flow", obj6);
        obj3.put("android_config_rn_time_goal_seconds", 240);
        obj3.put("android_config_rn_time_metric", obj6);
        obj3.put("android_config_price_per", "day");
        obj3.put("android_config_rt_potty_tracker_ui", obj6);
        firebaseRemoteConfig2.setDefaultsAsync(obj3);
        obj3 = new FirebaseRemoteConfigSettings.Builder();
        obj3 = obj3.setMinimumFetchIntervalInSeconds(r2.f).setFetchTimeoutInSeconds(10).build();
        n.e(obj3, "Builder()\n            .setMinimumFetchIntervalInSeconds(REMOTE_CONFIG_EXPIRATION_TIME)\n            .setFetchTimeoutInSeconds(10)\n            .build()");
        firebaseRemoteConfig2.setConfigSettingsAsync(obj3);
        o0();
    }

    private final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> D(String string) {
        SpecialProgramOverviewItem.PottyOverviewCardEnum stringToEnum;
        SpecialProgramOverviewItem.PottyOverviewCardEnum.Companion companion;
        ArrayList arrayList = new ArrayList();
        Iterator obj4 = j0(string).iterator();
        while (obj4.hasNext()) {
            stringToEnum = SpecialProgramOverviewItem.PottyOverviewCardEnum.Companion.parseStringToEnum((String)obj4.next());
            if (stringToEnum != null) {
            }
            arrayList.add(stringToEnum);
        }
        return arrayList;
    }

    private final String G(String string) {
        Object string2;
        Object obj3;
        if (string2 instanceof String != null) {
        } else {
            string2 = 0;
        }
        if (string2 == null) {
            n.e(this.b.getString(string), "firebaseRemoteConfig.getString(key)");
        }
        return string2;
    }

    private final boolean e(String string) {
        Object obj;
        boolean obj3;
        if (obj instanceof Boolean) {
        } else {
            obj = 0;
        }
        if (obj == null) {
            obj3 = this.b.getBoolean(string);
        } else {
            obj3 = obj.booleanValue();
        }
        return obj3;
    }

    private final double i(String string) {
        Object obj;
        double doubleValue;
        if (obj instanceof Double) {
        } else {
            obj = 0;
        }
        if (obj == null) {
            doubleValue = this.b.getDouble(string);
        } else {
            doubleValue = obj.doubleValue();
        }
        return doubleValue;
    }

    public static void i0(app.dogo.com.dogo_android.service.r2 r2, c0 c02) {
        r2.n0(r2, c02);
    }

    private final List<String> j0(String string) {
        Object str;
        boolean z;
        Object str2;
        String k1Var;
        Class<String> obj;
        Object obj6;
        str = G(string);
        if (l.z(str)) {
            obj6 = p.g();
        } else {
            java.lang.reflect.Type[] arr = new Type[1];
            r.a aVar = new r.a();
            str2 = aVar.b().d(t.j(List.class, String.class));
            n.e(str2, "Builder().build().adapter(type)");
            if ((List)str2.c(str) == null) {
                str = p.g();
            }
            obj6 = str;
        }
        return obj6;
    }

    private final Map<String, String> k0(String string) {
        Class<String> obj;
        String str;
        boolean z;
        String k1Var;
        java.lang.reflect.Type[] arr;
        int i;
        Object obj7;
        obj = String.class;
        str = G(string);
        if (l.z(str)) {
            obj7 = j0.h();
        } else {
            arr = new Type[2];
            r.a aVar = new r.a();
            f fVar = aVar.b().d(t.j(Map.class, obj, obj));
            n.e(fVar, "Builder().build().adapter(type)");
            if ((Map)fVar.c(str) == null) {
                obj = j0.h();
            }
            obj7 = obj;
        }
        return obj7;
    }

    private final Map<String, Map<String, String>> l0(String string) {
        Object obj;
        int i;
        String str;
        Class<Map> k1Var;
        java.lang.reflect.Type[] arr;
        Class<Map> obj2;
        java.lang.CharSequence obj7;
        Class<String> obj3 = String.class;
        str = 1;
        if (z ^= str != 0) {
            arr = new Type[4];
            arr[str] = Map.class;
            arr[2] = obj3;
            arr[3] = obj3;
            r.a aVar = new r.a();
            f fVar = aVar.b().d(t.j(Map.class, arr));
            n.e(fVar, "Builder().build().adapter(type)");
            if ((Map)fVar.c(string) == null) {
                obj = j0.h();
            }
        } else {
            obj = j0.h();
        }
        return obj;
    }

    private static final void n0(app.dogo.com.dogo_android.service.r2 r2, c0 c02) {
        List obj3;
        n.f(r2, "this$0");
        n.f(c02, "emitter");
        r2.a.q(q3.Experiments, r2.c.a());
        c02.onSuccess((Boolean)m.a(r2.b.fetchAndActivate()));
    }

    private final void o0() {
        this.e.putAll(this.d.f());
    }

    private final long w(String string) {
        Object obj;
        long longValue;
        if (obj instanceof Long) {
        } else {
            obj = 0;
        }
        if (obj == null) {
            longValue = this.b.getLong(string);
        } else {
            longValue = obj.longValue();
        }
        return longValue;
    }

    public final String A() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j());
        stringBuilder.append('/');
        stringBuilder.append(App.Companion.b().getResources().getString(2131886780));
        return stringBuilder.toString();
    }

    public final boolean B() {
        return e("android_show_challenge_become_premium_banner");
    }

    public final boolean C() {
        return e("android_feature_in_app_review");
    }

    public final boolean E() {
        return e("sponsored_challenges_first");
    }

    public final List<String> F(String string) {
        n.f(string, "key");
        return j0(string);
    }

    public final n H() {
        n dAY;
        if (n.Companion.a(G("android_config_price_per")) == null) {
            dAY = n.DAY;
        }
        return dAY;
    }

    public final String I() {
        return G("tiktok_follow_us");
    }

    public final long J() {
        return w("android_config_session_daily_trick_time_in_seconds");
    }

    public final long K() {
        return w("android_trick_threshold_for_share");
    }

    public final List<String> L() {
        return j0("android_config_tricks_without_clicker");
    }

    public final List<String> M() {
        return j0("android_config_program_whitelist");
    }

    public final Map<String, String> N() {
        return k0("android_config_program_whitelist_override");
    }

    public final boolean O() {
        return e("android_config_workout_streaks");
    }

    public final boolean P() {
        return e("android_config_certificate_enabled");
    }

    public final boolean Q() {
        return e("android_config_first_time_help_center_red_badge");
    }

    public final boolean R() {
        return e("android_config_customers_experience_enabled");
    }

    public final boolean S() {
        return e("android_config_help_card_enabled");
    }

    public final boolean T() {
        return e("android_lock_help_card");
    }

    public final boolean U(String string) {
        n.f(string, "locale");
        return j0("android_config_help_center_enabled_v2").contains(n2.a.a(string));
    }

    public final boolean V() {
        return e("android_config_iterable_notifications");
    }

    public final boolean W() {
        return e("android_config_rt_1_lesson_flow");
    }

    public final boolean X() {
        return e("android_config_create_nps_login");
    }

    public final boolean Y() {
        return e("android_config_mobile_inbox");
    }

    public final boolean Z() {
        return e("android_config_recommended_program_new_ui_v2");
    }

    public final void a(String string, Object object2) {
        boolean z;
        n.f(string, "featureKey");
        n.f(object2, "value");
        if (App.Companion.u()) {
            this.e.put(string, object2);
            this.d.q0(string, object2);
        }
    }

    public final boolean a0() {
        return e("android_config_rt_potty_tracker_ui");
    }

    public final void b(String string, List<String> list2) {
        n.f(string, "featureKey");
        n.f(list2, "list");
        r.a aVar = new r.a();
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = aVar.b().d(t.j(List.class, String.class));
        n.e(fVar, "moshi.adapter(type)");
        final String obj7 = fVar.h(list2);
        n.e(obj7, "json");
        a(string, obj7);
    }

    public final boolean b0() {
        return e("android_lock_premium_content");
    }

    public final void c() {
        this.e.clear();
        this.d.a();
    }

    public final boolean c0() {
        return e("android_program_exams_enabled");
    }

    public final Long d(String string, String string2) {
        int i;
        Object obj2;
        n.f(string, "iso2Language");
        n.f(string2, "trickId");
        obj2 = l0(G("android_config_tips_and_tricks")).get(string);
        i = 0;
        if ((Map)obj2 == null) {
        } else {
            obj2 = (Map)obj2.get(string2);
            if ((String)obj2 == null) {
            } else {
                i = l.o((String)obj2);
            }
        }
        return i;
    }

    public final boolean d0() {
        int i;
        boolean z;
        if (!Z()) {
            if (W()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean e0(String string) {
        n.f(string, "locale");
        return j0("android_config_social_tab_countries").contains(string);
    }

    public final boolean f() {
        return e("is_challenge_filter_featured_enabled");
    }

    public final boolean f0() {
        return e("android_config_show_all_plans_top");
    }

    public final double g(PackageType packageType, boolean z2) {
        int i;
        String obj2;
        n.f(packageType, "type");
        obj2 = r2.b.a[packageType.ordinal()];
        if (obj2 != 1) {
            if (obj2 != 2) {
                if (obj2 != 3) {
                    return 0;
                }
                obj2 = z2 ? "android_config_cltv_monthly_free_trial" : "android_config_cltv_monthly";
            } else {
                obj2 = z2 ? "android_config_cltv_quarterly_free_trial" : "android_config_cltv_quarterly";
            }
        } else {
            obj2 = z2 ? "android_config_cltv_annual_free_trial" : "android_config_cltv_annual";
        }
        return i(obj2);
    }

    public final boolean g0() {
        return e("android_config_rn_time_metric");
    }

    public final String h() {
        return G("android_config_current_offering_id");
    }

    public final boolean h0() {
        return e("android_config_local_training_reminders_enabled");
    }

    public final String j() {
        return G("android_config_dynamic_link_prefix");
    }

    public final List<String> k() {
        return j0("android_config_force_image_trick");
    }

    public final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> l() {
        return D("android_config_biting_order");
    }

    public final List<Dashboard.DashboardCardsEnum> m() {
        Dashboard.DashboardCardsEnum stringToEnum;
        Dashboard.DashboardCardsEnum.Companion companion;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = j0("android_config_dashboard_card_order").iterator();
        while (iterator.hasNext()) {
            stringToEnum = Dashboard.DashboardCardsEnum.Companion.parseStringToEnum((String)iterator.next());
            if (stringToEnum != null) {
            }
            arrayList.add(stringToEnum);
        }
        return arrayList;
    }

    public final a0<Boolean> m0() {
        o1 o1Var = new o1(this);
        a0 create = a0.create(o1Var);
        n.e(create, "create { emitter ->\n            try {\n                val isSuccess = Tasks.await(firebaseRemoteConfig.fetchAndActivate())\n                tracker.setUserProperty(UserProperty.Experiments, experimentInteractor.getExperimentVariationsForTracking())\n                emitter.onSuccess(isSuccess)\n            } catch (e: Exception) {\n                Timber.e(e)\n                emitter.onSuccess(false)\n            }\n        }");
        return create;
    }

    public final List<String> n() {
        return j0("android_locked_tricks");
    }

    public final long o() {
        return w("android_config_create_nps_ticket_min_symbols");
    }

    public final List<String> p() {
        return j0("android_config_onboarding_questions");
    }

    public final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> q() {
        return D("android_config_potty_order");
    }

    public final List<SpecialOfferCoupon> r() {
        return j1.q0(G("android_config_promo_offers"));
    }

    public final int s() {
        return (int)l;
    }

    public final String t() {
        return G("instagram_follow_us");
    }

    public final boolean u() {
        return e("android_config_invite_friends_banner_enabled");
    }

    public final String v() {
        return G("location_code");
    }

    public final long x() {
        return w("android_config_min_supported_app_version");
    }

    public final long y() {
        return w("android_photo_like_threshold_for_share");
    }

    public final long z() {
        return w("android_config_recent_tricks");
    }
}
