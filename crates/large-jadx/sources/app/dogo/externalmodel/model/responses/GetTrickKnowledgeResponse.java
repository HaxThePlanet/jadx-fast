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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/responses/GetTrickKnowledgeResponse;", "Landroid/os/Parcelable;", "tricks", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "(Ljava/util/List;)V", "getTricks", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GetTrickKnowledgeResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse> CREATOR;
    private final List<TrickKnowledgeEvent> tricks;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(TrickKnowledgeEvent.CREATOR.createFromParcel(parcel));
                i++;
            }
            GetTrickKnowledgeResponse obj5 = new GetTrickKnowledgeResponse(arrayList);
            return obj5;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse[] newArray(int i) {
            return new GetTrickKnowledgeResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        GetTrickKnowledgeResponse.Creator creator = new GetTrickKnowledgeResponse.Creator();
        GetTrickKnowledgeResponse.CREATOR = creator;
    }

    public GetTrickKnowledgeResponse(List<TrickKnowledgeEvent> list) {
        n.f(list, "tricks");
        super();
        this.tricks = list;
    }

    public static app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse copy$default(app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse getTrickKnowledgeResponse, List list2, int i3, Object object4) {
        List obj1;
        if (i3 &= 1 != 0) {
            obj1 = getTrickKnowledgeResponse.tricks;
        }
        return getTrickKnowledgeResponse.copy(obj1);
    }

    public final List<TrickKnowledgeEvent> component1() {
        return this.tricks;
    }

    public final app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse copy(List<TrickKnowledgeEvent> list) {
        n.f(list, "tricks");
        GetTrickKnowledgeResponse getTrickKnowledgeResponse = new GetTrickKnowledgeResponse(list);
        return getTrickKnowledgeResponse;
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
        if (object instanceof GetTrickKnowledgeResponse == null) {
            return i2;
        }
        if (!n.b(this.tricks, object.tricks)) {
            return i2;
        }
        return i;
    }

    public final List<TrickKnowledgeEvent> getTricks() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.tricks.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetTrickKnowledgeResponse(tricks=");
        stringBuilder.append(this.tricks);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List tricks = this.tricks;
        parcel.writeInt(tricks.size());
        Iterator iterator = tricks.iterator();
        for (TrickKnowledgeEvent size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
