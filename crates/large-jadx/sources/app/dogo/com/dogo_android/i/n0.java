package app.dogo.com.dogo_android.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.c7;
import app.dogo.com.dogo_android.h.e7;
import app.dogo.com.dogo_android.h.g7;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import app.dogo.com.dogo_android.util.h0.j1;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u0000 \u001e2\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\t\u001c\u001d\u001e\u001f !\"#$B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BooleanHolder", "Callbacks", "Companion", "DoubleHolder", "Holder", "ItemTypes", "JsonArrayHolder", "LongHolder", "StringHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n0 extends RecyclerView.h<app.dogo.com.dogo_android.i.n0.e> implements a {

    public static final app.dogo.com.dogo_android.i.n0.c Companion;
    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.i.n0.b a;
    private final c b;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0008\u0010\n\u001a\u00020\u0003H&J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "", "onBooleanUpdate", "", "key", "", "value", "", "onDoubleUpdate", "", "onInvalidValue", "onJsonArrayTap", "selectionList", "", "onLongUpdate", "", "onStringUpdate", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void I();

        public abstract void K0(String string, String string2);

        public abstract void S(String string, double d2);

        public abstract void d1(String string, List<String> list2);

        public abstract void r1(String string, boolean z2);

        public abstract void v0(String string, long l2);
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Companion;", "", "()V", "INSTANCE_OF_BOOLEAN_ITEM", "", "INSTANCE_OF_DOUBLE_ITEM", "INSTANCE_OF_JSON_ARRAY_ITEM", "INSTANCE_OF_LONG_ITEM", "INSTANCE_OF_STRING_ITEM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        public c(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0086\u0001\u0018\u0000 \u000c2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000cB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000b¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$ItemTypes;", "", "typeId", "", "(Ljava/lang/String;II)V", "getTypeId", "()I", "BOOLEAN", "LONG", "DOUBLE", "STRING", "JSON_ARRAY", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum f {

        BOOLEAN(false),
        LONG(false),
        DOUBLE(false),
        STRING(false),
        JSON_ARRAY(false);

        private final int typeId;
        private static final app.dogo.com.dogo_android.i.n0.f[] $values() {
            app.dogo.com.dogo_android.i.n0.f[] arr = new n0.f[5];
            return arr;
        }

        @Override // java.lang.Enum
        public final int getTypeId() {
            return this.typeId;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class j {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[n0.f.BOOLEAN.ordinal()] = 1;
            iArr[n0.f.DOUBLE.ordinal()] = 2;
            iArr[n0.f.STRING.ordinal()] = 3;
            iArr[n0.f.LONG.ordinal()] = 4;
            iArr[n0.f.JSON_ARRAY.ordinal()] = 5;
            n0.j.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class e extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public e(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$BooleanHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleToogleSwitchBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleToogleSwitchBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleToogleSwitchBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends app.dogo.com.dogo_android.i.n0.e {

        private final g7 b;
        final app.dogo.com.dogo_android.i.n0 c;
        public a(app.dogo.com.dogo_android.i.n0 n0, g7 g72) {
            n.f(n0, "this$0");
            n.f(g72, "binding");
            this.c = n0;
            super(g72);
            this.b = g72;
            y yVar = new y(n0, this);
            g72.P.setOnCheckedChangeListener(yVar);
        }

        private static final void b(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.a n0$a2, CompoundButton compoundButton3, boolean z4) {
            Object obj2;
            n.f(n0, "this$0");
            n.f(a2, "this$1");
            Object obj3 = n0.g().get(a2.getBindingAdapterPosition());
            (m0.a)obj3.d(z4);
            a2.c().V(obj3);
            final app.dogo.com.dogo_android.i.n0.b obj1 = n0.f(n0);
            if (obj1 == null) {
            } else {
                obj1.r1(obj3.a(), z4);
            }
        }

        public static void d(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.a n0$a2, CompoundButton compoundButton3, boolean z4) {
            n0.a.b(n0, a2, compoundButton3, z4);
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final g7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$DoubleHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.i.n0.e {

        private final c7 b;
        final app.dogo.com.dogo_android.i.n0 c;
        public d(app.dogo.com.dogo_android.i.n0 n0, c7 c72) {
            n.f(n0, "this$0");
            n.f(c72, "binding");
            this.c = n0;
            super(c72);
            this.b = c72;
            z zVar = new z(n0, this);
            c72.R.setOnClickListener(zVar);
        }

        private static final void b(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.d n0$d2, View view3) {
            String str;
            double doubleValue;
            Object obj4;
            n.f(n0, "this$0");
            n.f(d2, "this$1");
            Object obj6 = n0.g().get(d2.getBindingAdapterPosition());
            EditText editText = c7Var.P;
            n.e(editText, "binding.inputBox");
            Double num = j1.I(editText);
            if (num != null) {
                obj4 = n0.f(n0);
                if (obj4 == null) {
                } else {
                    obj4.S((m0.b)obj6.a(), num.doubleValue());
                }
                d2.c().V(obj6);
            } else {
                obj4 = n0.f(n0);
                if (obj4 == null) {
                } else {
                    obj4.I();
                }
            }
        }

        public static void d(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.d n0$d2, View view3) {
            n0.d.b(n0, d2, view3);
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final c7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$JsonArrayHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextRoundedBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextRoundedBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextRoundedBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class g extends app.dogo.com.dogo_android.i.n0.e {

        private final e7 b;
        final app.dogo.com.dogo_android.i.n0 c;
        public g(app.dogo.com.dogo_android.i.n0 n0, e7 e72) {
            n.f(n0, "this$0");
            n.f(e72, "binding");
            this.c = n0;
            super(e72);
            this.b = e72;
            a0 a0Var = new a0(n0, this);
            e72.w().setOnClickListener(a0Var);
        }

        private static final void b(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.g n0$g2, View view3) {
            Object obj1;
            Object obj2;
            n.f(n0, "this$0");
            n.f(g2, "this$1");
            obj1 = n0.g().get(g2.getBindingAdapterPosition());
            final app.dogo.com.dogo_android.i.n0.b obj0 = n0.f(n0);
            if (obj0 == null) {
            } else {
                obj0.d1((m0.c)obj1.a(), obj1.d());
            }
        }

        public static void d(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.g n0$g2, View view3) {
            n0.g.b(n0, g2, view3);
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final e7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$LongHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class h extends app.dogo.com.dogo_android.i.n0.e {

        private final c7 b;
        final app.dogo.com.dogo_android.i.n0 c;
        public h(app.dogo.com.dogo_android.i.n0 n0, c7 c72) {
            n.f(n0, "this$0");
            n.f(c72, "binding");
            this.c = n0;
            super(c72);
            this.b = c72;
            b0 b0Var = new b0(n0, this);
            c72.R.setOnClickListener(b0Var);
        }

        private static final void b(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.h n0$h2, View view3) {
            String longValue;
            long longValue2;
            Object obj4;
            n.f(n0, "this$0");
            n.f(h2, "this$1");
            Object obj6 = n0.g().get(h2.getBindingAdapterPosition());
            EditText editText = c7Var.P;
            n.e(editText, "binding.inputBox");
            Long num = j1.J(editText);
            if (num != null) {
                (m0.d)obj6.d(num.longValue());
                obj4 = n0.f(n0);
                if (obj4 == null) {
                } else {
                    obj4.v0(obj6.a(), num.longValue());
                }
                h2.c().V(obj6);
            } else {
                obj4 = n0.f(n0);
                if (obj4 == null) {
                } else {
                    obj4.I();
                }
            }
        }

        public static void d(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.h n0$h2, View view3) {
            n0.h.b(n0, h2, view3);
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final c7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$StringHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class i extends app.dogo.com.dogo_android.i.n0.e {

        private final c7 b;
        final app.dogo.com.dogo_android.i.n0 c;
        public i(app.dogo.com.dogo_android.i.n0 n0, c7 c72) {
            n.f(n0, "this$0");
            n.f(c72, "binding");
            this.c = n0;
            super(c72);
            this.b = c72;
            c0 c0Var = new c0(n0, this);
            c72.R.setOnClickListener(c0Var);
        }

        private static final void b(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.i n0$i2, View view3) {
            String str;
            n.f(n0, "this$0");
            n.f(i2, "this$1");
            Object obj4 = n0.g().get(i2.getBindingAdapterPosition());
            String string = c7Var.P.getText().toString();
            (m0.e)obj4.d(string);
            app.dogo.com.dogo_android.i.n0.b obj2 = n0.f(n0);
            if (obj2 == null) {
            } else {
                obj2.K0(obj4.a(), string);
            }
            i2.c().V(obj4);
        }

        public static void d(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.i n0$i2, View view3) {
            n0.i.b(n0, i2, view3);
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final c7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class l extends b<List<? extends app.dogo.com.dogo_android.i.m0>> {

        final Object a;
        final app.dogo.com.dogo_android.i.n0 b;
        public l(Object object, Object object2, app.dogo.com.dogo_android.i.n0 n03) {
            this.a = object;
            this.b = n03;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends app.dogo.com.dogo_android.i.m0> list2, List<? extends app.dogo.com.dogo_android.i.m0> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.i.n0 obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, n0.k.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends p implements p<app.dogo.com.dogo_android.i.m0, app.dogo.com.dogo_android.i.m0, Boolean> {

        public static final app.dogo.com.dogo_android.i.n0.k a;
        static {
            n0.k kVar = new n0.k();
            n0.k.a = kVar;
        }

        k() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(app.dogo.com.dogo_android.i.m0 m0, app.dogo.com.dogo_android.i.m0 m02) {
            n.f(m0, "o");
            n.f(m02, "n");
            return n.b(m0.a(), m02.a());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((m0)object, (m0)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(n0.class), "list", "getList()Ljava/util/List;");
        n0.c = arr;
        n0.c cVar = new n0.c(0);
        n0.Companion = cVar;
    }

    public n0() {
        final int i = 0;
        super(i, 1, i);
    }

    public n0(app.dogo.com.dogo_android.i.n0.b n0$b) {
        super();
        this.a = b;
        a obj2 = a.a;
        obj2 = p.g();
        n0.l lVar = new n0.l(obj2, obj2, this);
        this.b = lVar;
    }

    public n0(app.dogo.com.dogo_android.i.n0.b n0$b, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.i.n0.b f(app.dogo.com.dogo_android.i.n0 n0) {
        return n0.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<app.dogo.com.dogo_android.i.m0> g() {
        return (List)this.b.getValue(this, n0.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        boolean z;
        int obj2;
        obj2 = g().get(i);
        if (obj2 instanceof m0.a) {
            obj2 = n0.f.BOOLEAN.getTypeId();
            return obj2;
        } else {
            if (obj2 instanceof m0.b) {
                obj2 = n0.f.DOUBLE.getTypeId();
            } else {
                if (obj2 instanceof m0.d) {
                    obj2 = n0.f.LONG.getTypeId();
                } else {
                    if (obj2 instanceof m0.e) {
                        obj2 = n0.f.STRING.getTypeId();
                    } else {
                        if (!obj2 instanceof m0.c) {
                        } else {
                            obj2 = n0.f.JSON_ARRAY.getTypeId();
                        }
                    }
                }
            }
        }
        obj2 = new NoWhenBranchMatchedException();
        throw obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.i.n0.e n0$e, int i2) {
        c7 c7Var;
        List list;
        Object obj4;
        n.f(e, "holder");
        if (e instanceof n0.a) {
            (n0.a)e.c().V((m0.a)g().get(i2));
        } else {
            if (e instanceof n0.i) {
                (n0.i)e.c().V((m0.e)g().get(i2));
            } else {
                if (e instanceof n0.d) {
                    (n0.d)e.c().V((m0.b)g().get(i2));
                } else {
                    if (e instanceof n0.h) {
                        (n0.h)e.c().V((m0.d)g().get(i2));
                    } else {
                        if (e instanceof n0.g) {
                            (n0.g)e.c().V((m0.c)g().get(i2));
                        }
                    }
                }
            }
        }
        e.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.i.n0.e i(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.i.n0.e obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = n0.j.a[n0.f.Companion.a(i2).ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
                if (obj6 != 3) {
                    if (obj6 != 4) {
                        if (obj6 != 5) {
                        } else {
                            obj5 = e7.T(from, viewGroup, i3);
                            n.e(obj5, str2);
                            obj6 = new n0.g(this, obj5);
                        }
                        obj5 = new NoWhenBranchMatchedException();
                        throw obj5;
                    }
                    obj5 = c7.T(from, viewGroup, i3);
                    n.e(obj5, str2);
                    obj6 = new n0.h(this, obj5);
                } else {
                    obj5 = c7.T(from, viewGroup, i3);
                    n.e(obj5, str2);
                    obj6 = new n0.i(this, obj5);
                }
            } else {
                obj5 = c7.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new n0.d(this, obj5);
            }
        } else {
            obj5 = g7.T(from, viewGroup, i3);
            n.e(obj5, str2);
            obj6 = new n0.a(this, obj5);
        }
        return obj6;
    }

    public final void j(List<? extends app.dogo.com.dogo_android.i.m0> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, n0.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((n0.e)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
