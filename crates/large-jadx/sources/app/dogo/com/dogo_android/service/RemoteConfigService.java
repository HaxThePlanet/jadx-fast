package app.dogo.com.dogo_android.service;

import android.content.Context;
import android.content.res.Resources;
import app.dogo.com.dogo_android.k.n.a;
import app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum;
import app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum.Companion;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum.Companion;
import app.dogo.com.dogo_android.s.a.h2;
import app.dogo.com.dogo_android.util.h0.j1;
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
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import n.a.a;

/* compiled from: RemoteConfigService.kt */
@Metadata(d1 = "\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u001f\n\u0002\u0010%\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010$\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016J\u0016\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u0001J\u001c\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00102\u000c\u0010o\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016J\u0006\u0010p\u001a\u00020lJ\u001d\u0010q\u001a\u0004\u0018\u00010\"2\u0006\u0010r\u001a\u00020\u00102\u0006\u0010s\u001a\u00020\u0010¢\u0006\u0002\u0010tJ\u0010\u0010u\u001a\u00020\u000c2\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0016\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u000cJ\u0010\u0010|\u001a\u00020x2\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0010\u0010}\u001a\u00020\"2\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0016\u0010~\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00162\u0006\u0010\u007f\u001a\u00020\u0010H\u0002J\u0015\u0010\u0080\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010v\u001a\u00020\u0010J\u0011\u0010\u0081\u0001\u001a\u00020\u00102\u0006\u0010v\u001a\u00020\u0010H\u0002J\u0007\u0010\u0082\u0001\u001a\u00020\u000cJ\u0010\u0010\u0083\u0001\u001a\u00020\u000c2\u0007\u0010\u0084\u0001\u001a\u00020\u0010J\u0007\u0010\u0085\u0001\u001a\u00020\u000cJ\u0010\u0010\u0086\u0001\u001a\u00020\u000c2\u0007\u0010\u0084\u0001\u001a\u00020\u0010J\u0017\u0010\u0087\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010\u007f\u001a\u00020\u0010H\u0002J\u001d\u0010\u0088\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100e2\u0006\u0010\u007f\u001a\u00020\u0010H\u0002J*\u0010\u0089\u0001\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100e0e2\u0007\u0010\u008a\u0001\u001a\u00020\u0010H\u0002J\u000e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u000c0\u008c\u0001J\t\u0010\u008d\u0001\u001a\u00020lH\u0002R\u0011\u0010\u000b\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00168F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0018R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00168F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0018R\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0018R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008&\u0010\u0018R\u0017\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00168F¢\u0006\u0006\u001a\u0004\u0008(\u0010\u0018R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u00168F¢\u0006\u0006\u001a\u0004\u0008+\u0010\u0018R\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u0011\u00100\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u00081\u0010\u0012R\u0011\u00102\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00083\u0010\u000eR\u0011\u00104\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00084\u0010\u000eR\u0011\u00105\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00085\u0010\u000eR\u0011\u00106\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00086\u0010\u000eR\u0011\u00107\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00087\u0010\u000eR\u0011\u00108\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00088\u0010\u000eR\u0011\u00109\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u00089\u0010\u000eR\u0011\u0010:\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008:\u0010\u000eR\u0011\u0010;\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008;\u0010\u000eR\u0011\u0010<\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008<\u0010\u000eR\u0011\u0010=\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008=\u0010\u000eR\u0011\u0010>\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008>\u0010\u000eR\u0011\u0010?\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008?\u0010\u000eR\u0011\u0010@\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008@\u0010\u000eR\u0011\u0010A\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008A\u0010\u000eR\u0011\u0010B\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008B\u0010\u000eR\u0011\u0010C\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008C\u0010\u000eR\u0011\u0010D\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008E\u0010\u0012R\u0011\u0010F\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008G\u0010$R\u0011\u0010H\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008I\u0010$R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008K\u0010$R\u001a\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008O\u0010\u0012R\u0011\u0010P\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008Q\u0010\u000eR\u0011\u0010R\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008S\u0010\u000eR\u0011\u0010T\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008U\u0010\u000eR\u0011\u0010V\u001a\u00020W8F¢\u0006\u0006\u001a\u0004\u0008X\u0010YR\u0011\u0010Z\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008[\u0010\u0012R\u0011\u0010\\\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008]\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010^\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008_\u0010$R\u0017\u0010`\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008a\u0010\u0018R\u0017\u0010b\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00168F¢\u0006\u0006\u001a\u0004\u0008c\u0010\u0018R\u001d\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100e8F¢\u0006\u0006\u001a\u0004\u0008f\u0010gR\u0011\u0010h\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008i\u0010\u000e¨\u0006\u008f\u0001", d2 = {"Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "firebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "experimentInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "challengeFilterFeaturedState", "", "getChallengeFilterFeaturedState", "()Z", "dogoOfferId", "", "getDogoOfferId", "()Ljava/lang/String;", "dynamicLinkPrefix", "getDynamicLinkPrefix", "forceImageTrickList", "", "getForceImageTrickList", "()Ljava/util/List;", "getBitingProgramOverviewOrder", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "getGetBitingProgramOverviewOrder", "getDashboardCardsOrder", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "getGetDashboardCardsOrder", "getLockedTricks", "getGetLockedTricks", "getNpsTicketForZendeskMinSymbols", "", "getGetNpsTicketForZendeskMinSymbols", "()J", "getOnboardingQuestions", "getGetOnboardingQuestions", "getPottyProgramOverviewOrder", "getGetPottyProgramOverviewOrder", "getSpecialOffers", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "getGetSpecialOffers", "getTimeGoalDurationSeconds", "", "getGetTimeGoalDurationSeconds", "()I", "instagramFollowJson", "getInstagramFollowJson", "inviteFriendsBannerState", "getInviteFriendsBannerState", "isCertificateEnabled", "isContactUsBadgeEnabled", "isCustomersExperienceEnabled", "isHelpCardEnabled", "isHelpCardLockedForFreeUsers", "isIterableNotificationsEnabled", "isLessonFlowChangeEnabled", "isLoginBeforeZendeskTicketEnabled", "isMobileInboxEnabled", "isNewRecommendedProgramCardEnabledV2", "isPottyTrackerNewUiEnabled", "isPremiumContentLocked", "isProgramExamsEnabled", "isSubscriptionAllPlansTopEnabled", "isTimeMetricEnabled", "isTrainingRemindersEnabled", "locationCode", "getLocationCode", "minSupportedVersionCode", "getMinSupportedVersionCode", "photoLikeThresholdForShare", "getPhotoLikeThresholdForShare", "recentTricksMaximum", "getRecentTricksMaximum", "sessionDebugValues", "", "shareToFriendsLink", "getShareToFriendsLink", "shouldShowBecomePremiumBanner", "getShouldShowBecomePremiumBanner", "shouldShowInAppReview", "getShouldShowInAppReview", "sponsoredChallengeFirstFlag", "getSponsoredChallengeFirstFlag", "subscriptionPricePerPeriodType", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "getSubscriptionPricePerPeriodType", "()Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "tiktokFollowJson", "getTiktokFollowJson", "todaysSessionDailyTrickTimeSeconds", "getTodaysSessionDailyTrickTimeSeconds", "trickThresholdForShare", "getTrickThresholdForShare", "tricksWithoutClicker", "getTricksWithoutClicker", "whitelistedPrograms", "getWhitelistedPrograms", "whitelistedProgramsOverride", "", "getWhitelistedProgramsOverride", "()Ljava/util/Map;", "workoutStreaksEnabled", "getWorkoutStreaksEnabled", "activeDebugOverrides", "addDebugFeatureOverwrite", "", "featureKey", "value", "list", "clearDebugOverrides", "getArticleForLanguage", "iso2Language", "trickId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getBooleanValue", "key", "getCustomerLifetimeValueMultiplierFor", "", "type", "Lcom/revenuecat/purchases/PackageType;", "freeTrial", "getDoubleValue", "getLongValue", "getSpecialProgramOverviewOrder", "remoteKey", "getStringListValue", "getStringValue", "isDebugOverridesInUse", "isHelpCenterEnabled", "locale", "isProgramOverviewEnabled", "isSocialTabDisabledForLocale", "parseJsonArray", "parseJsonMap", "parseLanguageMap", "trickString", "safeRefresh", "Lio/reactivex/Single;", "syncSessionDebugCache", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r2, reason: from kotlin metadata */
public final class RemoteConfigService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final r2.a INSTANCE = null;
    private static final long f = 3600L;
    private final o3 a;
    private final FirebaseRemoteConfig b;
    private final h2 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final p2 experimentInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final Map<String, Object> firebaseRemoteConfig = new LinkedHashMap<>();

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008%\n\u0002\u0010\t\n\u0002\u0008\u0017\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020*¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/service/RemoteConfigService$Companion;", "", "()V", "APP_CERTIFICATE_ENABLED", "", "APP_CONTENT_LOCK_KEY", "APP_CUSTOMERS_EXPERIENCE_ENABLED", "APP_IS_FIRST_INSTALL_VERSION_6", "APP_TRAINING_PROGRAM_EXAM_KEY", "APP_TRAINING_REMINDERS_ENABLED", "APP_VERSION_CODE_KEY", "ASK_LOGIN_BEFORE_ZENDESK_TICKET_ENABLES", "BITING_OVERVIEW_CARDS_ORDER", "CHALLENGE_FEATURED_FILTER_ENABLED", "CHALLENGE_STATE_KEY", "CLTV_ANNUAL_MULTIPLIER", "CLTV_ANNUAL_MULTIPLIER_FREE_TRIAL", "CLTV_MONTHLY_MULTIPLIER", "CLTV_MONTHLY_MULTIPLIER_FREE_TRIAL", "CLTV_QUARTERLY_MULTIPLIER", "CLTV_QUARTERLY_MULTIPLIER_FREE_TRIAL", "CONTACT_US_BADGE_ENABLED", "DASHBOARD_CARDS_ORDER", "DOGO_OFFER_ID", "DYNAMIC_LINK_PREFIX", "FORCE_IMAGE_TRICK", "HELP_CARD_ENABLED", "INSTAGRAM_FOLLOW_US", "INVITE_FRIENDS_BANNER_ENABLED", "ITERABLE_NOTIFICATIONS_ENABLED", "LESSON_FLOW_CHANGE_ENABLED", "LOCKED_TRICKS", "LOCK_ON_HELP_CARD_FOR_FREE_USERS", "MOBILE_INBOX_ENABLED", "NPS_TICKET_FOR_ZENDESK_MIN_SYMBOLS", "ONBOARDING_QUESTIONS", "PHOTO_LIKE_THRESHOLD_FOR_SHARE", "POTTY_OVERVIEW_CARDS_ORDER", "POTTY_TRACKER_NEW_UI", "RECENT_TRICKS_MAXIMUM", "RECOMMENDED_PROGRAM_NEW_UI_V2", "REMOTE_CONFIG_EXPIRATION_TIME", "", "getREMOTE_CONFIG_EXPIRATION_TIME", "()J", "SESSION_DAILY_TRICK_TIME_IN_SECONDS", "SHOW_CHALLENGE_BECOME_PREMIUM_BANNER", "SHOW_IN_APP_REVIEW", "SOCIAL_TAB_COUNTRIES", "SPECIAL_OFFER", "SPONSORED_CHALLENGES_FIRST", "SUBSCRIPTION_ALL_PLANS_TOP_ENABLED", "SUBSCRIPTION_PRICE_PER", "TIKTOK_FOLLOW_US", "TIME_GOAL_DURATION_SECONDS", "TIME_METRIC_ENABLED", "TIPS_AND_TRICKS", "TRICKS_WITHOUT_CLICKER", "TRICK_THRESHOLD_FOR_SHARE", "USER_LOCATION_CODE", "USE_DOGO_API", "WHITELISTED_PROGRAMS", "WHITELISTED_PROGRAMS_OVERRIDE", "WORKOUT_STREAKS_ENABLED", "ZENDESK_HELP_CENTER_LANGUAGES", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[PackageType.values().length];
            iArr[PackageType.ANNUAL.ordinal()] = 1;
            iArr[PackageType.THREE_MONTH.ordinal()] = 2;
            iArr[PackageType.MONTHLY.ordinal()] = 3;
            r2.b.a = iArr;
        }
    }
    public r2(o3 o3Var, FirebaseRemoteConfig firebaseRemoteConfig, h2 h2Var, p2 p2Var) {
        n.f(o3Var, "tracker");
        n.f(firebaseRemoteConfig, "firebaseRemoteConfig");
        n.f(h2Var, "experimentInteractor");
        n.f(p2Var, "preferenceService");
        super();
        this.a = o3Var;
        this.b = firebaseRemoteConfig;
        this.c = h2Var;
        this.experimentInteractor = p2Var;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap hashMap = new HashMap();
        Boolean tRUE2 = Boolean.TRUE;
        hashMap.put("challenge_state", tRUE2);
        hashMap.put("location_code", "null");
        Boolean fALSE2 = Boolean.FALSE;
        hashMap.put("is_challenge_filter_featured_enabled", fALSE2);
        hashMap.put("android_trick_threshold_for_share", 8);
        hashMap.put("android_photo_like_threshold_for_share", 20);
        hashMap.put("sponsored_challenges_first", fALSE2);
        hashMap.put("android_config_session_daily_trick_time_in_seconds", 120);
        hashMap.put("android_config_invite_friends_banner_enabled", tRUE2);
        hashMap.put("android_show_challenge_become_premium_banner", tRUE2);
        hashMap.put("android_feature_in_app_review", fALSE2);
        hashMap.put("android_config_dynamic_link_prefix", "https://dogoapp.page.link");
        hashMap.put("android_program_exams_enabled", tRUE2);
        hashMap.put("android_config_min_supported_app_version", 555);
        hashMap.put("android_detect_v6_first_install", tRUE2);
        hashMap.put("android_config_certificate_enabled", fALSE2);
        hashMap.put("android_config_customers_experience_enabled", fALSE2);
        hashMap.put("android_config_use_appengine_api", tRUE2);
        hashMap.put("android_config_current_offering_id", "");
        String str43 = "[\"en\"]";
        hashMap.put("android_config_help_center_enabled_v2", str43);
        hashMap.put("android_config_workout_streaks", fALSE2);
        hashMap.put("android_config_help_card_enabled", tRUE2);
        hashMap.put("android_lock_help_card", tRUE2);
        hashMap.put("android_config_create_nps_login", tRUE2);
        hashMap.put("android_config_mobile_inbox", fALSE2);
        hashMap.put("android_config_cltv_monthly", Double.valueOf(1.51d));
        hashMap.put("android_config_cltv_monthly_free_trial", Double.valueOf(0.33d));
        hashMap.put("android_config_cltv_quarterly", Double.valueOf(0.9d));
        hashMap.put("android_config_cltv_quarterly_free_trial", Double.valueOf(0.14d));
        hashMap.put("android_config_cltv_annual", Double.valueOf(0.62d));
        hashMap.put("android_config_cltv_annual_free_trial", Double.valueOf(0.05d));
        hashMap.put("android_config_create_nps_ticket_min_symbols", 50);
        hashMap.put("android_config_recent_tricks", 15);
        hashMap.put("android_config_dashboard_card_order", "[\"recentTricks\", \"program\", \"exam\", \"help\", \"workout\", \"subscription\"]");
        hashMap.put("android_config_onboarding_questions", "[\"id_age\",\"id_pull_leash\",\"id_recall\",\"id_sit_and_stay\",\"id_improve_reaction_speed\",\"id_fun_tricks\",\"id_open_door\"]");
        hashMap.put("android_config_tricks_without_clicker", "[\"id_hand_feeding_01\",\"id_tug_01\", \"id_handling_01\",\"id_handling_02\", \"id_handling_03\",\"id_meet_greet_01\", \"id_biting_program_01\",\"id_collar_01\", \"id_guarding_program_01\",\"id_guarding_program_02\", \"id_jumping_prevent_01\",\"id_gotcha_program_01\"]");
        hashMap.put("android_config_program_whitelist", "[\"id_puppy_program\", \"id_pleasant_walks\", \"id_useful_program\", \"id_impulse_control\", \"id_adorable_program\", \"id_agile_program\", \"id_basic_obedience\"]");
        hashMap.put("android_config_local_training_reminders_enabled", fALSE2);
        hashMap.put("android_config_rt_1_lesson_flow", fALSE2);
        hashMap.put("android_config_rn_time_goal_seconds", 240);
        hashMap.put("android_config_rn_time_metric", fALSE2);
        hashMap.put("android_config_price_per", "day");
        hashMap.put("android_config_rt_potty_tracker_ui", fALSE2);
        firebaseRemoteConfig.setDefaultsAsync(hashMap);
        com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings builder2 = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(RemoteConfigService.f).setFetchTimeoutInSeconds(10L).build();
        n.e(builder2, "Builder()\n            .setMinimumFetchIntervalInSeconds(REMOTE_CONFIG_EXPIRATION_TIME)\n            .setFetchTimeoutInSeconds(10)\n            .build()");
        firebaseRemoteConfig.setConfigSettingsAsync(builder2);
        activeDebugOverrides();
    }

    /* renamed from: D, reason: from kotlin metadata */
    private final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> getBooleanValue(String key) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = getStringListValue(key).iterator();
        while (it.hasNext()) {
            SpecialProgramOverviewItem.PottyOverviewCardEnum stringToEnum = SpecialProgramOverviewItem_PottyOverviewCardEnum.INSTANCE.parseStringToEnum((String)it.next());
        }
        return arrayList;
    }

    /* renamed from: G, reason: from kotlin metadata */
    private final String getDoubleValue(String key) {
        Object value = null;
        String r0 = this.firebaseRemoteConfig.get(key) instanceof String ? (String)this.firebaseRemoteConfig.get(key) : 0;
        if (this.firebaseRemoteConfig == null) {
            str = "firebaseRemoteConfig.getString(key)";
            n.e(this.b.getString(key), str);
        }
        return value;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean getLongValue(String key) {
        Object value = null;
        boolean booleanValue;
        Boolean r0 = this.firebaseRemoteConfig.get(key) instanceof Boolean ? (Boolean)this.firebaseRemoteConfig.get(key) : 0;
        if (this.firebaseRemoteConfig == null) {
            booleanValue = this.b.getBoolean(key);
        } else {
            booleanValue = value.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final double getSpecialProgramOverviewOrder(String remoteKey) {
        Object value = null;
        double _double;
        Double r0 = this.firebaseRemoteConfig.get(remoteKey) instanceof Double ? (Double)this.firebaseRemoteConfig.get(remoteKey) : 0;
        if (this.firebaseRemoteConfig == null) {
            _double = this.b.getDouble(remoteKey);
        } else {
            _double = value.doubleValue();
        }
        return _double;
    }

    /* renamed from: j0, reason: from kotlin metadata */
    private final List<String> getStringListValue(String key) {
        Object obj;
        List list;
        String doubleValue = getDoubleValue(key);
        if (l.z(doubleValue)) {
            list = p.g();
        } else {
            try {
                java.lang.reflect.Type[] arr = new Type[1];
                obj2 = String.class;
                f fVar = new r.a().b().d(t.j(List.class, new Type[] { obj2 }));
                str = "Builder().build().adapter(type)";
                n.e(fVar, str);
                if ((List)fVar.c(doubleValue) == null) {
                    List list2 = p.g();
                }
            } catch (Exception e) {
                String str2 = "Json Array Parse failed ";
                String eP_ErrorMessage = n.o(str2, key);
                int i = new Object[i];
                a.k(e, eP_ErrorMessage, i);
                i = E_General.j;
                eP_ErrorMessage = new EP_ErrorMessage();
                key = n.o(str2, key);
                key = u.a(eP_ErrorMessage, key);
                key = i.withParameters(key);
                this.a.logEvent(key);
                key = p.g();
            }
        }
        return list;
    }

    /* renamed from: k0, reason: from kotlin metadata */
    private final Map<String, String> getStringValue(String key) {
        Object obj;
        Map map;
        obj = String.class;
        String doubleValue = getDoubleValue(key);
        if (l.z(doubleValue)) {
            map = j0.h();
        } else {
            try {
                java.lang.reflect.Type[] arr = new Type[2];
                int i = 1;
                arr[i] = obj;
                f fVar = new r.a().b().d(t.j(Map.class, arr));
                str = "Builder().build().adapter(type)";
                n.e(fVar, str);
                if ((Map)fVar.c(doubleValue) == null) {
                    Map map2 = j0.h();
                }
            } catch (Exception e) {
                String str2 = "Json Map Parse failed ";
                String eP_ErrorMessage = n.o(str2, key);
                int i2 = new Object[i2];
                a.k(e, eP_ErrorMessage, i2);
                i2 = E_General.j;
                eP_ErrorMessage = new EP_ErrorMessage();
                key = n.o(str2, key);
                key = u.a(eP_ErrorMessage, key);
                key = i2.withParameters(key);
                this.a.logEvent(key);
                key = j0.h();
            }
        }
        return map;
    }

    /* renamed from: l0, reason: from kotlin metadata */
    private final Map<String, Map<String, String>> isHelpCenterEnabled(String locale) {
        Object obj;
        Class<String> obj4 = String.class;
        int i3 = 1;
        i = l.z(locale) ^ i3;
        if (l.z(locale) ^ i3 != 0) {
            int i = 0;
            try {
                obj2 = Map.class;
                java.lang.reflect.Type[] arr = new Type[4];
                arr[i] = obj4;
                obj3 = Map.class;
                arr[i3] = obj3;
                arr[2] = obj4;
                arr[3] = obj4;
                f fVar = new r.a().b().d(t.j(obj2, arr));
                str = "Builder().build().adapter(type)";
                n.e(fVar, str);
                Map map = j0.h();
            } catch (Exception e) {
                String str2 = "Parse failed ";
                String eP_ErrorMessage = n.o(str2, locale);
                int i2 = new Object[i2];
                a.k(e, eP_ErrorMessage, i2);
                i2 = E_General.j;
                eP_ErrorMessage = new EP_ErrorMessage();
                locale = n.o(str2, locale);
                locale = u.a(eP_ErrorMessage, locale);
                locale = i2.withParameters(locale);
                this.a.logEvent(locale);
                Throwable e2 = j0.h();
            }
        } else {
            Map map2 = j0.h();
        }
        return obj;
    }

    /* renamed from: n0, reason: from kotlin metadata */
    private static final void addDebugFeatureOverwrite(r2 featureKey, c0 list) {
        n.f(featureKey, "this$0");
        n.f(list, "emitter");
        try {
            featureKey.a.setUserProperty(UserProperty.Experiments, featureKey.c.getExperimentVariationsForTracking());
            list.onSuccess((Boolean)m.a(featureKey.b.fetchAndActivate()));
        } catch (Exception e) {
            a.d(e);
            e = Boolean.FALSE;
            list.onSuccess(e);
        }
    }

    /* renamed from: o0, reason: from kotlin metadata */
    private final void activeDebugOverrides() {
        this.firebaseRemoteConfig.putAll(this.experimentInteractor.f());
    }

    /* renamed from: w, reason: from kotlin metadata */
    private final long isSocialTabDisabledForLocale(String locale) {
        Object value = null;
        long value2;
        Long r0 = this.firebaseRemoteConfig.get(locale) instanceof Long ? (ong)this.firebaseRemoteConfig.get(locale) : 0;
        if (this.firebaseRemoteConfig == null) {
            value2 = this.b.getLong(locale);
        } else {
            value2 = value.longValue();
        }
        return value2;
    }

    public final String A() throws android.content.res.Resources.NotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = j();
        String string = App.INSTANCE.b().getResources().getString(2131886780);
        str = str2 + 47 + string;
        return str;
    }

    public final boolean B() {
        return getLongValue("android_show_challenge_become_premium_banner");
    }

    public final boolean C() {
        return getLongValue("android_feature_in_app_review");
    }

    public final boolean E() {
        return getLongValue("sponsored_challenges_first");
    }

    /* renamed from: F, reason: from kotlin metadata */
    public final List<String> parseJsonArray(String remoteKey) {
        n.f(remoteKey, "key");
        return getStringListValue(remoteKey);
    }

    public final app.dogo.com.dogo_android.k.n H() {
        app.dogo.com.dogo_android.k.n type;
        if (PricePerPeriodType.INSTANCE.getType(getDoubleValue("android_config_price_per")) == null) {
            type = PricePerPeriodType.DAY;
        }
        return type;
    }

    public final String I() {
        return getDoubleValue("tiktok_follow_us");
    }

    public final long J() {
        return isSocialTabDisabledForLocale("android_config_session_daily_trick_time_in_seconds");
    }

    public final long K() {
        return isSocialTabDisabledForLocale("android_trick_threshold_for_share");
    }

    public final List<String> L() {
        return getStringListValue("android_config_tricks_without_clicker");
    }

    public final List<String> M() {
        return getStringListValue("android_config_program_whitelist");
    }

    public final Map<String, String> N() {
        return getStringValue("android_config_program_whitelist_override");
    }

    public final boolean O() {
        return getLongValue("android_config_workout_streaks");
    }

    public final boolean P() {
        return getLongValue("android_config_certificate_enabled");
    }

    public final boolean Q() {
        return getLongValue("android_config_first_time_help_center_red_badge");
    }

    public final boolean R() {
        return getLongValue("android_config_customers_experience_enabled");
    }

    public final boolean S() {
        return getLongValue("android_config_help_card_enabled");
    }

    public final boolean T() {
        return getLongValue("android_lock_help_card");
    }

    /* renamed from: U, reason: from kotlin metadata */
    public final boolean parseJsonMap(String remoteKey) {
        n.f(remoteKey, "locale");
        return getStringListValue("android_config_help_center_enabled_v2").contains(LocaleService.supportedLocales.getLocaleString(remoteKey));
    }

    public final boolean V() {
        return getLongValue("android_config_iterable_notifications");
    }

    public final boolean W() {
        return getLongValue("android_config_rt_1_lesson_flow");
    }

    public final boolean X() {
        return getLongValue("android_config_create_nps_login");
    }

    public final boolean Y() {
        return getLongValue("android_config_mobile_inbox");
    }

    public final boolean Z() {
        return getLongValue("android_config_recommended_program_new_ui_v2");
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final void getArticleForLanguage(String iso2Language, Object trickId) {
        n.f(iso2Language, "featureKey");
        n.f(trickId, "value");
        if (App.INSTANCE.u()) {
            this.firebaseRemoteConfig.put(iso2Language, trickId);
            this.experimentInteractor.setPopUpShowedInLessonList(iso2Language, trickId);
        }
    }

    public final boolean a0() {
        return getLongValue("android_config_rt_potty_tracker_ui");
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void getCustomerLifetimeValueMultiplierFor(String type, List<String> freeTrial) {
        n.f(type, "featureKey");
        n.f(freeTrial, "list");
        java.lang.reflect.Type[] arr = new Type[1];
        f fVar = new r.a().b().d(t.j(List.class, new Type[] { String.class }));
        n.e(fVar, "moshi.adapter(type)");
        final String str5 = fVar.h(freeTrial);
        n.e(str5, "json");
        getArticleForLanguage(type, str5);
    }

    public final boolean b0() {
        return getLongValue("android_lock_premium_content");
    }

    public final void c() {
        this.firebaseRemoteConfig.clear();
        this.experimentInteractor.a();
    }

    public final boolean c0() {
        return getLongValue("android_program_exams_enabled");
    }

    public final Long d(String str, String str2) {
        int i = 0;
        n.f(str, "iso2Language");
        n.f(str2, "trickId");
        Object value = isHelpCenterEnabled(getDoubleValue("android_config_tips_and_tricks")).get(str);
        i = 0;
        if (value != null) {
            value = value.get(str2);
            if (value != null) {
                Long l = l.o(value);
            }
        }
        return i;
    }

    public final boolean d0() {
        boolean z2 = false;
        if (Z() || this.W()) {
            int i2 = 1;
        }
        return z2;
    }

    /* renamed from: e0, reason: from kotlin metadata */
    public final boolean parseLanguageMap(String trickString) {
        n.f(trickString, "locale");
        return getStringListValue("android_config_social_tab_countries").contains(trickString);
    }

    public final boolean f() {
        return getLongValue("is_challenge_filter_featured_enabled");
    }

    public final boolean f0() {
        return getLongValue("android_config_show_all_plans_top");
    }

    public final double g(PackageType packageType, boolean z) {
        String str;
        n.f(packageType, "type");
        int i2 = r2.b.a[packageType.ordinal()];
        int i = 1;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                i = 3;
                if (i2 != 3) {
                    return 0;
                }
                packageType = z ? "android_config_cltv_monthly_free_trial" : "android_config_cltv_monthly";
            } else {
                packageType = z ? "android_config_cltv_quarterly_free_trial" : "android_config_cltv_quarterly";
            }
        } else {
            packageType = z ? "android_config_cltv_annual_free_trial" : "android_config_cltv_annual";
        }
        return (z ? "android_config_cltv_monthly_free_trial" : "android_config_cltv_monthly");
    }

    public final boolean g0() {
        return getLongValue("android_config_rn_time_metric");
    }

    public final String h() {
        return getDoubleValue("android_config_current_offering_id");
    }

    public final boolean h0() {
        return getLongValue("android_config_local_training_reminders_enabled");
    }

    public final String j() {
        return getDoubleValue("android_config_dynamic_link_prefix");
    }

    public final List<String> k() {
        return getStringListValue("android_config_force_image_trick");
    }

    public final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> l() {
        return getBooleanValue("android_config_biting_order");
    }

    public final List<Dashboard.DashboardCardsEnum> m() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = getStringListValue("android_config_dashboard_card_order").iterator();
        while (it.hasNext()) {
            Dashboard.DashboardCardsEnum stringToEnum = Dashboard_DashboardCardsEnum.INSTANCE.parseStringToEnum((String)it.next());
        }
        return arrayList;
    }

    public final i.b.a0<Boolean> m0() {
        i.b.a0 a0Var = a0.create(new o1(this));
        n.e(a0Var, "create { emitter ->\n            try {\n                val isSuccess = Tasks.await(firebaseRemoteConfig.fetchAndActivate())\n                tracker.setUserProperty(UserProperty.Experiments, experimentInteractor.getExperimentVariationsForTracking())\n                emitter.onSuccess(isSuccess)\n            } catch (e: Exception) {\n                Timber.e(e)\n                emitter.onSuccess(false)\n            }\n        }");
        return a0Var;
    }

    public final List<String> n() {
        return getStringListValue("android_locked_tricks");
    }

    public final long o() {
        return isSocialTabDisabledForLocale("android_config_create_nps_ticket_min_symbols");
    }

    public final List<String> p() {
        return getStringListValue("android_config_onboarding_questions");
    }

    public final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> q() {
        return getBooleanValue("android_config_potty_order");
    }

    public final List<SpecialOfferCoupon> r() {
        try {
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            String str3 = "parsing ";
            String str4 = " value";
            sb = str3 + str + str4;
            int eP_ErrorMessage = 0;
            eP_ErrorMessage = new Object[eP_ErrorMessage];
            a.e(e, sb, eP_ErrorMessage);
            sb = E_General.j;
            eP_ErrorMessage = new EP_ErrorMessage();
            StringBuilder stringBuilder = new StringBuilder();
            str = str3 + str + str4;
            String str = u.a(eP_ErrorMessage, str);
            str = sb.withParameters(str);
            this.a.logEvent(str);
            str = p.g();
            return str;
        }
        return app.dogo.com.dogo_android.util.extensionfunction.j1.q0(getDoubleValue("android_config_promo_offers"));
    }

    public final int s() {
        return (int)isSocialTabDisabledForLocale("android_config_rn_time_goal_seconds");
    }

    public final String t() {
        return getDoubleValue("instagram_follow_us");
    }

    public final boolean u() {
        return getLongValue("android_config_invite_friends_banner_enabled");
    }

    public final String v() {
        return getDoubleValue("location_code");
    }

    public final long x() {
        return isSocialTabDisabledForLocale("android_config_min_supported_app_version");
    }

    public final long y() {
        return isSocialTabDisabledForLocale("android_photo_like_threshold_for_share");
    }

    public final long z() {
        return isSocialTabDisabledForLocale("android_config_recent_tricks");
    }

    static {
        RemoteConfigService.INSTANCE = new RemoteConfigService_Companion(null);
    }

    /* renamed from: i0, reason: from kotlin metadata */
    public static /* synthetic */ void addDebugFeatureOverwrite(r2 featureKey, c0 value) {
        RemoteConfigService.addDebugFeatureOverwrite(featureKey, value);
    }
}
