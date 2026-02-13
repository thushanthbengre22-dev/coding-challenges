import os
import re

# Configuration: Point this to your Maven source root
SOURCE_ROOT = 'src/main/java/com/yourname'
IGNORE_FOLDERS = {'__pycache__', '.pytest_cache'}
EXTENSIONS = {'.java': 'Java', '.py': 'Python'}

def get_problem_data():
    problems = []
    # Start walking from the source root instead of the project root
    search_path = SOURCE_ROOT if os.path.exists(SOURCE_ROOT) else '.'

    for root, dirs, files in os.walk(search_path):
        for file in files:
            ext = os.path.splitext(file)[1]
            if ext in EXTENSIONS:
                # The "Category" is the name of the subfolder (e.g., "twopointer")
                category = os.path.basename(root).replace('_', ' ').title()

                # The name is the filename (e.g., "ValidPalindrome")
                name = os.path.splitext(file)[0].replace('_', ' ')
                # Add spaces between CamelCase names (e.g., "Valid Palindrome")
                name = re.sub(r'(?<!^)(?=[A-Z])', ' ', name)

                # The path for the GitHub link needs to be relative to the project root
                full_path = os.path.join(root, file).replace('\\', '/')

                problems.append({
                    'name': name,
                    'category': category,
                    'language': EXTENSIONS[ext],
                    'path': full_path
                })
    return sorted(problems, key=lambda x: (x['category'], x['name']))

# ... (keep the generate_markdown_table and update_readme functions from the previous version)