package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000c\n\u0002\u0008\u0006\n\u0002\u0010\r\n\u0002\u0008\u0005\n\u0002\u0010\u0006\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\n\n\u0002\u0010 \n\u0002\u0008\u0016\n\u0002\u0010\u0018\n\u0002\u0008\u0005\n\u0002\u0010\u0019\n\u0002\u0008\n\n\u0002\u0010\u0013\n\u0002\u0008\u0005\n\u0002\u0010\u0014\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0002\u0008\u0005\n\u0002\u0010\u0016\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0010$\n\u0002\u0008\n\u0008\u0087@\u0018\u00002\u00020\u0001B\u0015\u0008\u0001\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u000e\u0010\u000cJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\"\u0010 J\u0015\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008%\u0010&J\u0017\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008(\u0010)J\u0015\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008,\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008/\u00100J\u0015\u00101\u001a\u0002022\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u00083\u00104J\u0017\u00105\u001a\u0004\u0018\u0001022\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u00086\u00107J\u0015\u00108\u001a\u0002092\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008:\u0010;J\u0017\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008=\u0010>J-\u0010?\u001a\u0002H@\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\u0008D\u0010EJ$\u0010?\u001a\u0002H@\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008D\u0010FJ/\u0010G\u001a\u0004\u0018\u0001H@\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\u0008H\u0010EJ&\u0010G\u001a\u0004\u0018\u0001H@\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008H\u0010FJ-\u0010I\u001a\u0002H@\"\u0008\u0008\u0000\u0010@*\u00020J2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010K\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\u0008L\u0010MJ$\u0010I\u001a\u0002H@\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008L\u0010NJ/\u0010O\u001a\u0004\u0018\u0001H@\"\u0008\u0008\u0000\u0010@*\u00020J2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010K\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\u0008P\u0010MJ&\u0010O\u001a\u0004\u0018\u0001H@\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008P\u0010NJ\u0015\u0010Q\u001a\u00020R2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008S\u0010TJ\u0017\u0010U\u001a\u0004\u0018\u00010R2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008V\u0010TJ\u0015\u0010W\u001a\u00020X2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008Y\u0010ZJ\u0017\u0010[\u001a\u0004\u0018\u00010X2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008\\\u0010ZJ\u001f\u0010]\u001a\u000c\u0012\u0008\u0012\u00060\u0003j\u0002`\u00040^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008_\u0010`J!\u0010a\u001a\u000e\u0012\u0008\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008b\u0010`J\u0015\u0010c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008d\u0010eJ\u0017\u0010f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008g\u0010eJ\u001b\u0010h\u001a\u0008\u0012\u0004\u0012\u0002020i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008j\u0010kJ\u001d\u0010l\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008m\u0010kJ\u001b\u0010n\u001a\u0008\u0012\u0004\u0012\u00020\u001e0i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008o\u0010kJ\u001d\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008q\u0010kJ\u001f\u0010r\u001a\u000c\u0012\u0008\u0012\u00060\u0003j\u0002`\u00040i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008s\u0010kJ!\u0010t\u001a\u000e\u0012\u0008\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008u\u0010kJ\u001b\u0010v\u001a\u0008\u0012\u0004\u0012\u00020\n0i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008w\u0010kJ\u001d\u0010x\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\u0008y\u0010kJ3\u0010z\u001a\u0008\u0012\u0004\u0012\u0002H@0i\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\u0008{\u0010|J*\u0010z\u001a\u0008\u0012\u0004\u0012\u0002H@0i\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008{\u0010kJ5\u0010}\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\u0008~\u0010|J,\u0010}\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008~\u0010kJ\u0018\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u0084\u0001\u0010\u0082\u0001J\u0019\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u0087\u0001\u0010\u0088\u0001J\u001b\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u008a\u0001\u0010\u0088\u0001J\u001e\u0010\u008b\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u001e0^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u008c\u0001\u0010\u008d\u0001J \u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u008f\u0001\u0010\u008d\u0001J\u0019\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u0095\u0001\u0010\u0093\u0001J\u0019\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u0098\u0001\u0010\u0099\u0001J\u001b\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u009b\u0001\u0010\u0099\u0001J\u0019\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008\u009e\u0001\u0010\u009f\u0001J\u001b\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008¡\u0001\u0010\u009f\u0001J\u0019\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008¤\u0001\u0010¥\u0001J\u001b\u0010¦\u0001\u001a\u0005\u0018\u00010£\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008§\u0001\u0010¥\u0001J\u001e\u0010¨\u0001\u001a\u0008\u0012\u0004\u0012\u00020\n0^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008©\u0001\u0010ª\u0001J \u0010«\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008¬\u0001\u0010ª\u0001J6\u0010­\u0001\u001a\u0008\u0012\u0004\u0012\u0002H@0^\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\u0008®\u0001\u0010¯\u0001J-\u0010­\u0001\u001a\u0008\u0012\u0004\u0012\u0002H@0^\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0006\u0008®\u0001\u0010°\u0001J8\u0010±\u0001\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\u0008²\u0001\u0010¯\u0001J/\u0010±\u0001\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0006\u0008²\u0001\u0010°\u0001J7\u0010³\u0001\u001a\t\u0012\u0004\u0012\u0002H@0´\u0001\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\u0008µ\u0001\u0010¶\u0001J.\u0010³\u0001\u001a\t\u0012\u0004\u0012\u0002H@0´\u0001\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0006\u0008µ\u0001\u0010·\u0001J9\u0010¸\u0001\u001a\u000b\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\u0008\u0008\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\u0008¹\u0001\u0010¶\u0001J0\u0010¸\u0001\u001a\u000b\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\n\u0008\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\u0008¢\u0006\u0006\u0008¹\u0001\u0010·\u0001J\u001c\u0010º\u0001\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008»\u0001\u0010¼\u0001J \u0010½\u0001\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\u0008¾\u0001\u0010¼\u0001J\u0010\u0010¿\u0001\u001a\u000202¢\u0006\u0006\u0008À\u0001\u0010Á\u0001J\u0010\u0010Â\u0001\u001a\u00020\u0010¢\u0006\u0006\u0008Ã\u0001\u0010Ä\u0001J\u0017\u0010Å\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0005\u0008Æ\u0001\u0010\u0012J\u001a\u0010Ç\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0005\u0008È\u0001\u0010\u0012J\u001d\u0010É\u0001\u001a\u00020\u00102\u000b\u0010Ê\u0001\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0006\u0008Ë\u0001\u0010Ì\u0001J\u0010\u0010Í\u0001\u001a\u000202¢\u0006\u0006\u0008Î\u0001\u0010Á\u0001J\u0010\u0010Ï\u0001\u001a\u00020\n¢\u0006\u0006\u0008Ð\u0001\u0010Ñ\u0001J\u001f\u0010Ò\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ó\u0001¢\u0006\u0006\u0008Ô\u0001\u0010Õ\u0001J\u001e\u0010Ö\u0001\u001a\u00020\u00102\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\u0008×\u0001\u0010Ø\u0001J\u0013\u0010Ù\u0001\u001a\u000202HÖ\u0001¢\u0006\u0006\u0008Ú\u0001\u0010Á\u0001J\u0013\u0010Û\u0001\u001a\u00020\nHÖ\u0001¢\u0006\u0006\u0008Ü\u0001\u0010Ñ\u0001R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006Ý\u0001", d2 = {"Landroidx/savedstate/SavedStateReader;", "", "source", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "getBinder", "Landroid/os/IBinder;", "key", "", "getBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/IBinder;", "getBinderOrNull", "getBinderOrNull-impl", "getBoolean", "", "getBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Z", "getBooleanOrNull", "getBooleanOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "getChar", "", "getChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;)C", "getCharOrNull", "getCharOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Character;", "getCharSequence", "", "getCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/CharSequence;", "getCharSequenceOrNull", "getCharSequenceOrNull-impl", "getDouble", "", "getDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;)D", "getDoubleOrNull", "getDoubleOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Double;", "getFloat", "", "getFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;)F", "getFloatOrNull", "getFloatOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Float;", "getInt", "", "getInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;)I", "getIntOrNull", "getIntOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "", "getLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;)J", "getLongOrNull", "getLongOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "getParcelable", "T", "Landroid/os/Parcelable;", "parcelableClass", "Lkotlin/reflect/KClass;", "getParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableOrNull", "getParcelableOrNull-impl", "getJavaSerializable", "Ljava/io/Serializable;", "serializableClass", "getJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/io/Serializable;", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "getJavaSerializableOrNull", "getJavaSerializableOrNull-impl", "getSize", "Landroid/util/Size;", "getSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/Size;", "getSizeOrNull", "getSizeOrNull-impl", "getSizeF", "Landroid/util/SizeF;", "getSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SizeF;", "getSizeFOrNull", "getSizeFOrNull-impl", "getSavedStateArray", "", "getSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Bundle;", "getSavedStateArrayOrNull", "getSavedStateArrayOrNull-impl", "getString", "getString-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "getStringOrNull", "getStringOrNull-impl", "getIntList", "", "getIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "getIntListOrNull", "getIntListOrNull-impl", "getCharSequenceList", "getCharSequenceList-impl", "getCharSequenceListOrNull", "getCharSequenceListOrNull-impl", "getSavedStateList", "getSavedStateList-impl", "getSavedStateListOrNull", "getSavedStateListOrNull-impl", "getStringList", "getStringList-impl", "getStringListOrNull", "getStringListOrNull-impl", "getParcelableList", "getParcelableList-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/util/List;", "getParcelableListOrNull", "getParcelableListOrNull-impl", "getBooleanArray", "", "getBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Z", "getBooleanArrayOrNull", "getBooleanArrayOrNull-impl", "getCharArray", "", "getCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[C", "getCharArrayOrNull", "getCharArrayOrNull-impl", "getCharSequenceArray", "getCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/CharSequence;", "getCharSequenceArrayOrNull", "getCharSequenceArrayOrNull-impl", "getDoubleArray", "", "getDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[D", "getDoubleArrayOrNull", "getDoubleArrayOrNull-impl", "getFloatArray", "", "getFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[F", "getFloatArrayOrNull", "getFloatArrayOrNull-impl", "getIntArray", "", "getIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[I", "getIntArrayOrNull", "getIntArrayOrNull-impl", "getLongArray", "", "getLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[J", "getLongArrayOrNull", "getLongArrayOrNull-impl", "getStringArray", "getStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/String;", "getStringArrayOrNull", "getStringArrayOrNull-impl", "getParcelableArray", "getParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)[Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "getParcelableArrayOrNull", "getParcelableArrayOrNull-impl", "getSparseParcelableArray", "Landroid/util/SparseArray;", "getSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/util/SparseArray;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SparseArray;", "getSparseParcelableArrayOrNull", "getSparseParcelableArrayOrNull-impl", "getSavedState", "getSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Bundle;", "getSavedStateOrNull", "getSavedStateOrNull-impl", "size", "size-impl", "(Landroid/os/Bundle;)I", "isEmpty", "isEmpty-impl", "(Landroid/os/Bundle;)Z", "isNull", "isNull-impl", "contains", "contains-impl", "contentDeepEquals", "other", "contentDeepEquals-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)Z", "contentDeepHashCode", "contentDeepHashCode-impl", "contentDeepToString", "contentDeepToString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "toMap", "", "toMap-impl", "(Landroid/os/Bundle;)Ljava/util/Map;", "equals", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "toString-impl", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class SavedStateReader {

    private final Bundle source;
    private SavedStateReader(Bundle source) {
        super();
        this.source = source;
    }

    public static final androidx.savedstate.SavedStateReader box-impl(Bundle bundle) {
        SavedStateReader savedStateReader = new SavedStateReader(bundle);
        return savedStateReader;
    }

    public static Bundle constructor-impl(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "source");
        return bundle;
    }

    public static final boolean contains-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.containsKey(key);
    }

    public static final boolean contentDeepEquals-impl(Bundle arg0, Bundle other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepEquals(arg0, other);
    }

    public static final int contentDeepHashCode-impl(Bundle arg0) {
        return SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepHashCode(arg0);
    }

    public static final String contentDeepToString-impl(Bundle arg0) {
        StringBuilder stringBuilder = new StringBuilder(i += 2);
        final int i4 = 0;
        ArrayList arrayList = new ArrayList();
        SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepToString(arg0, stringBuilder, (List)arrayList);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static boolean equals-impl(Bundle bundle, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof SavedStateReader) {
            return i2;
        }
        if (!Intrinsics.areEqual(bundle, (SavedStateReader)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Bundle bundle, Bundle bundle2) {
        return Intrinsics.areEqual(bundle, bundle2);
    }

    public static final IBinder getBinder-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        IBinder binder = arg0.getBinder(key);
        if (binder == null) {
        } else {
            return binder;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final IBinder getBinderOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getBinder(key);
    }

    public static final boolean getBoolean-impl(Bundle arg0, String key) {
        int i;
        boolean boolean;
        Intrinsics.checkNotNullParameter(key, "key");
        boolean boolean2 = arg0.getBoolean(key, false);
        if (!boolean2) {
            i = 1;
            if (arg0.getBoolean(key, i) == i) {
            } else {
            }
            SavedStateReaderKt.keyOrValueNotFoundError(key);
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return boolean2;
    }

    public static final boolean[] getBooleanArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean[] booleanArray = arg0.getBooleanArray(key);
        if (booleanArray == null) {
        } else {
            return booleanArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final boolean[] getBooleanArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getBooleanArray(key);
    }

    public static final Boolean getBooleanOrNull-impl(Bundle arg0, String key) {
        int i2;
        int i;
        boolean boolean;
        Intrinsics.checkNotNullParameter(key, "key");
        final boolean boolean2 = arg0.getBoolean(key, false);
        i = 1;
        if (!boolean2 && arg0.getBoolean(key, i) == i) {
            i = 1;
            if (arg0.getBoolean(key, i) == i) {
                i2 = i;
            }
            if (i2 == i) {
                return null;
            }
        }
        return Boolean.valueOf(boolean2);
    }

    public static final char getChar-impl(Bundle arg0, String key) {
        int i;
        char char;
        Intrinsics.checkNotNullParameter(key, "key");
        char char2 = arg0.getChar(key, '\0');
        if (char2 == 0) {
            i = 65535;
            if (arg0.getChar(key, i) == i) {
            } else {
            }
            SavedStateReaderKt.keyOrValueNotFoundError(key);
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return char2;
    }

    public static final char[] getCharArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        char[] charArray = arg0.getCharArray(key);
        if (charArray == null) {
        } else {
            return charArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final char[] getCharArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getCharArray(key);
    }

    public static final Character getCharOrNull-impl(Bundle arg0, String key) {
        int i;
        char char;
        Intrinsics.checkNotNullParameter(key, "key");
        char char2 = arg0.getChar(key, '\0');
        i = 65535;
        if (char2 == 0 && arg0.getChar(key, i) == i) {
            i = 65535;
            if (arg0.getChar(key, i) == i) {
                return null;
            }
        }
        return Character.valueOf(char2);
    }

    public static final java.lang.CharSequence getCharSequence-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        java.lang.CharSequence charSequence = arg0.getCharSequence(key);
        if (charSequence == null) {
        } else {
            return charSequence;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final java.lang.CharSequence[] getCharSequenceArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        java.lang.CharSequence[] charSequenceArray = arg0.getCharSequenceArray(key);
        if (charSequenceArray == null) {
        } else {
            return charSequenceArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final java.lang.CharSequence[] getCharSequenceArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getCharSequenceArray(key);
    }

    public static final List<java.lang.CharSequence> getCharSequenceList-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList charSequenceArrayList = arg0.getCharSequenceArrayList(key);
        if (charSequenceArrayList == null) {
        } else {
            return (List)charSequenceArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final List<java.lang.CharSequence> getCharSequenceListOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (List)arg0.getCharSequenceArrayList(key);
    }

    public static final java.lang.CharSequence getCharSequenceOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getCharSequence(key);
    }

    public static final double getDouble-impl(Bundle arg0, String key) {
        int cmp;
        int i;
        long l;
        double double;
        Intrinsics.checkNotNullParameter(key, "key");
        int i2 = 1;
        final double double2 = arg0.getDouble(key, i2);
        final int i3 = 0;
        cmp = Double.compare(double2, i2) == 0 ? i : i3;
        if (cmp != 0) {
            l = 9218868437227405311L;
            if (Double.compare(double, l) == 0) {
            } else {
                i = i3;
            }
            if (i != 0) {
            } else {
            }
            SavedStateReaderKt.keyOrValueNotFoundError(key);
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return double2;
    }

    public static final double[] getDoubleArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        double[] doubleArray = arg0.getDoubleArray(key);
        if (doubleArray == null) {
        } else {
            return doubleArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final double[] getDoubleArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getDoubleArray(key);
    }

    public static final Double getDoubleOrNull-impl(Bundle arg0, String key) {
        int cmp;
        int i;
        long l;
        double double;
        Intrinsics.checkNotNullParameter(key, "key");
        int i2 = 1;
        final double double2 = arg0.getDouble(key, i2);
        final int i4 = 0;
        cmp = Double.compare(double2, i2) == 0 ? i : i4;
        if (cmp != 0) {
            l = 9218868437227405311L;
            if (Double.compare(double, l) == 0) {
            } else {
                i = i4;
            }
            if (i != 0) {
                return null;
            }
        }
        return Double.valueOf(double2);
    }

    public static final float getFloat-impl(Bundle arg0, String key) {
        int cmp;
        int i;
        float float;
        Intrinsics.checkNotNullParameter(key, "key");
        int i2 = 1;
        final float float2 = arg0.getFloat(key, i2);
        final int i4 = 0;
        cmp = Float.compare(float2, i2) == 0 ? i : i4;
        if (cmp != 0) {
            int i3 = 2139095039;
            if (Float.compare(float, i3) == 0) {
            } else {
                i = i4;
            }
            if (i != 0) {
            } else {
            }
            SavedStateReaderKt.keyOrValueNotFoundError(key);
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return float2;
    }

    public static final float[] getFloatArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        float[] floatArray = arg0.getFloatArray(key);
        if (floatArray == null) {
        } else {
            return floatArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final float[] getFloatArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getFloatArray(key);
    }

    public static final Float getFloatOrNull-impl(Bundle arg0, String key) {
        int cmp;
        int i;
        float float;
        Intrinsics.checkNotNullParameter(key, "key");
        int i2 = 1;
        final float float2 = arg0.getFloat(key, i2);
        final int i5 = 0;
        cmp = Float.compare(float2, i2) == 0 ? i : i5;
        if (cmp != 0) {
            int i3 = 2139095039;
            if (Float.compare(float, i3) == 0) {
            } else {
                i = i5;
            }
            if (i != 0) {
                return null;
            }
        }
        return Float.valueOf(float2);
    }

    public static final int getInt-impl(Bundle arg0, String key) {
        int i;
        int int;
        Intrinsics.checkNotNullParameter(key, "key");
        i = Integer.MIN_VALUE;
        final int int2 = arg0.getInt(key, i);
        if (int2 == i) {
            i = Integer.MAX_VALUE;
            if (arg0.getInt(key, i) == i) {
            } else {
            }
            SavedStateReaderKt.keyOrValueNotFoundError(key);
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return int2;
    }

    public static final int[] getIntArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int[] intArray = arg0.getIntArray(key);
        if (intArray == null) {
        } else {
            return intArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final int[] getIntArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getIntArray(key);
    }

    public static final List<Integer> getIntList-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList integerArrayList = arg0.getIntegerArrayList(key);
        if (integerArrayList == null) {
        } else {
            return (List)integerArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final List<Integer> getIntListOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (List)arg0.getIntegerArrayList(key);
    }

    public static final Integer getIntOrNull-impl(Bundle arg0, String key) {
        int i;
        int int;
        Intrinsics.checkNotNullParameter(key, "key");
        i = Integer.MIN_VALUE;
        final int int2 = arg0.getInt(key, i);
        i = Integer.MAX_VALUE;
        if (int2 == i && arg0.getInt(key, i) == i) {
            i = Integer.MAX_VALUE;
            if (arg0.getInt(key, i) == i) {
                return null;
            }
        }
        return Integer.valueOf(int2);
    }

    public static final <T extends java.io.Serializable> T getJavaSerializable-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getJavaSerializable-impl(arg0, key, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    public static final <T extends java.io.Serializable> T getJavaSerializable-impl(Bundle arg0, String key, KClass<T> serializableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(serializableClass, "serializableClass");
        java.io.Serializable serializable = BundleCompat.getSerializable(arg0, key, JvmClassMappingKt.getJavaClass(serializableClass));
        if (serializable == null) {
        } else {
            return serializable;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final <T extends java.io.Serializable> T getJavaSerializableOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getJavaSerializableOrNull-impl(arg0, key, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    public static final <T extends java.io.Serializable> T getJavaSerializableOrNull-impl(Bundle arg0, String key, KClass<T> serializableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(serializableClass, "serializableClass");
        return BundleCompat.getSerializable(arg0, key, JvmClassMappingKt.getJavaClass(serializableClass));
    }

    public static final long getLong-impl(Bundle arg0, String key) {
        int cmp;
        long long;
        Intrinsics.checkNotNullParameter(key, "key");
        long l = Long.MIN_VALUE;
        final long long2 = arg0.getLong(key, l);
        if (Long.compare(long2, l) == 0) {
            long l2 = Long.MAX_VALUE;
            if (Long.compare(long, l2) == 0) {
            } else {
            }
            SavedStateReaderKt.keyOrValueNotFoundError(key);
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return long2;
    }

    public static final long[] getLongArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long[] longArray = arg0.getLongArray(key);
        if (longArray == null) {
        } else {
            return longArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final long[] getLongArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getLongArray(key);
    }

    public static final Long getLongOrNull-impl(Bundle arg0, String key) {
        int cmp;
        long long;
        Intrinsics.checkNotNullParameter(key, "key");
        long l = Long.MIN_VALUE;
        final long long2 = arg0.getLong(key, l);
        long l2 = Long.MAX_VALUE;
        if (Long.compare(long2, l) == 0 && Long.compare(long, l2) == 0) {
            l2 = Long.MAX_VALUE;
            if (Long.compare(long, l2) == 0) {
                return null;
            }
        }
        return Long.valueOf(long2);
    }

    public static final <T extends android.os.Parcelable> T getParcelable-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelable-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> T getParcelable-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        Object parcelable = BundleCompat.getParcelable(arg0, key, JvmClassMappingKt.getJavaClass(parcelableClass));
        if ((Parcelable)parcelable == null) {
        } else {
            return (Parcelable)parcelable;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final <T extends android.os.Parcelable> T[] getParcelableArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableArray-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> T[] getParcelableArray-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        android.os.Parcelable[] parcelableArrayOrNull-impl = SavedStateReader.getParcelableArrayOrNull-impl(arg0, key, parcelableClass);
        if (parcelableArrayOrNull-impl == null) {
        } else {
            return parcelableArrayOrNull-impl;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final <T extends android.os.Parcelable> T[] getParcelableArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableArrayOrNull-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> T[] getParcelableArrayOrNull-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        android.os.Parcelable[] parcelableArray;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        if (parcelableArray instanceof Parcelable[]) {
        } else {
            parcelableArray = 0;
        }
        return parcelableArray;
    }

    public static final <T extends android.os.Parcelable> List<T> getParcelableList-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableList-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> List<T> getParcelableList-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        ArrayList parcelableArrayList = BundleCompat.getParcelableArrayList(arg0, key, JvmClassMappingKt.getJavaClass(parcelableClass));
        if (parcelableArrayList == null) {
        } else {
            return (List)parcelableArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final <T extends android.os.Parcelable> List<T> getParcelableListOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableListOrNull-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> List<T> getParcelableListOrNull-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        return (List)BundleCompat.getParcelableArrayList(arg0, key, JvmClassMappingKt.getJavaClass(parcelableClass));
    }

    public static final <T extends android.os.Parcelable> T getParcelableOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableOrNull-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> T getParcelableOrNull-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        return (Parcelable)BundleCompat.getParcelable(arg0, key, JvmClassMappingKt.getJavaClass(parcelableClass));
    }

    public static final Bundle getSavedState-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = arg0.getBundle(key);
        if (bundle == null) {
        } else {
            return bundle;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final Bundle[] getSavedStateArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        return (Bundle[])SavedStateReader.getParcelableArray-impl(arg0, key, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final Bundle[] getSavedStateArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        return (Bundle[])SavedStateReader.getParcelableArrayOrNull-impl(arg0, key, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final List<Bundle> getSavedStateList-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        return SavedStateReader.getParcelableList-impl(arg0, key, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final List<Bundle> getSavedStateListOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        return SavedStateReader.getParcelableListOrNull-impl(arg0, key, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final Bundle getSavedStateOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getBundle(key);
    }

    public static final Size getSize-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Size size = arg0.getSize(key);
        if (size == null) {
        } else {
            return size;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final SizeF getSizeF-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SizeF sizeF = arg0.getSizeF(key);
        if (sizeF == null) {
        } else {
            return sizeF;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final SizeF getSizeFOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getSizeF(key);
    }

    public static final Size getSizeOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getSize(key);
    }

    public static final <T extends android.os.Parcelable> SparseArray<T> getSparseParcelableArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getSparseParcelableArray-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> SparseArray<T> getSparseParcelableArray-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        SparseArray sparseParcelableArrayOrNull-impl = SavedStateReader.getSparseParcelableArrayOrNull-impl(arg0, key, parcelableClass);
        if (sparseParcelableArrayOrNull-impl == null) {
        } else {
            return sparseParcelableArrayOrNull-impl;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final <T extends android.os.Parcelable> SparseArray<T> getSparseParcelableArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getSparseParcelableArrayOrNull-impl(arg0, key, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final <T extends android.os.Parcelable> SparseArray<T> getSparseParcelableArrayOrNull-impl(Bundle arg0, String key, KClass<T> parcelableClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(parcelableClass, "parcelableClass");
        return BundleCompat.getSparseParcelableArray(arg0, key, JvmClassMappingKt.getJavaClass(parcelableClass));
    }

    public static final String getString-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = arg0.getString(key);
        if (string == null) {
        } else {
            return string;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final String[] getStringArray-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String[] stringArray = arg0.getStringArray(key);
        if (stringArray == null) {
        } else {
            return stringArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final String[] getStringArrayOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getStringArray(key);
    }

    public static final List<String> getStringList-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList stringArrayList = arg0.getStringArrayList(key);
        if (stringArrayList == null) {
        } else {
            return (List)stringArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(key);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final List<String> getStringListOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (List)arg0.getStringArrayList(key);
    }

    public static final String getStringOrNull-impl(Bundle arg0, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return arg0.getString(key);
    }

    public static int hashCode-impl(Bundle bundle) {
        return bundle.hashCode();
    }

    public static final boolean isEmpty-impl(Bundle arg0) {
        return arg0.isEmpty();
    }

    public static final boolean isNull-impl(Bundle arg0, String key) {
        boolean contains-impl;
        int i;
        Intrinsics.checkNotNullParameter(key, "key");
        if (SavedStateReader.contains-impl(arg0, key) && arg0.get(key) == null) {
            i = arg0.get(key) == null ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final int size-impl(Bundle arg0) {
        return arg0.size();
    }

    public static final Map<String, Object> toMap-impl(Bundle arg0) {
        Object next;
        Object obj;
        Map mapBuilder = MapsKt.createMapBuilder(arg0.size());
        final int i = 0;
        Iterator iterator = arg0.keySet().iterator();
        for (String next : iterator) {
            Intrinsics.checkNotNull(next);
            mapBuilder.put(next, arg0.get(next));
        }
        return MapsKt.build(mapBuilder);
    }

    public static String toString-impl(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SavedStateReader(source=").append(bundle).append(')').toString();
    }

    public boolean equals(Object object) {
        return SavedStateReader.equals-impl(this.source, object);
    }

    public int hashCode() {
        return SavedStateReader.hashCode-impl(this.source);
    }

    public String toString() {
        return SavedStateReader.toString-impl(this.source);
    }

    public final Bundle unbox-impl() {
        return this.source;
    }
}
