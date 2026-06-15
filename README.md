# SecureBuddy – AP CSA Mini Capstone

## Overview
SecureBuddy is a Java-based password manager built for AP CSA. It allows users to securely store, view, and search account credentials while also evaluating password strength.

## Features
- Add password entries (ID, account name, username, password)
- View all saved entries
- Search entries by account name
- Password strength evaluation (0–3 score)
- File persistence using CSV storage

## Password Strength Rules
Password strength is calculated using:
- Minimum length (8+ characters)
- Contains uppercase letters
- Contains special characters

Score:
- 3 = Strong
- 2 = Moderate
- 0–1 = Weak

## File Storage
Data is stored in a local file in CSV format:
