added the order feautre with receipt generation, tested it with a few base cases and it was working fine <br>
next , i will be sharing it with the group for approval and will be working on it to integrate gui with it <br>
though some of the feautures like overall rating cacluclations and notification framwork is still missing ,
=========================<br>
# HunarHub – A Handicraft Selling Platform for Rural Women 🧵💼

## Features

###  Maker Workflow
- Register and login as a Maker <br>
- Add handmade items with title, description, and price <br>
- View personal product listings <br>
- View account balance (simulated) <br>
- Receive payments from buyer orders <br>
 <br>
### Buyer Workflow
- Register and login as a Buyer <br>
- Browse products by maker or by category (the category thing is in-progress ) <br>
- Add products to a cart or purchase immediately <br>
- View cart, remove items, or checkout <br>
- View account balance <br>
- View order history and generate receipts <br>
- Leave reviews on purchased products <br>

###  Order & Receipt System <br>
- Each order generates a unique ID and timestamp <br>
- Transfers balance from buyer to maker <br>
- Prints a receipt with full order details <br>

###  Review System <br>
- Buyers can review items they’ve purchased <br>
- Reviews include star ratings and comments <br>
- Items display all their associated reviews <br>

---

## Folder Structure <br>
HunarHub/ <br>
│
├── Main.java # Entry point <br>
├── User.java # Abstract base class <br>
├── Maker.java # Seller functionality <br>
├── Buyer.java # Buyer functionality and menus <br>
├── Item.java # Handicraft product model <br>
├── Cart.java # Buyer cart system <br>
├── Order.java # Order and receipt generation <br>
├── Review.java # Review model and logic <br>
├── BankAccount.java # Simulated wallet for users <br>
├── README.md # Project overview and instructions <br>
└── .gitignore # Ignores .class files etc. <br>
<br>
What is missing ?<br>
1)File handling <br>
2)notification framework <br>
3)courses logic <br>
4)gui ka naam-o-nishaan tak nahi he! <br>
5)delivery framwork <br>



