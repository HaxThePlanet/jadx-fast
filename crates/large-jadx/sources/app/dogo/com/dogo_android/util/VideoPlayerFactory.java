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

/* compiled from: VideoPlayerFactory.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cJ*\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "goodExamplesCacheDataSourceFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerCacheDataSourceFactory;", "trickStepsCacheDataSourceFactory", "getGoodExamplesPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "url", "", "getVideoStepsPlayer", "startTime", "", "endTime", "predefinedPlayer", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c0, reason: from kotlin metadata */
public final class VideoPlayerFactory {

    /* renamed from: a, reason: from kotlin metadata */
    private final Context appContext;
    /* renamed from: b, reason: from kotlin metadata */
    private final b0 goodExamplesCacheDataSourceFactory;
    /* renamed from: c, reason: from kotlin metadata */
    private final b0 trickStepsCacheDataSourceFactory;
    public c0(Context context) {
        n.f(context, "context");
        super();
        final Context context2 = context.getApplicationContext();
        n.e(context2, "context.applicationContext");
        this.appContext = context2;
        final long l6 = 1048576L;
        final int i3 = 0;
        final int i4 = 16;
        final int i5 = 0;
        final Object obj = new b(context2);
        super(context2, obj, "trick_step_videos", (long)100 * l6, l5, i3, gVar, i4, i5);
        this.goodExamplesCacheDataSourceFactory = videoPlayerCacheDataSourceFactory;
        super(context2, obj, "good_example_videos", (long)50 * l6, l5, i3, gVar, i4, i5);
        this.trickStepsCacheDataSourceFactory = videoPlayerCacheDataSourceFactory2;
    }

    public static /* synthetic */ e2 c(c0 c0Var, String str, int i, int i2, e2 e2Var, int i3, Object object) {
        if (i3 & 8 != 0) {
            i = 0;
        }
        return c0Var.getVideoStepsPlayer(str, i, i2, e2Var);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final e2 getGoodExamplesPlayer(String url) {
        n.f(url, "url");
        e2 e2Var = new e2.b(this.appContext).z();
        n.e(e2Var, "Builder(appContext).build()");
        com.google.android.exoplayer2.source.hls.HlsMediaSource hlsMediaSource = new HlsMediaSource.Factory(this.trickStepsCacheDataSourceFactory).a(m1.b(url));
        n.e(hlsMediaSource, "Factory(goodExamplesCacheDataSourceFactory).createMediaSource(MediaItem.fromUri(url))");
        e2Var.q1(hlsMediaSource);
        e2Var.f();
        e2Var.J(2);
        e2Var.A(false);
        return e2Var;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final e2 getVideoStepsPlayer(String url, int startTime, int endTime, e2 predefinedPlayer) {
        long micros = -9223372036854775808L;
        long l;
        e2 e2Var;
        str = "url";
        n.f(url, str);
        if (predefinedPlayer == null) {
            str = "Builder(appContext).build()";
            n.e(new e2.b(this.appContext).z(), str);
        }
        if (endTime == -1) {
            micros = Long.MIN_VALUE;
        } else {
            l = (long)endTime;
            micros = TimeUnit.SECONDS.toMicros(l);
        }
        final com.google.android.exoplayer2.source.hls.HlsMediaSource hlsMediaSource = new HlsMediaSource.Factory(this.goodExamplesCacheDataSourceFactory).a(m1.b(url));
        n.e(hlsMediaSource, "Factory(trickStepsCacheDataSourceFactory).createMediaSource(MediaItem.fromUri(url))");
        ClippingMediaSource url2 = new ClippingMediaSource(hlsMediaSource, TimeUnit.SECONDS.toMicros((long)startTime), l3, micros, obj2);
        e2Var.b1();
        if (e2Var != null) {
            float f = 0.0f;
            e2Var.g(f);
        }
        e2Var.q1(url2);
        e2Var.f();
        e2Var.J(2);
        e2Var.A(false);
        return e2Var;
    }
}
