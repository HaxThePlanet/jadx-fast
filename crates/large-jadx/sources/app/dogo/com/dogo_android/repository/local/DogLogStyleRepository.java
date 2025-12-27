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

/* compiled from: DogLogStyleRepository.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000c\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository;", "", "()V", "getDogLogStyles", "", "", "Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "tagColorRes", "", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "tagLetterColorRes", "tagStringRes", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g1, reason: from kotlin metadata */
public final class DogLogStyleRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final g1.a INSTANCE = new g1$a(0);
    private static final DogLog.LogStyle a = new DogLog$LogStyle("unknown", 0, 0, 0);

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository$Companion;", "", "()V", "DEFAULT_LOG_STYLE", "Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "getDEFAULT_LOG_STYLE", "()Lapp/dogo/com/dogo_android/repository/domain/DogLog$LogStyle;", "DEFAULT_STYLE_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public final DogLog.LogStyle a() {
            return DogLogStyleRepository.a;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DogLogTypes.values().length];
            iArr[DogLogTypes.PEE.ordinal()] = 1;
            iArr[DogLogTypes.POOP.ordinal()] = 2;
            iArr[DogLogTypes.EAT.ordinal()] = 3;
            iArr[DogLogTypes.DRINK.ordinal()] = 4;
            iArr[DogLogTypes.SLEEP.ordinal()] = 5;
            iArr[DogLogTypes.WALK.ordinal()] = 6;
            iArr[DogLogTypes.ACCIDENT_PEE.ordinal()] = 7;
            iArr[DogLogTypes.ACCIDENT_POOP.ordinal()] = 8;
            iArr[DogLogTypes.UNKNOWN_TYPE.ordinal()] = 9;
            app.dogo.com.dogo_android.repository.local.g1.b.a = iArr;
        }
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ DogLog.LogStyle getDogLogStyles() {
        return DogLogStyleRepository.a;
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final int tagColorRes(e type) throws NoWhenBranchMatchedException {
        int i = 2131099819;
        switch (app.dogo.com.dogo_android.repository.local.g1.b.a[type.ordinal()]) {
            case 1: /* ordinal */
                i = 2131099772;
                break;
            case 2: /* ordinal */
                i = 2131099819;
                break;
            case 3: /* ordinal */
                i = 2131099818;
                break;
            case 4: /* ordinal */
                i = 2131099822;
                break;
            case 5: /* ordinal */
                i = 2131099823;
                break;
            case 6: /* ordinal */
                i = 2131099817;
                break;
            case 7: /* ordinal */
                i = 0;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return i;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final int tagLetterColorRes(e type) throws NoWhenBranchMatchedException {
        int i = 2131099821;
        i = 2131099821;
        switch (app.dogo.com.dogo_android.repository.local.g1.b.a[type.ordinal()]) {
            case 1: /* ordinal */
                i = R.color.dog_log_pee_tag;
                return i;
            case 2: /* ordinal */
                return i;
            case 3: /* ordinal */
                i = 2131100379;
                return i;
            case 4: /* ordinal */
                i = 0;
                return i;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final int tagStringRes(e type) throws NoWhenBranchMatchedException {
        int i = 2131887270;
        switch (app.dogo.com.dogo_android.repository.local.g1.b.a[type.ordinal()]) {
            case 1: /* ordinal */
                i = 2131887031;
                break;
            case 2: /* ordinal */
                i = 2131887051;
                break;
            case 3: /* ordinal */
                i = 2131887271;
                break;
            case 4: /* ordinal */
                i = 2131887270;
                break;
            case 5: /* ordinal */
                i = 2131887275;
                break;
            case 6: /* ordinal */
                i = 2131887276;
                break;
            case 7: /* ordinal */
                i = 2131887029;
                break;
            case 8: /* ordinal */
                i = 2131887049;
                break;
            case 9: /* ordinal */
                i = 0;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return i;
    }

    public final Map<String, DogLog.LogStyle> b() {
        int i = 0;
        e[] values = DogLogTypes.values();
        final ArrayList arrayList = new ArrayList(values.length);
        i = 0;
        for (e eVar : values) {
            arrayList.add(new Pair(eVar.getTagId(), new DogLog_LogStyle(eVar.getTagId(), tagLetterColorRes(eVar), tagStringRes(eVar), tagColorRes(eVar))));
        }
        return j0.s(arrayList);
    }
}
