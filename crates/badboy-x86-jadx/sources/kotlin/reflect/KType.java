package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00038&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001c\u0010\t\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0010¨\u0006\u0011", d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments$annotations", "()V", "getArguments", "()Ljava/util/List;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier$annotations", "getClassifier", "()Lkotlin/reflect/KClassifier;", "isMarkedNullable", "", "()Z", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KType extends kotlin.reflect.KAnnotatedElement {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void getArguments$annotations() {
        }

        public static void getClassifier$annotations() {
        }
    }
    public abstract List<kotlin.reflect.KTypeProjection> getArguments();

    @Override // kotlin.reflect.KAnnotatedElement
    public abstract kotlin.reflect.KClassifier getClassifier();

    @Override // kotlin.reflect.KAnnotatedElement
    public abstract boolean isMarkedNullable();
}
