import os
import re

def update_readme_stats():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.dirname(script_dir)

    base_dir = os.path.join(project_root, "src/main/java/com/bengre")
    readme_path = os.path.join(project_root, "README.md")

    # 1. Count Java files (excluding utilities)
    problem_count = 0
    for root, dirs, files in os.walk(base_dir):
        if "common" in root or "util" in root:
            continue
        problem_count += len([f for f in files if f.endswith('.java')])

    # 2. Read README
    with open(readme_path, "r", encoding="utf-8") as f:
        content = f.read()

    # 3. Targeted Replace using HTML Hooks
    # This pattern only matches the text between the START and END comments
    pattern = r"().*?()"
    replacement = f"\\1 {problem_count} \\2"

    if re.search(pattern, content):
        new_content = re.sub(pattern, replacement, content)
        with open(readme_path, "w", encoding="utf-8") as f:
            f.write(new_content)
        print(f"✅ README updated precisely: {problem_count} problems.")
    else:
        print("❌ Error: Could not find HTML hooks in README.md")

if __name__ == "__main__":
    update_readme_stats()