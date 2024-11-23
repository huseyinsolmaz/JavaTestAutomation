
# API Test Automation Project

This project is developed for automating API tests using **Rest Assured** and **TestNG**. The tests focus on performing **POST** and **DELETE** requests to create and delete bookings on the **Booking API**.

## Project Requirements

To run this project on another computer, the following software and tools are required:

- **Java 17** or higher
- **Maven** (to manage dependencies and build the project)
- **IDE** (such as IntelliJ IDEA, Eclipse, etc.)
- **Postman** (optional, for manual API testing)

## Getting Started

This project uses **Rest Assured** and **TestNG** to automate the testing of APIs. Follow the steps below to get the project up and running.

### 1. Install Required Software

#### **Java Installation**
This project is developed using **Java 17**. You can download and install the latest version of Java from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

Check the Java version by running the following command in the terminal:

```bash
java -version
```

#### **Maven Installation**
Maven is used to manage dependencies in this project. You can download Maven from [Maven's official site](https://maven.apache.org/download.cgi).

Check if Maven is installed correctly by running:

```bash
mvn -v
```

### 2. Clone the Repository

Clone this repository to your local machine using Git:

```bash
git clone https://github.com/huseyinsolmaz/JavaTestAutomation.git
```

Navigate to the project directory:

```bash
cd project-directory
```

### 3. Import the Project in Your IDE

- **IntelliJ IDEA**: Open IntelliJ IDEA, select **File > Open** and choose the project directory.
- **Eclipse**: Select **File > Import > Existing Maven Projects**, then browse and select the project directory.

### 4. Install Dependencies

Run the following command to download and install all required dependencies:

```bash
mvn clean install
```

### 5. Run the Tests

After the dependencies are installed, you can run the tests.

#### **Using IntelliJ IDEA:**
1. Right-click on the **Test Class** (e.g., `BookingTests.java`) in the project explorer.
2. Select **Run 'BookingTests'**.

#### **Using Maven Command Line:**
You can also run the tests using the following Maven command:

```bash
mvn test
```

This will run all the tests defined in the **`src/test/java`** folder.

### 6. View Test Results

After running the tests, you can view the results in the **console output** in your IDE or the terminal.

If you're using **TestNG**, the results will also be generated in the **`target/surefire-reports`** directory.

### 7. Optional: Postman for Manual Testing

If you prefer to manually test the API, you can import the collection into **Postman** by creating a collection for the API endpoints. You can test the **POST** and **DELETE** endpoints directly in Postman if needed.

## Troubleshooting

If you encounter any issues while running the tests:

- Make sure **Java** and **Maven** are installed and configured properly.
- Check if all dependencies are installed by running `mvn clean install`.
- Ensure that the **Booking API** (https://restful-booker.herokuapp.com) is available and functional.

For any other issues, feel free to open an issue in the repository or contact the project maintainers.
