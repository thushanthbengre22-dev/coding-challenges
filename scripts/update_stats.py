import os
import re

def update_readme_stats():
    # 1. Paths
    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.dirname(script_dir)
    base_dir = os.path.join(project_root, "src/main/java/com/bengre")
    readme_path = os.path.join(project_root, "README.md")

    # 2. Count Java files (ignoring common/util/target)
    problem_count = 0
    if os.path.exists(base_dir):
        for root, dirs, files in os.walk(base_dir):
            if any(x in root for x in ["common", "util", "target"]):
                continue
            problem_count += len([f for f in files if f.endswith('.java')])

    # 3. Read and Update README
    if os.path.exists(readme_path):
        with open(readme_path, "r", encoding="utf-8") as f:
            content = f.read()

        # THE FIX:
        # (.*?) is a "LAZY" match. It stops as soon as it sees the END tag.
        # Without the '?', it matches everything from the first START to the last END.
        pattern = r"()(.*?)()"

        if "" in content:
            # We use a lambda or specific replacement to ensure no "double-matching"
            new_text = f" {problem_count} "
            new_content = re.sub(pattern, rf"\1{new_text}\3", content, flags=re.DOTALL)

            with open(readme_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            print(f"✅ README count updated to: {problem_count}")
        else:
            print("❌ Markers not found. Use 0 ")

if __name__ == "__main__":
    update_readme_stats()