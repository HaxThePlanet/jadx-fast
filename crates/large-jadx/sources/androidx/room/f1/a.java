package androidx.room.f1;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class a {

    private static final Map<String, Lock> e;
    private final File a;
    private final Lock b;
    private final boolean c;
    private FileChannel d;
    static {
        HashMap hashMap = new HashMap();
        a.e = hashMap;
    }

    public a(String string, File file2, boolean z3) {
        super();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(".lck");
        File file = new File(file2, stringBuilder.toString());
        this.a = file;
        this.b = a.a(file.getAbsolutePath());
        this.c = z3;
    }

    private static Lock a(String string) {
        Object reentrantLock;
        final Map map = a.e;
        synchronized (map) {
            reentrantLock = new ReentrantLock();
            map.put(string, reentrantLock);
            return reentrantLock;
        }
    }

    public void b() {
        boolean channel;
        Object illegalStateException;
        this.b.lock();
        if (this.c) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.a);
            channel = fileOutputStream.getChannel();
            this.d = channel;
            channel.lock();
        }
    }

    public void c() {
        FileChannel fileChannel = this.d;
        if (fileChannel != null) {
            fileChannel.close();
        }
        this.b.unlock();
    }
}
