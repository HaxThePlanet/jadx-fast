package app.dogo.com.dogo_android.repository.domain;

import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus;
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

/* compiled from: BitingProgramProgress.kt */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toBitingProgramProgressItem", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BitingProgramProgressKt {
    public static final BitingProgramProgress toBitingProgramProgressItem(BitingProgressModel bitingProgressModel) {
        boolean booleanValue = false;
        String str2 = null;
        Object obj;
        Object obj2;
        String variationId;
        n.f(bitingProgressModel, "<this>");
        Long stoppedTimeMs = bitingProgressModel.getStoppedTimeMs();
        if (stoppedTimeMs == null) {
            int i3 = 0;
        } else {
            long value2 = stoppedTimeMs.longValue();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = bitingProgressModel.getArticles().entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next();
        }
        String certificatePdfUrl = bitingProgressModel.getCertificatePdfUrl();
        variationId = "";
        String r7 = certificatePdfUrl == null ? variationId : certificatePdfUrl;
        String certificateImageUrl = bitingProgressModel.getCertificateImageUrl();
        String r8 = certificateImageUrl == null ? variationId : certificateImageUrl;
        java.util.List tricks = bitingProgressModel.getTricks();
        final ArrayList arrayList = new ArrayList(p.r(tricks, 10));
        Iterator it2 = tricks.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            BitingProgramProgress_TrickVariationEvent bitingProgramProgress_TrickVariationEvent = new BitingProgramProgress_TrickVariationEvent(item.getTrickId(), variationId, item.getKnowledge());
            arrayList.add(bitingProgramProgress_TrickVariationEvent);
        }
        Boolean recommended = bitingProgressModel.isRecommended();
        if (recommended == null) {
            int i = 0;
        } else {
            booleanValue = recommended.booleanValue();
        }
        BitingProgramProgress bitingProgramProgress = new BitingProgramProgress(null, bitingProgressModel.getStartedTimeMs(), l, str2, str3, obj, obj2, p.L0(linkedHashMap.keySet()), arrayList, bitingProgressModel.getProgramIsCompleted(), bitingProgressModel.getArticlesAreCompleted(), bitingProgressModel.getTricksAreCompleted(), bitingProgressModel.getArticleCompletionPercentage(), bitingProgressModel.getTrickCompletionPercentage(), booleanValue, 1, 0);
        return bitingProgramProgress;
    }
}
