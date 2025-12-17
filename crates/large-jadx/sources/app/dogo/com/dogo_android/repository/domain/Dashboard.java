package app.dogo.com.dogo_android.repository.domain;

import app.dogo.com.dogo_android.u.h;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008^\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0003z{|Bç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n\u0012\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0008\u0008\u0002\u0010 \u001a\u00020\n\u0012\u000e\u0008\u0002\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\u0010\"J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0011HÆ\u0003J\t\u0010`\u001a\u00020\nHÆ\u0003J\t\u0010a\u001a\u00020\nHÆ\u0003J\u000f\u0010b\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\t\u0010c\u001a\u00020\nHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010h\u001a\u00020\nHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000f\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010n\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00107J\t\u0010o\u001a\u00020\nHÆ\u0003J\t\u0010p\u001a\u00020\nHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jô\u0001\u0010r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\n2\u0008\u0008\u0002\u0010\r\u001a\u00020\n2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\n2\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\n2\u000e\u0008\u0002\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015HÆ\u0001¢\u0006\u0002\u0010sJ\u0013\u0010t\u001a\u00020\n2\u0008\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020\u0011HÖ\u0001J\u0006\u0010w\u001a\u00020\nJ\u0006\u0010x\u001a\u00020\nJ\t\u0010y\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R \u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00085\u00102\"\u0004\u00086\u00104R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\u0008\u000b\u00107\"\u0004\u00088\u00109R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u00102\"\u0004\u0008;\u00104R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\u0008\t\u00107\"\u0004\u0008<\u00109R \u0010!\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010(\"\u0004\u0008>\u0010*R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010@\"\u0004\u0008A\u0010BR\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u00102\"\u0004\u0008D\u00104R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008E\u0010F\"\u0004\u0008G\u0010HR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010J\"\u0004\u0008K\u0010LR\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008M\u00102\"\u0004\u0008N\u00104R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010P\"\u0004\u0008Q\u0010RR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008S\u0010T\"\u0004\u0008U\u0010VR\u001a\u0010\u000c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008W\u00102\"\u0004\u0008X\u00104R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008Y\u00100R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010[\"\u0004\u0008\\\u0010]¨\u0006}", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "", "dogId", "", "userLanguage", "programItem", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "couponDiscount", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "isUserPremium", "", "isDogPremium", "userCancelledSubscription", "showWorkoutUnlocked", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "updatedZendeskMessageCount", "", "hasZendeskHistory", "helpCardEnabled", "cardsOrder", "", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "isLockForHelpCardEnabled", "recentlyViewed", "Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "pottyProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "bitingProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "trainingMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "pottyTrackerNewUiEnabled", "pottyCheckmarks", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLapp/dogo/com/dogo_android/repository/domain/WorkoutSession;IZZLjava/util/List;ZLapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;ZLjava/util/List;)V", "getBitingProgramCard", "()Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "setBitingProgramCard", "(Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;)V", "getCardsOrder", "()Ljava/util/List;", "setCardsOrder", "(Ljava/util/List;)V", "getCouponDiscount", "()Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "setCouponDiscount", "(Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;)V", "getDogId", "()Ljava/lang/String;", "getHasZendeskHistory", "()Z", "setHasZendeskHistory", "(Z)V", "getHelpCardEnabled", "setHelpCardEnabled", "()Ljava/lang/Boolean;", "setDogPremium", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setLockForHelpCardEnabled", "setUserPremium", "getPottyCheckmarks", "setPottyCheckmarks", "getPottyProgramCard", "()Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "setPottyProgramCard", "(Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;)V", "getPottyTrackerNewUiEnabled", "setPottyTrackerNewUiEnabled", "getProgramItem", "()Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "setProgramItem", "(Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;)V", "getRecentlyViewed", "()Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "setRecentlyViewed", "(Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;)V", "getShowWorkoutUnlocked", "setShowWorkoutUnlocked", "getTrainingMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "setTrainingMetrics", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;)V", "getUpdatedZendeskMessageCount", "()I", "setUpdatedZendeskMessageCount", "(I)V", "getUserCancelledSubscription", "setUserCancelledSubscription", "getUserLanguage", "getWorkoutSession", "()Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "setWorkoutSession", "(Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLapp/dogo/com/dogo_android/repository/domain/WorkoutSession;IZZLjava/util/List;ZLapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;ZLjava/util/List;)Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "equals", "other", "hashCode", "isExamCardVisible", "shouldShowMessageNumberInHelpCard", "toString", "BitingProgramCard", "DashboardCardsEnum", "PottyProgramCard", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Dashboard {

    private app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard bitingProgramCard;
    private List<? extends app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum> cardsOrder;
    private app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount;
    private final String dogId;
    private boolean hasZendeskHistory;
    private boolean helpCardEnabled;
    private Boolean isDogPremium;
    private boolean isLockForHelpCardEnabled;
    private Boolean isUserPremium;
    private List<Boolean> pottyCheckmarks;
    private app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard pottyProgramCard;
    private boolean pottyTrackerNewUiEnabled;
    private app.dogo.com.dogo_android.repository.domain.DashboardProgram programItem;
    private app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewed;
    private boolean showWorkoutUnlocked;
    private app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingMetrics;
    private int updatedZendeskMessageCount;
    private boolean userCancelledSubscription;
    private final String userLanguage;
    private app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008\u0086\u0001\u0018\u0000 \u000f2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "", "cardType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCardType", "()Ljava/lang/String;", "RECENT", "PROGRAM", "EXAM", "POTTY", "BITING", "WORKOUT", "SUBSCRIPTION", "TRAINING_TIME_SUMMARY", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum DashboardCardsEnum {

        RECENT("recentTricks"),
        PROGRAM("recentTricks"),
        EXAM("recentTricks"),
        POTTY("recentTricks"),
        BITING("recentTricks"),
        WORKOUT("recentTricks"),
        SUBSCRIPTION("recentTricks"),
        TRAINING_TIME_SUMMARY("recentTricks");

        private final String cardType;
        private static final app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum[] $values() {
            app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum[] arr = new Dashboard.DashboardCardsEnum[8];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getCardType() {
            return this.cardType;
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "", "showCard", "", "programProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "programDescription", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "reminders", "", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "(ZLapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;Ljava/util/List;)V", "getProgramDescription", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getProgramProgress", "()Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "getReminders", "()Ljava/util/List;", "getShowCard", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hasLogs", "hasProgress", "hasReminders", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PottyProgramCard {

        private final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription;
        private final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress programProgress;
        private final List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> reminders;
        private final boolean showCard;
        public PottyProgramCard(boolean z, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress2, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem3, List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> list4) {
            n.f(pottyProgramProgress2, "programProgress");
            n.f(programDescriptionItem3, "programDescription");
            n.f(list4, "reminders");
            super();
            this.showCard = z;
            this.programProgress = pottyProgramProgress2;
            this.programDescription = programDescriptionItem3;
            this.reminders = list4;
        }

        public PottyProgramCard(boolean z, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress2, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem3, List list4, int i5, g g6) {
            List obj4;
            if (i5 &= 8 != 0) {
                obj4 = p.g();
            }
            super(z, pottyProgramProgress2, programDescriptionItem3, obj4);
        }

        public static app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard copy$default(app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard dashboard$PottyProgramCard, boolean z2, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress3, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem4, List list5, int i6, Object object7) {
            boolean obj1;
            app.dogo.com.dogo_android.repository.domain.PottyProgramProgress obj2;
            app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem obj3;
            List obj4;
            if (i6 & 1 != 0) {
                obj1 = pottyProgramCard.showCard;
            }
            if (i6 & 2 != 0) {
                obj2 = pottyProgramCard.programProgress;
            }
            if (i6 & 4 != 0) {
                obj3 = pottyProgramCard.programDescription;
            }
            if (i6 &= 8 != 0) {
                obj4 = pottyProgramCard.reminders;
            }
            return pottyProgramCard.copy(obj1, obj2, obj3, obj4);
        }

        public final boolean component1() {
            return this.showCard;
        }

        public final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress component2() {
            return this.programProgress;
        }

        public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem component3() {
            return this.programDescription;
        }

        public final List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> component4() {
            return this.reminders;
        }

        public final app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard copy(boolean z, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress2, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem3, List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> list4) {
            n.f(pottyProgramProgress2, "programProgress");
            n.f(programDescriptionItem3, "programDescription");
            n.f(list4, "reminders");
            Dashboard.PottyProgramCard pottyProgramCard = new Dashboard.PottyProgramCard(z, pottyProgramProgress2, programDescriptionItem3, list4);
            return pottyProgramCard;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof Dashboard.PottyProgramCard) {
                return i2;
            }
            if (this.showCard != object.showCard) {
                return i2;
            }
            if (!n.b(this.programProgress, object.programProgress)) {
                return i2;
            }
            if (!n.b(this.programDescription, object.programDescription)) {
                return i2;
            }
            if (!n.b(this.reminders, object.reminders)) {
                return i2;
            }
            return i;
        }

        public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem getProgramDescription() {
            return this.programDescription;
        }

        public final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress getProgramProgress() {
            return this.programProgress;
        }

        public final List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> getReminders() {
            return this.reminders;
        }

        public final boolean getShowCard() {
            return this.showCard;
        }

        public final boolean hasLogs() {
            return this.programProgress.hasLogs();
        }

        public final boolean hasProgress() {
            boolean progress;
            int i;
            if (!this.programProgress.hasProgress()) {
                if (empty ^= i != 0) {
                } else {
                    i = 0;
                }
            }
            return i;
        }

        public final boolean hasReminders() {
            return empty ^= 1;
        }

        public int hashCode() {
            boolean showCard;
            if (this.showCard) {
                showCard = 1;
            }
            return i5 += i9;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PottyProgramCard(showCard=");
            stringBuilder.append(this.showCard);
            stringBuilder.append(", programProgress=");
            stringBuilder.append(this.programProgress);
            stringBuilder.append(", programDescription=");
            stringBuilder.append(this.programDescription);
            stringBuilder.append(", reminders=");
            stringBuilder.append(this.reminders);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0008HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramCompletion;", "showCard", "", "programCompleted", "programDescription", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "programCompletion", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "(ZZLapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;)V", "getProgramCompleted", "()Z", "getProgramCompletion", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "getProgramDescription", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getShowCard", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class BitingProgramCard implements h {

        private final boolean programCompleted;
        private final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion;
        private final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription;
        private final boolean showCard;
        public BitingProgramCard(boolean z, boolean z2, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem3, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData4) {
            n.f(programDescriptionItem3, "programDescription");
            n.f(programProgressData4, "programCompletion");
            super();
            this.showCard = z;
            this.programCompleted = z2;
            this.programDescription = programDescriptionItem3;
            this.programCompletion = programProgressData4;
        }

        public BitingProgramCard(boolean z, boolean z2, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem3, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData4, int i5, g g6) {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData;
            int i3;
            int i2;
            int i4;
            int i;
            int i6;
            int i7;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData obj11;
            if (i5 &= 8 != 0) {
                super(0, 0, 0, 0, 15, 0);
            }
            super(z, z2, programDescriptionItem3, obj11);
        }

        public static app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard copy$default(app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard dashboard$BitingProgramCard, boolean z2, boolean z3, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem4, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData5, int i6, Object object7) {
            boolean obj1;
            boolean obj2;
            app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem obj3;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData obj4;
            if (i6 & 1 != 0) {
                obj1 = bitingProgramCard.showCard;
            }
            if (i6 & 2 != 0) {
                obj2 = bitingProgramCard.programCompleted;
            }
            if (i6 & 4 != 0) {
                obj3 = bitingProgramCard.programDescription;
            }
            if (i6 &= 8 != 0) {
                obj4 = bitingProgramCard.getProgramCompletion();
            }
            return bitingProgramCard.copy(obj1, obj2, obj3, obj4);
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final boolean component1() {
            return this.showCard;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final boolean component2() {
            return this.programCompleted;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem component3() {
            return this.programDescription;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData component4() {
            return getProgramCompletion();
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard copy(boolean z, boolean z2, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem3, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData4) {
            n.f(programDescriptionItem3, "programDescription");
            n.f(programProgressData4, "programCompletion");
            Dashboard.BitingProgramCard bitingProgramCard = new Dashboard.BitingProgramCard(z, z2, programDescriptionItem3, programProgressData4);
            return bitingProgramCard;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof Dashboard.BitingProgramCard) {
                return i2;
            }
            if (this.showCard != object.showCard) {
                return i2;
            }
            if (this.programCompleted != object.programCompleted) {
                return i2;
            }
            if (!n.b(this.programDescription, object.programDescription)) {
                return i2;
            }
            if (!n.b(getProgramCompletion(), (Dashboard.BitingProgramCard)object.getProgramCompletion())) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final boolean getProgramCompleted() {
            return this.programCompleted;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData getProgramCompletion() {
            return this.programCompletion;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem getProgramDescription() {
            return this.programDescription;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public final boolean getShowCard() {
            return this.showCard;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public int hashCode() {
            boolean showCard;
            int i;
            if (this.showCard) {
                showCard = i;
            }
            final boolean programCompleted = this.programCompleted;
            if (programCompleted) {
            } else {
                i = programCompleted;
            }
            return i6 += i9;
        }

        @Override // app.dogo.com.dogo_android.u.h
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BitingProgramCard(showCard=");
            stringBuilder.append(this.showCard);
            stringBuilder.append(", programCompleted=");
            stringBuilder.append(this.programCompleted);
            stringBuilder.append(", programDescription=");
            stringBuilder.append(this.programDescription);
            stringBuilder.append(", programCompletion=");
            stringBuilder.append(getProgramCompletion());
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public Dashboard(String string, String string2, app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram3, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount4, Boolean boolean5, Boolean boolean6, boolean z7, boolean z8, app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession9, int i10, boolean z11, boolean z12, List<? extends app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum> list13, boolean z14, app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks15, app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard dashboard$PottyProgramCard16, app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard dashboard$BitingProgramCard17, app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics18, boolean z19, List<Boolean> list20) {
        final Object obj = this;
        final Object obj2 = list13;
        final Object obj3 = list20;
        n.f(string, "dogId");
        n.f(string2, "userLanguage");
        n.f(obj2, "cardsOrder");
        n.f(obj3, "pottyCheckmarks");
        super();
        obj.dogId = string;
        obj.userLanguage = string2;
        obj.programItem = dashboardProgram3;
        obj.couponDiscount = couponDiscount4;
        obj.isUserPremium = boolean5;
        obj.isDogPremium = boolean6;
        obj.userCancelledSubscription = z7;
        obj.showWorkoutUnlocked = z8;
        obj.workoutSession = workoutSession9;
        obj.updatedZendeskMessageCount = i10;
        obj.hasZendeskHistory = z11;
        obj.helpCardEnabled = z12;
        obj.cardsOrder = obj2;
        obj.isLockForHelpCardEnabled = z14;
        obj.recentlyViewed = recentlyViewedTricks15;
        obj.pottyProgramCard = pottyProgramCard16;
        obj.bitingProgramCard = bitingProgramCard17;
        obj.trainingMetrics = trainingTimeMetrics18;
        obj.pottyTrackerNewUiEnabled = z19;
        obj.pottyCheckmarks = obj3;
    }

    public Dashboard(String string, String string2, app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram3, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount4, Boolean boolean5, Boolean boolean6, boolean z7, boolean z8, app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession9, int i10, boolean z11, boolean z12, List list13, boolean z14, app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks15, app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard dashboard$PottyProgramCard16, app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard dashboard$BitingProgramCard17, app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics18, boolean z19, List list20, int i21, g g22) {
        int i15;
        int i8;
        List i2;
        int i19;
        int i;
        int i12;
        int i16;
        int i9;
        int i20;
        int i7;
        int i17;
        int i14;
        int i5;
        List list2;
        int i18;
        int i13;
        int i3;
        int i4;
        int i6;
        int i11;
        List list;
        int i22 = i21;
        final int i43 = 0;
        i19 = i22 & 4 != 0 ? i43 : dashboardProgram3;
        i = i22 & 8 != 0 ? i43 : couponDiscount4;
        i12 = i22 & 16 != 0 ? i43 : boolean5;
        i16 = i22 & 32 != 0 ? i43 : boolean6;
        int i44 = 0;
        i9 = i22 & 64 != 0 ? i44 : z7;
        i20 = i22 & 128 != 0 ? i44 : z8;
        i7 = i22 & 256 != 0 ? i43 : workoutSession9;
        i17 = i22 & 512 != 0 ? i44 : i10;
        i14 = i22 & 1024 != 0 ? i44 : z11;
        i5 = i22 & 2048 != 0 ? i8 : z12;
        if (i22 & 4096 != 0) {
            list2 = i2;
        } else {
            list2 = list13;
        }
        i18 = i22 & 8192 != 0 ? i44 : z14;
        i13 = i22 & 16384 != 0 ? i43 : recentlyViewedTricks15;
        i3 = i34 &= i22 != 0 ? i43 : pottyProgramCard16;
        i4 = i36 &= i22 != 0 ? i43 : bitingProgramCard17;
        i6 = i38 &= i22 != 0 ? i43 : trainingTimeMetrics18;
        i11 = i40 &= i22 != 0 ? i44 : z19;
        if (i22 &= i42 != 0) {
            list = i15;
        } else {
            list = list20;
        }
        super(string, string2, i19, i, i12, i16, i9, i20, i7, i17, i14, i5, list2, i18, i13, i3, i4, i6, i11, list);
    }

    public static app.dogo.com.dogo_android.repository.domain.Dashboard copy$default(app.dogo.com.dogo_android.repository.domain.Dashboard dashboard, String string2, String string3, app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram4, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount5, Boolean boolean6, Boolean boolean7, boolean z8, boolean z9, app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession10, int i11, boolean z12, boolean z13, List list14, boolean z15, app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks16, app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard dashboard$PottyProgramCard17, app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard dashboard$BitingProgramCard18, app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics19, boolean z20, List list21, int i22, Object object23) {
        List pottyCheckmarks;
        String dogId;
        String userLanguage;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram programItem;
        app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount;
        Boolean isUserPremium;
        Boolean isDogPremium;
        boolean userCancelledSubscription;
        boolean showWorkoutUnlocked;
        app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession;
        int updatedZendeskMessageCount;
        boolean hasZendeskHistory;
        boolean helpCardEnabled;
        List cardsOrder;
        boolean isLockForHelpCardEnabled;
        app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewed;
        app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard pottyProgramCard;
        app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard bitingProgramCard;
        app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingMetrics;
        boolean pottyTrackerNewUiEnabled;
        Object obj = dashboard;
        int i = i22;
        dogId = i & 1 != 0 ? obj.dogId : string2;
        userLanguage = i & 2 != 0 ? obj.userLanguage : string3;
        programItem = i & 4 != 0 ? obj.programItem : dashboardProgram4;
        couponDiscount = i & 8 != 0 ? obj.couponDiscount : couponDiscount5;
        isUserPremium = i & 16 != 0 ? obj.isUserPremium : boolean6;
        isDogPremium = i & 32 != 0 ? obj.isDogPremium : boolean7;
        userCancelledSubscription = i & 64 != 0 ? obj.userCancelledSubscription : z8;
        showWorkoutUnlocked = i & 128 != 0 ? obj.showWorkoutUnlocked : z9;
        workoutSession = i & 256 != 0 ? obj.workoutSession : workoutSession10;
        updatedZendeskMessageCount = i & 512 != 0 ? obj.updatedZendeskMessageCount : i11;
        hasZendeskHistory = i & 1024 != 0 ? obj.hasZendeskHistory : z12;
        helpCardEnabled = i & 2048 != 0 ? obj.helpCardEnabled : z13;
        cardsOrder = i & 4096 != 0 ? obj.cardsOrder : list14;
        isLockForHelpCardEnabled = i & 8192 != 0 ? obj.isLockForHelpCardEnabled : z15;
        recentlyViewed = i & 16384 != 0 ? obj.recentlyViewed : recentlyViewedTricks16;
        pottyProgramCard = i & i19 != 0 ? obj.pottyProgramCard : pottyProgramCard17;
        bitingProgramCard = i & i21 != 0 ? obj.bitingProgramCard : bitingProgramCard18;
        trainingMetrics = i & i24 != 0 ? obj.trainingMetrics : trainingTimeMetrics19;
        pottyTrackerNewUiEnabled = i & i26 != 0 ? obj.pottyTrackerNewUiEnabled : z20;
        pottyCheckmarks = i &= i28 != 0 ? obj.pottyCheckmarks : list21;
        return dashboard.copy(dogId, userLanguage, programItem, couponDiscount, isUserPremium, isDogPremium, userCancelledSubscription, showWorkoutUnlocked, workoutSession, updatedZendeskMessageCount, hasZendeskHistory, helpCardEnabled, cardsOrder, isLockForHelpCardEnabled, recentlyViewed, pottyProgramCard, bitingProgramCard, trainingMetrics, pottyTrackerNewUiEnabled, pottyCheckmarks);
    }

    public final String component1() {
        return this.dogId;
    }

    public final int component10() {
        return this.updatedZendeskMessageCount;
    }

    public final boolean component11() {
        return this.hasZendeskHistory;
    }

    public final boolean component12() {
        return this.helpCardEnabled;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum> component13() {
        return this.cardsOrder;
    }

    public final boolean component14() {
        return this.isLockForHelpCardEnabled;
    }

    public final app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks component15() {
        return this.recentlyViewed;
    }

    public final app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard component16() {
        return this.pottyProgramCard;
    }

    public final app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard component17() {
        return this.bitingProgramCard;
    }

    public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics component18() {
        return this.trainingMetrics;
    }

    public final boolean component19() {
        return this.pottyTrackerNewUiEnabled;
    }

    public final String component2() {
        return this.userLanguage;
    }

    public final List<Boolean> component20() {
        return this.pottyCheckmarks;
    }

    public final app.dogo.com.dogo_android.repository.domain.DashboardProgram component3() {
        return this.programItem;
    }

    public final app.dogo.com.dogo_android.repository.domain.CouponDiscount component4() {
        return this.couponDiscount;
    }

    public final Boolean component5() {
        return this.isUserPremium;
    }

    public final Boolean component6() {
        return this.isDogPremium;
    }

    public final boolean component7() {
        return this.userCancelledSubscription;
    }

    public final boolean component8() {
        return this.showWorkoutUnlocked;
    }

    public final app.dogo.com.dogo_android.repository.domain.WorkoutSession component9() {
        return this.workoutSession;
    }

    public final app.dogo.com.dogo_android.repository.domain.Dashboard copy(String string, String string2, app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram3, app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount4, Boolean boolean5, Boolean boolean6, boolean z7, boolean z8, app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession9, int i10, boolean z11, boolean z12, List<? extends app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum> list13, boolean z14, app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks15, app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard dashboard$PottyProgramCard16, app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard dashboard$BitingProgramCard17, app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics18, boolean z19, List<Boolean> list20) {
        Object obj = string;
        n.f(obj, "dogId");
        n.f(string2, "userLanguage");
        n.f(list13, "cardsOrder");
        n.f(list20, "pottyCheckmarks");
        super(obj, string2, dashboardProgram3, couponDiscount4, boolean5, boolean6, z7, z8, workoutSession9, i10, z11, z12, list13, z14, recentlyViewedTricks15, pottyProgramCard16, bitingProgramCard17, trainingTimeMetrics18, z19, list20);
        return dashboard2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Dashboard) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.userLanguage, object.userLanguage)) {
            return i2;
        }
        if (!n.b(this.programItem, object.programItem)) {
            return i2;
        }
        if (!n.b(this.couponDiscount, object.couponDiscount)) {
            return i2;
        }
        if (!n.b(this.isUserPremium, object.isUserPremium)) {
            return i2;
        }
        if (!n.b(this.isDogPremium, object.isDogPremium)) {
            return i2;
        }
        if (this.userCancelledSubscription != object.userCancelledSubscription) {
            return i2;
        }
        if (this.showWorkoutUnlocked != object.showWorkoutUnlocked) {
            return i2;
        }
        if (!n.b(this.workoutSession, object.workoutSession)) {
            return i2;
        }
        if (this.updatedZendeskMessageCount != object.updatedZendeskMessageCount) {
            return i2;
        }
        if (this.hasZendeskHistory != object.hasZendeskHistory) {
            return i2;
        }
        if (this.helpCardEnabled != object.helpCardEnabled) {
            return i2;
        }
        if (!n.b(this.cardsOrder, object.cardsOrder)) {
            return i2;
        }
        if (this.isLockForHelpCardEnabled != object.isLockForHelpCardEnabled) {
            return i2;
        }
        if (!n.b(this.recentlyViewed, object.recentlyViewed)) {
            return i2;
        }
        if (!n.b(this.pottyProgramCard, object.pottyProgramCard)) {
            return i2;
        }
        if (!n.b(this.bitingProgramCard, object.bitingProgramCard)) {
            return i2;
        }
        if (!n.b(this.trainingMetrics, object.trainingMetrics)) {
            return i2;
        }
        if (this.pottyTrackerNewUiEnabled != object.pottyTrackerNewUiEnabled) {
            return i2;
        }
        if (!n.b(this.pottyCheckmarks, object.pottyCheckmarks)) {
            return i2;
        }
        return i;
    }

    public final app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard getBitingProgramCard() {
        return this.bitingProgramCard;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum> getCardsOrder() {
        return this.cardsOrder;
    }

    public final app.dogo.com.dogo_android.repository.domain.CouponDiscount getCouponDiscount() {
        return this.couponDiscount;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final boolean getHasZendeskHistory() {
        return this.hasZendeskHistory;
    }

    public final boolean getHelpCardEnabled() {
        return this.helpCardEnabled;
    }

    public final List<Boolean> getPottyCheckmarks() {
        return this.pottyCheckmarks;
    }

    public final app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard getPottyProgramCard() {
        return this.pottyProgramCard;
    }

    public final boolean getPottyTrackerNewUiEnabled() {
        return this.pottyTrackerNewUiEnabled;
    }

    public final app.dogo.com.dogo_android.repository.domain.DashboardProgram getProgramItem() {
        return this.programItem;
    }

    public final app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks getRecentlyViewed() {
        return this.recentlyViewed;
    }

    public final boolean getShowWorkoutUnlocked() {
        return this.showWorkoutUnlocked;
    }

    public final app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics getTrainingMetrics() {
        return this.trainingMetrics;
    }

    public final int getUpdatedZendeskMessageCount() {
        return this.updatedZendeskMessageCount;
    }

    public final boolean getUserCancelledSubscription() {
        return this.userCancelledSubscription;
    }

    public final String getUserLanguage() {
        return this.userLanguage;
    }

    public final app.dogo.com.dogo_android.repository.domain.WorkoutSession getWorkoutSession() {
        return this.workoutSession;
    }

    public int hashCode() {
        int i3;
        int i10;
        int i6;
        int i9;
        boolean userCancelledSubscription;
        boolean showWorkoutUnlocked;
        int i7;
        boolean hasZendeskHistory;
        boolean helpCardEnabled;
        boolean isLockForHelpCardEnabled;
        int i5;
        int i;
        int i4;
        int i8;
        boolean i2;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram programItem = this.programItem;
        i8 = 0;
        if (programItem == null) {
            i3 = i8;
        } else {
            i3 = programItem.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount = this.couponDiscount;
        if (couponDiscount == null) {
            i10 = i8;
        } else {
            i10 = couponDiscount.hashCode();
        }
        Boolean isUserPremium = this.isUserPremium;
        if (isUserPremium == null) {
            i6 = i8;
        } else {
            i6 = isUserPremium.hashCode();
        }
        Boolean isDogPremium = this.isDogPremium;
        if (isDogPremium == null) {
            i9 = i8;
        } else {
            i9 = isDogPremium.hashCode();
        }
        i2 = 1;
        if (this.userCancelledSubscription) {
            userCancelledSubscription = i2;
        }
        if (this.showWorkoutUnlocked) {
            showWorkoutUnlocked = i2;
        }
        app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession = this.workoutSession;
        if (workoutSession == null) {
            i7 = i8;
        } else {
            i7 = workoutSession.hashCode();
        }
        if (this.hasZendeskHistory) {
            hasZendeskHistory = i2;
        }
        if (this.helpCardEnabled) {
            helpCardEnabled = i2;
        }
        if (this.isLockForHelpCardEnabled) {
            isLockForHelpCardEnabled = i2;
        }
        app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewed = this.recentlyViewed;
        if (recentlyViewed == null) {
            i5 = i8;
        } else {
            i5 = recentlyViewed.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard pottyProgramCard = this.pottyProgramCard;
        if (pottyProgramCard == null) {
            i = i8;
        } else {
            i = pottyProgramCard.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard bitingProgramCard = this.bitingProgramCard;
        if (bitingProgramCard == null) {
            i4 = i8;
        } else {
            i4 = bitingProgramCard.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingMetrics = this.trainingMetrics;
        if (trainingMetrics == null) {
        } else {
            i8 = trainingMetrics.hashCode();
        }
        boolean pottyTrackerNewUiEnabled = this.pottyTrackerNewUiEnabled;
        if (pottyTrackerNewUiEnabled) {
        } else {
            i2 = pottyTrackerNewUiEnabled;
        }
        return i48 += i53;
    }

    public final Boolean isDogPremium() {
        return this.isDogPremium;
    }

    public final boolean isExamCardVisible() {
        app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType pROGRAM_COMPLETED;
        int i;
        int type;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram programItem = this.programItem;
        if (programItem == null) {
            pROGRAM_COMPLETED = type;
        } else {
            pROGRAM_COMPLETED = programItem.getType();
        }
        if (pROGRAM_COMPLETED != DashboardProgram.CardType.LESSON) {
            app.dogo.com.dogo_android.repository.domain.DashboardProgram programItem2 = this.programItem;
            if (programItem2 == null) {
            } else {
                type = programItem2.getType();
            }
            if (type == DashboardProgram.CardType.PROGRAM_COMPLETED) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean isLockForHelpCardEnabled() {
        return this.isLockForHelpCardEnabled;
    }

    public final Boolean isUserPremium() {
        return this.isUserPremium;
    }

    public final void setBitingProgramCard(app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard dashboard$BitingProgramCard) {
        this.bitingProgramCard = bitingProgramCard;
    }

    public final void setCardsOrder(List<? extends app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum> list) {
        n.f(list, "<set-?>");
        this.cardsOrder = list;
    }

    public final void setCouponDiscount(app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public final void setDogPremium(Boolean boolean) {
        this.isDogPremium = boolean;
    }

    public final void setHasZendeskHistory(boolean z) {
        this.hasZendeskHistory = z;
    }

    public final void setHelpCardEnabled(boolean z) {
        this.helpCardEnabled = z;
    }

    public final void setLockForHelpCardEnabled(boolean z) {
        this.isLockForHelpCardEnabled = z;
    }

    public final void setPottyCheckmarks(List<Boolean> list) {
        n.f(list, "<set-?>");
        this.pottyCheckmarks = list;
    }

    public final void setPottyProgramCard(app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard dashboard$PottyProgramCard) {
        this.pottyProgramCard = pottyProgramCard;
    }

    public final void setPottyTrackerNewUiEnabled(boolean z) {
        this.pottyTrackerNewUiEnabled = z;
    }

    public final void setProgramItem(app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram) {
        this.programItem = dashboardProgram;
    }

    public final void setRecentlyViewed(app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks) {
        this.recentlyViewed = recentlyViewedTricks;
    }

    public final void setShowWorkoutUnlocked(boolean z) {
        this.showWorkoutUnlocked = z;
    }

    public final void setTrainingMetrics(app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics) {
        this.trainingMetrics = trainingTimeMetrics;
    }

    public final void setUpdatedZendeskMessageCount(int i) {
        this.updatedZendeskMessageCount = i;
    }

    public final void setUserCancelledSubscription(boolean z) {
        this.userCancelledSubscription = z;
    }

    public final void setUserPremium(Boolean boolean) {
        this.isUserPremium = boolean;
    }

    public final void setWorkoutSession(app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession) {
        this.workoutSession = workoutSession;
    }

    public final boolean shouldShowMessageNumberInHelpCard() {
        boolean updatedZendeskMessageCount;
        int i;
        Boolean isUserPremium = this.isUserPremium;
        n.d(isUserPremium);
        if (isUserPremium.booleanValue() && this.updatedZendeskMessageCount > 0) {
            i = this.updatedZendeskMessageCount > 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dashboard(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", userLanguage=");
        stringBuilder.append(this.userLanguage);
        stringBuilder.append(", programItem=");
        stringBuilder.append(this.programItem);
        stringBuilder.append(", couponDiscount=");
        stringBuilder.append(this.couponDiscount);
        stringBuilder.append(", isUserPremium=");
        stringBuilder.append(this.isUserPremium);
        stringBuilder.append(", isDogPremium=");
        stringBuilder.append(this.isDogPremium);
        stringBuilder.append(", userCancelledSubscription=");
        stringBuilder.append(this.userCancelledSubscription);
        stringBuilder.append(", showWorkoutUnlocked=");
        stringBuilder.append(this.showWorkoutUnlocked);
        stringBuilder.append(", workoutSession=");
        stringBuilder.append(this.workoutSession);
        stringBuilder.append(", updatedZendeskMessageCount=");
        stringBuilder.append(this.updatedZendeskMessageCount);
        stringBuilder.append(", hasZendeskHistory=");
        stringBuilder.append(this.hasZendeskHistory);
        stringBuilder.append(", helpCardEnabled=");
        stringBuilder.append(this.helpCardEnabled);
        stringBuilder.append(", cardsOrder=");
        stringBuilder.append(this.cardsOrder);
        stringBuilder.append(", isLockForHelpCardEnabled=");
        stringBuilder.append(this.isLockForHelpCardEnabled);
        stringBuilder.append(", recentlyViewed=");
        stringBuilder.append(this.recentlyViewed);
        stringBuilder.append(", pottyProgramCard=");
        stringBuilder.append(this.pottyProgramCard);
        stringBuilder.append(", bitingProgramCard=");
        stringBuilder.append(this.bitingProgramCard);
        stringBuilder.append(", trainingMetrics=");
        stringBuilder.append(this.trainingMetrics);
        stringBuilder.append(", pottyTrackerNewUiEnabled=");
        stringBuilder.append(this.pottyTrackerNewUiEnabled);
        stringBuilder.append(", pottyCheckmarks=");
        stringBuilder.append(this.pottyCheckmarks);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
