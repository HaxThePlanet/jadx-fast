package app.dogo.com.dogo_android.model;

import java.util.Date;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ExamModel.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u00083\u0008\u0086\u0008\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010/\u001a\u00020\u0010HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÍ\u0001\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001J\u0013\u0010?\u001a\u00020\u00032\u0008\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0010HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001bR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001bR\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001b¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/model/ExamModel;", "", "active", "", "dogAvatarUrl", "", "dogId", "dogName", "evaluatedByAvatar", "evaluatedByName", "evaluatedByEmail", "examId", "reviewComment", "reviewDate", "Ljava/util/Date;", "status", "", "userId", "videoThumbnailUrl", "videoUrl", "programId", "moduleId", "trickId", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActive", "()Z", "getDogAvatarUrl", "()Ljava/lang/String;", "getDogId", "getDogName", "getEvaluatedByAvatar", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getModuleId", "getProgramId", "getReviewComment", "getReviewDate", "()Ljava/util/Date;", "getStatus", "()I", "getTrickId", "getUserId", "getVideoThumbnailUrl", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ExamModel {

    private final boolean active;
    private final String dogAvatarUrl;
    private final String dogId;
    private final String dogName;
    private final String evaluatedByAvatar;
    private final String evaluatedByEmail;
    private final String evaluatedByName;
    private final String examId;
    private final String moduleId;
    private final String programId;
    private final String reviewComment;
    private final Date reviewDate;
    private final int status;
    private final String trickId;
    private final String userId;
    private final String videoThumbnailUrl;
    private final String videoUrl;
    public ExamModel(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Date date, int i, String str9, String str10, String str11, String str12, String str13, String str14) {
        final Object z3 = this;
        final Object str172 = str14;
        n.f(str2, "dogId");
        n.f(str172, "trickId");
        super();
        z3.active = z;
        z3.dogAvatarUrl = str;
        z3.dogId = str2;
        z3.dogName = str3;
        z3.evaluatedByAvatar = str4;
        z3.evaluatedByName = str5;
        z3.evaluatedByEmail = str6;
        z3.examId = str7;
        z3.reviewComment = str8;
        z3.reviewDate = date;
        z3.status = i;
        z3.userId = str9;
        z3.videoThumbnailUrl = str10;
        z3.videoUrl = str11;
        z3.programId = str12;
        z3.moduleId = str13;
        z3.trickId = str172;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final String getDogAvatarUrl() {
        return this.dogAvatarUrl;
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

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getReviewComment() {
        return this.reviewComment;
    }

    public final Date getReviewDate() {
        return this.reviewDate;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTrickId() {
        return this.trickId;
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

    public /* synthetic */ ExamModel(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Date date, int i, String str9, String str10, String str11, String str12, String str13, String str14, int i2, g gVar) {
        String str172;
        int z2;
        int str22 = 0;
        int str142 = 0;
        int str152 = 0;
        int str42 = 0;
        int str82 = 0;
        int str92 = 0;
        int date102 = 0;
        int str122 = 0;
        int str132 = 0;
        int str162 = 0;
        int i182 = i2;
        z2 = 0;
        int r1 = i182 & 1 != 0 ? 0 : z;
        int r3 = i182 & 2 != 0 ? 0 : str;
        str172 = "";
        String r5 = i182 & 4 != 0 ? str172 : str2;
        int r7 = i182 & 8 != 0 ? 0 : str3;
        String r8 = i182 & 16 != 0 ? str172 : str4;
        String r9 = i182 & 32 != 0 ? str172 : str5;
        String r10 = i182 & 64 != 0 ? str172 : str6;
        int r11 = i182 & 128 != 0 ? 0 : str7;
        int r12 = i182 & 256 != 0 ? 0 : str8;
        int r13 = i182 & 512 != 0 ? 0 : date;
        if (i182 & 1024 == 0) {
            z2 = i;
        }
        int r14 = i182 & 2048 != 0 ? 0 : str9;
        int r15 = i182 & 4096 != 0 ? 0 : str10;
        int r4 = i182 & 8192 != 0 ? 0 : str11;
        int r6 = i182 & 16384 != 0 ? 0 : str12;
        int r16 = i182 & 32768 != 0 ? 0 : str13;
        String r0 = i182 & 65536 != 0 ? str172 : str14;
        this(z2, str22, str172, str42, str172, str172, str172, str82, str92, date102, z2, str122, str132, str142, str152, str162, (i182 & 65536 != 0 ? str172 : str14));
    }

    public ExamModel() {
        this(false, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ ExamModel copy$default(ExamModel examModel, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Date date, int i, String str9, String str10, String str11, String str12, String str13, String str14, int i2, Object object) {
        String str182;
        boolean z22;
        String str32;
        String str42;
        String str52;
        String str62;
        String str72;
        String str82;
        String str92;
        String str102;
        Date date112;
        int i122;
        String str132;
        String str142;
        String str152;
        String str162;
        String str172;
        Object examModel2 = examModel;
        int i192 = i2;
        boolean r2 = i192 & 1 != 0 ? examModel2.active : z;
        String r3 = i192 & 2 != 0 ? examModel2.dogAvatarUrl : str;
        String r4 = i192 & 4 != 0 ? examModel2.dogId : str2;
        String r5 = i192 & 8 != 0 ? examModel2.dogName : str3;
        String r6 = i192 & 16 != 0 ? examModel2.evaluatedByAvatar : str4;
        String r7 = i192 & 32 != 0 ? examModel2.evaluatedByName : str5;
        String r8 = i192 & 64 != 0 ? examModel2.evaluatedByEmail : str6;
        String r9 = i192 & 128 != 0 ? examModel2.examId : str7;
        String r10 = i192 & 256 != 0 ? examModel2.reviewComment : str8;
        Date r11 = i192 & 512 != 0 ? examModel2.reviewDate : date;
        int r12 = i192 & 1024 != 0 ? examModel2.status : i;
        String r13 = i192 & 2048 != 0 ? examModel2.userId : str9;
        String r14 = i192 & 4096 != 0 ? examModel2.videoThumbnailUrl : str10;
        String r15 = i192 & 8192 != 0 ? examModel2.videoUrl : str11;
        r15 = i192 & 16384 != 0 ? examModel2.programId : str12;
        r15 = i192 & 32768 != 0 ? examModel2.moduleId : str13;
        String r1 = i192 & 65536 != 0 ? examModel2.trickId : str14;
        return examModel.copy(z22, str32, str42, str52, str62, str72, str82, str92, str102, date112, i122, str132, str142, (i192 & 8192 != 0 ? examModel2.videoUrl : str11), (i192 & 16384 != 0 ? examModel2.programId : str12), str172, (i192 & 65536 != 0 ? examModel2.trickId : str14));
    }

    /* operator */ public final boolean component1() {
        return this.active;
    }

    /* operator */ public final Date component10() {
        return this.reviewDate;
    }

    /* operator */ public final int component11() {
        return this.status;
    }

    /* operator */ public final String component12() {
        return this.userId;
    }

    /* operator */ public final String component13() {
        return this.videoThumbnailUrl;
    }

    /* operator */ public final String component14() {
        return this.videoUrl;
    }

    /* operator */ public final String component15() {
        return this.programId;
    }

    /* operator */ public final String component16() {
        return this.moduleId;
    }

    /* operator */ public final String component17() {
        return this.trickId;
    }

    /* operator */ public final String component2() {
        return this.dogAvatarUrl;
    }

    /* operator */ public final String component3() {
        return this.dogId;
    }

    /* operator */ public final String component4() {
        return this.dogName;
    }

    /* operator */ public final String component5() {
        return this.evaluatedByAvatar;
    }

    /* operator */ public final String component6() {
        return this.evaluatedByName;
    }

    /* operator */ public final String component7() {
        return this.evaluatedByEmail;
    }

    /* operator */ public final String component8() {
        return this.examId;
    }

    /* operator */ public final String component9() {
        return this.reviewComment;
    }

    public final ExamModel copy(boolean active, String dogAvatarUrl, String dogId, String dogName, String evaluatedByAvatar, String evaluatedByName, String evaluatedByEmail, String examId, String reviewComment, Date reviewDate, int status, String userId, String videoThumbnailUrl, String videoUrl, String programId, String moduleId, String trickId) {
        n.f(dogId, "dogId");
        n.f(trickId, "trickId");
        ExamModel examModel = new ExamModel(active, dogAvatarUrl, dogId, dogName, evaluatedByAvatar, evaluatedByName, evaluatedByEmail, examId, reviewComment, reviewDate, status, userId, videoThumbnailUrl, videoUrl, programId, moduleId, trickId);
        return examModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z17 = false;
        if (!(other instanceof ExamModel)) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!n.b(this.dogAvatarUrl, other.dogAvatarUrl)) {
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
        if (!n.b(this.reviewDate, other.reviewDate)) {
            return false;
        }
        if (this.status != other.status) {
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
        return !n.b(this.trickId, other.trickId) ? z17 : z;
    }

    public int hashCode() {
        boolean active2 = true;
        int i;
        if (this.active) {
            int i34 = 1;
        }
        i = 0;
        if (this.dogAvatarUrl == null) {
        } else {
            i = this.dogAvatarUrl.hashCode();
        }
        if (this.dogName == null) {
        } else {
            i = this.dogName.hashCode();
        }
        if (this.evaluatedByAvatar == null) {
        } else {
            i = this.evaluatedByAvatar.hashCode();
        }
        if (this.evaluatedByName == null) {
        } else {
            i = this.evaluatedByName.hashCode();
        }
        if (this.evaluatedByEmail == null) {
        } else {
            i = this.evaluatedByEmail.hashCode();
        }
        if (this.examId == null) {
        } else {
            i = this.examId.hashCode();
        }
        if (this.reviewComment == null) {
        } else {
            i = this.reviewComment.hashCode();
        }
        if (this.reviewDate == null) {
        } else {
            i = this.reviewDate.hashCode();
        }
        if (this.userId == null) {
        } else {
            i = this.userId.hashCode();
        }
        if (this.videoThumbnailUrl == null) {
        } else {
            i = this.videoThumbnailUrl.hashCode();
        }
        if (this.videoUrl == null) {
        } else {
            i = this.videoUrl.hashCode();
        }
        if (this.programId == null) {
        } else {
            i = this.programId.hashCode();
        }
        if (this.moduleId != null) {
            i = this.moduleId.hashCode();
        }
        return (active2 * 31) + i * 31 + this.dogId.hashCode() * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + Integer.hashCode(this.status) * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + this.trickId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ExamModel(active=";
        String str3 = ", dogAvatarUrl=";
        String str4 = ", dogId=";
        String str5 = ", dogName=";
        String str6 = ", evaluatedByAvatar=";
        String str7 = ", evaluatedByName=";
        String str8 = ", evaluatedByEmail=";
        String str9 = ", examId=";
        String str10 = ", reviewComment=";
        String str11 = ", reviewDate=";
        String str12 = ", status=";
        String str13 = ", userId=";
        String str14 = ", videoThumbnailUrl=";
        String str15 = ", videoUrl=";
        String str16 = ", programId=";
        String str17 = ", moduleId=";
        String str18 = ", trickId=";
        str = str2 + this.active + str3 + this.dogAvatarUrl + str4 + this.dogId + str5 + this.dogName + str6 + this.evaluatedByAvatar + str7 + this.evaluatedByName + str8 + this.evaluatedByEmail + str9 + this.examId + str10 + this.reviewComment + str11 + this.reviewDate + str12 + this.status + str13 + this.userId + str14 + this.videoThumbnailUrl + str15 + this.videoUrl + str16 + this.programId + str17 + this.moduleId + str18 + this.trickId + 41;
        return str;
    }
}
