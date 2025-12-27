package app.dogo.com.dogo_android.util;

import android.content.Context;
import com.google.android.exoplayer2.database.a;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.c;
import com.google.android.exoplayer2.upstream.cache.o;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.l.a;
import com.google.android.exoplayer2.upstream.p.b;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.upstream.s.b;
import com.google.android.exoplayer2.util.p0;
import java.io.File;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* compiled from: VideoPlayerFactory.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/util/VideoPlayerCacheDataSourceFactory;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "context", "Landroid/content/Context;", "dbProvider", "Lcom/google/android/exoplayer2/database/DatabaseProvider;", "cacheDirName", "", "maxCacheSize", "", "maxFileSize", "(Landroid/content/Context;Lcom/google/android/exoplayer2/database/DatabaseProvider;Ljava/lang/String;JJ)V", "cache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "defaultDatasourceFactory", "Lcom/google/android/exoplayer2/upstream/DefaultDataSourceFactory;", "createDataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b0, reason: from kotlin metadata */
final class VideoPlayerCacheDataSourceFactory implements l.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final b0.a INSTANCE = new b0$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final long cache;
    /* renamed from: b, reason: from kotlin metadata */
    private final r defaultDatasourceFactory;
    /* renamed from: c, reason: from kotlin metadata */
    private final o maxFileSize;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/VideoPlayerCacheDataSourceFactory$Companion;", "", "()V", "MAX_CACHE", "", "MAX_FILE", "MB", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public b0(Context context, a aVar, String str, long j, long j2) throws java.io.IOException {
        n.f(context, "context");
        n.f(aVar, "dbProvider");
        n.f(str, "cacheDirName");
        super();
        this.cache = j2;
        String str7 = p0.c0(context, "Dogo");
        n.e(str7, "getUserAgent(context, \"Dogo\")");
        com.google.android.exoplayer2.upstream.p pVar = new p.b(context).a();
        n.e(pVar, "Builder(context).build()");
        s.b bVar = new s.b();
        bVar.d(str7);
        bVar.c(pVar);
        n.e(bVar, "Factory()\n            .setUserAgent(userAgent)\n            .setTransferListener(bandwidthMeter)");
        this.defaultDatasourceFactory = new r(context, pVar, bVar);
        this.maxFileSize = new o(new File(context.getCacheDir(), str), new n(j, r6), aVar);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public l createDataSource() {
        c cVar = new c(this.maxFileSize, this.defaultDatasourceFactory.b(), new FileDataSource(), new CacheDataSink(this.maxFileSize, this.cache, r6), 3, null);
        return cVar;
    }

    public /* synthetic */ b0(Context context, a aVar, String str, long j, long j2, int i, g gVar) {
        int j42;
        int i62;
        j42 = i & 8;
        j42 = i & 8 != 0 ? j42 : j;
        i62 = i & 16;
        i62 = i & 16 != 0 ? i62 : j2;
        this(context, aVar, str, j42, l, i62, obj);
    }

}
