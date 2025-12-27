package app.dogo.com.dogo_android.model;

import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ExamHistoryModel.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0002\u0008H\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0010\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00100J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\t\u0010B\u001a\u00020\u0010HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0010HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0092\u0002\u0010T\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00102\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u00032\u0008\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010X\u001a\u00020YJ\t\u0010Z\u001a\u00020\u0007HÖ\u0001J\t\u0010[\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010$\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010!R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010!R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010!R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010!R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00101\u001a\u0004\u0008/\u00100R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u0011\u0010\u001a\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00105R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00105R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00101\u001a\u0004\u00088\u00100R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010!¨\u0006\\", d2 = {"Lapp/dogo/com/dogo_android/model/ExamHistoryModel;", "", "active", "", "dogAvatarUrl", "", "dogGender", "", "dogId", "dogName", "evaluatedByAvatar", "evaluatedByName", "evaluatedByEmail", "examId", "reviewComment", "reviewTimeMs", "", "status", "submissionTimeMs", "unlockTimeMs", "uploadTimeMs", "userId", "videoThumbnailUrl", "videoUrl", "programId", "moduleId", "timestamp", "id", "userFeedbackSubmitted", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IJJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getActive", "()Z", "getDogAvatarUrl", "()Ljava/lang/String;", "getDogGender", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDogId", "getDogName", "getEvaluatedByAvatar", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getId", "getModuleId", "getProgramId", "getReviewComment", "getReviewTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()I", "getSubmissionTimeMs", "()J", "getTimestamp", "getUnlockTimeMs", "getUploadTimeMs", "getUserFeedbackSubmitted", "getUserId", "getVideoThumbnailUrl", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IJJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)Lapp/dogo/com/dogo_android/model/ExamHistoryModel;", "equals", "other", "getProgramExamStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ExamHistoryModel {

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
    public ExamHistoryModel(boolean z, String str, Integer integer, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long long, int i, long j, long j2, Long long2, String str9, String str10, String str11, String str12, String str13, long j3, String str14, boolean z2) {
        final Object z4 = this;
        final Object obj = str14;
        n.f(str2, "dogId");
        n.f(obj, "id");
        super();
        z4.active = z;
        z4.dogAvatarUrl = str;
        z4.dogGender = integer;
        z4.dogId = str2;
        z4.dogName = str3;
        z4.evaluatedByAvatar = str4;
        z4.evaluatedByName = str5;
        z4.evaluatedByEmail = str6;
        z4.examId = str7;
        z4.reviewComment = str8;
        z4.reviewTimeMs = long;
        z4.status = i;
        z4.submissionTimeMs = j;
        z4.unlockTimeMs = j2;
        z4.uploadTimeMs = long2;
        z4.userId = str9;
        z4.videoThumbnailUrl = str10;
        z4.videoUrl = str11;
        z4.programId = str12;
        z4.moduleId = str13;
        z4.timestamp = j3;
        z4.id = obj;
        z4.userFeedbackSubmitted = z2;
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
        ProgramExam.Status aPPROVED2;
        if (this.status == Exam_Status.REJECTED.ordinal()) {
            aPPROVED2 = ProgramExam_Status.REJECTED;
        } else {
            if (this.status == Exam_Status.APPROVED.ordinal()) {
                aPPROVED2 = ProgramExam_Status.APPROVED;
            } else {
                if (this.status == Exam_Status.PENDING.ordinal()) {
                    aPPROVED2 = ProgramExam_Status.PENDING;
                } else {
                    if (this.status == Exam_Status.READY_TO_START.ordinal()) {
                        aPPROVED2 = ProgramExam_Status.READY;
                    } else {
                        if (this.status == Exam_Status.UPLOADING.ordinal()) {
                            aPPROVED2 = ProgramExam_Status.PENDING;
                        } else {
                            ProgramExam.Status r0 = this.status == Exam_Status.FINISHED.ordinal() ? ProgramExam_Status.APPROVED : ProgramExam_Status.LOCKED;
                        }
                    }
                }
            }
        }
        return (this.status == Exam_Status.FINISHED.ordinal() ? ProgramExam_Status.APPROVED : ProgramExam_Status.LOCKED);
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

    public /* synthetic */ ExamHistoryModel(boolean z, String str, Integer integer, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long long, int i, long j, long j2, Long long2, String str9, String str10, String str11, String str12, String str13, long j3, String str14, boolean z2, int i2, g gVar) {
        int z22;
        String str172;
        int str23;
        Integer integer32;
        String str42;
        int z232 = 0;
        long long152;
        i = i2;
        int z23 = 0;
        int r1 = i & 1 != 0 ? z23 : z;
        str23 = 0;
        int r3 = i & 2 != 0 ? str23 : str;
        if (i & 4 != 0) {
            integer32 = 0;
        } else {
            integer32 = integer;
        }
        str42 = "";
        String r6 = i & 8 != 0 ? str42 : str2;
        int r8 = i & 16 != 0 ? str23 : str3;
        String r9 = i & 32 != 0 ? str42 : str4;
        String r10 = i & 64 != 0 ? str42 : str5;
        String r11 = i & 128 != 0 ? str42 : str6;
        int r12 = i & 256 != 0 ? str23 : str7;
        int r13 = i & 512 != 0 ? str23 : str8;
        int r14 = i & 1024 != 0 ? str23 : long;
        int r15 = i & 2048 != 0 ? z23 : i;
        z232 = 0;
        int r18 = i & 4096 != 0 ? z232 : j;
        int r20 = i & 8192 != 0 ? z232 : j2;
        int r2 = i & 16384 != 0 ? str23 : long2;
        int r22 = i & 32768 != 0 ? str23 : str9;
        int r23 = i & 65536 != 0 ? str23 : str10;
        int r24 = i & 131072 != 0 ? str23 : str11;
        int r25 = i & 262144 != 0 ? str23 : str12;
        if (i & 524288 == 0) {
            str23 = str13;
        }
        if (i & 1048576 == 0) {
            z232 = j3;
        }
        if (i & 2097152 == 0) {
            str42 = str14;
        }
        int r0 = i & 4194304 != 0 ? 0 : z2;
        this(z22, str23, integer32, str42, str23, str42, str42, str42, str23, str23, str23, z22, z232, j2, long152, long2, str172, str23, str23, str23, str23, str23, z232, str14, str42, (i & 4194304 != 0 ? 0 : z2));
    }

    public ExamHistoryModel() {
        this(false, null, null, null, null, null, null, null, null, null, null, 0, 0L, l, null, str, null, null, null, null, 0L, null, false, i22, null, 0, 8388607, 0);
    }

    public static /* synthetic */ ExamHistoryModel copy$default(ExamHistoryModel examHistoryModel, boolean z, String str, Integer integer, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long long, int i, long j, long j2, Long long2, String str9, String str10, String str11, String str12, String str13, long j3, String str14, boolean z2, int i2, Object object) {
        boolean userFeedbackSubmitted2;
        boolean z22;
        String str32;
        Integer integer42;
        String str52;
        String str62;
        String str72;
        String str82;
        String str92;
        String str102;
        String str112;
        Long long122;
        int i132;
        long j142;
        long long162;
        Long str182;
        long z242;
        String object262;
        String str192;
        String str202;
        String str212;
        String j222;
        String str232;
        Object examHistoryModel2 = examHistoryModel;
        i = i2;
        boolean r2 = i & 1 != 0 ? examHistoryModel2.active : z;
        String r3 = i & 2 != 0 ? examHistoryModel2.dogAvatarUrl : str;
        Integer r4 = i & 4 != 0 ? examHistoryModel2.dogGender : integer;
        String r5 = i & 8 != 0 ? examHistoryModel2.dogId : str2;
        String r6 = i & 16 != 0 ? examHistoryModel2.dogName : str3;
        String r7 = i & 32 != 0 ? examHistoryModel2.evaluatedByAvatar : str4;
        String r8 = i & 64 != 0 ? examHistoryModel2.evaluatedByName : str5;
        String r9 = i & 128 != 0 ? examHistoryModel2.evaluatedByEmail : str6;
        String r10 = i & 256 != 0 ? examHistoryModel2.examId : str7;
        String r11 = i & 512 != 0 ? examHistoryModel2.reviewComment : str8;
        Long r12 = i & 1024 != 0 ? examHistoryModel2.reviewTimeMs : long;
        int r13 = i & 2048 != 0 ? examHistoryModel2.status : i;
        long r14 = i & 4096 != 0 ? examHistoryModel2.submissionTimeMs : j;
        r14 = i & 8192 != 0 ? examHistoryModel2.unlockTimeMs : j2;
        r14 = i & 16384 != 0 ? examHistoryModel2.uploadTimeMs : long2;
        String r15 = 32768 & i != 0 ? examHistoryModel2.userId : str9;
        r15 = i & 65536 != 0 ? examHistoryModel2.videoThumbnailUrl : str10;
        r15 = i & 131072 != 0 ? examHistoryModel2.videoUrl : str11;
        r15 = i & 262144 != 0 ? examHistoryModel2.programId : str12;
        r15 = i & 524288 != 0 ? examHistoryModel2.moduleId : str13;
        r14 = i & 1048576 != 0 ? examHistoryModel2.timestamp : j3;
        r14 = i & 2097152 != 0 ? examHistoryModel2.id : str14;
        boolean r1 = i & 4194304 != 0 ? examHistoryModel2.userFeedbackSubmitted : z2;
        return examHistoryModel.copy(z22, str32, integer42, str52, str62, str72, str82, str92, str102, str112, long122, i132, (i & 4096 != 0 ? examHistoryModel2.submissionTimeMs : j), r31, (i & 8192 != 0 ? examHistoryModel2.unlockTimeMs : j2), r33, str182, (32768 & i != 0 ? examHistoryModel2.userId : str9), (i & 65536 != 0 ? examHistoryModel2.videoThumbnailUrl : str10), (i & 131072 != 0 ? examHistoryModel2.videoUrl : str11), (i & 262144 != 0 ? examHistoryModel2.programId : str12), (i & 524288 != 0 ? examHistoryModel2.moduleId : str13), (i & 1048576 != 0 ? examHistoryModel2.timestamp : j3), r41, object262, (i & 4194304 != 0 ? examHistoryModel2.userFeedbackSubmitted : z2));
    }

    /* operator */ public final boolean component1() {
        return this.active;
    }

    /* operator */ public final String component10() {
        return this.reviewComment;
    }

    /* operator */ public final Long component11() {
        return this.reviewTimeMs;
    }

    /* operator */ public final int component12() {
        return this.status;
    }

    /* operator */ public final long component13() {
        return this.submissionTimeMs;
    }

    /* operator */ public final long component14() {
        return this.unlockTimeMs;
    }

    /* operator */ public final Long component15() {
        return this.uploadTimeMs;
    }

    /* operator */ public final String component16() {
        return this.userId;
    }

    /* operator */ public final String component17() {
        return this.videoThumbnailUrl;
    }

    /* operator */ public final String component18() {
        return this.videoUrl;
    }

    /* operator */ public final String component19() {
        return this.programId;
    }

    /* operator */ public final String component2() {
        return this.dogAvatarUrl;
    }

    /* operator */ public final String component20() {
        return this.moduleId;
    }

    /* operator */ public final long component21() {
        return this.timestamp;
    }

    /* operator */ public final String component22() {
        return this.id;
    }

    /* operator */ public final boolean component23() {
        return this.userFeedbackSubmitted;
    }

    /* operator */ public final Integer component3() {
        return this.dogGender;
    }

    /* operator */ public final String component4() {
        return this.dogId;
    }

    /* operator */ public final String component5() {
        return this.dogName;
    }

    /* operator */ public final String component6() {
        return this.evaluatedByAvatar;
    }

    /* operator */ public final String component7() {
        return this.evaluatedByName;
    }

    /* operator */ public final String component8() {
        return this.evaluatedByEmail;
    }

    /* operator */ public final String component9() {
        return this.examId;
    }

    public final ExamHistoryModel copy(boolean active, String dogAvatarUrl, Integer dogGender, String dogId, String dogName, String evaluatedByAvatar, String evaluatedByName, String evaluatedByEmail, String examId, String reviewComment, Long reviewTimeMs, int status, long submissionTimeMs, long unlockTimeMs, Long uploadTimeMs, String userId, String videoThumbnailUrl, String videoUrl, String programId, String moduleId, long timestamp, String id, boolean userFeedbackSubmitted) {
        n.f(dogId, "dogId");
        n.f(id, "id");
        ExamHistoryModel examHistoryModel = new ExamHistoryModel(active, dogAvatarUrl, dogGender, dogId, dogName, evaluatedByAvatar, evaluatedByName, evaluatedByEmail, examId, reviewComment, reviewTimeMs, status, submissionTimeMs, l, unlockTimeMs, str3, uploadTimeMs, userId, videoThumbnailUrl, videoUrl, programId, moduleId, timestamp, obj2, id, userFeedbackSubmitted);
        return examHistoryModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z20 = false;
        if (!(other instanceof ExamHistoryModel)) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!n.b(this.dogAvatarUrl, other.dogAvatarUrl)) {
            return false;
        }
        if (!n.b(this.dogGender, other.dogGender)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.dogName, other.dogName)) {
            return false;
        }
        if (!n.b(this.evaluatedByAvatar, other.evaluatedByAvatar)) {
            return false;
        }
        if (!n.b(this.evaluatedByName, other.evaluatedByName)) {
            return false;
        }
        if (!n.b(this.evaluatedByEmail, other.evaluatedByEmail)) {
            return false;
        }
        if (!n.b(this.examId, other.examId)) {
            return false;
        }
        if (!n.b(this.reviewComment, other.reviewComment)) {
            return false;
        }
        if (!n.b(this.reviewTimeMs, other.reviewTimeMs)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.submissionTimeMs != other.submissionTimeMs) {
            return false;
        }
        if (this.unlockTimeMs != other.unlockTimeMs) {
            return false;
        }
        if (!n.b(this.uploadTimeMs, other.uploadTimeMs)) {
            return false;
        }
        if (!n.b(this.userId, other.userId)) {
            return false;
        }
        if (!n.b(this.videoThumbnailUrl, other.videoThumbnailUrl)) {
            return false;
        }
        if (!n.b(this.videoUrl, other.videoUrl)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.moduleId, other.moduleId)) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        return this.userFeedbackSubmitted != other.userFeedbackSubmitted ? z20 : z;
    }

    public int hashCode() {
        boolean active2;
        boolean userFeedbackSubmitted2 = true;
        int i2;
        if (this.active) {
        }
        i2 = 0;
        if (this.dogAvatarUrl == null) {
        } else {
            i2 = this.dogAvatarUrl.hashCode();
        }
        if (this.dogGender == null) {
        } else {
            i2 = this.dogGender.hashCode();
        }
        if (this.dogName == null) {
        } else {
            i2 = this.dogName.hashCode();
        }
        if (this.evaluatedByAvatar == null) {
        } else {
            i2 = this.evaluatedByAvatar.hashCode();
        }
        if (this.evaluatedByName == null) {
        } else {
            i2 = this.evaluatedByName.hashCode();
        }
        if (this.evaluatedByEmail == null) {
        } else {
            i2 = this.evaluatedByEmail.hashCode();
        }
        if (this.examId == null) {
        } else {
            i2 = this.examId.hashCode();
        }
        if (this.reviewComment == null) {
        } else {
            i2 = this.reviewComment.hashCode();
        }
        if (this.reviewTimeMs == null) {
        } else {
            i2 = this.reviewTimeMs.hashCode();
        }
        if (this.uploadTimeMs == null) {
        } else {
            i2 = this.uploadTimeMs.hashCode();
        }
        if (this.userId == null) {
        } else {
            i2 = this.userId.hashCode();
        }
        if (this.videoThumbnailUrl == null) {
        } else {
            i2 = this.videoThumbnailUrl.hashCode();
        }
        if (this.videoUrl == null) {
        } else {
            i2 = this.videoUrl.hashCode();
        }
        if (this.programId == null) {
        } else {
            i2 = this.programId.hashCode();
        }
        if (this.moduleId != null) {
            i2 = this.moduleId.hashCode();
        }
        if (!(this.userFeedbackSubmitted)) {
        }
        return (active2 * 31) + i2 * 31 + i2 * 31 + this.dogId.hashCode() * 31 + i2 * 31 + i2 * 31 + i2 * 31 + i2 * 31 + i2 * 31 + i2 * 31 + i2 * 31 + Integer.hashCode(this.status) * 31 + Long.hashCode(this.submissionTimeMs) * 31 + Long.hashCode(this.unlockTimeMs) * 31 + i2 * 31 + i2 * 31 + i2 * 31 + i2 * 31 + i2 * 31 + i2 * 31 + Long.hashCode(this.timestamp) * 31 + this.id.hashCode() * 31 + userFeedbackSubmitted2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ExamHistoryModel(active=";
        String str3 = ", dogAvatarUrl=";
        String str4 = ", dogGender=";
        String str5 = ", dogId=";
        String str6 = ", dogName=";
        String str7 = ", evaluatedByAvatar=";
        String str8 = ", evaluatedByName=";
        String str9 = ", evaluatedByEmail=";
        String str10 = ", examId=";
        String str11 = ", reviewComment=";
        String str12 = ", reviewTimeMs=";
        String str13 = ", status=";
        String str14 = ", submissionTimeMs=";
        String str15 = ", unlockTimeMs=";
        String str16 = ", uploadTimeMs=";
        String str17 = ", userId=";
        String str18 = ", videoThumbnailUrl=";
        String str19 = ", videoUrl=";
        String str20 = ", programId=";
        String str21 = ", moduleId=";
        String str22 = ", timestamp=";
        String str23 = ", id=";
        String str24 = ", userFeedbackSubmitted=";
        str = str2 + this.active + str3 + this.dogAvatarUrl + str4 + this.dogGender + str5 + this.dogId + str6 + this.dogName + str7 + this.evaluatedByAvatar + str8 + this.evaluatedByName + str9 + this.evaluatedByEmail + str10 + this.examId + str11 + this.reviewComment + str12 + this.reviewTimeMs + str13 + this.status + str14 + this.submissionTimeMs + str15 + this.unlockTimeMs + str16 + this.uploadTimeMs + str17 + this.userId + str18 + this.videoThumbnailUrl + str19 + this.videoUrl + str20 + this.programId + str21 + this.moduleId + str22 + this.timestamp + str23 + this.id + str24 + this.userFeedbackSubmitted + 41;
        return str;
    }
}
