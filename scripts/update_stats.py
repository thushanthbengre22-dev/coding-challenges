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

        # THE CRITICAL FIX: Explicitly defined markers
        # Group 1: The Start Comment
        # Group 2: The stuff we are replacing (the number)
        # Group 3: The End Comment
        start_marker = ""
        end_marker = ""

        pattern = rf"({re.escape(start_marker)})(.*?)({re.escape(end_marker)})"

        if start_marker in content:
            # We use \1 and \3 to keep the actual HTML comments in the file
            # so the script can find them again next time.
            replacement = rf"\1 {problem_count} \3"
            new_content = re.sub(pattern, replacement, content, flags=re.DOTALL)

            with open(readme_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            print(f"✅ README count updated to: {problem_count}")
        else:
            print(f"❌ Error: Could not find markers: {start_marker}")

if __name__ == "__main__":
    update_readme_stats()