package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u1;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface AudioSink {

    public static final class ConfigurationException extends Exception {

        public final i1 format;
        public ConfigurationException(String string, i1 i12) {
            super(string);
            this.format = i12;
        }

        public ConfigurationException(Throwable throwable, i1 i12) {
            super(throwable);
            this.format = i12;
        }
    }

    public static final class InitializationException extends Exception {

        public final int audioTrackState;
        public final i1 format;
        public final boolean isRecoverable;
        public InitializationException(int i, int i2, int i3, int i4, i1 i15, boolean z6, Exception exception7) {
            String str;
            str = z6 ? " (recoverable)" : "";
            StringBuilder stringBuilder = new StringBuilder(length += 80);
            stringBuilder.append("AudioTrack init failed ");
            stringBuilder.append(i);
            stringBuilder.append(" ");
            stringBuilder.append("Config(");
            stringBuilder.append(i2);
            String obj5 = ", ";
            stringBuilder.append(obj5);
            stringBuilder.append(i3);
            stringBuilder.append(obj5);
            stringBuilder.append(i4);
            stringBuilder.append(")");
            stringBuilder.append(str);
            super(stringBuilder.toString(), exception7);
            this.audioTrackState = i;
            this.isRecoverable = z6;
            this.format = i15;
        }
    }

    public static final class UnexpectedDiscontinuityException extends Exception {

        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;
        public UnexpectedDiscontinuityException(long l, long l2) {
            StringBuilder stringBuilder = new StringBuilder(103);
            stringBuilder.append("Unexpected audio track timestamp discontinuity: expected ");
            stringBuilder.append(obj5);
            stringBuilder.append(", got ");
            stringBuilder.append(l);
            super(stringBuilder.toString());
            this.actualPresentationTimeUs = l;
            this.expectedPresentationTimeUs = obj5;
        }
    }

    public static final class WriteException extends Exception {

        public final int errorCode;
        public final i1 format;
        public final boolean isRecoverable;
        public WriteException(int i, i1 i12, boolean z3) {
            StringBuilder stringBuilder = new StringBuilder(36);
            stringBuilder.append("AudioTrack write failed: ");
            stringBuilder.append(i);
            super(stringBuilder.toString());
            this.isRecoverable = z3;
            this.errorCode = i;
            this.format = i12;
        }
    }

    public interface a {
        public abstract void a(boolean z);

        public void b(long l) {
        }

        public abstract void c(int i, long l2, long l3);

        public void d(long l) {
        }

        public abstract void e();

        public void f() {
        }

        public void t(Exception exception) {
        }
    }
    public abstract boolean b(i1 i1);

    public abstract boolean c();

    public abstract void d();

    public abstract u1 e();

    public abstract void flush();

    public abstract void g(float f);

    public abstract void h(u1 u1);

    public abstract void i();

    public abstract boolean j();

    public abstract void k(int i);

    public abstract long l(boolean z);

    public abstract void m();

    public abstract void n(com.google.android.exoplayer2.audio.p p);

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract boolean r(ByteBuffer byteBuffer, long l2, int i3);

    public abstract void reset();

    public abstract void s(com.google.android.exoplayer2.audio.AudioSink.a audioSink$a);

    public abstract int t(i1 i1);

    public abstract void u(i1 i1, int i2, int[] i3Arr3);

    public abstract void v();

    public abstract void w(boolean z);

    public abstract void x(com.google.android.exoplayer2.audio.v v);
}
