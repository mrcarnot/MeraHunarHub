added the order feautre with receipt generation, tested it with a few base cases and it was working fine <br>
next , i will be sharing it with the group for approval and will be working on it to integrate gui with it <br>
though some of the feautures like overall rating cacluclations and notification framwork is still missing ,
=========================<br>
# HunarHub – A Handicraft Selling Platform for Rural Women 🧵💼

## Features

###  Maker Workflow
- Register and login as a Maker
- Add handmade items with title, description, and price
- View personal product listings
- View account balance (simulated)
- Receive payments from buyer orders

### Buyer Workflow
- Register and login as a Buyer
- Browse products by maker or by category (the category thing is in-progress )
- Add products to a cart or purchase immediately
- View cart, remove items, or checkout
- View account balance
- View order history and generate receipts
- Leave reviews on purchased products

### 🧾 Order & Receipt System
- Each order generates a unique ID and timestamp
- Transfers balance from buyer to maker
- Prints a receipt with full order details

### ⭐ Review System
- Buyers can review items they’ve purchased
- Reviews include star ratings and comments
- Items display all their associated reviews

---

## 🧱 Tech Stack

- Java 17+
- Object-Oriented Programming
- Command-line interface (CLI)
- Git for version control

---

## 📂 Folder Structure
HunarHub/
│
├── Main.java # Entry point
├── User.java # Abstract base class
├── Maker.java # Seller functionality
├── Buyer.java # Buyer functionality and menus
├── Item.java # Handicraft product model
├── Cart.java # Buyer cart system
├── Order.java # Order and receipt generation
├── Review.java # Review model and logic
├── BankAccount.java # Simulated wallet for users
├── README.md # Project overview and instructions
└── .gitignore # Ignores .class files etc.
<br>
What is missing ?<br>
1)File handling 
2)notification framework
3)courses logic
4)gui ka naam-o-nishaan tak nahi he!
5)delivery framwork



