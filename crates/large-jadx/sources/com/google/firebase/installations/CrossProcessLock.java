package com.google.firebase.installations;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* loaded from: classes2.dex */
class CrossProcessLock {

    private static final String TAG = "CrossProcessLock";
    private final FileChannel channel;
    private final FileLock lock;
    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock2) {
        super();
        this.channel = fileChannel;
        this.lock = fileLock2;
    }

    static com.google.firebase.installations.CrossProcessLock acquire(Context context, String string2) {
        Throwable th;
        String str2;
        String str;
        final int i = 0;
        File file = new File(context.getFilesDir(), string2);
        RandomAccessFile obj4 = new RandomAccessFile(file, "rw");
        obj4 = obj4.getChannel();
        CrossProcessLock crossProcessLock = new CrossProcessLock(obj4, obj4.lock());
        return crossProcessLock;
    }

    void releaseAndClose() {
        FileChannel channel;
        String str2;
        String str;
        try {
            this.lock.release();
            this.channel.close();
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", th);
        }
    }
}
