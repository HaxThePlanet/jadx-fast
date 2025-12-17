package app.dogo.com.dogo_android.util;

import android.content.Context;
import com.google.android.exoplayer2.d1;
import com.google.android.exoplayer2.database.b;
import com.google.android.exoplayer2.e2;
import com.google.android.exoplayer2.e2.b;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cJ*\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "goodExamplesCacheDataSourceFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerCacheDataSourceFactory;", "trickStepsCacheDataSourceFactory", "getGoodExamplesPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "url", "", "getVideoStepsPlayer", "startTime", "", "endTime", "predefinedPlayer", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c0 {

    private final Context a;
    private final app.dogo.com.dogo_android.util.b0 b;
    private final app.dogo.com.dogo_android.util.b0 c;
    public c0(Context context) {
        n.f(context, "context");
        super();
        final Context obj15 = context.getApplicationContext();
        n.e(obj15, "context.applicationContext");
        this.a = obj15;
        b bVar = new b(obj15);
        final int i8 = 1048576;
        final int i5 = 0;
        final int i6 = 16;
        final int i7 = 0;
        final b bVar2 = bVar;
        super(obj15, bVar2, "trick_step_videos", l * i8, obj6, i5, obj8, i6, i7);
        this.b = b0Var3;
        super(obj15, bVar2, "good_example_videos", l2 * i8, obj6, i5, obj8, i6, i7);
        this.c = b0Var4;
    }

    public static e2 c(app.dogo.com.dogo_android.util.c0 c0, String string2, int i3, int i4, e2 e25, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        return c0.b(string2, i3, i4, obj4);
    }

    public final e2 a(String string) {
        n.f(string, "url");
        e2.b bVar = new e2.b(this.a);
        e2 e2Var = bVar.z();
        n.e(e2Var, "Builder(appContext).build()");
        HlsMediaSource.Factory factory = new HlsMediaSource.Factory(this.c);
        com.google.android.exoplayer2.source.hls.HlsMediaSource obj4 = factory.a(m1.b(string));
        n.e(obj4, "Factory(goodExamplesCacheDataSourceFactory).createMediaSource(MediaItem.fromUri(url))");
        e2Var.q1(obj4);
        e2Var.f();
        e2Var.J(2);
        e2Var.A(false);
        return e2Var;
    }

    public final e2 b(String string, int i2, int i3, e2 e24) {
        String str;
        long micros;
        long l;
        int obj10;
        e2 obj12;
        n.f(string, "url");
        if (e24 == null) {
            obj12 = new e2.b(this.a);
            n.e(obj12.z(), "Builder(appContext).build()");
        }
        if (i3 == -1) {
            micros = Long.MIN_VALUE;
        } else {
            micros = TimeUnit.SECONDS.toMicros((long)i3);
        }
        HlsMediaSource.Factory obj11 = new HlsMediaSource.Factory(this.b);
        final com.google.android.exoplayer2.source.hls.HlsMediaSource hlsMediaSource = obj11.a(m1.b(string));
        n.e(hlsMediaSource, "Factory(trickStepsCacheDataSourceFactory).createMediaSource(MediaItem.fromUri(url))");
        super(hlsMediaSource, TimeUnit.SECONDS.toMicros((long)i2), obj5, micros, obj7);
        obj12.b1();
        if (obj12 == null) {
        } else {
            obj12.g(0);
        }
        obj12.q1(obj9);
        obj12.f();
        obj12.J(2);
        obj12.A(false);
        return obj12;
    }
}
