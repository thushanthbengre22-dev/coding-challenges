import os
import re

def update_readme_stats():
    # 1. Dynamic Path Resolution
    # This finds the absolute path of the script and goes up one level to the root
    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.dirname(script_dir)

    base_dir = os.path.join(project_root, "src/main/java/com/bengre")
    readme_path = os.path.join(project_root, "README.md")

    # Folders to skip (utilities or shared nodes)
    exclude_folders = ["common", "util"]

    # 2. Recursive Count
    problem_count = 0
    if not os.path.exists(base_dir):
        print(f"❌ Error: Source directory not found at {base_dir}")
        return

    for root, dirs, files in os.walk(base_dir):
        # Skip excluded folders
        if any(ex in root for ex in exclude_folders):
            continue
        # Count java files
        java_files = [f for f in files if f.endswith('.java')]
        problem_count += len(java_files)

    # 3. Update the README.md
    if not os.path.exists(readme_path):
        print(f"❌ Error: README.md not found at {readme_path}")
        return

    with open(readme_path, "r", encoding="utf-8") as f:
        content = f.read()

    # Using the "Hook" method is safer.
    # This looks for [number] # Or your existing "Total Solved: X" string.

    # Pattern 1: Look for the HTML comments (Recommended)
    hook_pattern = r"().*?()"

    # Pattern 2: Your existing text-based pattern as a fallback
    text_pattern = r"(Total Solved:\s*)\d+"

    if re.search(hook_pattern, content):
        new_content = re.sub(hook_pattern, f"\\1 {problem_count} \\2", content)
    else:
        new_content = re.sub(text_pattern, f"\\1{problem_count}", content)

    with open(readme_path, "w", encoding="utf-8") as f:
        f.write(new_content)

    print(f"🚀 Success! Found {problem_count} problems. README updated at {readme_path}")

if __name__ == "__main__":
    update_readme_stats()