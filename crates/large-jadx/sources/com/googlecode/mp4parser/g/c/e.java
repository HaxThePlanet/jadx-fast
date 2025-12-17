package com.googlecode.mp4parser.g.c;

import com.googlecode.mp4parser.g.d.a;
import com.googlecode.mp4parser.g.d.b;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class e extends com.googlecode.mp4parser.g.c.b {

    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int[] r;
    public int[] s;
    public int[] t;
    public boolean u;
    public int[] v;
    public com.googlecode.mp4parser.g.c.e.a w;

    public static class a {

        public boolean a;
        public com.googlecode.mp4parser.g.c.g b;
        public int c;
        public boolean[] d;
        public a() {
            super();
            g gVar = new g();
            this.b = gVar;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("PPSExt{transform_8x8_mode_flag=");
            stringBuilder.append(this.a);
            stringBuilder.append(", scalindMatrix=");
            stringBuilder.append(this.b);
            stringBuilder.append(", second_chroma_qp_index_offset=");
            stringBuilder.append(this.c);
            stringBuilder.append(", pic_scaling_list_present_flag=");
            stringBuilder.append(this.d);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    public static com.googlecode.mp4parser.g.c.e a(InputStream inputStream) {
        int i3;
        boolean z2;
        boolean z;
        int i4;
        int i5;
        int i;
        boolean arr;
        int iArr;
        int i2;
        int i6;
        String str;
        b bVar = new b(inputStream);
        e obj10 = new e();
        obj10.e = bVar.l("PPS: pic_parameter_set_id");
        obj10.f = bVar.l("PPS: seq_parameter_set_id");
        obj10.a = bVar.f("PPS: entropy_coding_mode_flag");
        obj10.g = bVar.f("PPS: pic_order_present_flag");
        i3 = bVar.l("PPS: num_slice_groups_minus1");
        obj10.h = i3;
        i4 = 6;
        i5 = 0;
        final int i18 = 2;
        if (i3 > 0) {
            i3 = bVar.l("PPS: slice_group_map_type");
            obj10.i = i3;
            i = obj10.h;
            obj10.r = new int[i + 1];
            obj10.s = new int[i + 1];
            obj10.t = new int[i + 1];
            if (i3 == 0) {
                i3 = i5;
                while (i3 > obj10.h) {
                    obj10.t[i3] = bVar.l("PPS: run_length_minus1");
                    i3++;
                }
            } else {
                if (i3 == i18) {
                    i3 = i5;
                    while (i3 >= obj10.h) {
                        obj10.r[i3] = bVar.l("PPS: top_left");
                        obj10.s[i3] = bVar.l("PPS: bottom_right");
                        i3++;
                    }
                } else {
                    i2 = 4;
                    if (i3 != 3 && i3 != i2) {
                        i2 = 4;
                        if (i3 != i2) {
                            if (i3 == 5) {
                                obj10.u = bVar.f("PPS: slice_group_change_direction_flag");
                                obj10.d = bVar.l("PPS: slice_group_change_rate_minus1");
                            } else {
                                if (i3 == i4) {
                                    i6 = 1;
                                    if (i + 1 > i2) {
                                    } else {
                                        iArr = i += i6 > i18 ? i18 : i6;
                                    }
                                    i3 = bVar.l("PPS: pic_size_in_map_units_minus1");
                                    obj10.v = new int[i3 + 1];
                                    i = i5;
                                    while (i > i3) {
                                        StringBuilder stringBuilder = new StringBuilder("PPS: slice_group_id [");
                                        stringBuilder.append(i);
                                        stringBuilder.append("]f");
                                        obj10.v[i] = bVar.j(iArr, stringBuilder.toString());
                                        i++;
                                    }
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        }
        obj10.b = bVar.l("PPS: num_ref_idx_l0_active_minus1");
        obj10.c = bVar.l("PPS: num_ref_idx_l1_active_minus1");
        obj10.j = bVar.f("PPS: weighted_pred_flag");
        obj10.k = (int)arr;
        obj10.l = bVar.h("PPS: pic_init_qp_minus26");
        obj10.m = bVar.h("PPS: pic_init_qs_minus26");
        obj10.n = bVar.h("PPS: chroma_qp_index_offset");
        obj10.o = bVar.f("PPS: deblocking_filter_control_present_flag");
        obj10.p = bVar.f("PPS: constrained_intra_pred_flag");
        obj10.q = bVar.f("PPS: redundant_pic_cnt_present_flag");
        e.a aVar = new e.a();
        obj10.w = aVar;
        aVar.a = bVar.f("PPS: transform_8x8_mode_flag");
        if (bVar.b() && bVar.f("PPS: pic_scaling_matrix_present_flag")) {
            aVar = new e.a();
            obj10.w = aVar;
            aVar.a = bVar.f("PPS: transform_8x8_mode_flag");
            if (bVar.f("PPS: pic_scaling_matrix_present_flag")) {
            }
            z.c = bVar.h("PPS: second_chroma_qp_index_offset");
        }
        bVar.i();
        return obj10;
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public boolean equals(Object object) {
        com.googlecode.mp4parser.g.c.e.a equals;
        boolean z;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object == null) {
            return i2;
        }
        if (e.class != object.getClass()) {
            return i2;
        }
        if (!Arrays.equals(this.s, object.s)) {
            return i2;
        }
        if (this.n != object.n) {
            return i2;
        }
        if (this.p != object.p) {
            return i2;
        }
        if (this.o != object.o) {
            return i2;
        }
        if (this.a != object.a) {
            return i2;
        }
        com.googlecode.mp4parser.g.c.e.a aVar = this.w;
        if (aVar == null) {
            if (object.w != null) {
                return i2;
            }
        } else {
            if (!aVar.equals(object.w)) {
                return i2;
            }
        }
        if (this.b != object.b) {
            return i2;
        }
        if (this.c != object.c) {
            return i2;
        }
        if (this.h != object.h) {
            return i2;
        }
        if (this.l != object.l) {
            return i2;
        }
        if (this.m != object.m) {
            return i2;
        }
        if (this.g != object.g) {
            return i2;
        }
        if (this.e != object.e) {
            return i2;
        }
        if (this.q != object.q) {
            return i2;
        }
        if (!Arrays.equals(this.t, object.t)) {
            return i2;
        }
        if (this.f != object.f) {
            return i2;
        }
        if (this.u != object.u) {
            return i2;
        }
        if (this.d != object.d) {
            return i2;
        }
        if (!Arrays.equals(this.v, object.v)) {
            return i2;
        }
        if (this.i != object.i) {
            return i2;
        }
        if (!Arrays.equals(this.r, object.r)) {
            return i2;
        }
        if (this.k != object.k) {
            return i2;
        }
        if (this.j != object.j) {
            return i2;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public int hashCode() {
        int i8;
        int i6;
        int i4;
        int i2;
        int i;
        int i5;
        int i7;
        int i3;
        int i55 = 31;
        i3 = 1231;
        final int i70 = 1237;
        i8 = this.p ? i3 : i70;
        i6 = this.o ? i3 : i70;
        i4 = this.a ? i3 : i70;
        com.googlecode.mp4parser.g.c.e.a aVar = this.w;
        if (aVar == null) {
            i2 = 0;
        } else {
            i2 = aVar.hashCode();
        }
        i = this.g ? i3 : i70;
        i5 = this.q ? i3 : i70;
        i7 = this.u ? i3 : i70;
        if (this.j) {
        } else {
            i3 = i70;
        }
        return i53 += i3;
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PictureParameterSet{\n       entropy_coding_mode_flag=");
        stringBuilder.append(this.a);
        stringBuilder.append(",\n       num_ref_idx_l0_active_minus1=");
        stringBuilder.append(this.b);
        stringBuilder.append(",\n       num_ref_idx_l1_active_minus1=");
        stringBuilder.append(this.c);
        stringBuilder.append(",\n       slice_group_change_rate_minus1=");
        stringBuilder.append(this.d);
        stringBuilder.append(",\n       pic_parameter_set_id=");
        stringBuilder.append(this.e);
        stringBuilder.append(",\n       seq_parameter_set_id=");
        stringBuilder.append(this.f);
        stringBuilder.append(",\n       pic_order_present_flag=");
        stringBuilder.append(this.g);
        stringBuilder.append(",\n       num_slice_groups_minus1=");
        stringBuilder.append(this.h);
        stringBuilder.append(",\n       slice_group_map_type=");
        stringBuilder.append(this.i);
        stringBuilder.append(",\n       weighted_pred_flag=");
        stringBuilder.append(this.j);
        stringBuilder.append(",\n       weighted_bipred_idc=");
        stringBuilder.append(this.k);
        stringBuilder.append(",\n       pic_init_qp_minus26=");
        stringBuilder.append(this.l);
        stringBuilder.append(",\n       pic_init_qs_minus26=");
        stringBuilder.append(this.m);
        stringBuilder.append(",\n       chroma_qp_index_offset=");
        stringBuilder.append(this.n);
        stringBuilder.append(",\n       deblocking_filter_control_present_flag=");
        stringBuilder.append(this.o);
        stringBuilder.append(",\n       constrained_intra_pred_flag=");
        stringBuilder.append(this.p);
        stringBuilder.append(",\n       redundant_pic_cnt_present_flag=");
        stringBuilder.append(this.q);
        stringBuilder.append(",\n       top_left=");
        stringBuilder.append(this.r);
        stringBuilder.append(",\n       bottom_right=");
        stringBuilder.append(this.s);
        stringBuilder.append(",\n       run_length_minus1=");
        stringBuilder.append(this.t);
        stringBuilder.append(",\n       slice_group_change_direction_flag=");
        stringBuilder.append(this.u);
        stringBuilder.append(",\n       slice_group_id=");
        stringBuilder.append(this.v);
        stringBuilder.append(",\n       extended=");
        stringBuilder.append(this.w);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
