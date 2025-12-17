package androidx.room.f1;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import androidx.room.u0;
import d.s.a.b;
import d.s.a.g;
import d.s.a.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c {
    public static CancellationSignal a() {
        if (Build.VERSION.SDK_INT >= 16) {
            return b.b();
        }
        return null;
    }

    public static void b(g g) {
        Cursor string;
        String string2;
        boolean stringBuilder;
        String str;
        ArrayList arrayList = new ArrayList();
        string = g.H0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (string.moveToNext()) {
            arrayList.add(string.getString(0));
        }
        string.close();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            string = iterator.next();
            if ((String)string.startsWith("room_fts_content_sync_")) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("DROP TRIGGER IF EXISTS ");
            stringBuilder.append(string);
            g.C(stringBuilder.toString());
        }
    }

    public static Cursor c(u0 u0, j j2, boolean z3, CancellationSignal cancellationSignal4) {
        int sDK_INT;
        int i;
        Cursor obj2;
        j obj3;
        int obj4;
        int obj5;
        obj2 = u0.B(j2, cancellationSignal4);
        if (z3 != 0 && obj2 instanceof AbstractWindowedCursor != null) {
            if (obj2 instanceof AbstractWindowedCursor != null) {
                obj3 = obj2;
                obj4 = (AbstractWindowedCursor)obj3.getCount();
                if (obj3.hasWindow()) {
                    obj5 = obj3.getWindow().getNumRows();
                } else {
                    obj5 = obj4;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    if (obj5 < obj4) {
                        obj2 = b.a(obj3);
                    }
                } else {
                }
            }
        }
        return obj2;
    }

    public static int d(File file) {
        int i = 4;
        int i2 = 0;
        final ByteBuffer allocate = ByteBuffer.allocate(i);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        final FileChannel fileChannel = channel;
        fileChannel.tryLock(60, obj6, true);
        channel.position(60);
        if (channel.read(allocate) != i) {
        } else {
            allocate.rewind();
            if (channel != null) {
                try {
                    channel.close();
                    return allocate.getInt();
                    IOException obj10 = new IOException("Bad database header, unable to read 4 bytes at offset 60");
                    throw obj10;
                    if (obj1 == null) {
                    } else {
                    }
                    obj1.close();
                    throw file;
                }
            }
        }
    }
}
