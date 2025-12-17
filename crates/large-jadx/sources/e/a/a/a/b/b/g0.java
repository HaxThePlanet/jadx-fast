package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.android.persistencedb.room.entity.ArticleTagEntity;
import app.dogo.android.persistencedb.room.entity.QuestionEntity;
import e.a.a.a.b.c.a;
import e.a.a.a.b.c.i;
import e.a.a.a.b.d.a;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0002\u0008\u0013\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00020\u00032\u0012\u0010\u0014\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u0014\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001d0\u0015\"\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0 H'J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050!0 2\u0006\u0010#\u001a\u00020$H'J\u0014\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0!0 H'J\u001c\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0!0 2\u0006\u0010'\u001a\u00020$H'J\u001c\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110!0 2\u0006\u0010'\u001a\u00020$H'J\u001f\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010*\u001a\u00020$H§@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010-H§@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0004\u0018\u00010-H§@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0013\u00100\u001a\u0004\u0018\u00010-H§@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001c\u00101\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0!0 2\u0006\u0010'\u001a\u00020$H'J\u001f\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u001d0!2\u0006\u00103\u001a\u00020$H§@ø\u0001\u0000¢\u0006\u0002\u0010+J%\u00104\u001a\u00020\u00032\u0012\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0\u0015\"\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082@ø\u0001\u0000J%\u00107\u001a\u00020\u00032\u0012\u0010\u0010\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00110\u0015\"\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u00108J%\u00109\u001a\u00020\u00032\u0012\u0010:\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J%\u0010;\u001a\u00020\u00032\u0012\u0010\u0019\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001a0\u0015\"\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0014\u0010=\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH\u0082@ø\u0001\u0000J%\u0010>\u001a\u00020\u00032\u0012\u0010?\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001d0\u0015\"\u00020\u001dH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006@", d2 = {"Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "", "cleanInsertFullArticle", "", "articleFullEntity", "Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/ArticleFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanInsertFullQuestion", "questionFullEntity", "Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/QuestionFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticle", "article", "Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticleTag", "articleTag", "Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;", "(Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticleWithTags", "junctions", "", "Lapp/dogo/android/persistencedb/room/junction/ArticleWithTags;", "([Lapp/dogo/android/persistencedb/room/junction/ArticleWithTags;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteQuestion", "question", "Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;", "(Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteQuestionWithArticle", "Lapp/dogo/android/persistencedb/room/junction/QuestionWithArticle;", "([Lapp/dogo/android/persistencedb/room/junction/QuestionWithArticle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllArticles", "Lio/reactivex/Single;", "", "getAllLocalisedArticles", "locale", "", "getAllQuestions", "getArticleContent", "id", "getArticleTagContent", "getArticleWithTagJunction", "locale_articleId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestArticleTagTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestArticleTimestamp", "getLatestQuestionTimestamp", "getQuestionContent", "getQuestionWithArticleJunction", "locale_questionId", "insertArticle", "([Lapp/dogo/android/persistencedb/room/entity/ArticleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertArticleJunctions", "insertArticleTag", "([Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertArticleWithTags", "articleWithTags", "insertQuestion", "([Lapp/dogo/android/persistencedb/room/entity/QuestionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertQuestionJunctions", "insertQuestionWithArticle", "questionWithArticle", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface g0 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static final Object a(e.a.a.a.b.b.g0 g0, a a2, d d3) {
            return g0.a.e(g0, a2, d3);
        }

        public static final Object b(e.a.a.a.b.b.g0 g0, f f2, d d3) {
            return g0.a.f(g0, f2, d3);
        }

        public static Object c(e.a.a.a.b.b.g0 g0, a a2, d<? super w> d3) {
            boolean aVar;
            int label;
            int i;
            ArticleEntity length;
            int i2;
            Object obj;
            Object obj8;
            Object obj9;
            Object obj10;
            aVar = d3;
            label = aVar.label;
            i = Integer.MIN_VALUE;
            if (d3 instanceof g0.a.a && label & i != 0) {
                aVar = d3;
                label = aVar.label;
                i = Integer.MIN_VALUE;
                if (label & i != 0) {
                    aVar.label = label -= i;
                } else {
                    aVar = new g0.a.a(d3);
                }
            } else {
            }
            obj10 = aVar.result;
            Object obj2 = b.d();
            length = aVar.label;
            int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (length != 0) {
                if (length != i6) {
                    if (length != i5) {
                        if (length != i4) {
                        } else {
                            q.b(obj10);
                            return w.a;
                        }
                        obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj8;
                    }
                    obj8 = aVar.L$1;
                    obj9 = aVar.L$0;
                    q.b(obj10);
                } else {
                    obj9 = obj8;
                    obj8 = aVar.L$0;
                    q.b(obj10);
                    obj10 = obj9.b().toArray(new ArticleTagEntity[i3]);
                    Objects.requireNonNull(obj10, "null cannot be cast to non-null type kotlin.Array<T>");
                    aVar.L$0 = obj8;
                    aVar.L$1 = obj9;
                    aVar.label = i5;
                    if (obj8.k((ArticleTagEntity[])Arrays.copyOf((ArticleTagEntity[])obj10, obj10.length), aVar) == obj2) {
                        return obj2;
                    }
                    obj9 = obj8;
                    obj8 = obj;
                }
            } else {
                q.b(obj10);
                obj10 = new ArticleEntity[i6];
                obj10[i3] = a2.a();
                aVar.L$0 = g0;
                aVar.L$1 = a2;
                aVar.label = i6;
                if (g0.j(obj10, aVar) == obj2) {
                    return obj2;
                }
            }
            obj10 = 0;
            aVar.L$0 = obj10;
            aVar.L$1 = obj10;
            aVar.label = i4;
            if (g0.a.e(obj9, obj8, aVar) == obj2) {
                return obj2;
            }
        }

        public static Object d(e.a.a.a.b.b.g0 g0, f f2, d<? super w> d3) {
            boolean bVar;
            int label;
            int i;
            int label2;
            int i2;
            QuestionEntity questionEntity;
            Object obj;
            Object obj8;
            Object obj9;
            Object obj10;
            bVar = d3;
            label = bVar.label;
            i = Integer.MIN_VALUE;
            if (d3 instanceof g0.a.b && label & i != 0) {
                bVar = d3;
                label = bVar.label;
                i = Integer.MIN_VALUE;
                if (label & i != 0) {
                    bVar.label = label -= i;
                } else {
                    bVar = new g0.a.b(d3);
                }
            } else {
            }
            obj10 = bVar.result;
            Object obj2 = b.d();
            label2 = bVar.label;
            int i3 = 3;
            final int i4 = 2;
            final int i5 = 1;
            if (label2 != 0) {
                if (label2 != i5) {
                    if (label2 != i4) {
                        if (label2 != i3) {
                        } else {
                            q.b(obj10);
                            return w.a;
                        }
                        obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj8;
                    }
                    obj8 = bVar.L$1;
                    obj9 = bVar.L$0;
                    q.b(obj10);
                } else {
                    obj9 = obj8;
                    obj8 = bVar.L$0;
                    q.b(obj10);
                    bVar.L$0 = obj8;
                    bVar.L$1 = obj9;
                    bVar.label = i4;
                    if (obj8.e(obj9.a(), bVar) == obj2) {
                        return obj2;
                    }
                    obj9 = obj8;
                    obj8 = obj;
                }
            } else {
                q.b(obj10);
                obj10 = new QuestionEntity[i5];
                obj10[0] = f2.b();
                bVar.L$0 = g0;
                bVar.L$1 = f2;
                bVar.label = i5;
                if (g0.o(obj10, bVar) == obj2) {
                    return obj2;
                }
            }
            obj10 = 0;
            bVar.L$0 = obj10;
            bVar.L$1 = obj10;
            bVar.label = i3;
            if (g0.a.f(obj9, obj8, bVar) == obj2) {
                return obj2;
            }
        }

        private static Object e(e.a.a.a.b.b.g0 g0, a a2, d<? super w> d3) {
            boolean cVar;
            int label;
            int i;
            int arrayList;
            int i2;
            boolean next;
            int locale_tagId;
            String locale_articleId;
            a aVar;
            Object obj11;
            Object obj12;
            int obj13;
            cVar = d3;
            label = cVar.label;
            i = Integer.MIN_VALUE;
            if (d3 instanceof g0.a.c && label & i != 0) {
                cVar = d3;
                label = cVar.label;
                i = Integer.MIN_VALUE;
                if (label & i != 0) {
                    cVar.label = label -= i;
                } else {
                    cVar = new g0.a.c(d3);
                }
            } else {
            }
            obj13 = cVar.result;
            Object obj = b.d();
            arrayList = cVar.label;
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            final int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (arrayList != null) {
                if (arrayList != i6) {
                    if (arrayList != i5) {
                        if (arrayList != i4) {
                        } else {
                            q.b(obj13);
                            return w.a;
                        }
                        obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj11;
                    }
                    obj11 = cVar.L$1;
                    obj12 = cVar.L$0;
                    q.b(obj13);
                } else {
                    obj11 = cVar.L$1;
                    obj12 = cVar.L$0;
                    q.b(obj13);
                    obj13 = p.E0((List)obj13, obj11).toArray(new a[i3]);
                    Objects.requireNonNull(obj13, str);
                    cVar.L$0 = obj12;
                    cVar.L$1 = obj11;
                    cVar.label = i5;
                    if (obj12.d((a[])Arrays.copyOf((a[])obj13, obj13.length), cVar) == obj) {
                        return obj;
                    }
                }
            } else {
                q.b(obj13);
                obj13 = a2.b();
                arrayList = new ArrayList(p.r(obj13, 10));
                obj13 = obj13.iterator();
                for (ArticleTagEntity next2 : obj13) {
                    aVar = new a(a2.a().getLocale_articleId(), next2.getLocale_tagId());
                    arrayList.add(aVar);
                }
                cVar.L$0 = g0;
                cVar.L$1 = arrayList;
                cVar.label = i6;
                if (g0.b(a2.a().getLocale_articleId(), cVar) == obj) {
                    return obj;
                }
                obj12 = g0;
                obj11 = arrayList;
            }
            obj11 = obj11.toArray(new a[i3]);
            Objects.requireNonNull(obj11, str);
            obj13 = 0;
            cVar.L$0 = obj13;
            cVar.L$1 = obj13;
            cVar.label = i4;
            if (obj12.m((a[])Arrays.copyOf((a[])obj11, obj11.length), cVar) == obj) {
                return obj;
            }
        }

        private static Object f(e.a.a.a.b.b.g0 g0, f f2, d<? super w> d3) {
            boolean dVar;
            int label;
            int i;
            int locale_articleId;
            int i2;
            String locale_questionId;
            Object obj;
            i obj9;
            Object obj10;
            Object obj11;
            dVar = d3;
            label = dVar.label;
            i = Integer.MIN_VALUE;
            if (d3 instanceof g0.a.d && label & i != 0) {
                dVar = d3;
                label = dVar.label;
                i = Integer.MIN_VALUE;
                if (label & i != 0) {
                    dVar.label = label -= i;
                } else {
                    dVar = new g0.a.d(d3);
                }
            } else {
            }
            obj11 = dVar.result;
            Object obj2 = b.d();
            locale_articleId = dVar.label;
            int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (locale_articleId != 0) {
                if (locale_articleId != i6) {
                    if (locale_articleId != i5) {
                        if (locale_articleId != i4) {
                        } else {
                            q.b(obj11);
                            return w.a;
                        }
                        obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj9;
                    }
                    obj9 = dVar.L$1;
                    obj10 = dVar.L$0;
                    q.b(obj11);
                } else {
                    obj9 = dVar.L$1;
                    obj10 = dVar.L$0;
                    q.b(obj11);
                    obj11 = p.E0((List)obj11, p.b(obj9)).toArray(new i[i3]);
                    Objects.requireNonNull(obj11, "null cannot be cast to non-null type kotlin.Array<T>");
                    dVar.L$0 = obj10;
                    dVar.L$1 = obj9;
                    dVar.label = i5;
                    if (obj10.l((i[])Arrays.copyOf((i[])obj11, obj11.length), dVar) == obj2) {
                        return obj2;
                    }
                }
            } else {
                q.b(obj11);
                obj11 = new i(f2.a().a().getLocale_articleId(), f2.b().getLocale_questionId());
                dVar.L$0 = g0;
                dVar.L$1 = obj11;
                dVar.label = i6;
                obj10 = g0.n(f2.b().getLocale_questionId(), dVar);
                if (obj10 == obj2) {
                    return obj2;
                }
                obj10 = g0;
                obj9 = obj11;
                obj11 = obj;
            }
            obj11 = new i[i6];
            obj11[i3] = obj9;
            obj9 = 0;
            dVar.L$0 = obj9;
            dVar.L$1 = obj9;
            dVar.label = i4;
            if (obj10.f(obj11, dVar) == obj2) {
                return obj2;
            }
        }
    }
    public abstract Object a(d<? super Long> d);

    public abstract Object b(String string, d<? super List<a>> d2);

    public abstract Object c(d<? super Long> d);

    public abstract Object d(a[] aArr, d<? super w> d2);

    public abstract Object e(a a, d<? super w> d2);

    public abstract Object f(i[] iArr, d<? super w> d2);

    public abstract Object g(f f, d<? super w> d2);

    public abstract Object h(d<? super Long> d);

    public abstract a0<List<a>> i(String string);

    public abstract Object j(ArticleEntity[] articleEntityArr, d<? super w> d2);

    public abstract Object k(ArticleTagEntity[] articleTagEntityArr, d<? super w> d2);

    public abstract Object l(i[] iArr, d<? super w> d2);

    public abstract Object m(a[] aArr, d<? super w> d2);

    public abstract Object n(String string, d<? super List<i>> d2);

    public abstract Object o(QuestionEntity[] questionEntityArr, d<? super w> d2);
}
