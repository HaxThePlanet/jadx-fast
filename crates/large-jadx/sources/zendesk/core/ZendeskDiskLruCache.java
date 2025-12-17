package zendesk.core;

import f.e.a.a;
import f.e.a.a.c;
import f.e.a.a.e;
import f.g.c.a;
import f.g.e.a;
import f.g.e.b;
import f.g.e.g;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import l.d0;
import l.g;
import l.h;
import l.q;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
class ZendeskDiskLruCache implements zendesk.core.BaseStorage {

    private static final int CACHE_INDEX = 0;
    private static final int ITEMS_PER_KEY = 1;
    private static final String LOG_TAG = "DiskLruStorage";
    private static final int VERSION_ONE = 1;
    private final File directory;
    private final long maxSize;
    private final zendesk.core.Serializer serializer;
    private a storage;
    ZendeskDiskLruCache(File file, long l2, a a3, zendesk.core.Serializer serializer4) {
        super();
        this.directory = file;
        this.maxSize = l2;
        this.storage = serializer4;
        this.serializer = obj5;
    }

    ZendeskDiskLruCache(File file, zendesk.core.Serializer serializer2, int i3) {
        super();
        this.directory = file;
        final long l = (long)i3;
        this.maxSize = l;
        this.storage = openCache(file, l);
        this.serializer = serializer2;
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
        try {
        }
    }

    private String getString(String string, int i2) {
        int i;
        Throwable th;
        a storage;
        String str;
        String str2;
        int arr;
        int i4;
        int obj7;
        int obj8;
        obj7 = this.storage.F(key(string));
        if (obj7 != null) {
            try {
                obj7 = q.l(obj7.a(i2));
                i = obj7;
                obj7 = i4;
                int i3 = i2;
                i2 = i4;
                i2 = i3;
                obj8 = obj7;
                close(i);
                close(obj8);
                i2 = i3;
                i3 = string;
                string = i2;
                string = i3;
                i2 = string;
                arr = 0;
                arr = new Object[arr];
                a.j("DiskLruStorage", "Unable to read from cache", th, arr);
                close(string);
                close(i2);
                return obj7;
                close(string);
                close(i2);
                throw i3;
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        } else {
        }
    }

    private String key(String string) {
        return b.c(string);
    }

    private String keyMediaType(String string) {
        Object[] arr = new Object[1];
        return key(String.format(Locale.US, "%s_content_type", string));
    }

    private a openCache(File file, long l2) {
        int i;
        a obj2;
        int obj3;
        long obj4;
        i = 1;
        obj2 = a.K(file, i, i, l2);
        return obj2;
    }

    private void putString(String string, int i2, String string3) {
        ByteArrayInputStream byteArrayInputStream;
        String obj2;
        int obj3;
        d0 obj4;
        try {
            byteArrayInputStream = new ByteArrayInputStream(string3.getBytes("UTF-8"));
            write(string, i2, q.l(byteArrayInputStream));
            i2 = 0;
            i2 = new Object[i2];
            string3 = "DiskLruStorage";
            a.j(string3, "Unable to encode string", string, i2);
        }
    }

    private void write(String string, int i2, d0 d03) {
        int i;
        File directory;
        a storage;
        int arr;
        a.c obj5;
        int obj6;
        directory = this.directory;
        obj5 = this.storage.x(key(string));
        synchronized (directory) {
            directory = this.directory;
            obj5 = this.storage.x(key(string));
        }
        try {
            i = q.c(q.h(obj5.f(i2)));
            i.W0(d03);
            i.flush();
            obj5.e();
            obj6 = i;
        } catch (Throwable th) {
        }
        close(i);
        close(obj6);
        close(d03);
    }

    @Override // zendesk.core.BaseStorage
    public void clear() {
        a storage;
        File exists;
        String cache;
        String maxSize;
        int arr;
        int i;
        a storage2 = this.storage;
        if (storage2 == null) {
        }
        if (storage2.H() != null && this.storage.H().exists() != null && a.j(this.storage.H().listFiles()) != null) {
            if (this.storage.H().exists() != null) {
                if (a.j(this.storage.H().listFiles()) != null) {
                    try {
                        this.storage.r();
                        this.storage.close();
                        this.storage = openCache(this.directory, this.maxSize);
                        cache = "DiskLruStorage";
                        maxSize = "Error clearing cache. Error: %s";
                        arr = 1;
                        arr = new Object[arr];
                        Throwable message = message.getMessage();
                        arr[0] = message;
                        a.b(cache, maxSize, arr);
                        cache = this.directory;
                        maxSize = this.maxSize;
                        cache = openCache(cache, maxSize);
                        this.storage = cache;
                        throw message;
                    } catch (Throwable th) {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    public <E> E get(String string, Class<E> class2) {
        Object serializer;
        int deserialize;
        int i;
        long l;
        int obj6;
        Object obj7;
        deserialize = 0;
        if (this.storage == null) {
            return deserialize;
        }
        i = 0;
        if (class2.equals(ResponseBody.class)) {
            obj7 = this.storage.F(key(string));
            if (obj7 != null) {
                obj6 = getString(keyMediaType(string), i);
                if (g.c(obj6)) {
                    obj6 = MediaType.parse(obj6);
                } else {
                    obj6 = deserialize;
                }
                deserialize = obj6;
            }
        } else {
            deserialize = this.serializer.deserialize(getString(string, i), class2);
        }
        return deserialize;
    }

    @Override // zendesk.core.BaseStorage
    public String get(String string) {
        if (this.storage == null) {
            return null;
        }
        return getString(string, 0);
    }

    @Override // zendesk.core.BaseStorage
    public void put(String string, Object object2) {
        h serialize;
        int i;
        String obj3;
        Object obj4;
        if (this.storage == null) {
        }
        if (object2 instanceof ResponseBody) {
            i = 0;
            write(string, i, (ResponseBody)object2.source());
            putString(keyMediaType(string), i, object2.contentType().toString());
        } else {
            serialize = 0;
            if (object2 != null) {
                serialize = this.serializer.serialize(object2);
            }
            put(string, serialize);
        }
    }

    @Override // zendesk.core.BaseStorage
    public void put(String string, String string2) {
        a storage;
        if (this.storage != null) {
            if (g.e(string2)) {
            } else {
                putString(string, 0, string2);
            }
        }
    }

    @Override // zendesk.core.BaseStorage
    public void remove(String string) {
    }
}
