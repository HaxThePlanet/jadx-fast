package zendesk.support;

import com.google.gson.Gson;
import f.e.a.a;
import f.e.a.a.c;
import f.e.a.a.e;
import f.g.c.a;
import f.g.e.b;
import java.io.Closeable;
import java.lang.reflect.Type;
import l.q;

/* loaded from: classes3.dex */
public class SupportUiStorage {

    private static final int CACHE_INDEX = 0;
    private static final String LOG_TAG = "SupportUiStorage";
    public static final String REQUEST_MAPPER = "request_id_mapper";
    private final Gson gson;
    private final a storage;
    public SupportUiStorage(a a, Gson gson2) {
        super();
        this.storage = a;
        this.gson = gson2;
    }

    private static void abortEdit(a.c a$c) {
        int i;
        Object[] arr;
        Throwable obj4;
        a.k("SupportUiStorage", "Unable to cache data", new Object[0]);
        if (c != null) {
            c.a();
        }
    }

    static Gson access$000(zendesk.support.SupportUiStorage supportUiStorage) {
        return supportUiStorage.gson;
    }

    private static String key(String string) {
        return b.c(string);
    }

    public <E> E read(String string, Type type2) {
        final a storage = this.storage;
        SupportUiStorage.1 anon = new SupportUiStorage.1(this, type2);
        return Streams.use(this.storage.F(SupportUiStorage.key(string)), anon);
        synchronized (storage) {
            storage = this.storage;
            anon = new SupportUiStorage.1(this, type2);
            return Streams.use(this.storage.F(SupportUiStorage.key(string)), anon);
        }
    }

    public void write(String string, Object object2) {
        Object storage;
        Object obj4;
        int i = 0;
        storage = this.storage;
        a.c cVar = this.storage.x(SupportUiStorage.key(string));
        synchronized (storage) {
            i = 0;
            storage = this.storage;
            cVar = this.storage.x(SupportUiStorage.key(string));
        }
        try {
            Streams.toJson(this.gson, q.h(cVar.f(0)), object2);
            cVar.e();
            throw string;
            SupportUiStorage.abortEdit(obj0);
        } catch (Throwable th) {
        }
        try {
        }
    }
}
