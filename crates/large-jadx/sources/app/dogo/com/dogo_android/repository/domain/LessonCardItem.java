package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0002-.BI\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000cHÆ\u0003JO\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "Landroid/os/Parcelable;", "status", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;", "programName", "", "imageUrl", "description", "lessonNumber", "", "moduleNumber", "type", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;", "(Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;)V", "getDescription", "()Ljava/lang/String;", "getImageUrl", "getLessonNumber", "()I", "getModuleNumber", "getProgramName", "getStatus", "()Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CardStatus", "CardType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LessonCardItem implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LessonCardItem> CREATOR;
    private final String description;
    private final String imageUrl;
    private final int lessonNumber;
    private final int moduleNumber;
    private final String programName;
    private final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus status;
    private final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType type;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardStatus;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "IN_PROGRESS", "COMPLETED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum CardStatus {

        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED;
        private static final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus[] $values() {
            app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus[] arr = new LessonCardItem.CardStatus[3];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem$CardType;", "", "(Ljava/lang/String;I)V", "TRAINING", "TASK", "QUESTION", "HEADER", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum CardType {

        TRAINING,
        TASK,
        QUESTION,
        HEADER;
        private static final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType[] $values() {
            app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType[] arr = new LessonCardItem.CardType[4];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LessonCardItem> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LessonCardItem createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(LessonCardItem.CardStatus.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), LessonCardItem.CardType.valueOf(parcel.readString()));
            return lessonCardItem;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LessonCardItem[] newArray(int i) {
            return new LessonCardItem[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        LessonCardItem.Creator creator = new LessonCardItem.Creator();
        LessonCardItem.CREATOR = creator;
    }

    public LessonCardItem(app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus lessonCardItem$CardStatus, String string2, String string3, String string4, int i5, int i6, app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType lessonCardItem$CardType7) {
        n.f(cardStatus, "status");
        n.f(string2, "programName");
        n.f(string3, "imageUrl");
        n.f(string4, "description");
        n.f(cardType7, "type");
        super();
        this.status = cardStatus;
        this.programName = string2;
        this.imageUrl = string3;
        this.description = string4;
        this.lessonNumber = i5;
        this.moduleNumber = i6;
        this.type = cardType7;
    }

    public LessonCardItem(app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus lessonCardItem$CardStatus, String string2, String string3, String string4, int i5, int i6, app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType lessonCardItem$CardType7, int i8, g g9) {
        app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus nOT_STARTED;
        app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus cardStatus2;
        String str3;
        String str2;
        String str;
        int i2;
        int i;
        cardStatus2 = i8 & 1 != 0 ? nOT_STARTED : cardStatus;
        String str4 = "";
        str3 = i8 & 2 != 0 ? str4 : string2;
        str2 = i8 & 4 != 0 ? str4 : string3;
        str = i8 & 8 != 0 ? str4 : string4;
        int i11 = 0;
        i2 = i8 & 16 != 0 ? i11 : i5;
        i = i8 & 32 != 0 ? i11 : i6;
        super(cardStatus2, str3, str2, str, i2, i, cardType7);
    }

    public static app.dogo.com.dogo_android.repository.domain.LessonCardItem copy$default(app.dogo.com.dogo_android.repository.domain.LessonCardItem lessonCardItem, app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus lessonCardItem$CardStatus2, String string3, String string4, String string5, int i6, int i7, app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType lessonCardItem$CardType8, int i9, Object object10) {
        app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus obj6;
        String obj7;
        String obj8;
        String obj9;
        int obj10;
        int obj11;
        app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType obj12;
        if (i9 & 1 != 0) {
            obj6 = lessonCardItem.status;
        }
        if (i9 & 2 != 0) {
            obj7 = lessonCardItem.programName;
        }
        if (i9 & 4 != 0) {
            obj8 = lessonCardItem.imageUrl;
        }
        if (i9 & 8 != 0) {
            obj9 = lessonCardItem.description;
        }
        if (i9 & 16 != 0) {
            obj10 = lessonCardItem.lessonNumber;
        }
        if (i9 & 32 != 0) {
            obj11 = lessonCardItem.moduleNumber;
        }
        if (i9 & 64 != 0) {
            obj12 = lessonCardItem.type;
        }
        return lessonCardItem.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus component1() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.programName;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final int component5() {
        return this.lessonNumber;
    }

    @Override // android.os.Parcelable
    public final int component6() {
        return this.moduleNumber;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType component7() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonCardItem copy(app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus lessonCardItem$CardStatus, String string2, String string3, String string4, int i5, int i6, app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType lessonCardItem$CardType7) {
        n.f(cardStatus, "status");
        n.f(string2, "programName");
        n.f(string3, "imageUrl");
        n.f(string4, "description");
        final Object obj = cardType7;
        n.f(obj, "type");
        super(cardStatus, string2, string3, string4, i5, i6, obj);
        return lessonCardItem;
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
        if (!object instanceof LessonCardItem) {
            return i2;
        }
        if (this.status != object.status) {
            return i2;
        }
        if (!n.b(this.programName, object.programName)) {
            return i2;
        }
        if (!n.b(this.imageUrl, object.imageUrl)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (this.lessonNumber != object.lessonNumber) {
            return i2;
        }
        if (this.moduleNumber != object.moduleNumber) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public final int getLessonNumber() {
        return this.lessonNumber;
    }

    @Override // android.os.Parcelable
    public final int getModuleNumber() {
        return this.moduleNumber;
    }

    @Override // android.os.Parcelable
    public final String getProgramName() {
        return this.programName;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus getStatus() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i12 += i19;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LessonCardItem(status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", programName=");
        stringBuilder.append(this.programName);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", lessonNumber=");
        stringBuilder.append(this.lessonNumber);
        stringBuilder.append(", moduleNumber=");
        stringBuilder.append(this.moduleNumber);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
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
