package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes5.dex */
public class ParcelImpl implements Parcelable {

    public static final Parcelable.Creator<androidx.versionedparcelable.ParcelImpl> CREATOR;
    private final androidx.versionedparcelable.VersionedParcelable mParcel;
    static {
        ParcelImpl.1 anon = new ParcelImpl.1();
        ParcelImpl.CREATOR = anon;
    }

    protected ParcelImpl(Parcel in) {
        super();
        VersionedParcelParcel versionedParcelParcel = new VersionedParcelParcel(in);
        this.mParcel = versionedParcelParcel.readVersionedParcelable();
    }

    public ParcelImpl(androidx.versionedparcelable.VersionedParcelable parcel) {
        super();
        this.mParcel = parcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends androidx.versionedparcelable.VersionedParcelable> T getVersionedParcel() {
        return this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        VersionedParcelParcel versionedParcelParcel = new VersionedParcelParcel(dest);
        versionedParcelParcel.writeVersionedParcelable(this.mParcel);
    }
}
