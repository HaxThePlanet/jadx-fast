package app.dogo.com.dogo_android.util;

import android.content.Context;
import com.google.android.exoplayer2.database.a;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.c;
import com.google.android.exoplayer2.upstream.cache.n;
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
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/util/VideoPlayerCacheDataSourceFactory;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "context", "Landroid/content/Context;", "dbProvider", "Lcom/google/android/exoplayer2/database/DatabaseProvider;", "cacheDirName", "", "maxCacheSize", "", "maxFileSize", "(Landroid/content/Context;Lcom/google/android/exoplayer2/database/DatabaseProvider;Ljava/lang/String;JJ)V", "cache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "defaultDatasourceFactory", "Lcom/google/android/exoplayer2/upstream/DefaultDataSourceFactory;", "createDataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class b0 implements l.a {

    public static final app.dogo.com.dogo_android.util.b0.a Companion;
    private final long a;
    private final r b;
    private final o c;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/VideoPlayerCacheDataSourceFactory$Companion;", "", "()V", "MAX_CACHE", "", "MAX_FILE", "MB", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        b0.a aVar = new b0.a(0);
        b0.Companion = aVar;
    }

    public b0(Context context, a a2, String string3, long l4, long l5) {
        n.f(context, "context");
        n.f(a2, "dbProvider");
        n.f(string3, "cacheDirName");
        super();
        this.a = obj7;
        String obj7 = p0.c0(context, "Dogo");
        n.e(obj7, "getUserAgent(context, \"Dogo\")");
        p.b obj8 = new p.b(context);
        obj8 = obj8.a();
        n.e(obj8, "Builder(context).build()");
        s.b bVar = new s.b();
        bVar.d(obj7);
        bVar.c(obj8);
        n.e(bVar, "Factory()\n            .setUserAgent(userAgent)\n            .setTransferListener(bandwidthMeter)");
        obj7 = new r(context, obj8, bVar);
        this.b = obj7;
        obj8 = new File(context.getCacheDir(), string3);
        n obj2 = new n(l4, l5);
        obj7 = new o(obj8, obj2, a2);
        this.c = obj7;
    }

    public b0(Context context, a a2, String string3, long l4, long l5, int i6, g g7) {
        int i2;
        int i4;
        int i;
        int i3;
        i = obj18 & 8 != 0 ? i2 : l4;
        i3 = obj18 & 16 != 0 ? i4 : i6;
        super(context, a2, string3, i, obj7, i3, obj9);
    }

    @Override // com.google.android.exoplayer2.upstream.l$a
    public l a() {
        FileDataSource fileDataSource = new FileDataSource();
        CacheDataSink cacheDataSink = new CacheDataSink(this.c, this.a, obj6);
        super(this.c, this.b.b(), fileDataSource, cacheDataSink, 3, 0);
        return cVar2;
    }
}
