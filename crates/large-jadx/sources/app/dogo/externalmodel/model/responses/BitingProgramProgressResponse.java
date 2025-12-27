package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.BitingProgressModel;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: BitingProgramProgressResponse.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/BitingProgramProgressResponse;", "Landroid/os/Parcelable;", "progress", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "(Lapp/dogo/externalmodel/model/BitingProgressModel;)V", "getProgress", "()Lapp/dogo/externalmodel/model/BitingProgressModel;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BitingProgramProgressResponse implements Parcelable {

    public static final Parcelable.Creator<BitingProgramProgressResponse> CREATOR = new BitingProgramProgressResponse$Creator<>();
    private final BitingProgressModel progress;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BitingProgramProgressResponse> {
        @Override // android.os.Parcelable$Creator
        public final BitingProgramProgressResponse createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new BitingProgramProgressResponse((BitingProgressModel)BitingProgressModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final BitingProgramProgressResponse[] newArray(int i) {
            return new BitingProgramProgressResponse[i];
        }
    }
    public BitingProgramProgressResponse(BitingProgressModel bitingProgressModel) {
        n.f(bitingProgressModel, "progress");
        super();
        this.progress = bitingProgressModel;
    }

    public final BitingProgressModel getProgress() {
        return this.progress;
    }


    public static /* synthetic */ BitingProgramProgressResponse copy$default(BitingProgramProgressResponse bitingProgramProgressResponse, BitingProgressModel bitingProgressModel, int i, Object object) {
        BitingProgressModel progress2;
        if (i & 1 != 0) {
        }
        return bitingProgramProgressResponse.copy(progress2);
    }

    /* operator */ public final BitingProgressModel component1() {
        return this.progress;
    }

    public final BitingProgramProgressResponse copy(BitingProgressModel progress) {
        n.f(progress, "progress");
        return new BitingProgramProgressResponse(progress);
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
        if (!(other instanceof BitingProgramProgressResponse)) {
            return false;
        }
        return !n.b(this.progress, other.progress) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.progress.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "BitingProgramProgressResponse(progress=";
        str = str2 + this.progress + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.progress.writeToParcel(parcel, flags);
    }
}
