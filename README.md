# CountEvents Performance Optimization Project

## Overview

This project demonstrates the process of identifying and resolving performance bottlenecks in a Java application. We take a simple event counting program and optimize it for better performance while adhering to 12-factor app principles.

## Objectives

- Identify common performance bottlenecks in Java code
- Apply profiling techniques to pinpoint issues
- Implement optimization strategies to improve application speed
- Demonstrate adherence to 12-factor app methodology

## Repository Contents

- `src/main/java/EventCounter.java`: Original version of the application
- `src/main/java/OptimizedCountEvents.java`: Optimized version of the application
- `profiling_results/`: Directory containing profiling data and analysis
- `docs/performance_report.pdf`: Detailed report on optimization process and results


## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- VisualVM (for profiling)

### Running the Application

1. Compile the Java files:
   ```
   javac src/main/java/*.java
   ```

2. Run the original version:
   ```
   java -cp src/main/java CountEvents
   ```

3. Run the optimized version:
   ```
   java -cp src/main/java OptimizedCountEvents
   ```

## Profiling

To profile the application using VisualVM:

1. Start VisualVM
2. Run the application with the following command:
   ```
   java -Dcom.sun.management.jmxremote -cp src/main/java CountEvents
   ```
3. In VisualVM, select the running CountEvents application
4. Use the CPU and Memory profiler to analyze performance

## Optimization Process

1. **Identify Bottlenecks**: Used VisualVM to profile CPU and memory usage
2. **Code Analysis**: Reviewed code for potential improvements
3. **Implement Optimizations**: 
   - Removed unnecessary file I/O operations
   - Optimized memory usage by replacing large arrays with running sums
   - Improved time calculations
   - Enhanced event tracking logic
4. **Verify Improvements**: Re-profiled the optimized code to confirm performance gains

## Key Findings

- Significant reduction in CPU usage
- Decreased memory allocation
- Improved overall execution time
- Better adherence to 12-factor app principles

## 12-Factor App Compliance

This project demonstrates several 12-factor app principles:

- Config: Use of environment variables for configuration
- Processes: Stateless and share-nothing architecture
- Disposability: Fast startup and graceful shutdown
- Logs: Output to stdout instead of log files

## Further Improvements

- Implement dependency management (e.g., Maven or Gradle)
- Set up CI/CD pipeline for automated testing and deployment
- Containerize the application for better dev/prod parity

## Contributing

I welcome contributions! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.