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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001fB/\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel;", "Landroid/os/Parcelable;", "programs", "", "", "surveyTaken", "", "programs_v2", "Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel$ProgramCompatibility;", "(Ljava/util/List;ZLjava/util/List;)V", "getPrograms", "()Ljava/util/List;", "getPrograms_v2", "getSurveyTaken", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ProgramCompatibility", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SurveyAnswerResponseModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.SurveyAnswerResponseModel> CREATOR;
    private final List<String> programs;
    private final List<app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility> programs_v2;
    private final boolean surveyTaken;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.SurveyAnswerResponseModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.SurveyAnswerResponseModel createFromParcel(Parcel parcel) {
            int i;
            int i2;
            Object fromParcel;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : i2;
            final int int2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int2);
            while (i2 != int2) {
                arrayList.add(SurveyAnswerResponseModel.ProgramCompatibility.CREATOR.createFromParcel(parcel));
                i2++;
            }
            SurveyAnswerResponseModel obj7 = new SurveyAnswerResponseModel(parcel.createStringArrayList(), i, arrayList);
            return obj7;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.SurveyAnswerResponseModel[] newArray(int i) {
            return new SurveyAnswerResponseModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0008J$\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel$ProgramCompatibility;", "Landroid/os/Parcelable;", "programId", "", "compatibility", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCompatibility", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProgramId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel$ProgramCompatibility;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramCompatibility implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility> CREATOR;
        private final Integer compatibility;
        private final String programId;
        static {
            SurveyAnswerResponseModel.ProgramCompatibility.Creator creator = new SurveyAnswerResponseModel.ProgramCompatibility.Creator();
            SurveyAnswerResponseModel.ProgramCompatibility.CREATOR = creator;
        }

        public ProgramCompatibility(String string, Integer integer2) {
            n.f(string, "programId");
            super();
            this.programId = string;
            this.compatibility = integer2;
        }

        public static app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility copy$default(app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility surveyAnswerResponseModel$ProgramCompatibility, String string2, Integer integer3, int i4, Object object5) {
            String obj1;
            Integer obj2;
            if (i4 & 1 != 0) {
                obj1 = programCompatibility.programId;
            }
            if (i4 &= 2 != 0) {
                obj2 = programCompatibility.compatibility;
            }
            return programCompatibility.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.programId;
        }

        @Override // android.os.Parcelable
        public final Integer component2() {
            return this.compatibility;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility copy(String string, Integer integer2) {
            n.f(string, "programId");
            SurveyAnswerResponseModel.ProgramCompatibility programCompatibility = new SurveyAnswerResponseModel.ProgramCompatibility(string, integer2);
            return programCompatibility;
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
            if (!object instanceof SurveyAnswerResponseModel.ProgramCompatibility) {
                return i2;
            }
            if (!n.b(this.programId, object.programId)) {
                return i2;
            }
            if (!n.b(this.compatibility, object.compatibility)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final Integer getCompatibility() {
            return this.compatibility;
        }

        @Override // android.os.Parcelable
        public final String getProgramId() {
            return this.programId;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            Integer compatibility = this.compatibility;
            if (compatibility == null) {
                i = 0;
            } else {
                i = compatibility.hashCode();
            }
            return i3 += i;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramCompatibility(programId=");
            stringBuilder.append(this.programId);
            stringBuilder.append(", compatibility=");
            stringBuilder.append(this.compatibility);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int i;
            int obj3;
            n.f(parcel, "out");
            parcel.writeString(this.programId);
            obj3 = this.compatibility;
            if (obj3 == null) {
                obj3 = 0;
            } else {
                parcel.writeInt(1);
                obj3 = obj3.intValue();
            }
            parcel.writeInt(obj3);
        }
    }
    static {
        SurveyAnswerResponseModel.Creator creator = new SurveyAnswerResponseModel.Creator();
        SurveyAnswerResponseModel.CREATOR = creator;
    }

    public SurveyAnswerResponseModel() {
        super(0, 0, 0, 7, 0);
    }

    public SurveyAnswerResponseModel(List<String> list, boolean z2, List<app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility> list3) {
        n.f(list, "programs");
        n.f(list3, "programs_v2");
        super();
        this.programs = list;
        this.surveyTaken = z2;
        this.programs_v2 = list3;
    }

    public SurveyAnswerResponseModel(List list, boolean z2, List list3, int i4, g g5) {
        List obj1;
        int obj2;
        List obj3;
        if (i4 & 1 != 0) {
            obj1 = p.g();
        }
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        if (i4 &= 4 != 0) {
            obj3 = p.g();
        }
        super(obj1, obj2, obj3);
    }

    public static app.dogo.externalmodel.model.SurveyAnswerResponseModel copy$default(app.dogo.externalmodel.model.SurveyAnswerResponseModel surveyAnswerResponseModel, List list2, boolean z3, List list4, int i5, Object object6) {
        List obj1;
        boolean obj2;
        List obj3;
        if (i5 & 1 != 0) {
            obj1 = surveyAnswerResponseModel.programs;
        }
        if (i5 & 2 != 0) {
            obj2 = surveyAnswerResponseModel.surveyTaken;
        }
        if (i5 &= 4 != 0) {
            obj3 = surveyAnswerResponseModel.programs_v2;
        }
        return surveyAnswerResponseModel.copy(obj1, obj2, obj3);
    }

    public final List<String> component1() {
        return this.programs;
    }

    @Override // android.os.Parcelable
    public final boolean component2() {
        return this.surveyTaken;
    }

    public final List<app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility> component3() {
        return this.programs_v2;
    }

    public final app.dogo.externalmodel.model.SurveyAnswerResponseModel copy(List<String> list, boolean z2, List<app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility> list3) {
        n.f(list, "programs");
        n.f(list3, "programs_v2");
        SurveyAnswerResponseModel surveyAnswerResponseModel = new SurveyAnswerResponseModel(list, z2, list3);
        return surveyAnswerResponseModel;
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
        if (!object instanceof SurveyAnswerResponseModel) {
            return i2;
        }
        if (!n.b(this.programs, object.programs)) {
            return i2;
        }
        if (this.surveyTaken != object.surveyTaken) {
            return i2;
        }
        if (!n.b(this.programs_v2, object.programs_v2)) {
            return i2;
        }
        return i;
    }

    public final List<String> getPrograms() {
        return this.programs;
    }

    public final List<app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility> getPrograms_v2() {
        return this.programs_v2;
    }

    @Override // android.os.Parcelable
    public final boolean getSurveyTaken() {
        return this.surveyTaken;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean surveyTaken;
        if (this.surveyTaken) {
            surveyTaken = 1;
        }
        return i4 += i6;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurveyAnswerResponseModel(programs=");
        stringBuilder.append(this.programs);
        stringBuilder.append(", surveyTaken=");
        stringBuilder.append(this.surveyTaken);
        stringBuilder.append(", programs_v2=");
        stringBuilder.append(this.programs_v2);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeStringList(this.programs);
        parcel.writeInt(this.surveyTaken);
        List programs_v2 = this.programs_v2;
        parcel.writeInt(programs_v2.size());
        Iterator iterator = programs_v2.iterator();
        for (SurveyAnswerResponseModel.ProgramCompatibility size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
