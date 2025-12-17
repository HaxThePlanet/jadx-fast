package app.dogo.com.dogo_android.model;

import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.t;
import com.google.firebase.firestore.Exclude;
import java.io.Serializable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002MNB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u0019\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008BM\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010Bc\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0015B3\u0008\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001aJ\n\u0010H\u001a\u0004\u0018\u00010IH\u0007J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0007H\u0016R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R\u001a\u0010\n\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u001c\"\u0004\u0008$\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u001c\"\u0004\u0008&\u0010\u001eR\u0011\u0010'\u001a\u00020(8G¢\u0006\u0006\u001a\u0004\u0008)\u0010*R$\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0008\u0010+\u001a\u0004\u0018\u00010\u00078G@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001cR\u0014\u0010-\u001a\u00020.X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010/R\u0013\u00100\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u001cR\u0013\u00102\u001a\u0004\u0018\u000103¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010 R\u0013\u00107\u001a\u0004\u0018\u000103¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00105R\u001a\u0010\t\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u0010\u001c\"\u0004\u0008:\u0010\u001eR\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0013\u0010;\u001a\u0004\u0018\u000103¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u00105R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010\u001c\"\u0004\u0008>\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010\u001c\"\u0004\u0008@\u0010\u001eR\u0013\u0010A\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u0010\u001cR&\u0010\u0013\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f8G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u0010D\"\u0004\u0008E\u0010FR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0008\u0010+\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010\u001c¨\u0006O", d2 = {"Lapp/dogo/com/dogo_android/model/Exam;", "Ljava/io/Serializable;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "()V", "status", "", "userId", "", "(ILjava/lang/String;)V", "trickId", "dogId", "dogName", "dogAvatarUrl", "dogGender", "trickOrder", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IJ)V", "userLocale", "instructions", "videoTimeLimit", "videoUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "dogProfileModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/model/DogProfileModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogAvatarUrl", "()Ljava/lang/String;", "setDogAvatarUrl", "(Ljava/lang/String;)V", "getDogGender", "()I", "setDogGender", "(I)V", "getDogId", "setDogId", "getDogName", "setDogName", "examStatus", "Lapp/dogo/com/dogo_android/model/Exam$Status;", "getExamStatus", "()Lapp/dogo/com/dogo_android/model/Exam$Status;", "<set-?>", "getInstructions", "isActive", "", "()Z", "reviewComment", "getReviewComment", "reviewDate", "Ljava/util/Date;", "getReviewDate", "()Ljava/util/Date;", "getStatus", "submittionDate", "getSubmittionDate", "getTrickId", "setTrickId", "unlockDate", "getUnlockDate", "getUserId", "setUserId", "getUserLocale", "setUserLocale", "videoThumbnailUrl", "getVideoThumbnailUrl", "getVideoTimeLimit", "()J", "setVideoTimeLimit", "(J)V", "getVideoUrl", "findExamViewType", "Lapp/dogo/com/dogo_android/model/Exam$ExamViewType;", "setDocumentId", "", "id", "ExamViewType", "Status", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
    public static enum ExamViewType {

        FEEDBACK_APPROVED,
        FEEDBACK_REJECTED,
        ACTIVE_START,
        ACTIVE_REJECTED,
        ACTIVE_UPLOADING,
        ACTIVE_PENDING,
        PASSED_FINISHED,
        FUTURE_LOCKED;
        private static final app.dogo.com.dogo_android.model.Exam.ExamViewType[] $values() {
            app.dogo.com.dogo_android.model.Exam.ExamViewType[] arr = new Exam.ExamViewType[8];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/model/Exam$Status;", "", "(Ljava/lang/String;I)V", "REJECTED", "APPROVED", "PENDING", "READY_TO_START", "UPLOADING", "FINISHED", "LOCKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum Status {

        REJECTED,
        APPROVED,
        PENDING,
        READY_TO_START,
        UPLOADING,
        FINISHED,
        LOCKED;
        private static final app.dogo.com.dogo_android.model.Exam.Status[] $values() {
            app.dogo.com.dogo_android.model.Exam.Status[] arr = new Exam.Status[7];
            return arr;
        }
    }
    public Exam(int i, String string2) {
        super();
        this.status = i;
        this.userId = string2;
    }

    public Exam(TrickItem trickItem, app.dogo.com.dogo_android.model.DogProfileModel dogProfileModel2, String string3, String string4, String string5) {
        n.f(trickItem, "trickItem");
        n.f(dogProfileModel2, "dogProfileModel");
        n.f(string3, "userId");
        n.f(string4, "userLocale");
        super();
        setTrickId(trickItem.getId());
        this.userLocale = string4;
        setDogId(dogProfileModel2.getId());
        this.userId = string3;
        this.dogAvatarUrl = dogProfileModel2.getAvatar();
        this.dogGender = dogProfileModel2.getGender();
        this.dogName = dogProfileModel2.getName();
        this.instructions = trickItem.getDescription();
        this.videoTimeLimit = (long)obj2;
        this.videoUrl = string5;
    }

    public Exam(TrickItem trickItem, app.dogo.com.dogo_android.model.DogProfileModel dogProfileModel2, String string3, String string4, String string5, int i6, g g7) {
        int obj11;
        obj11 = i6 &= 16 != 0 ? 0 : obj11;
        super(trickItem, dogProfileModel2, string3, string4, obj11);
    }

    public Exam(String string, String string2, String string3, String string4, int i5, String string6, int i7, long l8) {
        n.f(string, "trickId");
        n.f(string2, "dogId");
        super();
        setTrickId(string);
        this.status = i7;
        this.trickOrder = l8;
        setDogId(string2);
        this.userId = string6;
        this.dogAvatarUrl = string4;
        this.dogGender = i5;
        this.dogName = string3;
    }

    public Exam(String string, String string2, String string3, String string4, int i5, String string6, String string7, String string8, int i9, String string10) {
        n.f(string, "trickId");
        n.f(string2, "dogId");
        super();
        setTrickId(string);
        this.userLocale = string7;
        setDogId(string2);
        this.userId = string6;
        this.dogAvatarUrl = string4;
        this.dogGender = i5;
        this.dogName = string3;
        this.instructions = string8;
        this.videoTimeLimit = (long)i9;
        this.videoUrl = string10;
    }

    @Exclude
    public final app.dogo.com.dogo_android.model.Exam.ExamViewType findExamViewType() {
        app.dogo.com.dogo_android.model.Exam.Status rEJECTED;
        app.dogo.com.dogo_android.model.Exam.Status examStatus = getExamStatus();
        if (this.isActive) {
            if (examStatus == Exam.Status.APPROVED) {
                return Exam.ExamViewType.FEEDBACK_APPROVED;
            }
            if (examStatus == Exam.Status.REJECTED) {
                return Exam.ExamViewType.FEEDBACK_REJECTED;
            }
        } else {
            if (examStatus == Exam.Status.READY_TO_START) {
                return Exam.ExamViewType.ACTIVE_START;
            }
            if (examStatus == Exam.Status.REJECTED) {
                return Exam.ExamViewType.ACTIVE_REJECTED;
            }
            if (examStatus == Exam.Status.UPLOADING) {
                return Exam.ExamViewType.ACTIVE_UPLOADING;
            }
            if (examStatus == Exam.Status.PENDING) {
                return Exam.ExamViewType.ACTIVE_PENDING;
            }
            if (examStatus == Exam.Status.FINISHED) {
                return Exam.ExamViewType.PASSED_FINISHED;
            }
            if (examStatus == Exam.Status.LOCKED) {
                return Exam.ExamViewType.FUTURE_LOCKED;
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public final String getDogAvatarUrl() {
        return this.dogAvatarUrl;
    }

    @Override // java.io.Serializable
    public final int getDogGender() {
        return this.dogGender;
    }

    @Override // java.io.Serializable
    public final String getDogId() {
        String dogId = this.dogId;
        if (dogId == null) {
        } else {
            return dogId;
        }
        n.w("dogId");
        throw 0;
    }

    @Override // java.io.Serializable
    public final String getDogName() {
        return this.dogName;
    }

    @Exclude
    public final app.dogo.com.dogo_android.model.Exam.Status getExamStatus() {
        int length;
        int status;
        if (values2.length > this.status) {
        } else {
            status = length + -1;
        }
        return Exam.Status.values()[status];
    }

    @Exclude
    public final String getInstructions() {
        return this.instructions;
    }

    @Override // java.io.Serializable
    public final String getReviewComment() {
        return this.reviewComment;
    }

    @Override // java.io.Serializable
    public final Date getReviewDate() {
        return this.reviewDate;
    }

    @Override // java.io.Serializable
    public final int getStatus() {
        return this.status;
    }

    @Override // java.io.Serializable
    public final Date getSubmittionDate() {
        return this.submittionDate;
    }

    @Override // java.io.Serializable
    public final String getTrickId() {
        String trickId = this.trickId;
        if (trickId == null) {
        } else {
            return trickId;
        }
        n.w("trickId");
        throw 0;
    }

    @Override // java.io.Serializable
    public final Date getUnlockDate() {
        return this.unlockDate;
    }

    @Override // java.io.Serializable
    public final String getUserId() {
        return this.userId;
    }

    @Override // java.io.Serializable
    public final String getUserLocale() {
        return this.userLocale;
    }

    @Override // java.io.Serializable
    public final String getVideoThumbnailUrl() {
        return this.videoThumbnailUrl;
    }

    @Exclude
    public final long getVideoTimeLimit() {
        return this.videoTimeLimit;
    }

    @Override // java.io.Serializable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // java.io.Serializable
    public final boolean isActive() {
        return this.isActive;
    }

    @Override // java.io.Serializable
    public void setDocumentId(String string) {
        n.f(string, "id");
    }

    @Override // java.io.Serializable
    public final void setDogAvatarUrl(String string) {
        this.dogAvatarUrl = string;
    }

    @Override // java.io.Serializable
    public final void setDogGender(int i) {
        this.dogGender = i;
    }

    @Override // java.io.Serializable
    public final void setDogId(String string) {
        n.f(string, "<set-?>");
        this.dogId = string;
    }

    @Override // java.io.Serializable
    public final void setDogName(String string) {
        this.dogName = string;
    }

    @Override // java.io.Serializable
    public final void setTrickId(String string) {
        n.f(string, "<set-?>");
        this.trickId = string;
    }

    @Override // java.io.Serializable
    public final void setUserId(String string) {
        this.userId = string;
    }

    @Override // java.io.Serializable
    public final void setUserLocale(String string) {
        this.userLocale = string;
    }

    @Exclude
    public final void setVideoTimeLimit(long l) {
        this.videoTimeLimit = l;
    }
}
