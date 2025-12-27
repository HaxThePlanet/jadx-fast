package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.android.persistencedb.room.entity.ArticleTagEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import e.a.a.a.b.c.i;
import e.a.a.a.b.d.f;
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

/* compiled from: QuestionEntityDao.kt */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0002\u0008\u0013\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0014\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u0014\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001d0\u0015\"\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0 H'J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0 2\u0006\u0010#\u001a\u00020$H'J\u0014\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0!0 H'J\u001c\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0!0 2\u0006\u0010'\u001a\u00020$H'J\u001c\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110!0 2\u0006\u0010'\u001a\u00020$H'J\u001f\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010*\u001a\u00020$H§@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010-H§@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0004\u0018\u00010-H§@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0013\u00100\u001a\u0004\u0018\u00010-H§@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001c\u00101\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0!0 2\u0006\u0010'\u001a\u00020$H'J\u001f\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u001d0!2\u0006\u00103\u001a\u00020$H§@ø\u0001\u0000¢\u0006\u0002\u0010+J%\u00104\u001a\u00020\u00032\u0012\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0\u0015\"\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082@ø\u0001\u0000J%\u00107\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00110\u0015\"\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u00108J%\u00109\u001a\u00020\u00032\u0012\u0010:\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J%\u0010;\u001a\u00020\u00032\u0012\u0010\u0019\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001a0\u0015\"\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0014\u0010=\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0082@ø\u0001\u0000J%\u0010>\u001a\u00020\u00032\u0012\u0010?\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001d0\u0015\"\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006@", d2 = {"Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "", "cleanInsertFullArticle", "", "articleFullEntity", "Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanInsertFullQuestion", "questionFullEntity", "Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticle", "article", "Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticleTag", "articleTag", "Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticleWithTags", "junctions", "", "Lapp/dogo/android/persistencedb/room/junction/ArticleWithTags;", "([Lapp/dogo/android/persistencedb/room/junction/ArticleWithTags;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteQuestion", "question", "Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;", "(Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteQuestionWithArticle", "Lapp/dogo/android/persistencedb/room/junction/QuestionWithArticle;", "([Lapp/dogo/android/persistencedb/room/junction/QuestionWithArticle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllArticles", "Lio/reactivex/Single;", "", "getAllLocalisedArticles", "locale", "", "getAllQuestions", "getArticleContent", "id", "getArticleTagContent", "getArticleWithTagJunction", "locale_articleId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestArticleTagTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestArticleTimestamp", "getLatestQuestionTimestamp", "getQuestionContent", "getQuestionWithArticleJunction", "locale_questionId", "insertArticle", "([Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertArticleJunctions", "insertArticleTag", "([Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertArticleWithTags", "articleWithTags", "insertQuestion", "([Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertQuestionJunctions", "insertQuestionWithArticle", "questionWithArticle", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g0, reason: from kotlin metadata */
public interface QuestionEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static final /* synthetic */ Object a(g0 g0Var, e.a.a.a.b.d.a aVar, d dVar) {
            return app.dogo.android.persistencedb.room.dao.g0.a.e(g0Var, aVar, dVar);
        }

        public static final /* synthetic */ Object b(g0 g0Var, f fVar, d dVar) {
            return app.dogo.android.persistencedb.room.dao.g0.a.f(g0Var, fVar, dVar);
        }

        public static Object c(g0 g0Var, e.a.a.a.b.d.a aVar, d<? super w> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int length;
            int i2;
            Object aVar22;
            Object g0Var2;
            e.a.a.a.b.d.a aVar3;
            e.a.a.a.b.b.g0 g0Var3;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.a;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.a) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    aVar = new app.dogo.android.persistencedb.room.dao.g0.a.a(dVar);
                }
            }
            Object obj2 = b.d();
            int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i6) {
                    if (dVar32.label != i5) {
                        if (dVar32.label != i4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    Object[] array = aVar22.b().toArray(new ArticleTagEntity[i3]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    length = array.length;
                    dVar32.L$0 = g0Var2;
                    dVar32.L$1 = aVar22;
                    dVar32.label = i5;
                    if (g0Var2.k((ArticleTagEntity[])Arrays.copyOf(array, length), dVar32) == obj2) {
                        return obj2;
                    }
                }
            } else {
                q.b(dVar32.result);
                ArticleEntity[] arr2 = new ArticleEntity[i6];
                dVar32.L$0 = g0Var;
                dVar32.L$1 = aVar;
                dVar32.label = i6;
                if (g0Var.j(new ArticleEntity[] { aVar.component1() }, dVar32) == obj2) {
                    return obj2;
                }
            }
            Object result2 = null;
            dVar32.L$0 = result2;
            dVar32.L$1 = result2;
            dVar32.label = i4;
            if (app.dogo.android.persistencedb.room.dao.g0.a.e(g0Var3, aVar3, dVar32) == obj2) {
                return obj2;
            }
        }

        public static Object d(g0 g0Var, f fVar, d<? super w> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int label22 = 0;
            int i2;
            QuestionEntity questionEntity;
            Object fVar22;
            Object g0Var2;
            e.a.a.a.b.b.g0 g0Var3;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.b;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.b) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.g0.a.b bVar = new app.dogo.android.persistencedb.room.dao.g0.a.b(dVar);
                }
            }
            Object obj2 = b.d();
            int i3 = 3;
            final int i4 = 2;
            final int i5 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i5) {
                    if (dVar32.label != i4) {
                        if (dVar32.label != i3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    dVar32.L$0 = g0Var2;
                    dVar32.L$1 = fVar22;
                    dVar32.label = i4;
                    if (g0Var2.e(fVar22.component1(), dVar32) == obj2) {
                        return obj2;
                    }
                }
            } else {
                q.b(dVar32.result);
                QuestionEntity[] arr = new QuestionEntity[i5];
                label22 = 0;
                arr[label22] = fVar.b();
                dVar32.L$0 = g0Var;
                dVar32.L$1 = fVar;
                dVar32.label = i5;
                if (g0Var.o(arr, dVar32) == obj2) {
                    return obj2;
                }
            }
            Object result2 = null;
            dVar32.L$0 = result2;
            dVar32.L$1 = result2;
            dVar32.label = i3;
            if (app.dogo.android.persistencedb.room.dao.g0.a.f(g0Var3, fVar, dVar32) == obj2) {
                return obj2;
            }
        }

        private static Object e(g0 g0Var, e.a.a.a.b.d.a aVar, d<? super w> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int length;
            int i2;
            boolean hasNext;
            String locale_articleId;
            e.a.a.a.b.c.a articleWithTags;
            ArrayList arrayList;
            Object g0Var2;
            Iterable iterable;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.c;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.c) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.g0.a.c cVar = new app.dogo.android.persistencedb.room.dao.g0.a.c(dVar);
                }
            }
            Object obj2 = b.d();
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            final int i4 = 0;
            final int i5 = 3;
            final int i6 = 2;
            final int i7 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i7) {
                    if (dVar32.label != i6) {
                        if (dVar32.label != i5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    Object[] array2 = p.E0((List)iterable, arrayList).toArray(new a[i4]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    length = array2.length;
                    dVar32.L$0 = g0Var2;
                    dVar32.L$1 = arrayList;
                    dVar32.label = i6;
                    if (g0Var2.d((a[])Arrays.copyOf(array2, length), dVar32) == obj2) {
                        return obj2;
                    }
                }
            } else {
                q.b(dVar32.result);
                List list = aVar.b();
                arrayList = new ArrayList(p.r(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new ArticleWithTags(aVar.component1().getLocale_articleId(), (ArticleTagEntity)it.next().getLocale_tagId()));
                }
                dVar32.L$0 = g0Var;
                dVar32.L$1 = arrayList;
                dVar32.label = i7;
                if (g0Var.b(aVar.component1().getLocale_articleId(), dVar32) == obj2) {
                    return obj2;
                }
                g0Var2 = g0Var;
            }
            Object[] array = arrayList.toArray(new a[i4]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Object result2 = null;
            dVar32.L$0 = result2;
            dVar32.L$1 = result2;
            dVar32.label = i5;
            if (g0Var2.m((a[])Arrays.copyOf(array, array.length), dVar32) == obj2) {
                return obj2;
            }
        }

        private static Object f(g0 g0Var, f fVar, d<? super w> dVar) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int length;
            int i2;
            String locale_questionId;
            Object fVar22;
            i dVar33;
            Object g0Var2;
            Iterable iterable;
            z = dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.d;
            if (dVar instanceof app.dogo.android.persistencedb.room.dao.g0.a.d) {
                dVar32 = dVar;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    dVar = new app.dogo.android.persistencedb.room.dao.g0.a.d(dVar);
                }
            }
            Object obj2 = b.d();
            int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i6) {
                    if (dVar32.label != i5) {
                        if (dVar32.label != i4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    Object[] array = p.E0((List)iterable, p.b(dVar33)).toArray(new i[i3]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    length = array.length;
                    dVar32.L$0 = g0Var2;
                    dVar32.L$1 = dVar33;
                    dVar32.label = i5;
                    if (g0Var2.l((i[])Arrays.copyOf(array, length), dVar32) == obj2) {
                        return obj2;
                    }
                }
            } else {
                q.b(dVar32.result);
                dVar33 = new QuestionWithArticle(fVar.component1().component1().getLocale_articleId(), fVar.b().getLocale_questionId());
                dVar32.L$0 = g0Var;
                dVar32.L$1 = dVar33;
                dVar32.label = i6;
                fVar22 = g0Var.n(fVar.b().getLocale_questionId(), dVar32);
                if (fVar22 == obj2) {
                    return obj2;
                }
                g0Var2 = g0Var;
            }
            i[] arr = new i[i6];
            Object obj3 = null;
            dVar32.L$0 = obj3;
            dVar32.L$1 = obj3;
            dVar32.label = i4;
            if (g0Var2.f(new i[] { dVar33 }, dVar32) == obj2) {
                return obj2;
            }
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ Object cleanInsertFullArticle(d<? super Long> articleFullEntity);

    Object b(String str, d<? super List<e.a.a.a.b.c.a>> dVar);

    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ Object cleanInsertFullQuestion(d<? super Long> questionFullEntity);

    Object d(e.a.a.a.b.c.a[] aVarArr, d<? super w> dVar);

    Object e(e.a.a.a.b.d.a aVar, d<? super w> dVar);

    Object f(i[] iVarArr, d<? super w> dVar);

    Object g(f fVar, d<? super w> dVar);

    /* renamed from: h, reason: from kotlin metadata */
    /* suspend */ Object deleteArticle(d<? super Long> article);

    /* renamed from: i, reason: from kotlin metadata */
    /* suspend */ a0<List<e.a.a.a.b.d.a>> deleteArticleTag(String articleTag);

    Object j(ArticleEntity[] articleEntityArr, d<? super w> dVar);

    Object k(ArticleTagEntity[] articleTagEntityArr, d<? super w> dVar);

    Object l(i[] iVarArr, d<? super w> dVar);

    Object m(e.a.a.a.b.c.a[] aVarArr, d<? super w> dVar);

    Object n(String str, d<? super List<i>> dVar);

    Object o(QuestionEntity[] questionEntityArr, d<? super w> dVar);
}
