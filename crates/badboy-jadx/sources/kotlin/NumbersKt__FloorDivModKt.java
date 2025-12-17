package kotlin;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0008H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0008H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\u0008¨\u0006\t", d2 = {"floorDiv", "", "", "other", "", "", "mod", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends kotlin.NumbersKt__BigIntegersKt {
    private static final int floorDiv(byte $this$floorDiv, byte other) {
        int i2;
        int i;
        i2 = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i2 * other != $this$floorDiv) {
            if (i2 * other != $this$floorDiv) {
                i2--;
            }
        }
        return i2;
    }

    private static final int floorDiv(byte $this$floorDiv, int other) {
        int i;
        int i2;
        i = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i * other != $this$floorDiv) {
            if (i * other != $this$floorDiv) {
                i--;
            }
        }
        return i;
    }

    private static final int floorDiv(byte $this$floorDiv, short other) {
        int i;
        int i2;
        i = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i * other != $this$floorDiv) {
            if (i * other != $this$floorDiv) {
                i--;
            }
        }
        return i;
    }

    private static final int floorDiv(int $this$floorDiv, byte other) {
        int i2;
        int i;
        i2 = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i2 * other != $this$floorDiv) {
            if (i2 * other != $this$floorDiv) {
                i2--;
            }
        }
        return i2;
    }

    private static final int floorDiv(int $this$floorDiv, int other) {
        int q;
        int i;
        q = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && q * other != $this$floorDiv) {
            if (q * other != $this$floorDiv) {
                q--;
            }
        }
        return q;
    }

    private static final int floorDiv(int $this$floorDiv, short other) {
        int i2;
        int i;
        i2 = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i2 * other != $this$floorDiv) {
            if (i2 * other != $this$floorDiv) {
                i2--;
            }
        }
        return i2;
    }

    private static final int floorDiv(short $this$floorDiv, byte other) {
        int i;
        int i2;
        i = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i * other != $this$floorDiv) {
            if (i * other != $this$floorDiv) {
                i--;
            }
        }
        return i;
    }

    private static final int floorDiv(short $this$floorDiv, int other) {
        int i;
        int i2;
        i = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i * other != $this$floorDiv) {
            if (i * other != $this$floorDiv) {
                i--;
            }
        }
        return i;
    }

    private static final int floorDiv(short $this$floorDiv, short other) {
        int i2;
        int i;
        i2 = $this$floorDiv / other;
        if ($this$floorDiv ^ other < 0 && i2 * other != $this$floorDiv) {
            if (i2 * other != $this$floorDiv) {
                i2--;
            }
        }
        return i2;
    }

    private static final long floorDiv(byte $this$floorDiv, long other) {
        long cmp2;
        int i;
        int cmp;
        cmp2 = (long)$this$floorDiv;
        i = cmp2 / other;
        if (Long.compare(i2, i3) < 0 && Long.compare(cmp, cmp2) != 0) {
            if (Long.compare(cmp, cmp2) != 0) {
                i += cmp2;
            }
        }
        return i;
    }

    private static final long floorDiv(int $this$floorDiv, long other) {
        long cmp2;
        int i;
        int cmp;
        cmp2 = (long)$this$floorDiv;
        i = cmp2 / other;
        if (Long.compare(i2, i3) < 0 && Long.compare(cmp, cmp2) != 0) {
            if (Long.compare(cmp, cmp2) != 0) {
                i += cmp2;
            }
        }
        return i;
    }

    private static final long floorDiv(long $this$floorDiv, byte other) {
        long cmp;
        int i;
        cmp = (long)obj10;
        i = $this$floorDiv / cmp;
        if (Long.compare(i3, i4) < 0 && Long.compare(i2, $this$floorDiv) != 0) {
            if (Long.compare(i2, $this$floorDiv) != 0) {
                i += cmp;
            }
        }
        return i;
    }

    private static final long floorDiv(long $this$floorDiv, int other) {
        long cmp;
        int i;
        cmp = (long)obj10;
        i = $this$floorDiv / cmp;
        if (Long.compare(i3, i4) < 0 && Long.compare(i2, $this$floorDiv) != 0) {
            if (Long.compare(i2, $this$floorDiv) != 0) {
                i += cmp;
            }
        }
        return i;
    }

    private static final long floorDiv(long $this$floorDiv, long other) {
        int q;
        int cmp;
        q = $this$floorDiv / obj8;
        if (Long.compare(i, i3) < 0 && Long.compare(i2, $this$floorDiv) != 0) {
            if (Long.compare(i2, $this$floorDiv) != 0) {
                q += cmp;
            }
        }
        return q;
    }

    private static final long floorDiv(long $this$floorDiv, short other) {
        long cmp;
        int i;
        cmp = (long)obj10;
        i = $this$floorDiv / cmp;
        if (Long.compare(i3, i4) < 0 && Long.compare(i2, $this$floorDiv) != 0) {
            if (Long.compare(i2, $this$floorDiv) != 0) {
                i += cmp;
            }
        }
        return i;
    }

    private static final long floorDiv(short $this$floorDiv, long other) {
        long cmp2;
        int i;
        int cmp;
        cmp2 = (long)$this$floorDiv;
        i = cmp2 / other;
        if (Long.compare(i2, i3) < 0 && Long.compare(cmp, cmp2) != 0) {
            if (Long.compare(cmp, cmp2) != 0) {
                i += cmp2;
            }
        }
        return i;
    }

    private static final byte mod(byte $this$mod, byte other) {
        int i = $this$mod % other;
        return (byte)i2;
    }

    private static final byte mod(int $this$mod, byte other) {
        int i = $this$mod % other;
        return (byte)i2;
    }

    private static final byte mod(long $this$mod, byte other) {
        long l = (long)obj10;
        int i3 = $this$mod % l;
        return (byte)i2;
    }

    private static final byte mod(short $this$mod, byte other) {
        int i = $this$mod % other;
        return (byte)i2;
    }

    private static final double mod(double $this$mod, double other) {
        int cmp;
        int i;
        int i2;
        double signum2;
        double signum;
        final int i3 = $this$mod % obj11;
        final int i5 = 0;
        cmp = Double.compare(i3, i4) == 0 ? i2 : i5;
        if (cmp == 0) {
            if (Double.compare(signum2, signum) == 0) {
            } else {
                i2 = i5;
            }
            i = i2 == 0 ? i3 + obj11 : i3;
        } else {
        }
        return i;
    }

    private static final double mod(double $this$mod, float other) {
        int i;
        int cmp;
        int i2;
        double signum2;
        double signum;
        final double d = (double)obj13;
        i = $this$mod % d;
        final int i4 = 0;
        cmp = Double.compare(i, i3) == 0 ? i2 : i4;
        if (cmp == 0) {
            if (Double.compare(signum2, signum) == 0) {
            } else {
                i2 = i4;
            }
            if (i2 == 0) {
                i += d;
            }
        }
        return i;
    }

    private static final double mod(float $this$mod, double other) {
        int i;
        int cmp;
        int i2;
        double signum;
        double signum2;
        d %= other;
        final int i4 = 0;
        cmp = Double.compare(i, i3) == 0 ? i2 : i4;
        if (cmp == 0) {
            if (Double.compare(signum, signum2) == 0) {
            } else {
                i2 = i4;
            }
            if (i2 == 0) {
                i += other;
            }
        }
        return i;
    }

    private static final float mod(float $this$mod, float other) {
        int cmp;
        int i;
        int i2;
        float signum;
        final int i3 = $this$mod % other;
        final int i5 = 0;
        cmp = Float.compare(i3, i4) == 0 ? i2 : i5;
        if (cmp == 0) {
            if (Float.compare(signum2, signum) == 0) {
            } else {
                i2 = i5;
            }
            i = i2 == 0 ? i3 + other : i3;
        } else {
        }
        return i;
    }

    private static final int mod(byte $this$mod, int other) {
        int i = $this$mod % other;
        return i += i6;
    }

    private static final int mod(int $this$mod, int other) {
        final int i = $this$mod % other;
        return i5 += i;
    }

    private static final int mod(long $this$mod, int other) {
        long l = (long)obj10;
        int i3 = $this$mod % l;
        return (int)i4;
    }

    private static final int mod(short $this$mod, int other) {
        int i = $this$mod % other;
        return i += i6;
    }

    private static final long mod(byte $this$mod, long other) {
        l %= other;
        return i += i6;
    }

    private static final long mod(int $this$mod, long other) {
        l %= other;
        return i += i6;
    }

    private static final long mod(long $this$mod, long other) {
        final int i = $this$mod % obj8;
        return i5 += i;
    }

    private static final long mod(short $this$mod, long other) {
        l %= other;
        return i += i6;
    }

    private static final short mod(byte $this$mod, short other) {
        int i = $this$mod % other;
        return (short)i2;
    }

    private static final short mod(int $this$mod, short other) {
        int i = $this$mod % other;
        return (short)i2;
    }

    private static final short mod(long $this$mod, short other) {
        long l = (long)obj10;
        int i3 = $this$mod % l;
        return (short)i2;
    }

    private static final short mod(short $this$mod, short other) {
        int i = $this$mod % other;
        return (short)i2;
    }
}
