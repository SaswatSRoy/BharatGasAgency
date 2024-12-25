# Bharat Gas Agency Management System

A comprehensive Java-based gas booking and management system that handles customer bookings, deliveries, and various reporting functionalities.

---

## Features

### 1. Customer Management
- Multi-customer support with detailed information capture.
- Stores customer details including:
  - Name
  - Street address
  - Area
  - Pincode
  - Mobile number
  - Number of cylinders (1 or 2)
  - Last booking date

### 2. Booking System
- Automated booking validation based on:
  - Number of cylinders
  - Last booking date
  - Delivery timeframes
- Status tracking with codes:
  - **B:** Booked
  - **C:** Cancelled
  - **D:** Delivered
  - **P:** Pending
- OTP verification system for delivery confirmation (default: 5678).
- Automated amount calculation including refunds.

### 3. Delivery Management
- Delivery person assignment.
- Delivery date tracking.
- Amount calculation with refund processing.
- Late delivery identification.
- Delivery status verification.

### 4. Reporting System
The system includes comprehensive reporting features:

1. **Cylinder Count Report**
   - Monthly cylinder delivery statistics.
   - Area-wise distribution analysis.

2. **Late Delivery Report**
   - Monthly late delivery tracking.
   - Refund calculations for delayed deliveries.

3. **Customer Category Reports**
   - Single cylinder holder details.
   - Double cylinder holder details.

4. **Delivery Person Report**
   - Delivery assignments.
   - Performance tracking.

5. **Overall Status Report**
   - Booking statistics.
   - Cancellation rates.
   - Delivery success rates.
   - Pending deliveries.

6. **Invoice Generation**
   - Detailed billing information.
   - Payment tracking.
   - Refund details.

---

## Implementation Details

### Class Structure
```java
gasPackage
└── gasAgency (Interface)
    └── Customer
        └── GasConnection
            └── Booking
                └── Delivery
```

### Functional Flow
```plaintext
Program Start
   ├── Initialize System
   ├── Display Menu
   │   ├── Customer Details Input
   │   ├── Booking Processing
   │   ├── Delivery Management
   │   ├── Reporting Features
   └── End Program
```

### Database Design
```plaintext
Tables:
1. Customers
   - CustomerID (Primary Key)
   - Name
   - Address
   - MobileNumber
   - CylinderCount
   - LastBookingDate

2. Bookings
   - BookingID (Primary Key)
   - CustomerID (Foreign Key)
   - Status
   - Amount
   - BookingDate

3. Deliveries
   - DeliveryID (Primary Key)
   - BookingID (Foreign Key)
   - DeliveryDate
   - Status
   - RefundAmount
```

### Key Components

1. **gasAgency Interface**
   - Agency details storage.
   - Default display methods.
   - Constants definition.

2. **Customer Class**
   - Basic customer information.
   - Address management.
   - Contact details.

3. **GasConnection Class**
   - Connection number management.
   - Cylinder quantity tracking.
   - Booking date validation.

4. **Booking Class**
   - Booking status management.
   - Amount calculations.
   - OTP verification.
   - Date validation.

5. **Delivery Class**
   - Delivery processing.
   - Status updates.
   - Amount and refund calculations.

---

### Data Validation Rules

1. **Single Cylinder Holders**
   - Minimum 30-day gap between bookings.
   - Standard delivery timeframe: 7 days.

2. **Double Cylinder Holders**
   - Minimum 50-day gap between bookings.
   - Same delivery timeframe applies.

---

### Financial Calculations

1. **Standard Booking**
   - Base amount: ₹875.00
   - Refund for late delivery: ₹41.25

2. **Refund Conditions**
   - Applicable for deliveries beyond 7 days.
   - Automatically calculated and applied.

---

## Usage

### Step-by-Step Guide
1. Clone the repository using Git:
   ```bash
   git clone https://github.com/your-repository/bharat-gas-agency.git
   cd bharat-gas-agency
   ```

2. Compile the Java files:
   ```bash
   javac -d bin src/*.java
   ```

3. Run the program:
   ```bash
   java -cp bin Main
   ```

4. Follow the on-screen instructions to manage customer bookings and deliveries.

### Menu Navigation
```plaintext
Main Menu:
1. Add Customer
2. Book Cylinder
3. Verify Delivery
4. Generate Reports
5. Exit
```

---

## Technical Requirements

- Java Development Kit (JDK).
- Support for:
  - Date handling (`java.util.Date`).
  - Text formatting (`java.text.SimpleDateFormat`).
  - User input (`java.util.Scanner`).

---

## Error Handling

- Input validation.
- Date parsing error management.
- Status validation.
- Exception handling with informative messages.

---

## Future Enhancements

- Online payment integration.
- SMS notification system.
- Customer feedback system.
- Delivery tracking system.
- Mobile application interface.

---

## Contributing

Feel free to fork this project and submit pull requests. For major changes, please open an issue first to discuss the proposed changes.

---

## License

### Bharat Gas Agency License

This project is licensed under the **Bharat Gas Agency Open License**:

**Permitted Use:**
1. Usage of the system for non-commercial purposes.
2. Modification and redistribution with appropriate credits.
3. Integration into gas agency management systems.

**Restrictions:**
1. Not for resale or commercial redistribution.
2. Modifications should be publicly shared for communal improvement.

**Disclaimer:**
This software is provided "as is," without warranty of any kind. Use at your own risk. The developers are not liable for any damages arising from its usage.

For more details, refer to the [license documentation](#).

---

