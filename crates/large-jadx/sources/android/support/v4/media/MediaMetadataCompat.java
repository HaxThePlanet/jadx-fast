package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.e.a;
import d.e.g;

/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {

    public static final Parcelable.Creator<android.support.v4.media.MediaMetadataCompat> CREATOR;
    static final a<String, Integer> c;
    final Bundle a;
    private MediaMetadata b;

    class a implements Parcelable.Creator<android.support.v4.media.MediaMetadataCompat> {
        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.MediaMetadataCompat a(Parcel parcel) {
            MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat(parcel);
            return mediaMetadataCompat;
        }

        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.MediaMetadataCompat[] b(int i) {
            return new MediaMetadataCompat[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        a aVar = new a();
        MediaMetadataCompat.c = aVar;
        Integer valueOf = 1;
        aVar.put("android.media.metadata.TITLE", valueOf);
        aVar.put("android.media.metadata.ARTIST", valueOf);
        Integer valueOf2 = 0;
        aVar.put("android.media.metadata.DURATION", valueOf2);
        aVar.put("android.media.metadata.ALBUM", valueOf);
        aVar.put("android.media.metadata.AUTHOR", valueOf);
        aVar.put("android.media.metadata.WRITER", valueOf);
        aVar.put("android.media.metadata.COMPOSER", valueOf);
        aVar.put("android.media.metadata.COMPILATION", valueOf);
        aVar.put("android.media.metadata.DATE", valueOf);
        aVar.put("android.media.metadata.YEAR", valueOf2);
        aVar.put("android.media.metadata.GENRE", valueOf);
        aVar.put("android.media.metadata.TRACK_NUMBER", valueOf2);
        aVar.put("android.media.metadata.NUM_TRACKS", valueOf2);
        aVar.put("android.media.metadata.DISC_NUMBER", valueOf2);
        aVar.put("android.media.metadata.ALBUM_ARTIST", valueOf);
        Integer valueOf3 = 2;
        aVar.put("android.media.metadata.ART", valueOf3);
        aVar.put("android.media.metadata.ART_URI", valueOf);
        aVar.put("android.media.metadata.ALBUM_ART", valueOf3);
        aVar.put("android.media.metadata.ALBUM_ART_URI", valueOf);
        Integer valueOf4 = 3;
        aVar.put("android.media.metadata.USER_RATING", valueOf4);
        aVar.put("android.media.metadata.RATING", valueOf4);
        aVar.put("android.media.metadata.DISPLAY_TITLE", valueOf);
        aVar.put("android.media.metadata.DISPLAY_SUBTITLE", valueOf);
        aVar.put("android.media.metadata.DISPLAY_DESCRIPTION", valueOf);
        aVar.put("android.media.metadata.DISPLAY_ICON", valueOf3);
        aVar.put("android.media.metadata.DISPLAY_ICON_URI", valueOf);
        aVar.put("android.media.metadata.MEDIA_ID", valueOf);
        aVar.put("android.media.metadata.BT_FOLDER_TYPE", valueOf2);
        aVar.put("android.media.metadata.MEDIA_URI", valueOf);
        aVar.put("android.media.metadata.ADVERTISEMENT", valueOf2);
        aVar.put("android.media.metadata.DOWNLOAD_STATUS", valueOf2);
        MediaMetadataCompat.a aVar2 = new MediaMetadataCompat.a();
        MediaMetadataCompat.CREATOR = aVar2;
    }

    MediaMetadataCompat(Parcel parcel) {
        super();
        this.a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static android.support.v4.media.MediaMetadataCompat a(Object object) {
        int sDK_INT;
        int i;
        if (object != null && Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 21) {
                Parcel obtain = Parcel.obtain();
                int i2 = 0;
                (MediaMetadata)object.writeToParcel(obtain, i2);
                obtain.setDataPosition(i2);
                Object fromParcel = MediaMetadataCompat.CREATOR.createFromParcel(obtain);
                obtain.recycle();
                fromParcel.b = object;
                return (MediaMetadataCompat)fromParcel;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.a);
    }
}
