# Missionaries and Cannibals Solver (A* Search)

A Java-based Artificial Intelligence solver for the generalized **Missionaries and Cannibals** problem using the **A* (A-Star) Search algorithm**.

## 🧩 The Problem
The goal is to move $N$ missionaries and $N$ cannibals from one side of a river to the other using a boat that holds $M$ people.
* **Constraint 1:** The number of cannibals must never exceed the number of missionaries on either bank (unless the number of missionaries is zero).
* **Constraint 2:** The boat cannot cross more than $K$ times.

## 🚀 Features
* **A* Implementation:** Uses a priority queue and a custom heuristic function to find the optimal path.
* **Generalized Inputs:** Works for any number of people ($N$), boat size ($M$), and maximum depth ($K$).
* **Performance Metrics:** Displays the execution time in milliseconds upon completion.

## 🛠️ Heuristic Function
The project uses a custom heuristic that estimates the minimum number of trips required based on the number of people left on the starting bank and the boat's capacity.

## 💻 Usage

### Compilation
Compile the Java files using the terminal:
```bash
javac MissionariesCannibals.java
