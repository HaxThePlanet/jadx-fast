package app.dogo.com.dogo_android.repository.domain;

import app.dogo.com.dogo_android.u.h;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: Dashboard.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008^\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0003z{|Bç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n\u0012\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0008\u0008\u0002\u0010 \u001a\u00020\n\u0012\u000e\u0008\u0002\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\u0010\"J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0011HÆ\u0003J\t\u0010`\u001a\u00020\nHÆ\u0003J\t\u0010a\u001a\u00020\nHÆ\u0003J\u000f\u0010b\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\t\u0010c\u001a\u00020\nHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010h\u001a\u00020\nHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000f\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010n\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00107J\t\u0010o\u001a\u00020\nHÆ\u0003J\t\u0010p\u001a\u00020\nHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jô\u0001\u0010r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\n2\u0008\u0008\u0002\u0010\r\u001a\u00020\n2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\n2\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\n2\u000e\u0008\u0002\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015HÆ\u0001¢\u0006\u0002\u0010sJ\u0013\u0010t\u001a\u00020\n2\u0008\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020\u0011HÖ\u0001J\u0006\u0010w\u001a\u00020\nJ\u0006\u0010x\u001a\u00020\nJ\t\u0010y\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R \u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00085\u00102\"\u0004\u00086\u00104R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\u0008\u000b\u00107\"\u0004\u00088\u00109R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u00102\"\u0004\u0008;\u00104R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\u0008\t\u00107\"\u0004\u0008<\u00109R \u0010!\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010(\"\u0004\u0008>\u0010*R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010@\"\u0004\u0008A\u0010BR\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u00102\"\u0004\u0008D\u00104R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008E\u0010F\"\u0004\u0008G\u0010HR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010J\"\u0004\u0008K\u0010LR\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008M\u00102\"\u0004\u0008N\u00104R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010P\"\u0004\u0008Q\u0010RR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008S\u0010T\"\u0004\u0008U\u0010VR\u001a\u0010\u000c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008W\u00102\"\u0004\u0008X\u00104R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008Y\u00100R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010[\"\u0004\u0008\\\u0010]¨\u0006}", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "", "dogId", "", "userLanguage", "programItem", "Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "couponDiscount", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "isUserPremium", "", "isDogPremium", "userCancelledSubscription", "showWorkoutUnlocked", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "updatedZendeskMessageCount", "", "hasZendeskHistory", "helpCardEnabled", "cardsOrder", "", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "isLockForHelpCardEnabled", "recentlyViewed", "Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "pottyProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "bitingProgramCard", "Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "trainingMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "pottyTrackerNewUiEnabled", "pottyCheckmarks", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLapp/dogo/com/dogo_android/repository/domain/WorkoutSession;IZZLjava/util/List;ZLapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;ZLjava/util/List;)V", "getBitingProgramCard", "()Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "setBitingProgramCard", "(Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;)V", "getCardsOrder", "()Ljava/util/List;", "setCardsOrder", "(Ljava/util/List;)V", "getCouponDiscount", "()Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "setCouponDiscount", "(Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;)V", "getDogId", "()Ljava/lang/String;", "getHasZendeskHistory", "()Z", "setHasZendeskHistory", "(Z)V", "getHelpCardEnabled", "setHelpCardEnabled", "()Ljava/lang/Boolean;", "setDogPremium", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setLockForHelpCardEnabled", "setUserPremium", "getPottyCheckmarks", "setPottyCheckmarks", "getPottyProgramCard", "()Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "setPottyProgramCard", "(Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;)V", "getPottyTrackerNewUiEnabled", "setPottyTrackerNewUiEnabled", "getProgramItem", "()Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;", "setProgramItem", "(Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;)V", "getRecentlyViewed", "()Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "setRecentlyViewed", "(Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;)V", "getShowWorkoutUnlocked", "setShowWorkoutUnlocked", "getTrainingMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "setTrainingMetrics", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;)V", "getUpdatedZendeskMessageCount", "()I", "setUpdatedZendeskMessageCount", "(I)V", "getUserCancelledSubscription", "setUserCancelledSubscription", "getUserLanguage", "getWorkoutSession", "()Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;", "setWorkoutSession", "(Lapp/dogo/com/dogo_android/repository/domain/WorkoutSession;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/DashboardProgram;Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZLapp/dogo/com/dogo_android/repository/domain/WorkoutSession;IZZLjava/util/List;ZLapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;ZLjava/util/List;)Lapp/dogo/com/dogo_android/repository/domain/Dashboard;", "equals", "other", "hashCode", "isExamCardVisible", "shouldShowMessageNumberInHelpCard", "toString", "BitingProgramCard", "DashboardCardsEnum", "PottyProgramCard", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Dashboard {

    private Dashboard.BitingProgramCard bitingProgramCard;
    private List<? extends Dashboard.DashboardCardsEnum> cardsOrder;
    private CouponDiscount couponDiscount;
    private final String dogId;
    private boolean hasZendeskHistory;
    private boolean helpCardEnabled;
    private Boolean isDogPremium;
    private boolean isLockForHelpCardEnabled;
    private Boolean isUserPremium;
    private List<Boolean> pottyCheckmarks;
    private Dashboard.PottyProgramCard pottyProgramCard;
    private boolean pottyTrackerNewUiEnabled;
    private DashboardProgram programItem;
    private RecentlyViewedTricks recentlyViewed;
    private boolean showWorkoutUnlocked;
    private TrainingTimeMetrics trainingMetrics;
    private int updatedZendeskMessageCount;
    private boolean userCancelledSubscription;
    private final String userLanguage;
    private WorkoutSession workoutSession;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008\u0086\u0001\u0018\u0000 \u000f2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard$DashboardCardsEnum;", "", "cardType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCardType", "()Ljava/lang/String;", "RECENT", "PROGRAM", "EXAM", "POTTY", "BITING", "WORKOUT", "SUBSCRIPTION", "TRAINING_TIME_SUMMARY", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum DashboardCardsEnum {

        BITING,
        EXAM,
        POTTY,
        PROGRAM,
        RECENT,
        SUBSCRIPTION,
        TRAINING_TIME_SUMMARY,
        WORKOUT;

        private final String cardType;
        @Override // java.lang.Enum
        public final String getCardType() {
            return this.cardType;
        }

        private static final /* synthetic */ Dashboard.DashboardCardsEnum[] $values() {
            app.dogo.com.dogo_android.repository.domain.Dashboard.DashboardCardsEnum[] arr = new Dashboard.DashboardCardsEnum[8];
            return new Dashboard.DashboardCardsEnum[] { Dashboard_DashboardCardsEnum.RECENT, Dashboard_DashboardCardsEnum.PROGRAM, Dashboard_DashboardCardsEnum.EXAM, Dashboard_DashboardCardsEnum.POTTY, Dashboard_DashboardCardsEnum.BITING, Dashboard_DashboardCardsEnum.WORKOUT, Dashboard_DashboardCardsEnum.SUBSCRIPTION, Dashboard_DashboardCardsEnum.TRAINING_TIME_SUMMARY };
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard$PottyProgramCard;", "", "showCard", "", "programProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "programDescription", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "reminders", "", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "(ZLapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;Ljava/util/List;)V", "getProgramDescription", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getProgramProgress", "()Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "getReminders", "()Ljava/util/List;", "getShowCard", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hasLogs", "hasProgress", "hasReminders", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PottyProgramCard {

        private final ProgramDescriptionItem programDescription;
        private final PottyProgramProgress programProgress;
        private final List<PottyRemindersItem> reminders;
        private final boolean showCard;
        public PottyProgramCard(boolean z, PottyProgramProgress pottyProgramProgress, ProgramDescriptionItem programDescriptionItem, List<PottyRemindersItem> list) {
            n.f(pottyProgramProgress, "programProgress");
            n.f(programDescriptionItem, "programDescription");
            n.f(list, "reminders");
            super();
            this.showCard = z;
            this.programProgress = pottyProgramProgress;
            this.programDescription = programDescriptionItem;
            this.reminders = list;
        }

        public final ProgramDescriptionItem getProgramDescription() {
            return this.programDescription;
        }

        public final PottyProgramProgress getProgramProgress() {
            return this.programProgress;
        }

        public final List<PottyRemindersItem> getReminders() {
            return this.reminders;
        }

        public final boolean getShowCard() {
            return this.showCard;
        }

        public final boolean hasLogs() {
            return this.programProgress.hasLogs();
        }

        public final boolean hasProgress() {
            boolean z = true;
            if (!this.programProgress.hasProgress()) {
                if (!(this.reminders.isEmpty() ^ 1)) {
                    int i3 = 0;
                }
            }
            return z;
        }

        public final boolean hasReminders() {
            return !this.reminders.isEmpty();
        }

        public /* synthetic */ PottyProgramCard(boolean z, PottyProgramProgress pottyProgramProgress, ProgramDescriptionItem programDescriptionItem, List list, int i, g gVar) {
            if (i & 8 != 0) {
                list = p.g();
            }
            this(z, pottyProgramProgress, programDescriptionItem, list);
        }

        public static /* synthetic */ Dashboard.PottyProgramCard copy$default(Dashboard.PottyProgramCard pottyProgramCard, boolean z, PottyProgramProgress pottyProgramProgress, ProgramDescriptionItem programDescriptionItem, List list, int i, Object object) {
            boolean showCard2;
            app.dogo.com.dogo_android.repository.domain.PottyProgramProgress programProgress2;
            app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription2;
            List reminders2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            return pottyProgramCard.copy(showCard2, programProgress2, programDescription2, reminders2);
        }

        /* operator */ public final boolean component1() {
            return this.showCard;
        }

        /* operator */ public final PottyProgramProgress component2() {
            return this.programProgress;
        }

        /* operator */ public final ProgramDescriptionItem component3() {
            return this.programDescription;
        }

        /* operator */ public final List<PottyRemindersItem> component4() {
            return this.reminders;
        }

        public final Dashboard.PottyProgramCard copy(boolean showCard, PottyProgramProgress programProgress, ProgramDescriptionItem programDescription, List<PottyRemindersItem> reminders) {
            n.f(programProgress, "programProgress");
            n.f(programDescription, "programDescription");
            n.f(reminders, "reminders");
            return new Dashboard_PottyProgramCard(showCard, programProgress, programDescription, reminders);
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof Dashboard_PottyProgramCard)) {
                return false;
            }
            if (this.showCard != other.showCard) {
                return false;
            }
            if (!n.b(this.programProgress, other.programProgress)) {
                return false;
            }
            if (!n.b(this.programDescription, other.programDescription)) {
                return false;
            }
            return !n.b(this.reminders, other.reminders) ? z5 : z;
        }

        public int hashCode() {
            boolean showCard2 = true;
            if (this.showCard) {
                int i7 = 1;
            }
            return (showCard2 * 31) + this.programProgress.hashCode() * 31 + this.programDescription.hashCode() * 31 + this.reminders.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "PottyProgramCard(showCard=";
            String str3 = ", programProgress=";
            String str4 = ", programDescription=";
            String str5 = ", reminders=";
            str = str2 + this.showCard + str3 + this.programProgress + str4 + this.programDescription + str5 + this.reminders + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0008HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Dashboard$BitingProgramCard;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramCompletion;", "showCard", "", "programCompleted", "programDescription", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "programCompletion", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "(ZZLapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;)V", "getProgramCompleted", "()Z", "getProgramCompletion", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "getProgramDescription", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getShowCard", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class BitingProgramCard implements h {

        private final boolean programCompleted;
        private final SpecialProgramOverviewItem.ProgramProgressData programCompletion;
        private final ProgramDescriptionItem programDescription;
        private final boolean showCard;
        public BitingProgramCard(boolean z, boolean z2, ProgramDescriptionItem programDescriptionItem, SpecialProgramOverviewItem.ProgramProgressData programProgressData) {
            n.f(programDescriptionItem, "programDescription");
            n.f(programProgressData, "programCompletion");
            super();
            this.showCard = z;
            this.programCompleted = z2;
            this.programDescription = programDescriptionItem;
            this.programCompletion = programProgressData;
        }

        public final boolean getProgramCompleted() {
            return this.programCompleted;
        }

        public SpecialProgramOverviewItem.ProgramProgressData getProgramCompletion() {
            return this.programCompletion;
        }

        public final ProgramDescriptionItem getProgramDescription() {
            return this.programDescription;
        }

        public final boolean getShowCard() {
            return this.showCard;
        }

        public /* synthetic */ BitingProgramCard(boolean z, boolean z2, ProgramDescriptionItem programDescriptionItem, SpecialProgramOverviewItem.ProgramProgressData programProgressData, int i, g gVar) {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData42;
            if (i & 8 != 0) {
                i = 0;
                boolean z3 = false;
                int i2 = 0;
                boolean z4 = false;
                int i3 = 15;
                gVar = null;
                super(i, z3, i2, z4, i3, gVar);
            }
            this(z, z2, programDescriptionItem, programProgressData42);
        }

        public static /* synthetic */ Dashboard.BitingProgramCard copy$default(Dashboard.BitingProgramCard bitingProgramCard, boolean z, boolean z2, ProgramDescriptionItem programDescriptionItem, SpecialProgramOverviewItem.ProgramProgressData programProgressData, int i, Object object) {
            boolean showCard2;
            boolean programCompleted2;
            app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescription2;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
                programCompletion = bitingProgramCard.getProgramCompletion();
            }
            return bitingProgramCard.copy(showCard2, programCompleted2, programDescription2, programCompletion);
        }

        /* operator */ public final boolean component1() {
            return this.showCard;
        }

        /* operator */ public final boolean component2() {
            return this.programCompleted;
        }

        /* operator */ public final ProgramDescriptionItem component3() {
            return this.programDescription;
        }

        /* operator */ public final SpecialProgramOverviewItem.ProgramProgressData component4() {
            return getProgramCompletion();
        }

        public final Dashboard.BitingProgramCard copy(boolean showCard, boolean programCompleted, ProgramDescriptionItem programDescription, SpecialProgramOverviewItem.ProgramProgressData programCompletion) {
            n.f(programDescription, "programDescription");
            n.f(programCompletion, "programCompletion");
            return new Dashboard_BitingProgramCard(showCard, programCompleted, programDescription, programCompletion);
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof Dashboard_BitingProgramCard)) {
                return false;
            }
            if (this.showCard != other.showCard) {
                return false;
            }
            if (this.programCompleted != other.programCompleted) {
                return false;
            }
            if (!n.b(this.programDescription, other.programDescription)) {
                return false;
            }
            return !n.b(getProgramCompletion(), other.getProgramCompletion()) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean showCard2;
            int i = 1;
            i = 1;
            if (this.showCard) {
            }
            if (!(this.programCompleted)) {
            }
            return (showCard2 * 31) + i * 31 + this.programDescription.hashCode() * 31 + getProgramCompletion().hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "BitingProgramCard(showCard=";
            String str3 = ", programCompleted=";
            String str4 = ", programDescription=";
            String str5 = ", programCompletion=";
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion = getProgramCompletion();
            str = str2 + this.showCard + str3 + this.programCompleted + str4 + this.programDescription + str5 + programCompletion + 41;
            return str;
        }
    }
    public Dashboard(String str, String str2, DashboardProgram dashboardProgram, CouponDiscount couponDiscount, Boolean boolean, Boolean boolean2, boolean z, boolean z2, WorkoutSession workoutSession, int i, boolean z3, boolean z4, List<? extends Dashboard.DashboardCardsEnum> list, boolean z5, RecentlyViewedTricks recentlyViewedTricks, Dashboard.PottyProgramCard pottyProgramCard, Dashboard.BitingProgramCard bitingProgramCard, TrainingTimeMetrics trainingTimeMetrics, boolean z6, List<Boolean> list2) {
        final Object str4 = this;
        final Object list132 = list;
        final Object list202 = list2;
        n.f(str, "dogId");
        n.f(str2, "userLanguage");
        n.f(list132, "cardsOrder");
        n.f(list202, "pottyCheckmarks");
        super();
        str4.dogId = str;
        str4.userLanguage = str2;
        str4.programItem = dashboardProgram;
        str4.couponDiscount = couponDiscount;
        str4.isUserPremium = boolean;
        str4.isDogPremium = boolean2;
        str4.userCancelledSubscription = z;
        str4.showWorkoutUnlocked = z2;
        str4.workoutSession = workoutSession;
        str4.updatedZendeskMessageCount = i;
        str4.hasZendeskHistory = z3;
        str4.helpCardEnabled = z4;
        str4.cardsOrder = list132;
        str4.isLockForHelpCardEnabled = z5;
        str4.recentlyViewed = recentlyViewedTricks;
        str4.pottyProgramCard = pottyProgramCard;
        str4.bitingProgramCard = bitingProgramCard;
        str4.trainingMetrics = trainingTimeMetrics;
        str4.pottyTrackerNewUiEnabled = z6;
        str4.pottyCheckmarks = list202;
    }

    public final Dashboard.BitingProgramCard getBitingProgramCard() {
        return this.bitingProgramCard;
    }

    public final List<Dashboard.DashboardCardsEnum> getCardsOrder() {
        return this.cardsOrder;
    }

    public final CouponDiscount getCouponDiscount() {
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

    public final Dashboard.PottyProgramCard getPottyProgramCard() {
        return this.pottyProgramCard;
    }

    public final boolean getPottyTrackerNewUiEnabled() {
        return this.pottyTrackerNewUiEnabled;
    }

    public final DashboardProgram getProgramItem() {
        return this.programItem;
    }

    public final RecentlyViewedTricks getRecentlyViewed() {
        return this.recentlyViewed;
    }

    public final boolean getShowWorkoutUnlocked() {
        return this.showWorkoutUnlocked;
    }

    public final TrainingTimeMetrics getTrainingMetrics() {
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

    public final WorkoutSession getWorkoutSession() {
        return this.workoutSession;
    }

    public final Boolean isDogPremium() {
        return this.isDogPremium;
    }

    public final boolean isExamCardVisible() {
        app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType type;
        boolean z = true;
        int i = 0;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram.CardType type2 = null;
        i = 0;
        if (this.programItem == null) {
        } else {
            type = this.programItem.getType();
        }
        if (this.programItem != DashboardProgram_CardType.LESSON) {
            if (this.programItem != null) {
                type2 = this.programItem.getType();
            }
            if (type2 == DashboardProgram_CardType.PROGRAM_COMPLETED) {
                int i2 = 1;
            } else {
                int i3 = 0;
            }
        }
        return z;
    }

    public final boolean isLockForHelpCardEnabled() {
        return this.isLockForHelpCardEnabled;
    }

    public final Boolean isUserPremium() {
        return this.isUserPremium;
    }

    public final void setBitingProgramCard(Dashboard.BitingProgramCard bitingProgramCard) {
        this.bitingProgramCard = bitingProgramCard;
    }

    public final void setCardsOrder(List<? extends Dashboard.DashboardCardsEnum> list) {
        n.f(list, "<set-?>");
        this.cardsOrder = list;
    }

    public final void setCouponDiscount(CouponDiscount couponDiscount) {
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

    public final void setPottyProgramCard(Dashboard.PottyProgramCard pottyProgramCard) {
        this.pottyProgramCard = pottyProgramCard;
    }

    public final void setPottyTrackerNewUiEnabled(boolean z) {
        this.pottyTrackerNewUiEnabled = z;
    }

    public final void setProgramItem(DashboardProgram dashboardProgram) {
        this.programItem = dashboardProgram;
    }

    public final void setRecentlyViewed(RecentlyViewedTricks recentlyViewedTricks) {
        this.recentlyViewed = recentlyViewedTricks;
    }

    public final void setShowWorkoutUnlocked(boolean z) {
        this.showWorkoutUnlocked = z;
    }

    public final void setTrainingMetrics(TrainingTimeMetrics trainingTimeMetrics) {
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

    public final void setWorkoutSession(WorkoutSession workoutSession) {
        this.workoutSession = workoutSession;
    }

    public final boolean shouldShowMessageNumberInHelpCard() {
        boolean z = false;
        n.d(this.isUserPremium);
        int r0 = this.isUserPremium.booleanValue() && this.updatedZendeskMessageCount > 0 ? 1 : 0;
        return (this.isUserPremium.booleanValue() && this.updatedZendeskMessageCount > 0 ? 1 : 0);
    }

    public /* synthetic */ Dashboard(String str, String str2, DashboardProgram dashboardProgram, CouponDiscount couponDiscount, Boolean boolean, Boolean boolean2, boolean z, boolean z2, WorkoutSession workoutSession, int i, boolean z3, boolean z4, List list, boolean z5, RecentlyViewedTricks recentlyViewedTricks, Dashboard.PottyProgramCard pottyProgramCard, Dashboard.BitingProgramCard bitingProgramCard, TrainingTimeMetrics trainingTimeMetrics, boolean z6, List list2, int i2, g gVar) {
        app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram32;
        app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount42;
        Boolean boolean52;
        Boolean boolean62;
        boolean z72;
        boolean z82;
        app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession92;
        int i102;
        boolean z112;
        boolean z122;
        List list132;
        boolean z142;
        app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks152;
        app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard pottyProgramCard162;
        app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard bitingProgramCard172;
        app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics182;
        boolean z192;
        List list202;
        int i212 = i2;
        final int i3 = 0;
        int r6 = i212 & 4 != 0 ? i3 : dashboardProgram;
        int r7 = i212 & 8 != 0 ? i3 : couponDiscount;
        int r8 = i212 & 16 != 0 ? i3 : boolean;
        int r9 = i212 & 32 != 0 ? i3 : boolean2;
        i102 = 0;
        int r10 = i212 & 64 != 0 ? i102 : z;
        int r11 = i212 & 128 != 0 ? i102 : z2;
        int r12 = i212 & 256 != 0 ? i3 : workoutSession;
        int r13 = i212 & 512 != 0 ? i102 : i;
        int r14 = i212 & 1024 != 0 ? i102 : z3;
        i2 = i212 & 2048;
        i2 = i212 & 2048 != 0 ? i2 : z4;
        list132 = i212 & 4096 != 0 ? list132 : list;
        int r17 = i212 & 8192 != 0 ? i102 : z5;
        int r18 = i212 & 16384 != 0 ? i3 : recentlyViewedTricks;
        int r19 = 32768 & i212 != 0 ? i3 : pottyProgramCard;
        int r20 = 65536 & i212 != 0 ? i3 : bitingProgramCard;
        int r21 = 131072 & i212 != 0 ? i3 : trainingTimeMetrics;
        int r22 = 262144 & i212 != 0 ? i102 : z6;
        i = i212 & 524288;
        list202 = i212 & 524288 != 0 ? list202 : list2;
        this(str, str2, dashboardProgram32, couponDiscount42, boolean52, boolean62, z72, z82, workoutSession92, i102, z112, z122, list132, z142, recentlyViewedTricks152, pottyProgramCard162, bitingProgramCard172, trainingTimeMetrics182, z192, list202);
    }

    public static /* synthetic */ Dashboard copy$default(Dashboard dashboard, String str, String str2, DashboardProgram dashboardProgram, CouponDiscount couponDiscount, Boolean boolean, Boolean boolean2, boolean z, boolean z2, WorkoutSession workoutSession, int i, boolean z3, boolean z4, List list, boolean z5, RecentlyViewedTricks recentlyViewedTricks, Dashboard.PottyProgramCard pottyProgramCard, Dashboard.BitingProgramCard bitingProgramCard, TrainingTimeMetrics trainingTimeMetrics, boolean z6, List list2, int i2, Object object) {
        List list212;
        String str22;
        String str32;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram dashboardProgram42;
        app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount52;
        Boolean boolean62;
        Boolean boolean72;
        boolean z82;
        boolean z92;
        app.dogo.com.dogo_android.repository.domain.WorkoutSession workoutSession102;
        int i112;
        boolean z122;
        boolean z132;
        List list142;
        boolean z152;
        app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks162;
        app.dogo.com.dogo_android.repository.domain.Dashboard.PottyProgramCard pottyProgramCard172;
        app.dogo.com.dogo_android.repository.domain.Dashboard.BitingProgramCard bitingProgramCard182;
        app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics trainingTimeMetrics192;
        boolean z202;
        Object dashboard2 = dashboard;
        int i222 = i2;
        String r2 = i222 & 1 != 0 ? dashboard2.dogId : str;
        String r3 = i222 & 2 != 0 ? dashboard2.userLanguage : str2;
        app.dogo.com.dogo_android.repository.domain.DashboardProgram r4 = i222 & 4 != 0 ? dashboard2.programItem : dashboardProgram;
        app.dogo.com.dogo_android.repository.domain.CouponDiscount r5 = i222 & 8 != 0 ? dashboard2.couponDiscount : couponDiscount;
        Boolean r6 = i222 & 16 != 0 ? dashboard2.isUserPremium : boolean;
        Boolean r7 = i222 & 32 != 0 ? dashboard2.isDogPremium : boolean2;
        boolean r8 = i222 & 64 != 0 ? dashboard2.userCancelledSubscription : z;
        boolean r9 = i222 & 128 != 0 ? dashboard2.showWorkoutUnlocked : z2;
        app.dogo.com.dogo_android.repository.domain.WorkoutSession r10 = i222 & 256 != 0 ? dashboard2.workoutSession : workoutSession;
        int r11 = i222 & 512 != 0 ? dashboard2.updatedZendeskMessageCount : i;
        boolean r12 = i222 & 1024 != 0 ? dashboard2.hasZendeskHistory : z3;
        boolean r13 = i222 & 2048 != 0 ? dashboard2.helpCardEnabled : z4;
        List r14 = i222 & 4096 != 0 ? dashboard2.cardsOrder : list;
        boolean r15 = i222 & 8192 != 0 ? dashboard2.isLockForHelpCardEnabled : z5;
        r15 = i222 & 16384 != 0 ? dashboard2.recentlyViewed : recentlyViewedTricks;
        r15 = i222 & 32768 != 0 ? dashboard2.pottyProgramCard : pottyProgramCard;
        r15 = i222 & 65536 != 0 ? dashboard2.bitingProgramCard : bitingProgramCard;
        r15 = i222 & 131072 != 0 ? dashboard2.trainingMetrics : trainingTimeMetrics;
        r15 = i222 & 262144 != 0 ? dashboard2.pottyTrackerNewUiEnabled : z6;
        List r1 = i222 & 524288 != 0 ? dashboard2.pottyCheckmarks : list2;
        return dashboard.copy(str22, str32, dashboardProgram42, couponDiscount52, boolean62, boolean72, z82, z92, workoutSession102, i112, z122, z132, list142, (i222 & 8192 != 0 ? dashboard2.isLockForHelpCardEnabled : z5), (i222 & 16384 != 0 ? dashboard2.recentlyViewed : recentlyViewedTricks), (i222 & 32768 != 0 ? dashboard2.pottyProgramCard : pottyProgramCard), (i222 & 65536 != 0 ? dashboard2.bitingProgramCard : bitingProgramCard), (i222 & 131072 != 0 ? dashboard2.trainingMetrics : trainingTimeMetrics), z202, (i222 & 524288 != 0 ? dashboard2.pottyCheckmarks : list2));
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final int component10() {
        return this.updatedZendeskMessageCount;
    }

    /* operator */ public final boolean component11() {
        return this.hasZendeskHistory;
    }

    /* operator */ public final boolean component12() {
        return this.helpCardEnabled;
    }

    /* operator */ public final List<Dashboard.DashboardCardsEnum> component13() {
        return this.cardsOrder;
    }

    /* operator */ public final boolean component14() {
        return this.isLockForHelpCardEnabled;
    }

    /* operator */ public final RecentlyViewedTricks component15() {
        return this.recentlyViewed;
    }

    /* operator */ public final Dashboard.PottyProgramCard component16() {
        return this.pottyProgramCard;
    }

    /* operator */ public final Dashboard.BitingProgramCard component17() {
        return this.bitingProgramCard;
    }

    /* operator */ public final TrainingTimeMetrics component18() {
        return this.trainingMetrics;
    }

    /* operator */ public final boolean component19() {
        return this.pottyTrackerNewUiEnabled;
    }

    /* operator */ public final String component2() {
        return this.userLanguage;
    }

    /* operator */ public final List<Boolean> component20() {
        return this.pottyCheckmarks;
    }

    /* operator */ public final DashboardProgram component3() {
        return this.programItem;
    }

    /* operator */ public final CouponDiscount component4() {
        return this.couponDiscount;
    }

    /* operator */ public final Boolean component5() {
        return this.isUserPremium;
    }

    /* operator */ public final Boolean component6() {
        return this.isDogPremium;
    }

    /* operator */ public final boolean component7() {
        return this.userCancelledSubscription;
    }

    /* operator */ public final boolean component8() {
        return this.showWorkoutUnlocked;
    }

    /* operator */ public final WorkoutSession component9() {
        return this.workoutSession;
    }

    public final Dashboard copy(String dogId, String userLanguage, DashboardProgram programItem, CouponDiscount couponDiscount, Boolean isUserPremium, Boolean isDogPremium, boolean userCancelledSubscription, boolean showWorkoutUnlocked, WorkoutSession workoutSession, int updatedZendeskMessageCount, boolean hasZendeskHistory, boolean helpCardEnabled, List<? extends Dashboard.DashboardCardsEnum> cardsOrder, boolean isLockForHelpCardEnabled, RecentlyViewedTricks recentlyViewed, Dashboard.PottyProgramCard pottyProgramCard, Dashboard.BitingProgramCard bitingProgramCard, TrainingTimeMetrics trainingMetrics, boolean pottyTrackerNewUiEnabled, List<Boolean> pottyCheckmarks) {
        Object dogId2 = dogId;
        n.f(dogId2, "dogId");
        n.f(userLanguage, "userLanguage");
        n.f(cardsOrder, "cardsOrder");
        n.f(pottyCheckmarks, "pottyCheckmarks");
        Dashboard dashboard = new Dashboard(dogId2, userLanguage, programItem, couponDiscount, isUserPremium, isDogPremium, userCancelledSubscription, showWorkoutUnlocked, workoutSession, updatedZendeskMessageCount, hasZendeskHistory, helpCardEnabled, cardsOrder, isLockForHelpCardEnabled, recentlyViewed, pottyProgramCard, bitingProgramCard, trainingMetrics, pottyTrackerNewUiEnabled, pottyCheckmarks);
        return dashboard;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z15 = false;
        if (!(other instanceof Dashboard)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.userLanguage, other.userLanguage)) {
            return false;
        }
        if (!n.b(this.programItem, other.programItem)) {
            return false;
        }
        if (!n.b(this.couponDiscount, other.couponDiscount)) {
            return false;
        }
        if (!n.b(this.isUserPremium, other.isUserPremium)) {
            return false;
        }
        if (!n.b(this.isDogPremium, other.isDogPremium)) {
            return false;
        }
        if (this.userCancelledSubscription != other.userCancelledSubscription) {
            return false;
        }
        if (this.showWorkoutUnlocked != other.showWorkoutUnlocked) {
            return false;
        }
        if (!n.b(this.workoutSession, other.workoutSession)) {
            return false;
        }
        if (this.updatedZendeskMessageCount != other.updatedZendeskMessageCount) {
            return false;
        }
        if (this.hasZendeskHistory != other.hasZendeskHistory) {
            return false;
        }
        if (this.helpCardEnabled != other.helpCardEnabled) {
            return false;
        }
        if (!n.b(this.cardsOrder, other.cardsOrder)) {
            return false;
        }
        if (this.isLockForHelpCardEnabled != other.isLockForHelpCardEnabled) {
            return false;
        }
        if (!n.b(this.recentlyViewed, other.recentlyViewed)) {
            return false;
        }
        if (!n.b(this.pottyProgramCard, other.pottyProgramCard)) {
            return false;
        }
        if (!n.b(this.bitingProgramCard, other.bitingProgramCard)) {
            return false;
        }
        if (!n.b(this.trainingMetrics, other.trainingMetrics)) {
            return false;
        }
        if (this.pottyTrackerNewUiEnabled != other.pottyTrackerNewUiEnabled) {
            return false;
        }
        return !n.b(this.pottyCheckmarks, other.pottyCheckmarks) ? z15 : z;
    }

    public int hashCode() {
        int i;
        boolean userCancelledSubscription2;
        boolean showWorkoutUnlocked2;
        boolean hasZendeskHistory2;
        boolean helpCardEnabled2;
        boolean isLockForHelpCardEnabled2;
        boolean pottyTrackerNewUiEnabled2 = true;
        i = 0;
        if (this.programItem == null) {
        } else {
            i = this.programItem.hashCode();
        }
        if (this.couponDiscount == null) {
        } else {
            i = this.couponDiscount.hashCode();
        }
        if (this.isUserPremium == null) {
        } else {
            i = this.isUserPremium.hashCode();
        }
        if (this.isDogPremium == null) {
        } else {
            i = this.isDogPremium.hashCode();
        }
        int i2 = 1;
        if (this.userCancelledSubscription) {
        }
        if (this.showWorkoutUnlocked) {
        }
        if (this.workoutSession == null) {
        } else {
            i = this.workoutSession.hashCode();
        }
        if (this.hasZendeskHistory) {
        }
        if (this.helpCardEnabled) {
        }
        if (this.isLockForHelpCardEnabled) {
        }
        if (this.recentlyViewed == null) {
        } else {
            i = this.recentlyViewed.hashCode();
        }
        if (this.pottyProgramCard == null) {
        } else {
            i = this.pottyProgramCard.hashCode();
        }
        if (this.bitingProgramCard == null) {
        } else {
            i = this.bitingProgramCard.hashCode();
        }
        if (this.trainingMetrics != null) {
            i = this.trainingMetrics.hashCode();
        }
        if (!(this.pottyTrackerNewUiEnabled)) {
        }
        return (this.dogId.hashCode() * 31) + this.userLanguage.hashCode() * 31 + i * 31 + i * 31 + i * 31 + i * 31 + userCancelledSubscription2 * 31 + showWorkoutUnlocked2 * 31 + i * 31 + Integer.hashCode(this.updatedZendeskMessageCount) * 31 + hasZendeskHistory2 * 31 + helpCardEnabled2 * 31 + this.cardsOrder.hashCode() * 31 + isLockForHelpCardEnabled2 * 31 + i * 31 + i * 31 + i * 31 + i * 31 + pottyTrackerNewUiEnabled2 * 31 + this.pottyCheckmarks.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Dashboard(dogId=";
        String str3 = ", userLanguage=";
        String str4 = ", programItem=";
        String str5 = ", couponDiscount=";
        String str6 = ", isUserPremium=";
        String str7 = ", isDogPremium=";
        String str8 = ", userCancelledSubscription=";
        String str9 = ", showWorkoutUnlocked=";
        String str10 = ", workoutSession=";
        String str11 = ", updatedZendeskMessageCount=";
        String str12 = ", hasZendeskHistory=";
        String str13 = ", helpCardEnabled=";
        String str14 = ", cardsOrder=";
        String str15 = ", isLockForHelpCardEnabled=";
        String str16 = ", recentlyViewed=";
        String str17 = ", pottyProgramCard=";
        String str18 = ", bitingProgramCard=";
        String str19 = ", trainingMetrics=";
        String str20 = ", pottyTrackerNewUiEnabled=";
        String str21 = ", pottyCheckmarks=";
        str = str2 + this.dogId + str3 + this.userLanguage + str4 + this.programItem + str5 + this.couponDiscount + str6 + this.isUserPremium + str7 + this.isDogPremium + str8 + this.userCancelledSubscription + str9 + this.showWorkoutUnlocked + str10 + this.workoutSession + str11 + this.updatedZendeskMessageCount + str12 + this.hasZendeskHistory + str13 + this.helpCardEnabled + str14 + this.cardsOrder + str15 + this.isLockForHelpCardEnabled + str16 + this.recentlyViewed + str17 + this.pottyProgramCard + str18 + this.bitingProgramCard + str19 + this.trainingMetrics + str20 + this.pottyTrackerNewUiEnabled + str21 + this.pottyCheckmarks + 41;
        return str;
    }
}
