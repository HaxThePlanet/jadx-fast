package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\u0008\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... pairs) {
        int i;
        Object component2;
        Object component1;
        Object obj;
        ContentValues contentValues = new ContentValues(pairs.length);
        ContentValues contentValues2 = contentValues;
        final int i2 = 0;
        i = 0;
        while (i < pairs.length) {
            Object obj2 = pairs[i];
            component1 = obj2.component1();
            component2 = obj2.component2();
            contentValues2.put((String)component1, (Short)component2);
            i++;
            contentValues2.put(component1, (Byte)component2);
            contentValues2.put(component1, (byte[])component2);
            contentValues2.put(component1, (Double)component2);
            contentValues2.put(component1, (Float)component2);
            contentValues2.put(component1, (Boolean)component2);
            contentValues2.put(component1, (Long)component2);
            contentValues2.put(component1, (Integer)component2);
            contentValues2.put(component1, (String)component2);
            contentValues2.putNull(component1);
        }
        return contentValues;
    }
}
