package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public class AtomicFile {

    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;
    public AtomicFile(File baseName) {
        super();
        this.mBaseName = baseName;
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(stringBuilder.append(baseName.getPath()).append(".new").toString());
        this.mNewName = file;
        StringBuilder stringBuilder2 = new StringBuilder();
        File file2 = new File(stringBuilder2.append(baseName.getPath()).append(".bak").toString());
        this.mLegacyBackupName = file2;
    }

    private static void rename(File source, File target) {
        boolean directory;
        boolean renameTo;
        String str;
        final String str2 = "AtomicFile";
        if (target.isDirectory() != null && !target.delete()) {
            if (!target.delete()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                Log.e(str2, stringBuilder2.append("Failed to delete file which is a directory ").append(target).toString());
            }
        }
        if (!source.renameTo(target)) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.e(str2, stringBuilder.append("Failed to rename ").append(source).append(" to ").append(target).toString());
        }
    }

    private static boolean sync(FileOutputStream stream) {
        try {
            stream.getFD().sync();
            return 1;
            return null;
        }
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(FileOutputStream str) {
        boolean sync;
        boolean delete;
        String mNewName;
        if (str == null) {
        }
        final String str2 = "AtomicFile";
        if (AtomicFile.sync(str) == null) {
            Log.e(str2, "Failed to sync file output stream");
        }
        str.close();
        if (!this.mNewName.delete()) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.e(str2, stringBuilder.append("Failed to delete new file ").append(this.mNewName).toString());
        }
    }

    public void finishWrite(FileOutputStream str) {
        boolean sync;
        String str2;
        if (str == null) {
        }
        if (AtomicFile.sync(str) == null) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        str.close();
        AtomicFile.rename(this.mNewName, this.mBaseName);
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        boolean mLegacyBackupName;
        boolean exists;
        File mBaseName;
        if (this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }
        if (this.mNewName.exists() && this.mBaseName.exists() && !this.mNewName.delete()) {
            if (this.mBaseName.exists()) {
                if (!this.mNewName.delete()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    Log.e("AtomicFile", stringBuilder.append("Failed to delete outdated new file ").append(this.mNewName).toString());
                }
            }
        }
        FileInputStream fileInputStream = new FileInputStream(this.mBaseName);
        return fileInputStream;
    }

    public byte[] readFully() throws IOException {
        int pos;
        int avail;
        byte[] data;
        int read;
        int bArr;
        int i;
        final FileInputStream read2 = openRead();
        pos = 0;
        data = new byte[read2.available()];
        read = read2.read(data, pos, length -= pos);
        while (read <= 0) {
            pos += read;
            avail = available;
            if (avail > length2 -= pos) {
            }
            read = read2.read(data, pos, length -= pos);
            bArr = new byte[pos + avail];
            i = 0;
            System.arraycopy(data, i, bArr, i, pos);
            data = bArr;
        }
        read2.close();
        return data;
    }

    public FileOutputStream startWrite() throws IOException {
        boolean mLegacyBackupName;
        File parentFile;
        if (this.mLegacyBackupName.exists()) {
            AtomicFile.rename(this.mLegacyBackupName, this.mBaseName);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.mNewName);
        return fileOutputStream;
    }
}
