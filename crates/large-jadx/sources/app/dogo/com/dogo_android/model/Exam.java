package app.dogo.com.dogo_android.model;

import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.t;
import com.google.firebase.firestore.Exclude;
import java.io.Serializable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: Exam.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002MNB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u0019\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008BM\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010Bc\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0015B3\u0008\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001aJ\n\u0010H\u001a\u0004\u0018\u00010IH\u0007J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0007H\u0016R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R\u001a\u0010\n\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u001c\"\u0004\u0008$\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u001c\"\u0004\u0008&\u0010\u001eR\u0011\u0010'\u001a\u00020(8G¢\u0006\u0006\u001a\u0004\u0008)\u0010*R$\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0008\u0010+\u001a\u0004\u0018\u00010\u00078G@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001cR\u0014\u0010-\u001a\u00020.X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010/R\u0013\u00100\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u001cR\u0013\u00102\u001a\u0004\u0018\u000103¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010 R\u0013\u00107\u001a\u0004\u0018\u000103¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00105R\u001a\u0010\t\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u0010\u001c\"\u0004\u0008:\u0010\u001eR\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0013\u0010;\u001a\u0004\u0018\u000103¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u00105R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010\u001c\"\u0004\u0008>\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010\u001c\"\u0004\u0008@\u0010\u001eR\u0013\u0010A\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u0010\u001cR&\u0010\u0013\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f8G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u0010D\"\u0004\u0008E\u0010FR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0008\u0010+\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010\u001c¨\u0006O", d2 = {"Lapp/dogo/com/dogo_android/model/Exam;", "Ljava/io/Serializable;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "()V", "status", "", "userId", "", "(ILjava/lang/String;)V", "trickId", "dogId", "dogName", "dogAvatarUrl", "dogGender", "trickOrder", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IJ)V", "userLocale", "instructions", "videoTimeLimit", "videoUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "dogProfileModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/model/DogProfileModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogAvatarUrl", "()Ljava/lang/String;", "setDogAvatarUrl", "(Ljava/lang/String;)V", "getDogGender", "()I", "setDogGender", "(I)V", "getDogId", "setDogId", "getDogName", "setDogName", "examStatus", "Lapp/dogo/com/dogo_android/model/Exam$Status;", "getExamStatus", "()Lapp/dogo/com/dogo_android/model/Exam$Status;", "<set-?>", "getInstructions", "isActive", "", "()Z", "reviewComment", "getReviewComment", "reviewDate", "Ljava/util/Date;", "getReviewDate", "()Ljava/util/Date;", "getStatus", "submittionDate", "getSubmittionDate", "getTrickId", "setTrickId", "unlockDate", "getUnlockDate", "getUserId", "setUserId", "getUserLocale", "setUserLocale", "videoThumbnailUrl", "getVideoThumbnailUrl", "getVideoTimeLimit", "()J", "setVideoTimeLimit", "(J)V", "getVideoUrl", "findExamViewType", "Lapp/dogo/com/dogo_android/model/Exam$ExamViewType;", "setDocumentId", "", "id", "ExamViewType", "Status", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Exam implements Serializable, t {

    private String dogAvatarUrl;
    private int dogGender;
    public String dogId;
    private String dogName;
    @Exclude
    private String instructions;
    private final boolean isActive;
    private final String reviewComment;
    private final Date reviewDate;
    private int status;
    private final Date submittionDate;
    public String trickId;
    @Exclude
    private long trickOrder;
    private final Date unlockDate;
    private String userId;
    private String userLocale;
    private final String videoThumbnailUrl;
    @Exclude
    private long videoTimeLimit;
    private String videoUrl;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\n\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/model/Exam$ExamViewType;", "", "(Ljava/lang/String;I)V", "FEEDBACK_APPROVED", "FEEDBACK_REJECTED", "ACTIVE_START", "ACTIVE_REJECTED", "ACTIVE_UPLOADING", "ACTIVE_PENDING", "PASSED_FINISHED", "FUTURE_LOCKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ExamViewType {

        ACTIVE_PENDING,
        ACTIVE_REJECTED,
        ACTIVE_START,
        ACTIVE_UPLOADING,
        FEEDBACK_APPROVED,
        FEEDBACK_REJECTED,
        FUTURE_LOCKED,
        PASSED_FINISHED;
        private static final /* synthetic */ Exam.ExamViewType[] $values() {
            app.dogo.com.dogo_android.model.Exam.ExamViewType[] arr = new Exam.ExamViewType[8];
            return new Exam.ExamViewType[] { Exam_ExamViewType.FEEDBACK_APPROVED, Exam_ExamViewType.FEEDBACK_REJECTED, Exam_ExamViewType.ACTIVE_START, Exam_ExamViewType.ACTIVE_REJECTED, Exam_ExamViewType.ACTIVE_UPLOADING, Exam_ExamViewType.ACTIVE_PENDING, Exam_ExamViewType.PASSED_FINISHED, Exam_ExamViewType.FUTURE_LOCKED };
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/model/Exam$Status;", "", "(Ljava/lang/String;I)V", "REJECTED", "APPROVED", "PENDING", "READY_TO_START", "UPLOADING", "FINISHED", "LOCKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Status {

        APPROVED,
        FINISHED,
        LOCKED,
        PENDING,
        READY_TO_START,
        REJECTED,
        UPLOADING;
        private static final /* synthetic */ Exam.Status[] $values() {
            app.dogo.com.dogo_android.model.Exam.Status[] arr = new Exam.Status[7];
            return new Exam.Status[] { Exam_Status.REJECTED, Exam_Status.APPROVED, Exam_Status.PENDING, Exam_Status.READY_TO_START, Exam_Status.UPLOADING, Exam_Status.FINISHED, Exam_Status.LOCKED };
        }
    }
    @Exclude
    public final Exam.ExamViewType findExamViewType() {
        app.dogo.com.dogo_android.model.Exam.Status examStatus = getExamStatus();
        if (this.isActive) {
            if (examStatus == Exam_Status.APPROVED) {
                return Exam_ExamViewType.FEEDBACK_APPROVED;
            }
            if (examStatus == Exam_Status.REJECTED) {
                return Exam_ExamViewType.FEEDBACK_REJECTED;
            }
        } else {
            if (examStatus == Exam_Status.READY_TO_START) {
                return Exam_ExamViewType.ACTIVE_START;
            }
            if (examStatus == Exam_Status.REJECTED) {
                return Exam_ExamViewType.ACTIVE_REJECTED;
            }
            if (examStatus == Exam_Status.UPLOADING) {
                return Exam_ExamViewType.ACTIVE_UPLOADING;
            }
            if (examStatus == Exam_Status.PENDING) {
                return Exam_ExamViewType.ACTIVE_PENDING;
            }
            if (examStatus == Exam_Status.FINISHED) {
                return Exam_ExamViewType.PASSED_FINISHED;
            }
            if (examStatus == Exam_Status.LOCKED) {
                return Exam_ExamViewType.FUTURE_LOCKED;
            }
        }
        return null;
    }

    public final String getDogAvatarUrl() {
        return this.dogAvatarUrl;
    }

    public final int getDogGender() {
        return this.dogGender;
    }

    public final String getDogId() {
        if (this.dogId == null) {
            n.w("dogId");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.dogId;
        }
    }

    public final String getDogName() {
        return this.dogName;
    }

    @Exclude
    public final Exam.Status getExamStatus() {
        int status2;
        length = Exam_Status.values().length;
        if (Exam_Status.values().length <= this.status) {
            length = Exam_Status.values().length;
            status2 = length - 1;
        }
        return Exam_Status.values()[status2];
    }

    @Exclude
    public final String getInstructions() {
        return this.instructions;
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

    public final Date getSubmittionDate() {
        return this.submittionDate;
    }

    public final String getTrickId() {
        if (this.trickId == null) {
            n.w("trickId");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.trickId;
        }
    }

    public final Date getUnlockDate() {
        return this.unlockDate;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserLocale() {
        return this.userLocale;
    }

    public final String getVideoThumbnailUrl() {
        return this.videoThumbnailUrl;
    }

    @Exclude
    public final long getVideoTimeLimit() {
        return this.videoTimeLimit;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setDogAvatarUrl(String str) {
        this.dogAvatarUrl = str;
    }

    public final void setDogGender(int i) {
        this.dogGender = i;
    }

    public final void setDogId(String str) {
        n.f(str, "<set-?>");
        this.dogId = str;
    }

    public final void setDogName(String str) {
        this.dogName = str;
    }

    public final void setTrickId(String str) {
        n.f(str, "<set-?>");
        this.trickId = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserLocale(String str) {
        this.userLocale = str;
    }

    @Exclude
    public final void setVideoTimeLimit(long j) {
        this.videoTimeLimit = j;
    }

    public Exam(int i, String str) {
        super();
        this.status = i;
        this.userId = str;
    }

    public Exam(String str, String str2, String str3, String str4, int i, String str5, int i2, long j) {
        n.f(str, "trickId");
        n.f(str2, "dogId");
        super();
        setTrickId(str);
        this.status = i2;
        this.trickOrder = j;
        setDogId(str2);
        this.userId = str5;
        this.dogAvatarUrl = str4;
        this.dogGender = i;
        this.dogName = str3;
    }

    public Exam(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, int i2, String str8) {
        n.f(str, "trickId");
        n.f(str2, "dogId");
        super();
        setTrickId(str);
        this.userLocale = str6;
        setDogId(str2);
        this.userId = str5;
        this.dogAvatarUrl = str4;
        this.dogGender = i;
        this.dogName = str3;
        this.instructions = str7;
        this.videoTimeLimit = (long)i2;
        this.videoUrl = str8;
    }

    public Exam(TrickItem trickItem, DogProfileModel dogProfileModel, String str, String str2, String str3) {
        n.f(trickItem, "trickItem");
        n.f(dogProfileModel, "dogProfileModel");
        n.f(str, "userId");
        n.f(str2, "userLocale");
        super();
        setTrickId(trickItem.getId());
        this.userLocale = str2;
        setDogId(dogProfileModel.getId());
        this.userId = str;
        this.dogAvatarUrl = dogProfileModel.getAvatar();
        this.dogGender = dogProfileModel.getGender();
        this.dogName = dogProfileModel.getName();
        this.instructions = trickItem.getDescription();
        this.videoTimeLimit = (long)trickItem.getVideoTimeLimit();
        this.videoUrl = str3;
    }

    public /* synthetic */ Exam(TrickItem trickItem, DogProfileModel dogProfileModel, String str, String str2, String str3, int i, g gVar) {
        i = i & 16 != 0 ? 0 : i;
        this(trickItem, dogProfileModel, str, str2, i);
    }

    public void setDocumentId(String id) {
        n.f(id, "id");
    }
}
