import os
import re

def update_readme_stats():
    # 1. Define paths and folders to skip
    base_dir = "src/main/java/com/bengre"
    exclude_folders = ["common"] # We don't count utility classes as "solved problems"

    # 2. Walk through the directory and count .java files
    problem_count = 0
    for root, dirs, files in os.walk(base_dir):
        # Skip excluded folders
        if any(ex in root for ex in exclude_folders):
            continue
        # Count java files
        problem_count += len([f for f in files if f.endswith('.java')])

    # 3. Update the README.md
    readme_path = "README.md"
    if not os.path.exists(readme_path):
        print("README.md not found!")
        return

    with open(readme_path, "r", encoding="utf-8") as f:
        content = f.read()

    # We look for the "Total Solved: X" pattern
    new_content = re.sub(r"(Total Solved:\s*)\d+", f"\\1{problem_count}", content)

    with open(readme_path, "w", encoding="utf-8") as f:
        f.write(new_content)

    print(f"✅ README updated. Total problems solved: {problem_count}")

if __name__ == "__main__":
    update_readme_stats()