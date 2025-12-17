package androidx.room.f1;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public class b {
    public static Cursor a(Cursor cursor) {
        String[] columnNames;
        int count;
        int columnCount;
        int i;
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                columnNames = new Object[cursor.getColumnCount()];
                count = 0;
                while (count < cursor.getColumnCount()) {
                    int type = cursor.getType(count);
                    columnNames[count] = 0;
                    count++;
                    i = 1;
                    columnNames[count] = Long.valueOf(cursor.getLong(count));
                    i = 2;
                    columnNames[count] = Double.valueOf(cursor.getDouble(count));
                    columnNames[count] = cursor.getString(count);
                    columnNames[count] = cursor.getBlob(count);
                }
                matrixCursor.addRow(columnNames);
                type = cursor.getType(count);
                columnNames[count] = 0;
                count++;
                i = 1;
                columnNames[count] = Long.valueOf(cursor.getLong(count));
                i = 2;
                columnNames[count] = Double.valueOf(cursor.getDouble(count));
                columnNames[count] = cursor.getString(count);
                columnNames[count] = cursor.getBlob(count);
            }
            columnNames = new Object[cursor.getColumnCount()];
            count = 0;
            while (count < cursor.getColumnCount()) {
                type = cursor.getType(count);
                columnNames[count] = 0;
                count++;
                i = 1;
                columnNames[count] = Long.valueOf(cursor.getLong(count));
                i = 2;
                columnNames[count] = Double.valueOf(cursor.getDouble(count));
                columnNames[count] = cursor.getString(count);
                columnNames[count] = cursor.getBlob(count);
            }
            type = cursor.getType(count);
            if (type != null) {
            } else {
            }
            i = 1;
            if (type != i) {
            } else {
            }
            i = 2;
            if (type != i) {
            } else {
            }
            if (type != 3) {
            } else {
            }
            if (type != 4) {
            } else {
            }
            columnNames[count] = cursor.getBlob(count);
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
            columnNames[count] = cursor.getString(count);
            columnNames[count] = Double.valueOf(cursor.getDouble(count));
            columnNames[count] = Long.valueOf(cursor.getLong(count));
            columnNames[count] = 0;
            count++;
            matrixCursor.addRow(columnNames);
            cursor.close();
            return matrixCursor;
            cursor.close();
            throw th;
        }
    }

    private static int b(Cursor cursor, String string2) {
        final int i = -1;
        if (Build.VERSION.SDK_INT > 25) {
            return i;
        }
        if (string2.length() == 0) {
            return i;
        }
        return b.c(cursor.getColumnNames(), string2);
    }

    static int c(String[] stringArr, String string2) {
        int i2;
        Object endsWith;
        int charAt;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        String str = ".";
        stringBuilder.append(str);
        stringBuilder.append(string2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(string2);
        stringBuilder2.append("`");
        int i3 = 0;
        i2 = i3;
        for (Object endsWith : stringArr) {
        }
        return -1;
    }

    public static int d(Cursor cursor, String string2) {
        int columnIndex = cursor.getColumnIndex(string2);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "`";
        stringBuilder.append(str);
        stringBuilder.append(string2);
        stringBuilder.append(str);
        int columnIndex2 = cursor.getColumnIndex(stringBuilder.toString());
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return b.b(cursor, string2);
    }

    public static int e(Cursor cursor, String string2) {
        int i;
        String str;
        String obj3;
        i = b.d(cursor, string2);
        if (i >= 0) {
            return i;
        }
        obj3 = Arrays.toString(cursor.getColumnNames());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("column '");
        stringBuilder.append(string2);
        stringBuilder.append("' does not exist. Available columns: ");
        stringBuilder.append(obj3);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
