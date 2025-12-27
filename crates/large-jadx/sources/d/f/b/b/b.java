package d.f.b.b;

import android.util.Pair;
import java.util.HashMap;

/* compiled from: DesignTool.java */
/* loaded from: classes.dex */
public class b {

    static final HashMap<Pair<Integer, Integer>, String> a = new HashMap<>();
    static final HashMap<String, String> b = new HashMap<>();
    static {
        Integer num = 4;
        final String str11 = "layout_constraintBottom_toBottomOf";
        obj.put(Pair.create(num, num), str11);
        Integer num5 = 3;
        final String str13 = "layout_constraintBottom_toTopOf";
        obj.put(Pair.create(num, num5), str13);
        String str12 = "layout_constraintTop_toBottomOf";
        obj.put(Pair.create(num5, num), str12);
        String str10 = "layout_constraintTop_toTopOf";
        obj.put(Pair.create(num5, num5), str10);
        Integer num2 = 6;
        final String str15 = "layout_constraintStart_toStartOf";
        obj.put(Pair.create(num2, num2), str15);
        Integer num6 = 7;
        final String str17 = "layout_constraintStart_toEndOf";
        obj.put(Pair.create(num2, num6), str17);
        String str16 = "layout_constraintEnd_toStartOf";
        obj.put(Pair.create(num6, num2), str16);
        String str14 = "layout_constraintEnd_toEndOf";
        obj.put(Pair.create(num6, num6), str14);
        Integer num3 = 1;
        final String str19 = "layout_constraintLeft_toLeftOf";
        obj.put(Pair.create(num3, num3), str19);
        Integer num7 = 2;
        final String str21 = "layout_constraintLeft_toRightOf";
        obj.put(Pair.create(num3, num7), str21);
        final String str22 = "layout_constraintRight_toRightOf";
        obj.put(Pair.create(num7, num7), str22);
        String str18 = "layout_constraintRight_toLeftOf";
        obj.put(Pair.create(num7, num3), str18);
        Integer num4 = 5;
        obj.put(Pair.create(num4, num4), "layout_constraintBaseline_toBaselineOf");
        String str = "layout_marginBottom";
        obj2.put(str11, str);
        obj2.put(str13, str);
        String str2 = "layout_marginTop";
        obj2.put(str12, str2);
        obj2.put(str10, str2);
        String str3 = "layout_marginStart";
        obj2.put(str15, str3);
        obj2.put(str17, str3);
        obj2.put(str16, "layout_marginEnd");
        obj2.put(str14, "layout_marginEnd");
        obj2.put(str19, "layout_marginLeft");
        obj2.put(str21, "layout_marginLeft");
        obj2.put(str22, "layout_marginRight");
        obj2.put(str18, "layout_marginRight");
    }

    public b(j jVar) {
        super();
    }
}
