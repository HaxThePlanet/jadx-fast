package app.dogo.com.dogo_android.model;

import java.util.Date;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u00083\u0008\u0086\u0008\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010/\u001a\u00020\u0010HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÍ\u0001\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001J\u0013\u0010?\u001a\u00020\u00032\u0008\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0010HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001bR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001bR\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001b¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/model/ExamModel;", "", "active", "", "dogAvatarUrl", "", "dogId", "dogName", "evaluatedByAvatar", "evaluatedByName", "evaluatedByEmail", "examId", "reviewComment", "reviewDate", "Ljava/util/Date;", "status", "", "userId", "videoThumbnailUrl", "videoUrl", "programId", "moduleId", "trickId", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActive", "()Z", "getDogAvatarUrl", "()Ljava/lang/String;", "getDogId", "getDogName", "getEvaluatedByAvatar", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getModuleId", "getProgramId", "getReviewComment", "getReviewDate", "()Ljava/util/Date;", "getStatus", "()I", "getTrickId", "getUserId", "getVideoThumbnailUrl", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExamModel {

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
    public ExamModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 131071, 0);
    }

    public ExamModel(boolean z, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, Date date10, int i11, String string12, String string13, String string14, String string15, String string16, String string17) {
        final Object obj = this;
        final Object obj2 = string17;
        n.f(string3, "dogId");
        n.f(obj2, "trickId");
        super();
        obj.active = z;
        obj.dogAvatarUrl = string2;
        obj.dogId = string3;
        obj.dogName = string4;
        obj.evaluatedByAvatar = string5;
        obj.evaluatedByName = string6;
        obj.evaluatedByEmail = string7;
        obj.examId = string8;
        obj.reviewComment = string9;
        obj.reviewDate = date10;
        obj.status = i11;
        obj.userId = string12;
        obj.videoThumbnailUrl = string13;
        obj.videoUrl = string14;
        obj.programId = string15;
        obj.moduleId = string16;
        obj.trickId = obj2;
    }

    public ExamModel(boolean z, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, Date date10, int i11, String string12, String string13, String string14, String string15, String string16, String string17, int i18, g g19) {
        String str2;
        int i2;
        int i12;
        int i4;
        int i9;
        String str5;
        int i;
        int i13;
        String str3;
        String str;
        String str4;
        int i6;
        int i5;
        int i3;
        int i8;
        int i10;
        int i7;
        int i14 = i18;
        i2 = i14 & 1 != 0 ? i12 : z;
        i4 = i14 & 2 != 0 ? 0 : string2;
        String str6 = "";
        str5 = i14 & 4 != 0 ? str6 : string3;
        i13 = i14 & 8 != 0 ? 0 : string4;
        str3 = i14 & 16 != 0 ? str6 : string5;
        str = i14 & 32 != 0 ? str6 : string6;
        str4 = i14 & 64 != 0 ? str6 : string7;
        i6 = i14 & 128 != 0 ? 0 : string8;
        i5 = i14 & 256 != 0 ? 0 : string9;
        i3 = i14 & 512 != 0 ? 0 : date10;
        if (i14 & 1024 != 0) {
        } else {
            i12 = i11;
        }
        i8 = i14 & 2048 != 0 ? 0 : string12;
        i10 = i14 & 4096 != 0 ? 0 : string13;
        i9 = i14 & 8192 != 0 ? 0 : string14;
        i = i14 & 16384 != 0 ? 0 : string15;
        i7 = i14 & i32 != 0 ? 0 : string16;
        str2 = i14 &= i34 != 0 ? obj20 : string17;
        super(i2, i4, str5, i13, str3, str, str4, i6, i5, i3, i12, i8, i10, i9, i, i7, str2);
    }

    public static app.dogo.com.dogo_android.model.ExamModel copy$default(app.dogo.com.dogo_android.model.ExamModel examModel, boolean z2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, Date date11, int i12, String string13, String string14, String string15, String string16, String string17, String string18, int i19, Object object20) {
        String trickId;
        boolean active;
        String dogAvatarUrl;
        String dogId;
        String dogName;
        String evaluatedByAvatar;
        String evaluatedByName;
        String evaluatedByEmail;
        String examId;
        String reviewComment;
        Date reviewDate;
        int status;
        String userId;
        String videoThumbnailUrl;
        String videoUrl;
        String programId;
        String moduleId;
        Object obj = examModel;
        int i = i19;
        active = i & 1 != 0 ? obj.active : z2;
        dogAvatarUrl = i & 2 != 0 ? obj.dogAvatarUrl : string3;
        dogId = i & 4 != 0 ? obj.dogId : string4;
        dogName = i & 8 != 0 ? obj.dogName : string5;
        evaluatedByAvatar = i & 16 != 0 ? obj.evaluatedByAvatar : string6;
        evaluatedByName = i & 32 != 0 ? obj.evaluatedByName : string7;
        evaluatedByEmail = i & 64 != 0 ? obj.evaluatedByEmail : string8;
        examId = i & 128 != 0 ? obj.examId : string9;
        reviewComment = i & 256 != 0 ? obj.reviewComment : string10;
        reviewDate = i & 512 != 0 ? obj.reviewDate : date11;
        status = i & 1024 != 0 ? obj.status : i12;
        userId = i & 2048 != 0 ? obj.userId : string13;
        videoThumbnailUrl = i & 4096 != 0 ? obj.videoThumbnailUrl : string14;
        videoUrl = i & 8192 != 0 ? obj.videoUrl : string15;
        programId = i & 16384 != 0 ? obj.programId : string16;
        moduleId = i & i20 != 0 ? obj.moduleId : string17;
        trickId = i &= i22 != 0 ? obj.trickId : string18;
        return examModel.copy(active, dogAvatarUrl, dogId, dogName, evaluatedByAvatar, evaluatedByName, evaluatedByEmail, examId, reviewComment, reviewDate, status, userId, videoThumbnailUrl, videoUrl, programId, moduleId, trickId);
    }

    public final boolean component1() {
        return this.active;
    }

    public final Date component10() {
        return this.reviewDate;
    }

    public final int component11() {
        return this.status;
    }

    public final String component12() {
        return this.userId;
    }

    public final String component13() {
        return this.videoThumbnailUrl;
    }

    public final String component14() {
        return this.videoUrl;
    }

    public final String component15() {
        return this.programId;
    }

    public final String component16() {
        return this.moduleId;
    }

    public final String component17() {
        return this.trickId;
    }

    public final String component2() {
        return this.dogAvatarUrl;
    }

    public final String component3() {
        return this.dogId;
    }

    public final String component4() {
        return this.dogName;
    }

    public final String component5() {
        return this.evaluatedByAvatar;
    }

    public final String component6() {
        return this.evaluatedByName;
    }

    public final String component7() {
        return this.evaluatedByEmail;
    }

    public final String component8() {
        return this.examId;
    }

    public final String component9() {
        return this.reviewComment;
    }

    public final app.dogo.com.dogo_android.model.ExamModel copy(boolean z, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, Date date10, int i11, String string12, String string13, String string14, String string15, String string16, String string17) {
        boolean z2 = z;
        n.f(string3, "dogId");
        n.f(string17, "trickId");
        super(z, string2, string3, string4, string5, string6, string7, string8, string9, date10, i11, string12, string13, string14, string15, string16, string17);
        return examModel2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ExamModel) {
            return i2;
        }
        if (this.active != object.active) {
            return i2;
        }
        if (!n.b(this.dogAvatarUrl, object.dogAvatarUrl)) {
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
        if (!n.b(this.reviewDate, object.reviewDate)) {
            return i2;
        }
        if (this.status != object.status) {
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
        if (!n.b(this.trickId, object.trickId)) {
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

    public int hashCode() {
        boolean active;
        int i13;
        int i3;
        int i11;
        int i6;
        int i5;
        int i7;
        int i4;
        int i;
        int i8;
        int i9;
        int i10;
        int i2;
        int i12;
        if (this.active) {
            active = 1;
        }
        String dogAvatarUrl = this.dogAvatarUrl;
        i12 = 0;
        if (dogAvatarUrl == null) {
            i13 = i12;
        } else {
            i13 = dogAvatarUrl.hashCode();
        }
        String dogName = this.dogName;
        if (dogName == null) {
            i3 = i12;
        } else {
            i3 = dogName.hashCode();
        }
        String evaluatedByAvatar = this.evaluatedByAvatar;
        if (evaluatedByAvatar == null) {
            i11 = i12;
        } else {
            i11 = evaluatedByAvatar.hashCode();
        }
        String evaluatedByName = this.evaluatedByName;
        if (evaluatedByName == null) {
            i6 = i12;
        } else {
            i6 = evaluatedByName.hashCode();
        }
        String evaluatedByEmail = this.evaluatedByEmail;
        if (evaluatedByEmail == null) {
            i5 = i12;
        } else {
            i5 = evaluatedByEmail.hashCode();
        }
        String examId = this.examId;
        if (examId == null) {
            i7 = i12;
        } else {
            i7 = examId.hashCode();
        }
        String reviewComment = this.reviewComment;
        if (reviewComment == null) {
            i4 = i12;
        } else {
            i4 = reviewComment.hashCode();
        }
        Date reviewDate = this.reviewDate;
        if (reviewDate == null) {
            i = i12;
        } else {
            i = reviewDate.hashCode();
        }
        String userId = this.userId;
        if (userId == null) {
            i8 = i12;
        } else {
            i8 = userId.hashCode();
        }
        String videoThumbnailUrl = this.videoThumbnailUrl;
        if (videoThumbnailUrl == null) {
            i9 = i12;
        } else {
            i9 = videoThumbnailUrl.hashCode();
        }
        String videoUrl = this.videoUrl;
        if (videoUrl == null) {
            i10 = i12;
        } else {
            i10 = videoUrl.hashCode();
        }
        String programId = this.programId;
        if (programId == null) {
            i2 = i12;
        } else {
            i2 = programId.hashCode();
        }
        String moduleId = this.moduleId;
        if (moduleId == null) {
        } else {
            i12 = moduleId.hashCode();
        }
        return i44 += i48;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExamModel(active=");
        stringBuilder.append(this.active);
        stringBuilder.append(", dogAvatarUrl=");
        stringBuilder.append(this.dogAvatarUrl);
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
        stringBuilder.append(", reviewDate=");
        stringBuilder.append(this.reviewDate);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
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
        stringBuilder.append(", trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
