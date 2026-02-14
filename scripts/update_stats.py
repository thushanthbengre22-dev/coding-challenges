import os
import re

def update_readme_stats():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.dirname(script_dir)
    base_dir = os.path.join(project_root, "src/main/java/com/bengre")
    readme_path = os.path.join(project_root, "README.md")

    # 1. Count Java files
    problem_count = 0
    if os.path.exists(base_dir):
        for root, dirs, files in os.walk(base_dir):
            if any(x in root for x in ["common", "util", "target"]):
                continue
            problem_count += len([f for f in files if f.endswith('.java')])

    # 2. Targeted Update
    if os.path.exists(readme_path):
        with open(readme_path, "r", encoding="utf-8") as f:
            content = f.read()

        # The Regex:
        # Looks for the START comment, then the number, then the END comment.
        # It only replaces the number in the middle.
        start_tag = r"\[//\]: # \(STATS_START\)"
        end_tag = r"\[//\]: # \(STATS_END\)"
        pattern = rf"({start_tag})\s*.*?\s*({end_tag})"

        if "STATS_START" in content:
            # \1 keeps the start tag, \2 keeps the end tag
            replacement = rf"\1 {problem_count} \2"
            new_content = re.sub(pattern, replacement, content)

            with open(readme_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            print(f"✅ Success! Updated count to {problem_count} (Markers are hidden)")
        else:
            print("❌ Error: Hidden markers not found in README.md")

if __name__ == "__main__":
    update_readme_stats()