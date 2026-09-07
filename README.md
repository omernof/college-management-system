# College Management System

A Java console application for managing a college's lecturers, departments and committees, built entirely with a small object-oriented class hierarchy — no external database required.

## Overview

The project models lecturers as a class hierarchy — `Lecturer` → `Doctor` → `Prof` — alongside `Department` and `Committee` classes. `CollegeManager` holds everything in memory and exposes the operations, and `collegeProject` (the `main` class) drives an interactive text menu for managing lecturers, departments and committees, plus several reporting queries (highest paid lecturer, department with the most students, professors ranked by salary, and more).

## Class overview

- **Lecturer** — base class: name, id, degree, salary and department.
- **Doctor** — a `Lecturer` who publishes articles.
- **Prof** — a `Doctor` affiliated with an institution.
- **Department** — holds a list of lecturers and reports on them (e.g. total articles).
- **Committee** — a named committee with a chairman and member lecturers.
- **CollegeManager** — in-memory management of departments, lecturers and committees, plus reporting.
- **collegeProject** — the `main` entry point with the interactive menu.

## Running

Compile and run `collegeProject`, which starts the interactive menu (add lecturers, departments and committees, assign lecturers to committees, and run the built-in reports). No setup or external services are required — everything runs in memory for the lifetime of the program.

## Authors

Built by Omer Nof.
