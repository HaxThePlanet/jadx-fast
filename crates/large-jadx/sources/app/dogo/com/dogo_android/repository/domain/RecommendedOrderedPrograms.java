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

/* compiled from: RecommendedOrderedPrograms.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001%B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000eR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\r¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "Landroid/os/Parcelable;", "dogId", "", "programCompatibilityMatchList", "", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms$ProgramCompatibilityMatchList;", "recommendedProgramId", "isSurveyAnswered", "", "orderedProgramList", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/util/List;)V", "getDogId", "()Ljava/lang/String;", "()Z", "getOrderedProgramList", "()Ljava/util/List;", "getProgramCompatibilityMatchList", "getRecommendedProgramId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ProgramCompatibilityMatchList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RecommendedOrderedPrograms implements Parcelable {

    public static final Parcelable.Creator<RecommendedOrderedPrograms> CREATOR = new RecommendedOrderedPrograms$Creator<>();
    private final String dogId;
    private final boolean isSurveyAnswered;
    private final List<String> orderedProgramList;
    private final List<RecommendedOrderedPrograms.ProgramCompatibilityMatchList> programCompatibilityMatchList;
    private final String recommendedProgramId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecommendedOrderedPrograms> {
        @Override // android.os.Parcelable$Creator
        public final RecommendedOrderedPrograms createFromParcel(Parcel parcel) {
            int i;
            boolean z;
            n.f(parcel, "parcel");
            int _int2 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int2);
            i = 0;
            while (i != _int2) {
                arrayList.add(RecommendedOrderedPrograms_ProgramCompatibilityMatchList.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            int _int = parcel.readInt() != 0 ? _int : i;
            RecommendedOrderedPrograms parcel2 = new RecommendedOrderedPrograms(parcel.readString(), arrayList, parcel.readString(), z, parcel.createStringArrayList());
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final RecommendedOrderedPrograms[] newArray(int i) {
            return new RecommendedOrderedPrograms[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms$ProgramCompatibilityMatchList;", "Landroid/os/Parcelable;", "programId", "", "compatibility", "", "(Ljava/lang/String;I)V", "getCompatibility", "()I", "getProgramId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramCompatibilityMatchList implements Parcelable {

        public static final Parcelable.Creator<RecommendedOrderedPrograms.ProgramCompatibilityMatchList> CREATOR = new RecommendedOrderedPrograms$ProgramCompatibilityMatchList$Creator<>();
        private final int compatibility;
        private final String programId;
        public ProgramCompatibilityMatchList(String str, int i) {
            n.f(str, "programId");
            super();
            this.programId = str;
            this.compatibility = i;
        }

        public final int getCompatibility() {
            return this.compatibility;
        }

        public final String getProgramId() {
            return this.programId;
        }

        public /* synthetic */ ProgramCompatibilityMatchList(String str, int i, int i2, g gVar) {
            String str2;
            str2 = i2 & 1 != 0 ? "" : str2;
            i = i2 & 2 != 0 ? 0 : i;
            this(str2, i);
        }


        public ProgramCompatibilityMatchList() {
            final String str = null;
            this(str, 0, 3, str);
        }

        public static /* synthetic */ RecommendedOrderedPrograms.ProgramCompatibilityMatchList copy$default(RecommendedOrderedPrograms.ProgramCompatibilityMatchList list, String str, int i, int i2, Object object) {
            String programId2;
            int compatibility2;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            return list.copy(programId2, compatibility2);
        }

        /* operator */ public final String component1() {
            return this.programId;
        }

        /* operator */ public final int component2() {
            return this.compatibility;
        }

        public final RecommendedOrderedPrograms.ProgramCompatibilityMatchList copy(String programId, int compatibility) {
            n.f(programId, "programId");
            return new RecommendedOrderedPrograms_ProgramCompatibilityMatchList(programId, compatibility);
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
            if (!(other instanceof RecommendedOrderedPrograms_ProgramCompatibilityMatchList)) {
                return false;
            }
            if (!n.b(this.programId, other.programId)) {
                return false;
            }
            return this.compatibility != other.compatibility ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.programId.hashCode() * 31) + Integer.hashCode(this.compatibility);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramCompatibilityMatchList(programId=";
            String str3 = ", compatibility=";
            str = str2 + this.programId + str3 + this.compatibility + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.programId);
            parcel.writeInt(this.compatibility);
        }
    }
    public RecommendedOrderedPrograms(String str, List<RecommendedOrderedPrograms.ProgramCompatibilityMatchList> list, String str2, boolean z, List<String> list2) {
        n.f(str, "dogId");
        n.f(list, "programCompatibilityMatchList");
        n.f(str2, "recommendedProgramId");
        n.f(list2, "orderedProgramList");
        super();
        this.dogId = str;
        this.programCompatibilityMatchList = list;
        this.recommendedProgramId = str2;
        this.isSurveyAnswered = z;
        this.orderedProgramList = list2;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final List<String> getOrderedProgramList() {
        return this.orderedProgramList;
    }

    public final List<RecommendedOrderedPrograms.ProgramCompatibilityMatchList> getProgramCompatibilityMatchList() {
        return this.programCompatibilityMatchList;
    }

    public final String getRecommendedProgramId() {
        return this.recommendedProgramId;
    }

    public final boolean isSurveyAnswered() {
        return this.isSurveyAnswered;
    }

    public /* synthetic */ RecommendedOrderedPrograms(String str, List list, String str2, boolean z, List list2, int i, g gVar) {
        String str32;
        int i2 = 1;
        ArrayList list52;
        if (i & 4 != 0) {
            str32 = (RecommendedOrderedPrograms_ProgramCompatibilityMatchList)p.X(list).getProgramId();
        }
        i2 = i & 8 != 0 ? 1 : i2;
        i = i & 16;
        if (i & 16 != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                new ArrayList(p.r(list, 10)).add((RecommendedOrderedPrograms_ProgramCompatibilityMatchList)it.next().getProgramId());
            }
        }
        this(str, list, str32, i2, list52);
    }


    public static /* synthetic */ RecommendedOrderedPrograms copy$default(RecommendedOrderedPrograms recommendedOrderedPrograms, String str, List list, String str2, boolean z, List list2, int i, Object object) {
        String str22;
        List object82;
        String str42;
        boolean z52;
        List list62;
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
        return recommendedOrderedPrograms.copy(str22, object82, str42, z52, list62);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final List<RecommendedOrderedPrograms.ProgramCompatibilityMatchList> component2() {
        return this.programCompatibilityMatchList;
    }

    /* operator */ public final String component3() {
        return this.recommendedProgramId;
    }

    /* operator */ public final boolean component4() {
        return this.isSurveyAnswered;
    }

    /* operator */ public final List<String> component5() {
        return this.orderedProgramList;
    }

    public final RecommendedOrderedPrograms copy(String dogId, List<RecommendedOrderedPrograms.ProgramCompatibilityMatchList> programCompatibilityMatchList, String recommendedProgramId, boolean isSurveyAnswered, List<String> orderedProgramList) {
        n.f(dogId, "dogId");
        n.f(programCompatibilityMatchList, "programCompatibilityMatchList");
        n.f(recommendedProgramId, "recommendedProgramId");
        n.f(orderedProgramList, "orderedProgramList");
        RecommendedOrderedPrograms recommendedOrderedPrograms = new RecommendedOrderedPrograms(dogId, programCompatibilityMatchList, recommendedProgramId, isSurveyAnswered, orderedProgramList);
        return recommendedOrderedPrograms;
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
        if (!(other instanceof RecommendedOrderedPrograms)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.programCompatibilityMatchList, other.programCompatibilityMatchList)) {
            return false;
        }
        if (!n.b(this.recommendedProgramId, other.recommendedProgramId)) {
            return false;
        }
        if (this.isSurveyAnswered != other.isSurveyAnswered) {
            return false;
        }
        return !n.b(this.orderedProgramList, other.orderedProgramList) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isSurveyAnswered2 = true;
        if (this.isSurveyAnswered) {
            int i13 = 1;
        }
        return (this.dogId.hashCode() * 31) + this.programCompatibilityMatchList.hashCode() * 31 + this.recommendedProgramId.hashCode() * 31 + isSurveyAnswered2 * 31 + this.orderedProgramList.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RecommendedOrderedPrograms(dogId=";
        String str3 = ", programCompatibilityMatchList=";
        String str4 = ", recommendedProgramId=";
        String str5 = ", isSurveyAnswered=";
        String str6 = ", orderedProgramList=";
        str = str2 + this.dogId + str3 + this.programCompatibilityMatchList + str4 + this.recommendedProgramId + str5 + this.isSurveyAnswered + str6 + this.orderedProgramList + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeInt(this.programCompatibilityMatchList.size());
        Iterator it = this.programCompatibilityMatchList.iterator();
        while (it.hasNext()) {
            (RecommendedOrderedPrograms_ProgramCompatibilityMatchList)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.recommendedProgramId);
        parcel.writeInt(this.isSurveyAnswered);
        parcel.writeStringList(this.orderedProgramList);
    }
}
