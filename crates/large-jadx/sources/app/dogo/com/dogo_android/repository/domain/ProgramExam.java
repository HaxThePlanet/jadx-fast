package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramExam.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008H\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 e2\u00020\u0001:\u0002efBÙ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0014\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u001eJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0011HÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010G\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0014HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003Jø\u0001\u0010X\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r2\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00052\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00142\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010YJ\t\u0010Z\u001a\u00020\u0011HÖ\u0001J\u0013\u0010[\u001a\u00020\u00142\u0008\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u0011HÖ\u0001J\t\u0010_\u001a\u00020\u0005HÖ\u0001J\u0019\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010 R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010 R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010 R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008'\u0010(R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\u0008*\u0010(\"\u0004\u0008+\u0010,R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008\u001d\u0010(R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010 R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010 R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\u00083\u00104R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00107R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010 R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010 R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\u0008<\u00104R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010 ¨\u0006g", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "Landroid/os/Parcelable;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickId", "", "trickImageUrl", "videoUrl", "thumbnailUrl", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "name", "orderDate", "", "reviewComment", "description", "examTimeLimit", "", "timestamp", "hasNewFeedback", "", "hasNewUpdates", "unlockDate", "evaluatedByAvatar", "evaluatedByName", "reviewTimeMs", "examId", "evaluatedByEmail", "userFeedbackSubmitted", "isRetakable", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;IJLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "getDescription", "()Ljava/lang/String;", "getEvaluatedByAvatar", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getExamTimeLimit", "()I", "getHasNewFeedback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasNewUpdates", "setHasNewUpdates", "(Ljava/lang/Boolean;)V", "getName", "getOrderDate", "()J", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getReviewComment", "getReviewTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "getThumbnailUrl", "getTimestamp", "getTrickId", "getTrickImageUrl", "getUnlockDate", "getUserFeedbackSubmitted", "()Z", "setUserFeedbackSubmitted", "(Z)V", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;IJLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Status", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramExam implements Parcelable {

    public static final Parcelable.Creator<ProgramExam> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ProgramExam.Companion INSTANCE = null;
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
    private final ProgramSaveInfo programSaveInfo;
    private final String reviewComment;
    private final Long reviewTimeMs;
    private final ProgramExam.Status status;
    private final String thumbnailUrl;
    private final long timestamp;
    private final String trickId;
    private final String trickImageUrl;
    private final Long unlockDate;
    private boolean userFeedbackSubmitted;
    private final String videoUrl;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Companion;", "", "()V", "EXAM_TIME_FALLBACK_IN_SECONDS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramExam> {
        @Override // android.os.Parcelable$Creator
        public final ProgramExam createFromParcel(Parcel parcel) {
            int i;
            boolean z;
            boolean z2;
            boolean z3 = true;
            Long num;
            Long num2;
            int i2;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            i2 = 1;
            i2 = 0;
            i = 0;
            if (parcel.readInt() == 0) {
            } else {
                int r2 = i2;
                Boolean str2 = i2;
            }
            if (parcel.readInt() == 0) {
            } else {
                r2 = i2;
                Boolean str = i2;
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            int r28 = i2;
            if (parcel.readInt() == 0) {
            } else {
                if (parcel.readInt() == 0) {
                }
                Boolean str3 = Boolean.valueOf(z3);
            }
            ProgramExam programExam = new ProgramExam((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel2), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), ProgramExam_Status.valueOf(parcel.readString()), parcel.readString(), parcel.readLong(), str6, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), bool, i, i, num, parcel.readString(), string, num2, parcel.readString(), parcel.readString(), i2, i);
            return programExam;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramExam[] newArray(int i) {
            return new ProgramExam[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "", "(Ljava/lang/String;I)V", "LOCKED", "READY", "PENDING", "REJECTED", "APPROVED", "AVAILABLE_HEADER", "UNAVAILABLE_HEADER", "PREMIUM_LOCKED", "PROGRESS_HEADER", "CERTIFICATE_HEADER", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Status {

        APPROVED,
        AVAILABLE_HEADER,
        CERTIFICATE_HEADER,
        LOCKED,
        PENDING,
        PREMIUM_LOCKED,
        PROGRESS_HEADER,
        READY,
        REJECTED,
        UNAVAILABLE_HEADER;
        private static final /* synthetic */ ProgramExam.Status[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramExam.Status[] arr = new ProgramExam.Status[10];
            return new ProgramExam.Status[] { ProgramExam_Status.LOCKED, ProgramExam_Status.READY, ProgramExam_Status.PENDING, ProgramExam_Status.REJECTED, ProgramExam_Status.APPROVED, ProgramExam_Status.AVAILABLE_HEADER, ProgramExam_Status.UNAVAILABLE_HEADER, ProgramExam_Status.PREMIUM_LOCKED, ProgramExam_Status.PROGRESS_HEADER, ProgramExam_Status.CERTIFICATE_HEADER };
        }
    }
    public ProgramExam(ProgramSaveInfo programSaveInfo, String str, String str2, String str3, String str4, ProgramExam.Status status, String str5, long j, String str6, String str7, int i, long j2, Boolean boolean, Boolean boolean2, Long long, String str8, String str9, Long long2, String str10, String str11, boolean z, Boolean boolean3) {
        final Object programSaveInfo3 = this;
        final Object str32 = str2;
        final Object str42 = str3;
        final Object str52 = str4;
        final Object status62 = status;
        final Object str72 = str5;
        final Object str102 = str6;
        final Object i112 = str7;
        final Object long182 = str8;
        final Object str192 = str9;
        n.f(programSaveInfo, "programSaveInfo");
        n.f(str, "trickId");
        n.f(str32, "trickImageUrl");
        n.f(str42, "videoUrl");
        n.f(str52, "thumbnailUrl");
        n.f(status62, "status");
        n.f(str72, "name");
        n.f(str102, "reviewComment");
        n.f(i112, "description");
        n.f(long182, "evaluatedByAvatar");
        n.f(str192, "evaluatedByName");
        super();
        programSaveInfo3.programSaveInfo = programSaveInfo;
        programSaveInfo3.trickId = str;
        programSaveInfo3.trickImageUrl = str32;
        programSaveInfo3.videoUrl = str42;
        programSaveInfo3.thumbnailUrl = str52;
        programSaveInfo3.status = status62;
        programSaveInfo3.name = str72;
        programSaveInfo3.orderDate = j;
        programSaveInfo3.reviewComment = str102;
        programSaveInfo3.description = i112;
        programSaveInfo3.examTimeLimit = i;
        programSaveInfo3.timestamp = j2;
        programSaveInfo3.hasNewFeedback = boolean;
        programSaveInfo3.hasNewUpdates = boolean2;
        programSaveInfo3.unlockDate = long;
        programSaveInfo3.evaluatedByAvatar = long182;
        programSaveInfo3.evaluatedByName = str192;
        programSaveInfo3.reviewTimeMs = long2;
        programSaveInfo3.examId = str10;
        programSaveInfo3.evaluatedByEmail = str11;
        programSaveInfo3.userFeedbackSubmitted = z;
        programSaveInfo3.isRetakable = boolean3;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEvaluatedByAvatar() {
        return this.evaluatedByAvatar;
    }

    public final String getEvaluatedByEmail() {
        return this.evaluatedByEmail;
    }

    public final String getEvaluatedByName() {
        return this.evaluatedByName;
    }

    public final String getExamId() {
        return this.examId;
    }

    public final int getExamTimeLimit() {
        return this.examTimeLimit;
    }

    public final Boolean getHasNewFeedback() {
        return this.hasNewFeedback;
    }

    public final Boolean getHasNewUpdates() {
        return this.hasNewUpdates;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOrderDate() {
        return this.orderDate;
    }

    public final ProgramSaveInfo getProgramSaveInfo() {
        return this.programSaveInfo;
    }

    public final String getReviewComment() {
        return this.reviewComment;
    }

    public final Long getReviewTimeMs() {
        return this.reviewTimeMs;
    }

    public final ProgramExam.Status getStatus() {
        return this.status;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final String getTrickImageUrl() {
        return this.trickImageUrl;
    }

    public final Long getUnlockDate() {
        return this.unlockDate;
    }

    public final boolean getUserFeedbackSubmitted() {
        return this.userFeedbackSubmitted;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final Boolean isRetakable() {
        return this.isRetakable;
    }

    public final void setHasNewUpdates(Boolean boolean) {
        this.hasNewUpdates = boolean;
    }

    public final void setUserFeedbackSubmitted(boolean z) {
        this.userFeedbackSubmitted = z;
    }

    public /* synthetic */ ProgramExam(ProgramSaveInfo programSaveInfo, String str, String str2, String str3, String str4, ProgramExam.Status status, String str5, long j, String str6, String str7, int i, long j2, Boolean boolean, Boolean boolean2, Long long, String str8, String str9, Long long2, String str10, String str11, boolean z, Boolean boolean3, int i2, g gVar) {
        Boolean boolean132;
        Object obj;
        Object obj2;
        String str172;
        Object obj3;
        String str192;
        Object obj4;
        boolean z212;
        Boolean boolean222;
        int i232;
        Boolean gVar242;
        i = i2;
        final int i5 = 0;
        int r17 = i & 2048 != 0 ? i5 : j2;
        i2 = i & 4096;
        Boolean fALSE22 = i & 4096 != 0 ? fALSE22 : boolean;
        i3 = i & 8192;
        Boolean fALSE2 = i & 8192 != 0 ? fALSE2 : boolean2;
        int i6 = 0;
        int r21 = i & 16384 != 0 ? i6 : long;
        str192 = "";
        String r22 = 32768 & i != 0 ? str192 : str8;
        String r23 = 65536 & i != 0 ? str192 : str9;
        i4 = 131072 & i;
        Long num = 131072 & i != 0 ? num : long2;
        int r25 = 262144 & i != 0 ? i6 : str10;
        int r26 = 524288 & i != 0 ? i6 : str11;
        i232 = 1048576 & i;
        i232 = 1048576 & i != 0 ? i232 : z;
        gVar242 = i & 2097152 != 0 ? gVar242 : boolean3;
        this(programSaveInfo, str, str2, str3, str4, status, str5, j, str, str6, str7, i, boolean132, bool, obj, obj2, str172, obj3, str192, obj4, z212, boolean222, i232, gVar242);
    }

    static {
        ProgramExam.INSTANCE = new ProgramExam_Companion(null);
        ProgramExam.CREATOR = new ProgramExam.Creator();
    }

    public static /* synthetic */ ProgramExam copy$default(ProgramExam programExam, ProgramSaveInfo programSaveInfo, String str, String str2, String str3, String str4, ProgramExam.Status status, String str5, long j, String str6, String str7, int i, long j2, Boolean boolean, Boolean boolean2, Long long, String str8, String str9, Long long2, String str10, String str11, boolean z, Boolean boolean3, int i2, Object object) {
        Boolean object252;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo22;
        String str32;
        String str42;
        String str52;
        String str62;
        app.dogo.com.dogo_android.repository.domain.ProgramExam.Status status72;
        String str82;
        long j92;
        String str112;
        String i122;
        int j132;
        long boolean142;
        Boolean long162;
        Boolean str172;
        Long str182;
        String long192;
        String str202;
        Long str212;
        String z222;
        String boolean232;
        boolean i242;
        Object programExam2 = programExam;
        i = i2;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo r2 = i & 1 != 0 ? programExam2.programSaveInfo : programSaveInfo;
        String r3 = i & 2 != 0 ? programExam2.trickId : str;
        String r4 = i & 4 != 0 ? programExam2.trickImageUrl : str2;
        String r5 = i & 8 != 0 ? programExam2.videoUrl : str3;
        String r6 = i & 16 != 0 ? programExam2.thumbnailUrl : str4;
        app.dogo.com.dogo_android.repository.domain.ProgramExam.Status r7 = i & 32 != 0 ? programExam2.status : status;
        String r8 = i & 64 != 0 ? programExam2.name : str5;
        long r9 = i & 128 != 0 ? programExam2.orderDate : j;
        String r11 = i & 256 != 0 ? programExam2.reviewComment : str6;
        String r12 = i & 512 != 0 ? programExam2.description : str7;
        int r13 = i & 1024 != 0 ? programExam2.examTimeLimit : i;
        long r14 = i & 2048 != 0 ? programExam2.timestamp : j2;
        r14 = i & 4096 != 0 ? programExam2.hasNewFeedback : boolean;
        Boolean r15 = i & 8192 != 0 ? programExam2.hasNewUpdates : boolean2;
        r15 = i & 16384 != 0 ? programExam2.unlockDate : long;
        r15 = i & 32768 != 0 ? programExam2.evaluatedByAvatar : str8;
        r15 = i & 65536 != 0 ? programExam2.evaluatedByName : str9;
        r15 = i & 131072 != 0 ? programExam2.reviewTimeMs : long2;
        r15 = i & 262144 != 0 ? programExam2.examId : str10;
        r15 = i & 524288 != 0 ? programExam2.evaluatedByEmail : str11;
        r15 = i & 1048576 != 0 ? programExam2.userFeedbackSubmitted : z;
        Boolean r1 = i & 2097152 != 0 ? programExam2.isRetakable : boolean3;
        return programExam.copy(programSaveInfo22, str32, str42, str52, str62, status72, str82, j92, r26, str112, i122, j132, (i & 2048 != 0 ? programExam2.timestamp : j2), r31, long162, (i & 8192 != 0 ? programExam2.hasNewUpdates : boolean2), (i & 16384 != 0 ? programExam2.unlockDate : long), (i & 32768 != 0 ? programExam2.evaluatedByAvatar : str8), (i & 65536 != 0 ? programExam2.evaluatedByName : str9), (i & 131072 != 0 ? programExam2.reviewTimeMs : long2), (i & 262144 != 0 ? programExam2.examId : str10), (i & 524288 != 0 ? programExam2.evaluatedByEmail : str11), i242, (i & 2097152 != 0 ? programExam2.isRetakable : boolean3));
    }

    /* operator */ public final ProgramSaveInfo component1() {
        return this.programSaveInfo;
    }

    /* operator */ public final String component10() {
        return this.description;
    }

    /* operator */ public final int component11() {
        return this.examTimeLimit;
    }

    /* operator */ public final long component12() {
        return this.timestamp;
    }

    /* operator */ public final Boolean component13() {
        return this.hasNewFeedback;
    }

    /* operator */ public final Boolean component14() {
        return this.hasNewUpdates;
    }

    /* operator */ public final Long component15() {
        return this.unlockDate;
    }

    /* operator */ public final String component16() {
        return this.evaluatedByAvatar;
    }

    /* operator */ public final String component17() {
        return this.evaluatedByName;
    }

    /* operator */ public final Long component18() {
        return this.reviewTimeMs;
    }

    /* operator */ public final String component19() {
        return this.examId;
    }

    /* operator */ public final String component2() {
        return this.trickId;
    }

    /* operator */ public final String component20() {
        return this.evaluatedByEmail;
    }

    /* operator */ public final boolean component21() {
        return this.userFeedbackSubmitted;
    }

    /* operator */ public final Boolean component22() {
        return this.isRetakable;
    }

    /* operator */ public final String component3() {
        return this.trickImageUrl;
    }

    /* operator */ public final String component4() {
        return this.videoUrl;
    }

    /* operator */ public final String component5() {
        return this.thumbnailUrl;
    }

    /* operator */ public final ProgramExam.Status component6() {
        return this.status;
    }

    /* operator */ public final String component7() {
        return this.name;
    }

    /* operator */ public final long component8() {
        return this.orderDate;
    }

    /* operator */ public final String component9() {
        return this.reviewComment;
    }

    public final ProgramExam copy(ProgramSaveInfo programSaveInfo, String trickId, String trickImageUrl, String videoUrl, String thumbnailUrl, ProgramExam.Status status, String name, long orderDate, String reviewComment, String description, int examTimeLimit, long timestamp, Boolean hasNewFeedback, Boolean hasNewUpdates, Long unlockDate, String evaluatedByAvatar, String evaluatedByName, Long reviewTimeMs, String examId, String evaluatedByEmail, boolean userFeedbackSubmitted, Boolean isRetakable) {
        Object programSaveInfo2 = programSaveInfo;
        n.f(programSaveInfo2, "programSaveInfo");
        n.f(trickId, "trickId");
        n.f(trickImageUrl, "trickImageUrl");
        n.f(videoUrl, "videoUrl");
        n.f(thumbnailUrl, "thumbnailUrl");
        n.f(status, "status");
        n.f(name, "name");
        n.f(reviewComment, "reviewComment");
        n.f(description, "description");
        n.f(evaluatedByAvatar, "evaluatedByAvatar");
        n.f(evaluatedByName, "evaluatedByName");
        ProgramExam programExam = new ProgramExam(programSaveInfo2, trickId, trickImageUrl, videoUrl, thumbnailUrl, status, name, orderDate, str12, reviewComment, description, examTimeLimit, timestamp, bool, hasNewFeedback, hasNewUpdates, unlockDate, evaluatedByAvatar, evaluatedByName, reviewTimeMs, examId, evaluatedByEmail, userFeedbackSubmitted, isRetakable);
        return programExam;
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
        final boolean z19 = false;
        if (!(other instanceof ProgramExam)) {
            return false;
        }
        if (!n.b(this.programSaveInfo, other.programSaveInfo)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        if (!n.b(this.trickImageUrl, other.trickImageUrl)) {
            return false;
        }
        if (!n.b(this.videoUrl, other.videoUrl)) {
            return false;
        }
        if (!n.b(this.thumbnailUrl, other.thumbnailUrl)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (this.orderDate != other.orderDate) {
            return false;
        }
        if (!n.b(this.reviewComment, other.reviewComment)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (this.examTimeLimit != other.examTimeLimit) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        if (!n.b(this.hasNewFeedback, other.hasNewFeedback)) {
            return false;
        }
        if (!n.b(this.hasNewUpdates, other.hasNewUpdates)) {
            return false;
        }
        if (!n.b(this.unlockDate, other.unlockDate)) {
            return false;
        }
        if (!n.b(this.evaluatedByAvatar, other.evaluatedByAvatar)) {
            return false;
        }
        if (!n.b(this.evaluatedByName, other.evaluatedByName)) {
            return false;
        }
        if (!n.b(this.reviewTimeMs, other.reviewTimeMs)) {
            return false;
        }
        if (!n.b(this.examId, other.examId)) {
            return false;
        }
        if (!n.b(this.evaluatedByEmail, other.evaluatedByEmail)) {
            return false;
        }
        if (this.userFeedbackSubmitted != other.userFeedbackSubmitted) {
            return false;
        }
        return !n.b(this.isRetakable, other.isRetakable) ? z19 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        boolean userFeedbackSubmitted2 = true;
        i = 0;
        if (this.hasNewFeedback == null) {
        } else {
            i = this.hasNewFeedback.hashCode();
        }
        if (this.hasNewUpdates == null) {
        } else {
            i = this.hasNewUpdates.hashCode();
        }
        if (this.unlockDate == null) {
        } else {
            i = this.unlockDate.hashCode();
        }
        if (this.reviewTimeMs == null) {
        } else {
            i = this.reviewTimeMs.hashCode();
        }
        if (this.examId == null) {
        } else {
            i = this.examId.hashCode();
        }
        if (this.evaluatedByEmail == null) {
        } else {
            i = this.evaluatedByEmail.hashCode();
        }
        if (this.userFeedbackSubmitted) {
            int i58 = 1;
        }
        if (this.isRetakable != null) {
            i = this.isRetakable.hashCode();
        }
        return (this.programSaveInfo.hashCode() * 31) + this.trickId.hashCode() * 31 + this.trickImageUrl.hashCode() * 31 + this.videoUrl.hashCode() * 31 + this.thumbnailUrl.hashCode() * 31 + this.status.hashCode() * 31 + this.name.hashCode() * 31 + Long.hashCode(this.orderDate) * 31 + this.reviewComment.hashCode() * 31 + this.description.hashCode() * 31 + Integer.hashCode(this.examTimeLimit) * 31 + Long.hashCode(this.timestamp) * 31 + i * 31 + i * 31 + i * 31 + this.evaluatedByAvatar.hashCode() * 31 + this.evaluatedByName.hashCode() * 31 + i * 31 + i * 31 + i * 31 + userFeedbackSubmitted2 * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramExam(programSaveInfo=";
        String str3 = ", trickId=";
        String str4 = ", trickImageUrl=";
        String str5 = ", videoUrl=";
        String str6 = ", thumbnailUrl=";
        String str7 = ", status=";
        String str8 = ", name=";
        String str9 = ", orderDate=";
        String str10 = ", reviewComment=";
        String str11 = ", description=";
        String str12 = ", examTimeLimit=";
        String str13 = ", timestamp=";
        String str14 = ", hasNewFeedback=";
        String str15 = ", hasNewUpdates=";
        String str16 = ", unlockDate=";
        String str17 = ", evaluatedByAvatar=";
        String str18 = ", evaluatedByName=";
        String str19 = ", reviewTimeMs=";
        String str20 = ", examId=";
        String str21 = ", evaluatedByEmail=";
        String str22 = ", userFeedbackSubmitted=";
        String str23 = ", isRetakable=";
        str = str2 + this.programSaveInfo + str3 + this.trickId + str4 + this.trickImageUrl + str5 + this.videoUrl + str6 + this.thumbnailUrl + str7 + this.status + str8 + this.name + str9 + this.orderDate + str10 + this.reviewComment + str11 + this.description + str12 + this.examTimeLimit + str13 + this.timestamp + str14 + this.hasNewFeedback + str15 + this.hasNewUpdates + str16 + this.unlockDate + str17 + this.evaluatedByAvatar + str18 + this.evaluatedByName + str19 + this.reviewTimeMs + str20 + this.examId + str21 + this.evaluatedByEmail + str22 + this.userFeedbackSubmitted + str23 + this.isRetakable + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        long value;
        n.f(parcel, "out");
        this.programSaveInfo.writeToParcel(parcel, flags);
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
        int i = 0;
        final int i2 = 1;
        if (this.hasNewFeedback == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.hasNewFeedback.booleanValue());
        }
        if (this.hasNewUpdates == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.hasNewUpdates.booleanValue());
        }
        if (this.unlockDate == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.unlockDate.longValue());
        }
        parcel.writeString(this.evaluatedByAvatar);
        parcel.writeString(this.evaluatedByName);
        if (this.reviewTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.reviewTimeMs.longValue());
        }
        parcel.writeString(this.examId);
        parcel.writeString(this.evaluatedByEmail);
        parcel.writeInt(this.userFeedbackSubmitted);
        if (this.isRetakable == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.isRetakable.booleanValue());
        }
    }
}
