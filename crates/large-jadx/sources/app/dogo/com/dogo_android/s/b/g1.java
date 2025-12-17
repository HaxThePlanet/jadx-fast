package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.repository.domain.DogLog.LogStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.o;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000c\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository;", "", "()V", "getDogLogStyles", "", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "tagColorRes", "", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "tagLetterColorRes", "tagStringRes", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g1 {

    public static final app.dogo.com.dogo_android.s.b.g1.a Companion;
    private static final DogLog.LogStyle a;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository$Companion;", "", "()V", "DEFAULT_LOG_STYLE", "Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "getDEFAULT_LOG_STYLE", "()Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "DEFAULT_STYLE_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final DogLog.LogStyle a() {
            return g1.a();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[e.PEE.ordinal()] = 1;
            iArr[e.POOP.ordinal()] = 2;
            iArr[e.EAT.ordinal()] = 3;
            iArr[e.DRINK.ordinal()] = 4;
            iArr[e.SLEEP.ordinal()] = 5;
            iArr[e.WALK.ordinal()] = 6;
            iArr[e.ACCIDENT_PEE.ordinal()] = 7;
            iArr[e.ACCIDENT_POOP.ordinal()] = 8;
            iArr[e.UNKNOWN_TYPE.ordinal()] = 9;
            g1.b.a = iArr;
        }
    }
    static {
        g1.a aVar = new g1.a(0);
        g1.Companion = aVar;
        final int i2 = 0;
        DogLog.LogStyle logStyle = new DogLog.LogStyle("unknown", i2, i2, i2);
        g1.a = logStyle;
    }

    public static final DogLog.LogStyle a() {
        return g1.a;
    }

    private final int c(e e) {
        int obj2;
        switch (obj2) {
            case 1:
                obj2 = 2131099772;
                break;
            case 2:
                obj2 = 2131099819;
                break;
            case 3:
                obj2 = 2131099818;
                break;
            case 4:
                obj2 = 2131099822;
                break;
            case 5:
                obj2 = 2131099823;
                break;
            case 6:
                obj2 = 2131099817;
                break;
            case 7:
                obj2 = 0;
                break;
            default:
                obj2 = new NoWhenBranchMatchedException();
                throw obj2;
        }
        return obj2;
    }

    private final int d(e e) {
        int i;
        i = 2131099821;
        switch (obj3) {
            case 1:
                i = i2;
                return i;
            case 2:
                return i;
            case 3:
                i = 2131100379;
                return i;
            case 4:
                i = 0;
                return i;
            default:
                NoWhenBranchMatchedException obj3 = new NoWhenBranchMatchedException();
                throw obj3;
        }
    }

    private final int e(e e) {
        int obj2;
        switch (obj2) {
            case 1:
                obj2 = 2131887031;
                break;
            case 2:
                obj2 = 2131887051;
                break;
            case 3:
                obj2 = 2131887271;
                break;
            case 4:
                obj2 = 2131887270;
                break;
            case 5:
                obj2 = 2131887275;
                break;
            case 6:
                obj2 = 2131887276;
                break;
            case 7:
                obj2 = 2131887029;
                break;
            case 8:
                obj2 = 2131887049;
                break;
            case 9:
                obj2 = 0;
                break;
            default:
                obj2 = new NoWhenBranchMatchedException();
                throw obj2;
        }
        return obj2;
    }

    public final Map<String, DogLog.LogStyle> b() {
        int i;
        int i4;
        o oVar;
        String tagId2;
        DogLog.LogStyle logStyle;
        String tagId;
        int i3;
        int i2;
        e[] values = e.values();
        ArrayList arrayList = new ArrayList(values.length);
        i = 0;
        while (i < values.length) {
            e eVar = values[i];
            logStyle = new DogLog.LogStyle(eVar.getTagId(), d(eVar), e(eVar), c(eVar));
            oVar = new o(eVar.getTagId(), logStyle);
            arrayList.add(oVar);
            i++;
        }
        return j0.s(arrayList);
    }
}
