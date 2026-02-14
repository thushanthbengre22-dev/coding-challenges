import os
import re

def update_readme_stats():
    # 1. Setup paths relative to the script location
    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.dirname(script_dir)
    base_dir = os.path.join(project_root, "src/main/java/com/bengre")
    readme_path = os.path.join(project_root, "README.md")

    # 2. Count .java files, ignoring common/util
    problem_count = 0
    for root, dirs, files in os.walk(base_dir):
        if any(x in root for x in ["common", "util"]):
            continue
        problem_count += len([f for f in files if f.endswith('.java')])

    # 3. Read the README
    with open(readme_path, "r", encoding="utf-8") as f:
        content = f.read()

    # 4. THE FIX: Only replace what is between the specific HTML comments
    # This prevents the script from touching Java versions or complexity O(N) numbers.
    pattern = r"().*?()"
    replacement = f"\\1{problem_count}\\2"

    if "" in content:
        new_content = re.sub(pattern, replacement, content, flags=re.DOTALL)
        with open(readme_path, "w", encoding="utf-8") as f:
            f.write(new_content)
        print(f"✅ Success: Updated count to {problem_count}")
    else:
        print("❌ Error: HTML hooks not found in README.md. No changes made.")

if __name__ == "__main__":
    update_readme_stats()