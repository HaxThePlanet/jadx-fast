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

/* compiled from: RecommendedProgramData.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\u000c\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecommendedProgramData;", "Landroid/os/Parcelable;", "recommendedPrograms", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "otherPrograms", "(Ljava/util/List;Ljava/util/List;)V", "getOtherPrograms", "()Ljava/util/List;", "getRecommendedPrograms", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RecommendedProgramData implements Parcelable {

    public static final Parcelable.Creator<RecommendedProgramData> CREATOR = new RecommendedProgramData$Creator<>();
    private final List<ProgramDescriptionItem> otherPrograms;
    private final List<ProgramDescriptionItem> recommendedPrograms;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecommendedProgramData> {
        @Override // android.os.Parcelable$Creator
        public final RecommendedProgramData createFromParcel(Parcel parcel) {
            int i = 0;
            Object fromParcel;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(ProgramDescriptionItem.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            int _int2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(_int2);
            while (i != _int2) {
                arrayList2.add(ProgramDescriptionItem.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new RecommendedProgramData(arrayList, arrayList2);
        }

        @Override // android.os.Parcelable$Creator
        public final RecommendedProgramData[] newArray(int i) {
            return new RecommendedProgramData[i];
        }
    }
    public RecommendedProgramData(List<ProgramDescriptionItem> list, List<ProgramDescriptionItem> list2) {
        n.f(list, "recommendedPrograms");
        n.f(list2, "otherPrograms");
        super();
        this.recommendedPrograms = list;
        this.otherPrograms = list2;
    }

    public final List<ProgramDescriptionItem> getOtherPrograms() {
        return this.otherPrograms;
    }

    public final List<ProgramDescriptionItem> getRecommendedPrograms() {
        return this.recommendedPrograms;
    }

    public /* synthetic */ RecommendedProgramData(List list, List list2, int i, g gVar) {
        List list3;
        List list4;
        if (i & 1 != 0) {
            list3 = p.g();
        }
        if (i & 2 != 0) {
            list4 = p.g();
        }
        this(list3, list4);
    }


    public RecommendedProgramData() {
        final List list = null;
        this(list, list, 3, list);
    }

    public static /* synthetic */ RecommendedProgramData copy$default(RecommendedProgramData recommendedProgramData, List list, List list2, int i, Object object) {
        List recommendedPrograms2;
        List otherPrograms2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return recommendedProgramData.copy(recommendedPrograms2, otherPrograms2);
    }

    /* operator */ public final List<ProgramDescriptionItem> component1() {
        return this.recommendedPrograms;
    }

    /* operator */ public final List<ProgramDescriptionItem> component2() {
        return this.otherPrograms;
    }

    public final RecommendedProgramData copy(List<ProgramDescriptionItem> recommendedPrograms, List<ProgramDescriptionItem> otherPrograms) {
        n.f(recommendedPrograms, "recommendedPrograms");
        n.f(otherPrograms, "otherPrograms");
        return new RecommendedProgramData(recommendedPrograms, otherPrograms);
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
        if (!(other instanceof RecommendedProgramData)) {
            return false;
        }
        if (!n.b(this.recommendedPrograms, other.recommendedPrograms)) {
            return false;
        }
        return !n.b(this.otherPrograms, other.otherPrograms) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.recommendedPrograms.hashCode() * 31) + this.otherPrograms.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RecommendedProgramData(recommendedPrograms=";
        String str3 = ", otherPrograms=";
        str = str2 + this.recommendedPrograms + str3 + this.otherPrograms + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.recommendedPrograms.size());
        Iterator it = this.recommendedPrograms.iterator();
        while (it.hasNext()) {
            (ProgramDescriptionItem)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.otherPrograms.size());
        Iterator it2 = this.otherPrograms.iterator();
        while (it2.hasNext()) {
            (ProgramDescriptionItem)it2.next().writeToParcel(parcel, flags);
        }
    }
}
