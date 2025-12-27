package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.TrickKnowledgeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: GetTrickKnowledgeResponse.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/responses/GetTrickKnowledgeResponse;", "Landroid/os/Parcelable;", "tricks", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "(Ljava/util/List;)V", "getTricks", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GetTrickKnowledgeResponse implements Parcelable {

    public static final Parcelable.Creator<GetTrickKnowledgeResponse> CREATOR = new GetTrickKnowledgeResponse$Creator<>();
    private final List<TrickKnowledgeEvent> tricks;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GetTrickKnowledgeResponse> {
        @Override // android.os.Parcelable$Creator
        public final GetTrickKnowledgeResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(TrickKnowledgeEvent.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new GetTrickKnowledgeResponse(arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final GetTrickKnowledgeResponse[] newArray(int i) {
            return new GetTrickKnowledgeResponse[i];
        }
    }
    public GetTrickKnowledgeResponse(List<TrickKnowledgeEvent> list) {
        n.f(list, "tricks");
        super();
        this.tricks = list;
    }

    public final List<TrickKnowledgeEvent> getTricks() {
        return this.tricks;
    }


    public static /* synthetic */ GetTrickKnowledgeResponse copy$default(GetTrickKnowledgeResponse getTrickKnowledgeResponse, List list, int i, Object object) {
        List tricks2;
        if (i & 1 != 0) {
        }
        return getTrickKnowledgeResponse.copy(tricks2);
    }

    /* operator */ public final List<TrickKnowledgeEvent> component1() {
        return this.tricks;
    }

    public final GetTrickKnowledgeResponse copy(List<TrickKnowledgeEvent> tricks) {
        n.f(tricks, "tricks");
        return new GetTrickKnowledgeResponse(tricks);
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
        if (!(other instanceof GetTrickKnowledgeResponse)) {
            return false;
        }
        return !n.b(this.tricks, other.tricks) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.tricks.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "GetTrickKnowledgeResponse(tricks=";
        str = str2 + this.tricks + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.tricks.size());
        Iterator it = this.tricks.iterator();
        while (it.hasNext()) {
            (TrickKnowledgeEvent)it.next().writeToParcel(parcel, flags);
        }
    }
}
