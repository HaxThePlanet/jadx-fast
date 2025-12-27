package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.DogLogModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: DogLogResponse.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/responses/DogLogResponse;", "Landroid/os/Parcelable;", "logs", "", "Lapp/dogo/externalmodel/model/DogLogModel;", "(Ljava/util/List;)V", "getLogs", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogLogResponse implements Parcelable {

    public static final Parcelable.Creator<DogLogResponse> CREATOR = new DogLogResponse$Creator<>();
    private final List<DogLogModel> logs;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogLogResponse> {
        @Override // android.os.Parcelable$Creator
        public final DogLogResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(DogLogModel.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new DogLogResponse(arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final DogLogResponse[] newArray(int i) {
            return new DogLogResponse[i];
        }
    }
    public DogLogResponse(List<DogLogModel> list) {
        n.f(list, "logs");
        super();
        this.logs = list;
    }

    public final List<DogLogModel> getLogs() {
        return this.logs;
    }

    public /* synthetic */ DogLogResponse(List list, int i, g gVar) {
        List list2;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        this(list2);
    }


    public DogLogResponse() {
        final List list = null;
        this(list, 1, list);
    }

    public static /* synthetic */ DogLogResponse copy$default(DogLogResponse dogLogResponse, List list, int i, Object object) {
        List logs2;
        if (i & 1 != 0) {
        }
        return dogLogResponse.copy(logs2);
    }

    /* operator */ public final List<DogLogModel> component1() {
        return this.logs;
    }

    public final DogLogResponse copy(List<DogLogModel> logs) {
        n.f(logs, "logs");
        return new DogLogResponse(logs);
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
        if (!(other instanceof DogLogResponse)) {
            return false;
        }
        return !n.b(this.logs, other.logs) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.logs.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogLogResponse(logs=";
        str = str2 + this.logs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.logs.size());
        Iterator it = this.logs.iterator();
        while (it.hasNext()) {
            (DogLogModel)it.next().writeToParcel(parcel, flags);
        }
    }
}
