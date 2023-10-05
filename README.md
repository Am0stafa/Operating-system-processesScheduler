# Operating System Processes Scheduler

This project simulates various operating system process scheduling algorithms and their impact on memory management through paging, fragmentation, and segmentation. It is implemented in Java and demonstrates three core scheduling algorithms: First-Come, First-Served (FCFS), Shortest Job First (SJF), and Round Robin (RR).:


1. First-Come, First-Served (FCFS): This is a scheduling algorithm in which the CPU is allocated to the process that has been waiting in the queue the longest. This algorithm is simple to implement, but it can lead to poor performance for processes with longer run times, as they may have to wait a long time to be allocated the CPU. Basically Processes are executed on first come, first serve basis (queue, based on arrival time).<br>
2. Shortest Job First: This is a scheduling algorithm in which the CPU is allocated to the process with the shortest estimated run time. This algorithm aims to minimize the average turnaround time for all processes by giving priority to shorter processes. It can lead to higher efficiency, but it may not always be fair to processes with longer run times.<br>
3. Round Robin: This is a scheduling algorithm in which the CPU is allocated to each process in the queue for a fixed amount of time, called a time quantum. Once the time quantum expires, the process is moved to the end of the queue and the CPU is allocated to the next process in the queue. This algorithm is effective at preventing a single process from monopolizing the CPU, but it can lead to poor performance for processes with longer run times.Basically each process is assigned a fixed time slot in a cyclic way.<be>

Certainly! A well-structured README file is essential for explaining the purpose of your project, its structure, and how others can run or contribute to it. Below is a revised version of your README based on the provided project details and code:


## Getting Started

### Prerequisites

- Java JDK (Version 8 or later)

### Running the Project

1. Clone the repository from GitHub:
   ```bash
   git clone https://github.com/Am0stafa/Operating-system-processesScheduler.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Operating-system-processesScheduler
   ```

3. Compile the `Main.java` file:
   ```bash
   javac Main.java
   ```

4. Run the compiled program:
   ```bash
   java Main
   ```

### Input Format

The program accepts input in the form of a string with the following format:
```plaintext
<process_names>;<arrival_times>;<execution_times>
```

- `<process_names>`: A comma-separated list of process names (e.g., `A,B,C,D,E`).
- `<arrival_times>`: A comma-separated list of arrival times corresponding to each process (e.g., `0,2,4,5,8`).
- `<execution_times>`: A comma-separated list of execution times corresponding to each process (e.g., `3,6,4,5,2`).

### Output Format

The program outputs the order of process execution along with the time spent on each process for each scheduling algorithm.

## Contributing

Feel free to fork the project, create a feature branch, and send us a pull request!

