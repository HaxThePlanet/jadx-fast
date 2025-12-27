package app.dogo.com.dogo_android.exam;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox.a;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.e.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import n.a.a;

/* compiled from: FrozenFrameFix.kt */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/exam/FrozenFrameFix;", "", "()V", "getFixedVideoFile", "Ljava/io/File;", "originalVideoFile", "performIfRequired", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class FrozenFrameFix {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final h.a INSTANCE = new h$a(0);

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/exam/FrozenFrameFix$Companion;", "", "()V", "SAMSUNG_DELTA", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    private final File getFixedVideoFile(File originalVideoFile) {
        return new File(originalVideoFile.getParentFile(), n.o(originalVideoFile.getName(), "_fixed.mp4"));
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final File performIfRequired(File originalVideoFile) {
        int i = 1;
        long l = 3000;
        long l2 = 30000;
        n.f(originalVideoFile, "originalVideoFile");
        com.googlecode.mp4parser.b bVar = new b(originalVideoFile);
        try {
            final f.b.a.d dVar = new d(bVar);
        } catch (Throwable th) {
        }
        try {
            List boxes = dVar.f().getBoxes(TrackBox.class);
            Iterator it2 = boxes.iterator();
            i = 0;
            while (it2.hasNext()) {
                Object item = (TrackBox)it2.next().getMediaBox().getMediaInformationBox().getSampleTableBox().getTimeToSampleBox().getEntries().get(i);
                long l3 = item.b();
                l2 = 30000L;
                if (l3 > l2) {
                    i = 1;
                    l = 3000L;
                    item.d(l);
                }
            }
            Throwable th2 = null;
            a.f("Frozen frame detected, attempting the fix", new Object[i]);
            c cVar = new c();
            Iterator it = boxes.iterator();
            while (it.hasNext()) {
                Object[] item2 = it.next();
                StringBuilder stringBuilder = new StringBuilder();
                String bVar3 = bVar.toString();
                long trackId = item2.getTrackHeaderBox().getTrackId();
                str = bVar3 + 91 + trackId + 93;
                cVar.a(new d(str, item2, new d[i]));
            }
            cVar.h(dVar.f().getMovieHeaderBox().getMatrix());
            final File fixedVideoFile = getFixedVideoFile(th);
            java.nio.channels.FileChannel channel = new RandomAccessFile(fixedVideoFile, "rw").getChannel();
        } catch (Throwable th) {
        }
        try {
            b.a(dVar, th2);
        } catch (Throwable th) {
        }
        b.a(bVar, th2);
        return th;
    }

}
