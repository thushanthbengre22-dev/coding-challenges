import os
import re

def update_readme_stats():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.dirname(script_dir)

    # Pathing
    base_dir = os.path.join(project_root, "src/main/java/com/bengre")
    readme_path = os.path.join(project_root, "README.md")

    # 1. Count only actual Java problem files
    problem_count = 0
    if os.path.exists(base_dir):
        for root, dirs, files in os.walk(base_dir):
            if any(x in root for x in ["common", "util", "target"]):
                continue
            problem_count += len([f for f in files if f.endswith('.java')])

    # 2. Update README safely
    if os.path.exists(readme_path):
        with open(readme_path, "r", encoding="utf-8") as f:
            content = f.read()

        # The '.*?' makes the regex "lazy" so it doesn't match everything in the file
        pattern = r"().*?()"

        if "" in content:
            # We use \1 and \2 to keep the markers and only change the number inside
            new_content = re.sub(pattern, rf"\1 {problem_count} \2", content, flags=re.DOTALL)

            with open(readme_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            print(f"✅ README successfully updated to: {problem_count}")
        else:
            print("⚠️ Markers not found. No changes made to prevent corruption.")

if __name__ == "__main__":
    update_readme_stats()