package app.dogo.externalmodel.model;

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

/* compiled from: SurveyAnswerResponseModel.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001fB/\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel;", "Landroid/os/Parcelable;", "programs", "", "", "surveyTaken", "", "programs_v2", "Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel$ProgramCompatibility;", "(Ljava/util/List;ZLjava/util/List;)V", "getPrograms", "()Ljava/util/List;", "getPrograms_v2", "getSurveyTaken", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ProgramCompatibility", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SurveyAnswerResponseModel implements Parcelable {

    public static final Parcelable.Creator<SurveyAnswerResponseModel> CREATOR = new SurveyAnswerResponseModel$Creator<>();
    private final List<String> programs;
    private final List<SurveyAnswerResponseModel.ProgramCompatibility> programs_v2;
    private final boolean surveyTaken;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SurveyAnswerResponseModel> {
        @Override // android.os.Parcelable$Creator
        public final SurveyAnswerResponseModel createFromParcel(Parcel parcel) {
            boolean z = true;
            int i = 0;
            n.f(parcel, "parcel");
            i = 0;
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            final int _int2 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int2);
            while (i != _int2) {
                arrayList.add(SurveyAnswerResponseModel_ProgramCompatibility.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new SurveyAnswerResponseModel(parcel.createStringArrayList(), z, arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final SurveyAnswerResponseModel[] newArray(int i) {
            return new SurveyAnswerResponseModel[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0008J$\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel$ProgramCompatibility;", "Landroid/os/Parcelable;", "programId", "", "compatibility", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCompatibility", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProgramId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel$ProgramCompatibility;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramCompatibility implements Parcelable {

        public static final Parcelable.Creator<SurveyAnswerResponseModel.ProgramCompatibility> CREATOR = new SurveyAnswerResponseModel$ProgramCompatibility$Creator<>();
        private final Integer compatibility;
        private final String programId;
        public ProgramCompatibility(String str, Integer integer) {
            n.f(str, "programId");
            super();
            this.programId = str;
            this.compatibility = integer;
        }

        public final Integer getCompatibility() {
            return this.compatibility;
        }

        public final String getProgramId() {
            return this.programId;
        }


        public static /* synthetic */ SurveyAnswerResponseModel.ProgramCompatibility copy$default(SurveyAnswerResponseModel.ProgramCompatibility programCompatibility, String str, Integer integer, int i, Object object) {
            String programId2;
            Integer compatibility2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return programCompatibility.copy(programId2, compatibility2);
        }

        /* operator */ public final String component1() {
            return this.programId;
        }

        /* operator */ public final Integer component2() {
            return this.compatibility;
        }

        public final SurveyAnswerResponseModel.ProgramCompatibility copy(String programId, Integer compatibility) {
            n.f(programId, "programId");
            return new SurveyAnswerResponseModel_ProgramCompatibility(programId, compatibility);
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
            if (!(other instanceof SurveyAnswerResponseModel_ProgramCompatibility)) {
                return false;
            }
            if (!n.b(this.programId, other.programId)) {
                return false;
            }
            return !n.b(this.compatibility, other.compatibility) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 0;
            if (this.compatibility == null) {
                i = 0;
            } else {
                i = this.compatibility.hashCode();
            }
            return (this.programId.hashCode() * 31) + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramCompatibility(programId=";
            String str3 = ", compatibility=";
            str = str2 + this.programId + str3 + this.compatibility + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            int value = 0;
            n.f(parcel, "out");
            parcel.writeString(this.programId);
            if (this.compatibility == null) {
                value = 0;
            } else {
                int i = 1;
                parcel.writeInt(i);
                value = this.compatibility.intValue();
            }
            parcel.writeInt(value);
        }
    }
    public SurveyAnswerResponseModel(List<String> list, boolean z, List<SurveyAnswerResponseModel.ProgramCompatibility> list2) {
        n.f(list, "programs");
        n.f(list2, "programs_v2");
        super();
        this.programs = list;
        this.surveyTaken = z;
        this.programs_v2 = list2;
    }

    public final List<String> getPrograms() {
        return this.programs;
    }

    public final List<SurveyAnswerResponseModel.ProgramCompatibility> getPrograms_v2() {
        return this.programs_v2;
    }

    public final boolean getSurveyTaken() {
        return this.surveyTaken;
    }

    public /* synthetic */ SurveyAnswerResponseModel(List list, boolean z, List list2, int i, g gVar) {
        List list4;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        i = i & 2 != 0 ? 0 : i;
        if (i & 4 != 0) {
            list4 = p.g();
        }
        this(list2, z, list4);
    }


    public SurveyAnswerResponseModel() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ SurveyAnswerResponseModel copy$default(SurveyAnswerResponseModel surveyAnswerResponseModel, List list, boolean z, List list2, int i, Object object) {
        List programs2;
        boolean surveyTaken2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return surveyAnswerResponseModel.copy(programs2, surveyTaken2, list);
    }

    /* operator */ public final List<String> component1() {
        return this.programs;
    }

    /* operator */ public final boolean component2() {
        return this.surveyTaken;
    }

    /* operator */ public final List<SurveyAnswerResponseModel.ProgramCompatibility> component3() {
        return this.programs_v2;
    }

    public final SurveyAnswerResponseModel copy(List<String> programs, boolean surveyTaken, List<SurveyAnswerResponseModel.ProgramCompatibility> programs_v2) {
        n.f(programs, "programs");
        n.f(programs_v2, "programs_v2");
        return new SurveyAnswerResponseModel(programs, surveyTaken, programs_v2);
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
        if (!(other instanceof SurveyAnswerResponseModel)) {
            return false;
        }
        if (!n.b(this.programs, other.programs)) {
            return false;
        }
        if (this.surveyTaken != other.surveyTaken) {
            return false;
        }
        return !n.b(this.programs_v2, other.programs_v2) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean surveyTaken2 = true;
        if (this.surveyTaken) {
            int i7 = 1;
        }
        return (this.programs.hashCode() * 31) + surveyTaken2 * 31 + this.programs_v2.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SurveyAnswerResponseModel(programs=";
        String str3 = ", surveyTaken=";
        String str4 = ", programs_v2=";
        str = str2 + this.programs + str3 + this.surveyTaken + str4 + this.programs_v2 + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeStringList(this.programs);
        parcel.writeInt(this.surveyTaken);
        parcel.writeInt(this.programs_v2.size());
        Iterator it = this.programs_v2.iterator();
        while (it.hasNext()) {
            (SurveyAnswerResponseModel_ProgramCompatibility)it.next().writeToParcel(parcel, flags);
        }
    }
}
