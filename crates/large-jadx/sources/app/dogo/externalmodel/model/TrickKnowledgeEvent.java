package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: TrickKnowledgeEvent.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "Landroid/os/Parcelable;", "trickId", "", "knowledge", "", "lastTrainedTimeMs", "", "(Ljava/lang/String;IJ)V", "getKnowledge", "()I", "getLastTrainedTimeMs", "()J", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickKnowledgeEvent implements Parcelable {

    public static final Parcelable.Creator<TrickKnowledgeEvent> CREATOR = new TrickKnowledgeEvent$Creator<>();
    private final int knowledge;
    private final long lastTrainedTimeMs;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrickKnowledgeEvent> {
        @Override // android.os.Parcelable$Creator
        public final TrickKnowledgeEvent createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new TrickKnowledgeEvent(parcel.readString(), parcel.readInt(), parcel.readLong(), r4);
        }

        @Override // android.os.Parcelable$Creator
        public final TrickKnowledgeEvent[] newArray(int i) {
            return new TrickKnowledgeEvent[i];
        }
    }
    public TrickKnowledgeEvent(String str, int i, long j) {
        n.f(str, "trickId");
        super();
        this.trickId = str;
        this.knowledge = i;
        this.lastTrainedTimeMs = j;
    }

    public final int getKnowledge() {
        return this.knowledge;
    }

    public final long getLastTrainedTimeMs() {
        return this.lastTrainedTimeMs;
    }

    public final String getTrickId() {
        return this.trickId;
    }


    public static /* synthetic */ TrickKnowledgeEvent copy$default(TrickKnowledgeEvent trickKnowledgeEvent, String str, int i, long j, int i2, Object object) {
        String trickId2;
        int knowledge2;
        long lastTrainedTimeMs2;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        return trickKnowledgeEvent.copy(trickId2, knowledge2, lastTrainedTimeMs2);
    }

    /* operator */ public final String component1() {
        return this.trickId;
    }

    /* operator */ public final int component2() {
        return this.knowledge;
    }

    /* operator */ public final long component3() {
        return this.lastTrainedTimeMs;
    }

    public final TrickKnowledgeEvent copy(String trickId, int knowledge, long lastTrainedTimeMs) {
        n.f(trickId, "trickId");
        return new TrickKnowledgeEvent(trickId, knowledge, lastTrainedTimeMs, r5);
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
        if (!(other instanceof TrickKnowledgeEvent)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        if (this.knowledge != other.knowledge) {
            return false;
        }
        return this.lastTrainedTimeMs != other.lastTrainedTimeMs ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.trickId.hashCode() * 31) + Integer.hashCode(this.knowledge) * 31 + Long.hashCode(this.lastTrainedTimeMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickKnowledgeEvent(trickId=";
        String str3 = ", knowledge=";
        String str4 = ", lastTrainedTimeMs=";
        str = str2 + this.trickId + str3 + this.knowledge + str4 + this.lastTrainedTimeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.trickId);
        parcel.writeInt(this.knowledge);
        parcel.writeLong(this.lastTrainedTimeMs);
    }
}
