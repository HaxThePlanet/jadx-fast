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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008&\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0002OPB\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000f\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000fHÆ\u0003J\t\u00101\u001a\u00020\u0016HÆ\u0003J\t\u00102\u001a\u00020\u0016HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0008HÆ\u0003J\t\u00106\u001a\u00020\u0008HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\u000f\u00109\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\u008f\u0001\u0010;\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000f2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0016HÆ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001J\u0013\u0010>\u001a\u00020\u00162\u0008\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020=HÖ\u0001J\u0006\u0010B\u001a\u00020\u0016J\u0006\u0010C\u001a\u00020\u0016J\u0006\u0010D\u001a\u00020\u0016J\u0006\u0010E\u001a\u00020\u0016J\u0006\u0010F\u001a\u00020\u0016J\u0006\u0010G\u001a\u00020\u0016J\u0006\u0010H\u001a\u00020\u0016J\t\u0010I\u001a\u00020\u0008HÖ\u0001J\u0019\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020=HÖ\u0001R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010\u001d\"\u0004\u0008)\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001aR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.¨\u0006Q", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "currentLessonPositionData", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "nextLessonPositionData", "programName", "", "programColor", "lessonStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "tasks", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "question", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "cardList", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "programStarted", "", "isActiveProgram", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;Ljava/util/List;ZZ)V", "getCardList", "()Ljava/util/List;", "getCurrentLessonPositionData", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "()Z", "setActiveProgram", "(Z)V", "getLessonStatus", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "getNextLessonPositionData", "getProgramColor", "()Ljava/lang/String;", "getProgramName", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getProgramStarted", "setProgramStarted", "getQuestion", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "getTasks", "getTrainingSession", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "isLessonInProgress", "isLessonMastered", "isLessonPasses", "isNextLessonInDifferentModule", "isQuestionComplete", "isTaskComplete", "isTrainingComplete", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "LessonPositionData", "ProgramLessonStatus", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramLessonItem implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramLessonItem> CREATOR;
    private final List<app.dogo.com.dogo_android.repository.domain.LessonCardItem> cardList;
    private final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData currentLessonPositionData;
    private boolean isActiveProgram;
    private final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus lessonStatus;
    private final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData nextLessonPositionData;
    private final String programColor;
    private final String programName;
    private final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
    private boolean programStarted;
    private final app.dogo.com.dogo_android.repository.domain.ProgramQuestion question;
    private final List<app.dogo.com.dogo_android.repository.domain.ProgramTasks> tasks;
    private final app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramLessonItem> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem createFromParcel(Parcel parcel) {
            int fromParcel3;
            int i;
            int i2;
            Object fromParcel2;
            int i4;
            Object fromParcel;
            int i3;
            n.f(parcel, "parcel");
            Parcelable.Creator cREATOR2 = ProgramLessonItem.LessonPositionData.CREATOR;
            if (parcel.readInt() == 0) {
                fromParcel3 = 0;
            } else {
                fromParcel3 = cREATOR2.createFromParcel(parcel);
            }
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            int i5 = 0;
            i2 = i5;
            while (i2 != int) {
                arrayList.add(ProgramTasks.CREATOR.createFromParcel(parcel));
                i2++;
            }
            int int2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(int2);
            i4 = i5;
            while (i4 != int2) {
                arrayList2.add(LessonCardItem.CREATOR.createFromParcel(parcel));
                i4++;
            }
            int i7 = 1;
            i = parcel.readInt() != 0 ? i7 : i5;
            i3 = parcel.readInt() != 0 ? i7 : i5;
            super((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), (ProgramLessonItem.LessonPositionData)cREATOR2.createFromParcel(parcel), (ProgramLessonItem.LessonPositionData)fromParcel3, parcel.readString(), parcel.readString(), ProgramLessonItem.ProgramLessonStatus.valueOf(parcel.readString()), (TrainingSession)TrainingSession.CREATOR.createFromParcel(parcel), arrayList, (ProgramQuestion)ProgramQuestion.CREATOR.createFromParcel(parcel), arrayList2, i, i3);
            return obj15;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem[] newArray(int i) {
            return new ProgramLessonItem[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "Landroid/os/Parcelable;", "lessonId", "", "lessonNumber", "", "moduleNumber", "(Ljava/lang/String;II)V", "getLessonId", "()Ljava/lang/String;", "getLessonNumber", "()I", "getModuleNumber", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LessonPositionData implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData> CREATOR;
        private final String lessonId;
        private final int lessonNumber;
        private final int moduleNumber;
        static {
            ProgramLessonItem.LessonPositionData.Creator creator = new ProgramLessonItem.LessonPositionData.Creator();
            ProgramLessonItem.LessonPositionData.CREATOR = creator;
        }

        public LessonPositionData(String string, int i2, int i3) {
            n.f(string, "lessonId");
            super();
            this.lessonId = string;
            this.lessonNumber = i2;
            this.moduleNumber = i3;
        }

        public LessonPositionData(String string, int i2, int i3, int i4, g g5) {
            int obj3;
            int obj4;
            final int i = 0;
            obj3 = i4 & 2 != 0 ? i : obj3;
            obj4 = i4 &= 4 != 0 ? i : obj4;
            super(string, obj3, obj4);
        }

        public static app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData copy$default(app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData, String string2, int i3, int i4, int i5, Object object6) {
            String obj1;
            int obj2;
            int obj3;
            if (i5 & 1 != 0) {
                obj1 = lessonPositionData.lessonId;
            }
            if (i5 & 2 != 0) {
                obj2 = lessonPositionData.lessonNumber;
            }
            if (i5 &= 4 != 0) {
                obj3 = lessonPositionData.moduleNumber;
            }
            return lessonPositionData.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.lessonId;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.lessonNumber;
        }

        @Override // android.os.Parcelable
        public final int component3() {
            return this.moduleNumber;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData copy(String string, int i2, int i3) {
            n.f(string, "lessonId");
            ProgramLessonItem.LessonPositionData lessonPositionData = new ProgramLessonItem.LessonPositionData(string, i2, i3);
            return lessonPositionData;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof ProgramLessonItem.LessonPositionData == null) {
                return i2;
            }
            if (!n.b(this.lessonId, object.lessonId)) {
                return i2;
            }
            if (this.lessonNumber != object.lessonNumber) {
                return i2;
            }
            if (this.moduleNumber != object.moduleNumber) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getLessonId() {
            return this.lessonId;
        }

        @Override // android.os.Parcelable
        public final int getLessonNumber() {
            return this.lessonNumber;
        }

        @Override // android.os.Parcelable
        public final int getModuleNumber() {
            return this.moduleNumber;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LessonPositionData(lessonId=");
            stringBuilder.append(this.lessonId);
            stringBuilder.append(", lessonNumber=");
            stringBuilder.append(this.lessonNumber);
            stringBuilder.append(", moduleNumber=");
            stringBuilder.append(this.moduleNumber);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.lessonId);
            parcel.writeInt(this.lessonNumber);
            parcel.writeInt(this.moduleNumber);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "STARTED", "PASSED", "MASTERED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum ProgramLessonStatus {

        NOT_STARTED,
        STARTED,
        PASSED,
        MASTERED;
        private static final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus[] arr = new ProgramLessonItem.ProgramLessonStatus[4];
            return arr;
        }
    }
    static {
        ProgramLessonItem.Creator creator = new ProgramLessonItem.Creator();
        ProgramLessonItem.CREATOR = creator;
    }

    public ProgramLessonItem(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData2, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus6, app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession7, List<app.dogo.com.dogo_android.repository.domain.ProgramTasks> list8, app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion9, List<app.dogo.com.dogo_android.repository.domain.LessonCardItem> list10, boolean z11, boolean z12) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(lessonPositionData2, "currentLessonPositionData");
        n.f(string4, "programName");
        n.f(string5, "programColor");
        n.f(programLessonStatus6, "lessonStatus");
        n.f(trainingSession7, "trainingSession");
        n.f(list8, "tasks");
        n.f(programQuestion9, "question");
        n.f(list10, "cardList");
        super();
        this.programSaveInfo = programSaveInfo;
        this.currentLessonPositionData = lessonPositionData2;
        this.nextLessonPositionData = lessonPositionData3;
        this.programName = string4;
        this.programColor = string5;
        this.lessonStatus = programLessonStatus6;
        this.trainingSession = trainingSession7;
        this.tasks = list8;
        this.question = programQuestion9;
        this.cardList = list10;
        this.programStarted = z11;
        this.isActiveProgram = z12;
    }

    public ProgramLessonItem(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData2, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus6, app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession7, List list8, app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion9, List list10, boolean z11, boolean z12, int i13, g g14) {
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData lessonPositionData;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData lessonPositionData4;
        int i9;
        String lessonId;
        String str2;
        int i8;
        String str;
        int i4;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus nOT_STARTED;
        int i6;
        app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession;
        int i10;
        List list;
        int i11;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion;
        int i18;
        List list2;
        int i;
        int i14;
        int i17;
        int i19;
        int i3;
        int i7;
        int i5;
        int i12;
        int i15;
        int i16;
        int i2;
        int i20 = i13;
        if (i20 & 2 != 0) {
            super(programSaveInfo.getLessonId(), 0, 0, 6, 0);
        } else {
            lessonPositionData = lessonPositionData2;
        }
        i9 = i20 & 4 != 0 ? 0 : lessonPositionData3;
        str2 = i20 & 8 != 0 ? str : string4;
        if (i20 & 16 != 0) {
        } else {
            str = string5;
        }
        nOT_STARTED = i20 & 32 != 0 ? ProgramLessonItem.ProgramLessonStatus.NOT_STARTED : programLessonStatus6;
        if (i20 & 64 != 0) {
            super(0, 0, 0, 0, 15, 0);
        } else {
            trainingSession = trainingSession7;
        }
        if (i20 & 128 != 0) {
            list = p.g();
        } else {
            list = list8;
        }
        if (i20 & 256 != 0) {
            super(0, 0, 0, 0, 0, 0, 0, 127, 0);
        } else {
            programQuestion = programQuestion9;
        }
        if (i20 & 512 != 0) {
            list2 = p.g();
        } else {
            list2 = list10;
        }
        i14 = i20 & 1024 != 0 ? i19 : z11;
        if (i20 &= 2048 != 0) {
        } else {
            i19 = z12;
        }
        super(programSaveInfo, lessonPositionData, i9, str2, str, nOT_STARTED, trainingSession, list, programQuestion, list2, i14, i19);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramLessonItem copy$default(app.dogo.com.dogo_android.repository.domain.ProgramLessonItem programLessonItem, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo2, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData3, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData4, String string5, String string6, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus7, app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession8, List list9, app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion10, List list11, boolean z12, boolean z13, int i14, Object object15) {
        boolean isActiveProgram;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData currentLessonPositionData;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData nextLessonPositionData;
        String programName;
        String programColor;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus lessonStatus;
        app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession;
        List tasks;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion question;
        List cardList;
        boolean programStarted;
        Object obj = programLessonItem;
        int i = i14;
        programSaveInfo = i & 1 != 0 ? obj.programSaveInfo : programSaveInfo2;
        currentLessonPositionData = i & 2 != 0 ? obj.currentLessonPositionData : lessonPositionData3;
        nextLessonPositionData = i & 4 != 0 ? obj.nextLessonPositionData : lessonPositionData4;
        programName = i & 8 != 0 ? obj.programName : string5;
        programColor = i & 16 != 0 ? obj.programColor : string6;
        lessonStatus = i & 32 != 0 ? obj.lessonStatus : programLessonStatus7;
        trainingSession = i & 64 != 0 ? obj.trainingSession : trainingSession8;
        tasks = i & 128 != 0 ? obj.tasks : list9;
        question = i & 256 != 0 ? obj.question : programQuestion10;
        cardList = i & 512 != 0 ? obj.cardList : list11;
        programStarted = i & 1024 != 0 ? obj.programStarted : z12;
        isActiveProgram = i &= 2048 != 0 ? obj.isActiveProgram : z13;
        return programLessonItem.copy(programSaveInfo, currentLessonPositionData, nextLessonPositionData, programName, programColor, lessonStatus, trainingSession, tasks, question, cardList, programStarted, isActiveProgram);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LessonCardItem> component10() {
        return this.cardList;
    }

    @Override // android.os.Parcelable
    public final boolean component11() {
        return this.programStarted;
    }

    @Override // android.os.Parcelable
    public final boolean component12() {
        return this.isActiveProgram;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData component2() {
        return this.currentLessonPositionData;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData component3() {
        return this.nextLessonPositionData;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.programName;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.programColor;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus component6() {
        return this.lessonStatus;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrainingSession component7() {
        return this.trainingSession;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramTasks> component8() {
        return this.tasks;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion component9() {
        return this.question;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem copy(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData2, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData programLessonItem$LessonPositionData3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus programLessonItem$ProgramLessonStatus6, app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession7, List<app.dogo.com.dogo_android.repository.domain.ProgramTasks> list8, app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion9, List<app.dogo.com.dogo_android.repository.domain.LessonCardItem> list10, boolean z11, boolean z12) {
        n.f(programSaveInfo, "programSaveInfo");
        final Object obj = lessonPositionData2;
        n.f(obj, "currentLessonPositionData");
        final Object obj2 = string4;
        n.f(obj2, "programName");
        final Object obj3 = string5;
        n.f(obj3, "programColor");
        final Object obj4 = programLessonStatus6;
        n.f(obj4, "lessonStatus");
        final Object obj5 = trainingSession7;
        n.f(obj5, "trainingSession");
        final Object obj6 = list8;
        n.f(obj6, "tasks");
        final Object obj7 = programQuestion9;
        n.f(obj7, "question");
        final Object obj8 = list10;
        n.f(obj8, "cardList");
        super(programSaveInfo, obj, lessonPositionData3, obj2, obj3, obj4, obj5, obj6, obj7, obj8, z11, z12);
        return programLessonItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ProgramLessonItem) {
            return i2;
        }
        if (!n.b(this.programSaveInfo, object.programSaveInfo)) {
            return i2;
        }
        if (!n.b(this.currentLessonPositionData, object.currentLessonPositionData)) {
            return i2;
        }
        if (!n.b(this.nextLessonPositionData, object.nextLessonPositionData)) {
            return i2;
        }
        if (!n.b(this.programName, object.programName)) {
            return i2;
        }
        if (!n.b(this.programColor, object.programColor)) {
            return i2;
        }
        if (this.lessonStatus != object.lessonStatus) {
            return i2;
        }
        if (!n.b(this.trainingSession, object.trainingSession)) {
            return i2;
        }
        if (!n.b(this.tasks, object.tasks)) {
            return i2;
        }
        if (!n.b(this.question, object.question)) {
            return i2;
        }
        if (!n.b(this.cardList, object.cardList)) {
            return i2;
        }
        if (this.programStarted != object.programStarted) {
            return i2;
        }
        if (this.isActiveProgram != object.isActiveProgram) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LessonCardItem> getCardList() {
        return this.cardList;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData getCurrentLessonPositionData() {
        return this.currentLessonPositionData;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus getLessonStatus() {
        return this.lessonStatus;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData getNextLessonPositionData() {
        return this.nextLessonPositionData;
    }

    @Override // android.os.Parcelable
    public final String getProgramColor() {
        return this.programColor;
    }

    @Override // android.os.Parcelable
    public final String getProgramName() {
        return this.programName;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final boolean getProgramStarted() {
        return this.programStarted;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramQuestion getQuestion() {
        return this.question;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramTasks> getTasks() {
        return this.tasks;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrainingSession getTrainingSession() {
        return this.trainingSession;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i2;
        boolean programStarted;
        boolean i;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData nextLessonPositionData = this.nextLessonPositionData;
        if (nextLessonPositionData == null) {
            i2 = 0;
        } else {
            i2 = nextLessonPositionData.hashCode();
        }
        if (this.programStarted) {
            programStarted = i;
        }
        boolean isActiveProgram = this.isActiveProgram;
        if (isActiveProgram) {
        } else {
            i = isActiveProgram;
        }
        return i24 += i;
    }

    @Override // android.os.Parcelable
    public final boolean isActiveProgram() {
        return this.isActiveProgram;
    }

    @Override // android.os.Parcelable
    public final boolean isLessonInProgress() {
        boolean trainingComplete;
        int i;
        if (!isTrainingComplete() && !isQuestionComplete()) {
            if (!isQuestionComplete()) {
                if (isTaskComplete()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isLessonMastered() {
        int i;
        boolean trainingComplete;
        if (isTrainingComplete() && isQuestionComplete() && isTaskComplete()) {
            if (isQuestionComplete()) {
                i = isTaskComplete() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isLessonPasses() {
        boolean trainingComplete;
        int i;
        if (isTrainingComplete() && isQuestionComplete()) {
            i = isQuestionComplete() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isNextLessonInDifferentModule() {
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData nextLessonPositionData;
        int i;
        nextLessonPositionData = this.nextLessonPositionData;
        i = 0;
        if (nextLessonPositionData == null) {
        } else {
            if (this.currentLessonPositionData.getModuleNumber() == nextLessonPositionData.getModuleNumber()) {
                i = i3;
            }
        }
        return i ^ 1;
    }

    @Override // android.os.Parcelable
    public final boolean isQuestionComplete() {
        int i;
        i = this.question.getType() == ProgramQuestion.Type.ANSWERED ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isTaskComplete() {
        Object iterator;
        boolean empty;
        int i;
        app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type cOMPLETED;
        iterator = this.tasks;
        final int i2 = 1;
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
                i = i2;
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if ((ProgramTasks)iterator.next().getType() == ProgramTasks.Type.COMPLETED) {
                    } else {
                    }
                    empty = i;
                    if (empty) {
                        break;
                    }
                    empty = i2;
                }
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isTrainingComplete() {
        Object trainingTricksList;
        boolean empty;
        Object ratedByUser;
        int i;
        boolean newContent;
        trainingTricksList = this.trainingSession.getTrainingTricksList();
        final int i2 = 1;
        if (trainingTricksList instanceof Collection != null && trainingTricksList.isEmpty()) {
            if (trainingTricksList.isEmpty()) {
                i = i2;
            } else {
                trainingTricksList = trainingTricksList.iterator();
                while (trainingTricksList.hasNext()) {
                    ratedByUser = trainingTricksList.next();
                    if ((TrickItem)ratedByUser.getNewContent()) {
                    } else {
                    }
                    empty = i2;
                    if (empty) {
                        break;
                    }
                    if (ratedByUser.isRatedByUser()) {
                    } else {
                    }
                    empty = i;
                }
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final void setActiveProgram(boolean z) {
        this.isActiveProgram = z;
    }

    @Override // android.os.Parcelable
    public final void setProgramStarted(boolean z) {
        this.programStarted = z;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramLessonItem(programSaveInfo=");
        stringBuilder.append(this.programSaveInfo);
        stringBuilder.append(", currentLessonPositionData=");
        stringBuilder.append(this.currentLessonPositionData);
        stringBuilder.append(", nextLessonPositionData=");
        stringBuilder.append(this.nextLessonPositionData);
        stringBuilder.append(", programName=");
        stringBuilder.append(this.programName);
        stringBuilder.append(", programColor=");
        stringBuilder.append(this.programColor);
        stringBuilder.append(", lessonStatus=");
        stringBuilder.append(this.lessonStatus);
        stringBuilder.append(", trainingSession=");
        stringBuilder.append(this.trainingSession);
        stringBuilder.append(", tasks=");
        stringBuilder.append(this.tasks);
        stringBuilder.append(", question=");
        stringBuilder.append(this.question);
        stringBuilder.append(", cardList=");
        stringBuilder.append(this.cardList);
        stringBuilder.append(", programStarted=");
        stringBuilder.append(this.programStarted);
        stringBuilder.append(", isActiveProgram=");
        stringBuilder.append(this.isActiveProgram);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData nextLessonPositionData;
        int i;
        int size2;
        int size;
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, i2);
        this.currentLessonPositionData.writeToParcel(parcel, i2);
        nextLessonPositionData = this.nextLessonPositionData;
        if (nextLessonPositionData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            nextLessonPositionData.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.programName);
        parcel.writeString(this.programColor);
        parcel.writeString(this.lessonStatus.name());
        this.trainingSession.writeToParcel(parcel, i2);
        List tasks = this.tasks;
        parcel.writeInt(tasks.size());
        Iterator iterator = tasks.iterator();
        for (ProgramTasks size2 : iterator) {
            size2.writeToParcel(parcel, i2);
        }
        this.question.writeToParcel(parcel, i2);
        List cardList = this.cardList;
        parcel.writeInt(cardList.size());
        Iterator iterator2 = cardList.iterator();
        for (LessonCardItem size : iterator2) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.programStarted);
        parcel.writeInt(this.isActiveProgram);
    }
}
