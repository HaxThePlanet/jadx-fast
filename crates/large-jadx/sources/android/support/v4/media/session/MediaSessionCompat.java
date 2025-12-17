package android.support.v4.media.session;

import android.media.session.MediaSession.QueueItem;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import androidx.versionedparcelable.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {

        public static final Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.QueueItem> CREATOR;
        private final MediaDescriptionCompat a;
        private final long b;
        static {
            MediaSessionCompat.QueueItem.a aVar = new MediaSessionCompat.QueueItem.a();
            MediaSessionCompat.QueueItem.CREATOR = aVar;
        }

        private QueueItem(MediaSession.QueueItem mediaSession$QueueItem, MediaDescriptionCompat mediaDescriptionCompat2, long l3) {
            super();
            if (mediaDescriptionCompat2 == null) {
            } else {
                if (Long.compare(l3, i) == 0) {
                } else {
                    this.a = mediaDescriptionCompat2;
                    this.b = l3;
                }
                IllegalArgumentException obj3 = new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
                throw obj3;
            }
            obj3 = new IllegalArgumentException("Description cannot be null");
            throw obj3;
        }

        QueueItem(Parcel parcel) {
            super();
            this.a = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.b = parcel.readLong();
        }

        public static android.support.v4.media.session.MediaSessionCompat.QueueItem a(Object object) {
            int sDK_INT;
            int i;
            if (object != null && Build.VERSION.SDK_INT < 21) {
                if (Build.VERSION.SDK_INT < 21) {
                }
                MediaSessionCompat.QueueItem queueItem = new MediaSessionCompat.QueueItem(object, MediaDescriptionCompat.a((MediaSession.QueueItem)object.getDescription()), object.getQueueId(), obj2);
                return queueItem;
            }
            return null;
        }

        public static List<android.support.v4.media.session.MediaSessionCompat.QueueItem> b(List<?> list) {
            int sDK_INT;
            int i;
            if (list != null) {
                if (Build.VERSION.SDK_INT < 21) {
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator obj2 = list.iterator();
                    for (Object next2 : obj2) {
                        arrayList.add(MediaSessionCompat.QueueItem.a(next2));
                    }
                }
                return arrayList;
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MediaSession.QueueItem {Description=");
            stringBuilder.append(this.a);
            stringBuilder.append(", Id=");
            stringBuilder.append(this.b);
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            this.a.writeToParcel(parcel, i2);
            parcel.writeLong(this.b);
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {

        public static final Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper> CREATOR;
        ResultReceiver a;
        static {
            MediaSessionCompat.ResultReceiverWrapper.a aVar = new MediaSessionCompat.ResultReceiverWrapper.a();
            MediaSessionCompat.ResultReceiverWrapper.CREATOR = aVar;
        }

        ResultReceiverWrapper(Parcel parcel) {
            super();
            this.a = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            this.a.writeToParcel(parcel, i2);
        }
    }

    public static final class Token implements Parcelable {

        public static final Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.Token> CREATOR;
        private final Object a;
        private final Object b;
        private android.support.v4.media.session.b c;
        private c v;
        static {
            MediaSessionCompat.Token.a aVar = new MediaSessionCompat.Token.a();
            MediaSessionCompat.Token.CREATOR = aVar;
        }

        Token(Object object) {
            final int i = 0;
            super(object, i, i);
        }

        Token(Object object, android.support.v4.media.session.b b2, c c3) {
            super();
            Object object2 = new Object();
            this.a = object2;
            this.b = object;
            this.c = b2;
            this.v = c3;
        }

        @Override // android.os.Parcelable
        public android.support.v4.media.session.b a() {
            final Object obj = this.a;
            return this.c;
            synchronized (obj) {
                obj = this.a;
                return this.c;
            }
        }

        @Override // android.os.Parcelable
        public void b(android.support.v4.media.session.b b) {
            final Object obj = this.a;
            this.c = b;
            return;
            synchronized (obj) {
                obj = this.a;
                this.c = b;
            }
        }

        @Override // android.os.Parcelable
        public void c(c c) {
            final Object obj = this.a;
            this.v = c;
            return;
            synchronized (obj) {
                obj = this.a;
                this.v = c;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            int i;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof MediaSessionCompat.Token) {
                return i2;
            }
            Object obj = this.b;
            if (obj == null) {
                if (object.b == null) {
                } else {
                    i = i2;
                }
                return i;
            }
            Object obj4 = object.b;
            if (obj4 == null) {
                return i2;
            }
            return obj.equals(obj4);
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            Object obj = this.b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Object sDK_INT;
            int obj4;
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable)this.b, i2);
            } else {
                parcel.writeStrongBinder((IBinder)this.b);
            }
        }
    }
    static {
        boolean equals = Build.VERSION.CODENAME.equals("S");
    }

    public static void a(Bundle bundle) {
        java.lang.ClassLoader classLoader;
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        MediaSessionCompat.a(bundle);
        bundle.isEmpty();
        return bundle;
    }
}
