package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements IBinder.DeathRecipient {

    android.support.v4.media.session.c.b a;
    android.support.v4.media.session.a b;

    private static class a extends MediaController.Callback {

        private final WeakReference<android.support.v4.media.session.c> a;
        a(android.support.v4.media.session.c c) {
            super();
            WeakReference weakReference = new WeakReference(c);
            this.a = weakReference;
        }

        @Override // android.media.session.MediaController$Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo mediaController$PlaybackInfo) {
            android.support.v4.media.session.d dVar2;
            int playbackType;
            AudioAttributesCompat audioAttributesCompat;
            int volumeControl;
            int maxVolume;
            int currentVolume;
            android.support.v4.media.session.d dVar;
            Object obj = this.a.get();
            if ((c)obj != null) {
                super(playbackInfo.getPlaybackType(), AudioAttributesCompat.c(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
                (c)obj.a(dVar);
            }
        }

        @Override // android.media.session.MediaController$Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.b(bundle);
            }
        }

        @Override // android.media.session.MediaController$Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            Object obj2;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.c(MediaMetadataCompat.a(mediaMetadata));
            }
        }

        @Override // android.media.session.MediaController$Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            android.support.v4.media.session.a aVar;
            Object obj3;
            Object obj = this.a.get();
            if ((c)obj != null) {
                if (obj.b != null) {
                } else {
                    (c)obj.d(PlaybackStateCompat.a(playbackState));
                }
            }
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            List obj2;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.e(MediaSessionCompat.QueueItem.b(list));
            }
        }

        @Override // android.media.session.MediaController$Callback
        public void onQueueTitleChanged(java.lang.CharSequence charSequence) {
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.f(charSequence);
            }
        }

        @Override // android.media.session.MediaController$Callback
        public void onSessionDestroyed() {
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.g();
            }
        }

        @Override // android.media.session.MediaController$Callback
        public void onSessionEvent(String string, Bundle bundle2) {
            android.support.v4.media.session.a sDK_INT;
            int i;
            MediaSessionCompat.a(bundle2);
            Object obj = this.a.get();
            if ((c)obj != null) {
                if (obj.b != null && Build.VERSION.SDK_INT < 23) {
                    if (Build.VERSION.SDK_INT < 23) {
                    } else {
                        (c)obj.h(string, bundle2);
                    }
                } else {
                }
            }
        }
    }

    private class b extends Handler {
    }

    private static class c extends android.support.v4.media.session.a.a {

        private final WeakReference<android.support.v4.media.session.c> a;
        c(android.support.v4.media.session.c c) {
            super();
            WeakReference weakReference = new WeakReference(c);
            this.a = weakReference;
        }

        @Override // android.support.v4.media.session.a$a
        public void P0(boolean z) {
        }

        @Override // android.support.v4.media.session.a$a
        public void Q0(java.lang.CharSequence charSequence) {
            int i2;
            int i;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(6, charSequence, 0);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void V() {
            int i2;
            int i;
            Object obj = this.a.get();
            if ((c)obj != null) {
                i = 0;
                (c)obj.i(13, i, i);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void W(Bundle bundle) {
            int i;
            int i2;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(7, bundle, 0);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void a1() {
            int i;
            int i2;
            Object obj = this.a.get();
            if ((c)obj != null) {
                i2 = 0;
                (c)obj.i(8, i2, i2);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void b1(MediaMetadataCompat mediaMetadataCompat) {
            int i2;
            int i;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(3, mediaMetadataCompat, 0);
            }
        }

        public void d0(List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
            int i;
            int i2;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(5, list, 0);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void h2(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            int i;
            int i2;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(2, playbackStateCompat, 0);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void i(int i) {
            int i3;
            int i2;
            int obj4;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(9, Integer.valueOf(i), 0);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void n2(android.support.v4.media.session.ParcelableVolumeInfo parcelableVolumeInfo) {
            int i;
            android.support.v4.media.session.d dVar;
            int i2;
            int i3;
            int i6;
            int i5;
            int i4;
            int dVar2;
            Object obj10;
            Object obj = this.a.get();
            if ((c)obj != null) {
                i = 0;
                if (parcelableVolumeInfo != null) {
                    super(parcelableVolumeInfo.a, parcelableVolumeInfo.b, parcelableVolumeInfo.c, parcelableVolumeInfo.v, parcelableVolumeInfo.w);
                } else {
                    dVar2 = i;
                }
                (c)obj.i(4, dVar2, i);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void onEvent(String string, Bundle bundle2) {
            int i;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(1, string, bundle2);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void w0(boolean z) {
            int i2;
            int i;
            boolean obj4;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(11, Boolean.valueOf(z), 0);
            }
        }

        @Override // android.support.v4.media.session.a$a
        public void x1(int i) {
            int i2;
            int i3;
            int obj4;
            Object obj = this.a.get();
            if ((c)obj != null) {
                (c)obj.i(12, Integer.valueOf(i), 0);
            }
        }
    }
    public c() {
        Object aVar;
        super();
        if (Build.VERSION.SDK_INT >= 21) {
            aVar = new c.a(this);
        } else {
            aVar = new c.c(this);
            this.b = aVar;
        }
    }

    @Override // android.os.IBinder$DeathRecipient
    public void a(android.support.v4.media.session.d d) {
    }

    @Override // android.os.IBinder$DeathRecipient
    public void b(Bundle bundle) {
    }

    @Override // android.os.IBinder$DeathRecipient
    public void binderDied() {
        final int i2 = 0;
        i(8, i2, i2);
    }

    @Override // android.os.IBinder$DeathRecipient
    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    @Override // android.os.IBinder$DeathRecipient
    public void d(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
    }

    @Override // android.os.IBinder$DeathRecipient
    public void f(java.lang.CharSequence charSequence) {
    }

    @Override // android.os.IBinder$DeathRecipient
    public void g() {
    }

    @Override // android.os.IBinder$DeathRecipient
    public void h(String string, Bundle bundle2) {
    }

    @Override // android.os.IBinder$DeathRecipient
    void i(int i, Object object2, Bundle bundle3) {
        int obj2;
        final android.support.v4.media.session.c.b bVar = this.a;
        if (bVar != null) {
            obj2 = bVar.obtainMessage(i, object2);
            obj2.setData(bundle3);
            obj2.sendToTarget();
        }
    }
}
