package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\u000c\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecommendedProgramData;", "Landroid/os/Parcelable;", "recommendedPrograms", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "otherPrograms", "(Ljava/util/List;Ljava/util/List;)V", "getOtherPrograms", "()Ljava/util/List;", "getRecommendedPrograms", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecommendedProgramData implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.RecommendedProgramData> CREATOR;
    private final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> otherPrograms;
    private final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> recommendedPrograms;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.RecommendedProgramData> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.RecommendedProgramData createFromParcel(Parcel parcel) {
            int i;
            int i2;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i2 = i;
            while (i2 != int) {
                arrayList.add(ProgramDescriptionItem.CREATOR.createFromParcel(parcel));
                i2++;
            }
            int int2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(int2);
            while (i != int2) {
                arrayList2.add(ProgramDescriptionItem.CREATOR.createFromParcel(parcel));
                i++;
            }
            RecommendedProgramData obj6 = new RecommendedProgramData(arrayList, arrayList2);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.RecommendedProgramData[] newArray(int i) {
            return new RecommendedProgramData[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        RecommendedProgramData.Creator creator = new RecommendedProgramData.Creator();
        RecommendedProgramData.CREATOR = creator;
    }

    public RecommendedProgramData() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public RecommendedProgramData(List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> list, List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> list2) {
        n.f(list, "recommendedPrograms");
        n.f(list2, "otherPrograms");
        super();
        this.recommendedPrograms = list;
        this.otherPrograms = list2;
    }

    public RecommendedProgramData(List list, List list2, int i3, g g4) {
        List obj1;
        List obj2;
        if (i3 & 1 != 0) {
            obj1 = p.g();
        }
        if (i3 &= 2 != 0) {
            obj2 = p.g();
        }
        super(obj1, obj2);
    }

    public static app.dogo.com.dogo_android.repository.domain.RecommendedProgramData copy$default(app.dogo.com.dogo_android.repository.domain.RecommendedProgramData recommendedProgramData, List list2, List list3, int i4, Object object5) {
        List obj1;
        List obj2;
        if (i4 & 1 != 0) {
            obj1 = recommendedProgramData.recommendedPrograms;
        }
        if (i4 &= 2 != 0) {
            obj2 = recommendedProgramData.otherPrograms;
        }
        return recommendedProgramData.copy(obj1, obj2);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> component1() {
        return this.recommendedPrograms;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> component2() {
        return this.otherPrograms;
    }

    public final app.dogo.com.dogo_android.repository.domain.RecommendedProgramData copy(List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> list, List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> list2) {
        n.f(list, "recommendedPrograms");
        n.f(list2, "otherPrograms");
        RecommendedProgramData recommendedProgramData = new RecommendedProgramData(list, list2);
        return recommendedProgramData;
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
        if (object instanceof RecommendedProgramData == null) {
            return i2;
        }
        if (!n.b(this.recommendedPrograms, object.recommendedPrograms)) {
            return i2;
        }
        if (!n.b(this.otherPrograms, object.otherPrograms)) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> getOtherPrograms() {
        return this.otherPrograms;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> getRecommendedPrograms() {
        return this.recommendedPrograms;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecommendedProgramData(recommendedPrograms=");
        stringBuilder.append(this.recommendedPrograms);
        stringBuilder.append(", otherPrograms=");
        stringBuilder.append(this.otherPrograms);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        int size2;
        n.f(parcel, "out");
        List recommendedPrograms = this.recommendedPrograms;
        parcel.writeInt(recommendedPrograms.size());
        Iterator iterator = recommendedPrograms.iterator();
        for (ProgramDescriptionItem size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        List otherPrograms = this.otherPrograms;
        parcel.writeInt(otherPrograms.size());
        Iterator iterator2 = otherPrograms.iterator();
        for (ProgramDescriptionItem size2 : iterator2) {
            size2.writeToParcel(parcel, i2);
        }
    }
}
