package app.dogo.com.dogo_android.model;

import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0002\u0008H\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0010\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00100J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\t\u0010B\u001a\u00020\u0010HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0010HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0092\u0002\u0010T\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00102\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u00032\u0008\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010X\u001a\u00020YJ\t\u0010Z\u001a\u00020\u0007HÖ\u0001J\t\u0010[\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010$\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010!R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010!R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010!R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010!R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00101\u001a\u0004\u0008/\u00100R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u0011\u0010\u001a\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00105R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00105R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00101\u001a\u0004\u00088\u00100R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010!¨\u0006\\", d2 = {"Lapp/dogo/com/dogo_android/model/ExamHistoryModel;", "", "active", "", "dogAvatarUrl", "", "dogGender", "", "dogId", "dogName", "evaluatedByAvatar", "evaluatedByName", "evaluatedByEmail", "examId", "reviewComment", "reviewTimeMs", "", "status", "submissionTimeMs", "unlockTimeMs", "uploadTimeMs", "userId", "videoThumbnailUrl", "videoUrl", "programId", "moduleId", "timestamp", "id", "userFeedbackSubmitted", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IJJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getActive", "()Z", "getDogAvatarUrl", "()Ljava/lang/String;", "getDogGender", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDogId", "getDogName", "getEvaluatedByAvatar", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getId", "getModuleId", "getProgramId", "getReviewComment", "getReviewTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()I", "getSubmissionTimeMs", "()J", "getTimestamp", "getUnlockTimeMs", "getUploadTimeMs", "getUserFeedbackSubmitted", "getUserId", "getVideoThumbnailUrl", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IJJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)Lapp/dogo/com/dogo_android/model/ExamHistoryModel;", "equals", "other", "getProgramExamStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExamHistoryModel {

    private final boolean active;
    private final String dogAvatarUrl;
    private final Integer dogGender;
    private final String dogId;
    private final String dogName;
    private final String evaluatedByAvatar;
    private final String evaluatedByEmail;
    private final String evaluatedByName;
    private final String examId;
    private final String id;
    private final String moduleId;
    private final String programId;
    private final String reviewComment;
    private final Long reviewTimeMs;
    private final int status;
    private final long submissionTimeMs;
    private final long timestamp;
    private final long unlockTimeMs;
    private final Long uploadTimeMs;
    private final boolean userFeedbackSubmitted;
    private final String userId;
    private final String videoThumbnailUrl;
    private final String videoUrl;
    public ExamHistoryModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj14, 0, obj16, 0, 0, 0, 0, 0, 0, 0, obj24, 0, 0, 8388607, 0);
    }

    public ExamHistoryModel(boolean z, String string2, Integer integer3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Long long11, int i12, long l13, long l14, Long long15, String string16, String string17, String string18, String string19, String string20, long l21, String string22, boolean z23) {
        final Object obj = this;
        final Object obj2 = obj30;
        n.f(string4, "dogId");
        n.f(obj2, "id");
        super();
        obj.active = z;
        obj.dogAvatarUrl = string2;
        obj.dogGender = integer3;
        obj.dogId = string4;
        obj.dogName = string5;
        obj.evaluatedByAvatar = string6;
        obj.evaluatedByName = string7;
        obj.evaluatedByEmail = string8;
        obj.examId = string9;
        obj.reviewComment = string10;
        obj.reviewTimeMs = long11;
        obj.status = i12;
        obj.submissionTimeMs = l13;
        obj.unlockTimeMs = long15;
        obj.uploadTimeMs = string17;
        obj.userId = string18;
        obj.videoThumbnailUrl = string19;
        obj.videoUrl = string20;
        obj.programId = l21;
        obj.moduleId = string22;
        obj.timestamp = z23;
        obj.id = obj2;
        obj.userFeedbackSubmitted = obj31;
    }

    public ExamHistoryModel(boolean z, String string2, Integer integer3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Long long11, int i12, long l13, long l14, Long long15, String string16, String string17, String string18, String string19, String string20, long l21, String string22, boolean z23, int i24, g g25) {
        int i7;
        int i17;
        int str3;
        int i3;
        int i5;
        Integer valueOf;
        String str;
        String str2;
        int i4;
        String str6;
        String str4;
        String str5;
        int i11;
        int i15;
        int i9;
        int i6;
        int i2;
        int i8;
        int i13;
        int i16;
        int i;
        int i10;
        int i14;
        int i18 = obj54;
        int i21 = 0;
        i17 = i18 & 1 != 0 ? i21 : z;
        i5 = 0;
        i3 = i18 & 2 != 0 ? i5 : string2;
        if (i18 & 4 != 0) {
            valueOf = Integer.valueOf(i21);
        } else {
            valueOf = integer3;
        }
        str2 = "";
        str = i18 & 8 != 0 ? str2 : string4;
        i4 = i18 & 16 != 0 ? i5 : string5;
        str6 = i18 & 32 != 0 ? str2 : string6;
        str4 = i18 & 64 != 0 ? str2 : string7;
        str5 = i18 & 128 != 0 ? str2 : string8;
        i11 = i18 & 256 != 0 ? i5 : string9;
        i15 = i18 & 512 != 0 ? i5 : string10;
        i9 = i18 & 1024 != 0 ? i5 : long11;
        i6 = i18 & 2048 != 0 ? i21 : i12;
        i2 = 0;
        i8 = i18 & 4096 != 0 ? i2 : l13;
        i13 = i18 & 8192 != 0 ? i2 : long15;
        str3 = i18 & 16384 != 0 ? i5 : string17;
        i16 = i18 & i37 != 0 ? i5 : string18;
        i = i18 & i39 != 0 ? i5 : string19;
        i10 = i18 & i41 != 0 ? i5 : string20;
        i14 = i18 & i43 != 0 ? i5 : l21;
        if (i18 & i45 != 0) {
        } else {
            i5 = string22;
        }
        if (i18 & i47 != 0) {
        } else {
            i2 = z23;
        }
        if (i18 & i49 != 0) {
        } else {
            str2 = g25;
        }
        i7 = i18 &= i51 != 0 ? 0 : obj53;
        super(i17, i3, valueOf, str, i4, str6, str4, str5, i11, i15, i9, i6, i8, long15, i13, string17, str3, i16, i, i10, i14, i5, i2, g25, str2, i7);
    }

    public static app.dogo.com.dogo_android.model.ExamHistoryModel copy$default(app.dogo.com.dogo_android.model.ExamHistoryModel examHistoryModel, boolean z2, String string3, Integer integer4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, Long long12, int i13, long l14, long l15, Long long16, String string17, String string18, String string19, String string20, String string21, long l22, String string23, boolean z24, int i25, Object object26) {
        boolean userFeedbackSubmitted;
        boolean active;
        String dogAvatarUrl;
        Integer dogGender;
        String dogId;
        String dogName;
        String evaluatedByAvatar;
        String evaluatedByName;
        String evaluatedByEmail;
        String examId;
        String reviewComment;
        Long reviewTimeMs;
        int status;
        long submissionTimeMs;
        long unlockTimeMs;
        Long uploadTimeMs;
        long timestamp;
        String str;
        String userId;
        String videoThumbnailUrl;
        String videoUrl;
        String programId;
        String moduleId;
        Object obj = examHistoryModel;
        int i = obj44;
        active = i & 1 != 0 ? obj.active : z2;
        dogAvatarUrl = i & 2 != 0 ? obj.dogAvatarUrl : string3;
        dogGender = i & 4 != 0 ? obj.dogGender : integer4;
        dogId = i & 8 != 0 ? obj.dogId : string5;
        dogName = i & 16 != 0 ? obj.dogName : string6;
        evaluatedByAvatar = i & 32 != 0 ? obj.evaluatedByAvatar : string7;
        evaluatedByName = i & 64 != 0 ? obj.evaluatedByName : string8;
        evaluatedByEmail = i & 128 != 0 ? obj.evaluatedByEmail : string9;
        examId = i & 256 != 0 ? obj.examId : string10;
        reviewComment = i & 512 != 0 ? obj.reviewComment : string11;
        reviewTimeMs = i & 1024 != 0 ? obj.reviewTimeMs : long12;
        status = i & 2048 != 0 ? obj.status : i13;
        submissionTimeMs = i & 4096 != 0 ? obj.submissionTimeMs : l14;
        unlockTimeMs = i & 8192 != 0 ? obj.unlockTimeMs : long16;
        uploadTimeMs = i & 16384 != 0 ? obj.uploadTimeMs : string18;
        userId = i19 &= i != 0 ? obj.userId : string19;
        videoThumbnailUrl = i & i22 != 0 ? obj.videoThumbnailUrl : string20;
        videoUrl = i & i24 != 0 ? obj.videoUrl : string21;
        programId = i & i27 != 0 ? obj.programId : l22;
        moduleId = i & i29 != 0 ? obj.moduleId : string23;
        timestamp = i & i31 != 0 ? obj.timestamp : z24;
        str = i & i33 != 0 ? obj.id : object26;
        userFeedbackSubmitted = i &= i21 != 0 ? obj.userFeedbackSubmitted : obj43;
        return examHistoryModel.copy(active, dogAvatarUrl, dogGender, dogId, dogName, evaluatedByAvatar, evaluatedByName, evaluatedByEmail, examId, reviewComment, reviewTimeMs, status, submissionTimeMs, l15, unlockTimeMs, string17, uploadTimeMs, userId, videoThumbnailUrl, videoUrl, programId, moduleId, timestamp);
    }

    public final boolean component1() {
        return this.active;
    }

    public final String component10() {
        return this.reviewComment;
    }

    public final Long component11() {
        return this.reviewTimeMs;
    }

    public final int component12() {
        return this.status;
    }

    public final long component13() {
        return this.submissionTimeMs;
    }

    public final long component14() {
        return this.unlockTimeMs;
    }

    public final Long component15() {
        return this.uploadTimeMs;
    }

    public final String component16() {
        return this.userId;
    }

    public final String component17() {
        return this.videoThumbnailUrl;
    }

    public final String component18() {
        return this.videoUrl;
    }

    public final String component19() {
        return this.programId;
    }

    public final String component2() {
        return this.dogAvatarUrl;
    }

    public final String component20() {
        return this.moduleId;
    }

    public final long component21() {
        return this.timestamp;
    }

    public final String component22() {
        return this.id;
    }

    public final boolean component23() {
        return this.userFeedbackSubmitted;
    }

    public final Integer component3() {
        return this.dogGender;
    }

    public final String component4() {
        return this.dogId;
    }

    public final String component5() {
        return this.dogName;
    }

    public final String component6() {
        return this.evaluatedByAvatar;
    }

    public final String component7() {
        return this.evaluatedByName;
    }

    public final String component8() {
        return this.evaluatedByEmail;
    }

    public final String component9() {
        return this.examId;
    }

    public final app.dogo.com.dogo_android.model.ExamHistoryModel copy(boolean z, String string2, Integer integer3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Long long11, int i12, long l13, long l14, Long long15, String string16, String string17, String string18, String string19, String string20, long l21, String string22, boolean z23) {
        boolean z2 = z;
        n.f(string4, "dogId");
        n.f(obj53, "id");
        super(z, string2, integer3, string4, string5, string6, string7, string8, string9, string10, long11, i12, l13, obj14, long15, obj16, string17, string18, string19, string20, l21, string22, z23, obj24, obj53, obj54);
        return examHistoryModel2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ExamHistoryModel) {
            return i2;
        }
        if (this.active != object.active) {
            return i2;
        }
        if (!n.b(this.dogAvatarUrl, object.dogAvatarUrl)) {
            return i2;
        }
        if (!n.b(this.dogGender, object.dogGender)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.dogName, object.dogName)) {
            return i2;
        }
        if (!n.b(this.evaluatedByAvatar, object.evaluatedByAvatar)) {
            return i2;
        }
        if (!n.b(this.evaluatedByName, object.evaluatedByName)) {
            return i2;
        }
        if (!n.b(this.evaluatedByEmail, object.evaluatedByEmail)) {
            return i2;
        }
        if (!n.b(this.examId, object.examId)) {
            return i2;
        }
        if (!n.b(this.reviewComment, object.reviewComment)) {
            return i2;
        }
        if (!n.b(this.reviewTimeMs, object.reviewTimeMs)) {
            return i2;
        }
        if (this.status != object.status) {
            return i2;
        }
        if (Long.compare(submissionTimeMs, submissionTimeMs2) != 0) {
            return i2;
        }
        if (Long.compare(unlockTimeMs, unlockTimeMs2) != 0) {
            return i2;
        }
        if (!n.b(this.uploadTimeMs, object.uploadTimeMs)) {
            return i2;
        }
        if (!n.b(this.userId, object.userId)) {
            return i2;
        }
        if (!n.b(this.videoThumbnailUrl, object.videoThumbnailUrl)) {
            return i2;
        }
        if (!n.b(this.videoUrl, object.videoUrl)) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (!n.b(this.moduleId, object.moduleId)) {
            return i2;
        }
        if (Long.compare(timestamp, timestamp2) != 0) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (this.userFeedbackSubmitted != object.userFeedbackSubmitted) {
            return i2;
        }
        return i;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final String getDogAvatarUrl() {
        return this.dogAvatarUrl;
    }

    public final Integer getDogGender() {
        return this.dogGender;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getDogName() {
        return this.dogName;
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

    public final String getId() {
        return this.id;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final ProgramExam.Status getProgramExamStatus() {
        ProgramExam.Status aPPROVED;
        int ordinal;
        int status = this.status;
        aPPROVED = status == Exam.Status.REJECTED.ordinal() ? ProgramExam.Status.REJECTED : status == ordinal ? ProgramExam.Status.APPROVED : status == ordinal ? ProgramExam.Status.PENDING : status == ordinal ? ProgramExam.Status.READY : status == ordinal ? ProgramExam.Status.PENDING : status == ordinal ? ProgramExam.Status.APPROVED : ProgramExam.Status.LOCKED;
        return aPPROVED;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getReviewComment() {
        return this.reviewComment;
    }

    public final Long getReviewTimeMs() {
        return this.reviewTimeMs;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getSubmissionTimeMs() {
        return this.submissionTimeMs;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getUnlockTimeMs() {
        return this.unlockTimeMs;
    }

    public final Long getUploadTimeMs() {
        return this.uploadTimeMs;
    }

    public final boolean getUserFeedbackSubmitted() {
        return this.userFeedbackSubmitted;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVideoThumbnailUrl() {
        return this.videoThumbnailUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        boolean active;
        boolean i14;
        int i4;
        int i13;
        int i9;
        int i11;
        int i10;
        int i;
        int i2;
        int i8;
        int i7;
        int i12;
        int i5;
        int i15;
        int i16;
        int i6;
        int i3;
        if (this.active) {
            active = i14;
        }
        String dogAvatarUrl = this.dogAvatarUrl;
        i3 = 0;
        if (dogAvatarUrl == null) {
            i4 = i3;
        } else {
            i4 = dogAvatarUrl.hashCode();
        }
        Integer dogGender = this.dogGender;
        if (dogGender == null) {
            i13 = i3;
        } else {
            i13 = dogGender.hashCode();
        }
        String dogName = this.dogName;
        if (dogName == null) {
            i9 = i3;
        } else {
            i9 = dogName.hashCode();
        }
        String evaluatedByAvatar = this.evaluatedByAvatar;
        if (evaluatedByAvatar == null) {
            i11 = i3;
        } else {
            i11 = evaluatedByAvatar.hashCode();
        }
        String evaluatedByName = this.evaluatedByName;
        if (evaluatedByName == null) {
            i10 = i3;
        } else {
            i10 = evaluatedByName.hashCode();
        }
        String evaluatedByEmail = this.evaluatedByEmail;
        if (evaluatedByEmail == null) {
            i = i3;
        } else {
            i = evaluatedByEmail.hashCode();
        }
        String examId = this.examId;
        if (examId == null) {
            i2 = i3;
        } else {
            i2 = examId.hashCode();
        }
        String reviewComment = this.reviewComment;
        if (reviewComment == null) {
            i8 = i3;
        } else {
            i8 = reviewComment.hashCode();
        }
        Long reviewTimeMs = this.reviewTimeMs;
        if (reviewTimeMs == null) {
            i7 = i3;
        } else {
            i7 = reviewTimeMs.hashCode();
        }
        Long uploadTimeMs = this.uploadTimeMs;
        if (uploadTimeMs == null) {
            i12 = i3;
        } else {
            i12 = uploadTimeMs.hashCode();
        }
        String userId = this.userId;
        if (userId == null) {
            i5 = i3;
        } else {
            i5 = userId.hashCode();
        }
        String videoThumbnailUrl = this.videoThumbnailUrl;
        if (videoThumbnailUrl == null) {
            i15 = i3;
        } else {
            i15 = videoThumbnailUrl.hashCode();
        }
        String videoUrl = this.videoUrl;
        if (videoUrl == null) {
            i16 = i3;
        } else {
            i16 = videoUrl.hashCode();
        }
        String programId = this.programId;
        if (programId == null) {
            i6 = i3;
        } else {
            i6 = programId.hashCode();
        }
        String moduleId = this.moduleId;
        if (moduleId == null) {
        } else {
            i3 = moduleId.hashCode();
        }
        boolean userFeedbackSubmitted = this.userFeedbackSubmitted;
        if (userFeedbackSubmitted) {
        } else {
            i14 = userFeedbackSubmitted;
        }
        return i59 += i14;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExamHistoryModel(active=");
        stringBuilder.append(this.active);
        stringBuilder.append(", dogAvatarUrl=");
        stringBuilder.append(this.dogAvatarUrl);
        stringBuilder.append(", dogGender=");
        stringBuilder.append(this.dogGender);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", dogName=");
        stringBuilder.append(this.dogName);
        stringBuilder.append(", evaluatedByAvatar=");
        stringBuilder.append(this.evaluatedByAvatar);
        stringBuilder.append(", evaluatedByName=");
        stringBuilder.append(this.evaluatedByName);
        stringBuilder.append(", evaluatedByEmail=");
        stringBuilder.append(this.evaluatedByEmail);
        stringBuilder.append(", examId=");
        stringBuilder.append(this.examId);
        stringBuilder.append(", reviewComment=");
        stringBuilder.append(this.reviewComment);
        stringBuilder.append(", reviewTimeMs=");
        stringBuilder.append(this.reviewTimeMs);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", submissionTimeMs=");
        stringBuilder.append(this.submissionTimeMs);
        stringBuilder.append(", unlockTimeMs=");
        stringBuilder.append(this.unlockTimeMs);
        stringBuilder.append(", uploadTimeMs=");
        stringBuilder.append(this.uploadTimeMs);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", videoThumbnailUrl=");
        stringBuilder.append(this.videoThumbnailUrl);
        stringBuilder.append(", videoUrl=");
        stringBuilder.append(this.videoUrl);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", userFeedbackSubmitted=");
        stringBuilder.append(this.userFeedbackSubmitted);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
