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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0008/0123456BO\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0008\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0002\u0010\u000cJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0003JX\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00052\u0010\u0008\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020!HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0013\u0010\u000eR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017¨\u00067", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "Landroid/os/Parcelable;", "id", "", "startTimeMs", "", "completeTimeMs", "masterTimeMs", "graduationTimeMs", "modules", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)V", "getCompleteTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGraduationTimeMs", "getId", "()Ljava/lang/String;", "getMasterTimeMs", "getModules", "()Ljava/util/List;", "getStartTimeMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "describeContents", "", "equals", "", "other", "", "hashCode", "isPassed", "isStarted", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ExamSubmission", "LessonProgress", "ModuleExam", "ModuleProgress", "ProgramExamStatus", "QuestionStatus", "TaskStatus", "TrickStatus", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramProgress implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress> CREATOR;
    private final Long completeTimeMs;
    private final Long graduationTimeMs;
    private final String id;
    private final Long masterTimeMs;
    private final List<app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress> modules;
    private final long startTimeMs;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ProgramProgress createFromParcel(Parcel parcel) {
            int valueOf2;
            int valueOf;
            int valueOf3;
            int i;
            int i2;
            int i4;
            int i3;
            int fromParcel;
            n.f(parcel, "parcel");
            int i5 = 0;
            if (parcel.readInt() == 0) {
                i = i5;
            } else {
                i = valueOf2;
            }
            if (parcel.readInt() == 0) {
                i2 = i5;
            } else {
                i2 = valueOf;
            }
            if (parcel.readInt() == 0) {
                i4 = i5;
            } else {
                i4 = valueOf3;
            }
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i3 = 0;
            while (i3 != int) {
                if (parcel.readInt() == 0) {
                } else {
                }
                fromParcel = ProgramProgress.ModuleProgress.CREATOR.createFromParcel(parcel);
                arrayList.add(fromParcel);
                i3++;
                fromParcel = i5;
            }
            super(parcel.readString(), parcel.readLong(), obj4, i, i2, i4, arrayList);
            return obj12;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ProgramProgress[] newArray(int i) {
            return new ProgramProgress[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u00082\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B½\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0010HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003JÆ\u0001\u0010@\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010AJ\t\u0010B\u001a\u00020CHÖ\u0001J\u0013\u0010D\u001a\u00020\u00102\u0008\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020CHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\u0019\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020CHÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0018R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010%\u001a\u0004\u0008#\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010%\u001a\u0004\u0008)\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010%\u001a\u0004\u0008*\u0010$R\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u0018¨\u0006N", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "Landroid/os/Parcelable;", "id", "", "examId", "timestamp", "", "reviewComment", "programId", "moduleId", "reviewTimeMs", "status", "videoThumbnailUrl", "videoUrl", "uploadTimeMs", "hasNewFeedback", "", "unlockTimeMs", "evaluatedByAvatar", "evaluatedByName", "userFeedbackSubmitted", "evaluatedByEmail", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getEvaluatedByAvatar", "()Ljava/lang/String;", "getEvaluatedByEmail", "getEvaluatedByName", "getExamId", "getHasNewFeedback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getModuleId", "getProgramId", "getReviewComment", "getReviewTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "getTimestamp", "()J", "getUnlockTimeMs", "getUploadTimeMs", "getUserFeedbackSubmitted", "()Z", "getVideoThumbnailUrl", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ExamSubmission implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission> CREATOR;
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
        static {
            ProgramProgress.ExamSubmission.Creator creator = new ProgramProgress.ExamSubmission.Creator();
            ProgramProgress.ExamSubmission.CREATOR = creator;
        }

        public ExamSubmission() {
            super(0, 0, 0, obj4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 131071, 0);
        }

        public ExamSubmission(String string, String string2, long l3, String string4, String string5, String string6, Long long7, String string8, String string9, String string10, Long long11, Boolean boolean12, Long long13, String string14, String string15, boolean z16, String string17) {
            final Object obj = this;
            final Object obj2 = string9;
            final Object obj3 = string10;
            final Object obj4 = long11;
            final Object obj5 = string15;
            final Object obj6 = z16;
            final Object obj7 = obj28;
            n.f(string, "id");
            n.f(string2, "examId");
            n.f(obj2, "status");
            n.f(obj3, "videoThumbnailUrl");
            n.f(obj4, "videoUrl");
            n.f(obj5, "evaluatedByAvatar");
            n.f(obj6, "evaluatedByName");
            n.f(obj7, "evaluatedByEmail");
            super();
            obj.id = string;
            obj.examId = string2;
            obj.timestamp = l3;
            obj.reviewComment = string5;
            obj.programId = string6;
            obj.moduleId = long7;
            obj.reviewTimeMs = string8;
            obj.status = obj2;
            obj.videoThumbnailUrl = obj3;
            obj.videoUrl = obj4;
            obj.uploadTimeMs = boolean12;
            obj.hasNewFeedback = long13;
            obj.unlockTimeMs = string14;
            obj.evaluatedByAvatar = obj5;
            obj.evaluatedByName = obj6;
            obj.userFeedbackSubmitted = string17;
            obj.evaluatedByEmail = obj7;
        }

        public ExamSubmission(String string, String string2, long l3, String string4, String string5, String string6, Long long7, String string8, String string9, String string10, Long long11, Boolean boolean12, Long long13, String string14, String string15, boolean z16, String string17, int i18, g g19) {
            String str;
            String str8;
            String str7;
            String str5;
            String str6;
            int i;
            int i3;
            int i8;
            int i7;
            int i5;
            int i2;
            String str2;
            String str3;
            String str4;
            int i4;
            Boolean fALSE;
            int i6;
            int i9 = g19;
            String str9 = "";
            str8 = i9 & 1 != 0 ? str9 : string;
            str6 = i9 & 2 != 0 ? str9 : string2;
            i = i9 & 4 != 0 ? 0 : l3;
            i3 = i9 & 8 != 0 ? 0 : string5;
            i7 = i9 & 16 != 0 ? 0 : string6;
            i5 = i9 & 32 != 0 ? 0 : long7;
            i2 = i9 & 64 != 0 ? 0 : string8;
            str2 = i9 & 128 != 0 ? str9 : string9;
            str3 = i9 & 256 != 0 ? str9 : string10;
            str4 = i9 & 512 != 0 ? str9 : long11;
            i4 = i9 & 1024 != 0 ? 0 : boolean12;
            fALSE = i9 & 2048 != 0 ? Boolean.FALSE : long13;
            i8 = i9 & 4096 != 0 ? 0 : string14;
            final String obj39 = str9;
            str7 = i9 & 8192 != 0 ? obj39 : string15;
            str5 = i9 & 16384 != 0 ? obj39 : z16;
            i6 = i9 & i27 != 0 ? 0 : string17;
            str = i9 &= i29 != 0 ? obj39 : i18;
            super(str8, str6, i, string5, i3, i7, i5, i2, str2, str3, str4, i4, fALSE, i8, str7, str5, i6, str);
        }

        public static app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission copy$default(app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission programProgress$ExamSubmission, String string2, String string3, long l4, String string5, String string6, String string7, Long long8, String string9, String string10, String string11, Long long12, Boolean boolean13, Long long14, String string15, String string16, boolean z17, String string18, int i19, Object object20) {
            String evaluatedByEmail;
            String str;
            String examId;
            long timestamp;
            String reviewComment;
            String programId;
            String moduleId;
            Long reviewTimeMs;
            String status;
            String videoThumbnailUrl;
            String videoUrl;
            Long uploadTimeMs;
            Boolean hasNewFeedback;
            Long unlockTimeMs;
            String evaluatedByAvatar;
            String evaluatedByName;
            boolean userFeedbackSubmitted;
            Object obj = examSubmission;
            int i = object20;
            str = i & 1 != 0 ? obj.id : string2;
            examId = i & 2 != 0 ? obj.examId : string3;
            timestamp = i & 4 != 0 ? obj.timestamp : l4;
            reviewComment = i & 8 != 0 ? obj.reviewComment : string6;
            programId = i & 16 != 0 ? obj.programId : string7;
            moduleId = i & 32 != 0 ? obj.moduleId : long8;
            reviewTimeMs = i & 64 != 0 ? obj.reviewTimeMs : string9;
            status = i & 128 != 0 ? obj.status : string10;
            videoThumbnailUrl = i & 256 != 0 ? obj.videoThumbnailUrl : string11;
            videoUrl = i & 512 != 0 ? obj.videoUrl : long12;
            uploadTimeMs = i & 1024 != 0 ? obj.uploadTimeMs : boolean13;
            hasNewFeedback = i & 2048 != 0 ? obj.hasNewFeedback : long14;
            unlockTimeMs = i & 4096 != 0 ? obj.unlockTimeMs : string15;
            evaluatedByAvatar = i & 8192 != 0 ? obj.evaluatedByAvatar : string16;
            evaluatedByName = i & 16384 != 0 ? obj.evaluatedByName : z17;
            userFeedbackSubmitted = i & i18 != 0 ? obj.userFeedbackSubmitted : string18;
            evaluatedByEmail = i &= i21 != 0 ? obj.evaluatedByEmail : i19;
            return examSubmission.copy(str, examId, timestamp, string5, reviewComment, programId, moduleId, reviewTimeMs, status, videoThumbnailUrl, videoUrl, uploadTimeMs, hasNewFeedback, unlockTimeMs, evaluatedByAvatar, evaluatedByName, userFeedbackSubmitted);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String component10() {
            return this.videoUrl;
        }

        @Override // android.os.Parcelable
        public final Long component11() {
            return this.uploadTimeMs;
        }

        @Override // android.os.Parcelable
        public final Boolean component12() {
            return this.hasNewFeedback;
        }

        @Override // android.os.Parcelable
        public final Long component13() {
            return this.unlockTimeMs;
        }

        @Override // android.os.Parcelable
        public final String component14() {
            return this.evaluatedByAvatar;
        }

        @Override // android.os.Parcelable
        public final String component15() {
            return this.evaluatedByName;
        }

        @Override // android.os.Parcelable
        public final boolean component16() {
            return this.userFeedbackSubmitted;
        }

        @Override // android.os.Parcelable
        public final String component17() {
            return this.evaluatedByEmail;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.examId;
        }

        @Override // android.os.Parcelable
        public final long component3() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public final String component4() {
            return this.reviewComment;
        }

        @Override // android.os.Parcelable
        public final String component5() {
            return this.programId;
        }

        @Override // android.os.Parcelable
        public final String component6() {
            return this.moduleId;
        }

        @Override // android.os.Parcelable
        public final Long component7() {
            return this.reviewTimeMs;
        }

        @Override // android.os.Parcelable
        public final String component8() {
            return this.status;
        }

        @Override // android.os.Parcelable
        public final String component9() {
            return this.videoThumbnailUrl;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission copy(String string, String string2, long l3, String string4, String string5, String string6, Long long7, String string8, String string9, String string10, Long long11, Boolean boolean12, Long long13, String string14, String string15, boolean z16, String string17) {
            Object obj = string;
            n.f(obj, "id");
            n.f(string2, "examId");
            n.f(string9, "status");
            n.f(string10, "videoThumbnailUrl");
            n.f(long11, "videoUrl");
            n.f(string15, "evaluatedByAvatar");
            n.f(z16, "evaluatedByName");
            n.f(obj39, "evaluatedByEmail");
            super(obj, string2, l3, obj4, string5, string6, long7, string8, string9, string10, long11, boolean12, long13, string14, string15, z16, string17, obj39);
            return examSubmission2;
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
            if (!object instanceof ProgramProgress.ExamSubmission) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.examId, object.examId)) {
                return i2;
            }
            if (Long.compare(timestamp, timestamp2) != 0) {
                return i2;
            }
            if (!n.b(this.reviewComment, object.reviewComment)) {
                return i2;
            }
            if (!n.b(this.programId, object.programId)) {
                return i2;
            }
            if (!n.b(this.moduleId, object.moduleId)) {
                return i2;
            }
            if (!n.b(this.reviewTimeMs, object.reviewTimeMs)) {
                return i2;
            }
            if (!n.b(this.status, object.status)) {
                return i2;
            }
            if (!n.b(this.videoThumbnailUrl, object.videoThumbnailUrl)) {
                return i2;
            }
            if (!n.b(this.videoUrl, object.videoUrl)) {
                return i2;
            }
            if (!n.b(this.uploadTimeMs, object.uploadTimeMs)) {
                return i2;
            }
            if (!n.b(this.hasNewFeedback, object.hasNewFeedback)) {
                return i2;
            }
            if (!n.b(this.unlockTimeMs, object.unlockTimeMs)) {
                return i2;
            }
            if (!n.b(this.evaluatedByAvatar, object.evaluatedByAvatar)) {
                return i2;
            }
            if (!n.b(this.evaluatedByName, object.evaluatedByName)) {
                return i2;
            }
            if (this.userFeedbackSubmitted != object.userFeedbackSubmitted) {
                return i2;
            }
            if (!n.b(this.evaluatedByEmail, object.evaluatedByEmail)) {
                return i2;
            }
            return i;
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
        public final Boolean getHasNewFeedback() {
            return this.hasNewFeedback;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String getModuleId() {
            return this.moduleId;
        }

        @Override // android.os.Parcelable
        public final String getProgramId() {
            return this.programId;
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
        public final String getStatus() {
            return this.status;
        }

        @Override // android.os.Parcelable
        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public final Long getUnlockTimeMs() {
            return this.unlockTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long getUploadTimeMs() {
            return this.uploadTimeMs;
        }

        @Override // android.os.Parcelable
        public final boolean getUserFeedbackSubmitted() {
            return this.userFeedbackSubmitted;
        }

        @Override // android.os.Parcelable
        public final String getVideoThumbnailUrl() {
            return this.videoThumbnailUrl;
        }

        @Override // android.os.Parcelable
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i2;
            int i;
            int i5;
            int i6;
            int i7;
            int i3;
            boolean userFeedbackSubmitted;
            int i4;
            String reviewComment = this.reviewComment;
            i4 = 0;
            if (reviewComment == null) {
                i2 = i4;
            } else {
                i2 = reviewComment.hashCode();
            }
            String programId = this.programId;
            if (programId == null) {
                i = i4;
            } else {
                i = programId.hashCode();
            }
            String moduleId = this.moduleId;
            if (moduleId == null) {
                i5 = i4;
            } else {
                i5 = moduleId.hashCode();
            }
            Long reviewTimeMs = this.reviewTimeMs;
            if (reviewTimeMs == null) {
                i6 = i4;
            } else {
                i6 = reviewTimeMs.hashCode();
            }
            Long uploadTimeMs = this.uploadTimeMs;
            if (uploadTimeMs == null) {
                i7 = i4;
            } else {
                i7 = uploadTimeMs.hashCode();
            }
            Boolean hasNewFeedback = this.hasNewFeedback;
            if (hasNewFeedback == null) {
                i3 = i4;
            } else {
                i3 = hasNewFeedback.hashCode();
            }
            Long unlockTimeMs = this.unlockTimeMs;
            if (unlockTimeMs == null) {
            } else {
                i4 = unlockTimeMs.hashCode();
            }
            if (this.userFeedbackSubmitted) {
                userFeedbackSubmitted = 1;
            }
            return i39 += i48;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ExamSubmission(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", examId=");
            stringBuilder.append(this.examId);
            stringBuilder.append(", timestamp=");
            stringBuilder.append(this.timestamp);
            stringBuilder.append(", reviewComment=");
            stringBuilder.append(this.reviewComment);
            stringBuilder.append(", programId=");
            stringBuilder.append(this.programId);
            stringBuilder.append(", moduleId=");
            stringBuilder.append(this.moduleId);
            stringBuilder.append(", reviewTimeMs=");
            stringBuilder.append(this.reviewTimeMs);
            stringBuilder.append(", status=");
            stringBuilder.append(this.status);
            stringBuilder.append(", videoThumbnailUrl=");
            stringBuilder.append(this.videoThumbnailUrl);
            stringBuilder.append(", videoUrl=");
            stringBuilder.append(this.videoUrl);
            stringBuilder.append(", uploadTimeMs=");
            stringBuilder.append(this.uploadTimeMs);
            stringBuilder.append(", hasNewFeedback=");
            stringBuilder.append(this.hasNewFeedback);
            stringBuilder.append(", unlockTimeMs=");
            stringBuilder.append(this.unlockTimeMs);
            stringBuilder.append(", evaluatedByAvatar=");
            stringBuilder.append(this.evaluatedByAvatar);
            stringBuilder.append(", evaluatedByName=");
            stringBuilder.append(this.evaluatedByName);
            stringBuilder.append(", userFeedbackSubmitted=");
            stringBuilder.append(this.userFeedbackSubmitted);
            stringBuilder.append(", evaluatedByEmail=");
            stringBuilder.append(this.evaluatedByEmail);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            long longValue;
            long longValue2;
            Boolean obj6;
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.examId);
            parcel.writeLong(this.timestamp);
            parcel.writeString(this.reviewComment);
            parcel.writeString(this.programId);
            parcel.writeString(this.moduleId);
            obj6 = this.reviewTimeMs;
            longValue = 0;
            final int i = 1;
            if (obj6 == null) {
                parcel.writeInt(longValue);
            } else {
                parcel.writeInt(i);
                parcel.writeLong(obj6.longValue());
            }
            parcel.writeString(this.status);
            parcel.writeString(this.videoThumbnailUrl);
            parcel.writeString(this.videoUrl);
            obj6 = this.uploadTimeMs;
            if (obj6 == null) {
                parcel.writeInt(longValue);
            } else {
                parcel.writeInt(i);
                parcel.writeLong(obj6.longValue());
            }
            obj6 = this.hasNewFeedback;
            if (obj6 == null) {
                parcel.writeInt(longValue);
            } else {
                parcel.writeInt(i);
                parcel.writeInt(obj6.booleanValue());
            }
            obj6 = this.unlockTimeMs;
            if (obj6 == null) {
                parcel.writeInt(longValue);
            } else {
                parcel.writeInt(i);
                parcel.writeLong(obj6.longValue());
            }
            parcel.writeString(this.evaluatedByAvatar);
            parcel.writeString(this.evaluatedByName);
            parcel.writeInt(this.userFeedbackSubmitted);
            parcel.writeString(this.evaluatedByEmail);
        }
    }

    @Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bw\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rHÆ\u0003J\u0080\u0001\u0010)\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rHÆ\u0001¢\u0006\u0002\u0010*J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0013\u0010,\u001a\u00020-2\u0008\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\u0006\u00100\u001a\u00020\u0007J\t\u00101\u001a\u00020\u0005HÖ\u0001J\u0006\u00102\u001a\u00020-J\u0006\u00103\u001a\u00020-J\u0006\u00104\u001a\u00020-J\u0006\u00105\u001a\u00020-J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001f\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001f¨\u0006<", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "Landroid/os/Parcelable;", "id", "", "index", "", "startTimeMs", "", "completeTimeMs", "masterTimeMs", "question", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;", "tricks", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "tasks", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TaskStatus;", "(Ljava/lang/String;IJLjava/lang/Long;Ljava/lang/Long;Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;Ljava/util/Map;Ljava/util/Map;)V", "getCompleteTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "()Ljava/lang/String;", "getIndex", "()I", "getMasterTimeMs", "getQuestion", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;", "getStartTimeMs", "()J", "getTasks", "()Ljava/util/Map;", "getTricks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;IJLjava/lang/Long;Ljava/lang/Long;Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;Ljava/util/Map;Ljava/util/Map;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "describeContents", "equals", "", "other", "", "getLastUserInteractionTimeMs", "hashCode", "isInProgress", "isMastered", "isPassed", "isStarted", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LessonProgress implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress> CREATOR;
        private final Long completeTimeMs;
        private final String id;
        private final int index;
        private final Long masterTimeMs;
        private final app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus question;
        private final long startTimeMs;
        private final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus> tasks;
        private final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus> tricks;
        static {
            ProgramProgress.LessonProgress.Creator creator = new ProgramProgress.LessonProgress.Creator();
            ProgramProgress.LessonProgress.CREATOR = creator;
        }

        public LessonProgress() {
            super(0, 0, 0, obj4, 0, 0, 0, 0, 0, 255, 0);
        }

        public LessonProgress(String string, int i2, long l3, Long long4, Long long5, app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus programProgress$QuestionStatus6, Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus> map7, Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus> map8) {
            n.f(string, "id");
            n.f(map8, "tricks");
            n.f(obj10, "tasks");
            super();
            this.id = string;
            this.index = i2;
            this.startTimeMs = l3;
            this.completeTimeMs = long5;
            this.masterTimeMs = questionStatus6;
            this.question = map7;
            this.tricks = map8;
            this.tasks = obj10;
        }

        public LessonProgress(String string, int i2, long l3, Long long4, Long long5, app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus programProgress$QuestionStatus6, Map map7, Map map8, int i9, g g10) {
            Map map2;
            String str;
            int i;
            int i5;
            int num;
            int i3;
            int i4;
            Map map;
            int i6 = g10;
            str = i6 & 1 != 0 ? "" : string;
            i = i6 & 2 != 0 ? 0 : i2;
            i5 = i6 & 4 != 0 ? 0 : l3;
            i3 = 0;
            num = i6 & 8 != 0 ? i3 : long5;
            i4 = i6 & 16 != 0 ? i3 : questionStatus6;
            if (i6 & 32 != 0) {
            } else {
                i3 = map7;
            }
            if (i6 & 64 != 0) {
                map = j0.h();
            } else {
                map = map8;
            }
            if (i6 &= 128 != 0) {
                map2 = j0.h();
            } else {
                map2 = i9;
            }
            super(str, i, i5, long5, num, i4, i3, map, map2);
        }

        public static app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress copy$default(app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress programProgress$LessonProgress, String string2, int i3, long l4, Long long5, Long long6, app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus programProgress$QuestionStatus7, Map map8, Map map9, int i10, Object object11) {
            Map tasks;
            String str;
            int index;
            long startTimeMs;
            Long completeTimeMs;
            Long masterTimeMs;
            app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus question;
            Map tricks;
            Object obj = lessonProgress;
            int i = object11;
            str = i & 1 != 0 ? obj.id : string2;
            index = i & 2 != 0 ? obj.index : i3;
            startTimeMs = i & 4 != 0 ? obj.startTimeMs : l4;
            completeTimeMs = i & 8 != 0 ? obj.completeTimeMs : long6;
            masterTimeMs = i & 16 != 0 ? obj.masterTimeMs : questionStatus7;
            question = i & 32 != 0 ? obj.question : map8;
            tricks = i & 64 != 0 ? obj.tricks : map9;
            tasks = i &= 128 != 0 ? obj.tasks : i10;
            return lessonProgress.copy(str, index, startTimeMs, long5, completeTimeMs, masterTimeMs, question, tricks);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.index;
        }

        @Override // android.os.Parcelable
        public final long component3() {
            return this.startTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long component4() {
            return this.completeTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long component5() {
            return this.masterTimeMs;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus component6() {
            return this.question;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus> component7() {
            return this.tricks;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus> component8() {
            return this.tasks;
        }

        public final app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress copy(String string, int i2, long l3, Long long4, Long long5, app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus programProgress$QuestionStatus6, Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus> map7, Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus> map8) {
            n.f(string, "id");
            final Object obj = map8;
            n.f(obj, "tricks");
            final Object obj2 = obj20;
            n.f(obj2, "tasks");
            super(string, i2, l3, obj5, long5, questionStatus6, map7, obj, obj2);
            return lessonProgress;
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
            if (!object instanceof ProgramProgress.LessonProgress) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (this.index != object.index) {
                return i2;
            }
            if (Long.compare(startTimeMs, startTimeMs2) != 0) {
                return i2;
            }
            if (!n.b(this.completeTimeMs, object.completeTimeMs)) {
                return i2;
            }
            if (!n.b(this.masterTimeMs, object.masterTimeMs)) {
                return i2;
            }
            if (!n.b(this.question, object.question)) {
                return i2;
            }
            if (!n.b(this.tricks, object.tricks)) {
                return i2;
            }
            if (!n.b(this.tasks, object.tasks)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final Long getCompleteTimeMs() {
            return this.completeTimeMs;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final int getIndex() {
            return this.index;
        }

        @Override // android.os.Parcelable
        public final long getLastUserInteractionTimeMs() {
            long timestamp3;
            long timestamp2;
            long timestamp7;
            Object next3;
            Object next2;
            long timestamp6;
            long timestamp;
            int cmp2;
            boolean next;
            long l2;
            long timestamp5;
            long l;
            int cmp;
            long timestamp4;
            timestamp3 = this.tasks.values().iterator();
            timestamp6 = 0;
            if (!timestamp3.hasNext()) {
                next3 = next2;
            } else {
                if (!timestamp3.hasNext()) {
                } else {
                    Object obj2 = next3;
                    if ((ProgramProgress.TaskStatus)obj2 == null) {
                        timestamp = timestamp6;
                    } else {
                        timestamp = (ProgramProgress.TaskStatus)obj2.getTimestamp();
                    }
                    Object next6 = timestamp3.next();
                    Object obj4 = next6;
                    do {
                        next6 = timestamp3.next();
                        obj4 = next6;
                        timestamp5 = (ProgramProgress.TaskStatus)(ProgramProgress.TaskStatus)obj4.getTimestamp();
                        if (Long.compare(timestamp, timestamp5) < 0) {
                        }
                        if (timestamp3.hasNext()) {
                        }
                        next3 = next6;
                        timestamp = timestamp5;
                        timestamp5 = timestamp6;
                    } while ((ProgramProgress.TaskStatus)obj4 == null);
                }
            }
            if ((ProgramProgress.TaskStatus)next3 == null) {
                l2 = timestamp6;
            } else {
                l2 = timestamp3;
            }
            timestamp2 = this.question;
            if (timestamp2 == null) {
                l = timestamp6;
            } else {
                l = timestamp2;
            }
            final Iterator iterator = this.tricks.values().iterator();
            if (!iterator.hasNext()) {
            } else {
                if (!iterator.hasNext()) {
                } else {
                    Object obj = next2;
                    if ((ProgramProgress.TrickStatus)obj == null) {
                        timestamp7 = timestamp6;
                    } else {
                        timestamp7 = (ProgramProgress.TrickStatus)obj.getTimestamp();
                    }
                    Object next5 = iterator.next();
                    Object obj3 = next5;
                    do {
                        next5 = iterator.next();
                        obj3 = next5;
                        timestamp4 = (ProgramProgress.TrickStatus)(ProgramProgress.TrickStatus)obj3.getTimestamp();
                        if (Long.compare(timestamp7, timestamp4) < 0) {
                        }
                        if (iterator.hasNext()) {
                        }
                        next2 = next5;
                        timestamp7 = timestamp4;
                        timestamp4 = timestamp6;
                    } while ((ProgramProgress.TrickStatus)obj3 == null);
                }
            }
            if ((ProgramProgress.TrickStatus)next2 == null) {
            } else {
                timestamp6 = (ProgramProgress.TrickStatus)next2.getTimestamp();
            }
            return Math.max(l2, timestamp5);
        }

        @Override // android.os.Parcelable
        public final Long getMasterTimeMs() {
            return this.masterTimeMs;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus getQuestion() {
            return this.question;
        }

        @Override // android.os.Parcelable
        public final long getStartTimeMs() {
            return this.startTimeMs;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus> getTasks() {
            return this.tasks;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus> getTricks() {
            return this.tricks;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            int i3;
            int i2;
            Long completeTimeMs = this.completeTimeMs;
            i2 = 0;
            if (completeTimeMs == null) {
                i = i2;
            } else {
                i = completeTimeMs.hashCode();
            }
            Long masterTimeMs = this.masterTimeMs;
            if (masterTimeMs == null) {
                i3 = i2;
            } else {
                i3 = masterTimeMs.hashCode();
            }
            app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus question = this.question;
            if (question == null) {
            } else {
                i2 = question.hashCode();
            }
            return i17 += i22;
        }

        @Override // android.os.Parcelable
        public final boolean isInProgress() {
            Object iterator;
            int i;
            boolean empty;
            Long valueOf;
            int i2;
            int i4;
            long timestamp;
            Collection iterator2;
            int i3;
            boolean empty2;
            iterator = this.tricks.values();
            i4 = 1;
            final int i5 = 0;
            if (iterator instanceof Collection != null && iterator.isEmpty()) {
                if (iterator.isEmpty()) {
                    i = i5;
                } else {
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        if ((ProgramProgress.TrickStatus)iterator.next() != null) {
                        } else {
                        }
                        empty = i5;
                        empty = i4;
                    }
                }
            } else {
            }
            app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus question = this.question;
            if (question == null) {
                valueOf = 0;
            } else {
                valueOf = Long.valueOf(question.getTimestamp());
            }
            i2 = valueOf != null ? i4 : i5;
            iterator2 = this.tasks.values();
            if (iterator2 instanceof Collection != null && iterator2.isEmpty()) {
                if (iterator2.isEmpty()) {
                    i3 = i5;
                } else {
                    iterator2 = iterator2.iterator();
                    while (iterator2.hasNext()) {
                        if ((ProgramProgress.TaskStatus)iterator2.next() != null) {
                        } else {
                        }
                        empty2 = i5;
                        empty2 = i4;
                    }
                }
            } else {
            }
            if (i == 0 && i2 == 0) {
                if (i2 == 0) {
                    if (i3 != 0) {
                    } else {
                        i4 = i5;
                    }
                }
            }
            return i4;
        }

        @Override // android.os.Parcelable
        public final boolean isMastered() {
            Long masterTimeMs;
            int i;
            int i2;
            masterTimeMs = this.masterTimeMs;
            if (masterTimeMs != null && Long.compare(longValue, i2) > 0) {
                i = Long.compare(longValue, i2) > 0 ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final boolean isPassed() {
            Long completeTimeMs;
            int i2;
            int i;
            completeTimeMs = this.completeTimeMs;
            if (completeTimeMs != null && Long.compare(longValue, i) > 0) {
                i2 = Long.compare(longValue, i) > 0 ? 1 : 0;
            } else {
            }
            return i2;
        }

        @Override // android.os.Parcelable
        public final boolean isStarted() {
            int i;
            i = Long.compare(startTimeMs, i2) > 0 ? 1 : 0;
            return i;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LessonProgress(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", index=");
            stringBuilder.append(this.index);
            stringBuilder.append(", startTimeMs=");
            stringBuilder.append(this.startTimeMs);
            stringBuilder.append(", completeTimeMs=");
            stringBuilder.append(this.completeTimeMs);
            stringBuilder.append(", masterTimeMs=");
            stringBuilder.append(this.masterTimeMs);
            stringBuilder.append(", question=");
            stringBuilder.append(this.question);
            stringBuilder.append(", tricks=");
            stringBuilder.append(this.tricks);
            stringBuilder.append(", tasks=");
            stringBuilder.append(this.tasks);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            long longValue;
            int value2;
            int value;
            Object key;
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.index);
            parcel.writeLong(this.startTimeMs);
            Long completeTimeMs = this.completeTimeMs;
            final int i = 0;
            final int i3 = 1;
            if (completeTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(completeTimeMs.longValue());
            }
            Long masterTimeMs = this.masterTimeMs;
            if (masterTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(masterTimeMs.longValue());
            }
            app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus question = this.question;
            if (question == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                question.writeToParcel(parcel, i2);
            }
            Map tricks = this.tricks;
            parcel.writeInt(tricks.size());
            Iterator iterator = tricks.entrySet().iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                parcel.writeString((String)(Map.Entry)next2.getKey());
                value2 = next2.getValue();
                if ((ProgramProgress.TrickStatus)value2 == 0) {
                } else {
                }
                parcel.writeInt(i3);
                (ProgramProgress.TrickStatus)value2.writeToParcel(parcel, i2);
                parcel.writeInt(i);
            }
            Map tasks = this.tasks;
            parcel.writeInt(tasks.size());
            Iterator iterator2 = tasks.entrySet().iterator();
            while (iterator2.hasNext()) {
                Object next4 = iterator2.next();
                parcel.writeString((String)(Map.Entry)next4.getKey());
                value = next4.getValue();
                if ((ProgramProgress.TaskStatus)value == 0) {
                } else {
                }
                parcel.writeInt(i3);
                (ProgramProgress.TaskStatus)value.writeToParcel(parcel, i2);
                parcel.writeInt(i);
            }
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B3\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006'", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleExam;", "Landroid/os/Parcelable;", "trickId", "", "unlockTimeMs", "", "hasNewUpdates", "", "examSubmission", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;)V", "getExamSubmission", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "getHasNewUpdates", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrickId", "()Ljava/lang/String;", "getUnlockTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleExam;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModuleExam implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam> CREATOR;
        private final app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission examSubmission;
        private final Boolean hasNewUpdates;
        private final String trickId;
        private final Long unlockTimeMs;
        static {
            ProgramProgress.ModuleExam.Creator creator = new ProgramProgress.ModuleExam.Creator();
            ProgramProgress.ModuleExam.CREATOR = creator;
        }

        public ModuleExam() {
            super(0, 0, 0, 0, 15, 0);
        }

        public ModuleExam(String string, Long long2, Boolean boolean3, app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission programProgress$ExamSubmission4) {
            n.f(string, "trickId");
            super();
            this.trickId = string;
            this.unlockTimeMs = long2;
            this.hasNewUpdates = boolean3;
            this.examSubmission = examSubmission4;
        }

        public ModuleExam(String string, Long long2, Boolean boolean3, app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission programProgress$ExamSubmission4, int i5, g g6) {
            String obj2;
            int obj3;
            Boolean obj4;
            int obj5;
            obj2 = i5 & 1 != 0 ? "" : obj2;
            final int i = 0;
            obj3 = i5 & 2 != 0 ? i : obj3;
            obj4 = i5 & 4 != 0 ? Boolean.FALSE : obj4;
            obj5 = i5 &= 8 != 0 ? i : obj5;
            super(obj2, obj3, obj4, obj5);
        }

        public static app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam copy$default(app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam programProgress$ModuleExam, String string2, Long long3, Boolean boolean4, app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission programProgress$ExamSubmission5, int i6, Object object7) {
            String obj1;
            Long obj2;
            Boolean obj3;
            app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission obj4;
            if (i6 & 1 != 0) {
                obj1 = moduleExam.trickId;
            }
            if (i6 & 2 != 0) {
                obj2 = moduleExam.unlockTimeMs;
            }
            if (i6 & 4 != 0) {
                obj3 = moduleExam.hasNewUpdates;
            }
            if (i6 &= 8 != 0) {
                obj4 = moduleExam.examSubmission;
            }
            return moduleExam.copy(obj1, obj2, obj3, obj4);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final Long component2() {
            return this.unlockTimeMs;
        }

        @Override // android.os.Parcelable
        public final Boolean component3() {
            return this.hasNewUpdates;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission component4() {
            return this.examSubmission;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam copy(String string, Long long2, Boolean boolean3, app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission programProgress$ExamSubmission4) {
            n.f(string, "trickId");
            ProgramProgress.ModuleExam moduleExam = new ProgramProgress.ModuleExam(string, long2, boolean3, examSubmission4);
            return moduleExam;
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
            if (!object instanceof ProgramProgress.ModuleExam) {
                return i2;
            }
            if (!n.b(this.trickId, object.trickId)) {
                return i2;
            }
            if (!n.b(this.unlockTimeMs, object.unlockTimeMs)) {
                return i2;
            }
            if (!n.b(this.hasNewUpdates, object.hasNewUpdates)) {
                return i2;
            }
            if (!n.b(this.examSubmission, object.examSubmission)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission getExamSubmission() {
            return this.examSubmission;
        }

        @Override // android.os.Parcelable
        public final Boolean getHasNewUpdates() {
            return this.hasNewUpdates;
        }

        @Override // android.os.Parcelable
        public final String getTrickId() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final Long getUnlockTimeMs() {
            return this.unlockTimeMs;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            int i3;
            int i2;
            Long unlockTimeMs = this.unlockTimeMs;
            i2 = 0;
            if (unlockTimeMs == null) {
                i = i2;
            } else {
                i = unlockTimeMs.hashCode();
            }
            Boolean hasNewUpdates = this.hasNewUpdates;
            if (hasNewUpdates == null) {
                i3 = i2;
            } else {
                i3 = hasNewUpdates.hashCode();
            }
            app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission examSubmission = this.examSubmission;
            if (examSubmission == null) {
            } else {
                i2 = examSubmission.hashCode();
            }
            return i9 += i2;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModuleExam(trickId=");
            stringBuilder.append(this.trickId);
            stringBuilder.append(", unlockTimeMs=");
            stringBuilder.append(this.unlockTimeMs);
            stringBuilder.append(", hasNewUpdates=");
            stringBuilder.append(this.hasNewUpdates);
            stringBuilder.append(", examSubmission=");
            stringBuilder.append(this.examSubmission);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            boolean hasNewUpdates;
            long longValue;
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            Long unlockTimeMs = this.unlockTimeMs;
            final int i = 0;
            final int i3 = 1;
            if (unlockTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(unlockTimeMs.longValue());
            }
            hasNewUpdates = this.hasNewUpdates;
            if (hasNewUpdates == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeInt(hasNewUpdates.booleanValue());
            }
            app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission examSubmission = this.examSubmission;
            if (examSubmission == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                examSubmission.writeToParcel(parcel, i2);
            }
        }
    }

    @Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bs\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c\u0012\u0016\u0008\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0011\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000cHÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fHÆ\u0003J|\u0010(\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c2\u0016\u0008\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fHÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0013\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\u0006\u00100\u001a\u00020,J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0017\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u001e\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u001f\u0010\u0013¨\u00067", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "Landroid/os/Parcelable;", "id", "", "index", "", "startTimeMs", "", "completeTimeMs", "masterTimeMs", "graduationTimeMs", "lessons", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "exams", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleExam;", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;)V", "getCompleteTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExams", "()Ljava/util/Map;", "getGraduationTimeMs", "getId", "()Ljava/lang/String;", "getIndex", "()I", "getLessons", "()Ljava/util/List;", "getMasterTimeMs", "getStartTimeMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;)Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "describeContents", "equals", "", "other", "", "hashCode", "isPassed", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ModuleProgress implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress> CREATOR;
        private final Long completeTimeMs;
        private final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam> exams;
        private final Long graduationTimeMs;
        private final String id;
        private final int index;
        private final List<app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress> lessons;
        private final Long masterTimeMs;
        private final Long startTimeMs;
        static {
            ProgramProgress.ModuleProgress.Creator creator = new ProgramProgress.ModuleProgress.Creator();
            ProgramProgress.ModuleProgress.CREATOR = creator;
        }

        public ModuleProgress() {
            super(0, 0, 0, 0, 0, 0, 0, 0, 255, 0);
        }

        public ModuleProgress(String string, int i2, Long long3, Long long4, Long long5, Long long6, List<app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress> list7, Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam> map8) {
            n.f(string, "id");
            n.f(list7, "lessons");
            n.f(map8, "exams");
            super();
            this.id = string;
            this.index = i2;
            this.startTimeMs = long3;
            this.completeTimeMs = long4;
            this.masterTimeMs = long5;
            this.graduationTimeMs = long6;
            this.lessons = list7;
            this.exams = map8;
        }

        public ModuleProgress(String string, int i2, Long long3, Long long4, Long long5, Long long6, List list7, Map map8, int i9, g g10) {
            Map map;
            String str;
            int i5;
            int i4;
            int i;
            int i6;
            int i3;
            List list;
            int i7 = i9;
            str = i7 & 1 != 0 ? "" : string;
            i5 = i7 & 2 != 0 ? 0 : i2;
            i = 0;
            i4 = i7 & 4 != 0 ? i : long3;
            i6 = i7 & 8 != 0 ? i : long4;
            i3 = i7 & 16 != 0 ? i : long5;
            if (i7 & 32 != 0) {
            } else {
                i = long6;
            }
            if (i7 & 64 != 0) {
                list = p.g();
            } else {
                list = list7;
            }
            if (i7 &= 128 != 0) {
                map = j0.h();
            } else {
                map = map8;
            }
            super(str, i5, i4, i6, i3, i, list, map);
        }

        public static app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress copy$default(app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress programProgress$ModuleProgress, String string2, int i3, Long long4, Long long5, Long long6, Long long7, List list8, Map map9, int i10, Object object11) {
            Map exams;
            String str;
            int index;
            Long startTimeMs;
            Long completeTimeMs;
            Long masterTimeMs;
            Long graduationTimeMs;
            List lessons;
            Object obj = moduleProgress;
            int i = i10;
            str = i & 1 != 0 ? obj.id : string2;
            index = i & 2 != 0 ? obj.index : i3;
            startTimeMs = i & 4 != 0 ? obj.startTimeMs : long4;
            completeTimeMs = i & 8 != 0 ? obj.completeTimeMs : long5;
            masterTimeMs = i & 16 != 0 ? obj.masterTimeMs : long6;
            graduationTimeMs = i & 32 != 0 ? obj.graduationTimeMs : long7;
            lessons = i & 64 != 0 ? obj.lessons : list8;
            exams = i &= 128 != 0 ? obj.exams : map9;
            return moduleProgress.copy(str, index, startTimeMs, completeTimeMs, masterTimeMs, graduationTimeMs, lessons, exams);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.index;
        }

        @Override // android.os.Parcelable
        public final Long component3() {
            return this.startTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long component4() {
            return this.completeTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long component5() {
            return this.masterTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long component6() {
            return this.graduationTimeMs;
        }

        public final List<app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress> component7() {
            return this.lessons;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam> component8() {
            return this.exams;
        }

        public final app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress copy(String string, int i2, Long long3, Long long4, Long long5, Long long6, List<app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress> list7, Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam> map8) {
            n.f(string, "id");
            final Object obj = list7;
            n.f(obj, "lessons");
            final Object obj2 = map8;
            n.f(obj2, "exams");
            super(string, i2, long3, long4, long5, long6, obj, obj2);
            return moduleProgress;
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
            if (!object instanceof ProgramProgress.ModuleProgress) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (this.index != object.index) {
                return i2;
            }
            if (!n.b(this.startTimeMs, object.startTimeMs)) {
                return i2;
            }
            if (!n.b(this.completeTimeMs, object.completeTimeMs)) {
                return i2;
            }
            if (!n.b(this.masterTimeMs, object.masterTimeMs)) {
                return i2;
            }
            if (!n.b(this.graduationTimeMs, object.graduationTimeMs)) {
                return i2;
            }
            if (!n.b(this.lessons, object.lessons)) {
                return i2;
            }
            if (!n.b(this.exams, object.exams)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final Long getCompleteTimeMs() {
            return this.completeTimeMs;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam> getExams() {
            return this.exams;
        }

        @Override // android.os.Parcelable
        public final Long getGraduationTimeMs() {
            return this.graduationTimeMs;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final int getIndex() {
            return this.index;
        }

        public final List<app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress> getLessons() {
            return this.lessons;
        }

        @Override // android.os.Parcelable
        public final Long getMasterTimeMs() {
            return this.masterTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long getStartTimeMs() {
            return this.startTimeMs;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i4;
            int i3;
            int i;
            int i2;
            Long startTimeMs = this.startTimeMs;
            i2 = 0;
            if (startTimeMs == null) {
                i4 = i2;
            } else {
                i4 = startTimeMs.hashCode();
            }
            Long completeTimeMs = this.completeTimeMs;
            if (completeTimeMs == null) {
                i3 = i2;
            } else {
                i3 = completeTimeMs.hashCode();
            }
            Long masterTimeMs = this.masterTimeMs;
            if (masterTimeMs == null) {
                i = i2;
            } else {
                i = masterTimeMs.hashCode();
            }
            Long graduationTimeMs = this.graduationTimeMs;
            if (graduationTimeMs == null) {
            } else {
                i2 = graduationTimeMs.hashCode();
            }
            return i18 += i22;
        }

        @Override // android.os.Parcelable
        public final boolean isPassed() {
            Long completeTimeMs;
            int i2;
            int i;
            completeTimeMs = this.completeTimeMs;
            if (completeTimeMs != null && Long.compare(longValue, i) > 0) {
                i2 = Long.compare(longValue, i) > 0 ? 1 : 0;
            } else {
            }
            return i2;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModuleProgress(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", index=");
            stringBuilder.append(this.index);
            stringBuilder.append(", startTimeMs=");
            stringBuilder.append(this.startTimeMs);
            stringBuilder.append(", completeTimeMs=");
            stringBuilder.append(this.completeTimeMs);
            stringBuilder.append(", masterTimeMs=");
            stringBuilder.append(this.masterTimeMs);
            stringBuilder.append(", graduationTimeMs=");
            stringBuilder.append(this.graduationTimeMs);
            stringBuilder.append(", lessons=");
            stringBuilder.append(this.lessons);
            stringBuilder.append(", exams=");
            stringBuilder.append(this.exams);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            long longValue;
            int size;
            int value;
            Object key;
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.index);
            Long startTimeMs = this.startTimeMs;
            final int i = 0;
            final int i3 = 1;
            if (startTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(startTimeMs.longValue());
            }
            Long completeTimeMs = this.completeTimeMs;
            if (completeTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(completeTimeMs.longValue());
            }
            Long masterTimeMs = this.masterTimeMs;
            if (masterTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(masterTimeMs.longValue());
            }
            Long graduationTimeMs = this.graduationTimeMs;
            if (graduationTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(graduationTimeMs.longValue());
            }
            List lessons = this.lessons;
            parcel.writeInt(lessons.size());
            Iterator iterator = lessons.iterator();
            while (iterator.hasNext()) {
                size = iterator.next();
                if ((ProgramProgress.LessonProgress)size == 0) {
                } else {
                }
                parcel.writeInt(i3);
                (ProgramProgress.LessonProgress)size.writeToParcel(parcel, i2);
                parcel.writeInt(i);
            }
            Map exams = this.exams;
            parcel.writeInt(exams.size());
            Iterator iterator2 = exams.entrySet().iterator();
            while (iterator2.hasNext()) {
                Object next3 = iterator2.next();
                parcel.writeString((String)(Map.Entry)next3.getKey());
                value = next3.getValue();
                if ((ProgramProgress.ModuleExam)value == 0) {
                } else {
                }
                parcel.writeInt(i3);
                (ProgramProgress.ModuleExam)value.writeToParcel(parcel, i2);
                parcel.writeInt(i);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000e", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$ProgramExamStatus;", "", "examStatus", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getExamStatus", "()Ljava/lang/String;", "LOCKED", "READY", "UPLOADING", "PASSED", "APPROVED", "REJECTED", "PENDING", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum ProgramExamStatus {

        LOCKED("locked"),
        READY("locked"),
        UPLOADING("locked"),
        PASSED("locked"),
        APPROVED("locked"),
        REJECTED("locked"),
        PENDING("locked");

        private final String examStatus;
        private static final app.dogo.externalmodel.model.responses.ProgramProgress.ProgramExamStatus[] $values() {
            app.dogo.externalmodel.model.responses.ProgramProgress.ProgramExamStatus[] arr = new ProgramProgress.ProgramExamStatus[7];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getExamStatus() {
            return this.examStatus;
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$QuestionStatus;", "Landroid/os/Parcelable;", "id", "", "timestamp", "", "(Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class QuestionStatus implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus> CREATOR;
        private final String id;
        private final long timestamp;
        static {
            ProgramProgress.QuestionStatus.Creator creator = new ProgramProgress.QuestionStatus.Creator();
            ProgramProgress.QuestionStatus.CREATOR = creator;
        }

        public QuestionStatus() {
            super(0, 0, obj3, 3, 0);
        }

        public QuestionStatus(String string, long l2) {
            n.f(string, "id");
            super();
            this.id = string;
            this.timestamp = l2;
        }

        public QuestionStatus(String string, long l2, int i3, g g4) {
            String obj1;
            int obj2;
            obj1 = g4 & 1 != 0 ? "" : obj1;
            obj2 = g4 &= 2 != 0 ? 0 : obj2;
            super(obj1, obj2, i3);
        }

        public static app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus copy$default(app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus programProgress$QuestionStatus, String string2, long l3, int i4, Object object5) {
            String obj1;
            long obj2;
            if (object5 & 1 != 0) {
                obj1 = questionStatus.id;
            }
            if (object5 &= 2 != 0) {
                obj2 = questionStatus.timestamp;
            }
            return questionStatus.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final long component2() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus copy(String string, long l2) {
            n.f(string, "id");
            ProgramProgress.QuestionStatus questionStatus = new ProgramProgress.QuestionStatus(string, l2, obj4);
            return questionStatus;
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
            if (!object instanceof ProgramProgress.QuestionStatus) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (Long.compare(timestamp, timestamp2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("QuestionStatus(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", timestamp=");
            stringBuilder.append(this.timestamp);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeLong(this.timestamp);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$TaskStatus;", "Landroid/os/Parcelable;", "id", "", "timestamp", "", "(Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TaskStatus implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus> CREATOR;
        private final String id;
        private final long timestamp;
        static {
            ProgramProgress.TaskStatus.Creator creator = new ProgramProgress.TaskStatus.Creator();
            ProgramProgress.TaskStatus.CREATOR = creator;
        }

        public TaskStatus() {
            super(0, 0, obj3, 3, 0);
        }

        public TaskStatus(String string, long l2) {
            n.f(string, "id");
            super();
            this.id = string;
            this.timestamp = l2;
        }

        public TaskStatus(String string, long l2, int i3, g g4) {
            String obj1;
            int obj2;
            obj1 = g4 & 1 != 0 ? "" : obj1;
            obj2 = g4 &= 2 != 0 ? 0 : obj2;
            super(obj1, obj2, i3);
        }

        public static app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus copy$default(app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus programProgress$TaskStatus, String string2, long l3, int i4, Object object5) {
            String obj1;
            long obj2;
            if (object5 & 1 != 0) {
                obj1 = taskStatus.id;
            }
            if (object5 &= 2 != 0) {
                obj2 = taskStatus.timestamp;
            }
            return taskStatus.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final long component2() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.TaskStatus copy(String string, long l2) {
            n.f(string, "id");
            ProgramProgress.TaskStatus taskStatus = new ProgramProgress.TaskStatus(string, l2, obj4);
            return taskStatus;
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
            if (!object instanceof ProgramProgress.TaskStatus) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (Long.compare(timestamp, timestamp2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TaskStatus(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", timestamp=");
            stringBuilder.append(this.timestamp);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeLong(this.timestamp);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "Landroid/os/Parcelable;", "id", "", "knowledge", "", "timestamp", "", "(Ljava/lang/String;IJ)V", "getId", "()Ljava/lang/String;", "getKnowledge", "()I", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickStatus implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus> CREATOR;
        private final String id;
        private final int knowledge;
        private final long timestamp;
        static {
            ProgramProgress.TrickStatus.Creator creator = new ProgramProgress.TrickStatus.Creator();
            ProgramProgress.TrickStatus.CREATOR = creator;
        }

        public TrickStatus() {
            super(0, 0, 0, obj4, 7, 0);
        }

        public TrickStatus(String string, int i2, long l3) {
            n.f(string, "id");
            super();
            this.id = string;
            this.knowledge = i2;
            this.timestamp = l3;
        }

        public TrickStatus(String string, int i2, long l3, int i4, g g5) {
            String obj1;
            int obj2;
            int obj3;
            obj1 = g5 & 1 != 0 ? "" : obj1;
            obj2 = g5 & 2 != 0 ? 0 : obj2;
            obj3 = g5 &= 4 != 0 ? 0 : obj3;
            super(obj1, obj2, obj3, i4);
        }

        public static app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus copy$default(app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus programProgress$TrickStatus, String string2, int i3, long l4, int i5, Object object6) {
            String obj1;
            int obj2;
            long obj3;
            if (object6 & 1 != 0) {
                obj1 = trickStatus.id;
            }
            if (object6 & 2 != 0) {
                obj2 = trickStatus.knowledge;
            }
            if (object6 &= 4 != 0) {
                obj3 = trickStatus.timestamp;
            }
            return trickStatus.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final long component3() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus copy(String string, int i2, long l3) {
            n.f(string, "id");
            ProgramProgress.TrickStatus trickStatus = new ProgramProgress.TrickStatus(string, i2, l3, obj5);
            return trickStatus;
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
            if (!object instanceof ProgramProgress.TrickStatus) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (this.knowledge != object.knowledge) {
                return i2;
            }
            if (Long.compare(timestamp, timestamp2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final int getKnowledge() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickStatus(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", knowledge=");
            stringBuilder.append(this.knowledge);
            stringBuilder.append(", timestamp=");
            stringBuilder.append(this.timestamp);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeInt(this.knowledge);
            parcel.writeLong(this.timestamp);
        }
    }
    static {
        ProgramProgress.Creator creator = new ProgramProgress.Creator();
        ProgramProgress.CREATOR = creator;
    }

    public ProgramProgress() {
        super(0, 0, obj3, 0, 0, 0, 0, 63, 0);
    }

    public ProgramProgress(String string, long l2, Long long3, Long long4, Long long5, List<app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress> list6) {
        n.f(string, "id");
        n.f(obj8, "modules");
        super();
        this.id = string;
        this.startTimeMs = l2;
        this.completeTimeMs = long4;
        this.masterTimeMs = long5;
        this.graduationTimeMs = list6;
        this.modules = obj8;
    }

    public ProgramProgress(String string, long l2, Long long3, Long long4, Long long5, List list6, int i7, g g8) {
        int num;
        int i;
        String obj6;
        int obj7;
        List obj12;
        int obj14;
        obj6 = g8 & 1 != 0 ? "" : obj6;
        obj7 = g8 & 2 != 0 ? 0 : obj7;
        int obj8 = 0;
        obj14 = g8 & 4 != 0 ? obj8 : long4;
        num = g8 & 8 != 0 ? obj8 : long5;
        i = g8 & 16 != 0 ? obj8 : list6;
        if (g8 & 32 != 0) {
            obj12 = p.g();
        }
        super(obj6, obj7, long5, obj14, num, i, obj12);
    }

    public static app.dogo.externalmodel.model.responses.ProgramProgress copy$default(app.dogo.externalmodel.model.responses.ProgramProgress programProgress, String string2, long l3, Long long4, Long long5, Long long6, List list7, int i8, Object object9) {
        String obj6;
        long obj7;
        Long obj9;
        Long obj10;
        Long obj11;
        List obj12;
        if (object9 & 1 != 0) {
            obj6 = programProgress.id;
        }
        if (object9 & 2 != 0) {
            obj7 = programProgress.startTimeMs;
        }
        if (object9 & 4 != 0) {
            obj9 = programProgress.completeTimeMs;
        }
        if (object9 & 8 != 0) {
            obj10 = programProgress.masterTimeMs;
        }
        if (object9 & 16 != 0) {
            obj11 = programProgress.graduationTimeMs;
        }
        if (object9 & 32 != 0) {
            obj12 = programProgress.modules;
        }
        return programProgress.copy(obj6, obj7, obj10, obj9, obj10, obj11);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return this.startTimeMs;
    }

    @Override // android.os.Parcelable
    public final Long component3() {
        return this.completeTimeMs;
    }

    @Override // android.os.Parcelable
    public final Long component4() {
        return this.masterTimeMs;
    }

    @Override // android.os.Parcelable
    public final Long component5() {
        return this.graduationTimeMs;
    }

    public final List<app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress> component6() {
        return this.modules;
    }

    public final app.dogo.externalmodel.model.responses.ProgramProgress copy(String string, long l2, Long long3, Long long4, Long long5, List<app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress> list6) {
        n.f(string, "id");
        final Object obj = obj16;
        n.f(obj, "modules");
        super(string, l2, obj4, long4, long5, list6, obj);
        return programProgress;
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
        if (!object instanceof ProgramProgress) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (Long.compare(startTimeMs, startTimeMs2) != 0) {
            return i2;
        }
        if (!n.b(this.completeTimeMs, object.completeTimeMs)) {
            return i2;
        }
        if (!n.b(this.masterTimeMs, object.masterTimeMs)) {
            return i2;
        }
        if (!n.b(this.graduationTimeMs, object.graduationTimeMs)) {
            return i2;
        }
        if (!n.b(this.modules, object.modules)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final Long getCompleteTimeMs() {
        return this.completeTimeMs;
    }

    @Override // android.os.Parcelable
    public final Long getGraduationTimeMs() {
        return this.graduationTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final Long getMasterTimeMs() {
        return this.masterTimeMs;
    }

    public final List<app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress> getModules() {
        return this.modules;
    }

    @Override // android.os.Parcelable
    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i2;
        int i3;
        int i;
        Long completeTimeMs = this.completeTimeMs;
        i = 0;
        if (completeTimeMs == null) {
            i2 = i;
        } else {
            i2 = completeTimeMs.hashCode();
        }
        Long masterTimeMs = this.masterTimeMs;
        if (masterTimeMs == null) {
            i3 = i;
        } else {
            i3 = masterTimeMs.hashCode();
        }
        Long graduationTimeMs = this.graduationTimeMs;
        if (graduationTimeMs == null) {
        } else {
            i = graduationTimeMs.hashCode();
        }
        return i13 += i16;
    }

    @Override // android.os.Parcelable
    public final boolean isPassed() {
        Long completeTimeMs;
        int i;
        int i2;
        completeTimeMs = this.completeTimeMs;
        if (completeTimeMs != null && Long.compare(longValue, i2) > 0) {
            i = Long.compare(longValue, i2) > 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isStarted() {
        int i;
        i = Long.compare(startTimeMs, i2) > 0 ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramProgress(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", startTimeMs=");
        stringBuilder.append(this.startTimeMs);
        stringBuilder.append(", completeTimeMs=");
        stringBuilder.append(this.completeTimeMs);
        stringBuilder.append(", masterTimeMs=");
        stringBuilder.append(this.masterTimeMs);
        stringBuilder.append(", graduationTimeMs=");
        stringBuilder.append(this.graduationTimeMs);
        stringBuilder.append(", modules=");
        stringBuilder.append(this.modules);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        long longValue;
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeLong(this.startTimeMs);
        Long completeTimeMs = this.completeTimeMs;
        final int i = 0;
        final int i3 = 1;
        if (completeTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeLong(completeTimeMs.longValue());
        }
        Long masterTimeMs = this.masterTimeMs;
        if (masterTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeLong(masterTimeMs.longValue());
        }
        Long graduationTimeMs = this.graduationTimeMs;
        if (graduationTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeLong(graduationTimeMs.longValue());
        }
        List modules = this.modules;
        parcel.writeInt(modules.size());
        Iterator iterator = modules.iterator();
        while (iterator.hasNext()) {
            size = iterator.next();
            if ((ProgramProgress.ModuleProgress)size == 0) {
            } else {
            }
            parcel.writeInt(i3);
            (ProgramProgress.ModuleProgress)size.writeToParcel(parcel, i2);
            parcel.writeInt(i);
        }
    }
}
