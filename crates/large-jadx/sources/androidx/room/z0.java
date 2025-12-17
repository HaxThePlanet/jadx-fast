package androidx.room;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.room.f1.a;
import androidx.room.f1.c;
import androidx.room.f1.d;
import d.s.a.g;
import d.s.a.h;
import d.s.a.h.a;
import d.s.a.h.b;
import d.s.a.h.b.a;
import d.s.a.l.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class z0 implements h, androidx.room.f0 {

    private final Context a;
    private final String b;
    private final File c;
    private final Callable<InputStream> v;
    private final int w;
    private final h x;
    private androidx.room.e0 y;
    private boolean z;

    class a extends h.a {
        a(androidx.room.z0 z0, int i2) {
            super(i2);
        }

        @Override // d.s.a.h$a
        public void d(g g) {
        }

        @Override // d.s.a.h$a
        public void f(g g) {
            final int i = this.a;
            if (i < 1) {
                g.setVersion(i);
            }
        }

        @Override // d.s.a.h$a
        public void g(g g, int i2, int i3) {
        }
    }
    z0(Context context, String string2, File file3, Callable<InputStream> callable4, int i5, h h6) {
        super();
        this.a = context;
        this.b = string2;
        this.c = file3;
        this.v = callable4;
        this.w = i5;
        this.x = h6;
    }

    private void a(File file, boolean z2) {
        Object channel;
        File parentFile;
        Object obj;
        java.nio.channels.FileChannel channel2;
        if (this.b != null) {
            channel = Channels.newChannel(this.a.getAssets().open(this.b));
            File tempFile = File.createTempFile("room-copy-helper", ".tmp", this.a.getCacheDir());
            tempFile.deleteOnExit();
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            d.a(channel, fileOutputStream.getChannel());
            parentFile = file.getParentFile();
            if (parentFile != null && parentFile.exists() == null) {
                if (parentFile.exists() == null) {
                    if (parentFile.mkdirs() == null) {
                    } else {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Failed to create directories for ");
                    stringBuilder2.append(file.getAbsolutePath());
                    IOException obj6 = new IOException(stringBuilder2.toString());
                    throw obj6;
                }
            }
            e(tempFile, z2);
            if (tempFile.renameTo(file) == null) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to move intermediate file (");
            stringBuilder.append(tempFile.getAbsolutePath());
            stringBuilder.append(") to destination (");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(").");
            obj6 = new IOException(stringBuilder.toString());
            throw obj6;
        } else {
            if (this.c != null) {
                FileInputStream fileInputStream = new FileInputStream(this.c);
                channel = fileInputStream.getChannel();
            } else {
                Callable callable = this.v;
                if (callable == null) {
                } else {
                    channel = Channels.newChannel((InputStream)callable.call());
                }
            }
        }
        IllegalStateException obj5 = new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
        throw obj5;
    }

    private h c(File file) {
        try {
            c cVar = new c();
            h.b.a aVar = h.b.a(this.a);
            aVar.c(file.getAbsolutePath());
            z0.a obj5 = new z0.a(this, Math.max(c.d(file), 1));
            aVar.b(obj5);
            return cVar.a(aVar.a());
            RuntimeException runtimeException = new RuntimeException("Malformed database file, unable to read version.", file);
            throw runtimeException;
        }
    }

    private void e(File file, boolean z2) {
        Object e0Var;
        g obj3;
        e0Var = this.y;
        if (e0Var != null) {
            if (e0Var.f == null) {
            } else {
                final h obj2 = c(file);
                if (z2 != null) {
                    obj3 = obj2.getWritableDatabase();
                } else {
                    obj3 = obj2.getReadableDatabase();
                }
            }
            e0Var2.f.a(obj3);
            obj2.close();
        }
    }

    private void i(boolean z) {
        String databaseName;
        Object databasePath;
        androidx.room.e0 e0Var;
        int i;
        String obj9;
        databaseName = getDatabaseName();
        databasePath = this.a.getDatabasePath(databaseName);
        e0Var = this.y;
        if (e0Var != null) {
            if (e0Var.m) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        a aVar = new a(databaseName, this.a.getFilesDir(), i);
        aVar.b();
        String str3 = "Unable to copy database file.";
        if (!databasePath.exists()) {
            a(databasePath, z);
            aVar.c();
        }
        if (this.y == null) {
            aVar.c();
        }
        int i2 = c.d(databasePath);
        final int i3 = this.w;
        if (i2 == i3) {
            aVar.c();
        }
        if (this.y.a(i2, i3)) {
            aVar.c();
        }
        if (this.a.deleteDatabase(databaseName)) {
            a(databasePath, z);
        } else {
            obj9 = new StringBuilder();
            obj9.append("Failed to delete database file (");
            obj9.append(databaseName);
            obj9.append(") for a copy destructive migration.");
            Log.w("ROOM", obj9.toString());
        }
        aVar.c();
    }

    @Override // d.s.a.h
    public void close() {
        this.x.close();
        this.z = false;
        return;
        synchronized (this) {
            this.x.close();
            this.z = false;
        }
    }

    @Override // d.s.a.h
    void f(androidx.room.e0 e0) {
        this.y = e0;
    }

    @Override // d.s.a.h
    public String getDatabaseName() {
        return this.x.getDatabaseName();
    }

    @Override // d.s.a.h
    public h getDelegate() {
        return this.x;
    }

    @Override // d.s.a.h
    public g getReadableDatabase() {
        boolean z;
        synchronized (this) {
            try {
                i(false);
                this.z = true;
                return this.x.getReadableDatabase();
                throw th;
            }
        }
    }

    @Override // d.s.a.h
    public g getWritableDatabase() {
        boolean z;
        synchronized (this) {
            try {
                z = 1;
                i(z);
                this.z = z;
                return this.x.getWritableDatabase();
                throw th;
            }
        }
    }

    @Override // d.s.a.h
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.x.setWriteAheadLoggingEnabled(z);
    }
}
