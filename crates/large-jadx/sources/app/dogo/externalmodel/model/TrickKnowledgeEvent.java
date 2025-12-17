package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "lastTrainedTimeMs", "", "(Ljava/lang/String;IJ)V", "getKnowledge", "()I", "getLastTrainedTimeMs", "()J", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickKnowledgeEvent implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.TrickKnowledgeEvent> CREATOR;
    private final int knowledge;
    private final long lastTrainedTimeMs;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.TrickKnowledgeEvent> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.TrickKnowledgeEvent createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            TrickKnowledgeEvent trickKnowledgeEvent = new TrickKnowledgeEvent(parcel.readString(), parcel.readInt(), parcel.readLong(), obj4);
            return trickKnowledgeEvent;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.TrickKnowledgeEvent[] newArray(int i) {
            return new TrickKnowledgeEvent[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        TrickKnowledgeEvent.Creator creator = new TrickKnowledgeEvent.Creator();
        TrickKnowledgeEvent.CREATOR = creator;
    }

    public TrickKnowledgeEvent(String string, int i2, long l3) {
        n.f(string, "trickId");
        super();
        this.trickId = string;
        this.knowledge = i2;
        this.lastTrainedTimeMs = l3;
    }

    public static app.dogo.externalmodel.model.TrickKnowledgeEvent copy$default(app.dogo.externalmodel.model.TrickKnowledgeEvent trickKnowledgeEvent, String string2, int i3, long l4, int i5, Object object6) {
        String obj1;
        int obj2;
        long obj3;
        if (object6 & 1 != 0) {
            obj1 = trickKnowledgeEvent.trickId;
        }
        if (object6 & 2 != 0) {
            obj2 = trickKnowledgeEvent.knowledge;
        }
        if (object6 &= 4 != 0) {
            obj3 = trickKnowledgeEvent.lastTrainedTimeMs;
        }
        return trickKnowledgeEvent.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return this.lastTrainedTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.TrickKnowledgeEvent copy(String string, int i2, long l3) {
        n.f(string, "trickId");
        TrickKnowledgeEvent trickKnowledgeEvent = new TrickKnowledgeEvent(string, i2, l3, obj5);
        return trickKnowledgeEvent;
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
        if (!object instanceof TrickKnowledgeEvent) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (this.knowledge != object.knowledge) {
            return i2;
        }
        if (Long.compare(lastTrainedTimeMs, lastTrainedTimeMs2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getKnowledge() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final long getLastTrainedTimeMs() {
        return this.lastTrainedTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getTrickId() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickKnowledgeEvent(trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", knowledge=");
        stringBuilder.append(this.knowledge);
        stringBuilder.append(", lastTrainedTimeMs=");
        stringBuilder.append(this.lastTrainedTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
        parcel.writeLong(this.lastTrainedTimeMs);
    }
}
