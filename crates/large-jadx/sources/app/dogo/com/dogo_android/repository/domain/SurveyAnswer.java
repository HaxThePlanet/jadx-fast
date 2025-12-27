package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SurveyAnswer.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswer;", "Landroid/os/Parcelable;", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SurveyAnswer implements Parcelable {

    public static final Parcelable.Creator<SurveyAnswer> CREATOR = new SurveyAnswer$Creator<>();
    private final String id;
    private final String name;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyAnswer> {
        @Override // android.os.Parcelable$Creator
        public final SurveyAnswer createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new SurveyAnswer(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final SurveyAnswer[] newArray(int i) {
            return new SurveyAnswer[i];
        }
    }
    public SurveyAnswer(String str, String str2) {
        n.f(str, "id");
        n.f(str2, "name");
        super();
        this.id = str;
        this.name = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }


    public static /* synthetic */ SurveyAnswer copy$default(SurveyAnswer surveyAnswer, String str, String str2, int i, Object object) {
        String id2;
        String name2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return surveyAnswer.copy(id2, name2);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    public final SurveyAnswer copy(String id, String name) {
        n.f(id, "id");
        n.f(name, "name");
        return new SurveyAnswer(id, name);
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
        if (!(other instanceof SurveyAnswer)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        return !n.b(this.name, other.name) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SurveyAnswer(id=";
        String str3 = ", name=";
        str = str2 + this.id + str3 + this.name + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
    }
}
