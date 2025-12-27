package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ProgramLessonItem.kt */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008&\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0002OPB\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000f\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000fHÆ\u0003J\t\u00101\u001a\u00020\u0016HÆ\u0003J\t\u00102\u001a\u00020\u0016HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0008HÆ\u0003J\t\u00106\u001a\u00020\u0008HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\u000f\u00109\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\u008f\u0001\u0010;\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000f2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0016HÆ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001J\u0013\u0010>\u001a\u00020\u00162\u0008\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020=HÖ\u0001J\u0006\u0010B\u001a\u00020\u0016J\u0006\u0010C\u001a\u00020\u0016J\u0006\u0010D\u001a\u00020\u0016J\u0006\u0010E\u001a\u00020\u0016J\u0006\u0010F\u001a\u00020\u0016J\u0006\u0010G\u001a\u00020\u0016J\u0006\u0010H\u001a\u00020\u0016J\t\u0010I\u001a\u00020\u0008HÖ\u0001J\u0019\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020=HÖ\u0001R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010\u001d\"\u0004\u0008)\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001aR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.¨\u0006Q", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "currentLessonPositionData", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "nextLessonPositionData", "programName", "", "programColor", "lessonStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "tasks", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "question", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "cardList", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "programStarted", "", "isActiveProgram", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;Ljava/util/List;ZZ)V", "getCardList", "()Ljava/util/List;", "getCurrentLessonPositionData", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "()Z", "setActiveProgram", "(Z)V", "getLessonStatus", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "getNextLessonPositionData", "getProgramColor", "()Ljava/lang/String;", "getProgramName", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getProgramStarted", "setProgramStarted", "getQuestion", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "getTasks", "getTrainingSession", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "isLessonInProgress", "isLessonMastered", "isLessonPasses", "isNextLessonInDifferentModule", "isQuestionComplete", "isTaskComplete", "isTrainingComplete", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "LessonPositionData", "ProgramLessonStatus", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramLessonItem implements Parcelable {

    public static final Parcelable.Creator<ProgramLessonItem> CREATOR = new ProgramLessonItem$Creator<>();
    private final List<LessonCardItem> cardList;
    private final ProgramLessonItem.LessonPositionData currentLessonPositionData;
    private boolean isActiveProgram;
    private final ProgramLessonItem.ProgramLessonStatus lessonStatus;
    private final ProgramLessonItem.LessonPositionData nextLessonPositionData;
    private final String programColor;
    private final String programName;
    private final ProgramSaveInfo programSaveInfo;
    private boolean programStarted;
    private final ProgramQuestion question;
    private final List<ProgramTasks> tasks;
    private final TrainingSession trainingSession;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramLessonItem> {
        @Override // android.os.Parcelable$Creator
        public final ProgramLessonItem createFromParcel(Parcel parcel) {
            int i = 0;
            int i2;
            boolean z2;
            n.f(parcel, "parcel");
            Parcelable.Creator cREATOR22 = ProgramLessonItem_LessonPositionData.CREATOR;
            if (parcel.readInt() == 0) {
                i = 0;
            } else {
                Object fromParcel6 = ProgramLessonItem_LessonPositionData.CREATOR.createFromParcel(parcel);
            }
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i2 = 0;
            while (i2 != TrainingSession.CREATOR) {
                arrayList.add(ProgramTasks.CREATOR.createFromParcel(parcel));
                i2 = i2 + 1;
            }
            int _int2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(_int2);
            while (i2 != ProgramSaveInfo.CREATOR) {
                arrayList2.add(LessonCardItem.CREATOR.createFromParcel(parcel));
                i2 = i2 + 1;
            }
            i2 = 1;
            int r0 = i2;
            int r13 = i2;
            ProgramLessonItem parcel2 = new ProgramLessonItem((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), (ProgramLessonItem_LessonPositionData)cREATOR22.createFromParcel(parcel), (ProgramLessonItem_LessonPositionData)i, parcel.readString(), parcel.readString(), ProgramLessonItem_ProgramLessonStatus.valueOf(parcel.readString()), (TrainingSession)TrainingSession.CREATOR.createFromParcel(parcel), arrayList, (ProgramQuestion)ProgramQuestion.CREATOR.createFromParcel(parcel), arrayList2, i2, i2);
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramLessonItem[] newArray(int i) {
            return new ProgramLessonItem[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "Landroid/os/Parcelable;", "lessonId", "", "lessonNumber", "", "moduleNumber", "(Ljava/lang/String;II)V", "getLessonId", "()Ljava/lang/String;", "getLessonNumber", "()I", "getModuleNumber", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LessonPositionData implements Parcelable {

        public static final Parcelable.Creator<ProgramLessonItem.LessonPositionData> CREATOR = new ProgramLessonItem$LessonPositionData$Creator<>();
        private final String lessonId;
        private final int lessonNumber;
        private final int moduleNumber;
        public LessonPositionData(String str, int i, int i2) {
            n.f(str, "lessonId");
            super();
            this.lessonId = str;
            this.lessonNumber = i;
            this.moduleNumber = i2;
        }

        public final String getLessonId() {
            return this.lessonId;
        }

        public final int getLessonNumber() {
            return this.lessonNumber;
        }

        public final int getModuleNumber() {
            return this.moduleNumber;
        }

        public /* synthetic */ LessonPositionData(String str, int i, int i2, int i3, g gVar) {
            i = 0;
            i = i3 & 2 != 0 ? i : i;
            i = i3 & 4 != 0 ? i : i;
            this(str, i, i);
        }


        public static /* synthetic */ ProgramLessonItem.LessonPositionData copy$default(ProgramLessonItem.LessonPositionData lessonPositionData, String str, int i, int i2, int i3, Object object) {
            String lessonId2;
            int lessonNumber2;
            int moduleNumber2;
            if (i3 & 1 != 0) {
            }
            if (i3 & 2 != 0) {
            }
            if (i3 & 4 != 0) {
            }
            return lessonPositionData.copy(lessonId2, lessonNumber2, moduleNumber2);
        }

        /* operator */ public final String component1() {
            return this.lessonId;
        }

        /* operator */ public final int component2() {
            return this.lessonNumber;
        }

        /* operator */ public final int component3() {
            return this.moduleNumber;
        }

        public final ProgramLessonItem.LessonPositionData copy(String lessonId, int lessonNumber, int moduleNumber) {
            n.f(lessonId, "lessonId");
            return new ProgramLessonItem_LessonPositionData(lessonId, lessonNumber, moduleNumber);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof ProgramLessonItem_LessonPositionData)) {
                return false;
            }
            if (!n.b(this.lessonId, other.lessonId)) {
                return false;
            }
            if (this.lessonNumber != other.lessonNumber) {
                return false;
            }
            return this.moduleNumber != other.moduleNumber ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.lessonId.hashCode() * 31) + Integer.hashCode(this.lessonNumber) * 31 + Integer.hashCode(this.moduleNumber);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LessonPositionData(lessonId=";
            String str3 = ", lessonNumber=";
            String str4 = ", moduleNumber=";
            str = str2 + this.lessonId + str3 + this.lessonNumber + str4 + this.moduleNumber + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.lessonId);
            parcel.writeInt(this.lessonNumber);
            parcel.writeInt(this.moduleNumber);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "STARTED", "PASSED", "MASTERED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ProgramLessonStatus {

        MASTERED,
        NOT_STARTED,
        PASSED,
        STARTED;
        private static final /* synthetic */ ProgramLessonItem.ProgramLessonStatus[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus[] arr = new ProgramLessonItem.ProgramLessonStatus[4];
            return new ProgramLessonItem.ProgramLessonStatus[] { ProgramLessonItem_ProgramLessonStatus.NOT_STARTED, ProgramLessonItem_ProgramLessonStatus.STARTED, ProgramLessonItem_ProgramLessonStatus.PASSED, ProgramLessonItem_ProgramLessonStatus.MASTERED };
        }
    }
    public ProgramLessonItem(ProgramSaveInfo programSaveInfo, ProgramLessonItem.LessonPositionData lessonPositionData, ProgramLessonItem.LessonPositionData lessonPositionData2, String str, String str2, ProgramLessonItem.ProgramLessonStatus programLessonStatus, TrainingSession trainingSession, List<ProgramTasks> list, ProgramQuestion programQuestion, List<LessonCardItem> list2, boolean z, boolean z2) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(lessonPositionData, "currentLessonPositionData");
        n.f(str, "programName");
        n.f(str2, "programColor");
        n.f(programLessonStatus, "lessonStatus");
        n.f(trainingSession, "trainingSession");
        n.f(list, "tasks");
        n.f(programQuestion, "question");
        n.f(list2, "cardList");
        super();
        this.programSaveInfo = programSaveInfo;
        this.currentLessonPositionData = lessonPositionData;
        this.nextLessonPositionData = lessonPositionData2;
        this.programName = str;
        this.programColor = str2;
        this.lessonStatus = programLessonStatus;
        this.trainingSession = trainingSession;
        this.tasks = list;
        this.question = programQuestion;
        this.cardList = list2;
        this.programStarted = z;
        this.isActiveProgram = z2;
    }

    public final List<LessonCardItem> getCardList() {
        return this.cardList;
    }

    public final ProgramLessonItem.LessonPositionData getCurrentLessonPositionData() {
        return this.currentLessonPositionData;
    }

    public final ProgramLessonItem.ProgramLessonStatus getLessonStatus() {
        return this.lessonStatus;
    }

    public final ProgramLessonItem.LessonPositionData getNextLessonPositionData() {
        return this.nextLessonPositionData;
    }

    public final String getProgramColor() {
        return this.programColor;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    public final boolean getProgramStarted() {
        return this.programStarted;
    }

    public final ProgramQuestion getQuestion() {
        return this.question;
    }

    public final List<ProgramTasks> getTasks() {
        return this.tasks;
    }

    public final TrainingSession getTrainingSession() {
        return this.trainingSession;
    }

    public final boolean isActiveProgram() {
        return this.isActiveProgram;
    }

    public final boolean isLessonInProgress() {
        boolean z = false;
        if (isTrainingComplete() || !(this.isQuestionComplete() && !this.isTaskComplete())) {
            int i2 = 1;
        }
        return z;
    }

    public final boolean isLessonMastered() {
        boolean z = true;
        int r0 = isTrainingComplete() && this.isQuestionComplete() && this.isTaskComplete() ? 1 : 0;
        return (isTrainingComplete() && this.isQuestionComplete() && this.isTaskComplete() ? 1 : 0);
    }

    public final boolean isLessonPasses() {
        boolean z = false;
        int r0 = isTrainingComplete() && this.isQuestionComplete() ? 1 : 0;
        return (isTrainingComplete() && this.isQuestionComplete() ? 1 : 0);
    }

    public final boolean isNextLessonInDifferentModule() {
        int i = 0;
        i = 0;
        if (this.nextLessonPositionData != null) {
            if (this.currentLessonPositionData.getModuleNumber() == this.nextLessonPositionData.getModuleNumber()) {
                i = 1;
            }
        }
        return i ^ 1;
    }

    public final boolean isQuestionComplete() {
        boolean z = true;
        int r0 = this.question.getType() == ProgramQuestion_Type.ANSWERED ? 1 : 0;
        return (this.question.getType() == ProgramQuestion_Type.ANSWERED ? 1 : 0);
    }

    public final boolean isTaskComplete() {
        Iterator it;
        boolean hasNext;
        boolean z = false;
        app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type cOMPLETED2;
        hasNext = tasks2 instanceof Collection;
        final int i2 = 1;
        int r2 = i2;
        return i2;
    }

    public final boolean isTrainingComplete() {
        Iterator it;
        boolean hasNext;
        boolean z = false;
        boolean newContent;
        List trainingTricksList = this.trainingSession.getTrainingTricksList();
        hasNext = trainingTricksList instanceof Collection;
        final int i2 = 1;
        int r2 = i2;
        return i2;
    }

    public final void setActiveProgram(boolean z) {
        this.isActiveProgram = z;
    }

    public final void setProgramStarted(boolean z) {
        this.programStarted = z;
    }

    public /* synthetic */ ProgramLessonItem(ProgramSaveInfo programSaveInfo, ProgramLessonItem.LessonPositionData lessonPositionData, ProgramLessonItem.LessonPositionData lessonPositionData2, String str, String str2, ProgramLessonItem.ProgramLessonStatus programLessonStatus, TrainingSession trainingSession, List list, ProgramQuestion programQuestion, List list2, boolean z, boolean z2, int i, g gVar) {
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData lessonPositionData22;
        int lessonPositionData32 = 0;
        String str42;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus programLessonStatus62;
        app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession72;
        List list82;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion92;
        List list102;
        int z112;
        int i4 = 15;
        g gVar2 = null;
        int i132 = i;
        if (i132 & 2 != 0) {
            i = 0;
            int i2 = 0;
            int i3 = 6;
            gVar = null;
            super(programSaveInfo.getLessonId(), i, i2, i3, gVar);
        } else {
            lessonPositionData22 = lessonPositionData;
        }
        int r2 = i132 & 4 != 0 ? 0 : lessonPositionData2;
        str42 = "";
        String r3 = i132 & 8 != 0 ? "" : str;
        if (i132 & 16 == 0) {
            str42 = str2;
        }
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus r5 = i132 & 32 != 0 ? ProgramLessonItem_ProgramLessonStatus.NOT_STARTED : programLessonStatus;
        if (i132 & 64 != 0) {
            list = null;
            list2 = null;
            z = false;
            z2 = false;
            i4 = 15;
            gVar2 = null;
            super(list, list2, z, z2, i4, gVar2);
        } else {
            trainingSession72 = trainingSession;
        }
        if (i132 & 128 != 0) {
            list82 = p.g();
        } else {
            list82 = list;
        }
        if (i132 & 256 != 0) {
            str = null;
            str2 = null;
            String str3 = null;
            String str6 = null;
            List list3 = null;
            int i5 = 0;
            app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type type = null;
            int i6 = 127;
            g gVar3 = null;
            super(str, str2, str3, str6, list3, i5, type, i6, gVar3);
        } else {
            programQuestion92 = programQuestion;
        }
        if (i132 & 512 != 0) {
            list102 = p.g();
        } else {
            list102 = list2;
        }
        z112 = 0;
        int r10 = i132 & 1024 != 0 ? 0 : z;
        if (i132 & 2048 == 0) {
            z112 = z2;
        }
        this(programSaveInfo, lessonPositionData22, lessonPositionData32, str42, str42, programLessonStatus62, trainingSession72, list82, programQuestion92, list102, z112, z112);
    }


    public static /* synthetic */ ProgramLessonItem copy$default(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo, ProgramLessonItem.LessonPositionData lessonPositionData, ProgramLessonItem.LessonPositionData lessonPositionData2, String str, String str2, ProgramLessonItem.ProgramLessonStatus programLessonStatus, TrainingSession trainingSession, List list, ProgramQuestion programQuestion, List list2, boolean z, boolean z2, int i, Object object) {
        boolean z132;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo22;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData lessonPositionData32;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData lessonPositionData42;
        String str52;
        String str62;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus programLessonStatus72;
        app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession82;
        List list92;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion102;
        List list112;
        boolean z122;
        Object programLessonItem2 = programLessonItem;
        int i142 = i;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo r2 = i142 & 1 != 0 ? programLessonItem2.programSaveInfo : programSaveInfo;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData r3 = i142 & 2 != 0 ? programLessonItem2.currentLessonPositionData : lessonPositionData;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData r4 = i142 & 4 != 0 ? programLessonItem2.nextLessonPositionData : lessonPositionData2;
        String r5 = i142 & 8 != 0 ? programLessonItem2.programName : str;
        String r6 = i142 & 16 != 0 ? programLessonItem2.programColor : str2;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus r7 = i142 & 32 != 0 ? programLessonItem2.lessonStatus : programLessonStatus;
        app.dogo.com.dogo_android.repository.domain.TrainingSession r8 = i142 & 64 != 0 ? programLessonItem2.trainingSession : trainingSession;
        List r9 = i142 & 128 != 0 ? programLessonItem2.tasks : list;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion r10 = i142 & 256 != 0 ? programLessonItem2.question : programQuestion;
        List r11 = i142 & 512 != 0 ? programLessonItem2.cardList : list2;
        boolean r12 = i142 & 1024 != 0 ? programLessonItem2.programStarted : z;
        boolean r1 = i142 & 2048 != 0 ? programLessonItem2.isActiveProgram : z2;
        return programLessonItem.copy(programSaveInfo22, lessonPositionData32, lessonPositionData42, str52, str62, programLessonStatus72, trainingSession82, list92, programQuestion102, list112, z122, (i142 & 2048 != 0 ? programLessonItem2.isActiveProgram : z2));
    }

    /* operator */ public final ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    /* operator */ public final List<LessonCardItem> component10() {
        return this.cardList;
    }

    /* operator */ public final boolean component11() {
        return this.programStarted;
    }

    /* operator */ public final boolean component12() {
        return this.isActiveProgram;
    }

    /* operator */ public final ProgramLessonItem.LessonPositionData component2() {
        return this.currentLessonPositionData;
    }

    /* operator */ public final ProgramLessonItem.LessonPositionData component3() {
        return this.nextLessonPositionData;
    }

    /* operator */ public final String component4() {
        return this.programName;
    }

    /* operator */ public final String component5() {
        return this.programColor;
    }

    /* operator */ public final ProgramLessonItem.ProgramLessonStatus component6() {
        return this.lessonStatus;
    }

    /* operator */ public final TrainingSession component7() {
        return this.trainingSession;
    }

    /* operator */ public final List<ProgramTasks> component8() {
        return this.tasks;
    }

    /* operator */ public final ProgramQuestion component9() {
        return this.question;
    }

    public final ProgramLessonItem copy(ProgramSaveInfo programSaveInfo, ProgramLessonItem.LessonPositionData currentLessonPositionData, ProgramLessonItem.LessonPositionData nextLessonPositionData, String programName, String programColor, ProgramLessonItem.ProgramLessonStatus lessonStatus, TrainingSession trainingSession, List<ProgramTasks> tasks, ProgramQuestion question, List<LessonCardItem> cardList, boolean programStarted, boolean isActiveProgram) {
        n.f(programSaveInfo, "programSaveInfo");
        final Object currentLessonPositionData2 = currentLessonPositionData;
        n.f(currentLessonPositionData2, "currentLessonPositionData");
        final Object programName2 = programName;
        n.f(programName2, "programName");
        final Object programColor2 = programColor;
        n.f(programColor2, "programColor");
        final Object lessonStatus2 = lessonStatus;
        n.f(lessonStatus2, "lessonStatus");
        final Object trainingSession2 = trainingSession;
        n.f(trainingSession2, "trainingSession");
        final Object tasks2 = tasks;
        n.f(tasks2, "tasks");
        final Object question2 = question;
        n.f(question2, "question");
        final Object cardList2 = cardList;
        n.f(cardList2, "cardList");
        ProgramLessonItem programLessonItem = new ProgramLessonItem(programSaveInfo, currentLessonPositionData2, nextLessonPositionData, programName2, programColor2, lessonStatus2, trainingSession2, tasks2, question2, cardList2, programStarted, isActiveProgram);
        return programLessonItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z12 = false;
        if (!(other instanceof ProgramLessonItem)) {
            return false;
        }
        if (!n.b(this.programSaveInfo, other.programSaveInfo)) {
            return false;
        }
        if (!n.b(this.currentLessonPositionData, other.currentLessonPositionData)) {
            return false;
        }
        if (!n.b(this.nextLessonPositionData, other.nextLessonPositionData)) {
            return false;
        }
        if (!n.b(this.programName, other.programName)) {
            return false;
        }
        if (!n.b(this.programColor, other.programColor)) {
            return false;
        }
        if (this.lessonStatus != other.lessonStatus) {
            return false;
        }
        if (!n.b(this.trainingSession, other.trainingSession)) {
            return false;
        }
        if (!n.b(this.tasks, other.tasks)) {
            return false;
        }
        if (!n.b(this.question, other.question)) {
            return false;
        }
        if (!n.b(this.cardList, other.cardList)) {
            return false;
        }
        if (this.programStarted != other.programStarted) {
            return false;
        }
        return this.isActiveProgram != other.isActiveProgram ? z12 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        boolean programStarted2;
        boolean isActiveProgram2 = true;
        if (this.nextLessonPositionData == null) {
            i = 0;
        } else {
            i = this.nextLessonPositionData.hashCode();
        }
        if (this.programStarted) {
        }
        if (!(this.isActiveProgram)) {
        }
        return (this.programSaveInfo.hashCode() * 31) + this.currentLessonPositionData.hashCode() * 31 + i * 31 + this.programName.hashCode() * 31 + this.programColor.hashCode() * 31 + this.lessonStatus.hashCode() * 31 + this.trainingSession.hashCode() * 31 + this.tasks.hashCode() * 31 + this.question.hashCode() * 31 + this.cardList.hashCode() * 31 + programStarted2 * 31 + isActiveProgram2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramLessonItem(programSaveInfo=";
        String str3 = ", currentLessonPositionData=";
        String str4 = ", nextLessonPositionData=";
        String str5 = ", programName=";
        String str6 = ", programColor=";
        String str7 = ", lessonStatus=";
        String str8 = ", trainingSession=";
        String str9 = ", tasks=";
        String str10 = ", question=";
        String str11 = ", cardList=";
        String str12 = ", programStarted=";
        String str13 = ", isActiveProgram=";
        str = str2 + this.programSaveInfo + str3 + this.currentLessonPositionData + str4 + this.nextLessonPositionData + str5 + this.programName + str6 + this.programColor + str7 + this.lessonStatus + str8 + this.trainingSession + str9 + this.tasks + str10 + this.question + str11 + this.cardList + str12 + this.programStarted + str13 + this.isActiveProgram + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, flags);
        this.currentLessonPositionData.writeToParcel(parcel, flags);
        if (this.nextLessonPositionData == null) {
            parcel.writeInt(0);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.nextLessonPositionData.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.programName);
        parcel.writeString(this.programColor);
        parcel.writeString(this.lessonStatus.name());
        this.trainingSession.writeToParcel(parcel, flags);
        parcel.writeInt(this.tasks.size());
        Iterator it = this.tasks.iterator();
        while (it.hasNext()) {
            (ProgramTasks)it.next().writeToParcel(parcel, flags);
        }
        this.question.writeToParcel(parcel, flags);
        parcel.writeInt(this.cardList.size());
        Iterator it2 = this.cardList.iterator();
        while (it2.hasNext()) {
            (LessonCardItem)it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.programStarted);
        parcel.writeInt(this.isActiveProgram);
    }
}
