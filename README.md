# College Management System

A Java console application for managing a college's lecturers, departments and committees, built with a small object-oriented class hierarchy on top of a PostgreSQL/JDBC data layer.

## Overview

The project models lecturers as a class hierarchy — `Lecturer` → `Doctor` → `Prof` — alongside `Department` and `Committee` classes. `CollegeManager` handles all persistence through JDBC against a PostgreSQL database, and `collegeProject` (the `main` class) drives an interactive text menu for managing lecturers, departments and committees, plus several reporting queries (highest paid lecturer, department with the most students, professors ranked by salary, and more).

## Class overview

- **Lecturer** — base class: name, id, degree, salary and department.
- **Doctor** — a `Lecturer` who publishes articles.
- **Prof** — a `Doctor` affiliated with an institution.
- **Department** — holds a list of lecturers and reports on them (e.g. total articles).
- **Committee** — a named committee with a chairman and member lecturers.
- **CollegeManager** — all database operations (add/update/remove/query) via JDBC.
- **collegeProject** — the `main` entry point with the interactive menu.

## Setup

You'll need a running PostgreSQL instance with a database (matching the tables the queries in `CollegeManager` expect: `departments`, `lecturers`, `committees`, `committee_members`).

Connection details are read from environment variables rather than being hard-coded, so no credentials live in the source code:

| Variable | Default | Description |
|---|---|---|
| `DB_URL` | `jdbc:postgresql://localhost:5432/college_project` | JDBC connection URL |
| `DB_USER` | `postgres` | Database user |
| `DB_PASSWORD` | *(none — required)* | Database password |

Set them before running, for example:

```bash
export DB_URL="jdbc:postgresql://localhost:5432/college_project"
export DB_USER=postgres
export DB_PASSWORD=your_password_here
```

You'll also need the [PostgreSQL JDBC driver](https://jdbc.postgresql.org/) on the classpath.

## Running

Compile and run `collegeProject`, which starts the interactive menu (add lecturers, departments and committees, assign lecturers to committees, and run the built-in reports).

## Authors

Built by Omer Nof and Linoy.
