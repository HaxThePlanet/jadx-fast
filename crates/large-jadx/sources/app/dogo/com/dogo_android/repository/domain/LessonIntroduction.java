package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001'BA\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "Landroid/os/Parcelable;", "cardTitle", "", "cardDescription", "title", "description", "type", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;", "cardBackgroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;Ljava/lang/String;)V", "getCardBackgroundColor", "()Ljava/lang/String;", "getCardDescription", "getCardTitle", "getDescription", "getTitle", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CardType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LessonIntroduction implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LessonIntroduction> CREATOR;
    private final String cardBackgroundColor;
    private final String cardDescription;
    private final String cardTitle;
    private final String description;
    private final String title;
    private final app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType type;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;", "", "(Ljava/lang/String;I)V", "LESSON", "TRAINING", "QUESTION", "ACTIVITY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum CardType {

        LESSON,
        TRAINING,
        QUESTION,
        ACTIVITY;
        private static final app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType[] $values() {
            app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType[] arr = new LessonIntroduction.CardType[4];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LessonIntroduction> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LessonIntroduction createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), LessonIntroduction.CardType.valueOf(parcel.readString()), parcel.readString());
            return lessonIntroduction;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LessonIntroduction[] newArray(int i) {
            return new LessonIntroduction[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        LessonIntroduction.Creator creator = new LessonIntroduction.Creator();
        LessonIntroduction.CREATOR = creator;
    }

    public LessonIntroduction() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public LessonIntroduction(String string, String string2, String string3, String string4, app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType lessonIntroduction$CardType5, String string6) {
        n.f(string, "cardTitle");
        n.f(string2, "cardDescription");
        n.f(string3, "title");
        n.f(string4, "description");
        n.f(cardType5, "type");
        n.f(string6, "cardBackgroundColor");
        super();
        this.cardTitle = string;
        this.cardDescription = string2;
        this.title = string3;
        this.description = string4;
        this.type = cardType5;
        this.cardBackgroundColor = string6;
    }

    public LessonIntroduction(String string, String string2, String string3, String string4, app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType lessonIntroduction$CardType5, String string6, int i7, g g8) {
        String str3;
        String str;
        String str2;
        app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType obj10;
        String obj12;
        String obj13;
        final String str4 = "";
        obj13 = i7 & 1 != 0 ? str4 : string;
        str3 = i7 & 2 != 0 ? str4 : string2;
        str = i7 & 4 != 0 ? str4 : string3;
        str2 = i7 & 8 != 0 ? str4 : string4;
        obj10 = i7 & 16 != 0 ? LessonIntroduction.CardType.LESSON : obj10;
        obj12 = i7 & 32 != 0 ? str4 : string6;
        super(obj13, str3, str, str2, obj10, obj12);
    }

    public static app.dogo.com.dogo_android.repository.domain.LessonIntroduction copy$default(app.dogo.com.dogo_android.repository.domain.LessonIntroduction lessonIntroduction, String string2, String string3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType lessonIntroduction$CardType6, String string7, int i8, Object object9) {
        String obj5;
        String obj6;
        String obj7;
        String obj8;
        app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType obj9;
        String obj10;
        if (i8 & 1 != 0) {
            obj5 = lessonIntroduction.cardTitle;
        }
        if (i8 & 2 != 0) {
            obj6 = lessonIntroduction.cardDescription;
        }
        if (i8 & 4 != 0) {
            obj7 = lessonIntroduction.title;
        }
        if (i8 & 8 != 0) {
            obj8 = lessonIntroduction.description;
        }
        if (i8 & 16 != 0) {
            obj9 = lessonIntroduction.type;
        }
        if (i8 & 32 != 0) {
            obj10 = lessonIntroduction.cardBackgroundColor;
        }
        return lessonIntroduction.copy(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.cardTitle;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.cardDescription;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType component5() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.cardBackgroundColor;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonIntroduction copy(String string, String string2, String string3, String string4, app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType lessonIntroduction$CardType5, String string6) {
        n.f(string, "cardTitle");
        n.f(string2, "cardDescription");
        n.f(string3, "title");
        n.f(string4, "description");
        n.f(cardType5, "type");
        n.f(string6, "cardBackgroundColor");
        super(string, string2, string3, string4, cardType5, string6);
        return lessonIntroduction;
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
        if (!object instanceof LessonIntroduction) {
            return i2;
        }
        if (!n.b(this.cardTitle, object.cardTitle)) {
            return i2;
        }
        if (!n.b(this.cardDescription, object.cardDescription)) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        if (!n.b(this.cardBackgroundColor, object.cardBackgroundColor)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    @Override // android.os.Parcelable
    public final String getCardDescription() {
        return this.cardDescription;
    }

    @Override // android.os.Parcelable
    public final String getCardTitle() {
        return this.cardTitle;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i10 += i16;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LessonIntroduction(cardTitle=");
        stringBuilder.append(this.cardTitle);
        stringBuilder.append(", cardDescription=");
        stringBuilder.append(this.cardDescription);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", cardBackgroundColor=");
        stringBuilder.append(this.cardBackgroundColor);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.cardTitle);
        parcel.writeString(this.cardDescription);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.type.name());
        parcel.writeString(this.cardBackgroundColor);
    }
}
