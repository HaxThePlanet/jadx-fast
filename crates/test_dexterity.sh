#!/bin/bash
rm -rf /tmp/dexterity_output
mkdir -p /tmp/dexterity_output

echo "=== Dexterity Processing Times (10 different apps) ==="
START_TOTAL=$(date +%s.%N)

for apk in /mnt/nvme4tb/dexterity/crates/test_apks/*.apk; do
    name=$(basename "$apk")
    echo -n "Processing $name... "
    START=$(date +%s.%N)
    /mnt/nvme4tb/dexterity/crates/target/release/dexterity "$apk" -d "/tmp/dexterity_output/$name" 2>&1 | tail -1
    END=$(date +%s.%N)
    TIME=$(echo "$END - $START" | bc)
    echo "  Time: ${TIME}s"
done

END_TOTAL=$(date +%s.%N)
TOTAL=$(echo "$END_TOTAL - $START_TOTAL" | bc)
echo ""
echo "=== DEXTERITY TOTAL TIME: ${TOTAL}s ==="
