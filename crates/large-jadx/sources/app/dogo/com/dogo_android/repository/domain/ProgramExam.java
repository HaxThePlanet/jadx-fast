package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008H\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 e2\u00020\u0001:\u0002efBÙ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0014\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u001eJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0011HÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010G\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0014HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003Jø\u0001\u0010X\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r2\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00052\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00142\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010YJ\t\u0010Z\u001a\u00020\u0011HÖ\u0001J\u0013\u0010[\u001a\u00020\u00142\u0008\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u0011HÖ\u0001J\t\u0010_\u001a\u00020\u0005HÖ\u0001J\u0019\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010 R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010 R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008'\u0010(R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\u0008*\u0010(\"\u0004\u0008+\u0010,R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008\u001d\u0010(R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010 R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010 R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\u00083\u00104R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00107R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010 R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010 R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\u0008<\u00104R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010 ¨\u0006g", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickId", "", "trickImageUrl", "videoUrl", "thumbnailUrl", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "name", "orderDate", "", "reviewComment", "description", "examTimeLimit", "", "timestamp", "hasNewFeedback", "", "hasNewUpdates", "unlockDate", "evaluatedByAvatar", "evaluatedByName", "reviewTimeMs", "examId", "evaluatedByEmail", "userFeedbackSubmitted", "isRetakable", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;IJLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "getDescription", "()Ljava/lang/String;", "getEvaluatedByAvatar", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getExamTimeLimit", "()I", "getHasNewFeedback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasNewUpdates", "setHasNewUpdates", "(Ljava/lang/Boolean;)V", "getName", "getOrderDate", "()J", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getReviewComment", "getReviewTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "getThumbnailUrl", "getTimestamp", "getTrickId", "getTrickImageUrl", "getUnlockDate", "getUserFeedbackSubmitted", "()Z", "setUserFeedbackSubmitted", "(Z)V", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;IJLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Status", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramExam implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramExam> CREATOR = null;
    public static final app.dogo.com.dogo_android.repository.domain.ProgramExam.Companion Companion = null;
    public static final int EXAM_TIME_FALLBACK_IN_SECONDS = 30;
    private final String description;
    private final String evaluatedByAvatar;
    private final String evaluatedByEmail;
    private final String evaluatedByName;
    private final String examId;
    private final int examTimeLimit;
    private final Boolean hasNewFeedback;
    private Boolean hasNewUpdates;
    private final Boolean isRetakable;
    private final String name;
    private final long orderDate;
    private final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
    private final String reviewComment;
    private final Long reviewTimeMs;
    private final app.dogo.com.dogo_android.repository.domain.ProgramExam.Status status;
    private final String thumbnailUrl;
    private final long timestamp;
    private final String trickId;
    private final String trickImageUrl;
    private final Long unlockDate;
    private boolean userFeedbackSubmitted;
    private final String videoUrl;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Companion;", "", "()V", "EXAM_TIME_FALLBACK_IN_SECONDS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramExam> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramExam createFromParcel(Parcel parcel) {
            int valueOf5;
            int valueOf;
            int valueOf3;
            Long valueOf2;
            Long valueOf4;
            int i3;
            int i6;
            int i2;
            int i5;
            int i4;
            Long num2;
            Long num;
            int i;
            Object obj = parcel;
            n.f(obj, "parcel");
            i2 = 1;
            int i8 = 0;
            int i10 = 0;
            if (parcel.readInt() == 0) {
                i5 = i10;
            } else {
                i6 = parcel.readInt() != 0 ? i2 : i8;
                i5 = valueOf;
            }
            if (parcel.readInt() == 0) {
                i4 = i10;
            } else {
                i3 = parcel.readInt() != 0 ? i2 : i8;
                i4 = valueOf3;
            }
            if (parcel.readInt() == 0) {
                num2 = i10;
            } else {
                num2 = valueOf2;
            }
            if (parcel.readInt() == 0) {
                num = i10;
            } else {
                num = valueOf4;
            }
            i = parcel.readInt() != 0 ? i2 : i8;
            if (parcel.readInt() == 0) {
                valueOf5 = i10;
            } else {
                if (parcel.readInt() != 0) {
                } else {
                    i2 = i8;
                }
                valueOf5 = Boolean.valueOf(i2);
            }
            super((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(obj), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ProgramExam.Status.valueOf(parcel.readString()), parcel.readString(), parcel.readLong(), obj11, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), obj16, i5, i4, num2, parcel.readString(), parcel.readString(), num, parcel.readString(), parcel.readString(), i, valueOf5);
            return programExam;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramExam[] newArray(int i) {
            return new ProgramExam[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "", "(Ljava/lang/String;I)V", "LOCKED", "READY", "PENDING", "REJECTED", "APPROVED", "AVAILABLE_HEADER", "UNAVAILABLE_HEADER", "PREMIUM_LOCKED", "PROGRESS_HEADER", "CERTIFICATE_HEADER", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum Status {

        LOCKED,
        READY,
        PENDING,
        REJECTED,
        APPROVED,
        AVAILABLE_HEADER,
        UNAVAILABLE_HEADER,
        PREMIUM_LOCKED,
        PROGRESS_HEADER,
        CERTIFICATE_HEADER;
        private static final app.dogo.com.dogo_android.repository.domain.ProgramExam.Status[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramExam.Status[] arr = new ProgramExam.Status[10];
            return arr;
        }
    }
    static {
        ProgramExam.Companion companion = new ProgramExam.Companion(0);
        ProgramExam.Companion = companion;
        ProgramExam.Creator creator = new ProgramExam.Creator();
        ProgramExam.CREATOR = creator;
    }

    public ProgramExam(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, String string2, String string3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.ProgramExam.Status programExam$Status6, String string7, long l8, String string9, String string10, int i11, long l12, Boolean boolean13, Boolean boolean14, Long long15, String string16, String string17, Long long18, String string19, String string20, boolean z21, Boolean boolean22) {
        final Object obj = this;
        final Object obj2 = string3;
        final Object obj3 = string4;
        final Object obj4 = string5;
        final Object obj5 = status6;
        final Object obj6 = string7;
        final Object obj7 = string10;
        final Object obj8 = i11;
        final Object obj9 = long18;
        final Object obj10 = string19;
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string2, "trickId");
        n.f(obj2, "trickImageUrl");
        n.f(obj3, "videoUrl");
        n.f(obj4, "thumbnailUrl");
        n.f(obj5, "status");
        n.f(obj6, "name");
        n.f(obj7, "reviewComment");
        n.f(obj8, "description");
        n.f(obj9, "evaluatedByAvatar");
        n.f(obj10, "evaluatedByName");
        super();
        obj.programSaveInfo = programSaveInfo;
        obj.trickId = string2;
        obj.trickImageUrl = obj2;
        obj.videoUrl = obj3;
        obj.thumbnailUrl = obj4;
        obj.status = obj5;
        obj.name = obj6;
        obj.orderDate = l8;
        obj.reviewComment = obj7;
        obj.description = obj8;
        obj.examTimeLimit = l12;
        obj.timestamp = boolean13;
        obj.hasNewFeedback = long15;
        obj.hasNewUpdates = string16;
        obj.unlockDate = string17;
        obj.evaluatedByAvatar = obj9;
        obj.evaluatedByName = obj10;
        obj.reviewTimeMs = string20;
        obj.examId = z21;
        obj.evaluatedByEmail = boolean22;
        obj.userFeedbackSubmitted = obj36;
        obj.isRetakable = obj37;
    }

    public ProgramExam(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, String string2, String string3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.ProgramExam.Status programExam$Status6, String string7, long l8, String string9, String string10, int i11, long l12, Boolean boolean13, Boolean boolean14, Long long15, String string16, String string17, Long long18, String string19, String string20, boolean z21, Boolean boolean22, int i23, g g24) {
        Boolean fALSE2;
        int fALSE3;
        int fALSE;
        int valueOf;
        int i5;
        int i3;
        Boolean bool3;
        Boolean bool2;
        int i2;
        String str2;
        String str;
        Long num;
        int i;
        int i6;
        int i4;
        Boolean bool;
        int i7 = obj54;
        final int i22 = 0;
        i3 = i7 & 2048 != 0 ? i22 : boolean13;
        bool3 = i7 & 4096 != 0 ? fALSE3 : long15;
        bool2 = i7 & 8192 != 0 ? fALSE : string16;
        int i24 = 0;
        i2 = i7 & 16384 != 0 ? i24 : string17;
        String str3 = "";
        str2 = i10 &= i7 != 0 ? str3 : long18;
        str = i13 &= i7 != 0 ? str3 : string19;
        if (i15 &= i7 != 0) {
            num = valueOf;
        } else {
            num = string20;
        }
        i = i16 &= i7 != 0 ? i24 : z21;
        i6 = i18 &= i7 != 0 ? i24 : boolean22;
        i4 = i20 &= i7 != 0 ? i5 : i23;
        bool = i7 &= i21 != 0 ? fALSE2 : g24;
        super(programSaveInfo, string2, string3, string4, string5, status6, string7, l8, obj13, string10, i11, l12, i3, obj18, bool3, bool2, i2, str2, str, num, i, i6, i4, bool);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramExam copy$default(app.dogo.com.dogo_android.repository.domain.ProgramExam programExam, app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo2, String string3, String string4, String string5, String string6, app.dogo.com.dogo_android.repository.domain.ProgramExam.Status programExam$Status7, String string8, long l9, String string10, String string11, int i12, long l13, Boolean boolean14, Boolean boolean15, Long long16, String string17, String string18, Long long19, String string20, String string21, boolean z22, Boolean boolean23, int i24, Object object25) {
        Boolean isRetakable;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
        String trickId;
        String trickImageUrl;
        String videoUrl;
        String thumbnailUrl;
        app.dogo.com.dogo_android.repository.domain.ProgramExam.Status status;
        String name;
        long orderDate;
        String reviewComment;
        String description;
        int examTimeLimit;
        long timestamp;
        Boolean hasNewFeedback;
        Boolean hasNewUpdates;
        Long unlockDate;
        String evaluatedByAvatar;
        String evaluatedByName;
        Long reviewTimeMs;
        String examId;
        String evaluatedByEmail;
        boolean userFeedbackSubmitted;
        Object obj = programExam;
        int i = obj42;
        programSaveInfo = i & 1 != 0 ? obj.programSaveInfo : programSaveInfo2;
        trickId = i & 2 != 0 ? obj.trickId : string3;
        trickImageUrl = i & 4 != 0 ? obj.trickImageUrl : string4;
        videoUrl = i & 8 != 0 ? obj.videoUrl : string5;
        thumbnailUrl = i & 16 != 0 ? obj.thumbnailUrl : string6;
        status = i & 32 != 0 ? obj.status : status7;
        name = i & 64 != 0 ? obj.name : string8;
        orderDate = i & 128 != 0 ? obj.orderDate : l9;
        reviewComment = i & 256 != 0 ? obj.reviewComment : string11;
        description = i & 512 != 0 ? obj.description : i12;
        examTimeLimit = i & 1024 != 0 ? obj.examTimeLimit : l13;
        timestamp = i & 2048 != 0 ? obj.timestamp : boolean14;
        hasNewFeedback = i & 4096 != 0 ? obj.hasNewFeedback : long16;
        hasNewUpdates = i & 8192 != 0 ? obj.hasNewUpdates : string17;
        unlockDate = i & 16384 != 0 ? obj.unlockDate : string18;
        evaluatedByAvatar = i & i19 != 0 ? obj.evaluatedByAvatar : long19;
        evaluatedByName = i & i21 != 0 ? obj.evaluatedByName : string20;
        reviewTimeMs = i & i23 != 0 ? obj.reviewTimeMs : string21;
        examId = i & i26 != 0 ? obj.examId : z22;
        evaluatedByEmail = i & i28 != 0 ? obj.evaluatedByEmail : boolean23;
        userFeedbackSubmitted = i & i30 != 0 ? obj.userFeedbackSubmitted : i24;
        isRetakable = i &= i32 != 0 ? obj.isRetakable : object25;
        return programExam.copy(programSaveInfo, trickId, trickImageUrl, videoUrl, thumbnailUrl, status, name, orderDate, string10, reviewComment, description, examTimeLimit, timestamp, boolean15, hasNewFeedback, hasNewUpdates, unlockDate, evaluatedByAvatar, evaluatedByName, reviewTimeMs, examId, evaluatedByEmail);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final String component10() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final int component11() {
        return this.examTimeLimit;
    }

    @Override // android.os.Parcelable
    public final long component12() {
        return this.timestamp;
    }

    @Override // android.os.Parcelable
    public final Boolean component13() {
        return this.hasNewFeedback;
    }

    @Override // android.os.Parcelable
    public final Boolean component14() {
        return this.hasNewUpdates;
    }

    @Override // android.os.Parcelable
    public final Long component15() {
        return this.unlockDate;
    }

    @Override // android.os.Parcelable
    public final String component16() {
        return this.evaluatedByAvatar;
    }

    @Override // android.os.Parcelable
    public final String component17() {
        return this.evaluatedByName;
    }

    @Override // android.os.Parcelable
    public final Long component18() {
        return this.reviewTimeMs;
    }

    @Override // android.os.Parcelable
    public final String component19() {
        return this.examId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final String component20() {
        return this.evaluatedByEmail;
    }

    @Override // android.os.Parcelable
    public final boolean component21() {
        return this.userFeedbackSubmitted;
    }

    @Override // android.os.Parcelable
    public final Boolean component22() {
        return this.isRetakable;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.trickImageUrl;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.videoUrl;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.thumbnailUrl;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExam.Status component6() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final long component8() {
        return this.orderDate;
    }

    @Override // android.os.Parcelable
    public final String component9() {
        return this.reviewComment;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExam copy(app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo, String string2, String string3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.ProgramExam.Status programExam$Status6, String string7, long l8, String string9, String string10, int i11, long l12, Boolean boolean13, Boolean boolean14, Long long15, String string16, String string17, Long long18, String string19, String string20, boolean z21, Boolean boolean22) {
        Object obj = programSaveInfo;
        n.f(obj, "programSaveInfo");
        n.f(string2, "trickId");
        n.f(string3, "trickImageUrl");
        n.f(string4, "videoUrl");
        n.f(string5, "thumbnailUrl");
        n.f(status6, "status");
        n.f(string7, "name");
        n.f(string10, "reviewComment");
        n.f(i11, "description");
        n.f(long18, "evaluatedByAvatar");
        n.f(string19, "evaluatedByName");
        super(obj, string2, string3, string4, string5, status6, string7, l8, obj9, string10, i11, l12, boolean13, obj14, long15, string16, string17, long18, string19, string20, z21, boolean22, obj50, obj51);
        return programExam2;
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
        if (!object instanceof ProgramExam) {
            return i2;
        }
        if (!n.b(this.programSaveInfo, object.programSaveInfo)) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (!n.b(this.trickImageUrl, object.trickImageUrl)) {
            return i2;
        }
        if (!n.b(this.videoUrl, object.videoUrl)) {
            return i2;
        }
        if (!n.b(this.thumbnailUrl, object.thumbnailUrl)) {
            return i2;
        }
        if (this.status != object.status) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (Long.compare(orderDate, orderDate2) != 0) {
            return i2;
        }
        if (!n.b(this.reviewComment, object.reviewComment)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (this.examTimeLimit != object.examTimeLimit) {
            return i2;
        }
        if (Long.compare(timestamp, timestamp2) != 0) {
            return i2;
        }
        if (!n.b(this.hasNewFeedback, object.hasNewFeedback)) {
            return i2;
        }
        if (!n.b(this.hasNewUpdates, object.hasNewUpdates)) {
            return i2;
        }
        if (!n.b(this.unlockDate, object.unlockDate)) {
            return i2;
        }
        if (!n.b(this.evaluatedByAvatar, object.evaluatedByAvatar)) {
            return i2;
        }
        if (!n.b(this.evaluatedByName, object.evaluatedByName)) {
            return i2;
        }
        if (!n.b(this.reviewTimeMs, object.reviewTimeMs)) {
            return i2;
        }
        if (!n.b(this.examId, object.examId)) {
            return i2;
        }
        if (!n.b(this.evaluatedByEmail, object.evaluatedByEmail)) {
            return i2;
        }
        if (this.userFeedbackSubmitted != object.userFeedbackSubmitted) {
            return i2;
        }
        if (!n.b(this.isRetakable, object.isRetakable)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final String getEvaluatedByAvatar() {
        return this.evaluatedByAvatar;
    }

    @Override // android.os.Parcelable
    public final String getEvaluatedByEmail() {
        return this.evaluatedByEmail;
    }

    @Override // android.os.Parcelable
    public final String getEvaluatedByName() {
        return this.evaluatedByName;
    }

    @Override // android.os.Parcelable
    public final String getExamId() {
        return this.examId;
    }

    @Override // android.os.Parcelable
    public final int getExamTimeLimit() {
        return this.examTimeLimit;
    }

    @Override // android.os.Parcelable
    public final Boolean getHasNewFeedback() {
        return this.hasNewFeedback;
    }

    @Override // android.os.Parcelable
    public final Boolean getHasNewUpdates() {
        return this.hasNewUpdates;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final long getOrderDate() {
        return this.orderDate;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    @Override // android.os.Parcelable
    public final String getReviewComment() {
        return this.reviewComment;
    }

    @Override // android.os.Parcelable
    public final Long getReviewTimeMs() {
        return this.reviewTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramExam.Status getStatus() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    @Override // android.os.Parcelable
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // android.os.Parcelable
    public final String getTrickId() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final String getTrickImageUrl() {
        return this.trickImageUrl;
    }

    @Override // android.os.Parcelable
    public final Long getUnlockDate() {
        return this.unlockDate;
    }

    @Override // android.os.Parcelable
    public final boolean getUserFeedbackSubmitted() {
        return this.userFeedbackSubmitted;
    }

    @Override // android.os.Parcelable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i7;
        int i5;
        boolean userFeedbackSubmitted;
        int i6;
        Boolean hasNewFeedback = this.hasNewFeedback;
        i6 = 0;
        if (hasNewFeedback == null) {
            i = i6;
        } else {
            i = hasNewFeedback.hashCode();
        }
        Boolean hasNewUpdates = this.hasNewUpdates;
        if (hasNewUpdates == null) {
            i2 = i6;
        } else {
            i2 = hasNewUpdates.hashCode();
        }
        Long unlockDate = this.unlockDate;
        if (unlockDate == null) {
            i3 = i6;
        } else {
            i3 = unlockDate.hashCode();
        }
        Long reviewTimeMs = this.reviewTimeMs;
        if (reviewTimeMs == null) {
            i4 = i6;
        } else {
            i4 = reviewTimeMs.hashCode();
        }
        String examId = this.examId;
        if (examId == null) {
            i7 = i6;
        } else {
            i7 = examId.hashCode();
        }
        String evaluatedByEmail = this.evaluatedByEmail;
        if (evaluatedByEmail == null) {
            i5 = i6;
        } else {
            i5 = evaluatedByEmail.hashCode();
        }
        if (this.userFeedbackSubmitted) {
            userFeedbackSubmitted = 1;
        }
        Boolean isRetakable = this.isRetakable;
        if (isRetakable == null) {
        } else {
            i6 = isRetakable.hashCode();
        }
        return i49 += i6;
    }

    @Override // android.os.Parcelable
    public final Boolean isRetakable() {
        return this.isRetakable;
    }

    @Override // android.os.Parcelable
    public final void setHasNewUpdates(Boolean boolean) {
        this.hasNewUpdates = boolean;
    }

    @Override // android.os.Parcelable
    public final void setUserFeedbackSubmitted(boolean z) {
        this.userFeedbackSubmitted = z;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramExam(programSaveInfo=");
        stringBuilder.append(this.programSaveInfo);
        stringBuilder.append(", trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", trickImageUrl=");
        stringBuilder.append(this.trickImageUrl);
        stringBuilder.append(", videoUrl=");
        stringBuilder.append(this.videoUrl);
        stringBuilder.append(", thumbnailUrl=");
        stringBuilder.append(this.thumbnailUrl);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", orderDate=");
        stringBuilder.append(this.orderDate);
        stringBuilder.append(", reviewComment=");
        stringBuilder.append(this.reviewComment);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", examTimeLimit=");
        stringBuilder.append(this.examTimeLimit);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", hasNewFeedback=");
        stringBuilder.append(this.hasNewFeedback);
        stringBuilder.append(", hasNewUpdates=");
        stringBuilder.append(this.hasNewUpdates);
        stringBuilder.append(", unlockDate=");
        stringBuilder.append(this.unlockDate);
        stringBuilder.append(", evaluatedByAvatar=");
        stringBuilder.append(this.evaluatedByAvatar);
        stringBuilder.append(", evaluatedByName=");
        stringBuilder.append(this.evaluatedByName);
        stringBuilder.append(", reviewTimeMs=");
        stringBuilder.append(this.reviewTimeMs);
        stringBuilder.append(", examId=");
        stringBuilder.append(this.examId);
        stringBuilder.append(", evaluatedByEmail=");
        stringBuilder.append(this.evaluatedByEmail);
        stringBuilder.append(", userFeedbackSubmitted=");
        stringBuilder.append(this.userFeedbackSubmitted);
        stringBuilder.append(", isRetakable=");
        stringBuilder.append(this.isRetakable);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        long longValue;
        Boolean obj6;
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, i2);
        parcel.writeString(this.trickId);
        parcel.writeString(this.trickImageUrl);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.status.name());
        parcel.writeString(this.name);
        parcel.writeLong(this.orderDate);
        parcel.writeString(this.reviewComment);
        parcel.writeString(this.description);
        parcel.writeInt(this.examTimeLimit);
        parcel.writeLong(this.timestamp);
        obj6 = this.hasNewFeedback;
        int i = 0;
        final int i3 = 1;
        if (obj6 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj6.booleanValue());
        }
        obj6 = this.hasNewUpdates;
        if (obj6 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj6.booleanValue());
        }
        obj6 = this.unlockDate;
        if (obj6 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeLong(obj6.longValue());
        }
        parcel.writeString(this.evaluatedByAvatar);
        parcel.writeString(this.evaluatedByName);
        obj6 = this.reviewTimeMs;
        if (obj6 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeLong(obj6.longValue());
        }
        parcel.writeString(this.examId);
        parcel.writeString(this.evaluatedByEmail);
        parcel.writeInt(this.userFeedbackSubmitted);
        obj6 = this.isRetakable;
        if (obj6 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj6.booleanValue());
        }
    }
}
