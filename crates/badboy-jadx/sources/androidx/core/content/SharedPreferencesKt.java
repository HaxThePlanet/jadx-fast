package androidx.core.content;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0008H\u0087\u0008¨\u0006\t", d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharedPreferencesKt {
    public static final void edit(SharedPreferences $this$edit, boolean commit, Function1<? super SharedPreferences.Editor, Unit> action) {
        final int i = 0;
        final SharedPreferences.Editor edit = $this$edit.edit();
        action.invoke(edit);
        if (commit) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static void edit$default(SharedPreferences $this$edit_u24default, boolean commit, Function1 action, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        int obj3 = 0;
        final SharedPreferences.Editor obj4 = $this$edit_u24default.edit();
        action.invoke(obj4);
        if (obj1 != null) {
            obj4.commit();
        } else {
            obj4.apply();
        }
    }
}
