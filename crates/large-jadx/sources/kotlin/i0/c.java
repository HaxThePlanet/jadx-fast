package kotlin.i0;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0002\u0008f\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002J%\u0010$\u001a\u00028\u00002\u0016\u0010%\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010'0&\"\u0004\u0018\u00010'H&¢\u0006\u0002\u0010(J#\u0010)\u001a\u00028\u00002\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010'0*H&¢\u0006\u0002\u0010+R\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0003\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\u00048&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0006\u001a\u0004\u0008\u0008\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00048&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0006\u001a\u0004\u0008\n\u0010\u0007R\u001a\u0010\u000c\u001a\u00020\u00048&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\u0006\u001a\u0004\u0008\u000c\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR \u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u00138&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u0006\u001a\u0004\u0008\u001e\u0010\u0016R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\u0006\u001a\u0004\u0008\"\u0010#¨\u0006,", d2 = {"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isFinal", "isFinal$annotations", "isOpen", "isOpen$annotations", "isSuspend", "isSuspend$annotations", "name", "", "getName", "()Ljava/lang/String;", "parameters", "", "Lkotlin/reflect/KParameter;", "getParameters", "()Ljava/util/List;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public interface c<R>  extends kotlin.i0.b {
    public abstract R call(Object... objectArr);

    public abstract R callBy(Map<kotlin.i0.k, ? extends Object> map);

    @Override // kotlin.i0.b
    public abstract String getName();

    public abstract List<kotlin.i0.k> getParameters();

    @Override // kotlin.i0.b
    public abstract kotlin.i0.o getReturnType();

    public abstract List<kotlin.i0.p> getTypeParameters();

    @Override // kotlin.i0.b
    public abstract kotlin.i0.t getVisibility();

    @Override // kotlin.i0.b
    public abstract boolean isAbstract();

    @Override // kotlin.i0.b
    public abstract boolean isFinal();

    @Override // kotlin.i0.b
    public abstract boolean isOpen();

    @Override // kotlin.i0.b
    public abstract boolean isSuspend();
}
