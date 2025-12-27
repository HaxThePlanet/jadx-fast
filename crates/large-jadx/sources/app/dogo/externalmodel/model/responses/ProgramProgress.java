package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;
import kotlin.y.p;

/* compiled from: ProgramProgress.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0008/0123456BO\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0008\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0002\u0010\u000cJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0003JX\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00052\u0010\u0008\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020!HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0013\u0010\u000eR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017¨\u00067", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "Landroid/os/Parcelable;", "id", "", "startTimeMs", "", "completeTimeMs", "masterTimeMs", "graduationTimeMs", "modules", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)V", "getCompleteTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGraduationTimeMs", "getId", "()Ljava/lang/String;", "getMasterTimeMs", "getModules", "()Ljava/util/List;", "getStartTimeMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "describeContents", "", "equals", "", "other", "", "hashCode", "isPassed", "isStarted", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ExamSubmission", "LessonProgress", "ModuleExam", "ModuleProgress", "ProgramExamStatus", "QuestionStatus", "TaskStatus", "TrickStatus", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramProgress implements Parcelable {

    public static final Parcelable.Creator<ProgramProgress> CREATOR = new ProgramProgress$Creator<>();
    private final Long completeTimeMs;
    private final Long graduationTimeMs;
    private final String id;
    private final Long masterTimeMs;
    private final List<ProgramProgress.ModuleProgress> modules;
    private final long startTimeMs;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramProgress> {
        @Override // android.os.Parcelable$Creator
        public final ProgramProgress createFromParcel(Parcel parcel) {
            Long num3;
            Long num2;
            Object obj;
            int i2 = 0;
            Object fromParcel;
            n.f(parcel, "parcel");
            int i = 0;
            if (parcel.readInt() == 0) {
            } else {
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            int _int4 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int4);
            i2 = 0;
            while (i2 != _int4) {
                arrayList.add(fromParcel);
                i2 = i2 + 1;
            }
            ProgramProgress parcel2 = new ProgramProgress(parcel.readString(), parcel.readLong(), l, num3, num2, obj, arrayList);
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramProgress[] newArray(int i) {
            return new ProgramProgress[i];
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u00082\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B½\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0010HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003JÆ\u0001\u0010@\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010AJ\t\u0010B\u001a\u00020CHÖ\u0001J\u0013\u0010D\u001a\u00020\u00102\u0008\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020CHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\u0019\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020CHÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0018R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010%\u001a\u0004\u0008#\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010%\u001a\u0004\u0008)\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010%\u001a\u0004\u0008*\u0010$R\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u0018¨\u0006N", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "Landroid/os/Parcelable;", "id", "", "examId", "timestamp", "", "reviewComment", "programId", "moduleId", "reviewTimeMs", "status", "videoThumbnailUrl", "videoUrl", "uploadTimeMs", "hasNewFeedback", "", "unlockTimeMs", "evaluatedByAvatar", "evaluatedByName", "userFeedbackSubmitted", "evaluatedByEmail", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getEvaluatedByAvatar", "()Ljava/lang/String;", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getHasNewFeedback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getModuleId", "getProgramId", "getReviewComment", "getReviewTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "getTimestamp", "()J", "getUnlockTimeMs", "getUploadTimeMs", "getUserFeedbackSubmitted", "()Z", "getVideoThumbnailUrl", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ExamSubmission implements Parcelable {

        public static final Parcelable.Creator<ProgramProgress.ExamSubmission> CREATOR = new ProgramProgress$ExamSubmission$Creator<>();
        private final String evaluatedByAvatar;
        private final String evaluatedByEmail;
        private final String evaluatedByName;
        private final String examId;
        private final Boolean hasNewFeedback;
        private final String id;
        private final String moduleId;
        private final String programId;
        private final String reviewComment;
        private final Long reviewTimeMs;
        private final String status;
        private final long timestamp;
        private final Long unlockTimeMs;
        private final Long uploadTimeMs;
        private final boolean userFeedbackSubmitted;
        private final String videoThumbnailUrl;
        private final String videoUrl;
        public ExamSubmission(String str, String str2, long j, String str3, String str4, String str5, Long long, String str6, String str7, String str8, Long long2, Boolean boolean, Long long3, String str9, String str10, boolean z, String str11) {
            final Object str72 = this;
            final Object str92 = str6;
            final Object str102 = str7;
            final Object long112 = str8;
            final Object str152 = str9;
            final Object z162 = str10;
            final Object obj = str11;
            n.f(str, "id");
            n.f(str2, "examId");
            n.f(str92, "status");
            n.f(str102, "videoThumbnailUrl");
            n.f(long112, "videoUrl");
            n.f(str152, "evaluatedByAvatar");
            n.f(z162, "evaluatedByName");
            n.f(obj, "evaluatedByEmail");
            super();
            str72.id = str;
            str72.examId = str2;
            str72.timestamp = j;
            str72.reviewComment = str3;
            str72.programId = str4;
            str72.moduleId = str5;
            str72.reviewTimeMs = long;
            str72.status = str92;
            str72.videoThumbnailUrl = str102;
            str72.videoUrl = long112;
            str72.uploadTimeMs = long2;
            str72.hasNewFeedback = boolean;
            str72.unlockTimeMs = long3;
            str72.evaluatedByAvatar = str152;
            str72.evaluatedByName = z162;
            str72.userFeedbackSubmitted = z;
            str72.evaluatedByEmail = obj;
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

        public final Boolean getHasNewFeedback() {
            return this.hasNewFeedback;
        }

        public final String getId() {
            return this.id;
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

        public final Long getReviewTimeMs() {
            return this.reviewTimeMs;
        }

        public final String getStatus() {
            return this.status;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Long getUnlockTimeMs() {
            return this.unlockTimeMs;
        }

        public final Long getUploadTimeMs() {
            return this.uploadTimeMs;
        }

        public final boolean getUserFeedbackSubmitted() {
            return this.userFeedbackSubmitted;
        }

        public final String getVideoThumbnailUrl() {
            return this.videoThumbnailUrl;
        }

        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public /* synthetic */ ExamSubmission(String str, String str2, long j, String str3, String str4, String str5, Long long, String str6, String str7, String str8, Long long2, Boolean boolean, Long long3, String str9, String str10, boolean z, String str11, int i, g gVar) {
            String i182;
            int j32 = 0;
            String str52 = null;
            int str142 = 0;
            int str62 = 0;
            int long72 = 0;
            int str82 = 0;
            int boolean122 = 0;
            Boolean long132;
            int str172 = 0;
            int gVar192 = i;
            i182 = "";
            String r1 = gVar192 & 1 != 0 ? i182 : str;
            String r3 = gVar192 & 2 != 0 ? i182 : str2;
            int r4 = gVar192 & 4 != 0 ? 0 : j;
            int r6 = gVar192 & 8 != 0 ? 0 : str3;
            int r8 = gVar192 & 16 != 0 ? 0 : str4;
            int r9 = gVar192 & 32 != 0 ? 0 : str5;
            int r10 = gVar192 & 64 != 0 ? 0 : long;
            String r11 = gVar192 & 128 != 0 ? i182 : str6;
            String r12 = gVar192 & 256 != 0 ? i182 : str7;
            String r13 = gVar192 & 512 != 0 ? i182 : str8;
            int r14 = gVar192 & 1024 != 0 ? 0 : long2;
            Boolean r15 = gVar192 & 2048 != 0 ? Boolean.FALSE : boolean;
            int r7 = gVar192 & 4096 != 0 ? 0 : long3;
            String r2 = gVar192 & 8192 != 0 ? i182 : str9;
            r2 = gVar192 & 16384 != 0 ? i182 : str10;
            int r17 = gVar192 & 32768 != 0 ? 0 : z;
            String r0 = gVar192 & 65536 != 0 ? i182 : str11;
            this(i182, i182, j32, str3, str52, str62, long72, str82, i182, i182, i182, boolean122, long132, str142, (gVar192 & 8192 != 0 ? i182 : str9), i182, str172, (gVar192 & 65536 != 0 ? i182 : str11));
        }


        public ExamSubmission() {
            this(null, null, 0L, str, null, null, null, null, null, null, null, null, null, null, null, false, null, 0, 131071, 0);
        }

        public static /* synthetic */ ProgramProgress.ExamSubmission copy$default(ProgramProgress.ExamSubmission examSubmission, String str, String str2, long j, String str3, String str4, String str5, Long long, String str6, String str7, String str8, Long long2, Boolean boolean, Long long3, String str9, String str10, boolean z, String str11, int i, Object object) {
            String i192;
            String str22;
            String str32;
            long j42;
            String str62;
            String str72;
            String long82;
            Long str92;
            String str102;
            String str112;
            String long122;
            Long boolean132;
            Boolean long142;
            Long str152;
            String str162;
            String z172;
            boolean str182;
            Object examSubmission2 = examSubmission;
            int object202 = i;
            String r2 = object202 & 1 != 0 ? examSubmission2.id : str;
            String r3 = object202 & 2 != 0 ? examSubmission2.examId : str2;
            long r4 = object202 & 4 != 0 ? examSubmission2.timestamp : j;
            String r6 = object202 & 8 != 0 ? examSubmission2.reviewComment : str3;
            String r7 = object202 & 16 != 0 ? examSubmission2.programId : str4;
            String r8 = object202 & 32 != 0 ? examSubmission2.moduleId : str5;
            Long r9 = object202 & 64 != 0 ? examSubmission2.reviewTimeMs : long;
            String r10 = object202 & 128 != 0 ? examSubmission2.status : str6;
            String r11 = object202 & 256 != 0 ? examSubmission2.videoThumbnailUrl : str7;
            String r12 = object202 & 512 != 0 ? examSubmission2.videoUrl : str8;
            Long r13 = object202 & 1024 != 0 ? examSubmission2.uploadTimeMs : long2;
            Boolean r14 = object202 & 2048 != 0 ? examSubmission2.hasNewFeedback : boolean;
            Long r15 = object202 & 4096 != 0 ? examSubmission2.unlockTimeMs : long3;
            r15 = object202 & 8192 != 0 ? examSubmission2.evaluatedByAvatar : str9;
            r15 = object202 & 16384 != 0 ? examSubmission2.evaluatedByName : str10;
            r15 = object202 & 32768 != 0 ? examSubmission2.userFeedbackSubmitted : z;
            String r1 = object202 & 65536 != 0 ? examSubmission2.evaluatedByEmail : str11;
            return examSubmission.copy(str22, str32, j42, r21, str62, str72, long82, str92, str102, str112, long122, boolean132, long142, (object202 & 4096 != 0 ? examSubmission2.unlockTimeMs : long3), (object202 & 8192 != 0 ? examSubmission2.evaluatedByAvatar : str9), (object202 & 16384 != 0 ? examSubmission2.evaluatedByName : str10), str182, (object202 & 65536 != 0 ? examSubmission2.evaluatedByEmail : str11));
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component10() {
            return this.videoUrl;
        }

        /* operator */ public final Long component11() {
            return this.uploadTimeMs;
        }

        /* operator */ public final Boolean component12() {
            return this.hasNewFeedback;
        }

        /* operator */ public final Long component13() {
            return this.unlockTimeMs;
        }

        /* operator */ public final String component14() {
            return this.evaluatedByAvatar;
        }

        /* operator */ public final String component15() {
            return this.evaluatedByName;
        }

        /* operator */ public final boolean component16() {
            return this.userFeedbackSubmitted;
        }

        /* operator */ public final String component17() {
            return this.evaluatedByEmail;
        }

        /* operator */ public final String component2() {
            return this.examId;
        }

        /* operator */ public final long component3() {
            return this.timestamp;
        }

        /* operator */ public final String component4() {
            return this.reviewComment;
        }

        /* operator */ public final String component5() {
            return this.programId;
        }

        /* operator */ public final String component6() {
            return this.moduleId;
        }

        /* operator */ public final Long component7() {
            return this.reviewTimeMs;
        }

        /* operator */ public final String component8() {
            return this.status;
        }

        /* operator */ public final String component9() {
            return this.videoThumbnailUrl;
        }

        public final ProgramProgress.ExamSubmission copy(String id, String examId, long timestamp, String reviewComment, String programId, String moduleId, Long reviewTimeMs, String status, String videoThumbnailUrl, String videoUrl, Long uploadTimeMs, Boolean hasNewFeedback, Long unlockTimeMs, String evaluatedByAvatar, String evaluatedByName, boolean userFeedbackSubmitted, String evaluatedByEmail) {
            Object id2 = id;
            n.f(id2, "id");
            n.f(examId, "examId");
            n.f(status, "status");
            n.f(videoThumbnailUrl, "videoThumbnailUrl");
            n.f(videoUrl, "videoUrl");
            n.f(evaluatedByAvatar, "evaluatedByAvatar");
            n.f(evaluatedByName, "evaluatedByName");
            n.f(evaluatedByEmail, "evaluatedByEmail");
            ProgramProgress_ExamSubmission programProgress_ExamSubmission = new ProgramProgress_ExamSubmission(id2, examId, timestamp, str10, reviewComment, programId, moduleId, reviewTimeMs, status, videoThumbnailUrl, videoUrl, uploadTimeMs, hasNewFeedback, unlockTimeMs, evaluatedByAvatar, evaluatedByName, userFeedbackSubmitted, evaluatedByEmail);
            return programProgress_ExamSubmission;
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
            final boolean z17 = false;
            if (!(other instanceof ProgramProgress_ExamSubmission)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.examId, other.examId)) {
                return false;
            }
            if (this.timestamp != other.timestamp) {
                return false;
            }
            if (!n.b(this.reviewComment, other.reviewComment)) {
                return false;
            }
            if (!n.b(this.programId, other.programId)) {
                return false;
            }
            if (!n.b(this.moduleId, other.moduleId)) {
                return false;
            }
            if (!n.b(this.reviewTimeMs, other.reviewTimeMs)) {
                return false;
            }
            if (!n.b(this.status, other.status)) {
                return false;
            }
            if (!n.b(this.videoThumbnailUrl, other.videoThumbnailUrl)) {
                return false;
            }
            if (!n.b(this.videoUrl, other.videoUrl)) {
                return false;
            }
            if (!n.b(this.uploadTimeMs, other.uploadTimeMs)) {
                return false;
            }
            if (!n.b(this.hasNewFeedback, other.hasNewFeedback)) {
                return false;
            }
            if (!n.b(this.unlockTimeMs, other.unlockTimeMs)) {
                return false;
            }
            if (!n.b(this.evaluatedByAvatar, other.evaluatedByAvatar)) {
                return false;
            }
            if (!n.b(this.evaluatedByName, other.evaluatedByName)) {
                return false;
            }
            if (this.userFeedbackSubmitted != other.userFeedbackSubmitted) {
                return false;
            }
            return !n.b(this.evaluatedByEmail, other.evaluatedByEmail) ? z17 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            boolean userFeedbackSubmitted2 = true;
            i = 0;
            if (this.reviewComment == null) {
            } else {
                i = this.reviewComment.hashCode();
            }
            if (this.programId == null) {
            } else {
                i = this.programId.hashCode();
            }
            if (this.moduleId == null) {
            } else {
                i = this.moduleId.hashCode();
            }
            if (this.reviewTimeMs == null) {
            } else {
                i = this.reviewTimeMs.hashCode();
            }
            if (this.uploadTimeMs == null) {
            } else {
                i = this.uploadTimeMs.hashCode();
            }
            if (this.hasNewFeedback == null) {
            } else {
                i = this.hasNewFeedback.hashCode();
            }
            if (this.unlockTimeMs != null) {
                i = this.unlockTimeMs.hashCode();
            }
            if (this.userFeedbackSubmitted) {
                int i42 = 1;
            }
            return (this.id.hashCode() * 31) + this.examId.hashCode() * 31 + Long.hashCode(this.timestamp) * 31 + i * 31 + i * 31 + i * 31 + i * 31 + this.status.hashCode() * 31 + this.videoThumbnailUrl.hashCode() * 31 + this.videoUrl.hashCode() * 31 + i * 31 + i * 31 + i * 31 + this.evaluatedByAvatar.hashCode() * 31 + this.evaluatedByName.hashCode() * 31 + userFeedbackSubmitted2 * 31 + this.evaluatedByEmail.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ExamSubmission(id=";
            String str3 = ", examId=";
            String str4 = ", timestamp=";
            String str5 = ", reviewComment=";
            String str6 = ", programId=";
            String str7 = ", moduleId=";
            String str8 = ", reviewTimeMs=";
            String str9 = ", status=";
            String str10 = ", videoThumbnailUrl=";
            String str11 = ", videoUrl=";
            String str12 = ", uploadTimeMs=";
            String str13 = ", hasNewFeedback=";
            String str14 = ", unlockTimeMs=";
            String str15 = ", evaluatedByAvatar=";
            String str16 = ", evaluatedByName=";
            String str17 = ", userFeedbackSubmitted=";
            String str18 = ", evaluatedByEmail=";
            str = str2 + this.id + str3 + this.examId + str4 + this.timestamp + str5 + this.reviewComment + str6 + this.programId + str7 + this.moduleId + str8 + this.reviewTimeMs + str9 + this.status + str10 + this.videoThumbnailUrl + str11 + this.videoUrl + str12 + this.uploadTimeMs + str13 + this.hasNewFeedback + str14 + this.unlockTimeMs + str15 + this.evaluatedByAvatar + str16 + this.evaluatedByName + str17 + this.userFeedbackSubmitted + str18 + this.evaluatedByEmail + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            long value2;
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.examId);
            parcel.writeLong(this.timestamp);
            parcel.writeString(this.reviewComment);
            parcel.writeString(this.programId);
            parcel.writeString(this.moduleId);
            int i = 0;
            final int i2 = 1;
            if (this.reviewTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.reviewTimeMs.longValue());
            }
            parcel.writeString(this.status);
            parcel.writeString(this.videoThumbnailUrl);
            parcel.writeString(this.videoUrl);
            if (this.uploadTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.uploadTimeMs.longValue());
            }
            if (this.hasNewFeedback == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeInt(this.hasNewFeedback.booleanValue());
            }
            if (this.unlockTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.unlockTimeMs.longValue());
            }
            parcel.writeString(this.evaluatedByAvatar);
            parcel.writeString(this.evaluatedByName);
            parcel.writeInt(this.userFeedbackSubmitted);
            parcel.writeString(this.evaluatedByEmail);
        }
    }

    @Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bw\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rHÆ\u0003J\u0080\u0001\u0010)\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rHÆ\u0001¢\u0006\u0002\u0010*J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0013\u0010,\u001a\u00020-2\u0008\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\u0006\u00100\u001a\u00020\u0007J\t\u00101\u001a\u00020\u0005HÖ\u0001J\u0006\u00102\u001a\u00020-J\u0006\u00103\u001a\u00020-J\u0006\u00104\u001a\u00020-J\u0006\u00105\u001a\u00020-J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001f\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001f¨\u0006<", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "Landroid/os/Parcelable;", "id", "", "index", "", "startTimeMs", "", "completeTimeMs", "masterTimeMs", "question", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;", "tricks", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "tasks", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TaskStatus;", "(Ljava/lang/String;IJLjava/lang/Long;Ljava/lang/Long;Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;Ljava/util/Map;Ljava/util/Map;)V", "getCompleteTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "()Ljava/lang/String;", "getIndex", "()I", "getMasterTimeMs", "getQuestion", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;", "getStartTimeMs", "()J", "getTasks", "()Ljava/util/Map;", "getTricks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;IJLjava/lang/Long;Ljava/lang/Long;Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;Ljava/util/Map;Ljava/util/Map;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "describeContents", "equals", "", "other", "", "getLastUserInteractionTimeMs", "hashCode", "isInProgress", "isMastered", "isPassed", "isStarted", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LessonProgress implements Parcelable {

        public static final Parcelable.Creator<ProgramProgress.LessonProgress> CREATOR = new ProgramProgress$LessonProgress$Creator<>();
        private final Long completeTimeMs;
        private final String id;
        private final int index;
        private final Long masterTimeMs;
        private final ProgramProgress.QuestionStatus question;
        private final long startTimeMs;
        private final Map<String, ProgramProgress.TaskStatus> tasks;
        private final Map<String, ProgramProgress.TrickStatus> tricks;
        public LessonProgress(String str, int i, long j, Long long, Long long2, ProgramProgress.QuestionStatus questionStatus, Map<String, ProgramProgress.TrickStatus> map, Map<String, ProgramProgress.TaskStatus> map2) {
            n.f(str, "id");
            n.f(map, "tricks");
            n.f(map2, "tasks");
            super();
            this.id = str;
            this.index = i;
            this.startTimeMs = j;
            this.completeTimeMs = long;
            this.masterTimeMs = long2;
            this.question = questionStatus;
            this.tricks = map;
            this.tasks = map2;
        }

        public final Long getCompleteTimeMs() {
            return this.completeTimeMs;
        }

        public final String getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        public final long getLastUserInteractionTimeMs() {
            long timestamp3;
            Object item2;
            Object item;
            long timestamp4 = 0;
            long timestamp5;
            boolean hasNext2;
            long timestamp;
            long timestamp2;
            int cmp2;
            Iterator it = this.tasks.values().iterator();
            int i = 0;
            if (!it.hasNext()) {
            } else {
                if (it.hasNext()) {
                    if (item2 == null) {
                    } else {
                        timestamp5 = item2.getTimestamp();
                    }
                    item2 = it.next();
                    do {
                        item2 = it.next();
                        timestamp5 = item2.getTimestamp();
                    } while (item2 == null);
                }
            }
            i = item2 == null ? i : timestamp;
            i = this.question == null ? i : timestamp2;
            final Iterator it2 = this.tricks.values().iterator();
            if (it2.hasNext()) {
                if (it2.hasNext()) {
                    if (item == null) {
                    } else {
                        timestamp3 = item.getTimestamp();
                    }
                    item = it2.next();
                    do {
                        item = it2.next();
                        timestamp3 = item.getTimestamp();
                    } while (item == null);
                }
            }
            if (item != null) {
                timestamp4 = item.getTimestamp();
            }
            return Math.max(timestamp, Math.max(timestamp2, timestamp4));
        }

        public final Long getMasterTimeMs() {
            return this.masterTimeMs;
        }

        public final ProgramProgress.QuestionStatus getQuestion() {
            return this.question;
        }

        public final long getStartTimeMs() {
            return this.startTimeMs;
        }

        public final Map<String, ProgramProgress.TaskStatus> getTasks() {
            return this.tasks;
        }

        public final Map<String, ProgramProgress.TrickStatus> getTricks() {
            return this.tricks;
        }

        public final boolean isInProgress() {
            int i;
            boolean hasNext;
            Long num = null;
            boolean z = true;
            boolean hasNext2;
            Collection values2 = this.tricks.values();
            hasNext = values2 instanceof Collection;
            i = 1;
            i = 0;
            int r0 = i;
            if (this.question == null) {
                int i2 = 0;
            } else {
                num = Long.valueOf(this.question.getTimestamp());
            }
            int r1 = i;
            Collection values = this.tasks.values();
            hasNext2 = values instanceof Collection;
            int r4 = i;
            return z;
        }

        public final boolean isMastered() {
            boolean z = false;
            long l = 0;
            if (this.masterTimeMs != null) {
                long value = this.masterTimeMs.longValue();
                l = 0L;
                int r0 = value > l ? 1 : 0;
            }
            return (value > l ? 1 : 0);
        }

        public final boolean isPassed() {
            boolean z = false;
            long l = 0;
            if (this.completeTimeMs != null) {
                long value = this.completeTimeMs.longValue();
                l = 0L;
                int r0 = value > l ? 1 : 0;
            }
            return (value > l ? 1 : 0);
        }

        public final boolean isStarted() {
            boolean z = true;
            int r0 = this.startTimeMs > 0 ? 1 : 0;
            return (this.startTimeMs > 0 ? 1 : 0);
        }

        public /* synthetic */ LessonProgress(String str, int i, long j, Long long, Long long2, ProgramProgress.QuestionStatus questionStatus, Map map, Map map2, int i2, g gVar) {
            Map i92;
            String str2;
            int i22 = 0;
            int j32 = 0;
            Long long52;
            int map72 = 0;
            Map map82;
            int gVar102 = i2;
            String r1 = gVar102 & 1 != 0 ? "" : str;
            int r2 = gVar102 & 2 != 0 ? 0 : i;
            int r3 = gVar102 & 4 != 0 ? 0 : j;
            map72 = 0;
            int r5 = gVar102 & 8 != 0 ? map72 : long;
            int r7 = gVar102 & 16 != 0 ? map72 : long2;
            if (gVar102 & 32 == 0) {
                map72 = questionStatus;
            }
            if (gVar102 & 64 != 0) {
                map82 = j0.h();
            } else {
                map82 = map;
            }
            if (gVar102 & 128 != 0) {
                i92 = j0.h();
            } else {
                i92 = map2;
            }
            this(str2, i22, j32, long, long52, map72, map72, map82, i92);
        }


        public LessonProgress() {
            this(null, 0, 0L, l, null, null, null, null, 0, 255, 0);
        }

        public static /* synthetic */ ProgramProgress.LessonProgress copy$default(ProgramProgress.LessonProgress lessonProgress, String str, int i, long j, Long long, Long long2, ProgramProgress.QuestionStatus questionStatus, Map map, Map map2, int i2, Object object) {
            Map i102;
            String str22;
            int i32;
            long j42;
            Long long62;
            Long questionStatus72;
            app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus map82;
            Map map92;
            Object lessonProgress2 = lessonProgress;
            int object112 = i2;
            String r2 = object112 & 1 != 0 ? lessonProgress2.id : str;
            int r3 = object112 & 2 != 0 ? lessonProgress2.index : i;
            long r4 = object112 & 4 != 0 ? lessonProgress2.startTimeMs : j;
            Long r6 = object112 & 8 != 0 ? lessonProgress2.completeTimeMs : long;
            Long r7 = object112 & 16 != 0 ? lessonProgress2.masterTimeMs : long2;
            app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus r8 = object112 & 32 != 0 ? lessonProgress2.question : questionStatus;
            Map r9 = object112 & 64 != 0 ? lessonProgress2.tricks : map;
            Map r1 = object112 & 128 != 0 ? lessonProgress2.tasks : map2;
            return lessonProgress.copy(str22, i32, j42, r14, long62, questionStatus72, map82, map92, (object112 & 128 != 0 ? lessonProgress2.tasks : map2));
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final int component2() {
            return this.index;
        }

        /* operator */ public final long component3() {
            return this.startTimeMs;
        }

        /* operator */ public final Long component4() {
            return this.completeTimeMs;
        }

        /* operator */ public final Long component5() {
            return this.masterTimeMs;
        }

        /* operator */ public final ProgramProgress.QuestionStatus component6() {
            return this.question;
        }

        /* operator */ public final Map<String, ProgramProgress.TrickStatus> component7() {
            return this.tricks;
        }

        /* operator */ public final Map<String, ProgramProgress.TaskStatus> component8() {
            return this.tasks;
        }

        public final ProgramProgress.LessonProgress copy(String id, int index, long startTimeMs, Long completeTimeMs, Long masterTimeMs, ProgramProgress.QuestionStatus question, Map<String, ProgramProgress.TrickStatus> tricks, Map<String, ProgramProgress.TaskStatus> tasks) {
            n.f(id, "id");
            final Object tasks2 = tricks;
            n.f(tasks2, "tricks");
            final Object obj = tasks;
            n.f(obj, "tasks");
            ProgramProgress_LessonProgress programProgress_LessonProgress = new ProgramProgress_LessonProgress(id, index, startTimeMs, l, completeTimeMs, masterTimeMs, question, tasks2, obj);
            return programProgress_LessonProgress;
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
            final boolean z8 = false;
            if (!(other instanceof ProgramProgress_LessonProgress)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (this.index != other.index) {
                return false;
            }
            if (this.startTimeMs != other.startTimeMs) {
                return false;
            }
            if (!n.b(this.completeTimeMs, other.completeTimeMs)) {
                return false;
            }
            if (!n.b(this.masterTimeMs, other.masterTimeMs)) {
                return false;
            }
            if (!n.b(this.question, other.question)) {
                return false;
            }
            if (!n.b(this.tricks, other.tricks)) {
                return false;
            }
            return !n.b(this.tasks, other.tasks) ? z8 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.completeTimeMs == null) {
            } else {
                i = this.completeTimeMs.hashCode();
            }
            if (this.masterTimeMs == null) {
            } else {
                i = this.masterTimeMs.hashCode();
            }
            if (this.question != null) {
                i = this.question.hashCode();
            }
            return (this.id.hashCode() * 31) + Integer.hashCode(this.index) * 31 + Long.hashCode(this.startTimeMs) * 31 + i * 31 + i * 31 + i * 31 + this.tricks.hashCode() * 31 + this.tasks.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LessonProgress(id=";
            String str3 = ", index=";
            String str4 = ", startTimeMs=";
            String str5 = ", completeTimeMs=";
            String str6 = ", masterTimeMs=";
            String str7 = ", question=";
            String str8 = ", tricks=";
            String str9 = ", tasks=";
            str = str2 + this.id + str3 + this.index + str4 + this.startTimeMs + str5 + this.completeTimeMs + str6 + this.masterTimeMs + str7 + this.question + str8 + this.tricks + str9 + this.tasks + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            long value;
            Object key;
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.index);
            parcel.writeLong(this.startTimeMs);
            final int i = 0;
            final int i2 = 1;
            if (this.completeTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.completeTimeMs.longValue());
            }
            if (this.masterTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.masterTimeMs.longValue());
            }
            if (this.question == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                this.question.writeToParcel(parcel, flags);
            }
            parcel.writeInt(this.tricks.size());
            Iterator it = this.tricks.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                parcel.writeString((String)item.getKey());
                Object value2 = item.getValue();
            }
            parcel.writeInt(this.tasks.size());
            Iterator it2 = this.tasks.entrySet().iterator();
            while (it2.hasNext()) {
                Object item2 = it2.next();
                parcel.writeString((String)item2.getKey());
                Object value3 = item2.getValue();
            }
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B3\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006'", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleExam;", "Landroid/os/Parcelable;", "trickId", "", "unlockTimeMs", "", "hasNewUpdates", "", "examSubmission", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;)V", "getExamSubmission", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "getHasNewUpdates", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrickId", "()Ljava/lang/String;", "getUnlockTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleExam;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModuleExam implements Parcelable {

        public static final Parcelable.Creator<ProgramProgress.ModuleExam> CREATOR = new ProgramProgress$ModuleExam$Creator<>();
        private final ProgramProgress.ExamSubmission examSubmission;
        private final Boolean hasNewUpdates;
        private final String trickId;
        private final Long unlockTimeMs;
        public ModuleExam(String str, Long long, Boolean boolean, ProgramProgress.ExamSubmission examSubmission) {
            n.f(str, "trickId");
            super();
            this.trickId = str;
            this.unlockTimeMs = long;
            this.hasNewUpdates = boolean;
            this.examSubmission = examSubmission;
        }

        public final ProgramProgress.ExamSubmission getExamSubmission() {
            return this.examSubmission;
        }

        public final Boolean getHasNewUpdates() {
            return this.hasNewUpdates;
        }

        public final String getTrickId() {
            return this.trickId;
        }

        public final Long getUnlockTimeMs() {
            return this.unlockTimeMs;
        }

        public /* synthetic */ ModuleExam(String str, Long long, Boolean boolean, ProgramProgress.ExamSubmission examSubmission, int i, g gVar) {
            String str2;
            Long l;
            Boolean fALSE2;
            if (i & 1 != 0) {
                str2 = "";
            }
            i = 0;
            i = i & 2 != 0 ? i : i;
            fALSE2 = i & 4 != 0 ? Boolean.FALSE : fALSE2;
            i = i & 8 != 0 ? i : i;
            this(str2, l, fALSE2, examSubmission);
        }


        public ModuleExam() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ ProgramProgress.ModuleExam copy$default(ProgramProgress.ModuleExam moduleExam, String str, Long long, Boolean boolean, ProgramProgress.ExamSubmission examSubmission, int i, Object object) {
            String trickId2;
            Long unlockTimeMs2;
            Boolean hasNewUpdates2;
            app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission examSubmission2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            return moduleExam.copy(trickId2, unlockTimeMs2, hasNewUpdates2, examSubmission2);
        }

        /* operator */ public final String component1() {
            return this.trickId;
        }

        /* operator */ public final Long component2() {
            return this.unlockTimeMs;
        }

        /* operator */ public final Boolean component3() {
            return this.hasNewUpdates;
        }

        /* operator */ public final ProgramProgress.ExamSubmission component4() {
            return this.examSubmission;
        }

        public final ProgramProgress.ModuleExam copy(String trickId, Long unlockTimeMs, Boolean hasNewUpdates, ProgramProgress.ExamSubmission examSubmission) {
            n.f(trickId, "trickId");
            return new ProgramProgress_ModuleExam(trickId, unlockTimeMs, hasNewUpdates, examSubmission);
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
            final boolean z6 = false;
            if (!(other instanceof ProgramProgress_ModuleExam)) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            if (!n.b(this.unlockTimeMs, other.unlockTimeMs)) {
                return false;
            }
            if (!n.b(this.hasNewUpdates, other.hasNewUpdates)) {
                return false;
            }
            return !n.b(this.examSubmission, other.examSubmission) ? z6 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.unlockTimeMs == null) {
            } else {
                i = this.unlockTimeMs.hashCode();
            }
            if (this.hasNewUpdates == null) {
            } else {
                i = this.hasNewUpdates.hashCode();
            }
            if (this.examSubmission != null) {
                i = this.examSubmission.hashCode();
            }
            return (this.trickId.hashCode() * 31) + i * 31 + i * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ModuleExam(trickId=";
            String str3 = ", unlockTimeMs=";
            String str4 = ", hasNewUpdates=";
            String str5 = ", examSubmission=";
            str = str2 + this.trickId + str3 + this.unlockTimeMs + str4 + this.hasNewUpdates + str5 + this.examSubmission + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            final int i = 0;
            final int i2 = 1;
            if (this.unlockTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.unlockTimeMs.longValue());
            }
            if (this.hasNewUpdates == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeInt(this.hasNewUpdates.booleanValue());
            }
            if (this.examSubmission == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                this.examSubmission.writeToParcel(parcel, flags);
            }
        }
    }

    @Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bs\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c\u0012\u0016\u0008\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0011\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000cHÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fHÆ\u0003J|\u0010(\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c2\u0016\u0008\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fHÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0013\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\u0006\u00100\u001a\u00020,J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u001e\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u001f\u0010\u0013¨\u00067", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "Landroid/os/Parcelable;", "id", "", "index", "", "startTimeMs", "", "completeTimeMs", "masterTimeMs", "graduationTimeMs", "lessons", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "exams", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleExam;", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;)V", "getCompleteTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExams", "()Ljava/util/Map;", "getGraduationTimeMs", "getId", "()Ljava/lang/String;", "getIndex", "()I", "getLessons", "()Ljava/util/List;", "getMasterTimeMs", "getStartTimeMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "describeContents", "equals", "", "other", "", "hashCode", "isPassed", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModuleProgress implements Parcelable {

        public static final Parcelable.Creator<ProgramProgress.ModuleProgress> CREATOR = new ProgramProgress$ModuleProgress$Creator<>();
        private final Long completeTimeMs;
        private final Map<String, ProgramProgress.ModuleExam> exams;
        private final Long graduationTimeMs;
        private final String id;
        private final int index;
        private final List<ProgramProgress.LessonProgress> lessons;
        private final Long masterTimeMs;
        private final Long startTimeMs;
        public ModuleProgress(String str, int i, Long long, Long long2, Long long3, Long long4, List<ProgramProgress.LessonProgress> list, Map<String, ProgramProgress.ModuleExam> map) {
            n.f(str, "id");
            n.f(list, "lessons");
            n.f(map, "exams");
            super();
            this.id = str;
            this.index = i;
            this.startTimeMs = long;
            this.completeTimeMs = long2;
            this.masterTimeMs = long3;
            this.graduationTimeMs = long4;
            this.lessons = list;
            this.exams = map;
        }

        public final Long getCompleteTimeMs() {
            return this.completeTimeMs;
        }

        public final Map<String, ProgramProgress.ModuleExam> getExams() {
            return this.exams;
        }

        public final Long getGraduationTimeMs() {
            return this.graduationTimeMs;
        }

        public final String getId() {
            return this.id;
        }

        public final int getIndex() {
            return this.index;
        }

        public final List<ProgramProgress.LessonProgress> getLessons() {
            return this.lessons;
        }

        public final Long getMasterTimeMs() {
            return this.masterTimeMs;
        }

        public final Long getStartTimeMs() {
            return this.startTimeMs;
        }

        public final boolean isPassed() {
            boolean z = false;
            long l = 0;
            if (this.completeTimeMs != null) {
                long value = this.completeTimeMs.longValue();
                l = 0L;
                int r0 = value > l ? 1 : 0;
            }
            return (value > l ? 1 : 0);
        }

        public /* synthetic */ ModuleProgress(String str, int i, Long long, Long long2, Long long3, Long long4, List list, Map map, int i2, g gVar) {
            Map map82;
            String str2;
            int i22 = 0;
            int long32;
            List list72;
            int i92 = i2;
            String r1 = i92 & 1 != 0 ? "" : str;
            int r2 = i92 & 2 != 0 ? 0 : i;
            long32 = 0;
            int r3 = i92 & 4 != 0 ? long32 : long;
            int r5 = i92 & 8 != 0 ? long32 : long2;
            int r6 = i92 & 16 != 0 ? long32 : long3;
            if (i92 & 32 == 0) {
                long32 = long4;
            }
            if (i92 & 64 != 0) {
                list72 = p.g();
            } else {
                list72 = list;
            }
            if (i92 & 128 != 0) {
                map82 = j0.h();
            } else {
                map82 = map;
            }
            this(str2, i22, long32, long32, long32, long32, list72, map82);
        }


        public ModuleProgress() {
            this(null, 0, null, null, null, null, null, null, 255, null);
        }

        public static /* synthetic */ ProgramProgress.ModuleProgress copy$default(ProgramProgress.ModuleProgress moduleProgress, String str, int i, Long long, Long long2, Long long3, Long long4, List list, Map map, int i2, Object object) {
            Map map92;
            String str22;
            int i32;
            Long long42;
            Long long52;
            Long long62;
            Long long72;
            List list82;
            Object moduleProgress2 = moduleProgress;
            int i102 = i2;
            String r2 = i102 & 1 != 0 ? moduleProgress2.id : str;
            int r3 = i102 & 2 != 0 ? moduleProgress2.index : i;
            Long r4 = i102 & 4 != 0 ? moduleProgress2.startTimeMs : long;
            Long r5 = i102 & 8 != 0 ? moduleProgress2.completeTimeMs : long2;
            Long r6 = i102 & 16 != 0 ? moduleProgress2.masterTimeMs : long3;
            Long r7 = i102 & 32 != 0 ? moduleProgress2.graduationTimeMs : long4;
            List r8 = i102 & 64 != 0 ? moduleProgress2.lessons : list;
            Map r1 = i102 & 128 != 0 ? moduleProgress2.exams : map;
            return moduleProgress.copy(str22, i32, long42, long52, long62, long72, list82, (i102 & 128 != 0 ? moduleProgress2.exams : map));
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final int component2() {
            return this.index;
        }

        /* operator */ public final Long component3() {
            return this.startTimeMs;
        }

        /* operator */ public final Long component4() {
            return this.completeTimeMs;
        }

        /* operator */ public final Long component5() {
            return this.masterTimeMs;
        }

        /* operator */ public final Long component6() {
            return this.graduationTimeMs;
        }

        /* operator */ public final List<ProgramProgress.LessonProgress> component7() {
            return this.lessons;
        }

        /* operator */ public final Map<String, ProgramProgress.ModuleExam> component8() {
            return this.exams;
        }

        public final ProgramProgress.ModuleProgress copy(String id, int index, Long startTimeMs, Long completeTimeMs, Long masterTimeMs, Long graduationTimeMs, List<ProgramProgress.LessonProgress> lessons, Map<String, ProgramProgress.ModuleExam> exams) {
            n.f(id, "id");
            final Object lessons2 = lessons;
            n.f(lessons2, "lessons");
            final Object exams2 = exams;
            n.f(exams2, "exams");
            ProgramProgress_ModuleProgress programProgress_ModuleProgress = new ProgramProgress_ModuleProgress(id, index, startTimeMs, completeTimeMs, masterTimeMs, graduationTimeMs, lessons2, exams2);
            return programProgress_ModuleProgress;
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
            final boolean z9 = false;
            if (!(other instanceof ProgramProgress_ModuleProgress)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (this.index != other.index) {
                return false;
            }
            if (!n.b(this.startTimeMs, other.startTimeMs)) {
                return false;
            }
            if (!n.b(this.completeTimeMs, other.completeTimeMs)) {
                return false;
            }
            if (!n.b(this.masterTimeMs, other.masterTimeMs)) {
                return false;
            }
            if (!n.b(this.graduationTimeMs, other.graduationTimeMs)) {
                return false;
            }
            if (!n.b(this.lessons, other.lessons)) {
                return false;
            }
            return !n.b(this.exams, other.exams) ? z9 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.startTimeMs == null) {
            } else {
                i = this.startTimeMs.hashCode();
            }
            if (this.completeTimeMs == null) {
            } else {
                i = this.completeTimeMs.hashCode();
            }
            if (this.masterTimeMs == null) {
            } else {
                i = this.masterTimeMs.hashCode();
            }
            if (this.graduationTimeMs != null) {
                i = this.graduationTimeMs.hashCode();
            }
            return (this.id.hashCode() * 31) + Integer.hashCode(this.index) * 31 + i * 31 + i * 31 + i * 31 + i * 31 + this.lessons.hashCode() * 31 + this.exams.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ModuleProgress(id=";
            String str3 = ", index=";
            String str4 = ", startTimeMs=";
            String str5 = ", completeTimeMs=";
            String str6 = ", masterTimeMs=";
            String str7 = ", graduationTimeMs=";
            String str8 = ", lessons=";
            String str9 = ", exams=";
            str = str2 + this.id + str3 + this.index + str4 + this.startTimeMs + str5 + this.completeTimeMs + str6 + this.masterTimeMs + str7 + this.graduationTimeMs + str8 + this.lessons + str9 + this.exams + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            long value;
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.index);
            final int i = 0;
            final int i2 = 1;
            if (this.startTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.startTimeMs.longValue());
            }
            if (this.completeTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.completeTimeMs.longValue());
            }
            if (this.masterTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.masterTimeMs.longValue());
            }
            if (this.graduationTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.graduationTimeMs.longValue());
            }
            parcel.writeInt(this.lessons.size());
            Iterator it = this.lessons.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            parcel.writeInt(this.exams.size());
            Iterator it2 = this.exams.entrySet().iterator();
            while (it2.hasNext()) {
                Object item2 = it2.next();
                parcel.writeString((String)item2.getKey());
                Object value2 = item2.getValue();
            }
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000e", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ProgramExamStatus;", "", "examStatus", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getExamStatus", "()Ljava/lang/String;", "LOCKED", "READY", "UPLOADING", "PASSED", "APPROVED", "REJECTED", "PENDING", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ProgramExamStatus {

        APPROVED,
        LOCKED,
        PASSED,
        PENDING,
        READY,
        REJECTED,
        UPLOADING;

        private final String examStatus;
        @Override // java.lang.Enum
        public final String getExamStatus() {
            return this.examStatus;
        }

        private static final /* synthetic */ ProgramProgress.ProgramExamStatus[] $values() {
            app.dogo.externalmodel.model.responses.ProgramProgress.ProgramExamStatus[] arr = new ProgramProgress.ProgramExamStatus[7];
            return new ProgramProgress.ProgramExamStatus[] { ProgramProgress_ProgramExamStatus.LOCKED, ProgramProgress_ProgramExamStatus.READY, ProgramProgress_ProgramExamStatus.UPLOADING, ProgramProgress_ProgramExamStatus.PASSED, ProgramProgress_ProgramExamStatus.APPROVED, ProgramProgress_ProgramExamStatus.REJECTED, ProgramProgress_ProgramExamStatus.PENDING };
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;", "Landroid/os/Parcelable;", "id", "", "timestamp", "", "(Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class QuestionStatus implements Parcelable {

        public static final Parcelable.Creator<ProgramProgress.QuestionStatus> CREATOR = new ProgramProgress$QuestionStatus$Creator<>();
        private final String id;
        private final long timestamp;
        public QuestionStatus(String str, long j) {
            n.f(str, "id");
            super();
            this.id = str;
            this.timestamp = j;
        }

        public final String getId() {
            return this.id;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public /* synthetic */ QuestionStatus(String str, long j, int i, g gVar) {
            String str2;
            str2 = i & 1 != 0 ? "" : str2;
            i = i & 2 != 0 ? 0 : i;
            this(str2, i, r3);
        }


        public QuestionStatus() {
            this(null, 0L, i3, 3, 0);
        }

        public static /* synthetic */ ProgramProgress.QuestionStatus copy$default(ProgramProgress.QuestionStatus questionStatus, String str, long j, int i, Object object) {
            String id2;
            long timestamp2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return questionStatus.copy(id2, timestamp2);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final long component2() {
            return this.timestamp;
        }

        public final ProgramProgress.QuestionStatus copy(String id, long timestamp) {
            n.f(id, "id");
            return new ProgramProgress_QuestionStatus(id, timestamp, r4);
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
            if (!(other instanceof ProgramProgress_QuestionStatus)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            return this.timestamp != other.timestamp ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.id.hashCode() * 31) + Long.hashCode(this.timestamp);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "QuestionStatus(id=";
            String str3 = ", timestamp=";
            str = str2 + this.id + str3 + this.timestamp + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeLong(this.timestamp);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$TaskStatus;", "Landroid/os/Parcelable;", "id", "", "timestamp", "", "(Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TaskStatus implements Parcelable {

        public static final Parcelable.Creator<ProgramProgress.TaskStatus> CREATOR = new ProgramProgress$TaskStatus$Creator<>();
        private final String id;
        private final long timestamp;
        public TaskStatus(String str, long j) {
            n.f(str, "id");
            super();
            this.id = str;
            this.timestamp = j;
        }

        public final String getId() {
            return this.id;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public /* synthetic */ TaskStatus(String str, long j, int i, g gVar) {
            String str2;
            str2 = i & 1 != 0 ? "" : str2;
            i = i & 2 != 0 ? 0 : i;
            this(str2, i, r3);
        }


        public TaskStatus() {
            this(null, 0L, i3, 3, 0);
        }

        public static /* synthetic */ ProgramProgress.TaskStatus copy$default(ProgramProgress.TaskStatus taskStatus, String str, long j, int i, Object object) {
            String id2;
            long timestamp2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return taskStatus.copy(id2, timestamp2);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final long component2() {
            return this.timestamp;
        }

        public final ProgramProgress.TaskStatus copy(String id, long timestamp) {
            n.f(id, "id");
            return new ProgramProgress_TaskStatus(id, timestamp, r4);
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
            if (!(other instanceof ProgramProgress_TaskStatus)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            return this.timestamp != other.timestamp ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.id.hashCode() * 31) + Long.hashCode(this.timestamp);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TaskStatus(id=";
            String str3 = ", timestamp=";
            str = str2 + this.id + str3 + this.timestamp + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeLong(this.timestamp);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "Landroid/os/Parcelable;", "id", "", "knowledge", "", "timestamp", "", "(Ljava/lang/String;IJ)V", "getId", "()Ljava/lang/String;", "getKnowledge", "()I", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickStatus implements Parcelable {

        public static final Parcelable.Creator<ProgramProgress.TrickStatus> CREATOR = new ProgramProgress$TrickStatus$Creator<>();
        private final String id;
        private final int knowledge;
        private final long timestamp;
        public TrickStatus(String str, int i, long j) {
            n.f(str, "id");
            super();
            this.id = str;
            this.knowledge = i;
            this.timestamp = j;
        }

        public final String getId() {
            return this.id;
        }

        public final int getKnowledge() {
            return this.knowledge;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public /* synthetic */ TrickStatus(String str, int i, long j, int i2, g gVar) {
            String str2;
            int i3 = 0;
            str2 = i2 & 1 != 0 ? "" : str2;
            i = i2 & 2 != 0 ? 0 : i;
            i3 = i2 & 4 != 0 ? 0 : i3;
            this(str2, i, i3, r4);
        }


        public TrickStatus() {
            this(null, 0, 0L, i4, 7, 0);
        }

        public static /* synthetic */ ProgramProgress.TrickStatus copy$default(ProgramProgress.TrickStatus trickStatus, String str, int i, long j, int i2, Object object) {
            String id2;
            int knowledge2;
            long timestamp2;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            return trickStatus.copy(id2, knowledge2, timestamp2);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final int component2() {
            return this.knowledge;
        }

        /* operator */ public final long component3() {
            return this.timestamp;
        }

        public final ProgramProgress.TrickStatus copy(String id, int knowledge, long timestamp) {
            n.f(id, "id");
            return new ProgramProgress_TrickStatus(id, knowledge, timestamp, r5);
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
            if (!(other instanceof ProgramProgress_TrickStatus)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (this.knowledge != other.knowledge) {
                return false;
            }
            return this.timestamp != other.timestamp ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.id.hashCode() * 31) + Integer.hashCode(this.knowledge) * 31 + Long.hashCode(this.timestamp);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickStatus(id=";
            String str3 = ", knowledge=";
            String str4 = ", timestamp=";
            str = str2 + this.id + str3 + this.knowledge + str4 + this.timestamp + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.knowledge);
            parcel.writeLong(this.timestamp);
        }
    }
    public ProgramProgress(String str, long j, Long long, Long long2, Long long3, List<ProgramProgress.ModuleProgress> list) {
        n.f(str, "id");
        n.f(list, "modules");
        super();
        this.id = str;
        this.startTimeMs = j;
        this.completeTimeMs = long;
        this.masterTimeMs = long2;
        this.graduationTimeMs = long3;
        this.modules = list;
    }

    public final Long getCompleteTimeMs() {
        return this.completeTimeMs;
    }

    public final Long getGraduationTimeMs() {
        return this.graduationTimeMs;
    }

    public final String getId() {
        return this.id;
    }

    public final Long getMasterTimeMs() {
        return this.masterTimeMs;
    }

    public final List<ProgramProgress.ModuleProgress> getModules() {
        return this.modules;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final boolean isPassed() {
        boolean z = false;
        long l = 0;
        if (this.completeTimeMs != null) {
            long value = this.completeTimeMs.longValue();
            l = 0L;
            int r0 = value > l ? 1 : 0;
        }
        return (value > l ? 1 : 0);
    }

    public final boolean isStarted() {
        boolean z = true;
        int r0 = this.startTimeMs > 0 ? 1 : 0;
        return (this.startTimeMs > 0 ? 1 : 0);
    }

    public /* synthetic */ ProgramProgress(String str, long j, Long long, Long long2, Long long3, List list, int i, g gVar) {
        Long long52;
        int long32;
        String str2;
        int j22 = 0;
        List i72;
        str2 = i & 1 != 0 ? "" : str2;
        if (i & 2 != 0) {
            j22 = 0;
        }
        long32 = 0;
        gVar = i & 4 != 0 ? long32 : long;
        int r2 = i & 8 != 0 ? long32 : long2;
        int r3 = i & 16 != 0 ? long32 : long3;
        if (i & 32 != 0) {
            i72 = p.g();
        }
        this(str2, j22, long2, long32, long52, long32, i72);
    }


    public ProgramProgress() {
        this(null, 0L, l, null, null, null, 0, 63, 0);
    }

    public static /* synthetic */ ProgramProgress copy$default(ProgramProgress programProgress, String str, long j, Long long, Long long2, Long long3, List list, int i, Object object) {
        String str22;
        long j32;
        Long long52;
        Long long62;
        Long list72;
        List i82;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        if (i & 32 != 0) {
        }
        return programProgress.copy(str22, j32, long52, long62, list72, i82);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final long component2() {
        return this.startTimeMs;
    }

    /* operator */ public final Long component3() {
        return this.completeTimeMs;
    }

    /* operator */ public final Long component4() {
        return this.masterTimeMs;
    }

    /* operator */ public final Long component5() {
        return this.graduationTimeMs;
    }

    /* operator */ public final List<ProgramProgress.ModuleProgress> component6() {
        return this.modules;
    }

    public final ProgramProgress copy(String id, long startTimeMs, Long completeTimeMs, Long masterTimeMs, Long graduationTimeMs, List<ProgramProgress.ModuleProgress> modules) {
        n.f(id, "id");
        final Object obj = modules;
        n.f(obj, "modules");
        ProgramProgress programProgress = new ProgramProgress(id, startTimeMs, l, completeTimeMs, masterTimeMs, graduationTimeMs, obj);
        return programProgress;
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
        final boolean z7 = false;
        if (!(other instanceof ProgramProgress)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (this.startTimeMs != other.startTimeMs) {
            return false;
        }
        if (!n.b(this.completeTimeMs, other.completeTimeMs)) {
            return false;
        }
        if (!n.b(this.masterTimeMs, other.masterTimeMs)) {
            return false;
        }
        if (!n.b(this.graduationTimeMs, other.graduationTimeMs)) {
            return false;
        }
        return !n.b(this.modules, other.modules) ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.completeTimeMs == null) {
        } else {
            i = this.completeTimeMs.hashCode();
        }
        if (this.masterTimeMs == null) {
        } else {
            i = this.masterTimeMs.hashCode();
        }
        if (this.graduationTimeMs != null) {
            i = this.graduationTimeMs.hashCode();
        }
        return (this.id.hashCode() * 31) + Long.hashCode(this.startTimeMs) * 31 + i * 31 + i * 31 + i * 31 + this.modules.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramProgress(id=";
        String str3 = ", startTimeMs=";
        String str4 = ", completeTimeMs=";
        String str5 = ", masterTimeMs=";
        String str6 = ", graduationTimeMs=";
        String str7 = ", modules=";
        str = str2 + this.id + str3 + this.startTimeMs + str4 + this.completeTimeMs + str5 + this.masterTimeMs + str6 + this.graduationTimeMs + str7 + this.modules + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        long value;
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeLong(this.startTimeMs);
        final int i = 0;
        final int i2 = 1;
        if (this.completeTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.completeTimeMs.longValue());
        }
        if (this.masterTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.masterTimeMs.longValue());
        }
        if (this.graduationTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.graduationTimeMs.longValue());
        }
        parcel.writeInt(this.modules.size());
        Iterator it = this.modules.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }
}
