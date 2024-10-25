# Vehicle Insurance System

## Overview

The **Vehicle Insurance System** is a software application designed to manage the operations of a vehicle insurance company. This system handles customer data, vehicles, insurance policies, claims, settlements, and transactions, providing an efficient way to store, retrieve, and process information with the help of a user-friendly **Graphical User Interface (GUI)**.

## Key Entities and Their Roles

### 1. Insurance Policy
Represents the agreement between the customer and the insurance company.

**Details Include:**
- **Premium:** Amount paid by the customer.
- **Coverage:** Compensation provided by the insurer in case of an accident.
- **Insurance Plans:** Policies depend on different plans (e.g., all-risk, third-party coverage).

---

### 2. Insurance Plan
Defines the risks covered, along with the associated premium and coverage.

**Example:**
- For a vehicle worth **$20,000**:
  - **Premium Rate:** 7.5% → Customer pays **$1,500**.
  - **All-Risk Plan:** Offers 100% coverage for accidents.

**Types of Plans:**
- Third-party insurance  
- Personal driver insurance  
- Vehicle damage insurance  
- Assistance services (e.g., towing, vehicle replacement)  

---

### 3. Customer
- A customer can hold multiple policies for the same or different vehicles.

---

### 4. Vehicle
Stores important details related to the insured vehicle.

**Details Include:**
- Registration information  
- Current value  
- Condition (including damaged parts)  

This information helps determine the **premium** and **coverage** of the policy.

---

### 5. Claim
- A claim is filed when a customer requests compensation for an accident.

**Details Include:**
- Claim number  
- Accident date  
- Damage details  
- Compensation amount  

---

### 6. Settlement
Represents the payment made by the insurance company as part of the claims process.

**Details Include:**
- Administrative data  
- Payment date and amount  
- Justifications (e.g., parts replaced, labor costs)  

---

## Core Functionalities

### 1. Data Entry and Management  
- Store and manage data for customers, vehicles, policies, claims, and settlements.

### 2. Search and Retrieval  
- Search and retrieve specific policies, claims, or settlements.

### 3. Processing and Analysis  
- Analyze deadlines, conditions, and amounts related to claims and transactions.

### 4. Display and Documentation  
- Generate and display documents such as:
  - Policies  
  - Claims  
  - Receipts  

---

## Project Scope

### 1. Graphical User Interface (GUI)
- Implementing a user-friendly interface to manage the interactions between users and the system.

### 2. Operations Processing
- Implementing the business logic to handle various insurance operations.

### 3. Information Outputs
- Generating reports, search results, receipts, and other relevant outputs.

---

## How to Use the System

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/vehicle-insurance-system.git
   cd vehicle-insurance-system
   ```

2. **Set up the environment:**  
   Install the required dependencies (if applicable).  

3. **Run the Application:**  
   Execute the application to start managing insurance operations via the GUI.

---

## Technologies Used
- **Programming Language:** [Java]  
- **Database:** No Database used 
- **GUI Framework:** Java Swing 

---

## Contributing
Feel free to contribute to this project by submitting issues and pull requests. For major changes, please open an issue first to discuss what you would like to change.

---

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Contact
For further information or queries, reach out to:  
**[Your Name]** - mayurkamble0250@gmail.com
