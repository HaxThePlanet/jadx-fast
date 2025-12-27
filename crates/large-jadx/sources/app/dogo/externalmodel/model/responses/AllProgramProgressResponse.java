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

/* compiled from: AllProgramProgressResponse.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001dB%\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse;", "Landroid/os/Parcelable;", "classic", "", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "special", "Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;", "(Ljava/util/Map;Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;)V", "getClassic", "()Ljava/util/Map;", "getSpecial", "()Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SpecialProgramList", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AllProgramProgressResponse implements Parcelable {

    public static final Parcelable.Creator<AllProgramProgressResponse> CREATOR = new AllProgramProgressResponse$Creator<>();
    private final Map<String, ProgramProgress> classic;
    private final AllProgramProgressResponse.SpecialProgramList special;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AllProgramProgressResponse> {
        @Override // android.os.Parcelable$Creator
        public final AllProgramProgressResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int);
            i = 0;
            while (i != _int) {
                linkedHashMap.put(parcel.readString(), ProgramProgress.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new AllProgramProgressResponse(linkedHashMap, (AllProgramProgressResponse_SpecialProgramList)AllProgramProgressResponse_SpecialProgramList.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final AllProgramProgressResponse[] newArray(int i) {
            return new AllProgramProgressResponse[i];
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse$SpecialProgramList;", "Landroid/os/Parcelable;", "id_potty_program", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "id_nipping_program", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;Lapp/dogo/externalmodel/model/BitingProgressModel;)V", "getId_nipping_program", "()Lapp/dogo/externalmodel/model/BitingProgressModel;", "getId_potty_program", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SpecialProgramList implements Parcelable {

        public static final Parcelable.Creator<AllProgramProgressResponse.SpecialProgramList> CREATOR = new AllProgramProgressResponse$SpecialProgramList$Creator<>();
        private final BitingProgressModel id_nipping_program;
        private final PottyProgramProgressModel.ProgramStatus id_potty_program;
        public SpecialProgramList(PottyProgramProgressModel.ProgramStatus programStatus, BitingProgressModel bitingProgressModel) {
            super();
            this.id_potty_program = programStatus;
            this.id_nipping_program = bitingProgressModel;
        }

        public final BitingProgressModel getId_nipping_program() {
            return this.id_nipping_program;
        }

        public final PottyProgramProgressModel.ProgramStatus getId_potty_program() {
            return this.id_potty_program;
        }

        public /* synthetic */ SpecialProgramList(PottyProgramProgressModel.ProgramStatus programStatus, BitingProgressModel bitingProgressModel, int i, g gVar) {
            PottyProgramProgressModel.ProgramStatus programStatus2;
            i = 0;
            i = i & 1 != 0 ? i : i;
            i = i & 2 != 0 ? i : i;
            this(programStatus2, bitingProgressModel);
        }


        public SpecialProgramList() {
            final PottyProgramProgressModel.ProgramStatus programStatus = null;
            this(programStatus, programStatus, 3, programStatus);
        }

        public static /* synthetic */ AllProgramProgressResponse.SpecialProgramList copy$default(AllProgramProgressResponse.SpecialProgramList list, PottyProgramProgressModel.ProgramStatus programStatus, BitingProgressModel bitingProgressModel, int i, Object object) {
            PottyProgramProgressModel.ProgramStatus id_potty_program2;
            BitingProgressModel id_nipping_program2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return list.copy(id_potty_program2, id_nipping_program2);
        }

        /* operator */ public final PottyProgramProgressModel.ProgramStatus component1() {
            return this.id_potty_program;
        }

        /* operator */ public final BitingProgressModel component2() {
            return this.id_nipping_program;
        }

        public final AllProgramProgressResponse.SpecialProgramList copy(PottyProgramProgressModel.ProgramStatus id_potty_program, BitingProgressModel id_nipping_program) {
            return new AllProgramProgressResponse_SpecialProgramList(id_potty_program, id_nipping_program);
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
            if (!(other instanceof AllProgramProgressResponse_SpecialProgramList)) {
                return false;
            }
            if (!n.b(this.id_potty_program, other.id_potty_program)) {
                return false;
            }
            return !n.b(this.id_nipping_program, other.id_nipping_program) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.id_potty_program == null) {
            } else {
                i = this.id_potty_program.hashCode();
            }
            if (this.id_nipping_program != null) {
                i = this.id_nipping_program.hashCode();
            }
            return (i * 31) + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "SpecialProgramList(id_potty_program=";
            String str3 = ", id_nipping_program=";
            str = str2 + this.id_potty_program + str3 + this.id_nipping_program + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            final int i = 0;
            final int i2 = 1;
            if (this.id_potty_program == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                this.id_potty_program.writeToParcel(parcel, flags);
            }
            if (this.id_nipping_program == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                this.id_nipping_program.writeToParcel(parcel, flags);
            }
        }
    }
    public AllProgramProgressResponse(Map<String, ProgramProgress> map, AllProgramProgressResponse.SpecialProgramList list) {
        n.f(map, "classic");
        n.f(list, "special");
        super();
        this.classic = map;
        this.special = list;
    }

    public final Map<String, ProgramProgress> getClassic() {
        return this.classic;
    }

    public final AllProgramProgressResponse.SpecialProgramList getSpecial() {
        return this.special;
    }

    public /* synthetic */ AllProgramProgressResponse(Map map, AllProgramProgressResponse.SpecialProgramList list, int i, g gVar) {
        Map map2;
        app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList allProgramProgressResponse_SpecialProgramList;
        i2 = i & 1;
        if (i & 1 != 0) {
            map2 = j0.h();
        }
        i = i & 2;
        if (i & 2 != 0) {
            i = 3;
            PottyProgramProgressModel.ProgramStatus programStatus = null;
            allProgramProgressResponse_SpecialProgramList = new AllProgramProgressResponse_SpecialProgramList(programStatus, programStatus, i, programStatus);
        }
        this(map2, allProgramProgressResponse_SpecialProgramList);
    }


    public AllProgramProgressResponse() {
        final Map map = null;
        this(map, map, 3, map);
    }

    public static /* synthetic */ AllProgramProgressResponse copy$default(AllProgramProgressResponse allProgramProgressResponse, Map map, AllProgramProgressResponse.SpecialProgramList list, int i, Object object) {
        Map classic2;
        app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList special2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return allProgramProgressResponse.copy(classic2, special2);
    }

    /* operator */ public final Map<String, ProgramProgress> component1() {
        return this.classic;
    }

    /* operator */ public final AllProgramProgressResponse.SpecialProgramList component2() {
        return this.special;
    }

    public final AllProgramProgressResponse copy(Map<String, ProgramProgress> classic, AllProgramProgressResponse.SpecialProgramList special) {
        n.f(classic, "classic");
        n.f(special, "special");
        return new AllProgramProgressResponse(classic, special);
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
        if (!(other instanceof AllProgramProgressResponse)) {
            return false;
        }
        if (!n.b(this.classic, other.classic)) {
            return false;
        }
        return !n.b(this.special, other.special) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.classic.hashCode() * 31) + this.special.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "AllProgramProgressResponse(classic=";
        String str3 = ", special=";
        str = str2 + this.classic + str3 + this.special + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.classic.size());
        Iterator it = this.classic.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            parcel.writeString((String)item.getKey());
            (ProgramProgress)item.getValue().writeToParcel(parcel, flags);
        }
        this.special.writeToParcel(parcel, flags);
    }
}
