package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {

    public static final Parcelable.Creator<android.support.v4.media.session.PlaybackStateCompat> CREATOR;
    List<android.support.v4.media.session.PlaybackStateCompat.CustomAction> A;
    final long B;
    final Bundle C;
    final int a;
    final long b;
    final long c;
    final float v;
    final long w;
    final int x;
    final java.lang.CharSequence y;
    final long z;

    public static final class CustomAction implements Parcelable {

        public static final Parcelable.Creator<android.support.v4.media.session.PlaybackStateCompat.CustomAction> CREATOR;
        private final String a;
        private final java.lang.CharSequence b;
        private final int c;
        private final Bundle v;
        static {
            PlaybackStateCompat.CustomAction.a aVar = new PlaybackStateCompat.CustomAction.a();
            PlaybackStateCompat.CustomAction.CREATOR = aVar;
        }

        CustomAction(Parcel parcel) {
            super();
            this.a = parcel.readString();
            this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.c = parcel.readInt();
            this.v = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String string, java.lang.CharSequence charSequence2, int i3, Bundle bundle4) {
            super();
            this.a = string;
            this.b = charSequence2;
            this.c = i3;
            this.v = bundle4;
        }

        public static android.support.v4.media.session.PlaybackStateCompat.CustomAction a(Object object) {
            int sDK_INT;
            int i;
            if (object != null && Build.VERSION.SDK_INT < 21) {
                if (Build.VERSION.SDK_INT < 21) {
                }
                Bundle extras = (PlaybackState.CustomAction)object.getExtras();
                MediaSessionCompat.a(extras);
                PlaybackStateCompat.CustomAction customAction = new PlaybackStateCompat.CustomAction(object.getAction(), object.getName(), object.getIcon(), extras);
                return customAction;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Action:mName='");
            stringBuilder.append(this.b);
            stringBuilder.append(", mIcon=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mExtras=");
            stringBuilder.append(this.v);
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeBundle(this.v);
        }
    }

    class a implements Parcelable.Creator<android.support.v4.media.session.PlaybackStateCompat> {
        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.session.PlaybackStateCompat a(Parcel parcel) {
            PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(parcel);
            return playbackStateCompat;
        }

        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.session.PlaybackStateCompat[] b(int i) {
            return new PlaybackStateCompat[i];
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
        PlaybackStateCompat.a aVar = new PlaybackStateCompat.a();
        PlaybackStateCompat.CREATOR = aVar;
    }

    PlaybackStateCompat(int i, long l2, long l3, float f4, long l5, int i6, java.lang.CharSequence charSequence7, long l8, List<android.support.v4.media.session.PlaybackStateCompat.CustomAction> list9, long l10, Bundle bundle11) {
        final Object obj = this;
        super();
        obj.a = i;
        obj.b = l2;
        obj.c = f4;
        obj.v = i6;
        obj.w = charSequence7;
        obj.x = list9;
        obj.y = l10;
        obj.z = bundle11;
        ArrayList arrayList = new ArrayList(obj16);
        obj.A = arrayList;
        obj.B = obj17;
        obj.C = obj19;
    }

    PlaybackStateCompat(Parcel parcel) {
        super();
        this.a = parcel.readInt();
        this.b = parcel.readLong();
        this.v = parcel.readFloat();
        this.z = parcel.readLong();
        this.c = parcel.readLong();
        this.w = parcel.readLong();
        this.y = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.A = parcel.createTypedArrayList(PlaybackStateCompat.CustomAction.CREATOR);
        this.B = parcel.readLong();
        this.C = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.x = parcel.readInt();
    }

    public static android.support.v4.media.session.PlaybackStateCompat a(Object object) {
        int playbackStateCompat2;
        int sDK_INT;
        int sDK_INT2;
        Object customActions;
        int arrayList;
        boolean next;
        int size;
        android.support.v4.media.session.PlaybackStateCompat playbackStateCompat;
        int state;
        long position;
        long bufferedPosition;
        float playbackSpeed;
        long actions;
        int i;
        java.lang.CharSequence errorMessage;
        long lastPositionUpdateTime;
        int i3;
        long activeQueueItemId;
        int i2;
        if (object != null && Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 21) {
                sDK_INT = object;
                customActions = (PlaybackState)sDK_INT.getCustomActions();
                if (customActions != null) {
                    arrayList = new ArrayList(customActions.size());
                    customActions = customActions.iterator();
                    for (Object next2 : customActions) {
                        arrayList.add(PlaybackStateCompat.CustomAction.a(next2));
                    }
                    i3 = arrayList;
                } else {
                    i3 = playbackStateCompat2;
                }
                if (Build.VERSION.SDK_INT >= 22) {
                    MediaSessionCompat.a(sDK_INT.getExtras());
                }
                super(sDK_INT.getState(), sDK_INT.getPosition(), obj8, sDK_INT.getBufferedPosition(), obj10, sDK_INT.getPlaybackSpeed(), sDK_INT.getActions(), obj13, 0, sDK_INT.getErrorMessage(), sDK_INT.getLastPositionUpdateTime(), obj17, i3, sDK_INT.getActiveQueueItemId(), obj20, playbackStateCompat2);
            }
        }
        return playbackStateCompat2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=");
        stringBuilder.append(this.a);
        stringBuilder.append(", position=");
        stringBuilder.append(this.b);
        stringBuilder.append(", buffered position=");
        stringBuilder.append(this.c);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.v);
        stringBuilder.append(", updated=");
        stringBuilder.append(this.z);
        stringBuilder.append(", actions=");
        stringBuilder.append(this.w);
        stringBuilder.append(", error code=");
        stringBuilder.append(this.x);
        stringBuilder.append(", error message=");
        stringBuilder.append(this.y);
        stringBuilder.append(", custom actions=");
        stringBuilder.append(this.A);
        stringBuilder.append(", active item id=");
        stringBuilder.append(this.B);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeLong(this.b);
        parcel.writeFloat(this.v);
        parcel.writeLong(this.z);
        parcel.writeLong(this.c);
        parcel.writeLong(this.w);
        TextUtils.writeToParcel(this.y, parcel, i2);
        parcel.writeTypedList(this.A);
        parcel.writeLong(this.B);
        parcel.writeBundle(this.C);
        parcel.writeInt(this.x);
    }
}
