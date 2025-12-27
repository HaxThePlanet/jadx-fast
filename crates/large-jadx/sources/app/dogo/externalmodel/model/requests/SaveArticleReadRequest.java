package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SaveArticleReadRequest.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0008\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0005¨\u0006\u0015", d2 = {"Lapp/dogo/externalmodel/model/requests/SaveArticleReadRequest;", "Landroid/os/Parcelable;", "isRead", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SaveArticleReadRequest implements Parcelable {

    public static final Parcelable.Creator<SaveArticleReadRequest> CREATOR = new SaveArticleReadRequest$Creator<>();
    private final boolean isRead;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SaveArticleReadRequest> {
        @Override // android.os.Parcelable$Creator
        public final SaveArticleReadRequest createFromParcel(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            SaveArticleReadRequest saveArticleReadRequest = new SaveArticleReadRequest((parcel.readInt() != 0 ? 1 : 0));
            return saveArticleReadRequest;
        }

        @Override // android.os.Parcelable$Creator
        public final SaveArticleReadRequest[] newArray(int i) {
            return new SaveArticleReadRequest[i];
        }
    }
    public SaveArticleReadRequest(boolean z) {
        super();
        this.isRead = z;
    }

    public final boolean isRead() {
        return this.isRead;
    }


    public static /* synthetic */ SaveArticleReadRequest copy$default(SaveArticleReadRequest saveArticleReadRequest, boolean z, int i, Object object) {
        boolean isRead2;
        if (i & 1 != 0) {
        }
        return saveArticleReadRequest.copy(isRead2);
    }

    /* operator */ public final boolean component1() {
        return this.isRead;
    }

    public final SaveArticleReadRequest copy(boolean isRead) {
        return new SaveArticleReadRequest(isRead);
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
        if (!(other instanceof SaveArticleReadRequest)) {
            return false;
        }
        return this.isRead != other.isRead ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 1;
        if (this.isRead) {
            i = 1;
        }
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SaveArticleReadRequest(isRead=";
        str = str2 + this.isRead + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.isRead);
    }
}
