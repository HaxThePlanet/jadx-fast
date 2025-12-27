package e.a.a.a.b.b;

import android.app.ActivityManager.ProcessErrorStateInfo;
import app.dogo.android.persistencedb.room.entity.TrickCategoryEntity;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickStepEntity;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.android.persistencedb.room.entity.TrickVariationEntity;
import app.dogo.android.persistencedb.room.entity.VideoStepEntity;
import e.a.a.a.b.c.j;
import e.a.a.a.b.c.k;
import e.a.a.a.b.c.l;
import e.a.a.a.b.c.m;
import e.a.a.a.b.d.g;
import i.b.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;

/* compiled from: TrickEntityDao.kt */
@Metadata(d1 = "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0002\u0008(\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u00032\u0012\u0010\u001c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001e0\u001d\"\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ%\u0010 \u001a\u00020\u00032\u0012\u0010!\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\"0\u001d\"\u00020\"H§@ø\u0001\u0000¢\u0006\u0002\u0010#J%\u0010$\u001a\u00020\u00032\u0012\u0010%\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020&0\u001d\"\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J%\u0010(\u001a\u00020\u00032\u0012\u0010)\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020*0\u001d\"\u00020*H§@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0019\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J\u001c\u00100\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000502012\u0006\u00103\u001a\u000204H'J\u0014\u00105\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0201H'J\u0014\u00106\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0201H'J\u0014\u00107\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110201H'J\u0014\u00108\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150201H'J\u0014\u00109\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190201H'J\u0014\u0010:\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050201H'J\u0014\u0010;\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020.0201H'J\u0013\u0010<\u001a\u0004\u0018\u00010=H§@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u0004\u0018\u00010=H§@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0013\u0010@\u001a\u0004\u0018\u00010=H§@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0013\u0010A\u001a\u0004\u0018\u00010=H§@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0013\u0010B\u001a\u0004\u0018\u00010=H§@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0013\u0010C\u001a\u0004\u0018\u00010=H§@ø\u0001\u0000¢\u0006\u0002\u0010>J'\u0010D\u001a\u0008\u0012\u0004\u0012\u00020\u0005022\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0002\u0010FJ!\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u0002042\u0006\u00103\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0002\u0010FJ\u001c\u0010I\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t02012\u0006\u0010E\u001a\u000204H'J\u001c\u0010J\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001102012\u0006\u0010H\u001a\u000204H'J\u001c\u0010K\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001502012\u0006\u0010H\u001a\u000204H'J\u001c\u0010L\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001902012\u0006\u0010H\u001a\u000204H'J\u001f\u0010M\u001a\u0008\u0012\u0004\u0012\u00020\u001e022\u0006\u0010N\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0002\u0010OJ\u001f\u0010P\u001a\u0008\u0012\u0004\u0012\u00020\"022\u0006\u0010N\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0002\u0010OJ\u001f\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020&022\u0006\u0010N\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0002\u0010OJ\u001f\u0010R\u001a\u0008\u0012\u0004\u0012\u00020*022\u0006\u0010N\u001a\u000204H§@ø\u0001\u0000¢\u0006\u0002\u0010OJ\u001c\u0010S\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020.02012\u0006\u0010H\u001a\u000204H'J%\u0010T\u001a\u00020\u00032\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\t0\u001d\"\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010UJ%\u0010V\u001a\u00020\u00032\u0012\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0\u001d\"\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010WJ\u0014\u0010X\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082@ø\u0001\u0000J%\u0010Y\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00110\u001d\"\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010ZJ%\u0010[\u001a\u00020\u00032\u0012\u0010\u0014\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00150\u001d\"\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0002\u0010\\J%\u0010]\u001a\u00020\u00032\u0012\u0010\u0018\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00190\u001d\"\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0002\u0010^J%\u0010_\u001a\u00020\u00032\u0012\u0010\u001c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001e0\u001d\"\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ%\u0010`\u001a\u00020\u00032\u0012\u0010!\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\"0\u001d\"\u00020\"H§@ø\u0001\u0000¢\u0006\u0002\u0010#J%\u0010a\u001a\u00020\u00032\u0012\u0010%\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020&0\u001d\"\u00020&H§@ø\u0001\u0000¢\u0006\u0002\u0010'J%\u0010b\u001a\u00020\u00032\u0012\u0010)\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020*0\u001d\"\u00020*H§@ø\u0001\u0000¢\u0006\u0002\u0010+J%\u0010c\u001a\u00020\u00032\u0012\u0010-\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020.0\u001d\"\u00020.H§@ø\u0001\u0000¢\u0006\u0002\u0010d\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006e", d2 = {"Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "", "cleanInsertFullTrick", "", "fullTrickEntity", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrick", "trick", "Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TrickEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickCategory", "trickCategory", "Lapp/dogo/android/persistencedb/room/entity/TrickCategoryEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TrickCategoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickStep", "trickStep", "Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickTag", "trickTag", "Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickVariation", "variation", "Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickWithSteps", "trickWithSteps", "", "Lapp/dogo/android/persistencedb/room/junction/TrickWithSteps;", "([Lapp/dogo/android/persistencedb/room/junction/TrickWithSteps;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickWithTags", "trickWithTags", "Lapp/dogo/android/persistencedb/room/junction/TrickWithTags;", "([Lapp/dogo/android/persistencedb/room/junction/TrickWithTags;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickWithVariation", "trickWithVariation", "Lapp/dogo/android/persistencedb/room/junction/TrickWithVariations;", "([Lapp/dogo/android/persistencedb/room/junction/TrickWithVariations;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrickWithVideoSteps", "trickWithVideoSteps", "Lapp/dogo/android/persistencedb/room/junction/TrickWithVideoSteps;", "([Lapp/dogo/android/persistencedb/room/junction/TrickWithVideoSteps;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVideoStep", "videoStep", "Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;", "(Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLocalisedTricks", "Lio/reactivex/Single;", "", "locale", "", "getAllTrickCategoryContent", "getAllTrickContent", "getAllTrickStepContent", "getAllTrickTagContent", "getAllTrickVariationContent", "getAllTricks", "getAllVideoStepContentContent", "getLatestTrickCategoryTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestTrickStepTimestamp", "getLatestTrickTagTimestamp", "getLatestTrickTimestamp", "getLatestTrickVariationTimestamp", "getLatestTrickVideoStepTimestamp", "getTrick", "trickId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrickCategoryContent", "id", "getTrickContent", "getTrickStepContent", "getTrickTagContent", "getTrickVariationContent", "getTrickWithStepsJunction", "locale_trickId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrickWithTagsJunction", "getTrickWithVariationJunction", "getTrickWithVideoStepsJunction", "getVideoStepContent", "insertTrick", "([Lapp/dogo/android/persistencedb/room/entity/TrickEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTrickCategories", "([Lapp/dogo/android/persistencedb/room/entity/TrickCategoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTrickJunctions", "insertTrickSteps", "([Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTrickTags", "([Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTrickVariations", "([Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTrickWithSteps", "insertTrickWithTags", "insertTrickWithVariation", "insertTrickWithVideoSteps", "insertVideoSteps", "([Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m0, reason: from kotlin metadata */
public interface TrickEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static final /* synthetic */ Object a(m0 m0Var, g gVar, d dVar) {
            return app.dogo.android.persistencedb.room.dao.m0.a.c(m0Var, gVar, dVar);
        }

        public static Object b(m0 m0Var, g gVar, d<? super w> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int label22 = 5;
            int i2;
            TrickEntity trickEntity;
            Object gVar22;
            Object m0Var2;
            e.a.a.a.b.b.m0 m0Var3;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.m0.a.a;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.m0.a.a) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.m0.a.a aVar = new app.dogo.android.persistencedb.room.dao.m0.a.a(dVar);
                }
            }
            Object obj3 = b.d();
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            final int i3 = 0;
            switch (dVar32.label) {
                case 0:
                    q.b(dVar32.result);
                    int i4 = 1;
                    TrickEntity[] arr3 = new TrickEntity[i4];
                    arr3[i3] = gVar.d();
                    dVar32.L$0 = m0Var;
                    dVar32.L$1 = gVar;
                    dVar32.label = i4;
                    return obj3;
                case 1:
                    q.b(dVar32.result);
                    break;
                case 2:
                    q.b(dVar32.result);
                    Object[] array2 = dVar32.L$1.e().toArray(new TrickStepEntity[i3]);
                    Objects.requireNonNull(array2, str);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = gVar22;
                    label22 = 3;
                    dVar32.label = 3;
                    return obj3;
                case 3:
                    q.b(dVar32.result);
                    Object[] array4 = dVar32.L$1.component1().toArray(new TrickTagEntity[i3]);
                    Objects.requireNonNull(array4, str);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = gVar22;
                    label22 = 4;
                    dVar32.label = 4;
                    return obj3;
                case 4:
                    q.b(dVar32.result);
                    Object[] array3 = dVar32.L$1.f().toArray(new TrickVariationEntity[i3]);
                    Objects.requireNonNull(array3, str);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = gVar22;
                    label22 = 5;
                    dVar32.label = 5;
                    return obj3;
                case 5:
                    q.b(dVar32.result);
                    Object obj4 = null;
                    dVar32.L$0 = obj4;
                    dVar32.L$1 = obj4;
                    dVar32.label = 6;
                    return obj3;
                case 6:
                    q.b(dVar32.result);
                    return w.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object[] array = gVar22.g().toArray(new VideoStepEntity[i3]);
            Objects.requireNonNull(array, str);
            dVar32.L$0 = m0Var2;
            dVar32.L$1 = gVar22;
            label22 = 2;
            dVar32.label = label22;
            if (m0Var2.v((VideoStepEntity[])Arrays.copyOf(array, array.length), dVar32) == dVar32.label) {
                return obj3;
            }
        }

        private static Object c(m0 m0Var, g gVar, d<? super w> dVar) {
            Object result2;
            Iterable iterable5;
            Object obj;
            Object obj2;
            Object m0Var2;
            Iterable iterable6;
            Object dVar32;
            int label2;
            Iterable iterable7;
            Object obj3;
            int i = -2147483648;
            int i4 = 11;
            int i3;
            Object obj4;
            Iterable iterable8;
            int length;
            Object obj6;
            Object obj5;
            Iterable iterable;
            Object gVar22;
            Iterable iterable3;
            int i6;
            String locale_trickId;
            Iterable iterable2;
            String locale_trickId2;
            Iterable iterable4;
            int i9;
            String locale_trickId3;
            String locale_trickId4;
            int i13;
            m0Var2 = m0Var;
            dVar32 = dVar;
            z = dVar32 instanceof app.dogo.android.persistencedb.room.dao.m0.a.b;
            if (dVar32 instanceof app.dogo.android.persistencedb.room.dao.m0.a.b) {
                i = Integer.MIN_VALUE;
                i3 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.m0.a.b bVar = new app.dogo.android.persistencedb.room.dao.m0.a.b(dVar32);
                }
            }
            Object obj10 = b.d();
            i4 = 10;
            final Object obj13 = null;
            final String str2 = "null cannot be cast to non-null type kotlin.Array<T>";
            final int i15 = 0;
            switch (dVar32.label) {
                case 0:
                    q.b(dVar32.result);
                    List component1 = gVar.component1();
                    ArrayList arrayList4 = new ArrayList(p.r(component1, i4));
                    Iterator it = component1.iterator();
                    arrayList4.add(new TrickWithTags(it.next().getLocale_tagId(), gVar.d().getLocale_trickId()));
                    List list = gVar.e();
                    ArrayList arrayList2 = new ArrayList(p.r(list, i4));
                    Iterator it2 = list.iterator();
                    arrayList2.add(new TrickWithSteps(it2.next().getLocale_stepId(), gVar.d().getLocale_trickId()));
                    List list2 = gVar.g();
                    ArrayList arrayList3 = new ArrayList(p.r(list2, i4));
                    Iterator it3 = list2.iterator();
                    arrayList3.add(new TrickWithVideoSteps(it3.next().getLocale_stepId(), gVar.d().getLocale_trickId()));
                    List list3 = gVar.f();
                    ArrayList arrayList = new ArrayList(p.r(list3, i4));
                    Iterator it4 = list3.iterator();
                    arrayList.add(new TrickWithVariations(it4.next().getLocale_variationId(), gVar.d().getLocale_trickId()));
                    dVar32.L$0 = m0Var2;
                    gVar22 = gVar;
                    dVar32.L$1 = gVar22;
                    dVar32.L$2 = arrayList4;
                    dVar32.L$3 = arrayList2;
                    dVar32.L$4 = arrayList3;
                    dVar32.L$5 = arrayList;
                    int i10 = 1;
                    dVar32.label = 1;
                    result2 = m0Var2.n(gVar.d().getLocale_trickId(), dVar32);
                    return obj10;
                    break;
                case 1:
                    q.b(dVar32.result);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = gVar22;
                    dVar32.L$2 = gVar22;
                    dVar32.L$3 = obj5;
                    dVar32.L$4 = obj4;
                    dVar32.L$5 = result2;
                    dVar32.L$6 = result2;
                    dVar32.label = 2;
                    result2 = m0Var2.e(gVar22.d().getLocale_trickId(), dVar32);
                    return obj10;
                    break;
                case 2:
                    q.b(dVar32.result);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = gVar22;
                    dVar32.L$2 = gVar22;
                    dVar32.L$3 = obj5;
                    dVar32.L$4 = obj4;
                    dVar32.L$5 = result2;
                    dVar32.L$6 = result2;
                    dVar32.L$7 = result2;
                    int i11 = 3;
                    dVar32.label = 3;
                    result2 = m0Var2.x(gVar22.d().getLocale_trickId(), dVar32);
                    return obj10;
                    break;
                case 3:
                    q.b(dVar32.result);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = gVar22;
                    dVar32.L$2 = obj5;
                    dVar32.L$3 = obj4;
                    dVar32.L$4 = result2;
                    dVar32.L$5 = result2;
                    dVar32.L$6 = result2;
                    dVar32.L$7 = result2;
                    int i12 = 4;
                    dVar32.label = 4;
                    Object trick = m0Var2.getTrick(gVar22.d().getLocale_trickId(), dVar32);
                    return obj10;
                    break;
                case 4:
                    q.b(dVar32.result);
                    java.util.Set set3 = p.E0(iterable7, iterable2);
                    java.util.Set set = p.E0(iterable5, iterable3);
                    java.util.Set set2 = p.E0((List)(ist)iterable6, iterable);
                    Object[] array7 = p.E0(iterable8, iterable4).toArray(new k[i15]);
                    Objects.requireNonNull(array7, str2);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = iterable4;
                    dVar32.L$2 = iterable2;
                    dVar32.L$3 = iterable3;
                    dVar32.L$4 = iterable;
                    dVar32.L$5 = set3;
                    dVar32.L$6 = set;
                    dVar32.L$7 = set2;
                    i13 = 5;
                    dVar32.label = 5;
                    return obj10;
                    break;
                case 5:
                    q.b(dVar32.result);
                    break;
                case 6:
                    q.b(dVar32.result);
                    Object[] array5 = obj3.toArray(new m[i15]);
                    Objects.requireNonNull(array5, str2);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = m0Var2;
                    dVar32.L$2 = result2;
                    dVar32.L$3 = result2;
                    dVar32.L$4 = obj2;
                    dVar32.L$5 = obj;
                    dVar32.L$6 = obj13;
                    i9 = 7;
                    dVar32.label = 7;
                    return obj10;
                case 7:
                    q.b(dVar32.result);
                    Object[] array = obj.toArray(new l[i15]);
                    Objects.requireNonNull(array, str2);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = m0Var2;
                    dVar32.L$2 = result2;
                    dVar32.L$3 = result2;
                    dVar32.L$4 = obj2;
                    dVar32.L$5 = obj13;
                    dVar32.label = 8;
                    return obj10;
                case 8:
                    q.b(dVar32.result);
                    Object[] array6 = result2.toArray(new m[i15]);
                    Objects.requireNonNull(array6, str2);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = m0Var2;
                    dVar32.L$2 = result2;
                    dVar32.L$3 = obj2;
                    dVar32.L$4 = obj13;
                    i6 = 9;
                    dVar32.label = 9;
                    return obj10;
                case 9:
                    q.b(dVar32.result);
                    Object[] array4 = m0Var2.toArray(new k[i15]);
                    Objects.requireNonNull(array4, str2);
                    length = array4.length;
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = result2;
                    dVar32.L$2 = obj2;
                    dVar32.L$3 = obj13;
                    dVar32.label = i4;
                    return obj10;
                case 10:
                    q.b(dVar32.result);
                    Object[] array3 = result2.toArray(new j[i15]);
                    Objects.requireNonNull(array3, str2);
                    dVar32.L$0 = m0Var2;
                    dVar32.L$1 = obj2;
                    dVar32.L$2 = obj13;
                    i4 = 11;
                    dVar32.label = 11;
                    return obj10;
                case 11:
                    q.b(dVar32.result);
                    Object[] array2 = obj2.toArray(new l[i15]);
                    Objects.requireNonNull(array2, str2);
                    dVar32.L$0 = obj13;
                    dVar32.L$1 = obj13;
                    dVar32.label = 12;
                    return obj10;
                case 12:
                    q.b(dVar32.result);
                    return w.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object[] array8 = obj6.toArray(new j[i15]);
            Objects.requireNonNull(array8, str2);
            dVar32.L$0 = m0Var2;
            dVar32.L$1 = iterable4;
            dVar32.L$2 = iterable2;
            dVar32.L$3 = iterable3;
            dVar32.L$4 = iterable;
            dVar32.L$5 = obj3;
            dVar32.L$6 = obj;
            dVar32.L$7 = obj13;
            dVar32.label = 6;
            if (m0Var2.m((j[])Arrays.copyOf(array8, array8.length), dVar32) == dVar32.label) {
                return obj10;
            }
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ Object cleanInsertFullTrick(d<? super Long> fullTrickEntity);

    /* renamed from: b, reason: from kotlin metadata */
    /* suspend */ Object getTrick(String locale, d<? super List<l>> trickId);

    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ Object getTrickCategoryContent(TrickEntity[] id, d<? super w> locale);

    Object d(m[] mVarArr, d<? super w> dVar);

    Object e(String str, d<? super List<j>> dVar);

    Object f(m[] mVarArr, d<? super w> dVar);

    Object g(k[] kVarArr, d<? super w> dVar);

    Object h(TrickVariationEntity[] trickVariationEntityArr, d<? super w> dVar);

    Object i(g gVar, d<? super w> dVar);

    /* renamed from: j, reason: from kotlin metadata */
    /* suspend */ Object deleteTrick(d<? super Long> trick);

    Object k(l[] lVarArr, d<? super w> dVar);

    Object l(TrickCategoryEntity[] trickCategoryEntityArr, d<? super w> dVar);

    Object m(j[] jVarArr, d<? super w> dVar);

    Object n(String str, d<? super List<k>> dVar);

    Object o(String str, String str2, d<? super TrickCategoryEntity> dVar);

    Object p(TrickTagEntity[] trickTagEntityArr, d<? super w> dVar);

    Object q(j[] jVarArr, d<? super w> dVar);

    Object r(TrickStepEntity[] trickStepEntityArr, d<? super w> dVar);

    Object s(l[] lVarArr, d<? super w> dVar);

    Object t(String str, String str2, d<? super List<g>> dVar);

    /* renamed from: u, reason: from kotlin metadata */
    /* suspend */ Object deleteTrickCategory(d<? super Long> trickCategory);

    Object v(VideoStepEntity[] videoStepEntityArr, d<? super w> dVar);

    Object w(k[] kVarArr, d<? super w> dVar);

    Object x(String str, d<? super List<m>> dVar);

    /* renamed from: y, reason: from kotlin metadata */
    /* suspend */ a0<List<g>> deleteTrickStep(String trickStep);
}
