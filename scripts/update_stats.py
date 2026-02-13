import os
import re

# Configuration
IGNORE_FOLDERS = {'.git', '.github', 'scripts', 'images', '.venv'}
EXTENSIONS = {'.java': 'Java', '.py': 'Python', '.cpp': 'C++'}

def get_problem_data():
    problems = []
    # Walk through the directory to find solution files
    for root, dirs, files in os.walk('.'):
        dirs[:] = [d for d in dirs if d not in IGNORE_FOLDERS]

        for file in files:
            ext = os.path.splitext(file)[1]
            if ext in EXTENSIONS:
                path = os.path.join(root, file).replace('\\', '/')
                # Category is the folder name (e.g., "Arrays")
                category = os.path.basename(root) if root != '.' else 'General'
                # Problem name is the filename without extension
                name = os.path.splitext(file)[0].replace('_', ' ').title()

                problems.append({
                    'name': name,
                    'category': category,
                    'language': EXTENSIONS[ext],
                    'path': path
                })
    return sorted(problems, key=lambda x: (x['category'], x['name']))

def generate_markdown_table(problems):
    header = "| Problem | Category | Language | Solution |\n"
    separator = "| :--- | :--- | :--- | :--- |\n"
    rows = ""
    for p in problems:
        rows += f"| {p['name']} | {p['category']} | {p['language']} | [View Code]({p['path']}) |\n"
    return header + separator + rows

def update_readme(count, table_md):
    # Ensure script finds README regardless of where it's run
    if os.path.basename(os.getcwd()) == 'scripts':
        os.chdir('..')

    with open("README.md", "r", encoding="utf-8") as f:
        content = f.read()

    # Update Statistics
    stats_pattern = r".*?"
    stats_replacement = f"\n**Total Problems Solved: {count}**\n"
    content = re.sub(stats_pattern, stats_replacement, content, flags=re.DOTALL)

    # Update Table
    table_pattern = r".*?"
    table_replacement = f"\n{table_md}\n"
    content = re.sub(table_pattern, table_replacement, content, flags=re.DOTALL)

    with open("README.md", "w", encoding="utf-8") as f:
        f.write(content)

if __name__ == "__main__":