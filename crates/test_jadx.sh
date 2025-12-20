#!/bin/bash
JADX=/home/chad/jadx/build/jadx/bin/jadx
mkdir -p /tmp/jadx_output
rm -rf /tmp/jadx_output/*

echo "=== JADX Processing Times (10 different apps) ==="
START_TOTAL=$(date +%s.%N)

for apk in /mnt/nvme4tb/dexterity/crates/test_apks/*.apk; do
    name=$(basename "$apk")
    echo -n "Processing $name... "
    START=$(date +%s.%N)
    $JADX -d "/tmp/jadx_output/$name" "$apk" 2>&1 | tail -1
    END=$(date +%s.%N)
    TIME=$(echo "$END - $START" | bc)
    echo "  Time: ${TIME}s"
    echo ""
done

END_TOTAL=$(date +%s.%N)
TOTAL=$(echo "$END_TOTAL - $START_TOTAL" | bc)
echo ""
echo "=== JADX TOTAL TIME: ${TOTAL}s ==="
