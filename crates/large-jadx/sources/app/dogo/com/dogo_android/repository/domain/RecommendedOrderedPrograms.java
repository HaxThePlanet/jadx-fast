package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001%B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000eR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\r¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "Landroid/os/Parcelable;", "dogId", "", "programCompatibilityMatchList", "", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms$ProgramCompatibilityMatchList;", "recommendedProgramId", "isSurveyAnswered", "", "orderedProgramList", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/util/List;)V", "getDogId", "()Ljava/lang/String;", "()Z", "getOrderedProgramList", "()Ljava/util/List;", "getProgramCompatibilityMatchList", "getRecommendedProgramId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ProgramCompatibilityMatchList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecommendedOrderedPrograms implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms> CREATOR;
    private final String dogId;
    private final boolean isSurveyAnswered;
    private final List<String> orderedProgramList;
    private final List<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList> programCompatibilityMatchList;
    private final String recommendedProgramId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms createFromParcel(Parcel parcel) {
            int int;
            int i;
            Object fromParcel;
            int i2;
            n.f(parcel, "parcel");
            int int2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int2);
            int i3 = 0;
            i = i3;
            while (i != int2) {
                arrayList.add(RecommendedOrderedPrograms.ProgramCompatibilityMatchList.CREATOR.createFromParcel(parcel));
                i++;
            }
            i2 = parcel.readInt() != 0 ? int : i3;
            super(parcel.readString(), arrayList, parcel.readString(), i2, parcel.createStringArrayList());
            return obj8;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms[] newArray(int i) {
            return new RecommendedOrderedPrograms[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms$ProgramCompatibilityMatchList;", "Landroid/os/Parcelable;", "programId", "", "compatibility", "", "(Ljava/lang/String;I)V", "getCompatibility", "()I", "getProgramId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramCompatibilityMatchList implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList> CREATOR;
        private final int compatibility;
        private final String programId;
        static {
            RecommendedOrderedPrograms.ProgramCompatibilityMatchList.Creator creator = new RecommendedOrderedPrograms.ProgramCompatibilityMatchList.Creator();
            RecommendedOrderedPrograms.ProgramCompatibilityMatchList.CREATOR = creator;
        }

        public ProgramCompatibilityMatchList() {
            final int i = 0;
            super(i, 0, 3, i);
        }

        public ProgramCompatibilityMatchList(String string, int i2) {
            n.f(string, "programId");
            super();
            this.programId = string;
            this.compatibility = i2;
        }

        public ProgramCompatibilityMatchList(String string, int i2, int i3, g g4) {
            String obj1;
            int obj2;
            obj1 = i3 & 1 != 0 ? "" : obj1;
            obj2 = i3 &= 2 != 0 ? 0 : obj2;
            super(obj1, obj2);
        }

        public static app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList copy$default(app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList recommendedOrderedPrograms$ProgramCompatibilityMatchList, String string2, int i3, int i4, Object object5) {
            String obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = programCompatibilityMatchList.programId;
            }
            if (i4 &= 2 != 0) {
                obj2 = programCompatibilityMatchList.compatibility;
            }
            return programCompatibilityMatchList.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.programId;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.compatibility;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList copy(String string, int i2) {
            n.f(string, "programId");
            RecommendedOrderedPrograms.ProgramCompatibilityMatchList programCompatibilityMatchList = new RecommendedOrderedPrograms.ProgramCompatibilityMatchList(string, i2);
            return programCompatibilityMatchList;
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
            if (object instanceof RecommendedOrderedPrograms.ProgramCompatibilityMatchList == null) {
                return i2;
            }
            if (!n.b(this.programId, object.programId)) {
                return i2;
            }
            if (this.compatibility != object.compatibility) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getCompatibility() {
            return this.compatibility;
        }

        @Override // android.os.Parcelable
        public final String getProgramId() {
            return this.programId;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramCompatibilityMatchList(programId=");
            stringBuilder.append(this.programId);
            stringBuilder.append(", compatibility=");
            stringBuilder.append(this.compatibility);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.programId);
            parcel.writeInt(this.compatibility);
        }
    }
    static {
        RecommendedOrderedPrograms.Creator creator = new RecommendedOrderedPrograms.Creator();
        RecommendedOrderedPrograms.CREATOR = creator;
    }

    public RecommendedOrderedPrograms(String string, List<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList> list2, String string3, boolean z4, List<String> list5) {
        n.f(string, "dogId");
        n.f(list2, "programCompatibilityMatchList");
        n.f(string3, "recommendedProgramId");
        n.f(list5, "orderedProgramList");
        super();
        this.dogId = string;
        this.programCompatibilityMatchList = list2;
        this.recommendedProgramId = string3;
        this.isSurveyAnswered = z4;
        this.orderedProgramList = list5;
    }

    public RecommendedOrderedPrograms(String string, List list2, String string3, boolean z4, List list5, int i6, g g7) {
        String obj9;
        int obj10;
        ArrayList obj11;
        if (i6 & 4 != 0) {
            obj9 = (RecommendedOrderedPrograms.ProgramCompatibilityMatchList)p.X(list2).getProgramId();
        }
        obj10 = i6 & 8 != 0 ? 1 : obj10;
        if (i6 & 16 != 0) {
            obj11 = new ArrayList(p.r(list2, 10));
            obj9 = list2.iterator();
            for (RecommendedOrderedPrograms.ProgramCompatibilityMatchList obj10 : obj9) {
                obj11.add(obj10.getProgramId());
            }
        }
        super(string, list2, obj9, obj10, obj11);
    }

    public static app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms copy$default(app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms recommendedOrderedPrograms, String string2, List list3, String string4, boolean z5, List list6, int i7, Object object8) {
        String obj4;
        List obj5;
        String obj6;
        boolean obj7;
        List obj8;
        if (i7 & 1 != 0) {
            obj4 = recommendedOrderedPrograms.dogId;
        }
        if (i7 & 2 != 0) {
            obj5 = recommendedOrderedPrograms.programCompatibilityMatchList;
        }
        if (i7 & 4 != 0) {
            obj6 = recommendedOrderedPrograms.recommendedProgramId;
        }
        if (i7 & 8 != 0) {
            obj7 = recommendedOrderedPrograms.isSurveyAnswered;
        }
        if (i7 & 16 != 0) {
            obj8 = recommendedOrderedPrograms.orderedProgramList;
        }
        return recommendedOrderedPrograms.copy(obj4, obj5, obj6, obj7, obj8);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.dogId;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList> component2() {
        return this.programCompatibilityMatchList;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.recommendedProgramId;
    }

    @Override // android.os.Parcelable
    public final boolean component4() {
        return this.isSurveyAnswered;
    }

    public final List<String> component5() {
        return this.orderedProgramList;
    }

    public final app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms copy(String string, List<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList> list2, String string3, boolean z4, List<String> list5) {
        n.f(string, "dogId");
        n.f(list2, "programCompatibilityMatchList");
        n.f(string3, "recommendedProgramId");
        n.f(list5, "orderedProgramList");
        super(string, list2, string3, z4, list5);
        return recommendedOrderedPrograms;
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
        if (!object instanceof RecommendedOrderedPrograms) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.programCompatibilityMatchList, object.programCompatibilityMatchList)) {
            return i2;
        }
        if (!n.b(this.recommendedProgramId, object.recommendedProgramId)) {
            return i2;
        }
        if (this.isSurveyAnswered != object.isSurveyAnswered) {
            return i2;
        }
        if (!n.b(this.orderedProgramList, object.orderedProgramList)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    public final List<String> getOrderedProgramList() {
        return this.orderedProgramList;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList> getProgramCompatibilityMatchList() {
        return this.programCompatibilityMatchList;
    }

    @Override // android.os.Parcelable
    public final String getRecommendedProgramId() {
        return this.recommendedProgramId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isSurveyAnswered;
        if (this.isSurveyAnswered) {
            isSurveyAnswered = 1;
        }
        return i8 += i12;
    }

    @Override // android.os.Parcelable
    public final boolean isSurveyAnswered() {
        return this.isSurveyAnswered;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecommendedOrderedPrograms(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", programCompatibilityMatchList=");
        stringBuilder.append(this.programCompatibilityMatchList);
        stringBuilder.append(", recommendedProgramId=");
        stringBuilder.append(this.recommendedProgramId);
        stringBuilder.append(", isSurveyAnswered=");
        stringBuilder.append(this.isSurveyAnswered);
        stringBuilder.append(", orderedProgramList=");
        stringBuilder.append(this.orderedProgramList);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        List programCompatibilityMatchList = this.programCompatibilityMatchList;
        parcel.writeInt(programCompatibilityMatchList.size());
        Iterator iterator = programCompatibilityMatchList.iterator();
        for (RecommendedOrderedPrograms.ProgramCompatibilityMatchList size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.recommendedProgramId);
        parcel.writeInt(this.isSurveyAnswered);
        parcel.writeStringList(this.orderedProgramList);
    }
}
