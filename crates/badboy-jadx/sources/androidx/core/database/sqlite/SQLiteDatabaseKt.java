package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"transaction", "T", "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase $this$transaction, boolean exclusive, Function1<? super SQLiteDatabase, ? extends T> body) {
        final int i = 0;
        if (exclusive) {
            $this$transaction.beginTransaction();
        } else {
            $this$transaction.beginTransactionNonExclusive();
        }
        final Object invoke = body.invoke($this$transaction);
        $this$transaction.setTransactionSuccessful();
        $this$transaction.endTransaction();
        final Object obj = invoke;
        return invoke;
    }

    public static Object transaction$default(SQLiteDatabase $this$transaction_u24default, boolean exclusive, Function1 body, int i4, Object object5) {
        int obj2;
        if (i4 &= 1 != 0) {
            obj2 = 1;
        }
        int obj4 = 0;
        if (obj2 != null) {
            $this$transaction_u24default.beginTransaction();
        } else {
            $this$transaction_u24default.beginTransactionNonExclusive();
        }
        final Object obj5 = body.invoke($this$transaction_u24default);
        $this$transaction_u24default.setTransactionSuccessful();
        $this$transaction_u24default.endTransaction();
        final Object obj = obj5;
        return obj5;
    }
}
