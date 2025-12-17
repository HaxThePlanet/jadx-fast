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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PremiumContentLockInteractor;", "", "()V", "unlockFirstUnlockedExam", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "examList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i3 {
    public final List<ProgramExam> a(List<ProgramExam> list) {
        Object obj;
        Object next2;
        Object next;
        int status3;
        int status;
        int longValue;
        int trickId;
        ProgramExam.Status status2;
        boolean next3;
        ProgramExam.Status longValue2;
        int i3;
        int cmp;
        ProgramExam.Status pREMIUM_LOCKED;
        int i5;
        int i12;
        int i18;
        int i2;
        int i15;
        int i13;
        int i7;
        int i;
        int i10;
        int i6;
        int i19;
        int i16;
        int i9;
        int i4;
        int i14;
        int i17;
        int i11;
        int i8;
        Object obj2 = list;
        n.f(obj2, "examList");
        ArrayList arrayList = new ArrayList();
        Iterator iterator3 = list.iterator();
        trickId = 0;
        while (iterator3.hasNext()) {
            next2 = iterator3.next();
            if ((ProgramExam)next2.getStatus() == ProgramExam.Status.READY) {
            } else {
            }
            longValue = trickId;
            if (longValue != 0) {
            }
            trickId = 0;
            arrayList.add(next2);
        }
        if (arrayList.isEmpty()) {
            return obj2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator iterator5 = list.iterator();
        while (iterator5.hasNext()) {
            status2 = iterator5.next();
            if ((ProgramExam)status2.getUnlockDate() != null) {
            } else {
            }
            longValue2 = trickId;
            if (longValue2 != 0) {
            }
            arrayList3.add(status2);
            longValue2 = longValue;
        }
        Iterator iterator4 = arrayList3.iterator();
        if (!iterator4.hasNext()) {
            obj = 0;
        } else {
            if (iterator4.hasNext()) {
                Long unlockDate = (ProgramExam)iterator4.next().getUnlockDate();
                n.d(unlockDate);
                longValue = unlockDate.longValue();
                Object next9 = iterator4.next();
                Long unlockDate3 = (ProgramExam)next9.getUnlockDate();
                n.d(unlockDate3);
                longValue2 = unlockDate3.longValue();
                do {
                    next9 = iterator4.next();
                    unlockDate3 = (ProgramExam)next9.getUnlockDate();
                    n.d(unlockDate3);
                    longValue2 = unlockDate3.longValue();
                    if (iterator4.hasNext()) {
                    }
                    next = next9;
                    longValue = longValue2;
                } while (Long.compare(longValue, longValue2) > 0);
            }
            obj = next;
        }
        int i20 = 10;
        if ((ProgramExam)obj == null) {
            ArrayList arrayList4 = new ArrayList(p.r(obj2, i20));
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                longValue = next8;
                if ((ProgramExam)longValue.getStatus() == ProgramExam.Status.READY && !n.b(longValue.getTrickId(), (ProgramExam)p.X(arrayList).getTrickId())) {
                }
                arrayList4.add(longValue);
                if (!n.b(longValue.getTrickId(), (ProgramExam)p.X(arrayList).getTrickId())) {
                }
                longValue = ProgramExam.copy$default(longValue, 0, 0, 0, 0, 0, ProgramExam.Status.PREMIUM_LOCKED, 0, 0, obj13, 0, 0, 0, 0, obj18, 0, 0, 0, 0, 0, 0, false, 0, 0, 0);
            }
            return arrayList4;
        }
        ArrayList arrayList2 = new ArrayList(p.r(obj2, i20));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            longValue = next6;
            if ((ProgramExam)longValue.getStatus() == ProgramExam.Status.READY && !n.b(longValue.getTrickId(), (ProgramExam)obj.getTrickId())) {
            }
            arrayList2.add(longValue);
            if (!n.b(longValue.getTrickId(), obj.getTrickId())) {
            }
            longValue = ProgramExam.copy$default(longValue, 0, 0, 0, 0, 0, ProgramExam.Status.PREMIUM_LOCKED, 0, 0, obj13, 0, 0, 0, 0, obj18, 0, 0, 0, 0, 0, 0, false, 0, 0, 0);
        }
        return arrayList2;
    }
}
