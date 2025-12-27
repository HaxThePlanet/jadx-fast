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

/* compiled from: SurveyAnswers.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\u0008\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0003J\t\u0010\u0012\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000cHÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "Landroid/os/Parcelable;", "answers", "", "Lkotlin/Pair;", "", "(Ljava/util/List;)V", "getAnswers", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getUserPropertyTrackingData", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SurveyAnswers implements Parcelable {

    public static final Parcelable.Creator<SurveyAnswers> CREATOR = new SurveyAnswers$Creator<>();
    private final List<o<String, String>> answers;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyAnswers> {
        @Override // android.os.Parcelable$Creator
        public final SurveyAnswers createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(parcel.readSerializable());
                i = i + 1;
            }
            return new SurveyAnswers(arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final SurveyAnswers[] newArray(int i) {
            return new SurveyAnswers[i];
        }
    }
    public SurveyAnswers(List<o<String, String>> list) {
        n.f(list, "answers");
        super();
        this.answers = list;
    }

    public final List<o<String, String>> getAnswers() {
        return this.answers;
    }

    public final List<String> getUserPropertyTrackingData() {
        final ArrayList arrayList = new ArrayList(p.r(this.answers, 10));
        Iterator it = this.answers.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            StringBuilder stringBuilder = new StringBuilder();
            Object obj2 = item.c();
            str = ": ";
            Object obj = item.d();
            str2 = obj2 + str + obj;
            arrayList.add(str2);
        }
        return arrayList;
    }


    public static /* synthetic */ SurveyAnswers copy$default(SurveyAnswers surveyAnswers, List list, int i, Object object) {
        List answers2;
        if (i & 1 != 0) {
        }
        return surveyAnswers.copy(answers2);
    }

    /* operator */ public final List<o<String, String>> component1() {
        return this.answers;
    }

    public final SurveyAnswers copy(List<o<String, String>> answers) {
        n.f(answers, "answers");
        return new SurveyAnswers(answers);
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
        final boolean z3 = false;
        if (!(other instanceof SurveyAnswers)) {
            return false;
        }
        return !n.b(this.answers, other.answers) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.answers.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SurveyAnswers(answers=";
        str = str2 + this.answers + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.answers.size());
        Iterator it = this.answers.iterator();
        while (it.hasNext()) {
            parcel.writeSerializable((Serializable)it.next());
        }
    }
}
