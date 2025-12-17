package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\u0008\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0003J\t\u0010\u0012\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000cHÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "Landroid/os/Parcelable;", "answers", "", "Lkotlin/Pair;", "", "(Ljava/util/List;)V", "getAnswers", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getUserPropertyTrackingData", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SurveyAnswers implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SurveyAnswers> CREATOR;
    private final List<o<String, String>> answers;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SurveyAnswers> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SurveyAnswers createFromParcel(Parcel parcel) {
            int i;
            java.io.Serializable serializable;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(parcel.readSerializable());
                i++;
            }
            SurveyAnswers obj5 = new SurveyAnswers(arrayList);
            return obj5;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SurveyAnswers[] newArray(int i) {
            return new SurveyAnswers[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        SurveyAnswers.Creator creator = new SurveyAnswers.Creator();
        SurveyAnswers.CREATOR = creator;
    }

    public SurveyAnswers(List<o<String, String>> list) {
        n.f(list, "answers");
        super();
        this.answers = list;
    }

    public static app.dogo.com.dogo_android.repository.domain.SurveyAnswers copy$default(app.dogo.com.dogo_android.repository.domain.SurveyAnswers surveyAnswers, List list2, int i3, Object object4) {
        List obj1;
        if (i3 &= 1 != 0) {
            obj1 = surveyAnswers.answers;
        }
        return surveyAnswers.copy(obj1);
    }

    public final List<o<String, String>> component1() {
        return this.answers;
    }

    public final app.dogo.com.dogo_android.repository.domain.SurveyAnswers copy(List<o<String, String>> list) {
        n.f(list, "answers");
        SurveyAnswers surveyAnswers = new SurveyAnswers(list);
        return surveyAnswers;
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
        if (!object instanceof SurveyAnswers) {
            return i2;
        }
        if (!n.b(this.answers, object.answers)) {
            return i2;
        }
        return i;
    }

    public final List<o<String, String>> getAnswers() {
        return this.answers;
    }

    public final List<String> getUserPropertyTrackingData() {
        int string;
        StringBuilder stringBuilder;
        String str;
        List answers = this.answers;
        ArrayList arrayList = new ArrayList(p.r(answers, 10));
        Iterator iterator = answers.iterator();
        for (o next2 : iterator) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)next2.c());
            stringBuilder.append(": ");
            stringBuilder.append((String)next2.d());
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.answers.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurveyAnswers(answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List obj3 = this.answers;
        parcel.writeInt(obj3.size());
        obj3 = obj3.iterator();
        for (Serializable size : obj3) {
            parcel.writeSerializable(size);
        }
    }
}
