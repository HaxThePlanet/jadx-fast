package zendesk.support;

import com.google.gson.Gson;
import f.g.c.a;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import l.b0;
import l.d0;
import l.g;
import l.h;
import l.q;

/* loaded from: classes3.dex */
public class Streams {

    public interface Use {
        public abstract R use(P p);
    }
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static <T> T fromJson(Gson gson, d0 d02, Type type3) {
        Streams.1 anon = new Streams.1(gson, type3);
        return Streams.use(Streams.toReader(d02), anon);
    }

    public static void toJson(Gson gson, b0 b02, Object object3) {
        Streams.2 anon = new Streams.2(gson, object3);
        Streams.use(Streams.toWriter(b02), anon);
    }

    public static Reader toReader(d0 d0) {
        if (d0 instanceof h) {
            InputStreamReader inputStreamReader = new InputStreamReader((h)d0.g2());
            return inputStreamReader;
        }
        InputStreamReader inputStreamReader2 = new InputStreamReader(q.d(d0).g2());
        return inputStreamReader2;
    }

    public static Writer toWriter(b0 b0) {
        if (b0 instanceof g) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((g)b0.b2());
            return outputStreamWriter;
        }
        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(q.c(b0).b2());
        return outputStreamWriter2;
    }

    public static <R, P extends Closeable> R use(P p, zendesk.support.Streams.Use<R, P> streams$Use2) {
        if (p == null) {
            return 0;
        }
        Streams.closeQuietly(p);
        return use2.use(p);
    }
}
