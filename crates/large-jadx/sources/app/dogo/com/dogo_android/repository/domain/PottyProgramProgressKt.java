package app.dogo.com.dogo_android.repository.domain;

import app.dogo.com.dogo_android.s.b.f1.b;
import app.dogo.externalmodel.model.DogLogModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus;
import app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays;
import app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: PottyProgramProgress.kt */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toPottyProgramProgressItem", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PottyProgramProgressKt {
    public static final PottyProgramProgress toPottyProgramProgressItem(PottyProgramProgressModel.ProgramStatus programStatus) {
        int i2 = 0;
        java.util.List list;
        java.util.List list2;
        String str4;
        String str5;
        int i7;
        Object obj;
        n.f(programStatus, "<this>");
        Long stoppedTimeMs = programStatus.getStoppedTimeMs();
        if (stoppedTimeMs == null) {
            i2 = 0;
        } else {
            long value2 = stoppedTimeMs.longValue();
        }
        PottyProgramProgressModel.StreakDays cleanDaysStreak = programStatus.getStreaks().getCleanDaysStreak();
        int i = 0;
        i = cleanDaysStreak == null ? i : days;
        PottyProgramProgressModel.StreakDays logStreak = programStatus.getStreaks().getLogStreak();
        i = logStreak == null ? i : days2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = programStatus.getArticles().entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next();
        }
        java.util.List logs = programStatus.getLogs();
        ArrayList arrayList = new ArrayList(p.r(logs, 10));
        Iterator it2 = logs.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            long eventTimeMs = item.getEventTimeMs();
            DogLogRepository_DogLogEntity dogLogRepository_DogLogEntity = new DogLogRepository_DogLogEntity(item.getId(), item.getDogId(), type, eventTimeMs, eventTimeMs);
            arrayList.add(dogLogRepository_DogLogEntity);
        }
        Boolean recommended = programStatus.isRecommended();
        i = recommended == null ? i : booleanValue;
        Boolean completed = programStatus.isCompleted();
        i = completed == null ? i : booleanValue2;
        String certificatePdfUrl = programStatus.getCertificatePdfUrl();
        String str = "";
        String r13 = certificatePdfUrl == null ? str : certificatePdfUrl;
        String certificateImageUrl = programStatus.getCertificateImageUrl();
        String r14 = certificateImageUrl == null ? str : certificateImageUrl;
        PottyProgramProgress pottyProgramProgress = new PottyProgramProgress(null, programStatus.getStartedTimeMs(), l, i2, i5, list, list2, p.L0(linkedHashMap.keySet()), arrayList, str4, str5, i7, (certificateImageUrl == null ? str : certificateImageUrl), 1, 0);
        return pottyProgramProgress;
    }
}
