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
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.b;
import com.googlecode.mp4parser.e.c;
import com.googlecode.mp4parser.e.d;
import f.b.a.d;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/exam/FrozenFrameFix;", "", "()V", "getFixedVideoFile", "Ljava/io/File;", "originalVideoFile", "performIfRequired", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h {

    public static final app.dogo.com.dogo_android.exam.h.a Companion;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/exam/FrozenFrameFix$Companion;", "", "()V", "SAMSUNG_DELTA", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        h.a aVar = new h.a(0);
        h.Companion = aVar;
    }

    private final File a(File file) {
        File file2 = new File(file.getParentFile(), n.o(file.getName(), "_fixed.mp4"));
        return file2;
    }

    public final File b(File file) {
        int i;
        Object obj;
        Object[] next;
        int dVar;
        String string;
        int arr;
        n.f(file, "originalVideoFile");
        b bVar = new b(file);
        d dVar2 = new d(bVar);
        List boxes = dVar2.f().getBoxes(TrackBox.class);
        Iterator iterator2 = boxes.iterator();
        int i3 = 0;
        i = i3;
        while (iterator2.hasNext()) {
            obj = (TrackBox)iterator2.next().getMediaBox().getMediaInformationBox().getSampleTableBox().getTimeToSampleBox().getEntries().get(i3);
            if (Long.compare(l, arr) > 0) {
            }
            i = 1;
            obj.d(3000);
        }
        int i2 = 0;
        if (i != 0) {
            a.f("Frozen frame detected, attempting the fix", new Object[i3]);
            c cVar = new c();
            Iterator iterator = boxes.iterator();
            for (TrackBox next : iterator) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bVar.toString());
                stringBuilder.append('[');
                stringBuilder.append(next.getTrackHeaderBox().getTrackId());
                stringBuilder.append(']');
                dVar = new d(stringBuilder.toString(), next, new d[i3]);
                cVar.a(dVar);
            }
            cVar.h(dVar2.f().getMovieHeaderBox().getMatrix());
            DefaultMp4Builder defaultMp4Builder = new DefaultMp4Builder();
            final File obj12 = a(file);
            RandomAccessFile randomAccessFile = new RandomAccessFile(obj12, "rw");
            java.nio.channels.FileChannel channel = randomAccessFile.getChannel();
            defaultMp4Builder.b(cVar).writeContainer(channel);
            b.a(channel, i2);
            b.a(dVar2, i2);
            b.a(bVar, i2);
            return obj12;
        }
        w wVar = w.a;
        b.a(dVar2, i2);
        b.a(bVar, i2);
        return file;
    }
}
