# Java-HTTP-URL-Checker---Security-Analyzer
A lightweight security analysis tool that checks HTTP headers and detects SQL injection vulnerabilities in websites.

🛠️ Installation & Compilation

open terminal , compile and run the code..
1️⃣ Compile the Java files
javac -d bin src/*.java
2️⃣ Run the program
java -cp bin Main



⚡ How It Works?
1️⃣ Enter a website URL (e.g., https://example.com).
2️⃣ The tool analyzes HTTP headers for security risks like:

X-Frame-Options (Prevents Clickjacking)
Content-Security-Policy (CSP) (Prevents XSS attacks)
Strict-Transport-Security (HSTS) (Forces HTTPS)
3️⃣ It tests for SQL injection by sending a payload (?id=1' OR '1'='1).
4️⃣ Displays security warnings if vulnerabilities are found.

📌 Why Use This Tool?
✅ Helps identify security vulnerabilities in websites
✅ Lightweight & easy to use (No external dependencies)
✅ Great for learning about web security & ethical hacking

