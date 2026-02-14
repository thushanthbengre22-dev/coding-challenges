import os

def update_readme_stats():
    # 1. Paths
    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.dirname(script_dir)
    base_dir = os.path.join(project_root, "src/main/java/com/bengre")
    readme_path = os.path.join(project_root, "README.md")

    # 2. Count Java files
    count = 0
    if os.path.exists(base_dir):
        for root, dirs, files in os.walk(base_dir):
            if any(x in root for x in ["common", "util", "target"]):
                continue
            count += len([f for f in files if f.endswith('.java')])

    # 3. Update README
    if os.path.exists(readme_path):
        with open(readme_path, "r", encoding="utf-8") as f:
            content = f.read()

        # These hex strings represent: and # This prevents your editor from stripping the tags out of the code.
        START_MARKER = "\x3c\x21\x2d\x2d\x53\x54\x41\x54\x53\x5f\x53\x54\x41\x52\x54\x2d\x2d\x3e"
        END_MARKER = "\x3c\x21\x2d\x2d\x53\x54\x41\x54\x53\x5f\x45\x4e\x44\x2d\x2d\x3e"

        if START_MARKER in content and END_MARKER in content:
            # Split using the hex-encoded markers
            parts_before = content.split(START_MARKER)
            before_text = parts_before[0]

            parts_after = parts_before[1].split(END_MARKER)
            after_text = parts_after[1]

            # Rebuild the file
            new_content = f"{before_text}{START_MARKER}{count}{END_MARKER}{after_text}"

            with open(readme_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            print(f"✅ Success! Updated count to {count}")
        else:
            print(f"❌ Error: Markers not found in README.md")
            print(f"Ensure your README has: {START_MARKER}0{END_MARKER}")

if __name__ == "__main__":
    update_readme_stats()