package d.s.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes.dex */
public interface g extends Closeable {
    @Override // java.io.Closeable
    public abstract void C(String string);

    @Override // java.io.Closeable
    public abstract boolean F1();

    @Override // java.io.Closeable
    public abstract Cursor H0(String string);

    @Override // java.io.Closeable
    public abstract d.s.a.k O(String string);

    @Override // java.io.Closeable
    public abstract long P0(String string, int i2, ContentValues contentValues3);

    @Override // java.io.Closeable
    public abstract void beginTransaction();

    @Override // java.io.Closeable
    public abstract void endTransaction();

    @Override // java.io.Closeable
    public abstract Cursor f0(d.s.a.j j, CancellationSignal cancellationSignal2);

    @Override // java.io.Closeable
    public abstract String getPath();

    @Override // java.io.Closeable
    public abstract boolean isOpen();

    @Override // java.io.Closeable
    public abstract Cursor j1(d.s.a.j j);

    @Override // java.io.Closeable
    public abstract boolean q1();

    @Override // java.io.Closeable
    public abstract void setTransactionSuccessful();

    @Override // java.io.Closeable
    public abstract void setVersion(int i);

    @Override // java.io.Closeable
    public abstract void x0();

    @Override // java.io.Closeable
    public abstract int y0(String string, int i2, ContentValues contentValues3, String string4, Object[] object5Arr5);

    public abstract List<Pair<String, String>> z();
}
