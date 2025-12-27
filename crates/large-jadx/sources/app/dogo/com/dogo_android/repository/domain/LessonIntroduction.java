package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LessonIntroduction.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001'BA\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "Landroid/os/Parcelable;", "cardTitle", "", "cardDescription", "title", "description", "type", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;", "cardBackgroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;Ljava/lang/String;)V", "getCardBackgroundColor", "()Ljava/lang/String;", "getCardDescription", "getCardTitle", "getDescription", "getTitle", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CardType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LessonIntroduction implements Parcelable {

    public static final Parcelable.Creator<LessonIntroduction> CREATOR = new LessonIntroduction$Creator<>();
    private final String cardBackgroundColor;
    private final String cardDescription;
    private final String cardTitle;
    private final String description;
    private final String title;
    private final LessonIntroduction.CardType type;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction$CardType;", "", "(Ljava/lang/String;I)V", "LESSON", "TRAINING", "QUESTION", "ACTIVITY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CardType {

        ACTIVITY,
        LESSON,
        QUESTION,
        TRAINING;
        private static final /* synthetic */ LessonIntroduction.CardType[] $values() {
            app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType[] arr = new LessonIntroduction.CardType[4];
            return new LessonIntroduction.CardType[] { LessonIntroduction_CardType.LESSON, LessonIntroduction_CardType.TRAINING, LessonIntroduction_CardType.QUESTION, LessonIntroduction_CardType.ACTIVITY };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LessonIntroduction> {
        @Override // android.os.Parcelable$Creator
        public final LessonIntroduction createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            LessonIntroduction lessonIntroduction = new LessonIntroduction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), LessonIntroduction_CardType.valueOf(parcel.readString()), parcel.readString());
            return lessonIntroduction;
        }

        @Override // android.os.Parcelable$Creator
        public final LessonIntroduction[] newArray(int i) {
            return new LessonIntroduction[i];
        }
    }
    public LessonIntroduction(String str, String str2, String str3, String str4, LessonIntroduction.CardType cardType, String str5) {
        n.f(str, "cardTitle");
        n.f(str2, "cardDescription");
        n.f(str3, "title");
        n.f(str4, "description");
        n.f(cardType, "type");
        n.f(str5, "cardBackgroundColor");
        super();
        this.cardTitle = str;
        this.cardDescription = str2;
        this.title = str3;
        this.description = str4;
        this.type = cardType;
        this.cardBackgroundColor = str5;
    }

    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    public final String getCardDescription() {
        return this.cardDescription;
    }

    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public final LessonIntroduction.CardType getType() {
        return this.type;
    }

    public /* synthetic */ LessonIntroduction(String str, String str2, String str3, String str4, LessonIntroduction.CardType cardType, String str5, int i, g gVar) {
        String str22;
        app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType cardType52;
        str22 = "";
        gVar = i & 1 != 0 ? str22 : str;
        String r1 = i & 2 != 0 ? str22 : str2;
        String r2 = i & 4 != 0 ? str22 : str3;
        String r3 = i & 8 != 0 ? str22 : str4;
        cardType52 = i & 16 != 0 ? LessonIntroduction_CardType.LESSON : cardType52;
        i = i & 32 != 0 ? str22 : str5;
        this(str22, str22, str22, str22, cardType52, (i & 32 != 0 ? str22 : str5));
    }


    public LessonIntroduction() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LessonIntroduction copy$default(LessonIntroduction lessonIntroduction, String str, String str2, String str3, String str4, LessonIntroduction.CardType cardType, String str5, int i, Object object) {
        String str22;
        String object92;
        String str42;
        String str52;
        app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType cardType62;
        String str72;
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
        return lessonIntroduction.copy(str22, object92, str42, str52, cardType62, str72);
    }

    /* operator */ public final String component1() {
        return this.cardTitle;
    }

    /* operator */ public final String component2() {
        return this.cardDescription;
    }

    /* operator */ public final String component3() {
        return this.title;
    }

    /* operator */ public final String component4() {
        return this.description;
    }

    /* operator */ public final LessonIntroduction.CardType component5() {
        return this.type;
    }

    /* operator */ public final String component6() {
        return this.cardBackgroundColor;
    }

    public final LessonIntroduction copy(String cardTitle, String cardDescription, String title, String description, LessonIntroduction.CardType type, String cardBackgroundColor) {
        n.f(cardTitle, "cardTitle");
        n.f(cardDescription, "cardDescription");
        n.f(title, "title");
        n.f(description, "description");
        n.f(type, "type");
        n.f(cardBackgroundColor, "cardBackgroundColor");
        LessonIntroduction lessonIntroduction = new LessonIntroduction(cardTitle, cardDescription, title, description, type, cardBackgroundColor);
        return lessonIntroduction;
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
        if (!(other instanceof LessonIntroduction)) {
            return false;
        }
        if (!n.b(this.cardTitle, other.cardTitle)) {
            return false;
        }
        if (!n.b(this.cardDescription, other.cardDescription)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return !n.b(this.cardBackgroundColor, other.cardBackgroundColor) ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.cardTitle.hashCode() * 31) + this.cardDescription.hashCode() * 31 + this.title.hashCode() * 31 + this.description.hashCode() * 31 + this.type.hashCode() * 31 + this.cardBackgroundColor.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonIntroduction(cardTitle=";
        String str3 = ", cardDescription=";
        String str4 = ", title=";
        String str5 = ", description=";
        String str6 = ", type=";
        String str7 = ", cardBackgroundColor=";
        str = str2 + this.cardTitle + str3 + this.cardDescription + str4 + this.title + str5 + this.description + str6 + this.type + str7 + this.cardBackgroundColor + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.cardTitle);
        parcel.writeString(this.cardDescription);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.type.name());
        parcel.writeString(this.cardBackgroundColor);
    }
}
