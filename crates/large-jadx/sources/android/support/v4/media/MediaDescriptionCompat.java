package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {

    public static final Parcelable.Creator<android.support.v4.media.MediaDescriptionCompat> CREATOR;
    private MediaDescription A;
    private final String a;
    private final java.lang.CharSequence b;
    private final java.lang.CharSequence c;
    private final java.lang.CharSequence v;
    private final Bitmap w;
    private final Uri x;
    private final Bundle y;
    private final Uri z;

    class a implements Parcelable.Creator<android.support.v4.media.MediaDescriptionCompat> {
        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.MediaDescriptionCompat a(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(parcel);
                return mediaDescriptionCompat;
            }
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.MediaDescriptionCompat[] b(int i) {
            return new MediaDescriptionCompat[i];
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

    public static final class b {

        private String a;
        private java.lang.CharSequence b;
        private java.lang.CharSequence c;
        private java.lang.CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;
        public android.support.v4.media.MediaDescriptionCompat a() {
            super(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            return mediaDescriptionCompat2;
        }

        public android.support.v4.media.MediaDescriptionCompat.b b(java.lang.CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.b c(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.b d(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.b e(Uri uri) {
            this.f = uri;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.b f(String string) {
            this.a = string;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.b g(Uri uri) {
            this.h = uri;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.b h(java.lang.CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public android.support.v4.media.MediaDescriptionCompat.b i(java.lang.CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }
    }
    static {
        MediaDescriptionCompat.a aVar = new MediaDescriptionCompat.a();
        MediaDescriptionCompat.CREATOR = aVar;
    }

    MediaDescriptionCompat(Parcel parcel) {
        super();
        this.a = parcel.readString();
        this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.v = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        java.lang.ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.w = (Bitmap)parcel.readParcelable(classLoader);
        this.x = (Uri)parcel.readParcelable(classLoader);
        this.y = parcel.readBundle(classLoader);
        this.z = (Uri)parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String string, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, Bitmap bitmap5, Uri uri6, Bundle bundle7, Uri uri8) {
        super();
        this.a = string;
        this.b = charSequence2;
        this.c = charSequence3;
        this.v = charSequence4;
        this.w = bitmap5;
        this.x = uri6;
        this.y = bundle7;
        this.z = uri8;
    }

    public static android.support.v4.media.MediaDescriptionCompat a(Object object) {
        Bundle mediaUri;
        int sDK_INT;
        int bVar;
        Bundle extras;
        String str2;
        int parcelable;
        String str;
        boolean size;
        int i;
        sDK_INT = Build.VERSION.SDK_INT;
        bVar = new MediaDescriptionCompat.b();
        bVar.f((MediaDescription)object.getMediaId());
        bVar.i(object.getTitle());
        bVar.h(object.getSubtitle());
        bVar.b(object.getDescription());
        bVar.d(object.getIconBitmap());
        bVar.e(object.getIconUri());
        extras = object.getExtras();
        if (object != null && sDK_INT >= 21 && extras != null) {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 21) {
                bVar = new MediaDescriptionCompat.b();
                bVar.f((MediaDescription)object.getMediaId());
                bVar.i(object.getTitle());
                bVar.h(object.getSubtitle());
                bVar.b(object.getDescription());
                bVar.d(object.getIconBitmap());
                bVar.e(object.getIconUri());
                extras = object.getExtras();
                if (extras != null) {
                    extras = MediaSessionCompat.b(extras);
                }
                str2 = "android.support.v4.media.description.MEDIA_URI";
                if (extras != null) {
                    parcelable = extras.getParcelable(str2);
                } else {
                    parcelable = mediaUri;
                }
                if (parcelable != 0) {
                    str = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
                    if (extras.containsKey(str) && extras.size() == 2) {
                        if (extras.size() == 2) {
                        } else {
                            extras.remove(str2);
                            extras.remove(str);
                            mediaUri = extras;
                        }
                    } else {
                    }
                } else {
                }
                bVar.c(mediaUri);
                if (parcelable != 0) {
                    bVar.g(parcelable);
                } else {
                    if (sDK_INT >= 23) {
                        bVar.g(object.getMediaUri());
                    }
                }
                mediaUri.A = object;
            }
        }
        return mediaUri;
    }

    @Override // android.os.Parcelable
    public Object b() {
        MediaDescription build;
        int sDK_INT;
        Bundle bundle;
        int i;
        Uri uri;
        String str;
        if (this.A == null) {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT < 21) {
            } else {
                MediaDescription.Builder builder = new MediaDescription.Builder();
                builder.setMediaId(this.a);
                builder.setTitle(this.b);
                builder.setSubtitle(this.c);
                builder.setDescription(this.v);
                builder.setIconBitmap(this.w);
                builder.setIconUri(this.x);
                i = 23;
                if (sDK_INT < i && this.z != null && this.y == null) {
                    if (this.z != null) {
                        if (this.y == null) {
                            bundle = new Bundle();
                            bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                        }
                        bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.z);
                    }
                }
                builder.setExtras(bundle);
                if (sDK_INT >= i) {
                    builder.setMediaUri(this.z);
                }
                this.A = builder.build();
            }
        }
        return build;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        String str = ", ";
        stringBuilder.append(str);
        stringBuilder.append(this.c);
        stringBuilder.append(str);
        stringBuilder.append(this.v);
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Object obj;
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, i2);
            TextUtils.writeToParcel(this.c, parcel, i2);
            TextUtils.writeToParcel(this.v, parcel, i2);
            parcel.writeParcelable(this.w, i2);
            parcel.writeParcelable(this.x, i2);
            parcel.writeBundle(this.y);
            parcel.writeParcelable(this.z, i2);
        } else {
            (MediaDescription)b().writeToParcel(parcel, i2);
        }
    }
}
