## Project Description

### Cron String Parser

This command line application parses a cron string and expands each field to display the times at which it will run. The application adheres to the standard cron format, which includes five time fields (minute, hour, day of month, month, and day of week) plus a command. The output is formatted as a table, where each field name is displayed in the first 14 columns followed by the corresponding times as a space-separated list.

### Features
- Parses a cron string provided as a single argument.
- Expands each field (minute, hour, day of month, month, day of week) to show the specific times when the cron expression matches.
- Handles basic cron expressions without special time strings like "@yearly".
- Outputs the expanded times in a structured table format for easy readability.

### Development Environment
The application is developed in **Java** as a command line interface (CLI) tool. It does not use existing cron parser libraries to demonstrate the ability to create a parser from scratch.

### Project Structure
- **Main.java**: Entry point of the application that parses the cron string and prints the expanded schedule.
- **CronParser.java**: Implements the logic to parse and expand the cron string into specific times.
- **README.md**: Contains instructions for setting up and running the application, project description, and other relevant information.

### Setup Instructions
#### Prerequisites
- **Java Development Kit (JDK)** installed (version 8 or higher).
- **Apache Maven** installed to build the project.

#### Running the Application
1. **Clone the repository:**
   ```bash
   git clone <repository_url>
   cd <repository_directory>
2. **Execute the bash script run.sh with your desired argument:**
    ```bash
    ./run.sh "*.15 0 1,15 * 1-5 .usr.bin.find"
3. **Output**
    ```bash
    minute       0 15 30 45
    hour         0
    day of month 1 15
    month        1 2 3 4 5 6 7 8 9 10 11 12
    day of week  1 2 3 4 5
    command      /usr/bin/find
