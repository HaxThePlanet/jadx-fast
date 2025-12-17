package com.google.android.exoplayer2.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
final class t {

    private final com.google.android.exoplayer2.audio.t.a a = null;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;

    private static final class a {

        private final AudioTrack a;
        private final AudioTimestamp b;
        private long c;
        private long d;
        private long e;
        public a(AudioTrack audioTrack) {
            super();
            this.a = audioTrack;
            AudioTimestamp obj1 = new AudioTimestamp();
            this.b = obj1;
        }

        public long a() {
            return this.e;
        }

        public long b() {
            return nanoTime /= i2;
        }

        public boolean c() {
            AudioTimestamp time;
            int cmp;
            int i;
            int i2;
            boolean timestamp = this.a.getTimestamp(this.b);
            long framePosition = time2.framePosition;
            if (timestamp && Long.compare(l, framePosition) > 0) {
                framePosition = time2.framePosition;
                if (Long.compare(l, framePosition) > 0) {
                    this.c = l3 += i2;
                }
                this.d = framePosition;
                this.e = framePosition += i;
            }
            return timestamp;
        }
    }
    public t(AudioTrack audioTrack) {
        com.google.android.exoplayer2.audio.t.a aVar;
        AudioTrack obj3;
        super();
        if (p0.a >= 19) {
            aVar = new t.a(audioTrack);
            this.a = aVar;
            g();
        } else {
            obj3 = 0;
            h(3);
        }
    }

    private void h(int i) {
        int i3;
        int i5;
        int i4;
        int i2;
        this.b = i;
        i3 = 10000;
        if (i != 0) {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i != 3) {
                        if (i != 4) {
                        } else {
                            this.d = 500000;
                        }
                        IllegalStateException obj7 = new IllegalStateException();
                        throw obj7;
                    }
                }
                this.d = 10000000;
            } else {
                this.d = i3;
            }
        } else {
            this.e = 0;
            this.f = -1;
            this.c = nanoTime /= i2;
            this.d = i3;
        }
    }

    public void a() {
        if (this.b == 4) {
            g();
        }
    }

    public long b() {
        long l;
        com.google.android.exoplayer2.audio.t.a aVar = this.a;
        if (aVar != null) {
            l = aVar.a();
        } else {
            l = -1;
        }
        return l;
    }

    public long c() {
        long l;
        com.google.android.exoplayer2.audio.t.a aVar = this.a;
        if (aVar != null) {
            l = aVar.b();
        } else {
            l = -9223372036854775807L;
        }
        return l;
    }

    public boolean d() {
        int i;
        i = this.b == 2 ? 1 : 0;
        return i;
    }

    public boolean e(long l) {
        com.google.android.exoplayer2.audio.t.a aVar;
        int i2;
        int cmp;
        int i;
        int l2;
        int obj7;
        int obj8;
        aVar = this.a;
        i2 = 0;
        if (aVar != null) {
            if (Long.compare(i3, l2) < 0) {
            } else {
                this.e = l;
                aVar = aVar.c();
                cmp = this.b;
                i = 3;
                l2 = 1;
                if (cmp != 0) {
                    obj7 = 2;
                    if (cmp != l2) {
                        if (cmp != obj7) {
                            if (cmp != i) {
                                if (cmp != 4) {
                                } else {
                                }
                                obj7 = new IllegalStateException();
                                throw obj7;
                            }
                            if (aVar) {
                                g();
                            }
                        } else {
                            if (!aVar) {
                                g();
                            }
                        }
                    } else {
                        if (aVar) {
                            if (Long.compare(i2, i) > 0) {
                                h(obj7);
                            }
                        } else {
                            g();
                        }
                    }
                    i2 = aVar;
                } else {
                    if (aVar) {
                        if (Long.compare(obj7, cmp) >= 0) {
                            this.f = this.a.a();
                            h(l2);
                        }
                    } else {
                        if (Long.compare(obj7, i2) > 0) {
                            h(i);
                        }
                    }
                }
            }
        }
        return i2;
    }

    public void f() {
        h(4);
    }

    public void g() {
        com.google.android.exoplayer2.audio.t.a aVar;
        if (this.a != null) {
            h(0);
        }
    }
}
