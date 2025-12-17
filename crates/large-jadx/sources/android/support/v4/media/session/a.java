package android.support.v4.media.session;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements android.support.v4.media.session.a {
        public a() {
            super();
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            int i2;
            int i3;
            int obj5;
            Object obj6;
            int obj7;
            final int i6 = 1;
            final String str = "android.support.v4.media.session.IMediaControllerCallback";
            if (i != 1598968902) {
                i2 = 0;
                i3 = 0;
                switch (i) {
                    case 1:
                        parcel2.enforceInterface(str);
                        i3 = obj6;
                        onEvent(parcel2.readString(), i3);
                        return i6;
                    case 2:
                        parcel2.enforceInterface(str);
                        a1();
                        return i6;
                    case 3:
                        parcel2.enforceInterface(str);
                        i3 = obj5;
                        h2(i3);
                        return i6;
                    case 4:
                        parcel2.enforceInterface(str);
                        i3 = obj5;
                        b1(i3);
                        return i6;
                    case 5:
                        parcel2.enforceInterface(str);
                        d0(parcel2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                        return i6;
                    case 6:
                        parcel2.enforceInterface(str);
                        i3 = obj5;
                        Q0(i3);
                        return i6;
                    case 7:
                        parcel2.enforceInterface(str);
                        i3 = obj5;
                        W(i3);
                        return i6;
                    case 8:
                        parcel2.enforceInterface(str);
                        i3 = obj5;
                        n2(i3);
                        return i6;
                    case 9:
                        parcel2.enforceInterface(str);
                        i(parcel2.readInt());
                        return i6;
                    case 10:
                        parcel2.enforceInterface(str);
                        i2 = i6;
                        P0(i2);
                        return i6;
                    case 11:
                        parcel2.enforceInterface(str);
                        i2 = i6;
                        w0(i2);
                        return i6;
                    case 12:
                        parcel2.enforceInterface(str);
                        x1(parcel2.readInt());
                        return i6;
                    case 13:
                        parcel2.enforceInterface(str);
                        V();
                        return i6;
                    default:
                        return super.onTransact(i, parcel2, parcel3, i4);
                }
            }
            parcel3.writeString(str);
            return i6;
        }
    }
    @Override // android.os.IInterface
    public abstract void P0(boolean z);

    @Override // android.os.IInterface
    public abstract void Q0(java.lang.CharSequence charSequence);

    @Override // android.os.IInterface
    public abstract void V();

    @Override // android.os.IInterface
    public abstract void W(Bundle bundle);

    @Override // android.os.IInterface
    public abstract void a1();

    @Override // android.os.IInterface
    public abstract void b1(MediaMetadataCompat mediaMetadataCompat);

    public abstract void d0(List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list);

    @Override // android.os.IInterface
    public abstract void h2(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat);

    @Override // android.os.IInterface
    public abstract void i(int i);

    @Override // android.os.IInterface
    public abstract void n2(android.support.v4.media.session.ParcelableVolumeInfo parcelableVolumeInfo);

    @Override // android.os.IInterface
    public abstract void onEvent(String string, Bundle bundle2);

    @Override // android.os.IInterface
    public abstract void w0(boolean z);

    @Override // android.os.IInterface
    public abstract void x1(int i);
}
