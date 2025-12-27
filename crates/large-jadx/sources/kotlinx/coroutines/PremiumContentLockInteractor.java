package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: PremiumContentLockInteractor.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PremiumContentLockInteractor;", "", "()V", "unlockFirstUnlockedExam", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "examList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i3, reason: from kotlin metadata */
public final class PremiumContentLockInteractor {
    /* renamed from: a, reason: from kotlin metadata */
    public final List<ProgramExam> unlockFirstUnlockedExam(List<ProgramExam> examList) {
        Object item = null;
        int i;
        int i2;
        int i3 = 1;
        boolean hasNext = true;
        Object item3;
        Object item4;
        long value;
        ProgramExam.Status status;
        boolean hasNext2;
        ProgramExam.Status rEADY2;
        String str;
        String str2;
        int cmp;
        String str3 = null;
        String str4 = null;
        ProgramExam.Status pREMIUM_LOCKED2;
        ProgramExam.Status pREMIUM_LOCKED22;
        ProgramExam.Status status2;
        ProgramExam.Status status3;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i4;
        int i5;
        long l;
        long l2;
        Boolean bool;
        Boolean bool2;
        Long l3;
        Long l4;
        String str11;
        String str12;
        String str13;
        String str14;
        Long l5;
        Long l6;
        String str15;
        String str16;
        String str17;
        String str18;
        boolean z;
        boolean z2;
        Boolean bool3;
        Boolean bool4;
        int i6;
        int i7;
        Object obj;
        Object obj2;
        int i8;
        int i9;
        Object examList2 = examList;
        n.f(examList2, "examList");
        ArrayList arrayList = new ArrayList();
        Iterator it3 = examList.iterator();
        i3 = 0;
        while (it3.hasNext()) {
            Object item2 = it3.next();
        }
        if (arrayList.isEmpty()) {
            return examList2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = examList.iterator();
        while (it5.hasNext()) {
            status = it5.next();
            int r7 = (ProgramExam)status.getUnlockDate() != null ? 1 : i3;
        }
        Iterator it4 = arrayList3.iterator();
        if (!it4.hasNext()) {
            int i10 = 0;
        } else {
            if (it4.hasNext()) {
                Long unlockDate = (ProgramExam)item.getUnlockDate();
                n.d(unlockDate);
                value = unlockDate.longValue();
                item = it4.next();
                Long unlockDate3 = (ProgramExam)item.getUnlockDate();
                n.d(unlockDate3);
                long value2 = unlockDate3.longValue();
                do {
                    item = it4.next();
                    unlockDate3 = (ProgramExam)item.getUnlockDate();
                    n.d(unlockDate3);
                    value2 = unlockDate3.longValue();
                } while (value > value2);
            }
        }
        int i11 = 10;
        if (item == null) {
            ArrayList arrayList4 = new ArrayList(p.r(examList2, i11));
            Iterator it2 = examList.iterator();
            while (it2.hasNext()) {
                arrayList4.add(item4);
            }
            return arrayList4;
        }
        ArrayList arrayList2 = new ArrayList(p.r(examList2, i11));
        Iterator it = examList.iterator();
        while (it.hasNext()) {
            arrayList2.add(item3);
        }
        return arrayList2;
    }
}
