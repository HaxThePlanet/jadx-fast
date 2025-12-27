package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LessonCardItem.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0002-.BI\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000cHÆ\u0003JO\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "Landroid/os/Parcelable;", "status", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;", "programName", "", "imageUrl", "description", "lessonNumber", "", "moduleNumber", "type", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;", "(Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;)V", "getDescription", "()Ljava/lang/String;", "getImageUrl", "getLessonNumber", "()I", "getModuleNumber", "getProgramName", "getStatus", "()Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CardStatus", "CardType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LessonCardItem implements Parcelable {

    public static final Parcelable.Creator<LessonCardItem> CREATOR = new LessonCardItem$Creator<>();
    private final String description;
    private final String imageUrl;
    private final int lessonNumber;
    private final int moduleNumber;
    private final String programName;
    private final LessonCardItem.CardStatus status;
    private final LessonCardItem.CardType type;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "IN_PROGRESS", "COMPLETED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CardStatus {

        COMPLETED,
        IN_PROGRESS,
        NOT_STARTED;
        private static final /* synthetic */ LessonCardItem.CardStatus[] $values() {
            app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus[] arr = new LessonCardItem.CardStatus[3];
            return new LessonCardItem.CardStatus[] { LessonCardItem_CardStatus.NOT_STARTED, LessonCardItem_CardStatus.IN_PROGRESS, LessonCardItem_CardStatus.COMPLETED };
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;", "", "(Ljava/lang/String;I)V", "TRAINING", "TASK", "QUESTION", "HEADER", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CardType {

        HEADER,
        QUESTION,
        TASK,
        TRAINING;
        private static final /* synthetic */ LessonCardItem.CardType[] $values() {
            app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType[] arr = new LessonCardItem.CardType[4];
            return new LessonCardItem.CardType[] { LessonCardItem_CardType.TRAINING, LessonCardItem_CardType.TASK, LessonCardItem_CardType.QUESTION, LessonCardItem_CardType.HEADER };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LessonCardItem> {
        @Override // android.os.Parcelable$Creator
        public final LessonCardItem createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            LessonCardItem lessonCardItem = new LessonCardItem(LessonCardItem_CardStatus.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), LessonCardItem_CardType.valueOf(parcel.readString()));
            return lessonCardItem;
        }

        @Override // android.os.Parcelable$Creator
        public final LessonCardItem[] newArray(int i) {
            return new LessonCardItem[i];
        }
    }
    public LessonCardItem(LessonCardItem.CardStatus cardStatus, String str, String str2, String str3, int i, int i2, LessonCardItem.CardType cardType) {
        n.f(cardStatus, "status");
        n.f(str, "programName");
        n.f(str2, "imageUrl");
        n.f(str3, "description");
        n.f(cardType, "type");
        super();
        this.status = cardStatus;
        this.programName = str;
        this.imageUrl = str2;
        this.description = str3;
        this.lessonNumber = i;
        this.moduleNumber = i2;
        this.type = cardType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getLessonNumber() {
        return this.lessonNumber;
    }

    public final int getModuleNumber() {
        return this.moduleNumber;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final LessonCardItem.CardStatus getStatus() {
        return this.status;
    }

    public final LessonCardItem.CardType getType() {
        return this.type;
    }

    public /* synthetic */ LessonCardItem(LessonCardItem.CardStatus cardStatus, String str, String str2, String str3, int i, int i2, LessonCardItem.CardType cardType, int i3, g gVar) {
        app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus cardStatus2;
        String str22;
        int i52;
        cardStatus2 = i3 & 1 != 0 ? cardStatus2 : cardStatus;
        str22 = "";
        String r3 = i3 & 2 != 0 ? str22 : str;
        String r4 = i3 & 4 != 0 ? str22 : str2;
        String r5 = i3 & 8 != 0 ? str22 : str3;
        i52 = 0;
        int r6 = i3 & 16 != 0 ? i52 : i;
        int r7 = i3 & 32 != 0 ? i52 : i2;
        this(cardStatus2, str22, str22, str22, i52, (i3 & 32 != 0 ? i52 : i2), cardType);
    }


    public static /* synthetic */ LessonCardItem copy$default(LessonCardItem lessonCardItem, LessonCardItem.CardStatus cardStatus, String str, String str2, String str3, int i, int i2, LessonCardItem.CardType cardType, int i3, Object object) {
        app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus cardStatus22;
        String object102;
        String str42;
        String str52;
        int i62;
        int i72;
        app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType cardType82;
        if (i3 & 1 != 0) {
        }
        if (i3 & 2 != 0) {
        }
        if (i3 & 4 != 0) {
        }
        if (i3 & 8 != 0) {
        }
        if (i3 & 16 != 0) {
        }
        if (i3 & 32 != 0) {
        }
        if (i3 & 64 != 0) {
        }
        return lessonCardItem.copy(cardStatus22, object102, str42, str52, i62, i72, cardType82);
    }

    /* operator */ public final LessonCardItem.CardStatus component1() {
        return this.status;
    }

    /* operator */ public final String component2() {
        return this.programName;
    }

    /* operator */ public final String component3() {
        return this.imageUrl;
    }

    /* operator */ public final String component4() {
        return this.description;
    }

    /* operator */ public final int component5() {
        return this.lessonNumber;
    }

    /* operator */ public final int component6() {
        return this.moduleNumber;
    }

    /* operator */ public final LessonCardItem.CardType component7() {
        return this.type;
    }

    public final LessonCardItem copy(LessonCardItem.CardStatus status, String programName, String imageUrl, String description, int lessonNumber, int moduleNumber, LessonCardItem.CardType type) {
        n.f(status, "status");
        n.f(programName, "programName");
        n.f(imageUrl, "imageUrl");
        n.f(description, "description");
        final Object type2 = type;
        n.f(type2, "type");
        LessonCardItem lessonCardItem = new LessonCardItem(status, programName, imageUrl, description, lessonNumber, moduleNumber, type2);
        return lessonCardItem;
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
        if (!(other instanceof LessonCardItem)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!n.b(this.programName, other.programName)) {
            return false;
        }
        if (!n.b(this.imageUrl, other.imageUrl)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (this.lessonNumber != other.lessonNumber) {
            return false;
        }
        if (this.moduleNumber != other.moduleNumber) {
            return false;
        }
        return this.type != other.type ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.status.hashCode() * 31) + this.programName.hashCode() * 31 + this.imageUrl.hashCode() * 31 + this.description.hashCode() * 31 + Integer.hashCode(this.lessonNumber) * 31 + Integer.hashCode(this.moduleNumber) * 31 + this.type.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonCardItem(status=";
        String str3 = ", programName=";
        String str4 = ", imageUrl=";
        String str5 = ", description=";
        String str6 = ", lessonNumber=";
        String str7 = ", moduleNumber=";
        String str8 = ", type=";
        str = str2 + this.status + str3 + this.programName + str4 + this.imageUrl + str5 + this.description + str6 + this.lessonNumber + str7 + this.moduleNumber + str8 + this.type + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.status.name());
        parcel.writeString(this.programName);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.description);
        parcel.writeInt(this.lessonNumber);
        parcel.writeInt(this.moduleNumber);
        parcel.writeString(this.type.name());
    }
}
