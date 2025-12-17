package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001dB%\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse;", "Landroid/os/Parcelable;", "classic", "", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "special", "Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;", "(Ljava/util/Map;Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;)V", "getClassic", "()Ljava/util/Map;", "getSpecial", "()Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SpecialProgramList", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AllProgramProgressResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.AllProgramProgressResponse> CREATOR;
    private final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress> classic;
    private final app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList special;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.AllProgramProgressResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.AllProgramProgressResponse createFromParcel(Parcel parcel) {
            int i;
            String string;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int);
            i = 0;
            while (i != int) {
                linkedHashMap.put(parcel.readString(), ProgramProgress.CREATOR.createFromParcel(parcel));
                i++;
            }
            AllProgramProgressResponse allProgramProgressResponse = new AllProgramProgressResponse(linkedHashMap, (AllProgramProgressResponse.SpecialProgramList)AllProgramProgressResponse.SpecialProgramList.CREATOR.createFromParcel(parcel));
            return allProgramProgressResponse;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.AllProgramProgressResponse[] newArray(int i) {
            return new AllProgramProgressResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;", "Landroid/os/Parcelable;", "id_potty_program", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "id_nipping_program", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;Lapp/dogo/externalmodel/model/BitingProgressModel;)V", "getId_nipping_program", "()Lapp/dogo/externalmodel/model/BitingProgressModel;", "getId_potty_program", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SpecialProgramList implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList> CREATOR;
        private final BitingProgressModel id_nipping_program;
        private final PottyProgramProgressModel.ProgramStatus id_potty_program;
        static {
            AllProgramProgressResponse.SpecialProgramList.Creator creator = new AllProgramProgressResponse.SpecialProgramList.Creator();
            AllProgramProgressResponse.SpecialProgramList.CREATOR = creator;
        }

        public SpecialProgramList() {
            final int i = 0;
            super(i, i, 3, i);
        }

        public SpecialProgramList(PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus, BitingProgressModel bitingProgressModel2) {
            super();
            this.id_potty_program = programStatus;
            this.id_nipping_program = bitingProgressModel2;
        }

        public SpecialProgramList(PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus, BitingProgressModel bitingProgressModel2, int i3, g g4) {
            int obj2;
            int obj3;
            final int i = 0;
            obj2 = i3 & 1 != 0 ? i : obj2;
            obj3 = i3 &= 2 != 0 ? i : obj3;
            super(obj2, obj3);
        }

        public static app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList copy$default(app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList allProgramProgressResponse$SpecialProgramList, PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus2, BitingProgressModel bitingProgressModel3, int i4, Object object5) {
            PottyProgramProgressModel.ProgramStatus obj1;
            BitingProgressModel obj2;
            if (i4 & 1 != 0) {
                obj1 = specialProgramList.id_potty_program;
            }
            if (i4 &= 2 != 0) {
                obj2 = specialProgramList.id_nipping_program;
            }
            return specialProgramList.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final PottyProgramProgressModel.ProgramStatus component1() {
            return this.id_potty_program;
        }

        @Override // android.os.Parcelable
        public final BitingProgressModel component2() {
            return this.id_nipping_program;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList copy(PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus, BitingProgressModel bitingProgressModel2) {
            AllProgramProgressResponse.SpecialProgramList specialProgramList = new AllProgramProgressResponse.SpecialProgramList(programStatus, bitingProgressModel2);
            return specialProgramList;
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
            if (object instanceof AllProgramProgressResponse.SpecialProgramList == null) {
                return i2;
            }
            if (!n.b(this.id_potty_program, object.id_potty_program)) {
                return i2;
            }
            if (!n.b(this.id_nipping_program, object.id_nipping_program)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final BitingProgressModel getId_nipping_program() {
            return this.id_nipping_program;
        }

        @Override // android.os.Parcelable
        public final PottyProgramProgressModel.ProgramStatus getId_potty_program() {
            return this.id_potty_program;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            int i2;
            PottyProgramProgressModel.ProgramStatus id_potty_program = this.id_potty_program;
            if (id_potty_program == null) {
                i = i2;
            } else {
                i = id_potty_program.hashCode();
            }
            final BitingProgressModel id_nipping_program = this.id_nipping_program;
            if (id_nipping_program == null) {
            } else {
                i2 = id_nipping_program.hashCode();
            }
            return i3 += i2;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialProgramList(id_potty_program=");
            stringBuilder.append(this.id_potty_program);
            stringBuilder.append(", id_nipping_program=");
            stringBuilder.append(this.id_nipping_program);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            PottyProgramProgressModel.ProgramStatus id_potty_program = this.id_potty_program;
            final int i = 0;
            final int i3 = 1;
            if (id_potty_program == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                id_potty_program.writeToParcel(parcel, i2);
            }
            BitingProgressModel id_nipping_program = this.id_nipping_program;
            if (id_nipping_program == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                id_nipping_program.writeToParcel(parcel, i2);
            }
        }
    }
    static {
        AllProgramProgressResponse.Creator creator = new AllProgramProgressResponse.Creator();
        AllProgramProgressResponse.CREATOR = creator;
    }

    public AllProgramProgressResponse() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public AllProgramProgressResponse(Map<String, app.dogo.externalmodel.model.responses.ProgramProgress> map, app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList allProgramProgressResponse$SpecialProgramList2) {
        n.f(map, "classic");
        n.f(specialProgramList2, "special");
        super();
        this.classic = map;
        this.special = specialProgramList2;
    }

    public AllProgramProgressResponse(Map map, app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList allProgramProgressResponse$SpecialProgramList2, int i3, g g4) {
        Map obj1;
        app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList obj2;
        int obj3;
        int obj4;
        if (i3 & 1 != 0) {
            obj1 = j0.h();
        }
        if (i3 &= 2 != 0) {
            obj4 = 0;
            obj2 = new AllProgramProgressResponse.SpecialProgramList(obj4, obj4, 3, obj4);
        }
        super(obj1, obj2);
    }

    public static app.dogo.externalmodel.model.responses.AllProgramProgressResponse copy$default(app.dogo.externalmodel.model.responses.AllProgramProgressResponse allProgramProgressResponse, Map map2, app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList allProgramProgressResponse$SpecialProgramList3, int i4, Object object5) {
        Map obj1;
        app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList obj2;
        if (i4 & 1 != 0) {
            obj1 = allProgramProgressResponse.classic;
        }
        if (i4 &= 2 != 0) {
            obj2 = allProgramProgressResponse.special;
        }
        return allProgramProgressResponse.copy(obj1, obj2);
    }

    public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress> component1() {
        return this.classic;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList component2() {
        return this.special;
    }

    public final app.dogo.externalmodel.model.responses.AllProgramProgressResponse copy(Map<String, app.dogo.externalmodel.model.responses.ProgramProgress> map, app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList allProgramProgressResponse$SpecialProgramList2) {
        n.f(map, "classic");
        n.f(specialProgramList2, "special");
        AllProgramProgressResponse allProgramProgressResponse = new AllProgramProgressResponse(map, specialProgramList2);
        return allProgramProgressResponse;
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
        if (object instanceof AllProgramProgressResponse == null) {
            return i2;
        }
        if (!n.b(this.classic, object.classic)) {
            return i2;
        }
        if (!n.b(this.special, object.special)) {
            return i2;
        }
        return i;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.ProgramProgress> getClassic() {
        return this.classic;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList getSpecial() {
        return this.special;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AllProgramProgressResponse(classic=");
        stringBuilder.append(this.classic);
        stringBuilder.append(", special=");
        stringBuilder.append(this.special);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int value;
        Object key;
        n.f(parcel, "out");
        Map classic = this.classic;
        parcel.writeInt(classic.size());
        Iterator iterator = classic.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            parcel.writeString((String)next2.getKey());
            (ProgramProgress)next2.getValue().writeToParcel(parcel, i2);
        }
        this.special.writeToParcel(parcel, i2);
    }
}
