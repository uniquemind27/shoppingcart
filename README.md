# Spring Boot Shopping Cart Using Microservices Architecture

## About

This is a shopping cart built using Microservices architecture. The idea was to build some basic features into the shopping cart.

It was made using **Spring Boot**, **Spring Data JPA**, **Spring Data REST and Docker**, **Eureka**, **Hystrix**.
Database - **H2** (in memory).

UserService - To add an user, delete an user, fetch an user and fetch all users.
ProductService - To add a product, delete a product, fetch a product and fetch all products.
CartService - To add products to the cart, delete the cart and view all carts.
OrderService - For placing orders and viewing an order.

Flow:
Controller --> Service --> Repository

Very basic schema was used for the shopping cart. 
Database per service model has been followed as a part of Miscroservices Architecture.

Hystrix was showcased only in order service just for example. 
Eureka has been used in the shopping cart.
Postman was used for testing. Collection of requests has been attached.



