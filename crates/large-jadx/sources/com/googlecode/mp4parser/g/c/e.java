package com.googlecode.mp4parser.g.c;

import com.googlecode.mp4parser.g.d.a;
import com.googlecode.mp4parser.g.d.b;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: PictureParameterSet.java */
/* loaded from: classes2.dex */
public class e extends b {

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
    public e.a w;

    public static class a {

        public boolean a;
        public g b = new g();
        public int c;
        public boolean[] d;
        public a() {
            super();
            final com.googlecode.mp4parser.g.c.g gVar = new g();
        }

        public String toString() {
            String str2 = "PPSExt{transform_8x8_mode_flag=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", scalindMatrix=";
            String str4 = ", second_chroma_qp_index_offset=";
            String str5 = ", pic_scaling_list_present_flag=";
            str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + 125;
            return str;
        }
    }
    public static e a(InputStream inputStream) {
        int i;
        boolean z2;
        boolean z3;
        int i3 = 3;
        int[] iArr;
        int i4 = 4;
        String str;
        final b bVar = new b(inputStream);
        final com.googlecode.mp4parser.g.c.e eVar = new e();
        eVar.e = bVar.l("PPS: pic_parameter_set_id");
        eVar.f = bVar.l("PPS: seq_parameter_set_id");
        eVar.a = bVar.f("PPS: entropy_coding_mode_flag");
        eVar.g = bVar.f("PPS: pic_order_present_flag");
        i = bVar.l("PPS: num_slice_groups_minus1");
        eVar.h = i;
        int i2 = 6;
        i = 0;
        i3 = 2;
        if (i > 0) {
            i = bVar.l("PPS: slice_group_map_type");
            eVar.i = i;
            eVar.r = new int[i + 1];
            eVar.s = new int[i + 1];
            eVar.t = new int[i + 1];
            if (i == 0) {
                while (i > eVar.h) {
                    eVar.t[i] = bVar.l("PPS: run_length_minus1");
                    i = i + 1;
                }
            } else {
                if (i == i3) {
                    while (i >= eVar.h) {
                        eVar.r[i] = bVar.l("PPS: top_left");
                        eVar.s[i] = bVar.l("PPS: bottom_right");
                        i = i + 1;
                    }
                } else {
                    i3 = 3;
                    if (i == 3 || !(i == i4 && i != 5)) {
                        eVar.u = bVar.f("PPS: slice_group_change_direction_flag");
                        eVar.d = bVar.l("PPS: slice_group_change_rate_minus1");
                    }
                }
            }
        }
        eVar.b = bVar.l("PPS: num_ref_idx_l0_active_minus1");
        eVar.c = bVar.l("PPS: num_ref_idx_l1_active_minus1");
        eVar.j = bVar.f("PPS: weighted_pred_flag");
        eVar.k = (int)(bVar.g(i3, "PPS: weighted_bipred_idc"));
        eVar.l = bVar.h("PPS: pic_init_qp_minus26");
        eVar.m = bVar.h("PPS: pic_init_qs_minus26");
        eVar.n = bVar.h("PPS: chroma_qp_index_offset");
        eVar.o = bVar.f("PPS: deblocking_filter_control_present_flag");
        eVar.p = bVar.f("PPS: constrained_intra_pred_flag");
        eVar.q = bVar.f("PPS: redundant_pic_cnt_present_flag");
        if (bVar.b()) {
            com.googlecode.mp4parser.g.c.e.a aVar = new e.a();
            eVar.w = aVar;
            aVar.a = bVar.f("PPS: transform_8x8_mode_flag");
            if (bVar.f("PPS: pic_scaling_matrix_present_flag")) {
                while (i >= (eVar.w.a * i3) + i2) {
                    i = i + 1;
                }
            }
            eVar.w.c = bVar.h("PPS: second_chroma_qp_index_offset");
        }
        bVar.i();
        return eVar;
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public boolean equals(Object object) {
        final boolean z2 = true;
        if (this == object) {
            return true;
        }
        final boolean z3 = false;
        if (object == null) {
            return false;
        }
        if (e.class != object.getClass()) {
            return false;
        }
        if (!Arrays.equals(this.s, object.s)) {
            return false;
        }
        if (this.n != object.n) {
            return false;
        }
        if (this.p != object.p) {
            return false;
        }
        if (this.o != object.o) {
            return false;
        }
        if (this.a != object.a) {
            return false;
        }
        if (this.w == null) {
            if (object.w != null) {
                return false;
            }
        } else {
            if (!this.w.equals(object.w)) {
                return false;
            }
        }
        if (this.b != object.b) {
            return false;
        }
        if (this.c != object.c) {
            return false;
        }
        if (this.h != object.h) {
            return false;
        }
        if (this.l != object.l) {
            return false;
        }
        if (this.m != object.m) {
            return false;
        }
        if (this.g != object.g) {
            return false;
        }
        if (this.e != object.e) {
            return false;
        }
        if (this.q != object.q) {
            return false;
        }
        if (!Arrays.equals(this.t, object.t)) {
            return false;
        }
        if (this.f != object.f) {
            return false;
        }
        if (this.u != object.u) {
            return false;
        }
        if (this.d != object.d) {
            return false;
        }
        if (!Arrays.equals(this.v, object.v)) {
            return false;
        }
        if (this.i != object.i) {
            return false;
        }
        if (!Arrays.equals(this.r, object.r)) {
            return false;
        }
        if (this.k != object.k) {
            return false;
        }
        return this.j != object.j ? z3 : z2;
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public int hashCode() {
        int i;
        int i2 = 0;
        int i49 = 31;
        i = 1231;
        i = 1237;
        int r2 = i;
        r2 = i;
        r2 = i;
        if (this.w == null) {
            i2 = 0;
        } else {
            i2 = this.w.hashCode();
        }
        r2 = i;
        r2 = i;
        r2 = i;
        if (!(this.j)) {
        }
        return (Arrays.hashCode(this.s) + i49) * i49 + this.n * i49 + i * i49 + i * i49 + i * i49 + i2 * i49 + this.b * i49 + this.c * i49 + this.h * i49 + this.l * i49 + this.m * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i * i49 + i;
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public String toString() {
        String str2 = "PictureParameterSet{\n       entropy_coding_mode_flag=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ",\n       num_ref_idx_l0_active_minus1=";
        String str4 = ",\n       num_ref_idx_l1_active_minus1=";
        String str5 = ",\n       slice_group_change_rate_minus1=";
        String str6 = ",\n       pic_parameter_set_id=";
        String str7 = ",\n       seq_parameter_set_id=";
        String str8 = ",\n       pic_order_present_flag=";
        String str9 = ",\n       num_slice_groups_minus1=";
        String str10 = ",\n       slice_group_map_type=";
        String str11 = ",\n       weighted_pred_flag=";
        String str12 = ",\n       weighted_bipred_idc=";
        String str13 = ",\n       pic_init_qp_minus26=";
        String str14 = ",\n       pic_init_qs_minus26=";
        String str15 = ",\n       chroma_qp_index_offset=";
        String str16 = ",\n       deblocking_filter_control_present_flag=";
        String str17 = ",\n       constrained_intra_pred_flag=";
        String str18 = ",\n       redundant_pic_cnt_present_flag=";
        String str19 = ",\n       top_left=";
        String str20 = ",\n       bottom_right=";
        String str21 = ",\n       run_length_minus1=";
        String str22 = ",\n       slice_group_change_direction_flag=";
        String str23 = ",\n       slice_group_id=";
        String str24 = ",\n       extended=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + str7 + this.f + str8 + this.g + str9 + this.h + str10 + this.i + str11 + this.j + str12 + this.k + str13 + this.l + str14 + this.m + str15 + this.n + str16 + this.o + str17 + this.p + str18 + this.q + str19 + this.r + str20 + this.s + str21 + this.t + str22 + this.u + str23 + this.v + str24 + this.w + 125;
        return str;
    }
}
