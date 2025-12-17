package androidx.core.graphics.drawable;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes5.dex */
public class IconCompatParcelizer {
    public static androidx.core.graphics.drawable.IconCompat read(VersionedParcel parcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = parcel.readInt(iconCompat.mType, 1);
        iconCompat.mData = parcel.readByteArray(iconCompat.mData, 2);
        iconCompat.mParcelable = parcel.readParcelable(iconCompat.mParcelable, 3);
        iconCompat.mInt1 = parcel.readInt(iconCompat.mInt1, 4);
        iconCompat.mInt2 = parcel.readInt(iconCompat.mInt2, 5);
        iconCompat.mTintList = (ColorStateList)parcel.readParcelable(iconCompat.mTintList, 6);
        iconCompat.mTintModeStr = parcel.readString(iconCompat.mTintModeStr, 7);
        iconCompat.mString1 = parcel.readString(iconCompat.mString1, 8);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(androidx.core.graphics.drawable.IconCompat obj, VersionedParcel parcel) {
        byte[] mData;
        android.os.Parcelable mParcelable;
        int mInt1;
        int mInt2;
        android.content.res.ColorStateList mTintList;
        String mTintModeStr;
        String mString1;
        int mType;
        int i = 1;
        parcel.setSerializationFlags(i, i);
        obj.onPreParceling(parcel.isStream());
        if (-1 != obj.mType) {
            parcel.writeInt(obj.mType, i);
        }
        if (obj.mData != null) {
            parcel.writeByteArray(obj.mData, 2);
        }
        if (obj.mParcelable != null) {
            parcel.writeParcelable(obj.mParcelable, 3);
        }
        if (obj.mInt1 != 0) {
            parcel.writeInt(obj.mInt1, 4);
        }
        if (obj.mInt2 != 0) {
            parcel.writeInt(obj.mInt2, 5);
        }
        if (obj.mTintList != null) {
            parcel.writeParcelable(obj.mTintList, 6);
        }
        if (obj.mTintModeStr != null) {
            parcel.writeString(obj.mTintModeStr, 7);
        }
        if (obj.mString1 != null) {
            parcel.writeString(obj.mString1, 8);
        }
    }
}
